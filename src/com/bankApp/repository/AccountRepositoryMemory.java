package com.bankApp.repository;

import com.bankApp.entity.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountRepositoryMemory implements AccountRepository {
    Map<Integer, Account> accountDB ;
    public AccountRepositoryMemory(){
        this.accountDB = new HashMap<>();
    }

    @Override
    public void save(Account ac){
        accountDB.put(ac.getId(),ac);
        System.out.println();
        System.out.println(accountDB.get(ac.getId()));
        System.out.println();
    }


    @Override
    public boolean delete(int id){
        if(accountDB.containsKey(id)) {
            accountDB.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Account find(int id){
        return accountDB.getOrDefault(id,null);
    }

    @Override
    public void update(Account ac){
        accountDB.put(ac.getId(),ac);
    }
}
