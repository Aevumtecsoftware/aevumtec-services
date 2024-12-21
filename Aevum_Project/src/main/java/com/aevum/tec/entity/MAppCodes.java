package com.aevum.tec.entity;

import java.util.Date;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "M_APP_CODES")
@IdClass(MAppCodesId.class)
public class MAppCodes {

    @Id
    @Column(name = "AC_TYPE", length = 12)
    private String type;
    
    @Id
    @Column(name = "AC_CODE", length = 50, nullable = false)
    private String code;

    @Column(name = "AC_VALUE", length = 240)
    private String value;

    @Column(name = "AC_MAIN_CODE", length = 240)
    private String mainCode;

    @Column(name = "AC_MAST_DEF_CODE", length = 240)
    private String masterDefCode;

    @Column(name = "AC_DESC", length = 240)
    private String description;

    @Column(name = "AC_DESC_BL", length = 4000)
    private String descriptionBl;

    @Column(name = "AC_SHORT_DESC", length = 60)
    private String shortDescription;

    @Column(name = "AC_SHORT_DESC_BL", length = 60)
    private String shortDescriptionBl;

    @Column(name = "AC_LONG_DESC", length = 4000)
    private String longDescription;

    @Column(name = "AC_LONG_DESC_BL", length = 4000)
    private String longDescriptionBl;

    @Column(name = "AC_CODE_BY_LOB_YN", length = 1)
    private String codeByLobYn;

    @Column(name = "AC_LOB_CODE", length = 12)
    private String lobCode;

    @Column(name = "AC_CMP_CODE", length = 12)
    private String companyCode;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @Column(name = "AC_EFF_FM_DT")
    private Date effectiveFromDate;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @Column(name = "AC_EFF_TO_DT")
    private Date effectiveToDate;

    @Column(name = "AC_MAP_CODE", length = 12)
    private String mapCode;

    @Column(name = "AC_CR_UID", length = 12)
    private String createdBy;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @Column(name = "AC_CR_DT")
    private Date createdDate;

    @Column(name = "AC_UPD_UID", length = 12)
    private String updatedBy;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @Column(name = "AC_UPD_DT")
    private Date updatedDate;
}

