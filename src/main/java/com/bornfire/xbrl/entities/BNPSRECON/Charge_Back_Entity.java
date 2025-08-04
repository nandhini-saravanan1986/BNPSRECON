package com.bornfire.xbrl.entities.BNPSRECON;

import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;


@Entity
@Table(name = "CHARGE_BACK")
public class Charge_Back_Entity {
	@Id
	private String	srlno;
	private BigDecimal	mti;
	private BigDecimal	mti_2;
	private String	mti_3;
	private BigDecimal	function_code;
	private BigDecimal	function_code_2;
	private BigDecimal	function_code_3;
	private String	record_number;
	private String	record_number_2;
	private String	record_number_3;
	private BigDecimal	date_and_time_local_transaction;
	private BigDecimal	primary_account_number;
	private BigDecimal	acquirer_reference_data;
	private BigDecimal	acquirer_institution_id_code;
	private BigDecimal	approval_code;
	private String	card_acceptor_terminal_id;
	private BigDecimal	amount_transaction;
	private BigDecimal	currency_code_transaction;
	private BigDecimal	amounts_additional;
	private String	transaction_originator_institution_id_code;
	private String	transaction_destination_institution_id_code;
	private String	unique_file_name;
	private BigDecimal	message_reason_code;
	private String	internal_tracking_number;
	private String	member_message_text;
	private String	document_indicator;
	private String	full_partial_indicator;
	private String	case_number;
	private BigDecimal	date_settlement;
	private String	settlement_dr_cr_indicator;
	private BigDecimal	amount_settlement;
	private BigDecimal	currency_code_settlement;
	private BigDecimal	conversion_rate_settlement;
	private BigDecimal	amount_billing;
	private BigDecimal	conversion_rate_billing;
	private BigDecimal	currency_code_billing;
	private BigDecimal	original_settlement_date;
	private String	fee_type_code_1;
	private BigDecimal	interchange_category_1;
	private BigDecimal	fee_amount_1;
	private String	fee_dr_cr_indicator_1;
	private BigDecimal	fee_currency_1;
	private String	processing_status;
	private BigDecimal	maucas_cps_record_reject_reason_code;
	private BigDecimal	card_acceptor_business_code;
	private String	card_acceptor_name;
	private BigDecimal	date_and_time_file_genereted;
	private String	member_institution_id_code;
	private String	product_code;
	private String	settlement_bin;
	private String	file_categoty;
	private String	version_number;
	private String	late_presentment_indicator;
	private String	rgcsrcvddt;
	private String	card_acceptor_additional_address;
	private String	report_name;
	private String	transactions_count;
	private BigDecimal	run_total_amount;
	private BigDecimal	retrieval_reference_number;
	private BigDecimal	maucas_cps_received_date;
	private String	additional_data;
	private String	additional_transaction_data;
	private String	entire_file_reject_indicator;
	private BigDecimal	file_reject_reason_code;
	private BigDecimal	control_number;
	private BigDecimal	processing_code;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date report_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_from_date;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	
	public String getSrlno() {
		return srlno;
	}
	public void setSrlno(String srlno) {
		this.srlno = srlno;
	}
	public BigDecimal getMti() {
		return mti;
	}
	public void setMti(BigDecimal mti) {
		this.mti = mti;
	}
	public BigDecimal getMti_2() {
		return mti_2;
	}
	public void setMti_2(BigDecimal mti_2) {
		this.mti_2 = mti_2;
	}
	public String getMti_3() {
		return mti_3;
	}
	public void setMti_3(String mti_3) {
		this.mti_3 = mti_3;
	}
	public BigDecimal getFunction_code() {
		return function_code;
	}
	public void setFunction_code(BigDecimal function_code) {
		this.function_code = function_code;
	}
	public BigDecimal getFunction_code_2() {
		return function_code_2;
	}
	public void setFunction_code_2(BigDecimal function_code_2) {
		this.function_code_2 = function_code_2;
	}
	public BigDecimal getFunction_code_3() {
		return function_code_3;
	}
	public void setFunction_code_3(BigDecimal function_code_3) {
		this.function_code_3 = function_code_3;
	}
	public String getRecord_number() {
		return record_number;
	}
	public void setRecord_number(String record_number) {
		this.record_number = record_number;
	}
	public String getRecord_number_2() {
		return record_number_2;
	}
	public void setRecord_number_2(String record_number_2) {
		this.record_number_2 = record_number_2;
	}
	public String getRecord_number_3() {
		return record_number_3;
	}
	public void setRecord_number_3(String record_number_3) {
		this.record_number_3 = record_number_3;
	}
	public BigDecimal getDate_and_time_local_transaction() {
		return date_and_time_local_transaction;
	}
	public void setDate_and_time_local_transaction(BigDecimal date_and_time_local_transaction) {
		this.date_and_time_local_transaction = date_and_time_local_transaction;
	}
	public BigDecimal getPrimary_account_number() {
		return primary_account_number;
	}
	public void setPrimary_account_number(BigDecimal primary_account_number) {
		this.primary_account_number = primary_account_number;
	}
	public BigDecimal getAcquirer_reference_data() {
		return acquirer_reference_data;
	}
	public void setAcquirer_reference_data(BigDecimal acquirer_reference_data) {
		this.acquirer_reference_data = acquirer_reference_data;
	}
	public BigDecimal getAcquirer_institution_id_code() {
		return acquirer_institution_id_code;
	}
	public void setAcquirer_institution_id_code(BigDecimal acquirer_institution_id_code) {
		this.acquirer_institution_id_code = acquirer_institution_id_code;
	}
	public BigDecimal getApproval_code() {
		return approval_code;
	}
	public void setApproval_code(BigDecimal approval_code) {
		this.approval_code = approval_code;
	}
	public String getCard_acceptor_terminal_id() {
		return card_acceptor_terminal_id;
	}
	public void setCard_acceptor_terminal_id(String card_acceptor_terminal_id) {
		this.card_acceptor_terminal_id = card_acceptor_terminal_id;
	}
	public BigDecimal getAmount_transaction() {
		return amount_transaction;
	}
	public void setAmount_transaction(BigDecimal amount_transaction) {
		this.amount_transaction = amount_transaction;
	}
	public BigDecimal getCurrency_code_transaction() {
		return currency_code_transaction;
	}
	public void setCurrency_code_transaction(BigDecimal currency_code_transaction) {
		this.currency_code_transaction = currency_code_transaction;
	}
	public BigDecimal getAmounts_additional() {
		return amounts_additional;
	}
	public void setAmounts_additional(BigDecimal amounts_additional) {
		this.amounts_additional = amounts_additional;
	}
	public String getTransaction_originator_institution_id_code() {
		return transaction_originator_institution_id_code;
	}
	public void setTransaction_originator_institution_id_code(String transaction_originator_institution_id_code) {
		this.transaction_originator_institution_id_code = transaction_originator_institution_id_code;
	}
	public String getTransaction_destination_institution_id_code() {
		return transaction_destination_institution_id_code;
	}
	public void setTransaction_destination_institution_id_code(String transaction_destination_institution_id_code) {
		this.transaction_destination_institution_id_code = transaction_destination_institution_id_code;
	}
	public String getUnique_file_name() {
		return unique_file_name;
	}
	public void setUnique_file_name(String unique_file_name) {
		this.unique_file_name = unique_file_name;
	}
	public BigDecimal getMessage_reason_code() {
		return message_reason_code;
	}
	public void setMessage_reason_code(BigDecimal message_reason_code) {
		this.message_reason_code = message_reason_code;
	}
	public String getInternal_tracking_number() {
		return internal_tracking_number;
	}
	public void setInternal_tracking_number(String internal_tracking_number) {
		this.internal_tracking_number = internal_tracking_number;
	}
	public String getMember_message_text() {
		return member_message_text;
	}
	public void setMember_message_text(String member_message_text) {
		this.member_message_text = member_message_text;
	}
	public String getDocument_indicator() {
		return document_indicator;
	}
	public void setDocument_indicator(String document_indicator) {
		this.document_indicator = document_indicator;
	}
	public String getFull_partial_indicator() {
		return full_partial_indicator;
	}
	public void setFull_partial_indicator(String full_partial_indicator) {
		this.full_partial_indicator = full_partial_indicator;
	}
	public String getCase_number() {
		return case_number;
	}
	public void setCase_number(String case_number) {
		this.case_number = case_number;
	}
	public BigDecimal getDate_settlement() {
		return date_settlement;
	}
	public void setDate_settlement(BigDecimal date_settlement) {
		this.date_settlement = date_settlement;
	}
	public String getSettlement_dr_cr_indicator() {
		return settlement_dr_cr_indicator;
	}
	public void setSettlement_dr_cr_indicator(String settlement_dr_cr_indicator) {
		this.settlement_dr_cr_indicator = settlement_dr_cr_indicator;
	}
	public BigDecimal getAmount_settlement() {
		return amount_settlement;
	}
	public void setAmount_settlement(BigDecimal amount_settlement) {
		this.amount_settlement = amount_settlement;
	}
	public BigDecimal getCurrency_code_settlement() {
		return currency_code_settlement;
	}
	public void setCurrency_code_settlement(BigDecimal currency_code_settlement) {
		this.currency_code_settlement = currency_code_settlement;
	}
	public BigDecimal getConversion_rate_settlement() {
		return conversion_rate_settlement;
	}
	public void setConversion_rate_settlement(BigDecimal conversion_rate_settlement) {
		this.conversion_rate_settlement = conversion_rate_settlement;
	}
	public BigDecimal getAmount_billing() {
		return amount_billing;
	}
	public void setAmount_billing(BigDecimal amount_billing) {
		this.amount_billing = amount_billing;
	}
	public BigDecimal getConversion_rate_billing() {
		return conversion_rate_billing;
	}
	public void setConversion_rate_billing(BigDecimal conversion_rate_billing) {
		this.conversion_rate_billing = conversion_rate_billing;
	}
	public BigDecimal getCurrency_code_billing() {
		return currency_code_billing;
	}
	public void setCurrency_code_billing(BigDecimal currency_code_billing) {
		this.currency_code_billing = currency_code_billing;
	}
	public BigDecimal getOriginal_settlement_date() {
		return original_settlement_date;
	}
	public void setOriginal_settlement_date(BigDecimal original_settlement_date) {
		this.original_settlement_date = original_settlement_date;
	}
	public String getFee_type_code_1() {
		return fee_type_code_1;
	}
	public void setFee_type_code_1(String fee_type_code_1) {
		this.fee_type_code_1 = fee_type_code_1;
	}
	public BigDecimal getInterchange_category_1() {
		return interchange_category_1;
	}
	public void setInterchange_category_1(BigDecimal interchange_category_1) {
		this.interchange_category_1 = interchange_category_1;
	}
	public BigDecimal getFee_amount_1() {
		return fee_amount_1;
	}
	public void setFee_amount_1(BigDecimal fee_amount_1) {
		this.fee_amount_1 = fee_amount_1;
	}
	public String getFee_dr_cr_indicator_1() {
		return fee_dr_cr_indicator_1;
	}
	public void setFee_dr_cr_indicator_1(String fee_dr_cr_indicator_1) {
		this.fee_dr_cr_indicator_1 = fee_dr_cr_indicator_1;
	}
	public BigDecimal getFee_currency_1() {
		return fee_currency_1;
	}
	public void setFee_currency_1(BigDecimal fee_currency_1) {
		this.fee_currency_1 = fee_currency_1;
	}
	public String getProcessing_status() {
		return processing_status;
	}
	public void setProcessing_status(String processing_status) {
		this.processing_status = processing_status;
	}
	public BigDecimal getMaucas_cps_record_reject_reason_code() {
		return maucas_cps_record_reject_reason_code;
	}
	public void setMaucas_cps_record_reject_reason_code(BigDecimal maucas_cps_record_reject_reason_code) {
		this.maucas_cps_record_reject_reason_code = maucas_cps_record_reject_reason_code;
	}
	public BigDecimal getCard_acceptor_business_code() {
		return card_acceptor_business_code;
	}
	public void setCard_acceptor_business_code(BigDecimal card_acceptor_business_code) {
		this.card_acceptor_business_code = card_acceptor_business_code;
	}
	public String getCard_acceptor_name() {
		return card_acceptor_name;
	}
	public void setCard_acceptor_name(String card_acceptor_name) {
		this.card_acceptor_name = card_acceptor_name;
	}
	public BigDecimal getDate_and_time_file_genereted() {
		return date_and_time_file_genereted;
	}
	public void setDate_and_time_file_genereted(BigDecimal date_and_time_file_genereted) {
		this.date_and_time_file_genereted = date_and_time_file_genereted;
	}
	public String getMember_institution_id_code() {
		return member_institution_id_code;
	}
	public void setMember_institution_id_code(String member_institution_id_code) {
		this.member_institution_id_code = member_institution_id_code;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getSettlement_bin() {
		return settlement_bin;
	}
	public void setSettlement_bin(String settlement_bin) {
		this.settlement_bin = settlement_bin;
	}
	public String getFile_categoty() {
		return file_categoty;
	}
	public void setFile_categoty(String file_categoty) {
		this.file_categoty = file_categoty;
	}
	public String getVersion_number() {
		return version_number;
	}
	public void setVersion_number(String version_number) {
		this.version_number = version_number;
	}
	public String getLate_presentment_indicator() {
		return late_presentment_indicator;
	}
	public void setLate_presentment_indicator(String late_presentment_indicator) {
		this.late_presentment_indicator = late_presentment_indicator;
	}
	public String getRgcsrcvddt() {
		return rgcsrcvddt;
	}
	public void setRgcsrcvddt(String rgcsrcvddt) {
		this.rgcsrcvddt = rgcsrcvddt;
	}
	public String getCard_acceptor_additional_address() {
		return card_acceptor_additional_address;
	}
	public void setCard_acceptor_additional_address(String card_acceptor_additional_address) {
		this.card_acceptor_additional_address = card_acceptor_additional_address;
	}
	public String getReport_name() {
		return report_name;
	}
	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}
	public String getTransactions_count() {
		return transactions_count;
	}
	public void setTransactions_count(String transactions_count) {
		this.transactions_count = transactions_count;
	}
	public BigDecimal getRun_total_amount() {
		return run_total_amount;
	}
	public void setRun_total_amount(BigDecimal run_total_amount) {
		this.run_total_amount = run_total_amount;
	}
	public BigDecimal getRetrieval_reference_number() {
		return retrieval_reference_number;
	}
	public void setRetrieval_reference_number(BigDecimal retrieval_reference_number) {
		this.retrieval_reference_number = retrieval_reference_number;
	}
	public BigDecimal getMaucas_cps_received_date() {
		return maucas_cps_received_date;
	}
	public void setMaucas_cps_received_date(BigDecimal maucas_cps_received_date) {
		this.maucas_cps_received_date = maucas_cps_received_date;
	}
	public String getAdditional_data() {
		return additional_data;
	}
	public void setAdditional_data(String additional_data) {
		this.additional_data = additional_data;
	}
	public String getAdditional_transaction_data() {
		return additional_transaction_data;
	}
	public void setAdditional_transaction_data(String additional_transaction_data) {
		this.additional_transaction_data = additional_transaction_data;
	}
	public String getEntire_file_reject_indicator() {
		return entire_file_reject_indicator;
	}
	public void setEntire_file_reject_indicator(String entire_file_reject_indicator) {
		this.entire_file_reject_indicator = entire_file_reject_indicator;
	}
	public BigDecimal getFile_reject_reason_code() {
		return file_reject_reason_code;
	}
	public void setFile_reject_reason_code(BigDecimal file_reject_reason_code) {
		this.file_reject_reason_code = file_reject_reason_code;
	}
	public BigDecimal getControl_number() {
		return control_number;
	}
	public void setControl_number(BigDecimal control_number) {
		this.control_number = control_number;
	}
	public BigDecimal getProcessing_code() {
		return processing_code;
	}
	public void setProcessing_code(BigDecimal processing_code) {
		this.processing_code = processing_code;
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
	public Date getReport_to_date() {
		return report_to_date;
	}
	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
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
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}
	public Date getReport_submit_date() {
		return report_submit_date;
	}
	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}
	
	public Charge_Back_Entity(String srlno, BigDecimal mti, BigDecimal mti_2, String mti_3, BigDecimal function_code,
			BigDecimal function_code_2, BigDecimal function_code_3, String record_number, String record_number_2,
			String record_number_3, BigDecimal date_and_time_local_transaction, BigDecimal primary_account_number,
			BigDecimal acquirer_reference_data, BigDecimal acquirer_institution_id_code, BigDecimal approval_code,
			String card_acceptor_terminal_id, BigDecimal amount_transaction, BigDecimal currency_code_transaction,
			BigDecimal amounts_additional, String transaction_originator_institution_id_code,
			String transaction_destination_institution_id_code, String unique_file_name, BigDecimal message_reason_code,
			String internal_tracking_number, String member_message_text, String document_indicator,
			String full_partial_indicator, String case_number, BigDecimal date_settlement,
			String settlement_dr_cr_indicator, BigDecimal amount_settlement, BigDecimal currency_code_settlement,
			BigDecimal conversion_rate_settlement, BigDecimal amount_billing, BigDecimal conversion_rate_billing,
			BigDecimal currency_code_billing, BigDecimal original_settlement_date, String fee_type_code_1,
			BigDecimal interchange_category_1, BigDecimal fee_amount_1, String fee_dr_cr_indicator_1,
			BigDecimal fee_currency_1, String processing_status, BigDecimal maucas_cps_record_reject_reason_code,
			BigDecimal card_acceptor_business_code, String card_acceptor_name, BigDecimal date_and_time_file_genereted,
			String member_institution_id_code, String product_code, String settlement_bin, String file_categoty,
			String version_number, String late_presentment_indicator, String rgcsrcvddt,
			String card_acceptor_additional_address, String report_name, String transactions_count,
			BigDecimal run_total_amount, BigDecimal retrieval_reference_number, BigDecimal maucas_cps_received_date,
			String additional_data, String additional_transaction_data, String entire_file_reject_indicator,
			BigDecimal file_reject_reason_code, BigDecimal control_number, BigDecimal processing_code, Date report_date,
			Date report_from_date, Date report_to_date, String entity_flg, String modify_flg, String del_flg,
			String report_code, Date report_submit_date) {
		super();
		this.srlno = srlno;
		this.mti = mti;
		this.mti_2 = mti_2;
		this.mti_3 = mti_3;
		this.function_code = function_code;
		this.function_code_2 = function_code_2;
		this.function_code_3 = function_code_3;
		this.record_number = record_number;
		this.record_number_2 = record_number_2;
		this.record_number_3 = record_number_3;
		this.date_and_time_local_transaction = date_and_time_local_transaction;
		this.primary_account_number = primary_account_number;
		this.acquirer_reference_data = acquirer_reference_data;
		this.acquirer_institution_id_code = acquirer_institution_id_code;
		this.approval_code = approval_code;
		this.card_acceptor_terminal_id = card_acceptor_terminal_id;
		this.amount_transaction = amount_transaction;
		this.currency_code_transaction = currency_code_transaction;
		this.amounts_additional = amounts_additional;
		this.transaction_originator_institution_id_code = transaction_originator_institution_id_code;
		this.transaction_destination_institution_id_code = transaction_destination_institution_id_code;
		this.unique_file_name = unique_file_name;
		this.message_reason_code = message_reason_code;
		this.internal_tracking_number = internal_tracking_number;
		this.member_message_text = member_message_text;
		this.document_indicator = document_indicator;
		this.full_partial_indicator = full_partial_indicator;
		this.case_number = case_number;
		this.date_settlement = date_settlement;
		this.settlement_dr_cr_indicator = settlement_dr_cr_indicator;
		this.amount_settlement = amount_settlement;
		this.currency_code_settlement = currency_code_settlement;
		this.conversion_rate_settlement = conversion_rate_settlement;
		this.amount_billing = amount_billing;
		this.conversion_rate_billing = conversion_rate_billing;
		this.currency_code_billing = currency_code_billing;
		this.original_settlement_date = original_settlement_date;
		this.fee_type_code_1 = fee_type_code_1;
		this.interchange_category_1 = interchange_category_1;
		this.fee_amount_1 = fee_amount_1;
		this.fee_dr_cr_indicator_1 = fee_dr_cr_indicator_1;
		this.fee_currency_1 = fee_currency_1;
		this.processing_status = processing_status;
		this.maucas_cps_record_reject_reason_code = maucas_cps_record_reject_reason_code;
		this.card_acceptor_business_code = card_acceptor_business_code;
		this.card_acceptor_name = card_acceptor_name;
		this.date_and_time_file_genereted = date_and_time_file_genereted;
		this.member_institution_id_code = member_institution_id_code;
		this.product_code = product_code;
		this.settlement_bin = settlement_bin;
		this.file_categoty = file_categoty;
		this.version_number = version_number;
		this.late_presentment_indicator = late_presentment_indicator;
		this.rgcsrcvddt = rgcsrcvddt;
		this.card_acceptor_additional_address = card_acceptor_additional_address;
		this.report_name = report_name;
		this.transactions_count = transactions_count;
		this.run_total_amount = run_total_amount;
		this.retrieval_reference_number = retrieval_reference_number;
		this.maucas_cps_received_date = maucas_cps_received_date;
		this.additional_data = additional_data;
		this.additional_transaction_data = additional_transaction_data;
		this.entire_file_reject_indicator = entire_file_reject_indicator;
		this.file_reject_reason_code = file_reject_reason_code;
		this.control_number = control_number;
		this.processing_code = processing_code;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
	}
	public Charge_Back_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String body(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	public static String status(HttpStatus internalServerError) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public char[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
