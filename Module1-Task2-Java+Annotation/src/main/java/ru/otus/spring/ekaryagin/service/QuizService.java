package ru.otus.spring.ekaryagin.service;

import ru.otus.spring.ekaryagin.domain.Question;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class QuizService {

    private final QuestionService questionService;
    private final IOService ioService;

    public QuizService(QuestionService questionService, IOService ioService) {
        this.questionService = questionService;
        this.ioService = ioService;
    }

    public void launchTheQuiz(){
        ioService.outputText("Welcome to the quiz!");
        ioService.outputText("here is a list of questions:");
        List<Question> questions = questionService.getQuestions();
        AtomicInteger i= new AtomicInteger(1);
        questions.forEach(question -> askQuestion(question, i.getAndIncrement()));
    }

    public void askQuestion(Question question, int number){
        ioService.outputText("\n" + number + " " + question.getTopic());
        ioService.outputText("\tAnswer options:");
        AtomicInteger i= new AtomicInteger(1);
        question.getAnswerOptions().forEach(answer -> ioService.outputText("\t\t" + i.getAndIncrement() + " " + answer.getSolution()));
    }

}
