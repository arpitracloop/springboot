package com.springboot.crud.service;

import com.springboot.crud.controller.StudentController;
import com.springboot.crud.entity.Student;
import com.springboot.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    Student student;

    //use jpa repo instead of crud  - done
    // pagination - done
    // exception handling
    StudentController studentController;


    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();  // it should return either list or page
    }

    public ResponseEntity<Student> getStudentsById(Long id) throws Exception {
        Optional<Student> studentOptional= studentRepository.findById(id);
        if(studentOptional.isPresent())
        {
            return new ResponseEntity<>(studentOptional.get(),HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }



    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student, Long Id)
    {
        Student student1 = studentRepository.findById(Id).get();
        if (Objects.nonNull(student.getName()) && !"".equalsIgnoreCase(student.getName())) {
            student1.setName(student.getName());
        }
        if (Objects.nonNull(student.getAddress()) && !"".equalsIgnoreCase(student.getAddress())) {
            student1.setAddress(student.getAddress());
        }
        return studentRepository.save(student1);
    }
    public Student deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return null;
    }
    public List<Student> findPaginatedStudent(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Student> pagedResult =studentRepository.findAll(paging);
        return pagedResult.toList();
    }
    public ResponseEntity<List<Student>> findStudentByNameLike(String name) throws Exception
    {
        List<Student> studentList = studentRepository.findByNameLike(name);
        if(studentList.contains(name))
        {
            return new ResponseEntity<>(studentRepository.findByNameLike(name),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }
}


