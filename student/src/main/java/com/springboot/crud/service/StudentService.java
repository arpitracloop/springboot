package com.springboot.crud.service;

import com.springboot.crud.repository.StudentRepository;
import com.springboot.crud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    List<Student> studentList;

    public Iterable<Student> getStudentList()
    {

        return studentRepository.findAll();

    }

    public Optional<Student> getStudentList(long id)
    {
        return studentRepository.findById(id);
    }

    public Student addStudent(Student student)
    {
       return studentRepository.save(student);
    }

//    public Student updateStudent(long id) {
//
//
//    }

    public Student deleteStudent(long id) {

        studentRepository.deleteById(id);

        return null;
    }


}


