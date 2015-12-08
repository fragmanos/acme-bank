package com.mybank.account;

import com.mybank.types.AccountType;
import org.joda.time.*;

/**
 * @author fragkakise on 02/12/2015.
 */
public class CheckingAccount extends BasicAccount {

  private final AccountType accountType;

  public CheckingAccount() {
    accountType = AccountType.CHECKING;
  }

  @Override
  public AccountType getAccountType() {
    return accountType;
  }

  public double getInterestEarned(DateTime futureDateTime) {
    double rate = 0.001;
      Period period = new Period(DateTime.now(), futureDateTime);
      Months months = Months.monthsBetween(DateTime.now(), futureDateTime);
      Days days = Days.daysBetween(DateTime.now(), futureDateTime);
    if (months.getMonths() <= 12) {
        return getFutureValue(getBalance(), rate, days.getDays()) - getBalance();
    } else {
        return getFutureValue(getBalance(), rate, days.getDays(), period.getYears())-getBalance();
    }
  }

}
