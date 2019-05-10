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
@FeignClient(value = "test", url = "${feign.client.url}", fallbackFactory = FeignHttpClientFallBack.class)
public interface FeignHttpClient {

	/**
	 * http方式调用
	 *
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	Map<String, Object> feignHttp();


}

@Component
class FeignHttpClientFallBack implements FeignHttpClient, FallbackFactory<FeignHttpClient> {
	private Logger logger = LoggerFactory.getLogger(FeignHttpClientFallBack.class);
	private Throwable throwable;

	@Override
	public FeignHttpClient create(Throwable throwable) {
		this.throwable = throwable;
		return new FeignHttpClientFallBack();
	}

	@Override
	public Map<String, Object> feignHttp() {
		logger.error("FeignHttpClient feignHttp 接口调用失败！");
		return null;
	}
}