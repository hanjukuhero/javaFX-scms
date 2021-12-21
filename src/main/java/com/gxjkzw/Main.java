package com.gxjkzw;

import com.gxjkzw.config.ResourcesCfg;
import com.gxjkzw.lib.DialogBuilder;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

@SpringBootApplication
@Slf4j
public class Main extends AbstractJavaFxApplicationSupport {

    private static ConfigurableApplicationContext springContext;

    private static Stage stage;

    /**
     * 让 spring 托管 javaFx 的Bean
     */
    @Override
    public void init() {
        springContext = SpringApplication.run(Main.class, getParameters().getRaw().toArray(new String[0]));
        // 将 bean 注入 Spring 托管上下文之外的类
        springContext.getAutowireCapableBeanFactory().autowireBeanProperties(
                this,
                AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE,
                true
        );
    }

    @Override
    public void start(Stage primaryStage) {
        stage = primaryStage;
        stage.setTitle("信号集中监测设备系统");
        gotoLogin();
        stage.show();

    }


    @Override
    public void stop() {
        springContext.stop();
    }

    /**
     * 跳转主页
     */
    public void gotoMain() {
        try {
            replaceSceneContent(ResourcesCfg.MAIN_VIEW_PATH);
        } catch (Exception e) {
            log.error("跳转失败：{}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 跳转登录页
     */
    public void gotoLogin() {
        try {
            replaceSceneContent(ResourcesCfg.LOGIN_VIEW_PATH);
        } catch (Exception e) {
            log.error("跳转失败：{}", e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 替换场景
     * @param fxml
     * @return
     * @throws Exception
     */
    private void replaceSceneContent(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        // 让 Spring 成为 JavaFX 控制器工厂，FXMLLoader 放入 spring 容器
        loader.setControllerFactory(springContext::getBean);
        ClassPathResource resource = new ClassPathResource(fxml);
        InputStream in = resource.getInputStream();
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        try {
            AnchorPane pane = loader.load(in);
            Scene scene;
            if (ResourcesCfg.LOGIN_VIEW_PATH.equals(fxml)) {
                scene = new Scene(pane);
            } else {
                scene = new Scene(pane, ResourcesCfg.STAGE_WIDTH, ResourcesCfg.STAGE_HEIGHT);
            }
            stage.setScene(scene);
            stage.sizeToScene();
        } catch (Exception e) {
            log.error("场景替换失败：{}", e.getMessage());
            e.printStackTrace();
        } finally {
            in.close();
        }
    }

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e.getCause() != null) {
                    Throwable realException = e.getCause().getCause();
                    if (realException != null) {
                        realException.printStackTrace();
                        String msg = realException.getMessage();
                        // 统一异常处理
                        new DialogBuilder(stage.getScene().getWindow()).setTitle("提示").setMessage(msg).setNegativeBtn("确定").create();
                        log.error(msg);
                    } else {
                        e.printStackTrace();
                    }
                }
                log.error(e.getMessage());
            }
        });

        launch(Main.class, args);
    }

}
