package com.aevum.tec.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GeneralException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private int errorCode;
	private String errorMessage;
	private String errorTime = new Timestamp(new Date().getTime()).toString();

	public GeneralException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
		this.errorMessage = errorMessage;
	}

	public GeneralException(int errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.errorTime = new Timestamp(new Date().getTime()).toString();
	}
}
