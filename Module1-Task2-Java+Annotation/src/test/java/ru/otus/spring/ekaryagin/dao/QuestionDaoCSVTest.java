package ru.otus.spring.ekaryagin.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.ekaryagin.domain.Answer;
import ru.otus.spring.ekaryagin.domain.Question;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Class QuestionDaoSVC")
class QuestionDaoCSVTest {

    QuestionDaoCSV questionDao;

    @BeforeEach
    void setUp() {
        questionDao = new QuestionDaoCSV("test.csv");
    }

    @DisplayName("correctly created by the constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        assertEquals("test.csv", questionDao.getQuestionsFileSource());
    }

    @DisplayName("correctly read resource file")
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
}
