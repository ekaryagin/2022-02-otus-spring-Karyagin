package ru.otus.spring.ekaryagin.service;

import ru.otus.spring.ekaryagin.domain.Question;

public interface ConverterForQuiz {
    Question getQuestionFromCSVString(String str);
}
