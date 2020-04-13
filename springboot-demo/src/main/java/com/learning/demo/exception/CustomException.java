package com.learning.demo.exception;

import com.learning.demo.response.StatusCode;
import lombok.Getter;

import java.text.MessageFormat;

@Getter
public class CustomException extends RuntimeException {
    //错误代码
    private StatusCode resultCode;

    public CustomException(StatusCode resultCode){
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public CustomException(StatusCode resultCode, Object... args){
        super(resultCode.getMessage());
        String message = MessageFormat.format(resultCode.getMessage(), args);
        resultCode.setMessage(message);
        this.resultCode = resultCode;
    }
}
