package com.mybank.transaction;

import org.joda.time.DateTime;

public class Transaction {
    private double amount;
    private DateTime transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = DateTime.now();
    }

    public double getAmount() {
        return amount;
    }
}
