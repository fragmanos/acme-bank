package com.abc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author fragkakise on 01/12/2015.
 */
public class AccountTest {

  private static final double DOUBLE_DELTA = 1e-15;

  private Account checkingAccount;
  private Account savingsAccount;
  private Account maxiSavingsAccount;

  @Before
  public void setUp() throws Exception {
    checkingAccount = new Account(AccountType.CHECKING);
    savingsAccount = new Account(AccountType.SAVINGS);
    maxiSavingsAccount = new Account(AccountType.MAXI_SAVINGS);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testDepositWithNegativeAmount(){
    checkingAccount.deposit(-300);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testWithdrawWithoutMoneyOnTheAccount(){
    checkingAccount.withdraw(200);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testWithdrawWithNegativeAmountOfMoney(){
    checkingAccount.withdraw(-200);
  }

  @Test
  public void testMaxiSavingsAccountInterestEarnedWithAmountLessThanThousand(){
    maxiSavingsAccount.deposit(1000);
    assertEquals(20.0, maxiSavingsAccount.getInterestEarned(), DOUBLE_DELTA);
  }

  @Test
  public void testMaxiSavingsAccountInterestEarnedWithAmountLessThanTwoThousand(){
    maxiSavingsAccount.deposit(2000);
    assertEquals(70.0, maxiSavingsAccount.getInterestEarned(), DOUBLE_DELTA);
  }

  @Test
  public void testSavingsAccountInterestEarnedWithAmountLessThanThousand(){
    savingsAccount.deposit(1000);
    assertEquals(1, savingsAccount.getInterestEarned(), DOUBLE_DELTA);
  }

}
