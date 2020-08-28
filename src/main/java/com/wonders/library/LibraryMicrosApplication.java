package com.wonders.library;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;

@Order
@SpringBootApplication
@MapperScan(basePackages = "com.wonders.library.platform.dao")
public class LibraryMicrosApplication {

    public static void main(String[] args) {
        try{
        SpringApplication.run(LibraryMicrosApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
