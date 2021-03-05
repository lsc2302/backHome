package com.lsc.backhome.common.api;


public enum ApiErrorCode implements IErrorCode {


    SUCCESS(200, "Success"),

    FAILED(-1, "Fail"),

    UNAUTHORIZED(401, "unauthorized"),

    FORBIDDEN(403, "No permission"),

    VALIDATE_FAILED(404, "validation Failed");

    private final Integer code;
    private final String message;

    ApiErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ApiErrorCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
