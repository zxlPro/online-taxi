package com.zxl.serviceverificationcode.controller;

import com.zxl.internalcommon.responese.NumberCodeResponse;
import com.zxl.internalcommon.responese.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className NumberCodeController
 * @Description 获取验证码controller
 * @Author zxl
 * @Date 2024/4/30 23:19
 */
@RestController
public class NumberCodeController {

    /**
     * @description 返回验证码
     * @params size
     * @return java.lang.String
     * @author zxl
     * @date 2024/4/30 23:23
     */
    @RequestMapping("/numbercode/{size}")
    public ResponseResult getNumberCode(@PathVariable int size){
        System.out.println("获取验证码方法size："+size);
        //随机生成指定size的验证码
        double mathRandom = (Math.random()*9+1)*Math.pow(10,size-1);
        int resultInt = (int)mathRandom;
        System.out.println("验证码服务生成验证码："+resultInt);
        //组装验证码响应实体类
        NumberCodeResponse response = new NumberCodeResponse();
        response.setNumberCode(resultInt);
        return ResponseResult.success(response);

    }
}
