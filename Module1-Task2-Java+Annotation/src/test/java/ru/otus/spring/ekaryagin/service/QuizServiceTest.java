package ru.otus.spring.ekaryagin.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

class QuizServiceTest {

    private final IOService ioService = Mockito.mock(IOService.class);
    private final TestService testService = Mockito.mock(TestService.class);
    private static final int thresholdLevel = 50;
    private final QuizService quizService = new QuizService(ioService, testService, thresholdLevel);

    @DisplayName("Reads the user's choice correctly")
    @Test
    void userChoice() {
        given(ioService.inputText()).willReturn("Y");
        assertEquals(true, quizService.userChoice());
        given(ioService.inputText()).willReturn("yES");
        assertEquals(true, quizService.userChoice());
        given(ioService.inputText()).willReturn("n");
        assertEquals(false, quizService.userChoice());
        given(ioService.inputText()).willReturn("0");
        assertEquals(false, quizService.userChoice());
    }

}