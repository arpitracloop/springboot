package com.springrest.crud.services;

import com.springrest.crud.entities.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    List<Customer> customerList;


    public CustomerServiceImpl() {
        customerList = new ArrayList<>();
        customerList.add(new Customer(001, "Arpit", "Kushwaha", 999999999, "arpit@racloop.com"));
        customerList.add(new Customer(002, "Mojo", "JOJO", 88888999, "mojojojo@racloop.com"));
    }


    @Override
    public List<Integer> getCustomer_id() {
        List<Integer> customerIds = new ArrayList<>();
        customerList.forEach(customer -> {
            customerIds.add(customer.getCustomer_id());
        });
        return customerIds;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        customerList.add(customer);
        return customer;
    }
}
