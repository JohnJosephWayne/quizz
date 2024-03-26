package org.example.secu.controller;

import org.example.secu.model.Question;
import org.example.secu.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/quizz")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getQuestions() throws IOException {
        List<Question> questions = questionService.getQuestions();
        return ResponseEntity.ok(questions);
    }

    @PostMapping("/submit")
    public ResponseEntity<String> submitQuiz(@RequestBody List<Question> questions) {
        // Logique de vérification des réponses ici
        return ResponseEntity.ok("Réponses traitées avec succès");
    }
}
