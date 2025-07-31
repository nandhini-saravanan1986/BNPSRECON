package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ECDD_CORPORATE_TABLE")
public class EcddCorporateEntity {
	private String customer_id;
	private String company_name;
	private String associated_account_number;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ecdd_date;
	private String trade_license_number;
	private String trade_legal_status;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date trade_expiry_date;
	private String company_address;
	private String triggered_event;
	private String no_change_reason;
	private String geographic_risk_profile;
	private String business_activity_products;
	private String trade_license_validity;
	private String ubo_signatories_kyc_validity;
	private String pep_status;
	private String trade_license_remarks;
	private String ubo_signatories_kyc_remarks;
	private String pep_remarks;
	private String counterparty_name_1;
	private String counterparty_import_export_1;
	private String counterparty_country_1;
	private String counterparty_activity_products_1;
	private String counterparty_name_2;
	private String counterparty_import_export_2;
	private String counterparty_country_2;
	private String counterparty_activity_products_2;
	private String counterparty_name_3;
	private String counterparty_import_export_3;
	private String counterparty_country_3;
	private String counterparty_activity_products_3;
	private String counterparty_name_4;
	private String counterparty_import_export_4;
	private String counterparty_country_4;
	private String counterparty_activity_products_4;
	private String counterparty_name_5;
	private String counterparty_import_export_5;
	private String counterparty_country_5;
	private String counterparty_activity_products_5;
	private String corporate_cbuae_bbl;
	private String corporate_google_screening;
	private String corporate_dow_jones_screening;
	private String corporate_internal_deny_list;
	private String corporate_screening_remarks;
	private String ubo_cbuae_bbl;
	private String ubo_google_screening;
	private String ubo_dow_jones_screening;
	private String ubo_internal_deny_list;
	private String ubo_screening_remarks;
	private String counterparty_cbuae_bbl;
	private String counterparty_google_screening;
	private String counterparty_dow_jones_screening;
	private String counterparty_internal_deny_list;
	private String counterparty_screening_remarks;
	private String transaction_history;
	private BigDecimal high_value_transaction_count;
	private BigDecimal high_value_transaction_volume;
	private String account_conduct;
	private BigDecimal cash_transaction_percent;
	private BigDecimal cheque_transaction_percent;
	private BigDecimal local_transfer_percent;
	private BigDecimal intl_transfer_percent;
	private BigDecimal current_transaction_count;
	private BigDecimal expected_transaction_count;
	private BigDecimal cash_volume_percent;
	private BigDecimal cheque_volume_percent;
	private BigDecimal local_transfer_volume_percent;
	private BigDecimal intl_transfer_volume_percent;
	private BigDecimal current_volume_count;
	private BigDecimal expected_volume_count;
	private String transactions_match_profile;
	private String system_risk;
	private String latest_risk;
	private String risk_reason;
	private String aof_available;
	private String aof_remarks;
	private String fatca_crs_available;
	private String fatca_crs_remarks;
	private String source_of_funds_available;
	private String source_of_funds_remarks;
	private String observations;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date review_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date approval_date;
	private String reviewed_by_name;
	private String reviewed_by_ec_no;
	private String reviewed_by_designation;
	private String approved_by_name;
	private String approved_by_ec_no;
	private String approved_by_designation;
	private String branch_name;
	private String branch_code;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date data_entry_date;
	private String data_entry_employee_name;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date document_uploaded_date;
	private String document_uploaded_employee_name;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date current_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date report_date;
	@Id
	private String srl_no;
	private String entry_user;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entry_time;
	private String auth_user;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date auth_time;
	private String modify_user;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modify_time;
	private String verify_user;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date verify_time;
	private String entity_flg;
	private String auth_flg;
	private String modify_flg;
	private String del_flg;

	public String getCustomer_id() {
		return customer_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public String getAssociated_account_number() {
		return associated_account_number;
	}

	public Date getEcdd_date() {
		return ecdd_date;
	}

	public String getTrade_license_number() {
		return trade_license_number;
	}

	public String getTrade_legal_status() {
		return trade_legal_status;
	}

	public Date getTrade_expiry_date() {
		return trade_expiry_date;
	}

	public String getCompany_address() {
		return company_address;
	}

	public String getTriggered_event() {
		return triggered_event;
	}

	public String getNo_change_reason() {
		return no_change_reason;
	}

	public String getGeographic_risk_profile() {
		return geographic_risk_profile;
	}

	public String getBusiness_activity_products() {
		return business_activity_products;
	}

	public String getTrade_license_validity() {
		return trade_license_validity;
	}

	public String getUbo_signatories_kyc_validity() {
		return ubo_signatories_kyc_validity;
	}

	public String getPep_status() {
		return pep_status;
	}

	public String getTrade_license_remarks() {
		return trade_license_remarks;
	}

	public String getUbo_signatories_kyc_remarks() {
		return ubo_signatories_kyc_remarks;
	}

	public String getPep_remarks() {
		return pep_remarks;
	}

	public String getCounterparty_name_1() {
		return counterparty_name_1;
	}

	public String getCounterparty_import_export_1() {
		return counterparty_import_export_1;
	}

	public String getCounterparty_country_1() {
		return counterparty_country_1;
	}

	public String getCounterparty_activity_products_1() {
		return counterparty_activity_products_1;
	}

	public String getCounterparty_name_2() {
		return counterparty_name_2;
	}

	public String getCounterparty_import_export_2() {
		return counterparty_import_export_2;
	}

	public String getCounterparty_country_2() {
		return counterparty_country_2;
	}

	public String getCounterparty_activity_products_2() {
		return counterparty_activity_products_2;
	}

	public String getCounterparty_name_3() {
		return counterparty_name_3;
	}

	public String getCounterparty_import_export_3() {
		return counterparty_import_export_3;
	}

	public String getCounterparty_country_3() {
		return counterparty_country_3;
	}

	public String getCounterparty_activity_products_3() {
		return counterparty_activity_products_3;
	}

	public String getCounterparty_name_4() {
		return counterparty_name_4;
	}

	public String getCounterparty_import_export_4() {
		return counterparty_import_export_4;
	}

	public String getCounterparty_country_4() {
		return counterparty_country_4;
	}

	public String getCounterparty_activity_products_4() {
		return counterparty_activity_products_4;
	}

	public String getCounterparty_name_5() {
		return counterparty_name_5;
	}

	public String getCounterparty_import_export_5() {
		return counterparty_import_export_5;
	}

	public String getCounterparty_country_5() {
		return counterparty_country_5;
	}

	public String getCounterparty_activity_products_5() {
		return counterparty_activity_products_5;
	}

	public String getCorporate_cbuae_bbl() {
		return corporate_cbuae_bbl;
	}

	public String getCorporate_google_screening() {
		return corporate_google_screening;
	}

	public String getCorporate_dow_jones_screening() {
		return corporate_dow_jones_screening;
	}

	public String getCorporate_internal_deny_list() {
		return corporate_internal_deny_list;
	}

	public String getCorporate_screening_remarks() {
		return corporate_screening_remarks;
	}

	public String getUbo_cbuae_bbl() {
		return ubo_cbuae_bbl;
	}

	public String getUbo_google_screening() {
		return ubo_google_screening;
	}

	public String getUbo_dow_jones_screening() {
		return ubo_dow_jones_screening;
	}

	public String getUbo_internal_deny_list() {
		return ubo_internal_deny_list;
	}

	public String getUbo_screening_remarks() {
		return ubo_screening_remarks;
	}

	public String getCounterparty_cbuae_bbl() {
		return counterparty_cbuae_bbl;
	}

	public String getCounterparty_google_screening() {
		return counterparty_google_screening;
	}

	public String getCounterparty_dow_jones_screening() {
		return counterparty_dow_jones_screening;
	}

	public String getCounterparty_internal_deny_list() {
		return counterparty_internal_deny_list;
	}

	public String getCounterparty_screening_remarks() {
		return counterparty_screening_remarks;
	}

	public String getTransaction_history() {
		return transaction_history;
	}

	public BigDecimal getHigh_value_transaction_count() {
		return high_value_transaction_count;
	}

	public BigDecimal getHigh_value_transaction_volume() {
		return high_value_transaction_volume;
	}

	public String getAccount_conduct() {
		return account_conduct;
	}

	public BigDecimal getCash_transaction_percent() {
		return cash_transaction_percent;
	}

	public BigDecimal getCheque_transaction_percent() {
		return cheque_transaction_percent;
	}

	public BigDecimal getLocal_transfer_percent() {
		return local_transfer_percent;
	}

	public BigDecimal getIntl_transfer_percent() {
		return intl_transfer_percent;
	}

	public BigDecimal getCurrent_transaction_count() {
		return current_transaction_count;
	}

	public BigDecimal getExpected_transaction_count() {
		return expected_transaction_count;
	}

	public BigDecimal getCash_volume_percent() {
		return cash_volume_percent;
	}

	public BigDecimal getCheque_volume_percent() {
		return cheque_volume_percent;
	}

	public BigDecimal getLocal_transfer_volume_percent() {
		return local_transfer_volume_percent;
	}

	public BigDecimal getIntl_transfer_volume_percent() {
		return intl_transfer_volume_percent;
	}

	public BigDecimal getCurrent_volume_count() {
		return current_volume_count;
	}

	public BigDecimal getExpected_volume_count() {
		return expected_volume_count;
	}

	public String getTransactions_match_profile() {
		return transactions_match_profile;
	}

	public String getSystem_risk() {
		return system_risk;
	}

	public String getLatest_risk() {
		return latest_risk;
	}

	public String getRisk_reason() {
		return risk_reason;
	}

	public String getAof_available() {
		return aof_available;
	}

	public String getAof_remarks() {
		return aof_remarks;
	}

	public String getFatca_crs_available() {
		return fatca_crs_available;
	}

	public String getFatca_crs_remarks() {
		return fatca_crs_remarks;
	}

	public String getSource_of_funds_available() {
		return source_of_funds_available;
	}

	public String getSource_of_funds_remarks() {
		return source_of_funds_remarks;
	}

	public String getObservations() {
		return observations;
	}

	public Date getReview_date() {
		return review_date;
	}

	public Date getApproval_date() {
		return approval_date;
	}

	public String getReviewed_by_name() {
		return reviewed_by_name;
	}

	public String getReviewed_by_ec_no() {
		return reviewed_by_ec_no;
	}

	public String getReviewed_by_designation() {
		return reviewed_by_designation;
	}

	public String getApproved_by_name() {
		return approved_by_name;
	}

	public String getApproved_by_ec_no() {
		return approved_by_ec_no;
	}

	public String getApproved_by_designation() {
		return approved_by_designation;
	}

	public String getBranch_name() {
		return branch_name;
	}

	public String getBranch_code() {
		return branch_code;
	}

	public Date getData_entry_date() {
		return data_entry_date;
	}

	public String getData_entry_employee_name() {
		return data_entry_employee_name;
	}

	public Date getDocument_uploaded_date() {
		return document_uploaded_date;
	}

	public String getDocument_uploaded_employee_name() {
		return document_uploaded_employee_name;
	}

	public Date getCurrent_date() {
		return current_date;
	}

	public Date getReport_date() {
		return report_date;
	}

	public String getSrl_no() {
		return srl_no;
	}

	public String getEntry_user() {
		return entry_user;
	}

	public Date getEntry_time() {
		return entry_time;
	}

	public String getAuth_user() {
		return auth_user;
	}

	public Date getAuth_time() {
		return auth_time;
	}

	public String getModify_user() {
		return modify_user;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public String getVerify_user() {
		return verify_user;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public String getAuth_flg() {
		return auth_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public void setAssociated_account_number(String associated_account_number) {
		this.associated_account_number = associated_account_number;
	}

	public void setEcdd_date(Date ecdd_date) {
		this.ecdd_date = ecdd_date;
	}

	public void setTrade_license_number(String trade_license_number) {
		this.trade_license_number = trade_license_number;
	}

	public void setTrade_legal_status(String trade_legal_status) {
		this.trade_legal_status = trade_legal_status;
	}

	public void setTrade_expiry_date(Date trade_expiry_date) {
		this.trade_expiry_date = trade_expiry_date;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	public void setTriggered_event(String triggered_event) {
		this.triggered_event = triggered_event;
	}

	public void setNo_change_reason(String no_change_reason) {
		this.no_change_reason = no_change_reason;
	}

	public void setGeographic_risk_profile(String geographic_risk_profile) {
		this.geographic_risk_profile = geographic_risk_profile;
	}

	public void setBusiness_activity_products(String business_activity_products) {
		this.business_activity_products = business_activity_products;
	}

	public void setTrade_license_validity(String trade_license_validity) {
		this.trade_license_validity = trade_license_validity;
	}

	public void setUbo_signatories_kyc_validity(String ubo_signatories_kyc_validity) {
		this.ubo_signatories_kyc_validity = ubo_signatories_kyc_validity;
	}

	public void setPep_status(String pep_status) {
		this.pep_status = pep_status;
	}

	public void setTrade_license_remarks(String trade_license_remarks) {
		this.trade_license_remarks = trade_license_remarks;
	}

	public void setUbo_signatories_kyc_remarks(String ubo_signatories_kyc_remarks) {
		this.ubo_signatories_kyc_remarks = ubo_signatories_kyc_remarks;
	}

	public void setPep_remarks(String pep_remarks) {
		this.pep_remarks = pep_remarks;
	}

	public void setCounterparty_name_1(String counterparty_name_1) {
		this.counterparty_name_1 = counterparty_name_1;
	}

	public void setCounterparty_import_export_1(String counterparty_import_export_1) {
		this.counterparty_import_export_1 = counterparty_import_export_1;
	}

	public void setCounterparty_country_1(String counterparty_country_1) {
		this.counterparty_country_1 = counterparty_country_1;
	}

	public void setCounterparty_activity_products_1(String counterparty_activity_products_1) {
		this.counterparty_activity_products_1 = counterparty_activity_products_1;
	}

	public void setCounterparty_name_2(String counterparty_name_2) {
		this.counterparty_name_2 = counterparty_name_2;
	}

	public void setCounterparty_import_export_2(String counterparty_import_export_2) {
		this.counterparty_import_export_2 = counterparty_import_export_2;
	}

	public void setCounterparty_country_2(String counterparty_country_2) {
		this.counterparty_country_2 = counterparty_country_2;
	}

	public void setCounterparty_activity_products_2(String counterparty_activity_products_2) {
		this.counterparty_activity_products_2 = counterparty_activity_products_2;
	}

	public void setCounterparty_name_3(String counterparty_name_3) {
		this.counterparty_name_3 = counterparty_name_3;
	}

	public void setCounterparty_import_export_3(String counterparty_import_export_3) {
		this.counterparty_import_export_3 = counterparty_import_export_3;
	}

	public void setCounterparty_country_3(String counterparty_country_3) {
		this.counterparty_country_3 = counterparty_country_3;
	}

	public void setCounterparty_activity_products_3(String counterparty_activity_products_3) {
		this.counterparty_activity_products_3 = counterparty_activity_products_3;
	}

	public void setCounterparty_name_4(String counterparty_name_4) {
		this.counterparty_name_4 = counterparty_name_4;
	}

	public void setCounterparty_import_export_4(String counterparty_import_export_4) {
		this.counterparty_import_export_4 = counterparty_import_export_4;
	}

	public void setCounterparty_country_4(String counterparty_country_4) {
		this.counterparty_country_4 = counterparty_country_4;
	}

	public void setCounterparty_activity_products_4(String counterparty_activity_products_4) {
		this.counterparty_activity_products_4 = counterparty_activity_products_4;
	}

	public void setCounterparty_name_5(String counterparty_name_5) {
		this.counterparty_name_5 = counterparty_name_5;
	}

	public void setCounterparty_import_export_5(String counterparty_import_export_5) {
		this.counterparty_import_export_5 = counterparty_import_export_5;
	}

	public void setCounterparty_country_5(String counterparty_country_5) {
		this.counterparty_country_5 = counterparty_country_5;
	}

	public void setCounterparty_activity_products_5(String counterparty_activity_products_5) {
		this.counterparty_activity_products_5 = counterparty_activity_products_5;
	}

	public void setCorporate_cbuae_bbl(String corporate_cbuae_bbl) {
		this.corporate_cbuae_bbl = corporate_cbuae_bbl;
	}

	public void setCorporate_google_screening(String corporate_google_screening) {
		this.corporate_google_screening = corporate_google_screening;
	}

	public void setCorporate_dow_jones_screening(String corporate_dow_jones_screening) {
		this.corporate_dow_jones_screening = corporate_dow_jones_screening;
	}

	public void setCorporate_internal_deny_list(String corporate_internal_deny_list) {
		this.corporate_internal_deny_list = corporate_internal_deny_list;
	}

	public void setCorporate_screening_remarks(String corporate_screening_remarks) {
		this.corporate_screening_remarks = corporate_screening_remarks;
	}

	public void setUbo_cbuae_bbl(String ubo_cbuae_bbl) {
		this.ubo_cbuae_bbl = ubo_cbuae_bbl;
	}

	public void setUbo_google_screening(String ubo_google_screening) {
		this.ubo_google_screening = ubo_google_screening;
	}

	public void setUbo_dow_jones_screening(String ubo_dow_jones_screening) {
		this.ubo_dow_jones_screening = ubo_dow_jones_screening;
	}

	public void setUbo_internal_deny_list(String ubo_internal_deny_list) {
		this.ubo_internal_deny_list = ubo_internal_deny_list;
	}

	public void setUbo_screening_remarks(String ubo_screening_remarks) {
		this.ubo_screening_remarks = ubo_screening_remarks;
	}

	public void setCounterparty_cbuae_bbl(String counterparty_cbuae_bbl) {
		this.counterparty_cbuae_bbl = counterparty_cbuae_bbl;
	}

	public void setCounterparty_google_screening(String counterparty_google_screening) {
		this.counterparty_google_screening = counterparty_google_screening;
	}

	public void setCounterparty_dow_jones_screening(String counterparty_dow_jones_screening) {
		this.counterparty_dow_jones_screening = counterparty_dow_jones_screening;
	}

	public void setCounterparty_internal_deny_list(String counterparty_internal_deny_list) {
		this.counterparty_internal_deny_list = counterparty_internal_deny_list;
	}

	public void setCounterparty_screening_remarks(String counterparty_screening_remarks) {
		this.counterparty_screening_remarks = counterparty_screening_remarks;
	}

	public void setTransaction_history(String transaction_history) {
		this.transaction_history = transaction_history;
	}

	public void setHigh_value_transaction_count(BigDecimal high_value_transaction_count) {
		this.high_value_transaction_count = high_value_transaction_count;
	}

	public void setHigh_value_transaction_volume(BigDecimal high_value_transaction_volume) {
		this.high_value_transaction_volume = high_value_transaction_volume;
	}

	public void setAccount_conduct(String account_conduct) {
		this.account_conduct = account_conduct;
	}

	public void setCash_transaction_percent(BigDecimal cash_transaction_percent) {
		this.cash_transaction_percent = cash_transaction_percent;
	}

	public void setCheque_transaction_percent(BigDecimal cheque_transaction_percent) {
		this.cheque_transaction_percent = cheque_transaction_percent;
	}

	public void setLocal_transfer_percent(BigDecimal local_transfer_percent) {
		this.local_transfer_percent = local_transfer_percent;
	}

	public void setIntl_transfer_percent(BigDecimal intl_transfer_percent) {
		this.intl_transfer_percent = intl_transfer_percent;
	}

	public void setCurrent_transaction_count(BigDecimal current_transaction_count) {
		this.current_transaction_count = current_transaction_count;
	}

	public void setExpected_transaction_count(BigDecimal expected_transaction_count) {
		this.expected_transaction_count = expected_transaction_count;
	}

	public void setCash_volume_percent(BigDecimal cash_volume_percent) {
		this.cash_volume_percent = cash_volume_percent;
	}

	public void setCheque_volume_percent(BigDecimal cheque_volume_percent) {
		this.cheque_volume_percent = cheque_volume_percent;
	}

	public void setLocal_transfer_volume_percent(BigDecimal local_transfer_volume_percent) {
		this.local_transfer_volume_percent = local_transfer_volume_percent;
	}

	public void setIntl_transfer_volume_percent(BigDecimal intl_transfer_volume_percent) {
		this.intl_transfer_volume_percent = intl_transfer_volume_percent;
	}

	public void setCurrent_volume_count(BigDecimal current_volume_count) {
		this.current_volume_count = current_volume_count;
	}

	public void setExpected_volume_count(BigDecimal expected_volume_count) {
		this.expected_volume_count = expected_volume_count;
	}

	public void setTransactions_match_profile(String transactions_match_profile) {
		this.transactions_match_profile = transactions_match_profile;
	}

	public void setSystem_risk(String system_risk) {
		this.system_risk = system_risk;
	}

	public void setLatest_risk(String latest_risk) {
		this.latest_risk = latest_risk;
	}

	public void setRisk_reason(String risk_reason) {
		this.risk_reason = risk_reason;
	}

	public void setAof_available(String aof_available) {
		this.aof_available = aof_available;
	}

	public void setAof_remarks(String aof_remarks) {
		this.aof_remarks = aof_remarks;
	}

	public void setFatca_crs_available(String fatca_crs_available) {
		this.fatca_crs_available = fatca_crs_available;
	}

	public void setFatca_crs_remarks(String fatca_crs_remarks) {
		this.fatca_crs_remarks = fatca_crs_remarks;
	}

	public void setSource_of_funds_available(String source_of_funds_available) {
		this.source_of_funds_available = source_of_funds_available;
	}

	public void setSource_of_funds_remarks(String source_of_funds_remarks) {
		this.source_of_funds_remarks = source_of_funds_remarks;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
	}

	public void setReviewed_by_name(String reviewed_by_name) {
		this.reviewed_by_name = reviewed_by_name;
	}

	public void setReviewed_by_ec_no(String reviewed_by_ec_no) {
		this.reviewed_by_ec_no = reviewed_by_ec_no;
	}

	public void setReviewed_by_designation(String reviewed_by_designation) {
		this.reviewed_by_designation = reviewed_by_designation;
	}

	public void setApproved_by_name(String approved_by_name) {
		this.approved_by_name = approved_by_name;
	}

	public void setApproved_by_ec_no(String approved_by_ec_no) {
		this.approved_by_ec_no = approved_by_ec_no;
	}

	public void setApproved_by_designation(String approved_by_designation) {
		this.approved_by_designation = approved_by_designation;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public void setData_entry_date(Date data_entry_date) {
		this.data_entry_date = data_entry_date;
	}

	public void setData_entry_employee_name(String data_entry_employee_name) {
		this.data_entry_employee_name = data_entry_employee_name;
	}

	public void setDocument_uploaded_date(Date document_uploaded_date) {
		this.document_uploaded_date = document_uploaded_date;
	}

	public void setDocument_uploaded_employee_name(String document_uploaded_employee_name) {
		this.document_uploaded_employee_name = document_uploaded_employee_name;
	}

	public void setCurrent_date(Date current_date) {
		this.current_date = current_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}

	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public void setVerify_user(String verify_user) {
		this.verify_user = verify_user;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public EcddCorporateEntity(String customer_id, String company_name, String associated_account_number,
			Date ecdd_date, String trade_license_number, String trade_legal_status, Date trade_expiry_date,
			String company_address, String triggered_event, String no_change_reason, String geographic_risk_profile,
			String business_activity_products, String trade_license_validity, String ubo_signatories_kyc_validity,
			String pep_status, String trade_license_remarks, String ubo_signatories_kyc_remarks, String pep_remarks,
			String counterparty_name_1, String counterparty_import_export_1, String counterparty_country_1,
			String counterparty_activity_products_1, String counterparty_name_2, String counterparty_import_export_2,
			String counterparty_country_2, String counterparty_activity_products_2, String counterparty_name_3,
			String counterparty_import_export_3, String counterparty_country_3, String counterparty_activity_products_3,
			String counterparty_name_4, String counterparty_import_export_4, String counterparty_country_4,
			String counterparty_activity_products_4, String counterparty_name_5, String counterparty_import_export_5,
			String counterparty_country_5, String counterparty_activity_products_5, String corporate_cbuae_bbl,
			String corporate_google_screening, String corporate_dow_jones_screening,
			String corporate_internal_deny_list, String corporate_screening_remarks, String ubo_cbuae_bbl,
			String ubo_google_screening, String ubo_dow_jones_screening, String ubo_internal_deny_list,
			String ubo_screening_remarks, String counterparty_cbuae_bbl, String counterparty_google_screening,
			String counterparty_dow_jones_screening, String counterparty_internal_deny_list,
			String counterparty_screening_remarks, String transaction_history, BigDecimal high_value_transaction_count,
			BigDecimal high_value_transaction_volume, String account_conduct, BigDecimal cash_transaction_percent,
			BigDecimal cheque_transaction_percent, BigDecimal local_transfer_percent, BigDecimal intl_transfer_percent,
			BigDecimal current_transaction_count, BigDecimal expected_transaction_count, BigDecimal cash_volume_percent,
			BigDecimal cheque_volume_percent, BigDecimal local_transfer_volume_percent,
			BigDecimal intl_transfer_volume_percent, BigDecimal current_volume_count, BigDecimal expected_volume_count,
			String transactions_match_profile, String system_risk, String latest_risk, String risk_reason,
			String aof_available, String aof_remarks, String fatca_crs_available, String fatca_crs_remarks,
			String source_of_funds_available, String source_of_funds_remarks, String observations, Date review_date,
			Date approval_date, String reviewed_by_name, String reviewed_by_ec_no, String reviewed_by_designation,
			String approved_by_name, String approved_by_ec_no, String approved_by_designation, String branch_name,
			String branch_code, Date data_entry_date, String data_entry_employee_name, Date document_uploaded_date,
			String document_uploaded_employee_name, Date current_date, Date report_date, String srl_no,
			String entry_user, Date entry_time, String auth_user, Date auth_time, String modify_user, Date modify_time,
			String verify_user, Date verify_time, String entity_flg, String auth_flg, String modify_flg,
			String del_flg) {
		super();
		this.customer_id = customer_id;
		this.company_name = company_name;
		this.associated_account_number = associated_account_number;
		this.ecdd_date = ecdd_date;
		this.trade_license_number = trade_license_number;
		this.trade_legal_status = trade_legal_status;
		this.trade_expiry_date = trade_expiry_date;
		this.company_address = company_address;
		this.triggered_event = triggered_event;
		this.no_change_reason = no_change_reason;
		this.geographic_risk_profile = geographic_risk_profile;
		this.business_activity_products = business_activity_products;
		this.trade_license_validity = trade_license_validity;
		this.ubo_signatories_kyc_validity = ubo_signatories_kyc_validity;
		this.pep_status = pep_status;
		this.trade_license_remarks = trade_license_remarks;
		this.ubo_signatories_kyc_remarks = ubo_signatories_kyc_remarks;
		this.pep_remarks = pep_remarks;
		this.counterparty_name_1 = counterparty_name_1;
		this.counterparty_import_export_1 = counterparty_import_export_1;
		this.counterparty_country_1 = counterparty_country_1;
		this.counterparty_activity_products_1 = counterparty_activity_products_1;
		this.counterparty_name_2 = counterparty_name_2;
		this.counterparty_import_export_2 = counterparty_import_export_2;
		this.counterparty_country_2 = counterparty_country_2;
		this.counterparty_activity_products_2 = counterparty_activity_products_2;
		this.counterparty_name_3 = counterparty_name_3;
		this.counterparty_import_export_3 = counterparty_import_export_3;
		this.counterparty_country_3 = counterparty_country_3;
		this.counterparty_activity_products_3 = counterparty_activity_products_3;
		this.counterparty_name_4 = counterparty_name_4;
		this.counterparty_import_export_4 = counterparty_import_export_4;
		this.counterparty_country_4 = counterparty_country_4;
		this.counterparty_activity_products_4 = counterparty_activity_products_4;
		this.counterparty_name_5 = counterparty_name_5;
		this.counterparty_import_export_5 = counterparty_import_export_5;
		this.counterparty_country_5 = counterparty_country_5;
		this.counterparty_activity_products_5 = counterparty_activity_products_5;
		this.corporate_cbuae_bbl = corporate_cbuae_bbl;
		this.corporate_google_screening = corporate_google_screening;
		this.corporate_dow_jones_screening = corporate_dow_jones_screening;
		this.corporate_internal_deny_list = corporate_internal_deny_list;
		this.corporate_screening_remarks = corporate_screening_remarks;
		this.ubo_cbuae_bbl = ubo_cbuae_bbl;
		this.ubo_google_screening = ubo_google_screening;
		this.ubo_dow_jones_screening = ubo_dow_jones_screening;
		this.ubo_internal_deny_list = ubo_internal_deny_list;
		this.ubo_screening_remarks = ubo_screening_remarks;
		this.counterparty_cbuae_bbl = counterparty_cbuae_bbl;
		this.counterparty_google_screening = counterparty_google_screening;
		this.counterparty_dow_jones_screening = counterparty_dow_jones_screening;
		this.counterparty_internal_deny_list = counterparty_internal_deny_list;
		this.counterparty_screening_remarks = counterparty_screening_remarks;
		this.transaction_history = transaction_history;
		this.high_value_transaction_count = high_value_transaction_count;
		this.high_value_transaction_volume = high_value_transaction_volume;
		this.account_conduct = account_conduct;
		this.cash_transaction_percent = cash_transaction_percent;
		this.cheque_transaction_percent = cheque_transaction_percent;
		this.local_transfer_percent = local_transfer_percent;
		this.intl_transfer_percent = intl_transfer_percent;
		this.current_transaction_count = current_transaction_count;
		this.expected_transaction_count = expected_transaction_count;
		this.cash_volume_percent = cash_volume_percent;
		this.cheque_volume_percent = cheque_volume_percent;
		this.local_transfer_volume_percent = local_transfer_volume_percent;
		this.intl_transfer_volume_percent = intl_transfer_volume_percent;
		this.current_volume_count = current_volume_count;
		this.expected_volume_count = expected_volume_count;
		this.transactions_match_profile = transactions_match_profile;
		this.system_risk = system_risk;
		this.latest_risk = latest_risk;
		this.risk_reason = risk_reason;
		this.aof_available = aof_available;
		this.aof_remarks = aof_remarks;
		this.fatca_crs_available = fatca_crs_available;
		this.fatca_crs_remarks = fatca_crs_remarks;
		this.source_of_funds_available = source_of_funds_available;
		this.source_of_funds_remarks = source_of_funds_remarks;
		this.observations = observations;
		this.review_date = review_date;
		this.approval_date = approval_date;
		this.reviewed_by_name = reviewed_by_name;
		this.reviewed_by_ec_no = reviewed_by_ec_no;
		this.reviewed_by_designation = reviewed_by_designation;
		this.approved_by_name = approved_by_name;
		this.approved_by_ec_no = approved_by_ec_no;
		this.approved_by_designation = approved_by_designation;
		this.branch_name = branch_name;
		this.branch_code = branch_code;
		this.data_entry_date = data_entry_date;
		this.data_entry_employee_name = data_entry_employee_name;
		this.document_uploaded_date = document_uploaded_date;
		this.document_uploaded_employee_name = document_uploaded_employee_name;
		this.current_date = current_date;
		this.report_date = report_date;
		this.srl_no = srl_no;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.auth_user = auth_user;
		this.auth_time = auth_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.verify_user = verify_user;
		this.verify_time = verify_time;
		this.entity_flg = entity_flg;
		this.auth_flg = auth_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
	}

	@Override
	public String toString() {
		return "EcddCorporateEntity [customer_id=" + customer_id + ", company_name=" + company_name
				+ ", associated_account_number=" + associated_account_number + ", ecdd_date=" + ecdd_date
				+ ", trade_license_number=" + trade_license_number + ", trade_legal_status=" + trade_legal_status
				+ ", trade_expiry_date=" + trade_expiry_date + ", company_address=" + company_address
				+ ", triggered_event=" + triggered_event + ", no_change_reason=" + no_change_reason
				+ ", geographic_risk_profile=" + geographic_risk_profile + ", business_activity_products="
				+ business_activity_products + ", trade_license_validity=" + trade_license_validity
				+ ", ubo_signatories_kyc_validity=" + ubo_signatories_kyc_validity + ", pep_status=" + pep_status
				+ ", trade_license_remarks=" + trade_license_remarks + ", ubo_signatories_kyc_remarks="
				+ ubo_signatories_kyc_remarks + ", pep_remarks=" + pep_remarks + ", counterparty_name_1="
				+ counterparty_name_1 + ", counterparty_import_export_1=" + counterparty_import_export_1
				+ ", counterparty_country_1=" + counterparty_country_1 + ", counterparty_activity_products_1="
				+ counterparty_activity_products_1 + ", counterparty_name_2=" + counterparty_name_2
				+ ", counterparty_import_export_2=" + counterparty_import_export_2 + ", counterparty_country_2="
				+ counterparty_country_2 + ", counterparty_activity_products_2=" + counterparty_activity_products_2
				+ ", counterparty_name_3=" + counterparty_name_3 + ", counterparty_import_export_3="
				+ counterparty_import_export_3 + ", counterparty_country_3=" + counterparty_country_3
				+ ", counterparty_activity_products_3=" + counterparty_activity_products_3 + ", counterparty_name_4="
				+ counterparty_name_4 + ", counterparty_import_export_4=" + counterparty_import_export_4
				+ ", counterparty_country_4=" + counterparty_country_4 + ", counterparty_activity_products_4="
				+ counterparty_activity_products_4 + ", counterparty_name_5=" + counterparty_name_5
				+ ", counterparty_import_export_5=" + counterparty_import_export_5 + ", counterparty_country_5="
				+ counterparty_country_5 + ", counterparty_activity_products_5=" + counterparty_activity_products_5
				+ ", corporate_cbuae_bbl=" + corporate_cbuae_bbl + ", corporate_google_screening="
				+ corporate_google_screening + ", corporate_dow_jones_screening=" + corporate_dow_jones_screening
				+ ", corporate_internal_deny_list=" + corporate_internal_deny_list + ", corporate_screening_remarks="
				+ corporate_screening_remarks + ", ubo_cbuae_bbl=" + ubo_cbuae_bbl + ", ubo_google_screening="
				+ ubo_google_screening + ", ubo_dow_jones_screening=" + ubo_dow_jones_screening
				+ ", ubo_internal_deny_list=" + ubo_internal_deny_list + ", ubo_screening_remarks="
				+ ubo_screening_remarks + ", counterparty_cbuae_bbl=" + counterparty_cbuae_bbl
				+ ", counterparty_google_screening=" + counterparty_google_screening
				+ ", counterparty_dow_jones_screening=" + counterparty_dow_jones_screening
				+ ", counterparty_internal_deny_list=" + counterparty_internal_deny_list
				+ ", counterparty_screening_remarks=" + counterparty_screening_remarks + ", transaction_history="
				+ transaction_history + ", high_value_transaction_count=" + high_value_transaction_count
				+ ", high_value_transaction_volume=" + high_value_transaction_volume + ", account_conduct="
				+ account_conduct + ", cash_transaction_percent=" + cash_transaction_percent
				+ ", cheque_transaction_percent=" + cheque_transaction_percent + ", local_transfer_percent="
				+ local_transfer_percent + ", intl_transfer_percent=" + intl_transfer_percent
				+ ", current_transaction_count=" + current_transaction_count + ", expected_transaction_count="
				+ expected_transaction_count + ", cash_volume_percent=" + cash_volume_percent
				+ ", cheque_volume_percent=" + cheque_volume_percent + ", local_transfer_volume_percent="
				+ local_transfer_volume_percent + ", intl_transfer_volume_percent=" + intl_transfer_volume_percent
				+ ", current_volume_count=" + current_volume_count + ", expected_volume_count=" + expected_volume_count
				+ ", transactions_match_profile=" + transactions_match_profile + ", system_risk=" + system_risk
				+ ", latest_risk=" + latest_risk + ", risk_reason=" + risk_reason + ", aof_available=" + aof_available
				+ ", aof_remarks=" + aof_remarks + ", fatca_crs_available=" + fatca_crs_available
				+ ", fatca_crs_remarks=" + fatca_crs_remarks + ", source_of_funds_available="
				+ source_of_funds_available + ", source_of_funds_remarks=" + source_of_funds_remarks + ", observations="
				+ observations + ", review_date=" + review_date + ", approval_date=" + approval_date
				+ ", reviewed_by_name=" + reviewed_by_name + ", reviewed_by_ec_no=" + reviewed_by_ec_no
				+ ", reviewed_by_designation=" + reviewed_by_designation + ", approved_by_name=" + approved_by_name
				+ ", approved_by_ec_no=" + approved_by_ec_no + ", approved_by_designation=" + approved_by_designation
				+ ", branch_name=" + branch_name + ", branch_code=" + branch_code + ", data_entry_date="
				+ data_entry_date + ", data_entry_employee_name=" + data_entry_employee_name
				+ ", document_uploaded_date=" + document_uploaded_date + ", document_uploaded_employee_name="
				+ document_uploaded_employee_name + ", current_date=" + current_date + ", report_date=" + report_date
				+ ", srl_no=" + srl_no + ", entry_user=" + entry_user + ", entry_time=" + entry_time + ", auth_user="
				+ auth_user + ", auth_time=" + auth_time + ", modify_user=" + modify_user + ", modify_time="
				+ modify_time + ", verify_user=" + verify_user + ", verify_time=" + verify_time + ", entity_flg="
				+ entity_flg + ", auth_flg=" + auth_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg
				+ ", getCustomer_id()=" + getCustomer_id() + ", getCompany_name()=" + getCompany_name()
				+ ", getAssociated_account_number()=" + getAssociated_account_number() + ", getEcdd_date()="
				+ getEcdd_date() + ", getTrade_license_number()=" + getTrade_license_number()
				+ ", getTrade_legal_status()=" + getTrade_legal_status() + ", getTrade_expiry_date()="
				+ getTrade_expiry_date() + ", getCompany_address()=" + getCompany_address() + ", getTriggered_event()="
				+ getTriggered_event() + ", getNo_change_reason()=" + getNo_change_reason()
				+ ", getGeographic_risk_profile()=" + getGeographic_risk_profile()
				+ ", getBusiness_activity_products()=" + getBusiness_activity_products()
				+ ", getTrade_license_validity()=" + getTrade_license_validity()
				+ ", getUbo_signatories_kyc_validity()=" + getUbo_signatories_kyc_validity() + ", getPep_status()="
				+ getPep_status() + ", getTrade_license_remarks()=" + getTrade_license_remarks()
				+ ", getUbo_signatories_kyc_remarks()=" + getUbo_signatories_kyc_remarks() + ", getPep_remarks()="
				+ getPep_remarks() + ", getCounterparty_name_1()=" + getCounterparty_name_1()
				+ ", getCounterparty_import_export_1()=" + getCounterparty_import_export_1()
				+ ", getCounterparty_country_1()=" + getCounterparty_country_1()
				+ ", getCounterparty_activity_products_1()=" + getCounterparty_activity_products_1()
				+ ", getCounterparty_name_2()=" + getCounterparty_name_2() + ", getCounterparty_import_export_2()="
				+ getCounterparty_import_export_2() + ", getCounterparty_country_2()=" + getCounterparty_country_2()
				+ ", getCounterparty_activity_products_2()=" + getCounterparty_activity_products_2()
				+ ", getCounterparty_name_3()=" + getCounterparty_name_3() + ", getCounterparty_import_export_3()="
				+ getCounterparty_import_export_3() + ", getCounterparty_country_3()=" + getCounterparty_country_3()
				+ ", getCounterparty_activity_products_3()=" + getCounterparty_activity_products_3()
				+ ", getCounterparty_name_4()=" + getCounterparty_name_4() + ", getCounterparty_import_export_4()="
				+ getCounterparty_import_export_4() + ", getCounterparty_country_4()=" + getCounterparty_country_4()
				+ ", getCounterparty_activity_products_4()=" + getCounterparty_activity_products_4()
				+ ", getCounterparty_name_5()=" + getCounterparty_name_5() + ", getCounterparty_import_export_5()="
				+ getCounterparty_import_export_5() + ", getCounterparty_country_5()=" + getCounterparty_country_5()
				+ ", getCounterparty_activity_products_5()=" + getCounterparty_activity_products_5()
				+ ", getCorporate_cbuae_bbl()=" + getCorporate_cbuae_bbl() + ", getCorporate_google_screening()="
				+ getCorporate_google_screening() + ", getCorporate_dow_jones_screening()="
				+ getCorporate_dow_jones_screening() + ", getCorporate_internal_deny_list()="
				+ getCorporate_internal_deny_list() + ", getCorporate_screening_remarks()="
				+ getCorporate_screening_remarks() + ", getUbo_cbuae_bbl()=" + getUbo_cbuae_bbl()
				+ ", getUbo_google_screening()=" + getUbo_google_screening() + ", getUbo_dow_jones_screening()="
				+ getUbo_dow_jones_screening() + ", getUbo_internal_deny_list()=" + getUbo_internal_deny_list()
				+ ", getUbo_screening_remarks()=" + getUbo_screening_remarks() + ", getCounterparty_cbuae_bbl()="
				+ getCounterparty_cbuae_bbl() + ", getCounterparty_google_screening()="
				+ getCounterparty_google_screening() + ", getCounterparty_dow_jones_screening()="
				+ getCounterparty_dow_jones_screening() + ", getCounterparty_internal_deny_list()="
				+ getCounterparty_internal_deny_list() + ", getCounterparty_screening_remarks()="
				+ getCounterparty_screening_remarks() + ", getTransaction_history()=" + getTransaction_history()
				+ ", getHigh_value_transaction_count()=" + getHigh_value_transaction_count()
				+ ", getHigh_value_transaction_volume()=" + getHigh_value_transaction_volume()
				+ ", getAccount_conduct()=" + getAccount_conduct() + ", getCash_transaction_percent()="
				+ getCash_transaction_percent() + ", getCheque_transaction_percent()=" + getCheque_transaction_percent()
				+ ", getLocal_transfer_percent()=" + getLocal_transfer_percent() + ", getIntl_transfer_percent()="
				+ getIntl_transfer_percent() + ", getCurrent_transaction_count()=" + getCurrent_transaction_count()
				+ ", getExpected_transaction_count()=" + getExpected_transaction_count() + ", getCash_volume_percent()="
				+ getCash_volume_percent() + ", getCheque_volume_percent()=" + getCheque_volume_percent()
				+ ", getLocal_transfer_volume_percent()=" + getLocal_transfer_volume_percent()
				+ ", getIntl_transfer_volume_percent()=" + getIntl_transfer_volume_percent()
				+ ", getCurrent_volume_count()=" + getCurrent_volume_count() + ", getExpected_volume_count()="
				+ getExpected_volume_count() + ", getTransactions_match_profile()=" + getTransactions_match_profile()
				+ ", getSystem_risk()=" + getSystem_risk() + ", getLatest_risk()=" + getLatest_risk()
				+ ", getRisk_reason()=" + getRisk_reason() + ", getAof_available()=" + getAof_available()
				+ ", getAof_remarks()=" + getAof_remarks() + ", getFatca_crs_available()=" + getFatca_crs_available()
				+ ", getFatca_crs_remarks()=" + getFatca_crs_remarks() + ", getSource_of_funds_available()="
				+ getSource_of_funds_available() + ", getSource_of_funds_remarks()=" + getSource_of_funds_remarks()
				+ ", getObservations()=" + getObservations() + ", getReview_date()=" + getReview_date()
				+ ", getApproval_date()=" + getApproval_date() + ", getReviewed_by_name()=" + getReviewed_by_name()
				+ ", getReviewed_by_ec_no()=" + getReviewed_by_ec_no() + ", getReviewed_by_designation()="
				+ getReviewed_by_designation() + ", getApproved_by_name()=" + getApproved_by_name()
				+ ", getApproved_by_ec_no()=" + getApproved_by_ec_no() + ", getApproved_by_designation()="
				+ getApproved_by_designation() + ", getBranch_name()=" + getBranch_name() + ", getBranch_code()="
				+ getBranch_code() + ", getData_entry_date()=" + getData_entry_date()
				+ ", getData_entry_employee_name()=" + getData_entry_employee_name() + ", getDocument_uploaded_date()="
				+ getDocument_uploaded_date() + ", getDocument_uploaded_employee_name()="
				+ getDocument_uploaded_employee_name() + ", getCurrent_date()=" + getCurrent_date()
				+ ", getReport_date()=" + getReport_date() + ", getSrl_no()=" + getSrl_no() + ", getEntry_user()="
				+ getEntry_user() + ", getEntry_time()=" + getEntry_time() + ", getAuth_user()=" + getAuth_user()
				+ ", getAuth_time()=" + getAuth_time() + ", getModify_user()=" + getModify_user()
				+ ", getModify_time()=" + getModify_time() + ", getVerify_user()=" + getVerify_user()
				+ ", getVerify_time()=" + getVerify_time() + ", getEntity_flg()=" + getEntity_flg() + ", getAuth_flg()="
				+ getAuth_flg() + ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public EcddCorporateEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
