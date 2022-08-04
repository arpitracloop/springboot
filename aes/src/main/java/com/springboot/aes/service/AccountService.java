package com.springboot.aes.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.aes.model.Account;
import com.springboot.aes.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;
import java.util.Base64;

@Service
@Slf4j
public class AccountService {

    @Autowired
     AccountRepository accountRepository;
    private static final byte[] keyValue = {'m','o','j','o','j','o','j','o'};

    public Account encrypt(Account account) throws JsonProcessingException {

        account.setAccountNumber(account.getAccountNumber());
        account.setBranch(account.getBranch());
        account.setIfsc(account.getIfsc());
        account.setName(account.getName());
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encBal = cipher.doFinal(account.getBalance().getBytes(StandardCharsets.UTF_16));
            String encodedBalance = Base64.getEncoder().encodeToString(encBal);
            account.setBalance(encodedBalance);

        } catch (Exception e) {
            log.error(e.getMessage());
        }


        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(account.toString());
        log.info(jsonString);
        return accountRepository.save(account);
    }

    public String decrypt(Account account) {
        try {
            Key key = new SecretKeySpec(keyValue, "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, key);
            byte[] decodedBalance = Base64.getDecoder().decode(String.valueOf(account.getBalance()));
            log.info("" + Arrays.toString(decodedBalance));
            byte[] decValue = c.doFinal(decodedBalance);

            String decryptedValue = new String(decValue);
            log.info(decryptedValue);

        } catch (Exception e) {
            log.error(e.getMessage());
        }
        accountRepository.save(account);
        return "decrypted";
    }

    public static Key generateKey() {
        return new SecretKeySpec(keyValue, "AES");
    }
}