package org.example.quizz.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.quizz.model.Question;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class QuestionService {

    private final Resource resourceFile;

    public QuestionService() {
        this.resourceFile = new ClassPathResource("question.json");
    }

    public List<Question> getQuestions() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = resourceFile.getInputStream()) {
            return objectMapper.readValue(inputStream, new TypeReference<>() {});
        }
    }
}
