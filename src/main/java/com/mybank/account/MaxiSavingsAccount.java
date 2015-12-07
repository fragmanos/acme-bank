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

  /**
   * Future Value Of Invested Principal
   * Principal * pow((1 + (Rate / interestPaymentFrequency)), (interestPaymentFrequency))
   *
   * @param rate The annual interest rate (as a decimal)
   * @param frequency How often in a year interest is paid.
   * @return Future value of invested principal
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
   * @return Future value of invested principal
   */
  public double getFutureValue(double principal, double rate, int frequency, int numberOfYears) {
    double division = rate / frequency;
    double addition = 1+ division;
    return principal * Math.pow(addition, frequency * numberOfYears);
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
