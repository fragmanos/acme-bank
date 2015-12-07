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

  /**
   * Future Value Of Invested Principal
   * Principal * pow((1 + (Rate / interestPaymentFrequency)), (interestPaymentFrequency))
   *
   * @param rate The annual interest rate (as a decimal)
   * @param frequency How often in a year interest is paid.
   * @return Compound interest rate
   */
  public double getFutureValue(double principal, double rate, double frequency) {
    double division = rate / frequency;
    double addition = 1+ division;
    return principal * Math.pow(addition, frequency);
  }

  /**
   * Future Value Of Invested Principal
   * Principal * pow((1 + (Rate / interestPaymentFrequency)), (interestPaymentFrequency * years))
   *
   * @param rate The annual interest rate (as a decimal)
   * @param frequency How often in a year interest is paid.
   * @param numberOfYears Number of years for compounding calculation of more than a Year
   * @return Compound interest rate
   */
  public double getFutureValue(double principal, double rate, int frequency, int numberOfYears) {
    double division = rate / frequency;
    double addition = 1+ division;
    return principal * Math.pow(addition, frequency * numberOfYears);
  }

}
