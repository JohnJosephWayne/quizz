package org.example.quizz.controller;

import jakarta.servlet.http.HttpSession;
import org.example.quizz.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class LogController {

    protected User user;

    @GetMapping("/login")
    public String showLoginForm() {
         return "/index";
    }

    @GetMapping ("/index")
    public String authenticate(@RequestParam("username") String username, HttpSession session) {
        if (username != null && !username.isEmpty()) {
            session.setAttribute("username", username);
            return "/quizz";
        } else {
            return "/login";
        }
    }
}