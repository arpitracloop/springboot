package com.springboot.decryption.controller;

import com.springboot.decryption.service.DecryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@RestController
public class DecryptController {

    @Autowired
    DecryptService decryptService;
    @GetMapping("/decrypt")
    public String getDecrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        return decryptService.Decryption();
    }
}
