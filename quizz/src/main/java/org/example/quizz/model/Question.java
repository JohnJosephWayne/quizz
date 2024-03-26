package org.example.secu.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Question {
    private int id;
    private String text;
    private List<String> correctAnswer;
    private List<String> incorrectAnswers;

}
