package com.dataman.pike.core.vo;

import java.util.List;

import com.dataman.pike.core.entity.FormElement;
import com.dataman.pike.core.entity.Operation;

public class OperationVo extends Operation {

	int runNum; //执行次数
	double avgUseTime; //平均使用时间
	double successRate; //成功率
	List<FormElement> formElements;
	
	public int getRunNum() {
		return runNum;
	}
	public void setRunNum(int runNum) {
		this.runNum = runNum;
	}
	public double getAvgUseTime() {
		return avgUseTime;
	}
	public void setAvgUseTime(double avgUseTime) {
		this.avgUseTime = avgUseTime;
	}
	public double getSuccessRate() {
		return successRate;
	}
	public void setSuccessRate(double successRate) {
		this.successRate = successRate;
	}
	public List<FormElement> getFormElements() {
		return formElements;
	}
	public void setFormElements(List<FormElement> formElements) {
		this.formElements = formElements;
	} 
	
	
}
