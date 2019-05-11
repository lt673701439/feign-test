package com.feign.feignclient.feign;

import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * FeignClient :当服务提供方在注册中心注册过时，也就是走eureka方式调用时，需要指定对方服务名 name(value)属性
 * 当以http方式访问时，这个name可以写一个任意不存在的服务名，但url必须写实际调用的http请求地址
 *
 * @author liutong
 * @date 2019-04-11 19:01:24
 */
@FeignClient(value = "feign-eureka", fallbackFactory = FeignEurekaClientFallBack.class)
public interface FeignEurekaClient {

	/**
	 * eureka方式调用
	 *
	 * @return
	 */
	@RequestMapping(value = "/eurekaTest", method = RequestMethod.GET)
	Map<String, Object> feignEureka();


}

@Component
class FeignEurekaClientFallBack implements FeignEurekaClient, FallbackFactory<FeignEurekaClient> {
	private Logger logger = LoggerFactory.getLogger(FeignEurekaClientFallBack.class);
	private Throwable throwable;

	@Override
	public FeignEurekaClient create(Throwable throwable) {
		this.throwable = throwable;
		return new FeignEurekaClientFallBack();
	}

	@Override
	public Map<String, Object> feignEureka() {
		logger.error("FeignEurekaClient feignEureka 接口调用失败！", throwable);
		return null;
	}
}