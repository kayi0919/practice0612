package org.prac.web.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;


@Controller
@Log4j2
public class LoginController {

    @Autowired
    LocaleResolver localeResolver;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/web/home")
    public String home() {
        return "home";
    }
}
