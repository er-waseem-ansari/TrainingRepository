package com.hexaware.dto;
import java.util.List;
public class Bank {

    public String name;

    public List<BankAccount> accountList = null;

    public Bank(String name, List<BankAccount> accountList) {
        this.name = name;
        this.accountList = accountList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BankAccount> getAccountList() {
        return this.accountList;
    }

    public void setAccountList(List<BankAccount> accountlist) {
        this.accountList = accountlist;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accountList=" + accountList +
                '}';
    }
}