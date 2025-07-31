package com.bornfire.xbrl.services;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.KYC_Audit_Entity;
import com.bornfire.xbrl.entities.KYC_Audit_Rep;
import com.bornfire.xbrl.entities.Kyc_Repo;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.BRBS.EcddIndividualProfileRepository;
import com.bornfire.xbrl.entities.BRBS.Ecdd_Individual_Profile_Entity;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Transactional
@Service
public class Kyc_individual_service {
	@Autowired
	Environment env;
	@Autowired
	DataSource srcdataSource;

	@Autowired
	private Kyc_Repo kyc_repo;
	@Autowired
	private HttpSession session;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	UserProfileRep userProfileRep;

	@Autowired
	KYC_Audit_Rep KYC_Audit_Rep;

	@Autowired
	EcddIndividualProfileRepository ecddIndividualProfileRepository;

	/*
	 * public boolean updateKycData(String srl_no, KYC_I data, HttpServletRequest
	 * req) { Optional<KYC_I> optionalKyc = kyc_repo.findById(srl_no); String userId
	 * = (String) req.getSession().getAttribute("USERID"); String BRANCHCODE =
	 * (String) req.getSession().getAttribute("BRANCHCODE"); LocalDateTime
	 * currentDateTime = LocalDateTime.now();
	 * 
	 * if (optionalKyc.isPresent()) { KYC_I kycEntity = optionalKyc.get();
	 * Set<String> skipFields = new HashSet<>(Arrays.asList("entityFlg",
	 * "modifyFlg", "delFlg", "modifyUser", "verifyUser", "modifyTime",
	 * "verifyTime", "customerId"));
	 * 
	 * Map<String, String> changes = new LinkedHashMap<>();
	 * 
	 * kycEntity.setCustomer_id(data.getCustomer_id());
	 * kycEntity.setAccount_type(data.getAccount_type());
	 * kycEntity.setName(data.getName());
	 * kycEntity.setAccount_number(data.getAccount_number());
	 * kycEntity.setDate_of_birth(data.getDate_of_birth());
	 * kycEntity.setPlace_of_birth(data.getPlace_of_birth());
	 * kycEntity.setNationality(data.getNationality());
	 * kycEntity.setAccount_opening_date(data.getAccount_opening_date());
	 * kycEntity.setCountry_of_citizenship(data.getCountry_of_citizenship());
	 * kycEntity.setCountry_of_current_residency(data.
	 * getCountry_of_current_residency());
	 * kycEntity.setOccupation(data.getOccupation());
	 * kycEntity.setBusiness_activity(data.getBusiness_activity());
	 * kycEntity.setAnnual_income(data.getAnnual_income());
	 * kycEntity.setSource_of_funds(data.getSource_of_funds());
	 * kycEntity.setPurpose_of_account_opening(data.getPurpose_of_account_opening())
	 * ; kycEntity.setTax_registration(data.getTax_registration());
	 * kycEntity.setTax_id_number(data.getTax_id_number());
	 * kycEntity.setPrimary_address(data.getPrimary_address());
	 * kycEntity.setPrimary_address_country(data.getPrimary_address_country());
	 * kycEntity.setPrimary_address_city(data.getPrimary_address_city());
	 * kycEntity.setPrimary_address_po_box(data.getPrimary_address_po_box());
	 * kycEntity.setMobile_number(data.getMobile_number());
	 * kycEntity.setPrimary_telephone(data.getPrimary_telephone());
	 * kycEntity.setSecondary_telephone(data.getSecondary_telephone());
	 * kycEntity.setEmail_id(data.getEmail_id());
	 * kycEntity.setResidential_status_changed(data.getResidential_status_changed())
	 * ; kycEntity.setNew_country_of_residency(data.getNew_country_of_residency());
	 * kycEntity.setNew_city_of_residency(data.getNew_city_of_residency());
	 * kycEntity.setNew_po_box_of_residency(data.getNew_po_box_of_residency());
	 * kycEntity.setAccount_satisfactory(data.getAccount_satisfactory());
	 * kycEntity.setTransaction_commensurate(data.getTransaction_commensurate());
	 * kycEntity.setHigh_value_transactions_observed(data.
	 * getHigh_value_transactions_observed());
	 * kycEntity.setHigh_value_transactions_details1(data.
	 * getHigh_value_transactions_details1());
	 * kycEntity.setSuspicion_observed(data.getSuspicion_observed());
	 * kycEntity.setSuspicion_observed_details(data.getSuspicion_observed_details())
	 * ; kycEntity.setBranch_satisfied_with_transactions(data.
	 * getBranch_satisfied_with_transactions());
	 * kycEntity.setSupporting_document_obtained(data.
	 * getSupporting_document_obtained());
	 * kycEntity.setCurrent_turnover(data.getCurrent_turnover());
	 * kycEntity.setExpected_turnover(data.getExpected_turnover());
	 * kycEntity.setExpected_transaction_types(data.getExpected_transaction_types())
	 * ; kycEntity.setTransaction_frequency(data.getTransaction_frequency());
	 * kycEntity.setExpected_transaction_volume(data.getExpected_transaction_volume(
	 * )); kycEntity.setKnown_countries_of_transaction_1(data.
	 * getKnown_countries_of_transaction_1());
	 * kycEntity.setKnown_countries_of_transaction_2(data.
	 * getKnown_countries_of_transaction_2());
	 * kycEntity.setKnown_countries_of_transaction_3(data.
	 * getKnown_countries_of_transaction_3());
	 * kycEntity.setKnown_countries_of_transaction_4(data.
	 * getKnown_countries_of_transaction_4()); kycEntity.setUae(data.getUae());
	 * kycEntity.setUn(data.getUn()); kycEntity.setOfac(data.getOfac());
	 * kycEntity.setHmt(data.getHmt()); kycEntity.setEu(data.getEu());
	 * kycEntity.setOthers(data.getOthers());
	 * kycEntity.setCbu_check_done(data.getCbu_check_done());
	 * kycEntity.setGoogle_media_search(data.getGoogle_media_search());
	 * kycEntity.setInternal_deny_list_screening(data.
	 * getInternal_deny_list_screening());
	 * kycEntity.setSupporting_document_obtained_2(data.
	 * getSupporting_document_obtained_2()); kycEntity.setIs_pep(data.getIs_pep());
	 * kycEntity.setSenior_management_approval(data.getSenior_management_approval())
	 * ; kycEntity.setForeign_currency_request(data.getForeign_currency_request());
	 * kycEntity.setSenior_management_approval_fc(data.
	 * getSenior_management_approval_fc());
	 * kycEntity.setCustomer_risk(data.getCustomer_risk());
	 * kycEntity.setHigh_risk_reason(data.getHigh_risk_reason());
	 * kycEntity.setFurther_due_diligence(data.getFurther_due_diligence());
	 * kycEntity.setObservations_of_bank_official(data.
	 * getObservations_of_bank_official());
	 * kycEntity.setAccount_opening_officer_signature(data.
	 * getAccount_opening_officer_signature());
	 * kycEntity.setAccount_opening_officer_name(data.
	 * getAccount_opening_officer_name());
	 * kycEntity.setAccount_opening_officer_designation(data.
	 * getAccount_opening_officer_designation());
	 * kycEntity.setAccount_opening_officer_date(data.
	 * getAccount_opening_officer_date());
	 * kycEntity.setBranch_official_signature(data.getBranch_official_designation())
	 * ; kycEntity.setBranch_official_name(data.getBranch_official_name());
	 * kycEntity.setBranch_official_signature(data.getBranch_official_signature());
	 * kycEntity.setBranch_official_name(data.getBranch_official_name());
	 * kycEntity.setBranch_official_designation(data.getBranch_official_designation(
	 * )); kycEntity.setBranch_official_date(data.getBranch_official_date());
	 * kycEntity.setDebit(data.getDebit()); kycEntity.setCredit(data.getCredit());
	 * kycEntity.setSuspicion_observed_1(data.getSuspicion_observed_1());
	 * kycEntity.setCountry_of_citizenship_others(data.
	 * getCountry_of_citizenship_others());
	 * kycEntity.setReason_for_red_flag_1(data.getReason_for_red_flag_1());
	 * kycEntity.setReason_for_red_flag_2(data.getReason_for_red_flag_2());
	 * kycEntity.setJoint_support_document_details(data.
	 * getJoint_support_document_details()); kycEntity.setBranch(data.getBranch());
	 * kycEntity.setLast_ecdd_date(data.getLast_ecdd_date());
	 * kycEntity.setAof_available(data.getAof_available());
	 * kycEntity.setAof_remarks(data.getAof_remarks());
	 * kycEntity.setFatca_crs_available(data.getFatca_crs_available());
	 * kycEntity.setFatca_crs_remarks(data.getFatca_crs_remarks());
	 * kycEntity.setSource_of_funds_available(data.getSource_of_funds_available());
	 * kycEntity.setSource_of_funds_remarks(data.getSource_of_funds_remarks());
	 * kycEntity.setObservations(data.getObservations());
	 * kycEntity.setCurrent_date(data.getCurrent_date());
	 * kycEntity.setJoint_holder1_name(data.getJoint_holder1_name());
	 * kycEntity.setJoint_holder1_address(data.getJoint_holder1_address());
	 * kycEntity.setJoint_holder1_address_country(data.
	 * getJoint_holder1_address_country());
	 * kycEntity.setJoint_holder1_address_city(data.getJoint_holder1_address_city())
	 * ; kycEntity.setJoint_holder1_address_po_box(data.
	 * getJoint_holder1_address_po_box());
	 * kycEntity.setJoint_holder1_mobile(data.getJoint_holder1_mobile());
	 * kycEntity.setJoint_holder1_primary_telephone(data.
	 * getJoint_holder1_primary_telephone());
	 * kycEntity.setJoint_holder1_secondary_telephone(data.
	 * getJoint_holder1_secondary_telephone());
	 * kycEntity.setJoint_holder1_email(data.getJoint_holder1_email());
	 * kycEntity.setJoint_holder1_residential_status_changed(data.
	 * getJoint_holder1_residential_status_changed());
	 * kycEntity.setJoint_holder1_new_country_of_residency(data.
	 * getJoint_holder1_new_country_of_residency());
	 * kycEntity.setJoint_holder1_new_city_of_residency(data.
	 * getJoint_holder1_new_city_of_residency());
	 * kycEntity.setJoint_holder1_new_po_box_of_residency(data.
	 * getJoint_holder1_new_po_box_of_residency());
	 * kycEntity.setJoint_holder2_name(data.getJoint_holder2_name());
	 * kycEntity.setJoint_holder2_address(data.getJoint_holder2_address());
	 * kycEntity.setJoint_holder2_address_country(data.
	 * getJoint_holder2_address_country());
	 * kycEntity.setJoint_holder2_address_city(data.getJoint_holder2_address_city())
	 * ; kycEntity.setJoint_holder2_address_po_box(data.
	 * getJoint_holder2_address_po_box());
	 * kycEntity.setJoint_holder2_mobile(data.getJoint_holder2_mobile());
	 * kycEntity.setJoint_holder2_primary_telephone(data.
	 * getJoint_holder2_primary_telephone());
	 * kycEntity.setJoint_holder2_secondary_telephone(data.
	 * getJoint_holder2_secondary_telephone());
	 * kycEntity.setJoint_holder2_email(data.getJoint_holder2_email());
	 * kycEntity.setJoint_holder2_residential_status_changed(data.
	 * getJoint_holder2_residential_status_changed());
	 * kycEntity.setJoint_holder2_new_city_of_residency(data.
	 * getJoint_holder2_new_city_of_residency());
	 * kycEntity.setJoint_holder2_new_country_of_residency(data.
	 * getJoint_holder2_new_country_of_residency());
	 * kycEntity.setJoint_holder2_new_po_box_of_residency(data.
	 * getJoint_holder2_new_po_box_of_residency());
	 * kycEntity.setPrimary_account_holder_nationality(data.
	 * getPrimary_account_holder_nationality());
	 * kycEntity.setJoint_account_holder_1_nationality(data.
	 * getJoint_account_holder_1_nationality());
	 * kycEntity.setJoint_account_holder_2_nationality(data.
	 * getJoint_account_holder_2_nationality());
	 * kycEntity.setPrimary_account_holder_passport(data.
	 * getPrimary_account_holder_passport());
	 * kycEntity.setJoint_account_holder_1_passport(data.
	 * getJoint_account_holder_1_passport());
	 * kycEntity.setJoint_account_holder_2_passport(data.
	 * getJoint_account_holder_2_passport());
	 * kycEntity.setPrimary_account_holder_visa_eid(data.
	 * getPrimary_account_holder_visa_eid());
	 * kycEntity.setJoint_account_holder_1_visa_eid(data.
	 * getJoint_account_holder_1_visa_eid());
	 * kycEntity.setJoint_account_holder_2_visa_eid(data.
	 * getJoint_account_holder_2_visa_eid());
	 * kycEntity.setPrimary_account_holder_valid_residence(data.
	 * getPrimary_account_holder_valid_residence());
	 * kycEntity.setJoint_account_holder_1_valid_residence(data.
	 * getJoint_account_holder_1_valid_residence());
	 * kycEntity.setJoint_account_holder_2_valid_residence(data.
	 * getJoint_account_holder_2_valid_residence());
	 * kycEntity.setPrimary_account_holder_proof_source_income(
	 * data.getPrimary_account_holder_proof_source_income());
	 * kycEntity.setJoint_account_holder_1_proof_source_income(
	 * data.getJoint_account_holder_1_proof_source_income());
	 * kycEntity.setJoint_account_holder_2_proof_source_income(
	 * data.getJoint_account_holder_2_proof_source_income());
	 * kycEntity.setLinked_account1_name(data.getLinked_account1_name());
	 * kycEntity.setLinked_account1_number(data.getLinked_account1_number());
	 * kycEntity.setLinked_account1_type(data.getLinked_account1_type());
	 * kycEntity.setLinked_account1_opening_date(data.
	 * getLinked_account1_opening_date());
	 * kycEntity.setLinked_account1_currency(data.getLinked_account1_currency());
	 * kycEntity.setLinked_account1_status(data.getLinked_account1_status());
	 * kycEntity.setLinked_account2_name(data.getLinked_account2_name());
	 * kycEntity.setLinked_account2_number(data.getLinked_account2_number());
	 * kycEntity.setLinked_account2_type(data.getLinked_account2_type());
	 * kycEntity.setLinked_account2_opening_date(data.
	 * getLinked_account2_opening_date());
	 * kycEntity.setLinked_account2_currency(data.getLinked_account2_currency());
	 * kycEntity.setLinked_account2_status(data.getLinked_account2_status());
	 * kycEntity.setLinked_account3_name(data.getLinked_account3_name());
	 * kycEntity.setLinked_account3_number(data.getLinked_account3_number());
	 * kycEntity.setLinked_account3_type(data.getLinked_account3_type());
	 * kycEntity.setLinked_account3_opening_date(data.
	 * getLinked_account3_opening_date());
	 * kycEntity.setLinked_account3_currency(data.getLinked_account3_currency());
	 * kycEntity.setLinked_account3_status(data.getLinked_account3_status());
	 * kycEntity.setLinked_account4_name(data.getLinked_account4_name());
	 * kycEntity.setLinked_account4_number(data.getLinked_account4_number());
	 * kycEntity.setLinked_account4_type(data.getLinked_account4_type());
	 * kycEntity.setLinked_account4_opening_date(data.
	 * getLinked_account4_opening_date());
	 * kycEntity.setLinked_account4_currency(data.getLinked_account4_currency());
	 * kycEntity.setLinked_account4_status(data.getLinked_account4_status());
	 * kycEntity.setHigh_value_transactions_details2(data.
	 * getHigh_value_transactions_details2());
	 * kycEntity.setHigh_value_transactions_details3(data.
	 * getHigh_value_transactions_details3());
	 * kycEntity.setHigh_value_transactions_details4(data.
	 * getHigh_value_transactions_details4());
	 * kycEntity.setHigh_value_transactions_observed(data.
	 * getHigh_value_transactions_observed());
	 * kycEntity.setOther_expected_countries_1(data.getOther_expected_countries_1())
	 * ;
	 * kycEntity.setOther_expected_countries_2(data.getOther_expected_countries_2())
	 * ;
	 * kycEntity.setOther_expected_countries_3(data.getOther_expected_countries_3())
	 * ;
	 * kycEntity.setOther_expected_countries_4(data.getOther_expected_countries_4())
	 * ; kycEntity.setJoint_uae(data.getJoint_uae());
	 * kycEntity.setJoint_un(data.getJoint_un());
	 * kycEntity.setJoint_ofac(data.getJoint_ofac());
	 * kycEntity.setJoint_hmt(data.getJoint_hmt());
	 * kycEntity.setJoint_eu(data.getJoint_eu());
	 * kycEntity.setJoint_others(data.getJoint_others());
	 * kycEntity.setJoint_cbu_check_done(data.getJoint_cbu_check_done());
	 * kycEntity.setJoint_google_media_search(data.getJoint_google_media_search());
	 * kycEntity.setJoint_internal_deny_list_screening(data.
	 * getJoint_internal_deny_list_screening());
	 * kycEntity.setJoint_suspicion_observed(data.getJoint_suspicion_observed());
	 * kycEntity.setJoint_supporting_document_obtained(data.
	 * getJoint_supporting_document_obtained());
	 * kycEntity.setSupporting_document_obtained(data.
	 * getSupporting_document_obtained()); kycEntity.setModify_flg("Y");
	 * kycEntity.setEntity_flg("N"); kycEntity.setModify_user(userId);
	 * kycEntity.setKnown_countries_of_transaction_5(data.
	 * getKnown_countries_of_transaction_5());
	 * kycEntity.setKnown_countries_of_transaction_6(data.
	 * getKnown_countries_of_transaction_6());
	 * kycEntity.setKnown_countries_of_transaction_7(data.
	 * getKnown_countries_of_transaction_7());
	 * kycEntity.setKnown_countries_of_transaction_8(data.
	 * getKnown_countries_of_transaction_8());
	 * 
	 * kycEntity.setOther_expected_countries_5(data.getOther_expected_countries_5())
	 * ;
	 * kycEntity.setOther_expected_countries_6(data.getOther_expected_countries_6())
	 * ;
	 * kycEntity.setOther_expected_countries_7(data.getOther_expected_countries_7())
	 * ;
	 * kycEntity.setOther_expected_countries_8(data.getOther_expected_countries_8())
	 * ;
	 * 
	 * kycEntity.setAddinfo_primaryaddress(data.getAddinfo_primaryaddress());
	 * kycEntity.setJoint_holder1_primaryaddress(data.
	 * getJoint_holder1_primaryaddress());
	 * kycEntity.setJoint_holder2_primaryaddress(data.
	 * getJoint_holder2_primaryaddress());
	 * kycEntity.setPrimary_dow_jones(data.getPrimary_dow_jones());
	 * kycEntity.setJoint_dow_jones(data.getJoint_dow_jones());
	 * 
	 * kycEntity.setModify_time(Date.from(currentDateTime.atZone(ZoneId.
	 * systemDefault()).toInstant())); kycEntity.setBranch(BRANCHCODE);
	 * kyc_repo.save(kycEntity); String auditID = sequence.generateRequestUUId();
	 * String user1 = (String) req.getSession().getAttribute("USERID"); String
	 * username = (String) req.getSession().getAttribute("USERNAME");
	 * 
	 * KYC_Audit_Entity audit = new KYC_Audit_Entity(); Date currentDate = new
	 * Date(); audit.setAudit_date(currentDate); audit.setEntry_time(currentDate);
	 * audit.setEntry_user(user1); audit.setEntry_user_name(username);
	 * audit.setFunc_code("MODIFIED"); audit.setAudit_table("KYC_indidual");
	 * audit.setAudit_screen("MODIFY"); audit.setEvent_id(user1);
	 * audit.setEvent_name(username);
	 * audit.setModi_details("Modified Successfully"); StringBuilder changeDetails =
	 * new StringBuilder(); changes.forEach((field, value) ->
	 * changeDetails.append(field).append(": ").append(value).append("||| "));
	 * audit.setChange_details(changeDetails.toString());
	 * 
	 * audit.setReport_id(data.getCustomer_id()); audit.setAudit_ref_no(auditID);
	 * 
	 * KYC_Audit_Rep.save(audit);
	 * 
	 * return true; } else { return false; } }
	 */

	public Boolean verified(String Srl_no, HttpServletRequest req) {
		Optional<Ecdd_Individual_Profile_Entity> optionalKyc = ecddIndividualProfileRepository.findById(Srl_no);
		String userId = (String) session.getAttribute("USERID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		LocalDateTime currentDateTime = LocalDateTime.now();

		Optional<UserProfile> Userdetails = userProfileRep.findById(userId);
		if (optionalKyc.isPresent()) {

			Ecdd_Individual_Profile_Entity kycEntity = optionalKyc.get();

			String customerId = kycEntity.getCustomer_id();

			kycEntity.setApproved_by_name(Userdetails.get().getUsername());
			kycEntity.setApproved_by_ec_no(Userdetails.get().getEmpid());

			kycEntity.setModify_flg("N");
			kycEntity.setEntity_flg("Y");
			kycEntity.setVerify_user(userId);
			kycEntity.setVerify_time(Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant()));

			ecddIndividualProfileRepository.save(kycEntity);
			// Generate audit entry
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Create and populate audit entity
			KYC_Audit_Entity audit = new KYC_Audit_Entity();
			Date currentDate = new Date();
			audit.setAudit_date(currentDate);
			audit.setAuth_user(user1);
			audit.setAuth_time(currentDate);
			audit.setAuth_user_name(username);
			audit.setFunc_code("VERIFIED");
			audit.setAudit_table("KYC_indidual");
			audit.setAudit_screen("VERIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setModi_details("VERIFIED Successfully");
			audit.setAudit_ref_no(auditID);

			audit.setReport_id(customerId);

			// Save audit entity
			KYC_Audit_Rep.save(audit);
			return true;
		}
		return false;

	}

	public File GrtPdf(String Cust_Id) throws Exception {
		String path = env.getProperty("output.exportpath");
		String fileName = Cust_Id + ".pdf";
		File outputFile;

		try {
			// Build the output PDF path
			String fullPath = path + fileName;
			System.out.println("Generated file path: " + fullPath);

			// Load and compile the JRXML
			InputStream jasperFile = this.getClass().getResourceAsStream("/static/jasper/KYC_Individual.jrxml");
			if (jasperFile == null) {
				throw new FileNotFoundException("Jasper template not found at /static/jasper/KYC_Individual.jrxml");
			}

			JasperReport jr = JasperCompileManager.compileReport(jasperFile);

			// Prepare parameters
			HashMap<String, Object> map = new HashMap<>();
			map.put("Customer_ID", Cust_Id);

			// ✅ Correctly resolve the image directory as String
			File imageDir = new ClassPathResource("static/images/").getFile();
			String imageDirPath = imageDir.getAbsolutePath() + File.separator;
			map.put("IMAGE_DIR", imageDirPath);

			System.out.println("Resolved IMAGE_DIR path: " + imageDirPath);

			// Fill and export report
			JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
			JasperExportManager.exportReportToPdfFile(jp, fullPath);

			System.out.println("PDF generated successfully.");
			outputFile = new File(fullPath);

		} catch (Exception e) {
			System.err.println("Error generating PDF: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}

		return outputFile;
	}

	/*
	 * public boolean updateKycData(String srlno, Ecdd_Individual_Profile_Entity
	 * incomingData, HttpServletRequest req) { // Step 1: Find the existing record
	 * in the database.
	 * 
	 * // Generate audit entry String auditID = sequence.generateRequestUUId();
	 * String user1 = (String) req.getSession().getAttribute("USERID"); String
	 * username = (String) req.getSession().getAttribute("USERNAME");
	 * 
	 * Optional<Ecdd_Individual_Profile_Entity> optionalEntity =
	 * ecddIndividualProfileRepository.findById(srlno);
	 * 
	 * // This is the CORRECTED logic block if (optionalEntity.isPresent()) { // The
	 * record to be updated exists. Let's proceed.
	 * 
	 * // Get session attributes and current time for metadata. String userId =
	 * (String) req.getSession().getAttribute("USERID"); LocalDateTime
	 * currentDateTime = LocalDateTime.now(); Date modifyDate =
	 * Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant());
	 * 
	 * // Get the actual entity object from the database that we will modify.
	 * Ecdd_Individual_Profile_Entity existingEntity = optionalEntity.get();
	 * 
	 * Set<String> skipFields = new HashSet<>(Arrays.asList("CustomerId",
	 * "EntityFlg", "ModifyFlg", "DelFlg", "ModifyUser", "VerifyUser", "ModifyTime",
	 * "VerifyTime"));
	 * 
	 * Map<String, String> changes = new LinkedHashMap<>();
	 * 
	 * // --- General Account Information ---
	 * existingEntity.setAccount_title(incomingData.getAccount_title());
	 * existingEntity.setEcdd_date(incomingData.getEcdd_date());
	 * existingEntity.setCustomer_id(incomingData.getCustomer_id());
	 * existingEntity.setAssociated_accounts(incomingData.getAssociated_accounts());
	 * existingEntity.setCurrency(incomingData.getCurrency());
	 * existingEntity.setAccount_open_date(incomingData.getAccount_open_date());
	 * existingEntity.setCurrency_approval_yn(incomingData.getCurrency_approval_yn()
	 * );
	 * 
	 * // --- Primary Account Holder ---
	 * existingEntity.setPrimary_holder_name(incomingData.getPrimary_holder_name());
	 * existingEntity.setPrimary_customer_id(incomingData.getPrimary_customer_id());
	 * existingEntity.setPrimary_non_resident_yn(incomingData.
	 * getPrimary_non_resident_yn());
	 * existingEntity.setPrimary_nationality(incomingData.getPrimary_nationality());
	 * existingEntity.setPrimary_mobile_no(incomingData.getPrimary_mobile_no());
	 * existingEntity.setPrimary_email(incomingData.getPrimary_email());
	 * existingEntity.setPrimary_address(incomingData.getPrimary_address());
	 * existingEntity.setPrimary_passport_no(incomingData.getPrimary_passport_no());
	 * existingEntity.setPrimary_passport_exp_date(incomingData.
	 * getPrimary_passport_exp_date());
	 * existingEntity.setPrimary_emirates_id_no(incomingData.
	 * getPrimary_emirates_id_no());
	 * existingEntity.setPrimary_emirates_exp_date(incomingData.
	 * getPrimary_emirates_exp_date());
	 * existingEntity.setPrimary_pep_yn(incomingData.getPrimary_pep_yn());
	 * existingEntity.setPrimary_pep_approval(incomingData.getPrimary_pep_approval()
	 * );
	 * 
	 * // --- Joint Holder 1 ---
	 * existingEntity.setJoint1_name(incomingData.getJoint1_name());
	 * existingEntity.setJoint1_customer_id(incomingData.getJoint1_customer_id());
	 * existingEntity.setJoint1_non_resident_yn(incomingData.
	 * getJoint1_non_resident_yn());
	 * existingEntity.setJoint1_nationality(incomingData.getJoint1_nationality());
	 * existingEntity.setJoint1_mobile_no(incomingData.getJoint1_mobile_no());
	 * existingEntity.setJoint1_email(incomingData.getJoint1_email());
	 * existingEntity.setJoint1_address(incomingData.getJoint1_address());
	 * existingEntity.setJoint1_passport_no(incomingData.getJoint1_passport_no());
	 * existingEntity.setJoint1_passport_exp_date(incomingData.
	 * getJoint1_passport_exp_date());
	 * existingEntity.setJoint1_emirates_id_no(incomingData.getJoint1_emirates_id_no
	 * ()); existingEntity.setJoint1_emirates_exp_date(incomingData.
	 * getJoint1_emirates_exp_date());
	 * existingEntity.setJoint1_pep_yn(incomingData.getJoint1_pep_yn());
	 * existingEntity.setJoint1_pep_approval(incomingData.getJoint1_pep_approval());
	 * 
	 * // --- Joint Holder 2 ---
	 * existingEntity.setJoint2_name(incomingData.getJoint2_name());
	 * existingEntity.setJoint2_customer_id(incomingData.getJoint2_customer_id());
	 * existingEntity.setJoint2_non_resident_yn(incomingData.
	 * getJoint2_non_resident_yn());
	 * existingEntity.setJoint2_nationality(incomingData.getJoint2_nationality());
	 * existingEntity.setJoint2_mobile_no(incomingData.getJoint2_mobile_no());
	 * existingEntity.setJoint2_email(incomingData.getJoint2_email());
	 * existingEntity.setJoint2_address(incomingData.getJoint2_address());
	 * existingEntity.setJoint2_passport_no(incomingData.getJoint2_passport_no());
	 * existingEntity.setJoint2_passport_exp_date(incomingData.
	 * getJoint2_passport_exp_date());
	 * existingEntity.setJoint2_emirates_id_no(incomingData.getJoint2_emirates_id_no
	 * ()); existingEntity.setJoint2_emirates_exp_date(incomingData.
	 * getJoint2_emirates_exp_date());
	 * existingEntity.setJoint2_pep_yn(incomingData.getJoint2_pep_yn());
	 * existingEntity.setJoint2_pep_approval(incomingData.getJoint2_pep_approval());
	 * 
	 * // --- Joint Holder 3 ---
	 * existingEntity.setJoint3_name(incomingData.getJoint3_name());
	 * existingEntity.setJoint3_customer_id(incomingData.getJoint3_customer_id());
	 * existingEntity.setJoint3_non_resident_yn(incomingData.
	 * getJoint3_non_resident_yn());
	 * existingEntity.setJoint3_nationality(incomingData.getJoint3_nationality());
	 * existingEntity.setJoint3_mobile_no(incomingData.getJoint3_mobile_no());
	 * existingEntity.setJoint3_email(incomingData.getJoint3_email());
	 * existingEntity.setJoint3_address(incomingData.getJoint3_address());
	 * existingEntity.setJoint3_passport_no(incomingData.getJoint3_passport_no());
	 * existingEntity.setJoint3_passport_exp_date(incomingData.
	 * getJoint3_passport_exp_date());
	 * existingEntity.setJoint3_emirates_id_no(incomingData.getJoint3_emirates_id_no
	 * ()); existingEntity.setJoint3_emirates_exp_date(incomingData.
	 * getJoint3_emirates_exp_date());
	 * existingEntity.setJoint3_pep_yn(incomingData.getJoint3_pep_yn());
	 * existingEntity.setJoint3_pep_approval(incomingData.getJoint3_pep_approval());
	 * 
	 * // --- Risk, KYC, and Screening for all holders ---
	 * existingEntity.setKyc_valid_yn_primary(incomingData.getKyc_valid_yn_primary()
	 * );
	 * existingEntity.setAnnual_income_primary(incomingData.getAnnual_income_primary
	 * ()); existingEntity.setSource_of_income_primary(incomingData.
	 * getSource_of_income_primary());
	 * existingEntity.setScreen_google_primary(incomingData.getScreen_google_primary
	 * ()); existingEntity.setScreen_dowjones_primary(incomingData.
	 * getScreen_dowjones_primary());
	 * existingEntity.setKyc_valid_yn_joint1(incomingData.getKyc_valid_yn_joint1());
	 * existingEntity.setAnnual_income_joint1(incomingData.getAnnual_income_joint1()
	 * ); existingEntity.setSource_of_income_joint1(incomingData.
	 * getSource_of_income_joint1());
	 * existingEntity.setScreen_google_joint1(incomingData.getScreen_google_joint1()
	 * ); existingEntity.setScreen_dowjones_joint1(incomingData.
	 * getScreen_dowjones_joint1());
	 * existingEntity.setKyc_valid_yn_joint2(incomingData.getKyc_valid_yn_joint2());
	 * existingEntity.setAnnual_income_joint2(incomingData.getAnnual_income_joint2()
	 * ); existingEntity.setSource_of_income_joint2(incomingData.
	 * getSource_of_income_joint2());
	 * existingEntity.setScreen_google_joint2(incomingData.getScreen_google_joint2()
	 * ); existingEntity.setScreen_dowjones_joint2(incomingData.
	 * getScreen_dowjones_joint2());
	 * existingEntity.setKyc_valid_yn_joint3(incomingData.getKyc_valid_yn_joint3());
	 * existingEntity.setAnnual_income_joint3(incomingData.getAnnual_income_joint3()
	 * ); existingEntity.setSource_of_income_joint3(incomingData.
	 * getSource_of_income_joint3());
	 * existingEntity.setScreen_google_joint3(incomingData.getScreen_google_joint3()
	 * ); existingEntity.setScreen_dowjones_joint3(incomingData.
	 * getScreen_dowjones_joint3());
	 * 
	 * // --- Due Diligence & Transaction Monitoring ---
	 * existingEntity.setBranch_remarks(incomingData.getBranch_remarks());
	 * existingEntity.setUnusual_txn_details(incomingData.getUnusual_txn_details());
	 * existingEntity.setSuspicious_activity(incomingData.getSuspicious_activity());
	 * existingEntity.setHigh_value_txn_count(incomingData.getHigh_value_txn_count()
	 * );
	 * existingEntity.setHigh_value_txn_volume(incomingData.getHigh_value_txn_volume
	 * ());
	 * existingEntity.setFrequency_txn_percent(incomingData.getFrequency_txn_percent
	 * ()); existingEntity.setVolume_turnover_percent(incomingData.
	 * getVolume_turnover_percent());
	 * existingEntity.setCash_txn_count(incomingData.getCash_txn_count());
	 * existingEntity.setCash_txn_volume(incomingData.getCash_txn_volume());
	 * existingEntity.setCheque_txn_count(incomingData.getCheque_txn_count());
	 * existingEntity.setCheque_txn_volume(incomingData.getCheque_txn_volume());
	 * existingEntity.setLocal_txn_count(incomingData.getLocal_txn_count());
	 * existingEntity.setLocal_txn_volume(incomingData.getLocal_txn_volume());
	 * existingEntity.setIntl_txn_count(incomingData.getIntl_txn_count());
	 * existingEntity.setIntl_txn_volume(incomingData.getIntl_txn_volume());
	 * existingEntity.setCurr_txn_count(incomingData.getCurr_txn_count());
	 * existingEntity.setCurr_txn_volume(incomingData.getCurr_txn_volume());
	 * existingEntity.setExpected_txn_count(incomingData.getExpected_txn_count());
	 * existingEntity.setExpected_txn_volume(incomingData.getExpected_txn_volume());
	 * existingEntity.setProfile_match_yn(incomingData.getProfile_match_yn());
	 * existingEntity.setProfile_mismatch_remarks(incomingData.
	 * getProfile_mismatch_remarks());
	 * 
	 * // --- Risk Categorization ---
	 * existingEntity.setSystem_risk(incomingData.getSystem_risk());
	 * existingEntity.setCustomer_risk_reason(incomingData.getCustomer_risk_reason()
	 * );
	 * 
	 * // --- Document Availability in DMS ---
	 * existingEntity.setAof_available_yn(incomingData.getAof_available_yn());
	 * existingEntity.setAof_remarks(incomingData.getAof_remarks());
	 * existingEntity.setKyc_doc_available_yn(incomingData.getKyc_doc_available_yn()
	 * ); existingEntity.setKyc_doc_remarks(incomingData.getKyc_doc_remarks());
	 * existingEntity.setSource_of_funds_available_yn(incomingData.
	 * getSource_of_funds_available_yn());
	 * existingEntity.setSource_of_funds_remarks(incomingData.
	 * getSource_of_funds_remarks());
	 * 
	 * // --- Observations & Review ---
	 * 
	 * Optional<UserProfile> Userdetails = userProfileRep.findById(userId);
	 * 
	 * existingEntity.setBranch_observations(incomingData.getBranch_observations());
	 * existingEntity.setReview_date(incomingData.getReview_date());
	 * existingEntity.setBranch_name(incomingData.getBranch_name());
	 * System.out.println(Userdetails.get().getUsername());
	 * System.out.println(Userdetails.get().getEmail_id());
	 * existingEntity.setReviewed_by_name(Userdetails.get().getUsername());
	 * existingEntity.setReviewed_by_ec_no(Userdetails.get().getEmpid());
	 * existingEntity.setReviewed_by_designation(incomingData.
	 * getReviewed_by_designation());
	 * existingEntity.setApproval_date(incomingData.getApproval_date());
	 * existingEntity.setApproved_by_name(incomingData.getApproved_by_name());
	 * existingEntity.setApproved_by_ec_no(incomingData.getApproved_by_ec_no());
	 * existingEntity.setApproved_by_designation(incomingData.
	 * getApproved_by_designation());
	 * 
	 * // --- Finacle & DMS Data Entry ---
	 * existingEntity.setEntry_date(incomingData.getEntry_date());
	 * existingEntity.setEntered_by(incomingData.getEntered_by());
	 * existingEntity.setDoc_uploaded_date(incomingData.getDoc_uploaded_date());
	 * existingEntity.setDoc_uploaded_by(incomingData.getDoc_uploaded_by());
	 * existingEntity.setReport_date(incomingData.getReport_date());
	 * existingEntity.setSrlno(incomingData.getSrlno());
	 * 
	 * // Metadata / system fields existingEntity.setModify_flg("Y");
	 * existingEntity.setEntity_flg("N"); existingEntity.setModify_user(userId);
	 * existingEntity.setModify_time(Date.from(currentDateTime.atZone(ZoneId.
	 * systemDefault()).toInstant())); existingEntity.setAuth_flg("N");
	 * 
	 * ecddIndividualProfileRepository.save(existingEntity);
	 * 
	 * // Create and populate audit entity KYC_Audit_Entity audit = new
	 * KYC_Audit_Entity(); Date currentDate = new Date();
	 * audit.setAudit_date(currentDate); audit.setEntry_time(currentDate);
	 * audit.setEntry_user(user1); audit.setEntry_user_name(username);
	 * audit.setFunc_code("Modified"); audit.setAudit_table("Kyc_Individual");
	 * audit.setAudit_screen("Modify"); audit.setEvent_id(user1);
	 * audit.setEvent_name(username);
	 * audit.setModi_details("Modified Successfully");
	 * 
	 * // Append field changes to the audit details StringBuilder changeDetails =
	 * new StringBuilder(); // changes.forEach((field, value) ->
	 * changeDetails.append(field).append(": // ").append(value).append("||| "));
	 * audit.setChange_details(changeDetails.toString()); // New field in the audit
	 * table for storing changes
	 * 
	 * audit.setAudit_ref_no(auditID);
	 * 
	 * // Save audit entity KYC_Audit_Rep.save(audit); return true; } else {
	 * 
	 * return false; } }
	 * 
	 * public String uploadrelateddocs(MultipartFile Securityfile,String Userid) {
	 * return Userid;
	 * 
	 * }
	 */

	// ... your autowired repositories (ecddIndividualProfileRepository,
	// userProfileRep, KYC_Audit_Rep)
	// ... and sequence generator

	@Transactional
	public boolean updateKycData(String srlno, Ecdd_Individual_Profile_Entity incomingData, HttpServletRequest req) {

		// Step 1: Find the existing record to update.
		Optional<Ecdd_Individual_Profile_Entity> optionalEntity = ecddIndividualProfileRepository.findById(srlno);
		if (!optionalEntity.isPresent()) {
			System.err.println("UPDATE FAILED: No record found for srlno: " + srlno);
			return false;
		}
		Ecdd_Individual_Profile_Entity existingEntity = optionalEntity.get();

		// =================================================================================
		// STEP 2: CAPTURE DETAILED FIELD-LEVEL CHANGES FOR AUDITING
		// =================================================================================
		final Map<String, String> changes = new LinkedHashMap<>();
		final BeanWrapper src = new BeanWrapperImpl(incomingData);
		final BeanWrapper dest = new BeanWrapperImpl(existingEntity);

		// Create a map of the property names that were submitted in this specific AJAX
		// request.
		Set<String> submittedPropertyNames = new HashSet<>();
		for (PropertyDescriptor pd : src.getPropertyDescriptors()) {
			if (src.isReadableProperty(pd.getName()) && src.getPropertyValue(pd.getName()) != null) {
				submittedPropertyNames.add(pd.getName());
			}
		}

		// Now, only check for changes on the fields that were part of this save action.
		for (String propertyName : submittedPropertyNames) {
			Object newValue = src.getPropertyValue(propertyName);
			Object oldValue = dest.getPropertyValue(propertyName);
			if (!Objects.equals(oldValue, newValue)) {
				changes.put(propertyName,
						String.format("'%s' -> '%s'", String.valueOf(oldValue), String.valueOf(newValue)));
			}
		}

		// =================================================================================
		// STEP 3: PERFORM THE PARTIAL UPDATE LOGIC
		// =================================================================================

		// This single line copies all properties that were not null in the incoming
		// data.
		// It correctly handles both updating fields and setting them to null if an
		// empty string was sent.
		BeanUtils.copyProperties(incomingData, existingEntity, getNullPropertyNames(incomingData));

		// =================================================================================
		// STEP 4: HANDLE SPECIAL CASES & SET METADATA
		// =================================================================================
		String userId = (String) req.getSession().getAttribute("USERID");
		
		// Special logic for reviewer details (this is correct)
		if (incomingData.getReviewed_by_designation() != null) {
			userProfileRep.findById(userId).ifPresent(userProfile -> {
				existingEntity.setReviewed_by_name(userProfile.getUsername());
				existingEntity.setReviewed_by_ec_no(userProfile.getEmpid());
			});
		}
		incomingData.setAuth_flg(incomingData.getAuth_flg()==null ? "N" : incomingData.getAuth_flg());
		if(incomingData.getAuth_flg().equals("Y")) {
		System.out.println(incomingData.getAuth_flg());
		// Set mandatory metadata
		
		existingEntity.setEntity_flg("N"); // Assuming this should be set on modification
		existingEntity.setAuth_flg("Y");
		existingEntity.setModify_flg("Y");
		existingEntity.setModify_user(userId);
		existingEntity.setModify_time(new Date());
		}else {
		existingEntity.setAuth_flg("N");
		}
		// =================================================================================
		// STEP 5: SAVE THE UPDATED ENTITY
		// =================================================================================
		ecddIndividualProfileRepository.save(existingEntity);

		// =================================================================================
		// STEP 6: CREATE AND SAVE THE DETAILED AUDIT LOG
		// =================================================================================
		// This logic is excellent and doesn't need to change.
		String userName = (String) req.getSession().getAttribute("USERNAME");
		KYC_Audit_Entity audit = new KYC_Audit_Entity();
		Date currentDate = new Date();
		audit.setAudit_ref_no(sequence.generateRequestUUId());
		audit.setAudit_date(currentDate);
		audit.setEntry_time(currentDate);
		audit.setEntry_user(userId);
		audit.setEntry_user_name(userName);
		audit.setFunc_code("Modified");
		audit.setAudit_table("Kyc_Individual");
		audit.setAudit_screen("Modify");
		audit.setModi_details("Successfully modified section for record SRL No: " + srlno);

		if (changes.isEmpty()) {
			audit.setChange_details("No data fields were changed (metadata update only).");
		} else {
			String changeDetailsString = changes.entrySet().stream()
					.map(entry -> entry.getKey() + ": " + entry.getValue()).collect(Collectors.joining(" ||| "));
			audit.setChange_details(changeDetailsString);
		}

		KYC_Audit_Rep.save(audit);

		return true;
	}

	/**
	 * Helper method to get the names of all properties that are null in the source
	 * object. This is used by BeanUtils.copyProperties to avoid overwriting
	 * existing data with nulls.
	 */
	private String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		PropertyDescriptor[] pds = src.getPropertyDescriptors();

		Set<String> emptyNames = new HashSet<>();
		for (PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		return emptyNames.toArray(new String[0]);
	}
}
