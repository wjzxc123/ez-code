package com.licon.admin.core.sys.repository;

import com.licon.admin.core.sys.po.Role;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/30 14:10
 */
public interface RoleRepository {
	/***
	 * 根据角色编码查询角色，已经所包含的权限
	 * @param roleCode
	 * @return {@link Role}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/30 14:12
	 */
	Role queryRoleByRoleCode(String roleCode) throws Exception;
}
