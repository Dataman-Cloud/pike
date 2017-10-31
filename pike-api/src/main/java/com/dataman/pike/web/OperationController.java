package com.dataman.pike.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "Operation API")
@RestController
@RequestMapping(value = "/operation", produces = "application/json;charset=utf-8")
public class OperationController extends BaseController{

	
}
