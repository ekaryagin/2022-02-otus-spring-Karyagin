package ru.otus.spring.ekaryagin.domain;

import java.util.Objects;

public class Answer {

    private final String solution;
    private final Boolean correct;

    public Answer(String solution, Boolean correct) {
        this.solution = solution;
        this.correct = correct;
    }

    public String getSolution(){
        return solution;
    }

    public boolean isCorrect(){
        return correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return solution.equals(answer.solution) && correct.equals(answer.correct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(solution, correct);
    }
}
