package ru.otus.spring.ekaryagin.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.ekaryagin.dao.QuestionDao;
import ru.otus.spring.ekaryagin.domain.Question;
import ru.otus.spring.ekaryagin.exception.QuestionsLoadingException;
import ru.otus.spring.ekaryagin.utility.Message;

import java.util.List;

@Service
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
            throw new QuestionsLoadingException(Message.EXCEPT_NO_QUESTIONS);
        }
        return questionDao.getQuestions();
    }
}
