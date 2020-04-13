package com.learning.demo.exception.handler;

import com.learning.demo.exception.CustomException;
import com.learning.demo.response.ResponseSummary;
import com.learning.demo.response.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(CustomException.class)
    public ResponseSummary handleException(CustomException e) {
        // 打印异常信息
        log.error("### 异常信息:{} ###", e.getMessage());
        return new ResponseSummary(e.getResultCode());
    }

    /**
     * 参数错误异常
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResponseSummary handleException(Exception e) {

        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException validException = (MethodArgumentNotValidException) e;
            BindingResult result = validException.getBindingResult();
            StringBuffer errorMsg = new StringBuffer();
            if (result.hasErrors()) {
                List<ObjectError> errors = result.getAllErrors();
                errors.forEach(p ->{
                    FieldError fieldError = (FieldError) p;
                    errorMsg.append(fieldError.getDefaultMessage()).append(",");
                    log.error("### 请求参数错误：{"+fieldError.getObjectName()+"},field{"+fieldError.getField()+ "},errorMessage{"+fieldError.getDefaultMessage()+"}"); });
            }
        } else if (e instanceof BindException) {
            BindException bindException = (BindException)e;
            if (bindException.hasErrors()) {
                log.error("### 请求参数错误: {}", bindException.getAllErrors());
            }
        }

        return new ResponseSummary(StatusCode.PARAM_IS_INVALID);
    }

    /**
     * 处理所有不可知的异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseSummary handleOtherException(Exception e){
        //打印异常堆栈信息
        e.printStackTrace();
        // 打印异常信息
        log.error("### 不可知的异常:{} ###", e.getMessage());
        return new ResponseSummary(StatusCode.SYSTEM_INNER_ERROR);
    }
}
