package com.zxl.apipassenger.service;

import com.alibaba.fastjson2.JSONObject;
import com.zxl.apipassenger.remote.ServiceVerificationCodeClient;
import com.zxl.internalcommon.responese.NumberCodeResponse;
import com.zxl.internalcommon.responese.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description 获取验证码service
 * @author zxl
 * @date 2024/4/30 20:53
 */
@Service
public class VerificationCodeService {
    @Autowired
    private ServiceVerificationCodeClient serviceVerificationCodeClient;

     /**
      * @description TODO
      * @params passengerPhone
      * @return java.lang.String
      * @author zxl
      * @date 2024/4/30 20:49
      */
    public ResponseResult getVerificationCode(String passengerPhone){
        //调用验证码服务获取验证码
        System.out.println("调用验证码服务获取验证码");
        ResponseResult<NumberCodeResponse> numberResp =  serviceVerificationCodeClient.getNumberCode(6);
        int numberCode = numberResp.getData().getNumberCode();
        System.out.println("获取验证码服务返回验证码为："+numberCode);
        //存入redis
        System.out.println("存入redis");

        //返回响应值
        JSONObject respJson = new JSONObject();
        respJson.put("data","123456");
        return ResponseResult.success(respJson);

    }
}
