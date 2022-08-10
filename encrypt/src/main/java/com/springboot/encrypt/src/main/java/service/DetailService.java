package com.springboot.encrypt.src.main.java.service;

import com.springboot.encrypt.src.main.java.model.Details;
import com.springboot.encrypt.src.main.java.model.FPSDetails;
import com.springboot.encrypt.src.main.java.repository.DetailRepository;
import com.springboot.encrypt.src.main.java.repository.FPSDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    public DetailRepository detailRepository;
    public FPSDetails fpsDetails;
    public FPSDetailsRepository fpsDetailsRepository;

    //

    //

    public Details addData(Details details){
        details.setGroupId(details.getGroupId());
        details.setDistrictName(details.getDistrictName());
        details.setLastConsignee(details.getLastConsignee());

    }

    public FPSDetails findByLastConsignee(Long lastConsignee)
    {
        return detailRepository.findById(Long lastConsignee).map(details->{
            fpsDetails.setShopId(lastConsignee),
            fpsDetails.setFpsOwnerName(),
            fpsDetails.setOrderNo(lastConsignee);
            fpsDetails.setDetails(details);
            return fpsDetailsRepository.save(fpsDetails);
        });

    }

    public List<Details> getDetails() {
        return detailRepository.findAll();
    }
    public static byte[] encrypt () throws Exception
    {
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(getGeneratedKey().getEncoded(), "AES");

        //Create IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(getGeneratedIv());

        //Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        //Perform Encryption
        byte[] cipherText = cipher.doFinal();

        return cipherText;
    }
    public static String decrypt () throws Exception
    {
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(getGeneratedKey().getEncoded(), "AES");

        //Create IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(getGeneratedIv());

        //Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        //Perform Decryption
        byte[] decryptedText = cipher.doFinal(cipherText);

        return new String(decryptedText);
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

    public static SecretKey getGeneratedKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);

        // Generate Key
        SecretKey key = keyGenerator.generateKey();

        return key;
    }

    private static String  bytesToHex(byte[] hash) {
        return DatatypeConverter.printHexBinary(hash).toLowerCase();
    }

    public static byte[] getGeneratedIv() {
        byte[] IV = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(IV);
        return IV;


    }

    public Details saveDetails(Details details) {
        return detailRepository.save(details);
    }
}
