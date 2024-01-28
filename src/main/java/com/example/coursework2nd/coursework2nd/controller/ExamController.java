package com.example.coursework2nd.coursework2nd.controller;

import com.example.coursework2nd.coursework2nd.model.Question;
import com.example.coursework2nd.coursework2nd.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    private final ExaminerService examinerServiceImpl;

    public ExamController(ExaminerService examinerServiceImpl) {
        this.examinerServiceImpl = examinerServiceImpl;
    }

    @GetMapping("/exam/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerServiceImpl.getQuestions(amount);
    }

}
