package com.dataman.pike.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataman.pike.core.dao.mapper.ex.ProjectExMapper;
import com.dataman.pike.core.entity.Project;
import com.dataman.pike.core.service.IProjectService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	ProjectExMapper projectExMapper;
	
	@Override
	public PageList<Project> findPageList(PageBounds pb) {
		// TODO Auto-generated method stub
		return projectExMapper.findPageList(pb);
	}

}
