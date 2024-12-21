package com.aevum.tec.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class MAppCodesDTO {

    private String code;

    private String type;

    private String value;

    private String mainCode;

    private String masterDefCode;

    private String description;

    private String descriptionBl;

    private String shortDescription;

    private String shortDescriptionBl;

    private String longDescription;

    private String longDescriptionBl;

    private String codeByLobYn;

    private String lobCode;

    private String companyCode;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    private Date effectiveFromDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    private Date effectiveToDate;

    private String mapCode;

    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    private Date createdDate;

    private String updatedBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    private Date updatedDate;
    public enum FilterCondition {

        EQ, IN, INL
    }

    private FilterDTO filter;  
    //private 
}
