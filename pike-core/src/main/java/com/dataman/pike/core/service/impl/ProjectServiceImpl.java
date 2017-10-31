package com.dataman.pike.core.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataman.pike.core.dao.mapper.auto.ProjectMapper;
import com.dataman.pike.core.dao.mapper.ex.ProjectExMapper;
import com.dataman.pike.core.entity.Project;
import com.dataman.pike.core.param.ProjectParam;
import com.dataman.pike.core.service.IProjectService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	ProjectMapper projectMapper;
	
	@Autowired
	ProjectExMapper projectExMapper;
	
	@Override
	public PageList<Project> findPageList(String proNo,String proName,String proManager,String source,PageBounds pb) {
		// TODO Auto-generated method stub
		return projectExMapper.findPageList(proNo,proName,proManager,source,pb);
	}

	@Override
	public Project findById(Long id) {
		// TODO Auto-generated method stub
		return projectMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addProject(ProjectParam param) {
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();
		Project pro =new Project();
		pro.setCreateAt(cal.getTime());
		pro.setEndAt(cal.getTime());
		pro.setEmail(param.getEmail());
		pro.setExteneralId(param.getExteneralId());
		pro.setHealthCheck(param.getHealthCheck());
		pro.setType(param.getType());
		pro.setManager(param.getManager());
		pro.setManagerId(param.getManagerId());
		pro.setPhone(param.getPhone());
		pro.setProname(param.getProname());
		pro.setRemarkName(param.getRemarkName());
		return projectMapper.insertSelective(pro);
	}

	@Override
	public int editProject(Long id, ProjectParam param) {
		// TODO Auto-generated method stub
		Calendar cal=Calendar.getInstance();
		Project pro =new Project();
		pro.setId(id);
		pro.setEndAt(cal.getTime());
		pro.setEmail(param.getEmail());
		pro.setExteneralId(param.getExteneralId());
		pro.setHealthCheck(param.getHealthCheck());
		pro.setType(param.getType());
		pro.setManager(param.getManager());
		pro.setManagerId(param.getManagerId());
		pro.setPhone(param.getPhone());
		pro.setProname(param.getProname());
		pro.setRemarkName(param.getRemarkName());
		return projectMapper.updateByPrimaryKeySelective(pro);
	}

	@Override
	public int deleteById(Long id) {
		// TODO Auto-generated method stub
		
		
		
		return projectMapper.deleteByPrimaryKey(id);
	}

}
