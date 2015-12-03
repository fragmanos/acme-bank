package com.mybank.messages;

/**
 * @author fragkakise on 03/12/2015.
 */
public enum ExceptionErrorMessages {
  DEPOSIT_NEGATIVE_AMOUNT("Amount for deposit must be positive."),
  WITHDRAW_NEGATIVE_AMOUNT("Amount for withdraw must positive."),
  INSUFFICIENT_WITHDRAW_BALANCE("Amount must be less or equal than balance"),
  INSUFFICIENT_TRANSFER_BALANCE("Transferred amount must be less or equal than balance"),
  TRANSFER_NEGATIVE_AMOUNT("Attempt to transfer negative amount of money");

  private String description;

  ExceptionErrorMessages(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
