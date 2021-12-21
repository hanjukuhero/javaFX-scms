package com.gxjkzw.dao.mapper;

import com.gxjkzw.dao.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author yi.qin
 * @since 2021-12-16
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
