package com.lut.admin.core.mybatis;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.builder.annotation.ProviderSqlSource;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 14:52
 */
public class SelectByCondition extends AbstractMethod {

	private static final long serialVersionUID = -7014796892566010324L;

	@Override
	public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
		final String sql = "<script>select %s from %s</script>";
		final String fieldSql = prepareFieldSql(tableInfo);
		final String sqlResult = String.format(sql,fieldSql, tableInfo.getTableName());
		SqlSource sqlSource = languageDriver.createSqlSource(configuration, sqlResult, modelClass);
		return this.addSelectMappedStatementForTable(mapperClass,"selectByCondition",sqlSource,tableInfo);
	}

	public String prepareFieldSql(TableInfo tableInfo){
		StringBuilder fieldSql = new StringBuilder();
		fieldSql.append(tableInfo.getKeyColumn()).append(",");
		tableInfo.getFieldList().forEach(x -> {
			fieldSql.append(x.getColumn()).append(",");
		});
		fieldSql.delete(fieldSql.length() - 1, fieldSql.length());
		return fieldSql.toString();
	}

}
