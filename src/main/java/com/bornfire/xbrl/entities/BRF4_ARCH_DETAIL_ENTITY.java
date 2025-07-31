package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="BRF4_ARCH_DETAIL")
public class BRF4_ARCH_DETAIL_ENTITY {
	
	private String	sol_id;
	private String	acid;
	private String	foracid;
	private String	acct_name;
	@Id
	private String	acct_no;
	private String	nre_flg;
	private String	currency_code;
	private String	del_flg;
	private String	create_user;
	private String	modify_user;
	private String	report_lable;
	private String	report_name;
	private Date	report_date;
	private String	version_control;
	private String	cust_id;
	private String	verify_user;
	private String	entity_flg;
	private String	remarks;
	private BigDecimal	accr_bal;
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	public String getForacid() {
		return foracid;
	}
	public void setForacid(String foracid) {
		this.foracid = foracid;
	}
	public String getAcct_name() {
		return acct_name;
	}
	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}
	public String getAcct_no() {
		return acct_no;
	}
	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}
	public String getNre_flg() {
		return nre_flg;
	}
	public void setNre_flg(String nre_flg) {
		this.nre_flg = nre_flg;
	}
	public String getCurrency_code() {
		return currency_code;
	}
	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public String getReport_lable() {
		return report_lable;
	}
	public void setReport_lable(String report_lable) {
		this.report_lable = report_lable;
	}
	public String getReport_name() {
		return report_name;
	}
	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public String getVersion_control() {
		return version_control;
	}
	public void setVersion_control(String version_control) {
		this.version_control = version_control;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public BigDecimal getAccr_bal() {
		return accr_bal;
	}
	public void setAccr_bal(BigDecimal accr_bal) {
		this.accr_bal = accr_bal;
	}
	public BRF4_ARCH_DETAIL_ENTITY(String sol_id, String acid, String foracid, String acct_name, String acct_no,
			String nre_flg, String currency_code, String del_flg, String create_user, String modify_user,
			String report_lable, String report_name, Date report_date, String version_control, String cust_id,
			String verify_user, String entity_flg, String remarks, BigDecimal accr_bal) {
		super();
		this.sol_id = sol_id;
		this.acid = acid;
		this.foracid = foracid;
		this.acct_name = acct_name;
		this.acct_no = acct_no;
		this.nre_flg = nre_flg;
		this.currency_code = currency_code;
		this.del_flg = del_flg;
		this.create_user = create_user;
		this.modify_user = modify_user;
		this.report_lable = report_lable;
		this.report_name = report_name;
		this.report_date = report_date;
		this.version_control = version_control;
		this.cust_id = cust_id;
		this.verify_user = verify_user;
		this.entity_flg = entity_flg;
		this.remarks = remarks;
		this.accr_bal = accr_bal;
	}
	public BRF4_ARCH_DETAIL_ENTITY() {
		super();
		
	}
	
	


}
