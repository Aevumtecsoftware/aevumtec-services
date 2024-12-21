package com.aevum.tec.message.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageModel {

	private String message;
	private String messageType;
	private Object data;
	private LocalDateTime timestamp = LocalDateTime.now();
	private String otp;

}
