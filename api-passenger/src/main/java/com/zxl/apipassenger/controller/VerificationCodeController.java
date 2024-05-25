package com.zxl.apipassenger.controller;

import com.zxl.apipassenger.request.VerificationCodeRequest;
import com.zxl.apipassenger.service.VerificationCodeService;
import com.zxl.internalcommon.responese.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description 请求验证码controller
 * @author zxl
 * @date 2024/4/30 20:52
 */
@RestController
public class VerificationCodeController {

    @Autowired
    private VerificationCodeService verificationCodeService;

    /**
     * @description 请求手机验证码方法
     * @params request
     * @return java.lang.String
     * @author zxl
     * @date 2024/4/30 20:51
     */
    @GetMapping("/verification-code")
    public ResponseResult verificationCodeController(@RequestBody VerificationCodeRequest request){
        String phone = request.getPassengerPhone();
        System.out.println("接收到传入的手机号："+phone);
        return verificationCodeService.getVerificationCode(phone);
    }

}
