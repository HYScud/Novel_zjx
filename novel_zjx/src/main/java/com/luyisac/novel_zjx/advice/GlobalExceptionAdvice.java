package com.luyisac.novel_zjx.advice;

import com.luyisac.novel_zjx.common.Result;
import com.luyisac.novel_zjx.exception.CommonException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(CommonException.class)
    public Result<?> exceptionHandler(CommonException commonException){
        System.out.println(new Result<>(commonException.getErrorCode(),commonException.getMessage()));
        return new Result<>(commonException.getErrorCode(),commonException.getMessage());
    }
}
