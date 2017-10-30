package com.dataman.pike.core.service;

import com.dataman.pike.core.entity.Project;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface IProjectService {

	PageList<Project> findPageList(PageBounds pb);
}
