package com.bornfire.xbrl.entities;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface XBRLProceduresRep extends CrudRepository<XBRLProcedures,String>{
	
	@Procedure(name = "ReportSaveSp", procedureName = "FINAL_REPORT_UPDATE_SP")
	public void ReportSaveSp(@Param("REPORT_ID")String reportid,
					@Param("REF_NO")String refno,
					@Param("REPORT_DATE")String reportdate,
					@Param("IN_FROM_DATE")String fromdate,
					@Param("IN_TO_DATE")String todate,
					@Param("CURRENCY")String currency);
	
	@Procedure(name = "MIS_BAL_POP_SP", procedureName = "MIS_BAL_POP_SP")
	public void misBalPopSp(@Param("IN_REPORT_DATE")String reportdate);
	
	@Procedure(name = "MIS_RFND_POP_SP", procedureName = "MIS_RFND_POP_SP")
	public void misRfndPopSp(@Param("IN_REPORT_DATE")String reportdate);
	
	
	@Procedure(name = "COMMON_ETL_PROCESS_SP", procedureName = "COMMON_ETL_PROCESS_SP")
	public void etlProcess(@Param("RUNDATE")String reportdate);

}
