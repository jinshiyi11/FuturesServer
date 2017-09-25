package com.shuai.hehe.api.response;

import com.google.gson.annotations.SerializedName;

/**
 *
 */
public class ResponseInfo<T> {
    @SerializedName("errorCode")
    private int mErrorCode = ErrorCode.ERROR_SUCCESS.getErrorCode();

    @SerializedName("msg")
    private String mMessage;

    @SerializedName("data")
    private T mData;

    public ResponseInfo() {
    }

    public ResponseInfo(int errorCode, String message) {
        mErrorCode = errorCode;
        mMessage = message;
    }

    public ResponseInfo(ErrorCode error) {
        mErrorCode = error.getErrorCode();
        mMessage = error.getMessage();
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

    public T getData() {
        return mData;
    }

    public void setData(T data) {
        this.mData = data;
    }
}
