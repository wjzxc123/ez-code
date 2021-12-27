package com.licon.admin.core;

import java.util.UUID;

import com.licon.admin.core.mybatis.enums.EnableEnum;
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

	@Test
	public void testMybatisPlusEnum() throws Exception {
		Resource resource = new Resource();
		String resourceId = UUID.randomUUID().toString();
		resource.setResourceId(resourceId);
		resource.setResourcePath("/sys/test");
		resource.setResourceName("系统测试地址");
		resource.setEnable(EnableEnum.ON);
		resource.setResourceVersion("V1");
		resourceRepository.save(resource);

		resource = resourceRepository.findInResourceId(resourceId);

		System.out.println(resource);
	}
}
