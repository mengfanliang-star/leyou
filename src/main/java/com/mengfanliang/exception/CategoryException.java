package com.mengfanliang.exception;

public class CategoryException extends Exception{
    private Integer status;
    public CategoryException(Integer status,String message) {
        super(message);
        this.status=status;
    }

    public Integer getStatus() {
        return status;
    }


}
