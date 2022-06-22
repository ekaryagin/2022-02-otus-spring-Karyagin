package ru.otus.spring.ekaryagin.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.spring.ekaryagin.domain.Answer;
import ru.otus.spring.ekaryagin.domain.Question;
import ru.otus.spring.ekaryagin.service.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    private final QuestionService questionService;
    private final MessageSender messageSender;
    private final IOService ioService;

    public TestServiceImpl(QuestionService questionService, MessageSender messageSender, IOService ioService) {
        this.questionService = questionService;
        this.messageSender = messageSender;
        this.ioService = ioService;
    }

    public int startTesting() {
        List<Question> questions = questionService.getQuestions();
        int countQuestions = 0;
        int countRightAnswers = 0;
        messageSender.sendMessageLn("START_TESTING");
        for (Question question : questions) {
            countQuestions++;
            List<Integer> rightAnswers = askQuestion(question, countQuestions);
            List<Integer> userAnswers = askAnswer();
            if (checkAnswer(rightAnswers, userAnswers)) {
                countRightAnswers++;
            }
        }
        int mark = getResult(countQuestions, countRightAnswers);
        summingUp(mark);
        return mark;
    }

    //Asks a question, and returns a list of correct answers
    protected List<Integer> askQuestion(Question question, int number) {
        messageSender.sendMessageFormatted("QUESTION_NUMBER", number, question.getTopic());
        messageSender.sendMessageLn("ANSWER_OPTIONS");
        return givePossibleAnswers(question);
    }

    //Suggests possible answers, and returns a list of correct answers
    protected List<Integer> givePossibleAnswers(Question question) {
        Collections.shuffle(question.getAnswerOptions());
        List<Integer> rightAnswers = new ArrayList<>();
        int answerNumber = 1;
        for (Answer answer : question.getAnswerOptions()) {
            messageSender.sendMessageFormatted("ANSWER_NUMBER", answerNumber, answer.getSolution());
            if (answer.isCorrect()) {
                rightAnswers.add(answerNumber);
            }
            answerNumber++;
        }
        return rightAnswers;
    }

    //Asks the user for his answer option, and returns a list of his answers
    protected List<Integer> askAnswer() {
        List<Integer> userAnswers = new ArrayList<>();
        while (true) {
            messageSender.sendMessage("ENTER_ANSWER");
            try {
                String userResponse = ioService.inputText();
                String[] strs = userResponse.split(",");
                for (String str : strs) {
                    userAnswers.add(Integer.parseInt(str));
                }
                return userAnswers;
            } catch (NumberFormatException ex) {
                messageSender.sendMessageLn("ONLY_NUM_AND_COMMAS");
            }
        }
    }

    //Checking the user's choice
    protected boolean checkAnswer(List<Integer> rightAnswers, List<Integer> userAnswers) {
        Collections.sort(rightAnswers);
        Collections.sort(userAnswers);
        return rightAnswers.equals(userAnswers);
    }

    //Calculate the percentage of correct answers
    protected int getResult(int countQuestions, int countRightAnswers) {
        return Math.round((float) countRightAnswers / (float) countQuestions * 100);
    }

    protected void summingUp(int mark) {
        messageSender.sendMessageLn("TEST_OVER");
        messageSender.sendMessageFormatted("YOUR_MARK", mark);
    }
}
