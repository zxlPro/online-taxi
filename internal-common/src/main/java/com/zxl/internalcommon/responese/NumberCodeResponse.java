package com.zxl.internalcommon.responese;

import lombok.Data;

/**
 * @className NumberCodeResponse
 * @Description 验证码返回实体类
 * @Author zxl
 * @Date 2024/5/1 00:13
 */
@Data
public class NumberCodeResponse {
    //验证码
    private int numberCode;
}
