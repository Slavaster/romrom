package com.homelab.romrominitializr.controllers;

import com.homelab.romrominitializr.repositories.UserRepo;
import com.homelab.romrominitializr.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserRepo userRepo;

    @GetMapping("login")
    public String loginForm() {
        return "login.html";
    }

    @PostMapping("login")
    public String loginSubmit(User user){

        if( userRepo.findByLoginAndPassword(user.getLogin(), user.getPassword()).size()>0) return "/pages/mailForm.jsp";

        return "/pages/errorPage.jsp";
    }


}
