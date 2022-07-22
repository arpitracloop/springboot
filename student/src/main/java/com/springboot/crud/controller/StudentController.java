package com.springboot.crud.controller;

import com.springboot.crud.entity.Student;
import com.springboot.crud.repository.StudentRepository;
import com.springboot.crud.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class StudentController
{


    @Autowired
    public StudentRepository studentRepository;
    @Autowired
    public StudentService studentService;

    @GetMapping("/getStudentByPaging/{pageNo}/{pageSize}")
    public List<Student> getPaginatedStudent(@PathVariable int pageNo,
                                               @PathVariable int pageSize) {

        return studentService.findPaginated(pageNo, pageSize);
    }
    @GetMapping("/getAllStudents")
    private List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudentById/{id}")
    private Student getStudentsById(@PathVariable Long id)
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
    private Student deleteStudentById(@PathVariable Long id)
    {
        return studentService.deleteStudentById(id);
    }

//    @GetMapping("/findByName/{name}")
//    private List<Student> findByName(@PathVariable String name)
//    {
//        return studentService.findByName(name);
//    }

    @GetMapping("/findStudentByNameLike/name")
    public ResponseEntity<List<Student>> findStudentByNameLike(@RequestParam String name)
    {
        return new ResponseEntity<List<Student>>(studentRepository.findByNameLike("%"+name+"%"), HttpStatus.OK);
    }

}




