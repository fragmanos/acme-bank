package com.abc;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    private static final double DOUBLE_DELTA = 1e-15;

    private Bank bank;
    private Customer customer;
    private Account checkingAccount;
    private Account savingsAccount;
    private Account maxiSavingsAccount;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        customer = new Customer("Manos");
        bank.addCustomer(customer);
        checkingAccount = new Account(AccountType.CHECKING);
        savingsAccount = new Account(AccountType.SAVINGS);
        maxiSavingsAccount = new Account(AccountType.MAXI_SAVINGS);
    }

    @Test
    public void testCustomerSummaryMatchesExpected() {
        customer.openAccount(checkingAccount);
        assertEquals("Customer Summary\n - Manos (1 account)", bank.getCustomerSummary(customer));
    }

    @Test
    public void testTotalInterestPaidForCheckingAccountMatchesExpected() {
        customer.openAccount(checkingAccount);
        checkingAccount.deposit(100.0);
        assertEquals(0.1, customer.getTotalInterestEarnedForAccount(checkingAccount), DOUBLE_DELTA);
    }

    @Test
    public void testTotalInterestPaidForSavingsAccountMatchesExpected() {
        customer.openAccount(savingsAccount);
        savingsAccount.deposit(1500.0);
        assertEquals(2.0, customer.getTotalInterestEarnedForAccount(savingsAccount), DOUBLE_DELTA);
    }

    @Test
    public void testTotalInterestPaidForMaxiSavingsAccountMatchesExpected() {
        customer.openAccount(maxiSavingsAccount);
        maxiSavingsAccount.deposit(3000.0);
        assertEquals(170.0, customer.getTotalInterestEarnedForAccount(maxiSavingsAccount), DOUBLE_DELTA);
    }

}
