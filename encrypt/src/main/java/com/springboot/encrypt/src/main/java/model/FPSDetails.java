package com.springboot.encrypt.src.main.java.model;

import com.springboot.encrypt.src.main.java.controller.FPSDetailsController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FPSDetails {

    @Autowired
    private FPSDetailsController fpsDetailsController;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long shopId;
    private String fpsOwnerName;
    private Long orderNo;

    @ManyToOne
    private Details details;

}
