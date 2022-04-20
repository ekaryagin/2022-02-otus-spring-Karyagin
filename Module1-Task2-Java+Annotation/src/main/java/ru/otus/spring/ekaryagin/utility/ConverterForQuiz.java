package ru.otus.spring.ekaryagin.utility;

import ru.otus.spring.ekaryagin.domain.Answer;
import ru.otus.spring.ekaryagin.domain.Question;

import java.util.ArrayList;
import java.util.List;

public class ConverterForQuiz {

    private ConverterForQuiz() {
    }

    public static Question getQuestionFromCSVString(String str) {
        String[] questionPlusAnswers = str.split(";");
        String question = questionPlusAnswers[0];
        List<Answer> answers = new ArrayList<>();
        for (int i = 1; i < questionPlusAnswers.length; i++) {
            if (questionPlusAnswers[i].startsWith("!")) {
                answers.add(new Answer(questionPlusAnswers[i].substring(1), true));
            } else {
                answers.add(new Answer(questionPlusAnswers[i], false));
            }
        }
        return new Question(question, answers);
    }
}
