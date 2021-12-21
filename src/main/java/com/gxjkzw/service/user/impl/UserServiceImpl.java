package com.gxjkzw.service.user.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gxjkzw.dao.mapper.UserMapper;
import com.gxjkzw.service.user.UserService;
import com.gxjkzw.common.bo.LoginUserInfo;
import com.gxjkzw.common.exception.NoAuthException;
import com.gxjkzw.common.util.DictCacheUtil;
import com.gxjkzw.common.util.MD5Kit;
import com.gxjkzw.dao.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @description:
 * @author：yi.qin
 * @date：2021/12/16
 * @version：1.0
 * @slogan：打铁还需自身硬
 */

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public LoginUserInfo login(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("login_name", username)
                .eq("del", Boolean.FALSE);
        int count = userMapper.selectCount(wrapper);
        if (count < 1) {
            throw new NoAuthException("用户名称不存在");
        }
        wrapper.clear();
        wrapper.eq("login_name", username)
                .eq("password", MD5Kit.md5(password.toLowerCase()));
        User user = userMapper.selectOne(wrapper);
        if (user == null) {
            throw new NoAuthException("用户名称或登录密码错误");
        }
        if (!user.getStatus()) {
            throw new NoAuthException("该用户未启用");
        }
        log.info("[login_name：{}][username：{}]登录成功", user.getLoginName(), user.getUsername());
        return loadLoginUser(user);
    }

    private LoginUserInfo loadLoginUser(User user) {
        // todo
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        BeanUtil.copyProperties(user, loginUserInfo);
        DictCacheUtil.getInstance().setLoginUserInfo(loginUserInfo);
        return loginUserInfo;
    }


    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        System.out.println(DateUtil.formatLocalDateTime(time));
    }
}
