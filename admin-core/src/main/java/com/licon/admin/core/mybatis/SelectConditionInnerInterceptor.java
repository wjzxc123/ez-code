package com.licon.admin.core.mybatis;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 16:05
 */
@Slf4j
public class SelectConditionInnerInterceptor implements InnerInterceptor {

	private static final String SEPARATOR = ".";

	private static final String SQL_ID = "selectByCondition";

	@Override
	public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {

		if (ms == null){
			return;
		}
		if (!SQL_ID.equalsIgnoreCase(ms.getId().substring(ms.getId().lastIndexOf(SEPARATOR)+1))){
			return;
		}

		Field[] fields = parameter.getClass().getDeclaredFields();
		StringBuilder relsql = new StringBuilder();
		Arrays.stream(fields).forEach(field -> {
			Object fieldValue = BeanUtil.getFieldValue(parameter, field.getName());
			String formatValue = getFormatValue(StrUtil.toUnderlineCase(field.getName()).toUpperCase(), fieldValue);
			relsql.append(formatValue);
		});
		if (relsql.length()>0){
			relsql.delete(0,3);
		}

		relsql.insert(0," where ");

		relsql.insert(0,boundSql.getSql());

		Field field = null;
		try {
			field = boundSql.getClass().getDeclaredField("sql");
			field.setAccessible(true);
			field.set(boundSql, relsql.toString());
		}catch (NoSuchFieldException | IllegalAccessException e) {
			log.error("获取字段值异常，查询失败");
		}
	}

	public String getFormatValue(String tableName,Object data){
		if (data == null){
			return "";
		}else if (data instanceof Integer){
			return "and "+tableName+" = '"+data.toString()+"' ";
		}else if (data instanceof String){
			return "and "+tableName+" = '"+data.toString()+"' ";
		}else if(data instanceof Boolean){
			return "and "+tableName+" = '"+data.toString()+"' ";
		}else if (data instanceof List){
			List list = (List)data;
			StringBuilder sb = new StringBuilder();
			sb.append("and ").append(tableName).append(" ").append("( ");
			list.forEach(x->{
				sb.append("'").append(x).append("'").append(",");
			});
			sb.delete(sb.length() - 1, sb.length()).append(" ) ");

			return sb.toString();
		}else {
			return "and "+tableName+" = '"+data.toString()+"' ";
		}
	}
}
