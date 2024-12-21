package com.aevum.tec.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aevum.tec.dto.MAppCodesDTO;
import com.aevum.tec.message.model.MessageModel;
import com.aevum.tec.services.CommonService;

@RestController
@RequestMapping("/api/")

public class CommonController {

	private final CommonService mAppCodesService;

	public CommonController(CommonService mAppCodesService) {
		this.mAppCodesService = mAppCodesService;
	}

	@PostMapping("/dropDownList")
	public ResponseEntity<MessageModel> getApplCodesList(@RequestBody MAppCodesDTO bean,
			@RequestHeader(required = true) String company) {
		MessageModel res = mAppCodesService.getApplCodesList(bean);
		return new ResponseEntity<MessageModel>(res, HttpStatus.ACCEPTED);
	}
}
