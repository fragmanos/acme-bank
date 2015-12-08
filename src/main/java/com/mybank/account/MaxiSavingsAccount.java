package com.mybank.account;

import com.mybank.transaction.Transaction;
import com.mybank.types.AccountType;
import org.joda.time.*;

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

  public double getInterestEarned(DateTime futureDateTime) {
    double balance = getBalance();
    double rateWithWithdrawalsOnLastTenDays = 0.001;
    double rateWithoutWithdrawalsOnLastTenDays = 0.05;

    Period period = new Period(DateTime.now(), futureDateTime);
    Months months = Months.monthsBetween(DateTime.now(), futureDateTime);
    Days days = Days.daysBetween(DateTime.now(), futureDateTime);

    double rate = (isWithdrawOccurredOnLastTenDays(futureDateTime)) ? rateWithWithdrawalsOnLastTenDays : rateWithoutWithdrawalsOnLastTenDays;
    if(months.getMonths() <= 12) {
      return getFutureValue(balance, rate, days.getDays()) - balance;
    } else {
      return getFutureValue(balance, rate, days.getDays(), period.getYears()) - balance;
    }
  }

  public boolean isWithdrawOccurredOnLastTenDays(DateTime futureDateTime) {
  boolean withdrawOccurredOnLastTenDays = false;
        for (Transaction transaction : getTransactions()) {
          if (transaction.getTransactionType().equals(WITHDRAWAL)){
            int daysBetween = Days.daysBetween(transaction.getTransactionDate(), futureDateTime).getDays();
            withdrawOccurredOnLastTenDays = (daysBetween <= 10);
          }
        }
    return withdrawOccurredOnLastTenDays;
  }
}
