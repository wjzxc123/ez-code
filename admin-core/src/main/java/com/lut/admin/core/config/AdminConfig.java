package com.lut.admin.core.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/17 15:25
 */
@Data
@Slf4j
@ConfigurationProperties(prefix = AdminConfig.PREFIX)
public class AdminConfig implements Serializable {

	private static final long serialVersionUID = -5383436148526970469L;

	public static final String PREFIX = "ez-code.admin.datasource";

	private Map<String,DataSourceConfig> datasource = new HashMap<>();

	private PageHelperConfig pagehelper = new PageHelperConfig();
}
