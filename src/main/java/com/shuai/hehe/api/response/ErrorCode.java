package com.shuai.hehe.api.response;

/**
 *
 */
public enum ErrorCode {
    ERROR_UNKNOWN(-1,"unknown error"),
    ERROR_SUCCESS(0,"success"),
    // 发送验证码失败
    ERROR_SEND_VERIFICATION_CODE(1,"send verification code fail")
    ;

    private int mErrorCode;
    private String mMessage;

    ErrorCode(int errorCode, String message) {
        this.mErrorCode = errorCode;
        this.mMessage = message;
    }

    public int getErrorCode() {
        return mErrorCode;
    }

    public void setErrorCode(int errorCode) {
        this.mErrorCode = errorCode;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        this.mMessage = message;
    }
}
