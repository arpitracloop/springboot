package com.springboot.crud.entity;

import lombok.*;

import javax.persistence.*;

@Entity
//@Table
@Data
//@Getter  // use data in place of getter and setter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long Id;
    @Column
    private String Name;
    @Column
    private int Standard;
    @Column
    private long Contact;
    @Column
    private String Address;
    @Column
    private String Email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return Id == student.Id;
    }

    @Override
    public int hashCode() {
        return (int) (Id ^ (Id >>> 32));
    }
}
