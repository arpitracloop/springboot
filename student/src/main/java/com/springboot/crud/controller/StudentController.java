package com.springboot.crud.controller;

import com.springboot.crud.entity.Student;
import com.springboot.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController
{
    @Autowired
    public StudentService studentService;

    @GetMapping("/getAllStudents")
    private Iterable<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudentById/{id}")
    private Student getStudentsById(@PathVariable long Id)
    {
        return studentService.getStudentsById(Id);
    }

    @PostMapping("/addStudent")
    private Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @PutMapping("/updateStudent")
    private Student updateStudent(@RequestBody Student student)
    {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent/{Id}")
    private Student deleteStudentById(@PathVariable long Id)
    {
        return studentService.deleteStudentById(Id);
    }
}
