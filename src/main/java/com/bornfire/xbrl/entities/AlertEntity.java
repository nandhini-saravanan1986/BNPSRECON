package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ALERT_AND_NOTIFICATION_TABLE")
public class AlertEntity {
	@Id
	private String	report_srl;
	private BigDecimal	report_version;
	private Date	report_version_date;
	private String	report_code;
	private String	report_desc;
	private String	report_category;
	private String	report_frequency;
	private Date	due_date;
	private Date start_date;
	private String	user_id_1;
	private String	user_name_1;
	private String	email_id_1;
	private BigDecimal	mobile_no_1;
	private String	alert_flg_1;
	private String	user_id_2;
	private String	user_name_2;
	private String	email_id_2;
	private BigDecimal	mobile_no_2;
	private String	alert_flg_2;
	private String	user_id_3;
	private String	user_name_3;
	private String	email_id_3;
	private BigDecimal	mobile_no_3;
	private String	alert_flg_3;
	private String	del_flg;
	private String	entity_flg;
	private String	modify_flg;
	private String	entry_user;
	private String	modify_user;
	private String	auth_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	auth_time;
	public String getReport_srl() {
		return report_srl;
	}
	public void setReport_srl(String report_srl) {
		this.report_srl = report_srl;
	}
	public BigDecimal getReport_version() {
		return report_version;
	}
	public void setReport_version(BigDecimal report_version) {
		this.report_version = report_version;
	}
	public Date getReport_version_date() {
		return report_version_date;
	}
	public void setReport_version_date(Date report_version_date) {
		this.report_version_date = report_version_date;
	}
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public String getReport_desc() {
		return report_desc;
	}
	public void setReport_desc(String report_desc) {
		this.report_desc = report_desc;
	}
	public String getReport_category() {
		return report_category;
	}
	public void setReport_category(String report_category) {
		this.report_category = report_category;
	}
	public String getReport_frequency() {
		return report_frequency;
	}
	public void setReport_frequency(String report_frequency) {
		this.report_frequency = report_frequency;
	}
	
	public String getUser_id_1() {
		return user_id_1;
	}
	public void setUser_id_1(String user_id_1) {
		this.user_id_1 = user_id_1;
	}
	public String getUser_name_1() {
		return user_name_1;
	}
	public void setUser_name_1(String user_name_1) {
		this.user_name_1 = user_name_1;
	}
	public String getEmail_id_1() {
		return email_id_1;
	}
	public void setEmail_id_1(String email_id_1) {
		this.email_id_1 = email_id_1;
	}
	public BigDecimal getMobile_no_1() {
		return mobile_no_1;
	}
	public void setMobile_no_1(BigDecimal mobile_no_1) {
		this.mobile_no_1 = mobile_no_1;
	}
	public String getAlert_flg_1() {
		return alert_flg_1;
	}
	public void setAlert_flg_1(String alert_flg_1) {
		this.alert_flg_1 = alert_flg_1;
	}
	public String getUser_id_2() {
		return user_id_2;
	}
	public void setUser_id_2(String user_id_2) {
		this.user_id_2 = user_id_2;
	}
	public String getUser_name_2() {
		return user_name_2;
	}
	public void setUser_name_2(String user_name_2) {
		this.user_name_2 = user_name_2;
	}
	public String getEmail_id_2() {
		return email_id_2;
	}
	public void setEmail_id_2(String email_id_2) {
		this.email_id_2 = email_id_2;
	}
	public BigDecimal getMobile_no_2() {
		return mobile_no_2;
	}
	public void setMobile_no_2(BigDecimal mobile_no_2) {
		this.mobile_no_2 = mobile_no_2;
	}
	public String getAlert_flg_2() {
		return alert_flg_2;
	}
	public void setAlert_flg_2(String alert_flg_2) {
		this.alert_flg_2 = alert_flg_2;
	}
	public String getUser_id_3() {
		return user_id_3;
	}
	public void setUser_id_3(String user_id_3) {
		this.user_id_3 = user_id_3;
	}
	public String getUser_name_3() {
		return user_name_3;
	}
	public void setUser_name_3(String user_name_3) {
		this.user_name_3 = user_name_3;
	}
	public String getEmail_id_3() {
		return email_id_3;
	}
	public void setEmail_id_3(String email_id_3) {
		this.email_id_3 = email_id_3;
	}
	public BigDecimal getMobile_no_3() {
		return mobile_no_3;
	}
	public void setMobile_no_3(BigDecimal mobile_no_3) {
		this.mobile_no_3 = mobile_no_3;
	}
	public String getAlert_flg_3() {
		return alert_flg_3;
	}
	public void setAlert_flg_3(String alert_flg_3) {
		this.alert_flg_3 = alert_flg_3;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getAuth_user() {
		return auth_user;
	}
	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public Date getAuth_time() {
		return auth_time;
	}
	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}
	public AlertEntity(String report_srl, BigDecimal report_version, Date report_version_date, String report_code,
			String report_desc, String report_category, String report_frequency,
			String user_id_1, String user_name_1, String email_id_1, BigDecimal mobile_no_1, String alert_flg_1,
			String user_id_2, String user_name_2, String email_id_2, BigDecimal mobile_no_2, String alert_flg_2,
			String user_id_3, String user_name_3, String email_id_3, BigDecimal mobile_no_3, String alert_flg_3,
			String del_flg, String entity_flg, String modify_flg, String entry_user, String modify_user,
			String auth_user, Date entry_time, Date modify_time, Date auth_time) {
		super();
		this.report_srl = report_srl;
		this.report_version = report_version;
		this.report_version_date = report_version_date;
		this.report_code = report_code;
		this.report_desc = report_desc;
		this.report_category = report_category;
		this.report_frequency = report_frequency;
		
		this.user_id_1 = user_id_1;
		this.user_name_1 = user_name_1;
		this.email_id_1 = email_id_1;
		this.mobile_no_1 = mobile_no_1;
		this.alert_flg_1 = alert_flg_1;
		this.user_id_2 = user_id_2;
		this.user_name_2 = user_name_2;
		this.email_id_2 = email_id_2;
		this.mobile_no_2 = mobile_no_2;
		this.alert_flg_2 = alert_flg_2;
		this.user_id_3 = user_id_3;
		this.user_name_3 = user_name_3;
		this.email_id_3 = email_id_3;
		this.mobile_no_3 = mobile_no_3;
		this.alert_flg_3 = alert_flg_3;
		this.del_flg = del_flg;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.auth_user = auth_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.auth_time = auth_time;
	}
	public AlertEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AlertEntity [report_srl=" + report_srl + ", report_version=" + report_version + ", report_version_date="
				+ report_version_date + ", report_code=" + report_code + ", report_desc=" + report_desc
				+ ", report_category=" + report_category + ", report_frequency=" + report_frequency
				 + ", user_id_1=" + user_id_1 + ", user_name_1="
				+ user_name_1 + ", email_id_1=" + email_id_1 + ", mobile_no_1=" + mobile_no_1 + ", alert_flg_1="
				+ alert_flg_1 + ", user_id_2=" + user_id_2 + ", user_name_2=" + user_name_2 + ", email_id_2="
				+ email_id_2 + ", mobile_no_2=" + mobile_no_2 + ", alert_flg_2=" + alert_flg_2 + ", user_id_3="
				+ user_id_3 + ", user_name_3=" + user_name_3 + ", email_id_3=" + email_id_3 + ", mobile_no_3="
				+ mobile_no_3 + ", alert_flg_3=" + alert_flg_3 + ", del_flg=" + del_flg + ", entity_flg=" + entity_flg
				+ ", modify_flg=" + modify_flg + ", entry_user=" + entry_user + ", modify_user=" + modify_user
				+ ", auth_user=" + auth_user + ", entry_time=" + entry_time + ", modify_time=" + modify_time
				+ ", auth_time=" + auth_time + "]";
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	

}
