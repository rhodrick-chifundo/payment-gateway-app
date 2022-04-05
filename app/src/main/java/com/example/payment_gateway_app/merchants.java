package com.example.payment_gateway_app;

public class merchants {
    String accountBalance, accountName, accountNumber, serviceName;

    public merchants() {
    }

    public merchants(String accountBalance, String accountName, String accountNumber, String serviceName) {
        this.accountBalance = accountBalance;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.serviceName = serviceName;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
