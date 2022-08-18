package com.springboot.encryptiondecryptionworking.controller;

import com.springboot.encryptiondecryptionworking.srevice.EncDecService;
import lombok.extern.slf4j.Slf4j;
import org.kopitubruk.util.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.ws.rs.BeanParam;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
@Slf4j
@Controller
public class EncDec {
    @Autowired
    EncDecService encDecService;

    @PostMapping("/decrypt")
    public void decrypt(@BeanParam String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, IOException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException {
        encDecService.decrypt(cipherText);
    }

//    @PostMapping("/encrypt/{text}")
//    public String encrypt(String text) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, IOException, InvalidKeyException {
//        return encDecService.encrypt(text);
//    }

    @GetMapping("/getChecksum")
    public String getChecksum(@BeanParam String text) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return encDecService.getCheckSum(text);
    }

    @PostMapping("/createData")
    public void createData() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, JSONException {
        encDecService.createData();
    }

    @PostMapping("/createPayload")
    public void createPayload() throws SocketException, UnknownHostException {
        encDecService.createPayload("1","W");
    }
}
