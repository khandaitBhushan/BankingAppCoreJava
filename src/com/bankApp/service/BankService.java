package com.bankApp.service;

import com.bankApp.entity.Account;
import com.bankApp.exception.InsufficientBalanceException;
import com.bankApp.exception.AccountNotFoundException;
import com.bankApp.repository.AccountRepository;
import com.bankApp.repository.AccountRepositoryJDBC;

public class BankService {
    AccountRepository repo = new AccountRepositoryJDBC();

    public void createAccount(Account ac){
        repo.save(ac);
    }

    public void removeAccount(int id){
        if(!repo.delete(id))
            throw new AccountNotFoundException("User with id : "+id+" does not exist!");
    }

    public Account findAccount(int id){
        Account currAccount = repo.find(id);
        if(currAccount==null)
            throw new AccountNotFoundException("User with id :"+id+" does not exist");
        else return currAccount;
    }

    public void deposit(double balance, int id){
            Account currentAccount = findAccount(id);
            currentAccount.setBalance(currentAccount.getBalance()+balance);
            repo.update(currentAccount);

    }

    public void withdraw(double balance, int id){
            Account currentAccount = findAccount(id);
            double currentBalance = currentAccount.getBalance();
            if(currentBalance < balance){
                throw  new InsufficientBalanceException("Your balance is insufficient!");
            }
            currentBalance -= balance;
            currentAccount.setBalance(currentBalance);
            repo.update(currentAccount);
    }

    public double getBalance(int id){
            Account currentAccount = findAccount(id);
            return currentAccount.getBalance();
    }

}
