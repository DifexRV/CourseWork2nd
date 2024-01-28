package com.example.coursework2nd.coursework2nd;

import com.example.coursework2nd.coursework2nd.model.Question;
import com.example.coursework2nd.coursework2nd.service.JavaQuestionServiceImpl;
import com.example.coursework2nd.coursework2nd.service.QuestionService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    QuestionService questionService = new JavaQuestionServiceImpl();
    Question newQuestion = new Question("Вопрос № 1", "Ответ на вопрос № 1");

    @Test
    public void addTest() {
        Question addedQuestion = questionService.add("Вопрос № 1", "Ответ на вопрос № 1");
        assertEquals(newQuestion, addedQuestion);
        assertTrue(questionService.getAll().contains(newQuestion));
        assertThrows(IllegalArgumentException.class, () -> questionService.add(newQuestion));
    }


    @Test
    public void removeTest() {
        questionService.add(newQuestion);
        Question removedQuestion = questionService.remove(newQuestion);
        assertEquals(newQuestion, removedQuestion);
        assertFalse(questionService.getAll().contains(newQuestion));
        assertThrows(IllegalArgumentException.class, () -> questionService.remove(newQuestion));
    }


    @Test
    public void findTest() {
        Question questionToFind = questionService.add(newQuestion);
        assertEquals(newQuestion.getQuestion(), questionToFind.getQuestion());
        assertThrows(IllegalArgumentException.class, () -> questionService.find("Вопрос № 2"));
    }

}
