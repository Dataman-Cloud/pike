package com.dataman.pike.core.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataman.pike.core.dao.mapper.auto.DictionaryMapper;
import com.dataman.pike.core.dao.mapper.ex.DictionaryExMapper;
import com.dataman.pike.core.entity.Dictionary;
import com.dataman.pike.core.service.IDictionaryService;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
	
	@Autowired
	DictionaryMapper dictionaryMapper;
	
	@Autowired
	DictionaryExMapper dictionaryExMapper;
	
	@Override
	public Dictionary findById(Long id) {
		return dictionaryMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageList<Dictionary> findPageList(String nameCn, PageBounds pb) {
		return dictionaryExMapper.findPageList(nameCn, pb);
	}

	@Override
	public int addDictionary(Dictionary o) {
		return dictionaryMapper.insert(o);
	}

	@Override
	public int editDictionary(Dictionary o) {
		return dictionaryMapper.updateByPrimaryKeySelective(o);
	}

	@Override
	public int deleteById(Long id) {
		return dictionaryMapper.deleteByPrimaryKey(id);
	}

}
