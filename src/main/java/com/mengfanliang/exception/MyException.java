package com.mengfanliang.exception;

import com.mengfanliang.result.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyException {
    @ExceptionHandler(Exception.class)
    public R error(Exception e){
        //return R.myCode(408,e.getMessage());
        return R.serverError();

    }
    @ExceptionHandler(CategoryException.class)
    public R error(CategoryException e){
        return R.myCode(e.getStatus(),e.getMessage());
    }

}
