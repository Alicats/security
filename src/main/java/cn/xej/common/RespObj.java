package cn.xej.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespObj {

    private int code;
    private String message;
    private Object data;

    public static RespObj succ(Object data) {
        return succ(200, "操作成功", data);
    }

    public static RespObj succ(int code, String msg, Object data) {
        RespObj r = new RespObj();
        r.setCode(code);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }

    public static RespObj fail(String msg) {
        return fail(400, msg, null);
    }

    public static RespObj fail(String msg, Object data) {
        return fail(400, msg, data);
    }

    public static RespObj fail(int code, String msg, Object data) {
        RespObj r = new RespObj();
        r.setCode(code);
        r.setMessage(msg);
        r.setData(data);
        return r;
    }

}
