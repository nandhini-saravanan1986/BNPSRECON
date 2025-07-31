package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.EcddCorporateEntity;
import com.bornfire.xbrl.entities.KYC_Audit_Entity;
import com.bornfire.xbrl.entities.KYC_Audit_Rep;
import com.bornfire.xbrl.entities.Kyc_Corprate_Repo;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import net.sf.jasperreports.engine.JRException;

@Service
@Transactional
public class Kyc_Corprate_service {

	private static final Logger logger = LoggerFactory.getLogger(Kyc_Corprate_service.class);

	@Autowired
	Environment env;
	@Autowired
	DataSource srcdataSource;
	@Autowired
	SequenceGenerator sequence;
	@Autowired
	private Kyc_Corprate_Repo Kyc_Corprate_Repo;
	@Autowired
	private HttpSession session;
	@Autowired
	UserProfileRep userProfileRep;

	@Autowired
	KYC_Audit_Rep KYC_Audit_Rep;

	public boolean updateKycData(String srl_no, EcddCorporateEntity data, HttpServletRequest req) {
		// Find the existing KYC record

		Optional<EcddCorporateEntity> optionalKyc = Kyc_Corprate_Repo.findById(srl_no);
		String userId = (String) session.getAttribute("USERID");
		String BRANCHCODE = (String) session.getAttribute("BRANCHCODE");
		LocalDateTime currentDateTime = LocalDateTime.now();

		if (optionalKyc.isPresent()) {

			EcddCorporateEntity kycEntity = optionalKyc.get();

			Set<String> skipFields = new HashSet<>(Arrays.asList("CustomerId", "EntityFlg", "ModifyFlg", "DelFlg",
					"ModifyUser", "VerifyUser", "ModifyTime", "VerifyTime"));

			Map<String, String> changes = new LinkedHashMap<>();

			kycEntity.setCompany_name(data.getCompany_name());
			kycEntity.setCustomer_id(data.getCustomer_id());
			kycEntity.setCompany_address(data.getCompany_address());
			kycEntity.setAssociated_account_number(data.getAssociated_account_number());
			kycEntity.setEcdd_date(data.getEcdd_date());
			kycEntity.setTrade_license_number(data.getTrade_license_number());
			kycEntity.setTrade_legal_status(data.getTrade_legal_status());
			kycEntity.setTrade_expiry_date(data.getTrade_expiry_date());
			kycEntity.setTriggered_event(data.getTriggered_event());
			kycEntity.setNo_change_reason(data.getNo_change_reason());
			kycEntity.setGeographic_risk_profile(data.getGeographic_risk_profile());
			kycEntity.setBusiness_activity_products(data.getBusiness_activity_products());
			kycEntity.setTrade_license_validity(data.getTrade_license_validity());
			kycEntity.setUbo_signatories_kyc_validity(data.getUbo_signatories_kyc_validity());
			kycEntity.setTrade_license_remarks(data.getTrade_license_remarks());
			kycEntity.setUbo_signatories_kyc_remarks(data.getUbo_signatories_kyc_remarks());
			kycEntity.setPep_status(data.getPep_status());
			kycEntity.setPep_remarks(data.getPep_remarks());
			kycEntity.setCounterparty_name_1(data.getCounterparty_name_1());
			kycEntity.setCounterparty_import_export_1(data.getCounterparty_import_export_1());
			kycEntity.setCounterparty_country_1(data.getCounterparty_country_1());
			kycEntity.setCounterparty_activity_products_1(data.getCounterparty_activity_products_1());
			kycEntity.setCounterparty_name_2(data.getCounterparty_name_2());
			kycEntity.setCounterparty_import_export_2(data.getCounterparty_import_export_2());
			kycEntity.setCounterparty_country_2(data.getCounterparty_country_2());
			kycEntity.setCounterparty_activity_products_2(data.getCounterparty_activity_products_2());
			kycEntity.setCounterparty_name_3(data.getCounterparty_name_3());
			kycEntity.setCounterparty_import_export_3(data.getCounterparty_import_export_3());
			kycEntity.setCounterparty_country_3(data.getCounterparty_country_3());
			kycEntity.setCounterparty_activity_products_3(data.getCounterparty_activity_products_3());
			kycEntity.setCounterparty_name_4(data.getCounterparty_name_4());
			kycEntity.setCounterparty_import_export_4(data.getCounterparty_import_export_4());
			kycEntity.setCounterparty_country_4(data.getCounterparty_country_4());
			kycEntity.setCounterparty_activity_products_4(data.getCounterparty_activity_products_4());
			kycEntity.setCounterparty_name_5(data.getCounterparty_name_5());
			kycEntity.setCounterparty_import_export_5(data.getCounterparty_import_export_5());
			kycEntity.setCounterparty_country_5(data.getCounterparty_country_5());
			kycEntity.setCounterparty_activity_products_5(data.getCounterparty_activity_products_5());
			kycEntity.setCorporate_cbuae_bbl(data.getCorporate_cbuae_bbl());
			kycEntity.setCorporate_google_screening(data.getCorporate_google_screening());
			kycEntity.setCorporate_dow_jones_screening(data.getCorporate_dow_jones_screening());
			kycEntity.setCorporate_internal_deny_list(data.getCorporate_internal_deny_list());
			kycEntity.setCorporate_screening_remarks(data.getCorporate_screening_remarks());
			kycEntity.setUbo_cbuae_bbl(data.getUbo_cbuae_bbl());
			kycEntity.setUbo_google_screening(data.getUbo_google_screening());
			kycEntity.setUbo_dow_jones_screening(data.getUbo_dow_jones_screening());
			kycEntity.setUbo_internal_deny_list(data.getUbo_internal_deny_list());
			kycEntity.setUbo_screening_remarks(data.getUbo_screening_remarks());
			kycEntity.setCounterparty_cbuae_bbl(data.getCounterparty_cbuae_bbl());
			kycEntity.setCounterparty_google_screening(data.getCounterparty_google_screening());
			kycEntity.setCounterparty_dow_jones_screening(data.getCounterparty_dow_jones_screening());
			kycEntity.setCounterparty_internal_deny_list(data.getCounterparty_internal_deny_list());
			kycEntity.setCounterparty_screening_remarks(data.getCounterparty_screening_remarks());
			kycEntity.setTransaction_history(data.getTransaction_history());
			kycEntity.setHigh_value_transaction_count(data.getHigh_value_transaction_count());
			kycEntity.setHigh_value_transaction_volume(data.getHigh_value_transaction_volume());
			kycEntity.setAccount_conduct(data.getAccount_conduct());
			kycEntity.setCash_transaction_percent(data.getCash_transaction_percent());
			kycEntity.setCheque_transaction_percent(data.getCheque_transaction_percent());
			kycEntity.setLocal_transfer_percent(data.getLocal_transfer_percent());
			kycEntity.setIntl_transfer_percent(data.getIntl_transfer_percent());
			kycEntity.setCurrent_transaction_count(data.getCurrent_transaction_count());
			kycEntity.setExpected_transaction_count(data.getExpected_transaction_count());
			kycEntity.setCash_volume_percent(data.getCash_volume_percent());
			kycEntity.setCheque_volume_percent(data.getCheque_volume_percent());
			kycEntity.setLocal_transfer_volume_percent(data.getLocal_transfer_volume_percent());
			kycEntity.setIntl_transfer_volume_percent(data.getIntl_transfer_volume_percent());
			kycEntity.setCurrent_volume_count(data.getCurrent_volume_count());
			kycEntity.setExpected_volume_count(data.getExpected_volume_count());
			kycEntity.setTransactions_match_profile(data.getTransactions_match_profile());
			kycEntity.setSystem_risk(data.getSystem_risk());
			kycEntity.setLatest_risk(data.getLatest_risk());
			kycEntity.setRisk_reason(data.getRisk_reason());
			kycEntity.setAof_available(data.getAof_available());
			kycEntity.setAof_remarks(data.getAof_remarks());
			kycEntity.setFatca_crs_available(data.getFatca_crs_available());
			kycEntity.setFatca_crs_remarks(data.getFatca_crs_remarks());
			kycEntity.setSource_of_funds_available(data.getSource_of_funds_available());
			kycEntity.setSource_of_funds_remarks(data.getSource_of_funds_remarks());
			kycEntity.setObservations(data.getObservations());
			kycEntity.setReview_date(data.getReview_date());
			kycEntity.setApproval_date(data.getApproval_date());

			Optional<UserProfile> Userdetails = userProfileRep.findById(userId);
			System.out.println(Userdetails.get().getUsername());
			System.out.println(Userdetails.get().getEmail_id());
			kycEntity.setReviewed_by_name(Userdetails.get().getUsername());
			kycEntity.setReviewed_by_ec_no(Userdetails.get().getEmpid());
			kycEntity.setReviewed_by_designation(data.getReviewed_by_designation());
			/*
			 * kycEntity.setApproved_by_name(data.getApproved_by_name());
			 * kycEntity.setApproved_by_ec_no(data.getApproved_by_ec_no());
			 */
			kycEntity.setApproved_by_designation(data.getApproved_by_designation());
			kycEntity.setBranch_name(data.getBranch_name());
			kycEntity.setBranch_code(BRANCHCODE);
			kycEntity.setData_entry_date(data.getData_entry_date());
			kycEntity.setData_entry_employee_name(data.getData_entry_employee_name());
			kycEntity.setDocument_uploaded_date(data.getDocument_uploaded_date());
			kycEntity.setDocument_uploaded_employee_name(data.getDocument_uploaded_employee_name());
			kycEntity.setCurrent_date(data.getCurrent_date());
			kycEntity.setReport_date(data.getReport_date());
			kycEntity.setSrl_no(data.getSrl_no());
			
			data.setAuth_flg(data.getAuth_flg() == null ? "N":data.getAuth_flg());
			
			if(data.getAuth_flg().equals("Y")) {

			// Metadata / system fields
			kycEntity.setModify_flg("Y");
			kycEntity.setEntity_flg("N");
			kycEntity.setModify_user(userId);
			kycEntity.setModify_time(Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant()));
			kycEntity.setAuth_flg("Y");
			}
			Kyc_Corprate_Repo.save(kycEntity);
			// Generate audit entry
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Create and populate audit entity
			KYC_Audit_Entity audit = new KYC_Audit_Entity();
			Date currentDate = new Date();
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(user1);
			audit.setEntry_user_name(username);
			audit.setFunc_code("Modified");
			audit.setAudit_table("Kyc_corporate");
			audit.setAudit_screen("Modify");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setModi_details("Modified Successfully");

			// Append field changes to the audit details
			StringBuilder changeDetails = new StringBuilder();
			// changes.forEach((field, value) -> changeDetails.append(field).append(":
			// ").append(value).append("||| "));
			audit.setChange_details(changeDetails.toString()); // New field in the audit table for storing changes

			audit.setAudit_ref_no(auditID);

			// Save audit entity
			KYC_Audit_Rep.save(audit);
			return true;
		} else {

			return false;
		}
	}

	public Boolean verified(String customerId, HttpServletRequest req) {

		Optional<EcddCorporateEntity> optionalKyc = Kyc_Corprate_Repo.findById(customerId);
		String userId = (String) session.getAttribute("USERID");
		LocalDateTime currentDateTime = LocalDateTime.now();

		Optional<UserProfile> Userdetails = userProfileRep.findById(userId);

		if (optionalKyc.isPresent()) {

			EcddCorporateEntity kycEntity = optionalKyc.get();
			kycEntity.setApproved_by_name(Userdetails.get().getUsername());
			kycEntity.setApproved_by_ec_no(Userdetails.get().getEmpid());
			kycEntity.setModify_flg("N");
			kycEntity.setEntity_flg("Y");
			kycEntity.setVerify_user(userId);
			kycEntity.setVerify_time(Date.from(currentDateTime.atZone(ZoneId.systemDefault()).toInstant()));

			Kyc_Corprate_Repo.save(kycEntity);
			// Generate audit entry
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Create and populate audit entity
			KYC_Audit_Entity audit = new KYC_Audit_Entity();
			Date currentDate = new Date();
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(user1);
			audit.setEntry_user_name(username);
			audit.setFunc_code("VERIFIED");
			audit.setAudit_table("Kyc_corporate");
			audit.setAudit_screen("VERIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setModi_details("VERIFIED Successfully");
			audit.setAuth_user(user1);
			audit.setAuth_time(currentDate);
			audit.setAuth_user_name(username);

			audit.setAudit_ref_no(auditID);
			audit.setReport_id(customerId);
			// Save audit entity
			KYC_Audit_Rep.save(audit);
			return true;
		}
		return false;

	}

	public File GrtPdf(String srl_no, HttpServletRequest req) throws FileNotFoundException, JRException, SQLException {
		Optional<EcddCorporateEntity> optionalKyc = Kyc_Corprate_Repo.findById(srl_no);

		String Filename = Kyc_Corprate_Repo.findById(srl_no).map(EcddCorporateEntity::getCustomer_id)
				.orElse("ECDD_FORM");
		String filepath = env.getProperty("output.exportpathfinal");
		File outputFile = new File(filepath + "KYC-CORP" + Filename + ".pdf");
		try {

			if (optionalKyc.isPresent()) {

				logger.info("Start Downloading Document");
				EcddCorporateEntity EcddCorporateEntity = optionalKyc.get();

				Document document = new Document(PageSize.A4); // create pdf file in the A4 sheet format

				/// Base color is used for headers
				BaseColor antiqueWhite = new BaseColor(250, 235, 215);

				PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile)); // set the file
																										// path export
				document.open(); // open pdf file to write
				// Fonts
				Font HeaderandTag = FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.BOLD);
				Font Normalheader = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.BOLD);
				Font Responsesize = FontFactory.getFont(FontFactory.TIMES_ROMAN, 8);

				/// Manually aqdd the space
				Paragraph Manualspace = new Paragraph("                                             ");
				Manualspace.setAlignment(Element.ALIGN_LEFT);
				Manualspace.setSpacingAfter(0.5f);

				/*
				 * /// add water mark
				 * 
				 * Image img =
				 * Image.getInstance("src/main/resources/static/images/client_Logo_bkp.png");
				 * img.scaleAbsolute(150, 150);
				 * 
				 * PdfContentByte canvas = writer.getDirectContentUnder(); PdfGState gs1 = new
				 * PdfGState(); gs1.setFillOpacity(0.2f); canvas.saveState();
				 * canvas.setGState(gs1);
				 * 
				 * float centerX = (document.getPageSize().getWidth() - img.getScaledWidth()) /
				 * 2; float centerY = (document.getPageSize().getHeight() -
				 * img.getScaledHeight()) / 2; img.setAbsolutePosition(centerX, centerY);
				 * 
				 * canvas.addImage(img); canvas.restoreState();
				 */

				logger.info("Entering Stage 1");

				// First title
				Paragraph Duediligence = new Paragraph("Periodic ECDD-Due Diligence Form", Normalheader);
				Duediligence.setAlignment(Element.ALIGN_LEFT);
				Duediligence.setSpacingAfter(1f);
				document.add(Duediligence);

				// Second Title
				Paragraph Non_Individual = new Paragraph("(Non-Individual customers)", Normalheader);
				Non_Individual.setAlignment(Element.ALIGN_LEFT);
				Non_Individual.setSpacingAfter(5f);
				document.add(Non_Individual);

				/////// From Here onwards start creating the table for the form
				PdfPTable customerdetailheader = new PdfPTable(4);
				customerdetailheader.setWidthPercentage(100); /// set the width for the table 100
				customerdetailheader.setWidths(new float[] { 1, 3, 1, 1 }); /// Seperate the Columns for this table

				PdfPCell cell1 = new PdfPCell(new Phrase("Company Name ", Normalheader));
				cell1.setFixedHeight(16f); // Row height
				cell1.setVerticalAlignment(Element.ALIGN_LEFT);
				cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell1.setBorderWidth((float) 0.8);
				customerdetailheader.addCell(cell1);

				PdfPCell cell2 = new PdfPCell(new Phrase(
						EcddCorporateEntity.getCompany_name() != null ? EcddCorporateEntity.getCompany_name() : "",
						Responsesize));

				cell2.setMinimumHeight(16f); // Row height
				cell2.setVerticalAlignment(Element.ALIGN_LEFT);
				cell2.setVerticalAlignment(Element.ALIGN_TOP);
				cell2.setBorderWidth((float) 0.8);
				customerdetailheader.addCell(cell2);

				PdfPCell cell3 = new PdfPCell(new Phrase("ECDD Date", Normalheader));
				cell3.setFixedHeight(16f); // Row height
				cell3.setVerticalAlignment(Element.ALIGN_LEFT);
				cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell3.setBorderWidth((float) 0.8);
				customerdetailheader.addCell(cell3);

				PdfPCell cell4 = new PdfPCell(new Phrase(EcddCorporateEntity.getEcdd_date() != null
						? new SimpleDateFormat("dd/MM/yyyy").format(EcddCorporateEntity.getEcdd_date())
						: "", Responsesize)); 
				cell4.setMinimumHeight(16f); 
				cell4.setVerticalAlignment(Element.ALIGN_LEFT);
				cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell4.setBorderWidth((float) 0.8);
				customerdetailheader.addCell(cell4);

				document.add(customerdetailheader);

				///////////// 2nd Row

				/////// From Here onwards start creating the table for the form
				PdfPTable customerdetailheader1 = new PdfPTable(4);
				customerdetailheader1.setWidthPercentage(100); /// set the width for the table 100
				customerdetailheader1.setWidths(new float[] { 1, 1, 2, 2 }); /// Seperate the Columns for this table

				PdfPCell headercell1 = new PdfPCell(new Phrase("Customer ID", Normalheader));
				headercell1.setFixedHeight(16f); // Row height
				headercell1.setVerticalAlignment(Element.ALIGN_LEFT);
				headercell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				headercell1.setBorderWidth((float) 0.8);
				customerdetailheader1.addCell(headercell1);

				PdfPCell headercell2 = new PdfPCell(new Phrase(EcddCorporateEntity.getCustomer_id(), Responsesize)); /// put
																														/// the
																														/// company
																														/// name
																														/// here
				headercell2.setMinimumHeight(16f); // Row height
				headercell2.setVerticalAlignment(Element.ALIGN_LEFT);
				headercell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				headercell2.setBorderWidth((float) 0.8);
				customerdetailheader1.addCell(headercell2);

				PdfPCell headercell3 = new PdfPCell(new Phrase("Associated Account Number(s)", Normalheader));
				headercell3.setMinimumHeight(16f); // Row height
				headercell3.setVerticalAlignment(Element.ALIGN_LEFT);
				headercell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				headercell3.setBorderWidth((float) 0.8);
				customerdetailheader1.addCell(headercell3);

				PdfPCell headercell4 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getAssociated_account_number(), Responsesize)); // put the date
																										// here
				headercell4.setMinimumHeight(16f); // Row height
				headercell4.setVerticalAlignment(Element.ALIGN_LEFT);
				headercell4.setVerticalAlignment(Element.ALIGN_TOP);
				headercell4.setBorderWidth((float) 0.8);
				customerdetailheader1.addCell(headercell4);

				document.add(customerdetailheader1);

				document.add(Manualspace);
				logger.info("Entering Stage 2");
				/*  *******************************************************************************************************************************************************/
				/// 1. corporate customer information
				PdfPTable corpinfor = new PdfPTable(2);
				corpinfor.setWidthPercentage(100);
				corpinfor.setWidths(new float[] { (float) 0.2, (float) 3.8 });

				PdfPCell corpcell = new PdfPCell(new Phrase("1.", Normalheader));
				corpcell.setFixedHeight(16f); // Row height
				corpcell.setVerticalAlignment(Element.ALIGN_LEFT);
				corpcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				corpcell.setBorderWidth((float) 0.8);
				corpcell.setBackgroundColor(antiqueWhite);
				corpinfor.addCell(corpcell);

				PdfPCell corpcelldesc = new PdfPCell(new Phrase("CORPORATE CUSTOMER INFORMATION", Normalheader));
				corpcelldesc.setFixedHeight(16f); // Row height
				corpcelldesc.setVerticalAlignment(Element.ALIGN_LEFT);
				corpcelldesc.setVerticalAlignment(Element.ALIGN_MIDDLE);
				corpcelldesc.setBorderWidth((float) 0.8);
				corpcelldesc.setBackgroundColor(antiqueWhite);
				corpinfor.addCell(corpcelldesc);

				document.add(corpinfor);

				// CORPORATE INFORMATION LICENSE DETAILS
				PdfPTable licenseTable = new PdfPTable(4);
				licenseTable.setWidthPercentage(100);
				licenseTable.setWidths(new float[] { 0.9f, 2f, 1.5f, 1.5f }); // Adjust the widths

				// Create the merged cell for "Trade License Details"
				PdfPCell licenseTablecell = new PdfPCell(new Phrase("Trade License Details", Normalheader));
				licenseTablecell.setRowspan(2); // Span 2 rows vertically
				licenseTablecell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				licenseTablecell.setHorizontalAlignment(Element.ALIGN_LEFT);
				licenseTable.addCell(licenseTablecell);

				// Row 1 Headers
				licenseTable.addCell(createCell("Number", Normalheader));
				licenseTable.addCell(createCell("Legal Status (LLC, FZC, etc.)", Normalheader));
				licenseTable.addCell(createCell("Expiry Date", Normalheader));

				// Row 2 Values
				licenseTable.addCell(createCell(EcddCorporateEntity.getTrade_license_number(), Responsesize));
				licenseTable.addCell(createCell(EcddCorporateEntity.getTrade_legal_status(), Responsesize));
				licenseTable.addCell(createCell(EcddCorporateEntity.getTrade_expiry_date() != null
						? new SimpleDateFormat("dd/MM/yyyy").format(EcddCorporateEntity.getTrade_expiry_date())
						: "", Responsesize));

				// Add the table (not the cell) to the document
				document.add(licenseTable);

				PdfPTable companyaddress = new PdfPTable(2);
				companyaddress.setWidthPercentage(100);
				companyaddress.setWidths(new float[] { 0.47f, 2.63f }); // Adjust the widths for two columns

				// Create the cell for "Company Address"
				PdfPCell companyaddressdesc = new PdfPCell(new Phrase("Company\nAddress", Normalheader));
				companyaddressdesc.setMinimumHeight(16f); // Base row height, but will expand if needed
				companyaddressdesc.setVerticalAlignment(Element.ALIGN_MIDDLE); // Set once
				companyaddressdesc.setHorizontalAlignment(Element.ALIGN_LEFT); // Align left
				companyaddressdesc.setBorderWidth(0.8f);
				companyaddressdesc.setNoWrap(false); // Allow text wrapping
				companyaddress.addCell(companyaddressdesc);

				// Create the cell for the response (to put the date here)
				PdfPCell companyaddressresp = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCompany_address(), Responsesize)); // Empty for now, but can
																								// hold dynamic content
				companyaddressresp.setMinimumHeight(16f); // Base row height, but will expand if needed
				companyaddressresp.setVerticalAlignment(Element.ALIGN_MIDDLE); // Set once
				companyaddressresp.setHorizontalAlignment(Element.ALIGN_TOP); // Align left
				companyaddressresp.setBorderWidth(0.8f);
				companyaddressresp.setNoWrap(false); // Allow text wrapping
				companyaddress.addCell(companyaddressresp);

				// Add the table to the document
				document.add(companyaddress);
				logger.info("Entering Stage 3");
				/*  *******************************************************************************************************************************************************/

				///// 2. DEVELOPMENT & CHANGES SINGLE LAST UPDATE
				PdfPTable DEVELOPMENT = new PdfPTable(2);
				DEVELOPMENT.setWidthPercentage(100);
				DEVELOPMENT.setWidths(new float[] { (float) 0.2, (float) 3.8 });

				PdfPCell DEVELOPMENTcell = new PdfPCell(new Phrase("2.", Normalheader));
				DEVELOPMENTcell.setFixedHeight(16f); // Row height
				DEVELOPMENTcell.setVerticalAlignment(Element.ALIGN_LEFT);
				DEVELOPMENTcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DEVELOPMENTcell.setBorderWidth((float) 0.8);
				DEVELOPMENTcell.setBackgroundColor(antiqueWhite);
				DEVELOPMENT.addCell(DEVELOPMENTcell);

				PdfPCell DEVELOPMENTcelldesc = new PdfPCell(
						new Phrase("DEVELOPMENT & CHANGES SINGLE LAST UPDATE", Normalheader));
				DEVELOPMENTcelldesc.setFixedHeight(16f); // Row height
				DEVELOPMENTcelldesc.setVerticalAlignment(Element.ALIGN_LEFT);
				DEVELOPMENTcelldesc.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DEVELOPMENTcelldesc.setBorderWidth((float) 0.8);
				DEVELOPMENTcelldesc.setBackgroundColor(antiqueWhite);
				DEVELOPMENT.addCell(DEVELOPMENTcelldesc);

				document.add(DEVELOPMENT);

				PdfPTable DEVELOPMENTDetails = new PdfPTable(2);
				DEVELOPMENTDetails.setWidthPercentage(100);
				DEVELOPMENTDetails.setWidths(new float[] { (float) 2.5, (float) 1.5 });

				PdfPCell Devdetailcell = new PdfPCell(new Phrase(
						"If there is any triggered event i.e. change / development observed in\r\n1) Entity Name                             "
								+ "2) Ownership Structure"
								+ "\r\n3) Legal Status of Entity             4) Activity or Product\r\n"
								+ "Please avoid this form and prepare Detailed ECDD",
						Normalheader));
				Devdetailcell.setMinimumHeight(16f); // Row height
				Devdetailcell.setVerticalAlignment(Element.ALIGN_LEFT);
				Devdetailcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Devdetailcell.setBorderWidth((float) 0.8);
				DEVELOPMENTDetails.addCell(Devdetailcell);

				PdfPCell Devdetailcell2 = new PdfPCell(new Phrase(
						"(if No Change, mention and Proceed) - \r\n" + "" + (EcddCorporateEntity.getNo_change_reason() == null ? "" : EcddCorporateEntity.getNo_change_reason() ),
						Responsesize)); // Empty for now, but can hold dynamic content
				Devdetailcell2.setMinimumHeight(16f); // Base row height, but will expand if needed
				Devdetailcell2.setVerticalAlignment(Element.ALIGN_TOP); // Set once
				Devdetailcell2.setHorizontalAlignment(Element.ALIGN_LEFT); // Align left
				Devdetailcell2.setBorderWidth(0.8f);
				Devdetailcell2.setNoWrap(false); // Allow text wrapping
				DEVELOPMENTDetails.addCell(Devdetailcell2);

				document.add(DEVELOPMENTDetails);

				/* *********************************************************************************************************************************************************/
				///// 3. RISK ASSESSMENT
				PdfPTable Riskassessment = new PdfPTable(2);
				Riskassessment.setWidthPercentage(100);
				Riskassessment.setWidths(new float[] { (float) 0.2, (float) 3.8 });

				PdfPCell Riskassessmentcell = new PdfPCell(new Phrase("3.", Normalheader));
				Riskassessmentcell.setFixedHeight(16f); // Row height
				Riskassessmentcell.setVerticalAlignment(Element.ALIGN_LEFT);
				Riskassessmentcell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Riskassessmentcell.setBorderWidth((float) 0.8);
				Riskassessmentcell.setBackgroundColor(antiqueWhite);
				Riskassessment.addCell(Riskassessmentcell);

				PdfPCell Riskassessmentcelldesc = new PdfPCell(new Phrase("RISK ASSESSMENT", Normalheader));
				Riskassessmentcelldesc.setFixedHeight(16f); // Row height
				Riskassessmentcelldesc.setVerticalAlignment(Element.ALIGN_LEFT);
				Riskassessmentcelldesc.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Riskassessmentcelldesc.setBorderWidth((float) 0.8);
				Riskassessmentcelldesc.setBackgroundColor(antiqueWhite);
				Riskassessment.addCell(Riskassessmentcelldesc);

				document.add(Riskassessment);

				PdfPTable Riskassessmentsub1 = new PdfPTable(2);
				Riskassessmentsub1.setWidthPercentage(100);
				Riskassessmentsub1.setWidths(new float[] { 2, 2 });

				PdfPCell Riskassessmentsubdesc1 = new PdfPCell(new Phrase(
						"Geographic Risk Profile(List of Countries where co. has existing or started new operations)",
						Normalheader));
				Riskassessmentsubdesc1.setFixedHeight(30f); // Row height
				Riskassessmentsubdesc1.setVerticalAlignment(Element.ALIGN_LEFT);
				Riskassessmentsubdesc1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Riskassessmentsubdesc1.setBorderWidth((float) 0.8);
				Riskassessmentsub1.addCell(Riskassessmentsubdesc1);

				PdfPCell Riskassessmentsubdesc2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getGeographic_risk_profile(), Responsesize));
				Riskassessmentsubdesc2.setMinimumHeight(30f); // Row height
				Riskassessmentsubdesc2.setVerticalAlignment(Element.ALIGN_LEFT);
				Riskassessmentsubdesc2.setVerticalAlignment(Element.ALIGN_TOP);
				Riskassessmentsubdesc2.setBorderWidth((float) 0.8);
				Riskassessmentsub1.addCell(Riskassessmentsubdesc2);

				document.add(Riskassessmentsub1);
				///
				PdfPTable Riskassessmentsub2 = new PdfPTable(2);
				Riskassessmentsub2.setWidthPercentage(100);
				Riskassessmentsub2.setWidths(new float[] { 2, 2 });

				PdfPCell Riskassessmentsubdesc3 = new PdfPCell(
						new Phrase("Business Activity & Products", Normalheader));
				Riskassessmentsubdesc3.setFixedHeight(30f); // Row height
				Riskassessmentsubdesc3.setVerticalAlignment(Element.ALIGN_LEFT);
				Riskassessmentsubdesc3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Riskassessmentsubdesc3.setBorderWidth((float) 0.8);
				Riskassessmentsub2.addCell(Riskassessmentsubdesc3);

				PdfPCell Riskassessmentsubdesc4 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getBusiness_activity_products(), Responsesize));
				Riskassessmentsubdesc4.setMinimumHeight(30f); // Row height
				Riskassessmentsubdesc4.setVerticalAlignment(Element.ALIGN_LEFT);
				Riskassessmentsubdesc4.setVerticalAlignment(Element.ALIGN_TOP);
				Riskassessmentsubdesc4.setBorderWidth((float) 0.8);
				Riskassessmentsub2.addCell(Riskassessmentsubdesc4);

				document.add(Riskassessmentsub2);
				logger.info("Entering Stage 4");
				/* *********************************************************************************************************************************************************/
				///// 4. KYC DETAILS
				PdfPTable Kycdetails = new PdfPTable(2);
				Kycdetails.setWidthPercentage(100);
				Kycdetails.setWidths(new float[] { (float) 0.2, (float) 3.8 });

				PdfPCell Kycdetailsheader = new PdfPCell(new Phrase("4.", Normalheader));
				Kycdetailsheader.setFixedHeight(16f); // Row height
				Kycdetailsheader.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsheader.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsheader.setBorderWidth((float) 0.8);
				Kycdetailsheader.setBackgroundColor(antiqueWhite);
				Kycdetails.addCell(Kycdetailsheader);

				PdfPCell Kycdetailsheaderdesc = new PdfPCell(new Phrase("KYC DETAILS", Normalheader));
				Kycdetailsheaderdesc.setFixedHeight(16f); // Row height
				Kycdetailsheaderdesc.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsheaderdesc.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsheaderdesc.setBorderWidth((float) 0.8);
				Kycdetailsheaderdesc.setBackgroundColor(antiqueWhite);
				Kycdetails.addCell(Kycdetailsheaderdesc);

				document.add(Kycdetails);
				///

				PdfPTable Kycdetailsdet1 = new PdfPTable(3);
				Kycdetailsdet1.setWidthPercentage(100);
				Kycdetailsdet1.setWidths(new float[] { 1, 1, 2 });

				PdfPCell Kycdetailsdetcell1 = new PdfPCell(new Phrase("KYC TYPE", Normalheader));
				Kycdetailsdetcell1.setFixedHeight(16f); // Row height
				Kycdetailsdetcell1.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsdetcell1.setBorderWidth((float) 0.8);
				Kycdetailsdet1.addCell(Kycdetailsdetcell1);

				PdfPCell Kycdetailsdetcell2 = new PdfPCell(new Phrase("Validity", Normalheader));
				Kycdetailsdetcell2.setFixedHeight(16f); // Row height
				Kycdetailsdetcell2.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsdetcell2.setBorderWidth((float) 0.8);
				Kycdetailsdet1.addCell(Kycdetailsdetcell2);

				PdfPCell Kycdetailsdetcell3 = new PdfPCell(
						new Phrase("Remarks(Details of action initiated,in case od expired documents)", Normalheader));
				Kycdetailsdetcell3.setMinimumHeight(16f); // Row height
				Kycdetailsdetcell3.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsdetcell3.setBorderWidth((float) 0.8);
				Kycdetailsdet1.addCell(Kycdetailsdetcell3);
				document.add(Kycdetailsdet1);

				////

				PdfPTable Kycdetailsdet2 = new PdfPTable(3);
				Kycdetailsdet2.setWidthPercentage(100);
				Kycdetailsdet2.setWidths(new float[] { 1, 1, 2 });

				PdfPCell Kycdetailsdetcella1 = new PdfPCell(new Phrase("Trade License", Normalheader));
				Kycdetailsdetcella1.setFixedHeight(16f); // Row height
				Kycdetailsdetcella1.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcella1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsdetcella1.setBorderWidth((float) 0.8);
				Kycdetailsdet2.addCell(Kycdetailsdetcella1);

				PdfPCell Kycdetailsdetcella2 = new PdfPCell(
						new Phrase("Valid/Expired - " + EcddCorporateEntity.getTrade_license_validity(), Responsesize));
				Kycdetailsdetcella2.setFixedHeight(16f); // Row height
				Kycdetailsdetcella2.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcella2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsdetcella2.setBorderWidth((float) 0.8);
				Kycdetailsdet2.addCell(Kycdetailsdetcella2);

				PdfPCell Kycdetailsdetcella3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getTrade_license_remarks(), Responsesize));
				Kycdetailsdetcella3.setMinimumHeight(16f); // Row height
				Kycdetailsdetcella3.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcella3.setVerticalAlignment(Element.ALIGN_TOP);
				Kycdetailsdetcella3.setBorderWidth((float) 0.8);
				Kycdetailsdet2.addCell(Kycdetailsdetcella3);
				document.add(Kycdetailsdet2);

				////

				PdfPTable Kycdetailsdet3 = new PdfPTable(3);
				Kycdetailsdet3.setWidthPercentage(100);
				Kycdetailsdet3.setWidths(new float[] { 1, 1, 2 });

				PdfPCell Kycdetailsdetcellb1 = new PdfPCell(new Phrase("UBOs'/Signatories' KYC", Normalheader));
				Kycdetailsdetcellb1.setFixedHeight(16f); // Row height
				Kycdetailsdetcellb1.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcellb1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsdetcellb1.setBorderWidth((float) 0.8);
				Kycdetailsdet3.addCell(Kycdetailsdetcellb1);

				PdfPCell Kycdetailsdetcellb2 = new PdfPCell(new Phrase(
						"Valid/Expired - " + EcddCorporateEntity.getUbo_signatories_kyc_validity(), Responsesize));
				Kycdetailsdetcellb2.setFixedHeight(16f); // Row height
				Kycdetailsdetcellb2.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcellb2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsdetcellb2.setBorderWidth((float) 0.8);
				Kycdetailsdet3.addCell(Kycdetailsdetcellb2);

				PdfPCell Kycdetailsdetcellb3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getUbo_signatories_kyc_remarks(), Responsesize));
				Kycdetailsdetcellb3.setMinimumHeight(16f); // Row height
				Kycdetailsdetcellb3.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcellb3.setVerticalAlignment(Element.ALIGN_TOP);
				Kycdetailsdetcellb3.setBorderWidth((float) 0.8);
				Kycdetailsdet3.addCell(Kycdetailsdetcellb3);
				document.add(Kycdetailsdet3);

				PdfPTable Kycdetailsdet4 = new PdfPTable(3);
				Kycdetailsdet4.setWidthPercentage(100);
				Kycdetailsdet4.setWidths(new float[] { 1, 1, 2 });
				////
				PdfPCell Kycdetailsdetcellc1 = new PdfPCell(new Phrase("Pep's Status", Normalheader));
				Kycdetailsdetcellc1.setFixedHeight(16f); // Row height
				Kycdetailsdetcellc1.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcellc1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsdetcellc1.setBorderWidth((float) 0.8);
				Kycdetailsdet4.addCell(Kycdetailsdetcellc1);

				PdfPCell Kycdetailsdetcellc2 = new PdfPCell(
						new Phrase("Yes/No - " + EcddCorporateEntity.getPep_status(), Responsesize));
				Kycdetailsdetcellc2.setFixedHeight(16f); // Row height
				Kycdetailsdetcellc2.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcellc2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Kycdetailsdetcellc2.setBorderWidth((float) 0.8);
				Kycdetailsdet4.addCell(Kycdetailsdetcellc2);

				PdfPCell Kycdetailsdetcellc3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getPep_remarks(), Responsesize));
				Kycdetailsdetcellc3.setMinimumHeight(16f); // Row height
				Kycdetailsdetcellc3.setVerticalAlignment(Element.ALIGN_LEFT);
				Kycdetailsdetcellc3.setVerticalAlignment(Element.ALIGN_TOP);
				Kycdetailsdetcellc3.setBorderWidth((float) 0.8);
				Kycdetailsdet4.addCell(Kycdetailsdetcellc3);
				document.add(Kycdetailsdet4);

				logger.info("Entering Stage 5");

				/* **********************COUNTERPARTIES (NEWLY INTRODUCES DURING THE PERIOD) */
				PdfPTable COUNTERPARTIES = new PdfPTable(2);
				COUNTERPARTIES.setWidthPercentage(100);
				COUNTERPARTIES.setWidths(new float[] { (float) 0.2, (float) 3.8 });

				PdfPCell COUNTERPARTIESheader = new PdfPCell(new Phrase("5.", Normalheader));
				COUNTERPARTIESheader.setFixedHeight(16f); // Row height
				COUNTERPARTIESheader.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESheader.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESheader.setBorderWidth((float) 0.8);
				COUNTERPARTIESheader.setBackgroundColor(antiqueWhite);
				COUNTERPARTIES.addCell(Kycdetailsheader);

				PdfPCell COUNTERPARTIESheaderDESC = new PdfPCell(
						new Phrase("COUNTERPARTIES (NEWLY INTRODUCES DURING THE PERIOD)", Normalheader));
				COUNTERPARTIESheaderDESC.setFixedHeight(16f); // Row height
				COUNTERPARTIESheaderDESC.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESheaderDESC.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESheaderDESC.setBorderWidth((float) 0.8);
				COUNTERPARTIESheaderDESC.setBackgroundColor(antiqueWhite);
				COUNTERPARTIES.addCell(COUNTERPARTIESheaderDESC);

				document.add(COUNTERPARTIES);

				//
				PdfPTable COUNTERPARTIESROW1 = new PdfPTable(4);
				COUNTERPARTIESROW1.setWidthPercentage(100);
				COUNTERPARTIESROW1.setWidths(new float[] { 2.5f, 0.8f, 0.8f, 0.9f });

				PdfPCell COUNTERPARTIESROW1CELL1 = new PdfPCell(new Phrase("Name", Normalheader));
				COUNTERPARTIESROW1CELL1.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW1CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW1CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW1CELL1.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW1.addCell(COUNTERPARTIESROW1CELL1);

				PdfPCell COUNTERPARTIESROW1CELL2 = new PdfPCell(new Phrase("Import/Export", Normalheader));
				COUNTERPARTIESROW1CELL2.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW1CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW1CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW1CELL2.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW1.addCell(COUNTERPARTIESROW1CELL2);

				PdfPCell COUNTERPARTIESROW1CELL3 = new PdfPCell(new Phrase("Country", Normalheader));
				COUNTERPARTIESROW1CELL3.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW1CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW1CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW1CELL3.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW1.addCell(COUNTERPARTIESROW1CELL3);

				PdfPCell COUNTERPARTIESROW1CELL4 = new PdfPCell(new Phrase("Activity/Products", Normalheader));
				COUNTERPARTIESROW1CELL4.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW1CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW1CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW1CELL4.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW1.addCell(COUNTERPARTIESROW1CELL4);

				document.add(COUNTERPARTIESROW1);
				//
				PdfPTable COUNTERPARTIESROW2 = new PdfPTable(4);
				COUNTERPARTIESROW2.setWidthPercentage(100);
				COUNTERPARTIESROW2.setWidths(new float[] { 2.5f, 0.8f, 0.8f, 0.9f });

				PdfPCell COUNTERPARTIESROW2CELL1 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_name_1(), Responsesize));
				COUNTERPARTIESROW2CELL1.setMinimumHeight(16f); // Row height
				COUNTERPARTIESROW2CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW2CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW2CELL1.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW2.addCell(COUNTERPARTIESROW2CELL1);

				PdfPCell COUNTERPARTIESROW2CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_import_export_1(), Responsesize));
				COUNTERPARTIESROW2CELL2.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW2CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW2CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW2CELL2.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW2.addCell(COUNTERPARTIESROW2CELL2);

				PdfPCell COUNTERPARTIESROW2CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_country_1(), Responsesize));
				COUNTERPARTIESROW2CELL3.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW2CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW2CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW2CELL3.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW2.addCell(COUNTERPARTIESROW2CELL3);

				PdfPCell COUNTERPARTIESROW2CELL4 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_activity_products_1(), Responsesize));
				COUNTERPARTIESROW2CELL4.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW2CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW2CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW2CELL4.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW2.addCell(COUNTERPARTIESROW2CELL4);

				document.add(COUNTERPARTIESROW2);

				//
				PdfPTable COUNTERPARTIESROW3 = new PdfPTable(4);
				COUNTERPARTIESROW3.setWidthPercentage(100);
				COUNTERPARTIESROW3.setWidths(new float[] { 2.5f, 0.8f, 0.8f, 0.9f });

				PdfPCell COUNTERPARTIESROW3CELL1 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_name_2(), Responsesize));
				COUNTERPARTIESROW3CELL1.setMinimumHeight(16f); // Row height
				COUNTERPARTIESROW3CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW3CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW3CELL1.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW3.addCell(COUNTERPARTIESROW3CELL1);

				PdfPCell COUNTERPARTIESROW3CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_import_export_2(), Responsesize));
				COUNTERPARTIESROW3CELL2.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW3CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW3CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW3CELL2.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW3.addCell(COUNTERPARTIESROW3CELL2);

				PdfPCell COUNTERPARTIESROW3CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_country_2(), Responsesize));
				COUNTERPARTIESROW3CELL3.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW3CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW3CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW3CELL3.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW3.addCell(COUNTERPARTIESROW3CELL3);

				PdfPCell COUNTERPARTIESROW3CELL4 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_activity_products_2(), Responsesize));
				COUNTERPARTIESROW3CELL4.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW3CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW3CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW3CELL4.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW3.addCell(COUNTERPARTIESROW3CELL4);

				document.add(COUNTERPARTIESROW3);

				//
				PdfPTable COUNTERPARTIESROW4 = new PdfPTable(4);
				COUNTERPARTIESROW4.setWidthPercentage(100);
				COUNTERPARTIESROW4.setWidths(new float[] { 2.5f, 0.8f, 0.8f, 0.9f });

				PdfPCell COUNTERPARTIESROW4CELL1 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_name_3(), Responsesize));
				COUNTERPARTIESROW4CELL1.setMinimumHeight(16f); // Row height
				COUNTERPARTIESROW4CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW4CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW4CELL1.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW4.addCell(COUNTERPARTIESROW4CELL1);

				PdfPCell COUNTERPARTIESROW4CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_import_export_3(), Responsesize));
				COUNTERPARTIESROW4CELL2.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW4CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW4CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW4CELL2.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW4.addCell(COUNTERPARTIESROW4CELL2);

				PdfPCell COUNTERPARTIESROW4CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_country_3(), Responsesize));
				COUNTERPARTIESROW4CELL3.setMinimumHeight(16f); // Row height
				COUNTERPARTIESROW4CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW4CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW4CELL3.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW4.addCell(COUNTERPARTIESROW4CELL3);

				PdfPCell COUNTERPARTIESROW4CELL4 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_activity_products_3(), Responsesize));
				COUNTERPARTIESROW4CELL4.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW4CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW4CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW4CELL4.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW4.addCell(COUNTERPARTIESROW4CELL4);

				document.add(COUNTERPARTIESROW4);

				//
				PdfPTable COUNTERPARTIESROW5 = new PdfPTable(4);
				COUNTERPARTIESROW5.setWidthPercentage(100);
				COUNTERPARTIESROW5.setWidths(new float[] { 2.5f, 0.8f, 0.8f, 0.9f });

				PdfPCell COUNTERPARTIESROW5CELL1 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_name_4(), Responsesize));
				COUNTERPARTIESROW5CELL1.setMinimumHeight(16f); // Row height
				COUNTERPARTIESROW5CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW5CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW5CELL1.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW5.addCell(COUNTERPARTIESROW5CELL1);

				PdfPCell COUNTERPARTIESROW5CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_import_export_4(), Responsesize));
				COUNTERPARTIESROW5CELL2.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW5CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW5CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW5CELL2.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW5.addCell(COUNTERPARTIESROW5CELL2);

				PdfPCell COUNTERPARTIESROW5CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_country_4(), Responsesize));
				COUNTERPARTIESROW5CELL3.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW5CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW5CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW5CELL3.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW5.addCell(COUNTERPARTIESROW5CELL3);

				PdfPCell COUNTERPARTIESROW5CELL4 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_activity_products_4(), Responsesize));
				COUNTERPARTIESROW5CELL4.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW5CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW5CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW5CELL4.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW5.addCell(COUNTERPARTIESROW5CELL4);

				document.add(COUNTERPARTIESROW5);

				//
				PdfPTable COUNTERPARTIESROW6 = new PdfPTable(4);
				COUNTERPARTIESROW6.setWidthPercentage(100);
				COUNTERPARTIESROW6.setWidths(new float[] { 2.5f, 0.8f, 0.8f, 0.9f });

				PdfPCell COUNTERPARTIESROW6CELL1 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_name_5(), Responsesize));
				COUNTERPARTIESROW6CELL1.setMinimumHeight(16f); // Row height
				COUNTERPARTIESROW6CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW6CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW6CELL1.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW6.addCell(COUNTERPARTIESROW6CELL1);

				PdfPCell COUNTERPARTIESROW6CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_import_export_5(), Responsesize));
				COUNTERPARTIESROW6CELL2.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW6CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW6CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW6CELL2.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW6.addCell(COUNTERPARTIESROW6CELL2);

				PdfPCell COUNTERPARTIESROW6CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_country_5(), Responsesize));
				COUNTERPARTIESROW6CELL3.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW6CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW6CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW6CELL3.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW6.addCell(COUNTERPARTIESROW6CELL3);

				PdfPCell COUNTERPARTIESROW6CELL4 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_activity_products_5(), Responsesize));
				COUNTERPARTIESROW6CELL4.setFixedHeight(16f); // Row height
				COUNTERPARTIESROW6CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				COUNTERPARTIESROW6CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				COUNTERPARTIESROW6CELL4.setBorderWidth((float) 0.8);
				COUNTERPARTIESROW6.addCell(COUNTERPARTIESROW6CELL4);

				document.add(COUNTERPARTIESROW6);
				logger.info("Entering Stage 6");

				/* **********************DUE_DILLIGENCE / SCREENING REPORTS */
				PdfPTable DUE_DILLIGENCE = new PdfPTable(2);
				DUE_DILLIGENCE.setWidthPercentage(100);
				DUE_DILLIGENCE.setWidths(new float[] { (float) 0.2, (float) 3.8 });

				PdfPCell DUE_DILLIGENCEheader = new PdfPCell(new Phrase("6.", Normalheader));
				DUE_DILLIGENCEheader.setFixedHeight(16f); // Row height
				DUE_DILLIGENCEheader.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEheader.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEheader.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEheader.setBackgroundColor(antiqueWhite);
				DUE_DILLIGENCE.addCell(DUE_DILLIGENCEheader);

				PdfPCell DUE_DILLIGENCEheaderDESC = new PdfPCell(
						new Phrase("DUE_DILLIGENCE / SCREENING REPORTS", Normalheader));
				DUE_DILLIGENCEheaderDESC.setFixedHeight(16f); // Row height
				DUE_DILLIGENCEheaderDESC.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEheaderDESC.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEheaderDESC.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEheaderDESC.setBackgroundColor(antiqueWhite);
				DUE_DILLIGENCE.addCell(DUE_DILLIGENCEheaderDESC);

				document.add(DUE_DILLIGENCE);

				PdfPTable DUE_DILLIGENCEROW1 = new PdfPTable(5);
				DUE_DILLIGENCEROW1.setWidthPercentage(100);
				DUE_DILLIGENCEROW1.setWidths(new float[] { 1, 0.7f, 0.7f, 1, 3.6f });
				//// Here is the change made
				PdfPCell DUE_DILLIGENCEROW1CELL0 = new PdfPCell(new Phrase("", Normalheader));
				DUE_DILLIGENCEROW1CELL0.setFixedHeight(35f); // Row height
				DUE_DILLIGENCEROW1CELL0.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW1CELL0.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW1CELL0.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW1.addCell(DUE_DILLIGENCEROW1CELL0);

				PdfPCell DUE_DILLIGENCEROW1CELL1 = new PdfPCell(
						new Phrase("CBUAE BBL CHECK DONE\r\n(Yes/No)", Normalheader));
				DUE_DILLIGENCEROW1CELL1.setFixedHeight(35f); // Row height
				DUE_DILLIGENCEROW1CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW1CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW1CELL1.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW1.addCell(DUE_DILLIGENCEROW1CELL1);

				PdfPCell DUE_DILLIGENCEROW1CELL2 = new PdfPCell(new Phrase("Google\r\n(Yes/no)", Normalheader));
				DUE_DILLIGENCEROW1CELL2.setFixedHeight(35f); // Row height
				DUE_DILLIGENCEROW1CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW1CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW1CELL2.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW1.addCell(DUE_DILLIGENCEROW1CELL2);

				PdfPCell DUE_DILLIGENCEROW1CELL3 = new PdfPCell(new Phrase("Dow-Jones\r\n(Yes/no)", Normalheader));
				DUE_DILLIGENCEROW1CELL3.setFixedHeight(35f); // Row height
				DUE_DILLIGENCEROW1CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW1CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW1CELL3.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW1.addCell(DUE_DILLIGENCEROW1CELL3);

				/*
				 * PdfPCell DUE_DILLIGENCEROW1CELL4 = new PdfPCell( new
				 * Phrase("Internal Deny\r\nList(HAMLUPL)\r\n(Yes/no)", Normalheader));
				 * DUE_DILLIGENCEROW1CELL4.setFixedHeight(35f); // Row height
				 * DUE_DILLIGENCEROW1CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				 * DUE_DILLIGENCEROW1CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * DUE_DILLIGENCEROW1CELL4.setBorderWidth((float) 0.8);
				 * DUE_DILLIGENCEROW1.addCell(DUE_DILLIGENCEROW1CELL4);
				 */

				PdfPCell DUE_DILLIGENCEROW1CELL5 = new PdfPCell(
						new Phrase("Br.remarks(if any adverse found)", Normalheader));
				DUE_DILLIGENCEROW1CELL5.setMinimumHeight(35f); // Row height
				DUE_DILLIGENCEROW1CELL5.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW1CELL5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW1CELL5.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW1.addCell(DUE_DILLIGENCEROW1CELL5);

				document.add(DUE_DILLIGENCEROW1);

				////
				PdfPTable DUE_DILLIGENCEROW2 = new PdfPTable(5);
				DUE_DILLIGENCEROW2.setWidthPercentage(100);
				DUE_DILLIGENCEROW2.setWidths(new float[] { 1, 0.7f, 0.7f, 1, 3.6f });

				PdfPCell DUE_DILLIGENCEROW2CELL1 = new PdfPCell(new Phrase("Corporate", Normalheader));
				DUE_DILLIGENCEROW2CELL1.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW2CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW2CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW2CELL1.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW2.addCell(DUE_DILLIGENCEROW2CELL1);
				//// Column Added Here for CBUAE Check
				PdfPCell DUE_DILLIGENCEROW2CELL0 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCorporate_cbuae_bbl(), Responsesize));
				DUE_DILLIGENCEROW2CELL0.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW2CELL0.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW2CELL0.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW2CELL0.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW2.addCell(DUE_DILLIGENCEROW2CELL0);

				PdfPCell DUE_DILLIGENCEROW2CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCorporate_google_screening(), Responsesize));
				DUE_DILLIGENCEROW2CELL2.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW2CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW2CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW2CELL2.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW2.addCell(DUE_DILLIGENCEROW2CELL2);

				PdfPCell DUE_DILLIGENCEROW2CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCorporate_dow_jones_screening(), Responsesize));
				DUE_DILLIGENCEROW2CELL3.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW2CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW2CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW2CELL3.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW2.addCell(DUE_DILLIGENCEROW2CELL3);

				/*
				 * PdfPCell DUE_DILLIGENCEROW2CELL4 = new PdfPCell( new
				 * Phrase(EcddCorporateEntity.getCorporate_internal_deny_list(), Normalheader));
				 * DUE_DILLIGENCEROW2CELL4.setFixedHeight(20f); // Row height
				 * DUE_DILLIGENCEROW2CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				 * DUE_DILLIGENCEROW2CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * DUE_DILLIGENCEROW2CELL4.setBorderWidth((float) 0.8);
				 * DUE_DILLIGENCEROW2.addCell(DUE_DILLIGENCEROW2CELL4);
				 */
				PdfPCell DUE_DILLIGENCEROW2CELL5 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCorporate_screening_remarks(), Responsesize));
				DUE_DILLIGENCEROW2CELL5.setMinimumHeight(20f); // Row height
				DUE_DILLIGENCEROW2CELL5.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW2CELL5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW2CELL5.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW2.addCell(DUE_DILLIGENCEROW2CELL5);

				document.add(DUE_DILLIGENCEROW2);

				///
				PdfPTable DUE_DILLIGENCEROW3 = new PdfPTable(5);
				DUE_DILLIGENCEROW3.setWidthPercentage(100);
				DUE_DILLIGENCEROW3.setWidths(new float[] { 1, 0.7f, 0.7f, 1, 3.6f });

				PdfPCell DUE_DILLIGENCEROW3CELL1 = new PdfPCell(new Phrase("UBO/Signatory", Normalheader));
				DUE_DILLIGENCEROW3CELL1.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW3CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW3CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW3CELL1.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW3.addCell(DUE_DILLIGENCEROW3CELL1);

				PdfPCell DUE_DILLIGENCEROW3CELL0 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getUbo_cbuae_bbl(), Responsesize));
				DUE_DILLIGENCEROW3CELL0.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW3CELL0.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW3CELL0.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW3CELL0.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW3.addCell(DUE_DILLIGENCEROW3CELL0);

				PdfPCell DUE_DILLIGENCEROW3CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getUbo_google_screening(), Responsesize));
				DUE_DILLIGENCEROW3CELL2.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW3CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW3CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW3CELL2.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW3.addCell(DUE_DILLIGENCEROW3CELL2);

				PdfPCell DUE_DILLIGENCEROW3CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCorporate_dow_jones_screening(), Responsesize));
				DUE_DILLIGENCEROW3CELL3.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW3CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW3CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW3CELL3.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW3.addCell(DUE_DILLIGENCEROW3CELL3);

				/*
				 * PdfPCell DUE_DILLIGENCEROW3CELL4 = new PdfPCell( new
				 * Phrase(EcddCorporateEntity.getCorporate_internal_deny_list(), Normalheader));
				 * DUE_DILLIGENCEROW3CELL4.setFixedHeight(20f); // Row height
				 * DUE_DILLIGENCEROW3CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				 * DUE_DILLIGENCEROW3CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * DUE_DILLIGENCEROW3CELL4.setBorderWidth((float) 0.8);
				 * DUE_DILLIGENCEROW3.addCell(DUE_DILLIGENCEROW3CELL4);
				 */
				PdfPCell DUE_DILLIGENCEROW3CELL5 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCorporate_screening_remarks(), Responsesize));
				DUE_DILLIGENCEROW3CELL5.setMinimumHeight(20f); // Row height
				DUE_DILLIGENCEROW3CELL5.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW3CELL5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW3CELL5.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW3.addCell(DUE_DILLIGENCEROW3CELL5);

				document.add(DUE_DILLIGENCEROW3);

				///
				PdfPTable DUE_DILLIGENCEROW4 = new PdfPTable(5);
				DUE_DILLIGENCEROW4.setWidthPercentage(100);
				DUE_DILLIGENCEROW4.setWidths(new float[] { 1, 0.7f, 0.7f, 1, 3.6f });

				PdfPCell DUE_DILLIGENCEROW4CELL1 = new PdfPCell(new Phrase("Counter Party", Normalheader));
				DUE_DILLIGENCEROW4CELL1.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW4CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW4CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW4CELL1.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW4.addCell(DUE_DILLIGENCEROW4CELL1);

				PdfPCell DUE_DILLIGENCEROW4CELL0 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_cbuae_bbl(), Responsesize));
				DUE_DILLIGENCEROW4CELL0.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW4CELL0.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW4CELL0.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW4CELL0.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW4.addCell(DUE_DILLIGENCEROW4CELL0);

				PdfPCell DUE_DILLIGENCEROW4CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_google_screening(), Responsesize));
				DUE_DILLIGENCEROW4CELL2.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW4CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW4CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW4CELL2.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW4.addCell(DUE_DILLIGENCEROW4CELL2);

				PdfPCell DUE_DILLIGENCEROW4CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_dow_jones_screening(), Responsesize));
				DUE_DILLIGENCEROW4CELL3.setFixedHeight(20f); // Row height
				DUE_DILLIGENCEROW4CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW4CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW4CELL3.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW4.addCell(DUE_DILLIGENCEROW4CELL3);

				/*
				 * PdfPCell DUE_DILLIGENCEROW4CELL4 = new PdfPCell( new
				 * Phrase(EcddCorporateEntity.getCounterparty_internal_deny_list(),
				 * Normalheader)); DUE_DILLIGENCEROW4CELL4.setFixedHeight(20f); // Row height
				 * DUE_DILLIGENCEROW4CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				 * DUE_DILLIGENCEROW4CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * DUE_DILLIGENCEROW4CELL4.setBorderWidth((float) 0.8);
				 * DUE_DILLIGENCEROW4.addCell(DUE_DILLIGENCEROW4CELL4);
				 */

				PdfPCell DUE_DILLIGENCEROW4CELL5 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCounterparty_screening_remarks(), Responsesize));
				DUE_DILLIGENCEROW4CELL5.setMinimumHeight(20f); // Row height
				DUE_DILLIGENCEROW4CELL5.setVerticalAlignment(Element.ALIGN_LEFT);
				DUE_DILLIGENCEROW4CELL5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				DUE_DILLIGENCEROW4CELL5.setBorderWidth((float) 0.8);
				DUE_DILLIGENCEROW4.addCell(DUE_DILLIGENCEROW4CELL5);

				document.add(DUE_DILLIGENCEROW4);
				logger.info("Entering Stage 7");

				/*****************************************************************************************************************************************************/

				PdfPTable TRANSAC_MONI = new PdfPTable(2);
				TRANSAC_MONI.setWidthPercentage(100);
				TRANSAC_MONI.setWidths(new float[] { (float) 0.2, (float) 3.8 });

				PdfPCell TRANSAC_MONIheader = new PdfPCell(new Phrase("6.", Normalheader));
				TRANSAC_MONIheader.setFixedHeight(16f); // Row height
				TRANSAC_MONIheader.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIheader.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIheader.setBorderWidth((float) 0.8);
				TRANSAC_MONIheader.setBackgroundColor(antiqueWhite);
				TRANSAC_MONI.addCell(TRANSAC_MONIheader);

				PdfPCell TRANSAC_MONIheaderDESC = new PdfPCell(new Phrase("TRANSACTION MONITORING", Normalheader));
				TRANSAC_MONIheaderDESC.setFixedHeight(16f); // Row height
				TRANSAC_MONIheaderDESC.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIheaderDESC.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIheaderDESC.setBorderWidth((float) 0.8);
				TRANSAC_MONIheaderDESC.setBackgroundColor(antiqueWhite);
				TRANSAC_MONI.addCell(TRANSAC_MONIheaderDESC);

				document.add(TRANSAC_MONI);

				PdfPTable TRANSAC_MONIROW1 = new PdfPTable(1);
				TRANSAC_MONIROW1.setWidthPercentage(100);
				TRANSAC_MONIROW1.setWidths(new float[] { 1 });

				PdfPCell TRANSAC_MONIROW1CELL1 = new PdfPCell(new Phrase(
						"Transaction History"
								+ "(Details of unusual or suspicious transactions over the past 12 months)",
						Normalheader));
				TRANSAC_MONIROW1CELL1.setFixedHeight(16f); // Row height
				TRANSAC_MONIROW1CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW1CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW1CELL1.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW1.addCell(TRANSAC_MONIROW1CELL1);

				document.add(TRANSAC_MONIROW1);
				///
				PdfPTable TRANSAC_MONIROW2 = new PdfPTable(1);
				TRANSAC_MONIROW2.setWidthPercentage(100);
				TRANSAC_MONIROW2.setWidths(new float[] { 1 });

				PdfPCell TRANSAC_MONIROW2CELL1 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getTransaction_history(), Responsesize));
				TRANSAC_MONIROW2CELL1.setMinimumHeight(25f); // Row height
				TRANSAC_MONIROW2CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW2CELL1.setVerticalAlignment(Element.ALIGN_TOP);
				TRANSAC_MONIROW2CELL1.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW2.addCell(TRANSAC_MONIROW2CELL1);

				document.add(TRANSAC_MONIROW2);
				////
				/// Conduct of the account (Label)
				PdfPTable TRANSAC_MONIROW4 = new PdfPTable(1);
				TRANSAC_MONIROW4.setWidthPercentage(100);
				TRANSAC_MONIROW4.setWidths(new float[] { 1 });

				PdfPCell TRANSAC_MONIROW4CELL1 = new PdfPCell(new Phrase(
						"Conduct of the account"
								+ "(Any suspicious activity or risk indicators or ISTR filed during ECDD period)",
						Normalheader));
				TRANSAC_MONIROW4CELL1.setFixedHeight(16f); // Row height
				TRANSAC_MONIROW4CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW4CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW4CELL1.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW4.addCell(TRANSAC_MONIROW4CELL1);

				document.add(TRANSAC_MONIROW4);
				/// Conduct of the account (Value)
				PdfPTable TRANSAC_MONIROW5 = new PdfPTable(1);
				TRANSAC_MONIROW5.setWidthPercentage(100);
				TRANSAC_MONIROW5.setWidths(new float[] { 1 });

				PdfPCell TRANSAC_MONIROW5CELL1 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getAccount_conduct(), Responsesize));
				TRANSAC_MONIROW5CELL1.setMinimumHeight(40f); // Row height
				TRANSAC_MONIROW5CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW5CELL1.setVerticalAlignment(Element.ALIGN_TOP);
				TRANSAC_MONIROW5CELL1.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW5.addCell(TRANSAC_MONIROW5CELL1);

				document.add(TRANSAC_MONIROW5);

				//// High Value Transaction Monitoring (MOVED HERE)
				PdfPTable TRANSAC_MONIROW3 = new PdfPTable(5);
				TRANSAC_MONIROW3.setWidthPercentage(100);
				TRANSAC_MONIROW3.setWidths(new float[] { 2.6f, 1f, 0.7f, 1, 1f });

				PdfPCell TRANSAC_MONIROW3CELL1 = new PdfPCell(
						new Phrase("High Value Transaction Monitoring (Above 1 million)", Normalheader));
				TRANSAC_MONIROW3CELL1.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW3CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW3CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW3CELL1.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW3.addCell(TRANSAC_MONIROW3CELL1);

				PdfPCell TRANSAC_MONIROW3CELL2 = new PdfPCell(new Phrase("No of Transaction", Normalheader));
				TRANSAC_MONIROW3CELL2.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW3CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW3CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW3CELL2.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW3.addCell(TRANSAC_MONIROW3CELL2);

				PdfPCell TRANSAC_MONIROW3CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getHigh_value_transaction_count() != null
								? EcddCorporateEntity.getHigh_value_transaction_count().toString()
								: "", Responsesize));
				TRANSAC_MONIROW3CELL3.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW3CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW3CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW3CELL3.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW3.addCell(TRANSAC_MONIROW3CELL3);

				PdfPCell TRANSAC_MONIROW3CELL4 = new PdfPCell(new Phrase("Voulme", Normalheader));
				TRANSAC_MONIROW3CELL4.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW3CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW3CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW3CELL4.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW3.addCell(TRANSAC_MONIROW3CELL4);

				PdfPCell TRANSAC_MONIROW3CELL5 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getHigh_value_transaction_volume() != null
								? EcddCorporateEntity.getHigh_value_transaction_volume().toString()
								: "", Responsesize));
				TRANSAC_MONIROW3CELL5.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW3CELL5.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW3CELL5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW3CELL5.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW3.addCell(TRANSAC_MONIROW3CELL5);

				document.add(TRANSAC_MONIROW3);

				// END OF MODIFICATION

				Paragraph Branch = new Paragraph(
						"Branch to ensure updating the data in CBS with latest details & upload documents in DMS",
						Responsesize);
				Branch.setAlignment(Element.ALIGN_CENTER);
				Branch.setSpacingAfter(1f);

				document.add(Branch);

				//////////////// PAGE 2
				document.add(Duediligence);
				document.add(Non_Individual);
				document.add(customerdetailheader);
				document.add(customerdetailheader1);

				document.add(Manualspace);

				PdfPTable TRANSAC_MONIROW6 = new PdfPTable(2);
				TRANSAC_MONIROW6.setWidthPercentage(100);
				TRANSAC_MONIROW6.setWidths(new float[] { 1.36f, 0.54f });

				PdfPCell TRANSAC_MONIROW6CELL1 = new PdfPCell(
						new Phrase("Frequency and Volume of transaction During The Period (% w.r.t Annual Turnover)",
								Normalheader));
				TRANSAC_MONIROW6CELL1.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW6CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW6CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW6CELL1.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW6.addCell(TRANSAC_MONIROW6CELL1);

				PdfPCell TRANSAC_MONIROW6CELL2 = new PdfPCell(
						new Phrase(" No.of Transaction &\r\n Turnover", Normalheader));
				TRANSAC_MONIROW6CELL2.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW6CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW6CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW6CELL2.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW6.addCell(TRANSAC_MONIROW6CELL2);

				document.add(TRANSAC_MONIROW6);

				PdfPTable TRANSAC_MONIROW7 = new PdfPTable(7);
				TRANSAC_MONIROW7.setWidthPercentage(100);
				TRANSAC_MONIROW7.setWidths(new float[] { 1, 1, 1, 1, 1, 1, 1 });

				PdfPCell TRANSAC_MONIROW7CELL1 = new PdfPCell(new Phrase("", Normalheader));
				TRANSAC_MONIROW7CELL1.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW7CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW7CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW7CELL1.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW7.addCell(TRANSAC_MONIROW7CELL1);

				PdfPCell TRANSAC_MONIROW7CELL2 = new PdfPCell(new Phrase("Cash", Normalheader));
				TRANSAC_MONIROW7CELL2.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW7CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW7CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW7CELL2.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW7.addCell(TRANSAC_MONIROW7CELL2);

				PdfPCell TRANSAC_MONIROW7CELL3 = new PdfPCell(new Phrase("Cheque", Normalheader));
				TRANSAC_MONIROW7CELL3.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW7CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW7CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW7CELL3.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW7.addCell(TRANSAC_MONIROW7CELL3);

				PdfPCell TRANSAC_MONIROW7CELL4 = new PdfPCell(new Phrase("Local Transfer", Normalheader));
				TRANSAC_MONIROW7CELL4.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW7CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW7CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW7CELL4.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW7.addCell(TRANSAC_MONIROW7CELL4);

				PdfPCell TRANSAC_MONIROW7CELL5 = new PdfPCell(new Phrase("International Transfer", Normalheader));
				TRANSAC_MONIROW7CELL5.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW7CELL5.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW7CELL5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW7CELL5.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW7.addCell(TRANSAC_MONIROW7CELL5);

				PdfPCell TRANSAC_MONIROW7CELL6 = new PdfPCell(new Phrase("Current", Normalheader));
				TRANSAC_MONIROW7CELL6.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW7CELL6.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW7CELL6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW7CELL6.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW7.addCell(TRANSAC_MONIROW7CELL6);

				PdfPCell TRANSAC_MONIROW7CELL7 = new PdfPCell(new Phrase("Expected", Normalheader));
				TRANSAC_MONIROW7CELL7.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW7CELL7.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW7CELL7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW7CELL7.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW7.addCell(TRANSAC_MONIROW7CELL7);

				document.add(TRANSAC_MONIROW7);

				///
				PdfPTable TRANSAC_MONIROW8 = new PdfPTable(7);
				TRANSAC_MONIROW8.setWidthPercentage(100);
				TRANSAC_MONIROW8.setWidths(new float[] { 1, 1, 1, 1, 1, 1, 1 });

				PdfPCell TRANSAC_MONIROW8CELL1 = new PdfPCell(new Phrase("No of Transaction(%)", Normalheader));
				TRANSAC_MONIROW8CELL1.setFixedHeight(30f); // Row height
				TRANSAC_MONIROW8CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW8CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW8CELL1.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW8.addCell(TRANSAC_MONIROW8CELL1);

				PdfPCell TRANSAC_MONIROW8CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCash_transaction_percent() != null
								? EcddCorporateEntity.getCash_transaction_percent().toString()
								: "", Responsesize));
				TRANSAC_MONIROW8CELL2.setFixedHeight(30f); // Row height
				TRANSAC_MONIROW8CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW8CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW8CELL2.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW8.addCell(TRANSAC_MONIROW8CELL2);

				PdfPCell TRANSAC_MONIROW8CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCheque_transaction_percent() != null
								? EcddCorporateEntity.getCheque_transaction_percent().toString()
								: "", Responsesize));
				TRANSAC_MONIROW8CELL3.setFixedHeight(30f); // Row heigh
				TRANSAC_MONIROW8CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW8CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW8CELL3.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW8.addCell(TRANSAC_MONIROW8CELL3);

				PdfPCell TRANSAC_MONIROW8CELL4 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getLocal_transfer_percent() != null
								? EcddCorporateEntity.getLocal_transfer_percent().toString()
								: "", Responsesize));
				TRANSAC_MONIROW8CELL4.setFixedHeight(30f); // Row height
				TRANSAC_MONIROW8CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW8CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW8CELL4.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW8.addCell(TRANSAC_MONIROW8CELL4);

				PdfPCell TRANSAC_MONIROW8CELL5 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getIntl_transfer_percent() != null
								? EcddCorporateEntity.getIntl_transfer_percent().toString()
								: "", Responsesize));
				TRANSAC_MONIROW8CELL5.setFixedHeight(30f); // Row height
				TRANSAC_MONIROW8CELL5.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW8CELL5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW8CELL5.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW8.addCell(TRANSAC_MONIROW8CELL5);

				PdfPCell TRANSAC_MONIROW8CELL6 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCurrent_transaction_count() != null
								? EcddCorporateEntity.getCurrent_transaction_count().toString()
								: "", Responsesize));
				TRANSAC_MONIROW8CELL6.setFixedHeight(30f); // Row height
				TRANSAC_MONIROW8CELL6.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW8CELL6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW8CELL6.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW8.addCell(TRANSAC_MONIROW8CELL6);

				PdfPCell TRANSAC_MONIROW8CELL7 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getExpected_transaction_count() != null
								? EcddCorporateEntity.getExpected_transaction_count().toString()
								: "", Responsesize));
				TRANSAC_MONIROW8CELL7.setFixedHeight(30f); // Row height
				TRANSAC_MONIROW8CELL7.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW8CELL7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW8CELL7.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW8.addCell(TRANSAC_MONIROW8CELL7);

				document.add(TRANSAC_MONIROW8);

				///
				PdfPTable TRANSAC_MONIROW9 = new PdfPTable(7);
				TRANSAC_MONIROW9.setWidthPercentage(100);
				TRANSAC_MONIROW9.setWidths(new float[] { 1, 1, 1, 1, 1, 1, 1 });

				PdfPCell TRANSAC_MONIROW9CELL1 = new PdfPCell(new Phrase("Volume(%)", Normalheader));
				TRANSAC_MONIROW9CELL1.setFixedHeight(20f); // Row height
				TRANSAC_MONIROW9CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW9CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW9CELL1.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW9.addCell(TRANSAC_MONIROW9CELL1);

				PdfPCell TRANSAC_MONIROW9CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCash_volume_percent() != null
								? EcddCorporateEntity.getCash_volume_percent().toString()
								: "", Responsesize));
				TRANSAC_MONIROW9CELL2.setFixedHeight(20f); // Row height
				TRANSAC_MONIROW9CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW9CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW9CELL2.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW9.addCell(TRANSAC_MONIROW9CELL2);

				PdfPCell TRANSAC_MONIROW9CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCheque_volume_percent() != null
								? EcddCorporateEntity.getCheque_volume_percent().toString()
								: "", Responsesize));
				TRANSAC_MONIROW9CELL3.setFixedHeight(20f); // Row heigh
				TRANSAC_MONIROW9CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW9CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW9CELL3.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW9.addCell(TRANSAC_MONIROW9CELL3);

				PdfPCell TRANSAC_MONIROW9CELL4 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getLocal_transfer_volume_percent() != null
								? EcddCorporateEntity.getLocal_transfer_volume_percent().toString()
								: "", Responsesize));
				TRANSAC_MONIROW9CELL4.setFixedHeight(20f); // Row height
				TRANSAC_MONIROW9CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW9CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW9CELL4.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW9.addCell(TRANSAC_MONIROW9CELL4);

				PdfPCell TRANSAC_MONIROW9CELL5 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getIntl_transfer_volume_percent() != null
								? EcddCorporateEntity.getIntl_transfer_volume_percent().toString()
								: "", Responsesize));
				TRANSAC_MONIROW9CELL5.setFixedHeight(20f); // Row height
				TRANSAC_MONIROW9CELL5.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW9CELL5.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW9CELL5.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW9.addCell(TRANSAC_MONIROW9CELL5);

				PdfPCell TRANSAC_MONIROW9CELL6 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getCurrent_volume_count() != null
								? EcddCorporateEntity.getCurrent_volume_count().toString()
								: "", Responsesize));
				TRANSAC_MONIROW9CELL6.setFixedHeight(20f); // Row height
				TRANSAC_MONIROW9CELL6.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW9CELL6.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW9CELL6.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW9.addCell(TRANSAC_MONIROW9CELL6);

				PdfPCell TRANSAC_MONIROW9CELL7 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getExpected_volume_count() != null
								? EcddCorporateEntity.getExpected_volume_count().toString()
								: "", Responsesize));
				TRANSAC_MONIROW9CELL7.setFixedHeight(20f); // Row height
				TRANSAC_MONIROW9CELL7.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW9CELL7.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW9CELL7.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW9.addCell(TRANSAC_MONIROW9CELL7);

				document.add(TRANSAC_MONIROW9);

				//
				PdfPTable TRANSAC_MONIROW10 = new PdfPTable(1);
				TRANSAC_MONIROW10.setWidthPercentage(100);
				TRANSAC_MONIROW10.setWidths(new float[] { 1 });

				PdfPCell TRANSAC_MONIROW10CELL1 = new PdfPCell(new Phrase(
						"Transaction in the account commensurate with business profile - YES/NO - "
								+ EcddCorporateEntity.getTransactions_match_profile() + ""
								+ "\r\n(if No,please provide Your justification,recommendations, and comments in section 10)",
						Normalheader));
				TRANSAC_MONIROW10CELL1.setFixedHeight(25f); // Row height
				TRANSAC_MONIROW10CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				TRANSAC_MONIROW10CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				TRANSAC_MONIROW10CELL1.setBorderWidth((float) 0.8);
				TRANSAC_MONIROW10.addCell(TRANSAC_MONIROW10CELL1);

				document.add(TRANSAC_MONIROW10);

				logger.info("Entering Stage 8");
				/*       ******************************************************************************************************************************************/
				//// CUSTOMER_RISK & REASON FOR RISK CATEGORY

				PdfPTable CUSTOMER_RISK = new PdfPTable(2);
				CUSTOMER_RISK.setWidthPercentage(100);
				CUSTOMER_RISK.setWidths(new float[] { (float) 0.2, (float) 3.8 });

				PdfPCell CUSTOMER_RISKheader = new PdfPCell(new Phrase("8.", Normalheader));
				CUSTOMER_RISKheader.setFixedHeight(16f); // Row height
				CUSTOMER_RISKheader.setVerticalAlignment(Element.ALIGN_LEFT);
				CUSTOMER_RISKheader.setVerticalAlignment(Element.ALIGN_MIDDLE);
				CUSTOMER_RISKheader.setBorderWidth((float) 0.8);
				CUSTOMER_RISKheader.setBackgroundColor(antiqueWhite);
				CUSTOMER_RISK.addCell(CUSTOMER_RISKheader);

				PdfPCell CUSTOMER_RISKheaderDESC = new PdfPCell(
						new Phrase("CUSTOMER RISK & REASON FOR RISK CATEGORIZATION (AS PER CRA)", Normalheader));
				CUSTOMER_RISKheaderDESC.setFixedHeight(16f); // Row height
				CUSTOMER_RISKheaderDESC.setVerticalAlignment(Element.ALIGN_LEFT);
				CUSTOMER_RISKheaderDESC.setVerticalAlignment(Element.ALIGN_MIDDLE);
				CUSTOMER_RISKheaderDESC.setBorderWidth((float) 0.8);
				CUSTOMER_RISKheaderDESC.setBackgroundColor(antiqueWhite);
				CUSTOMER_RISK.addCell(CUSTOMER_RISKheaderDESC);

				document.add(CUSTOMER_RISK);

				///
				PdfPTable CUSTOMER_RISKROW1 = new PdfPTable(2);
				CUSTOMER_RISKROW1.setWidthPercentage(100);
				CUSTOMER_RISKROW1.setWidths(new float[] { 1.6f, 2.3f });

				PdfPCell CUSTOMER_RISKROW1CELL1 = new PdfPCell(new Phrase("System Risk", Normalheader));
				CUSTOMER_RISKROW1CELL1.setFixedHeight(25f); // Row height
				CUSTOMER_RISKROW1CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				CUSTOMER_RISKROW1CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				CUSTOMER_RISKROW1CELL1.setBorderWidth((float) 0.8);
				CUSTOMER_RISKROW1.addCell(CUSTOMER_RISKROW1CELL1);

				/*
				 * PdfPCell CUSTOMER_RISKROW1CELL2 = new PdfPCell(new
				 * Phrase("Latest Risk as per CRA", Normalheader));
				 * CUSTOMER_RISKROW1CELL2.setFixedHeight(25f); // Row height
				 * CUSTOMER_RISKROW1CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				 * CUSTOMER_RISKROW1CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * CUSTOMER_RISKROW1CELL2.setBorderWidth((float) 0.8);
				 * CUSTOMER_RISKROW1.addCell(CUSTOMER_RISKROW1CELL2);
				 */

				PdfPCell CUSTOMER_RISKROW1CELL3 = new PdfPCell(new Phrase(
						"Reason (Any downgrade from system-driven risk must be \r\n approved by territory comliance Department)",
						Normalheader));
				CUSTOMER_RISKROW1CELL3.setFixedHeight(25f); // Row heigh
				CUSTOMER_RISKROW1CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				CUSTOMER_RISKROW1CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				CUSTOMER_RISKROW1CELL3.setBorderWidth((float) 0.8);
				CUSTOMER_RISKROW1.addCell(CUSTOMER_RISKROW1CELL3);

				document.add(CUSTOMER_RISKROW1);

				///
				PdfPTable CUSTOMER_RISKROW2 = new PdfPTable(3);
				CUSTOMER_RISKROW2.setWidthPercentage(100);
				CUSTOMER_RISKROW2.setWidths(new float[] { 0.77f, 0.79f, 3.60f });

				PdfPCell CUSTOMER_RISKROW2CELL1 = new PdfPCell(new Phrase("High\r\nMedium\r\nLow", Normalheader));
				CUSTOMER_RISKROW2CELL1.setFixedHeight(35f); // Row height
				CUSTOMER_RISKROW2CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				CUSTOMER_RISKROW2CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				CUSTOMER_RISKROW2CELL1.setBorderWidth((float) 0.8);
				CUSTOMER_RISKROW2.addCell(CUSTOMER_RISKROW2CELL1);

				PdfPCell CUSTOMER_RISKROW2CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getSystem_risk(), Responsesize));
				CUSTOMER_RISKROW2CELL2.setFixedHeight(35f); // Row height
				CUSTOMER_RISKROW2CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				CUSTOMER_RISKROW2CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				CUSTOMER_RISKROW2CELL2.setBorderWidth((float) 0.8);
				CUSTOMER_RISKROW2.addCell(CUSTOMER_RISKROW2CELL2);

				/*
				 * PdfPCell CUSTOMER_RISKROW2CELL3 = new PdfPCell(new
				 * Phrase("High\r\nMedium\r\nLow", Normalheader));
				 * CUSTOMER_RISKROW2CELL3.setFixedHeight(35f); // Row heigh
				 * CUSTOMER_RISKROW2CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				 * CUSTOMER_RISKROW2CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * CUSTOMER_RISKROW2CELL3.setBorderWidth((float) 0.8);
				 * CUSTOMER_RISKROW2.addCell(CUSTOMER_RISKROW2CELL3);
				 * 
				 * PdfPCell CUSTOMER_RISKROW2CELL4 = new PdfPCell( new
				 * Phrase(EcddCorporateEntity.getLatest_risk(), Normalheader));
				 * CUSTOMER_RISKROW2CELL4.setFixedHeight(35f); // Row heigh
				 * CUSTOMER_RISKROW2CELL4.setVerticalAlignment(Element.ALIGN_LEFT);
				 * CUSTOMER_RISKROW2CELL4.setVerticalAlignment(Element.ALIGN_MIDDLE);
				 * CUSTOMER_RISKROW2CELL4.setBorderWidth((float) 0.8);
				 * CUSTOMER_RISKROW2.addCell(CUSTOMER_RISKROW2CELL4);
				 */

				PdfPCell CUSTOMER_RISKROW2CELL5 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getRisk_reason(), Responsesize));
				CUSTOMER_RISKROW2CELL5.setMinimumHeight(35f); // Row heigh
				CUSTOMER_RISKROW2CELL5.setVerticalAlignment(Element.ALIGN_LEFT);
				CUSTOMER_RISKROW2CELL5.setVerticalAlignment(Element.ALIGN_TOP);
				CUSTOMER_RISKROW2CELL5.setBorderWidth((float) 0.8);
				CUSTOMER_RISKROW2.addCell(CUSTOMER_RISKROW2CELL5);

				document.add(CUSTOMER_RISKROW2);

				logger.info("Entering Stage 9");
				/*       *******************************************************************************************************************************************/

				//// Documents Avail in DMS

				PdfPTable Documents_avail = new PdfPTable(2);
				Documents_avail.setWidthPercentage(100);
				Documents_avail.setWidths(new float[] { (float) 0.2, (float) 3.8 });

				PdfPCell Documents_availheader = new PdfPCell(new Phrase("9.", Normalheader));
				Documents_availheader.setFixedHeight(16f); // Row height
				Documents_availheader.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availheader.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availheader.setBorderWidth((float) 0.8);
				Documents_availheader.setBackgroundColor(antiqueWhite);
				Documents_avail.addCell(Documents_availheader);

				PdfPCell Documents_availheaderDESC = new PdfPCell(
						new Phrase("Documents Availability in DMS", Normalheader));
				Documents_availheaderDESC.setFixedHeight(16f); // Row height
				Documents_availheaderDESC.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availheaderDESC.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availheaderDESC.setBorderWidth((float) 0.8);
				Documents_availheaderDESC.setBackgroundColor(antiqueWhite);
				Documents_avail.addCell(Documents_availheaderDESC);

				document.add(Documents_avail);

				///
				PdfPTable Documents_availROW1 = new PdfPTable(3);
				Documents_availROW1.setWidthPercentage(100);
				Documents_availROW1.setWidths(new float[] { 1.25f, 0.35f, 1.4f });

				PdfPCell Documents_availROW1CELL1 = new PdfPCell(
						new Phrase("AOF and FATCA / CRS & Others", Normalheader));
				Documents_availROW1CELL1.setFixedHeight(35f); // Row height
				Documents_availROW1CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW1CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availROW1CELL1.setBorderWidth((float) 0.8);
				Documents_availROW1.addCell(Documents_availROW1CELL1);

				PdfPCell Documents_availROW1CELL2 = new PdfPCell(
						new Phrase("Availability check (Yes/No)", Normalheader));
				Documents_availROW1CELL2.setFixedHeight(35f); // Row height
				Documents_availROW1CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW1CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availROW1CELL2.setBorderWidth((float) 0.8);
				Documents_availROW1.addCell(Documents_availROW1CELL2);

				PdfPCell Documents_availROW1CELL3 = new PdfPCell(
						new Phrase("Remarks(Details of action initiated,in case of unavailability of said document)",
								Normalheader));
				Documents_availROW1CELL3.setFixedHeight(35f); // Row heigh
				Documents_availROW1CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW1CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availROW1CELL3.setBorderWidth((float) 0.8);
				Documents_availROW1.addCell(Documents_availROW1CELL3);
				document.add(Documents_availROW1);
				///
				PdfPTable Documents_availROW2 = new PdfPTable(3);
				Documents_availROW2.setWidthPercentage(100);
				Documents_availROW2.setWidths(new float[] { 1.25f, 0.35f, 1.4f });

				PdfPCell Documents_availROW2CELL1 = new PdfPCell(
						new Phrase("Ensured the availability of AOF in DMS", Normalheader));
				Documents_availROW2CELL1.setFixedHeight(35f); // Row height
				Documents_availROW2CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW2CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availROW2CELL1.setBorderWidth((float) 0.8);
				Documents_availROW2.addCell(Documents_availROW2CELL1);

				PdfPCell Documents_availROW2CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getAof_available(), Responsesize));
				Documents_availROW2CELL2.setFixedHeight(35f); // Row height
				Documents_availROW2CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW2CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availROW2CELL2.setBorderWidth((float) 0.8);
				Documents_availROW2.addCell(Documents_availROW2CELL2);

				PdfPCell Documents_availROW2CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getAof_remarks(), Responsesize));
				Documents_availROW2CELL3.setFixedHeight(35f); // Row heigh
				Documents_availROW2CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW2CELL3.setVerticalAlignment(Element.ALIGN_TOP);
				Documents_availROW2CELL3.setBorderWidth((float) 0.8);
				Documents_availROW2.addCell(Documents_availROW2CELL3);

				document.add(Documents_availROW2);

				///
				PdfPTable Documents_availROW3 = new PdfPTable(3);
				Documents_availROW3.setWidthPercentage(100);
				Documents_availROW3.setWidths(new float[] { 1.25f, 0.35f, 1.4f });

				PdfPCell Documents_availROW3CELL1 = new PdfPCell(new Phrase(
						"Ensured availability of FATCA/CRS Declaration & KYC Docs for Entity,UBOs & Signatories in DMS",
						Normalheader));
				Documents_availROW3CELL1.setFixedHeight(35f); // Row height
				Documents_availROW3CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW3CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availROW3CELL1.setBorderWidth((float) 0.8);
				Documents_availROW3.addCell(Documents_availROW3CELL1);

				PdfPCell Documents_availROW3CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getFatca_crs_available(), Responsesize));
				Documents_availROW3CELL2.setFixedHeight(35f); // Row height
				Documents_availROW3CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW3CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availROW3CELL2.setBorderWidth((float) 0.8);
				Documents_availROW3.addCell(Documents_availROW3CELL2);

				PdfPCell Documents_availROW3CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getFatca_crs_remarks(), Responsesize));
				Documents_availROW3CELL3.setFixedHeight(35f); // Row heigh
				Documents_availROW3CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW3CELL3.setVerticalAlignment(Element.ALIGN_TOP);
				Documents_availROW3CELL3.setBorderWidth((float) 0.8);
				Documents_availROW3.addCell(Documents_availROW3CELL3);

				document.add(Documents_availROW3);

				///
				PdfPTable Documents_availROW4 = new PdfPTable(3);
				Documents_availROW4.setWidthPercentage(100);
				Documents_availROW4.setWidths(new float[] { 1.25f, 0.35f, 1.4f });

				PdfPCell Documents_availROW4CELL1 = new PdfPCell(
						new Phrase("Ensured that Source of Funds documents available in DMS", Normalheader));
				Documents_availROW4CELL1.setFixedHeight(35f); // Row height
				Documents_availROW4CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW4CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availROW4CELL1.setBorderWidth((float) 0.8);
				Documents_availROW4.addCell(Documents_availROW4CELL1);

				PdfPCell Documents_availROW4CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getSource_of_funds_available(), Responsesize));
				Documents_availROW4CELL2.setFixedHeight(35f); // Row height
				Documents_availROW4CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW4CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				Documents_availROW4CELL2.setBorderWidth((float) 0.8);
				Documents_availROW4.addCell(Documents_availROW4CELL2);

				PdfPCell Documents_availROW4CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getSource_of_funds_remarks(), Responsesize));
				Documents_availROW4CELL3.setFixedHeight(35f); // Row heigh
				Documents_availROW4CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				Documents_availROW4CELL3.setVerticalAlignment(Element.ALIGN_TOP);
				Documents_availROW4CELL3.setBorderWidth((float) 0.8);
				Documents_availROW4.addCell(Documents_availROW4CELL3);

				document.add(Documents_availROW4);

				logger.info("Entering Stage 10");
				/* *******************************************************************************************************************************************************/
				//// OBSERVATION & OTHER DUE DILIGENCE CARRIED BY THE BRANCH

				PdfPTable OBSERVATION = new PdfPTable(2);
				OBSERVATION.setWidthPercentage(100);
				OBSERVATION.setWidths(new float[] { (float) 0.2, (float) 3.8 });

				PdfPCell OBSERVATIONheader = new PdfPCell(new Phrase("10.", Normalheader));
				OBSERVATIONheader.setFixedHeight(16f); // Row height
				OBSERVATIONheader.setVerticalAlignment(Element.ALIGN_LEFT);
				OBSERVATIONheader.setVerticalAlignment(Element.ALIGN_MIDDLE);
				OBSERVATIONheader.setBorderWidth((float) 0.8);
				OBSERVATIONheader.setBackgroundColor(antiqueWhite);
				OBSERVATION.addCell(OBSERVATIONheader);

				PdfPCell OBSERVATIONheaderDESC = new PdfPCell(
						new Phrase("OBSERVATION & OTHER DUE DILIGENCE CARRIED BY THE BRANCH", Normalheader));
				OBSERVATIONheaderDESC.setFixedHeight(16f); // Row height
				OBSERVATIONheaderDESC.setVerticalAlignment(Element.ALIGN_LEFT);
				OBSERVATIONheaderDESC.setVerticalAlignment(Element.ALIGN_MIDDLE);
				OBSERVATIONheaderDESC.setBorderWidth((float) 0.8);
				OBSERVATIONheaderDESC.setBackgroundColor(antiqueWhite);
				OBSERVATION.addCell(OBSERVATIONheaderDESC);

				document.add(OBSERVATION);

				PdfPTable OBSERVATIONDESC = new PdfPTable(1);
				OBSERVATIONDESC.setWidthPercentage(100);
				OBSERVATIONDESC.setWidths(new float[] { 1 });

				PdfPCell OBSERVATIONDESCROW = new PdfPCell(
						new Phrase(EcddCorporateEntity.getObservations(), Responsesize));
				OBSERVATIONDESCROW.setFixedHeight(75f); // Row height
				OBSERVATIONDESCROW.setVerticalAlignment(Element.ALIGN_LEFT);
				OBSERVATIONDESCROW.setVerticalAlignment(Element.ALIGN_TOP);
				OBSERVATIONDESCROW.setBorderWidth((float) 0.8);
				OBSERVATIONDESC.addCell(OBSERVATIONDESCROW);

				document.add(OBSERVATIONDESC);
				document.add(Manualspace);

				/* *******************************************************************************************************************************************************/
				//// BRANCH AND REVIEWER & APPROVER

				PdfPTable REVIEW_APPR = new PdfPTable(1);
				REVIEW_APPR.setWidthPercentage(100);
				REVIEW_APPR.setWidths(new float[] { 1 });

				PdfPCell REVIEW_APPRheaderDESC = new PdfPCell(new Phrase("BRANCH - Reviewer & Approver", Normalheader));
				REVIEW_APPRheaderDESC.setFixedHeight(16f); // Row height
				REVIEW_APPRheaderDESC.setVerticalAlignment(Element.ALIGN_LEFT);
				REVIEW_APPRheaderDESC.setVerticalAlignment(Element.ALIGN_MIDDLE);
				REVIEW_APPRheaderDESC.setBorderWidth((float) 0.8);
				REVIEW_APPRheaderDESC.setBackgroundColor(antiqueWhite);
				REVIEW_APPR.addCell(REVIEW_APPRheaderDESC);

				document.add(REVIEW_APPR);

				PdfPTable OBSERVATIONDESCROW1 = new PdfPTable(3);
				OBSERVATIONDESCROW1.setWidthPercentage(100);
				OBSERVATIONDESCROW1.setWidths(new float[] { 1, 1,1 });

				String reviewDateStr = EcddCorporateEntity.getReview_date() != null
						? new SimpleDateFormat("dd/MM/yyyy").format(EcddCorporateEntity.getReview_date())
						: "";

				PdfPCell OBSERVATIONDESCROW1CELL1 = new PdfPCell(
						new Phrase("Review Date : " + reviewDateStr, Responsesize));
				OBSERVATIONDESCROW1CELL1.setMinimumHeight(15f);
				OBSERVATIONDESCROW1CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				OBSERVATIONDESCROW1CELL1.setBorderWidth(0.8f);
				OBSERVATIONDESCROW1CELL1.setBorderWidthBottom(0);
				OBSERVATIONDESCROW1.addCell(OBSERVATIONDESCROW1CELL1);

				String approvalDateStr = EcddCorporateEntity.getApproval_date() != null
						? new SimpleDateFormat("dd/MM/yyyy").format(EcddCorporateEntity.getApproval_date())
						: "";

				PdfPCell OBSERVATIONDESCROW1CELL2 = new PdfPCell(
						new Phrase("Approval Date : " + approvalDateStr, Responsesize));
				OBSERVATIONDESCROW1CELL2.setMinimumHeight(15f);
				OBSERVATIONDESCROW1CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				OBSERVATIONDESCROW1CELL2.setBorderWidth(0.8f);
				OBSERVATIONDESCROW1CELL2.setBorderWidthBottom(0);
				OBSERVATIONDESCROW1.addCell(OBSERVATIONDESCROW1CELL2);
				
				PdfPCell OBSERVATIONDESCROW1CELL3 = new PdfPCell(
						new Phrase("Branch Head/Operation Head", Responsesize));
				OBSERVATIONDESCROW1CELL3.setMinimumHeight(15f);
				OBSERVATIONDESCROW1CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				OBSERVATIONDESCROW1CELL3.setBorderWidth(0.8f);
				OBSERVATIONDESCROW1CELL3.setBorderWidthBottom(0);
				OBSERVATIONDESCROW1.addCell(OBSERVATIONDESCROW1CELL3);

				document.add(OBSERVATIONDESCROW1);

				PdfPTable OBSERVATIONDESCROW2 = new PdfPTable(3);
				OBSERVATIONDESCROW2.setWidthPercentage(100);
				OBSERVATIONDESCROW2.setWidths(new float[] { 1, 1,1 });

				// Reviewed By Phrase
				Phrase reviewedPhrase = new Phrase();
				reviewedPhrase.add(new Chunk("Reviewed By:\n", Responsesize));
				reviewedPhrase.add(new Chunk("Name        : "
						+ (EcddCorporateEntity.getReviewed_by_name() != null ? EcddCorporateEntity.getReviewed_by_name()
								: "")
						+ "\n", Responsesize));
				reviewedPhrase.add(new Chunk("EC No       : " + (EcddCorporateEntity.getReviewed_by_ec_no() != null
						? EcddCorporateEntity.getReviewed_by_ec_no()
						: "") + "\n", Responsesize));
				reviewedPhrase
						.add(new Chunk("Designation : " + (EcddCorporateEntity.getReviewed_by_designation() != null
								? EcddCorporateEntity.getReviewed_by_designation()
								: ""), Responsesize));

				PdfPCell OBSERVATIONDESCROW2CELL1 = new PdfPCell(reviewedPhrase);
				OBSERVATIONDESCROW2CELL1.setFixedHeight(50f);
				OBSERVATIONDESCROW2CELL1.setVerticalAlignment(Element.ALIGN_TOP);
				OBSERVATIONDESCROW2CELL1.setPadding(5f);
				OBSERVATIONDESCROW2CELL1.setBorderWidth(0.8f);
				OBSERVATIONDESCROW2CELL1.setBorderWidthBottom(0);
				OBSERVATIONDESCROW2CELL1.setBorderWidthTop(0);
				OBSERVATIONDESCROW2.addCell(OBSERVATIONDESCROW2CELL1);

				// Approved By Phrase
				Phrase approvedPhrase = new Phrase();
				approvedPhrase.add(new Chunk("Approved By:\n", Responsesize));
				approvedPhrase.add(new Chunk("Name        : "
						+ (EcddCorporateEntity.getApproved_by_name() != null ? EcddCorporateEntity.getApproved_by_name()
								: "")
						+ "\n", Responsesize));
				approvedPhrase.add(new Chunk("EC No       : " + (EcddCorporateEntity.getApproved_by_ec_no() != null
						? EcddCorporateEntity.getApproved_by_ec_no()
						: "") + "\n", Responsesize));
				approvedPhrase
						.add(new Chunk("Designation : " + (EcddCorporateEntity.getApproved_by_designation() != null
								? EcddCorporateEntity.getApproved_by_designation()
								: ""), Responsesize));

				PdfPCell OBSERVATIONDESCROW2CELL2 = new PdfPCell(approvedPhrase);
				OBSERVATIONDESCROW2CELL2.setFixedHeight(50f);
				OBSERVATIONDESCROW2CELL2.setVerticalAlignment(Element.ALIGN_TOP);
				OBSERVATIONDESCROW2CELL2.setPadding(5f);
				OBSERVATIONDESCROW2CELL2.setBorderWidth(0.8f);
				OBSERVATIONDESCROW2CELL2.setBorderWidthBottom(0);
				OBSERVATIONDESCROW2CELL2.setBorderWidthTop(0);
				OBSERVATIONDESCROW2.addCell(OBSERVATIONDESCROW2CELL2);
				
				PdfPCell OBSERVATIONDESCROW2CELL3 = new PdfPCell();
				OBSERVATIONDESCROW2CELL3.setFixedHeight(50f);
				OBSERVATIONDESCROW2CELL3.setVerticalAlignment(Element.ALIGN_TOP);
				OBSERVATIONDESCROW2CELL3.setPadding(5f);
				OBSERVATIONDESCROW2CELL3.setBorderWidth(0.8f);
				OBSERVATIONDESCROW2CELL3.setBorderWidthBottom(0);
				OBSERVATIONDESCROW2CELL3.setBorderWidthTop(0);
				OBSERVATIONDESCROW2.addCell(OBSERVATIONDESCROW2CELL3);

				document.add(OBSERVATIONDESCROW2);

				////
				PdfPTable OBSERVATIONDESCROW3 = new PdfPTable(3);
				OBSERVATIONDESCROW3.setWidthPercentage(100);
				OBSERVATIONDESCROW3.setWidths(new float[] { 1, 1,1 });

				PdfPCell OBSERVATIONDESCROW3CELL1 = new PdfPCell(
						new Phrase("Branch -" + EcddCorporateEntity.getBranch_name(), Responsesize));
				OBSERVATIONDESCROW3CELL1.setFixedHeight(25f); // Row height
				OBSERVATIONDESCROW3CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				OBSERVATIONDESCROW3CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				OBSERVATIONDESCROW3CELL1.setBorderWidth((float) 0.8);
				OBSERVATIONDESCROW3CELL1.setBorderWidthTop(0);
				OBSERVATIONDESCROW3.addCell(OBSERVATIONDESCROW3CELL1);

				PdfPCell OBSERVATIONDESCROW3CELL2 = new PdfPCell(new Phrase());
				OBSERVATIONDESCROW3CELL2.setFixedHeight(25f); // Row height
				OBSERVATIONDESCROW3CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				OBSERVATIONDESCROW3CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				OBSERVATIONDESCROW3CELL2.setBorderWidth((float) 0.8);
				OBSERVATIONDESCROW3CELL2.setBorderWidthTop(0);
				OBSERVATIONDESCROW3.addCell(OBSERVATIONDESCROW3CELL2);
				
				PdfPCell OBSERVATIONDESCROW3CELL3 = new PdfPCell(new Phrase("Name & Signature"));
				OBSERVATIONDESCROW3CELL3.setFixedHeight(25f); // Row height
				OBSERVATIONDESCROW3CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				OBSERVATIONDESCROW3CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				OBSERVATIONDESCROW3CELL3.setBorderWidth((float) 0.8);
				OBSERVATIONDESCROW3CELL3.setBorderWidthTop(0);
				OBSERVATIONDESCROW3.addCell(OBSERVATIONDESCROW3CELL3);

				document.add(OBSERVATIONDESCROW3);

				document.add(Manualspace);
				/* *******************************************************************************************************************************************************/
				//// FINACLEDATES

				PdfPTable FINACLEDATES = new PdfPTable(3);
				FINACLEDATES.setWidthPercentage(100);
				FINACLEDATES.setWidths(new float[] { 1, 1, 1 });

				PdfPCell FINACLEDATESROW1CELL1 = new PdfPCell(new Phrase("", Normalheader));
				FINACLEDATESROW1CELL1.setFixedHeight(16f); // Row height
				FINACLEDATESROW1CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				FINACLEDATESROW1CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				FINACLEDATESROW1CELL1.setBorderWidth((float) 0.8);
				FINACLEDATES.addCell(FINACLEDATESROW1CELL1);

				PdfPCell FINACLEDATESROW1CELL2 = new PdfPCell(new Phrase("Date", Normalheader));
				FINACLEDATESROW1CELL2.setFixedHeight(16f); // Row height
				FINACLEDATESROW1CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				FINACLEDATESROW1CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				FINACLEDATESROW1CELL2.setBorderWidth((float) 0.8);
				FINACLEDATES.addCell(FINACLEDATESROW1CELL2);

				PdfPCell FINACLEDATESROW1CELL3 = new PdfPCell(new Phrase("Name of the Employee", Normalheader));
				FINACLEDATESROW1CELL3.setFixedHeight(16f); // Row height
				FINACLEDATESROW1CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				FINACLEDATESROW1CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				FINACLEDATESROW1CELL3.setBorderWidth((float) 0.8);
				FINACLEDATES.addCell(FINACLEDATESROW1CELL3);

				document.add(FINACLEDATES);
				//
				PdfPTable FINACLEDATESROW2 = new PdfPTable(3);
				FINACLEDATESROW2.setWidthPercentage(100);
				FINACLEDATESROW2.setWidths(new float[] { 1, 1, 1 });

				PdfPCell FINACLEDATESROW2CELL1 = new PdfPCell(new Phrase("Data Entered in Finacle", Normalheader));
				FINACLEDATESROW2CELL1.setFixedHeight(16f); // Row height
				FINACLEDATESROW2CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				FINACLEDATESROW2CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				FINACLEDATESROW2CELL1.setBorderWidth((float) 0.8);
				FINACLEDATESROW2.addCell(FINACLEDATESROW2CELL1);

				PdfPCell FINACLEDATESROW2CELL2 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getData_entry_date() != null
								? new SimpleDateFormat("dd/MM/yyyy").format(EcddCorporateEntity.getData_entry_date())
								: "", Responsesize));
				FINACLEDATESROW2CELL2.setFixedHeight(16f); // Row height
				FINACLEDATESROW2CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				FINACLEDATESROW2CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				FINACLEDATESROW2CELL2.setBorderWidth((float) 0.8);
				FINACLEDATESROW2.addCell(FINACLEDATESROW2CELL2);

				PdfPCell FINACLEDATESROW2CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getData_entry_employee_name(), Normalheader));
				FINACLEDATESROW2CELL3.setFixedHeight(16f); // Row height
				FINACLEDATESROW2CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				FINACLEDATESROW2CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				FINACLEDATESROW2CELL3.setBorderWidth((float) 0.8);
				FINACLEDATESROW2.addCell(FINACLEDATESROW2CELL3);

				document.add(FINACLEDATESROW2);

				////
				PdfPTable FINACLEDATESROW3 = new PdfPTable(3);
				FINACLEDATESROW3.setWidthPercentage(100);
				FINACLEDATESROW3.setWidths(new float[] { 1, 1, 1 });

				PdfPCell FINACLEDATESROW3CELL1 = new PdfPCell(new Phrase("Document(s) Uploaded in DMS", Normalheader));
				FINACLEDATESROW3CELL1.setFixedHeight(16f); // Row height
				FINACLEDATESROW3CELL1.setVerticalAlignment(Element.ALIGN_LEFT);
				FINACLEDATESROW3CELL1.setVerticalAlignment(Element.ALIGN_MIDDLE);
				FINACLEDATESROW3CELL1.setBorderWidth((float) 0.8);
				FINACLEDATESROW3.addCell(FINACLEDATESROW3CELL1);

				PdfPCell FINACLEDATESROW3CELL2 = new PdfPCell(
						new Phrase(
								EcddCorporateEntity.getDocument_uploaded_date() != null
										? new SimpleDateFormat("dd/MM/yyyy")
												.format(EcddCorporateEntity.getDocument_uploaded_date())
										: "",
								Responsesize));
				FINACLEDATESROW3CELL2.setFixedHeight(16f); // Row height
				FINACLEDATESROW3CELL2.setVerticalAlignment(Element.ALIGN_LEFT);
				FINACLEDATESROW3CELL2.setVerticalAlignment(Element.ALIGN_MIDDLE);
				FINACLEDATESROW3CELL2.setBorderWidth((float) 0.8);
				FINACLEDATESROW3.addCell(FINACLEDATESROW3CELL2);

				PdfPCell FINACLEDATESROW3CELL3 = new PdfPCell(
						new Phrase(EcddCorporateEntity.getDocument_uploaded_employee_name(), Normalheader));
				FINACLEDATESROW3CELL3.setFixedHeight(16f); // Row height
				FINACLEDATESROW3CELL3.setVerticalAlignment(Element.ALIGN_LEFT);
				FINACLEDATESROW3CELL3.setVerticalAlignment(Element.ALIGN_MIDDLE);
				FINACLEDATESROW3CELL3.setBorderWidth((float) 0.8);
				FINACLEDATESROW3.addCell(FINACLEDATESROW3CELL3);

				document.add(FINACLEDATESROW3);
				Font FootnoteFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, Font.ITALIC);
				Paragraph confirmationNote = new Paragraph(
						"I confirm that I have done screening of All Account holders & kept on record.", FootnoteFont);
				confirmationNote.setAlignment(Element.ALIGN_CENTER);
				confirmationNote.setSpacingAfter(15f);
				document.add(confirmationNote);

				// 2. NOW, create and add the "Branch to ensure..." paragraph.
				Paragraph Branch2 = new Paragraph(
						"Branch to ensure updating the data in CBS with latest details & upload documents in DMS",
						Responsesize);
				Branch2.setAlignment(Element.ALIGN_CENTER);
				document.add(Branch2);

				/*
				 * /// add water mark logger.info("Enter Final Stage"); Image img1 =
				 * Image.getInstance("src/main/resources/static/images/client_Logo_bkp.png");
				 * img1.scaleAbsolute(150, 150);
				 * 
				 * PdfContentByte canvas1 = writer.getDirectContentUnder(); PdfGState gs11 = new
				 * PdfGState(); gs11.setFillOpacity(0.2f); canvas1.saveState();
				 * canvas1.setGState(gs11);
				 * 
				 * float centerX1 = (document.getPageSize().getWidth() - img1.getScaledWidth())
				 * / 2; float centerY1 = (document.getPageSize().getHeight() -
				 * img1.getScaledHeight()) / 2; img1.setAbsolutePosition(centerX1, centerY1);
				 * 
				 * canvas1.addImage(img1); canvas1.restoreState();
				 */

				document.close(); /// close the file after all the work completed

				// Generate audit entry
				String auditID = sequence.generateRequestUUId();
				String user1 = (String) req.getSession().getAttribute("USERID");
				String username = (String) req.getSession().getAttribute("USERNAME");

				// Create and populate audit entity
				KYC_Audit_Entity audit = new KYC_Audit_Entity();
				Date currentDate = new Date();
				audit.setAudit_date(currentDate);
				audit.setEntry_time(currentDate);
				audit.setEntry_user(user1);
				audit.setEntry_user_name(username);
				audit.setFunc_code("Download");
				audit.setAudit_table("Kyc_corporate");
				audit.setAudit_screen("Modify");
				audit.setEvent_id(user1);
				audit.setEvent_name(username);
				audit.setModi_details(
						EcddCorporateEntity.getCustomer_id() + " - Document downloaded by user - " + user1);

				audit.setAudit_ref_no(auditID);

				// Save audit entity
				KYC_Audit_Rep.save(audit);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return outputFile;

	}

	private static PdfPCell createCell(String text, Font font) {
		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setFixedHeight(16f);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setBorderWidth((float) 0.8);
		return cell;
	}
	
	public String uploadrelateddocs(MultipartFile Securityfile,String Userid) {
		return Userid;
		
	}

}
