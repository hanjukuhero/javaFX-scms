package com.gxjkzw.lib;

import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @description: 消息传递以及常用的工具类封装代码
 * @author：yi.qin
 * @date：2021/12/16
 * @version：1.0
 * @slogan：打铁还需自身硬
 */
public class MessageUtil {

    private Stage stage;
    private Scene scene;
    private Object controller;

    public MessageUtil(Object controller) {
        this.controller = controller;
    }

    public MessageUtil(Stage stage, Scene scene, Object controller) {
        this.stage = stage;
        this.scene = scene;
        this.controller = controller;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Object getController() {
        return controller;
    }

    public void setController(Object controller) {
        this.controller = controller;
    }

}
