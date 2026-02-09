package com.bankApp.repository;

import com.bankApp.db.DbConnection;
import com.bankApp.entity.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountRepositoryJDBC implements AccountRepository{
    @Override
    public void save(Account ac) {
        String query = """
            INSERT INTO account (name, balance, account_type, address, phone_no)
            VALUES (?, ?, ?, ?, ?)""";
        
        try(PreparedStatement st = DbConnection.getConnection().prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);){
            st.setString(1,ac.getName());
            st.setDouble(2,ac.getBalance());
            st.setString(3,ac.getAccountType());
            st.setString(4,ac.getAddress());
            st.setString(5,ac.getPhoneNo());
            int rowAffected = st.executeUpdate();
            ResultSet set = st.getGeneratedKeys();
            if(set.next()) {
                int id = set.getInt(1);
                ac.setId(id);
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Account find(int id) {
        String query = "select * from account where id = ?";
        try(PreparedStatement st = DbConnection.getConnection().prepareStatement(query)){
            st.setInt(1,id);
            ResultSet resultSet = st.executeQuery();
            Account currAccount = null;
                if(resultSet.next()){
                currAccount = new Account(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6)
                        );
            }
            resultSet.close();
            return currAccount;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        String query = "delete from account where id = ?";
        try(PreparedStatement st = DbConnection.getConnection().prepareStatement(query)){
            st.setInt(1,id);
            int del_query = st.executeUpdate();
            return del_query!=0;
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public void update(Account ac){
        String query = "update account set balance = ? where id = ?";
        try(PreparedStatement st = DbConnection.getConnection().prepareStatement(query)){
            st.setDouble(1,ac.getBalance());
            st.setInt(2,ac.getId());
            int update_query = st.executeUpdate();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
