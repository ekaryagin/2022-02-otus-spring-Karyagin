package ru.otus.spring.ekaryagin.service;

import java.io.InputStream;
import java.io.PrintStream;

public interface IOProvider {

    InputStream getIn();

    PrintStream getOut();
}
