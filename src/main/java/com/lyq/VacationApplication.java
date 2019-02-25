package com.lyq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan({"com.lyq.mapper","com.lyq.aspectj","com.lyq.exceptionhandler"})
@ImportResource(value = {"classpath:dubbo-provider.xml"})
@EntityScan("com.lyq.model")

public class VacationApplication {

    public static void main(String[] args) {
        SpringApplication.run(VacationApplication.class, args);
    }

}

