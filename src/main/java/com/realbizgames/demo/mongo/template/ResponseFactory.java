package com.realbizgames.demo.mongo.template;

import org.springframework.http.HttpStatus;

public class ResponseFactory {
    public static <T> ResponseTemplate<T> success(String message, T data) {
        ResponseTemplate<T> result = new ResponseTemplate();
        ResponseTemplate.Status status = new ResponseTemplate.Status();

        status.setSuccess(true);
        status.setCode(HttpStatus.OK.value());
        status.setMessage(message);
        result.setStatus(status);
        result.setData(data);

        return result;
    }

    public static <T> ResponseTemplate<T> success(String message) {
        return success(message, null);
    }

    public static <T> ResponseTemplate<T> success(T data) {
        return success("Success", data);
    }

    public static <T> ResponseTemplate<T> success() {
        return success("Success", null);
    }

    public static <T> ResponseTemplate<T> failed(int code, String message, T data) {
        ResponseTemplate.Status status = new ResponseTemplate.Status();
        status.setSuccess(false);
        status.setCode(code);
        status.setMessage(message);

        ResponseTemplate<T> result = new ResponseTemplate();
        result.setStatus(status);
        result.setData(data);
        return result;
    }

    public static <T> ResponseTemplate<T> failed(String message, T data) {
        return failed(HttpStatus.BAD_REQUEST.value(), message, data);
    }

    public static <T> ResponseTemplate<T> failed(Integer code, String message) {
        return failed(code, message, null);
    }

    public static <T> ResponseTemplate<T> failed() {
        return failed(HttpStatus.BAD_REQUEST.value(), "Failed", null);
    }
}
