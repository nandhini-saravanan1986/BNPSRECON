package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="USER_PROFILE")
public class FinUserProfile {
	
	@Id
	@Column(name="user_id")
	private String	userid;
	private String	del_flg;
	private String	user_work_class;
	private String	user_sol_tenor;
	private String	remote_access_flg;
	private Float	user_max_inactive_time;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	user_acct_expy_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	user_pw_expy_date;
	private String	auth_user_id;
	private Float	tot_mod_times;
	private String	user_appl_name;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	user_disabled_from_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	user_disabled_upto_date;
	private String	new_user_flg;
	
	private String	user_temp_work_class;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	user_tmp_wrk_class_eff_upto;
	private String	user_logged_on_flg;
	@DateTimeFormat(pattern = "hh:ss")
	private Date	user_login_time_low;
	@DateTimeFormat(pattern = "hh:ss")
	private Date	user_login_time_high;
	private String	lchg_user_id;
	private Date	lchg_time;
	private String	rcre_user_id;
	private Date	rcre_time;
	private String	app_lang_code;
	private String	default_term_id;
	private String	virtual_flg;
	private String	proxy_post_allwd;
	private Float	ts_cnt;
	private String	role_id;
	private String	entity_cre_flg;
	
	@ManyToOne
	@JoinColumn(name="user_emp_id", referencedColumnName="emp_id")
	private FinGenEmpTb finGenEmpTb;
	
	@ManyToOne
	@JoinColumn(name="sol_id", referencedColumnName="sol_id")
	private FinSolTb finSolTb;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getUser_work_class() {
		return user_work_class;
	}
	public void setUser_work_class(String user_work_class) {
		this.user_work_class = user_work_class;
	}
	
	public String getUser_sol_tenor() {
		return user_sol_tenor;
	}
	public void setUser_sol_tenor(String user_sol_tenor) {
		this.user_sol_tenor = user_sol_tenor;
	}
	public String getRemote_access_flg() {
		return remote_access_flg;
	}
	public void setRemote_access_flg(String remote_access_flg) {
		this.remote_access_flg = remote_access_flg;
	}
	public Float getUser_max_inactive_time() {
		return user_max_inactive_time;
	}
	public void setUser_max_inactive_time(Float user_max_inactive_time) {
		this.user_max_inactive_time = user_max_inactive_time;
	}
	public Date getUser_acct_expy_date() {
		return user_acct_expy_date;
	}
	public void setUser_acct_expy_date(Date user_acct_expy_date) {
		this.user_acct_expy_date = user_acct_expy_date;
	}
	public Date getUser_pw_expy_date() {
		return user_pw_expy_date;
	}
	public void setUser_pw_expy_date(Date user_pw_expy_date) {
		this.user_pw_expy_date = user_pw_expy_date;
	}
	public String getAuth_user_id() {
		return auth_user_id;
	}
	public void setAuth_user_id(String auth_user_id) {
		this.auth_user_id = auth_user_id;
	}
	public Float getTot_mod_times() {
		return tot_mod_times;
	}
	public void setTot_mod_times(Float tot_mod_times) {
		this.tot_mod_times = tot_mod_times;
	}
	public String getUser_appl_name() {
		return user_appl_name;
	}
	public void setUser_appl_name(String user_appl_name) {
		this.user_appl_name = user_appl_name;
	}
	public Date getUser_disabled_from_date() {
		return user_disabled_from_date;
	}
	public void setUser_disabled_from_date(Date user_disabled_from_date) {
		this.user_disabled_from_date = user_disabled_from_date;
	}
	public Date getUser_disabled_upto_date() {
		return user_disabled_upto_date;
	}
	public void setUser_disabled_upto_date(Date user_disabled_upto_date) {
		this.user_disabled_upto_date = user_disabled_upto_date;
	}
	public String getNew_user_flg() {
		return new_user_flg;
	}
	public void setNew_user_flg(String new_user_flg) {
		this.new_user_flg = new_user_flg;
	}
	
	public String getUser_temp_work_class() {
		return user_temp_work_class;
	}
	public void setUser_temp_work_class(String user_temp_work_class) {
		this.user_temp_work_class = user_temp_work_class;
	}
	public Date getUser_tmp_wrk_class_eff_upto() {
		return user_tmp_wrk_class_eff_upto;
	}
	public void setUser_tmp_wrk_class_eff_upto(Date user_tmp_wrk_class_eff_upto) {
		this.user_tmp_wrk_class_eff_upto = user_tmp_wrk_class_eff_upto;
	}
	public String getUser_logged_on_flg() {
		return user_logged_on_flg;
	}
	public void setUser_logged_on_flg(String user_logged_on_flg) {
		this.user_logged_on_flg = user_logged_on_flg;
	}
	public Date getUser_login_time_low() {
		return user_login_time_low;
	}
	public void setUser_login_time_low(Date user_login_time_low) {
		this.user_login_time_low = user_login_time_low;
	}
	public Date getUser_login_time_high() {
		return user_login_time_high;
	}
	public void setUser_login_time_high(Date user_login_time_high) {
		this.user_login_time_high = user_login_time_high;
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
	public String getApp_lang_code() {
		return app_lang_code;
	}
	public void setApp_lang_code(String app_lang_code) {
		this.app_lang_code = app_lang_code;
	}
	public String getDefault_term_id() {
		return default_term_id;
	}
	public void setDefault_term_id(String default_term_id) {
		this.default_term_id = default_term_id;
	}
	public String getVirtual_flg() {
		return virtual_flg;
	}
	public void setVirtual_flg(String virtual_flg) {
		this.virtual_flg = virtual_flg;
	}
	public String getProxy_post_allwd() {
		return proxy_post_allwd;
	}
	public void setProxy_post_allwd(String proxy_post_allwd) {
		this.proxy_post_allwd = proxy_post_allwd;
	}
	public Float getTs_cnt() {
		return ts_cnt;
	}
	public void setTs_cnt(Float ts_cnt) {
		this.ts_cnt = ts_cnt;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getEntity_cre_flg() {
		return entity_cre_flg;
	}
	public void setEntity_cre_flg(String entity_cre_flg) {
		this.entity_cre_flg = entity_cre_flg;
	}
	public FinGenEmpTb getFinGenEmpTb() {
		return finGenEmpTb;
	}
	public void setFinGenEmpTb(FinGenEmpTb finGenEmpTb) {
		this.finGenEmpTb = finGenEmpTb;
	}
	public FinSolTb getFinSolTb() {
		return finSolTb;
	}
	public void setFinSolTb(FinSolTb finSolTb) {
		this.finSolTb = finSolTb;
	}


}
