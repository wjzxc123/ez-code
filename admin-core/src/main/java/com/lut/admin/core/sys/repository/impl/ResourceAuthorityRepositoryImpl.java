package com.lut.admin.core.sys.repository.impl;

import java.util.List;

import com.lut.admin.core.sys.mapper.ResourceAuthorityMapper;
import com.lut.admin.core.sys.po.ResourceAuthority;
import com.lut.admin.core.sys.repository.ResourceAuthorityRepository;

import org.springframework.stereotype.Repository;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/21 15:08
 */
@Repository
public class ResourceAuthorityRepositoryImpl implements ResourceAuthorityRepository {

	final ResourceAuthorityMapper resourceAuthorityMapper;

	public ResourceAuthorityRepositoryImpl(ResourceAuthorityMapper resourceAuthorityMapper) {
		this.resourceAuthorityMapper = resourceAuthorityMapper;
	}

	@Override
	public List<ResourceAuthority> getAuthorityByResourceId(String resourceId) throws Exception {
		return resourceAuthorityMapper.selectByCondition(new ResourceAuthority().setResourceId(resourceId));
	}
}
