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
public class ExecuteResult<T> implements Serializable {
	
	private static final long serialVersionUID = -5773062345051251353L;
	
	private T result;
	private String successMessage;
	private List<String> errorMessages = new ArrayList<String>();
	private Map<String, String> fieldErrors = new HashMap<String, String>();
	private List<String> warningMessages = new ArrayList<String>();
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

	public T getResult() {
		return (T) this.result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public List<String> getErrorMessages() {
		return this.errorMessages;
	}

	public void setErrorMessages(List<String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public Map<String, String> getFieldErrors() {
		return this.fieldErrors;
	}

	public void setFieldErrors(Map<String, String> fieldErrors) {
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

	public void addFieldError(String field, String errorMessage) {
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
