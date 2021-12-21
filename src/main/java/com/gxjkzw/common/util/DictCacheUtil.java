package com.gxjkzw.common.util;

import com.gxjkzw.common.bo.LoginUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @description: 缓存工具类
 * @author：yi.qin
 * @date：2021/12/16
 * @version：1.0
 * @slogan：打铁还需自身硬
 */

@Component
@Slf4j
public class DictCacheUtil implements ApplicationRunner {

    public static LoginUserInfo LOGIN_USER_INFO = new LoginUserInfo();

    /**
     * 登录后保存用户登录信息
     * @param loginUserInfo
     */
    public void setLoginUserInfo(LoginUserInfo loginUserInfo) {
        LOGIN_USER_INFO = loginUserInfo;
    }

    public void initialize() {

    }

    /**
     * 单例：饿汉式，系统启动即加载
     */
    private static class CacheUtilHandle {
        static DictCacheUtil instance = new DictCacheUtil();
    }

    public static DictCacheUtil getInstance() {
        return CacheUtilHandle.instance;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        long start = System.currentTimeMillis();
        log.info("---------- 开始加载缓存 ----------");
        this.initialize();
        long end = System.currentTimeMillis();
        long time = (end - start) / 1000;
        log.info("---------- 加载缓存结束 耗时 {} 秒 ----------", time);
    }
}
