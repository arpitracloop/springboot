package com.springboot.crud.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private int standard;
    @Column
    private long contact;
    @Column
    private String address;
    @Column
    private String email;

}
