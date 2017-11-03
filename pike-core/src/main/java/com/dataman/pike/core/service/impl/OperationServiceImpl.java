package com.dataman.pike.core.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dataman.pike.core.dao.mapper.auto.FormElementMapper;
import com.dataman.pike.core.dao.mapper.auto.OperationMapper;
import com.dataman.pike.core.dao.mapper.ex.FormElementExMapper;
import com.dataman.pike.core.dao.mapper.ex.OperationExMapper;
import com.dataman.pike.core.entity.FormElement;
import com.dataman.pike.core.entity.Operation;
import com.dataman.pike.core.param.OperationParam;
import com.dataman.pike.core.param.FormElementParam;
import com.dataman.pike.core.service.IOperationService;
import com.dataman.pike.core.vo.JobResult;
import com.dataman.pike.core.vo.OperationVo;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;

@Service
public class OperationServiceImpl implements IOperationService {

	@Autowired
	OperationMapper operationMapper;
	@Autowired
	OperationExMapper operationExMapper;
	@Autowired
	FormElementMapper formElementMapper;
	@Autowired
	FormElementExMapper formElementExMapper;

	@Override
	public OperationVo findById(Long id) {
		// TODO Auto-generated method stub
		return operationExMapper.findById(id);
	}

	@Override
	@Transactional
	public int deleteById(Long id) {
		// 检测是否 有 发布 包含 该操作
		// 删除 form_element
		formElementExMapper.delByOperId(id);
		// 删除 operation
		return operationMapper.deleteByPrimaryKey(id);
	}

	@Override
	public PageList<OperationVo> findPageList(String nameCn, PageBounds pb) {
		// TODO Auto-generated method stub
		return operationExMapper.findPageList(nameCn, pb);
	}

	@Override
	@Transactional
	public int addOperation(OperationParam param) {
		String formStr = "";

		short status = 0;
		Calendar cal = Calendar.getInstance();
		Operation op = new Operation();
		List<FormElement> list = new ArrayList<FormElement>();
		op.setNameCn(param.getNameCn());
		op.setNameEn(param.getNameEn());
		op.setType(param.getType());
		op.setCreateAt(cal.getTime());
		op.setUpdateAt(cal.getTime());
		op.setStatus(status);
		// TODO 构建 formStr
		op.setFormStr(formStr);
		if (param.getType() == 0) {
			op.setShellResultStr(param.getResultStr());
		} else {
			op.setGroovyResultStr(param.getResultStr());
		}
		operationMapper.insertSelective(op);
		for (FormElementParam ele : param.getFormElements()) {
			FormElement fe = new FormElement();
			fe.setCreateAt(cal.getTime());
			fe.setUpdateAt(cal.getTime());
			fe.setNameCn(ele.getNameCn());
			fe.setNameEn(ele.getNameEn());
			fe.setPlaceholder(ele.getPlaceholder());
			fe.setRules(ele.getRules());
			fe.setValueDic(ele.getValueDic());
			fe.setElementName(ele.getElementName());
			fe.setOperId(op.getId());
			list.add(fe);
		}
		if (!list.isEmpty()) {
			formElementExMapper.insertList(list);
		}
		return 0;
	}

	@Override
	@Transactional
	public int editOperation(Long id, OperationParam param) {
		String formStr = "";
		short status = 0;
		Calendar cal = Calendar.getInstance();
		Operation op = new Operation();
		List<FormElement> list = new ArrayList<FormElement>();
		op.setId(id);
		op.setNameCn(param.getNameCn());
		op.setNameEn(param.getNameEn());
		op.setType(param.getType());
		op.setCreateAt(cal.getTime());
		op.setUpdateAt(cal.getTime());
		op.setStatus(status);
		// TODO 构建 formStr groovyResultStr shellResultStr
		op.setFormStr(formStr);
		if (param.getType() == 0) {
			op.setShellResultStr(param.getResultStr());
		} else {
			op.setGroovyResultStr(param.getResultStr());
		}
		operationMapper.updateByPrimaryKeySelective(op);
		formElementExMapper.delByOperId(id);
		for (FormElementParam ele : param.getFormElements()) {
			FormElement fe = new FormElement();
			fe.setCreateAt(cal.getTime());
			fe.setUpdateAt(cal.getTime());
			fe.setNameCn(ele.getNameCn());
			fe.setNameEn(ele.getNameEn());
			fe.setPlaceholder(ele.getPlaceholder());
			fe.setRules(ele.getRules());
			fe.setValueDic(ele.getValueDic());
			fe.setElementName(ele.getElementName());
			fe.setOperId(op.getId());
			list.add(fe);
		}
		if (!list.isEmpty()) {
			formElementExMapper.insertList(list);
		}
		return 0;
	}

	@Override
	public JobResult testOperation(Long id, OperationParam param) {
		// TODO Auto-generated method stub
		return null;
	}

}
