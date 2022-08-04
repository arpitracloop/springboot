package com.springboot.aes.controller;

import com.springboot.aes.model.Account;
import com.springboot.aes.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class AccountController {

@Autowired
 AccountService accountService;

    @PostMapping(value = "/getDetails")
    public Account getDetails(@RequestBody Account account) throws IOException {
        return accountService.encrypt(account);
    }

    @PostMapping("/decode")
    public String decode(@RequestBody Account account) {
        return accountService.decrypt(account);

    }
}