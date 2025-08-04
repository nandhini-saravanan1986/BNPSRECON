package com.bornfire.xbrl.entities.BNPSRECON;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRECON_Common_Table_Rep extends JpaRepository<BRECON_Common_Table_Entity, String> {
	@Query(value = "SELECT BRECON_COMMON_SEQUENCE.NEXTVAL FROM DUAL", nativeQuery = true)
	String srlno();

	@Query(value = "SELECT * FROM BRECON_COMMON_TABLE WHERE RECON_FLAG = 'Y' ORDER BY PART_TRAN_SRL_NUM", nativeQuery = true)
	List<BRECON_Common_Table_Entity> getDestinationvalues();

	@Query(value = "select distinct TRAN_DATE from BRECON_COMMON_TABLE where TRAN_DATE = ?1", nativeQuery = true)
	String getcoresystemlistdatavalues1(String report_date);

	@Query(value = "SELECT A.TRAN_DATE, A.TRAN_ID, A.PART_TRAN_SRL_NUM, A.ACID, A.PART_TRAN_TYPE, A.TRAN_AMT, "
			+ "B.NTRY_VALUE_DATE, B.STMT_ACCOUNT_IDENTIFIER, B.TRANSACTION_CURRENCY, B.NTRY_ENTRY_REFERENCE, "
			+ "B.NTRY_CREDIT_DEBIT_INDICATOR, B.NTRY_TRANSACTION_AMOUNT " + "FROM brecon_source_table A "
			+ "JOIN brecon_destination_table B ON A.TRAN_RMKS = B.NTRY_REFS_CLEARING_SYSTEM_REFERENCE " + // Ensure
																											// correct
																											// join
																											// condition
			"FETCH FIRST 100 ROWS ONLY", nativeQuery = true)
	List<Object[]> getDestinationvaluesdata();

	@Query(value = "SELECT \r\n" + 
			"    A.TRAN_DATE,\r\n" + 
			"    A.TRAN_ID, \r\n" + 
			"    A.PART_TRAN_SRL_NUM, \r\n" + 
			"    A.ACID, \r\n" + 
			"    A.PART_TRAN_TYPE, \r\n" + 
			"    A.TRAN_AMT,\r\n" + 
			"    A.TRAN_RMKS,\r\n" + 
			"    B.NTRY_VALUE_DATE, \r\n" + 
			"    B.STMT_ACCOUNT_IDENTIFIER, \r\n" + 
			"    B.TRANSACTION_CURRENCY, \r\n" + 
			"    B.NTRY_ENTRY_REFERENCE, \r\n" + 
			"    B.NTRY_CREDIT_DEBIT_INDICATOR, \r\n" + 
			"    B.NTRY_TRANSACTION_AMOUNT,\r\n" + 
			"    B.NTRY_REFS_TRANSACTION_ID \r\n" + 
			"FROM brecon_source_table A \r\n" + 
			"JOIN brecon_destination_table B \r\n" + 
			"    ON A.TRAN_RMKS = B.NTRY_REFS_CLEARING_SYSTEM_REFERENCE \r\n" + 
			"    AND A.TRAN_AMT = B.NTRY_TRANSACTION_AMOUNT \r\n" + 
			"WHERE A.RECON_FLAG = 'N' \r\n" + 
			"    AND B.RECON_FLAG = 'N'", nativeQuery = true)
	List<Object> getDestinationvaluesdatavalue();

	@Query(value = "select * from BRECON_COMMON_TABLE where  RECON_FLAG = 'Y' and report_date = ?1 ORDER BY PART_TRAN_SRL_NUM", nativeQuery = true)
	List<BRECON_Common_Table_Entity> getcommondatavalues(Date report_date);
	
	@Query(value = "select NVL(to_char(sum(tran_amt)),0) from brecon_common_table where report_date = ?1 and part_tran_type = 'D' AND RECON_FLAG = 'Y'", nativeQuery = true)
	String getdebitamount(Date report_date);
	
	@Query(value = "select NVL(to_char(count(*)),0) from brecon_common_table where report_date = ?1 and part_tran_type = 'D' AND RECON_FLAG = 'Y'", nativeQuery = true)
	String getdebitentries(Date report_date);
	
	@Query(value = "select NVL(to_char(sum(tran_amt)),0) from brecon_common_table where report_date = ?1 and part_tran_type = 'C' AND RECON_FLAG = 'Y'", nativeQuery = true)
	String getcreditamount(Date report_date);
	
	@Query(value = "select NVL(to_char(count(*)),0) from brecon_common_table where report_date = ?1 and part_tran_type = 'C' AND RECON_FLAG = 'Y'", nativeQuery = true)
	String getcreditentries(Date report_date);
	
}
