package com.zxl.internalcommon.constant;

import lombok.Data;
import lombok.Getter;

/**
 * @className StatusCodeEnum
 * @Description 返回状态码
 * @Author zxl
 * @Date 2024/4/30 23:56
 */
public enum StatusCodeEnum {

    SUCCESS(200,"success"),
    FAIL(500,"fail");

    @Getter
    private int code;
    @Getter
    private String value;



    StatusCodeEnum(int code,String value){
        this.code = code;
        this.value = value;
    }


}
