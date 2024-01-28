package com.hexaware.dto;

public class BankAccount {
    private static long lastAccountNumber = 1110;
    private long accountNumber;
    private String holderName;
    private String type;
    private double balance;

    public BankAccount(String holderName, String type, double balance) {
        this.accountNumber = BankAccount.lastAccountNumber++;
        this.holderName = holderName;
        this.type = type;
        this.balance = balance;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", holderName='" + holderName + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}