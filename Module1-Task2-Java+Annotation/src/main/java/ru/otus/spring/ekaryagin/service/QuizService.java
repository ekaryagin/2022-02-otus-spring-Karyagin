package ru.otus.spring.ekaryagin.service;

import ru.otus.spring.ekaryagin.domain.Answer;
import ru.otus.spring.ekaryagin.domain.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizService {

    private final QuestionService questionService;
    private final IOService ioService;

    public QuizService(QuestionService questionService, IOService ioService) {
        this.questionService = questionService;
        this.ioService = ioService;
    }

    public void launchTheQuiz(){
        ioService.outputTextLn("Welcome to the quiz!");

        ioService.outputText("Input your last name: ");
        String lastName = ioService.inputText();
        ioService.outputText("Input your first name: ");
        String firstName = ioService.inputText();

        ioService.outputTextLn("Here is a list of questions:");
        List<Question> questions = questionService.getQuestions();
        int countQuestions = 0;
        int countRightAnswers = 0;
        for (Question question: questions) {
            countQuestions++;
            if (checkAnswer(askQuestion(question, countQuestions), askAnswer())){
                countRightAnswers++;
            }
        }
        int mark = getResult(countQuestions, countRightAnswers);

        ioService.outputText("\nYou have answered " + mark + "% of the questions correctly.\n");
    }

    //Asks a question, and returns a list of correct answers
    protected List<Integer> askQuestion(Question question, int number){
        ioService.outputTextLn("\n" + number + " " + question.getTopic());
        ioService.outputTextLn("\tAnswer options:");
        return givePossibleAnswers(question);
    }

    //Suggests possible answers, and returns a list of correct answers
    protected List<Integer> givePossibleAnswers(Question question){
        Collections.shuffle(question.getAnswerOptions());
        List<Integer> rightAnswers = new ArrayList<>();
        int answerNumber = 1;
        for (Answer answer: question.getAnswerOptions()) {
            ioService.outputTextLn("\t\t" + answerNumber + " - " + answer.getSolution());
            if (answer.isCorrect()){
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
            ioService.outputText("\t\tEnter the correct answer numbers separated by commas: ");
            try {
                String userResponse = ioService.inputText();
                String[] strs = userResponse.split(",");
                for (String str : strs) {
                    userAnswers.add(Integer.parseInt(str));
                }
                return userAnswers;
            } catch (NumberFormatException ex) {
                ioService.outputTextLn("\t\tPlease enter numbers separated by commas, no other characters.");
            }
        }
    }

    //Checking the user's choice
    protected boolean checkAnswer(List<Integer> rightAnswers,List<Integer> userAnswers){
        Collections.sort(rightAnswers);
        Collections.sort(userAnswers);
        return rightAnswers.equals(userAnswers);
    }

    //Calculate the percentage of correct answers
    protected int getResult(int countQuestions, int countRightAnswers){
        return Math.round((float)countRightAnswers/(float)countQuestions*100);
    }

}
