package org.example.quizz.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question {
    private int id;
    private String text;
    private String correctAnswer;
    private List<String> incorrectAnswers;

}
