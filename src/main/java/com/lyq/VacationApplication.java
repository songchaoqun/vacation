package com.lyq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan({"com.lyq.mapper","com.lyq.aspectj","com.lyq.exceptionhandler"})
public class VacationApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacationApplication.class, args);
    }

}

