package ru.otus.spring.ekaryagin.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Class Answer")
class AnswerTest {

    @DisplayName("correctly created by the constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        Answer answer = new Answer("Answer1-1", true);
        assertAll("answer",
                () -> assertEquals("Answer1-1", answer.getSolution()),
                () -> assertTrue(answer.isCorrect())
        );
    }
}