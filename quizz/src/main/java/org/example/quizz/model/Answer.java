package org.example.quizz.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
    private String text;
    private boolean correct;

    int score = 0;

    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public boolean isSelected() {
        return correct;
    }
}
