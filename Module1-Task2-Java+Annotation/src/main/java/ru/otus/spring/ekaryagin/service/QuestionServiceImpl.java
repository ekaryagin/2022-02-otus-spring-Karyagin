package ru.otus.spring.ekaryagin.service;

import ru.otus.spring.ekaryagin.dao.QuestionDao;
import ru.otus.spring.ekaryagin.domain.Question;
import ru.otus.spring.ekaryagin.exception.QuestionsLoadingException;

import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    public QuestionServiceImpl(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = questionDao.getQuestions();
        if (questions.isEmpty())
        {
            throw new QuestionsLoadingException("There are no quiz questions in the source.");
        }
        return questionDao.getQuestions();
    }
}
