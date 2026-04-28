package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, 
                        @RequestParam String password, 
                        Model model) {
        Login user = loginService.log(username, password);
        if (user != null) {
            return "redirect:/welcome";
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }
}

