package ru.otus.spring.ekaryagin.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.spring.ekaryagin.config.LocalSettings;
import ru.otus.spring.ekaryagin.service.LocaleProvider;

import java.util.Locale;

@Service
public class LocaleProviderImpl implements LocaleProvider {
    private final Locale locale;

    public LocaleProviderImpl(LocalSettings localSettings) {
        locale = Locale.forLanguageTag(localSettings.getLocale());
    }

    @Override
    public Locale getLocale() {
        return locale;
    }
}
