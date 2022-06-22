package ru.otus.spring.ekaryagin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "app-settings")
@Component
public class LocalSettingsImpl implements LocalSettings{
    private String locale = "";
    private String questionsBaseName = "";
    private int thresholdLevel = 0;

    @Override
    public String getLocale() {
        return locale;
    }

    @Override
    public String getQuestionsBaseName() {
        return questionsBaseName;
    }

    @Override
    public int getThresholdLevel() {
        return thresholdLevel;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public void setQuestionsBaseName(String questionsBaseName) {
        this.questionsBaseName = questionsBaseName;
    }

    public void setThresholdLevel(int thresholdLevel) {
        this.thresholdLevel = thresholdLevel;
    }
}
