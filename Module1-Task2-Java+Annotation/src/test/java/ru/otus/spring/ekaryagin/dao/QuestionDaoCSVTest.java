package ru.otus.spring.ekaryagin.dao;

import org.junit.jupiter.api.*;
import ru.otus.spring.ekaryagin.domain.Answer;
import ru.otus.spring.ekaryagin.domain.Question;
import ru.otus.spring.ekaryagin.exception.QuestionsLoadingException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@DisplayName("Class QuestionDaoSVC")
class QuestionDaoCSVTest {

    QuestionDaoCSV questionDao;

    @BeforeEach
    void setUp() {
        questionDao = new QuestionDaoCSV("test.csv");
    }

    @DisplayName("Correctly created by the constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        assertEquals("test.csv", questionDao.getQuestionsFileSource());
    }

    @DisplayName("Correctly read resource file")
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
        assertEquals(questions, questionDao.getQuestions());
    }

    @DisplayName("Throw a valid exception if the file is missing or corrupted")
    @Test
    void getException() {
        QuestionDaoCSV questionDaoEx = new QuestionDaoCSV("testEx.csv");
        QuestionsLoadingException thrown =  Assertions.assertThrows(QuestionsLoadingException.class, questionDaoEx::getQuestions);
        assertEquals("The quiz file was not found or damaged.", thrown.getMessage());
    }
}
