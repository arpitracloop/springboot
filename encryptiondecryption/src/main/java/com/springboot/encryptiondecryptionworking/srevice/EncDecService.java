package com.springboot.encryptiondecryptionworking.srevice;

import com.springboot.encryptiondecryptionworking.dto.OutputDTO;
import com.springboot.encryptiondecryptionworking.dto.PayloadDto;
import com.springboot.encryptiondecryptionworking.model.EncDecModel;
import com.springboot.encryptiondecryptionworking.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.kopitubruk.util.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
@Slf4j
@Service
public class EncDecService {

    @Value("${token}")
    private String token;

    @Value("${url}")
    private String url;

    @Autowired
    RestTemplate restTemplate;


 /*       private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public byte[] encrypt (String text ) throws Exception
    {

        byte[] pwdBytes = getFilesPath();
        byte[] keyBytes = new byte[16];
        int len = pwdBytes.length;
        //Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //Create SecretKeySpec
        SecretKeySpec keySpec = new SecretKeySpec(pwdBytes, "AES");

        //Create IvParameterSpec
        IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);

        //Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE,keySpec, ivSpec);

        //Perform Encryption
        byte[] cipherText = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));

        return cipherText;
    }


    public void decrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher=  Cipher.getInstance(TRANSFORMATION);

*//*        byte[] encryptedData = Convert.FromBase64String(textToDecrypt);
        byte[] pwdBytes = getFilesPath();
        byte[] keyBytes = new byte[16];
        int len = pwdBytes.Length;*//*

        //byte[] name = Base64.getEncoder().encode("hello World".getBytes());
        byte[] decodedString = Base64.getDecoder().decode(new String(textToDecrypt).getBytes("UTF-8"));
        byte[] pwdBytes = getFilesPath();
        byte[] keyBytes = new byte[16];
        int len = pwdBytes.length;
*//*
        if (len > keyBytes.Length)
            len = keyBytes.Length;
        Array.Copy(pwdBytes, keyBytes, len);
        rijndaelCipher.Key = keyBytes;
        rijndaelCipher.IV = keyBytes;
        byte[] plainText = rijndaelCipher.CreateDecryptor().TransformFinalBlock(encryptedData, 0,
        encryptedData.Length);
        return Encoding.UTF8.GetString(plainText);*//*

        if(len>keyBytes.length){
            len=keyBytes.length;

            IvParameterSpec iv = new IvParameterSpec(keyBytes);
            //cipher.init(Cipher.DECRYPT_MODE, keyBytes, iv);
            byte[] plainText = cipher.doFinal(Base64.getDecoder()
                    .decode(textToDecrypt));
            String result= new String(plainText);
            System.out.println(result);
        }

    }




    public String getCheckSum (String text) throws UnsupportedEncodingException {
        byte[] utf8 = text.getBytes("UTF8");

        StringBuilder hex= new StringBuilder(utf8.length*2);
        byte b =0;
        for (byte b1 : utf8) {
            b=b1;
            hex.append(String.format("%02x", b1));
        }


        return hex.toString();
    }*/

    public void createData() throws IOException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException, JSONException {

        String payLoad = createPayload("1","W");
        String encryptedPayload = encrypt(payLoad);
        String checkSum= getCheckSum(payLoad);


        if(restTemplate!=null){

//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("Token", token);
//            jsonObject.put("Data", encryptedPayload);
//            jsonObject.put("Checksum", checkSum);
//            HttpEntity<String> request = new HttpEntity<String>(jsonObject.toString(), headers);
            EncDecModel encDecModel = new EncDecModel( token, encryptedPayload, checkSum);
            OutputDTO output = restTemplate.postForObject(url, encDecModel, OutputDTO.class);  //creates a new resource by posting an object to the given URI template.
            //String result = JsonUtils.serializeAsJson(output);
            if(output.getHeader().getStatus().equalsIgnoreCase("1")){
                //log.info(output.getDetails());
                decrypt(output.getDetails());
                encrypt(output.getDetails());
            }

            /*
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject JsonObjectStudent = new JSONObject();
            JsonObjectStudent.put("Token", token);
            JsonObjectStudent.put("Data", encryptedPayload);
            JsonObjectStudent.put("Checksum", checkSum);

            //HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(JsonObjectStudent,headers);

         ResponseEntity<String> output=   restTemplate.exchange(url, HttpMethod.POST,entity,String.class);

         decrypt(output.toString());

           */ }

    }

    public String createPayload(String scheme, String commodity) throws UnknownHostException, SocketException {

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int currentMonth=0;
        String financialYear="";
        if(month<3 || month==3){
            currentMonth= month+9;
            int firstYear= year-1;
            financialYear= String.valueOf(firstYear)+"-"+String.valueOf(year).substring(2,4);

        }
        else{
            currentMonth=month-3;
            int lastYear= year+1;
            financialYear= String.valueOf(year)+"-"+String.valueOf(lastYear).substring(2,4);
        }

        DecimalFormat formatter = new DecimalFormat("00");
        String currentMonthFormatted = formatter.format(currentMonth);
/*        String ip ="";
        try(final DatagramSocket socket = new DatagramSocket()){
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
             ip = socket.getLocalAddress().getHostAddress();
        }*/

        InetAddress addr = InetAddress.getLocalHost(); // provides methods to get IP of hostname
        String IP= addr.getHostAddress();
        log.info(IP);

        PayloadDto payloadDto = new PayloadDto(currentMonthFormatted, financialYear, scheme, IP, commodity);
        /*String payload="{\n" +
                "    \"month\": \""+currentMonthFormatted+"\",\n" +
                "    \"year\": \""+financialYear+"\",\n" +
                "    \"scheme\": \""+scheme+"\",\n" +
                "    \"ipadd\": \""+IP+"\",\n" +
                "    \"commodity\": \""+commodity+"\"\n" +
                "  }";*/
        String payload = JsonUtils.serializeAsJson(payloadDto);
        log.info(payload);
        return payload;
    }

    public String encrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, IOException {

        byte[] keyBytes = new byte[16];
        byte[] b = getFilesPath();
        int len = b.length;
        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);

        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(keyBytes);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, iv);
        byte[] cipherText = cipher.doFinal(input.getBytes());
        String encryotedString = Base64.getEncoder()
                .encodeToString(cipherText);
        log.info("Encrypted Data  = \n" + encryotedString);
        return encryotedString;
    }

    public void decrypt(String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException, IOException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] keyBytes = new byte[16];
        byte[] b = getFilesPath();
        int len = b.length;
        if (len > keyBytes.length) {
            len = keyBytes.length;
        }
        System.arraycopy(b, 0, keyBytes, 0, len);   //copies an array from the specified source array, beginning at the specified position,
        // to the specified position of the destination array

        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        IvParameterSpec iv = new IvParameterSpec(keyBytes);
        cipher.init(Cipher.DECRYPT_MODE, key, iv);
        byte[] plainText = cipher.doFinal(Base64.getDecoder()
                .decode(cipherText));
        String s = new String(plainText);
        log.info("\nDecrypted Data = \n" + s);
        getCheckSum(s);
    }

    public byte[] getFilesPath() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        File file = new File(classLoader.getResource("key-path").getFile());
        FileInputStream fl = new FileInputStream(file);
        byte[] arr = new byte[(int) file.length()];
        fl.read(arr);
        fl.close();
        return arr;
    }

    public String getCheckSum(String str1) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");  // MD are secure one way hash functions
        byte[] array = messageDigest.digest(str1.getBytes("UTF-8"));
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : array) {
            stringBuilder.append(String.format("%02X", b));
        }
        String checkSum = stringBuilder.toString().toLowerCase();
        log.info("\nCheckSum = \n" + checkSum);
        return checkSum;
    }
}
