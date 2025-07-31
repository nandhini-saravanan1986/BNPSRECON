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
@Table(name = "ECDD_INDIV_PROFILE")
public class Ecdd_Individual_Profile_Entity {
	@Id
	private String srlno;
	private String account_title;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ecdd_date;
	private String customer_id;
	private String associated_accounts;
	private String currency;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date account_open_date;
	private String currency_approval_yn;
	private String primary_holder_name;
	private String primary_customer_id;
	private String primary_non_resident_yn;
	private String primary_nationality;
	private String primary_mobile_no;
	private String primary_email;
	private String primary_address;
	private String primary_passport_no;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date primary_passport_exp_date;
	private String primary_emirates_id_no;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date primary_emirates_exp_date;
	private String primary_pep_yn;
	private String primary_pep_approval;
	private String kyc_valid_yn_primary;
	private BigDecimal annual_income_primary;
	private String source_of_income_primary;
	private String screen_google_primary;
	private String screen_dowjones_primary;
	private String joint1_name;
	private String joint1_customer_id;
	private String joint1_non_resident_yn;
	private String joint1_nationality;
	private String joint1_mobile_no;
	private String joint1_email;
	private String joint1_address;
	private String joint1_passport_no;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joint1_passport_exp_date;
	private String joint1_emirates_id_no;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joint1_emirates_exp_date;
	private String joint1_pep_yn;
	private String joint1_pep_approval;
	private String kyc_valid_yn_joint1;
	private BigDecimal annual_income_joint1;
	private String source_of_income_joint1;
	private String screen_google_joint1;
	private String screen_dowjones_joint1;
	private String joint2_name;
	private String joint2_customer_id;
	private String joint2_non_resident_yn;
	private String joint2_nationality;
	private String joint2_mobile_no;
	private String joint2_email;
	private String joint2_address;
	private String joint2_passport_no;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joint2_passport_exp_date;
	private String joint2_emirates_id_no;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joint2_emirates_exp_date;
	private String joint2_pep_yn;
	private String joint2_pep_approval;
	private String kyc_valid_yn_joint2;
	private BigDecimal annual_income_joint2;
	private String source_of_income_joint2;
	private String screen_google_joint2;
	private String screen_dowjones_joint2;
	private String joint3_name;
	private String joint3_customer_id;
	private String joint3_non_resident_yn;
	private String joint3_nationality;
	private String joint3_mobile_no;
	private String joint3_email;
	private String joint3_address;
	private String joint3_passport_no;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joint3_passport_exp_date;
	private String joint3_emirates_id_no;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date joint3_emirates_exp_date;
	private String joint3_pep_yn;
	private String joint3_pep_approval;
	private String kyc_valid_yn_joint3;
	private BigDecimal annual_income_joint3;
	private String source_of_income_joint3;
	private String screen_google_joint3;
	private String screen_dowjones_joint3;
	private String branch_remarks;
	private String unusual_txn_details;
	private String suspicious_activity;
	private BigDecimal high_value_txn_count;
	private BigDecimal high_value_txn_volume;
	private BigDecimal frequency_txn_percent;
	private BigDecimal volume_turnover_percent;
	private BigDecimal cash_txn_count;
	private BigDecimal cash_txn_volume;
	private BigDecimal cheque_txn_count;
	private BigDecimal cheque_txn_volume;
	private BigDecimal local_txn_count;
	private BigDecimal local_txn_volume;
	private BigDecimal intl_txn_count;
	private BigDecimal intl_txn_volume;
	private BigDecimal curr_txn_count;
	private BigDecimal curr_txn_volume;
	private BigDecimal expected_txn_count;
	private BigDecimal expected_txn_volume;
	private String profile_match_yn;
	private String profile_mismatch_remarks;
	private String system_risk;
	private String customer_risk_reason;
	private String aof_available_yn;
	private String aof_remarks;
	private String kyc_doc_available_yn;
	private String kyc_doc_remarks;
	private String source_of_funds_available_yn;
	private String source_of_funds_remarks;
	private String branch_observations;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date review_date;
	private String reviewed_by_name;
	private String reviewed_by_ec_no;
	private String reviewed_by_designation;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date approval_date;
	private String approved_by_name;
	private String approved_by_ec_no;
	private String approved_by_designation;
	private String branch;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date entry_date;
	private String entered_by;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date doc_uploaded_date;
	private String doc_uploaded_by;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date report_date;
	private String entry_user;
	private Date entry_time;
	private String auth_user;
	private Date auth_time;
	private String modify_user;
	private Date modify_time;
	private String verify_user;
	private Date verify_time;
	private String entity_flg;
	private String auth_flg;
	private String modify_flg;
	private String del_flg;
	private String branch_name;
	private String head_signature_name;

	public String getSrlno() {
		return srlno;
	}

	public void setSrlno(String srlno) {
		this.srlno = srlno;
	}

	public String getAccount_title() {
		return account_title;
	}

	public void setAccount_title(String account_title) {
		this.account_title = account_title;
	}

	public Date getEcdd_date() {
		return ecdd_date;
	}

	public void setEcdd_date(Date ecdd_date) {
		this.ecdd_date = ecdd_date;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getAssociated_accounts() {
		return associated_accounts;
	}

	public void setAssociated_accounts(String associated_accounts) {
		this.associated_accounts = associated_accounts;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getAccount_open_date() {
		return account_open_date;
	}

	public void setAccount_open_date(Date account_open_date) {
		this.account_open_date = account_open_date;
	}

	public String getCurrency_approval_yn() {
		return currency_approval_yn;
	}

	public void setCurrency_approval_yn(String currency_approval_yn) {
		this.currency_approval_yn = currency_approval_yn;
	}

	public String getPrimary_holder_name() {
		return primary_holder_name;
	}

	public void setPrimary_holder_name(String primary_holder_name) {
		this.primary_holder_name = primary_holder_name;
	}

	public String getPrimary_customer_id() {
		return primary_customer_id;
	}

	public void setPrimary_customer_id(String primary_customer_id) {
		this.primary_customer_id = primary_customer_id;
	}

	public String getPrimary_non_resident_yn() {
		return primary_non_resident_yn;
	}

	public void setPrimary_non_resident_yn(String primary_non_resident_yn) {
		this.primary_non_resident_yn = primary_non_resident_yn;
	}

	public String getPrimary_nationality() {
		return primary_nationality;
	}

	public void setPrimary_nationality(String primary_nationality) {
		this.primary_nationality = primary_nationality;
	}

	public String getPrimary_mobile_no() {
		return primary_mobile_no;
	}

	public void setPrimary_mobile_no(String primary_mobile_no) {
		this.primary_mobile_no = primary_mobile_no;
	}

	public String getPrimary_email() {
		return primary_email;
	}

	public void setPrimary_email(String primary_email) {
		this.primary_email = primary_email;
	}

	public String getPrimary_address() {
		return primary_address;
	}

	public void setPrimary_address(String primary_address) {
		this.primary_address = primary_address;
	}

	public String getPrimary_passport_no() {
		return primary_passport_no;
	}

	public void setPrimary_passport_no(String primary_passport_no) {
		this.primary_passport_no = primary_passport_no;
	}

	public Date getPrimary_passport_exp_date() {
		return primary_passport_exp_date;
	}

	public void setPrimary_passport_exp_date(Date primary_passport_exp_date) {
		this.primary_passport_exp_date = primary_passport_exp_date;
	}

	public String getPrimary_emirates_id_no() {
		return primary_emirates_id_no;
	}

	public void setPrimary_emirates_id_no(String primary_emirates_id_no) {
		this.primary_emirates_id_no = primary_emirates_id_no;
	}

	public Date getPrimary_emirates_exp_date() {
		return primary_emirates_exp_date;
	}

	public void setPrimary_emirates_exp_date(Date primary_emirates_exp_date) {
		this.primary_emirates_exp_date = primary_emirates_exp_date;
	}

	public String getPrimary_pep_yn() {
		return primary_pep_yn;
	}

	public void setPrimary_pep_yn(String primary_pep_yn) {
		this.primary_pep_yn = primary_pep_yn;
	}

	public String getPrimary_pep_approval() {
		return primary_pep_approval;
	}

	public void setPrimary_pep_approval(String primary_pep_approval) {
		this.primary_pep_approval = primary_pep_approval;
	}

	public String getKyc_valid_yn_primary() {
		return kyc_valid_yn_primary;
	}

	public void setKyc_valid_yn_primary(String kyc_valid_yn_primary) {
		this.kyc_valid_yn_primary = kyc_valid_yn_primary;
	}

	public BigDecimal getAnnual_income_primary() {
		return annual_income_primary;
	}

	public void setAnnual_income_primary(BigDecimal annual_income_primary) {
		this.annual_income_primary = annual_income_primary;
	}

	public String getSource_of_income_primary() {
		return source_of_income_primary;
	}

	public void setSource_of_income_primary(String source_of_income_primary) {
		this.source_of_income_primary = source_of_income_primary;
	}

	public String getScreen_google_primary() {
		return screen_google_primary;
	}

	public void setScreen_google_primary(String screen_google_primary) {
		this.screen_google_primary = screen_google_primary;
	}

	public String getScreen_dowjones_primary() {
		return screen_dowjones_primary;
	}

	public void setScreen_dowjones_primary(String screen_dowjones_primary) {
		this.screen_dowjones_primary = screen_dowjones_primary;
	}

	public String getJoint1_name() {
		return joint1_name;
	}

	public void setJoint1_name(String joint1_name) {
		this.joint1_name = joint1_name;
	}

	public String getJoint1_customer_id() {
		return joint1_customer_id;
	}

	public void setJoint1_customer_id(String joint1_customer_id) {
		this.joint1_customer_id = joint1_customer_id;
	}

	public String getJoint1_non_resident_yn() {
		return joint1_non_resident_yn;
	}

	public void setJoint1_non_resident_yn(String joint1_non_resident_yn) {
		this.joint1_non_resident_yn = joint1_non_resident_yn;
	}

	public String getJoint1_nationality() {
		return joint1_nationality;
	}

	public void setJoint1_nationality(String joint1_nationality) {
		this.joint1_nationality = joint1_nationality;
	}

	public String getJoint1_mobile_no() {
		return joint1_mobile_no;
	}

	public void setJoint1_mobile_no(String joint1_mobile_no) {
		this.joint1_mobile_no = joint1_mobile_no;
	}

	public String getJoint1_email() {
		return joint1_email;
	}

	public void setJoint1_email(String joint1_email) {
		this.joint1_email = joint1_email;
	}

	public String getJoint1_address() {
		return joint1_address;
	}

	public void setJoint1_address(String joint1_address) {
		this.joint1_address = joint1_address;
	}

	public String getJoint1_passport_no() {
		return joint1_passport_no;
	}

	public void setJoint1_passport_no(String joint1_passport_no) {
		this.joint1_passport_no = joint1_passport_no;
	}

	public Date getJoint1_passport_exp_date() {
		return joint1_passport_exp_date;
	}

	public void setJoint1_passport_exp_date(Date joint1_passport_exp_date) {
		this.joint1_passport_exp_date = joint1_passport_exp_date;
	}

	public String getJoint1_emirates_id_no() {
		return joint1_emirates_id_no;
	}

	public void setJoint1_emirates_id_no(String joint1_emirates_id_no) {
		this.joint1_emirates_id_no = joint1_emirates_id_no;
	}

	public Date getJoint1_emirates_exp_date() {
		return joint1_emirates_exp_date;
	}

	public void setJoint1_emirates_exp_date(Date joint1_emirates_exp_date) {
		this.joint1_emirates_exp_date = joint1_emirates_exp_date;
	}

	public String getJoint1_pep_yn() {
		return joint1_pep_yn;
	}

	public void setJoint1_pep_yn(String joint1_pep_yn) {
		this.joint1_pep_yn = joint1_pep_yn;
	}

	public String getJoint1_pep_approval() {
		return joint1_pep_approval;
	}

	public void setJoint1_pep_approval(String joint1_pep_approval) {
		this.joint1_pep_approval = joint1_pep_approval;
	}

	public String getKyc_valid_yn_joint1() {
		return kyc_valid_yn_joint1;
	}

	public void setKyc_valid_yn_joint1(String kyc_valid_yn_joint1) {
		this.kyc_valid_yn_joint1 = kyc_valid_yn_joint1;
	}

	public BigDecimal getAnnual_income_joint1() {
		return annual_income_joint1;
	}

	public void setAnnual_income_joint1(BigDecimal annual_income_joint1) {
		this.annual_income_joint1 = annual_income_joint1;
	}

	public String getSource_of_income_joint1() {
		return source_of_income_joint1;
	}

	public void setSource_of_income_joint1(String source_of_income_joint1) {
		this.source_of_income_joint1 = source_of_income_joint1;
	}

	public String getScreen_google_joint1() {
		return screen_google_joint1;
	}

	public void setScreen_google_joint1(String screen_google_joint1) {
		this.screen_google_joint1 = screen_google_joint1;
	}

	public String getScreen_dowjones_joint1() {
		return screen_dowjones_joint1;
	}

	public void setScreen_dowjones_joint1(String screen_dowjones_joint1) {
		this.screen_dowjones_joint1 = screen_dowjones_joint1;
	}

	public String getJoint2_name() {
		return joint2_name;
	}

	public void setJoint2_name(String joint2_name) {
		this.joint2_name = joint2_name;
	}

	public String getJoint2_customer_id() {
		return joint2_customer_id;
	}

	public void setJoint2_customer_id(String joint2_customer_id) {
		this.joint2_customer_id = joint2_customer_id;
	}

	public String getJoint2_non_resident_yn() {
		return joint2_non_resident_yn;
	}

	public void setJoint2_non_resident_yn(String joint2_non_resident_yn) {
		this.joint2_non_resident_yn = joint2_non_resident_yn;
	}

	public String getJoint2_nationality() {
		return joint2_nationality;
	}

	public void setJoint2_nationality(String joint2_nationality) {
		this.joint2_nationality = joint2_nationality;
	}

	public String getJoint2_mobile_no() {
		return joint2_mobile_no;
	}

	public void setJoint2_mobile_no(String joint2_mobile_no) {
		this.joint2_mobile_no = joint2_mobile_no;
	}

	public String getJoint2_email() {
		return joint2_email;
	}

	public void setJoint2_email(String joint2_email) {
		this.joint2_email = joint2_email;
	}

	public String getJoint2_address() {
		return joint2_address;
	}

	public void setJoint2_address(String joint2_address) {
		this.joint2_address = joint2_address;
	}

	public String getJoint2_passport_no() {
		return joint2_passport_no;
	}

	public void setJoint2_passport_no(String joint2_passport_no) {
		this.joint2_passport_no = joint2_passport_no;
	}

	public Date getJoint2_passport_exp_date() {
		return joint2_passport_exp_date;
	}

	public void setJoint2_passport_exp_date(Date joint2_passport_exp_date) {
		this.joint2_passport_exp_date = joint2_passport_exp_date;
	}

	public String getJoint2_emirates_id_no() {
		return joint2_emirates_id_no;
	}

	public void setJoint2_emirates_id_no(String joint2_emirates_id_no) {
		this.joint2_emirates_id_no = joint2_emirates_id_no;
	}

	public Date getJoint2_emirates_exp_date() {
		return joint2_emirates_exp_date;
	}

	public void setJoint2_emirates_exp_date(Date joint2_emirates_exp_date) {
		this.joint2_emirates_exp_date = joint2_emirates_exp_date;
	}

	public String getJoint2_pep_yn() {
		return joint2_pep_yn;
	}

	public void setJoint2_pep_yn(String joint2_pep_yn) {
		this.joint2_pep_yn = joint2_pep_yn;
	}

	public String getJoint2_pep_approval() {
		return joint2_pep_approval;
	}

	public void setJoint2_pep_approval(String joint2_pep_approval) {
		this.joint2_pep_approval = joint2_pep_approval;
	}

	public String getKyc_valid_yn_joint2() {
		return kyc_valid_yn_joint2;
	}

	public void setKyc_valid_yn_joint2(String kyc_valid_yn_joint2) {
		this.kyc_valid_yn_joint2 = kyc_valid_yn_joint2;
	}

	public BigDecimal getAnnual_income_joint2() {
		return annual_income_joint2;
	}

	public void setAnnual_income_joint2(BigDecimal annual_income_joint2) {
		this.annual_income_joint2 = annual_income_joint2;
	}

	public String getSource_of_income_joint2() {
		return source_of_income_joint2;
	}

	public void setSource_of_income_joint2(String source_of_income_joint2) {
		this.source_of_income_joint2 = source_of_income_joint2;
	}

	public String getScreen_google_joint2() {
		return screen_google_joint2;
	}

	public void setScreen_google_joint2(String screen_google_joint2) {
		this.screen_google_joint2 = screen_google_joint2;
	}

	public String getScreen_dowjones_joint2() {
		return screen_dowjones_joint2;
	}

	public void setScreen_dowjones_joint2(String screen_dowjones_joint2) {
		this.screen_dowjones_joint2 = screen_dowjones_joint2;
	}

	public String getJoint3_name() {
		return joint3_name;
	}

	public void setJoint3_name(String joint3_name) {
		this.joint3_name = joint3_name;
	}

	public String getJoint3_customer_id() {
		return joint3_customer_id;
	}

	public void setJoint3_customer_id(String joint3_customer_id) {
		this.joint3_customer_id = joint3_customer_id;
	}

	public String getJoint3_non_resident_yn() {
		return joint3_non_resident_yn;
	}

	public void setJoint3_non_resident_yn(String joint3_non_resident_yn) {
		this.joint3_non_resident_yn = joint3_non_resident_yn;
	}

	public String getJoint3_nationality() {
		return joint3_nationality;
	}

	public void setJoint3_nationality(String joint3_nationality) {
		this.joint3_nationality = joint3_nationality;
	}

	public String getJoint3_mobile_no() {
		return joint3_mobile_no;
	}

	public void setJoint3_mobile_no(String joint3_mobile_no) {
		this.joint3_mobile_no = joint3_mobile_no;
	}

	public String getJoint3_email() {
		return joint3_email;
	}

	public void setJoint3_email(String joint3_email) {
		this.joint3_email = joint3_email;
	}

	public String getJoint3_address() {
		return joint3_address;
	}

	public void setJoint3_address(String joint3_address) {
		this.joint3_address = joint3_address;
	}

	public String getJoint3_passport_no() {
		return joint3_passport_no;
	}

	public void setJoint3_passport_no(String joint3_passport_no) {
		this.joint3_passport_no = joint3_passport_no;
	}

	public Date getJoint3_passport_exp_date() {
		return joint3_passport_exp_date;
	}

	public void setJoint3_passport_exp_date(Date joint3_passport_exp_date) {
		this.joint3_passport_exp_date = joint3_passport_exp_date;
	}

	public String getJoint3_emirates_id_no() {
		return joint3_emirates_id_no;
	}

	public void setJoint3_emirates_id_no(String joint3_emirates_id_no) {
		this.joint3_emirates_id_no = joint3_emirates_id_no;
	}

	public Date getJoint3_emirates_exp_date() {
		return joint3_emirates_exp_date;
	}

	public void setJoint3_emirates_exp_date(Date joint3_emirates_exp_date) {
		this.joint3_emirates_exp_date = joint3_emirates_exp_date;
	}

	public String getJoint3_pep_yn() {
		return joint3_pep_yn;
	}

	public void setJoint3_pep_yn(String joint3_pep_yn) {
		this.joint3_pep_yn = joint3_pep_yn;
	}

	public String getJoint3_pep_approval() {
		return joint3_pep_approval;
	}

	public void setJoint3_pep_approval(String joint3_pep_approval) {
		this.joint3_pep_approval = joint3_pep_approval;
	}

	public String getKyc_valid_yn_joint3() {
		return kyc_valid_yn_joint3;
	}

	public void setKyc_valid_yn_joint3(String kyc_valid_yn_joint3) {
		this.kyc_valid_yn_joint3 = kyc_valid_yn_joint3;
	}

	public BigDecimal getAnnual_income_joint3() {
		return annual_income_joint3;
	}

	public void setAnnual_income_joint3(BigDecimal annual_income_joint3) {
		this.annual_income_joint3 = annual_income_joint3;
	}

	public String getSource_of_income_joint3() {
		return source_of_income_joint3;
	}

	public void setSource_of_income_joint3(String source_of_income_joint3) {
		this.source_of_income_joint3 = source_of_income_joint3;
	}

	public String getScreen_google_joint3() {
		return screen_google_joint3;
	}

	public void setScreen_google_joint3(String screen_google_joint3) {
		this.screen_google_joint3 = screen_google_joint3;
	}

	public String getScreen_dowjones_joint3() {
		return screen_dowjones_joint3;
	}

	public void setScreen_dowjones_joint3(String screen_dowjones_joint3) {
		this.screen_dowjones_joint3 = screen_dowjones_joint3;
	}

	public String getBranch_remarks() {
		return branch_remarks;
	}

	public void setBranch_remarks(String branch_remarks) {
		this.branch_remarks = branch_remarks;
	}

	public String getUnusual_txn_details() {
		return unusual_txn_details;
	}

	public void setUnusual_txn_details(String unusual_txn_details) {
		this.unusual_txn_details = unusual_txn_details;
	}

	public String getSuspicious_activity() {
		return suspicious_activity;
	}

	public void setSuspicious_activity(String suspicious_activity) {
		this.suspicious_activity = suspicious_activity;
	}

	public BigDecimal getHigh_value_txn_count() {
		return high_value_txn_count;
	}

	public void setHigh_value_txn_count(BigDecimal high_value_txn_count) {
		this.high_value_txn_count = high_value_txn_count;
	}

	public BigDecimal getHigh_value_txn_volume() {
		return high_value_txn_volume;
	}

	public void setHigh_value_txn_volume(BigDecimal high_value_txn_volume) {
		this.high_value_txn_volume = high_value_txn_volume;
	}

	public BigDecimal getFrequency_txn_percent() {
		return frequency_txn_percent;
	}

	public void setFrequency_txn_percent(BigDecimal frequency_txn_percent) {
		this.frequency_txn_percent = frequency_txn_percent;
	}

	public BigDecimal getVolume_turnover_percent() {
		return volume_turnover_percent;
	}

	public void setVolume_turnover_percent(BigDecimal volume_turnover_percent) {
		this.volume_turnover_percent = volume_turnover_percent;
	}

	public BigDecimal getCash_txn_count() {
		return cash_txn_count;
	}

	public void setCash_txn_count(BigDecimal cash_txn_count) {
		this.cash_txn_count = cash_txn_count;
	}

	public BigDecimal getCash_txn_volume() {
		return cash_txn_volume;
	}

	public void setCash_txn_volume(BigDecimal cash_txn_volume) {
		this.cash_txn_volume = cash_txn_volume;
	}

	public BigDecimal getCheque_txn_count() {
		return cheque_txn_count;
	}

	public void setCheque_txn_count(BigDecimal cheque_txn_count) {
		this.cheque_txn_count = cheque_txn_count;
	}

	public BigDecimal getCheque_txn_volume() {
		return cheque_txn_volume;
	}

	public void setCheque_txn_volume(BigDecimal cheque_txn_volume) {
		this.cheque_txn_volume = cheque_txn_volume;
	}

	public BigDecimal getLocal_txn_count() {
		return local_txn_count;
	}

	public void setLocal_txn_count(BigDecimal local_txn_count) {
		this.local_txn_count = local_txn_count;
	}

	public BigDecimal getLocal_txn_volume() {
		return local_txn_volume;
	}

	public void setLocal_txn_volume(BigDecimal local_txn_volume) {
		this.local_txn_volume = local_txn_volume;
	}

	public BigDecimal getIntl_txn_count() {
		return intl_txn_count;
	}

	public void setIntl_txn_count(BigDecimal intl_txn_count) {
		this.intl_txn_count = intl_txn_count;
	}

	public BigDecimal getIntl_txn_volume() {
		return intl_txn_volume;
	}

	public void setIntl_txn_volume(BigDecimal intl_txn_volume) {
		this.intl_txn_volume = intl_txn_volume;
	}

	public BigDecimal getCurr_txn_count() {
		return curr_txn_count;
	}

	public void setCurr_txn_count(BigDecimal curr_txn_count) {
		this.curr_txn_count = curr_txn_count;
	}

	public BigDecimal getCurr_txn_volume() {
		return curr_txn_volume;
	}

	public void setCurr_txn_volume(BigDecimal curr_txn_volume) {
		this.curr_txn_volume = curr_txn_volume;
	}

	public BigDecimal getExpected_txn_count() {
		return expected_txn_count;
	}

	public void setExpected_txn_count(BigDecimal expected_txn_count) {
		this.expected_txn_count = expected_txn_count;
	}

	public BigDecimal getExpected_txn_volume() {
		return expected_txn_volume;
	}

	public void setExpected_txn_volume(BigDecimal expected_txn_volume) {
		this.expected_txn_volume = expected_txn_volume;
	}

	public String getProfile_match_yn() {
		return profile_match_yn;
	}

	public void setProfile_match_yn(String profile_match_yn) {
		this.profile_match_yn = profile_match_yn;
	}

	public String getProfile_mismatch_remarks() {
		return profile_mismatch_remarks;
	}

	public void setProfile_mismatch_remarks(String profile_mismatch_remarks) {
		this.profile_mismatch_remarks = profile_mismatch_remarks;
	}

	public String getSystem_risk() {
		return system_risk;
	}

	public void setSystem_risk(String system_risk) {
		this.system_risk = system_risk;
	}

	public String getCustomer_risk_reason() {
		return customer_risk_reason;
	}

	public void setCustomer_risk_reason(String customer_risk_reason) {
		this.customer_risk_reason = customer_risk_reason;
	}

	public String getAof_available_yn() {
		return aof_available_yn;
	}

	public void setAof_available_yn(String aof_available_yn) {
		this.aof_available_yn = aof_available_yn;
	}

	public String getAof_remarks() {
		return aof_remarks;
	}

	public void setAof_remarks(String aof_remarks) {
		this.aof_remarks = aof_remarks;
	}

	public String getKyc_doc_available_yn() {
		return kyc_doc_available_yn;
	}

	public void setKyc_doc_available_yn(String kyc_doc_available_yn) {
		this.kyc_doc_available_yn = kyc_doc_available_yn;
	}

	public String getKyc_doc_remarks() {
		return kyc_doc_remarks;
	}

	public void setKyc_doc_remarks(String kyc_doc_remarks) {
		this.kyc_doc_remarks = kyc_doc_remarks;
	}

	public String getSource_of_funds_available_yn() {
		return source_of_funds_available_yn;
	}

	public void setSource_of_funds_available_yn(String source_of_funds_available_yn) {
		this.source_of_funds_available_yn = source_of_funds_available_yn;
	}

	public String getSource_of_funds_remarks() {
		return source_of_funds_remarks;
	}

	public void setSource_of_funds_remarks(String source_of_funds_remarks) {
		this.source_of_funds_remarks = source_of_funds_remarks;
	}

	public String getBranch_observations() {
		return branch_observations;
	}

	public void setBranch_observations(String branch_observations) {
		this.branch_observations = branch_observations;
	}

	public Date getReview_date() {
		return review_date;
	}

	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}

	public String getReviewed_by_name() {
		return reviewed_by_name;
	}

	public void setReviewed_by_name(String reviewed_by_name) {
		this.reviewed_by_name = reviewed_by_name;
	}

	public String getReviewed_by_ec_no() {
		return reviewed_by_ec_no;
	}

	public void setReviewed_by_ec_no(String reviewed_by_ec_no) {
		this.reviewed_by_ec_no = reviewed_by_ec_no;
	}

	public String getReviewed_by_designation() {
		return reviewed_by_designation;
	}

	public void setReviewed_by_designation(String reviewed_by_designation) {
		this.reviewed_by_designation = reviewed_by_designation;
	}

	public Date getApproval_date() {
		return approval_date;
	}

	public void setApproval_date(Date approval_date) {
		this.approval_date = approval_date;
	}

	public String getApproved_by_name() {
		return approved_by_name;
	}

	public void setApproved_by_name(String approved_by_name) {
		this.approved_by_name = approved_by_name;
	}

	public String getApproved_by_ec_no() {
		return approved_by_ec_no;
	}

	public void setApproved_by_ec_no(String approved_by_ec_no) {
		this.approved_by_ec_no = approved_by_ec_no;
	}

	public String getApproved_by_designation() {
		return approved_by_designation;
	}

	public void setApproved_by_designation(String approved_by_designation) {
		this.approved_by_designation = approved_by_designation;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getEntry_date() {
		return entry_date;
	}

	public void setEntry_date(Date entry_date) {
		this.entry_date = entry_date;
	}

	public String getEntered_by() {
		return entered_by;
	}

	public void setEntered_by(String entered_by) {
		this.entered_by = entered_by;
	}

	public Date getDoc_uploaded_date() {
		return doc_uploaded_date;
	}

	public void setDoc_uploaded_date(Date doc_uploaded_date) {
		this.doc_uploaded_date = doc_uploaded_date;
	}

	public String getDoc_uploaded_by() {
		return doc_uploaded_by;
	}

	public void setDoc_uploaded_by(String doc_uploaded_by) {
		this.doc_uploaded_by = doc_uploaded_by;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
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

	public String getAuth_user() {
		return auth_user;
	}

	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}

	public Date getAuth_time() {
		return auth_time;
	}

	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
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

	public String getAuth_flg() {
		return auth_flg;
	}

	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
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

	public String getBranch_name() {
		return branch_name;
	}

	public void setBranch_name(String branch_name) {
		this.branch_name = branch_name;
	}

	public String getHead_signature_name() {
		return head_signature_name;
	}

	public void setHead_signature_name(String head_signature_name) {
		this.head_signature_name = head_signature_name;
	}

	@Override
	public String toString() {
		return "Ecdd_Individual_Profile_Entity [srlno=" + srlno + ", account_title=" + account_title + ", ecdd_date="
				+ ecdd_date + ", customer_id=" + customer_id + ", associated_accounts=" + associated_accounts
				+ ", currency=" + currency + ", account_open_date=" + account_open_date + ", currency_approval_yn="
				+ currency_approval_yn + ", primary_holder_name=" + primary_holder_name + ", primary_customer_id="
				+ primary_customer_id + ", primary_non_resident_yn=" + primary_non_resident_yn
				+ ", primary_nationality=" + primary_nationality + ", primary_mobile_no=" + primary_mobile_no
				+ ", primary_email=" + primary_email + ", primary_address=" + primary_address + ", primary_passport_no="
				+ primary_passport_no + ", primary_passport_exp_date=" + primary_passport_exp_date
				+ ", primary_emirates_id_no=" + primary_emirates_id_no + ", primary_emirates_exp_date="
				+ primary_emirates_exp_date + ", primary_pep_yn=" + primary_pep_yn + ", primary_pep_approval="
				+ primary_pep_approval + ", kyc_valid_yn_primary=" + kyc_valid_yn_primary + ", annual_income_primary="
				+ annual_income_primary + ", source_of_income_primary=" + source_of_income_primary
				+ ", screen_google_primary=" + screen_google_primary + ", screen_dowjones_primary="
				+ screen_dowjones_primary + ", joint1_name=" + joint1_name + ", joint1_customer_id="
				+ joint1_customer_id + ", joint1_non_resident_yn=" + joint1_non_resident_yn + ", joint1_nationality="
				+ joint1_nationality + ", joint1_mobile_no=" + joint1_mobile_no + ", joint1_email=" + joint1_email
				+ ", joint1_address=" + joint1_address + ", joint1_passport_no=" + joint1_passport_no
				+ ", joint1_passport_exp_date=" + joint1_passport_exp_date + ", joint1_emirates_id_no="
				+ joint1_emirates_id_no + ", joint1_emirates_exp_date=" + joint1_emirates_exp_date + ", joint1_pep_yn="
				+ joint1_pep_yn + ", joint1_pep_approval=" + joint1_pep_approval + ", kyc_valid_yn_joint1="
				+ kyc_valid_yn_joint1 + ", annual_income_joint1=" + annual_income_joint1 + ", source_of_income_joint1="
				+ source_of_income_joint1 + ", screen_google_joint1=" + screen_google_joint1
				+ ", screen_dowjones_joint1=" + screen_dowjones_joint1 + ", joint2_name=" + joint2_name
				+ ", joint2_customer_id=" + joint2_customer_id + ", joint2_non_resident_yn=" + joint2_non_resident_yn
				+ ", joint2_nationality=" + joint2_nationality + ", joint2_mobile_no=" + joint2_mobile_no
				+ ", joint2_email=" + joint2_email + ", joint2_address=" + joint2_address + ", joint2_passport_no="
				+ joint2_passport_no + ", joint2_passport_exp_date=" + joint2_passport_exp_date
				+ ", joint2_emirates_id_no=" + joint2_emirates_id_no + ", joint2_emirates_exp_date="
				+ joint2_emirates_exp_date + ", joint2_pep_yn=" + joint2_pep_yn + ", joint2_pep_approval="
				+ joint2_pep_approval + ", kyc_valid_yn_joint2=" + kyc_valid_yn_joint2 + ", annual_income_joint2="
				+ annual_income_joint2 + ", source_of_income_joint2=" + source_of_income_joint2
				+ ", screen_google_joint2=" + screen_google_joint2 + ", screen_dowjones_joint2="
				+ screen_dowjones_joint2 + ", joint3_name=" + joint3_name + ", joint3_customer_id=" + joint3_customer_id
				+ ", joint3_non_resident_yn=" + joint3_non_resident_yn + ", joint3_nationality=" + joint3_nationality
				+ ", joint3_mobile_no=" + joint3_mobile_no + ", joint3_email=" + joint3_email + ", joint3_address="
				+ joint3_address + ", joint3_passport_no=" + joint3_passport_no + ", joint3_passport_exp_date="
				+ joint3_passport_exp_date + ", joint3_emirates_id_no=" + joint3_emirates_id_no
				+ ", joint3_emirates_exp_date=" + joint3_emirates_exp_date + ", joint3_pep_yn=" + joint3_pep_yn
				+ ", joint3_pep_approval=" + joint3_pep_approval + ", kyc_valid_yn_joint3=" + kyc_valid_yn_joint3
				+ ", annual_income_joint3=" + annual_income_joint3 + ", source_of_income_joint3="
				+ source_of_income_joint3 + ", screen_google_joint3=" + screen_google_joint3
				+ ", screen_dowjones_joint3=" + screen_dowjones_joint3 + ", branch_remarks=" + branch_remarks
				+ ", unusual_txn_details=" + unusual_txn_details + ", suspicious_activity=" + suspicious_activity
				+ ", high_value_txn_count=" + high_value_txn_count + ", high_value_txn_volume=" + high_value_txn_volume
				+ ", frequency_txn_percent=" + frequency_txn_percent + ", volume_turnover_percent="
				+ volume_turnover_percent + ", cash_txn_count=" + cash_txn_count + ", cash_txn_volume="
				+ cash_txn_volume + ", cheque_txn_count=" + cheque_txn_count + ", cheque_txn_volume="
				+ cheque_txn_volume + ", local_txn_count=" + local_txn_count + ", local_txn_volume=" + local_txn_volume
				+ ", intl_txn_count=" + intl_txn_count + ", intl_txn_volume=" + intl_txn_volume + ", curr_txn_count="
				+ curr_txn_count + ", curr_txn_volume=" + curr_txn_volume + ", expected_txn_count=" + expected_txn_count
				+ ", expected_txn_volume=" + expected_txn_volume + ", profile_match_yn=" + profile_match_yn
				+ ", profile_mismatch_remarks=" + profile_mismatch_remarks + ", system_risk=" + system_risk
				+ ", customer_risk_reason=" + customer_risk_reason + ", aof_available_yn=" + aof_available_yn
				+ ", aof_remarks=" + aof_remarks + ", kyc_doc_available_yn=" + kyc_doc_available_yn
				+ ", kyc_doc_remarks=" + kyc_doc_remarks + ", source_of_funds_available_yn="
				+ source_of_funds_available_yn + ", source_of_funds_remarks=" + source_of_funds_remarks
				+ ", branch_observations=" + branch_observations + ", review_date=" + review_date
				+ ", reviewed_by_name=" + reviewed_by_name + ", reviewed_by_ec_no=" + reviewed_by_ec_no
				+ ", reviewed_by_designation=" + reviewed_by_designation + ", approval_date=" + approval_date
				+ ", approved_by_name=" + approved_by_name + ", approved_by_ec_no=" + approved_by_ec_no
				+ ", approved_by_designation=" + approved_by_designation + ", branch=" + branch + ", entry_date="
				+ entry_date + ", entered_by=" + entered_by + ", doc_uploaded_date=" + doc_uploaded_date
				+ ", doc_uploaded_by=" + doc_uploaded_by + ", report_date=" + report_date + ", entry_user=" + entry_user
				+ ", entry_time=" + entry_time + ", auth_user=" + auth_user + ", auth_time=" + auth_time
				+ ", modify_user=" + modify_user + ", modify_time=" + modify_time + ", verify_user=" + verify_user
				+ ", verify_time=" + verify_time + ", entity_flg=" + entity_flg + ", auth_flg=" + auth_flg
				+ ", modify_flg=" + modify_flg + ", del_flg=" + del_flg + ", branch_name=" + branch_name
				+ ", head_signature_name=" + head_signature_name + ", getSrlno()=" + getSrlno()
				+ ", getAccount_title()=" + getAccount_title() + ", getEcdd_date()=" + getEcdd_date()
				+ ", getCustomer_id()=" + getCustomer_id() + ", getAssociated_accounts()=" + getAssociated_accounts()
				+ ", getCurrency()=" + getCurrency() + ", getAccount_open_date()=" + getAccount_open_date()
				+ ", getCurrency_approval_yn()=" + getCurrency_approval_yn() + ", getPrimary_holder_name()="
				+ getPrimary_holder_name() + ", getPrimary_customer_id()=" + getPrimary_customer_id()
				+ ", getPrimary_non_resident_yn()=" + getPrimary_non_resident_yn() + ", getPrimary_nationality()="
				+ getPrimary_nationality() + ", getPrimary_mobile_no()=" + getPrimary_mobile_no()
				+ ", getPrimary_email()=" + getPrimary_email() + ", getPrimary_address()=" + getPrimary_address()
				+ ", getPrimary_passport_no()=" + getPrimary_passport_no() + ", getPrimary_passport_exp_date()="
				+ getPrimary_passport_exp_date() + ", getPrimary_emirates_id_no()=" + getPrimary_emirates_id_no()
				+ ", getPrimary_emirates_exp_date()=" + getPrimary_emirates_exp_date() + ", getPrimary_pep_yn()="
				+ getPrimary_pep_yn() + ", getPrimary_pep_approval()=" + getPrimary_pep_approval()
				+ ", getKyc_valid_yn_primary()=" + getKyc_valid_yn_primary() + ", getAnnual_income_primary()="
				+ getAnnual_income_primary() + ", getSource_of_income_primary()=" + getSource_of_income_primary()
				+ ", getScreen_google_primary()=" + getScreen_google_primary() + ", getScreen_dowjones_primary()="
				+ getScreen_dowjones_primary() + ", getJoint1_name()=" + getJoint1_name() + ", getJoint1_customer_id()="
				+ getJoint1_customer_id() + ", getJoint1_non_resident_yn()=" + getJoint1_non_resident_yn()
				+ ", getJoint1_nationality()=" + getJoint1_nationality() + ", getJoint1_mobile_no()="
				+ getJoint1_mobile_no() + ", getJoint1_email()=" + getJoint1_email() + ", getJoint1_address()="
				+ getJoint1_address() + ", getJoint1_passport_no()=" + getJoint1_passport_no()
				+ ", getJoint1_passport_exp_date()=" + getJoint1_passport_exp_date() + ", getJoint1_emirates_id_no()="
				+ getJoint1_emirates_id_no() + ", getJoint1_emirates_exp_date()=" + getJoint1_emirates_exp_date()
				+ ", getJoint1_pep_yn()=" + getJoint1_pep_yn() + ", getJoint1_pep_approval()="
				+ getJoint1_pep_approval() + ", getKyc_valid_yn_joint1()=" + getKyc_valid_yn_joint1()
				+ ", getAnnual_income_joint1()=" + getAnnual_income_joint1() + ", getSource_of_income_joint1()="
				+ getSource_of_income_joint1() + ", getScreen_google_joint1()=" + getScreen_google_joint1()
				+ ", getScreen_dowjones_joint1()=" + getScreen_dowjones_joint1() + ", getJoint2_name()="
				+ getJoint2_name() + ", getJoint2_customer_id()=" + getJoint2_customer_id()
				+ ", getJoint2_non_resident_yn()=" + getJoint2_non_resident_yn() + ", getJoint2_nationality()="
				+ getJoint2_nationality() + ", getJoint2_mobile_no()=" + getJoint2_mobile_no() + ", getJoint2_email()="
				+ getJoint2_email() + ", getJoint2_address()=" + getJoint2_address() + ", getJoint2_passport_no()="
				+ getJoint2_passport_no() + ", getJoint2_passport_exp_date()=" + getJoint2_passport_exp_date()
				+ ", getJoint2_emirates_id_no()=" + getJoint2_emirates_id_no() + ", getJoint2_emirates_exp_date()="
				+ getJoint2_emirates_exp_date() + ", getJoint2_pep_yn()=" + getJoint2_pep_yn()
				+ ", getJoint2_pep_approval()=" + getJoint2_pep_approval() + ", getKyc_valid_yn_joint2()="
				+ getKyc_valid_yn_joint2() + ", getAnnual_income_joint2()=" + getAnnual_income_joint2()
				+ ", getSource_of_income_joint2()=" + getSource_of_income_joint2() + ", getScreen_google_joint2()="
				+ getScreen_google_joint2() + ", getScreen_dowjones_joint2()=" + getScreen_dowjones_joint2()
				+ ", getJoint3_name()=" + getJoint3_name() + ", getJoint3_customer_id()=" + getJoint3_customer_id()
				+ ", getJoint3_non_resident_yn()=" + getJoint3_non_resident_yn() + ", getJoint3_nationality()="
				+ getJoint3_nationality() + ", getJoint3_mobile_no()=" + getJoint3_mobile_no() + ", getJoint3_email()="
				+ getJoint3_email() + ", getJoint3_address()=" + getJoint3_address() + ", getJoint3_passport_no()="
				+ getJoint3_passport_no() + ", getJoint3_passport_exp_date()=" + getJoint3_passport_exp_date()
				+ ", getJoint3_emirates_id_no()=" + getJoint3_emirates_id_no() + ", getJoint3_emirates_exp_date()="
				+ getJoint3_emirates_exp_date() + ", getJoint3_pep_yn()=" + getJoint3_pep_yn()
				+ ", getJoint3_pep_approval()=" + getJoint3_pep_approval() + ", getKyc_valid_yn_joint3()="
				+ getKyc_valid_yn_joint3() + ", getAnnual_income_joint3()=" + getAnnual_income_joint3()
				+ ", getSource_of_income_joint3()=" + getSource_of_income_joint3() + ", getScreen_google_joint3()="
				+ getScreen_google_joint3() + ", getScreen_dowjones_joint3()=" + getScreen_dowjones_joint3()
				+ ", getBranch_remarks()=" + getBranch_remarks() + ", getUnusual_txn_details()="
				+ getUnusual_txn_details() + ", getSuspicious_activity()=" + getSuspicious_activity()
				+ ", getHigh_value_txn_count()=" + getHigh_value_txn_count() + ", getHigh_value_txn_volume()="
				+ getHigh_value_txn_volume() + ", getFrequency_txn_percent()=" + getFrequency_txn_percent()
				+ ", getVolume_turnover_percent()=" + getVolume_turnover_percent() + ", getCash_txn_count()="
				+ getCash_txn_count() + ", getCash_txn_volume()=" + getCash_txn_volume() + ", getCheque_txn_count()="
				+ getCheque_txn_count() + ", getCheque_txn_volume()=" + getCheque_txn_volume()
				+ ", getLocal_txn_count()=" + getLocal_txn_count() + ", getLocal_txn_volume()=" + getLocal_txn_volume()
				+ ", getIntl_txn_count()=" + getIntl_txn_count() + ", getIntl_txn_volume()=" + getIntl_txn_volume()
				+ ", getCurr_txn_count()=" + getCurr_txn_count() + ", getCurr_txn_volume()=" + getCurr_txn_volume()
				+ ", getExpected_txn_count()=" + getExpected_txn_count() + ", getExpected_txn_volume()="
				+ getExpected_txn_volume() + ", getProfile_match_yn()=" + getProfile_match_yn()
				+ ", getProfile_mismatch_remarks()=" + getProfile_mismatch_remarks() + ", getSystem_risk()="
				+ getSystem_risk() + ", getCustomer_risk_reason()=" + getCustomer_risk_reason()
				+ ", getAof_available_yn()=" + getAof_available_yn() + ", getAof_remarks()=" + getAof_remarks()
				+ ", getKyc_doc_available_yn()=" + getKyc_doc_available_yn() + ", getKyc_doc_remarks()="
				+ getKyc_doc_remarks() + ", getSource_of_funds_available_yn()=" + getSource_of_funds_available_yn()
				+ ", getSource_of_funds_remarks()=" + getSource_of_funds_remarks() + ", getBranch_observations()="
				+ getBranch_observations() + ", getReview_date()=" + getReview_date() + ", getReviewed_by_name()="
				+ getReviewed_by_name() + ", getReviewed_by_ec_no()=" + getReviewed_by_ec_no()
				+ ", getReviewed_by_designation()=" + getReviewed_by_designation() + ", getApproval_date()="
				+ getApproval_date() + ", getApproved_by_name()=" + getApproved_by_name() + ", getApproved_by_ec_no()="
				+ getApproved_by_ec_no() + ", getApproved_by_designation()=" + getApproved_by_designation()
				+ ", getBranch()=" + getBranch() + ", getEntry_date()=" + getEntry_date() + ", getEntered_by()="
				+ getEntered_by() + ", getDoc_uploaded_date()=" + getDoc_uploaded_date() + ", getDoc_uploaded_by()="
				+ getDoc_uploaded_by() + ", getReport_date()=" + getReport_date() + ", getEntry_user()="
				+ getEntry_user() + ", getEntry_time()=" + getEntry_time() + ", getAuth_user()=" + getAuth_user()
				+ ", getAuth_time()=" + getAuth_time() + ", getModify_user()=" + getModify_user()
				+ ", getModify_time()=" + getModify_time() + ", getVerify_user()=" + getVerify_user()
				+ ", getVerify_time()=" + getVerify_time() + ", getEntity_flg()=" + getEntity_flg() + ", getAuth_flg()="
				+ getAuth_flg() + ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg()
				+ ", getBranch_name()=" + getBranch_name() + ", getHead_signature_name()=" + getHead_signature_name()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public Ecdd_Individual_Profile_Entity(String srlno, String account_title, Date ecdd_date, String customer_id,
			String associated_accounts, String currency, Date account_open_date, String currency_approval_yn,
			String primary_holder_name, String primary_customer_id, String primary_non_resident_yn,
			String primary_nationality, String primary_mobile_no, String primary_email, String primary_address,
			String primary_passport_no, Date primary_passport_exp_date, String primary_emirates_id_no,
			Date primary_emirates_exp_date, String primary_pep_yn, String primary_pep_approval,
			String kyc_valid_yn_primary, BigDecimal annual_income_primary, String source_of_income_primary,
			String screen_google_primary, String screen_dowjones_primary, String joint1_name, String joint1_customer_id,
			String joint1_non_resident_yn, String joint1_nationality, String joint1_mobile_no, String joint1_email,
			String joint1_address, String joint1_passport_no, Date joint1_passport_exp_date,
			String joint1_emirates_id_no, Date joint1_emirates_exp_date, String joint1_pep_yn,
			String joint1_pep_approval, String kyc_valid_yn_joint1, BigDecimal annual_income_joint1,
			String source_of_income_joint1, String screen_google_joint1, String screen_dowjones_joint1,
			String joint2_name, String joint2_customer_id, String joint2_non_resident_yn, String joint2_nationality,
			String joint2_mobile_no, String joint2_email, String joint2_address, String joint2_passport_no,
			Date joint2_passport_exp_date, String joint2_emirates_id_no, Date joint2_emirates_exp_date,
			String joint2_pep_yn, String joint2_pep_approval, String kyc_valid_yn_joint2,
			BigDecimal annual_income_joint2, String source_of_income_joint2, String screen_google_joint2,
			String screen_dowjones_joint2, String joint3_name, String joint3_customer_id, String joint3_non_resident_yn,
			String joint3_nationality, String joint3_mobile_no, String joint3_email, String joint3_address,
			String joint3_passport_no, Date joint3_passport_exp_date, String joint3_emirates_id_no,
			Date joint3_emirates_exp_date, String joint3_pep_yn, String joint3_pep_approval, String kyc_valid_yn_joint3,
			BigDecimal annual_income_joint3, String source_of_income_joint3, String screen_google_joint3,
			String screen_dowjones_joint3, String branch_remarks, String unusual_txn_details,
			String suspicious_activity, BigDecimal high_value_txn_count, BigDecimal high_value_txn_volume,
			BigDecimal frequency_txn_percent, BigDecimal volume_turnover_percent, BigDecimal cash_txn_count,
			BigDecimal cash_txn_volume, BigDecimal cheque_txn_count, BigDecimal cheque_txn_volume,
			BigDecimal local_txn_count, BigDecimal local_txn_volume, BigDecimal intl_txn_count,
			BigDecimal intl_txn_volume, BigDecimal curr_txn_count, BigDecimal curr_txn_volume,
			BigDecimal expected_txn_count, BigDecimal expected_txn_volume, String profile_match_yn,
			String profile_mismatch_remarks, String system_risk, String customer_risk_reason, String aof_available_yn,
			String aof_remarks, String kyc_doc_available_yn, String kyc_doc_remarks,
			String source_of_funds_available_yn, String source_of_funds_remarks, String branch_observations,
			Date review_date, String reviewed_by_name, String reviewed_by_ec_no, String reviewed_by_designation,
			Date approval_date, String approved_by_name, String approved_by_ec_no, String approved_by_designation,
			String branch, Date entry_date, String entered_by, Date doc_uploaded_date, String doc_uploaded_by,
			Date report_date, String entry_user, Date entry_time, String auth_user, Date auth_time, String modify_user,
			Date modify_time, String verify_user, Date verify_time, String entity_flg, String auth_flg,
			String modify_flg, String del_flg, String branch_name, String head_signature_name) {
		super();
		this.srlno = srlno;
		this.account_title = account_title;
		this.ecdd_date = ecdd_date;
		this.customer_id = customer_id;
		this.associated_accounts = associated_accounts;
		this.currency = currency;
		this.account_open_date = account_open_date;
		this.currency_approval_yn = currency_approval_yn;
		this.primary_holder_name = primary_holder_name;
		this.primary_customer_id = primary_customer_id;
		this.primary_non_resident_yn = primary_non_resident_yn;
		this.primary_nationality = primary_nationality;
		this.primary_mobile_no = primary_mobile_no;
		this.primary_email = primary_email;
		this.primary_address = primary_address;
		this.primary_passport_no = primary_passport_no;
		this.primary_passport_exp_date = primary_passport_exp_date;
		this.primary_emirates_id_no = primary_emirates_id_no;
		this.primary_emirates_exp_date = primary_emirates_exp_date;
		this.primary_pep_yn = primary_pep_yn;
		this.primary_pep_approval = primary_pep_approval;
		this.kyc_valid_yn_primary = kyc_valid_yn_primary;
		this.annual_income_primary = annual_income_primary;
		this.source_of_income_primary = source_of_income_primary;
		this.screen_google_primary = screen_google_primary;
		this.screen_dowjones_primary = screen_dowjones_primary;
		this.joint1_name = joint1_name;
		this.joint1_customer_id = joint1_customer_id;
		this.joint1_non_resident_yn = joint1_non_resident_yn;
		this.joint1_nationality = joint1_nationality;
		this.joint1_mobile_no = joint1_mobile_no;
		this.joint1_email = joint1_email;
		this.joint1_address = joint1_address;
		this.joint1_passport_no = joint1_passport_no;
		this.joint1_passport_exp_date = joint1_passport_exp_date;
		this.joint1_emirates_id_no = joint1_emirates_id_no;
		this.joint1_emirates_exp_date = joint1_emirates_exp_date;
		this.joint1_pep_yn = joint1_pep_yn;
		this.joint1_pep_approval = joint1_pep_approval;
		this.kyc_valid_yn_joint1 = kyc_valid_yn_joint1;
		this.annual_income_joint1 = annual_income_joint1;
		this.source_of_income_joint1 = source_of_income_joint1;
		this.screen_google_joint1 = screen_google_joint1;
		this.screen_dowjones_joint1 = screen_dowjones_joint1;
		this.joint2_name = joint2_name;
		this.joint2_customer_id = joint2_customer_id;
		this.joint2_non_resident_yn = joint2_non_resident_yn;
		this.joint2_nationality = joint2_nationality;
		this.joint2_mobile_no = joint2_mobile_no;
		this.joint2_email = joint2_email;
		this.joint2_address = joint2_address;
		this.joint2_passport_no = joint2_passport_no;
		this.joint2_passport_exp_date = joint2_passport_exp_date;
		this.joint2_emirates_id_no = joint2_emirates_id_no;
		this.joint2_emirates_exp_date = joint2_emirates_exp_date;
		this.joint2_pep_yn = joint2_pep_yn;
		this.joint2_pep_approval = joint2_pep_approval;
		this.kyc_valid_yn_joint2 = kyc_valid_yn_joint2;
		this.annual_income_joint2 = annual_income_joint2;
		this.source_of_income_joint2 = source_of_income_joint2;
		this.screen_google_joint2 = screen_google_joint2;
		this.screen_dowjones_joint2 = screen_dowjones_joint2;
		this.joint3_name = joint3_name;
		this.joint3_customer_id = joint3_customer_id;
		this.joint3_non_resident_yn = joint3_non_resident_yn;
		this.joint3_nationality = joint3_nationality;
		this.joint3_mobile_no = joint3_mobile_no;
		this.joint3_email = joint3_email;
		this.joint3_address = joint3_address;
		this.joint3_passport_no = joint3_passport_no;
		this.joint3_passport_exp_date = joint3_passport_exp_date;
		this.joint3_emirates_id_no = joint3_emirates_id_no;
		this.joint3_emirates_exp_date = joint3_emirates_exp_date;
		this.joint3_pep_yn = joint3_pep_yn;
		this.joint3_pep_approval = joint3_pep_approval;
		this.kyc_valid_yn_joint3 = kyc_valid_yn_joint3;
		this.annual_income_joint3 = annual_income_joint3;
		this.source_of_income_joint3 = source_of_income_joint3;
		this.screen_google_joint3 = screen_google_joint3;
		this.screen_dowjones_joint3 = screen_dowjones_joint3;
		this.branch_remarks = branch_remarks;
		this.unusual_txn_details = unusual_txn_details;
		this.suspicious_activity = suspicious_activity;
		this.high_value_txn_count = high_value_txn_count;
		this.high_value_txn_volume = high_value_txn_volume;
		this.frequency_txn_percent = frequency_txn_percent;
		this.volume_turnover_percent = volume_turnover_percent;
		this.cash_txn_count = cash_txn_count;
		this.cash_txn_volume = cash_txn_volume;
		this.cheque_txn_count = cheque_txn_count;
		this.cheque_txn_volume = cheque_txn_volume;
		this.local_txn_count = local_txn_count;
		this.local_txn_volume = local_txn_volume;
		this.intl_txn_count = intl_txn_count;
		this.intl_txn_volume = intl_txn_volume;
		this.curr_txn_count = curr_txn_count;
		this.curr_txn_volume = curr_txn_volume;
		this.expected_txn_count = expected_txn_count;
		this.expected_txn_volume = expected_txn_volume;
		this.profile_match_yn = profile_match_yn;
		this.profile_mismatch_remarks = profile_mismatch_remarks;
		this.system_risk = system_risk;
		this.customer_risk_reason = customer_risk_reason;
		this.aof_available_yn = aof_available_yn;
		this.aof_remarks = aof_remarks;
		this.kyc_doc_available_yn = kyc_doc_available_yn;
		this.kyc_doc_remarks = kyc_doc_remarks;
		this.source_of_funds_available_yn = source_of_funds_available_yn;
		this.source_of_funds_remarks = source_of_funds_remarks;
		this.branch_observations = branch_observations;
		this.review_date = review_date;
		this.reviewed_by_name = reviewed_by_name;
		this.reviewed_by_ec_no = reviewed_by_ec_no;
		this.reviewed_by_designation = reviewed_by_designation;
		this.approval_date = approval_date;
		this.approved_by_name = approved_by_name;
		this.approved_by_ec_no = approved_by_ec_no;
		this.approved_by_designation = approved_by_designation;
		this.branch = branch;
		this.entry_date = entry_date;
		this.entered_by = entered_by;
		this.doc_uploaded_date = doc_uploaded_date;
		this.doc_uploaded_by = doc_uploaded_by;
		this.report_date = report_date;
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
		this.branch_name = branch_name;
		this.head_signature_name = head_signature_name;
	}

	public Ecdd_Individual_Profile_Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
}
