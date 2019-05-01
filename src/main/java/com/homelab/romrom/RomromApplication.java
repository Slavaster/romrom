package com.homelab.romrom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RomromApplication {

    public static void main(String[] args) {
        SpringApplication.run(RomromApplication.class, args);
    }

    @RequestMapping("/greeting")
    public String greeting(){
        return "Hello, mazafaka!";
    }

}
