package com.aevum.tec.dto;

import java.util.Date;

import lombok.Data;


@Data
public class MobileUserDTO {
    private String imei;
    private String countryCode;
    private String name;
    private String mobileNo;
    private String civilId;
    private String emailId;
    private String language;
    private String deviceMake;
    private String userType;
    private String mobileToken;
    private String password;
    private String locked;
    private String status;
    private Date passwordChangeDate;
    private String token;
    private Date tokenDate;
    private String emailOk;
    private String mobileOk;
    private String deviceVersion;
    private String sessionToken;
    private Date lastLoginDate;
    private String resetOtp;
    private String resetOtpFlag;
    private String resetTries;
    private Date resetValidTill;
    private Date createdDate;
    private String createdBy;
    private Date updatedDate;
    private String updatedBy;
    private String ipAddress;
}
