package com.gxjkzw.service.user;

import com.gxjkzw.common.bo.LoginUserInfo;

public interface UserService {
    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    LoginUserInfo login(String username, String password);
}
