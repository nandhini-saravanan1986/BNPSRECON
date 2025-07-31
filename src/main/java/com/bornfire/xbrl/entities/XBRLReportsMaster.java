package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "XBRL_REPORT_MASTER_TB")
public class XBRLReportsMaster {

	@Id
	@Column(name="report_id")
	private String reportid;
	private String report_name;
	private String report_frequency;
	private String xbrl_taxonomy_version;
	private String institution_code;
	private String institution_name;
	private String institution_category;
	private String tool_name;
	private String tool_version;
	private String report_validity;
	private String archive_enable_flg;
	private String sub_report_flg;
	private String domain_id;
	private String	rcre_user_id;
	private Date	rcre_time;
	private String	lchg_user_id;
	private Date	lchg_time;
	private String	verify_user_id;
	private Date	verify_time;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	taxonomy_version_date;

	public String getReportid() {
		return reportid;
	}
	public void setReportid(String reportid) {
		this.reportid = reportid;
	}
	public String getReport_name() {
		return report_name;
	}
	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}
	public String getReport_frequency() {
		return report_frequency;
	}
	public void setReport_frequency(String report_frequency) {
		this.report_frequency = report_frequency;
	}
	public String getXbrl_taxonomy_version() {
		return xbrl_taxonomy_version;
	}
	public void setXbrl_taxonomy_version(String xbrl_taxonomy_version) {
		this.xbrl_taxonomy_version = xbrl_taxonomy_version;
	}
	public String getInstitution_code() {
		return institution_code;
	}
	public void setInstitution_code(String institution_code) {
		this.institution_code = institution_code;
	}
	public String getInstitution_name() {
		return institution_name;
	}
	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}
	public String getInstitution_category() {
		return institution_category;
	}
	public void setInstitution_category(String institution_category) {
		this.institution_category = institution_category;
	}
	public String getTool_name() {
		return tool_name;
	}
	public void setTool_name(String tool_name) {
		this.tool_name = tool_name;
	}
	public String getTool_version() {
		return tool_version;
	}
	public void setTool_version(String tool_version) {
		this.tool_version = tool_version;
	}
	public String getReport_validity() {
		return report_validity;
	}
	public void setReport_validity(String report_validity) {
		this.report_validity = report_validity;
	}
	public String getArchive_enable_flg() {
		return archive_enable_flg;
	}
	public void setArchive_enable_flg(String archive_enable_flg) {
		this.archive_enable_flg = archive_enable_flg;
	}
	public String getSub_report_flg() {
		return sub_report_flg;
	}
	public void setSub_report_flg(String sub_report_flg) {
		this.sub_report_flg = sub_report_flg;
	}
	public String getDomain_id() {
		return domain_id;
	}
	public void setDomain_id(String domain_id) {
		this.domain_id = domain_id;
	}
	public String getRcre_user_id() {
		return rcre_user_id;
	}
	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}
	public Date getRcre_time() {
		return rcre_time;
	}
	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}
	public String getLchg_user_id() {
		return lchg_user_id;
	}
	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}
	public Date getLchg_time() {
		return lchg_time;
	}
	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}
	public String getVerify_user_id() {
		return verify_user_id;
	}
	public void setVerify_user_id(String verify_user_id) {
		this.verify_user_id = verify_user_id;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public Date getTaxonomy_version_date() {
		return taxonomy_version_date;
	}
	public void setTaxonomy_version_date(Date taxonomy_version_date) {
		this.taxonomy_version_date = taxonomy_version_date;
	}

	
}
