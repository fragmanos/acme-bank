package com.mybank.types;

/**
 * @author fragkakise on 03/12/2015.
 */
public enum TransactionType {
  WITHDRAWAL("withdrawal"),
  DEPOSIT("deposit");

  private String description;

  TransactionType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

}
