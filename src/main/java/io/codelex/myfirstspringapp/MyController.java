package io.codelex.myfirstspringapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/spring")
    public String getGreetingMessage() {
        return "Hello my fellow user!";
    }

}
