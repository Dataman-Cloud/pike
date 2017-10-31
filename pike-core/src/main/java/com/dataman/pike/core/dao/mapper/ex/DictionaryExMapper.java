package com.dataman.pike.core.dao.mapper.ex;

import org.apache.ibatis.annotations.Param;

import com.dataman.pike.core.entity.Dictionary;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface DictionaryExMapper {

	public PageList<Dictionary> findPageList(@Param("nameCn") String nameCn,PageBounds pb);
}
