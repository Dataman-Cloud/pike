package com.dataman.pike.core.param;

import java.util.List;

public class OperationParam {

	String nameCn;
	String nameEn;
	Short type;
	String resultStr;

	List<FormElementParam> formElements;

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getNameEn() {
		return nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	public List<FormElementParam> getFormElements() {
		return formElements;
	}

	public void setFormElements(List<FormElementParam> formElements) {
		this.formElements = formElements;
	}

	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

}
