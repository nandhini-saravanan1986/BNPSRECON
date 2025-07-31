package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public interface Brecon_core_rep extends JpaRepository<Brecon_core_entity, String> {

	@Query(value = "SELECT * FROM BRECON_SOURCE_TABLE WHERE RECON_FLAG = 'N'", nativeQuery = true)
	List<Brecon_core_entity> getcoresystemlistdata();

	@Query(value = "select * from BRECON_SOURCE_TABLE where srlno = ?1", nativeQuery = true)
	Brecon_core_entity getSrlno(String srlno);

	@Query(value = "select * from BRECON_SOURCE_TABLE where TRAN_DATE = ?1", nativeQuery = true)
	List<Brecon_core_entity> getcoresystemlistdatavalues(String report_date);

	@Query(value = "select * from BRECON_SOURCE_TABLE where TRAN_RMKS = ?1 and TRAN_AMT = ?2", nativeQuery = true)
	List<Brecon_core_entity> getcoresystemlistdatavalues11(String report_date, String tran_amt);

	@Query(value = "select distinct TRAN_DATE from BRECON_SOURCE_TABLE where TRAN_DATE = ?1", nativeQuery = true)
	String getcoresystemlistdatavalues1(String report_date);

	@Procedure(procedureName = "BRECON_MAPPING_PROCEDURE")
	void executeBreconMappingProcedure(Date reportDate);

	@Query(value = "SELECT COALESCE(MAX(CAST(srlno AS integer)), 0) FROM BRECON_SOURCE_TABLE WHERE REGEXP_LIKE(srlno, '^[0-9]+$')", nativeQuery = true)
	String getMaxSrlNo();

	@Query(value = "select * from BRECON_SOURCE_TABLE where  RECON_FLAG = 'N' and report_date = ?1", nativeQuery = true)
	List<Brecon_core_entity> getcoresystemlistvalue(Date reportDate);
	
	@Query(value = "SELECT * FROM (select distinct report_date,tran_rmks,count(tran_rmks) AS CBSCOUNT from BRECON_SOURCE_TABLE where "
			+ "report_date >= sysdate-7\r\n" + 
			"GROUP BY report_date,tran_rmks) WHERE CBSCOUNT >1", nativeQuery = true)
	List<Object[]> getcbsduplicaterecord();
	
	@Query(value = "select * from BRECON_SOURCE_TABLE where report_date = ?1", nativeQuery = true)
	List<Brecon_core_entity> getcoresystemlisttotvalue(Date reportDate);
}
