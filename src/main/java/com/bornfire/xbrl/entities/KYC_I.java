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
@Table(name = "ECDD_INDIVIDUAL")
public class KYC_I {

	private String customer_id;
	private String account_type;
	private String name;
	private String account_number;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_of_birth;
	private String place_of_birth;
	private String nationality;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date account_opening_date;
	private String country_of_citizenship;
	private String country_of_current_residency;
	private String occupation;
	private String business_activity;
	private BigDecimal annual_income;
	private String source_of_funds;
	private String purpose_of_account_opening;
	private String tax_registration;
	private String tax_id_number;
	private String primary_address;
	private String primary_address_country;
	private String primary_address_city;
	private String primary_address_po_box;
	private String mobile_number;
	private String primary_telephone;
	private String secondary_telephone;
	private String email_id;
	private String residential_status_changed;
	private String new_country_of_residency;
	private String new_city_of_residency;
	private String new_po_box_of_residency;
	private String account_satisfactory;
	private String transaction_commensurate;
	private String high_value_transactions_observed;
	private String high_value_transactions_details1;
	private String suspicion_observed;
	private String suspicion_observed_details;
	private String branch_satisfied_with_transactions;
	private String supporting_document_obtained;
	private BigDecimal current_turnover;
	private BigDecimal expected_turnover;
	private String expected_transaction_types;
	private BigDecimal expected_transaction_volume;
	private String transaction_frequency;
	private String uae;
	private String un;
	private String ofac;
	private String hmt;
	private String eu;
	private String others;
	private String cbu_check_done;
	private String google_media_search;
	private String internal_deny_list_screening;
	private String supporting_document_obtained_2;
	private String is_pep;
	private String senior_management_approval;
	private String foreign_currency_request;
	private String senior_management_approval_fc;
	private String customer_risk;
	private String high_risk_reason;
	private String further_due_diligence;
	private String observations_of_bank_official;
	private String account_opening_officer_signature;
	private String account_opening_officer_name;
	private String account_opening_officer_designation;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date account_opening_officer_date;
	private String branch_official_signature;
	private String branch_official_name;
	private String branch_official_designation;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date branch_official_date;
	private String debit;
	private String credit;
	private String suspicion_observed_1;
	private String country_of_citizenship_others;
	private String reason_for_red_flag_1;
	private String reason_for_red_flag_2;
	private String joint_support_document_details;
	private String branch;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date last_ecdd_date;
	private String aof_available;
	private String aof_remarks;
	private String fatca_crs_available;
	private String fatca_crs_remarks;
	private String source_of_funds_available;
	private String source_of_funds_remarks;
	private String observations;
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
	private String joint_holder1_name;
	private String joint_holder1_address;
	private String joint_holder1_address_country;
	private String joint_holder1_address_city;
	private String joint_holder1_address_po_box;
	private String joint_holder1_mobile;
	private String joint_holder1_primary_telephone;
	private String joint_holder1_secondary_telephone;
	private String joint_holder1_email;
	private String joint_holder1_residential_status_changed;
	private String joint_holder1_new_country_of_residency;
	private String joint_holder1_new_city_of_residency;
	private String joint_holder1_new_po_box_of_residency;
	private String joint_holder2_name;
	private String joint_holder2_address;
	private String joint_holder2_address_country;
	private String joint_holder2_address_city;
	private String joint_holder2_address_po_box;
	private String joint_holder2_mobile;
	private String joint_holder2_primary_telephone;
	private String joint_holder2_secondary_telephone;
	private String joint_holder2_email;
	private String joint_holder2_residential_status_changed;
	private String joint_holder2_new_country_of_residency;
	private String joint_holder2_new_city_of_residency;
	private String joint_holder2_new_po_box_of_residency;
	private String primary_account_holder_nationality;
	private String joint_account_holder_1_nationality;
	private String joint_account_holder_2_nationality;
	private String primary_account_holder_passport;
	private String joint_account_holder_1_passport;
	private String joint_account_holder_2_passport;
	private String primary_account_holder_visa_eid;
	private String joint_account_holder_1_visa_eid;
	private String joint_account_holder_2_visa_eid;
	private String primary_account_holder_valid_residence;
	private String joint_account_holder_1_valid_residence;
	private String joint_account_holder_2_valid_residence;
	private String primary_account_holder_proof_source_income;
	private String joint_account_holder_1_proof_source_income;
	private String joint_account_holder_2_proof_source_income;
	private String linked_account1_name;
	private String linked_account1_number;
	private String linked_account1_type;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date linked_account1_opening_date;
	private String linked_account1_currency;
	private String linked_account1_status;
	private String linked_account2_name;
	private String linked_account2_number;
	private String linked_account2_type;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date linked_account2_opening_date;
	private String linked_account2_currency;
	private String linked_account2_status;
	private String linked_account3_name;
	private String linked_account3_number;
	private String linked_account3_type;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date linked_account3_opening_date;
	private String linked_account3_currency;
	private String linked_account3_status;
	private String linked_account4_name;
	private String linked_account4_number;
	private String linked_account4_type;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date linked_account4_opening_date;
	private String linked_account4_currency;
	private String linked_account4_status;
	private String high_value_transactions_details2;
	private String high_value_transactions_details3;
	private String high_value_transactions_details4;
	private String known_countries_of_transaction_1;
	private String known_countries_of_transaction_2;
	private String known_countries_of_transaction_3;
	private String known_countries_of_transaction_4;
	private String other_expected_countries_1;
	private String other_expected_countries_2;
	private String other_expected_countries_3;
	private String other_expected_countries_4;
	private String joint_uae;
	private String joint_un;
	private String joint_ofac;
	private String joint_hmt;
	private String joint_eu;
	private String joint_others;
	private String joint_cbu_check_done;
	private String joint_google_media_search;
	private String joint_internal_deny_list_screening;
	private String joint_suspicion_observed;
	private String joint_supporting_document_obtained;
	private String known_countries_of_transaction_5;
	private String known_countries_of_transaction_6;
	private String known_countries_of_transaction_7;
	private String known_countries_of_transaction_8;
	private String other_expected_countries_5;
	private String other_expected_countries_6;
	private String other_expected_countries_7;
	private String other_expected_countries_8;
	private String addinfo_primaryaddress;
	private String joint_holder1_primaryaddress;
	private String joint_holder2_primaryaddress;
	private String primary_dow_jones;
	private String joint_dow_jones;

	public String getCustomer_id() {
		return customer_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public String getName() {
		return name;
	}

	public String getAccount_number() {
		return account_number;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public String getPlace_of_birth() {
		return place_of_birth;
	}

	public String getNationality() {
		return nationality;
	}

	public Date getAccount_opening_date() {
		return account_opening_date;
	}

	public String getCountry_of_citizenship() {
		return country_of_citizenship;
	}

	public String getCountry_of_current_residency() {
		return country_of_current_residency;
	}

	public String getOccupation() {
		return occupation;
	}

	public String getBusiness_activity() {
		return business_activity;
	}

	public BigDecimal getAnnual_income() {
		return annual_income;
	}

	public String getSource_of_funds() {
		return source_of_funds;
	}

	public String getPurpose_of_account_opening() {
		return purpose_of_account_opening;
	}

	public String getTax_registration() {
		return tax_registration;
	}

	public String getTax_id_number() {
		return tax_id_number;
	}

	public String getPrimary_address() {
		return primary_address;
	}

	public String getPrimary_address_country() {
		return primary_address_country;
	}

	public String getPrimary_address_city() {
		return primary_address_city;
	}

	public String getPrimary_address_po_box() {
		return primary_address_po_box;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public String getPrimary_telephone() {
		return primary_telephone;
	}

	public String getSecondary_telephone() {
		return secondary_telephone;
	}

	public String getEmail_id() {
		return email_id;
	}

	public String getResidential_status_changed() {
		return residential_status_changed;
	}

	public String getNew_country_of_residency() {
		return new_country_of_residency;
	}

	public String getNew_city_of_residency() {
		return new_city_of_residency;
	}

	public String getNew_po_box_of_residency() {
		return new_po_box_of_residency;
	}

	public String getAccount_satisfactory() {
		return account_satisfactory;
	}

	public String getTransaction_commensurate() {
		return transaction_commensurate;
	}

	public String getHigh_value_transactions_observed() {
		return high_value_transactions_observed;
	}

	public String getHigh_value_transactions_details1() {
		return high_value_transactions_details1;
	}

	public String getSuspicion_observed() {
		return suspicion_observed;
	}

	public String getSuspicion_observed_details() {
		return suspicion_observed_details;
	}

	public String getBranch_satisfied_with_transactions() {
		return branch_satisfied_with_transactions;
	}

	public String getSupporting_document_obtained() {
		return supporting_document_obtained;
	}

	public BigDecimal getCurrent_turnover() {
		return current_turnover;
	}

	public BigDecimal getExpected_turnover() {
		return expected_turnover;
	}

	public String getExpected_transaction_types() {
		return expected_transaction_types;
	}

	public BigDecimal getExpected_transaction_volume() {
		return expected_transaction_volume;
	}

	public String getTransaction_frequency() {
		return transaction_frequency;
	}

	public String getUae() {
		return uae;
	}

	public String getUn() {
		return un;
	}

	public String getOfac() {
		return ofac;
	}

	public String getHmt() {
		return hmt;
	}

	public String getEu() {
		return eu;
	}

	public String getOthers() {
		return others;
	}

	public String getCbu_check_done() {
		return cbu_check_done;
	}

	public String getGoogle_media_search() {
		return google_media_search;
	}

	public String getInternal_deny_list_screening() {
		return internal_deny_list_screening;
	}

	public String getSupporting_document_obtained_2() {
		return supporting_document_obtained_2;
	}

	public String getIs_pep() {
		return is_pep;
	}

	public String getSenior_management_approval() {
		return senior_management_approval;
	}

	public String getForeign_currency_request() {
		return foreign_currency_request;
	}

	public String getSenior_management_approval_fc() {
		return senior_management_approval_fc;
	}

	public String getCustomer_risk() {
		return customer_risk;
	}

	public String getHigh_risk_reason() {
		return high_risk_reason;
	}

	public String getFurther_due_diligence() {
		return further_due_diligence;
	}

	public String getObservations_of_bank_official() {
		return observations_of_bank_official;
	}

	public String getAccount_opening_officer_signature() {
		return account_opening_officer_signature;
	}

	public String getAccount_opening_officer_name() {
		return account_opening_officer_name;
	}

	public String getAccount_opening_officer_designation() {
		return account_opening_officer_designation;
	}

	public Date getAccount_opening_officer_date() {
		return account_opening_officer_date;
	}

	public String getBranch_official_signature() {
		return branch_official_signature;
	}

	public String getBranch_official_name() {
		return branch_official_name;
	}

	public String getBranch_official_designation() {
		return branch_official_designation;
	}

	public Date getBranch_official_date() {
		return branch_official_date;
	}

	public String getDebit() {
		return debit;
	}

	public String getCredit() {
		return credit;
	}

	public String getSuspicion_observed_1() {
		return suspicion_observed_1;
	}

	public String getCountry_of_citizenship_others() {
		return country_of_citizenship_others;
	}

	public String getReason_for_red_flag_1() {
		return reason_for_red_flag_1;
	}

	public String getReason_for_red_flag_2() {
		return reason_for_red_flag_2;
	}

	public String getJoint_support_document_details() {
		return joint_support_document_details;
	}

	public String getBranch() {
		return branch;
	}

	public Date getLast_ecdd_date() {
		return last_ecdd_date;
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

	public String getJoint_holder1_name() {
		return joint_holder1_name;
	}

	public String getJoint_holder1_address() {
		return joint_holder1_address;
	}

	public String getJoint_holder1_address_country() {
		return joint_holder1_address_country;
	}

	public String getJoint_holder1_address_city() {
		return joint_holder1_address_city;
	}

	public String getJoint_holder1_address_po_box() {
		return joint_holder1_address_po_box;
	}

	public String getJoint_holder1_mobile() {
		return joint_holder1_mobile;
	}

	public String getJoint_holder1_primary_telephone() {
		return joint_holder1_primary_telephone;
	}

	public String getJoint_holder1_secondary_telephone() {
		return joint_holder1_secondary_telephone;
	}

	public String getJoint_holder1_email() {
		return joint_holder1_email;
	}

	public String getJoint_holder1_residential_status_changed() {
		return joint_holder1_residential_status_changed;
	}

	public String getJoint_holder1_new_country_of_residency() {
		return joint_holder1_new_country_of_residency;
	}

	public String getJoint_holder1_new_city_of_residency() {
		return joint_holder1_new_city_of_residency;
	}

	public String getJoint_holder1_new_po_box_of_residency() {
		return joint_holder1_new_po_box_of_residency;
	}

	public String getJoint_holder2_name() {
		return joint_holder2_name;
	}

	public String getJoint_holder2_address() {
		return joint_holder2_address;
	}

	public String getJoint_holder2_address_country() {
		return joint_holder2_address_country;
	}

	public String getJoint_holder2_address_city() {
		return joint_holder2_address_city;
	}

	public String getJoint_holder2_address_po_box() {
		return joint_holder2_address_po_box;
	}

	public String getJoint_holder2_mobile() {
		return joint_holder2_mobile;
	}

	public String getJoint_holder2_primary_telephone() {
		return joint_holder2_primary_telephone;
	}

	public String getJoint_holder2_secondary_telephone() {
		return joint_holder2_secondary_telephone;
	}

	public String getJoint_holder2_email() {
		return joint_holder2_email;
	}

	public String getJoint_holder2_residential_status_changed() {
		return joint_holder2_residential_status_changed;
	}

	public String getJoint_holder2_new_country_of_residency() {
		return joint_holder2_new_country_of_residency;
	}

	public String getJoint_holder2_new_city_of_residency() {
		return joint_holder2_new_city_of_residency;
	}

	public String getJoint_holder2_new_po_box_of_residency() {
		return joint_holder2_new_po_box_of_residency;
	}

	public String getPrimary_account_holder_nationality() {
		return primary_account_holder_nationality;
	}

	public String getJoint_account_holder_1_nationality() {
		return joint_account_holder_1_nationality;
	}

	public String getJoint_account_holder_2_nationality() {
		return joint_account_holder_2_nationality;
	}

	public String getPrimary_account_holder_passport() {
		return primary_account_holder_passport;
	}

	public String getJoint_account_holder_1_passport() {
		return joint_account_holder_1_passport;
	}

	public String getJoint_account_holder_2_passport() {
		return joint_account_holder_2_passport;
	}

	public String getPrimary_account_holder_visa_eid() {
		return primary_account_holder_visa_eid;
	}

	public String getJoint_account_holder_1_visa_eid() {
		return joint_account_holder_1_visa_eid;
	}

	public String getJoint_account_holder_2_visa_eid() {
		return joint_account_holder_2_visa_eid;
	}

	public String getPrimary_account_holder_valid_residence() {
		return primary_account_holder_valid_residence;
	}

	public String getJoint_account_holder_1_valid_residence() {
		return joint_account_holder_1_valid_residence;
	}

	public String getJoint_account_holder_2_valid_residence() {
		return joint_account_holder_2_valid_residence;
	}

	public String getPrimary_account_holder_proof_source_income() {
		return primary_account_holder_proof_source_income;
	}

	public String getJoint_account_holder_1_proof_source_income() {
		return joint_account_holder_1_proof_source_income;
	}

	public String getJoint_account_holder_2_proof_source_income() {
		return joint_account_holder_2_proof_source_income;
	}

	public String getLinked_account1_name() {
		return linked_account1_name;
	}

	public String getLinked_account1_number() {
		return linked_account1_number;
	}

	public String getLinked_account1_type() {
		return linked_account1_type;
	}

	public Date getLinked_account1_opening_date() {
		return linked_account1_opening_date;
	}

	public String getLinked_account1_currency() {
		return linked_account1_currency;
	}

	public String getLinked_account1_status() {
		return linked_account1_status;
	}

	public String getLinked_account2_name() {
		return linked_account2_name;
	}

	public String getLinked_account2_number() {
		return linked_account2_number;
	}

	public String getLinked_account2_type() {
		return linked_account2_type;
	}

	public Date getLinked_account2_opening_date() {
		return linked_account2_opening_date;
	}

	public String getLinked_account2_currency() {
		return linked_account2_currency;
	}

	public String getLinked_account2_status() {
		return linked_account2_status;
	}

	public String getLinked_account3_name() {
		return linked_account3_name;
	}

	public String getLinked_account3_number() {
		return linked_account3_number;
	}

	public String getLinked_account3_type() {
		return linked_account3_type;
	}

	public Date getLinked_account3_opening_date() {
		return linked_account3_opening_date;
	}

	public String getLinked_account3_currency() {
		return linked_account3_currency;
	}

	public String getLinked_account3_status() {
		return linked_account3_status;
	}

	public String getLinked_account4_name() {
		return linked_account4_name;
	}

	public String getLinked_account4_number() {
		return linked_account4_number;
	}

	public String getLinked_account4_type() {
		return linked_account4_type;
	}

	public Date getLinked_account4_opening_date() {
		return linked_account4_opening_date;
	}

	public String getLinked_account4_currency() {
		return linked_account4_currency;
	}

	public String getLinked_account4_status() {
		return linked_account4_status;
	}

	public String getHigh_value_transactions_details2() {
		return high_value_transactions_details2;
	}

	public String getHigh_value_transactions_details3() {
		return high_value_transactions_details3;
	}

	public String getHigh_value_transactions_details4() {
		return high_value_transactions_details4;
	}

	public String getKnown_countries_of_transaction_1() {
		return known_countries_of_transaction_1;
	}

	public String getKnown_countries_of_transaction_2() {
		return known_countries_of_transaction_2;
	}

	public String getKnown_countries_of_transaction_3() {
		return known_countries_of_transaction_3;
	}

	public String getKnown_countries_of_transaction_4() {
		return known_countries_of_transaction_4;
	}

	public String getOther_expected_countries_1() {
		return other_expected_countries_1;
	}

	public String getOther_expected_countries_2() {
		return other_expected_countries_2;
	}

	public String getOther_expected_countries_3() {
		return other_expected_countries_3;
	}

	public String getOther_expected_countries_4() {
		return other_expected_countries_4;
	}

	public String getJoint_uae() {
		return joint_uae;
	}

	public String getJoint_un() {
		return joint_un;
	}

	public String getJoint_ofac() {
		return joint_ofac;
	}

	public String getJoint_hmt() {
		return joint_hmt;
	}

	public String getJoint_eu() {
		return joint_eu;
	}

	public String getJoint_others() {
		return joint_others;
	}

	public String getJoint_cbu_check_done() {
		return joint_cbu_check_done;
	}

	public String getJoint_google_media_search() {
		return joint_google_media_search;
	}

	public String getJoint_internal_deny_list_screening() {
		return joint_internal_deny_list_screening;
	}

	public String getJoint_suspicion_observed() {
		return joint_suspicion_observed;
	}

	public String getJoint_supporting_document_obtained() {
		return joint_supporting_document_obtained;
	}

	public String getKnown_countries_of_transaction_5() {
		return known_countries_of_transaction_5;
	}

	public String getKnown_countries_of_transaction_6() {
		return known_countries_of_transaction_6;
	}

	public String getKnown_countries_of_transaction_7() {
		return known_countries_of_transaction_7;
	}

	public String getKnown_countries_of_transaction_8() {
		return known_countries_of_transaction_8;
	}

	public String getOther_expected_countries_5() {
		return other_expected_countries_5;
	}

	public String getOther_expected_countries_6() {
		return other_expected_countries_6;
	}

	public String getOther_expected_countries_7() {
		return other_expected_countries_7;
	}

	public String getOther_expected_countries_8() {
		return other_expected_countries_8;
	}

	public String getAddinfo_primaryaddress() {
		return addinfo_primaryaddress;
	}

	public String getJoint_holder1_primaryaddress() {
		return joint_holder1_primaryaddress;
	}

	public String getJoint_holder2_primaryaddress() {
		return joint_holder2_primaryaddress;
	}

	public String getPrimary_dow_jones() {
		return primary_dow_jones;
	}

	public String getJoint_dow_jones() {
		return joint_dow_jones;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public void setPlace_of_birth(String place_of_birth) {
		this.place_of_birth = place_of_birth;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void setAccount_opening_date(Date account_opening_date) {
		this.account_opening_date = account_opening_date;
	}

	public void setCountry_of_citizenship(String country_of_citizenship) {
		this.country_of_citizenship = country_of_citizenship;
	}

	public void setCountry_of_current_residency(String country_of_current_residency) {
		this.country_of_current_residency = country_of_current_residency;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public void setBusiness_activity(String business_activity) {
		this.business_activity = business_activity;
	}

	public void setAnnual_income(BigDecimal annual_income) {
		this.annual_income = annual_income;
	}

	public void setSource_of_funds(String source_of_funds) {
		this.source_of_funds = source_of_funds;
	}

	public void setPurpose_of_account_opening(String purpose_of_account_opening) {
		this.purpose_of_account_opening = purpose_of_account_opening;
	}

	public void setTax_registration(String tax_registration) {
		this.tax_registration = tax_registration;
	}

	public void setTax_id_number(String tax_id_number) {
		this.tax_id_number = tax_id_number;
	}

	public void setPrimary_address(String primary_address) {
		this.primary_address = primary_address;
	}

	public void setPrimary_address_country(String primary_address_country) {
		this.primary_address_country = primary_address_country;
	}

	public void setPrimary_address_city(String primary_address_city) {
		this.primary_address_city = primary_address_city;
	}

	public void setPrimary_address_po_box(String primary_address_po_box) {
		this.primary_address_po_box = primary_address_po_box;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public void setPrimary_telephone(String primary_telephone) {
		this.primary_telephone = primary_telephone;
	}

	public void setSecondary_telephone(String secondary_telephone) {
		this.secondary_telephone = secondary_telephone;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public void setResidential_status_changed(String residential_status_changed) {
		this.residential_status_changed = residential_status_changed;
	}

	public void setNew_country_of_residency(String new_country_of_residency) {
		this.new_country_of_residency = new_country_of_residency;
	}

	public void setNew_city_of_residency(String new_city_of_residency) {
		this.new_city_of_residency = new_city_of_residency;
	}

	public void setNew_po_box_of_residency(String new_po_box_of_residency) {
		this.new_po_box_of_residency = new_po_box_of_residency;
	}

	public void setAccount_satisfactory(String account_satisfactory) {
		this.account_satisfactory = account_satisfactory;
	}

	public void setTransaction_commensurate(String transaction_commensurate) {
		this.transaction_commensurate = transaction_commensurate;
	}

	public void setHigh_value_transactions_observed(String high_value_transactions_observed) {
		this.high_value_transactions_observed = high_value_transactions_observed;
	}

	public void setHigh_value_transactions_details1(String high_value_transactions_details1) {
		this.high_value_transactions_details1 = high_value_transactions_details1;
	}

	public void setSuspicion_observed(String suspicion_observed) {
		this.suspicion_observed = suspicion_observed;
	}

	public void setSuspicion_observed_details(String suspicion_observed_details) {
		this.suspicion_observed_details = suspicion_observed_details;
	}

	public void setBranch_satisfied_with_transactions(String branch_satisfied_with_transactions) {
		this.branch_satisfied_with_transactions = branch_satisfied_with_transactions;
	}

	public void setSupporting_document_obtained(String supporting_document_obtained) {
		this.supporting_document_obtained = supporting_document_obtained;
	}

	public void setCurrent_turnover(BigDecimal current_turnover) {
		this.current_turnover = current_turnover;
	}

	public void setExpected_turnover(BigDecimal expected_turnover) {
		this.expected_turnover = expected_turnover;
	}

	public void setExpected_transaction_types(String expected_transaction_types) {
		this.expected_transaction_types = expected_transaction_types;
	}

	public void setExpected_transaction_volume(BigDecimal expected_transaction_volume) {
		this.expected_transaction_volume = expected_transaction_volume;
	}

	public void setTransaction_frequency(String transaction_frequency) {
		this.transaction_frequency = transaction_frequency;
	}

	public void setUae(String uae) {
		this.uae = uae;
	}

	public void setUn(String un) {
		this.un = un;
	}

	public void setOfac(String ofac) {
		this.ofac = ofac;
	}

	public void setHmt(String hmt) {
		this.hmt = hmt;
	}

	public void setEu(String eu) {
		this.eu = eu;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public void setCbu_check_done(String cbu_check_done) {
		this.cbu_check_done = cbu_check_done;
	}

	public void setGoogle_media_search(String google_media_search) {
		this.google_media_search = google_media_search;
	}

	public void setInternal_deny_list_screening(String internal_deny_list_screening) {
		this.internal_deny_list_screening = internal_deny_list_screening;
	}

	public void setSupporting_document_obtained_2(String supporting_document_obtained_2) {
		this.supporting_document_obtained_2 = supporting_document_obtained_2;
	}

	public void setIs_pep(String is_pep) {
		this.is_pep = is_pep;
	}

	public void setSenior_management_approval(String senior_management_approval) {
		this.senior_management_approval = senior_management_approval;
	}

	public void setForeign_currency_request(String foreign_currency_request) {
		this.foreign_currency_request = foreign_currency_request;
	}

	public void setSenior_management_approval_fc(String senior_management_approval_fc) {
		this.senior_management_approval_fc = senior_management_approval_fc;
	}

	public void setCustomer_risk(String customer_risk) {
		this.customer_risk = customer_risk;
	}

	public void setHigh_risk_reason(String high_risk_reason) {
		this.high_risk_reason = high_risk_reason;
	}

	public void setFurther_due_diligence(String further_due_diligence) {
		this.further_due_diligence = further_due_diligence;
	}

	public void setObservations_of_bank_official(String observations_of_bank_official) {
		this.observations_of_bank_official = observations_of_bank_official;
	}

	public void setAccount_opening_officer_signature(String account_opening_officer_signature) {
		this.account_opening_officer_signature = account_opening_officer_signature;
	}

	public void setAccount_opening_officer_name(String account_opening_officer_name) {
		this.account_opening_officer_name = account_opening_officer_name;
	}

	public void setAccount_opening_officer_designation(String account_opening_officer_designation) {
		this.account_opening_officer_designation = account_opening_officer_designation;
	}

	public void setAccount_opening_officer_date(Date account_opening_officer_date) {
		this.account_opening_officer_date = account_opening_officer_date;
	}

	public void setBranch_official_signature(String branch_official_signature) {
		this.branch_official_signature = branch_official_signature;
	}

	public void setBranch_official_name(String branch_official_name) {
		this.branch_official_name = branch_official_name;
	}

	public void setBranch_official_designation(String branch_official_designation) {
		this.branch_official_designation = branch_official_designation;
	}

	public void setBranch_official_date(Date branch_official_date) {
		this.branch_official_date = branch_official_date;
	}

	public void setDebit(String debit) {
		this.debit = debit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public void setSuspicion_observed_1(String suspicion_observed_1) {
		this.suspicion_observed_1 = suspicion_observed_1;
	}

	public void setCountry_of_citizenship_others(String country_of_citizenship_others) {
		this.country_of_citizenship_others = country_of_citizenship_others;
	}

	public void setReason_for_red_flag_1(String reason_for_red_flag_1) {
		this.reason_for_red_flag_1 = reason_for_red_flag_1;
	}

	public void setReason_for_red_flag_2(String reason_for_red_flag_2) {
		this.reason_for_red_flag_2 = reason_for_red_flag_2;
	}

	public void setJoint_support_document_details(String joint_support_document_details) {
		this.joint_support_document_details = joint_support_document_details;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public void setLast_ecdd_date(Date last_ecdd_date) {
		this.last_ecdd_date = last_ecdd_date;
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

	public void setJoint_holder1_name(String joint_holder1_name) {
		this.joint_holder1_name = joint_holder1_name;
	}

	public void setJoint_holder1_address(String joint_holder1_address) {
		this.joint_holder1_address = joint_holder1_address;
	}

	public void setJoint_holder1_address_country(String joint_holder1_address_country) {
		this.joint_holder1_address_country = joint_holder1_address_country;
	}

	public void setJoint_holder1_address_city(String joint_holder1_address_city) {
		this.joint_holder1_address_city = joint_holder1_address_city;
	}

	public void setJoint_holder1_address_po_box(String joint_holder1_address_po_box) {
		this.joint_holder1_address_po_box = joint_holder1_address_po_box;
	}

	public void setJoint_holder1_mobile(String joint_holder1_mobile) {
		this.joint_holder1_mobile = joint_holder1_mobile;
	}

	public void setJoint_holder1_primary_telephone(String joint_holder1_primary_telephone) {
		this.joint_holder1_primary_telephone = joint_holder1_primary_telephone;
	}

	public void setJoint_holder1_secondary_telephone(String joint_holder1_secondary_telephone) {
		this.joint_holder1_secondary_telephone = joint_holder1_secondary_telephone;
	}

	public void setJoint_holder1_email(String joint_holder1_email) {
		this.joint_holder1_email = joint_holder1_email;
	}

	public void setJoint_holder1_residential_status_changed(String joint_holder1_residential_status_changed) {
		this.joint_holder1_residential_status_changed = joint_holder1_residential_status_changed;
	}

	public void setJoint_holder1_new_country_of_residency(String joint_holder1_new_country_of_residency) {
		this.joint_holder1_new_country_of_residency = joint_holder1_new_country_of_residency;
	}

	public void setJoint_holder1_new_city_of_residency(String joint_holder1_new_city_of_residency) {
		this.joint_holder1_new_city_of_residency = joint_holder1_new_city_of_residency;
	}

	public void setJoint_holder1_new_po_box_of_residency(String joint_holder1_new_po_box_of_residency) {
		this.joint_holder1_new_po_box_of_residency = joint_holder1_new_po_box_of_residency;
	}

	public void setJoint_holder2_name(String joint_holder2_name) {
		this.joint_holder2_name = joint_holder2_name;
	}

	public void setJoint_holder2_address(String joint_holder2_address) {
		this.joint_holder2_address = joint_holder2_address;
	}

	public void setJoint_holder2_address_country(String joint_holder2_address_country) {
		this.joint_holder2_address_country = joint_holder2_address_country;
	}

	public void setJoint_holder2_address_city(String joint_holder2_address_city) {
		this.joint_holder2_address_city = joint_holder2_address_city;
	}

	public void setJoint_holder2_address_po_box(String joint_holder2_address_po_box) {
		this.joint_holder2_address_po_box = joint_holder2_address_po_box;
	}

	public void setJoint_holder2_mobile(String joint_holder2_mobile) {
		this.joint_holder2_mobile = joint_holder2_mobile;
	}

	public void setJoint_holder2_primary_telephone(String joint_holder2_primary_telephone) {
		this.joint_holder2_primary_telephone = joint_holder2_primary_telephone;
	}

	public void setJoint_holder2_secondary_telephone(String joint_holder2_secondary_telephone) {
		this.joint_holder2_secondary_telephone = joint_holder2_secondary_telephone;
	}

	public void setJoint_holder2_email(String joint_holder2_email) {
		this.joint_holder2_email = joint_holder2_email;
	}

	public void setJoint_holder2_residential_status_changed(String joint_holder2_residential_status_changed) {
		this.joint_holder2_residential_status_changed = joint_holder2_residential_status_changed;
	}

	public void setJoint_holder2_new_country_of_residency(String joint_holder2_new_country_of_residency) {
		this.joint_holder2_new_country_of_residency = joint_holder2_new_country_of_residency;
	}

	public void setJoint_holder2_new_city_of_residency(String joint_holder2_new_city_of_residency) {
		this.joint_holder2_new_city_of_residency = joint_holder2_new_city_of_residency;
	}

	public void setJoint_holder2_new_po_box_of_residency(String joint_holder2_new_po_box_of_residency) {
		this.joint_holder2_new_po_box_of_residency = joint_holder2_new_po_box_of_residency;
	}

	public void setPrimary_account_holder_nationality(String primary_account_holder_nationality) {
		this.primary_account_holder_nationality = primary_account_holder_nationality;
	}

	public void setJoint_account_holder_1_nationality(String joint_account_holder_1_nationality) {
		this.joint_account_holder_1_nationality = joint_account_holder_1_nationality;
	}

	public void setJoint_account_holder_2_nationality(String joint_account_holder_2_nationality) {
		this.joint_account_holder_2_nationality = joint_account_holder_2_nationality;
	}

	public void setPrimary_account_holder_passport(String primary_account_holder_passport) {
		this.primary_account_holder_passport = primary_account_holder_passport;
	}

	public void setJoint_account_holder_1_passport(String joint_account_holder_1_passport) {
		this.joint_account_holder_1_passport = joint_account_holder_1_passport;
	}

	public void setJoint_account_holder_2_passport(String joint_account_holder_2_passport) {
		this.joint_account_holder_2_passport = joint_account_holder_2_passport;
	}

	public void setPrimary_account_holder_visa_eid(String primary_account_holder_visa_eid) {
		this.primary_account_holder_visa_eid = primary_account_holder_visa_eid;
	}

	public void setJoint_account_holder_1_visa_eid(String joint_account_holder_1_visa_eid) {
		this.joint_account_holder_1_visa_eid = joint_account_holder_1_visa_eid;
	}

	public void setJoint_account_holder_2_visa_eid(String joint_account_holder_2_visa_eid) {
		this.joint_account_holder_2_visa_eid = joint_account_holder_2_visa_eid;
	}

	public void setPrimary_account_holder_valid_residence(String primary_account_holder_valid_residence) {
		this.primary_account_holder_valid_residence = primary_account_holder_valid_residence;
	}

	public void setJoint_account_holder_1_valid_residence(String joint_account_holder_1_valid_residence) {
		this.joint_account_holder_1_valid_residence = joint_account_holder_1_valid_residence;
	}

	public void setJoint_account_holder_2_valid_residence(String joint_account_holder_2_valid_residence) {
		this.joint_account_holder_2_valid_residence = joint_account_holder_2_valid_residence;
	}

	public void setPrimary_account_holder_proof_source_income(String primary_account_holder_proof_source_income) {
		this.primary_account_holder_proof_source_income = primary_account_holder_proof_source_income;
	}

	public void setJoint_account_holder_1_proof_source_income(String joint_account_holder_1_proof_source_income) {
		this.joint_account_holder_1_proof_source_income = joint_account_holder_1_proof_source_income;
	}

	public void setJoint_account_holder_2_proof_source_income(String joint_account_holder_2_proof_source_income) {
		this.joint_account_holder_2_proof_source_income = joint_account_holder_2_proof_source_income;
	}

	public void setLinked_account1_name(String linked_account1_name) {
		this.linked_account1_name = linked_account1_name;
	}

	public void setLinked_account1_number(String linked_account1_number) {
		this.linked_account1_number = linked_account1_number;
	}

	public void setLinked_account1_type(String linked_account1_type) {
		this.linked_account1_type = linked_account1_type;
	}

	public void setLinked_account1_opening_date(Date linked_account1_opening_date) {
		this.linked_account1_opening_date = linked_account1_opening_date;
	}

	public void setLinked_account1_currency(String linked_account1_currency) {
		this.linked_account1_currency = linked_account1_currency;
	}

	public void setLinked_account1_status(String linked_account1_status) {
		this.linked_account1_status = linked_account1_status;
	}

	public void setLinked_account2_name(String linked_account2_name) {
		this.linked_account2_name = linked_account2_name;
	}

	public void setLinked_account2_number(String linked_account2_number) {
		this.linked_account2_number = linked_account2_number;
	}

	public void setLinked_account2_type(String linked_account2_type) {
		this.linked_account2_type = linked_account2_type;
	}

	public void setLinked_account2_opening_date(Date linked_account2_opening_date) {
		this.linked_account2_opening_date = linked_account2_opening_date;
	}

	public void setLinked_account2_currency(String linked_account2_currency) {
		this.linked_account2_currency = linked_account2_currency;
	}

	public void setLinked_account2_status(String linked_account2_status) {
		this.linked_account2_status = linked_account2_status;
	}

	public void setLinked_account3_name(String linked_account3_name) {
		this.linked_account3_name = linked_account3_name;
	}

	public void setLinked_account3_number(String linked_account3_number) {
		this.linked_account3_number = linked_account3_number;
	}

	public void setLinked_account3_type(String linked_account3_type) {
		this.linked_account3_type = linked_account3_type;
	}

	public void setLinked_account3_opening_date(Date linked_account3_opening_date) {
		this.linked_account3_opening_date = linked_account3_opening_date;
	}

	public void setLinked_account3_currency(String linked_account3_currency) {
		this.linked_account3_currency = linked_account3_currency;
	}

	public void setLinked_account3_status(String linked_account3_status) {
		this.linked_account3_status = linked_account3_status;
	}

	public void setLinked_account4_name(String linked_account4_name) {
		this.linked_account4_name = linked_account4_name;
	}

	public void setLinked_account4_number(String linked_account4_number) {
		this.linked_account4_number = linked_account4_number;
	}

	public void setLinked_account4_type(String linked_account4_type) {
		this.linked_account4_type = linked_account4_type;
	}

	public void setLinked_account4_opening_date(Date linked_account4_opening_date) {
		this.linked_account4_opening_date = linked_account4_opening_date;
	}

	public void setLinked_account4_currency(String linked_account4_currency) {
		this.linked_account4_currency = linked_account4_currency;
	}

	public void setLinked_account4_status(String linked_account4_status) {
		this.linked_account4_status = linked_account4_status;
	}

	public void setHigh_value_transactions_details2(String high_value_transactions_details2) {
		this.high_value_transactions_details2 = high_value_transactions_details2;
	}

	public void setHigh_value_transactions_details3(String high_value_transactions_details3) {
		this.high_value_transactions_details3 = high_value_transactions_details3;
	}

	public void setHigh_value_transactions_details4(String high_value_transactions_details4) {
		this.high_value_transactions_details4 = high_value_transactions_details4;
	}

	public void setKnown_countries_of_transaction_1(String known_countries_of_transaction_1) {
		this.known_countries_of_transaction_1 = known_countries_of_transaction_1;
	}

	public void setKnown_countries_of_transaction_2(String known_countries_of_transaction_2) {
		this.known_countries_of_transaction_2 = known_countries_of_transaction_2;
	}

	public void setKnown_countries_of_transaction_3(String known_countries_of_transaction_3) {
		this.known_countries_of_transaction_3 = known_countries_of_transaction_3;
	}

	public void setKnown_countries_of_transaction_4(String known_countries_of_transaction_4) {
		this.known_countries_of_transaction_4 = known_countries_of_transaction_4;
	}

	public void setOther_expected_countries_1(String other_expected_countries_1) {
		this.other_expected_countries_1 = other_expected_countries_1;
	}

	public void setOther_expected_countries_2(String other_expected_countries_2) {
		this.other_expected_countries_2 = other_expected_countries_2;
	}

	public void setOther_expected_countries_3(String other_expected_countries_3) {
		this.other_expected_countries_3 = other_expected_countries_3;
	}

	public void setOther_expected_countries_4(String other_expected_countries_4) {
		this.other_expected_countries_4 = other_expected_countries_4;
	}

	public void setJoint_uae(String joint_uae) {
		this.joint_uae = joint_uae;
	}

	public void setJoint_un(String joint_un) {
		this.joint_un = joint_un;
	}

	public void setJoint_ofac(String joint_ofac) {
		this.joint_ofac = joint_ofac;
	}

	public void setJoint_hmt(String joint_hmt) {
		this.joint_hmt = joint_hmt;
	}

	public void setJoint_eu(String joint_eu) {
		this.joint_eu = joint_eu;
	}

	public void setJoint_others(String joint_others) {
		this.joint_others = joint_others;
	}

	public void setJoint_cbu_check_done(String joint_cbu_check_done) {
		this.joint_cbu_check_done = joint_cbu_check_done;
	}

	public void setJoint_google_media_search(String joint_google_media_search) {
		this.joint_google_media_search = joint_google_media_search;
	}

	public void setJoint_internal_deny_list_screening(String joint_internal_deny_list_screening) {
		this.joint_internal_deny_list_screening = joint_internal_deny_list_screening;
	}

	public void setJoint_suspicion_observed(String joint_suspicion_observed) {
		this.joint_suspicion_observed = joint_suspicion_observed;
	}

	public void setJoint_supporting_document_obtained(String joint_supporting_document_obtained) {
		this.joint_supporting_document_obtained = joint_supporting_document_obtained;
	}

	public void setKnown_countries_of_transaction_5(String known_countries_of_transaction_5) {
		this.known_countries_of_transaction_5 = known_countries_of_transaction_5;
	}

	public void setKnown_countries_of_transaction_6(String known_countries_of_transaction_6) {
		this.known_countries_of_transaction_6 = known_countries_of_transaction_6;
	}

	public void setKnown_countries_of_transaction_7(String known_countries_of_transaction_7) {
		this.known_countries_of_transaction_7 = known_countries_of_transaction_7;
	}

	public void setKnown_countries_of_transaction_8(String known_countries_of_transaction_8) {
		this.known_countries_of_transaction_8 = known_countries_of_transaction_8;
	}

	public void setOther_expected_countries_5(String other_expected_countries_5) {
		this.other_expected_countries_5 = other_expected_countries_5;
	}

	public void setOther_expected_countries_6(String other_expected_countries_6) {
		this.other_expected_countries_6 = other_expected_countries_6;
	}

	public void setOther_expected_countries_7(String other_expected_countries_7) {
		this.other_expected_countries_7 = other_expected_countries_7;
	}

	public void setOther_expected_countries_8(String other_expected_countries_8) {
		this.other_expected_countries_8 = other_expected_countries_8;
	}

	public void setAddinfo_primaryaddress(String addinfo_primaryaddress) {
		this.addinfo_primaryaddress = addinfo_primaryaddress;
	}

	public void setJoint_holder1_primaryaddress(String joint_holder1_primaryaddress) {
		this.joint_holder1_primaryaddress = joint_holder1_primaryaddress;
	}

	public void setJoint_holder2_primaryaddress(String joint_holder2_primaryaddress) {
		this.joint_holder2_primaryaddress = joint_holder2_primaryaddress;
	}

	public void setPrimary_dow_jones(String primary_dow_jones) {
		this.primary_dow_jones = primary_dow_jones;
	}

	public void setJoint_dow_jones(String joint_dow_jones) {
		this.joint_dow_jones = joint_dow_jones;
	}

	public KYC_I(String customer_id, String account_type, String name, String account_number, Date date_of_birth,
			String place_of_birth, String nationality, Date account_opening_date, String country_of_citizenship,
			String country_of_current_residency, String occupation, String business_activity, BigDecimal annual_income,
			String source_of_funds, String purpose_of_account_opening, String tax_registration, String tax_id_number,
			String primary_address, String primary_address_country, String primary_address_city,
			String primary_address_po_box, String mobile_number, String primary_telephone, String secondary_telephone,
			String email_id, String residential_status_changed, String new_country_of_residency,
			String new_city_of_residency, String new_po_box_of_residency, String account_satisfactory,
			String transaction_commensurate, String high_value_transactions_observed,
			String high_value_transactions_details1, String suspicion_observed, String suspicion_observed_details,
			String branch_satisfied_with_transactions, String supporting_document_obtained, BigDecimal current_turnover,
			BigDecimal expected_turnover, String expected_transaction_types, BigDecimal expected_transaction_volume,
			String transaction_frequency, String uae, String un, String ofac, String hmt, String eu, String others,
			String cbu_check_done, String google_media_search, String internal_deny_list_screening,
			String supporting_document_obtained_2, String is_pep, String senior_management_approval,
			String foreign_currency_request, String senior_management_approval_fc, String customer_risk,
			String high_risk_reason, String further_due_diligence, String observations_of_bank_official,
			String account_opening_officer_signature, String account_opening_officer_name,
			String account_opening_officer_designation, Date account_opening_officer_date,
			String branch_official_signature, String branch_official_name, String branch_official_designation,
			Date branch_official_date, String debit, String credit, String suspicion_observed_1,
			String country_of_citizenship_others, String reason_for_red_flag_1, String reason_for_red_flag_2,
			String joint_support_document_details, String branch, Date last_ecdd_date, String aof_available,
			String aof_remarks, String fatca_crs_available, String fatca_crs_remarks, String source_of_funds_available,
			String source_of_funds_remarks, String observations, Date current_date, Date report_date, String srl_no,
			String entry_user, Date entry_time, String auth_user, Date auth_time, String modify_user, Date modify_time,
			String verify_user, Date verify_time, String entity_flg, String auth_flg, String modify_flg, String del_flg,
			String joint_holder1_name, String joint_holder1_address, String joint_holder1_address_country,
			String joint_holder1_address_city, String joint_holder1_address_po_box, String joint_holder1_mobile,
			String joint_holder1_primary_telephone, String joint_holder1_secondary_telephone,
			String joint_holder1_email, String joint_holder1_residential_status_changed,
			String joint_holder1_new_country_of_residency, String joint_holder1_new_city_of_residency,
			String joint_holder1_new_po_box_of_residency, String joint_holder2_name, String joint_holder2_address,
			String joint_holder2_address_country, String joint_holder2_address_city,
			String joint_holder2_address_po_box, String joint_holder2_mobile, String joint_holder2_primary_telephone,
			String joint_holder2_secondary_telephone, String joint_holder2_email,
			String joint_holder2_residential_status_changed, String joint_holder2_new_country_of_residency,
			String joint_holder2_new_city_of_residency, String joint_holder2_new_po_box_of_residency,
			String primary_account_holder_nationality, String joint_account_holder_1_nationality,
			String joint_account_holder_2_nationality, String primary_account_holder_passport,
			String joint_account_holder_1_passport, String joint_account_holder_2_passport,
			String primary_account_holder_visa_eid, String joint_account_holder_1_visa_eid,
			String joint_account_holder_2_visa_eid, String primary_account_holder_valid_residence,
			String joint_account_holder_1_valid_residence, String joint_account_holder_2_valid_residence,
			String primary_account_holder_proof_source_income, String joint_account_holder_1_proof_source_income,
			String joint_account_holder_2_proof_source_income, String linked_account1_name,
			String linked_account1_number, String linked_account1_type, Date linked_account1_opening_date,
			String linked_account1_currency, String linked_account1_status, String linked_account2_name,
			String linked_account2_number, String linked_account2_type, Date linked_account2_opening_date,
			String linked_account2_currency, String linked_account2_status, String linked_account3_name,
			String linked_account3_number, String linked_account3_type, Date linked_account3_opening_date,
			String linked_account3_currency, String linked_account3_status, String linked_account4_name,
			String linked_account4_number, String linked_account4_type, Date linked_account4_opening_date,
			String linked_account4_currency, String linked_account4_status, String high_value_transactions_details2,
			String high_value_transactions_details3, String high_value_transactions_details4,
			String known_countries_of_transaction_1, String known_countries_of_transaction_2,
			String known_countries_of_transaction_3, String known_countries_of_transaction_4,
			String other_expected_countries_1, String other_expected_countries_2, String other_expected_countries_3,
			String other_expected_countries_4, String joint_uae, String joint_un, String joint_ofac, String joint_hmt,
			String joint_eu, String joint_others, String joint_cbu_check_done, String joint_google_media_search,
			String joint_internal_deny_list_screening, String joint_suspicion_observed,
			String joint_supporting_document_obtained, String known_countries_of_transaction_5,
			String known_countries_of_transaction_6, String known_countries_of_transaction_7,
			String known_countries_of_transaction_8, String other_expected_countries_5,
			String other_expected_countries_6, String other_expected_countries_7, String other_expected_countries_8,
			String addinfo_primaryaddress, String joint_holder1_primaryaddress, String joint_holder2_primaryaddress,
			String primary_dow_jones, String joint_dow_jones) {
		super();
		this.customer_id = customer_id;
		this.account_type = account_type;
		this.name = name;
		this.account_number = account_number;
		this.date_of_birth = date_of_birth;
		this.place_of_birth = place_of_birth;
		this.nationality = nationality;
		this.account_opening_date = account_opening_date;
		this.country_of_citizenship = country_of_citizenship;
		this.country_of_current_residency = country_of_current_residency;
		this.occupation = occupation;
		this.business_activity = business_activity;
		this.annual_income = annual_income;
		this.source_of_funds = source_of_funds;
		this.purpose_of_account_opening = purpose_of_account_opening;
		this.tax_registration = tax_registration;
		this.tax_id_number = tax_id_number;
		this.primary_address = primary_address;
		this.primary_address_country = primary_address_country;
		this.primary_address_city = primary_address_city;
		this.primary_address_po_box = primary_address_po_box;
		this.mobile_number = mobile_number;
		this.primary_telephone = primary_telephone;
		this.secondary_telephone = secondary_telephone;
		this.email_id = email_id;
		this.residential_status_changed = residential_status_changed;
		this.new_country_of_residency = new_country_of_residency;
		this.new_city_of_residency = new_city_of_residency;
		this.new_po_box_of_residency = new_po_box_of_residency;
		this.account_satisfactory = account_satisfactory;
		this.transaction_commensurate = transaction_commensurate;
		this.high_value_transactions_observed = high_value_transactions_observed;
		this.high_value_transactions_details1 = high_value_transactions_details1;
		this.suspicion_observed = suspicion_observed;
		this.suspicion_observed_details = suspicion_observed_details;
		this.branch_satisfied_with_transactions = branch_satisfied_with_transactions;
		this.supporting_document_obtained = supporting_document_obtained;
		this.current_turnover = current_turnover;
		this.expected_turnover = expected_turnover;
		this.expected_transaction_types = expected_transaction_types;
		this.expected_transaction_volume = expected_transaction_volume;
		this.transaction_frequency = transaction_frequency;
		this.uae = uae;
		this.un = un;
		this.ofac = ofac;
		this.hmt = hmt;
		this.eu = eu;
		this.others = others;
		this.cbu_check_done = cbu_check_done;
		this.google_media_search = google_media_search;
		this.internal_deny_list_screening = internal_deny_list_screening;
		this.supporting_document_obtained_2 = supporting_document_obtained_2;
		this.is_pep = is_pep;
		this.senior_management_approval = senior_management_approval;
		this.foreign_currency_request = foreign_currency_request;
		this.senior_management_approval_fc = senior_management_approval_fc;
		this.customer_risk = customer_risk;
		this.high_risk_reason = high_risk_reason;
		this.further_due_diligence = further_due_diligence;
		this.observations_of_bank_official = observations_of_bank_official;
		this.account_opening_officer_signature = account_opening_officer_signature;
		this.account_opening_officer_name = account_opening_officer_name;
		this.account_opening_officer_designation = account_opening_officer_designation;
		this.account_opening_officer_date = account_opening_officer_date;
		this.branch_official_signature = branch_official_signature;
		this.branch_official_name = branch_official_name;
		this.branch_official_designation = branch_official_designation;
		this.branch_official_date = branch_official_date;
		this.debit = debit;
		this.credit = credit;
		this.suspicion_observed_1 = suspicion_observed_1;
		this.country_of_citizenship_others = country_of_citizenship_others;
		this.reason_for_red_flag_1 = reason_for_red_flag_1;
		this.reason_for_red_flag_2 = reason_for_red_flag_2;
		this.joint_support_document_details = joint_support_document_details;
		this.branch = branch;
		this.last_ecdd_date = last_ecdd_date;
		this.aof_available = aof_available;
		this.aof_remarks = aof_remarks;
		this.fatca_crs_available = fatca_crs_available;
		this.fatca_crs_remarks = fatca_crs_remarks;
		this.source_of_funds_available = source_of_funds_available;
		this.source_of_funds_remarks = source_of_funds_remarks;
		this.observations = observations;
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
		this.joint_holder1_name = joint_holder1_name;
		this.joint_holder1_address = joint_holder1_address;
		this.joint_holder1_address_country = joint_holder1_address_country;
		this.joint_holder1_address_city = joint_holder1_address_city;
		this.joint_holder1_address_po_box = joint_holder1_address_po_box;
		this.joint_holder1_mobile = joint_holder1_mobile;
		this.joint_holder1_primary_telephone = joint_holder1_primary_telephone;
		this.joint_holder1_secondary_telephone = joint_holder1_secondary_telephone;
		this.joint_holder1_email = joint_holder1_email;
		this.joint_holder1_residential_status_changed = joint_holder1_residential_status_changed;
		this.joint_holder1_new_country_of_residency = joint_holder1_new_country_of_residency;
		this.joint_holder1_new_city_of_residency = joint_holder1_new_city_of_residency;
		this.joint_holder1_new_po_box_of_residency = joint_holder1_new_po_box_of_residency;
		this.joint_holder2_name = joint_holder2_name;
		this.joint_holder2_address = joint_holder2_address;
		this.joint_holder2_address_country = joint_holder2_address_country;
		this.joint_holder2_address_city = joint_holder2_address_city;
		this.joint_holder2_address_po_box = joint_holder2_address_po_box;
		this.joint_holder2_mobile = joint_holder2_mobile;
		this.joint_holder2_primary_telephone = joint_holder2_primary_telephone;
		this.joint_holder2_secondary_telephone = joint_holder2_secondary_telephone;
		this.joint_holder2_email = joint_holder2_email;
		this.joint_holder2_residential_status_changed = joint_holder2_residential_status_changed;
		this.joint_holder2_new_country_of_residency = joint_holder2_new_country_of_residency;
		this.joint_holder2_new_city_of_residency = joint_holder2_new_city_of_residency;
		this.joint_holder2_new_po_box_of_residency = joint_holder2_new_po_box_of_residency;
		this.primary_account_holder_nationality = primary_account_holder_nationality;
		this.joint_account_holder_1_nationality = joint_account_holder_1_nationality;
		this.joint_account_holder_2_nationality = joint_account_holder_2_nationality;
		this.primary_account_holder_passport = primary_account_holder_passport;
		this.joint_account_holder_1_passport = joint_account_holder_1_passport;
		this.joint_account_holder_2_passport = joint_account_holder_2_passport;
		this.primary_account_holder_visa_eid = primary_account_holder_visa_eid;
		this.joint_account_holder_1_visa_eid = joint_account_holder_1_visa_eid;
		this.joint_account_holder_2_visa_eid = joint_account_holder_2_visa_eid;
		this.primary_account_holder_valid_residence = primary_account_holder_valid_residence;
		this.joint_account_holder_1_valid_residence = joint_account_holder_1_valid_residence;
		this.joint_account_holder_2_valid_residence = joint_account_holder_2_valid_residence;
		this.primary_account_holder_proof_source_income = primary_account_holder_proof_source_income;
		this.joint_account_holder_1_proof_source_income = joint_account_holder_1_proof_source_income;
		this.joint_account_holder_2_proof_source_income = joint_account_holder_2_proof_source_income;
		this.linked_account1_name = linked_account1_name;
		this.linked_account1_number = linked_account1_number;
		this.linked_account1_type = linked_account1_type;
		this.linked_account1_opening_date = linked_account1_opening_date;
		this.linked_account1_currency = linked_account1_currency;
		this.linked_account1_status = linked_account1_status;
		this.linked_account2_name = linked_account2_name;
		this.linked_account2_number = linked_account2_number;
		this.linked_account2_type = linked_account2_type;
		this.linked_account2_opening_date = linked_account2_opening_date;
		this.linked_account2_currency = linked_account2_currency;
		this.linked_account2_status = linked_account2_status;
		this.linked_account3_name = linked_account3_name;
		this.linked_account3_number = linked_account3_number;
		this.linked_account3_type = linked_account3_type;
		this.linked_account3_opening_date = linked_account3_opening_date;
		this.linked_account3_currency = linked_account3_currency;
		this.linked_account3_status = linked_account3_status;
		this.linked_account4_name = linked_account4_name;
		this.linked_account4_number = linked_account4_number;
		this.linked_account4_type = linked_account4_type;
		this.linked_account4_opening_date = linked_account4_opening_date;
		this.linked_account4_currency = linked_account4_currency;
		this.linked_account4_status = linked_account4_status;
		this.high_value_transactions_details2 = high_value_transactions_details2;
		this.high_value_transactions_details3 = high_value_transactions_details3;
		this.high_value_transactions_details4 = high_value_transactions_details4;
		this.known_countries_of_transaction_1 = known_countries_of_transaction_1;
		this.known_countries_of_transaction_2 = known_countries_of_transaction_2;
		this.known_countries_of_transaction_3 = known_countries_of_transaction_3;
		this.known_countries_of_transaction_4 = known_countries_of_transaction_4;
		this.other_expected_countries_1 = other_expected_countries_1;
		this.other_expected_countries_2 = other_expected_countries_2;
		this.other_expected_countries_3 = other_expected_countries_3;
		this.other_expected_countries_4 = other_expected_countries_4;
		this.joint_uae = joint_uae;
		this.joint_un = joint_un;
		this.joint_ofac = joint_ofac;
		this.joint_hmt = joint_hmt;
		this.joint_eu = joint_eu;
		this.joint_others = joint_others;
		this.joint_cbu_check_done = joint_cbu_check_done;
		this.joint_google_media_search = joint_google_media_search;
		this.joint_internal_deny_list_screening = joint_internal_deny_list_screening;
		this.joint_suspicion_observed = joint_suspicion_observed;
		this.joint_supporting_document_obtained = joint_supporting_document_obtained;
		this.known_countries_of_transaction_5 = known_countries_of_transaction_5;
		this.known_countries_of_transaction_6 = known_countries_of_transaction_6;
		this.known_countries_of_transaction_7 = known_countries_of_transaction_7;
		this.known_countries_of_transaction_8 = known_countries_of_transaction_8;
		this.other_expected_countries_5 = other_expected_countries_5;
		this.other_expected_countries_6 = other_expected_countries_6;
		this.other_expected_countries_7 = other_expected_countries_7;
		this.other_expected_countries_8 = other_expected_countries_8;
		this.addinfo_primaryaddress = addinfo_primaryaddress;
		this.joint_holder1_primaryaddress = joint_holder1_primaryaddress;
		this.joint_holder2_primaryaddress = joint_holder2_primaryaddress;
		this.primary_dow_jones = primary_dow_jones;
		this.joint_dow_jones = joint_dow_jones;
	}

	@Override
	public String toString() {
		return "KYC_I [customer_id=" + customer_id + ", account_type=" + account_type + ", name=" + name
				+ ", account_number=" + account_number + ", date_of_birth=" + date_of_birth + ", place_of_birth="
				+ place_of_birth + ", nationality=" + nationality + ", account_opening_date=" + account_opening_date
				+ ", country_of_citizenship=" + country_of_citizenship + ", country_of_current_residency="
				+ country_of_current_residency + ", occupation=" + occupation + ", business_activity="
				+ business_activity + ", annual_income=" + annual_income + ", source_of_funds=" + source_of_funds
				+ ", purpose_of_account_opening=" + purpose_of_account_opening + ", tax_registration="
				+ tax_registration + ", tax_id_number=" + tax_id_number + ", primary_address=" + primary_address
				+ ", primary_address_country=" + primary_address_country + ", primary_address_city="
				+ primary_address_city + ", primary_address_po_box=" + primary_address_po_box + ", mobile_number="
				+ mobile_number + ", primary_telephone=" + primary_telephone + ", secondary_telephone="
				+ secondary_telephone + ", email_id=" + email_id + ", residential_status_changed="
				+ residential_status_changed + ", new_country_of_residency=" + new_country_of_residency
				+ ", new_city_of_residency=" + new_city_of_residency + ", new_po_box_of_residency="
				+ new_po_box_of_residency + ", account_satisfactory=" + account_satisfactory
				+ ", transaction_commensurate=" + transaction_commensurate + ", high_value_transactions_observed="
				+ high_value_transactions_observed + ", high_value_transactions_details1="
				+ high_value_transactions_details1 + ", suspicion_observed=" + suspicion_observed
				+ ", suspicion_observed_details=" + suspicion_observed_details + ", branch_satisfied_with_transactions="
				+ branch_satisfied_with_transactions + ", supporting_document_obtained=" + supporting_document_obtained
				+ ", current_turnover=" + current_turnover + ", expected_turnover=" + expected_turnover
				+ ", expected_transaction_types=" + expected_transaction_types + ", expected_transaction_volume="
				+ expected_transaction_volume + ", transaction_frequency=" + transaction_frequency + ", uae=" + uae
				+ ", un=" + un + ", ofac=" + ofac + ", hmt=" + hmt + ", eu=" + eu + ", others=" + others
				+ ", cbu_check_done=" + cbu_check_done + ", google_media_search=" + google_media_search
				+ ", internal_deny_list_screening=" + internal_deny_list_screening + ", supporting_document_obtained_2="
				+ supporting_document_obtained_2 + ", is_pep=" + is_pep + ", senior_management_approval="
				+ senior_management_approval + ", foreign_currency_request=" + foreign_currency_request
				+ ", senior_management_approval_fc=" + senior_management_approval_fc + ", customer_risk="
				+ customer_risk + ", high_risk_reason=" + high_risk_reason + ", further_due_diligence="
				+ further_due_diligence + ", observations_of_bank_official=" + observations_of_bank_official
				+ ", account_opening_officer_signature=" + account_opening_officer_signature
				+ ", account_opening_officer_name=" + account_opening_officer_name
				+ ", account_opening_officer_designation=" + account_opening_officer_designation
				+ ", account_opening_officer_date=" + account_opening_officer_date + ", branch_official_signature="
				+ branch_official_signature + ", branch_official_name=" + branch_official_name
				+ ", branch_official_designation=" + branch_official_designation + ", branch_official_date="
				+ branch_official_date + ", debit=" + debit + ", credit=" + credit + ", suspicion_observed_1="
				+ suspicion_observed_1 + ", country_of_citizenship_others=" + country_of_citizenship_others
				+ ", reason_for_red_flag_1=" + reason_for_red_flag_1 + ", reason_for_red_flag_2="
				+ reason_for_red_flag_2 + ", joint_support_document_details=" + joint_support_document_details
				+ ", branch=" + branch + ", last_ecdd_date=" + last_ecdd_date + ", aof_available=" + aof_available
				+ ", aof_remarks=" + aof_remarks + ", fatca_crs_available=" + fatca_crs_available
				+ ", fatca_crs_remarks=" + fatca_crs_remarks + ", source_of_funds_available="
				+ source_of_funds_available + ", source_of_funds_remarks=" + source_of_funds_remarks + ", observations="
				+ observations + ", current_date=" + current_date + ", report_date=" + report_date + ", srl_no="
				+ srl_no + ", entry_user=" + entry_user + ", entry_time=" + entry_time + ", auth_user=" + auth_user
				+ ", auth_time=" + auth_time + ", modify_user=" + modify_user + ", modify_time=" + modify_time
				+ ", verify_user=" + verify_user + ", verify_time=" + verify_time + ", entity_flg=" + entity_flg
				+ ", auth_flg=" + auth_flg + ", modify_flg=" + modify_flg + ", del_flg=" + del_flg
				+ ", joint_holder1_name=" + joint_holder1_name + ", joint_holder1_address=" + joint_holder1_address
				+ ", joint_holder1_address_country=" + joint_holder1_address_country + ", joint_holder1_address_city="
				+ joint_holder1_address_city + ", joint_holder1_address_po_box=" + joint_holder1_address_po_box
				+ ", joint_holder1_mobile=" + joint_holder1_mobile + ", joint_holder1_primary_telephone="
				+ joint_holder1_primary_telephone + ", joint_holder1_secondary_telephone="
				+ joint_holder1_secondary_telephone + ", joint_holder1_email=" + joint_holder1_email
				+ ", joint_holder1_residential_status_changed=" + joint_holder1_residential_status_changed
				+ ", joint_holder1_new_country_of_residency=" + joint_holder1_new_country_of_residency
				+ ", joint_holder1_new_city_of_residency=" + joint_holder1_new_city_of_residency
				+ ", joint_holder1_new_po_box_of_residency=" + joint_holder1_new_po_box_of_residency
				+ ", joint_holder2_name=" + joint_holder2_name + ", joint_holder2_address=" + joint_holder2_address
				+ ", joint_holder2_address_country=" + joint_holder2_address_country + ", joint_holder2_address_city="
				+ joint_holder2_address_city + ", joint_holder2_address_po_box=" + joint_holder2_address_po_box
				+ ", joint_holder2_mobile=" + joint_holder2_mobile + ", joint_holder2_primary_telephone="
				+ joint_holder2_primary_telephone + ", joint_holder2_secondary_telephone="
				+ joint_holder2_secondary_telephone + ", joint_holder2_email=" + joint_holder2_email
				+ ", joint_holder2_residential_status_changed=" + joint_holder2_residential_status_changed
				+ ", joint_holder2_new_country_of_residency=" + joint_holder2_new_country_of_residency
				+ ", joint_holder2_new_city_of_residency=" + joint_holder2_new_city_of_residency
				+ ", joint_holder2_new_po_box_of_residency=" + joint_holder2_new_po_box_of_residency
				+ ", primary_account_holder_nationality=" + primary_account_holder_nationality
				+ ", joint_account_holder_1_nationality=" + joint_account_holder_1_nationality
				+ ", joint_account_holder_2_nationality=" + joint_account_holder_2_nationality
				+ ", primary_account_holder_passport=" + primary_account_holder_passport
				+ ", joint_account_holder_1_passport=" + joint_account_holder_1_passport
				+ ", joint_account_holder_2_passport=" + joint_account_holder_2_passport
				+ ", primary_account_holder_visa_eid=" + primary_account_holder_visa_eid
				+ ", joint_account_holder_1_visa_eid=" + joint_account_holder_1_visa_eid
				+ ", joint_account_holder_2_visa_eid=" + joint_account_holder_2_visa_eid
				+ ", primary_account_holder_valid_residence=" + primary_account_holder_valid_residence
				+ ", joint_account_holder_1_valid_residence=" + joint_account_holder_1_valid_residence
				+ ", joint_account_holder_2_valid_residence=" + joint_account_holder_2_valid_residence
				+ ", primary_account_holder_proof_source_income=" + primary_account_holder_proof_source_income
				+ ", joint_account_holder_1_proof_source_income=" + joint_account_holder_1_proof_source_income
				+ ", joint_account_holder_2_proof_source_income=" + joint_account_holder_2_proof_source_income
				+ ", linked_account1_name=" + linked_account1_name + ", linked_account1_number="
				+ linked_account1_number + ", linked_account1_type=" + linked_account1_type
				+ ", linked_account1_opening_date=" + linked_account1_opening_date + ", linked_account1_currency="
				+ linked_account1_currency + ", linked_account1_status=" + linked_account1_status
				+ ", linked_account2_name=" + linked_account2_name + ", linked_account2_number="
				+ linked_account2_number + ", linked_account2_type=" + linked_account2_type
				+ ", linked_account2_opening_date=" + linked_account2_opening_date + ", linked_account2_currency="
				+ linked_account2_currency + ", linked_account2_status=" + linked_account2_status
				+ ", linked_account3_name=" + linked_account3_name + ", linked_account3_number="
				+ linked_account3_number + ", linked_account3_type=" + linked_account3_type
				+ ", linked_account3_opening_date=" + linked_account3_opening_date + ", linked_account3_currency="
				+ linked_account3_currency + ", linked_account3_status=" + linked_account3_status
				+ ", linked_account4_name=" + linked_account4_name + ", linked_account4_number="
				+ linked_account4_number + ", linked_account4_type=" + linked_account4_type
				+ ", linked_account4_opening_date=" + linked_account4_opening_date + ", linked_account4_currency="
				+ linked_account4_currency + ", linked_account4_status=" + linked_account4_status
				+ ", high_value_transactions_details2=" + high_value_transactions_details2
				+ ", high_value_transactions_details3=" + high_value_transactions_details3
				+ ", high_value_transactions_details4=" + high_value_transactions_details4
				+ ", known_countries_of_transaction_1=" + known_countries_of_transaction_1
				+ ", known_countries_of_transaction_2=" + known_countries_of_transaction_2
				+ ", known_countries_of_transaction_3=" + known_countries_of_transaction_3
				+ ", known_countries_of_transaction_4=" + known_countries_of_transaction_4
				+ ", other_expected_countries_1=" + other_expected_countries_1 + ", other_expected_countries_2="
				+ other_expected_countries_2 + ", other_expected_countries_3=" + other_expected_countries_3
				+ ", other_expected_countries_4=" + other_expected_countries_4 + ", joint_uae=" + joint_uae
				+ ", joint_un=" + joint_un + ", joint_ofac=" + joint_ofac + ", joint_hmt=" + joint_hmt + ", joint_eu="
				+ joint_eu + ", joint_others=" + joint_others + ", joint_cbu_check_done=" + joint_cbu_check_done
				+ ", joint_google_media_search=" + joint_google_media_search + ", joint_internal_deny_list_screening="
				+ joint_internal_deny_list_screening + ", joint_suspicion_observed=" + joint_suspicion_observed
				+ ", joint_supporting_document_obtained=" + joint_supporting_document_obtained
				+ ", known_countries_of_transaction_5=" + known_countries_of_transaction_5
				+ ", known_countries_of_transaction_6=" + known_countries_of_transaction_6
				+ ", known_countries_of_transaction_7=" + known_countries_of_transaction_7
				+ ", known_countries_of_transaction_8=" + known_countries_of_transaction_8
				+ ", other_expected_countries_5=" + other_expected_countries_5 + ", other_expected_countries_6="
				+ other_expected_countries_6 + ", other_expected_countries_7=" + other_expected_countries_7
				+ ", other_expected_countries_8=" + other_expected_countries_8 + ", addinfo_primaryaddress="
				+ addinfo_primaryaddress + ", joint_holder1_primaryaddress=" + joint_holder1_primaryaddress
				+ ", joint_holder2_primaryaddress=" + joint_holder2_primaryaddress + ", primary_dow_jones="
				+ primary_dow_jones + ", joint_dow_jones=" + joint_dow_jones + ", getCustomer_id()=" + getCustomer_id()
				+ ", getAccount_type()=" + getAccount_type() + ", getName()=" + getName() + ", getAccount_number()="
				+ getAccount_number() + ", getDate_of_birth()=" + getDate_of_birth() + ", getPlace_of_birth()="
				+ getPlace_of_birth() + ", getNationality()=" + getNationality() + ", getAccount_opening_date()="
				+ getAccount_opening_date() + ", getCountry_of_citizenship()=" + getCountry_of_citizenship()
				+ ", getCountry_of_current_residency()=" + getCountry_of_current_residency() + ", getOccupation()="
				+ getOccupation() + ", getBusiness_activity()=" + getBusiness_activity() + ", getAnnual_income()="
				+ getAnnual_income() + ", getSource_of_funds()=" + getSource_of_funds()
				+ ", getPurpose_of_account_opening()=" + getPurpose_of_account_opening() + ", getTax_registration()="
				+ getTax_registration() + ", getTax_id_number()=" + getTax_id_number() + ", getPrimary_address()="
				+ getPrimary_address() + ", getPrimary_address_country()=" + getPrimary_address_country()
				+ ", getPrimary_address_city()=" + getPrimary_address_city() + ", getPrimary_address_po_box()="
				+ getPrimary_address_po_box() + ", getMobile_number()=" + getMobile_number()
				+ ", getPrimary_telephone()=" + getPrimary_telephone() + ", getSecondary_telephone()="
				+ getSecondary_telephone() + ", getEmail_id()=" + getEmail_id() + ", getResidential_status_changed()="
				+ getResidential_status_changed() + ", getNew_country_of_residency()=" + getNew_country_of_residency()
				+ ", getNew_city_of_residency()=" + getNew_city_of_residency() + ", getNew_po_box_of_residency()="
				+ getNew_po_box_of_residency() + ", getAccount_satisfactory()=" + getAccount_satisfactory()
				+ ", getTransaction_commensurate()=" + getTransaction_commensurate()
				+ ", getHigh_value_transactions_observed()=" + getHigh_value_transactions_observed()
				+ ", getHigh_value_transactions_details1()=" + getHigh_value_transactions_details1()
				+ ", getSuspicion_observed()=" + getSuspicion_observed() + ", getSuspicion_observed_details()="
				+ getSuspicion_observed_details() + ", getBranch_satisfied_with_transactions()="
				+ getBranch_satisfied_with_transactions() + ", getSupporting_document_obtained()="
				+ getSupporting_document_obtained() + ", getCurrent_turnover()=" + getCurrent_turnover()
				+ ", getExpected_turnover()=" + getExpected_turnover() + ", getExpected_transaction_types()="
				+ getExpected_transaction_types() + ", getExpected_transaction_volume()="
				+ getExpected_transaction_volume() + ", getTransaction_frequency()=" + getTransaction_frequency()
				+ ", getUae()=" + getUae() + ", getUn()=" + getUn() + ", getOfac()=" + getOfac() + ", getHmt()="
				+ getHmt() + ", getEu()=" + getEu() + ", getOthers()=" + getOthers() + ", getCbu_check_done()="
				+ getCbu_check_done() + ", getGoogle_media_search()=" + getGoogle_media_search()
				+ ", getInternal_deny_list_screening()=" + getInternal_deny_list_screening()
				+ ", getSupporting_document_obtained_2()=" + getSupporting_document_obtained_2() + ", getIs_pep()="
				+ getIs_pep() + ", getSenior_management_approval()=" + getSenior_management_approval()
				+ ", getForeign_currency_request()=" + getForeign_currency_request()
				+ ", getSenior_management_approval_fc()=" + getSenior_management_approval_fc() + ", getCustomer_risk()="
				+ getCustomer_risk() + ", getHigh_risk_reason()=" + getHigh_risk_reason()
				+ ", getFurther_due_diligence()=" + getFurther_due_diligence() + ", getObservations_of_bank_official()="
				+ getObservations_of_bank_official() + ", getAccount_opening_officer_signature()="
				+ getAccount_opening_officer_signature() + ", getAccount_opening_officer_name()="
				+ getAccount_opening_officer_name() + ", getAccount_opening_officer_designation()="
				+ getAccount_opening_officer_designation() + ", getAccount_opening_officer_date()="
				+ getAccount_opening_officer_date() + ", getBranch_official_signature()="
				+ getBranch_official_signature() + ", getBranch_official_name()=" + getBranch_official_name()
				+ ", getBranch_official_designation()=" + getBranch_official_designation()
				+ ", getBranch_official_date()=" + getBranch_official_date() + ", getDebit()=" + getDebit()
				+ ", getCredit()=" + getCredit() + ", getSuspicion_observed_1()=" + getSuspicion_observed_1()
				+ ", getCountry_of_citizenship_others()=" + getCountry_of_citizenship_others()
				+ ", getReason_for_red_flag_1()=" + getReason_for_red_flag_1() + ", getReason_for_red_flag_2()="
				+ getReason_for_red_flag_2() + ", getJoint_support_document_details()="
				+ getJoint_support_document_details() + ", getBranch()=" + getBranch() + ", getLast_ecdd_date()="
				+ getLast_ecdd_date() + ", getAof_available()=" + getAof_available() + ", getAof_remarks()="
				+ getAof_remarks() + ", getFatca_crs_available()=" + getFatca_crs_available()
				+ ", getFatca_crs_remarks()=" + getFatca_crs_remarks() + ", getSource_of_funds_available()="
				+ getSource_of_funds_available() + ", getSource_of_funds_remarks()=" + getSource_of_funds_remarks()
				+ ", getObservations()=" + getObservations() + ", getCurrent_date()=" + getCurrent_date()
				+ ", getReport_date()=" + getReport_date() + ", getSrl_no()=" + getSrl_no() + ", getEntry_user()="
				+ getEntry_user() + ", getEntry_time()=" + getEntry_time() + ", getAuth_user()=" + getAuth_user()
				+ ", getAuth_time()=" + getAuth_time() + ", getModify_user()=" + getModify_user()
				+ ", getModify_time()=" + getModify_time() + ", getVerify_user()=" + getVerify_user()
				+ ", getVerify_time()=" + getVerify_time() + ", getEntity_flg()=" + getEntity_flg() + ", getAuth_flg()="
				+ getAuth_flg() + ", getModify_flg()=" + getModify_flg() + ", getDel_flg()=" + getDel_flg()
				+ ", getJoint_holder1_name()=" + getJoint_holder1_name() + ", getJoint_holder1_address()="
				+ getJoint_holder1_address() + ", getJoint_holder1_address_country()="
				+ getJoint_holder1_address_country() + ", getJoint_holder1_address_city()="
				+ getJoint_holder1_address_city() + ", getJoint_holder1_address_po_box()="
				+ getJoint_holder1_address_po_box() + ", getJoint_holder1_mobile()=" + getJoint_holder1_mobile()
				+ ", getJoint_holder1_primary_telephone()=" + getJoint_holder1_primary_telephone()
				+ ", getJoint_holder1_secondary_telephone()=" + getJoint_holder1_secondary_telephone()
				+ ", getJoint_holder1_email()=" + getJoint_holder1_email()
				+ ", getJoint_holder1_residential_status_changed()=" + getJoint_holder1_residential_status_changed()
				+ ", getJoint_holder1_new_country_of_residency()=" + getJoint_holder1_new_country_of_residency()
				+ ", getJoint_holder1_new_city_of_residency()=" + getJoint_holder1_new_city_of_residency()
				+ ", getJoint_holder1_new_po_box_of_residency()=" + getJoint_holder1_new_po_box_of_residency()
				+ ", getJoint_holder2_name()=" + getJoint_holder2_name() + ", getJoint_holder2_address()="
				+ getJoint_holder2_address() + ", getJoint_holder2_address_country()="
				+ getJoint_holder2_address_country() + ", getJoint_holder2_address_city()="
				+ getJoint_holder2_address_city() + ", getJoint_holder2_address_po_box()="
				+ getJoint_holder2_address_po_box() + ", getJoint_holder2_mobile()=" + getJoint_holder2_mobile()
				+ ", getJoint_holder2_primary_telephone()=" + getJoint_holder2_primary_telephone()
				+ ", getJoint_holder2_secondary_telephone()=" + getJoint_holder2_secondary_telephone()
				+ ", getJoint_holder2_email()=" + getJoint_holder2_email()
				+ ", getJoint_holder2_residential_status_changed()=" + getJoint_holder2_residential_status_changed()
				+ ", getJoint_holder2_new_country_of_residency()=" + getJoint_holder2_new_country_of_residency()
				+ ", getJoint_holder2_new_city_of_residency()=" + getJoint_holder2_new_city_of_residency()
				+ ", getJoint_holder2_new_po_box_of_residency()=" + getJoint_holder2_new_po_box_of_residency()
				+ ", getPrimary_account_holder_nationality()=" + getPrimary_account_holder_nationality()
				+ ", getJoint_account_holder_1_nationality()=" + getJoint_account_holder_1_nationality()
				+ ", getJoint_account_holder_2_nationality()=" + getJoint_account_holder_2_nationality()
				+ ", getPrimary_account_holder_passport()=" + getPrimary_account_holder_passport()
				+ ", getJoint_account_holder_1_passport()=" + getJoint_account_holder_1_passport()
				+ ", getJoint_account_holder_2_passport()=" + getJoint_account_holder_2_passport()
				+ ", getPrimary_account_holder_visa_eid()=" + getPrimary_account_holder_visa_eid()
				+ ", getJoint_account_holder_1_visa_eid()=" + getJoint_account_holder_1_visa_eid()
				+ ", getJoint_account_holder_2_visa_eid()=" + getJoint_account_holder_2_visa_eid()
				+ ", getPrimary_account_holder_valid_residence()=" + getPrimary_account_holder_valid_residence()
				+ ", getJoint_account_holder_1_valid_residence()=" + getJoint_account_holder_1_valid_residence()
				+ ", getJoint_account_holder_2_valid_residence()=" + getJoint_account_holder_2_valid_residence()
				+ ", getPrimary_account_holder_proof_source_income()=" + getPrimary_account_holder_proof_source_income()
				+ ", getJoint_account_holder_1_proof_source_income()=" + getJoint_account_holder_1_proof_source_income()
				+ ", getJoint_account_holder_2_proof_source_income()=" + getJoint_account_holder_2_proof_source_income()
				+ ", getLinked_account1_name()=" + getLinked_account1_name() + ", getLinked_account1_number()="
				+ getLinked_account1_number() + ", getLinked_account1_type()=" + getLinked_account1_type()
				+ ", getLinked_account1_opening_date()=" + getLinked_account1_opening_date()
				+ ", getLinked_account1_currency()=" + getLinked_account1_currency() + ", getLinked_account1_status()="
				+ getLinked_account1_status() + ", getLinked_account2_name()=" + getLinked_account2_name()
				+ ", getLinked_account2_number()=" + getLinked_account2_number() + ", getLinked_account2_type()="
				+ getLinked_account2_type() + ", getLinked_account2_opening_date()=" + getLinked_account2_opening_date()
				+ ", getLinked_account2_currency()=" + getLinked_account2_currency() + ", getLinked_account2_status()="
				+ getLinked_account2_status() + ", getLinked_account3_name()=" + getLinked_account3_name()
				+ ", getLinked_account3_number()=" + getLinked_account3_number() + ", getLinked_account3_type()="
				+ getLinked_account3_type() + ", getLinked_account3_opening_date()=" + getLinked_account3_opening_date()
				+ ", getLinked_account3_currency()=" + getLinked_account3_currency() + ", getLinked_account3_status()="
				+ getLinked_account3_status() + ", getLinked_account4_name()=" + getLinked_account4_name()
				+ ", getLinked_account4_number()=" + getLinked_account4_number() + ", getLinked_account4_type()="
				+ getLinked_account4_type() + ", getLinked_account4_opening_date()=" + getLinked_account4_opening_date()
				+ ", getLinked_account4_currency()=" + getLinked_account4_currency() + ", getLinked_account4_status()="
				+ getLinked_account4_status() + ", getHigh_value_transactions_details2()="
				+ getHigh_value_transactions_details2() + ", getHigh_value_transactions_details3()="
				+ getHigh_value_transactions_details3() + ", getHigh_value_transactions_details4()="
				+ getHigh_value_transactions_details4() + ", getKnown_countries_of_transaction_1()="
				+ getKnown_countries_of_transaction_1() + ", getKnown_countries_of_transaction_2()="
				+ getKnown_countries_of_transaction_2() + ", getKnown_countries_of_transaction_3()="
				+ getKnown_countries_of_transaction_3() + ", getKnown_countries_of_transaction_4()="
				+ getKnown_countries_of_transaction_4() + ", getOther_expected_countries_1()="
				+ getOther_expected_countries_1() + ", getOther_expected_countries_2()="
				+ getOther_expected_countries_2() + ", getOther_expected_countries_3()="
				+ getOther_expected_countries_3() + ", getOther_expected_countries_4()="
				+ getOther_expected_countries_4() + ", getJoint_uae()=" + getJoint_uae() + ", getJoint_un()="
				+ getJoint_un() + ", getJoint_ofac()=" + getJoint_ofac() + ", getJoint_hmt()=" + getJoint_hmt()
				+ ", getJoint_eu()=" + getJoint_eu() + ", getJoint_others()=" + getJoint_others()
				+ ", getJoint_cbu_check_done()=" + getJoint_cbu_check_done() + ", getJoint_google_media_search()="
				+ getJoint_google_media_search() + ", getJoint_internal_deny_list_screening()="
				+ getJoint_internal_deny_list_screening() + ", getJoint_suspicion_observed()="
				+ getJoint_suspicion_observed() + ", getJoint_supporting_document_obtained()="
				+ getJoint_supporting_document_obtained() + ", getKnown_countries_of_transaction_5()="
				+ getKnown_countries_of_transaction_5() + ", getKnown_countries_of_transaction_6()="
				+ getKnown_countries_of_transaction_6() + ", getKnown_countries_of_transaction_7()="
				+ getKnown_countries_of_transaction_7() + ", getKnown_countries_of_transaction_8()="
				+ getKnown_countries_of_transaction_8() + ", getOther_expected_countries_5()="
				+ getOther_expected_countries_5() + ", getOther_expected_countries_6()="
				+ getOther_expected_countries_6() + ", getOther_expected_countries_7()="
				+ getOther_expected_countries_7() + ", getOther_expected_countries_8()="
				+ getOther_expected_countries_8() + ", getAddinfo_primaryaddress()=" + getAddinfo_primaryaddress()
				+ ", getJoint_holder1_primaryaddress()=" + getJoint_holder1_primaryaddress()
				+ ", getJoint_holder2_primaryaddress()=" + getJoint_holder2_primaryaddress()
				+ ", getPrimary_dow_jones()=" + getPrimary_dow_jones() + ", getJoint_dow_jones()="
				+ getJoint_dow_jones() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public KYC_I() {
		super();
		// TODO Auto-generated constructor stub
	}
}
