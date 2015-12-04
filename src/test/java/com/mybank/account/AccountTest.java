package com.mybank.account;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author fragkakise on 01/12/2015.
 */
public class AccountTest {

  private static final double DOUBLE_DELTA = 1e-15;

  private CheckingAccount checkingAccount;
  private SavingsAccount savingsAccount;
  private MaxiSavingsAccount maxiSavingsAccount;

  @Before
  public void setUp() throws Exception {
    checkingAccount = new CheckingAccount();
    savingsAccount = new SavingsAccount();
    maxiSavingsAccount = new MaxiSavingsAccount();
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
  public void testSavingsAccountInterestEarnedWithAmountLessThanThousand(){
    savingsAccount.deposit(1000);
    assertEquals(1, savingsAccount.getInterestEarned(), DOUBLE_DELTA);
  }

  @Test
  public void testTransferBetweenAccountsMatchesExpected(){
    checkingAccount.deposit(1000);
    savingsAccount.deposit(1000);
    checkingAccount.transfer(200, savingsAccount);
    assertEquals(800, checkingAccount.getBalance(), DOUBLE_DELTA);
    assertEquals(1200, savingsAccount.getBalance(), DOUBLE_DELTA);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testTransferWithoutSufficientMoneyOnTheSourceAccount(){
    checkingAccount.deposit(1000);
    savingsAccount.deposit(1000);
    checkingAccount.transfer(1200, savingsAccount);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testTransferWithNegativeAmountOfMoney(){
    checkingAccount.deposit(1000);
    savingsAccount.deposit(1000);
    checkingAccount.transfer(-500, savingsAccount);
  }

  @Test
  public void testMaxiSavingsAccountWithoutWithdrawalForTenDays(){
    maxiSavingsAccount.deposit(10000);
    maxiSavingsAccount.withdraw(9000);
    assertEquals(50, maxiSavingsAccount.getInterestEarned(DateTime.now().plusDays(11)), DOUBLE_DELTA);
  }

  @Test
  public void testMaxiSavingsAccountWithWithdrawalOnTheNextTenDays(){
    maxiSavingsAccount.deposit(10000);
    maxiSavingsAccount.withdraw(9000);
    assertEquals(1, maxiSavingsAccount.getInterestEarned(DateTime.now().plusDays(3)), DOUBLE_DELTA);
  }

}
