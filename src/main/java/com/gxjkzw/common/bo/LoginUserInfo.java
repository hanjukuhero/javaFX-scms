package com.gxjkzw.common.bo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @description: 登录用户信息
 * @author：yi.qin
 * @date：2021/12/16
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
@Data
public class LoginUserInfo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 登录名
     */
    private String loginName;

    /**
     * 工号
     */
    private String empNo;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phoneNum;

    /**
     * 用户类型 1：超管 2：公司管理 3：公司员工
     */
    private Integer type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;
}
