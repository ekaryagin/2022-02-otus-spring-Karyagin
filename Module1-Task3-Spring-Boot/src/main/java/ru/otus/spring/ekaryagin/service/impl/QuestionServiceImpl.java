package ru.otus.spring.ekaryagin.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.spring.ekaryagin.dao.QuestionDao;
import ru.otus.spring.ekaryagin.domain.Question;
import ru.otus.spring.ekaryagin.exception.QuestionsLoadingException;
import ru.otus.spring.ekaryagin.service.MessageService;
import ru.otus.spring.ekaryagin.service.QuestionService;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;
    private final MessageService messageService;

    public QuestionServiceImpl(QuestionDao questionDao, MessageService messageService) {
        this.questionDao = questionDao;
        this.messageService = messageService;
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = questionDao.getQuestions();
        if (questions.isEmpty()) {
            throw new QuestionsLoadingException(messageService.getMessage("EXCEPT_NO_QUESTIONS"));
        }
        return questions;
    }
}
