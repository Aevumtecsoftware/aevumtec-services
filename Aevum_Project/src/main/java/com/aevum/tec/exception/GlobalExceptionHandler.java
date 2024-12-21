package com.aevum.tec.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.Data;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(GeneralException.class)
	public ResponseEntity<Object> handlingGeneralException(GeneralException ex) {

		ErrorResponse errorResponse = new ErrorResponse(ex.getErrorCode(), ex.getErrorMessage(), ex.getErrorTime());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Data
	public static class ErrorResponse {

		private int errorCode;
		private String errorMessage;
		private String errorTime;

		public ErrorResponse(int errorCode, String errorMessage, String errorTime) {
			this.errorCode = errorCode;
			this.errorMessage = errorMessage;
			this.errorTime = errorTime;
		}
	}

}
