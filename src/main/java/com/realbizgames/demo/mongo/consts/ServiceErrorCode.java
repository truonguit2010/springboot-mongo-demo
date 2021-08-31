package com.realbizgames.demo.mongo.consts;

public enum ServiceErrorCode {
    USER_ID_NULL_OR_EMPTY_EXCEPTION(21083100),
    USER_NOT_FOUND_EXCEPTION(21083101),
    ;
    int code;

    ServiceErrorCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
