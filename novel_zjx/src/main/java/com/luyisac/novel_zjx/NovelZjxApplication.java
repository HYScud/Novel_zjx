package com.luyisac.novel_zjx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.luyisac.novel_zjx.mapper"})
@ComponentScan(basePackages = {"com.luyisac.novel_zjx"})
@EnableTransactionManagement(proxyTargetClass=true)
public class NovelZjxApplication {
    public static void main(String[] args) {
        SpringApplication.run(NovelZjxApplication.class, args);
    }
}
