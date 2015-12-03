package com.mybank.account;

import java.util.ArrayList;
import java.util.List;

import com.mybank.transaction.Transaction;
import com.mybank.types.AccountType;

import static com.mybank.messages.ExceptionErrorMessages.*;

/**
 * @author fragkakise on 02/12/2015.
 */
public abstract class BasicAccount {

  private List<Transaction> transactions;

  public BasicAccount() {
    this.transactions = new ArrayList<Transaction>();
  }

  public abstract AccountType getAccountType();

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void deposit(double amount) {
      if(amount > 0){
        transactions.add(new Transaction(amount));
      } else {
          throw new IllegalArgumentException(DEPOSIT_NEGATIVE_AMOUNT.getDescription());
      }
  }

  public void withdraw(double amount) {
    if (amount <= 0) {
      throw new IllegalArgumentException(WITHDRAW_NEGATIVE_AMOUNT.getDescription());
    } else if(amount > 0 && amount > getBalance()){
      throw new IllegalArgumentException(INSUFFICIENT_WITHDRAW_BALANCE.getDescription());
    } else {
      transactions.add(new Transaction(-amount));
    }
  }

  public void transfer(double amount, BasicAccount targetAccount) {
    if (amount > 0) {
      if(amount <= this.getBalance()) {
        targetAccount.deposit(amount);
        this.withdraw(amount);
      } else {
        throw new IllegalArgumentException(INSUFFICIENT_TRANSFER_BALANCE.getDescription());
      }
    } else {
      throw new IllegalArgumentException(TRANSFER_NEGATIVE_AMOUNT.getDescription());
    }
  }

  public double getBalance() {
    double balance = 0;
    for(Transaction transaction : transactions) {
      balance += transaction.getAmount();
    }
    return balance;
  }

  public abstract double getInterestEarned();

}
