package com.licon.admin.core.sys.repository.impl;

import com.licon.admin.core.sys.mapper.UserMapper;
import com.licon.admin.core.sys.po.User;
import com.licon.admin.core.sys.repository.UserRepository;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/30 14:18
 */
public class UserRepositoryImpl implements UserRepository {
	final UserMapper userMapper;

	public UserRepositoryImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User queryUserByAccount(String account) throws Exception {
		return userMapper.findUserInAccount(account);
	}
}
