package com.gxjkzw.controller;

import cn.hutool.core.util.StrUtil;
import com.gxjkzw.Main;
import com.gxjkzw.common.bo.LoginUserInfo;
import com.gxjkzw.common.util.MD5Kit;
import com.gxjkzw.lib.DialogBuilder;
import com.gxjkzw.service.user.UserService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

@Component
@Slf4j
public class LoginController {

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextField usernameField;

    @FXML
    private JFXButton btnLogin;

    @Resource
    UserService userService;

    @Resource
    Main main;

    @FXML
    void login() throws IOException {
        log.info("点击登录按钮");
        if (StrUtil.isEmpty(usernameField.getText())) {
            new DialogBuilder(btnLogin).setTitle("提示").setMessage("用户名称不能为空").setNegativeBtn("确定").create();
            return;
        }
        if (StrUtil.isEmpty(passwordField.getText())) {
            new DialogBuilder(btnLogin).setTitle("提示").setMessage("登录密码不能为空").setNegativeBtn("确定").create();
            return;
        }
        // 转码
        String password = MD5Kit.md5(passwordField.getText());
        LoginUserInfo loginUserInfo = userService.login(usernameField.getText(), password);
        new DialogBuilder(btnLogin).setTitle("提示").setMessage(loginUserInfo.getUsername() + "登录成功").setNegativeBtn("确定").create();
        main.gotoMain();

        // ClassPathResource resource = new ClassPathResource(ResourcesCfg.MAIN_VIEW_PATH);
        // Parent root = FXMLLoader.load(resource.getURL());
        // Stage stage = new Stage();
        // Scene scene = new Scene(root, ResourcesCfg.STAGE_WIDTH, ResourcesCfg.STAGE_HEIGHT);
        // stage.setTitle("xxx");
        // stage.setScene(scene);
        // stage.show();
        // stage.setOnCloseRequest(event -> {
        //     System.out.println("正在关闭当前窗口");
        //     stage.close();
        // });
    }


}
