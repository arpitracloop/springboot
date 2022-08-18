package com.springboot.encrypt.src.main.java.service;

import com.springboot.encrypt.src.main.java.model.Details;
import com.springboot.encrypt.src.main.java.model.FPSDetails;
import com.springboot.encrypt.src.main.java.repository.DetailRepository;
import com.springboot.encrypt.src.main.java.repository.FPSDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;

@Service
public class DetailService {

    @Autowired
    public static DetailRepository detailRepository;


//    @Autowired
//    public FPSDetailsRepository fpsDetailsRepository;

    //

    //

    public Details addDetails(Details details){
        details.setGroupId(details.getGroupId());
        details.setDistrictName(details.getDistrictName());
        details.setLastConsignee(details.getLastConsignee());
        detailRepository.save(details);
        return details;
    }

    public FPSDetails findByLastConsignee(Long lastConsignee)
    {
            detailRepository.findById(lastConsignee).map(details->{
   //             fpsDetailsRepository.findAllById(lastConsignee);
              return fpsDetailsRepository.findAllById(Collections.singleton(lastConsignee));
//                fpsDetails.setFpsOwnerName(fpsDetails.getFpsOwnerName());
//                fpsDetails.setOrderNo(fpsDetails.getOrderNo());
//                fpsDetails.setDetails(details);
         //       return fpsDetailsRepository.save(lastConsignee);
        });

        return null;
    }

    public static List<Details> getDetails() {
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

        // converting list to byte[] array
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
        try{
            oos = new ObjectOutputStream(baos);
            oos.writeObject(getDetails());
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        byte[] byteArray = baos.toByteArray();

        //Perform Encryption
        byte[] cipherText = cipher.doFinal(byteArray);

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
        byte[] decryptedText = cipher.doFinal(encrypt());  // encrypt() will return ciphertext

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


}
