package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AlertRep extends JpaRepository<AlertEntity, String> {

	 @Query(value = "SELECT * FROM ALERT_AND_NOTIFICATION_TABLE WHERE report_srl = :reportSrl", nativeQuery = true)
	    List<AlertEntity> findByReportSrl(@Param("reportSrl") String reportSrl);
}
