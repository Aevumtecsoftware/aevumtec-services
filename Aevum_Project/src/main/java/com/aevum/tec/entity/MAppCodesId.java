package com.aevum.tec.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class MAppCodesId implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
    private String code;

    // Default constructor
   // public MAppCodesId() {}

  
}

