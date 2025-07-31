package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.BRBS.EcddIndividualProfileRepository;
import com.bornfire.xbrl.entities.BRBS.Ecdd_Individual_Profile_Entity;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class IndividualPdfService {

	private static final Logger logger = LoggerFactory.getLogger(IndividualPdfService.class);

	@Autowired
	private EcddIndividualProfileRepository individualProfileRepo;

	@Autowired
	private Environment env;

	// --- Custom Fonts and Colors for PDF content ---
	private static BaseFont TIMES_NORMAL;
	private static BaseFont TIMES_BOLD;

	static {
		try {
			// Ensure times.ttf and timesbd.ttf are in src/main/resources/fonts
			TIMES_NORMAL = BaseFont.createFont("fonts/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			TIMES_BOLD = BaseFont.createFont("fonts/timesbd.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		} catch (Exception e) {
			logger.error("Error loading custom Times New Roman fonts. Falling back to default.", e);
			// Fallback to default fonts if custom ones are not found
			TIMES_NORMAL = new Font(Font.FontFamily.TIMES_ROMAN).getBaseFont();
			TIMES_BOLD = new Font(Font.FontFamily.TIMES_ROMAN, 1, Font.BOLD).getBaseFont();
		}
	}

	// --- Define color palette from the PDF ---
	private static final BaseColor COLOR_PALE_ORANGE_BG = new BaseColor(250, 219, 197); // #FADBC5

	// --- Define font styles from the PDF ---
	private static final Font FONT_TITLE = new Font(TIMES_BOLD, 12, Font.BOLD, BaseColor.BLACK);
	private static final Font FONT_SECTION_HEADER = new Font(TIMES_BOLD, 10, Font.BOLD, BaseColor.BLACK);
	private static final Font FONT_COLUMN_HEADER = new Font(TIMES_BOLD, 8, Font.BOLD, BaseColor.BLACK);
	private static final Font FONT_PLAIN_LABEL = new Font(TIMES_NORMAL, 8, Font.BOLD, BaseColor.BLACK);
	private static final Font FONT_DATA = new Font(TIMES_NORMAL, 8, Font.NORMAL, BaseColor.BLACK);
	private static final Font FONT_FOOTER = new Font(TIMES_NORMAL, 8, Font.NORMAL, BaseColor.BLACK);

	public File generateIndividualPdf(String srlno, HttpServletRequest req) throws Exception {
		Optional<Ecdd_Individual_Profile_Entity> optionalKyc = individualProfileRepo.findById(srlno);

		if (!optionalKyc.isPresent()) {
			throw new FileNotFoundException("ECDD Individual Profile with srlno " + srlno + " not found.");
		}

		Ecdd_Individual_Profile_Entity entity = optionalKyc.get();
		String filename = entity.getCustomer_id() != null ? entity.getCustomer_id() : "ECDD_INDIVIDUAL_FORM";
		String filepath = env.getProperty("output.exportpathfinal", "/tmp/");
		File outputFile = new File(filepath + filename + ".pdf");

		Document document = new Document(PageSize.A4);
		PdfWriter writer = null;

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(outputFile));

			// Assign the event helper to manage headers, footers, and watermarks
			HeaderFooterPageEvent eventHelper = new HeaderFooterPageEvent(entity);
			writer.setPageEvent(eventHelper);

			document.open();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			// ========================================================================
			// PAGE 1 CONTENT
			// ========================================================================

			// --- Section 1: OTHER ACCOUNT DETAILS ---
			PdfPTable otherDetailsTable = new PdfPTable(4);
			otherDetailsTable.setWidthPercentage(100);
			otherDetailsTable.setWidths(new float[] { 3f, 3.5f, 2.5f, 3.5f });
			otherDetailsTable.addCell(createSectionHeader("1. OTHER ACCOUNT DETAILS", 4));
			otherDetailsTable.addCell(createCell("Currency", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			otherDetailsTable.addCell(createCell(nvl(entity.getCurrency()), FONT_DATA, Element.ALIGN_LEFT));
			otherDetailsTable.addCell(createCell("Account Opening Date", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			otherDetailsTable
					.addCell(createCell(formatDate(entity.getAccount_open_date(), sdf), FONT_DATA, Element.ALIGN_LEFT));
			PdfPCell approvalCell = createCell("Approval obtained in case of currency other than AED)",
					FONT_PLAIN_LABEL, Element.ALIGN_LEFT);
			approvalCell.setColspan(3);
			otherDetailsTable.addCell(approvalCell);
			otherDetailsTable.addCell(createCell(nvl(entity.getCurrency_approval_yn()), FONT_DATA, Element.ALIGN_LEFT));
			document.add(otherDetailsTable);

			// --- Sections 2, 3, 4 ---
			PdfPTable holdersTable = new PdfPTable(5);
			holdersTable.setWidthPercentage(100);
			holdersTable.setWidths(new float[] { 2.5f, 2.5f, 2.5f, 2.5f, 2.5f });

			// Section 2
			holdersTable.addCell(createSectionHeader("2. ACCOUNT HOLDERS' INFORMATION", 5));
			holdersTable.addCell(createCell("", FONT_COLUMN_HEADER, Element.ALIGN_CENTER)); // Empty label cell, with
																							// border
			holdersTable.addCell(createCell("PRIMARY A/C HOLDER", FONT_COLUMN_HEADER, Element.ALIGN_LEFT));
			holdersTable.addCell(createCell("JOINT HOLDER 1", FONT_COLUMN_HEADER, Element.ALIGN_LEFT));
			holdersTable.addCell(createCell("JOINT HOLDER 2", FONT_COLUMN_HEADER, Element.ALIGN_LEFT));
			holdersTable.addCell(createCell("JOINT HOLDER 3", FONT_COLUMN_HEADER, Element.ALIGN_LEFT));

			addHolderRow(holdersTable, "Name", entity.getPrimary_holder_name(), entity.getJoint1_name(),
					entity.getJoint2_name(), entity.getJoint3_name());
			addHolderRow(holdersTable, "Customer ID", entity.getPrimary_customer_id(), entity.getJoint1_customer_id(),
					entity.getJoint2_customer_id(), entity.getJoint3_customer_id());
			addHolderRow(holdersTable, "Non Resident (Y/N)", entity.getPrimary_non_resident_yn(),
					entity.getJoint1_non_resident_yn(), entity.getJoint2_non_resident_yn(),
					entity.getJoint3_non_resident_yn());
			addHolderRow(holdersTable, "Nationality", entity.getPrimary_nationality(), entity.getJoint1_nationality(),
					entity.getJoint2_nationality(), entity.getJoint3_nationality());
			addHolderRow(holdersTable, "Mobile Number", entity.getPrimary_mobile_no(), entity.getJoint1_mobile_no(),
					entity.getJoint2_mobile_no(), entity.getJoint3_mobile_no());
			addHolderRow(holdersTable, "Email Address", entity.getPrimary_email(), entity.getJoint1_email(),
					entity.getJoint2_email(), entity.getJoint3_email());
			addHolderRow(holdersTable, "Address", entity.getPrimary_address(), entity.getJoint1_address(),
					entity.getJoint2_address(), entity.getJoint3_address());
			addHolderRow(holdersTable, "Latest Passport No.", entity.getPrimary_passport_no(),
					entity.getJoint1_passport_no(), entity.getJoint2_passport_no(), entity.getJoint3_passport_no());
			addHolderRowDate(holdersTable, "Passport Exp. Date", entity.getPrimary_passport_exp_date(),
					entity.getJoint1_passport_exp_date(), entity.getJoint2_passport_exp_date(),
					entity.getJoint3_passport_exp_date(), sdf);
			addHolderRow(holdersTable, "Emirates ID No", entity.getPrimary_emirates_id_no(),
					entity.getJoint1_emirates_id_no(), entity.getJoint2_emirates_id_no(),
					entity.getJoint3_emirates_id_no());
			addHolderRowDate(holdersTable, "EID Expiry Date", entity.getPrimary_emirates_exp_date(),
					entity.getJoint1_emirates_exp_date(), entity.getJoint2_emirates_exp_date(),
					entity.getJoint3_emirates_exp_date(), sdf);
			addHolderRow(holdersTable, "PEP Status (Y/N)", entity.getPrimary_pep_yn(), entity.getJoint1_pep_yn(),
					entity.getJoint2_pep_yn(), entity.getJoint3_pep_yn());
			addHolderRow(holdersTable, "Approval if PEP as 'Yes'", entity.getPrimary_pep_approval(),
					entity.getJoint1_pep_approval(), entity.getJoint2_pep_approval(), entity.getJoint3_pep_approval());

			// Section 3
			holdersTable.addCell(createSectionHeader("3. DUE DILLIGENCE / SCREENING REPORTS", 5));
			addHolderRow(holdersTable, "Google (Yes/No)", entity.getScreen_google_primary(),
					entity.getScreen_google_joint1(), entity.getScreen_google_joint2(),
					entity.getScreen_google_joint3());
			addHolderRow(holdersTable, "Dow-Jones (Yes/No)", entity.getScreen_dowjones_primary(),
					entity.getScreen_dowjones_joint1(), entity.getScreen_dowjones_joint2(),
					entity.getScreen_dowjones_joint3());
			holdersTable
					.addCell(createCell("Br. Remarks (If any adverse found)", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			PdfPCell remarksCell = createCell(nvl(entity.getBranch_remarks()), FONT_DATA, Element.ALIGN_LEFT);
			remarksCell.setColspan(4);
			holdersTable.addCell(remarksCell);

			// Section 4
			holdersTable.addCell(createSectionHeader("4. RISK ASSESSMENT", 5));
			addHolderRow(holdersTable, "KYC Valid (Y/N)", entity.getKyc_valid_yn_primary(),
					entity.getKyc_valid_yn_joint1(), entity.getKyc_valid_yn_joint2(), entity.getKyc_valid_yn_joint3());
			addHolderRow(holdersTable, "Annual Income", nvl(entity.getAnnual_income_primary()),
					nvl(entity.getAnnual_income_joint1()), nvl(entity.getAnnual_income_joint2()),
					nvl(entity.getAnnual_income_joint3()));
			addHolderRow(holdersTable, "Source of Income", entity.getSource_of_income_primary(),
					entity.getSource_of_income_joint1(), entity.getSource_of_income_joint2(),
					entity.getSource_of_income_joint3());
			document.add(holdersTable);

			// ========================================================================
			// START: REBUILT SECTION 5 - ALL BORDERED CELLS
			// ========================================================================

			// --- Main container for all of Section 5 ---
			PdfPTable section5Container = new PdfPTable(1);
			section5Container.setWidthPercentage(100);
			// section5Container.setSpacingBefore(5f);

			// Add the orange header for the whole section
			section5Container.addCell(createSectionHeader("5. TRANSACTION MONITORING", 1));

			// --- Block for Transaction History and Conduct of Account ---
			PdfPTable remarksTable = new PdfPTable(1);
			remarksTable.setWidthPercentage(100);
			PdfPCell historyLabelCell = createCellWithHeight(
					"Transaction History (Details of unusual or suspicious transactions over the past 12 months if noticed)",
					FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f);
			historyLabelCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
			remarksTable.addCell(historyLabelCell);
			PdfPCell historyDataCell = createCellWithTopAlignment(nvl(entity.getUnusual_txn_details()), FONT_DATA,
					Element.ALIGN_LEFT, 25f);
			historyDataCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
			remarksTable.addCell(historyDataCell);
			PdfPCell conductLabelCell = createCellWithHeight(
					"Conduct of the account (Any suspicious activity or risk indicators or ISTR filed during ECDD period)",
					FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f);
			conductLabelCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
			remarksTable.addCell(conductLabelCell);
			PdfPCell conductDataCell = createCellWithTopAlignment(nvl(entity.getSuspicious_activity()), FONT_DATA,
					Element.ALIGN_LEFT, 25f);
			conductDataCell.setBorder(Rectangle.LEFT | Rectangle.RIGHT | Rectangle.TOP | Rectangle.BOTTOM);
			remarksTable.addCell(conductDataCell);

			// Add this block into the main container
			section5Container.addCell(createCellWithTable(remarksTable, Rectangle.NO_BORDER)); // Add table without
																								// extra cell borders

			// --- Block for High Value, Frequency, and Volume Grids ---
			// This will be a single table with a complex structure to ensure all borders
			// are correct
			PdfPTable gridContainerTable = new PdfPTable(7);
			gridContainerTable.setWidthPercentage(100);
			gridContainerTable.setWidths(new float[] { 2.5f, 1.25f, 1.25f, 1.25f, 1.75f, 1f, 1f });

			// Row 1: High Value Transaction Monitoring
			PdfPCell highValueTitleCell = createCell("High Value Transaction Monitoring (Above 500 thousand)",
					FONT_COLUMN_HEADER, Element.ALIGN_LEFT);
			highValueTitleCell.setColspan(2);
			gridContainerTable.addCell(highValueTitleCell);
			gridContainerTable.addCell(createCell("No. of Transaction", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			gridContainerTable
					.addCell(createCell(nvl(entity.getHigh_value_txn_count()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell("Volume", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			PdfPCell highValueVolumeCell = createCell(nvl(entity.getHigh_value_txn_volume()), FONT_DATA,
					Element.ALIGN_CENTER);
			highValueVolumeCell.setColspan(2);
			gridContainerTable.addCell(highValueVolumeCell);

			// Row 2: Frequency and Volume Header
			PdfPCell freqTitle = createCell(
					"Frequency and Volume of transactions During The Period (% w.r.t Annual Turnover)",
					FONT_COLUMN_HEADER, Element.ALIGN_LEFT);
			freqTitle.setColspan(5);
			gridContainerTable.addCell(freqTitle);
			// This is the CORRECTED version
			// Use the helper method that takes font, alignment, and colspan
			PdfPCell turnoverTitle = createCell("No. of Transaction & Turnover", FONT_COLUMN_HEADER,
					Element.ALIGN_CENTER, 2);
			gridContainerTable.addCell(turnoverTitle);

			// Row 3: Grid Column Headers
			gridContainerTable.addCell(createCell("", FONT_COLUMN_HEADER, Element.ALIGN_CENTER)); // Empty corner
			gridContainerTable.addCell(createCell("Cash", FONT_COLUMN_HEADER, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell("Cheque", FONT_COLUMN_HEADER, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell("Local transfer", FONT_COLUMN_HEADER, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell("International Transfer", FONT_COLUMN_HEADER, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell("Current", FONT_COLUMN_HEADER, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell("Expected", FONT_COLUMN_HEADER, Element.ALIGN_CENTER));

			// Row 4: No. of Transaction (%) Data
			gridContainerTable.addCell(createCell("No. of Transaction (%)", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			gridContainerTable.addCell(createCell(nvl(entity.getCash_txn_count()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell(nvl(entity.getCheque_txn_count()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell(nvl(entity.getLocal_txn_count()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell(nvl(entity.getIntl_txn_count()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell(nvl(entity.getCurr_txn_count()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable
					.addCell(createCell(nvl(entity.getExpected_txn_count()), FONT_DATA, Element.ALIGN_CENTER));

			// Row 5: Volume (%) Data
			gridContainerTable.addCell(createCell("Volume (%)", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			gridContainerTable.addCell(createCell(nvl(entity.getCash_txn_volume()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell(nvl(entity.getCheque_txn_volume()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell(nvl(entity.getLocal_txn_volume()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell(nvl(entity.getIntl_txn_volume()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable.addCell(createCell(nvl(entity.getCurr_txn_volume()), FONT_DATA, Element.ALIGN_CENTER));
			gridContainerTable
					.addCell(createCell(nvl(entity.getExpected_txn_volume()), FONT_DATA, Element.ALIGN_CENTER));

			// Add this grid block into the main container
			section5Container.addCell(createCellWithTable(gridContainerTable, Rectangle.NO_BORDER));

			// Add the entire Section 5 to the document
			document.add(section5Container);

			// ========================================================================
			// PAGE 2 CONTENT
			// ========================================================================
			document.newPage();

			PdfPTable commensurateTable = new PdfPTable(2);
			commensurateTable.setWidthPercentage(100);
			commensurateTable.setWidths(new float[] { 9f, 1f });

			commensurateTable
					.addCell(createCell("Transactions in the account commensurate with customer profile – Yes/No",
							FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			commensurateTable.addCell(createCell(nvl(entity.getProfile_match_yn()), FONT_DATA, Element.ALIGN_LEFT));

			PdfPCell commensurateRemarksCell = createCellWithTopAlignment(
					"(if No, please provide your justification, recommendations, and comments)\n"
							+ nvl(entity.getProfile_mismatch_remarks()),
					FONT_DATA, Element.ALIGN_LEFT, 35f);
			commensurateRemarksCell.setColspan(2);
			commensurateTable.addCell(commensurateRemarksCell);
			document.add(commensurateTable);

			// --- Section 6: Customer Risk & Reason ---
			PdfPTable riskTable = new PdfPTable(2);
			riskTable.setWidthPercentage(100);
			riskTable.setWidths(new float[] { 2f, 8f });
			riskTable.addCell(createSectionHeader("6. CUSTOMER RISK & REASON FOR RISK CATEGORIZATION (AS PER CRA)", 2));

			// Header Row
			riskTable.addCell(createCell("System Risk", FONT_COLUMN_HEADER, Element.ALIGN_LEFT));
			riskTable.addCell(createCell(
					"Reason for categorizing customer as high risk (Any downgrade from system-driven risk must be approved by Territory Compliance Department)",
					FONT_COLUMN_HEADER, Element.ALIGN_LEFT));

			// Content Rows with Rowspan
			PdfPCell reasonCell = createCellWithTopAlignment(nvl(entity.getCustomer_risk_reason()), FONT_DATA,
					Element.ALIGN_LEFT, 60f);
			reasonCell.setRowspan(3);

			// CORRECTED: Using FONT_PLAIN_LABEL for High, Medium, Low to make them bold
			if (entity.getSystem_risk().equals("High")) {
				riskTable.addCell(createCellWithHeight("High", FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f));
				riskTable.addCell(reasonCell);
				riskTable.addCell(createCellWithHeight("", FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f));
				riskTable.addCell(createCellWithHeight("", FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f));
				document.add(riskTable);
			} else if (entity.getSystem_risk().equals("Medium")) {
				riskTable.addCell(createCellWithHeight("", FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f));
				riskTable.addCell(reasonCell);
				riskTable.addCell(createCellWithHeight("Medium", FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f));
				riskTable.addCell(createCellWithHeight("", FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f));
				document.add(riskTable);
			} else if (entity.getSystem_risk().equals("Low")) {
				riskTable.addCell(createCellWithHeight("", FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f));
				riskTable.addCell(reasonCell);
				riskTable.addCell(createCellWithHeight("", FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f));
				riskTable.addCell(createCellWithHeight("Low", FONT_PLAIN_LABEL, Element.ALIGN_LEFT, 20f));
				document.add(riskTable);
			}

			// --- Section 7: Documents Availability ---
			PdfPTable docsTable = new PdfPTable(3);
			docsTable.setWidthPercentage(100);
			docsTable.setWidths(new float[] { 5f, 1.5f, 5f });
			docsTable.addCell(createSectionHeader("7. Documents Availability in DMS", 3));
			docsTable.addCell(createCell("AOF and FATCA / CRS & Others", FONT_COLUMN_HEADER, Element.ALIGN_LEFT));
			docsTable.addCell(createCell("Availability Check (Yes/No)", FONT_COLUMN_HEADER, Element.ALIGN_CENTER));
			docsTable.addCell(
					createCell("Remarks (Details of action initiated, in case of Non-availability of said document)",
							FONT_COLUMN_HEADER, Element.ALIGN_CENTER));
			docsTable.addCell(
					createCell("Ensured the availability of Latest AOF in DMS", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			docsTable.addCell(createCell(nvl(entity.getAof_available_yn()), FONT_DATA, Element.ALIGN_CENTER));
			docsTable.addCell(createCell(nvl(entity.getAof_remarks()), FONT_DATA, Element.ALIGN_LEFT));
			docsTable.addCell(
					createCell("Ensured availability of FATCA/CRS Declaration & KYC Docs for All the Holders in DMS",
							FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			docsTable.addCell(createCell(nvl(entity.getKyc_doc_available_yn()), FONT_DATA, Element.ALIGN_CENTER));
			docsTable.addCell(createCell(nvl(entity.getKyc_doc_remarks()), FONT_DATA, Element.ALIGN_LEFT));
			docsTable.addCell(createCell("Ensured that Source of Funds documents available in DMS", FONT_PLAIN_LABEL,
					Element.ALIGN_LEFT));
			docsTable.addCell(
					createCell(nvl(entity.getSource_of_funds_available_yn()), FONT_DATA, Element.ALIGN_CENTER));
			docsTable.addCell(createCell(nvl(entity.getSource_of_funds_remarks()), FONT_DATA, Element.ALIGN_LEFT));
			document.add(docsTable);

			// --- Section 8: Observation ---
			PdfPTable observationTable = new PdfPTable(1);
			observationTable.setWidthPercentage(100);
			observationTable.addCell(createSectionHeader(
					"8. OBSERVATION & OTHER DUE DILIGENCE CARRIED BY THE BRANCH (Specific comments required for high risk accounts)",
					1));
			observationTable.addCell(createCellWithTopAlignment(nvl(entity.getBranch_observations()), FONT_DATA,
					Element.ALIGN_LEFT, 60f));
			document.add(observationTable);

			// --- Reviewer & Approver Table ---
			// --- Reviewer, Approver & Head Table (UPDATED) ---
			PdfPTable reviewApprovalTable = new PdfPTable(3);
			reviewApprovalTable.setWidthPercentage(100);
			reviewApprovalTable.setSpacingBefore(10f);
			reviewApprovalTable.setWidths(new float[] { 33f, 33f, 34f }); // Balanced column widths

			// The header now spans 3 columns
			reviewApprovalTable.addCell(createSectionHeader("Branch - Reviewer, Approver & Head", 3));

			// Column 1: Reviewer Cell
			PdfPCell reviewedCell = createCellWithTopAlignment("", FONT_DATA, Element.ALIGN_LEFT, 90f);
			reviewedCell.addElement(
					new Paragraph("Review Date: " + formatDate(entity.getReview_date(), sdf), FONT_PLAIN_LABEL));
			reviewedCell.addElement(new Paragraph(" ", FONT_DATA));
			reviewedCell.addElement(new Paragraph("Reviewed by -", FONT_DATA));
			reviewedCell
					.addElement(new Paragraph(
							String.format("(Name, EC No & Designation)\n%s\n%s\n%s", nvl(entity.getReviewed_by_name()),
									nvl(entity.getReviewed_by_ec_no()), nvl(entity.getReviewed_by_designation())),
							FONT_DATA));
			reviewedCell.addElement(new Paragraph(" ", FONT_DATA));
			reviewedCell.addElement(new Paragraph("Branch - " + nvl(entity.getBranch_name()), FONT_PLAIN_LABEL));

			// Column 2: Approver Cell
			PdfPCell approvedCell = createCellWithTopAlignment("", FONT_DATA, Element.ALIGN_LEFT, 90f);
			approvedCell.addElement(
					new Paragraph("Approval Date: " + formatDate(entity.getApproval_date(), sdf), FONT_PLAIN_LABEL));
			approvedCell.addElement(new Paragraph(" ", FONT_DATA));
			approvedCell.addElement(new Paragraph("Approved by -", FONT_DATA));
			approvedCell
					.addElement(new Paragraph(
							String.format("(Name, EC No & Designation)\n%s\n%s\n%s", nvl(entity.getApproved_by_name()),
									nvl(entity.getApproved_by_ec_no()), nvl(entity.getApproved_by_designation())),
							FONT_DATA));

			// Column 3: Branch Head/Operation Head Signature Cell
			PdfPCell headSignatureCell = createCellWithTopAlignment("", FONT_DATA, Element.ALIGN_LEFT, 90f);
			headSignatureCell.addElement(new Paragraph("Branch Head/Operation Head Signature", FONT_DATA));
			// Create a placeholder box for the signature
			PdfPTable signatureBox = new PdfPTable(1);
			signatureBox.setWidthPercentage(90);
			// Create a cell and attach a custom event to draw the dashed border
			PdfPCell boxCell = new PdfPCell(new Phrase(" "));
			boxCell.setFixedHeight(60f);
			boxCell.setBorder(Rectangle.NO_BORDER); // We draw the border manually
			DashedBorderEvent dashedEvent = new DashedBorderEvent();
			boxCell.setCellEvent(dashedEvent); // Attach the custom border event
			signatureBox.addCell(boxCell);
			headSignatureCell.addElement(new Paragraph(" "));
			headSignatureCell.addElement(signatureBox);
			headSignatureCell.addElement(new Paragraph(" "));
			headSignatureCell.addElement(new Paragraph("Name: " + nvl(entity.getHead_signature_name()), FONT_DATA));

			// Add all three cells to the table
			reviewApprovalTable.addCell(reviewedCell);
			reviewApprovalTable.addCell(approvedCell);
			reviewApprovalTable.addCell(headSignatureCell);

			document.add(reviewApprovalTable);

			// --- Data Entry Table ---
			PdfPTable dataEntryTable = new PdfPTable(3);
			dataEntryTable.setWidthPercentage(100);
			dataEntryTable.setSpacingBefore(10f);
			dataEntryTable.addCell(createCell("", FONT_COLUMN_HEADER, Element.ALIGN_CENTER)); // With border now
			dataEntryTable.addCell(createCell("Date", FONT_COLUMN_HEADER, Element.ALIGN_LEFT));
			dataEntryTable.addCell(createCell("Name of the Employee", FONT_COLUMN_HEADER, Element.ALIGN_LEFT));
			dataEntryTable.addCell(createCell("Data Entered in Finacle", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			dataEntryTable.addCell(createCell(formatDate(entity.getEntry_date(), sdf), FONT_DATA, Element.ALIGN_LEFT));
			dataEntryTable.addCell(createCell(nvl(entity.getEntered_by()), FONT_DATA, Element.ALIGN_LEFT));
			dataEntryTable.addCell(createCell("Document(s) Uploaded in DMS", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
			dataEntryTable
					.addCell(createCell(formatDate(entity.getDoc_uploaded_date(), sdf), FONT_DATA, Element.ALIGN_LEFT));
			dataEntryTable.addCell(createCell(nvl(entity.getDoc_uploaded_by()), FONT_DATA, Element.ALIGN_LEFT));
			document.add(dataEntryTable);

			PdfPTable confirmationTable = new PdfPTable(1);
			confirmationTable.setWidthPercentage(100);
			confirmationTable.setSpacingBefore(15f); // Add some space above the statement

			// The FONT_PLAIN_LABEL is bold, which matches the visual style
			String confirmationText = "I confirm that I have done screening of All Account holders & kept on record.";
			PdfPCell confirmationCell = createCell(confirmationText, FONT_PLAIN_LABEL, Element.ALIGN_CENTER);

			// Remove the border to make it look like a standalone line of text
			confirmationCell.setBorder(Rectangle.NO_BORDER);

			confirmationTable.addCell(confirmationCell);
			document.add(confirmationTable);

		} catch (Exception e) {
			logger.error("Error during PDF generation for srlno {}: {}", srlno, e.getMessage(), e);
			throw new DocumentException("Failed to generate PDF.", e);
		} finally {
			if (document != null && document.isOpen()) {
				document.close();
			}
		}

		logger.info("PDF generated successfully: {}", outputFile.getAbsolutePath());
		return outputFile;
	}

	// ============== HELPER METHODS FOR PDF CELL CREATION ==============

	private PdfPCell createCell(String text, Font font, int horizontalAlignment) {
		return createCellWithHeight(text, font, horizontalAlignment, 16f);
	}

	private PdfPCell createCell(String text, Font font, int horizontalAlignment, int colspan) {
		PdfPCell cell = createCell(text, font, horizontalAlignment);
		cell.setColspan(colspan);
		return cell;
	}

	private PdfPCell createCellWithHeight(String text, Font font, int horizontalAlignment, float height) {
		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setHorizontalAlignment(horizontalAlignment);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setPadding(4f);
		cell.setMinimumHeight(height);
		return cell;
	}

	private PdfPCell createCellWithTopAlignment(String text, Font font, int horizontalAlignment, float height) {
		PdfPCell cell = new PdfPCell(new Phrase(text, font));
		cell.setHorizontalAlignment(horizontalAlignment);
		cell.setVerticalAlignment(Element.ALIGN_TOP);
		cell.setPadding(4f);
		cell.setPaddingTop(5f);
		cell.setMinimumHeight(height);
		return cell;
	}

	private PdfPCell createCellWithTable(PdfPTable table, int border) {
		PdfPCell cell = new PdfPCell(table);
		cell.setBorder(border);
		cell.setPadding(0);
		return cell;
	}

	private PdfPCell createSectionHeader(String text, int colspan) {
		String[] parts = text.split(" ", 2);
		Phrase phrase = new Phrase();
		phrase.add(new Chunk(parts[0] + " ", FONT_SECTION_HEADER));
		if (parts.length > 1) {
			phrase.add(new Chunk(parts[1], FONT_SECTION_HEADER));
		}

		PdfPCell cell = new PdfPCell(phrase);
		cell.setColspan(colspan);
		cell.setBackgroundColor(COLOR_PALE_ORANGE_BG);
		cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		cell.setHorizontalAlignment(Element.ALIGN_LEFT);
		cell.setPadding(4f);
		cell.setPaddingLeft(5f);
		cell.setMinimumHeight(20f);
		return cell;
	}

	private void addHolderRow(PdfPTable table, String label, Object val1, Object val2, Object val3, Object val4) {
		table.addCell(createCell(label, FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
		table.addCell(createCell(nvl(val1), FONT_DATA, Element.ALIGN_LEFT));
		table.addCell(createCell(nvl(val2), FONT_DATA, Element.ALIGN_LEFT));
		table.addCell(createCell(nvl(val3), FONT_DATA, Element.ALIGN_LEFT));
		table.addCell(createCell(nvl(val4), FONT_DATA, Element.ALIGN_LEFT));
	}

	private void addHolderRowDate(PdfPTable table, String label, Date d1, Date d2, Date d3, Date d4,
			SimpleDateFormat sdf) {
		table.addCell(createCell(label, FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
		table.addCell(createCell(formatDate(d1, sdf), FONT_DATA, Element.ALIGN_LEFT));
		table.addCell(createCell(formatDate(d2, sdf), FONT_DATA, Element.ALIGN_LEFT));
		table.addCell(createCell(formatDate(d3, sdf), FONT_DATA, Element.ALIGN_LEFT));
		table.addCell(createCell(formatDate(d4, sdf), FONT_DATA, Element.ALIGN_LEFT));
	}

	private String nvl(Object obj) {
		if (obj == null)
			return "";
		String s = obj.toString();
		return s.equalsIgnoreCase("null") ? "" : s;
	}

	private String formatDate(Date date, SimpleDateFormat sdf) {
		return date == null ? "" : sdf.format(date);
	}
	// Place this at the end of your IndividualPdfService class, after the
	// HeaderFooterPageEvent class

	class DashedBorderEvent implements com.itextpdf.text.pdf.PdfPCellEvent {
		@Override
		public void cellLayout(PdfPCell cell, Rectangle position, PdfContentByte[] canvases) {
			PdfContentByte canvas = canvases[PdfPTable.LINECANVAS];
			canvas.saveState();
			canvas.setLineDash(3f, 3f); // 3 points on, 3 points off
			canvas.rectangle(position.getLeft(), position.getBottom(), position.getWidth(), position.getHeight());
			canvas.stroke();
			canvas.restoreState();
		}
	}

	// ========================================================================
	// INNER CLASS FOR PAGE EVENTS (HEADER, FOOTER, WATERMARK)
	// ========================================================================
	private class HeaderFooterPageEvent extends PdfPageEventHelper {
		private final Ecdd_Individual_Profile_Entity entity;
		private final SimpleDateFormat sdf;
		private Image bobLogo;
		private Image trustLogo;
		private Image clientWatermarkLogo;

		public HeaderFooterPageEvent(Ecdd_Individual_Profile_Entity entity) {
			this.entity = entity;
			this.sdf = new SimpleDateFormat("dd-MM-yyyy");
			try {
				URL bobUrl = getClass().getResource("/static/images/bob_logo.png");
				URL trustUrl = getClass().getResource("/static/images/trust_logo.png");
				URL clientWatermarkUrl = getClass().getResource("/static/images/client_Logo_bkp.png");

				if (bobUrl != null)
					bobLogo = Image.getInstance(bobUrl);
				if (trustUrl != null)
					trustLogo = Image.getInstance(trustUrl);
				if (clientWatermarkUrl != null) {
					clientWatermarkLogo = Image.getInstance(clientWatermarkUrl);
				} else {
					logger.warn("Custom watermark 'client_Logo_bkp.png' not found in resources.");
				}

			} catch (Exception e) {
				logger.error("Critical error: Could not load header/watermark logos from resources.", e);
			}
		}

		@Override
		public void onStartPage(PdfWriter writer, Document document) {
			try {
				// --- Main Header Table ---
				PdfPTable headerTable = new PdfPTable(2);
				headerTable.setWidthPercentage(100);
				headerTable.setWidths(new float[] { 75, 25 });
				headerTable.setSpacingAfter(5f);

				PdfPCell titleCell = new PdfPCell();
				Paragraph titlePara = new Paragraph("Periodic CDD/ECDD-Due Diligence Form (Individual Customer)",
						FONT_TITLE);
				titlePara.setAlignment(Element.ALIGN_LEFT);
				titleCell.addElement(titlePara);
				titleCell.setBorder(Rectangle.NO_BORDER);
				titleCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				headerTable.addCell(titleCell);

				// Right Cell: Logos
				PdfPCell logosCell = new PdfPCell();
				logosCell.setBorder(Rectangle.NO_BORDER);
				logosCell.setHorizontalAlignment(Element.ALIGN_RIGHT);

				if (bobLogo != null && trustLogo != null) {
					PdfPTable logoContainer = new PdfPTable(2);
					logoContainer.setWidths(new float[] { 3, 1 });
					bobLogo.scaleToFit(100, 40);
					trustLogo.scaleToFit(40, 40);

					PdfPCell b = new PdfPCell(bobLogo);
					b.setBorder(Rectangle.NO_BORDER);
					b.setVerticalAlignment(Element.ALIGN_MIDDLE);

					PdfPCell t = new PdfPCell(trustLogo);
					t.setBorder(Rectangle.NO_BORDER);
					t.setVerticalAlignment(Element.ALIGN_MIDDLE);

					logoContainer.addCell(b);
					logoContainer.addCell(t);
					logosCell.addElement(logoContainer);
				}
				headerTable.addCell(logosCell);
				document.add(headerTable);

				// --- Top Data Block: This creates the 2x2 grid as per the target PDF ---
				PdfPTable headerInfoTable = new PdfPTable(4);
				headerInfoTable.setWidthPercentage(100);
				// CORRECTED: Column widths adjusted to match the visual layout of the original
				// PDF
				headerInfoTable.setWidths(new float[] { 2.0f, 4.5f, 3.0f, 2.5f });
				headerInfoTable.setSpacingAfter(5f);

				// Row 1
				headerInfoTable.addCell(createCell("Account Title", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
				headerInfoTable.addCell(createCell(nvl(entity.getAccount_title()), FONT_DATA, Element.ALIGN_LEFT));
				headerInfoTable.addCell(createCell("ECDD Date", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
				headerInfoTable
						.addCell(createCell(formatDate(entity.getEcdd_date(), sdf), FONT_DATA, Element.ALIGN_LEFT));

				// Row 2
				headerInfoTable.addCell(createCell("Customer ID", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
				headerInfoTable.addCell(createCell(nvl(entity.getCustomer_id()), FONT_DATA, Element.ALIGN_LEFT));
				headerInfoTable
						.addCell(createCell("Associated Account Number(s)", FONT_PLAIN_LABEL, Element.ALIGN_LEFT));
				headerInfoTable
						.addCell(createCell(nvl(entity.getAssociated_accounts()), FONT_DATA, Element.ALIGN_LEFT));
				document.add(headerInfoTable);

			} catch (DocumentException e) {
				logger.error("Error adding header content to page", e);
			}

			if (clientWatermarkLogo != null) {
				PdfContentByte under = writer.getDirectContentUnder();
				PdfGState gs = new PdfGState();
				gs.setFillOpacity(0.05f);
				under.saveState();
				under.setGState(gs);
				try {
					clientWatermarkLogo.scaleAbsolute(300f, 300f);
					float x = (PageSize.A4.getWidth() - clientWatermarkLogo.getScaledWidth()) / 2;
					float y = (PageSize.A4.getHeight() - clientWatermarkLogo.getScaledHeight()) / 2;
					clientWatermarkLogo.setAbsolutePosition(x, y);
					under.addImage(clientWatermarkLogo);
				} catch (DocumentException e) {
					logger.error("Could not add client image watermark", e);
				}
				under.restoreState();
			}
		}

		@Override
		public void onEndPage(PdfWriter writer, Document document) {
			// --- Footer (Disclaimer and Page Number) ---
			PdfPTable footerTable = new PdfPTable(1);
			footerTable.setWidthPercentage(100);
			footerTable.setTotalWidth(document.right() - document.left());

			Phrase footerText = new Phrase(
					"Branch to ensure updating the data in CBS with latest details & upload documents in DMS",
					FONT_FOOTER);
			PdfPCell textCell = new PdfPCell(footerText);
			textCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			textCell.setBorder(Rectangle.NO_BORDER);
			footerTable.addCell(textCell);

			String pageNumText = String.format("Page %d / 2", writer.getPageNumber());
			Phrase pageNumPhrase = new Phrase(pageNumText, FONT_FOOTER);
			PdfPCell pageNumCell = new PdfPCell(pageNumPhrase);
			pageNumCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			pageNumCell.setBorder(Rectangle.NO_BORDER);
			footerTable.addCell(pageNumCell);

			// Write the table at the bottom of the page
			footerTable.writeSelectedRows(0, -1, document.leftMargin(), document.bottom(), writer.getDirectContent());
		}
	}
}