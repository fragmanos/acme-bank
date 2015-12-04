package com.mybank.account;

import com.mybank.transaction.Transaction;
import com.mybank.types.AccountType;
import org.joda.time.DateTime;
import org.joda.time.Days;

import static com.mybank.types.TransactionType.WITHDRAWAL;

/**
 * @author fragkakise on 02/12/2015.
 */
public class MaxiSavingsAccount extends BasicAccount {

  private final AccountType accountType;

  public MaxiSavingsAccount() {
    accountType = AccountType.MAXI_SAVINGS;
  }

  @Override
  public AccountType getAccountType() {
    return accountType;
  }

  public double getInterestEarned(DateTime dateTime) {
    double interestEarned = 0;

    for (Transaction transaction : getTransactions()) {
      if (transaction.getTransactionType().equals(WITHDRAWAL)){
        int daysBetween = Days.daysBetween(transaction.getTransactionDate(), dateTime).getDays();
        interestEarned = (daysBetween <= 10)? getBalance() * 0.001 : getBalance() * 0.05;
      }
    }
    return interestEarned;
  }
}
