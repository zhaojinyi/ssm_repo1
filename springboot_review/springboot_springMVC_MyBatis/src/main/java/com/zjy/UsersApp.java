package com.zjy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.zjy.mapper") //  MapperScan 用户扫描mybatis的包
public class UsersApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(UsersApp.class, args);
    }
}
