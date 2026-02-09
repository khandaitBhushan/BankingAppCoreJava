package com.bankApp.entity;

public class Account {
    private int id;
    private String name;
    private double balance;
    private String accountType;
    private String address;
    private String phoneNo;

    public Account() {
    }

    public Account(int id, String name, double balance, String accountType, String address, String phoneNo) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public String toString() {
        return "id : " + id +'\n'+
                "name : " + name + '\n' +
                "balance : " + balance +'\n'+
                "accountType : " + accountType + '\n' +
                "address : " + address + '\n' +
                "phoneNo : " + phoneNo + '\n' ;
    }
}
