package com.aevum.tec.login;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aevum.tec.entity.MobileUser;

@Repository
public interface UserAuthRepository extends JpaRepository<MobileUser, String> {

	@Modifying
	@Transactional
	@Query("UPDATE MobileUser u SET u.resetOtp = :otp, u.updatedDate = :updatedDate WHERE u.mobileNo = :mobileNo")
	int updateMurestotpById(@Param("mobileNo") String mobileNo, @Param("otp") String resetOtpFlag, @Param("updatedDate") Date updatedDate);
}
