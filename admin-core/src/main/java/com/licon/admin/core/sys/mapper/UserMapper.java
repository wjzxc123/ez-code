package com.licon.admin.core.sys.mapper;

import com.licon.admin.core.mybatis.ExtensionMapper;
import com.licon.admin.core.sys.po.User;
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
public interface UserMapper extends ExtensionMapper<User> {
	/***
	 * 根据账户获取用户以及所有拥有的角色
	 * @param account
	 * @return {@link User}
	 * @throws
	 * @author Licon
	 * @date 2021/12/30 10:58
	 */
	User findUserInAccount(@Param("account") String account);
}
