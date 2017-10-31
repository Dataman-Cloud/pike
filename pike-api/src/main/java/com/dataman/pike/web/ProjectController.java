package com.dataman.pike.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataman.pike.core.param.ProjectParam;
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
	public Object find(@RequestParam(required = false, defaultValue = "0") @ApiParam(name = "pageNum", value = "页码") Integer pageNum,
			@RequestParam(required = false) @ApiParam(name = "proNo", value = "项目编号") String proNo,
			@RequestParam(required = false) @ApiParam(name = "proName", value = "项目名称") String proName,
			@RequestParam(required = false) @ApiParam(name = "proManager", value = "项目负责人") String proManager,
			@RequestParam(required = false) @ApiParam(name = "source", value = "项目来源") String source){
		return pageRet(projectService.findPageList(proNo,proName,proManager,source,pageBounds(pageNum)));
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ApiOperation(value = "添加项目")
	public Object add(@RequestBody ProjectParam param){
		return sucesssRet(projectService.addProject(param));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ApiOperation(value = "修改项目")
	public Object edit(@ApiParam(required = true, name = "id", value = "项目id") @PathVariable Long id,@RequestBody ProjectParam param){
		return sucesssRet(projectService.editProject(id, param));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ApiOperation(value = "删除项目")
	public Object del(@ApiParam(required = true, name = "id", value = "项目id") @PathVariable Long id){
		return sucesssRet(projectService.deleteById(id));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ApiOperation(value = "查询")
	public Object findById(@ApiParam(required = true, name = "id", value = "项目id") @PathVariable Long id){
		return sucesssRet(projectService.findById(id));
	}
}
