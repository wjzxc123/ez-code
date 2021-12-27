package com.licon.admin.core.sys.repository.impl;

import java.util.List;

import com.licon.admin.core.sys.mapper.ResourceMapper;
import com.licon.admin.core.sys.po.Resource;
import com.licon.admin.core.sys.repository.ResourceRepository;
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
		return resourceMapper.findInResourcePath(path);
	}

	@Override
	public Resource findInResourceId(String resourceId) throws Exception {
		return resourceMapper.findInResourceId(resourceId);
	}

	@Override
	public boolean save(Resource resource) throws Exception {
		int result = 0;
		if (resource.getId()== null){
			result = resourceMapper.insert(resource);
		}else {
			result = resourceMapper.updateById(resource);
		}
		if (result == 0){
			throw new Exception("保存失败");
		}
		return true;
	}
}
