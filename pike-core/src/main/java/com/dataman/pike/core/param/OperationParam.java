package com.dataman.pike.core.param;

import java.util.List;

public class OperationParam {

	String nameCn;
	String nameEn;
	int type;
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


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public List<FormElementParam> getFormElements() {
		return formElements;
	}


	public void setFormElements(List<FormElementParam> formElements) {
		this.formElements = formElements;
	}


	public class FormElementParam {
		String nameCn;
		String nameEn;
		String elementName;
		String rules;
		String placeholder;
		Long valueDic;
		
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
		public String getElementName() {
			return elementName;
		}
		public void setElementName(String elementName) {
			this.elementName = elementName;
		}
		public String getRules() {
			return rules;
		}
		public void setRules(String rules) {
			this.rules = rules;
		}
		public String getPlaceholder() {
			return placeholder;
		}
		public void setPlaceholder(String placeholder) {
			this.placeholder = placeholder;
		}
		public Long getValueDic() {
			return valueDic;
		}
		public void setValueDic(Long valueDic) {
			this.valueDic = valueDic;
		}
	}
}
