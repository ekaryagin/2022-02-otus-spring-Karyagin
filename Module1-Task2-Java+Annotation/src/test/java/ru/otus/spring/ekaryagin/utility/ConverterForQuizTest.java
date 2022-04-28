package ru.otus.spring.ekaryagin.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.ekaryagin.domain.Answer;
import ru.otus.spring.ekaryagin.domain.Question;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class ConverterForQuizTest {

    @DisplayName("correctly convert a string to object Question")
    @Test
    void getQuestionFromCSVString() {
        String testStr = "Question1;!Answer1-1;Answer1-2;Answer1-3";
        ArrayList<Answer> answers = new ArrayList<>( Arrays.asList(new Answer("Answer1-1", true),
                new Answer("Answer1-2", false),
                new Answer("Answer1-3", false)));
        Question question = ConverterForQuiz.getQuestionFromCSVString(testStr);
        assertAll("answer",
                () -> assertEquals("Question1", question.getTopic()),
                () -> assertEquals(answers, question.getAnswerOptions())
        );
    }

}