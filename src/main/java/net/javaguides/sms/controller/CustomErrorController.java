package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomErrorController {

    @GetMapping("/403")
    public String accessDenied() {
        return "403"; // renders 403.html
    }
}
