package com.springboot.user.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    private String firstName;
    private String secondName;
    private long contact;
    private String Address;
    private Date DOB;
    private String email;
    private String password;
    @ManyToMany
    private Collection<Role> roles;
}
