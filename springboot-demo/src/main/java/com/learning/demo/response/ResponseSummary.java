package com.learning.demo.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ResponseSummary<T> {
    //操作代码
    int status;

    //提示信息
    String message;

    //结果数据
    T data;

    public ResponseSummary(StatusCode statusCode){
        this.status = statusCode.getCode();
        this.message = statusCode.getMessage();
    }

    public ResponseSummary(StatusCode statusCode, T data){
        this.status = statusCode.getCode();
        this.message = statusCode.getMessage();
        this.data = data;
    }

    public ResponseSummary(String message){
        this.message = message;
    }

    public static ResponseSummary SUCCESS(){
        return new ResponseSummary(StatusCode.SUCCESS);
    }

    public static <T> ResponseSummary SUCCESS(T data){
        return new ResponseSummary(StatusCode.SUCCESS, data);
    }

    public static ResponseSummary FAIL(){
        return new ResponseSummary(StatusCode.FAIL);
    }

    public static ResponseSummary FAIL(String message){
        return new ResponseSummary(message);
    }

    public static <T> ResponseSummary createSummary(StatusCode statusCode, T data){
        return new ResponseSummary(statusCode, data);
    }

    public static ResponseSummary createSummary(StatusCode statusCode){
        return new ResponseSummary(statusCode);
    }
}
