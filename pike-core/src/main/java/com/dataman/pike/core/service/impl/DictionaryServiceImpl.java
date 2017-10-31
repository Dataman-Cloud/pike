package com.dataman.pike.core.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataman.pike.core.dao.mapper.auto.DictionaryMapper;
import com.dataman.pike.core.dao.mapper.ex.DictionaryExMapper;
import com.dataman.pike.core.entity.Dictionary;
import com.dataman.pike.core.param.DictionaryParam;
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
	public int addDictionary(DictionaryParam param) {
		Calendar cal=Calendar.getInstance();
		Dictionary o =new Dictionary();
		o.setNameCn(param.getNameCn());
		o.setNameEn(param.getNameEn());
		o.setType(param.getType());
		o.setValue(param.getValue());
		o.setCreator(param.getCreator());
		o.setCreateAt(cal.getTime());
		o.setUpdateAt(cal.getTime());
		return dictionaryMapper.insertSelective(o);
	}

	@Override
	public int editDictionary(Long id,DictionaryParam param) {
		Calendar cal=Calendar.getInstance();
		Dictionary o =new Dictionary();
		o.setId(id);
		o.setNameCn(param.getNameCn());
		o.setNameEn(param.getNameEn());
		o.setType(param.getType());
		o.setValue(param.getValue());
		o.setUpdateAt(cal.getTime());
		return dictionaryMapper.updateByPrimaryKeySelective(o);
	}

	@Override
	public int deleteById(Long id) {
		return dictionaryMapper.deleteByPrimaryKey(id);
	}

}
