package com.springboot.encryptiondecryptionworking.dto;


import lombok.Data;

@Data
public class Header {

    private String status;
    private String message;
    private String month;
    private String year;
    private String scheme;
    private String commodity;
}
