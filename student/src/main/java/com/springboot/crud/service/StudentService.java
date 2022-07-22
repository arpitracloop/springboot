package com.springboot.crud.service;

import com.springboot.crud.controller.StudentController;
import com.springboot.crud.entity.Student;
import com.springboot.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentService {
    Student student;

    //use jpa repo instead of crud  - done
    // pagination
    // exception handling
    StudentController studentController;


    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();  // it should return either list or page
    }

    public Student getStudentsById(Long id) {

        studentRepository.findById(id);

        return student;   // this should not return optional instead student
        // look in this method
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
    public List<Student> findPaginated(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Student> pagedResult =studentRepository.findAll(paging);

        return pagedResult.toList();
    }


//    public List<Student> findByName(String name)
//    {
//        return studentRepository.findByName(name);
//    }
//
//    public List<Student> findByNameLike(String name)
//    {
//        return studentRepository.findByNameLike(name);
//    }
}


