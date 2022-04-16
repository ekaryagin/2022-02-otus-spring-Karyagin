package ru.otus.spring.ekaryagin.service;

import java.io.InputStream;
import java.io.PrintStream;

public class IOProviderConsole implements IOProvider{

    private final InputStream in;
    private final PrintStream out;

    public IOProviderConsole() {
        this.in = System.in;
        this.out = System.out;
    }

    @Override
    public InputStream getIn() {
        return in;
    }

    @Override
    public PrintStream getOut() {
        return out;
    }
}
