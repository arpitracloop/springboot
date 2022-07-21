package com.springboot.crud.service;

import com.springboot.crud.entity.Student;
import com.springboot.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    Student student;

 //use jpa repo instead of crud
    // pagination
    // exception handling


    @Autowired
    private StudentRepository studentRepository;

    public Iterable<Student> getAllStudents()
    {
       return (Iterable<Student>) studentRepository.findAll();  // it should return either list or page
    }

    public Optional<Student> getStudentsById(Long id)
    {
        return studentRepository.findById(id);   // this should not return optional instead student
    }

    public Student addStudent(Student student)
    {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student, Long Id)
    {
        Student student1 = studentRepository.findById(Id).get();
        if(Objects.nonNull(student.getName())&& !"".equalsIgnoreCase(student.getName()))
        {
            student1.setName(student.getName());
        }
        if(Objects.nonNull(student.getAddress())&&!"".equalsIgnoreCase(student.getAddress()))
        {
            student1.setAddress(student.getAddress());
        }
//
//        Optional<Student> stu = studentRepository.findById(Id);
//        if(stu.equals(student.getId())){
//            student.setName(student.getName());
//            student.setAddress(student.getAddress());
//            studentRepository.save(student);
//        }
//        else {
//            return null;
//        }
//        return student;
        return studentRepository.save(student1);

    }

    public Student deleteStudentById(long id)
    {
        studentRepository.deleteById(id);
        return null;
    }
}


