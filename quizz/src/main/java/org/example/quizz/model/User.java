package org.example.quizz.model;

import io.micrometer.observation.transport.Propagator;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class User {
    protected String username;
    protected ArrayList<Question> questionList;
}
