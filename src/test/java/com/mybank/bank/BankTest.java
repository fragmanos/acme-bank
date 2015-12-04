package com.mybank.bank;

import com.mybank.account.CheckingAccount;
import com.mybank.account.MaxiSavingsAccount;
import com.mybank.account.SavingsAccount;
import com.mybank.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    private static final double DOUBLE_DELTA = 1e-15;

    private Bank bank;
    private Customer customer;
    private CheckingAccount checkingAccount;
    private SavingsAccount savingsAccount;
    private MaxiSavingsAccount maxiSavingsAccount;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        customer = new Customer("Manos");
        bank.addCustomer(customer);
        checkingAccount = new CheckingAccount();
        savingsAccount = new SavingsAccount();
        maxiSavingsAccount = new MaxiSavingsAccount();
    }

    @Test
    public void testCustomerSummaryMatchesExpected() {
        customer.openAccount(checkingAccount);
        assertEquals("Customer Summary\n - Manos (1 account)", bank.getCustomerSummary(customer));
    }

    @Test
    public void testTotalInterestPaidForCheckingAccountMatchesExpected() {
        checkingAccount.deposit(100.0);
        assertEquals(0.1, checkingAccount.getInterestEarned(), DOUBLE_DELTA);
    }

    @Test
    public void testTotalInterestPaidForSavingsAccountMatchesExpected() {
        savingsAccount.deposit(1500.0);
        assertEquals(2.0, savingsAccount.getInterestEarned(), DOUBLE_DELTA);
    }

}
