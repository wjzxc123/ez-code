package com.licon.admin.core.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.licon.admin.core.sys.mapper.ResourceMapper;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/23 17:07
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@MapperScan("com.licon.admin.core.sys.mapper")
@EnableAsync
public @interface MapperForeignConfig {

}
