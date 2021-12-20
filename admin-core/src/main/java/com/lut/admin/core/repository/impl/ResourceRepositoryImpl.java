package com.lut.admin.core.repository.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lut.admin.core.mapper.ResourceMapper;
import com.lut.admin.core.po.Resource;
import com.lut.admin.core.repository.ResourceRepository;

import org.springframework.stereotype.Service;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/20 13:34
 */
@Service
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
}
