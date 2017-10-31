package com.dataman.pike.core.service;

import com.dataman.pike.core.entity.Dictionary;
import com.dataman.pike.core.param.DictionaryParam;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

public interface IDictionaryService {

	public Dictionary findById(Long id);
	
	public int deleteById(Long id);
	
	public PageList<Dictionary> findPageList(String nameCn,PageBounds pb);
	
	public int addDictionary(DictionaryParam param);
	
	public int editDictionary(Long id,DictionaryParam param);
	
}
