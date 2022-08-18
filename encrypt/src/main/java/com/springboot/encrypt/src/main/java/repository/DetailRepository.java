package com.springboot.encrypt.src.main.java.repository;

import com.springboot.encrypt.src.main.java.model.Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailRepository extends JpaRepository<Details, Long> {

}
