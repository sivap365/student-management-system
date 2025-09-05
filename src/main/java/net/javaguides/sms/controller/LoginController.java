package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";  // Will render login.html from templates
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied"; // You can create access-denied.html
    }
}
