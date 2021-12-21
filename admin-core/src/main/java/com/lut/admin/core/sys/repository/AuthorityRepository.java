package com.lut.admin.core.sys.repository;

import java.util.List;

import com.lut.admin.core.sys.po.Authority;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/21 9:10
 */
public interface AuthorityRepository {
	/***
	 * 获取权限列表
	 * @param authority
	 * @return {@link List< Authority>}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/21 9:17
	 */
	List<Authority> getAuthorities(Authority authority) throws Exception;

	/***
	 * 根据权限编码查找权限
	 * @param authorityCode
	 * @return {@link Authority}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/21 9:18
	 */
	Authority findAuthorityByCode(String authorityCode) throws Exception;

	/***
	 * 保存权限
	 * @param authority
	 * @return {@link boolean}
	 * @throws Exception
	 * @author Licon
	 * @date 2021/12/21 9:18
	 */
	boolean save(Authority authority) throws Exception;
}
