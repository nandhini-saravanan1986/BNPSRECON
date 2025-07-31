package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="SOL")
public class FinSolTb {
	
	@Id
	private String	sol_id;
	private String	del_flg;
	private String	sol_desc;
	private String	extn_cntr_code;
	private String	bank_code;
	private String	abbr_bank_name;
	private String	br_code;
	private String	abbr_br_name;
	private String	clg_centre_num;
	private String	micr_centre_flg;
	private String	micr_centre_code;
	private String	micr_bank_code;
	private String	micr_branch_code;
	private String	addr_1;
	private String	addr_2;
	private String	city_code;
	private String	state_code;
	private String	pin_code;
	private BigDecimal	wkly_off;
	private BigDecimal	instrmnt_encode_batch_num;
	private BigDecimal	instrmnt_encode_block_num;
	private String	stop_cash_ft_flg;
	private String	stop_clg_ft_flg;
	private String	stop_xfer_ft_flg;
	private String	user_cash_dr_lim_excp_code;
	private String	user_clg_dr_lim_excp_code;
	private String	user_xfer_dr_lim_excp_code;
	private String	tds_cert_num_code;
	private String	same_day_rev_to_ibr_flg;
	private Date	date_of_installation;
	private String	db_stat_code;
	private String	db_int_stat_code;
	private Date	bod_sys_date;
	private Date	last_si_exec_date;
	private String	lchg_user_id;
	private String	rcre_user_id;
	private Date	lchg_time;
	private Date	rcre_time;
	private Date	cut_over_time;
	private String	value_dating_on_holidays;
	private String	type_of_cash_acct;
	private String	br_stat_code;
	private BigDecimal	hc_vault_limit_in_hc;
	private BigDecimal	fc_vault_limit_in_hc;
	private BigDecimal	consol_vault_limit_in_hc;
	private String	sol_alias;
	private String	db_stat_user_id;
	private String	atm_job_status;
	private String	uniform_br_code;
	private String	license_no;
	@DateTimeFormat(pattern="dd-MM-yyyy")
	private Date	br_open_date;
	private String	region_name;
	private String	division_name;
	private String	circle_office_name;
	private String	tds_circle_name;
	private String	dp_code;
	private String	tax_dedn_details;
	private String	pan_gir_no;
	private BigDecimal	num_of_times_ibr_gen;
	private BigDecimal	osp_max_out_std_days;
	private String	proxy_pend_verifn_excp_code;
	private String	proxy_not_squared_excp_code;
	private String	next_cust_num_code;
	private String	instrmnt_wise_reg_alwd;
	private String	home_crncy_code;
	private BigDecimal	ddn_warn_level;
	private String	ddn_warn_level_excp_code;
	private String	external_sol;
	private String	high_value_sol;
	private String	profit_center;
	private String	all_ext_trans_proc_excp_code;
	private String	tr_enable_flg;
	private String	tr_home_crncy_code;
	private BigDecimal	ts_cnt;
	private String	destry_invt_class;
	private String	destry_invt_location;
	private String	ext_eod_not_comp_excp_code;
	private String	cs_sol_mesg1;
	private String	cs_sol_mesg2;
	private String	fab_flg;
	private String	local_image_flg;
	private String	receive_all_images_flg;
	private BigDecimal	sol_priority;
	private Date	pdc_instl_run_date;
	private String	sdl_id;
	private String	branch_ip_address;
	private BigDecimal	branch_ref_port_num;
	private Date	last_int_calc_date_for_sb;
	private String	sol_eod_status;
	private BigDecimal	minor_age;
	private String	cs_sol_natl_mesg1;
	private String	cs_sol_natl_mesg2;
	
	
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getSol_desc() {
		return sol_desc;
	}
	public void setSol_desc(String sol_desc) {
		this.sol_desc = sol_desc;
	}
	public String getExtn_cntr_code() {
		return extn_cntr_code;
	}
	public void setExtn_cntr_code(String extn_cntr_code) {
		this.extn_cntr_code = extn_cntr_code;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getAbbr_bank_name() {
		return abbr_bank_name;
	}
	public void setAbbr_bank_name(String abbr_bank_name) {
		this.abbr_bank_name = abbr_bank_name;
	}
	public String getBr_code() {
		return br_code;
	}
	public void setBr_code(String br_code) {
		this.br_code = br_code;
	}
	public String getAbbr_br_name() {
		return abbr_br_name;
	}
	public void setAbbr_br_name(String abbr_br_name) {
		this.abbr_br_name = abbr_br_name;
	}
	public String getClg_centre_num() {
		return clg_centre_num;
	}
	public void setClg_centre_num(String clg_centre_num) {
		this.clg_centre_num = clg_centre_num;
	}
	public String getMicr_centre_flg() {
		return micr_centre_flg;
	}
	public void setMicr_centre_flg(String micr_centre_flg) {
		this.micr_centre_flg = micr_centre_flg;
	}
	public String getMicr_centre_code() {
		return micr_centre_code;
	}
	public void setMicr_centre_code(String micr_centre_code) {
		this.micr_centre_code = micr_centre_code;
	}
	public String getMicr_bank_code() {
		return micr_bank_code;
	}
	public void setMicr_bank_code(String micr_bank_code) {
		this.micr_bank_code = micr_bank_code;
	}
	public String getMicr_branch_code() {
		return micr_branch_code;
	}
	public void setMicr_branch_code(String micr_branch_code) {
		this.micr_branch_code = micr_branch_code;
	}
	public String getAddr_1() {
		return addr_1;
	}
	public void setAddr_1(String addr_1) {
		this.addr_1 = addr_1;
	}
	public String getAddr_2() {
		return addr_2;
	}
	public void setAddr_2(String addr_2) {
		this.addr_2 = addr_2;
	}
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
	public String getState_code() {
		return state_code;
	}
	public void setState_code(String state_code) {
		this.state_code = state_code;
	}
	public String getPin_code() {
		return pin_code;
	}
	public void setPin_code(String pin_code) {
		this.pin_code = pin_code;
	}
	public BigDecimal getWkly_off() {
		return wkly_off;
	}
	public void setWkly_off(BigDecimal wkly_off) {
		this.wkly_off = wkly_off;
	}
	public BigDecimal getInstrmnt_encode_batch_num() {
		return instrmnt_encode_batch_num;
	}
	public void setInstrmnt_encode_batch_num(BigDecimal instrmnt_encode_batch_num) {
		this.instrmnt_encode_batch_num = instrmnt_encode_batch_num;
	}
	public BigDecimal getInstrmnt_encode_block_num() {
		return instrmnt_encode_block_num;
	}
	public void setInstrmnt_encode_block_num(BigDecimal instrmnt_encode_block_num) {
		this.instrmnt_encode_block_num = instrmnt_encode_block_num;
	}
	public String getStop_cash_ft_flg() {
		return stop_cash_ft_flg;
	}
	public void setStop_cash_ft_flg(String stop_cash_ft_flg) {
		this.stop_cash_ft_flg = stop_cash_ft_flg;
	}
	public String getStop_clg_ft_flg() {
		return stop_clg_ft_flg;
	}
	public void setStop_clg_ft_flg(String stop_clg_ft_flg) {
		this.stop_clg_ft_flg = stop_clg_ft_flg;
	}
	public String getStop_xfer_ft_flg() {
		return stop_xfer_ft_flg;
	}
	public void setStop_xfer_ft_flg(String stop_xfer_ft_flg) {
		this.stop_xfer_ft_flg = stop_xfer_ft_flg;
	}
	public String getUser_cash_dr_lim_excp_code() {
		return user_cash_dr_lim_excp_code;
	}
	public void setUser_cash_dr_lim_excp_code(String user_cash_dr_lim_excp_code) {
		this.user_cash_dr_lim_excp_code = user_cash_dr_lim_excp_code;
	}
	public String getUser_clg_dr_lim_excp_code() {
		return user_clg_dr_lim_excp_code;
	}
	public void setUser_clg_dr_lim_excp_code(String user_clg_dr_lim_excp_code) {
		this.user_clg_dr_lim_excp_code = user_clg_dr_lim_excp_code;
	}
	public String getUser_xfer_dr_lim_excp_code() {
		return user_xfer_dr_lim_excp_code;
	}
	public void setUser_xfer_dr_lim_excp_code(String user_xfer_dr_lim_excp_code) {
		this.user_xfer_dr_lim_excp_code = user_xfer_dr_lim_excp_code;
	}
	public String getTds_cert_num_code() {
		return tds_cert_num_code;
	}
	public void setTds_cert_num_code(String tds_cert_num_code) {
		this.tds_cert_num_code = tds_cert_num_code;
	}
	public String getSame_day_rev_to_ibr_flg() {
		return same_day_rev_to_ibr_flg;
	}
	public void setSame_day_rev_to_ibr_flg(String same_day_rev_to_ibr_flg) {
		this.same_day_rev_to_ibr_flg = same_day_rev_to_ibr_flg;
	}
	public Date getDate_of_installation() {
		return date_of_installation;
	}
	public void setDate_of_installation(Date date_of_installation) {
		this.date_of_installation = date_of_installation;
	}
	public String getDb_stat_code() {
		return db_stat_code;
	}
	public void setDb_stat_code(String db_stat_code) {
		this.db_stat_code = db_stat_code;
	}
	public String getDb_int_stat_code() {
		return db_int_stat_code;
	}
	public void setDb_int_stat_code(String db_int_stat_code) {
		this.db_int_stat_code = db_int_stat_code;
	}
	public Date getBod_sys_date() {
		return bod_sys_date;
	}
	public void setBod_sys_date(Date bod_sys_date) {
		this.bod_sys_date = bod_sys_date;
	}
	public Date getLast_si_exec_date() {
		return last_si_exec_date;
	}
	public void setLast_si_exec_date(Date last_si_exec_date) {
		this.last_si_exec_date = last_si_exec_date;
	}
	public String getLchg_user_id() {
		return lchg_user_id;
	}
	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}
	public String getRcre_user_id() {
		return rcre_user_id;
	}
	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}
	public Date getLchg_time() {
		return lchg_time;
	}
	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}
	public Date getRcre_time() {
		return rcre_time;
	}
	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}
	public Date getCut_over_time() {
		return cut_over_time;
	}
	public void setCut_over_time(Date cut_over_time) {
		this.cut_over_time = cut_over_time;
	}
	public String getValue_dating_on_holidays() {
		return value_dating_on_holidays;
	}
	public void setValue_dating_on_holidays(String value_dating_on_holidays) {
		this.value_dating_on_holidays = value_dating_on_holidays;
	}
	public String getType_of_cash_acct() {
		return type_of_cash_acct;
	}
	public void setType_of_cash_acct(String type_of_cash_acct) {
		this.type_of_cash_acct = type_of_cash_acct;
	}
	public String getBr_stat_code() {
		return br_stat_code;
	}
	public void setBr_stat_code(String br_stat_code) {
		this.br_stat_code = br_stat_code;
	}
	public BigDecimal getHc_vault_limit_in_hc() {
		return hc_vault_limit_in_hc;
	}
	public void setHc_vault_limit_in_hc(BigDecimal hc_vault_limit_in_hc) {
		this.hc_vault_limit_in_hc = hc_vault_limit_in_hc;
	}
	public BigDecimal getFc_vault_limit_in_hc() {
		return fc_vault_limit_in_hc;
	}
	public void setFc_vault_limit_in_hc(BigDecimal fc_vault_limit_in_hc) {
		this.fc_vault_limit_in_hc = fc_vault_limit_in_hc;
	}
	public BigDecimal getConsol_vault_limit_in_hc() {
		return consol_vault_limit_in_hc;
	}
	public void setConsol_vault_limit_in_hc(BigDecimal consol_vault_limit_in_hc) {
		this.consol_vault_limit_in_hc = consol_vault_limit_in_hc;
	}
	public String getSol_alias() {
		return sol_alias;
	}
	public void setSol_alias(String sol_alias) {
		this.sol_alias = sol_alias;
	}
	public String getDb_stat_user_id() {
		return db_stat_user_id;
	}
	public void setDb_stat_user_id(String db_stat_user_id) {
		this.db_stat_user_id = db_stat_user_id;
	}
	public String getAtm_job_status() {
		return atm_job_status;
	}
	public void setAtm_job_status(String atm_job_status) {
		this.atm_job_status = atm_job_status;
	}
	public String getUniform_br_code() {
		return uniform_br_code;
	}
	public void setUniform_br_code(String uniform_br_code) {
		this.uniform_br_code = uniform_br_code;
	}
	public String getLicense_no() {
		return license_no;
	}
	public void setLicense_no(String license_no) {
		this.license_no = license_no;
	}
	public Date getBr_open_date() {
		return br_open_date;
	}
	public void setBr_open_date(Date br_open_date) {
		this.br_open_date = br_open_date;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	public String getDivision_name() {
		return division_name;
	}
	public void setDivision_name(String division_name) {
		this.division_name = division_name;
	}
	public String getCircle_office_name() {
		return circle_office_name;
	}
	public void setCircle_office_name(String circle_office_name) {
		this.circle_office_name = circle_office_name;
	}
	public String getTds_circle_name() {
		return tds_circle_name;
	}
	public void setTds_circle_name(String tds_circle_name) {
		this.tds_circle_name = tds_circle_name;
	}
	public String getDp_code() {
		return dp_code;
	}
	public void setDp_code(String dp_code) {
		this.dp_code = dp_code;
	}
	public String getTax_dedn_details() {
		return tax_dedn_details;
	}
	public void setTax_dedn_details(String tax_dedn_details) {
		this.tax_dedn_details = tax_dedn_details;
	}
	public String getPan_gir_no() {
		return pan_gir_no;
	}
	public void setPan_gir_no(String pan_gir_no) {
		this.pan_gir_no = pan_gir_no;
	}
	public BigDecimal getNum_of_times_ibr_gen() {
		return num_of_times_ibr_gen;
	}
	public void setNum_of_times_ibr_gen(BigDecimal num_of_times_ibr_gen) {
		this.num_of_times_ibr_gen = num_of_times_ibr_gen;
	}
	public BigDecimal getOsp_max_out_std_days() {
		return osp_max_out_std_days;
	}
	public void setOsp_max_out_std_days(BigDecimal osp_max_out_std_days) {
		this.osp_max_out_std_days = osp_max_out_std_days;
	}
	public String getProxy_pend_verifn_excp_code() {
		return proxy_pend_verifn_excp_code;
	}
	public void setProxy_pend_verifn_excp_code(String proxy_pend_verifn_excp_code) {
		this.proxy_pend_verifn_excp_code = proxy_pend_verifn_excp_code;
	}
	public String getProxy_not_squared_excp_code() {
		return proxy_not_squared_excp_code;
	}
	public void setProxy_not_squared_excp_code(String proxy_not_squared_excp_code) {
		this.proxy_not_squared_excp_code = proxy_not_squared_excp_code;
	}
	public String getNext_cust_num_code() {
		return next_cust_num_code;
	}
	public void setNext_cust_num_code(String next_cust_num_code) {
		this.next_cust_num_code = next_cust_num_code;
	}
	public String getInstrmnt_wise_reg_alwd() {
		return instrmnt_wise_reg_alwd;
	}
	public void setInstrmnt_wise_reg_alwd(String instrmnt_wise_reg_alwd) {
		this.instrmnt_wise_reg_alwd = instrmnt_wise_reg_alwd;
	}
	public String getHome_crncy_code() {
		return home_crncy_code;
	}
	public void setHome_crncy_code(String home_crncy_code) {
		this.home_crncy_code = home_crncy_code;
	}
	public BigDecimal getDdn_warn_level() {
		return ddn_warn_level;
	}
	public void setDdn_warn_level(BigDecimal ddn_warn_level) {
		this.ddn_warn_level = ddn_warn_level;
	}
	public String getDdn_warn_level_excp_code() {
		return ddn_warn_level_excp_code;
	}
	public void setDdn_warn_level_excp_code(String ddn_warn_level_excp_code) {
		this.ddn_warn_level_excp_code = ddn_warn_level_excp_code;
	}
	public String getExternal_sol() {
		return external_sol;
	}
	public void setExternal_sol(String external_sol) {
		this.external_sol = external_sol;
	}
	public String getHigh_value_sol() {
		return high_value_sol;
	}
	public void setHigh_value_sol(String high_value_sol) {
		this.high_value_sol = high_value_sol;
	}
	public String getProfit_center() {
		return profit_center;
	}
	public void setProfit_center(String profit_center) {
		this.profit_center = profit_center;
	}
	public String getAll_ext_trans_proc_excp_code() {
		return all_ext_trans_proc_excp_code;
	}
	public void setAll_ext_trans_proc_excp_code(String all_ext_trans_proc_excp_code) {
		this.all_ext_trans_proc_excp_code = all_ext_trans_proc_excp_code;
	}
	public String getTr_enable_flg() {
		return tr_enable_flg;
	}
	public void setTr_enable_flg(String tr_enable_flg) {
		this.tr_enable_flg = tr_enable_flg;
	}
	public String getTr_home_crncy_code() {
		return tr_home_crncy_code;
	}
	public void setTr_home_crncy_code(String tr_home_crncy_code) {
		this.tr_home_crncy_code = tr_home_crncy_code;
	}
	public BigDecimal getTs_cnt() {
		return ts_cnt;
	}
	public void setTs_cnt(BigDecimal ts_cnt) {
		this.ts_cnt = ts_cnt;
	}
	public String getDestry_invt_class() {
		return destry_invt_class;
	}
	public void setDestry_invt_class(String destry_invt_class) {
		this.destry_invt_class = destry_invt_class;
	}
	public String getDestry_invt_location() {
		return destry_invt_location;
	}
	public void setDestry_invt_location(String destry_invt_location) {
		this.destry_invt_location = destry_invt_location;
	}
	public String getExt_eod_not_comp_excp_code() {
		return ext_eod_not_comp_excp_code;
	}
	public void setExt_eod_not_comp_excp_code(String ext_eod_not_comp_excp_code) {
		this.ext_eod_not_comp_excp_code = ext_eod_not_comp_excp_code;
	}
	public String getCs_sol_mesg1() {
		return cs_sol_mesg1;
	}
	public void setCs_sol_mesg1(String cs_sol_mesg1) {
		this.cs_sol_mesg1 = cs_sol_mesg1;
	}
	public String getCs_sol_mesg2() {
		return cs_sol_mesg2;
	}
	public void setCs_sol_mesg2(String cs_sol_mesg2) {
		this.cs_sol_mesg2 = cs_sol_mesg2;
	}
	public String getFab_flg() {
		return fab_flg;
	}
	public void setFab_flg(String fab_flg) {
		this.fab_flg = fab_flg;
	}
	public String getLocal_image_flg() {
		return local_image_flg;
	}
	public void setLocal_image_flg(String local_image_flg) {
		this.local_image_flg = local_image_flg;
	}
	public String getReceive_all_images_flg() {
		return receive_all_images_flg;
	}
	public void setReceive_all_images_flg(String receive_all_images_flg) {
		this.receive_all_images_flg = receive_all_images_flg;
	}
	public BigDecimal getSol_priority() {
		return sol_priority;
	}
	public void setSol_priority(BigDecimal sol_priority) {
		this.sol_priority = sol_priority;
	}
	public Date getPdc_instl_run_date() {
		return pdc_instl_run_date;
	}
	public void setPdc_instl_run_date(Date pdc_instl_run_date) {
		this.pdc_instl_run_date = pdc_instl_run_date;
	}
	public String getSdl_id() {
		return sdl_id;
	}
	public void setSdl_id(String sdl_id) {
		this.sdl_id = sdl_id;
	}
	public String getBranch_ip_address() {
		return branch_ip_address;
	}
	public void setBranch_ip_address(String branch_ip_address) {
		this.branch_ip_address = branch_ip_address;
	}
	public BigDecimal getBranch_ref_port_num() {
		return branch_ref_port_num;
	}
	public void setBranch_ref_port_num(BigDecimal branch_ref_port_num) {
		this.branch_ref_port_num = branch_ref_port_num;
	}
	public Date getLast_int_calc_date_for_sb() {
		return last_int_calc_date_for_sb;
	}
	public void setLast_int_calc_date_for_sb(Date last_int_calc_date_for_sb) {
		this.last_int_calc_date_for_sb = last_int_calc_date_for_sb;
	}
	public String getSol_eod_status() {
		return sol_eod_status;
	}
	public void setSol_eod_status(String sol_eod_status) {
		this.sol_eod_status = sol_eod_status;
	}
	public BigDecimal getMinor_age() {
		return minor_age;
	}
	public void setMinor_age(BigDecimal minor_age) {
		this.minor_age = minor_age;
	}
	public String getCs_sol_natl_mesg1() {
		return cs_sol_natl_mesg1;
	}
	public void setCs_sol_natl_mesg1(String cs_sol_natl_mesg1) {
		this.cs_sol_natl_mesg1 = cs_sol_natl_mesg1;
	}
	public String getCs_sol_natl_mesg2() {
		return cs_sol_natl_mesg2;
	}
	public void setCs_sol_natl_mesg2(String cs_sol_natl_mesg2) {
		this.cs_sol_natl_mesg2 = cs_sol_natl_mesg2;
	}
	
	
	

}
