package com.bornfire.xbrl.entities.BNPSRECON;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BRECON_COMMON_TABLE")
public class BRECON_Common_Table_Entity {
	private String	account_no;
	private String	acid;
	private String	amt_reservation_ind;
	private String	bank_code;
	private String	bank_id;
	private String	bkdt_tran_flg;
	private String	br_code;
	private String	canonicalizationmethod_algorithm;
	private Date	create_time;
	private String	create_user;
	private String	crncy_code;
	private String	crncy_hol_chk_done_flg;
	private String	cust_id;
	private String	del_flg;
	private String	del_memo_pad;
	private String	digestmethod_algorithm;
	private String	dth_init_sol_id;
	private String	eabfab_upd_flg;
	private String	entity_flg;
	private Date	entry_date;
	private String	entry_user_id;
	private BigDecimal	fx_tran_amt;
	private Date	gl_date;
	private String	gl_segment_string;
	private String	gl_sub_head_code;
	private String	grphdr_bank_identifier_code;
	private Date	grphdr_creation_date_time;
	private String	grphdr_last_page_indicator;
	private String	grphdr_message_identifier;
	private String	grphdr_name;
	private BigDecimal	grphdr_page_number;
	private String	gst_upd_flg;
	private String	impl_cash_part_tran_flg;
	private String	instrmnt_alpha;
	private Date	instrmnt_date;
	private String	instrmnt_num;
	private String	instrmnt_type;
	private String	iso_flg;
	private Date	lchg_time;
	private String	lchg_user_id;
	private String	lift_lien_flg;
	private String	modify_flg;
	private Date	modify_time;
	private String	modify_user;
	private String	module_id;
	private String	mud_pool_bal_build_flg;
	private String	navigation_flg;
	private String	ntry_account_servicer_reference;
	private BigDecimal	ntry_amount_currency;
	private Date	ntry_booking_date;
	private Date	ntry_booking_date_time;
	private String	ntry_brch_cdtdbtint;
	private String	ntry_btch_currency;
	private String	ntry_btch_msg_id;
	private BigDecimal	ntry_btch_numoftxs;
	private BigDecimal	ntry_btch_ttlamt;
	private String	ntry_cdtragt_bicfi_credit;
	private String	ntry_code;
	private String	ntry_credit_debit_indicator;
	private String	ntry_dbtragt_bicfi_debit;
	private String	ntry_entry_reference;
	private String	ntry_fininstnid_bicfi;
	private BigDecimal	ntry_instructed_amount;
	private String	ntry_proprietary_code;
	private String	ntry_refs_account_servicer_reference;
	private String	ntry_refs_clearing_system_reference;
	private String	ntry_refs_end_to_end_identification;
	private String	ntry_refs_instruction_id;
	private String	ntry_refs_message_identifier;
	private String	ntry_refs_pmtinfid;
	private String	ntry_refs_transaction_id;
	private String	ntry_refs_uetr;
	private BigDecimal	ntry_transaction_amount;
	private BigDecimal	ntry_txdtls_amount_currency;
	private String	ntry_txdtls_credit_debit_indicator;
	private Date	ntry_value_date;
	private String	ntry_value_date_time;
	private String	party_code;
	private String	part_tran_srl_num;
	private String	part_tran_type;
	private BigDecimal	principal_portion_amt;
	private String	prnt_advc_ind;
	private String	proxy_acid;
	private String	proxy_post_ind;
	private String	pr_srl_num;
	private Date	pstd_date;
	private String	pstd_flg;
	private String	pstd_user_id;
	private String	ptran_chrg_exists_flg;
	private String	pttm_event_type;
	private BigDecimal	rate;
	private String	rate_code;
	private Date	rcre_time;
	private String	rcre_user_id;
	private Date	recon_date;
	private String	recon_flag;
	private String	referral_id;
	private BigDecimal	ref_amt;
	private String	ref_crncy_code;
	private String	ref_num;
	private BigDecimal	regularization_amt;
	private Date	report_date;
	private Date	report_from_date;
	private String	report_name;
	private Date	report_to_date;
	private BigDecimal	reservation_amt;
	private String	restrict_modify_ind;
	private Date	reversal_date;
	private Date	reversal_value_date;
	private String	rpt_code;
	private String	serial_num;
	private String	signaturemethod_algorithm;
	private String	signature_keyinfo_x509_certificate;
	private String	signature_keyinfo_x509_subject_name;
	private String	signature_signedinfo_digest_value;
	private String	signature_signedinfo_signature_value;
	private Date	si_org_exec_date;
	private String	si_srl_num;
	private String	sol_id;
	@Id
	private String	srlno;
	private String	stmt_account_identifier;
	private BigDecimal	stmt_bal1_amount;
	private String	stmt_bal1_code_or_proprietary;
	private String	stmt_bal1_credit_debit_indicator;
	private Date	stmt_bal1_date;
	private Date	stmt_bal1_date_time;
	private BigDecimal	stmt_bal_amount;
	private String	stmt_bal_code_or_proprietary;
	private String	stmt_bal_credit_debit_indicator;
	private Date	stmt_bal_date;
	private Date	stmt_bal_date_time;
	private Date	stmt_creation_date_time;
	private BigDecimal	stmt_electronic_sequence_number;
	private Date	stmt_from_date_time;
	private String	stmt_related_account_identifier;
	private String	stmt_statement_identifier;
	private Date	stmt_to_date_time;
	private String	svs_tran_id;
	private String	sys_part_tran_code;
	private String	tf_entity_sol_id;
	private String	tod_entity_id;
	private String	tod_entity_type;
	private String	transaction_currency;
	private String	transform_algorithm;
	private BigDecimal	tran_amt;
	private String	tran_crncy_code;
	private Date	tran_date;
	private String	tran_free_code1;
	private String	tran_free_code2;
	private String	tran_id;
	private String	tran_particular;
	private String	tran_particular_2;
	private String	tran_particular_code;
	private String	tran_rmks;
	private String	tran_sub_type;
	private String	tran_type;
	private BigDecimal	trea_rate;
	private String	trea_ref_num;
	private String	tr_status;
	private BigDecimal	ts_cnt;
	private BigDecimal	txssummry_amount;
	private String	txssummry_credit_debit_indicator;
	private BigDecimal	txssummry_credit_number_of_entries;
	private BigDecimal	txssummry_credit_sum;
	private BigDecimal	txssummry_debit_number_of_entries;
	private BigDecimal	txssummry_debit_sum;
	private BigDecimal	txssummry_number_of_entries;
	private BigDecimal	txssummry_sum;
	private String	uad_module_id;
	private String	uad_module_key;
	private String	user_part_tran_code;
	private Date	value_date;
	private Date	verify_time;
	private String	verify_user;
	private Date	vfd_date;
	private String	vfd_user_id;
	private String	voucher_print_flg;
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
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
	public String getCanonicalizationmethod_algorithm() {
		return canonicalizationmethod_algorithm;
	}
	public void setCanonicalizationmethod_algorithm(String canonicalizationmethod_algorithm) {
		this.canonicalizationmethod_algorithm = canonicalizationmethod_algorithm;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
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
	public String getDigestmethod_algorithm() {
		return digestmethod_algorithm;
	}
	public void setDigestmethod_algorithm(String digestmethod_algorithm) {
		this.digestmethod_algorithm = digestmethod_algorithm;
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
	public String getEntity_flg() {
		return entity_flg;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
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
	public String getGrphdr_bank_identifier_code() {
		return grphdr_bank_identifier_code;
	}
	public void setGrphdr_bank_identifier_code(String grphdr_bank_identifier_code) {
		this.grphdr_bank_identifier_code = grphdr_bank_identifier_code;
	}
	public Date getGrphdr_creation_date_time() {
		return grphdr_creation_date_time;
	}
	public void setGrphdr_creation_date_time(Date grphdr_creation_date_time) {
		this.grphdr_creation_date_time = grphdr_creation_date_time;
	}
	public String getGrphdr_last_page_indicator() {
		return grphdr_last_page_indicator;
	}
	public void setGrphdr_last_page_indicator(String grphdr_last_page_indicator) {
		this.grphdr_last_page_indicator = grphdr_last_page_indicator;
	}
	public String getGrphdr_message_identifier() {
		return grphdr_message_identifier;
	}
	public void setGrphdr_message_identifier(String grphdr_message_identifier) {
		this.grphdr_message_identifier = grphdr_message_identifier;
	}
	public String getGrphdr_name() {
		return grphdr_name;
	}
	public void setGrphdr_name(String grphdr_name) {
		this.grphdr_name = grphdr_name;
	}
	public BigDecimal getGrphdr_page_number() {
		return grphdr_page_number;
	}
	public void setGrphdr_page_number(BigDecimal grphdr_page_number) {
		this.grphdr_page_number = grphdr_page_number;
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
	public String getModify_flg() {
		return modify_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public String getModify_user() {
		return modify_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
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
	public String getNtry_account_servicer_reference() {
		return ntry_account_servicer_reference;
	}
	public void setNtry_account_servicer_reference(String ntry_account_servicer_reference) {
		this.ntry_account_servicer_reference = ntry_account_servicer_reference;
	}
	public BigDecimal getNtry_amount_currency() {
		return ntry_amount_currency;
	}
	public void setNtry_amount_currency(BigDecimal ntry_amount_currency) {
		this.ntry_amount_currency = ntry_amount_currency;
	}
	public Date getNtry_booking_date() {
		return ntry_booking_date;
	}
	public void setNtry_booking_date(Date ntry_booking_date) {
		this.ntry_booking_date = ntry_booking_date;
	}
	public Date getNtry_booking_date_time() {
		return ntry_booking_date_time;
	}
	public void setNtry_booking_date_time(Date ntry_booking_date_time) {
		this.ntry_booking_date_time = ntry_booking_date_time;
	}
	public String getNtry_brch_cdtdbtint() {
		return ntry_brch_cdtdbtint;
	}
	public void setNtry_brch_cdtdbtint(String ntry_brch_cdtdbtint) {
		this.ntry_brch_cdtdbtint = ntry_brch_cdtdbtint;
	}
	public String getNtry_btch_currency() {
		return ntry_btch_currency;
	}
	public void setNtry_btch_currency(String ntry_btch_currency) {
		this.ntry_btch_currency = ntry_btch_currency;
	}
	public String getNtry_btch_msg_id() {
		return ntry_btch_msg_id;
	}
	public void setNtry_btch_msg_id(String ntry_btch_msg_id) {
		this.ntry_btch_msg_id = ntry_btch_msg_id;
	}
	public BigDecimal getNtry_btch_numoftxs() {
		return ntry_btch_numoftxs;
	}
	public void setNtry_btch_numoftxs(BigDecimal ntry_btch_numoftxs) {
		this.ntry_btch_numoftxs = ntry_btch_numoftxs;
	}
	public BigDecimal getNtry_btch_ttlamt() {
		return ntry_btch_ttlamt;
	}
	public void setNtry_btch_ttlamt(BigDecimal ntry_btch_ttlamt) {
		this.ntry_btch_ttlamt = ntry_btch_ttlamt;
	}
	public String getNtry_cdtragt_bicfi_credit() {
		return ntry_cdtragt_bicfi_credit;
	}
	public void setNtry_cdtragt_bicfi_credit(String ntry_cdtragt_bicfi_credit) {
		this.ntry_cdtragt_bicfi_credit = ntry_cdtragt_bicfi_credit;
	}
	public String getNtry_code() {
		return ntry_code;
	}
	public void setNtry_code(String ntry_code) {
		this.ntry_code = ntry_code;
	}
	public String getNtry_credit_debit_indicator() {
		return ntry_credit_debit_indicator;
	}
	public void setNtry_credit_debit_indicator(String ntry_credit_debit_indicator) {
		this.ntry_credit_debit_indicator = ntry_credit_debit_indicator;
	}
	public String getNtry_dbtragt_bicfi_debit() {
		return ntry_dbtragt_bicfi_debit;
	}
	public void setNtry_dbtragt_bicfi_debit(String ntry_dbtragt_bicfi_debit) {
		this.ntry_dbtragt_bicfi_debit = ntry_dbtragt_bicfi_debit;
	}
	public String getNtry_entry_reference() {
		return ntry_entry_reference;
	}
	public void setNtry_entry_reference(String ntry_entry_reference) {
		this.ntry_entry_reference = ntry_entry_reference;
	}
	public String getNtry_fininstnid_bicfi() {
		return ntry_fininstnid_bicfi;
	}
	public void setNtry_fininstnid_bicfi(String ntry_fininstnid_bicfi) {
		this.ntry_fininstnid_bicfi = ntry_fininstnid_bicfi;
	}
	public BigDecimal getNtry_instructed_amount() {
		return ntry_instructed_amount;
	}
	public void setNtry_instructed_amount(BigDecimal ntry_instructed_amount) {
		this.ntry_instructed_amount = ntry_instructed_amount;
	}
	public String getNtry_proprietary_code() {
		return ntry_proprietary_code;
	}
	public void setNtry_proprietary_code(String ntry_proprietary_code) {
		this.ntry_proprietary_code = ntry_proprietary_code;
	}
	public String getNtry_refs_account_servicer_reference() {
		return ntry_refs_account_servicer_reference;
	}
	public void setNtry_refs_account_servicer_reference(String ntry_refs_account_servicer_reference) {
		this.ntry_refs_account_servicer_reference = ntry_refs_account_servicer_reference;
	}
	public String getNtry_refs_clearing_system_reference() {
		return ntry_refs_clearing_system_reference;
	}
	public void setNtry_refs_clearing_system_reference(String ntry_refs_clearing_system_reference) {
		this.ntry_refs_clearing_system_reference = ntry_refs_clearing_system_reference;
	}
	public String getNtry_refs_end_to_end_identification() {
		return ntry_refs_end_to_end_identification;
	}
	public void setNtry_refs_end_to_end_identification(String ntry_refs_end_to_end_identification) {
		this.ntry_refs_end_to_end_identification = ntry_refs_end_to_end_identification;
	}
	public String getNtry_refs_instruction_id() {
		return ntry_refs_instruction_id;
	}
	public void setNtry_refs_instruction_id(String ntry_refs_instruction_id) {
		this.ntry_refs_instruction_id = ntry_refs_instruction_id;
	}
	public String getNtry_refs_message_identifier() {
		return ntry_refs_message_identifier;
	}
	public void setNtry_refs_message_identifier(String ntry_refs_message_identifier) {
		this.ntry_refs_message_identifier = ntry_refs_message_identifier;
	}
	public String getNtry_refs_pmtinfid() {
		return ntry_refs_pmtinfid;
	}
	public void setNtry_refs_pmtinfid(String ntry_refs_pmtinfid) {
		this.ntry_refs_pmtinfid = ntry_refs_pmtinfid;
	}
	public String getNtry_refs_transaction_id() {
		return ntry_refs_transaction_id;
	}
	public void setNtry_refs_transaction_id(String ntry_refs_transaction_id) {
		this.ntry_refs_transaction_id = ntry_refs_transaction_id;
	}
	public String getNtry_refs_uetr() {
		return ntry_refs_uetr;
	}
	public void setNtry_refs_uetr(String ntry_refs_uetr) {
		this.ntry_refs_uetr = ntry_refs_uetr;
	}
	public BigDecimal getNtry_transaction_amount() {
		return ntry_transaction_amount;
	}
	public void setNtry_transaction_amount(BigDecimal ntry_transaction_amount) {
		this.ntry_transaction_amount = ntry_transaction_amount;
	}
	public BigDecimal getNtry_txdtls_amount_currency() {
		return ntry_txdtls_amount_currency;
	}
	public void setNtry_txdtls_amount_currency(BigDecimal ntry_txdtls_amount_currency) {
		this.ntry_txdtls_amount_currency = ntry_txdtls_amount_currency;
	}
	public String getNtry_txdtls_credit_debit_indicator() {
		return ntry_txdtls_credit_debit_indicator;
	}
	public void setNtry_txdtls_credit_debit_indicator(String ntry_txdtls_credit_debit_indicator) {
		this.ntry_txdtls_credit_debit_indicator = ntry_txdtls_credit_debit_indicator;
	}
	public Date getNtry_value_date() {
		return ntry_value_date;
	}
	public void setNtry_value_date(Date ntry_value_date) {
		this.ntry_value_date = ntry_value_date;
	}
	public String getNtry_value_date_time() {
		return ntry_value_date_time;
	}
	public void setNtry_value_date_time(String ntry_value_date_time) {
		this.ntry_value_date_time = ntry_value_date_time;
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
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}
	public Date getReport_from_date() {
		return report_from_date;
	}
	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}
	public String getReport_name() {
		return report_name;
	}
	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}
	public Date getReport_to_date() {
		return report_to_date;
	}
	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
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
	public String getSignaturemethod_algorithm() {
		return signaturemethod_algorithm;
	}
	public void setSignaturemethod_algorithm(String signaturemethod_algorithm) {
		this.signaturemethod_algorithm = signaturemethod_algorithm;
	}
	public String getSignature_keyinfo_x509_certificate() {
		return signature_keyinfo_x509_certificate;
	}
	public void setSignature_keyinfo_x509_certificate(String signature_keyinfo_x509_certificate) {
		this.signature_keyinfo_x509_certificate = signature_keyinfo_x509_certificate;
	}
	public String getSignature_keyinfo_x509_subject_name() {
		return signature_keyinfo_x509_subject_name;
	}
	public void setSignature_keyinfo_x509_subject_name(String signature_keyinfo_x509_subject_name) {
		this.signature_keyinfo_x509_subject_name = signature_keyinfo_x509_subject_name;
	}
	public String getSignature_signedinfo_digest_value() {
		return signature_signedinfo_digest_value;
	}
	public void setSignature_signedinfo_digest_value(String signature_signedinfo_digest_value) {
		this.signature_signedinfo_digest_value = signature_signedinfo_digest_value;
	}
	public String getSignature_signedinfo_signature_value() {
		return signature_signedinfo_signature_value;
	}
	public void setSignature_signedinfo_signature_value(String signature_signedinfo_signature_value) {
		this.signature_signedinfo_signature_value = signature_signedinfo_signature_value;
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
	public String getSrlno() {
		return srlno;
	}
	public void setSrlno(String srlno) {
		this.srlno = srlno;
	}
	public String getStmt_account_identifier() {
		return stmt_account_identifier;
	}
	public void setStmt_account_identifier(String stmt_account_identifier) {
		this.stmt_account_identifier = stmt_account_identifier;
	}
	public BigDecimal getStmt_bal1_amount() {
		return stmt_bal1_amount;
	}
	public void setStmt_bal1_amount(BigDecimal stmt_bal1_amount) {
		this.stmt_bal1_amount = stmt_bal1_amount;
	}
	public String getStmt_bal1_code_or_proprietary() {
		return stmt_bal1_code_or_proprietary;
	}
	public void setStmt_bal1_code_or_proprietary(String stmt_bal1_code_or_proprietary) {
		this.stmt_bal1_code_or_proprietary = stmt_bal1_code_or_proprietary;
	}
	public String getStmt_bal1_credit_debit_indicator() {
		return stmt_bal1_credit_debit_indicator;
	}
	public void setStmt_bal1_credit_debit_indicator(String stmt_bal1_credit_debit_indicator) {
		this.stmt_bal1_credit_debit_indicator = stmt_bal1_credit_debit_indicator;
	}
	public Date getStmt_bal1_date() {
		return stmt_bal1_date;
	}
	public void setStmt_bal1_date(Date stmt_bal1_date) {
		this.stmt_bal1_date = stmt_bal1_date;
	}
	public Date getStmt_bal1_date_time() {
		return stmt_bal1_date_time;
	}
	public void setStmt_bal1_date_time(Date stmt_bal1_date_time) {
		this.stmt_bal1_date_time = stmt_bal1_date_time;
	}
	public BigDecimal getStmt_bal_amount() {
		return stmt_bal_amount;
	}
	public void setStmt_bal_amount(BigDecimal stmt_bal_amount) {
		this.stmt_bal_amount = stmt_bal_amount;
	}
	public String getStmt_bal_code_or_proprietary() {
		return stmt_bal_code_or_proprietary;
	}
	public void setStmt_bal_code_or_proprietary(String stmt_bal_code_or_proprietary) {
		this.stmt_bal_code_or_proprietary = stmt_bal_code_or_proprietary;
	}
	public String getStmt_bal_credit_debit_indicator() {
		return stmt_bal_credit_debit_indicator;
	}
	public void setStmt_bal_credit_debit_indicator(String stmt_bal_credit_debit_indicator) {
		this.stmt_bal_credit_debit_indicator = stmt_bal_credit_debit_indicator;
	}
	public Date getStmt_bal_date() {
		return stmt_bal_date;
	}
	public void setStmt_bal_date(Date stmt_bal_date) {
		this.stmt_bal_date = stmt_bal_date;
	}
	public Date getStmt_bal_date_time() {
		return stmt_bal_date_time;
	}
	public void setStmt_bal_date_time(Date stmt_bal_date_time) {
		this.stmt_bal_date_time = stmt_bal_date_time;
	}
	public Date getStmt_creation_date_time() {
		return stmt_creation_date_time;
	}
	public void setStmt_creation_date_time(Date stmt_creation_date_time) {
		this.stmt_creation_date_time = stmt_creation_date_time;
	}
	public BigDecimal getStmt_electronic_sequence_number() {
		return stmt_electronic_sequence_number;
	}
	public void setStmt_electronic_sequence_number(BigDecimal stmt_electronic_sequence_number) {
		this.stmt_electronic_sequence_number = stmt_electronic_sequence_number;
	}
	public Date getStmt_from_date_time() {
		return stmt_from_date_time;
	}
	public void setStmt_from_date_time(Date stmt_from_date_time) {
		this.stmt_from_date_time = stmt_from_date_time;
	}
	public String getStmt_related_account_identifier() {
		return stmt_related_account_identifier;
	}
	public void setStmt_related_account_identifier(String stmt_related_account_identifier) {
		this.stmt_related_account_identifier = stmt_related_account_identifier;
	}
	public String getStmt_statement_identifier() {
		return stmt_statement_identifier;
	}
	public void setStmt_statement_identifier(String stmt_statement_identifier) {
		this.stmt_statement_identifier = stmt_statement_identifier;
	}
	public Date getStmt_to_date_time() {
		return stmt_to_date_time;
	}
	public void setStmt_to_date_time(Date stmt_to_date_time) {
		this.stmt_to_date_time = stmt_to_date_time;
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
	public String getTod_entity_id() {
		return tod_entity_id;
	}
	public void setTod_entity_id(String tod_entity_id) {
		this.tod_entity_id = tod_entity_id;
	}
	public String getTod_entity_type() {
		return tod_entity_type;
	}
	public void setTod_entity_type(String tod_entity_type) {
		this.tod_entity_type = tod_entity_type;
	}
	public String getTransaction_currency() {
		return transaction_currency;
	}
	public void setTransaction_currency(String transaction_currency) {
		this.transaction_currency = transaction_currency;
	}
	public String getTransform_algorithm() {
		return transform_algorithm;
	}
	public void setTransform_algorithm(String transform_algorithm) {
		this.transform_algorithm = transform_algorithm;
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
	public BigDecimal getTxssummry_amount() {
		return txssummry_amount;
	}
	public void setTxssummry_amount(BigDecimal txssummry_amount) {
		this.txssummry_amount = txssummry_amount;
	}
	public String getTxssummry_credit_debit_indicator() {
		return txssummry_credit_debit_indicator;
	}
	public void setTxssummry_credit_debit_indicator(String txssummry_credit_debit_indicator) {
		this.txssummry_credit_debit_indicator = txssummry_credit_debit_indicator;
	}
	public BigDecimal getTxssummry_credit_number_of_entries() {
		return txssummry_credit_number_of_entries;
	}
	public void setTxssummry_credit_number_of_entries(BigDecimal txssummry_credit_number_of_entries) {
		this.txssummry_credit_number_of_entries = txssummry_credit_number_of_entries;
	}
	public BigDecimal getTxssummry_credit_sum() {
		return txssummry_credit_sum;
	}
	public void setTxssummry_credit_sum(BigDecimal txssummry_credit_sum) {
		this.txssummry_credit_sum = txssummry_credit_sum;
	}
	public BigDecimal getTxssummry_debit_number_of_entries() {
		return txssummry_debit_number_of_entries;
	}
	public void setTxssummry_debit_number_of_entries(BigDecimal txssummry_debit_number_of_entries) {
		this.txssummry_debit_number_of_entries = txssummry_debit_number_of_entries;
	}
	public BigDecimal getTxssummry_debit_sum() {
		return txssummry_debit_sum;
	}
	public void setTxssummry_debit_sum(BigDecimal txssummry_debit_sum) {
		this.txssummry_debit_sum = txssummry_debit_sum;
	}
	public BigDecimal getTxssummry_number_of_entries() {
		return txssummry_number_of_entries;
	}
	public void setTxssummry_number_of_entries(BigDecimal txssummry_number_of_entries) {
		this.txssummry_number_of_entries = txssummry_number_of_entries;
	}
	public BigDecimal getTxssummry_sum() {
		return txssummry_sum;
	}
	public void setTxssummry_sum(BigDecimal txssummry_sum) {
		this.txssummry_sum = txssummry_sum;
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
	public Date getVerify_time() {
		return verify_time;
	}
	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}
	public String getVerify_user() {
		return verify_user;
	}
	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
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
	public BRECON_Common_Table_Entity(String account_no, String acid, String amt_reservation_ind, String bank_code,
			String bank_id, String bkdt_tran_flg, String br_code, String canonicalizationmethod_algorithm,
			Date create_time, String create_user, String crncy_code, String crncy_hol_chk_done_flg, String cust_id,
			String del_flg, String del_memo_pad, String digestmethod_algorithm, String dth_init_sol_id,
			String eabfab_upd_flg, String entity_flg, Date entry_date, String entry_user_id, BigDecimal fx_tran_amt,
			Date gl_date, String gl_segment_string, String gl_sub_head_code, String grphdr_bank_identifier_code,
			Date grphdr_creation_date_time, String grphdr_last_page_indicator, String grphdr_message_identifier,
			String grphdr_name, BigDecimal grphdr_page_number, String gst_upd_flg, String impl_cash_part_tran_flg,
			String instrmnt_alpha, Date instrmnt_date, String instrmnt_num, String instrmnt_type, String iso_flg,
			Date lchg_time, String lchg_user_id, String lift_lien_flg, String modify_flg, Date modify_time,
			String modify_user, String module_id, String mud_pool_bal_build_flg, String navigation_flg,
			String ntry_account_servicer_reference, BigDecimal ntry_amount_currency, Date ntry_booking_date,
			Date ntry_booking_date_time, String ntry_brch_cdtdbtint, String ntry_btch_currency, String ntry_btch_msg_id,
			BigDecimal ntry_btch_numoftxs, BigDecimal ntry_btch_ttlamt, String ntry_cdtragt_bicfi_credit,
			String ntry_code, String ntry_credit_debit_indicator, String ntry_dbtragt_bicfi_debit,
			String ntry_entry_reference, String ntry_fininstnid_bicfi, BigDecimal ntry_instructed_amount,
			String ntry_proprietary_code, String ntry_refs_account_servicer_reference,
			String ntry_refs_clearing_system_reference, String ntry_refs_end_to_end_identification,
			String ntry_refs_instruction_id, String ntry_refs_message_identifier, String ntry_refs_pmtinfid,
			String ntry_refs_transaction_id, String ntry_refs_uetr, BigDecimal ntry_transaction_amount,
			BigDecimal ntry_txdtls_amount_currency, String ntry_txdtls_credit_debit_indicator, Date ntry_value_date,
			String ntry_value_date_time, String party_code, String part_tran_srl_num, String part_tran_type,
			BigDecimal principal_portion_amt, String prnt_advc_ind, String proxy_acid, String proxy_post_ind,
			String pr_srl_num, Date pstd_date, String pstd_flg, String pstd_user_id, String ptran_chrg_exists_flg,
			String pttm_event_type, BigDecimal rate, String rate_code, Date rcre_time, String rcre_user_id,
			Date recon_date, String recon_flag, String referral_id, BigDecimal ref_amt, String ref_crncy_code,
			String ref_num, BigDecimal regularization_amt, Date report_date, Date report_from_date, String report_name,
			Date report_to_date, BigDecimal reservation_amt, String restrict_modify_ind, Date reversal_date,
			Date reversal_value_date, String rpt_code, String serial_num, String signaturemethod_algorithm,
			String signature_keyinfo_x509_certificate, String signature_keyinfo_x509_subject_name,
			String signature_signedinfo_digest_value, String signature_signedinfo_signature_value,
			Date si_org_exec_date, String si_srl_num, String sol_id, String srlno, String stmt_account_identifier,
			BigDecimal stmt_bal1_amount, String stmt_bal1_code_or_proprietary, String stmt_bal1_credit_debit_indicator,
			Date stmt_bal1_date, Date stmt_bal1_date_time, BigDecimal stmt_bal_amount,
			String stmt_bal_code_or_proprietary, String stmt_bal_credit_debit_indicator, Date stmt_bal_date,
			Date stmt_bal_date_time, Date stmt_creation_date_time, BigDecimal stmt_electronic_sequence_number,
			Date stmt_from_date_time, String stmt_related_account_identifier, String stmt_statement_identifier,
			Date stmt_to_date_time, String svs_tran_id, String sys_part_tran_code, String tf_entity_sol_id,
			String tod_entity_id, String tod_entity_type, String transaction_currency, String transform_algorithm,
			BigDecimal tran_amt, String tran_crncy_code, Date tran_date, String tran_free_code1, String tran_free_code2,
			String tran_id, String tran_particular, String tran_particular_2, String tran_particular_code,
			String tran_rmks, String tran_sub_type, String tran_type, BigDecimal trea_rate, String trea_ref_num,
			String tr_status, BigDecimal ts_cnt, BigDecimal txssummry_amount, String txssummry_credit_debit_indicator,
			BigDecimal txssummry_credit_number_of_entries, BigDecimal txssummry_credit_sum,
			BigDecimal txssummry_debit_number_of_entries, BigDecimal txssummry_debit_sum,
			BigDecimal txssummry_number_of_entries, BigDecimal txssummry_sum, String uad_module_id,
			String uad_module_key, String user_part_tran_code, Date value_date, Date verify_time, String verify_user,
			Date vfd_date, String vfd_user_id, String voucher_print_flg) {
		super();
		this.account_no = account_no;
		this.acid = acid;
		this.amt_reservation_ind = amt_reservation_ind;
		this.bank_code = bank_code;
		this.bank_id = bank_id;
		this.bkdt_tran_flg = bkdt_tran_flg;
		this.br_code = br_code;
		this.canonicalizationmethod_algorithm = canonicalizationmethod_algorithm;
		this.create_time = create_time;
		this.create_user = create_user;
		this.crncy_code = crncy_code;
		this.crncy_hol_chk_done_flg = crncy_hol_chk_done_flg;
		this.cust_id = cust_id;
		this.del_flg = del_flg;
		this.del_memo_pad = del_memo_pad;
		this.digestmethod_algorithm = digestmethod_algorithm;
		this.dth_init_sol_id = dth_init_sol_id;
		this.eabfab_upd_flg = eabfab_upd_flg;
		this.entity_flg = entity_flg;
		this.entry_date = entry_date;
		this.entry_user_id = entry_user_id;
		this.fx_tran_amt = fx_tran_amt;
		this.gl_date = gl_date;
		this.gl_segment_string = gl_segment_string;
		this.gl_sub_head_code = gl_sub_head_code;
		this.grphdr_bank_identifier_code = grphdr_bank_identifier_code;
		this.grphdr_creation_date_time = grphdr_creation_date_time;
		this.grphdr_last_page_indicator = grphdr_last_page_indicator;
		this.grphdr_message_identifier = grphdr_message_identifier;
		this.grphdr_name = grphdr_name;
		this.grphdr_page_number = grphdr_page_number;
		this.gst_upd_flg = gst_upd_flg;
		this.impl_cash_part_tran_flg = impl_cash_part_tran_flg;
		this.instrmnt_alpha = instrmnt_alpha;
		this.instrmnt_date = instrmnt_date;
		this.instrmnt_num = instrmnt_num;
		this.instrmnt_type = instrmnt_type;
		this.iso_flg = iso_flg;
		this.lchg_time = lchg_time;
		this.lchg_user_id = lchg_user_id;
		this.lift_lien_flg = lift_lien_flg;
		this.modify_flg = modify_flg;
		this.modify_time = modify_time;
		this.modify_user = modify_user;
		this.module_id = module_id;
		this.mud_pool_bal_build_flg = mud_pool_bal_build_flg;
		this.navigation_flg = navigation_flg;
		this.ntry_account_servicer_reference = ntry_account_servicer_reference;
		this.ntry_amount_currency = ntry_amount_currency;
		this.ntry_booking_date = ntry_booking_date;
		this.ntry_booking_date_time = ntry_booking_date_time;
		this.ntry_brch_cdtdbtint = ntry_brch_cdtdbtint;
		this.ntry_btch_currency = ntry_btch_currency;
		this.ntry_btch_msg_id = ntry_btch_msg_id;
		this.ntry_btch_numoftxs = ntry_btch_numoftxs;
		this.ntry_btch_ttlamt = ntry_btch_ttlamt;
		this.ntry_cdtragt_bicfi_credit = ntry_cdtragt_bicfi_credit;
		this.ntry_code = ntry_code;
		this.ntry_credit_debit_indicator = ntry_credit_debit_indicator;
		this.ntry_dbtragt_bicfi_debit = ntry_dbtragt_bicfi_debit;
		this.ntry_entry_reference = ntry_entry_reference;
		this.ntry_fininstnid_bicfi = ntry_fininstnid_bicfi;
		this.ntry_instructed_amount = ntry_instructed_amount;
		this.ntry_proprietary_code = ntry_proprietary_code;
		this.ntry_refs_account_servicer_reference = ntry_refs_account_servicer_reference;
		this.ntry_refs_clearing_system_reference = ntry_refs_clearing_system_reference;
		this.ntry_refs_end_to_end_identification = ntry_refs_end_to_end_identification;
		this.ntry_refs_instruction_id = ntry_refs_instruction_id;
		this.ntry_refs_message_identifier = ntry_refs_message_identifier;
		this.ntry_refs_pmtinfid = ntry_refs_pmtinfid;
		this.ntry_refs_transaction_id = ntry_refs_transaction_id;
		this.ntry_refs_uetr = ntry_refs_uetr;
		this.ntry_transaction_amount = ntry_transaction_amount;
		this.ntry_txdtls_amount_currency = ntry_txdtls_amount_currency;
		this.ntry_txdtls_credit_debit_indicator = ntry_txdtls_credit_debit_indicator;
		this.ntry_value_date = ntry_value_date;
		this.ntry_value_date_time = ntry_value_date_time;
		this.party_code = party_code;
		this.part_tran_srl_num = part_tran_srl_num;
		this.part_tran_type = part_tran_type;
		this.principal_portion_amt = principal_portion_amt;
		this.prnt_advc_ind = prnt_advc_ind;
		this.proxy_acid = proxy_acid;
		this.proxy_post_ind = proxy_post_ind;
		this.pr_srl_num = pr_srl_num;
		this.pstd_date = pstd_date;
		this.pstd_flg = pstd_flg;
		this.pstd_user_id = pstd_user_id;
		this.ptran_chrg_exists_flg = ptran_chrg_exists_flg;
		this.pttm_event_type = pttm_event_type;
		this.rate = rate;
		this.rate_code = rate_code;
		this.rcre_time = rcre_time;
		this.rcre_user_id = rcre_user_id;
		this.recon_date = recon_date;
		this.recon_flag = recon_flag;
		this.referral_id = referral_id;
		this.ref_amt = ref_amt;
		this.ref_crncy_code = ref_crncy_code;
		this.ref_num = ref_num;
		this.regularization_amt = regularization_amt;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_name = report_name;
		this.report_to_date = report_to_date;
		this.reservation_amt = reservation_amt;
		this.restrict_modify_ind = restrict_modify_ind;
		this.reversal_date = reversal_date;
		this.reversal_value_date = reversal_value_date;
		this.rpt_code = rpt_code;
		this.serial_num = serial_num;
		this.signaturemethod_algorithm = signaturemethod_algorithm;
		this.signature_keyinfo_x509_certificate = signature_keyinfo_x509_certificate;
		this.signature_keyinfo_x509_subject_name = signature_keyinfo_x509_subject_name;
		this.signature_signedinfo_digest_value = signature_signedinfo_digest_value;
		this.signature_signedinfo_signature_value = signature_signedinfo_signature_value;
		this.si_org_exec_date = si_org_exec_date;
		this.si_srl_num = si_srl_num;
		this.sol_id = sol_id;
		this.srlno = srlno;
		this.stmt_account_identifier = stmt_account_identifier;
		this.stmt_bal1_amount = stmt_bal1_amount;
		this.stmt_bal1_code_or_proprietary = stmt_bal1_code_or_proprietary;
		this.stmt_bal1_credit_debit_indicator = stmt_bal1_credit_debit_indicator;
		this.stmt_bal1_date = stmt_bal1_date;
		this.stmt_bal1_date_time = stmt_bal1_date_time;
		this.stmt_bal_amount = stmt_bal_amount;
		this.stmt_bal_code_or_proprietary = stmt_bal_code_or_proprietary;
		this.stmt_bal_credit_debit_indicator = stmt_bal_credit_debit_indicator;
		this.stmt_bal_date = stmt_bal_date;
		this.stmt_bal_date_time = stmt_bal_date_time;
		this.stmt_creation_date_time = stmt_creation_date_time;
		this.stmt_electronic_sequence_number = stmt_electronic_sequence_number;
		this.stmt_from_date_time = stmt_from_date_time;
		this.stmt_related_account_identifier = stmt_related_account_identifier;
		this.stmt_statement_identifier = stmt_statement_identifier;
		this.stmt_to_date_time = stmt_to_date_time;
		this.svs_tran_id = svs_tran_id;
		this.sys_part_tran_code = sys_part_tran_code;
		this.tf_entity_sol_id = tf_entity_sol_id;
		this.tod_entity_id = tod_entity_id;
		this.tod_entity_type = tod_entity_type;
		this.transaction_currency = transaction_currency;
		this.transform_algorithm = transform_algorithm;
		this.tran_amt = tran_amt;
		this.tran_crncy_code = tran_crncy_code;
		this.tran_date = tran_date;
		this.tran_free_code1 = tran_free_code1;
		this.tran_free_code2 = tran_free_code2;
		this.tran_id = tran_id;
		this.tran_particular = tran_particular;
		this.tran_particular_2 = tran_particular_2;
		this.tran_particular_code = tran_particular_code;
		this.tran_rmks = tran_rmks;
		this.tran_sub_type = tran_sub_type;
		this.tran_type = tran_type;
		this.trea_rate = trea_rate;
		this.trea_ref_num = trea_ref_num;
		this.tr_status = tr_status;
		this.ts_cnt = ts_cnt;
		this.txssummry_amount = txssummry_amount;
		this.txssummry_credit_debit_indicator = txssummry_credit_debit_indicator;
		this.txssummry_credit_number_of_entries = txssummry_credit_number_of_entries;
		this.txssummry_credit_sum = txssummry_credit_sum;
		this.txssummry_debit_number_of_entries = txssummry_debit_number_of_entries;
		this.txssummry_debit_sum = txssummry_debit_sum;
		this.txssummry_number_of_entries = txssummry_number_of_entries;
		this.txssummry_sum = txssummry_sum;
		this.uad_module_id = uad_module_id;
		this.uad_module_key = uad_module_key;
		this.user_part_tran_code = user_part_tran_code;
		this.value_date = value_date;
		this.verify_time = verify_time;
		this.verify_user = verify_user;
		this.vfd_date = vfd_date;
		this.vfd_user_id = vfd_user_id;
		this.voucher_print_flg = voucher_print_flg;
	}
	public BRECON_Common_Table_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
