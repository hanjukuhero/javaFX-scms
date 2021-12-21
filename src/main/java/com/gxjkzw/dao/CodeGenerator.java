package com.gxjkzw.dao;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class CodeGenerator {
    public static void main(String[] args) {

        String tableName = "t_user";

        // 创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();

        // 子模块
        String moduleName = "/scms-dao";

        // 项目目录 C:\IdeaProjects\scms\scms-dao
        String projectPath = System.getProperty("user.dir") + moduleName;

        gc.setAuthor("yi.qin");
        gc.setOutputDir(projectPath + "/src/main/java");
        // 生成后是否打开资源管理器
        gc.setOpen(false);
        // 重新生成时文件是否覆盖
        gc.setFileOverride(true);
        // xml中带有resultMap
        gc.setBaseResultMap(true);
        // xml中带有字段
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置 TODO
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/scms?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("mysql");
        mpg.setDataSource(dsc);

        // 包配置 TODO
        PackageConfig pc = new PackageConfig();
        // 包父路径
        pc.setParent("com.gxjkzw.dao");
        // 实体类包名
        pc.setEntity("entity");
        // mapper包名
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);


        // 注入配置， 该配置不在代码中配置出来的话，则生该自动生成的文件不会生成对应的文件！！！！
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                if(StrUtil.isEmpty(pc.getModuleName())){
                    return projectPath + "/src/main/resources/mapper/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                } else {
                    return projectPath + "/src/main/resources/mapper/" + pc.getModuleName() + "/" + tableInfo.getXmlName() + StringPool.DOT_XML;
                }
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);


        TemplateConfig tc = new TemplateConfig();
        // 这个标注了则不再默认路径下生成XML文件了
        tc.setXml(null);
        tc.setController(null);
        tc.setService(null);
        tc.setServiceImpl(null);
        mpg.setTemplate(tc);


        // 策略配置 TODO
        StrategyConfig strategy = new StrategyConfig();
        // 表名
        // strategy.setInclude("t_user");
        strategy.setInclude(tableName);
        // 数据库表映射到实体的命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 生成实体时去掉表前缀
        strategy.setTablePrefix("t_");
        // 数据库表字段映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // lombok如果使用到修改成true
        strategy.setEntityLombokModel(true);

        mpg.setStrategy(strategy);

        // 执行
        mpg.execute();
    }
}
