package org.example.secu.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
    private String text;
    private boolean correct;

    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public boolean isSelected() {
        return correct;
    }
}
