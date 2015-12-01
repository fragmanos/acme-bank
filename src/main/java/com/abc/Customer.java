package com.abc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String customerName;
    private List<Account> accounts;

    public Customer(String customerName) {
        this.customerName = customerName;
        this.accounts = new ArrayList<Account>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void openAccount(Account account) {
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
        for (Account account : accounts) {
            statement.append("\n").append(getStatementForAccount(account)).append("\n");
            transactionAmount += account.sumTransactions();
        }
        statement.append("\nTotal In All Accounts ")
          .append(getTransactionAmountFormattedToDollars(transactionAmount));
        return String.valueOf(statement);
    }

    private String getStatementForAccount(Account account) {
        StringBuilder accountStatement = new StringBuilder("");
        double total = 0.0;

        accountStatement.append(account.getAccountType().getDescription()).append("\n");

        for(Transaction transaction : account.transactions) {
            accountStatement
              .append("  ").append(getTransactionType(transaction))
              .append(" ").append(getTransactionAmountFormattedToDollars(transaction.amount))
              .append("\n");
            total += transaction.amount;
        }
        accountStatement.append("Total ").append(getTransactionAmountFormattedToDollars(total));
        return String.valueOf(accountStatement);
    }

    private String getTransactionType(Transaction transaction) {
        return transaction.amount < 0 ? "withdrawal" : "deposit";
    }

    private String getTransactionAmountFormattedToDollars(double amount){
        return String.format("$%,.2f", abs(amount));
    }

    public double getTotalInterestEarnedForAccount(Account account) {
        return account.interestEarned();
    }
}
