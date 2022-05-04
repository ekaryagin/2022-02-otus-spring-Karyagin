package ru.otus.spring.ekaryagin.service.impl;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.spring.ekaryagin.service.LocaleProvider;
import ru.otus.spring.ekaryagin.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
    private final LocaleProvider localeProvider;
    private final MessageSource messageSource;

    public MessageServiceImpl(LocaleProvider localeProvider, MessageSource messageSource) {
        this.localeProvider = localeProvider;
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String messageId) {
        return messageSource.getMessage(messageId, null,
                "We have not found a message for this situation, sorry =( !",localeProvider.getLocale());
    }
}