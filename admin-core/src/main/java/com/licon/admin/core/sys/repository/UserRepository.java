package com.licon.admin.core.sys.repository;

import com.licon.admin.core.sys.po.User;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/30 14:10
 */
public interface UserRepository {

	/***
	 *根据账户查询用户以及所包含的角色
	 * @param account
	 * @return {@link User}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/30 14:13
	 */
	User queryUserByAccount(String account) throws Exception;
}
