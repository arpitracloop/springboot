package com.springboot.encrypt.src.main.java.controller;

import com.springboot.encrypt.src.main.java.model.Details;
import com.springboot.encrypt.src.main.java.model.FPSDetails;
import com.springboot.encrypt.src.main.java.service.FPSDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FPSDetailsController {

    private FPSDetailsService fpsDetailsService;

    @PostMapping("/setFpsDetails")
    public String fpsDetails(@ModelAttribute("fpsDetails") FPSDetails fpsDetails)
    {
        return fpsDetailsService.saveFpsDetails(fpsDetails);
    }

    @GetMapping("/showFpsDetails")
    public Iterable<Details> showFpsDetails()
    {
        return fpsDetailsService.showFpsDetails();
    }

}
