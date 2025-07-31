package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="XBRL_AUDIT_TABLE")
public class XBRLAudit {
	
	@Id
	private String	ref_no;
	private String	report_id;
	private String	table_name;
	private String	unique_id;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date	report_date;
	private String	enterer_id;
	@DateTimeFormat(pattern="dd-MM-yyyy HH:mm a")
	@JsonFormat(pattern="dd-MM-yyyy HH:mm a")
	private Date	audit_date;
	private String	modified_fields_data;
	private String	rmks;
	public String getRef_no() {
		return ref_no;
	}
	public void setRef_no(String ref_no) {
		this.ref_no = ref_no;
	}
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getUnique_id() {
		return unique_id;
	}
	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getEnterer_id() {
		return enterer_id;
	}
	public void setEnterer_id(String enterer_id) {
		this.enterer_id = enterer_id;
	}
	public Date getAudit_date() {
		return audit_date;
	}
	public void setAudit_date(Date audit_date) {
		this.audit_date = audit_date;
	}
	public String getModified_fields_data() {
		return modified_fields_data;
	}
	public void setModified_fields_data(String modified_fields_data) {
		this.modified_fields_data = modified_fields_data;
	}
	public String getRmks() {
		return rmks;
	}
	public void setRmks(String rmks) {
		this.rmks = rmks;
	}

	

}
