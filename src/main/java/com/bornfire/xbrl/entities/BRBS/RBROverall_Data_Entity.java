package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "overall_data")
public class RBROverall_Data_Entity {
	private String operation;
	private String acid;
	private String cust_id;
	private String bank_code;
	@Id
	private String srl_no;
	private String cin;
	private String csno;
	private BigDecimal os_funded;
	private BigDecimal app_limit_funded;
	private BigDecimal app_limit_unfunded;
	private BigDecimal os_unfunded_before_ccf;
	private BigDecimal os_unfunded_after_ccf;
	private BigDecimal total_outstanding_fun_unfun_after_cc;
	private BigDecimal val_sec;
	private BigDecimal dis_val_sec;
	private BigDecimal rwa;
	private String remarks;
	private String reserve_line_1;
	private String reserve_line_2;
	private String reserve_line_3;
	private String reserve_line_4;
	private String reserve_line_5;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date report_date;
	private String entry_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date entry_time;
	private String auth_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date auth_time;
	private String modify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date modify_time;
	private String entity_flg;
	private String auth_flg;
	private String modify_flg;
	private String del_flg;
	private String branch_code;

	public String getOperation() {
		return operation;
	}

	public String getAcid() {
		return acid;
	}

	public String getCust_id() {
		return cust_id;
	}

	public String getBank_code() {
		return bank_code;
	}

	public String getSrl_no() {
		return srl_no;
	}

	public String getCin() {
		return cin;
	}

	public String getCsno() {
		return csno;
	}

	public BigDecimal getOs_funded() {
		return os_funded;
	}

	public BigDecimal getApp_limit_funded() {
		return app_limit_funded;
	}

	public BigDecimal getApp_limit_unfunded() {
		return app_limit_unfunded;
	}

	public BigDecimal getOs_unfunded_before_ccf() {
		return os_unfunded_before_ccf;
	}

	public BigDecimal getOs_unfunded_after_ccf() {
		return os_unfunded_after_ccf;
	}

	public BigDecimal getTotal_outstanding_fun_unfun_after_cc() {
		return total_outstanding_fun_unfun_after_cc;
	}

	public BigDecimal getVal_sec() {
		return val_sec;
	}

	public BigDecimal getDis_val_sec() {
		return dis_val_sec;
	}

	public BigDecimal getRwa() {
		return rwa;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getReserve_line_1() {
		return reserve_line_1;
	}

	public String getReserve_line_2() {
		return reserve_line_2;
	}

	public String getReserve_line_3() {
		return reserve_line_3;
	}

	public String getReserve_line_4() {
		return reserve_line_4;
	}

	public String getReserve_line_5() {
		return reserve_line_5;
	}

	public Date getReport_date() {
		return report_date;
	}

	public String getEntry_user() {
		return entry_user;
	}

	public Date getEntry_time() {
		return entry_time;
	}

	public String getAuth_user() {
		return auth_user;
	}

	public Date getAuth_time() {
		return auth_time;
	}

	public String getModify_user() {
		return modify_user;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public String getAuth_flg() {
		return auth_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public String getBranch_code() {
		return branch_code;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public void setCsno(String csno) {
		this.csno = csno;
	}

	public void setOs_funded(BigDecimal os_funded) {
		this.os_funded = os_funded;
	}

	public void setApp_limit_funded(BigDecimal app_limit_funded) {
		this.app_limit_funded = app_limit_funded;
	}

	public void setApp_limit_unfunded(BigDecimal app_limit_unfunded) {
		this.app_limit_unfunded = app_limit_unfunded;
	}

	public void setOs_unfunded_before_ccf(BigDecimal os_unfunded_before_ccf) {
		this.os_unfunded_before_ccf = os_unfunded_before_ccf;
	}

	public void setOs_unfunded_after_ccf(BigDecimal os_unfunded_after_ccf) {
		this.os_unfunded_after_ccf = os_unfunded_after_ccf;
	}

	public void setTotal_outstanding_fun_unfun_after_cc(BigDecimal total_outstanding_fun_unfun_after_cc) {
		this.total_outstanding_fun_unfun_after_cc = total_outstanding_fun_unfun_after_cc;
	}

	public void setVal_sec(BigDecimal val_sec) {
		this.val_sec = val_sec;
	}

	public void setDis_val_sec(BigDecimal dis_val_sec) {
		this.dis_val_sec = dis_val_sec;
	}

	public void setRwa(BigDecimal rwa) {
		this.rwa = rwa;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setReserve_line_1(String reserve_line_1) {
		this.reserve_line_1 = reserve_line_1;
	}

	public void setReserve_line_2(String reserve_line_2) {
		this.reserve_line_2 = reserve_line_2;
	}

	public void setReserve_line_3(String reserve_line_3) {
		this.reserve_line_3 = reserve_line_3;
	}

	public void setReserve_line_4(String reserve_line_4) {
		this.reserve_line_4 = reserve_line_4;
	}

	public void setReserve_line_5(String reserve_line_5) {
		this.reserve_line_5 = reserve_line_5;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}

	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public RBROverall_Data_Entity(String operation, String acid, String cust_id, String bank_code, String srl_no,
			String cin, String csno, BigDecimal os_funded, BigDecimal app_limit_funded, BigDecimal app_limit_unfunded,
			BigDecimal os_unfunded_before_ccf, BigDecimal os_unfunded_after_ccf,
			BigDecimal total_outstanding_fun_unfun_after_cc, BigDecimal val_sec, BigDecimal dis_val_sec, BigDecimal rwa,
			String remarks, String reserve_line_1, String reserve_line_2, String reserve_line_3, String reserve_line_4,
			String reserve_line_5, Date report_date, String entry_user, Date entry_time, String auth_user,
			Date auth_time, String modify_user, Date modify_time, String entity_flg, String auth_flg, String modify_flg,
			String del_flg, String branch_code) {
		super();
		this.operation = operation;
		this.acid = acid;
		this.cust_id = cust_id;
		this.bank_code = bank_code;
		this.srl_no = srl_no;
		this.cin = cin;
		this.csno = csno;
		this.os_funded = os_funded;
		this.app_limit_funded = app_limit_funded;
		this.app_limit_unfunded = app_limit_unfunded;
		this.os_unfunded_before_ccf = os_unfunded_before_ccf;
		this.os_unfunded_after_ccf = os_unfunded_after_ccf;
		this.total_outstanding_fun_unfun_after_cc = total_outstanding_fun_unfun_after_cc;
		this.val_sec = val_sec;
		this.dis_val_sec = dis_val_sec;
		this.rwa = rwa;
		this.remarks = remarks;
		this.reserve_line_1 = reserve_line_1;
		this.reserve_line_2 = reserve_line_2;
		this.reserve_line_3 = reserve_line_3;
		this.reserve_line_4 = reserve_line_4;
		this.reserve_line_5 = reserve_line_5;
		this.report_date = report_date;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.auth_user = auth_user;
		this.auth_time = auth_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.entity_flg = entity_flg;
		this.auth_flg = auth_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.branch_code = branch_code;
	}

	public RBROverall_Data_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
