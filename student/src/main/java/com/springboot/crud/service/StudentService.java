package com.springboot.crud.service;

import com.springboot.crud.entity.Student;
import com.springboot.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    public List<Student> getAllStudents;
    public Student getStudentsById;
    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> getAllStudents()
    {
       return studentRepository.findAll();
    }

    public Student getStudentsById(long id)
    {
        return studentRepository.findById(id).get();
    }

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Student deleteStudentById(long id)
    {
        studentRepository.deleteById(id);
        return null;
    }
}


