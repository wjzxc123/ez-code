package com.licon.domain.config;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/1 18:04
 */
@Slf4j
//@Configuration
//@Order(-1)
public class DataSourceConfig {
	/**
	 * 数据源配置的前缀，必须与application.properties中配置的对应数据源的前缀一致
	 */
	private static final String DBDS_DATASOURCE_PREFIX = "spring.datasource.dbds";

	//@Bean
	//@ConfigurationProperties(prefix = DBDS_DATASOURCE_PREFIX)
	//@Primary
	public DataSource getDBDatasource(){
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
}
