package com.springboot.crud.controller;

import com.springboot.crud.entity.Student;
import com.springboot.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class StudentController
{
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public Iterable<Student> getStudent()
    {
        return studentService.getStudentList();
    }

    @GetMapping("/student/{Id}")
    public Optional<Student> getStudent(@PathVariable long Id)
    {
        return studentService.getStudentList(Id);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @PutMapping("/student/{Id}")
    public Student updateStudent(@PathVariable long Id)
    {
        return studentService.updateStudent(Id);
    }

    @DeleteMapping("/student/{Id}")
    public Student deleteStudent(@PathVariable long Id)
    {
        return studentService.deleteStudent(Id);
    }
}
