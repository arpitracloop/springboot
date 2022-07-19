package com.springboot.crud.service;

import com.springboot.crud.dao.StudentDao;
import com.springboot.crud.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private StudentDao studentDao;

    List<Student> studentList;


    public List<Student> studentList(){
        studentList=new ArrayList<>();
        studentList.add(new Student(1,"Arpit",10,788676656,"Haridwar","arpit@racloop.com"));



        return studentList;
    }

    public List<Student> getStudentList()
    {

        studentList();

        return studentList;
    }

    public Student addStudent(Student student)
    {

        studentDao.save(student);
        return student;
    }

    public Student updateStudent(Student student)
    {
        studentList.forEach(e->
        {
            if(e.getId()==student.getId())
            {
                e.setName(student.getName());
                e.setStandard(student.getStandard());
                e.setAddress(student.getAddress());
                e.setContact(student.getContact());
                e.setEmail(student.getEmail());
            }
        });
        return student;
    }

    public Student deleteStudent(long parseLong) {
        studentDao.deleteById(parseLong);
        return null;

    }



}


