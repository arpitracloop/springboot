package com.springrest.crud.controllers;

import com.springrest.crud.entities.Customer;
import com.springrest.crud.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //get customer id
    @GetMapping("/customerid")
    public List<Integer> getCustomer_id()
    {
        return this.customerService.getCustomer_id();

    }

    @GetMapping("/customers")
    public List<Customer> getCustomers()
    {
        return this.customerService.getCustomerList();
    }


    // add new customer
    @PostMapping("/addcustomer")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        return this.customerService.addCustomer(customer);
    }
//    @GetMapping("/customerDetails{}")
//    public Customer getDetails(@PathVariable String customer)
//    {
//        return this.customerService.getCustomer_id()
//    }

    // update customer
    @PutMapping("/updatecustomer")
    public Customer updateCustomer(@RequestBody Customer customer)
    {
        return this.customerService.updateCustomer(customer);
    }

    @DeleteMapping("/deletecustomer{Customer_id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable String Customer_id)
    {
        try{
            this.customerService.deleteCustomer(Long.parseLong(Customer_id));
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
