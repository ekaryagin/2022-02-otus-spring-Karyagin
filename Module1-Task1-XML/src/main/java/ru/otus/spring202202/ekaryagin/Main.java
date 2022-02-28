package ru.otus.spring202202.ekaryagin;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring202202.ekaryagin.domain.Question;
import ru.otus.spring202202.ekaryagin.service.QuestionServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        QuestionServiceImpl questionService = context.getBean(QuestionServiceImpl.class);
        List<Question> questions = questionService.getQuestions();
        questions.forEach(question -> {
            System.out.println(question.toString());
        });
    }
}
