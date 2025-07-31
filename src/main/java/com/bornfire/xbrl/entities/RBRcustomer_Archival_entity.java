package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ARCHIVAL_CUSTOMER_DATA1")
public class RBRcustomer_Archival_entity {
	private String cust_id;
	private String operation;
	private String bank_code;
	private String cin;
	private String branch_code;
	private String csno;
	@Id
	private String srl_no;
	private String cif_no;
	private String remarks;
	private String caname;
	private String cename;
	private String type_code;
	private String sub_bor_type;
	private String cus_res;
	private String borrower_subsidiary;
	private String group_up;
	private String group_ip;
	private String lei;
	private String cus_dom;
	private String eco_sec;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date est_date;
	private String emi_est;
	private String lic_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date exp_lic;
	private String emi_lic;
	private String telephone;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date dob;
	private String eid;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date exp_emi_id;
	private String passport;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date exp_passport;
	private BigDecimal capital_annual_income;
	private BigDecimal turnover_operating_income;
	private String auditor;
	private String employer;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_of_audited_fs;
	private BigDecimal no_of_employees;
	private String gender;
	private String reserve_line_1;
	private String reserve_line_2;
	private String reserve_line_3;
	private String reserve_line_4;
	private String reserve_line_5;
	private String lei_number;
	private String branch;
	private String license_issued_emirate;
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
	private Date acct_opn_date;
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getBranch_code() {
		return branch_code;
	}
	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}
	public String getCsno() {
		return csno;
	}
	public void setCsno(String csno) {
		this.csno = csno;
	}
	public String getSrl_no() {
		return srl_no;
	}
	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}
	public String getCif_no() {
		return cif_no;
	}
	public void setCif_no(String cif_no) {
		this.cif_no = cif_no;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCaname() {
		return caname;
	}
	public void setCaname(String caname) {
		this.caname = caname;
	}
	public String getCename() {
		return cename;
	}
	public void setCename(String cename) {
		this.cename = cename;
	}
	public String getType_code() {
		return type_code;
	}
	public void setType_code(String type_code) {
		this.type_code = type_code;
	}
	public String getSub_bor_type() {
		return sub_bor_type;
	}
	public void setSub_bor_type(String sub_bor_type) {
		this.sub_bor_type = sub_bor_type;
	}
	public String getCus_res() {
		return cus_res;
	}
	public void setCus_res(String cus_res) {
		this.cus_res = cus_res;
	}
	public String getBorrower_subsidiary() {
		return borrower_subsidiary;
	}
	public void setBorrower_subsidiary(String borrower_subsidiary) {
		this.borrower_subsidiary = borrower_subsidiary;
	}
	public String getGroup_up() {
		return group_up;
	}
	public void setGroup_up(String group_up) {
		this.group_up = group_up;
	}
	public String getGroup_ip() {
		return group_ip;
	}
	public void setGroup_ip(String group_ip) {
		this.group_ip = group_ip;
	}
	public String getLei() {
		return lei;
	}
	public void setLei(String lei) {
		this.lei = lei;
	}
	public String getCus_dom() {
		return cus_dom;
	}
	public void setCus_dom(String cus_dom) {
		this.cus_dom = cus_dom;
	}
	public String getEco_sec() {
		return eco_sec;
	}
	public void setEco_sec(String eco_sec) {
		this.eco_sec = eco_sec;
	}
	public Date getEst_date() {
		return est_date;
	}
	public void setEst_date(Date est_date) {
		this.est_date = est_date;
	}
	public String getEmi_est() {
		return emi_est;
	}
	public void setEmi_est(String emi_est) {
		this.emi_est = emi_est;
	}
	public String getLic_id() {
		return lic_id;
	}
	public void setLic_id(String lic_id) {
		this.lic_id = lic_id;
	}
	public Date getExp_lic() {
		return exp_lic;
	}
	public void setExp_lic(Date exp_lic) {
		this.exp_lic = exp_lic;
	}
	public String getEmi_lic() {
		return emi_lic;
	}
	public void setEmi_lic(String emi_lic) {
		this.emi_lic = emi_lic;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public Date getExp_emi_id() {
		return exp_emi_id;
	}
	public void setExp_emi_id(Date exp_emi_id) {
		this.exp_emi_id = exp_emi_id;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public Date getExp_passport() {
		return exp_passport;
	}
	public void setExp_passport(Date exp_passport) {
		this.exp_passport = exp_passport;
	}
	public BigDecimal getCapital_annual_income() {
		return capital_annual_income;
	}
	public void setCapital_annual_income(BigDecimal capital_annual_income) {
		this.capital_annual_income = capital_annual_income;
	}
	public BigDecimal getTurnover_operating_income() {
		return turnover_operating_income;
	}
	public void setTurnover_operating_income(BigDecimal turnover_operating_income) {
		this.turnover_operating_income = turnover_operating_income;
	}
	public String getAuditor() {
		return auditor;
	}
	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public Date getDate_of_audited_fs() {
		return date_of_audited_fs;
	}
	public void setDate_of_audited_fs(Date date_of_audited_fs) {
		this.date_of_audited_fs = date_of_audited_fs;
	}
	public BigDecimal getNo_of_employees() {
		return no_of_employees;
	}
	public void setNo_of_employees(BigDecimal no_of_employees) {
		this.no_of_employees = no_of_employees;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getReserve_line_1() {
		return reserve_line_1;
	}
	public void setReserve_line_1(String reserve_line_1) {
		this.reserve_line_1 = reserve_line_1;
	}
	public String getReserve_line_2() {
		return reserve_line_2;
	}
	public void setReserve_line_2(String reserve_line_2) {
		this.reserve_line_2 = reserve_line_2;
	}
	public String getReserve_line_3() {
		return reserve_line_3;
	}
	public void setReserve_line_3(String reserve_line_3) {
		this.reserve_line_3 = reserve_line_3;
	}
	public String getReserve_line_4() {
		return reserve_line_4;
	}
	public void setReserve_line_4(String reserve_line_4) {
		this.reserve_line_4 = reserve_line_4;
	}
	public String getReserve_line_5() {
		return reserve_line_5;
	}
	public void setReserve_line_5(String reserve_line_5) {
		this.reserve_line_5 = reserve_line_5;
	}
	public String getLei_number() {
		return lei_number;
	}
	public void setLei_number(String lei_number) {
		this.lei_number = lei_number;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getLicense_issued_emirate() {
		return license_issued_emirate;
	}
	public void setLicense_issued_emirate(String license_issued_emirate) {
		this.license_issued_emirate = license_issued_emirate;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
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
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getAuth_flg() {
		return auth_flg;
	}
	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public Date getAcct_opn_date() {
		return acct_opn_date;
	}
	public void setAcct_opn_date(Date acct_opn_date) {
		this.acct_opn_date = acct_opn_date;
	}
	public RBRcustomer_Archival_entity(String cust_id, String operation, String bank_code, String cin,
			String branch_code, String csno, String srl_no, String cif_no, String remarks, String caname, String cename,
			String type_code, String sub_bor_type, String cus_res, String borrower_subsidiary, String group_up,
			String group_ip, String lei, String cus_dom, String eco_sec, Date est_date, String emi_est, String lic_id,
			Date exp_lic, String emi_lic, String telephone, Date dob, String eid, Date exp_emi_id, String passport,
			Date exp_passport, BigDecimal capital_annual_income, BigDecimal turnover_operating_income, String auditor,
			String employer, Date date_of_audited_fs, BigDecimal no_of_employees, String gender, String reserve_line_1,
			String reserve_line_2, String reserve_line_3, String reserve_line_4, String reserve_line_5,
			String lei_number, String branch, String license_issued_emirate, Date report_date, String entry_user,
			Date entry_time, String auth_user, Date auth_time, String modify_user, Date modify_time, String entity_flg,
			String auth_flg, String modify_flg, String del_flg, Date acct_opn_date) {
		super();
		this.cust_id = cust_id;
		this.operation = operation;
		this.bank_code = bank_code;
		this.cin = cin;
		this.branch_code = branch_code;
		this.csno = csno;
		this.srl_no = srl_no;
		this.cif_no = cif_no;
		this.remarks = remarks;
		this.caname = caname;
		this.cename = cename;
		this.type_code = type_code;
		this.sub_bor_type = sub_bor_type;
		this.cus_res = cus_res;
		this.borrower_subsidiary = borrower_subsidiary;
		this.group_up = group_up;
		this.group_ip = group_ip;
		this.lei = lei;
		this.cus_dom = cus_dom;
		this.eco_sec = eco_sec;
		this.est_date = est_date;
		this.emi_est = emi_est;
		this.lic_id = lic_id;
		this.exp_lic = exp_lic;
		this.emi_lic = emi_lic;
		this.telephone = telephone;
		this.dob = dob;
		this.eid = eid;
		this.exp_emi_id = exp_emi_id;
		this.passport = passport;
		this.exp_passport = exp_passport;
		this.capital_annual_income = capital_annual_income;
		this.turnover_operating_income = turnover_operating_income;
		this.auditor = auditor;
		this.employer = employer;
		this.date_of_audited_fs = date_of_audited_fs;
		this.no_of_employees = no_of_employees;
		this.gender = gender;
		this.reserve_line_1 = reserve_line_1;
		this.reserve_line_2 = reserve_line_2;
		this.reserve_line_3 = reserve_line_3;
		this.reserve_line_4 = reserve_line_4;
		this.reserve_line_5 = reserve_line_5;
		this.lei_number = lei_number;
		this.branch = branch;
		this.license_issued_emirate = license_issued_emirate;
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
		this.acct_opn_date = acct_opn_date;
	}
	
	public RBRcustomer_Archival_entity(RBRcustomer_entity cud) {
	    this.cust_id = cud.getCust_id();
	    this.operation = cud.getOperation();
	    this.bank_code = cud.getBank_code();
	    this.cin = cud.getCin();
	    this.branch_code = cud.getBranch_code();
	    this.csno = cud.getCsno();
	    this.srl_no = cud.getSrl_no();
	    this.cif_no = cud.getCif_no();
	    this.remarks = cud.getRemarks();
	    this.caname = cud.getCaname();
	    this.cename = cud.getCename();
	    this.type_code = cud.getType_code();
	    this.sub_bor_type = cud.getSub_bor_type();
	    this.cus_res = cud.getCus_res();
	    this.borrower_subsidiary = cud.getBorrower_subsidiary();
	    this.group_up = cud.getGroup_up();
	    this.group_ip = cud.getGroup_ip();
	    this.lei = cud.getLei();
	    this.cus_dom = cud.getCus_dom();
	    this.eco_sec = cud.getEco_sec();
	    this.est_date = cud.getEst_date();
	    this.emi_est = cud.getEmi_est();
	    this.lic_id = cud.getLic_id();
	    this.exp_lic = cud.getExp_lic();
	    this.emi_lic = cud.getEmi_lic();
	    this.telephone = cud.getTelephone();
	    this.dob = cud.getDob();
	    this.eid = cud.getEid();
	    this.exp_emi_id = cud.getExp_emi_id();
	    this.passport = cud.getPassport();
	    this.exp_passport = cud.getExp_passport();
	    this.capital_annual_income = cud.getCapital_annual_income();
	    this.turnover_operating_income = cud.getTurnover_operating_income();
	    this.auditor = cud.getAuditor();
	    this.employer = cud.getEmployer();
	    this.date_of_audited_fs = cud.getDate_of_audited_fs();
	    this.no_of_employees = cud.getNo_of_employees();
	    this.gender = cud.getGender();
	    this.reserve_line_1 = cud.getReserve_line_1();
	    this.reserve_line_2 = cud.getReserve_line_2();
	    this.reserve_line_3 = cud.getReserve_line_3();
	    this.reserve_line_4 = cud.getReserve_line_4();
	    this.reserve_line_5 = cud.getReserve_line_5();
	    this.lei_number = cud.getLei_number();
	    this.branch = cud.getBranch();
	    this.license_issued_emirate = cud.getLicense_issued_emirate();
	    this.report_date = cud.getReport_date();
	    this.entry_user = cud.getEntry_user();
	    this.entry_time = cud.getEntry_time();
	    this.auth_user = cud.getAuth_user();
	    this.auth_time = cud.getAuth_time();
	    this.modify_user = cud.getModify_user();
	    this.modify_time = cud.getModify_time();
	    this.entity_flg = cud.getEntity_flg();
	    this.auth_flg = cud.getAuth_flg();
	    this.modify_flg = cud.getModify_flg();
	    this.del_flg = cud.getDel_flg();
	    this.acct_opn_date = cud.getAcct_opn_date();
	}

	public RBRcustomer_Archival_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
