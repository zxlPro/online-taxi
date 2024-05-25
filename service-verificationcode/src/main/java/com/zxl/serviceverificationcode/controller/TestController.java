package com.zxl.serviceverificationcode.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className TestController
 * @Description TODO
 * @Author zxl
 * @Date 2024/4/30 21:32
 */
@RestController
public class TestController {

    /**
     * @description 测试方法
     * @params
     * @return java.lang.String
     * @author zxl
     * @date 2024/4/30 21:34
     */
    @RequestMapping("/test")
    public String test(){
        System.out.println("验证码服务测试controller");
        return "test";
    }

}
