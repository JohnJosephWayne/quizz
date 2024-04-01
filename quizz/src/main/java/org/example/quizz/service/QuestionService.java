package org.example.quizz.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.quizz.model.Question;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class QuestionService {

    public List<Question> getQuestions() throws IOException {
        Resource resourceFile = new ClassPathResource("C:\\Users\\user\\IdeaProjects\\quizz\\quizz\\src\\main\\resources\\templates\\json\\question.json");
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(resourceFile.getInputStream(), new TypeReference<>() {});
    }
}
