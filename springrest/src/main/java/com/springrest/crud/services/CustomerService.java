package com.springrest.crud.services;

import com.springrest.crud.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CustomerService {

    public List<Integer> getCustomer_id();
    public Customer updateCustomer(Customer customer);

    //
    List<Customer> getCustomerList();

    public Customer addCustomer(Customer customer);

    public void deleteCustomer(long parseLong);
}
