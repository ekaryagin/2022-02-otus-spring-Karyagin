package ru.otus.spring.ekaryagin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.otus.spring.ekaryagin.service.QuizService;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class, args);
        QuizService quiz = context.getBean(QuizService.class);
        quiz.launchTheQuiz();
    }
}
