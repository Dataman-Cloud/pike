package com.dataman.pike.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataman.pike.core.param.OperationParam;
import com.dataman.pike.core.service.IOperationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Operation API")
@RestController
@RequestMapping(value = "/operation", produces = "application/json;charset=utf-8")
public class OperationController extends BaseController{

	@Autowired
	IOperationService operationService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ApiOperation(value = "分页查询操作")
	public Object find(@RequestParam(required = false) @ApiParam(name = "name", value = "名称") String name,
			@RequestParam(required = false, defaultValue = "0") @ApiParam(name = "pageNum", value = "页码") Integer pageNum){		
		return pageRet(operationService.findPageList(name, pageBounds(pageNum)));
	}
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	@ApiOperation(value = "添加操作")
	public Object add(@RequestBody OperationParam param){
		return sucesssRet(operationService.addOperation(param));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ApiOperation(value = "删除操作")
	public Object del(@ApiParam(required = true, name = "id", value = "操作id") @PathVariable Long id){
		return sucesssRet(operationService.deleteById(id));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	@ApiOperation(value = "修改操作")
	public Object edit(@ApiParam(required = true, name = "id", value = "操作id") @PathVariable Long id,
			@RequestBody OperationParam param){
		return sucesssRet(operationService.editOperation(id, param));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ApiOperation(value = "查询")
	public Object findById(@ApiParam(required = true, name = "id", value = "操作id") @PathVariable Long id){
		return sucesssRet(operationService.findById(id));
	}
	
	@RequestMapping(value="/{id}/test",method=RequestMethod.PUT)
	@ApiOperation(value = "操作测试")
	public Object test(@ApiParam(required = true, name = "id", value = "操作id") @PathVariable Long id,
			@RequestBody OperationParam param){
		return sucesssRet(operationService.testOperation(id, param));
	}
	
}
