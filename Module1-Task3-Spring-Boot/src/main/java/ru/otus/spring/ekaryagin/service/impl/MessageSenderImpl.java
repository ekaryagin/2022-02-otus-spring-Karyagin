package ru.otus.spring.ekaryagin.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.spring.ekaryagin.service.IOService;
import ru.otus.spring.ekaryagin.service.MessageSender;
import ru.otus.spring.ekaryagin.service.MessageService;

@Service
public class MessageSenderImpl implements MessageSender {

    private final IOService ioService;
    private final MessageService messageService;

    public MessageSenderImpl(IOService ioService, MessageService messageService) {
        this.ioService = ioService;
        this.messageService = messageService;
    }

    @Override
    public void sendMessage(String messageId) {
        ioService.outputText(messageService.getMessage(messageId));
    }

    @Override
    public void sendMessageLn(String messageId) {
        ioService.outputTextLn(messageService.getMessage(messageId));
    }

    @Override
    public void sendMessageFormatted(String messageId, Object... args) {
        ioService.outputTextLn(String.format(messageService.getMessage(messageId), args));
    }
}
