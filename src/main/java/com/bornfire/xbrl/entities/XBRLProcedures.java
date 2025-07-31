package com.bornfire.xbrl.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQueries
		({ 
			@NamedStoredProcedureQuery 
			(name = "ReportSaveSp", procedureName = "FINAL_REPORT_UPDATE_SP", 
				parameters = {	@StoredProcedureParameter(mode = ParameterMode.IN, name = "REPORT_ID", type = String.class),
								@StoredProcedureParameter(mode = ParameterMode.IN, name = "REF_NO", type = String.class),
								@StoredProcedureParameter(mode = ParameterMode.IN, name = "REPORT_DATE", type = String.class),
								@StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_FROM_DATE", type = String.class),
								@StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_TO_DATE", type = String.class),
								@StoredProcedureParameter(mode = ParameterMode.IN, name = "CURRENCY", type = String.class),
							 }
			),
			@NamedStoredProcedureQuery
			(name = "MIS_BAL_POP_SP", procedureName = "MIS_BAL_POP_SP", 
			parameters = {	@StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_REPORT_DATE", type = String.class),
							
						 }
		),
			@NamedStoredProcedureQuery
			(name = "MIS_RFND_POP_SP", procedureName = "MIS_RFND_POP_SP", 
			parameters = {	@StoredProcedureParameter(mode = ParameterMode.IN, name = "IN_REPORT_DATE", type = String.class),
							
						 }
		),
			@NamedStoredProcedureQuery
			(name = "COMMON_ETL_PROCESS_SP", procedureName = "COMMON_ETL_PROCESS_SP", 
			parameters = {	@StoredProcedureParameter(mode = ParameterMode.IN, name = "RUNDATE", type = String.class),
							
						 }
		)
		})
public class XBRLProcedures {
	
	@Id
	private String procedureName;

	public String getProcedureName() {
		return procedureName;
	}

	public void setProcedureName(String procedureName) {
		this.procedureName = procedureName;
	}
	
	

}
