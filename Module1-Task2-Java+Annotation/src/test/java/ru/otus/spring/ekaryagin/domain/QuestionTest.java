package ru.otus.spring.ekaryagin.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Class Question")
class QuestionTest {

    @DisplayName("correctly created by the constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        ArrayList<Answer> answers = new ArrayList<>( Arrays.asList(new Answer("Answer1-1", true),
                new Answer("Answer1-2", false),
                new Answer("Answer1-3", false)));
        Question question = new Question("Question", answers);
        assertAll("question",
                () -> assertEquals("Question", question.getTopic()),
                () -> assertEquals(answers, question.getAnswerOptions())
        );
    }
}
