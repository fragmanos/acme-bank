package com.mybank.transaction;

import com.mybank.types.TransactionType;
import org.joda.time.DateTime;

import java.math.BigDecimal;

public class Transaction {

    private TransactionType transactionType;
    private double amount;
    private DateTime transactionDate;

    public Transaction(double amount) {
        this.transactionType = (amount > 0 )? TransactionType.DEPOSIT : TransactionType.WITHDRAWAL ;
        this.amount = amount;
        this.transactionDate = DateTime.now();
    }

    public double getAmount() {
        return amount;
    }

    public DateTime getTransactionDate() {
        return transactionDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
