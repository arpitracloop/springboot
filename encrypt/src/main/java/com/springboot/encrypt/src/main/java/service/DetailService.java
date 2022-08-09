package com.springboot.encrypt.src.main.java.service;

import com.springboot.encrypt.src.main.java.model.Details;
import com.springboot.encrypt.src.main.java.repository.DetailRepository;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;

public class DetailService {

    public DetailRepository detailRepository;
    public List<Details> getDetails() {
        return detailRepository.findAll();
    }
    public static byte[] encrypt (byte[] plaintext, SecretKey key, byte[] IV ) throws Exception
    {
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        //Create IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(IV);

        //Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        //Perform Encryption
        byte[] cipherText = cipher.doFinal(plaintext);

        return cipherText;
    }

    public String encypt() {

    }

    public byte[] getBytes(String details) {
        byte [] change = details.getBytes();
        return change;
    }


    public String getChecksum(String data) {
        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            return bytesToHex(hash);
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public SecretKey getGeneratedKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);

        // Generate Key
        SecretKey key = keyGenerator.generateKey();

        return key;
    }

    private static String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash).toLowerCase();
    }

    public byte[] getGeneratedIv() {
        byte[] IV = new byte[16];
        SecureRandom random = new SecureRandom();
        return random.nextBytes(IV);


    }
}
