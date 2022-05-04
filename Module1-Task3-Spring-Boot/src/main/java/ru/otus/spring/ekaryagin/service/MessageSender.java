package ru.otus.spring.ekaryagin.service;

public interface MessageSender {
    void sendMessage(String messageId);
    void sendMessageLn(String messageId);
    void sendMessageFormatted(String messageId, Object... args);
}
