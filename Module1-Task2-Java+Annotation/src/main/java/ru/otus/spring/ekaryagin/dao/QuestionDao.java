package ru.otus.spring.ekaryagin.dao;

import ru.otus.spring.ekaryagin.domain.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> getQuestions();
}
