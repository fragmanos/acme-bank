package com.mybank.account;

import com.mybank.types.AccountType;
import org.joda.time.*;

/**
 * @author fragkakise on 02/12/2015.
 */
public class SavingsAccount extends BasicAccount {

  private final AccountType accountType;

  public SavingsAccount() {
    accountType = AccountType.SAVINGS;
  }

  @Override
  public AccountType getAccountType() {
    return accountType;
  }

  public double getInterestEarned(DateTime futureDateTime) {
    double balance = getBalance();
    double rateBelowThousand = 0.001;
    double balanceLimit = 1000;
    double rateAboveThousand = (1 + (balance-1000) * 0.002)/balance;
    Period period = new Period(DateTime.now(), futureDateTime);
    Months months = Months.monthsBetween(DateTime.now(), futureDateTime);
    Days days = Days.daysBetween(DateTime.now(), futureDateTime);
    if (months.getMonths() <= 12) {
      return getFutureValueForPeriodLessThanYear(balance, rateBelowThousand, balanceLimit, rateAboveThousand, days);
    } else {
      return getFutureValueForPeriodMoreThanYear(balance, rateBelowThousand, balanceLimit, rateAboveThousand, period, days);
    }
  }

  private double getFutureValueForPeriodMoreThanYear(double balance, double rateBelowThousand, double balanceLimit, double rateAboveThousand, Period period, Days days) {
    if (balance <= balanceLimit)
      return getFutureValue(getBalance(), rateBelowThousand, days.getDays(), period.getYears()) - balance;
    else
      return getFutureValue(getBalance(), rateAboveThousand, days.getDays(), period.getYears()) - balance;
  }

  private double getFutureValueForPeriodLessThanYear(double balance, double rateBelowThousand, double balanceLimit, double rateAboveThousand, Days days) {
    if (balance <= balanceLimit)
      return getFutureValue(getBalance(), rateBelowThousand, days.getDays()) - balance;
    else
      return getFutureValue(getBalance(), rateAboveThousand, days.getDays()) - balance;
  }
}
