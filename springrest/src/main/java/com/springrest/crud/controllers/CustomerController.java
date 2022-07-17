package com.springrest.crud.controllers;

import com.springrest.crud.entities.Customer;
import com.springrest.crud.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @GetMapping("/home")
    public String home()
    {
        return "This is a home page";
    }

    //get customer id
    @GetMapping("/customerid")
    public List<Integer> getCustomer_id()
    {
        return this.customerService.getCustomer_id();

    }

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

}
