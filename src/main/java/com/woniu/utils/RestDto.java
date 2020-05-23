package com.woniu.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestDto<T> {
    private Integer code;
    private String msg;
    private T data;

    public RestDto(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestDto(T data) {
        this.data = data;
    }

    public static RestDto OK(){
        return new RestDto(RestCode.SUCCESS.getCode(),RestCode.SUCCESS.getMsg());
    }

    public static <T>RestDto OK(T data){
        return new RestDto(RestCode.SUCCESS.getCode(),RestCode.SUCCESS.getMsg(), data);
    }

    public static RestDto FAIL(){
        return new RestDto(RestCode.FAIL.getCode(),RestCode.FAIL.getMsg());
    }

    public static <T>RestDto FAIL(T data){
        return new RestDto(RestCode.FAIL.getCode(),RestCode.FAIL.getMsg(),data);
    }
}