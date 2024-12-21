package com.aevum.tec.dto;

import com.aevum.tec.dto.MAppCodesDTO.FilterCondition;

import lombok.Data;

@Data
public class FilterDTO {

	 private String data1;
     private String data2;
     private String data3;
     private String data4;
     private String data5;
     private String data5Col;
     private String columnName;
     private String orderBy;

     private FilterCondition data1Cond = FilterCondition.IN;
     private FilterCondition data2Cond = FilterCondition.IN;
     private FilterCondition data3Cond = FilterCondition.IN;
     private FilterCondition data4Cond = FilterCondition.IN;
     private FilterCondition data5Cond = FilterCondition.IN;
     
}
