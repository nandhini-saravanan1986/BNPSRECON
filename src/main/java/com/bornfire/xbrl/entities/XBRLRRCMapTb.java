package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="XBRL_RRC_MAP_TABLE")
public class XBRLRRCMapTb {
	
	private String	entity_flg;
	private String	cust_id;
	@Id
	private String	acct_no;
	private String	sch_type;
	private String	sch_code;
	private String	glsl_code;
	private String	fin_ref_code;
	private String	entry_user;
	private Date	entry_time;
	private String	modify_user;
	private Date	modify_time;
	private String	verify_user;
	private Date	verify_time;
	private String	del_flg;
	private String	modify_flg;
	private String	bls0100_s1;
	private String	bls0100_s2;
	private String	bls0100_s3;
	private String	bls0100_s4;
	private String	bls0110;
	
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getAcct_no() {
		return acct_no;
	}
	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}
	public String getSch_type() {
		return sch_type;
	}
	public void setSch_type(String sch_type) {
		this.sch_type = sch_type;
	}
	public String getSch_code() {
		return sch_code;
	}
	public void setSch_code(String sch_code) {
		this.sch_code = sch_code;
	}
	public String getGlsl_code() {
		return glsl_code;
	}
	public void setGlsl_code(String glsl_code) {
		this.glsl_code = glsl_code;
	}
	public String getFin_ref_code() {
		return fin_ref_code;
	}
	public void setFin_ref_code(String fin_ref_code) {
		this.fin_ref_code = fin_ref_code;
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
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public String getBls0100_s1() {
		return bls0100_s1;
	}
	public void setBls0100_s1(String bls0100_s1) {
		this.bls0100_s1 = bls0100_s1;
	}
	public String getBls0100_s2() {
		return bls0100_s2;
	}
	public void setBls0100_s2(String bls0100_s2) {
		this.bls0100_s2 = bls0100_s2;
	}
	public String getBls0100_s3() {
		return bls0100_s3;
	}
	public void setBls0100_s3(String bls0100_s3) {
		this.bls0100_s3 = bls0100_s3;
	}
	public String getBls0100_s4() {
		return bls0100_s4;
	}
	public void setBls0100_s4(String bls0100_s4) {
		this.bls0100_s4 = bls0100_s4;
	}
	public String getBls0110() {
		return bls0110;
	}
	public void setBls0110(String bls0110) {
		this.bls0110 = bls0110;
	}
	public XBRLRRCMapTb(String cust_id, String acct_no, String sch_type, String sch_code, String glsl_code,
			String bls0100_s1, String bls0100_s2, String bls0100_s3, String bls0100_s4, String bls0110, String modify_user,Date modify_time) {
		super();
		this.cust_id = cust_id;
		this.acct_no = acct_no;
		this.sch_type = sch_type;
		this.sch_code = sch_code;
		this.glsl_code = glsl_code;
		this.bls0100_s1 = bls0100_s1;
		this.bls0100_s2 = bls0100_s2;
		this.bls0100_s3 = bls0100_s3;
		this.bls0100_s4 = bls0100_s4;
		this.bls0110 = bls0110;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
	}
	public XBRLRRCMapTb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public XBRLRRCMapTb(String cust_id, String acct_no, String sch_type, String sch_code,
			String glsl_code, String entry_user, Date entry_time, String modify_user,
			Date modify_time, String bls0100_s1, String bls0100_s2, String bls0100_s3, String bls0100_s4, String bls0110) {
		
		this.cust_id = cust_id;
		this.acct_no = acct_no;
		this.sch_type = sch_type;
		this.sch_code = sch_code;
		this.glsl_code = glsl_code;
		
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		
		this.bls0100_s1 = bls0100_s1;
		this.bls0100_s2 = bls0100_s2;
		this.bls0100_s3 = bls0100_s3;
		this.bls0100_s4 = bls0100_s4;
		this.bls0110 = bls0110;
	}
	
	


	
}
