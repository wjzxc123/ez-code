package com.licon.admin.core.mybatis;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * Describe: 扩展 BaseMapper
 *
 * @author Licon
 * @date 2021/12/20 15:05
 */
public interface ExtensionMapper<T> extends BaseMapper<T> {
	/***
	 * 对象中不为空的全部凭借为where条件除BaseFiled字段除外 {@link com.licon.admin.core.mybatis.SelectByCondition}
	 * @param condition
	 * @return {@link List<T>}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/20 15:07
	 */
	List<T> selectByCondition(T condition) throws Exception;
}
