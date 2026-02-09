package com.bankApp.repository;

import com.bankApp.entity.Account;

public interface AccountRepository {
    void save(Account ac);
    Account find(int id);
    boolean delete(int id);
    void update(Account ac);
}
