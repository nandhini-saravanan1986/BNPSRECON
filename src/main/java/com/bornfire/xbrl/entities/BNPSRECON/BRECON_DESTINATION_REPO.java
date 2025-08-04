package com.bornfire.xbrl.entities.BNPSRECON;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BRECON_DESTINATION_REPO extends JpaRepository<BRECON_DESTINATION_ENTITY, String> {

	@Query(value = "SELECT FYITRANSACTION.NEXTVAL FROM DUAL", nativeQuery = true)
	String srlno();

	@Query(value = "select distinct report_name from BRECON_DESTINATION_TABLE", nativeQuery = true)
	List<String> getReportNames();
	
	@Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM BRECON_DESTINATION_TABLE WHERE ntry_refs_clearing_system_reference = ?1", nativeQuery = true)
	Integer checkduplicatentry(String ntry_refs_clearing_system_reference);
	
	@Query("SELECT r.ntry_refs_clearing_system_reference,r.ntry_transaction_amount,r.ntry_txdtls_credit_debit_indicator FROM\r\n"
			+ "BRECON_DESTINATION_ENTITY  r WHERE r.ntry_refs_clearing_system_reference IN :refs")
	List<Object[]> findExistingReferences(@Param("refs") Set<String> refs);

	
	@Query(value = "select * from BRECON_DESTINATION_TABLE where ntry_refs_clearing_system_reference=?1", nativeQuery = true)
	Optional<BRECON_DESTINATION_ENTITY> checkntryref(String ntry_refs_clearing_system_reference);
	

	@Query(value = "select distinct REPORT_DATE,NTRY_VALUE_DATE,report_name,STMT_ACCOUNT_IDENTIFIER,count(report_name) as no_of_fields_inserted,TXSSUMMRY_NUMBER_OF_ENTRIES,TXSSUMMRY_CREDIT_NUMBER_OF_ENTRIES,TXSSUMMRY_DEBIT_NUMBER_OF_ENTRIES from BRECON_DESTINATION_TABLE group by report_name,REPORT_DATE,NTRY_VALUE_DATE,STMT_ACCOUNT_IDENTIFIER,TXSSUMMRY_NUMBER_OF_ENTRIES,TXSSUMMRY_CREDIT_NUMBER_OF_ENTRIES,TXSSUMMRY_DEBIT_NUMBER_OF_ENTRIES ORDER BY REPORT_DATE", nativeQuery = true)
	List<Object> getlist();

	@Query(value = "select * from BRECON_DESTINATION_TABLE WHERE RECON_FLAG = 'N'", nativeQuery = true)
	List<BRECON_DESTINATION_ENTITY> getDestination();

	@Query(value = "select * from brecon_destination_table where NTRY_VALUE_DATE = ?1", nativeQuery = true)
	List<BRECON_DESTINATION_ENTITY> getReportNamesvalues(Date yesterdayDate);

	@Query(value = "select * from brecon_destination_table where NTRY_REFS_TRANSACTION_ID = ?1", nativeQuery = true)
	List<BRECON_DESTINATION_ENTITY> getReportNamesvaluesdata(String yesterdayDate);

	@Query(value = "select distinct REPORT_DATE,report_name,STMT_ACCOUNT_IDENTIFIER,count(report_name) as no_of_fields_inserted,TXSSUMMRY_NUMBER_OF_ENTRIES,TXSSUMMRY_CREDIT_NUMBER_OF_ENTRIES,TXSSUMMRY_DEBIT_NUMBER_OF_ENTRIES from BRECON_DESTINATION_TABLE group by report_name,REPORT_DATE,STMT_ACCOUNT_IDENTIFIER,TXSSUMMRY_NUMBER_OF_ENTRIES,TXSSUMMRY_CREDIT_NUMBER_OF_ENTRIES,TXSSUMMRY_DEBIT_NUMBER_OF_ENTRIES", nativeQuery = true)
	List<Object> getlistval();

	@Query(value = "select * from BRECON_DESTINATION_TABLE where srlno = ?1", nativeQuery = true)
	BRECON_DESTINATION_ENTITY getSrlno(String srlno);

	@Query(value = "SELECT " + "    'BreconSourceTable' AS table_name_source, " + "    src.source_count, "
			+ "    'BreconDestinationTable' AS table_name_destination, " + "    dest.destination_count " + "FROM "
			+ "    (SELECT COUNT(TRAN_DATE) AS source_count " + "     FROM brecon_source_table "
			+ "     WHERE TRAN_DATE = TO_DATE(?1, 'DD-MON-YYYY')) src " + "CROSS JOIN "
			+ "    (SELECT COUNT(STMT_CREATION_DATE_TIME) AS destination_count "
			+ "     FROM brecon_destination_table WHERE TRUNC(STMT_CREATION_DATE_TIME) = TO_DATE(?2, 'DD-MON-YYYY')) dest", nativeQuery = true)
	List<Object> getlistvalues(String fromDateToUse, String fromDateToUse1);

	@Query(value = "select * from brecon_destination_table where NTRY_VALUE_DATE = ?1", nativeQuery = true)
	List<BRECON_DESTINATION_ENTITY> getReportNamesvaluesdatas(Date yesterdayDate);

	@Query(value = "select * from BRECON_DESTINATION_TABLE where RECON_FLAG = 'N' AND NTRY_VALUE_DATE = ?1", nativeQuery = true)
	List<BRECON_DESTINATION_ENTITY> getDestinationdatavalues(Date yesterdayDate);

	@Query(value = "select * from brecon_destination_table where REPORT_DATE = ?1", nativeQuery = true)
	List<BRECON_DESTINATION_ENTITY> getReportNamesvaluesdata(Date yesterdayDate);
	
	@Query(value = "SELECT 'BreconSourceTable' AS table_name_source,src.source_count,'BreconDestinationTable' AS table_name_destination,dest.destination_count FROM (SELECT COUNT(TRAN_DATE) AS source_count FROM brecon_source_table) src CROSS JOIN (SELECT COUNT(STMT_CREATION_DATE_TIME) AS destination_count FROM brecon_destination_table) dest", nativeQuery = true)
	List<Object> getlistvalues();
	
	@Query(value = "SELECT * FROM (select distinct ntry_value_date,ntry_refs_clearing_system_reference,count(ntry_refs_clearing_system_reference) AS AANIPAYCOUNT from BRECON_DESTINATION_TABLE where "
			+ "ntry_value_date >= sysdate-7\r\n" + 
			"GROUP BY ntry_value_date,ntry_refs_clearing_system_reference) WHERE AANIPAYCOUNT >1", nativeQuery = true)
	List<Object[]> getaaniduplicaterecord();

}
