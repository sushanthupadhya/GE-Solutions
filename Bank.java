package com.ge.exercise3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private static final Logger logger = LogManager.getLogger(Bank.class);
    private Map<String, Account> accountMap;

    public Bank() {
        accountMap = new HashMap<>();
    }

    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void depositToAccount(String accountNumber, float amount) {
        getAccount(accountNumber).deposit(amount);
    }

    public void withdrawFromAccount(String accountNumber,String accountType,float amount) {
    	//checking and amount>100 do not allow to withdraw
    	//prevent savings account having negative balance
    	float balance=getAccount(accountNumber).getBalance();
    	float balanceAfterWithdraw=balance-amount;
    	if(!(accountType=="Checking" && amount>100.0f)&&!(accountType=="Savings" && balanceAfterWithdraw<0))
    	{
        getAccount(accountNumber).withdraw(amount);
    	}
    
    }
    
    public void predictProfitOrLoss(List<Account>account)
    {
    	float profitOrloss=0.0f;
    	for (Account account2 : account) {
    	 profitOrloss+=(account2.valueNextMonth()-account2.getBalance());
			System.out.println(profitOrloss);
		}
    	System.out.println("Final Profit Or Loss is"+profitOrloss);
    }

    public int numAccounts() {
        return accountMap.size();
    }
}
