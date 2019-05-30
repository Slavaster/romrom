package com.homelab.romrominitializr.controllers;

import com.homelab.romrominitializr.Skill;
import com.homelab.romrominitializr.User;
import com.homelab.romrominitializr.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    UserRepo userRepo;

    @PostMapping("/profile/update")
    public void updateUser(@RequestParam("name") String name,
                           @RequestParam("surname") String surname,
                           @RequestParam("city") String city,
                           @RequestParam("birth_date") Date birth_date,
                           @RequestParam("email") String email,
                           @RequestParam("phone") String phone){
        System.out.println("Go through /profile/update");

    }

    @RequestMapping("/profile")
    public ModelAndView loginSubmit(User user){
        System.out.println("Go through /profile");
        List<User> foundUsers = userRepo.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if( foundUsers.size()==1){

            Map<String, Object> userMap = new HashMap<>();
            userMap.put("name", foundUsers.get(0).getUserInformation().getName());
            userMap.put("surname", foundUsers.get(0).getUserInformation().getSurname());
            userMap.put("city", foundUsers.get(0).getUserInformation().getCity());
            userMap.put("birth_date", foundUsers.get(0).getUserInformation().getBirthDate());
            userMap.put("phone", foundUsers.get(0).getUserInformation().getPhoneNumber());
            userMap.put("email", foundUsers.get(0).getUserInformation().getEmailAddress());
            userMap.put("skills", foundUsers.get(0).getSkills().stream().map(Skill::toString).collect(Collectors.joining(",")));
            return new ModelAndView("/WEB-INF/views/user_profile.jsp", userMap);
        }

        return new ModelAndView("/pages/errorPage.jsp");
    }

}
