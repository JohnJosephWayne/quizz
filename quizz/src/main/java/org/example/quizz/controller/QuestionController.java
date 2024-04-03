package org.example.quizz.controller;

import jakarta.servlet.http.HttpSession;
import org.example.quizz.model.Question;
import org.example.quizz.service.QuestionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class QuestionController {
    protected QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/quizz")
    public String showQuiz(HttpSession session, Model model) {
        if (session.getAttribute("username") == null) {
            return "redirect:/index";
        }
        try {
            List<Question> questions = questionService.getQuestions();
            model.addAttribute("questions");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/quizz";
    }
}