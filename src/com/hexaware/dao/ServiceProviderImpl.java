package com.hexaware.dao;

import com.hexaware.dto.Bank;
import com.hexaware.dto.BankAccount;
import com.hexaware.myexceptions.AccountNumberInvalidException;
import com.hexaware.myexceptions.InsufficientFundsException;
import com.hexaware.myexceptions.NegativeAmountException;

public class ServiceProviderImpl implements IServiceProvider {

    private Bank myBank;

    public ServiceProviderImpl() {
        super();
    }

    public ServiceProviderImpl(Bank myBank) {
        super();
        this.myBank = myBank;
    }

    @Override
    public BankAccount searchAccount(long accountNumber) throws AccountNumberInvalidException {
        BankAccount reqAccount = null;
        for (BankAccount account : myBank.getAccountList()) {
            if (account.getAccountNumber() == accountNumber) {
                reqAccount = account;
                break;
            }
        }
        if(reqAccount == null) throw new AccountNumberInvalidException("Invalid account number");
	

        return reqAccount;
    }

    @Override
	public double checkBalance(long accountNumber) throws AccountNumberInvalidException{

		double balanceAmount = -1;
		BankAccount reqAccount=null;
		reqAccount=searchAccount(accountNumber);
		if(reqAccount == null) throw new AccountNumberInvalidException("Invalid account number");
		balanceAmount=reqAccount.getBalance();

		return balanceAmount;
	}


    @Override
	public boolean deposit(long accountNumber, double amount) throws AccountNumberInvalidException, NegativeAmountException  {
	
		BankAccount reqAccount=null;
		boolean depostStatus=false;
		if(amount>0) {
			reqAccount=searchAccount(accountNumber);
			if(reqAccount==null){
				throw new AccountNumberInvalidException("Invalid account number");
			}
			else {
				reqAccount.setBalance(reqAccount.getBalance()+amount);
				depostStatus=true;
			}
		}else {
			throw new NegativeAmountException("Balance cannot be negative");
		}
		return depostStatus;
	}


    @Override
	public boolean withdraw(long accountNumber, double amount) throws AccountNumberInvalidException, InsufficientFundsException, NegativeAmountException  {

	
		BankAccount reqAccount=null;
		boolean withdrawStatus=false;
		reqAccount=searchAccount(accountNumber);
		if(reqAccount == null) throw new AccountNumberInvalidException("Invalid account number");
		if(reqAccount.getBalance()<amount) {
			throw new InsufficientFundsException("You have insufficient balance");
		}
		if(amount<0) {
			throw new NegativeAmountException("amount cannot be negative");
		}
		else {
			reqAccount.setBalance(reqAccount.getBalance()-amount);
			withdrawStatus=true;
		}
		return withdrawStatus;
	}

    @Override
    public boolean createAccount(BankAccount newAcc) {
        // TODO Auto-generated method stub
        BankAccount lastAccObj = myBank.getAccountList().get(myBank.getAccountList().size() - 1);
        boolean status = false;
        BankAccount newAccObj = new BankAccount(newAcc.getHolderName(),newAcc.getType(), newAcc.getBalance());
        myBank.getAccountList().add(newAccObj);
        status = true;
        return status;
    }

    @Override
	public boolean removeAccount(long accountNumber) throws AccountNumberInvalidException  {
		BankAccount reqAccount=null;
		boolean removeStatus=false;
		reqAccount=searchAccount(accountNumber);
		if(reqAccount == null) throw new AccountNumberInvalidException("Invalid account number");
		this.myBank.getAccountList().remove(reqAccount);
		removeStatus=true;
		return removeStatus;
	}

}
