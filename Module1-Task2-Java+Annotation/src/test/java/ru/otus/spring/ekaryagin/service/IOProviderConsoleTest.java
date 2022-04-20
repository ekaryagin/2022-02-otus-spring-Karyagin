package ru.otus.spring.ekaryagin.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Class IOProviderConsole")
class IOProviderConsoleTest {

    @DisplayName("correctly created by the constructor")
    @Test
    void shouldHaveCorrectConstructor() {
        IOProviderConsole ioProvider = new IOProviderConsole();
        assertAll("question",
                () -> assertEquals(System.in, ioProvider.getIn()),
                () -> assertEquals(System.out, ioProvider.getOut())
        );
    }
}