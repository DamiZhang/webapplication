package com.sk.userman.exception;

import com.sk.userman.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xbxqc
 */
@Slf4j
@ControllerAdvice
public class ResultExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Result<String> resultBindExceptionHandler(BindException e) {
        log.error("Exception:", e);

        StringBuilder errMsg = new StringBuilder();
        Result<String> result = new Result<String>();

        e.getAllErrors().forEach( x -> errMsg.append(x.getDefaultMessage()).append(","));
        result.setCode(400);
        result.setMsg(errMsg.toString());
        return result;
    }

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public Result<String> resultExceptionHandler(BusinessException e) {
        log.error("Exception:", e);
        Result<String> result = new Result<String>();
        result.setCode(400);
        result.setMsg(e.getMessage());
        return result;
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result<String> resultMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        StringBuilder errMsg = new StringBuilder();
        Result<String> result = new Result<String>();
        e.getBindingResult().getAllErrors().forEach( x -> errMsg.append(x.getDefaultMessage()).append(","));
        result.setCode(400);
        result.setMsg(errMsg.toString());
        return result;
    }


}

