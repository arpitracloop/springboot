package com.springboot.encrypt.src.main.java.repository;

import com.springboot.encrypt.src.main.java.model.FPSDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FPSDetailsRepository extends CrudRepository<FPSDetails, Long> {


}
