package com.springboot.encryptiondecryptionworking.dto;

import lombok.Data;

@Data
public class PayloadDto {

    private String month;
    private String year;
    private String scheme;
    private String ipadd;
    private String commodity;

    public PayloadDto(String month, String year, String scheme, String ipadd, String commodity) {
        this.month = month;
        this.year = year;
        this.scheme = scheme;
        this.ipadd = ipadd;
        this.commodity = commodity;
    }
}
