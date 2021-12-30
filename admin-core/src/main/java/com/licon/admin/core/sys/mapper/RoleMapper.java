package com.licon.admin.core.sys.mapper;

import com.licon.admin.core.mybatis.ExtensionMapper;
import com.licon.admin.core.sys.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Licon
 * @since 2021-12-29
 */
public interface RoleMapper extends ExtensionMapper<Role> {
	/***
	 * 根绝角色编码获取角色以及所拥有的权限
	 * @param roleCode
	 * @return {@link Role}
	 * @throws
	 * @author Licon
	 * @date 2021/12/30 10:58
	 */
	Role findRoleInRoleCode(@Param("roleCode") String roleCode);
}
