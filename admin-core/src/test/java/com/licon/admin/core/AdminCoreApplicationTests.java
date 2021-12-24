package com.licon.admin.core;

import com.licon.admin.core.sys.po.Resource;
import com.licon.admin.core.sys.repository.ResourceRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminCoreApplicationTests {

	@Autowired
	ResourceRepository resourceRepository;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCondition() throws Exception {
		Resource resource = new Resource();
		resource.setResourceId("12312313");
		resource.setResourcePath("/test");
		resourceRepository.getResources(resource);
	}

	@Test
	public void testFindPath() throws Exception {
		String path = "/test";
		resourceRepository.findInResourcePath(path);
	}
}