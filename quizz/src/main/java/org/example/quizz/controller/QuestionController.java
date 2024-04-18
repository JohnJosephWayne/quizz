package org.example.quizz.controller;

import org.example.quizz.model.Answer;
import org.example.quizz.model.Question;
import org.example.quizz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class QuestionController {


    @Autowired
    private QuestionService questionService;

    @GetMapping("/quizz")
    public ResponseEntity<List<Question>> getQuestions() throws IOException {
        List<Question> questions = questionService.getQuestions();
        return ResponseEntity.ok(questions);
    }
}
