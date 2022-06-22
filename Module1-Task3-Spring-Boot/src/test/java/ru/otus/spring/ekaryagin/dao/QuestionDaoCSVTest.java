package ru.otus.spring.ekaryagin.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.spring.ekaryagin.domain.Answer;
import ru.otus.spring.ekaryagin.domain.Question;
import ru.otus.spring.ekaryagin.service.ConverterForQuiz;
import ru.otus.spring.ekaryagin.service.MessageService;
import ru.otus.spring.ekaryagin.service.QuestionResourceNameService;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Class QuestionDaoSVC")
@SpringBootTest
class QuestionDaoCSVTest {

    @Autowired
    MessageService messageService;
    @Autowired
    QuestionResourceNameService questionResourceNameService;
    @Autowired
    ConverterForQuiz converterForQuiz;

    @DisplayName("Correctly read resource file")
    @Test
    void getQuestions() {
        QuestionDaoCSV questionDao = new QuestionDaoCSV(messageService, questionResourceNameService, converterForQuiz);
        ArrayList<Question> questions = new ArrayList<>(Arrays.asList(
                new Question("Вопрос1",
                        Arrays.asList(new Answer("Ответ1-1", true),
                                new Answer("Ответ1-2", false),
                                new Answer("Ответ1-3", false))),
                new Question("Вопрос2",
                        Arrays.asList(new Answer("Ответ2-1", false),
                                new Answer("Ответ2-2", true))))
        );

        assertEquals(questions, questionDao.getQuestions());
    }
}
