package com.abc;

/**
 * @author fragkakise on 30/11/2015.
 */
public enum AccountType {
  CHECKING("Checking Account"),
  SAVINGS("Savings Account"),
  MAXI_SAVINGS("Maxi Savings Account");

  private String description;

  AccountType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

}
