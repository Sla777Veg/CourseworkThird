package com.example.coursework_3.service;

import com.example.coursework_3.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
