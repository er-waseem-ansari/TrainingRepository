package com.hexaware.dao;

import com.hexaware.dto.BankAccount;
import com.hexaware.myexceptions.AccountNumberInvalidException;
import com.hexaware.myexceptions.InsufficientFundsException;
import com.hexaware.myexceptions.NegativeAmountException;

public interface IServiceProvider {
	public BankAccount  searchAccount(long accountNumber) throws AccountNumberInvalidException;
	public double checkBalance(long accountNumber) throws AccountNumberInvalidException;
	public boolean deposit(long accountNumber,double amount) throws AccountNumberInvalidException, NegativeAmountException;
	public boolean withdraw(long accountNumber,double amount) throws AccountNumberInvalidException, InsufficientFundsException, NegativeAmountException;
	public boolean removeAccount(long accountNumber) throws AccountNumberInvalidException;
	public boolean createAccount(BankAccount newAcc);


}

