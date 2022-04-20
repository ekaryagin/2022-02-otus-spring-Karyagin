package ru.otus.spring.ekaryagin.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class TestServiceTest {

    private IOService ioService;
    private TestService testService;

    @BeforeEach
    void setUp() {
        ioService = Mockito.mock(IOService.class);
        QuestionService questionService = Mockito.mock(QuestionServiceImpl.class);
        testService = new TestService(questionService, ioService);
    }

    @DisplayName("Reads the user's response correctly")
    @Test
    void askAnswer() {
        given(ioService.inputText()).willReturn("1,2,,");
        assertEquals(Arrays.asList(1, 2), testService.askAnswer());
    }

    @DisplayName("Correctly compare the answers")
    @Test
    void checkAnswer() {
        assertAll("compare the answers",
                () -> assertTrue(testService.checkAnswer(Arrays.asList(1, 2), Arrays.asList(1, 2))),
                () -> assertTrue(testService.checkAnswer(Arrays.asList(1, 2), Arrays.asList(2, 1))),
                () -> assertTrue(testService.checkAnswer(Arrays.asList(2), Arrays.asList(2))),
                () -> assertFalse(testService.checkAnswer(Arrays.asList(2), Arrays.asList(1, 2))),
                () -> assertFalse(testService.checkAnswer(Arrays.asList(1, 2), Arrays.asList(1)))
        );
    }

    @DisplayName("Correctly calculates the percentage of correct answers")
    @Test
    void getResult() {
        assertAll("counting the percentages",
                () -> assertEquals(70, testService.getResult(10, 7)),
                () -> assertEquals(0, testService.getResult(5, 0)),
                () -> assertEquals(30, testService.getResult(1000, 296))
        );
    }

}