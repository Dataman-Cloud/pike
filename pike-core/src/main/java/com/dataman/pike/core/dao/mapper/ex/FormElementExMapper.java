package com.dataman.pike.core.dao.mapper.ex;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dataman.pike.core.entity.FormElement;

public interface FormElementExMapper {
    
	public int delByOperId(@Param("operId") Long operId);
	
	public List<FormElement> selectByOperId(@Param("operId") Long operId);
	
	public int insertList(@Param("list") List<FormElement> list);
}