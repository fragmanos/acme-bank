package com.mybank.bank;

import com.mybank.account.CheckingAccount;
import com.mybank.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankTest {

    private Bank bank;
    private Customer customer;
    private CheckingAccount checkingAccount;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
        customer = new Customer("Manos");
        bank.addCustomer(customer);
        checkingAccount = new CheckingAccount();
    }

    @Test
    public void testCustomerSummaryMatchesExpected() {
        customer.openAccount(checkingAccount);
        assertEquals("Customer Summary\n - Manos (1 account)", bank.getCustomerSummary(customer));
    }

}
