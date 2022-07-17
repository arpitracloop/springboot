package com.springrest.crud.services;

import com.springrest.crud.entities.Customer;

import java.util.List;
public interface CustomerService {

    public List<Integer> getCustomer_id();

    public Customer addCustomer(Customer customer);
}
