package ru.otus.spring.ekaryagin.dao;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.otus.spring.ekaryagin.domain.Question;
import ru.otus.spring.ekaryagin.exception.QuestionsLoadingException;
import ru.otus.spring.ekaryagin.service.ConverterForQuiz;
import ru.otus.spring.ekaryagin.service.MessageService;
import ru.otus.spring.ekaryagin.service.QuestionResourceNameService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionDaoCSV implements QuestionDao {

    private final MessageService messageService;
    private final QuestionResourceNameService questionResourceNameService;
    private final ConverterForQuiz converterForQuiz;

    public QuestionDaoCSV(MessageService messageService, QuestionResourceNameService questionResourceNameService, ConverterForQuiz converterForQuiz) {
        this.messageService = messageService;
        this.questionResourceNameService = questionResourceNameService;
        this.converterForQuiz = converterForQuiz;
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        try (InputStreamReader resource = new InputStreamReader(
                new ClassPathResource(questionResourceNameService.getResourceName()).getInputStream())) {

            BufferedReader reader = new BufferedReader(resource);
            String buffer;

            while ((buffer = reader.readLine()) != null) {
                questions.add(converterForQuiz.getQuestionFromCSVString(buffer));
            }
        } catch (IOException e) {
            throw new QuestionsLoadingException(messageService.getMessage("EXCEPT_FILE_NOT_FOUND"));
        }
        return questions;
    }

}
