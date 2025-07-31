package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "T1_CUR_PROD_SERVICES_DET_TABLE")
public class T1CurProdDetail {

	@Id
	private String cust_id;
	private String cust_name;
	private String cust_type;
	private String cust_rating;
	private String acct_no;
	private String acct_name;
	private String tran_type;
	private String tran_sub_type;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date tran_date;
	private String tran_id;
	
	private BigDecimal part_tran_id;
	private Character part_tran_type;
	private String tran_crncy;
	private BigDecimal tran_amt;
	private String tran_category;
	private Character qtr_flg;
	private Character entity_flg;
	private Character del_flg;
	private Character modify_flg;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date entry_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date modify_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date verify_date;
	private String entry_user;
	private String modify_user;
	private String verify_user;
	private String report_code;
	private String report_name;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	private Character arch_flg;
	private String cell_mapping;
	private String process_owner;
	private String bank_id;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date cust_rating_date;
	private String tran_particulars;
	private String tran_channel;
	private String cntry_res;
	private String cnty_incorp;
	private String cntry_oper;
	private String aml_code_1;
	private String aml_code_2;
	private String aml_code_3;
	private String aml_code_4;
	private String aml_code_5;
	private String aml_code_6;
	private String aml_code_7;
	private String aml_code_8;
	private String aml_code_9;
	private String aml_code_10;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date relationship_date;
	private String mis_face_to_face;
	private String mis_non_face_to_face;
	private String mis_internal_rating_grade;
	private String mis_internal_rating_scale;

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_type() {
		return cust_type;
	}

	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}

	public String getCust_rating() {
		return cust_rating;
	}

	public void setCust_rating(String cust_rating) {
		this.cust_rating = cust_rating;
	}

	public String getAcct_no() {
		return acct_no;
	}

	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public String getTran_type() {
		return tran_type;
	}

	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}

	public String getTran_sub_type() {
		return tran_sub_type;
	}

	public void setTran_sub_type(String tran_sub_type) {
		this.tran_sub_type = tran_sub_type;
	}

	public Date getTran_date() {
		return tran_date;
	}

	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}

	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}

	public BigDecimal getPart_tran_id() {
		return part_tran_id;
	}

	public void setPart_tran_id(BigDecimal part_tran_id) {
		this.part_tran_id = part_tran_id;
	}

	public Character getPart_tran_type() {
		return part_tran_type;
	}

	public void setPart_tran_type(Character part_tran_type) {
		this.part_tran_type = part_tran_type;
	}

	public String getTran_crncy() {
		return tran_crncy;
	}

	public void setTran_crncy(String tran_crncy) {
		this.tran_crncy = tran_crncy;
	}

	public BigDecimal getTran_amt() {
		return tran_amt;
	}

	public void setTran_amt(BigDecimal tran_amt) {
		this.tran_amt = tran_amt;
	}

	public String getTran_category() {
		return tran_category;
	}

	public void setTran_category(String tran_category) {
		this.tran_category = tran_category;
	}

	public Character getQtr_flg() {
		return qtr_flg;
	}

	public void setQtr_flg(Character qtr_flg) {
		this.qtr_flg = qtr_flg;
	}

	public Character getEntity_flg() {
		return entity_flg;
	}

	public void setEntity_flg(Character entity_flg) {
		this.entity_flg = entity_flg;
	}

	public Character getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(Character del_flg) {
		this.del_flg = del_flg;
	}

	public Character getModify_flg() {
		return modify_flg;
	}

	public void setModify_flg(Character modify_flg) {
		this.modify_flg = modify_flg;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	public Date getModify_date() {
		return modify_date;
	}

	public void setModify_date(Date modify_date) {
		this.modify_date = modify_date;
	}

	public Date getVerify_date() {
		return verify_date;
	}

	public void setVerify_date(Date verify_date) {
		this.verify_date = verify_date;
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

	public String getVerify_user() {
		return verify_user;
	}

	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}

	public String getReport_code() {
		return report_code;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
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

	public Character getArch_flg() {
		return arch_flg;
	}

	public void setArch_flg(Character arch_flg) {
		this.arch_flg = arch_flg;
	}

	public String getCell_mapping() {
		return cell_mapping;
	}

	public void setCell_mapping(String cell_mapping) {
		this.cell_mapping = cell_mapping;
	}

	public String getProcess_owner() {
		return process_owner;
	}

	public void setProcess_owner(String process_owner) {
		this.process_owner = process_owner;
	}

	public String getBank_id() {
		return bank_id;
	}

	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}

	public Date getCust_rating_date() {
		return cust_rating_date;
	}

	public void setCust_rating_date(Date cust_rating_date) {
		this.cust_rating_date = cust_rating_date;
	}

	public String getTran_particulars() {
		return tran_particulars;
	}

	public void setTran_particulars(String tran_particulars) {
		this.tran_particulars = tran_particulars;
	}

	public String getTran_channel() {
		return tran_channel;
	}

	public void setTran_channel(String tran_channel) {
		this.tran_channel = tran_channel;
	}

	public String getCntry_res() {
		return cntry_res;
	}

	public void setCntry_res(String cntry_res) {
		this.cntry_res = cntry_res;
	}

	public String getCnty_incorp() {
		return cnty_incorp;
	}

	public void setCnty_incorp(String cnty_incorp) {
		this.cnty_incorp = cnty_incorp;
	}

	public String getCntry_oper() {
		return cntry_oper;
	}

	public void setCntry_oper(String cntry_oper) {
		this.cntry_oper = cntry_oper;
	}

	public String getAml_code_1() {
		return aml_code_1;
	}

	public void setAml_code_1(String aml_code_1) {
		this.aml_code_1 = aml_code_1;
	}

	public String getAml_code_2() {
		return aml_code_2;
	}

	public void setAml_code_2(String aml_code_2) {
		this.aml_code_2 = aml_code_2;
	}

	public String getAml_code_3() {
		return aml_code_3;
	}

	public void setAml_code_3(String aml_code_3) {
		this.aml_code_3 = aml_code_3;
	}

	public String getAml_code_4() {
		return aml_code_4;
	}

	public void setAml_code_4(String aml_code_4) {
		this.aml_code_4 = aml_code_4;
	}

	public String getAml_code_5() {
		return aml_code_5;
	}

	public void setAml_code_5(String aml_code_5) {
		this.aml_code_5 = aml_code_5;
	}

	public String getAml_code_6() {
		return aml_code_6;
	}

	public void setAml_code_6(String aml_code_6) {
		this.aml_code_6 = aml_code_6;
	}

	public String getAml_code_7() {
		return aml_code_7;
	}

	public void setAml_code_7(String aml_code_7) {
		this.aml_code_7 = aml_code_7;
	}

	public String getAml_code_8() {
		return aml_code_8;
	}

	public void setAml_code_8(String aml_code_8) {
		this.aml_code_8 = aml_code_8;
	}

	public String getAml_code_9() {
		return aml_code_9;
	}

	public void setAml_code_9(String aml_code_9) {
		this.aml_code_9 = aml_code_9;
	}

	public String getAml_code_10() {
		return aml_code_10;
	}

	public void setAml_code_10(String aml_code_10) {
		this.aml_code_10 = aml_code_10;
	}

	public Date getRelationship_date() {
		return relationship_date;
	}

	public void setRelationship_date(Date relationship_date) {
		this.relationship_date = relationship_date;
	}

	public String getMis_face_to_face() {
		return mis_face_to_face;
	}

	public void setMis_face_to_face(String mis_face_to_face) {
		this.mis_face_to_face = mis_face_to_face;
	}

	public String getMis_non_face_to_face() {
		return mis_non_face_to_face;
	}

	public void setMis_non_face_to_face(String mis_non_face_to_face) {
		this.mis_non_face_to_face = mis_non_face_to_face;
	}

	public String getMis_internal_rating_grade() {
		return mis_internal_rating_grade;
	}

	public void setMis_internal_rating_grade(String mis_internal_rating_grade) {
		this.mis_internal_rating_grade = mis_internal_rating_grade;
	}

	public String getMis_internal_rating_scale() {
		return mis_internal_rating_scale;
	}

	public void setMis_internal_rating_scale(String mis_internal_rating_scale) {
		this.mis_internal_rating_scale = mis_internal_rating_scale;
	}

	public T1CurProdDetail(String cust_id, String cust_name, String cust_type, String cust_rating, String acct_no,
			String acct_name, String tran_type, String tran_sub_type, Date tran_date, String tran_id,
			BigDecimal part_tran_id, Character part_tran_type, String tran_crncy, BigDecimal tran_amt,
			String tran_category, Character qtr_flg, Character entity_flg, Character del_flg, Character modify_flg,
			Date entry_date, Date modify_date, Date verify_date, String entry_user, String modify_user,
			String verify_user, String report_code, String report_name, Date report_date, Character arch_flg,
			String cell_mapping, String process_owner, String bank_id, Date cust_rating_date, String tran_particulars,
			String tran_channel, String cntry_res, String cnty_incorp, String cntry_oper, String aml_code_1,
			String aml_code_2, String aml_code_3, String aml_code_4, String aml_code_5, String aml_code_6,
			String aml_code_7, String aml_code_8, String aml_code_9, String aml_code_10, Date relationship_date,
			String mis_face_to_face, String mis_non_face_to_face, String mis_internal_rating_grade,
			String mis_internal_rating_scale) {
		super();
		this.cust_id = cust_id;
		this.cust_name = cust_name;
		this.cust_type = cust_type;
		this.cust_rating = cust_rating;
		this.acct_no = acct_no;
		this.acct_name = acct_name;
		this.tran_type = tran_type;
		this.tran_sub_type = tran_sub_type;
		this.tran_date = tran_date;
		this.tran_id = tran_id;
		this.part_tran_id = part_tran_id;
		this.part_tran_type = part_tran_type;
		this.tran_crncy = tran_crncy;
		this.tran_amt = tran_amt;
		this.tran_category = tran_category;
		this.qtr_flg = qtr_flg;
		this.entity_flg = entity_flg;
		this.del_flg = del_flg;
		this.modify_flg = modify_flg;
		this.entry_date = entry_date;
		this.modify_date = modify_date;
		this.verify_date = verify_date;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.verify_user = verify_user;
		this.report_code = report_code;
		this.report_name = report_name;
		this.report_date = report_date;
		this.arch_flg = arch_flg;
		this.cell_mapping = cell_mapping;
		this.process_owner = process_owner;
		this.bank_id = bank_id;
		this.cust_rating_date = cust_rating_date;
		this.tran_particulars = tran_particulars;
		this.tran_channel = tran_channel;
		this.cntry_res = cntry_res;
		this.cnty_incorp = cnty_incorp;
		this.cntry_oper = cntry_oper;
		this.aml_code_1 = aml_code_1;
		this.aml_code_2 = aml_code_2;
		this.aml_code_3 = aml_code_3;
		this.aml_code_4 = aml_code_4;
		this.aml_code_5 = aml_code_5;
		this.aml_code_6 = aml_code_6;
		this.aml_code_7 = aml_code_7;
		this.aml_code_8 = aml_code_8;
		this.aml_code_9 = aml_code_9;
		this.aml_code_10 = aml_code_10;
		this.relationship_date = relationship_date;
		this.mis_face_to_face = mis_face_to_face;
		this.mis_non_face_to_face = mis_non_face_to_face;
		this.mis_internal_rating_grade = mis_internal_rating_grade;
		this.mis_internal_rating_scale = mis_internal_rating_scale;
	}

	public T1CurProdDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

}
