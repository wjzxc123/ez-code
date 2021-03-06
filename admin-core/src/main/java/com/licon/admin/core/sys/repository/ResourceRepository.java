package com.licon.admin.core.sys.repository;

import java.util.List;

import com.licon.admin.core.sys.po.Resource;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 13:20
 */
public interface ResourceRepository{

	/***
	 * 获取所有资源
	 * @param resource
	 * @return {@link List<Resource>}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/20 13:31
	 */
	List<Resource> getResources(Resource resource) throws Exception;
	
	/***
	 *根据资源路径匹配资源
	 * @param path
	 * @return {@link List< Resource>}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/20 13:33
	 */
	List<Resource> findInResourcePath(String path) throws Exception;
	
	/***
	 * 根据资源id获取资源
	 * @param resourceId
	 * @return {@link Resource}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/20 13:34
	 */
	Resource findInResourceId(String resourceId) throws Exception;

	/***
	 * 保存资源
	 * @param resource
	 * @return {@link boolean}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/21 9:11
	 */
	boolean save(Resource resource) throws Exception;
}
