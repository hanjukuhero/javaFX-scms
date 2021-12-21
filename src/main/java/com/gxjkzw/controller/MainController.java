package com.gxjkzw.controller;

import com.gxjkzw.Main;
import com.gxjkzw.config.ResourcesCfg;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @description: 主页面
 * @author：yi.qin
 * @date：2021/12/17
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
@Component
@Slf4j
public class MainController implements Initializable {

    @Resource
    Main main;

    @FXML
    private JFXButton btnLogout;

    @FXML
    private WebView webView;

    @FXML
    void logout(ActionEvent event) {
        main.gotoLogin();
    }

    @FXML
    void clickOnLoad() throws IOException {
        if (webView != null) {
            WebEngine webEngine = webView.getEngine();
            ClassPathResource resource = new ClassPathResource(ResourcesCfg.HTML_CHART_PATH);
            webEngine.load(resource.getURL().toExternalForm());
            System.out.println("打开网页啦");
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        WebEngine webEngine = webView.getEngine();
        ClassPathResource resource = new ClassPathResource(ResourcesCfg.HTML_CHART_PATH);
        try {
            webEngine.load(resource.getURL().toExternalForm());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
