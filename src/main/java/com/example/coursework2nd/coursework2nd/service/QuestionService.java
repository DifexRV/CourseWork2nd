package com.example.coursework2nd.coursework2nd.service;

import com.example.coursework2nd.coursework2nd.model.Question;

import java.util.Collection;

public interface QuestionService {

    Collection<Question> getAll();
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(Question question);

    Question find(String question);
    Question getRandomQuestion();

}
