package org.code0.springmvc2.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * @Title: ExecuteResult.java
 * @Package org.code0.springmvc2.util
 * @Description: ExecuteResult.java
 * @author Code0
 * @date 2018年1月6日 下午12:46:53
 */
@Getter
@Setter
public class ExecuteResult implements Serializable {
	
	private static final long serialVersionUID = -5773062345051251353L;
	
	/**
	 * 返回一个代表success的不包含任何信息的ExecuteResult对象
	 * @return
	 */
	public static ExecuteResult success(){
		return new ExecuteResult();
	}
	
	/** @Fields reData : 根据需求返回的业务数据 */
	private Object reData;
	/** @Fields successMessage : 成功信息 */
	private String successMessage;
	/** @Fields errorMessages : 错误信息 */
	private List<String> errorMessages = new ArrayList<String>();
	/** @Fields fieldErrors : 字段相关错误信息 */
	private Map<String, Object> fieldErrors = new HashMap<String, Object>();
	/** @Fields warningMessages : 警告信息 */
	private List<String> warningMessages = new ArrayList<String>();
	/** @Fields throwable : 抛出的异常 */
	private Throwable throwable;

	public void addErrorMessage(String errorMessage) {
		this.errorMessages.add(errorMessage);
	}

	public void addFieldError(String field, Object errorMessage) {
		this.fieldErrors.put(field, errorMessage);
	}

	public void addWarningMessage(String warningMessage) {
		this.warningMessages.add(warningMessage);
	}
	
	public boolean isSuccess() {
		return (this.errorMessages.isEmpty()) && (this.fieldErrors.isEmpty());
	}

	public boolean hasFieldError(){
		return !this.fieldErrors.isEmpty();
	}
	
	public boolean hasErrorMessage(){
		return !this.errorMessages.isEmpty();
	}
	
}
