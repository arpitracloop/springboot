package com.springboot.aes.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Account  {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountNumber;
    private String name;
    private String branch;
    private String ifsc;
    private String balance;


    @Override
    public String toString() {
        return "Account{" +
                "balance='" + balance + '\'' +
                '}';
    }




}
