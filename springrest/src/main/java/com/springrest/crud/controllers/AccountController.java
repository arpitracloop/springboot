package com.springrest.crud.controllers;

import com.springrest.crud.entities.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

//
//    @Autowired
//    private AccountService accountService;


    //get account number
    @GetMapping("/accountnumber")
    public List<Account> getAccount_number()
    {
        return null;
        //return this.accountService.getAccount_number();

    }



}
