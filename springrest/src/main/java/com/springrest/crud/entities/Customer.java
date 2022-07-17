package com.springrest.crud.entities;

import java.util.HashSet;
import java.util.Set;


public class Customer {

    private int Customer_id;
    private String Customer_first_name;
    private String Customer_last_name;
    private int Customer_phone_number;
    private String Customer_email;

    private Set<Account> account = new HashSet<>();

    public Customer(int customer_id, String customer_first_name, String customer_last_name, int customer_phone_number, String customer_email)
    {
        Customer_id = customer_id;
        Customer_first_name = customer_first_name;
        Customer_last_name = customer_last_name;
        Customer_phone_number = customer_phone_number;
        Customer_email = customer_email;
    }

    public Customer()
    {

    }

    public int getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(int customer_id) {
        Customer_id = customer_id;
    }

    public String getCustomer_first_name() {
        return Customer_first_name;
    }

    public void setCustomer_first_name(String customer_first_name) {
        Customer_first_name = customer_first_name;
    }

    public String getCustomer_last_name() {
        return Customer_last_name;
    }

    public void setCustomer_last_name(String customer_last_name) {
        Customer_last_name = customer_last_name;
    }

    public int getCustomer_phone_number() {
        return Customer_phone_number;
    }

    public void setCustomer_phone_number(int customer_phone_number) {
        Customer_phone_number = customer_phone_number;
    }

    public String getCustomer_email() {
        return Customer_email;
    }

    public void setCustomer_email(String customer_email) {
        Customer_email = customer_email;
    }

    public Set<Account> getAccount() {
        return account;
    }

    public void setAccount(Set<Account> account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Customer_id=" + Customer_id +
                ", Customer_first_name='" + Customer_first_name + '\'' +
                ", Customer_last_name='" + Customer_last_name + '\'' +
                ", Customer_phone_number=" + Customer_phone_number +
                ", Customer_email='" + Customer_email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return Customer_id == customer.Customer_id;
    }

    @Override
    public int hashCode() {
        return Customer_id;
    }
}
