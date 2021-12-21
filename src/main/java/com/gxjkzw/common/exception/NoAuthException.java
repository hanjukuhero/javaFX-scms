package com.gxjkzw.common.exception;

/**
 * 功能描述：
 * 权限不足异常
 * @Author: hyj
 * @Date: 2021/1/29 16:17
 */
public class NoAuthException extends UserDefinedException {

	public NoAuthException(Throwable e) {
        super(e.getMessage(), e);
    }

	public NoAuthException(String message) {
        super(message);
    }


}
