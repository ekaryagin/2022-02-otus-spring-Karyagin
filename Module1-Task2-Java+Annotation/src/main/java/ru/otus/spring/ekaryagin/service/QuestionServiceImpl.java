package ru.otus.spring.ekaryagin.service;

import ru.otus.spring.ekaryagin.dao.QuestionDao;
import ru.otus.spring.ekaryagin.domain.Question;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestions() {
        return questionDao.getQuestions();
    }
}
