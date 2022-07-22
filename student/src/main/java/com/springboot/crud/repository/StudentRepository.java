package com.springboot.crud.repository;

import com.springboot.crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


   List<Student> findByNameLike(String name);
   List<Student> findByNameAndAddress(String name, String address);
   List<Student> findByName(String name);



}
