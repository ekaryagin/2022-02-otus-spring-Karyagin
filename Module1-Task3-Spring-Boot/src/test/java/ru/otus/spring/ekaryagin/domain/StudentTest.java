package ru.otus.spring.ekaryagin.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Class Student")
class StudentTest {

    @DisplayName("correctly created by the constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        Student student = new Student("Джеймс", "Гослинг");
        assertAll("Student",
                () -> assertEquals("Джеймс", student.getFirstName()),
                () -> assertEquals("Гослинг", student.getLastName())
        );
    }
}