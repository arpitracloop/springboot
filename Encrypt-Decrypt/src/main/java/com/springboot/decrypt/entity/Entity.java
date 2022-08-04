package com.springboot.decrypt.entity;

import lombok.Data;

import javax.crypto.SecretKey;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table
public class Entity implements SecretKey {

    @Id
    private int id;
    private String cipherText;

    @Override
    public String getAlgorithm() {
        return null;
    }

    @Override
    public String getFormat() {
        return null;
    }

    @Override
    public byte[] getEncoded() {
        return new byte[0];
    }
}
