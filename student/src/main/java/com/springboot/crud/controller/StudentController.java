package com.springboot.crud.controller;

import com.springboot.crud.entity.Student;
import com.springboot.crud.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StudentController
{

    @Autowired
    public StudentService studentService;

    // for getting students in page
    @GetMapping("/getStudentByPaging/{pageNo}/{pageSize}")
    public List<Student> getPaginatedStudent(@PathVariable int pageNo, @PathVariable int pageSize)
    {
        return studentService.findPaginatedStudent(pageNo, pageSize);
    }

    // get all students
    @GetMapping("/getAllStudents")
    private List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    //get student by id
    @GetMapping("/getStudentById/{id}")
    private ResponseEntity<Student> getStudentsById(@RequestBody Student student,@PathVariable Long id) throws Exception
    {
            return studentService.getStudentsById(id);
    }

    //add student
    @PostMapping("/addStudent")
    private Student addStudent(@RequestBody Student student)
    {
        return studentService.addStudent(student);
    }

    //update student by id
    @PutMapping("/updateStudent/{id}")
    private Student updateStudent(@RequestBody Student student, @PathVariable Long id)
    {
        return studentService.updateStudent(student,id);
    }

    //delete student by id
    @DeleteMapping("/deleteStudent/{Id}")
    private Student deleteStudentById(@PathVariable Long id)
    {
        return studentService.deleteStudentById(id);
    }

    //get student by name like
    @GetMapping("/findStudentByNameLike/name")
    public ResponseEntity<List<Student>> findStudentByNameLike(@RequestParam String name)  {
        return studentService.findStudentByNameLike(name);
    }

    // get student by name and address
    @GetMapping("/findStudentByNameAndAddress/nameAndAddress")
    public ResponseEntity<List<Student>> findStudentByNameAndAddress(@RequestParam String name, @RequestParam String address)
    {
        return studentService.findStudentByNameAndAddress(name,address);
    }

    // get student by name
    @GetMapping("/findStudentByName/name")
    public ResponseEntity<List<Student>> findStudentByName(@RequestParam String name)
    {
        return studentService.findStudentByName(name);
    }

}




