package com.example.coursework2nd.coursework2nd.service;

import com.example.coursework2nd.coursework2nd.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount > questionService.getAll().size()) {
            throw new IllegalArgumentException("Maximum number of questions exceeded");
        }
        Set<Question> setQuestions = new HashSet<>();
        while (setQuestions.size() < amount) {
            setQuestions.add(questionService.getRandomQuestion());
        }
        return setQuestions;
    }


}
