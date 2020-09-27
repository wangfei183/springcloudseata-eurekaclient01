package com.example.springcloudseataeurekaclient01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动创建
//@SpringBootApplication
public class SpringcloudseataEurekaclient01Application {
    private static Logger logger= LoggerFactory.getLogger(SpringcloudseataEurekaclient01Application.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudseataEurekaclient01Application.class, args);
        logger.info("seata——user启动完毕-----------------------------------------------");
    }

}
