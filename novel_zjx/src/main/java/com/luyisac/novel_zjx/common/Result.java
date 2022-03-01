package com.luyisac.novel_zjx.common;

import com.luyisac.novel_zjx.enums.ResultEnums;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;
    private List<T> datalist;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Result(Integer code, String msg, List<T> datalist) {
        this.code = code;
        this.msg = msg;
        this.datalist = datalist;
    }
    public Result(Integer code) {
        this.code = code;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result() {
        this.code = ResultEnums.SUCCESS.getCode();
        this.msg =  ResultEnums.SUCCESS.getMsg();
    }

    public Result(Integer code, String msg, T data, List<T> datalist) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.datalist = datalist;
    }
}
