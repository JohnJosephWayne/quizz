package org.example.quizz.controller;

import jakarta.servlet.http.HttpSession;
import org.example.quizz.model.Question;
import org.example.quizz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;


@Controller
public class LogController {

    int id = 0;

    private QuestionService questionService;

    @Autowired
    public LogController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping("/accueil")
    public String showLoginForm() {
        return "index";
    }

    @GetMapping("/log")
    public String authenticate(Model model, HttpSession session,@RequestBody String username) throws IOException {
        if (username != null && !username.isEmpty()) {
            model.addAttribute("username", username);
            model.addAttribute("questions", questionService.getQuestions());
            session.setAttribute("username", username);
            session.setAttribute("questions", questionService.getQuestions());
        }
        return "quizz";
    }

    @GetMapping("/quizz")
    public String showNextQuestion(Model model) throws IOException {
//        if (!model.containsAttribute("username")) {
//            return "index";
//        }
//        if (id < 0 || id >= questionService.getQuestions().size()) {
////             Redirection vers une page de fin ou de résumé s'il n'y a plus de questions
//            return "end";
        for (Question question : questionService.getQuestions()) {
            if (question.getId() == id) {
                model.addAttribute("question", question);
            }
        }
        return "quizz";
    }
}
