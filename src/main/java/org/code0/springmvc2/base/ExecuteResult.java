package org.code0.springmvc2.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: ExecuteResult.java
 * @Package org.code0.springmvc2.util
 * @Description: ExecuteResult.java
 * @author Code0
 * @date 2018年1月6日 下午12:46:53
 */
public class ExecuteResult implements Serializable {
	
	private static final long serialVersionUID = -5773062345051251353L;
	
	public static ExecuteResult getExecuteResult(){
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

	public String getSuccessMessage() {
		return this.successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
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
	
	public Object getReData() {
		return this.reData;
	}

	public void setReData(Object data) {
		this.reData = data;
	}

	public List<String> getErrorMessages() {
		return this.errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public Map<String, Object> getFieldErrors() {
		return this.fieldErrors;
	}

	public void setFieldErrors(Map<String, Object> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	public List<String> getWarningMessages() {
		return this.warningMessages;
	}

	public void setWarningMessages(List<String> warningMessages) {
		this.warningMessages = warningMessages;
	}

	public void addErrorMessage(String errorMessage) {
		this.errorMessages.add(errorMessage);
	}

	public void addFieldError(String field, Object errorMessage) {
		this.fieldErrors.put(field, errorMessage);
	}

	public void addWarningMessage(String warningMessage) {
		this.warningMessages.add(warningMessage);
	}

	public Throwable getThrowable() {
		return this.throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}
}
