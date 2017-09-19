package com.lty.api.gateway.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

/**
 * 
 * @描述:
 * @作者: Kevin Xie
 * @创建时间: 2016年10月10日
 * @版本: 1.0
 */
@Configuration
@EnableSwagger
public class SwaggerConfig {
	@Resource
	private SpringSwaggerConfig springSwaggerConfig;

	/**
	 * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
	 * framework - allowing for multiple swagger groups i.e. same code base
	 * multiple swagger resource listings.
	 */
	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?");
	}

	/**
	 * API Info as it appears on the swagger-ui page
	 */
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("API Gateway API文档", "详细的restful接口", "", "", "", "");
		return apiInfo;
	}
}