package com.lsc.backhome.common.exception;

import com.lsc.backhome.common.api.IErrorCode;


public class ApiAsserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
