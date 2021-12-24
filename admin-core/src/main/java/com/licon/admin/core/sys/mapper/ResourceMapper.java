package com.licon.admin.core.sys.mapper;

import java.util.List;

import com.licon.admin.core.mybatis.ExtensionMapper;
import com.licon.admin.core.sys.po.Resource;
import org.apache.ibatis.annotations.Param;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/17 10:37
 */
public interface ResourceMapper extends ExtensionMapper<Resource> {
	/***
	 * 根据资源路径匹配资源
	 * @param path
	 * @return {@link List< Resource>}
	 * @throws
	 * @author Licon
	 * @date 2021/12/23 16:53
	 */
	List<Resource> findInResourcePath(@Param("path") String path);
}
