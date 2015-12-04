package com.mybank.account;

import com.mybank.types.AccountType;

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

  public double getInterestEarned() {
    return getBalance() * 0.001;
  }

}
