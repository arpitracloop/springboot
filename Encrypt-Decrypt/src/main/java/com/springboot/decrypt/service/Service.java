package com.springboot.decrypt.service;

import lombok.Value;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;

@org.springframework.stereotype.Service
public class Service {
    @Value("${cypherText.data}")
    private static String cypherText;

    public static  final String ALGO = "AES";
    private static final byte[] secretKey = new byte[16];

    public static String decrypt () throws Exception
    {
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance(ALGO);

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(cypherText);

        //Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptData = Base64.getDecoder().decode(cypherText);

        //Perform Decryption
        byte[] decryptedText = cipher.doFinal(decryptData);

        return new String(decryptedText);
    }
}
    public String decrypt(Entity entity) {
        try {
            Key key = new SecretKeySpec(secretKey, ALGO);
            Cipher c = Cipher.getInstance(ALGO);
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedMobile = Base64.getDecoder().decode(qrDetails.getMobile());
            log.info("@@@@@"+ Arrays.toString(decodedMobile));
            byte[] decValue = c.doFinal(decodedMobile);

            String decryptedValue = new String(decValue);
            log.info(decryptedValue);

            byte[] decodedCoupon = Base64.getDecoder().decode(qrDetails.getCouponCode());
            byte[] decCode = c.doFinal(decodedCoupon);
            String decryptedData = new String(decCode);
            log.info(decryptedData);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        Repository.save(qrDetails);
        return "decrypted";
    }

    public static Key generateKey(){
        return new SecretKeySpec(keyValue, ALGO);
    }
//    Cipher cipher = Cipher.getInstance("AES");
//    cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//    String decrypted =cipher.doFinal(cipher);
//    return decrypted;

}


