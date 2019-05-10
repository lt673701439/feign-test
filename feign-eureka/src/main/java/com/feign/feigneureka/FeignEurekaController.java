package com.feign.feigneureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liutong
 * @date 2019-04-11 18:37:56
 */
@RestController
public class FeignEurekaController {
	private Logger logger = LoggerFactory.getLogger(FeignEurekaController.class);

	/**
	 * eureka方式 被调的方法
	 *
	 * @return
	 */
	@GetMapping(value = "/eurekaTest")
	public Map<String, Object> eurekaTest() {
		logger.info("进入 eurekaTest 接口");
		Map<String, Object> map = new HashMap<>(4);
		map.put("bbb", "eurekaTest 返回成功");
		return map;
	}

}
