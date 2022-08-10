package com.springboot.encrypt.src.main.java.model;

import com.springboot.encrypt.src.main.java.controller.FPSDetailsController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FPSDetails {

    private FPSDetailsController fpsDetailsController;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shopId;
    private String fpsOwnerName;
    private Long orderNo;

    @OneToMany
    private Details details;

}
