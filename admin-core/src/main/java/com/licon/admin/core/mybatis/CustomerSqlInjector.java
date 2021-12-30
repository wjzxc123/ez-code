package com.licon.admin.core.mybatis;

import java.util.List;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;

import org.springframework.stereotype.Component;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 14:54
 */
public class CustomerSqlInjector extends DefaultSqlInjector {
	@Override
	public List<AbstractMethod> getMethodList(Class<?> mapperClass, TableInfo tableInfo) {
		List<AbstractMethod> methodList = super.getMethodList(mapperClass, tableInfo);
		methodList.add(new SelectByCondition());
		return methodList;
	}
}
