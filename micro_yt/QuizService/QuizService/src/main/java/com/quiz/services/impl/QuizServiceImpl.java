package com.quiz.services.impl;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;
import com.quiz.services.QuestionClient;
import com.quiz.services.QuizService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private QuizRepository quizRepository;

    private QuestionClient questionClient;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }


    @Override
    public Quiz add(Quiz quiz) {
        System.out.println("Saving Quiz: " + quiz);
        return quizRepository.save(quiz);
    }


    @Override
    public List<Quiz> get() {
//        return quizRepository.findAll();
    List<Quiz> quizzes = quizRepository.findAll();

//    for(Quiz quiz : quizzes){
//        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
//    }
//    return quizzes;
//
    List<Quiz> newQuizList = quizzes.stream().peek(quiz -> quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()))).collect(Collectors.toList());

    return newQuizList;
    }

    @Override
    public Quiz get(Long id) {
        //here we get an optional object if we get it will give data else throw error
//        return quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));

        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;


    }
}
