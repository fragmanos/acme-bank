package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public String getCustomerSummary(Customer customer) {
        StringBuilder summary = new StringBuilder("Customer Summary");
            summary.append("\n - ")
              .append(customer.getCustomerName()).append(" (")
              .append(getPluralFormat(customer.getNumberOfAccounts(), "account")).append(")");
        return String.valueOf(summary);
    }

    //  Make sure correct plural of word is created based on the number passed in:
    //  If number passed in is 1 just return the word otherwise add an 's' at the end
    private String getPluralFormat(int number, String word) {
        return number + " " + (number == 1 ? word : word + "s");
    }

}
