package com.springboot.encryptiondecryptionworking.model;

import lombok.Data;

@Data
public class EncDecModel {
    private String Token;
    private String Data;
    private String Checksum;

    public EncDecModel(String token, String data, String checksum) {
        Token = token;
        Data = data;
        Checksum = checksum;
    }
}
