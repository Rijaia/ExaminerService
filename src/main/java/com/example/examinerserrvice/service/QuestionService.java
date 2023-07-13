package com.example.examinerserrvice.service;

import com.example.examinerserrvice.Question;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);
    Question getAll();
    Question getRandomQuestion();

}
