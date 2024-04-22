package org.example.quizz.service;

import org.example.quizz.model.Answer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizzService {

    private List<Answer> answers;

    public String calculateScore() {
        int score = 0;
        for (Answer answer : answers) {
            if (answer.isSelected()) { // If the answer is correct
                score++; // Increment the score
            }
        }
        return "score";
    }
}