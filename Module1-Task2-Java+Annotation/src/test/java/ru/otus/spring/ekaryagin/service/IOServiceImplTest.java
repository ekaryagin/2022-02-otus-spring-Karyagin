package ru.otus.spring.ekaryagin.service;

import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Class IOServiceImpl")
class IOServiceImplTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private IOService ioService;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        ioService = new IOServiceImpl(new IOProviderConsole());
    }

    @Test
    void outputText() {
        ioService.outputText("Test");
        assertEquals("Test", outContent.toString());
    }

    @Test
    void outputTextLn() {
        ioService.outputTextLn("Test1");
        String lineSeparator = System.lineSeparator();
        assertEquals("Test1" + lineSeparator, outContent.toString());
    }

    @Test
    void inputText() {
        String data = "Test2";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));
            IOService ioService1 = new IOServiceImpl(new IOProviderConsole());
            assertEquals("Test2", ioService1.inputText());
        } finally {
            System.setIn(stdin);
        }
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }
}