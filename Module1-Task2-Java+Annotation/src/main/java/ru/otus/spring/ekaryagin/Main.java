package ru.otus.spring.ekaryagin;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import ru.otus.spring.ekaryagin.service.QuizService;

@PropertySource("classpath:application.properties")
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        QuizService quiz = context.getBean(QuizService.class);
        quiz.launchTheQuiz();
    }
}
