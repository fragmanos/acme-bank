package com.mybank.customer;

import com.mybank.account.BasicAccount;
import com.mybank.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

import static com.mybank.types.TransactionType.*;
import static java.lang.Math.abs;

public class Customer {

    private String customerName;
    private List<BasicAccount> accounts;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.accounts = new ArrayList<BasicAccount>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void openAccount(BasicAccount account) {
        accounts.add(account);
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public String getStatementForAllAccounts() {
        double transactionAmount = 0;
        StringBuilder statement = new StringBuilder("");
        statement.append("Statement for ")
          .append(customerName)
          .append("\n");
        for (BasicAccount account : accounts) {
            statement.append("\n").append(getStatementForAccount(account)).append("\n");
            transactionAmount += account.getBalance();
        }
        statement.append("\nTotal In All Accounts ")
          .append(getTransactionAmountFormattedToDollars(transactionAmount));
        return String.valueOf(statement);
    }

    private String getStatementForAccount(BasicAccount account) {
        StringBuilder accountStatement = new StringBuilder("");
        double balance = 0.0;

        accountStatement.append(account.getAccountType().getDescription()).append("\n");

        for(Transaction transaction : account.getTransactions()) {
            accountStatement
              .append("  ").append(getTransactionType(transaction))
              .append(" ").append(getTransactionAmountFormattedToDollars(transaction.getAmount()))
              .append("\n");
            balance += transaction.getAmount();
        }
        accountStatement.append("Total ").append(getTransactionAmountFormattedToDollars(balance));
        return String.valueOf(accountStatement);
    }

    private String getTransactionType(Transaction transaction) {
        return transaction.getAmount() < 0 ? WITHDRAWAL.getDescription() : DEPOSIT.getDescription();
    }

    private String getTransactionAmountFormattedToDollars(double amount){
        return String.format("$%,.2f", abs(amount));
    }

}
