package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VragenController {

    private static String[] questions = {
            "Where is Amsterdam?",
            "Where is New York?"
    };

    private static String[] answers = {
            "In the Netherlands",
            "In US of A"
    };

    @GetMapping(value = "/questions")       // collection
    public String[] getQuestions() {
        return questions;
    }

    @GetMapping(value = "/questions/{nr}")       // item
    public String getQuestion(@PathVariable int nr) {
        return questions[nr];
    }

    @GetMapping(value = "/questions/{nr}/answer")       // document
    public String getAnswer(@PathVariable int nr) {
        return answers[nr];
    }

    @PostMapping(value = "/questions")
    public void addQuestion() {
        // voeg vraag toe!!
    }


}
