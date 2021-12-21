package com.lut.admin.core.sys.repository;

import java.util.List;

import com.lut.admin.core.sys.po.ResourceAuthority;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/21 10:16
 */
public interface ResourceAuthorityRepository {
	/***
	 * 获取权限资源根于资源id
	 * @param resourceId
	 * @return {@link List< ResourceAuthority>}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/21 10:18
	 */
	List<ResourceAuthority> getAuthorityByResourceId(String resourceId) throws Exception;
}
