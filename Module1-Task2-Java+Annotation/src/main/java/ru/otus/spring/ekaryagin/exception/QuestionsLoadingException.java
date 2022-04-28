package ru.otus.spring.ekaryagin.exception;

public class QuestionsLoadingException extends RuntimeException {
    public QuestionsLoadingException(String message) {
        super(message);
    }
}
