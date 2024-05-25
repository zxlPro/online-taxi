package com.zxl.apipassenger.request;

import lombok.Data;

/**
 * @description 接受验证码请求类
 * @author zxl
 * @date 2024/4/30 21:02
 */
@Data
public class VerificationCodeRequest {
    /**
     * 手机号
     */
    private String passengerPhone;
}
