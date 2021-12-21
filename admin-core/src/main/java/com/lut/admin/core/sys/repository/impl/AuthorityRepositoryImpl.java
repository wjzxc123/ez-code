package com.lut.admin.core.sys.repository.impl;

import java.util.List;

import com.lut.admin.core.sys.mapper.AuthorityMapper;
import com.lut.admin.core.sys.po.Authority;
import com.lut.admin.core.sys.repository.AuthorityRepository;

import org.springframework.stereotype.Repository;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/21 9:19
 */
@Repository
public class AuthorityRepositoryImpl implements AuthorityRepository {

	final AuthorityMapper authorityMapper;

	public AuthorityRepositoryImpl(AuthorityMapper authorityMapper) {
		this.authorityMapper = authorityMapper;
	}

	@Override
	public List<Authority> getAuthorities(Authority authority) throws Exception {
		return authorityMapper.selectByCondition(authority);
	}

	@Override
	public Authority findAuthorityByCode(String authorityCode) throws Exception {
		return null;
	}

	@Override
	public boolean save(Authority authority) throws Exception {
		return false;
	}
}
