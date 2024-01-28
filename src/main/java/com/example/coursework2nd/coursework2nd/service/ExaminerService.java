package com.example.coursework2nd.coursework2nd.service;

import com.example.coursework2nd.coursework2nd.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
