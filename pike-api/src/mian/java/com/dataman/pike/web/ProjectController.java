package com.dataman.pike.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataman.pike.core.service.IProjectService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Project API")
@RestController
@RequestMapping(value = "/project", produces = "application/json;charset=utf-8")
public class ProjectController extends BaseController {

	@Autowired
	IProjectService projectService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ApiOperation(value = "分页查询项目")
	public Object find(@RequestParam(required = false, defaultValue = "0") @ApiParam(name = "pageNum", value = "页码") Integer pageNum){
		return sucesssRet(projectService.findPageList(pageBounds(pageNum)));
	}
}
