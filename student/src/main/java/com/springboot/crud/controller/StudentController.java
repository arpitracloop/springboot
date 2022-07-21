package com.springboot.crud.controller;

import com.springboot.crud.entity.Student;
import com.springboot.crud.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
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
    private Optional<Student> getStudentsById(@PathVariable Long id)
    {
        return studentService.getStudentsById(id);
    }

    @PostMapping("/addStudent")
    private Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    @PutMapping("/updateStudent/{id}")
    private Student updateStudent(@RequestBody Student student, @PathVariable Long id)
    {

        return studentService.updateStudent(student,id);
    }

    @DeleteMapping("/deleteStudent/{Id}")
    private Student deleteStudentById(@PathVariable long Id)
    {
        return studentService.deleteStudentById(Id);
    }
}
