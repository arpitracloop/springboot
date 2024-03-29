package com.springboot.encrypt.src.main.java.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String districtName;
    private String groupId;
    private Long lastConsignee;

    @OneToMany
    private List<FPSDetails> fpsDetails;

}
