package com.lut.admin.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/21 14:36
 */
@Configuration
@ComponentScan(basePackages = "com.lut.admin.core.sys.repository")
public class RepositoryForeignConfig {
}
