package com.quiz.entities;

import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Question {

    private Long questionId;

    private String question;

    private Long quizId;


}
