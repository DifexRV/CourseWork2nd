package com.example.coursework2nd.coursework2nd.controller;

import com.example.coursework2nd.coursework2nd.model.Question;
import com.example.coursework2nd.coursework2nd.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/get")
    public Collection<Question> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/add")
    public Question add(@RequestParam String question,
                        @RequestParam String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question remove(@RequestParam String question,
                           @RequestParam String answer) {
        Question questionUser = new Question(question, answer);
        return questionService.remove(questionUser);
    }

    @GetMapping("/find")
    public Question find(@RequestParam String question) {
        return questionService.find(question);
    }
}
