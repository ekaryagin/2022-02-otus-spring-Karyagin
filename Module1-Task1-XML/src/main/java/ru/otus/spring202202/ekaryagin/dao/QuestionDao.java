package ru.otus.spring202202.ekaryagin.dao;

import ru.otus.spring202202.ekaryagin.domain.Question;

import java.util.List;

public interface QuestionDao {

    List<Question> getQuestions();
}
