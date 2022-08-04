package com.springboot.decrypt.repository;

import com.springboot.decrypt.entity.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository  extends JpaRepository<Entity, Integer> {

}
