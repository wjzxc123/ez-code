package com.licon.admin.core;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import org.junit.jupiter.api.Test;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/21 16:26
 */
public class GenerateTest {
	@Test
	public void createMapper() throws Exception{
		DataSourceConfig.Builder dataSourceConfig = new DataSourceConfig.Builder("jdbc:mysql://127.0.0.1:3306/ez_code?autoReconnect=true&useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=CONVERT_TO_NULL&useSSL=false", "root", "root")
				.dbQuery(new MySqlQuery())
				.schema("ez_code")
				.typeConvert(new MySqlTypeConvert())
				.keyWordsHandler(new MySqlKeyWordsHandler());
		FastAutoGenerator.create(dataSourceConfig)
				.globalConfig(builder -> {
					builder.author("Licon") // 设置作者
							//.enableSwagger() // 开启 swagger 模式
							.fileOverride() // 覆盖已生成文件
							.outputDir("C:\\Users\\lvshaowei\\Desktop"); // 指定输出目录
				})
				.templateConfig(builder -> {
					builder.disable(TemplateType.CONTROLLER,TemplateType.SERVICE,TemplateType.SERVICEIMPL)
							.build();
				})
				.packageConfig(builder -> {
					builder.parent("com.licon.admin.core") // 设置父包名
							.moduleName("sys") // 设置父包模块名
							.entity("po")
							.mapper("mapper")
							.xml("mapper")
							//.pathInfo(Collections.singletonMap(OutputFile.mapperXml, "C:\\Users\\lvshaowei\\Desktop"))
							.build(); // 设置mapperXml生成路径
				})
				.strategyConfig(builder -> {
					builder.addInclude("sys_resource_authority")
							.entityBuilder()
							.versionColumnName("version")
							.versionPropertyName("version")
							.columnNaming(NamingStrategy.underline_to_camel)
							.enableLombok()
							.disableSerialVersionUID()
							//.formatFileName("%sDO")
							.mapperBuilder()
							.enableMapperAnnotation()
							.enableBaseResultMap()
							.enableBaseColumnList()
							.build();
				})
				.templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
				.execute();
	}
}
