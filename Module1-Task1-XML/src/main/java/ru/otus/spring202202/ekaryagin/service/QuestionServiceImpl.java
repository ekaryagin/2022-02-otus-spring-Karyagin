package ru.otus.spring202202.ekaryagin.service;

import ru.otus.spring202202.ekaryagin.dao.QuestionDao;
import ru.otus.spring202202.ekaryagin.domain.Question;

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
