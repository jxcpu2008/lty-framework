package com.lty.app.web.auth.config;

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
// 下面这句等同于springmvc的配置文件，因为已经提供了springmvc配置文件，所以这里不能加上这个注解，否则系统会生成两个web context
//@EnableWebMvc
@EnableSwagger
// model在facade项目，model加上了@ApiModel注解，故需要扫描facade项目的model包，但是没有效果
// 下面这句等同spring配置文件的context:component-scan配置
//@ComponentScan(basePackages={"com.lty.app.web.auth.controller", "com.lty.app.facade.auth.model"})
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
		ApiInfo apiInfo = new ApiInfo("简单权限demo系统 API文档", "详细的restful接口", "", "", "", "");
		return apiInfo;
	}
}