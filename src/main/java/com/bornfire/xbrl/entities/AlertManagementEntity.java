package com.bornfire.xbrl.entities;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "BRBS_ALERT_MGMT_TABLE")
public class AlertManagementEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String	srl_no;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date	alert_date;
	private String	alert_code;
	private String	alert_desc;
	private String	param_1;
	private String	param_2;
	private String	param_3;
	private BigDecimal	param_value_1;
	private BigDecimal	param_value_2;
	private BigDecimal	param_value_3;
	private String	email_flg;
	private String	email_1;
	private String	email_2;
	private String	email_3;
	private String	email_user_1;
	private String	email_user_2;
	private String	email_user_3;
	private String	sms_flg;
	private BigDecimal	mobile_1;
	private BigDecimal	mobile_2;
	private BigDecimal	mobile_3;
	private String	mobile_user_1;
	private String	mobile_user_2;
	private String	mobile_user_3;
	private String	alert_flg;
	private String	alert_userid_1;
	private String	alert_userid_2;
	private String	alert_userid_3;
	private String	alert_user_1;
	private String	alert_user_2;
	private String	alert_user_3;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	start_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date	end_date;
	private String	suspend_flg;
	private String	remarks;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date	suspend_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date	activate_date;
	private String	entity_flg;
	private String	del_flg;
	private String	mod_flg;
	private String	entry_user;
	private String	modify_user;
	private String	auth_user;
	private Date	entry_time;
	private Date	modify_time;
	public String getSrl_no() {
		return srl_no;
	}
	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}
	public Date getAlert_date() {
		return alert_date;
	}
	public void setAlert_date(Date alert_date) {
		this.alert_date = alert_date;
	}
	public String getAlert_code() {
		return alert_code;
	}
	public void setAlert_code(String alert_code) {
		this.alert_code = alert_code;
	}
	public String getAlert_desc() {
		return alert_desc;
	}
	public void setAlert_desc(String alert_desc) {
		this.alert_desc = alert_desc;
	}
	public String getParam_1() {
		return param_1;
	}
	public void setParam_1(String param_1) {
		this.param_1 = param_1;
	}
	public String getParam_2() {
		return param_2;
	}
	public void setParam_2(String param_2) {
		this.param_2 = param_2;
	}
	public String getParam_3() {
		return param_3;
	}
	public void setParam_3(String param_3) {
		this.param_3 = param_3;
	}
	public BigDecimal getParam_value_1() {
		return param_value_1;
	}
	public void setParam_value_1(BigDecimal param_value_1) {
		this.param_value_1 = param_value_1;
	}
	public BigDecimal getParam_value_2() {
		return param_value_2;
	}
	public void setParam_value_2(BigDecimal param_value_2) {
		this.param_value_2 = param_value_2;
	}
	public BigDecimal getParam_value_3() {
		return param_value_3;
	}
	public void setParam_value_3(BigDecimal param_value_3) {
		this.param_value_3 = param_value_3;
	}
	public String getEmail_flg() {
		return email_flg;
	}
	public void setEmail_flg(String email_flg) {
		this.email_flg = email_flg;
	}
	public String getEmail_1() {
		return email_1;
	}
	public void setEmail_1(String email_1) {
		this.email_1 = email_1;
	}
	public String getEmail_2() {
		return email_2;
	}
	public void setEmail_2(String email_2) {
		this.email_2 = email_2;
	}
	public String getEmail_3() {
		return email_3;
	}
	public void setEmail_3(String email_3) {
		this.email_3 = email_3;
	}
	public String getEmail_user_1() {
		return email_user_1;
	}
	public void setEmail_user_1(String email_user_1) {
		this.email_user_1 = email_user_1;
	}
	public String getEmail_user_2() {
		return email_user_2;
	}
	public void setEmail_user_2(String email_user_2) {
		this.email_user_2 = email_user_2;
	}
	public String getEmail_user_3() {
		return email_user_3;
	}
	public void setEmail_user_3(String email_user_3) {
		this.email_user_3 = email_user_3;
	}
	public String getSms_flg() {
		return sms_flg;
	}
	public void setSms_flg(String sms_flg) {
		this.sms_flg = sms_flg;
	}
	public BigDecimal getMobile_1() {
		return mobile_1;
	}
	public void setMobile_1(BigDecimal mobile_1) {
		this.mobile_1 = mobile_1;
	}
	public BigDecimal getMobile_2() {
		return mobile_2;
	}
	public void setMobile_2(BigDecimal mobile_2) {
		this.mobile_2 = mobile_2;
	}
	public BigDecimal getMobile_3() {
		return mobile_3;
	}
	public void setMobile_3(BigDecimal mobile_3) {
		this.mobile_3 = mobile_3;
	}
	public String getMobile_user_1() {
		return mobile_user_1;
	}
	public void setMobile_user_1(String mobile_user_1) {
		this.mobile_user_1 = mobile_user_1;
	}
	public String getMobile_user_2() {
		return mobile_user_2;
	}
	public void setMobile_user_2(String mobile_user_2) {
		this.mobile_user_2 = mobile_user_2;
	}
	public String getMobile_user_3() {
		return mobile_user_3;
	}
	public void setMobile_user_3(String mobile_user_3) {
		this.mobile_user_3 = mobile_user_3;
	}
	public String getAlert_flg() {
		return alert_flg;
	}
	public void setAlert_flg(String alert_flg) {
		this.alert_flg = alert_flg;
	}
	public String getAlert_userid_1() {
		return alert_userid_1;
	}
	public void setAlert_userid_1(String alert_userid_1) {
		this.alert_userid_1 = alert_userid_1;
	}
	public String getAlert_userid_2() {
		return alert_userid_2;
	}
	public void setAlert_userid_2(String alert_userid_2) {
		this.alert_userid_2 = alert_userid_2;
	}
	public String getAlert_userid_3() {
		return alert_userid_3;
	}
	public void setAlert_userid_3(String alert_userid_3) {
		this.alert_userid_3 = alert_userid_3;
	}
	public String getAlert_user_1() {
		return alert_user_1;
	}
	public void setAlert_user_1(String alert_user_1) {
		this.alert_user_1 = alert_user_1;
	}
	public String getAlert_user_2() {
		return alert_user_2;
	}
	public void setAlert_user_2(String alert_user_2) {
		this.alert_user_2 = alert_user_2;
	}
	public String getAlert_user_3() {
		return alert_user_3;
	}
	public void setAlert_user_3(String alert_user_3) {
		this.alert_user_3 = alert_user_3;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public String getSuspend_flg() {
		return suspend_flg;
	}
	public void setSuspend_flg(String suspend_flg) {
		this.suspend_flg = suspend_flg;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getSuspend_date() {
		return suspend_date;
	}
	public void setSuspend_date(Date suspend_date) {
		this.suspend_date = suspend_date;
	}
	public Date getActivate_date() {
		return activate_date;
	}
	public void setActivate_date(Date activate_date) {
		this.activate_date = activate_date;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getMod_flg() {
		return mod_flg;
	}
	public void setMod_flg(String mod_flg) {
		this.mod_flg = mod_flg;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
