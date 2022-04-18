package ru.otus.spring.ekaryagin.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.spring.ekaryagin.dao.QuestionDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class QuizServiceTest {

    private IOService ioService;
    private QuestionServiceImpl questionService;
    private QuizService quizService;

    @BeforeEach
    void setUp() {
        ioService = Mockito.mock(IOService.class);
        questionService = Mockito.mock(QuestionServiceImpl.class);
        quizService = new QuizService(questionService, ioService);
    }

    //TODO askAnswer test
    @Test
    void askAnswer() {
        given(ioService.inputText()).willReturn("1,2,,");
        assertEquals(Arrays.asList(1, 2), quizService.askAnswer());
    }

    @DisplayName("Correctly compare the answers")
    @Test
    void checkAnswer() {
        assertAll("compare the answers",
                () -> assertTrue(quizService.checkAnswer(Arrays.asList(1, 2), Arrays.asList(1, 2))),
                () -> assertTrue(quizService.checkAnswer(Arrays.asList(1, 2), Arrays.asList(2, 1))),
                () -> assertTrue(quizService.checkAnswer(Arrays.asList(2), Arrays.asList(2))),
                () -> assertFalse(quizService.checkAnswer(Arrays.asList(2), Arrays.asList(1, 2))),
                () -> assertFalse(quizService.checkAnswer(Arrays.asList(1, 2), Arrays.asList(1)))
        );
    }

    @DisplayName("Correctly calculates the percentage of correct answers")
    @Test
    void getResult() {
        assertAll("counting the percentages",
                () -> assertEquals(70, quizService.getResult(10, 7)),
                () -> assertEquals(0, quizService.getResult(5, 0)),
                () -> assertEquals(30, quizService.getResult(1000, 296))
        );
    }
}