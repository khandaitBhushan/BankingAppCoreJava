package com.bankApp.repository;

import com.bankApp.entity.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {
    Map<Integer, Account> accountDB ;
    public AccountRepository(){
        this.accountDB = new HashMap<>();
    }

    public void save(Account ac){
        accountDB.put(ac.getId(),ac);
        System.out.println();
        System.out.println(accountDB.get(ac.getId()));
        System.out.println();
    }

    public boolean delete(int id){
        if(accountDB.containsKey(id)) {
            accountDB.remove(id);
            return true;
        }
        return false;
    }

    public Account find(int id){
        return accountDB.getOrDefault(id,null);
    }
}
