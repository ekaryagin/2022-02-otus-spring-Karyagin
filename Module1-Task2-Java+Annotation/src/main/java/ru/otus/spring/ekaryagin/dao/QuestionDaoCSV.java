package ru.otus.spring.ekaryagin.dao;

import org.springframework.core.io.ClassPathResource;
import ru.otus.spring.ekaryagin.domain.Question;
import ru.otus.spring.ekaryagin.exception.QuestionsLoadingException;
import ru.otus.spring.ekaryagin.utility.ConverterForQuiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoCSV implements QuestionDao {

    private final String questionsFileSource;

    public QuestionDaoCSV(String questionsFileSource) {
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
                questions.add(ConverterForQuiz.getQuestionFromCSVString(buffer));
            }
        } catch (IOException e) {
            throw new QuestionsLoadingException("The quiz file was not found or damaged.");
        }
        return questions;
    }

    public String getQuestionsFileSource() {
        return questionsFileSource;
    }
}
