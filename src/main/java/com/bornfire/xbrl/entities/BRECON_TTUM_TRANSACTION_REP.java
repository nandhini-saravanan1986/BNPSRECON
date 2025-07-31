package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface BRECON_TTUM_TRANSACTION_REP extends JpaRepository<BRECON_TTUM_TRANSACTION_ENTITY, String> {

	@Query(value = "select * from BRECON_TTUM_TRANSACTION where  RECON_FLAG = 'N' and NTRY_VALUE_DATE = ?1", nativeQuery = true)
	List<BRECON_TTUM_TRANSACTION_ENTITY> getttumtransaction(Date reportDate);

	@Query(value = "select * from BRECON_TTUM_TRANSACTION where NTRY_VALUE_DATE = ?1", nativeQuery = true)
	List<BRECON_TTUM_TRANSACTION_ENTITY> getReportNamesvalues(Date yesterdayDate);

	@Query(value = "SELECT FYITRANSACTION.NEXTVAL FROM DUAL", nativeQuery = true)
	String srlno();

	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM BRECON_TTUM_TRANSACTION WHERE ntry_refs_clearing_system_reference = ?1", nativeQuery = true)
	Integer checkduplicatentry(String ntry_refs_clearing_system_reference);
	
	@Query("SELECT r.ntry_refs_clearing_system_reference,r.ntry_transaction_amount,r.ntry_txdtls_credit_debit_indicator\r\n"
			+ "			 FROM BRECON_TTUM_TRANSACTION_ENTITY  r WHERE r.ntry_refs_clearing_system_reference IN :refs")
	List<Object[]> findExistingReferences(@Param("refs") Set<String> refs);

	
	@Query(value = "select distinct report_name from BRECON_TTUM_TRANSACTION", nativeQuery = true)
	List<String> getReportNames();

}
