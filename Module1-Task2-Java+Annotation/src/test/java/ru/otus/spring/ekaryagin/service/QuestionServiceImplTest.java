package ru.otus.spring.ekaryagin.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.spring.ekaryagin.dao.QuestionDao;
import ru.otus.spring.ekaryagin.domain.Answer;
import ru.otus.spring.ekaryagin.domain.Question;
import ru.otus.spring.ekaryagin.exception.QuestionsLoadingException;
import ru.otus.spring.ekaryagin.utility.Message;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@DisplayName("Class QuestionServiceImpl")
class QuestionServiceImplTest {

    private QuestionDao questionDao;
    private QuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        questionDao = Mockito.mock(QuestionDao.class);
        questionService = new QuestionServiceImpl(questionDao);
    }

    @DisplayName("Correctly works with dao")
    @Test
    void getQuestions() {
        ArrayList<Question> questions = new ArrayList<>(Arrays.asList(
                new Question("Question1",
                        Arrays.asList(new Answer("Answer1-1", true),
                                new Answer("Answer1-2", false),
                                new Answer("Answer1-3", false))),
                new Question("Question2",
                        Arrays.asList(new Answer("Answer2-1", false),
                                new Answer("Answer2-2", true))))
        );
        given(questionDao.getQuestions()).willReturn(questions);

        assertEquals(questions, questionService.getQuestions());
    }

    @DisplayName("Throw a valid exception if there are no questions in the source")
    @Test
    void getException() {
        ArrayList<Question> questions = new ArrayList<>();
        given(questionDao.getQuestions()).willReturn(questions);
        QuestionsLoadingException thrown =  Assertions.assertThrows(QuestionsLoadingException.class, () ->
            questionService.getQuestions());
        assertEquals(Message.EXCEPT_NO_QUESTIONS, thrown.getMessage());
    }
}