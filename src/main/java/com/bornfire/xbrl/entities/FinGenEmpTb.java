package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="GET")
public class FinGenEmpTb {

	@Id
	private String	emp_id;
	private String	entity_cre_flg;
	private String	del_flg;
	private String	emp_intls;
	private String	sol_id;
	private String	emp_name;
	private String	emp_short_name;
	private BigDecimal	emp_sign_power_num;
	private BigDecimal	emp_sign_power_amt;
	private String	emp_desig;
	private String	emp_stat;
	private BigDecimal	tot_mod_times;
	private String	lchg_user_id;
	private Date	lchg_time;
	private String	rcre_user_id;
	private Date	rcre_time;
	private String	is_head_teller;
	private BigDecimal	ts_cnt;
	private String	emp_email_id;
	@Transient
	private String	alt1_emp_name;
	@Transient
	private String	alt1_emp_short_name;
	
	
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEntity_cre_flg() {
		return entity_cre_flg;
	}
	public void setEntity_cre_flg(String entity_cre_flg) {
		this.entity_cre_flg = entity_cre_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getEmp_intls() {
		return emp_intls;
	}
	public void setEmp_intls(String emp_intls) {
		this.emp_intls = emp_intls;
	}
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_short_name() {
		return emp_short_name;
	}
	public void setEmp_short_name(String emp_short_name) {
		this.emp_short_name = emp_short_name;
	}
	public BigDecimal getEmp_sign_power_num() {
		return emp_sign_power_num;
	}
	public void setEmp_sign_power_num(BigDecimal emp_sign_power_num) {
		this.emp_sign_power_num = emp_sign_power_num;
	}
	public BigDecimal getEmp_sign_power_amt() {
		return emp_sign_power_amt;
	}
	public void setEmp_sign_power_amt(BigDecimal emp_sign_power_amt) {
		this.emp_sign_power_amt = emp_sign_power_amt;
	}
	public String getEmp_desig() {
		return emp_desig;
	}
	public void setEmp_desig(String emp_desig) {
		this.emp_desig = emp_desig;
	}
	public String getEmp_stat() {
		return emp_stat;
	}
	public void setEmp_stat(String emp_stat) {
		this.emp_stat = emp_stat;
	}
	public BigDecimal getTot_mod_times() {
		return tot_mod_times;
	}
	public void setTot_mod_times(BigDecimal tot_mod_times) {
		this.tot_mod_times = tot_mod_times;
	}
	public String getLchg_user_id() {
		return lchg_user_id;
	}
	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}
	public Date getLchg_time() {
		return lchg_time;
	}
	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}
	public String getRcre_user_id() {
		return rcre_user_id;
	}
	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}
	public Date getRcre_time() {
		return rcre_time;
	}
	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}
	public String getIs_head_teller() {
		return is_head_teller;
	}
	public void setIs_head_teller(String is_head_teller) {
		this.is_head_teller = is_head_teller;
	}
	public BigDecimal getTs_cnt() {
		return ts_cnt;
	}
	public void setTs_cnt(BigDecimal ts_cnt) {
		this.ts_cnt = ts_cnt;
	}
	public String getEmp_email_id() {
		return emp_email_id;
	}
	public void setEmp_email_id(String emp_email_id) {
		this.emp_email_id = emp_email_id;
	}
	public String getAlt1_emp_name() {
		return alt1_emp_name;
	}
	public void setAlt1_emp_name(String alt1_emp_name) {
		this.alt1_emp_name = alt1_emp_name;
	}
	public String getAlt1_emp_short_name() {
		return alt1_emp_short_name;
	}
	public void setAlt1_emp_short_name(String alt1_emp_short_name) {
		this.alt1_emp_short_name = alt1_emp_short_name;
	}
	

	
	
}
