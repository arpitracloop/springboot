package com.springboot.crud.controller;

import com.springboot.crud.entity.Student;
import com.springboot.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> getStudentList()
    {
        return this.studentService.getStudentList();
    }
    @GetMapping("/student{Id}")
    public Student getStudent(@PathVariable("Id") int Id)
    {
        return (Student) this.studentService.getStudentList();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student)
    {
        return this.studentService.addStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student)
    {
        return this.studentService.updateStudent(student);
    }

    @DeleteMapping("/student{Id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String Id) {
        try {
            this.studentService.deleteStudent(Long.parseLong(Id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e)
        {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
