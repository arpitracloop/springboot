package com.springrest.crud.entities;

import java.util.HashSet;
import java.util.Set;


public class Account {


    private int Account_number;
    private String Account_type;
    private String Account_branch;

    private Set<Customer> customer = new HashSet<>();

    public Account(int account_number, String account_type, String account_branch)
    {
        Account_number = account_number;
        Account_type = account_type;
        Account_branch = account_branch;
    }

    public Account()
    {

    }

    public int getAccount_number() {
        return Account_number;
    }
//
//    public void setAccount_number() {
//        for(Account account : Account)
//        {
//            if(account )
//
//        }
//        Account_number = account_number;
//    }
//    public void setAccount_number(int account_number) {
//
//        Account_number = account_number;
//    }

    public String getAccount_type() {
        return Account_type;
    }

    public void setAccount_type(String account_type) {
        Account_type = account_type;
    }

    public String getAccount_branch() {
        return Account_branch;
    }

    public void setAccount_branch(String account_branch) {
        Account_branch = account_branch;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Account_number=" + Account_number +
                ", Account_type='" + Account_type + '\'' +
                ", Account_branch='" + Account_branch + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return Account_number == account.Account_number;
    }

    @Override
    public int hashCode() {
        return Account_number;
    }
}
