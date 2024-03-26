package org.example.secu.controller;

import org.example.secu.model.Question;
import org.example.secu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/accueil")
@SessionAttributes("username")
public class LogController {

    private final QuestionService questionService;

    @Autowired
    public LogController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/accueil")
    public String showLoginForm(Model model) {
        if (!model.containsAttribute("username")) {
            model.addAttribute("username", "");
        }
        return "quizz";
    }

    @PostMapping("/accueil")
    public String authenticate(@RequestParam("username") String username, RedirectAttributes redirectAttributes) {
        if (username != null && !username.isEmpty()) {
            redirectAttributes.addFlashAttribute("username", username);
            return "redirect:/quizz";
        } else {
            return "redirect:/accueil";
        }
    }

    @GetMapping("/quizz")
    public String showNextQuestion(@RequestParam(defaultValue = "0") int id, Model model) throws IOException {
        if (!model.containsAttribute("username")) {
            return "redirect:/accueil";
        }

        List<Question> questions = questionService.getQuestions();
        if (id < 0 || id >= questions.size()) {
            // Redirection vers une page de fin ou de résumé s'il n'y a plus de questions
            return "redirect:/accueil";
        }

        model.addAttribute("username", model.getAttribute("username"));
        model.addAttribute("question", questions.get(id));

        return "quizz";
    }

    @GetMapping("/end")
    public String showEndPage() {
        return "end";
    }
}
