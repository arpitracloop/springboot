package com.springboot.encrypt.src.main.java;

public class AES_Encryption
{
    static String plainText = "This is a plain text which need to be encrypted by AES Algorithm with CBC Mode";


    static String temp = "K1NlITwVST1hm6nW+SEqo+rfFASFLPUO29a+eG4eVqCZggqBRj8eq0GAsITT7Jc/edhge/X5+s78Z\n" +
            "7psm9d9BRyiZX2V1k3H/ctS8/pehibq+YjCxc7HmmOdMNk+AyUPnQpXt0ZPBRs4SYySPvUSBhEzh0n\n" +
            "x3frxdmgoBx2mwRk2Xb0TaT4HcU7KUvZ8HH3VyTHgs101dIBNWHwi/qj90A/tj+r4TttMsVtOz9bAI\n" +
            "YAUAx9VsjTyaw9VqjcyyyVCOhW9QSTcThyiODQdm/wwdSROTsWVy4YYO6eSTmVneN4wlkYtcG1LdW9\n" +
            "LjNjSmNHK+yowITiCkn61Cm59N7yygxyP2ZHV7f8sTHdQcgiTJ59R6H+LkiVegGiOobiTABJmviFfS\n" +
            "0tBSjHtEZEyGT4jmHKG0snfxRfbM4+ZUnnOcdoTKnEo46SuMfuZfdmr/DgKJWatAhCgNffBw+VFPRA\n" +
            "8N4yhVTm/G+asBsOHZA6F88I6NPcY3dDrr6nSKl/u7YGYsPAILqMXk2sp7kRjwsFMfPbZqITKUCrbo\n" +
            "nZE4nARVp33Edop05f44fRjUd+kWOa7K/mcigj2F1xFywx74ruLCGNyY784HJ4ce5bL30Jfq5Rrpzj\n" +
            "oxRuj+f/FRr+3U3LXLhD534Q+0PyRKKpXZ1u93XLRxv3nJfdcaJ0DQX2c8LjUJd+ZM4vTr5yB5M2lK\n" +
            "Mn/jo7QmbyAx1bSakiaxfVTwtiYrEY2GtFJjFbLxPHLU7Jf9Uplnmlnfil5DAyEbsFachMc8nvs+XD\n" +
            "ohGUZvUP1eo7FgzDeWPc2eltLXvulN7sow3oMnzLdGPffX0dcdVrhHhrNwhp4JRQBXEpggCNdOB7ea\n" +
            "Ou9ReYcbkiD96xoDYoL7rhxl7NtCbmjfGbIn8aBAV/hQTni3Qh4iyg3H+XlsKObWApngkZ7QK9kQsb\n" +
            "jfUZzud6Wl2lE0TlK/WWh9yLuMgoIP+jMSTmqu18VFmkasTx7bYAqEPGwC0p/mBxdij3AxfMHS5XtC\n" +
            "Wuj1aXAGi7s9+QP3T3hJZH1CvTY5QVTXgpmIowSvEywYWO6MCZeABq2Et7gSMbOrBIUVn01EBp5KLC\n" +
            "ZX/czqvQvdL3m5cuxG9K9WyMpjKxu/iulOz2kLM6KkbdO/nvEhHrlP41A6LKXbCvDSdTZAephiuqaN\n" +
            "uEk8TVt6TgxbMvTE8LmfCl/Z7TYiM4VFDBsDxiudh7932cmk0bR48GCBkiTKTxMHQi5KCClb+8sP3N\n" +
            "h+lh4CYS9NVx+j7ybYUvzyW1T+7axHjfpMGkpGCTNnCzo6rOQiuAxbfpxx7HbLnViUzY+J7gF0xRFb\n" +
            "bqtwoapQPRTLkXvca60wzrBqv5EKoGE7OnJutnAuROnX2msmkxgx9UWIj6J4NPYC6fIgKEwEMvGa0q\n" +
            "igqZi0ioD6su0lWf/4OcnjMjFD59vcw/Pc9PecUqPn17OfjFBwoX9Gp4RBgbDDCij9DOCW3tvzqpxu\n" +
            "QVtLQUrX2uNTJTLR0YWNvr7UFyEmbTa5x/uOIotGkTwNWq8JKbgjaIFIPhNbprH+6h0pQtif8GjA0m\n" +
            "fA8IJ2PBxg7N9oTiTDqJDlKH/+zFi6TDOJPa7YtMFpxww93l6voLuiVTk7oJ2Hh+BkiNDBWis1FJ5A\n" +
            "zYS36JwUstm7T/x6njXVmMSn7nGG//C6bNWOj2K7zZ0ISrfTZZx/CXmkvUvkAlQnYLxRADaplK4oUB\n" +
            "fl+7/f+tM7ZLUn+pwENYFu9UX8582pnXtxQviziz64J6NHfSOmLkUKJm1bqjhBhTflk05gucqXjXVf\n" +
            "Sa7FKjA+q+7+Djqb8mjmfsQs/vGc0N0Vp20lQ0LYCQqZ5JYDfYgH2PIx8F0tMArAW7FQ4UwACsZu81\n" +
            "/uEKy0Td/3r3zOrBUeI+hjE870tVwd3G6rtAIsvlcsfAoWOn/";
    public static void main(String[] args) throws Exception
    {
//        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
//        keyGenerator.init(128);
//
//        // Generate Key
//        SecretKey key = keyGenerator.generateKey();

        // Generating IV.
//        byte[] IV = new byte[16];
//        SecureRandom random = new SecureRandom();
//        random.nextBytes(IV);

//        System.out.println("Original Text  : "+plainText);
//
//        byte[] cipherText = encrypt(plainText.getBytes(),key, IV);
//        System.out.println("Encrypted Text : "+Base64.getEncoder().encodeToString(cipherText) );

//        String decryptedText = decrypt(temp.getBytes(),key, IV);
//        System.out.println("DeCrypted Text : "+decryptedText);

//        String md5Hash = getMD5Hash(temp);
//        System.out.println("Checksum : "+md5Hash);

    }
//    private static String getMD5Hash(String data) {
//        String result = null;
//        try {
//            MessageDigest digest = MessageDigest.getInstance("MD5");
//            byte[] hash = digest.digest(data.getBytes("UTF-8"));
//            return bytesToHex(hash);
//        }catch(Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }

//    private static String getSHA256Hash(String plainText) {
//        String result = null;
//        try {
//            MessageDigest digest = MessageDigest.getInstance("SHA-256");
//            byte[] hash = digest.digest(temp.getBytes("UTF-8"));
//            return bytesToHex(hash);
//        }catch(Exception ex) {
//            ex.printStackTrace();
//        }
//        return result;
//    }
//    private static String  bytesToHex(byte[] hash) {
//        return DatatypeConverter.printHexBinary(hash).toLowerCase();
//    }
//
//    public static byte[] encrypt (byte[] plaintext,SecretKey key,byte[] IV ) throws Exception
//    {
//        //Get Cipher Instance
//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//
//        //Create SecretKeySpec
//        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
//
//        //Create IvParameterSpec
//        IvParameterSpec ivSpec = new IvParameterSpec(IV);
//
//        //Initialize Cipher for ENCRYPT_MODE
//        cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
//
//        //Perform Encryption
//        byte[] cipherText = cipher.doFinal(plaintext);
//
//        return cipherText;
//    }
//

//    public static String decrypt (byte[] cipherText, SecretKey key,byte[] IV) throws Exception
//    {
//        //Get Cipher Instance
//        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//
//        //Create SecretKeySpec
//        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
//
//        //Create IvParameterSpec
//        IvParameterSpec ivSpec = new IvParameterSpec(IV);
//
//        //Initialize Cipher for DECRYPT_MODE
//        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
//
//        //Perform Decryption
//        byte[] decryptedText = cipher.doFinal(cipherText);
//
//        return new String(decryptedText);
//    }
}