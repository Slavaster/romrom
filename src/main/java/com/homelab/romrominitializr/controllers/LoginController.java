package com.homelab.romrominitializr.controllers;

import com.homelab.romrominitializr.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String home(){
        return "views/user_profile.jsp";
    }


    @RequestMapping("/login")
    public String loginPage(){
        return "views/login.jsp";
    }

    @RequestMapping("/logout-success")
    public String logoutPage(){
        return "testAuth/logout.jsp";
    }



}
