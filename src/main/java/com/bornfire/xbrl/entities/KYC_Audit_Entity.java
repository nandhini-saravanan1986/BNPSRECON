package com.bornfire.xbrl.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "KYC_AUDIT_TABLE")
public class KYC_Audit_Entity {
    @Id
    private String audit_ref_no;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date audit_date;

    private String audit_table;
    private String audit_screen;
    private String event_id;
    private String event_name;

    private String modi_details;
    private String entry_user;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date entry_time;

    private String remarks;
    private String auth_user;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date auth_time;

    private String func_code;
    private String change_details;

    // New Columns
    private String report_id;
    private String entry_user_name;
    private String auth_user_name;
	public String getAudit_ref_no() {
		return audit_ref_no;
	}
	public void setAudit_ref_no(String audit_ref_no) {
		this.audit_ref_no = audit_ref_no;
	}
	public Date getAudit_date() {
		return audit_date;
	}
	public void setAudit_date(Date audit_date) {
		this.audit_date = audit_date;
	}
	public String getAudit_table() {
		return audit_table;
	}
	public void setAudit_table(String audit_table) {
		this.audit_table = audit_table;
	}
	public String getAudit_screen() {
		return audit_screen;
	}
	public void setAudit_screen(String audit_screen) {
		this.audit_screen = audit_screen;
	}
	public String getEvent_id() {
		return event_id;
	}
	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getModi_details() {
		return modi_details;
	}
	public void setModi_details(String modi_details) {
		this.modi_details = modi_details;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAuth_user() {
		return auth_user;
	}
	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}
	public Date getAuth_time() {
		return auth_time;
	}
	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}
	public String getFunc_code() {
		return func_code;
	}
	public void setFunc_code(String func_code) {
		this.func_code = func_code;
	}
	public String getChange_details() {
		return change_details;
	}
	public void setChange_details(String change_details) {
		this.change_details = change_details;
	}
	public String getReport_id() {
		return report_id;
	}
	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}
	public String getEntry_user_name() {
		return entry_user_name;
	}
	public void setEntry_user_name(String entry_user_name) {
		this.entry_user_name = entry_user_name;
	}
	public String getAuth_user_name() {
		return auth_user_name;
	}
	public void setAuth_user_name(String auth_user_name) {
		this.auth_user_name = auth_user_name;
	}
	public KYC_Audit_Entity(String audit_ref_no, Date audit_date, String audit_table, String audit_screen,
			String event_id, String event_name, String modi_details, String entry_user, Date entry_time, String remarks,
			String auth_user, Date auth_time, String func_code, String change_details, String report_id,
			String entry_user_name, String auth_user_name) {
		super();
		this.audit_ref_no = audit_ref_no;
		this.audit_date = audit_date;
		this.audit_table = audit_table;
		this.audit_screen = audit_screen;
		this.event_id = event_id;
		this.event_name = event_name;
		this.modi_details = modi_details;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.remarks = remarks;
		this.auth_user = auth_user;
		this.auth_time = auth_time;
		this.func_code = func_code;
		this.change_details = change_details;
		this.report_id = report_id;
		this.entry_user_name = entry_user_name;
		this.auth_user_name = auth_user_name;
	}
	public KYC_Audit_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "KYC_Audit_Entity [audit_ref_no=" + audit_ref_no + ", audit_date=" + audit_date + ", audit_table="
				+ audit_table + ", audit_screen=" + audit_screen + ", event_id=" + event_id + ", event_name="
				+ event_name + ", modi_details=" + modi_details + ", entry_user=" + entry_user + ", entry_time="
				+ entry_time + ", remarks=" + remarks + ", auth_user=" + auth_user + ", auth_time=" + auth_time
				+ ", func_code=" + func_code + ", change_details=" + change_details + ", report_id=" + report_id
				+ ", entry_user_name=" + entry_user_name + ", auth_user_name=" + auth_user_name + "]";
	}
    
    
    
}
