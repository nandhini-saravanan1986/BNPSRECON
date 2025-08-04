package com.bornfire.xbrl.entities.BNPSRECON;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BRECON_SOURCE_TABLE")
public class Brecon_core_entity {
	private String acid;
	private String amt_reservation_ind;
	private String bank_code;
	private String bank_id;
	private String bkdt_tran_flg;
	private String br_code;
	private String crncy_code;
	private String crncy_hol_chk_done_flg;
	private String cust_id;
	private String del_flg;
	private String del_memo_pad;
	private String dth_init_sol_id;
	private String eabfab_upd_flg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entry_date;
	private String entry_user_id;
	private BigDecimal fx_tran_amt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date gl_date;
	private String gl_segment_string;
	private String gl_sub_head_code;
	private String gst_upd_flg;
	private String impl_cash_part_tran_flg;
	private String instrmnt_alpha;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date instrmnt_date;
	private String instrmnt_num;
	private String instrmnt_type;
	private String iso_flg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date lchg_time;
	private String lchg_user_id;
	private String lift_lien_flg;
	private String module_id;
	private String mud_pool_bal_build_flg;
	private String navigation_flg;
	private String party_code;
	private String part_tran_srl_num;
	private String part_tran_type;
	private BigDecimal principal_portion_amt;
	private String prnt_advc_ind;
	private String proxy_acid;
	private String proxy_post_ind;
	private String pr_srl_num;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date pstd_date;
	private String pstd_flg;
	private String pstd_user_id;
	private String ptran_chrg_exists_flg;
	private String pttm_event_type;
	private BigDecimal rate;
	private String rate_code;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rcre_time;
	private String rcre_user_id;
	private String referral_id;
	private BigDecimal ref_amt;
	private String ref_crncy_code;
	private String ref_num;
	private BigDecimal regularization_amt;
	private BigDecimal reservation_amt;
	private String restrict_modify_ind;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reversal_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date reversal_value_date;
	private String rpt_code;
	private String serial_num;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date si_org_exec_date;
	private String si_srl_num;
	private String sol_id;
	private String svs_tran_id;
	private String sys_part_tran_code;
	private String tf_entity_sol_id;
	private String tod_entity_type;
	private String tod_entity_id;
	private BigDecimal tran_amt;
	private String tran_crncy_code;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date tran_date;
	private String tran_free_code1;
	private String tran_free_code2;
	private String tran_id;
	private String tran_particular;
	private String tran_particular_2;
	private String tran_particular_code;
	private String tran_rmks;
	private String tran_sub_type;
	private String tran_type;
	private BigDecimal trea_rate;
	private String trea_ref_num;
	private String tr_status;
	private BigDecimal ts_cnt;
	private String uad_module_id;
	private String uad_module_key;
	private String user_part_tran_code;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date value_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date vfd_date;
	private String vfd_user_id;
	private String voucher_print_flg;
	private String create_user;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date create_time;
	private String modify_user;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modify_time;
	private String verify_user;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date verify_time;
	private String entity_flg;
	private String modify_flg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date report_from_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date report_to_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date report_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date recon_date;
	private String recon_flag;
	@Id
	private String srlno;
	public String getAcid() {
		return acid;
	}
	public void setAcid(String acid) {
		this.acid = acid;
	}
	public String getAmt_reservation_ind() {
		return amt_reservation_ind;
	}
	public void setAmt_reservation_ind(String amt_reservation_ind) {
		this.amt_reservation_ind = amt_reservation_ind;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getBank_id() {
		return bank_id;
	}
	public void setBank_id(String bank_id) {
		this.bank_id = bank_id;
	}
	public String getBkdt_tran_flg() {
		return bkdt_tran_flg;
	}
	public void setBkdt_tran_flg(String bkdt_tran_flg) {
		this.bkdt_tran_flg = bkdt_tran_flg;
	}
	public String getBr_code() {
		return br_code;
	}
	public void setBr_code(String br_code) {
		this.br_code = br_code;
	}
	public String getCrncy_code() {
		return crncy_code;
	}
	public void setCrncy_code(String crncy_code) {
		this.crncy_code = crncy_code;
	}
	public String getCrncy_hol_chk_done_flg() {
		return crncy_hol_chk_done_flg;
	}
	public void setCrncy_hol_chk_done_flg(String crncy_hol_chk_done_flg) {
		this.crncy_hol_chk_done_flg = crncy_hol_chk_done_flg;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getDel_memo_pad() {
		return del_memo_pad;
	}
	public void setDel_memo_pad(String del_memo_pad) {
		this.del_memo_pad = del_memo_pad;
	}
	public String getDth_init_sol_id() {
		return dth_init_sol_id;
	}
	public void setDth_init_sol_id(String dth_init_sol_id) {
		this.dth_init_sol_id = dth_init_sol_id;
	}
	public String getEabfab_upd_flg() {
		return eabfab_upd_flg;
	}
	public void setEabfab_upd_flg(String eabfab_upd_flg) {
		this.eabfab_upd_flg = eabfab_upd_flg;
	}
	public Date getEntry_date() {
		return entry_date;
	}
	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}
	public String getEntry_user_id() {
		return entry_user_id;
	}
	public void setEntry_user_id(String entry_user_id) {
		this.entry_user_id = entry_user_id;
	}
	public BigDecimal getFx_tran_amt() {
		return fx_tran_amt;
	}
	public void setFx_tran_amt(BigDecimal fx_tran_amt) {
		this.fx_tran_amt = fx_tran_amt;
	}
	public Date getGl_date() {
		return gl_date;
	}
	public void setGl_date(Date gl_date) {
		this.gl_date = gl_date;
	}
	public String getGl_segment_string() {
		return gl_segment_string;
	}
	public void setGl_segment_string(String gl_segment_string) {
		this.gl_segment_string = gl_segment_string;
	}
	public String getGl_sub_head_code() {
		return gl_sub_head_code;
	}
	public void setGl_sub_head_code(String gl_sub_head_code) {
		this.gl_sub_head_code = gl_sub_head_code;
	}
	public String getGst_upd_flg() {
		return gst_upd_flg;
	}
	public void setGst_upd_flg(String gst_upd_flg) {
		this.gst_upd_flg = gst_upd_flg;
	}
	public String getImpl_cash_part_tran_flg() {
		return impl_cash_part_tran_flg;
	}
	public void setImpl_cash_part_tran_flg(String impl_cash_part_tran_flg) {
		this.impl_cash_part_tran_flg = impl_cash_part_tran_flg;
	}
	public String getInstrmnt_alpha() {
		return instrmnt_alpha;
	}
	public void setInstrmnt_alpha(String instrmnt_alpha) {
		this.instrmnt_alpha = instrmnt_alpha;
	}
	public Date getInstrmnt_date() {
		return instrmnt_date;
	}
	public void setInstrmnt_date(Date instrmnt_date) {
		this.instrmnt_date = instrmnt_date;
	}
	public String getInstrmnt_num() {
		return instrmnt_num;
	}
	public void setInstrmnt_num(String instrmnt_num) {
		this.instrmnt_num = instrmnt_num;
	}
	public String getInstrmnt_type() {
		return instrmnt_type;
	}
	public void setInstrmnt_type(String instrmnt_type) {
		this.instrmnt_type = instrmnt_type;
	}
	public String getIso_flg() {
		return iso_flg;
	}
	public void setIso_flg(String iso_flg) {
		this.iso_flg = iso_flg;
	}
	public Date getLchg_time() {
		return lchg_time;
	}
	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}
	public String getLchg_user_id() {
		return lchg_user_id;
	}
	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}
	public String getLift_lien_flg() {
		return lift_lien_flg;
	}
	public void setLift_lien_flg(String lift_lien_flg) {
		this.lift_lien_flg = lift_lien_flg;
	}
	public String getModule_id() {
		return module_id;
	}
	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}
	public String getMud_pool_bal_build_flg() {
		return mud_pool_bal_build_flg;
	}
	public void setMud_pool_bal_build_flg(String mud_pool_bal_build_flg) {
		this.mud_pool_bal_build_flg = mud_pool_bal_build_flg;
	}
	public String getNavigation_flg() {
		return navigation_flg;
	}
	public void setNavigation_flg(String navigation_flg) {
		this.navigation_flg = navigation_flg;
	}
	public String getParty_code() {
		return party_code;
	}
	public void setParty_code(String party_code) {
		this.party_code = party_code;
	}
	public String getPart_tran_srl_num() {
		return part_tran_srl_num;
	}
	public void setPart_tran_srl_num(String part_tran_srl_num) {
		this.part_tran_srl_num = part_tran_srl_num;
	}
	public String getPart_tran_type() {
		return part_tran_type;
	}
	public void setPart_tran_type(String part_tran_type) {
		this.part_tran_type = part_tran_type;
	}
	public BigDecimal getPrincipal_portion_amt() {
		return principal_portion_amt;
	}
	public void setPrincipal_portion_amt(BigDecimal principal_portion_amt) {
		this.principal_portion_amt = principal_portion_amt;
	}
	public String getPrnt_advc_ind() {
		return prnt_advc_ind;
	}
	public void setPrnt_advc_ind(String prnt_advc_ind) {
		this.prnt_advc_ind = prnt_advc_ind;
	}
	public String getProxy_acid() {
		return proxy_acid;
	}
	public void setProxy_acid(String proxy_acid) {
		this.proxy_acid = proxy_acid;
	}
	public String getProxy_post_ind() {
		return proxy_post_ind;
	}
	public void setProxy_post_ind(String proxy_post_ind) {
		this.proxy_post_ind = proxy_post_ind;
	}
	public String getPr_srl_num() {
		return pr_srl_num;
	}
	public void setPr_srl_num(String pr_srl_num) {
		this.pr_srl_num = pr_srl_num;
	}
	public Date getPstd_date() {
		return pstd_date;
	}
	public void setPstd_date(Date pstd_date) {
		this.pstd_date = pstd_date;
	}
	public String getPstd_flg() {
		return pstd_flg;
	}
	public void setPstd_flg(String pstd_flg) {
		this.pstd_flg = pstd_flg;
	}
	public String getPstd_user_id() {
		return pstd_user_id;
	}
	public void setPstd_user_id(String pstd_user_id) {
		this.pstd_user_id = pstd_user_id;
	}
	public String getPtran_chrg_exists_flg() {
		return ptran_chrg_exists_flg;
	}
	public void setPtran_chrg_exists_flg(String ptran_chrg_exists_flg) {
		this.ptran_chrg_exists_flg = ptran_chrg_exists_flg;
	}
	public String getPttm_event_type() {
		return pttm_event_type;
	}
	public void setPttm_event_type(String pttm_event_type) {
		this.pttm_event_type = pttm_event_type;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public String getRate_code() {
		return rate_code;
	}
	public void setRate_code(String rate_code) {
		this.rate_code = rate_code;
	}
	public Date getRcre_time() {
		return rcre_time;
	}
	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}
	public String getRcre_user_id() {
		return rcre_user_id;
	}
	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}
	public String getReferral_id() {
		return referral_id;
	}
	public void setReferral_id(String referral_id) {
		this.referral_id = referral_id;
	}
	public BigDecimal getRef_amt() {
		return ref_amt;
	}
	public void setRef_amt(BigDecimal ref_amt) {
		this.ref_amt = ref_amt;
	}
	public String getRef_crncy_code() {
		return ref_crncy_code;
	}
	public void setRef_crncy_code(String ref_crncy_code) {
		this.ref_crncy_code = ref_crncy_code;
	}
	public String getRef_num() {
		return ref_num;
	}
	public void setRef_num(String ref_num) {
		this.ref_num = ref_num;
	}
	public BigDecimal getRegularization_amt() {
		return regularization_amt;
	}
	public void setRegularization_amt(BigDecimal regularization_amt) {
		this.regularization_amt = regularization_amt;
	}
	public BigDecimal getReservation_amt() {
		return reservation_amt;
	}
	public void setReservation_amt(BigDecimal reservation_amt) {
		this.reservation_amt = reservation_amt;
	}
	public String getRestrict_modify_ind() {
		return restrict_modify_ind;
	}
	public void setRestrict_modify_ind(String restrict_modify_ind) {
		this.restrict_modify_ind = restrict_modify_ind;
	}
	public Date getReversal_date() {
		return reversal_date;
	}
	public void setReversal_date(Date reversal_date) {
		this.reversal_date = reversal_date;
	}
	public Date getReversal_value_date() {
		return reversal_value_date;
	}
	public void setReversal_value_date(Date reversal_value_date) {
		this.reversal_value_date = reversal_value_date;
	}
	public String getRpt_code() {
		return rpt_code;
	}
	public void setRpt_code(String rpt_code) {
		this.rpt_code = rpt_code;
	}
	public String getSerial_num() {
		return serial_num;
	}
	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}
	public Date getSi_org_exec_date() {
		return si_org_exec_date;
	}
	public void setSi_org_exec_date(Date si_org_exec_date) {
		this.si_org_exec_date = si_org_exec_date;
	}
	public String getSi_srl_num() {
		return si_srl_num;
	}
	public void setSi_srl_num(String si_srl_num) {
		this.si_srl_num = si_srl_num;
	}
	public String getSol_id() {
		return sol_id;
	}
	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}
	public String getSvs_tran_id() {
		return svs_tran_id;
	}
	public void setSvs_tran_id(String svs_tran_id) {
		this.svs_tran_id = svs_tran_id;
	}
	public String getSys_part_tran_code() {
		return sys_part_tran_code;
	}
	public void setSys_part_tran_code(String sys_part_tran_code) {
		this.sys_part_tran_code = sys_part_tran_code;
	}
	public String getTf_entity_sol_id() {
		return tf_entity_sol_id;
	}
	public void setTf_entity_sol_id(String tf_entity_sol_id) {
		this.tf_entity_sol_id = tf_entity_sol_id;
	}
	public String getTod_entity_type() {
		return tod_entity_type;
	}
	public void setTod_entity_type(String tod_entity_type) {
		this.tod_entity_type = tod_entity_type;
	}
	public String getTod_entity_id() {
		return tod_entity_id;
	}
	public void setTod_entity_id(String tod_entity_id) {
		this.tod_entity_id = tod_entity_id;
	}
	public BigDecimal getTran_amt() {
		return tran_amt;
	}
	public void setTran_amt(BigDecimal tran_amt) {
		this.tran_amt = tran_amt;
	}
	public String getTran_crncy_code() {
		return tran_crncy_code;
	}
	public void setTran_crncy_code(String tran_crncy_code) {
		this.tran_crncy_code = tran_crncy_code;
	}
	public Date getTran_date() {
		return tran_date;
	}
	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}
	public String getTran_free_code1() {
		return tran_free_code1;
	}
	public void setTran_free_code1(String tran_free_code1) {
		this.tran_free_code1 = tran_free_code1;
	}
	public String getTran_free_code2() {
		return tran_free_code2;
	}
	public void setTran_free_code2(String tran_free_code2) {
		this.tran_free_code2 = tran_free_code2;
	}
	public String getTran_id() {
		return tran_id;
	}
	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}
	public String getTran_particular() {
		return tran_particular;
	}
	public void setTran_particular(String tran_particular) {
		this.tran_particular = tran_particular;
	}
	public String getTran_particular_2() {
		return tran_particular_2;
	}
	public void setTran_particular_2(String tran_particular_2) {
		this.tran_particular_2 = tran_particular_2;
	}
	public String getTran_particular_code() {
		return tran_particular_code;
	}
	public void setTran_particular_code(String tran_particular_code) {
		this.tran_particular_code = tran_particular_code;
	}
	public String getTran_rmks() {
		return tran_rmks;
	}
	public void setTran_rmks(String tran_rmks) {
		this.tran_rmks = tran_rmks;
	}
	public String getTran_sub_type() {
		return tran_sub_type;
	}
	public void setTran_sub_type(String tran_sub_type) {
		this.tran_sub_type = tran_sub_type;
	}
	public String getTran_type() {
		return tran_type;
	}
	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}
	public BigDecimal getTrea_rate() {
		return trea_rate;
	}
	public void setTrea_rate(BigDecimal trea_rate) {
		this.trea_rate = trea_rate;
	}
	public String getTrea_ref_num() {
		return trea_ref_num;
	}
	public void setTrea_ref_num(String trea_ref_num) {
		this.trea_ref_num = trea_ref_num;
	}
	public String getTr_status() {
		return tr_status;
	}
	public void setTr_status(String tr_status) {
		this.tr_status = tr_status;
	}
	public BigDecimal getTs_cnt() {
		return ts_cnt;
	}
	public void setTs_cnt(BigDecimal ts_cnt) {
		this.ts_cnt = ts_cnt;
	}
	public String getUad_module_id() {
		return uad_module_id;
	}
	public void setUad_module_id(String uad_module_id) {
		this.uad_module_id = uad_module_id;
	}
	public String getUad_module_key() {
		return uad_module_key;
	}
	public void setUad_module_key(String uad_module_key) {
		this.uad_module_key = uad_module_key;
	}
	public String getUser_part_tran_code() {
		return user_part_tran_code;
	}
	public void setUser_part_tran_code(String user_part_tran_code) {
		this.user_part_tran_code = user_part_tran_code;
	}
	public Date getValue_date() {
		return value_date;
	}
	public void setValue_date(Date value_date) {
		this.value_date = value_date;
	}
	public Date getVfd_date() {
		return vfd_date;
	}
	public void setVfd_date(Date vfd_date) {
		this.vfd_date = vfd_date;
	}
	public String getVfd_user_id() {
		return vfd_user_id;
	}
	public void setVfd_user_id(String vfd_user_id) {
		this.vfd_user_id = vfd_user_id;
	}
	public String getVoucher_print_flg() {
		return voucher_print_flg;
	}
	public void setVoucher_print_flg(String voucher_print_flg) {
		this.voucher_print_flg = voucher_print_flg;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
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
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public Date getReport_from_date() {
		return report_from_date;
	}
	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}
	public Date getReport_to_date() {
		return report_to_date;
	}
	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public Date getRecon_date() {
		return recon_date;
	}
	public void setRecon_date(Date recon_date) {
		this.recon_date = recon_date;
	}
	public String getRecon_flag() {
		return recon_flag;
	}
	public void setRecon_flag(String recon_flag) {
		this.recon_flag = recon_flag;
	}
	public String getSrlno() {
		return srlno;
	}
	public void setSrlno(String srlno) {
		this.srlno = srlno;
	}
	public Brecon_core_entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}