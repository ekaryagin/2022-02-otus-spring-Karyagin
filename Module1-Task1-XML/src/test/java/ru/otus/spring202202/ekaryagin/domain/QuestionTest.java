package ru.otus.spring202202.ekaryagin.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Class Question")
public class QuestionTest {

    @DisplayName("correctly created by the constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        ArrayList<String> answers = new ArrayList<>();
        answers.add("Answer");
        Question question = new Question("Question", answers);
        assertAll("question",
                () -> assertEquals("Question", question.getQuestion()),
                () -> assertEquals(answers, question.getAnswerOptions())
        );
    }
}
