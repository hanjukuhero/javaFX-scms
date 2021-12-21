package com.gxjkzw.common.enums;

/**
 * 
 * @author junkezhou
 *
 */
public enum ResultCode {

	/**
	 * 占位符,无具体业务使用意义.
	 */
	PLACEHOLDER(0, "占位符,无具体业务使用意义."),

	/**
	 * 成功！
	 */
	SUCCESS(1, "成功！"),

	/**
	 * 服务器内部错误！
	 */
	SERVER_INNER_ERROR(2, "服务器出错了，请稍后重试！"),

	/**
	 * 用户未登录！
	 */
	NOT_LOGGED_IN(3, "用户未登录或登录失效！"),

	/**
	 * 用户资料未补全！
	 */
	PROFILE_MISSING(4, "用户资料不完整！"),

	/**
	 * 请求错误！
	 */
	REQUEST_ERROR(5, "业务异常！请求参数缺失"),

	/**
	 * 权限不足
	 */
	NO_AUTH(6, "没有相关权限");

	private Integer code;
	private String msg;

	ResultCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	// /**
	//  * 根据传入的数值获得相应的枚举值
	//  *
	//  * @param sourceCode
	//  *            需要传入的数值
	//  * @return 返回数值对应的枚举值对象
	//  * @throws BusinessException
	//  *             如果传入的数值为空或者无法匹配的合法的枚举值则抛出异常
	//  */
	// public static ResultCode getCodeEnum(Integer sourceCode) throws BusinessException {
	// 	ResultCode result = null;
	//
	// 	if (null == sourceCode)
	// 		throw new BusinessException("参数sourceCode不能为NULL!");
	//
	// 	for (ResultCode enumObj : ResultCode.values()) {
	// 		if (enumObj.getCode().equals(sourceCode))
	// 			result = enumObj;
	// 	}
	//
	// 	if (null == result) {
	// 		throw new BusinessException("无法匹配到合法的枚举值!");
	// 	} else if (PLACEHOLDER.equals(result)) {
	// 		throw new BusinessException("不能使用占位符枚举值!");
	// 	}
	// 	return result;
	// }
}
