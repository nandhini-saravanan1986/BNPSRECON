package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="BRECON_DESTINATION_TABLE")
public class BRECON_DESTINATION_ENTITY {
	private String	account_no;
	private String	grphdr_message_identifier;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	grphdr_creation_date_time;
	private String	grphdr_name;
	private String	grphdr_bank_identifier_code;
	private BigDecimal	grphdr_page_number;
	private String	grphdr_last_page_indicator;
	private String	stmt_statement_identifier;
	private BigDecimal	stmt_electronic_sequence_number;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	stmt_creation_date_time;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	stmt_from_date_time;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	stmt_to_date_time;
	private String	stmt_account_identifier;
	private String	stmt_related_account_identifier;
	private String	stmt_bal_code_or_proprietary;
	private BigDecimal	stmt_bal_amount;
	private String	stmt_bal_credit_debit_indicator;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	stmt_bal_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	stmt_bal_date_time;
	private BigDecimal	txssummry_number_of_entries;
	private BigDecimal	txssummry_sum;
	private BigDecimal	txssummry_amount;
	private String	txssummry_credit_debit_indicator;
	private BigDecimal	txssummry_credit_number_of_entries;
	private BigDecimal	txssummry_credit_sum;
	private BigDecimal	txssummry_debit_number_of_entries;
	private BigDecimal	txssummry_debit_sum;
	private String	ntry_entry_reference;
	private BigDecimal	ntry_amount_currency;
	private String	ntry_credit_debit_indicator;
	private String	ntry_code;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ntry_booking_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ntry_booking_date_time;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	ntry_value_date;
	private String	ntry_value_date_time;
	private String	ntry_account_servicer_reference;
	private String	ntry_proprietary_code;
	private BigDecimal	ntry_instructed_amount;
	private BigDecimal	ntry_transaction_amount;
	private String	ntry_refs_message_identifier;
	private String	ntry_refs_account_servicer_reference;
	private String	ntry_refs_instruction_id;
	private String	ntry_refs_end_to_end_identification;
	private String	ntry_refs_transaction_id;
	private String	ntry_refs_clearing_system_reference;
	private BigDecimal	ntry_txdtls_amount_currency;
	private String	ntry_txdtls_credit_debit_indicator;
	private String	ntry_fininstnid_bicfi;
	private String	ntry_dbtragt_bicfi_debit;
	private String	ntry_cdtragt_bicfi_credit;
	private String	signature_signedinfo_digest_value;
	private String	signature_signedinfo_signature_value;
	private String	signature_keyinfo_x509_subject_name;
	private String	signature_keyinfo_x509_certificate;
	private String	canonicalizationmethod_algorithm;
	private String	signaturemethod_algorithm;
	private String	transform_algorithm;
	private String	digestmethod_algorithm;
	private String	report_name;
	private String	ntry_btch_msg_id;
	private BigDecimal	ntry_btch_numoftxs;
	private BigDecimal	ntry_btch_ttlamt;
	private String	ntry_brch_cdtdbtint;
	private String	ntry_refs_pmtinfid;
	private String	ntry_refs_uetr;
	private String	create_user;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	create_time;
	private String	modify_user;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	modify_time;
	private String	verify_user;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	verify_time;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	@Id
	private String	srlno;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	report_from_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	report_to_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	report_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	recon_date;
	private String	recon_flag;
	private String	ntry_btch_currency;
	private String	stmt_bal1_code_or_proprietary;
	private BigDecimal	stmt_bal1_amount;
	private String	stmt_bal1_credit_debit_indicator;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	stmt_bal1_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date	stmt_bal1_date_time;
	private String	transaction_currency;
	public String getAccount_no() {
		return account_no;
	}
	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}
	public String getGrphdr_message_identifier() {
		return grphdr_message_identifier;
	}
	public void setGrphdr_message_identifier(String grphdr_message_identifier) {
		this.grphdr_message_identifier = grphdr_message_identifier;
	}
	public Date getGrphdr_creation_date_time() {
		return grphdr_creation_date_time;
	}
	public void setGrphdr_creation_date_time(Date grphdr_creation_date_time) {
		this.grphdr_creation_date_time = grphdr_creation_date_time;
	}
	public String getGrphdr_name() {
		return grphdr_name;
	}
	public void setGrphdr_name(String grphdr_name) {
		this.grphdr_name = grphdr_name;
	}
	public String getGrphdr_bank_identifier_code() {
		return grphdr_bank_identifier_code;
	}
	public void setGrphdr_bank_identifier_code(String grphdr_bank_identifier_code) {
		this.grphdr_bank_identifier_code = grphdr_bank_identifier_code;
	}
	public BigDecimal getGrphdr_page_number() {
		return grphdr_page_number;
	}
	public void setGrphdr_page_number(BigDecimal grphdr_page_number) {
		this.grphdr_page_number = grphdr_page_number;
	}
	public String getGrphdr_last_page_indicator() {
		return grphdr_last_page_indicator;
	}
	public void setGrphdr_last_page_indicator(String grphdr_last_page_indicator) {
		this.grphdr_last_page_indicator = grphdr_last_page_indicator;
	}
	public String getStmt_statement_identifier() {
		return stmt_statement_identifier;
	}
	public void setStmt_statement_identifier(String stmt_statement_identifier) {
		this.stmt_statement_identifier = stmt_statement_identifier;
	}
	public BigDecimal getStmt_electronic_sequence_number() {
		return stmt_electronic_sequence_number;
	}
	public void setStmt_electronic_sequence_number(BigDecimal stmt_electronic_sequence_number) {
		this.stmt_electronic_sequence_number = stmt_electronic_sequence_number;
	}
	public Date getStmt_creation_date_time() {
		return stmt_creation_date_time;
	}
	public void setStmt_creation_date_time(Date stmt_creation_date_time) {
		this.stmt_creation_date_time = stmt_creation_date_time;
	}
	public Date getStmt_from_date_time() {
		return stmt_from_date_time;
	}
	public void setStmt_from_date_time(Date stmt_from_date_time) {
		this.stmt_from_date_time = stmt_from_date_time;
	}
	public Date getStmt_to_date_time() {
		return stmt_to_date_time;
	}
	public void setStmt_to_date_time(Date stmt_to_date_time) {
		this.stmt_to_date_time = stmt_to_date_time;
	}
	public String getStmt_account_identifier() {
		return stmt_account_identifier;
	}
	public void setStmt_account_identifier(String stmt_account_identifier) {
		this.stmt_account_identifier = stmt_account_identifier;
	}
	public String getStmt_related_account_identifier() {
		return stmt_related_account_identifier;
	}
	public void setStmt_related_account_identifier(String stmt_related_account_identifier) {
		this.stmt_related_account_identifier = stmt_related_account_identifier;
	}
	public String getStmt_bal_code_or_proprietary() {
		return stmt_bal_code_or_proprietary;
	}
	public void setStmt_bal_code_or_proprietary(String stmt_bal_code_or_proprietary) {
		this.stmt_bal_code_or_proprietary = stmt_bal_code_or_proprietary;
	}
	public BigDecimal getStmt_bal_amount() {
		return stmt_bal_amount;
	}
	public void setStmt_bal_amount(BigDecimal stmt_bal_amount) {
		this.stmt_bal_amount = stmt_bal_amount;
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
	public String getNtry_entry_reference() {
		return ntry_entry_reference;
	}
	public void setNtry_entry_reference(String ntry_entry_reference) {
		this.ntry_entry_reference = ntry_entry_reference;
	}
	public BigDecimal getNtry_amount_currency() {
		return ntry_amount_currency;
	}
	public void setNtry_amount_currency(BigDecimal ntry_amount_currency) {
		this.ntry_amount_currency = ntry_amount_currency;
	}
	public String getNtry_credit_debit_indicator() {
		return ntry_credit_debit_indicator;
	}
	public void setNtry_credit_debit_indicator(String ntry_credit_debit_indicator) {
		this.ntry_credit_debit_indicator = ntry_credit_debit_indicator;
	}
	public String getNtry_code() {
		return ntry_code;
	}
	public void setNtry_code(String ntry_code) {
		this.ntry_code = ntry_code;
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
	public String getNtry_account_servicer_reference() {
		return ntry_account_servicer_reference;
	}
	public void setNtry_account_servicer_reference(String ntry_account_servicer_reference) {
		this.ntry_account_servicer_reference = ntry_account_servicer_reference;
	}
	public String getNtry_proprietary_code() {
		return ntry_proprietary_code;
	}
	public void setNtry_proprietary_code(String ntry_proprietary_code) {
		this.ntry_proprietary_code = ntry_proprietary_code;
	}
	public BigDecimal getNtry_instructed_amount() {
		return ntry_instructed_amount;
	}
	public void setNtry_instructed_amount(BigDecimal ntry_instructed_amount) {
		this.ntry_instructed_amount = ntry_instructed_amount;
	}
	public BigDecimal getNtry_transaction_amount() {
		return ntry_transaction_amount;
	}
	public void setNtry_transaction_amount(BigDecimal ntry_transaction_amount) {
		this.ntry_transaction_amount = ntry_transaction_amount;
	}
	public String getNtry_refs_message_identifier() {
		return ntry_refs_message_identifier;
	}
	public void setNtry_refs_message_identifier(String ntry_refs_message_identifier) {
		this.ntry_refs_message_identifier = ntry_refs_message_identifier;
	}
	public String getNtry_refs_account_servicer_reference() {
		return ntry_refs_account_servicer_reference;
	}
	public void setNtry_refs_account_servicer_reference(String ntry_refs_account_servicer_reference) {
		this.ntry_refs_account_servicer_reference = ntry_refs_account_servicer_reference;
	}
	public String getNtry_refs_instruction_id() {
		return ntry_refs_instruction_id;
	}
	public void setNtry_refs_instruction_id(String ntry_refs_instruction_id) {
		this.ntry_refs_instruction_id = ntry_refs_instruction_id;
	}
	public String getNtry_refs_end_to_end_identification() {
		return ntry_refs_end_to_end_identification;
	}
	public void setNtry_refs_end_to_end_identification(String ntry_refs_end_to_end_identification) {
		this.ntry_refs_end_to_end_identification = ntry_refs_end_to_end_identification;
	}
	public String getNtry_refs_transaction_id() {
		return ntry_refs_transaction_id;
	}
	public void setNtry_refs_transaction_id(String ntry_refs_transaction_id) {
		this.ntry_refs_transaction_id = ntry_refs_transaction_id;
	}
	public String getNtry_refs_clearing_system_reference() {
		return ntry_refs_clearing_system_reference;
	}
	public void setNtry_refs_clearing_system_reference(String ntry_refs_clearing_system_reference) {
		this.ntry_refs_clearing_system_reference = ntry_refs_clearing_system_reference;
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
	public String getNtry_fininstnid_bicfi() {
		return ntry_fininstnid_bicfi;
	}
	public void setNtry_fininstnid_bicfi(String ntry_fininstnid_bicfi) {
		this.ntry_fininstnid_bicfi = ntry_fininstnid_bicfi;
	}
	public String getNtry_dbtragt_bicfi_debit() {
		return ntry_dbtragt_bicfi_debit;
	}
	public void setNtry_dbtragt_bicfi_debit(String ntry_dbtragt_bicfi_debit) {
		this.ntry_dbtragt_bicfi_debit = ntry_dbtragt_bicfi_debit;
	}
	public String getNtry_cdtragt_bicfi_credit() {
		return ntry_cdtragt_bicfi_credit;
	}
	public void setNtry_cdtragt_bicfi_credit(String ntry_cdtragt_bicfi_credit) {
		this.ntry_cdtragt_bicfi_credit = ntry_cdtragt_bicfi_credit;
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
	public String getSignature_keyinfo_x509_subject_name() {
		return signature_keyinfo_x509_subject_name;
	}
	public void setSignature_keyinfo_x509_subject_name(String signature_keyinfo_x509_subject_name) {
		this.signature_keyinfo_x509_subject_name = signature_keyinfo_x509_subject_name;
	}
	public String getSignature_keyinfo_x509_certificate() {
		return signature_keyinfo_x509_certificate;
	}
	public void setSignature_keyinfo_x509_certificate(String signature_keyinfo_x509_certificate) {
		this.signature_keyinfo_x509_certificate = signature_keyinfo_x509_certificate;
	}
	public String getCanonicalizationmethod_algorithm() {
		return canonicalizationmethod_algorithm;
	}
	public void setCanonicalizationmethod_algorithm(String canonicalizationmethod_algorithm) {
		this.canonicalizationmethod_algorithm = canonicalizationmethod_algorithm;
	}
	public String getSignaturemethod_algorithm() {
		return signaturemethod_algorithm;
	}
	public void setSignaturemethod_algorithm(String signaturemethod_algorithm) {
		this.signaturemethod_algorithm = signaturemethod_algorithm;
	}
	public String getTransform_algorithm() {
		return transform_algorithm;
	}
	public void setTransform_algorithm(String transform_algorithm) {
		this.transform_algorithm = transform_algorithm;
	}
	public String getDigestmethod_algorithm() {
		return digestmethod_algorithm;
	}
	public void setDigestmethod_algorithm(String digestmethod_algorithm) {
		this.digestmethod_algorithm = digestmethod_algorithm;
	}
	public String getReport_name() {
		return report_name;
	}
	public void setReport_name(String report_name) {
		this.report_name = report_name;
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
	public String getNtry_brch_cdtdbtint() {
		return ntry_brch_cdtdbtint;
	}
	public void setNtry_brch_cdtdbtint(String ntry_brch_cdtdbtint) {
		this.ntry_brch_cdtdbtint = ntry_brch_cdtdbtint;
	}
	public String getNtry_refs_pmtinfid() {
		return ntry_refs_pmtinfid;
	}
	public void setNtry_refs_pmtinfid(String ntry_refs_pmtinfid) {
		this.ntry_refs_pmtinfid = ntry_refs_pmtinfid;
	}
	public String getNtry_refs_uetr() {
		return ntry_refs_uetr;
	}
	public void setNtry_refs_uetr(String ntry_refs_uetr) {
		this.ntry_refs_uetr = ntry_refs_uetr;
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
	public String getDel_flg() {
		return del_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public String getSrlno() {
		return srlno;
	}
	public void setSrlno(String srlno) {
		this.srlno = srlno;
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
	public String getNtry_btch_currency() {
		return ntry_btch_currency;
	}
	public void setNtry_btch_currency(String ntry_btch_currency) {
		this.ntry_btch_currency = ntry_btch_currency;
	}
	public String getStmt_bal1_code_or_proprietary() {
		return stmt_bal1_code_or_proprietary;
	}
	public void setStmt_bal1_code_or_proprietary(String stmt_bal1_code_or_proprietary) {
		this.stmt_bal1_code_or_proprietary = stmt_bal1_code_or_proprietary;
	}
	public BigDecimal getStmt_bal1_amount() {
		return stmt_bal1_amount;
	}
	public void setStmt_bal1_amount(BigDecimal stmt_bal1_amount) {
		this.stmt_bal1_amount = stmt_bal1_amount;
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
	public String getTransaction_currency() {
		return transaction_currency;
	}
	public void setTransaction_currency(String transaction_currency) {
		this.transaction_currency = transaction_currency;
	}
	public BRECON_DESTINATION_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}