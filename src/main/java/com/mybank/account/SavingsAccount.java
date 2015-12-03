package com.mybank.account;

import com.mybank.types.AccountType;

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

  @Override
  public double getInterestEarned() {
    double balance = getBalance();
    if (balance <= 1000)
      return balance * 0.001;
    else
      return 1 + (balance-1000) * 0.002;
  }
}
