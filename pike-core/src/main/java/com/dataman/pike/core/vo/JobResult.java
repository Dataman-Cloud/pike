package com.dataman.pike.core.vo;

/**
 * @ClassName: Job 执行返回结果
 * @Description: TODO() 
 * @author liuqing 
 * @date 2017年11月3日 下午4:00:55 
 * @Copyright © 2017北京数人科技有限公司
 */
public class JobResult {

	boolean result;
	String resultMsg;
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public String getResultMsg() {
		return resultMsg;
	}
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	
	public JobResult(boolean result, String resultMsg) {
		super();
		this.result = result;
		this.resultMsg = resultMsg;
	}
	
}
