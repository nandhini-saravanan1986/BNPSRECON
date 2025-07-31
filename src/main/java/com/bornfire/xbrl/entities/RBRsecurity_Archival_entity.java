package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ARCHIVAL_SECURITY_DATA")
public class RBRsecurity_Archival_entity {
	private String operation;
	private String acid;
	private String cust_id;
	@Id
	private String srl_no;
	private String bank_code;
	private String cin;
	private String csno;
	private String fac_id;
	private String security_rec_id;
	private String security_type;
	private BigDecimal mv;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date valdate;
	private BigDecimal dis_val_col;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date exp_date;
	private String namea_guarantor;
	private String namee_guarantor;
	private BigDecimal per_exp_secured_guarantor;
	private String id_type;
	private String id_value;
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

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
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

	public String getCsno() {
		return csno;
	}

	public void setCsno(String csno) {
		this.csno = csno;
	}

	public String getFac_id() {
		return fac_id;
	}

	public void setFac_id(String fac_id) {
		this.fac_id = fac_id;
	}

	public String getSecurity_rec_id() {
		return security_rec_id;
	}

	public void setSecurity_rec_id(String security_rec_id) {
		this.security_rec_id = security_rec_id;
	}

	public String getSecurity_type() {
		return security_type;
	}

	public void setSecurity_type(String security_type) {
		this.security_type = security_type;
	}

	public BigDecimal getMv() {
		return mv;
	}

	public void setMv(BigDecimal mv) {
		this.mv = mv;
	}

	public Date getValdate() {
		return valdate;
	}

	public void setValdate(Date valdate) {
		this.valdate = valdate;
	}

	public BigDecimal getDis_val_col() {
		return dis_val_col;
	}

	public void setDis_val_col(BigDecimal dis_val_col) {
		this.dis_val_col = dis_val_col;
	}

	public Date getExp_date() {
		return exp_date;
	}

	public void setExp_date(Date exp_date) {
		this.exp_date = exp_date;
	}

	public String getNamea_guarantor() {
		return namea_guarantor;
	}

	public void setNamea_guarantor(String namea_guarantor) {
		this.namea_guarantor = namea_guarantor;
	}

	public String getNamee_guarantor() {
		return namee_guarantor;
	}

	public void setNamee_guarantor(String namee_guarantor) {
		this.namee_guarantor = namee_guarantor;
	}

	public BigDecimal getPer_exp_secured_guarantor() {
		return per_exp_secured_guarantor;
	}

	public void setPer_exp_secured_guarantor(BigDecimal per_exp_secured_guarantor) {
		this.per_exp_secured_guarantor = per_exp_secured_guarantor;
	}

	public String getId_type() {
		return id_type;
	}

	public void setId_type(String id_type) {
		this.id_type = id_type;
	}

	public String getId_value() {
		return id_value;
	}

	public void setId_value(String id_value) {
		this.id_value = id_value;
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

	public String getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public RBRsecurity_Archival_entity(String operation, String acid, String cust_id, String srl_no, String bank_code,
			String cin, String csno, String fac_id, String security_rec_id, String security_type, BigDecimal mv,
			Date valdate, BigDecimal dis_val_col, Date exp_date, String namea_guarantor, String namee_guarantor,
			BigDecimal per_exp_secured_guarantor, String id_type, String id_value, String reserve_line_1,
			String reserve_line_2, String reserve_line_3, String reserve_line_4, String reserve_line_5,
			Date report_date, String entry_user, Date entry_time, String auth_user, Date auth_time, String modify_user,
			Date modify_time, String entity_flg, String auth_flg, String modify_flg, String del_flg,
			String branch_code) {
		super();
		this.operation = operation;
		this.acid = acid;
		this.cust_id = cust_id;
		this.srl_no = srl_no;
		this.bank_code = bank_code;
		this.cin = cin;
		this.csno = csno;
		this.fac_id = fac_id;
		this.security_rec_id = security_rec_id;
		this.security_type = security_type;
		this.mv = mv;
		this.valdate = valdate;
		this.dis_val_col = dis_val_col;
		this.exp_date = exp_date;
		this.namea_guarantor = namea_guarantor;
		this.namee_guarantor = namee_guarantor;
		this.per_exp_secured_guarantor = per_exp_secured_guarantor;
		this.id_type = id_type;
		this.id_value = id_value;
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

	public RBRsecurity_Archival_entity(Security_Entity cud) {
		this.operation = cud.getOperation();
		this.acid = cud.getAcid();
		this.cust_id = cud.getCust_id();
		this.srl_no = cud.getSrl_no();
		this.bank_code = cud.getBank_code();
		this.cin = cud.getCin();
		this.csno = cud.getCsno();
		this.fac_id = cud.getFac_id();
		this.security_rec_id = cud.getSecurity_rec_id();
		this.security_type = cud.getSecurity_type();
		this.mv = cud.getMv();
		this.valdate = cud.getValdate();
		this.dis_val_col = cud.getDis_val_col();
		this.exp_date = cud.getExp_date();
		this.namea_guarantor = cud.getNamea_guarantor();
		this.namee_guarantor = cud.getNamee_guarantor();
		this.per_exp_secured_guarantor = cud.getPer_exp_secured_guarantor();
		this.id_type = cud.getId_type();
		this.id_value = cud.getId_value();
		this.reserve_line_1 = cud.getReserve_line_1();
		this.reserve_line_2 = cud.getReserve_line_2();
		this.reserve_line_3 = cud.getReserve_line_3();
		this.reserve_line_4 = cud.getReserve_line_4();
		this.reserve_line_5 = cud.getReserve_line_5();
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
		this.branch_code = cud.getBranch_code();
	}

	public RBRsecurity_Archival_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
