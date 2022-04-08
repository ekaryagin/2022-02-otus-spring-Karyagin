package ru.otus.spring202202.ekaryagin.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring202202.ekaryagin.domain.Question;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Class QuestionDaoSVC")
public class QuestionDaoSVCTest {

    @DisplayName("correctly created by the constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        QuestionDaoSVC questionDao = new QuestionDaoSVC("file.svc");
        assertEquals("file.svc", questionDao.getQuestionsFileSource());
    }

    @DisplayName("correctly convert a string to object Question")
    @Test
    void shoudConvertStringToQuestion() {
        QuestionDaoSVC questionDao = new QuestionDaoSVC("file.svc");
        ArrayList<String> answers = new ArrayList<>();
        answers.add("1. Answer");
        Question question = new Question("Question", answers);
        assertEquals(question, questionDao.getQuestionFromString("Question;Answer"));
    }
}
