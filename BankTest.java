package com.ge.exercise3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankTest {

    Bank bank;

   /* @Before
    public void setUp() {
        bank = new Bank();
    }*/

    @Test
    public void addAccountTest() {
        Account account = new Account("001");
        bank.addAccount(account);
        assertEquals(1, bank.numAccounts());
    }

    @Test
    public void getAccountTest() {
        Account account = new Account("002", "Checking", 100.0f);
        bank.addAccount(account);
        assertEquals(account, bank.getAccount("002"));
    }

    @Test
    public void depositToAccountTest() {
        Account account = new Account("003", "Checking", 100.0f);
     
        bank.addAccount(account);
        bank.depositToAccount("003", 100.0f);
        assertEquals(200.0f, account.getBalance(), 0.01);
    }

    @Test
    public void withdrawFromAccountTest() {
        Account account = new Account("004", "Checking", 100.0f);
        Account account1 = new Account("005", "Checking", 120.0f);
        Account account2 = new Account("006", "Savings", 140.0f);
        bank = new Bank();
        bank.addAccount(account);
        bank.addAccount(account1);
        bank.addAccount(account2);
        bank.withdrawFromAccount("004","Checking",100.0f);
        bank.withdrawFromAccount("005","Checking",120.0f);
        bank.withdrawFromAccount("006", "Savings", 150.0f);
        assertEquals(0.0f, account.getBalance(), 0.01);
    }
    
    @Test
    public void predictProfitOrLoss() {
        Account account = new Account("004", "Checking", 100.0f);
        account.setMonthlyFee(10);
        account.setMonthlyInterestRate(1.09f);
        Account account1 = new Account("005", "Checking", 120.0f);
        account1.setMonthlyFee(20);
        account1.setMonthlyInterestRate(1.12f);
        Account account2 = new Account("006", "Savings", 140.0f);
        account2.setMonthlyInterestRate(1.12f);
        account2.setMonthlyFee(30);
        bank = new Bank();
        bank.addAccount(account);
        bank.addAccount(account1);
        bank.addAccount(account2);
         List<Account>acc=new ArrayList<>();
         acc.add(account);
         acc.add(account1);
         acc.add(account2);
         bank.predictProfitOrLoss(acc);
        
    }
}