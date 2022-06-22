package ru.otus.spring.ekaryagin.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.spring.ekaryagin.config.LocalSettings;
import ru.otus.spring.ekaryagin.domain.Student;
import ru.otus.spring.ekaryagin.service.*;

@Service
public class QuizServiceImpl implements QuizService {

    private final IOService ioService;
    private final TestService testService;
    private final MessageSender messageSender;
    private final LocalSettings localSettings;

    public QuizServiceImpl(IOService ioService, TestService testService,
                           MessageSender messageSender, LocalSettings localSettings) {
        this.ioService = ioService;
        this.testService = testService;
        this.messageSender = messageSender;
        this.localSettings = localSettings;
    }

    public void launchTheQuiz() {
        messageSender.sendMessageLn("WELCOME");
        messageSender.sendMessage("INPUT_LAST_NAME");
        String lastName = ioService.inputText();
        messageSender.sendMessage("INPUT_FIRST_NAME");
        String firstName = ioService.inputText();
        Student student = new Student(firstName, lastName);
        boolean beginTest = true;
        int mark = 0;
        while (beginTest) {
            mark = testService.startTesting();
            messageSender.sendMessageLn("REPEAT_TEST");
            beginTest = userChoice();
        }
        debriefing(mark, student);
        messageSender.sendMessageLn("BAY");
    }

    protected void debriefing(int mark, Student student) {
        messageSender.sendMessageLn("SUM_UP");
        messageSender.sendMessageFormatted("APPEAL", student.getFirstName(), student.getLastName());
        if (mark >= localSettings.getThresholdLevel()) {
            messageSender.sendMessageLn("PASSED_TEST");
        } else {
            messageSender.sendMessageLn("FAILED_TEST");
        }
    }

    protected boolean userChoice() {
        boolean choice = false;
        messageSender.sendMessage("YOUR_CHOICE");
        String userInput = ioService.inputText();
        if (userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yes")) {
            choice = true;
        }
        return choice;
    }
}
