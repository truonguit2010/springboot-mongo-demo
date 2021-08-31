package com.realbizgames.demo.mongo.config;

import com.realbizgames.demo.mongo.consts.AppConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class MessageSourceConfig extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    private static final List<Locale> LOCALES = Arrays.asList(AppConstants.LOCALE_VI, AppConstants.LOCALE_EN);

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String headerLang = request.getHeader("Accept-Language");
        LocaleContextHolder.setDefaultLocale(AppConstants.LOCALE_VI);
        LocaleContextHolder.setLocale(AppConstants.LOCALE_VI);

        return headerLang == null || headerLang.isBlank()
                ? AppConstants.LOCALE_VI
                : Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
    }

    @Bean
    public LocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(AppConstants.LOCALE_VI);
        return acceptHeaderLocaleResolver;
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasenames("i18n/messages");
        rs.setDefaultEncoding("UTF-8");
        rs.setUseCodeAsDefaultMessage(true);

        return rs;
    }
}
