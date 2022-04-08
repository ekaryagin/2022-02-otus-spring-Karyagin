package ru.otus.spring202202.ekaryagin.domain;

import java.util.List;
import java.util.Objects;

public class Question {

    private final String question;
    private final List<String> answerOptions;

    public Question(String question, List<String> answerOptions) {
        this.question = question;
        this.answerOptions = answerOptions;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswerOptions() {
        return answerOptions;
    }

    @Override
    public String toString() {
        return question + "\nOptions:\n" + answerOptions + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question1 = (Question) o;
        return question.equals(question1.question) && Objects.equals(answerOptions, question1.answerOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answerOptions);
    }
}
