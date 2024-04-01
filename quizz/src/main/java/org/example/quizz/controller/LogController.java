package org.example.quizz.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("username")
public class LogController {

    @GetMapping("/")
    public String showLoginForm() {
        return "index";
    }

    @GetMapping("/index")
    public String authenticate(@RequestParam("username") String username, HttpSession session) {
        if (username != null && !username.isEmpty()) {
            session.setAttribute("username", username);
            return "redirect:/quizz";
        } else {
            return "redirect:/index";
        }
    }
}