package com.dataman.pike.core.dao.mapper.ex;

import org.apache.ibatis.annotations.Param;

import com.dataman.pike.core.vo.OperationVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface OperationExMapper {

	public PageList<OperationVo> findPageList(@Param("nameCn") String nameCn,PageBounds pb);
	
	public OperationVo findById(@Param("id") long id);
}

