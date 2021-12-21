package com.gxjkzw.common.exception;

import com.gxjkzw.common.enums.ResultCode;
import com.gxjkzw.common.util.StrKit;

/**
 *  用户自定义业务异常
 */
public class UserDefinedException extends RuntimeException {

	private ResultCode exception;

	public UserDefinedException(Throwable e) {
		super(e.getMessage(), e);
	}

	public UserDefinedException(String message) {
		super(message);
	}

	public UserDefinedException(String messageTemplate, Object... params) {
		super(StrKit.format(messageTemplate, params));
	}

	public UserDefinedException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public UserDefinedException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrKit.format(messageTemplate, params), throwable);
	}

	public UserDefinedException(ResultCode exception) {
		super(exception.getMsg());
		this.exception = exception;
	}

	public UserDefinedException(ResultCode exception, String message) {
		super(message);
		this.exception = exception;
	}

	public ResultCode getException() {
		return exception;
	}

	public void setException(ResultCode exception) {
		this.exception = exception;
	}
}
