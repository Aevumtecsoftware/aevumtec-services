package com.aevum.tec.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.aevum.tec.entity.MAppCodes;
import com.aevum.tec.entity.MAppCodesId;


@Repository
public interface MAppCodesRepository extends JpaRepository<MAppCodes, MAppCodesId> {


	@Query("SELECT m FROM MAppCodes m WHERE m.type = :type ")
    List<MAppCodes> findByTypeAndDateRange(@Param("type") String type);


}

