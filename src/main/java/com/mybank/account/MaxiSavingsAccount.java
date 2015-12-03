package com.mybank.account;

import com.mybank.types.AccountType;

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

  @Override
  public double getInterestEarned() {
    double balance = getBalance();
    double interest;
    if (balance <= 1000){
      interest = balance * 0.02;
    } else if (balance <= 2000){
      interest = 20 + (balance - 1000) * 0.05;
    } else {
      interest = 70 + (balance - 2000) * 0.1;
    }
    return interest;
  }

}
