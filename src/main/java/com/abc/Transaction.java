package com.abc;

import java.util.Calendar;
import java.util.Date;

public class Transaction {
    private double amount;

    private Date transactionDate;

    public Transaction(double amount) {
        this.amount = amount;
        this.transactionDate = Calendar.getInstance().getTime();
    }

    public double getAmount() {
        return amount;
    }
}
