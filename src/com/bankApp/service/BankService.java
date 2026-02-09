package com.bankApp.service;

import com.bankApp.entity.Account;
import com.bankApp.exception.InsufficientBalanceException;
import com.bankApp.exception.AccountNotFoundException;
import com.bankApp.repository.AccountRepository;

public class BankService {
    AccountRepository repo = new AccountRepository();

    public void createAccount(Account ac){
        repo.save(ac);
    }

    public void removeAccount(int id){
        if(!repo.delete(id))
            throw new AccountNotFoundException("User with id : "+id+" does not exist!");
    }

    public Account findAccount(int id){
        if(repo.find(id)==null)
            throw new AccountNotFoundException("User with id :"+id+" does not exist");
        else return repo.find(id);
    }

    public void deposit(double balance, int id){
            Account currentAccount = findAccount(id);
            currentAccount.setBalance(currentAccount.getBalance()+balance);
    }

    public void withdraw(double balance, int id){
            Account currentAccount = findAccount(id);
            double currentBalance = currentAccount.getBalance();
            if(currentBalance < balance){
                throw  new InsufficientBalanceException("Your balance is insufficient!");
            }
            currentBalance -= balance;
            currentAccount.setBalance(currentBalance);
    }

    public double getBalance(int id){
            Account currentAccount = findAccount(id);
            return currentAccount.getBalance();
    }

}
