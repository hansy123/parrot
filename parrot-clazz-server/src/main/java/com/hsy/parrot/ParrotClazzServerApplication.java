package com.hsy.parrot;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@RefreshScope
@EnableFeignClients
@EnableHystrix
@EnableDistributedTransaction
public class ParrotClazzServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParrotClazzServerApplication.class, args);
    }
}
