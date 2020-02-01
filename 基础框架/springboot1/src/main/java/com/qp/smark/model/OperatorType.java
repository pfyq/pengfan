package com.qp.smark.model;

/**
 * 日志操作类型
 * 
 * @author sswu
 * 
 */
public enum OperatorType {
	SELECT("0"), UPDATE("1"), ADD("2"), DELETE("3");

	String value;

	OperatorType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
