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

import java.util.*;

@Service
public class StudentService {

    // exception handling
    StudentController studentController;

    @Autowired
    private StudentRepository studentRepository;

//    // get student by page
    public List<Student> findPaginatedStudent(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Student> pagedResult =studentRepository.findAll(paging);
        Map<String, Object> response = new HashMap<>();
//        response.put("students", student);
        response.put("currentPage", pagedResult.getNumber());
        response.put("totalItems", pagedResult.getTotalElements());
        response.put("totalPages", pagedResult.getTotalPages());
        return pagedResult.toList();

    }

    // get all students
    public List<Student> getAllStudents()
    {
        Student student = new Student();

        if(student.getDel().equals(false))
        {
            return studentRepository.findAll();
        }
        else {
            return null;
        }
          // it should return either list or page
    }

    //get students by id
    public ResponseEntity<Student> getStudentsById(Long id) throws Exception {
        Optional<Student> studentOptional= studentRepository.findById(id);
        if(studentOptional.isPresent() && studentOptional.get().getDel().equals(false))
        {
            return new ResponseEntity<>(studentOptional.get(),HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //add student
    public Student addStudent(Student student)
    {
        student.setDel(false);
        return studentRepository.save(student);
    }

    // update student
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

    //delete student
    public Student deleteStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent() && student.get().getDel().equals(false)) {
            student.get().setDel(true);
            studentRepository.save(student.get());
            return student.get();
        }
        else {

            return null;
        }
//        student.setDel(true);
//        return null;
    }

    //get student by name like
    public ResponseEntity<List<Student>> findStudentByNameLike(String name)
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

    // get student by name and address
    public ResponseEntity<List<Student>> findStudentByNameAndAddress(String name, String address) {
        List<Student> studentList = studentRepository.findByNameAndAddress(name, address);
        if(studentList.contains(name)||studentList.contains(address))
        {
            return new ResponseEntity<>(studentRepository.findByNameAndAddress(name, address),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    //get student by name
    public ResponseEntity<List<Student>> findStudentByName(String name) {
        List<Student> studentList = studentRepository.findByName(name);
        if(studentList.contains(name))
        {
            return new ResponseEntity<>(studentRepository.findByName(name),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}


