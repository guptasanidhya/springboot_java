package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz add(Quiz quiz) {
        System.out.println("Saving Quiz: " + quiz);
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> get() {
        return quizRepository.findAll();
    }

    @Override
    public Quiz get(Long id) {
        //here we get an optional object if we get it will give data else throw error
        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
    }
}
