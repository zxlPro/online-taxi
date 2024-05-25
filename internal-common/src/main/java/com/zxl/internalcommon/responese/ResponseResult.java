package com.zxl.internalcommon.responese;

import com.zxl.internalcommon.constant.StatusCodeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @className ResponseResult
 * @Description 统一返回响应实体类
 * @Author zxl
 * @Date 2024/5/1 00:00
 */
@Data
//设置链式调用
@Accessors(chain = true)
public class ResponseResult <T>{

    private int code;

    private String message;

    private T data;

    /**
     * @description 返回成功
     * @params data
     * @return com.zxl.internalcommon.responese.ResponseResult<T>
     * @author zxl
     * @date 2024/5/1 00:03
     */
    public static <T> ResponseResult  success(T data){
        return new ResponseResult().setCode(StatusCodeEnum.SUCCESS.getCode())
                .setMessage(StatusCodeEnum.SUCCESS.getValue())
                .setData(data);
    }

    /**
     * @description 失败返回 错误吗及错误详情
     * @params code
    message
     * @return com.zxl.internalcommon.responese.ResponseResult
     * @author zxl
     * @date 2024/5/1 00:06
     */
    public static ResponseResult fail(int code,String message){
        return new ResponseResult().setCode(code)
                .setMessage(message);
    }

    /**
     * @description 失败 返回错误码/错误信息/错误详情
     * @params code
    message
    data
     * @return com.zxl.internalcommon.responese.ResponseResult
     * @author zxl
     * @date 2024/5/1 00:07
     */
    public static <T> ResponseResult fial(int code,String message,T data){
        return new ResponseResult().setCode(code)
                .setMessage(message)
                .setData(data);
    }

    /**
     * @description 失败 默认返回
     * @params data
     * @return com.zxl.internalcommon.responese.ResponseResult
     * @author zxl
     * @date 2024/5/1 00:10
     */
    public static <T> ResponseResult fail(T data){
        return new ResponseResult().setCode(StatusCodeEnum.FAIL.getCode())
                .setMessage(StatusCodeEnum.FAIL.getValue())
                .setData(data);

    }

}
