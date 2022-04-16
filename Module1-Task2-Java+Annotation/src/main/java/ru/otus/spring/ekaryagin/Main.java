package ru.otus.spring.ekaryagin;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.ekaryagin.service.QuizService;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuizService quiz = context.getBean(QuizService.class);
        quiz.launchTheQuiz();
    }
}
