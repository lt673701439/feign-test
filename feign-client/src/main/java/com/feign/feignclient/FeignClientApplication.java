package com.feign.feignclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.feign.feignclient.feign")
@EnableEurekaClient
@SpringBootApplication
public class FeignClientApplication {
	private static final Logger log = LoggerFactory.getLogger(FeignClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
		log.info("feign-client 启动完成...........");
	}

}
