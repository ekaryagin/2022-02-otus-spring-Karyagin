package ru.otus.spring202202.ekaryagin.dao;

import org.springframework.core.io.ClassPathResource;
import ru.otus.spring202202.ekaryagin.domain.Question;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoSVC implements QuestionDao {

    private final String questionsFileSource;

    public QuestionDaoSVC(String questionsFileSource) {
        this.questionsFileSource = questionsFileSource;
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        try (InputStreamReader resource = new InputStreamReader(
                new ClassPathResource(questionsFileSource).getInputStream())) {

            BufferedReader reader = new BufferedReader(resource);
            String buffer;

            while ((buffer = reader.readLine()) != null) {
                questions.add(getQuestionFromString(buffer));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }

    Question getQuestionFromString(String str) {
        String[] questionPlusAnswers = str.split(";");
        String question = questionPlusAnswers[0];
        ArrayList<String> answers = new ArrayList<>();
        for (int i = 1; i < questionPlusAnswers.length; i++) {
            answers.add(i + ". " + questionPlusAnswers[i]);
        }
        return new Question(question, answers);
    }

    public String getQuestionsFileSource() {
        return questionsFileSource;
    }
}
