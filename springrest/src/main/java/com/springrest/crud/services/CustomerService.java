package com.springrest.crud.services;

import com.springrest.crud.entities.Customer;

import java.util.List;
public interface CustomerService {

    public List<Integer> getCustomer_id();
    public Customer updateCustomer(Customer customer);

    //
    List<Customer> getCustomerList();

    public Customer addCustomer(Customer customer);

    public void deleteCustomer(long parseLong);
}
