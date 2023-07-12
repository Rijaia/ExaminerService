package com.example.examinerserrvice.service.impl;

import com.example.examinerserrvice.Question;
import com.example.examinerserrvice.exeptoin.NotEnoughQuestionsInStorage;
import com.example.examinerserrvice.service.ExaminerService;
import com.example.examinerserrvice.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerQuestionsImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerQuestionsImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new NotEnoughQuestionsInStorage();
        }
        Set<Question> randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
