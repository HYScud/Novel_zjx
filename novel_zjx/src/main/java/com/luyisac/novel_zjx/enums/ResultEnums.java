package com.luyisac.novel_zjx.enums;

import lombok.Getter;

@Getter
public enum ResultEnums {
    SUCCESS(20000,"操作成功"),
    ERROR(40000,"操作失败"),
    DATA_NOT_FOUND(40001,"查询失败"),
    PARAMS_NULL(40002,"参数不能为空"),
    PARAMS_ERROR(40005,"参数不合法"),
    LOGIN_FAIL(40007,"用户名或密码不正确"),
    LOGIN_EMPTY(40008,"用户名或密码为空");


    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
