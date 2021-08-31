package com.realbizgames.demo.mongo.exception;

import com.realbizgames.demo.mongo.consts.ServiceErrorCode;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

public class BaseServiceException extends RuntimeException {
    public static BaseServiceException of(ServiceErrorCode errorCode, String msg) {
        return new BaseServiceException(errorCode, msg);
    }

    public static BaseServiceException of(ServiceErrorCode errorCode, MessageSource messageSource, String key) {
        String msg = messageSource.getMessage(key, null, LocaleContextHolder.getLocale());
        return new BaseServiceException(errorCode, msg);
    }

    public static BaseServiceException of(ServiceErrorCode errorCode, MessageSource messageSource, String key, Object... params) {
        String msg = messageSource.getMessage(key, params, LocaleContextHolder.getLocale());
        return new BaseServiceException(errorCode, msg);
    }

    ServiceErrorCode errorCode;

    public BaseServiceException(ServiceErrorCode errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public ServiceErrorCode getErrorCode() {
        return errorCode;
    }
}
