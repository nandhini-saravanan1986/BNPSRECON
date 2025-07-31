package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MANUAL_Audit_Rep extends JpaRepository<MANUAL_Audit_Entity, String>{
	@Query(value = "select * from MANUAL_AUDIT_TABLE where AUDIT_TABLE = 'XBRLUSERPROFILETABLE'", nativeQuery = true)
	List<MANUAL_Audit_Entity> getauditListLocalvalues();
	
	@Query(value = "select * from MANUAL_AUDIT_TABLE where AUDIT_TABLE = 'XBRLUSERPROFILETABLE' AND TRUNC(AUDIT_DATE) = ?1", nativeQuery = true)
	List<MANUAL_Audit_Entity> getauditListLocalvaluesbusiness(Date fromDateToUse);
	
	@Query(value = "SELECT * FROM MANUAL_AUDIT_TABLE WHERE AUDIT_TABLE IN ('BRECONDESTINATIONTABLE', 'BRECONSOURCETABLE') AND TRUNC(AUDIT_DATE) = TRUNC(?1)", nativeQuery = true)
	List<MANUAL_Audit_Entity> getauditListLocalvaluesbusiness1(Date fromDateToUse);
	
	}

