package com.springboot.crud.entity;

import javax.persistence.*;

@Entity
@Table
public class Student {

    @Id
    @Column
    private long Id;
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

    public Student(long id, String name, int standard, long contact, String address, String email) {
        Id = id;
        Name = name;
        Standard = standard;
        Contact = contact;
        Address = address;
        Email = email;
    }

    public Student() {
    }

    public  long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStandard() {
        return Standard;
    }

    public void setStandard(int standard) {
        Standard = standard;
    }

    public  long getContact() {
        return Contact;
    }

    public void setContact(long contact) {
        Contact = contact;
    }

    public  String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public  String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Standard=" + Standard +
                ", Contact=" + Contact +
                ", Address='" + Address + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }

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
