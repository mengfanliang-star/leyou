package com.mengfanliang.result;

import java.util.HashMap;
import java.util.Map;

public class R {
    private Integer status;
    private String msg;
    private Map<String,Object> data =new HashMap<String,Object>();

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
    private R(){

    }

    public static R ok(){
        R r=new R();
        r.setStatus(ResultCode.OK.getStatus());
        r.setMsg(ResultCode.OK.getMsg());
        return r;
    }


    public static R badRequest(){
        R r=new R();
        r.setStatus(ResultCode.BAD_REQUEST.getStatus());
        r.setMsg(ResultCode.BAD_REQUEST.getMsg());
        return r;

    }
    
    public static R serverError(){
        R r=new R();
        r.setStatus(ResultCode.SERVER_ERROR.getStatus());
        r.setMsg(ResultCode.SERVER_ERROR.getMsg());
        return r;
    }
    
    public static R notFound(){
        R r=new R();
        r.setStatus(ResultCode.NOT_FIND.getStatus());
        r.setMsg(ResultCode.NOT_FIND.getMsg());
        return r;
    }

    public static R myCode(Integer status,String msg){
        R r=new R();
        r.setStatus(status);
        r.setMsg(msg);
        return r;
    }
    
    public R date(Map<String,Object> map){
        this.setData(map);
        return this;
    }
    
    public R date(String key,Object value){
        this.data.put(key,value);
        return this;
    }
}
