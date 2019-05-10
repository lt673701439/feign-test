package com.feign.feigneureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FeignEurekaApplication {
	private static final Logger log = LoggerFactory.getLogger(FeignEurekaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FeignEurekaApplication.class, args);
		log.info("feign-eureka 启动完成...........");
	}

}
