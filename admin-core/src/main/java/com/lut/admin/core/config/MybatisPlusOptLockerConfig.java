package com.lut.admin.core.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.lut.admin.core.mybatis.SelectConditionInnerInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/11/23 10:28
 */
@Configuration
public class MybatisPlusOptLockerConfig {

	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
		interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
		interceptor.addInnerInterceptor(new SelectConditionInnerInterceptor());
		return interceptor;
	}
}