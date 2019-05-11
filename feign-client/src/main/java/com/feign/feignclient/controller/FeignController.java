package com.feign.feignclient.controller;

import com.feign.feignclient.feign.FeignEurekaClient;
import com.feign.feignclient.feign.FeignHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liutong
 * @date 2019-04-11 18:37:56
 */
@RestController
public class FeignController {
	private Logger logger = LoggerFactory.getLogger(FeignController.class);

	private final FeignHttpClient feignHttpClient;
	private final FeignEurekaClient feignEurekaClient;

	@Autowired
	public FeignController(FeignHttpClient feignHttpClient, FeignEurekaClient feignEurekaClient) {
		this.feignHttpClient = feignHttpClient;
		this.feignEurekaClient = feignEurekaClient;
	}

	/**
	 * http方式调用入口
	 *
	 * @return
	 */
	@GetMapping(value = "/feignHttp")
	public Map<String, Object> feignHttp() {
		logger.info("进入 feignHttp 接口");
		return feignHttpClient.feignHttp();
	}

	/**
	 * http方式 被调方法
	 *
	 * @return
	 */
	@GetMapping(value = "/httpTest")
	public Map<String, Object> httpTest() {
		logger.info("调用了 httpTest 接口");
		Map<String, Object> map = new HashMap<>(4);
		map.put("aaa", "httpTest 返回成功");
		return map;
	}

	/**
	 * eureka方式调用入口
	 *
	 * @return
	 */
	@GetMapping(value = "/feignEureka")
	public Map<String, Object> feignEureka() {
		logger.info("进入 feignEureka 接口");
		return feignEurekaClient.feignEureka();
	}

	/**
	 * eureka方式 被调的方法
	 * Deprecated, 废弃了，本来想想http方式一样在当前服务内调自己服务本身的接口
	 * 但因为通过eureka方式调用，不能在本服务内调自己本身，原因还未研究
	 *
	 * @return
	 */
	@Deprecated
	@GetMapping(value = "/eurekaTest")
	public Map<String, Object> eurekaTest() {
		logger.info("进入 eurekaTest 接口");
		Map<String, Object> map = new HashMap<>(4);
		map.put("bbb", "eurekaTest 返回成功");
		return map;
	}

}
