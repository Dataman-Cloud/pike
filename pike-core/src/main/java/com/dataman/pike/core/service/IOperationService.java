package com.dataman.pike.core.service;

import com.dataman.pike.core.param.OperationParam;
import com.dataman.pike.core.vo.JobResult;
import com.dataman.pike.core.vo.OperationVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface IOperationService {

	public OperationVo findById(Long id);
	
	public int deleteById(Long id);
	
	public PageList<OperationVo> findPageList(String nameCn,PageBounds pb);
	
	public int addOperation(OperationParam param);
	
	public int editOperation(Long id,OperationParam param);
	
	public JobResult testOperation(Long id,OperationParam param);
	
}
