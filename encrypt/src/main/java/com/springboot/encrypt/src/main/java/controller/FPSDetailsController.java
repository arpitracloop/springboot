package com.springboot.encrypt.src.main.java.controller;

import com.springboot.encrypt.src.main.java.model.FPSDetails;
import com.springboot.encrypt.src.main.java.service.DetailService;
import com.springboot.encrypt.src.main.java.service.FPSDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FPSDetailsController {

    @Autowired
    private FPSDetailsService fpsDetailsService;
    private DetailService detailService;


    @PostMapping("/details/{lastConsignee}/fpsDetails")
    public FPSDetails setFpsDetails(@PathVariable(value = "lastConsignee") Long lastConsignee, @RequestBody FPSDetails fpsDetails)
    {
        return detailService.findByLastConsignee(lastConsignee);
    }

    @PostMapping("/setFpsDetails")
    public FPSDetails fpsDetails(@ModelAttribute("fpsDetails") FPSDetails fpsDetails)
    {
        return fpsDetailsService.saveFpsDetails(fpsDetails);
    }

    @GetMapping("/showFpsDetails")
    public Iterable<FPSDetails> showFpsDetails()
    {
        return fpsDetailsService.showFpsDetails();
    }


}
