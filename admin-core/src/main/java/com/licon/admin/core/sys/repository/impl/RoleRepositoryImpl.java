package com.licon.admin.core.sys.repository.impl;

import com.licon.admin.core.sys.mapper.RoleMapper;
import com.licon.admin.core.sys.po.Role;
import com.licon.admin.core.sys.repository.RoleRepository;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/30 14:19
 */
public class RoleRepositoryImpl implements RoleRepository {
	final RoleMapper roleMapper;

	public RoleRepositoryImpl(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Override
	public Role queryRoleByRoleCode(String roleCode) throws Exception {
		return roleMapper.findRoleInRoleCode(roleCode);
	}
}
