package com.springboot.crud.controller;

import com.springboot.crud.entity.JwtRequest;
import com.springboot.crud.entity.JwtResponse;
import com.springboot.crud.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate","/AUTHENTICATE"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{

        return jwtService.createJwtToken(jwtRequest);
    }


}
