package com.shuai.hehe.api.exception;

import com.shuai.hehe.api.response.ErrorCode;
import com.shuai.hehe.api.response.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一处理异常
 */
@ControllerAdvice
public class ServiceExceptionHandler {
    private final static Logger sLogger = LoggerFactory.getLogger(ServiceExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseInfo handle(Exception exception) {
        if(exception instanceof ServiceException){
            ServiceException serviceException= (ServiceException) exception;
            return new ResponseInfo(serviceException.getErrorCode(), serviceException.getMessage());
        }else{
            sLogger.error("未知异常",exception);
            return new ResponseInfo(ErrorCode.ERROR_UNKNOWN);
        }
    }
}
