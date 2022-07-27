package com.springboot.webapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    private  AuthenticateService authenticateService =new AuthenticateService();


    @RequestMapping(value="login", method = RequestMethod.GET)
    public String gotoLoginPage()
    {
        return  "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model)
    {
        if(authenticateService.authenticate(name,password)) {
            model.put("name", name);
            model.put("password", password);

            //authentication
            //name=mojojojo
            //password=mojojojo

            return "welcome";
        }
        else return  gotoLoginPage();
    }


}
