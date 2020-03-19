package com.mengfanliang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mengfanliang.mapper")
public class LeyouApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeyouApplication.class, args);
    }

}
