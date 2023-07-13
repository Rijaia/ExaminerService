package com.example.examinerserrvice.service.Impl;

import com.example.examinerserrvice.Question;
import com.example.examinerserrvice.service.impl.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();

    @Test
    public void shouldRemoveExistedQuestionAndReturnIt() {
        //given
        Question question = new Question("question", "answer");
        javaQuestionService.add(question);
        //when
        Question removedQuestion = javaQuestionService.remove(question);
        //then
        Assertions.assertEquals(question, removedQuestion);
    }
    @Test
    public void shouldRemoveNonExistedQuestionAndReturnNull() {
        //given
        Question question = new Question("question", "answer");
        //when
        Question removedQuestion = javaQuestionService.remove(question);
        //then
        Assertions.assertNull(removedQuestion);
    }
}
