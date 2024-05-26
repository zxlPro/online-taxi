package com.zxl.apipassenger.service;

import com.alibaba.fastjson2.JSONObject;
import com.zxl.apipassenger.remote.ServiceVerificationCodeClient;
import com.zxl.internalcommon.responese.NumberCodeResponse;
import com.zxl.internalcommon.responese.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description 获取验证码service
 * @author zxl
 * @date 2024/4/30 20:53
 */
@Service
public class VerificationCodeService {
    @Autowired
    private ServiceVerificationCodeClient serviceVerificationCodeClient;

    private String verificationCodePrefix = "PASSENGER_VERIFICATION_CODE_";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

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
        String key = verificationCodePrefix+passengerPhone;
        stringRedisTemplate.opsForValue().set(key,String.valueOf(numberCode),2, TimeUnit.MINUTES);
        //通过短信发送验证码

        return ResponseResult.success();

    }
}
