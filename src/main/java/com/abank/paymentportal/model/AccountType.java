package com.abank.paymentportal.model;

public enum AccountType {
    CARD_SIMPLE("card/simple");

    private final String accountType;

    AccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}