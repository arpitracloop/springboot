package com.springboot.crud.dto;

import com.springboot.crud.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentDto {

    private List<Student> students;
    private int currentPage;
    private int totalPage;
    private long totalElement;


}
