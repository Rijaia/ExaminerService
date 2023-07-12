package com.example.examinerserrvice.service;

import com.example.examinerserrvice.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
