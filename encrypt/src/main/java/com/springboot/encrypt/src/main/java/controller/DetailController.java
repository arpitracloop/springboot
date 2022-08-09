package com.springboot.encrypt.src.main.java.controller;

import com.springboot.encrypt.src.main.java.model.Details;
import com.springboot.encrypt.src.main.java.service.DetailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class DetailController {

    public DetailService detailService;

    @GetMapping("/details")
    public List<Details> getDetails()
    {
        return detailService.getDetails();
    }

    public byte[] getBytes(String details)
    {
        return detailService.getBytes(details);
    }

    @GetMapping("/encryptedDetails")
    public String getEncryptedDetails(, SecretKey key, byte[] IV )
    {
        return detailService.encrypt(byte[] plaintext, SecretKey key, byte[] IV );
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
