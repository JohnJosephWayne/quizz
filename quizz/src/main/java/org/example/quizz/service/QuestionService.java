package org.example.secu.service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.secu.model.Question;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class QuestionService {

    @Value("classpath:question.json")
    private Resource resourceFile;

    public List<Question> getQuestions() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Question> questions = objectMapper.readValue(resourceFile.getFile(), new TypeReference<>() {
        });
        return questions;
    }
}
