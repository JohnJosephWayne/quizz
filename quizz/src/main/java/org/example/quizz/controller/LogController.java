package org.example.quizz.controller;

import jakarta.servlet.http.HttpSession;
import org.example.quizz.model.Question;
import org.example.quizz.service.QuestionService;
import org.example.quizz.service.QuizzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.List;


@Controller
public class LogController {

    int id = 0;


    private QuestionService questionService;
    private QuizzService quizzService;

    @Autowired
    public void QuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    public void QuizzService(QuizzService quizzService) {
        this.quizzService = quizzService;
    }

    @GetMapping("/accueil")
    public String showLoginForm() {
        return "index";
    }

    @GetMapping("/log")
    public String authenticate(Model model, HttpSession session, @RequestBody String username, Question question) throws IOException {
        if (username != null && !username.isEmpty()) {
            model.addAttribute("username", username);
            model.addAttribute("questions", questionService.getQuestions());
            session.setAttribute("username", username);
            session.setAttribute("questions", questionService.getQuestions());
            model.addAttribute("correctAnswer", question.getCorrectAnswer());
            model.addAttribute("incorrectAnswers", question.getIncorrectAnswers());
            session.setAttribute("correctAnswer", question.getCorrectAnswer());
            session.setAttribute("incorrectAnswers", question.getIncorrectAnswers());
            session.setAttribute("score", quizzService.calculateScore());

        }
        return "quizz";
    }

    @GetMapping("/quizz")
    public String showQuestions(Model model, @RequestParam String username) throws IOException {
        model.addAttribute("questions", questionService.getQuestions());
        model.addAttribute("username", username);

        for (Question question : questionService.getQuestions()) {
            model.addAttribute(question.toString());
            model.addAttribute(question.getCorrectAnswer()).toString();
            model.addAttribute(question.getIncorrectAnswers().toString());
            model.getAttribute(question.toString());
            model.getAttribute(question.getCorrectAnswer().toString());
            model.getAttribute(question.getIncorrectAnswers().toString());

        }
        return "quizz";
    }
    @GetMapping("/evaluate")
    public String evaluateAnswers(@RequestParam List<String> answers, HttpSession session) {
        if (answers == null || answers.isEmpty()) {
            // Handle case where no answers were selected
            return "quizz";
        }

        List<Question> questions = (List<Question>) session.getAttribute("questions");
        int score = 0;

        for (int i = 0; i < answers.size(); i++) {
            Question question = questions.get(i);
            String selectedAnswer = answers.get(i);

            if (selectedAnswer.equals(question.getCorrectAnswer())) {
                score++;
            }
        }

        session.setAttribute("score", score);
        return "end";
    }

    @GetMapping("/end")
    public String end(HttpSession session, Model model) {
        Object username = session.getAttribute("username");
        Object score = session.getAttribute("score");

        if (username == null || score == null) {
            return "redirect:/accueil";
        }

        session.removeAttribute("username");
        session.removeAttribute("questions");
        session.removeAttribute("score");

        model.addAttribute("username", username);
        model.addAttribute("score", score);

        return "end";

    }
}

