package com.springrest.crud.dao;

import com.springrest.crud.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer, Integer>
{
    


}
