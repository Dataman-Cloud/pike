package com.dataman.pike.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@CrossOrigin(origins="*")
public class BaseController {

	protected static String SUCCESS_CODE="00";
	protected static String FAIL_CODE="01";
	protected static String PARAMERR_CODE="02";
	
	static int DEFAULT_PAGE_SIZE = 10;
	
	public PageBounds pageBounds(int pageNum){
		return new PageBounds(pageNum, DEFAULT_PAGE_SIZE);
	}
	
	public PageBounds pageBounds(int pageNum,Order... order){
		return new PageBounds(pageNum, DEFAULT_PAGE_SIZE,order);
	}
	
	public static Object sucesssRet(Object data){
		Map<String, Object> json = new HashMap<String, Object>(2);
		json.put("resultCode", SUCCESS_CODE);
		json.put("data",data);
		return json;
	}
	
	public static Object failRet(Object msg){
		Map<String, Object> json = new HashMap<String, Object>(2);
		json.put("resultCode", FAIL_CODE);
		json.put("errmsg",msg);
		return json;
	}
	
}
