package com.springboot.encrypt.src.main.java.service;

import com.springboot.encrypt.src.main.java.model.Details;
import com.springboot.encrypt.src.main.java.model.FPSDetails;
import com.springboot.encrypt.src.main.java.repository.FPSDetailsRepository;
import org.springframework.stereotype.Service;

@Service
public class FPSDetailsService {
    FPSDetailsRepository fpsDetailsRepository;
    public String saveFpsDetails(FPSDetails fpsDetails) {
        fpsDetails.setShopId();
        fpsDetails.setFpsOwnerName();
        fpsDetails.setOrderNo();
        fpsDetails.setDetails();

    }
    public Iterable<Details> showFpsDetails()
    {
        return fpsDetailsRepository.findAll();
    }
}
