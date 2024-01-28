package com.example.coursework2nd.coursework2nd;

import com.example.coursework2nd.coursework2nd.model.Question;
import com.example.coursework2nd.coursework2nd.service.ExaminerService;
import com.example.coursework2nd.coursework2nd.service.ExaminerServiceImpl;
import com.example.coursework2nd.coursework2nd.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExaminerServiceImplTest {

    QuestionService questionService = Mockito.mock(QuestionService.class);
    ExaminerService examinerService = new ExaminerServiceImpl(questionService);


    List<Question> allQuestions = new ArrayList<>(List.of(
            new Question("Вопрос 1", "Ответ на вопрос № 1"),
            new Question("Вопрос 2", "Ответ на вопрос № 2"),
            new Question("Вопрос 3", "Ответ на вопрос № 3")
    ));

    @Test
    public void getQuestions() {
        Mockito.when(questionService.getAll()).thenReturn(allQuestions);
        int amount = 2;
        List<Question> questions = new ArrayList<>(examinerService.getQuestions(amount));
        assertEquals(amount,questions.size());
        assertTrue(allQuestions.contains(questions));
    }

}
