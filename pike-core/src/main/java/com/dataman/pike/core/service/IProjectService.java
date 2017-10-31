package com.dataman.pike.core.service;

import com.dataman.pike.core.entity.Project;
import com.dataman.pike.core.param.ProjectParam;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface IProjectService {
	
	Project findById(Long id);
	
	PageList<Project> findPageList(String proNo,String proName,String proManager,String source,PageBounds pb);

	int addProject(ProjectParam param);
	
	int editProject(Long id,ProjectParam param);
	
	int deleteById(Long id);
	
}
