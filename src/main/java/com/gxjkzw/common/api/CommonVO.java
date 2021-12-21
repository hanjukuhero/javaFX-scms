package com.gxjkzw.common.api;

import com.gxjkzw.common.enums.ResultCode;

/**
 * @description: 通用返回对象
 * @author：yi.qin
 * @date：2021/12/17
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
public class CommonVO<T> {
    /**
     * 状态码
     */
    private long code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据封装
     */
    private T data;

    public CommonVO() {
    }

    public CommonVO(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonVO<T> success(T data) {
        return new CommonVO<>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> CommonVO<T> success(T data, String message) {
        return new CommonVO<>(ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     * @param codeEnum 错误码
     */
    public static <T> CommonVO<T> fail(ResultCode codeEnum) {
        return new CommonVO<T>(codeEnum.getCode(), codeEnum.getMsg(), null);
    }

    public long getCode() {
        return code;
    }

    public void setCode(ResultCode code) {
        this.code = code.getCode();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
