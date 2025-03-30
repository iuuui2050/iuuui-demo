package com.iuuui.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author iuuui
 * @date 2025/03/29 1130
 */
public class GeneratorUtil {

    private final static String URL = "jdbc:mysql://localhost:3306/iuuui?useUnicode=true&characterEncoding=UTF-8";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    public static void main(String[] args) {
        extracted();
    }

    private static void extracted() {
        String tables = "sys_user_role,sys_user,sys_role_menu,sys_role,sys_menu";
        FastAutoGenerator.create(URL, USERNAME, PASSWORD)
                .globalConfig(
                        builder -> builder
                                .author("iuuui")
                                .outputDir("D:\\code\\javaProject\\iuuui-demo\\spring-security\\src\\main\\java")
                                .commentDate("yyyy-MM-dd HHmm")
                                .disableOpenDir()
                )
                .packageConfig(
                        builder -> builder
                                .parent("com.iuuui")
                                .entity("entity")
                                .mapper("mapper")
                                .service("service")
                                .serviceImpl("service.impl")
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\code\\javaProject\\iuuui-demo\\spring-security\\src\\main\\resources\\mappers"))
                )
                .strategyConfig(
                        builder -> builder
                                .addInclude(tables.split(","))
                                .entityBuilder()
                                .enableLombok()
                                .controllerBuilder()
                                .disable()
                                .serviceBuilder()
                                .formatServiceFileName("%sService")
                )
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
