package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private AccountType accountType;
    public List<Transaction> transactions;

    public Account(AccountType accountType) {
        this.accountType = accountType;
        this.transactions = new ArrayList<Transaction>();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            transactions.add(new Transaction(amount));
        }
    }

public void withdraw(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("amount must be greater than zero");
    } else if(amount > 0 && amount > sumTransactions()){
        throw new IllegalArgumentException("amount must be less or equal than balance");
    } else {
        transactions.add(new Transaction(-amount));
    }
}

    public double getInterestEarned() {
        double amount = sumTransactions();
        switch(accountType){
            case CHECKING:
                amount = getCheckingAccountInterestEarned(amount);
                break;
            case SAVINGS:
                amount = getSavingsAccountInterestEarned(amount);
                break;
            case MAXI_SAVINGS:
                amount = getMaxiSavingsAccountInterestEarned(amount);
            break;
        }
        return amount;
    }

    private double getCheckingAccountInterestEarned(double amount) {
        return amount * 0.001;
    }

    private double getMaxiSavingsAccountInterestEarned(double amount) {
        if (amount <= 1000)
            return amount * 0.02;
        if (amount <= 2000)
            return 20 + (amount-1000) * 0.05;
        return 70 + (amount-2000) * 0.1;
    }

    private double getSavingsAccountInterestEarned(double amount) {
        if (amount <= 1000)
            return amount * 0.001;
        else
            return 1 + (amount-1000) * 0.002;
    }

    public double sumTransactions() {
        double amount = 0.0;
        for (Transaction transaction: transactions)
            amount += transaction.amount;
        return amount;
    }

    public AccountType getAccountType() {
        return accountType;
    }

}
