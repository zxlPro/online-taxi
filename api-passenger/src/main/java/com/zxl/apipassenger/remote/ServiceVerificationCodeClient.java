package com.zxl.apipassenger.remote;

import com.zxl.internalcommon.responese.NumberCodeResponse;
import com.zxl.internalcommon.responese.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

/**
 * @className ServiceVerificationCodeClient
 * @Description 远程调用验证码服务接口
 * @Author zxl
 * @Date 2024/5/1 11:39
 */
@FeignClient("service-verificationcode")
public interface ServiceVerificationCodeClient {

    /**
     * @description 获取验证码
     * @params size
     * @return com.zxl.internalcommon.responese.ResponseResult<com.zxl.internalcommon.responese.NumberCodeResponse>
     * @author zxl
     * @date 2024/5/1 11:43
     */
    @RequestMapping(method = RequestMethod.GET,value = "/numbercode/{size}")
    ResponseResult<NumberCodeResponse> getNumberCode(@PathVariable("size") int size);
}
