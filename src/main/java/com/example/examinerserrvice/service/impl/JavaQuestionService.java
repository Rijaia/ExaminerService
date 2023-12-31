package com.example.examinerserrvice.service.impl;

import com.example.examinerserrvice.Question;
import com.example.examinerserrvice.service.QuestionService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JavaQuestionService implements QuestionService {
    private final List<Question> questions = new ArrayList<>();

    @PostConstruct
    public void setup() {
       questions.add(new Question("Какие две области данных в памяти выделяют в Java?",
                "Хип и куча"));
       questions.add(new Question("Какие основные реализации интерфейса List?",
                "ArrayList, LinkedList"));
       questions.add(new Question("На какой структуре данных основывается LinkedList?",
                "Двусвязный список"));
       questions.add(new Question("В чем сила?","Сила в правде"));
    }
    @Override
    public Question add(String question, String answer) {
        return add(new Question(question,answer));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        return null;
    }

    @Override
    public Question getAll() {
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        return null;
    }
}
