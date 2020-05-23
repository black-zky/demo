package com.woniu.utils;

import lombok.Getter;

import javax.management.StandardEmitterMBean;

@Getter
public enum RestCode {

    SUCCESS(200,"成功"),
    FAIL(500,"失败");

    private Integer code;
    private String msg;

    RestCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
