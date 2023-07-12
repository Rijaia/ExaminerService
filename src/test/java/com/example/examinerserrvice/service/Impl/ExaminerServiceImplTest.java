package com.example.examinerserrvice.service.Impl;

import com.example.examinerserrvice.Question;
import com.example.examinerserrvice.exeptoin.NotEnoughQuestionsInStorage;
import com.example.examinerserrvice.service.QuestionService;
import com.example.examinerserrvice.service.impl.ExaminerQuestionsImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerQuestionsImpl examinerService;

    @Test
    public void shouldThrowExceptionWhenAmountMoreThenAvailableQuestions() {
        //given
        int amount = 5;
        when(questionService.getAll()).thenReturn(Collections.emptyList());

        //when

        //then
        Assertions.assertThrows(NotEnoughQuestionsInStorage.class,()->
                examinerService.getQuestions(amount));

    }

    @Test
    public void shouldSuccessfullyRandomQuestions() {
        //given
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Какие две области данных в памяти выделяют в Java?",
                "Хип и куча"));
        questions.add(new Question("Какие основные реализации интерфейса List?",
                "ArrayList, LinkedList"));
        questions.add(new Question("На какой структуре данных основывается LinkedList?",
                "Двусвязный список"));
        questions.add(new Question("В чем сила?","Сила в правде"));

        int amount = 3;
        when(questionService.getAll()).thenReturn(questions);
        when(questionService.getRandomQuestion()).thenReturn(
                questions.get(0), questions.get(1),
                questions.get(1), questions.get(2)

        );

        //when
        Collection<Question> actualQuestions = examinerService.getQuestions(amount);
        //then
        Assertions.assertEquals(amount,actualQuestions.size());
        Assertions.assertTrue(actualQuestions.contains(questions.get(0)));
        Assertions.assertTrue(actualQuestions.contains(questions.get(1)));
        Assertions.assertTrue(actualQuestions.contains(questions.get(2)));
        verify(questionService, times(4)).getRandomQuestion();

    }


}
