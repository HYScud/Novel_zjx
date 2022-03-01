package com.luyisac.novel_zjx.exception;

import com.luyisac.novel_zjx.enums.ResultEnums;

public class CommonException extends RuntimeException{

    private Integer errorCode= ResultEnums.ERROR.getCode();
    private String errorMsg;

    public CommonException(ResultEnums resultEnums) {
        this.errorCode = resultEnums.ERROR.getCode();
    }

    public CommonException(String message) {
        super(message);
        this.errorMsg=message;
   }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(Throwable cause, ResultEnums resultEnums) {
        super(resultEnums.getMsg(), cause);
        this.errorCode = resultEnums.ERROR.getCode();;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
