package com.springboot.encrypt.src.main.java.service;

import com.springboot.encrypt.src.main.java.model.FPSDetails;
import com.springboot.encrypt.src.main.java.repository.FPSDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FPSDetailsService {

    @Autowired
    FPSDetailsRepository fpsDetailsRepository;

    public FPSDetails saveFpsDetails(FPSDetails fpsDetails) {
        fpsDetails.setShopId(fpsDetails.getShopId());
        fpsDetails.setFpsOwnerName(fpsDetails.getFpsOwnerName());
        fpsDetails.setOrderNo(fpsDetails.getOrderNo());

        return fpsDetailsRepository.save(fpsDetails);

    }
    public Iterable<FPSDetails> showFpsDetails()
    {
        return fpsDetailsRepository.findAll();
    }
}
