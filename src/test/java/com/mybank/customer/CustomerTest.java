package com.mybank.customer;

import com.mybank.account.CheckingAccount;
import com.mybank.account.MaxiSavingsAccount;
import com.mybank.account.SavingsAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    CheckingAccount checkingAccount;
    SavingsAccount savingsAccount;
    MaxiSavingsAccount maxiSavingsAccount;

    @Before
    public void setUp() throws Exception {
        checkingAccount = new CheckingAccount();
        savingsAccount = new SavingsAccount();
        maxiSavingsAccount = new MaxiSavingsAccount();
    }

    @Test
    public void TestCustomerStatementGeneration(){

      Customer henry = new Customer("Henry");
      henry.openAccount(checkingAccount);
      henry.openAccount(savingsAccount);

      checkingAccount.deposit(100.0);
      savingsAccount.deposit(4000.0);
      savingsAccount.withdraw(200.0);

      String customerStatement = "Statement for Henry\n" +
                          "\n" +
                          "Checking Account\n" +
                          "  deposit $100.00\n" +
                          "Total $100.00\n" +
                          "\n" +
                          "Savings Account\n" +
                          "  deposit $4,000.00\n" +
                          "  withdrawal $200.00\n" +
                          "Total $3,800.00\n" +
                          "\n" +
                          "Total In All Accounts $3,900.00";
      assertEquals(customerStatement, henry.getStatementForAllAccounts());
    }

    @Test
    public void testThreeAccountsForACustomer() {
        Customer oscar = new Customer("Oscar");
        oscar.openAccount(checkingAccount);
        oscar.openAccount(savingsAccount);
        oscar.openAccount(maxiSavingsAccount);
        assertEquals(3, oscar.getNumberOfAccounts());
    }
}
