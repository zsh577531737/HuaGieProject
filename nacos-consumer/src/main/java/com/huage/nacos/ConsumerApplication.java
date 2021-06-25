package com.huage.nacos;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@EnableDubbo
@NacosPropertySource(dataId = "application-dev.yml", autoRefreshed = true)
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
