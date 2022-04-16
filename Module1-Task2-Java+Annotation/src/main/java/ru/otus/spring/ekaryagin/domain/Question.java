package ru.otus.spring.ekaryagin.domain;

import java.util.List;
import java.util.Objects;

public class Question {

    private final String topic;
    private final List<Answer> answerOptions;

    public Question(String question, List<Answer> answerOptions) {
        this.topic = question;
        this.answerOptions = answerOptions;
    }

    public String getTopic() {
        return topic;
    }

    public List<Answer> getAnswerOptions() {
        return answerOptions;
    }

    @Override
    public String toString() {
        return topic + "\nOptions:\n" + answerOptions.toString() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question1 = (Question) o;
        return topic.equals(question1.topic) && Objects.equals(answerOptions, question1.answerOptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, answerOptions);
    }
}
