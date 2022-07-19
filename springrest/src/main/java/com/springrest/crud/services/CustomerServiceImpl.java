package com.springrest.crud.services;

import com.springrest.crud.dao.CustomerDao;
import com.springrest.crud.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    List<Customer> customerList;


    public List<Customer> CustomerServiceImpl() {
        customerList = new ArrayList<>();
        customerList.add(new Customer(001, "Arpit", "Kushwaha", 999999999, "arpit@racloop.com"));
        customerList.add(new Customer(002, "Mojo", "JOJO", 88888999, "mojojojo@racloop.com"));

        return customerList;
    }

    @Override
    public List<Integer> getCustomer_id() {
        List<Integer> customerIds = new ArrayList<>();
        customerList.forEach(customer -> {
            customerIds.add(customer.getCustomer_id());
        });
        return customerIds;
    }


    //all list
//    @Override
//    public List<Integer> getCustomer_id()
//    {
//        return customerDao.findAll();
//    }
//
//    @Override
//    public Customer getCustomer(long customerIds)
//        {
//            return customerDao.getOne(customerIds);
//        }



    @Override
    public Customer addCustomer(Customer customer) {
//        customerList.add(customer);
            customerDao.save(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer)
    {
//        customerList.forEach(e ->{
//            if(e.getCustomer_id()==customer.getCustomer_id())
//            {
//                e.setCustomer_first_name(customer.getCustomer_first_name());
//                e.setCustomer_last_name(customer.getCustomer_last_name());
//                e.setCustomer_phone_number(customer.getCustomer_phone_number());
//                e.setCustomer_email(customer.getCustomer_email());
//            }
//        });
        customerDao.save(customer);
        return customer;
    }

    @Override
    public List<Customer> getCustomerList() {
        return getCustomerList();
    }

    @Override
    public void deleteCustomer(long parseLong)
    {
       customerList = this.customerList.stream().filter(e->e.getCustomer_id()!=parseLong).collect(Collectors.toList());
//        Customer entity = customerDao.getOne(parseLong);
//        customerDao.delete(entity);
    }
}
