package com.example.coursework_3.controller;

import com.example.coursework_3.exception.UnSufficientQuestionsException;
import com.example.coursework_3.service.ExaminerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.coursework_3.model.Question;

import java.util.Collection;

@RestController
@RequestMapping
public class ExamController {

    public final ExaminerService examinerService;

    @ExceptionHandler(UnSufficientQuestionsException.class)
    public ResponseEntity<String> handleException() {
        return ResponseEntity.badRequest()
                .body("Недостаточно вопросов");
    }

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }

}