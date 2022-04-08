package ru.otus.spring202202.ekaryagin.service;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.spring202202.ekaryagin.dao.QuestionDao;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@DisplayName("Class QuestionServiceImpl")
class QuestionServiceImplTest {

    private QuestionDao questionDao;
    private QuestionServiceImpl questionService;

    @BeforeEach
    void setUp() {
        questionDao = Mockito.mock(QuestionDao.class);
        questionService = new QuestionServiceImpl(questionDao);
    }

    @DisplayName("correctly works with dao")
    @Test
    void getQuestions() {
        given(questionDao.getQuestions()).willReturn(new ArrayList<>());

        assertThat(questionService.getQuestions()).isNotNull();
    }
}