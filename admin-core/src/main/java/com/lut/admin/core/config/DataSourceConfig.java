package com.lut.admin.core.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/1 18:04
 */
@Data
@Slf4j
public class DataSourceConfig {
	private String jdbcUrl;
	private String username;
	private String password;
	private String driverClassName;
	private String poolType;
}
