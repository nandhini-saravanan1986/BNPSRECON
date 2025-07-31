package com.bornfire.xbrl.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Transactional
@Repository

public interface KYC_Audit_Rep extends JpaRepository<KYC_Audit_Entity, String>{
	
	@Query(value = "select * from KYC_AUDIT_TABLE where AUDIT_TABLE = 'XBRLUSERPROFILETABLE'", nativeQuery = true)
	List<KYC_Audit_Entity> getauditListLocalvalues();
	
	@Query(value = "select * from KYC_AUDIT_TABLE where AUDIT_TABLE = 'Kyc_corporate'", nativeQuery = true)
	List<KYC_Audit_Entity> getauditListLocalvalues1();
	
	@Query(value = "select * from KYC_AUDIT_TABLE where TRUNC(AUDIT_DATE) = ?1", nativeQuery = true)
	List<KYC_Audit_Entity> getauditListOpeartion(Date audit_date);
	
	@Query(value = "SELECT KYC_AUDIT_SEQ.NEXTVAL FROM dual", nativeQuery = true)
	Long getAuditRefUUID();
	
	@Query(value = "select * from KYC_AUDIT_TABLE where AUDIT_TABLE = 'XBRLUSERPROFILETABLE' AND TRUNC(AUDIT_DATE) = ?1", nativeQuery = true)
	List<KYC_Audit_Entity> getauditListLocalvaluesbusiness(Date fromDateToUse);
	
	@Query(value = "SELECT * FROM KYC_AUDIT_TABLE WHERE AUDIT_TABLE IN ('Kyc_corporate', 'KYC_indidual') AND TRUNC(AUDIT_DATE) = TRUNC(?1)", nativeQuery = true)
	List<KYC_Audit_Entity> getauditListLocalvaluesbusiness1(Date fromDateToUse);
	@Query(value = "SELECT change_details FROM KYC_AUDIT_TABLE WHERE AUDIT_TABLE IN ('Kyc_corporate', 'KYC_indidual') and audit_ref_no = ?1", nativeQuery = true)
	String getchanges(String audit_ref_no);
	
}
