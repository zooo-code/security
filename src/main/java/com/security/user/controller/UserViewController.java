package com.security.user.controller;

import com.security.user.entity.User;
import com.security.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final UserService userService;
    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal User userInfo) {

        if (userInfo == null){
            return "home";
        }
        model.addAttribute("userInfo", userInfo);
        return "loginHome";
    }
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }
    @PostMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("AddUserRequest",new AddUserRequest());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(AddUserRequest request) {
        userService.save(request);
        log.info("{}",request.getEmail());
        log.info("{}",request.getPassword());
        return "redirect:/";
    }
}