package com.springboot.crud.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private String userName;
    @Column
    private String email;
    @Column
    private String userPassword;
    @Column
    private Boolean del;
    @Column
    @NotNull
    @Size(max=10,min = 10)
    private Long parentContact;

}
