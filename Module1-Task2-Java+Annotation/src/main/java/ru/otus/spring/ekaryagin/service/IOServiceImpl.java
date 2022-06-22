package ru.otus.spring.ekaryagin.service;

import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.Scanner;

@Service
public class IOServiceImpl implements IOService {

    private final PrintStream printStream;
    private final Scanner inputScanner;

    public IOServiceImpl(IOProvider ioProvider) {
        this.printStream = ioProvider.getOut();
        inputScanner = new Scanner(ioProvider.getIn());
    }

    @Override
    public void outputTextLn(String text) {
        printStream.println(text);
    }

    @Override
    public void outputText(String text) {
        printStream.print(text);
    }

    @Override
    public String inputText() {
        return inputScanner.nextLine();
    }
}
