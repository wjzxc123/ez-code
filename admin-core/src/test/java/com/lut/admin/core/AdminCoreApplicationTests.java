package com.lut.admin.core;

import com.lut.admin.core.po.Resource;
import com.lut.admin.core.repository.ResourceRepository;
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
}
