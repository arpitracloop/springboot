package com.springboot.encrypt.src.main.java.controller;

import com.springboot.encrypt.src.main.java.model.Details;
import com.springboot.encrypt.src.main.java.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class DetailController {

    @Autowired
    public DetailService detailService;

    @GetMapping("/details")
    public List<Details> getDetails()
    {
        return detailService.getDetails();
    }

    @PostMapping("/setDeatails")
    public Details setDetails(@RequestBody Details details)
    {
        return detailService.addDetails(details );
    }

    public byte[] getBytes(String details)
    {
        return detailService.getBytes(details);
    }

    @GetMapping("/encryptedDetails")
    public byte[] getEncryptedDetails( ) throws Exception {
        return detailService.encrypt();
    }

    @GetMapping("/decrypt")
    public String getDecryptedDetails()throws Exception {
        return detailService.decrypt();
    }

    public String getChecksum(String details)
    {
        return detailService.getChecksum(details);
    }

    public SecretKey generateKey() throws NoSuchAlgorithmException {
        return detailService.getGeneratedKey();
    }

    public byte[] ivGenerator()
    {
        return detailService.getGeneratedIv();
    }
}
