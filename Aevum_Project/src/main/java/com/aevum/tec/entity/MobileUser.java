package com.aevum.tec.entity;

import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@Table(name = "M_MOBILE_USERS")
public class MobileUser {

    @Column(name = "MU_IMEI", length = 60)
    private String imei;

    @Column(name = "MU_COUNTRY_CODE", length = 12)
    private String countryCode;

    @Column(name = "MU_NAME", length = 240)
    private String name;

    @Id
    @Column(name = "MU_MOBILE_NO", length = 240)
    private String mobileNo;

    @Column(name = "MU_CIVIL_ID", length = 20)
    private String civilId;

    @Column(name = "MU_EMAIL_ID", length = 60)
    private String emailId;

    @Column(name = "MU_LANGUAGE", length = 1)
    private String language;

    @Column(name = "MU_DEVICE_MAKE", length = 240)
    private String deviceMake;

    @Column(name = "MU_USER_TYPE", length = 1)
    private String userType;

    @Column(name = "MU_MOB_TOKEN", length = 300)
    private String mobileToken;

    @Column(name = "MU_PASSWORD", length = 60)
    private String password;

    @Column(name = "MU_LOCKED", length = 1, columnDefinition = "varchar(1) default '0'")
    private String locked;

    @Column(name = "MU_STATUS", length = 1, columnDefinition = "varchar(1) default '2'")
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @Column(name = "MU_PWD_CHNG_DT")
    private Date passwordChangeDate;

    @Column(name = "MU_TOKEN", length = 300)
    private String token;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @Column(name = "MU_TOKEN_DT")
    private Date tokenDate;

    @Column(name = "MU_EMAIL_OK", length = 1, columnDefinition = "varchar(1) default '0'")
    private String emailOk;

    @Column(name = "MU_MOBILE_OK", length = 1, columnDefinition = "varchar(1) default '0'")
    private String mobileOk;

    @Column(name = "MU_DEVICE_VERSION", length = 240)
    private String deviceVersion;

    @Column(name = "MU_SESSION_TOKEN", length = 300)
    private String sessionToken;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @Column(name = "MU_LAST_LOGIN_DT")
    private Date lastLoginDate;

    @Column(name = "MU_RESET_OTP", length = 6)
    private String resetOtp;

    @Column(name = "MU_RESET_OTP_FLAG", length = 1)
    private String resetOtpFlag;

    @Column(name = "MU_RESET_TRLS", length = 1)
    private String resetTries;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @Column(name = "MU_RESET_VALID_TILL")
    private Date resetValidTill;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @Column(name = "MU_CR_DT", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "MU_CR_UID", length = 12)
    private String createdBy;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy")
    @Column(name = "MU_UPD_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Column(name = "MU_UPD_UID", length = 12)
    private String updatedBy;

    @Column(name = "MU_IP_ADDRESS", length = 255)
    private String ipAddress;

   
    @PrePersist
    protected void onCreate() {
        createdDate = new Date();  
        updatedDate = new Date();  
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Date();  
    }
}
