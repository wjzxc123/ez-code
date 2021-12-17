package com.lut.admin.core.autoconfigure;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.lut.admin.core.config.AdminConfig;
import com.lut.admin.core.config.PageHelperConfig;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/17 14:49
 */
@Configuration
@EnableConfigurationProperties({AdminConfig.class, PageHelperConfig.class})
public class EasyCodeCoreAutoConfiguration {
}
