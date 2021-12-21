package com.gxjkzw.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author yi.qin
 * @since 2021-12-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 职位（角色）
     */
    private Long roleId;

    /**
     * 手机号码
     */
    private String phoneNum;

    /**
     * 用户类型 1：超管 2：公司管理 3：公司员工
     */
    private Integer type;

    /**
     * 状态，1：启用，0：禁用
     */
    private Boolean status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private Long createId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后更新
     */
    private LocalDateTime updateTime;

    /**
     * 删除标识
     */
    private Boolean del;

}
