package com.security.user.controller;

import com.security.user.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {

    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal User userInfo) throws Exception {
        model.addAttribute("userInfo", userInfo);
        return "home";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }
}