package ru.otus.spring.ekaryagin.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.spring.ekaryagin.config.LocalSettings;
import ru.otus.spring.ekaryagin.service.LocaleProvider;
import ru.otus.spring.ekaryagin.service.QuestionResourceNameService;

import java.util.Locale;

@Service
public class QuestionResourceNameServiceImpl implements QuestionResourceNameService {

    private static final String SEPARATOR = "_";
    private static final String EXTENSION = ".csv";
    private final LocaleProvider localeProvider;
    private final LocalSettings localSettings;

    public QuestionResourceNameServiceImpl(LocaleProvider localeProvider, LocalSettings localSettings) {
        this.localeProvider = localeProvider;
        this.localSettings = localSettings;
    }

    @Override
    public String getResourceName() {
        Locale local = localeProvider.getLocale();
        String questionsBaseName = localSettings.getQuestionsBaseName();
        String language =  local.getLanguage();
        String country = local.getCountry();
        if (!language.isEmpty()){
            return questionsBaseName+SEPARATOR+language+SEPARATOR+country+EXTENSION;
        }
        return questionsBaseName+EXTENSION;
    }
}
