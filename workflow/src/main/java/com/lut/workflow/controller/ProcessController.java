package com.lut.workflow.controller;

import javax.servlet.http.HttpServletRequest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Describe:
 *
 * @author Licon
 * @date 2021/12/2 14:27
 */
@RestController
@RequestMapping("/api")
public class ProcessController {
	@Autowired
	RuntimeService runtimeService;
	@Autowired
	RepositoryService repositoryService;

	@Autowired
	TaskService taskService;

	@PostMapping("/create")
	public Object createProcess(HttpServletRequest request){
		//repositoryService.createDeployment().


		return null;
	}
}
