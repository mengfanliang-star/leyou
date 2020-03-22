package com.mengfanliang.result;

public enum ResultCode {
    OK(200,"查询成功"),
    CREATED(201,"创建成功"),
    DELETED(204,"删除或者更新成功"),
    BAD_REQUEST(400,"参数不正确"),
    NOT_FIND(404,"资源服务器未找到"),
    SERVER_ERROR(500,"内部错误");
    private Integer status;
    private String msg;

    ResultCode(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
