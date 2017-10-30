package com.dataman.pike.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dataman.pike.core.service.IDictionaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "Dictionary API")
@RestController
@RequestMapping(value = "/dictionary", produces = "application/json;charset=utf-8")
public class DictionaryController extends BaseController {

	@Autowired
	IDictionaryService dictionaryService;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	@ApiOperation(value = "分页查询字典")
	public Object find(@RequestParam(required = false) @ApiParam(name = "name", value = "名称") String name,
			@RequestParam(required = false, defaultValue = "0") @ApiParam(name = "pageNum", value = "页码") Integer pageNum){
		return sucesssRet(dictionaryService.findPageList(name,pageBounds(pageNum)));
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ApiOperation(value = "删除字典")
	public Object del(@ApiParam(required = true, name = "id", value = "字典id") @PathVariable Long id){
		return sucesssRet(dictionaryService.deleteById(id));
	}
	
	
	
}
