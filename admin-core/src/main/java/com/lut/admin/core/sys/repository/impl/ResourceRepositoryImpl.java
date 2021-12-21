package com.lut.admin.core.sys.repository.impl;

import java.util.List;

import com.lut.admin.core.sys.mapper.ResourceMapper;
import com.lut.admin.core.sys.po.Resource;
import com.lut.admin.core.sys.repository.ResourceRepository;
import org.springframework.stereotype.Repository;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 13:34
 */
@Repository
public class ResourceRepositoryImpl implements ResourceRepository {

	final ResourceMapper resourceMapper;

	public ResourceRepositoryImpl(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}

	@Override
	public List<Resource> getResources(Resource resource) throws Exception {
		return resourceMapper.selectByCondition(resource);
	}

	@Override
	public List<Resource> findInResourcePath(String path) throws Exception {
		return null;
	}

	@Override
	public Resource findInResourceId(String resourceId) throws Exception {
		return null;
	}

	@Override
	public boolean save(Resource resource) throws Exception {
		return false;
	}
}
