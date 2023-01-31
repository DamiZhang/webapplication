package com.sk.userman.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author xbxqc
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private String message;
	private int code = 500;

	public BusinessException() {

	}

	public BusinessException(String message) {
		this.message = message;
	}

	public BusinessException(String message, int code) {
		this.message = message;
		this.code = code;
	}

}

