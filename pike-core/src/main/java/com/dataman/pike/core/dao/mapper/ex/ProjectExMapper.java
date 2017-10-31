package com.dataman.pike.core.dao.mapper.ex;

import org.apache.ibatis.annotations.Param;

import com.dataman.pike.core.entity.Project;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface ProjectExMapper {
	/**
	 * @method findPageList(分页)
	 * @return PageList<Project>
	 * @author liuqing
	 * @date 2017年10月30日 上午10:30:29
	 */
	PageList<Project> findPageList(@Param("proNo") String proNo,@Param("proName") String proName,
			@Param("proManager") String proManager,@Param("source") String source,PageBounds pb);
	
}
