package com.springboot.decrypt.controller;

import com.springboot.decrypt.entity.Entity;
import com.springboot.decrypt.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller  {

    Entity entity;
    @Autowired
    public Service service;

    @GetMapping("/decrypt")
    public String decryption() throws Exception
    {
        return "";
      //  return service.Decrypt();
    }
}
