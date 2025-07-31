package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PARTNER_SHAREHOLDER_DATA")
public class RBRShareHolder_Entity {
	private String operation;
	private String acid;
	private String cust_id;
	private String bankcode;
	@Id
	private String srl_no;
	private String cin;
	private String csno;
	private BigDecimal part_shar_rec_id;
	private String part_shar_type;
	private String p_s_aname;
	private String p_s_ename;
	private String p_s_cin;
	private String p_s_res;
	private BigDecimal p_s_share_percentage;
	private String p_s_legal_status;
	private String p_s_emi_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date p_s_exp_emi_id;
	private String p_s_passport_no;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date p_s_exp_passport;
	private String p_s_nat_code;
	private String p_s_trade_license_no;
	private String p_s_place_of_issuing_tl;
	private String p_s_lei;
	private String p_s_lei_number;
	private String gender;
	private String reserve_line_1;
	private String reserve_line_2;
	private String reserve_line_3;
	private String reserve_line_4;
	private String reserve_line_5;
	private BigDecimal net_worth_p_s;
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

	public String getBankcode() {
		return bankcode;
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

	public BigDecimal getPart_shar_rec_id() {
		return part_shar_rec_id;
	}

	public String getPart_shar_type() {
		return part_shar_type;
	}

	public String getP_s_aname() {
		return p_s_aname;
	}

	public String getP_s_ename() {
		return p_s_ename;
	}

	public String getP_s_cin() {
		return p_s_cin;
	}

	public String getP_s_res() {
		return p_s_res;
	}

	public BigDecimal getP_s_share_percentage() {
		return p_s_share_percentage;
	}

	public String getP_s_legal_status() {
		return p_s_legal_status;
	}

	public String getP_s_emi_id() {
		return p_s_emi_id;
	}

	public Date getP_s_exp_emi_id() {
		return p_s_exp_emi_id;
	}

	public String getP_s_passport_no() {
		return p_s_passport_no;
	}

	public Date getP_s_exp_passport() {
		return p_s_exp_passport;
	}

	public String getP_s_nat_code() {
		return p_s_nat_code;
	}

	public String getP_s_trade_license_no() {
		return p_s_trade_license_no;
	}

	public String getP_s_place_of_issuing_tl() {
		return p_s_place_of_issuing_tl;
	}

	public String getP_s_lei() {
		return p_s_lei;
	}

	public String getP_s_lei_number() {
		return p_s_lei_number;
	}

	public String getGender() {
		return gender;
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

	public BigDecimal getNet_worth_p_s() {
		return net_worth_p_s;
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

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
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

	public void setPart_shar_rec_id(BigDecimal part_shar_rec_id) {
		this.part_shar_rec_id = part_shar_rec_id;
	}

	public void setPart_shar_type(String part_shar_type) {
		this.part_shar_type = part_shar_type;
	}

	public void setP_s_aname(String p_s_aname) {
		this.p_s_aname = p_s_aname;
	}

	public void setP_s_ename(String p_s_ename) {
		this.p_s_ename = p_s_ename;
	}

	public void setP_s_cin(String p_s_cin) {
		this.p_s_cin = p_s_cin;
	}

	public void setP_s_res(String p_s_res) {
		this.p_s_res = p_s_res;
	}

	public void setP_s_share_percentage(BigDecimal p_s_share_percentage) {
		this.p_s_share_percentage = p_s_share_percentage;
	}

	public void setP_s_legal_status(String p_s_legal_status) {
		this.p_s_legal_status = p_s_legal_status;
	}

	public void setP_s_emi_id(String p_s_emi_id) {
		this.p_s_emi_id = p_s_emi_id;
	}

	public void setP_s_exp_emi_id(Date p_s_exp_emi_id) {
		this.p_s_exp_emi_id = p_s_exp_emi_id;
	}

	public void setP_s_passport_no(String p_s_passport_no) {
		this.p_s_passport_no = p_s_passport_no;
	}

	public void setP_s_exp_passport(Date p_s_exp_passport) {
		this.p_s_exp_passport = p_s_exp_passport;
	}

	public void setP_s_nat_code(String p_s_nat_code) {
		this.p_s_nat_code = p_s_nat_code;
	}

	public void setP_s_trade_license_no(String p_s_trade_license_no) {
		this.p_s_trade_license_no = p_s_trade_license_no;
	}

	public void setP_s_place_of_issuing_tl(String p_s_place_of_issuing_tl) {
		this.p_s_place_of_issuing_tl = p_s_place_of_issuing_tl;
	}

	public void setP_s_lei(String p_s_lei) {
		this.p_s_lei = p_s_lei;
	}

	public void setP_s_lei_number(String p_s_lei_number) {
		this.p_s_lei_number = p_s_lei_number;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public void setNet_worth_p_s(BigDecimal net_worth_p_s) {
		this.net_worth_p_s = net_worth_p_s;
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

	public RBRShareHolder_Entity(String operation, String acid, String cust_id, String bankcode, String srl_no,
			String cin, String csno, BigDecimal part_shar_rec_id, String part_shar_type, String p_s_aname,
			String p_s_ename, String p_s_cin, String p_s_res, BigDecimal p_s_share_percentage, String p_s_legal_status,
			String p_s_emi_id, Date p_s_exp_emi_id, String p_s_passport_no, Date p_s_exp_passport, String p_s_nat_code,
			String p_s_trade_license_no, String p_s_place_of_issuing_tl, String p_s_lei, String p_s_lei_number,
			String gender, String reserve_line_1, String reserve_line_2, String reserve_line_3, String reserve_line_4,
			String reserve_line_5, BigDecimal net_worth_p_s, Date report_date, String entry_user, Date entry_time,
			String auth_user, Date auth_time, String modify_user, Date modify_time, String entity_flg, String auth_flg,
			String modify_flg, String del_flg, String branch_code) {
		super();
		this.operation = operation;
		this.acid = acid;
		this.cust_id = cust_id;
		this.bankcode = bankcode;
		this.srl_no = srl_no;
		this.cin = cin;
		this.csno = csno;
		this.part_shar_rec_id = part_shar_rec_id;
		this.part_shar_type = part_shar_type;
		this.p_s_aname = p_s_aname;
		this.p_s_ename = p_s_ename;
		this.p_s_cin = p_s_cin;
		this.p_s_res = p_s_res;
		this.p_s_share_percentage = p_s_share_percentage;
		this.p_s_legal_status = p_s_legal_status;
		this.p_s_emi_id = p_s_emi_id;
		this.p_s_exp_emi_id = p_s_exp_emi_id;
		this.p_s_passport_no = p_s_passport_no;
		this.p_s_exp_passport = p_s_exp_passport;
		this.p_s_nat_code = p_s_nat_code;
		this.p_s_trade_license_no = p_s_trade_license_no;
		this.p_s_place_of_issuing_tl = p_s_place_of_issuing_tl;
		this.p_s_lei = p_s_lei;
		this.p_s_lei_number = p_s_lei_number;
		this.gender = gender;
		this.reserve_line_1 = reserve_line_1;
		this.reserve_line_2 = reserve_line_2;
		this.reserve_line_3 = reserve_line_3;
		this.reserve_line_4 = reserve_line_4;
		this.reserve_line_5 = reserve_line_5;
		this.net_worth_p_s = net_worth_p_s;
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

	public RBRShareHolder_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
