package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * springboot启动类
 * @author zxl
 */
@ServletComponentScan // 在springboot启动时加载@WebServlet、@WebFilter、@WebListener这个注解，并将其实例化
@SpringBootApplication
public class StudySsmBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudySsmBootApplication.class, args);
    }

}
