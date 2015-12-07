package com.mybank.account;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author fragkakise on 01/12/2015.
 */
public class AccountTest {

  private static final double DOUBLE_DELTA = 2;

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
  public void testOneYearTotalInterestPaidForCheckingAccountMatchesExpected() {
    // value 'balanceExpected' is exported from excel named Interest Calculations.xlsx - Checking TAB - 367 row
    double principalAmount = 100000.0;
    double balanceExpected = 100100.04987955;
    double expectedInterest  = balanceExpected - principalAmount;
    checkingAccount.deposit(principalAmount);
    assertEquals(expectedInterest, checkingAccount.getInterestEarned(DateTime.now().plusYears(1)), DOUBLE_DELTA);
  }

  @Test
  public void testTwoYearsTotalInterestPaidForCheckingAccountMatchesExpected() {
    // value 'balanceExpected' is exported from excel named Interest Calculations.xlsx - Checking TAB - 367 row
    double principalAmount = 100000.0;
    double balanceExpected = 100200.19985888;
    double expectedInterest  = balanceExpected - principalAmount;
    checkingAccount.deposit(principalAmount);
    assertEquals(expectedInterest, checkingAccount.getInterestEarned(DateTime.now().plusYears(2).plusMinutes(1)), DOUBLE_DELTA);
  }

  @Test
  public void testOneYearTotalInterestPaidForSavingsAccountWithBalanceOverThousandMatchesExpected() {
    // value 'balanceExpected' is exported from excel named Interest Calculations.xlsx - Checking TAB - 367 row
    double principalAmount = 100000.0;
    double balanceExpected = 100199.19858644;
    double expectedInterest  = balanceExpected - principalAmount;
    savingsAccount.deposit(principalAmount);
    assertEquals(expectedInterest, savingsAccount.getInterestEarned(DateTime.now().plusYears(1)), DOUBLE_DELTA);
  }

  @Test
  public void testTwoYearTotalInterestPaidForSavingsAccountWithBalanceOverThousandMatchesExpected() {
    // value 'balanceExpected' is exported from excel named Interest Calculations.xlsx - Checking TAB - 367 row
    double principalAmount = 100000.0;
    double balanceExpected = 100398.79596762;
    double expectedInterest  = balanceExpected - principalAmount;
    savingsAccount.deposit(principalAmount);
    assertEquals(expectedInterest, savingsAccount.getInterestEarned(DateTime.now().plusYears(2).plusMinutes(1)), DOUBLE_DELTA);
  }

  @Test
  public void testOneYearTotalInterestPaidForSavingsAccountWithBalanceEqualToThousandMatchesExpected() {
    // value 'balanceExpected' is exported from excel named Interest Calculations.xlsx - Checking TAB - 367 row
    double principalAmount = 1000.0;
    double balanceExpected = 1001.00324126;
    double expectedInterest  = balanceExpected - principalAmount;
    savingsAccount.deposit(principalAmount);
    assertEquals(expectedInterest, savingsAccount.getInterestEarned(DateTime.now().plusYears(1).plusMinutes(1)), DOUBLE_DELTA);
  }

  @Test
  public void testTwoYearTotalInterestPaidForSavingsAccountWithBalanceEqualToThousandMatchesExpected() {
    // value 'balanceExpected' is exported from excel named Interest Calculations.xlsx - Checking TAB - 367 row
    double principalAmount = 1000.0;
    double balanceExpected = 1002.00474380;
    double expectedInterest  = balanceExpected - principalAmount;
    savingsAccount.deposit(principalAmount);
    assertEquals(expectedInterest, savingsAccount.getInterestEarned(DateTime.now().plusYears(2).plusMinutes(1)), DOUBLE_DELTA);
  }

  @Test
  public void testOneYearMaxiSavingsAccountInterestEarnedWithoutWithdrawalForTenDays() {
    // value 'balanceExpected' is exported from excel named Interest Calculations.xlsx - Checking TAB - 367 row
    maxiSavingsAccount.deposit(1000000);
    maxiSavingsAccount.withdraw(900000);
    double principalAmount = maxiSavingsAccount.getBalance();
    double balanceExpected = 105126.74964675;
    double expectedInterest  = balanceExpected - principalAmount;
    assertEquals(expectedInterest, maxiSavingsAccount.getInterestEarned(DateTime.now().plusYears(1)), DOUBLE_DELTA);
  }

  @Test
  public void testTwoYearMaxiSavingsAccountInterestEarnedWithoutWithdrawalForTenDays() {
    // value 'balanceExpected' is exported from excel named Interest Calculations.xlsx - Checking TAB - 367 row
    maxiSavingsAccount.deposit(1000000);
    maxiSavingsAccount.withdraw(900000);
    double principalAmount = maxiSavingsAccount.getBalance();
    double balanceExpected = 110516.33491290;
    double expectedInterest  = balanceExpected - principalAmount;
    assertEquals(expectedInterest, maxiSavingsAccount.getInterestEarned(DateTime.now().plusYears(2).plusMinutes(1)), DOUBLE_DELTA);
  }

  @Test
  public void testMaxiSavingsAccountWithWithdrawalOnTheNextTenDays(){
    maxiSavingsAccount.deposit(10000);
    maxiSavingsAccount.withdraw(9000);
    assertEquals(1, maxiSavingsAccount.getInterestEarned(DateTime.now().plusDays(3)), DOUBLE_DELTA);
  }

}
