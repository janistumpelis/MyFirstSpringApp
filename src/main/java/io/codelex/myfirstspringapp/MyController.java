package io.codelex.myfirstspringapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class MyController {

    @RequestMapping("/spring")
    public String getGreetingMessage() {
        return "Hello my fellow user!";
    }

    @RequestMapping("/spring/divide")
    public int divide(@RequestParam(value = "divider") int x) {
       try {
           return 1000 / x;
       } catch (ArithmeticException ex) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Kļūda veicot aprēķinu", ex);
       }
    }

}
