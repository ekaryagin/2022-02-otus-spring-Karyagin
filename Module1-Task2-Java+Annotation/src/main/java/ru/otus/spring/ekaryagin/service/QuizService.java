package ru.otus.spring.ekaryagin.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.spring.ekaryagin.domain.Student;
import ru.otus.spring.ekaryagin.utility.Message;

@Service
public class QuizService {

    private final IOService ioService;
    private final TestService testService;
    private final int thresholdLevel;

    public QuizService(IOService ioService, TestService testService,
                       @Value("${thresholdLevel}") int thresholdLevel) {
        this.ioService = ioService;
        this.testService = testService;
        this.thresholdLevel = thresholdLevel;
    }

    public void launchTheQuiz() {
        ioService.outputTextLn(Message.WELCOME);
        ioService.outputText(Message.INPUT_LAST_NAME);
        String lastName = ioService.inputText();
        ioService.outputText(Message.INPUT_FIRST_NAME);
        String firstName = ioService.inputText();
        Student student = new Student(firstName, lastName);
        boolean beginTest = true;
        int mark = 0;
        while (beginTest) {
            mark = testService.startTesting();
            ioService.outputTextLn(Message.REPEAT_TEST);
            beginTest = userChoice();
        }
        debriefing(mark, student);
        ioService.outputTextLn(Message.BAY);
    }

    protected void debriefing(int mark, Student student) {
        ioService.outputTextLn(Message.SUM_UP);
        ioService.outputTextLn(Message.APPEAL + student.getFirstName() + " " + student.getLastName());
        if (mark >= thresholdLevel) {
            ioService.outputTextLn(Message.PASSED_TEST);
        } else {
            ioService.outputTextLn(Message.FAILED_TEST);
        }
    }

    protected boolean userChoice() {
        boolean choice = false;
        ioService.outputText(Message.YOUR_CHOICE);
        String userInput = ioService.inputText();
        if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
            choice = true;
        }
        return choice;
    }

}
