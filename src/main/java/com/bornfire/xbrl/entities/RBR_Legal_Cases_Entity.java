package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "legal_cases")
public class RBR_Legal_Cases_Entity {
	private String operation;
	private String bank_code;
	@Id
	private String cin;
	private BigDecimal csno;
	private BigDecimal legal_case_rec_id;
	private String legal_case_status;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_legal_case;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_final_judgement;
	private String borrower_status;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date skipped_date;
	private String country_skipped_to;
	private String related_reference_ccsys;
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

	public String getBank_code() {
		return bank_code;
	}

	public String getCin() {
		return cin;
	}

	public BigDecimal getCsno() {
		return csno;
	}

	public BigDecimal getLegal_case_rec_id() {
		return legal_case_rec_id;
	}

	public String getLegal_case_status() {
		return legal_case_status;
	}

	public Date getDate_legal_case() {
		return date_legal_case;
	}

	public Date getDate_final_judgement() {
		return date_final_judgement;
	}

	public String getBorrower_status() {
		return borrower_status;
	}

	public Date getSkipped_date() {
		return skipped_date;
	}

	public String getCountry_skipped_to() {
		return country_skipped_to;
	}

	public String getRelated_reference_ccsys() {
		return related_reference_ccsys;
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

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public void setCsno(BigDecimal csno) {
		this.csno = csno;
	}

	public void setLegal_case_rec_id(BigDecimal legal_case_rec_id) {
		this.legal_case_rec_id = legal_case_rec_id;
	}

	public void setLegal_case_status(String legal_case_status) {
		this.legal_case_status = legal_case_status;
	}

	public void setDate_legal_case(Date date_legal_case) {
		this.date_legal_case = date_legal_case;
	}

	public void setDate_final_judgement(Date date_final_judgement) {
		this.date_final_judgement = date_final_judgement;
	}

	public void setBorrower_status(String borrower_status) {
		this.borrower_status = borrower_status;
	}

	public void setSkipped_date(Date skipped_date) {
		this.skipped_date = skipped_date;
	}

	public void setCountry_skipped_to(String country_skipped_to) {
		this.country_skipped_to = country_skipped_to;
	}

	public void setRelated_reference_ccsys(String related_reference_ccsys) {
		this.related_reference_ccsys = related_reference_ccsys;
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

	public RBR_Legal_Cases_Entity(String operation, String bank_code, String cin, BigDecimal csno,
			BigDecimal legal_case_rec_id, String legal_case_status, Date date_legal_case, Date date_final_judgement,
			String borrower_status, Date skipped_date, String country_skipped_to, String related_reference_ccsys,
			String reserve_line_1, String reserve_line_2, String reserve_line_3, String reserve_line_4,
			String reserve_line_5, Date report_date, String entry_user, Date entry_time, String auth_user,
			Date auth_time, String modify_user, Date modify_time, String entity_flg, String auth_flg, String modify_flg,
			String del_flg, String branch_code) {
		super();
		this.operation = operation;
		this.bank_code = bank_code;
		this.cin = cin;
		this.csno = csno;
		this.legal_case_rec_id = legal_case_rec_id;
		this.legal_case_status = legal_case_status;
		this.date_legal_case = date_legal_case;
		this.date_final_judgement = date_final_judgement;
		this.borrower_status = borrower_status;
		this.skipped_date = skipped_date;
		this.country_skipped_to = country_skipped_to;
		this.related_reference_ccsys = related_reference_ccsys;
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

	public RBR_Legal_Cases_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
