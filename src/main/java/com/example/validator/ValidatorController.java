package com.example.validator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidatorController {

    @GetMapping(path = "/validation")
    public String toCheckLoginPasswordConfirmPassword
            (@RequestParam String login, @RequestParam String password, @RequestParam String confirmPassword) {
        try {
            ValidatorUtils.toCheckLoginPasswordConfirmPassword(login, password, confirmPassword);
            return "логин выполнен";
        } catch (Exception ex) {
            return ex.getMessage();
        }


    }


}
