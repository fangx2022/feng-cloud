package com.feng.cloud.domain;

/**
 * @Description://TODO
 * @Author: fangx
 * @Data 2024年07月14日 23:21
 */
public class ResponseDTO<T> {

    private Integer code;

    private String msg;

    private T data;

    public ResponseDTO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static ResponseDTO error(Integer code, String msg){
        return new ResponseDTO(code,msg);
    }
}
