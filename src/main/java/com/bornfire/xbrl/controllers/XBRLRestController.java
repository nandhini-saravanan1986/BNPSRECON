package com.bornfire.xbrl.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.BRECON_TTUM_TRANSACTION_ENTITY;
import com.bornfire.xbrl.entities.BRECON_TTUM_TRANSACTION_REP;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.XBRLAudit;
import com.bornfire.xbrl.entities.XBRLProceduresRep;
import com.bornfire.xbrl.entities.XBRLSession;
import com.bornfire.xbrl.entities.BRBS.AuditTablePojo;
import com.bornfire.xbrl.entities.BRBS.BRECON_Audit_Entity;
import com.bornfire.xbrl.entities.BRBS.BRECON_Audit_Rep;
import com.bornfire.xbrl.entities.BRBS.BRECON_Common_Table_Entity;
import com.bornfire.xbrl.entities.BRBS.BRECON_Common_Table_Rep;
import com.bornfire.xbrl.entities.BRBS.BRECON_DESTINATION_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRECON_DESTINATION_REPO;
import com.bornfire.xbrl.entities.BRBS.Brecon_core_entity;
import com.bornfire.xbrl.entities.BRBS.Brecon_core_rep;
import com.bornfire.xbrl.entities.BRBS.Charge_Back_Rep;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Rep;
import com.bornfire.xbrl.services.AlertManagementServices;
import com.bornfire.xbrl.services.Breconservice;
import com.bornfire.xbrl.services.CallStoredProcedure;
import com.bornfire.xbrl.services.Kyc_Corprate_service;
import com.bornfire.xbrl.services.Kyc_individual_service;
import com.bornfire.xbrl.services.LoginServices;
import com.bornfire.xbrl.services.ReportServices;

import FYItransactions.Balance;
import FYItransactions.Entry;

@RestController
@Component
public class XBRLRestController {

	private static final Logger logger = LoggerFactory.getLogger(XBRLRestController.class);

	@Autowired
	AlertManagementServices alertManagementServices;

	@Autowired
	XBRLProceduresRep xbrlProceduresRep;

	@Autowired
	ReportServices reportServices;

	@Autowired
	LoginServices loginServices;

	@Autowired
	BRECON_DESTINATION_REPO bRECON_DESTINATION_REPO;

	@Autowired
	BRECON_Audit_Rep bRECON_Audit_Rep;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	UserProfileRep userProfileRep;

	@Autowired
	Brecon_core_rep coresystemlistrep;

	@Autowired
	BRECON_Common_Table_Rep bRECON_Common_Table_Rep;

	@Autowired
	Charge_Back_Rep charge_Back_Rep;

	@Autowired
	MANUAL_Service_Rep mANUAL_Service_Rep;

	@Autowired
	Kyc_individual_service Kyc_individual_service;

	@Autowired
	Kyc_Corprate_service Kyc_Corprate_service;

	@PersistenceContext
	private EntityManager entityManager;

	private final CallStoredProcedure callStoredProcedure = new CallStoredProcedure();

	@RequestMapping(value = "userlogList", method = RequestMethod.GET)
	public List<XBRLSession> userLogList(@RequestParam String fromdate, @RequestParam String todate) {

		Date fromdate2 = null;
		Date todate2 = null;

		try {
			fromdate2 = new SimpleDateFormat("dd-MM-yyyy").parse(fromdate);
			todate2 = new SimpleDateFormat("dd-MM-yyyy").parse(todate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginServices.getUserLog(fromdate2, todate2);

	}

	@RequestMapping(value = "auditList", method = RequestMethod.GET)
	public List<XBRLAudit> auditList(@RequestParam String fromdate, @RequestParam String todate) {

		Date fromdate2 = null;
		Date todate2 = null;

		try {

			fromdate2 = new SimpleDateFormat("dd-MM-yyyy").parse(fromdate);
			todate2 = new SimpleDateFormat("dd-MM-yyyy").parse(todate);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportServices.getAuditLog(fromdate2, todate2);

	}

	@RequestMapping(value = "uploadxmlvalues", method = RequestMethod.POST)
	public String uploadxmlvalues(@RequestParam("file") MultipartFile file,
			@RequestParam("report_name") String report_name,
			@RequestParam("report_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date report_date,
			@RequestParam("report_from_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date report_from_date,
			@RequestParam("report_to_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date report_to_date) {

		List<String> reportNames = bRECON_DESTINATION_REPO.getReportNames();

		if (reportNames.contains(report_name)) {
			return "This file already exists";
		} else {
			try {
				InputStream Stream = file.getInputStream();
				JAXBContext jaxBContext;
				JAXBElement<FYItransactions.Document> jaxbElement = null;

				jaxBContext = JAXBContext.newInstance(FYItransactions.Document.class);
				Unmarshaller unMarshaller = jaxBContext.createUnmarshaller();
				XMLInputFactory factory = XMLInputFactory.newInstance();
				factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);
				XMLEventReader xmlEventReader = factory.createXMLEventReader(Stream);
				jaxbElement = unMarshaller.unmarshal(xmlEventReader, FYItransactions.Document.class);
				BRECON_DESTINATION_ENTITY chargeBack = new BRECON_DESTINATION_ENTITY();

				String hdr = jaxbElement.getValue().getBkToCstmrStmt().getGrpHdr().getGrpHdrMessageIdentifier();
				Date hdr1 = jaxbElement.getValue().getBkToCstmrStmt().getGrpHdr().getGrpHdrCreationDateTime();
				String hdr2 = jaxbElement.getValue().getBkToCstmrStmt().getGrpHdr().getMsgRcpt().getGrpHdrName();
				String hdr3 = jaxbElement.getValue().getBkToCstmrStmt().getGrpHdr().getMsgRcpt().getId().getOrgId()
						.getGrpHdrBankIdentifierCode();
				BigDecimal hdr4 = jaxbElement.getValue().getBkToCstmrStmt().getGrpHdr().getMsgPgntn()
						.getGrpHdrPageNumber();
				String hdr5 = jaxbElement.getValue().getBkToCstmrStmt().getGrpHdr().getMsgPgntn()
						.getGrpHdrLastPageIndicator();

				String Stmt = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getStmtStatementIdentifier();
				BigDecimal Stmt1 = jaxbElement.getValue().getBkToCstmrStmt().getStmt()
						.getStmtElectronicSequenceNumber();
				Date Stmt3 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getStmtCreationDateTime();
				Date Stmt14 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getFrToDt().getStmtFromDateTime();
				Date Stmt15 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getFrToDt().getStmtToDateTime();
				String Stmt4 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getAcct().getId().getOthr()
						.getStmtAccountIdentifier();
				String Stmt5 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getRltdAcct().getId().getOthr()
						.getStmtRelatedAccountIdentifier();
				BigDecimal Stmt6 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getTxsSummry().getTtlNtries()
						.getTxsSummryNumberOfEntries();
				BigDecimal Stmt7 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getTxsSummry().getTtlNtries()
						.getTxsSummrySum();
				BigDecimal Stmt8 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getTxsSummry().getTtlNtries()
						.getTtlNetNtry().getTxsSummryAmount();
				String Stmt9 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getTxsSummry().getTtlNtries()
						.getTtlNetNtry().getTxsSummryCreditDebitIndicator();
				BigDecimal Stmt10 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getTxsSummry().getTtlCdtNtries()
						.getTxsSummryCreditNumberOfEntries();
				BigDecimal Stmt11 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getTxsSummry().getTtlCdtNtries()
						.getTxsSummryCreditSum();
				BigDecimal Stmt12 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getTxsSummry().getTtlDbtNtries()
						.getTxsSummryDebitNumberOfEntries();
				BigDecimal Stmt13 = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getTxsSummry().getTtlDbtNtries()
						.getTxsSummryDebitSum();

				// signature datavalues//
				String sign = jaxbElement.getValue().getSignature().getSignedInfo().getCanonicalizationMethod()
						.getAlgorithm();
				String sign1 = jaxbElement.getValue().getSignature().getSignedInfo().getSignatureMethod()
						.getAlgorithm();
				String sign2 = jaxbElement.getValue().getSignature().getSignedInfo().getReference().getTransforms()
						.getTransform().getAlgorithm();
				String sign3 = jaxbElement.getValue().getSignature().getSignedInfo().getReference().getDigestMethod()
						.getAlgorithm();

				String sign4 = jaxbElement.getValue().getSignature().getSignedInfo().getReference()
						.getSignature_signedinfo_digest_value();

				String sign5 = jaxbElement.getValue().getSignature().getSignature_signedinfo_signature_value();

				String sign6 = jaxbElement.getValue().getSignature().getKeyInfo().getX509Data()
						.getSignature_keyinfo_x509_subject_name();
				String sign7 = jaxbElement.getValue().getSignature().getKeyInfo().getX509Data()
						.getSignature_keyinfo_x509_certificate();

				chargeBack.setCanonicalizationmethod_algorithm(sign);
				chargeBack.setSignaturemethod_algorithm(sign1);
				chargeBack.setTransform_algorithm(sign2);
				chargeBack.setDigestmethod_algorithm(sign3);
				chargeBack.setSignature_signedinfo_digest_value(sign4);
				chargeBack.setSignature_signedinfo_signature_value(sign5);
				chargeBack.setSignature_keyinfo_x509_subject_name(sign6);
				chargeBack.setSignature_keyinfo_x509_certificate(sign7);

				chargeBack.setGrphdr_message_identifier(hdr);
				chargeBack.setGrphdr_creation_date_time(hdr1);
				chargeBack.setGrphdr_name(hdr2);
				chargeBack.setGrphdr_bank_identifier_code(hdr3);
				chargeBack.setGrphdr_page_number(hdr4);
				chargeBack.setGrphdr_last_page_indicator(hdr5);

				chargeBack.setStmt_statement_identifier(Stmt);
				chargeBack.setStmt_electronic_sequence_number(Stmt1);
				chargeBack.setStmt_creation_date_time(Stmt3);
				chargeBack.setStmt_from_date_time(Stmt14);
				chargeBack.setStmt_to_date_time(Stmt15);
				chargeBack.setStmt_account_identifier(Stmt4);
				chargeBack.setStmt_related_account_identifier(Stmt5);
				chargeBack.setTxssummry_number_of_entries(Stmt6);
				chargeBack.setTxssummry_sum(Stmt7);
				chargeBack.setTxssummry_amount(Stmt8);
				chargeBack.setTxssummry_credit_debit_indicator(Stmt9);
				chargeBack.setTxssummry_credit_number_of_entries(Stmt10);
				chargeBack.setTxssummry_credit_sum(Stmt11);
				chargeBack.setTxssummry_debit_number_of_entries(Stmt12);
				chargeBack.setTxssummry_debit_sum(Stmt13);

				chargeBack.setEntity_flg("Y");

				List<Balance> balances = jaxbElement.getValue().getBkToCstmrStmt().getStmt().getBal();

				if (balances.size() > 0) {
					Balance firstBalance = balances.get(0);

					String st1 = firstBalance.getTp().getCdOrPrtry().getStmtBalCodeOrProprietary();
					BigDecimal st2 = firstBalance.getStmtBalAmount();
					String st3 = firstBalance.getStmtBalCreditDebitIndicator();
					Date st4 = firstBalance.getDt().getStmtBalDate();
					Date st5 = firstBalance.getDt().getStmtBalDateTime();

					// Set first balance in normal columns
					chargeBack.setStmt_bal_code_or_proprietary(st1);
					chargeBack.setStmt_bal_amount(st2);
					chargeBack.setStmt_bal_credit_debit_indicator(st3);
					chargeBack.setStmt_bal_date(st4);
					chargeBack.setStmt_bal_date_time(st5);
				}

				if (balances.size() > 1) {
					Balance secondBalance = balances.get(1);

					String st1_1 = secondBalance.getTp().getCdOrPrtry().getStmtBalCodeOrProprietary();
					BigDecimal st2_1 = secondBalance.getStmtBalAmount();
					String st3_1 = secondBalance.getStmtBalCreditDebitIndicator();
					Date st4_1 = secondBalance.getDt().getStmtBalDate();
					Date st5_1 = secondBalance.getDt().getStmtBalDateTime();

					// Set second balance in "Bal1" columns
					chargeBack.setStmt_bal1_code_or_proprietary(st1_1);
					chargeBack.setStmt_bal1_amount(st2_1);
					chargeBack.setStmt_bal1_credit_debit_indicator(st3_1);
					chargeBack.setStmt_bal1_date(st4_1);
					chargeBack.setStmt_bal1_date_time(st5_1);
				}

				int y = 0;
				for (Entry trab2 : jaxbElement.getValue().getBkToCstmrStmt().getStmt().getNtry()) {
					String st11 = trab2.getNtryEntryReference();
					BigDecimal st12 = trab2.getNtryAmountCurrency();
					String st13 = trab2.getNtryCreditDebitIndicator();
					String st14 = trab2.getSts().getNtryCode();
					Date st15 = trab2.getBookgDt().getNtryBookingDate();
					Date st16 = trab2.getBookgDt().getNtryBookingDateTime();
					Date st17 = trab2.getValDt().getNtryValueDate();
					String st18 = trab2.getValDt().getNtryValueDateTime();
					String st19 = trab2.getNtry_account_servicer_reference();
					String st20 = trab2.getBkTxCd().getPrtry().getNtryProprietaryCode();

					BigDecimal st21 = trab2.getAmtDtls().getInstdAmt().getNtryInstructedAmount();
					BigDecimal st221 = trab2.getAmtDtls().getTxAmt().getCurrency_values().getNtry_transaction_amount();

					String st331 = trab2.getAmtDtls().getTxAmt().getCurrency_values().getTransaction_currency();
					if (st331 != null && !st331.isEmpty()) {
						chargeBack.setTransaction_currency(st331);
					} else {
					}

					if (trab2.getNtryDtls() != null && trab2.getNtryDtls().getBtch() != null) {
						String st51 = trab2.getNtryDtls().getBtch().getNtry_btch_msg_id();
						BigDecimal st52 = trab2.getNtryDtls().getBtch().getNtry_btch_numoftxs();
						BigDecimal st53 = trab2.getNtryDtls().getBtch().getNtry_btch_ttlamt();
						String st54 = trab2.getNtryDtls().getBtch().getNtry_brch_cdtdbtint();

						chargeBack.setNtry_btch_msg_id(st51);
						chargeBack.setNtry_btch_numoftxs(st52);
						chargeBack.setNtry_btch_ttlamt(st53);
						chargeBack.setNtry_brch_cdtdbtint(st54);
					} else {
					}

					String st22 = trab2.getNtryDtls().getTxDtls().getRefs().getNtryRefsMessageIdentifier();
					String st41 = trab2.getNtryDtls().getTxDtls().getRefs().getNtry_refs_pmtinfid();
					String st23 = trab2.getNtryDtls().getTxDtls().getRefs().getNtryRefsAccountServicerReference();
					String st24 = trab2.getNtryDtls().getTxDtls().getRefs().getNtryRefsInstructionId();
					String st25 = trab2.getNtryDtls().getTxDtls().getRefs().getNtryRefsEndToEndIdentification();
					String st42 = trab2.getNtryDtls().getTxDtls().getRefs().getNtry_refs_uetr();
					String st26 = trab2.getNtryDtls().getTxDtls().getRefs().getNtryRefsTransactionId();
					String st27 = trab2.getNtryDtls().getTxDtls().getRefs().getNtryRefsClearingSystemReference();

					BigDecimal st28 = trab2.getNtryDtls().getTxDtls().getNtryTxDtlsAmountCurrency();
					String st29 = trab2.getNtryDtls().getTxDtls().getNtryTxDtlsCreditDebitIndicator();
					String abc = trab2.getNtryDtls().getTxDtls().getMsgRcpt().getInstgAgt().getFinInstnId()
							.getNtry_fininstnid_bicfi();
					String st30 = trab2.getNtryDtls().getTxDtls().getMsgRcpt().getDbtrAgt().getFinInstnId()
							.getNtry_dbtragt_bicfi_debit();
					String st31 = trab2.getNtryDtls().getTxDtls().getMsgRcpt().getCdtrAgt().getFinInstnId()
							.getNtry_cdtragt_bicfi_credit();

					chargeBack.setNtry_entry_reference(st11);
					chargeBack.setNtry_amount_currency(st12);
					chargeBack.setNtry_credit_debit_indicator(st13);
					chargeBack.setNtry_code(st14);
					chargeBack.setNtry_booking_date(st15);
					chargeBack.setNtry_booking_date_time(st16);
					chargeBack.setNtry_value_date(st17);
					chargeBack.setNtry_value_date_time(st18);
					chargeBack.setNtry_account_servicer_reference(st19);
					chargeBack.setNtry_proprietary_code(st20);
					chargeBack.setNtry_instructed_amount(st21);
					chargeBack.setNtry_refs_message_identifier(st22);
					chargeBack.setNtry_refs_pmtinfid(st41);
					chargeBack.setNtry_refs_account_servicer_reference(st23);
					chargeBack.setNtry_refs_instruction_id(st24);
					chargeBack.setNtry_refs_end_to_end_identification(st25);
					chargeBack.setNtry_refs_uetr(st42);
					chargeBack.setNtry_refs_transaction_id(st26);
					chargeBack.setNtry_refs_clearing_system_reference(st27);
					chargeBack.setNtry_txdtls_amount_currency(st28);
					chargeBack.setNtry_txdtls_credit_debit_indicator(st29);
					chargeBack.setNtry_dbtragt_bicfi_debit(st30);
					chargeBack.setNtry_cdtragt_bicfi_credit(st31);
					chargeBack.setNtry_transaction_amount(st221);

					chargeBack.setNtry_fininstnid_bicfi(abc);

					chargeBack.setSrlno(bRECON_DESTINATION_REPO.srlno());
					chargeBack.setDel_flg("N");
					chargeBack.setReport_name(report_name);
					chargeBack.setReport_date(report_date);
					chargeBack.setReport_from_date(report_from_date);
					chargeBack.setReport_to_date(report_to_date);
					y++;
					chargeBack.setSrlno(bRECON_DESTINATION_REPO.srlno());
					bRECON_DESTINATION_REPO.save(chargeBack);
				}
				return "Saved Successfully";
			} catch (Exception e) {
				e.printStackTrace();
				return "Error uploading XML file.";
			}
		}
	}

	@Autowired
	BRECON_TTUM_TRANSACTION_REP brecon_ttum_transaction_rep;

	@Autowired
	Breconservice Breconservice;

	@PostMapping("/tmtuploadxmlvaluesdatas")
	public ResponseEntity<String> tmtuploadxmlvaluesdatas(@RequestParam("files") List<MultipartFile> files,
			@RequestParam("report_names") List<String> reportNames,
			@RequestParam("report_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date reportDate,
			HttpServletRequest request) {
		List<String> existingReportNames = bRECON_DESTINATION_REPO.getReportNames();
		List<String> existingTTUMReportNames = brecon_ttum_transaction_rep.getReportNames();

		List<String> matchedFiles = new ArrayList<>();
		List<String> unmatchedFiles = new ArrayList<>();
		List<String> duplicates = new ArrayList<>();

		for (int i = 0; i < files.size(); i++) {
			MultipartFile file = files.get(i);
			String reportName = reportNames.get(i);
			String fileName = file.getOriginalFilename();

			logger.info("Processing file: {}", fileName);

			if (existingReportNames.contains(fileName) || existingTTUMReportNames.contains(fileName)) {
				unmatchedFiles.add(fileName);
				continue;
			}

			try (InputStream stream = file.getInputStream()) {
				JAXBContext jaxBContext = JAXBContext.newInstance(FYItransactions.Document.class);
				Unmarshaller unMarshaller = jaxBContext.createUnmarshaller();
				XMLInputFactory factory = XMLInputFactory.newInstance();
				factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);
				XMLEventReader reader = factory.createXMLEventReader(stream);
				JAXBElement<FYItransactions.Document> jaxbElement = unMarshaller.unmarshal(reader,
						FYItransactions.Document.class);
				FYItransactions.Document doc = jaxbElement.getValue();

				String stmtIdentifier = doc.getBkToCstmrStmt().getStmt().getAcct().getId().getOthr()
						.getStmtAccountIdentifier();
				List<Entry> entries = doc.getBkToCstmrStmt().getStmt().getNtry();

				Set<String> transactionRefs = entries.stream()
						.map(e -> e.getNtryDtls().getTxDtls().getRefs().getNtryRefsClearingSystemReference())
						.collect(Collectors.toSet());

				logger.info("Transaction Refs are : " + transactionRefs);

				Set<Entry> existingRefs = new HashSet<>();

				List<Object[]> result = stmtIdentifier.equals("DPPA2000011201001")
						? brecon_ttum_transaction_rep.findExistingReferences(transactionRefs)
						: bRECON_DESTINATION_REPO.findExistingReferences(transactionRefs);

				for (Object[] row : result) {
					String ref = (String) row[0];
					BigDecimal amt = (BigDecimal) row[1];
					String tranindi = (String) row[2];
					existingRefs.add(new Entry(ref, amt, tranindi));
				}

				List<Entry> newEntries = new ArrayList<>();
				List<Entry> duplicateEntries = new ArrayList<>();

				for (Entry entry : entries) {
					String refval = entry.getNtryDtls().getTxDtls().getRefs().getNtryRefsClearingSystemReference();
					BigDecimal tranamt = entry.getNtryAmountCurrency();
					String tranindic = entry.getNtryCreditDebitIndicator();

					Entry key = new Entry(refval, tranamt, tranindic);
					logger.info("Existing Data to Check : " + existingRefs);
					logger.info("Key Value to check : " + key.toString());
					if (existingRefs.contains(key)) {

						duplicateEntries.add(entry);
					} else {
						newEntries.add(entry);
					}
				}

				if (!newEntries.isEmpty()) {
					matchedFiles.add(fileName);
					if (!stmtIdentifier.equals("DPPA2000011201001")) {
						Breconservice.batchInsertAANI(doc, newEntries, reportName, stmtIdentifier);
					} else {
						Breconservice.batchInsertTTUM(doc, newEntries, reportName, stmtIdentifier);
					}
				}

				if (!duplicateEntries.isEmpty()) {
					if (!duplicates.contains(fileName))
						duplicates.add(fileName);
					Breconservice.batchInsertDuplicates(doc, duplicateEntries, reportName, stmtIdentifier);
				}

			} catch (IOException | JAXBException | XMLStreamException e) {
				logger.error("Error processing file {}: {}", file.getOriginalFilename(), e.getMessage(), e);
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body("Failed to process: " + file.getOriginalFilename() + "\n" + e.getMessage());
			}
		}

		String matchedFilesString = matchedFiles.isEmpty() ? "Uploaded Files:\nNo new records Uploaded"
				: "Uploaded Files:\n" + String.join("\n", matchedFiles);
		String unmatchedFilesString = unmatchedFiles.isEmpty() ? "Already Existing Files:\nNo existing records skipped"
				: "Already Existing Files:\n" + String.join("\n", unmatchedFiles);
		String duplicateReport = duplicates.isEmpty() ? "Duplicates:\nNo Duplicate records"
				: "Duplicate Record Files:\n" + String.join("\n", duplicates)
						+ "\nPlease check 'Duplicate Records' menu.";

		return ResponseEntity.ok().contentType(MediaType.TEXT_PLAIN)
				.body(matchedFilesString + "\n\n" + unmatchedFilesString + "\n\n" + duplicateReport);
	}

	@RequestMapping(value = "/aasciexportxmlvalues", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> aasciexportxmlvalues(
			@RequestParam("report_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date report_date,
			HttpServletRequest request) {

		List<BRECON_TTUM_TRANSACTION_ENTITY> reportNames = brecon_ttum_transaction_rep
				.getReportNamesvalues(report_date);

		if (reportNames != null && !reportNames.isEmpty()) {
			List<BRECON_TTUM_TRANSACTION_ENTITY> DPPAVALUES = new ArrayList<>();
			List<BRECON_TTUM_TRANSACTION_ENTITY> CREDITTRAN = new ArrayList<>();
			List<BRECON_TTUM_TRANSACTION_ENTITY> DEBITTRAN = new ArrayList<>();
			List<BRECON_TTUM_TRANSACTION_ENTITY> returnrecord = new ArrayList<>();

			for (BRECON_TTUM_TRANSACTION_ENTITY dataval1 : reportNames) {
				if (dataval1.getStmt_account_identifier().equals("DPPA2000011201001")) {
					DPPAVALUES.add(dataval1);
				}
			}

			for (BRECON_TTUM_TRANSACTION_ENTITY allvalueses : DPPAVALUES) {
				if (allvalueses.getNtry_credit_debit_indicator().equals("CRDT")) {
					CREDITTRAN.add(allvalueses);
				} else if (allvalueses.getNtry_credit_debit_indicator().equals("DBIT")) {
					DEBITTRAN.add(allvalueses);
				}
			}

			LocalDate yesterdayDate1 = report_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
					.minusDays(1);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String formattedYesterdayDate = yesterdayDate1.format(formatter);

			// Counter for credit entries
			int creditCounter = 0;

			for (BRECON_TTUM_TRANSACTION_ENTITY debitTransaction : DEBITTRAN) {
				if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("AEPCAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("AEPCAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90011615180157"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90011615180158"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_value_date_time()); // Set
																										// LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				} else if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("AEPCAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("CBAUAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90101682061018"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90011615180158"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_value_date_time()); // Set
																										// LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				} else if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("CBAUAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("AEPCAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90011615180158"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90101682061018"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_value_date_time()); // Set
																										// LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				}
			}

			// Repeat the same structure for CREDITTRAN
			for (BRECON_TTUM_TRANSACTION_ENTITY debitTransaction : CREDITTRAN) {
				if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("AEPCAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("AEPCAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90011615180158"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90011615180157"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_value_date_time()); // Set
																										// LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				}

				else if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("AEPCAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("CBAUAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90101682061018"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90011615180158"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_value_date_time()); // Set
																										// LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				}

				else if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("CBAUAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("AEPCAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90011615180158"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90101682061018"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_value_date_time()); // Set
																										// LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				}
			}

			// Generating ASCII file if returnrecord is not empty
			if (!returnrecord.isEmpty()) {
				// Assuming report_date is of type java.util.Date
				LocalDate reportDate = report_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				String formattedReportDate = reportDate.format(formatter1);

				// Create a StringBuilder to store the output
				StringBuilder sb = new StringBuilder();

				// Create lists to store all debit and credit transactions
				List<BRECON_TTUM_TRANSACTION_ENTITY> debitRecords = new ArrayList<>();
				List<BRECON_TTUM_TRANSACTION_ENTITY> creditRecords = new ArrayList<>();

				// Separate records into debit and credit lists
				for (BRECON_TTUM_TRANSACTION_ENTITY returnedValue : returnrecord) {
					if ("D".equals(returnedValue.getNtry_credit_debit_indicator())) {
						debitRecords.add(returnedValue); // Add to debit records
					} else if ("C".equals(returnedValue.getNtry_credit_debit_indicator())) {
						creditRecords.add(returnedValue); // Add to credit records
					}
				}

				// Calculate maximum widths for each column based on the records
				int maxAccountNoWidth = 0;
				int maxReferenceWidth = 0;
				int maxCurrencyWidth = 0;
				int maxAmountWidth = 0;

				for (BRECON_TTUM_TRANSACTION_ENTITY record : returnrecord) {
					maxAccountNoWidth = Math.max(maxAccountNoWidth, record.getAccount_no().trim().length());
					maxReferenceWidth = Math.max(maxReferenceWidth, record.getNtry_entry_reference().trim().length());
					maxCurrencyWidth = Math.max(maxCurrencyWidth, record.getTransaction_currency().trim().length());
					maxAmountWidth = Math.max(maxAmountWidth,
							String.format("%.2f", record.getNtry_transaction_amount().doubleValue()).length());
				}

				// Print both debit and credit transactions without headers
				for (int i = 0; i < Math.max(debitRecords.size(), creditRecords.size()); i++) {
					// Append debit record if available
					if (i < debitRecords.size()) {
						BRECON_TTUM_TRANSACTION_ENTITY debitRecord = debitRecords.get(i);
						sb.append(String.format("%s  ", formattedReportDate))
								.append(String.format("%-" + maxAccountNoWidth + "s  ",
										debitRecord.getAccount_no().trim()))
								.append(String.format("%-" + maxReferenceWidth + "s  ",
										debitRecord.getNtry_entry_reference().trim()))
								.append(String.format("%-" + maxCurrencyWidth + "s  ",
										debitRecord.getTransaction_currency().trim()))
								.append(String.format("%s  ", "D")).append(String.format("%" + maxAmountWidth + ".2f  ",
										debitRecord.getNtry_transaction_amount().doubleValue()));
					}

					// Append credit record if available
					if (i < creditRecords.size()) {
						BRECON_TTUM_TRANSACTION_ENTITY creditRecord = creditRecords.get(i);
						sb.append(String.format("%-" + maxAccountNoWidth + "s  ", creditRecord.getAccount_no().trim()))
								.append(String.format("%-" + maxReferenceWidth + "s  ",
										creditRecord.getNtry_entry_reference().trim()))
								.append(String.format("%-" + maxCurrencyWidth + "s  ",
										creditRecord.getTransaction_currency().trim()))
								.append(String.format("%s  ", "C")).append(String.format("%" + maxAmountWidth + ".2f",
										creditRecord.getNtry_transaction_amount().doubleValue()))
								.append("\n");
					} else {
						// If no credit record, just add a new line
						sb.append("\n");
					}
				}

				// Convert StringBuilder to ByteArrayOutputStream
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				try {
					outputStream.write(sb.toString().getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Set up headers for file download
				HttpHeaders headers1 = new HttpHeaders();
				headers1.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Brecon.txt");
				ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

				String auditID = sequence.generateRequestUUId();
				String user1 = (String) request.getSession().getAttribute("USERID");
				String username = (String) request.getSession().getAttribute("USERNAME");

				BRECON_Audit_Entity audit = new BRECON_Audit_Entity();
				audit.setAudit_date(new Date());
				audit.setEntry_time(new Date());
				audit.setEntry_user(user1);
				audit.setFunc_code("DOWNLOAD");
				audit.setAudit_table("BRECONDESTINATIONTABLE");
				audit.setAudit_screen("DOWNLOAD");
				audit.setEvent_id(user1);
				audit.setEvent_name(username);
				audit.setModi_details("Downloaded Successfully");

				UserProfile values1 = userProfileRep.getRole(user1);
				audit.setAuth_user(values1.getAuth_user());
				audit.setAuth_time(values1.getAuth_time());
				audit.setAudit_ref_no(auditID);

				bRECON_Audit_Rep.save(audit);

				return ResponseEntity.ok().headers(headers1).contentLength(outputStream.size())
						.contentType(MediaType.TEXT_PLAIN).body(resource);
			} else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT)
						.body(Collections.singletonMap("message", "No records to generate."));
			}
		}
		// Return a bad request if there is no data to generate the report
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(Collections.singletonMap("message", "No data available to generate the report."));
	}

	/* pon prasanth */
	@GetMapping("businesstrailvalues")
	public List<BRECON_Audit_Entity> businesstrailvalues(@RequestParam(required = false) Date fromDateToUse) {
		List<BRECON_Audit_Entity> accountvalue = bRECON_Audit_Rep.getauditListLocalvaluesbusiness(fromDateToUse);
		System.out.println("the Entered Account Num Is  " + fromDateToUse);
		return accountvalue;
	}

	@RequestMapping(value = "/CallmanualReconprocedurerun", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> CallmanualReconprocedurerun(
			@RequestParam("report_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date report_date) {

		String msg = "";
		System.out.println("Reconciliation Started");

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("BRECON_TRAN_COMM_VALIDATION_PROCEDURE");
		query.execute();
		msg = "Reconciliation completed for " + report_date;

		return ResponseEntity.ok(msg);
	}

	@RequestMapping(value = "/exportxmlvalues", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<?> exportxmlvalues(
			@RequestParam("report_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date report_date) {

		List<BRECON_TTUM_TRANSACTION_ENTITY> reportNames = brecon_ttum_transaction_rep
				.getReportNamesvalues(report_date);

		if (reportNames != null && !reportNames.isEmpty()) {
			List<BRECON_TTUM_TRANSACTION_ENTITY> DPPAVALUES = new ArrayList<>();
			List<BRECON_TTUM_TRANSACTION_ENTITY> CREDITTRAN = new ArrayList<>();
			List<BRECON_TTUM_TRANSACTION_ENTITY> DEBITTRAN = new ArrayList<>();
			List<BRECON_TTUM_TRANSACTION_ENTITY> returnrecord = new ArrayList<>();

			for (BRECON_TTUM_TRANSACTION_ENTITY dataval1 : reportNames) {
				if (dataval1.getStmt_account_identifier().equals("DPPA2000011201001")) {
					DPPAVALUES.add(dataval1);
				}
			}

			for (BRECON_TTUM_TRANSACTION_ENTITY allvalueses : DPPAVALUES) {
				if (allvalueses.getNtry_credit_debit_indicator().equals("CRDT")) {
					CREDITTRAN.add(allvalueses);
				} else if (allvalueses.getNtry_credit_debit_indicator().equals("DBIT")) {
					DEBITTRAN.add(allvalueses);
				}
			}

			LocalDate yesterdayDate1 = report_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
					.minusDays(0);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
			String formattedYesterdayDate = yesterdayDate1.format(formatter);

			// Counter for credit entries
			int creditCounter = 0;

			for (BRECON_TTUM_TRANSACTION_ENTITY debitTransaction : DEBITTRAN) {
				if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("AEPCAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("AEPCAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90011615180157"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90011615180158"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_value_date_time()); // Set LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				} else if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("AEPCAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("CBAUAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90101682061018"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90011615180158"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_value_date_time()); // Set LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				} else if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("CBAUAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("AEPCAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90011615180158"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90101682061018"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference()); // Set LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				}
			}

			// Repeat the same structure for CREDITTRAN
			for (BRECON_TTUM_TRANSACTION_ENTITY debitTransaction : CREDITTRAN) {
				if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("AEPCAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("AEPCAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90011615180158"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90011615180157"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_value_date_time()); // Set LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				}

				else if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("AEPCAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("CBAUAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90101682061018"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90011615180158"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_value_date_time()); // Set LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				}

				else if (debitTransaction.getNtry_dbtragt_bicfi_debit().equals("CBAUAEAA")
						&& debitTransaction.getNtry_cdtragt_bicfi_credit().equals("AEPCAEAA")) {

					// Set debit account number
					BRECON_TTUM_TRANSACTION_ENTITY debitEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					debitEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					debitEntry.setAccount_no("90011615180158"); // Debit account number
					debitEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					debitEntry.setNtry_credit_debit_indicator("D");
					debitEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference());
					debitEntry.setTransaction_currency(debitTransaction.getTransaction_currency());
					returnrecord.add(debitEntry);

					// Set credit account number
					BRECON_TTUM_TRANSACTION_ENTITY creditEntry = new BRECON_TTUM_TRANSACTION_ENTITY();
					creditEntry.setStmt_account_identifier(debitTransaction.getStmt_account_identifier());
					creditEntry.setAccount_no("90101682061018"); // Credit account number
					creditEntry.setNtry_transaction_amount(debitTransaction.getNtry_transaction_amount());
					creditEntry.setNtry_credit_debit_indicator("C"); // Credit indicator
					creditEntry.setNtry_entry_reference(debitTransaction.getNtry_entry_reference()); // Set LAC
					creditEntry.setTransaction_currency(debitTransaction.getTransaction_currency()); // reference
					returnrecord.add(creditEntry);
					creditCounter++;
				}
			}

			// Generating Excel if returnrecord is not empty
			if (!returnrecord.isEmpty()) {
				try (Workbook workbook = new XSSFWorkbook()) {
					Sheet sheet = workbook.createSheet("Sheet1");

					Row headerRow = sheet.createRow(0);
					CellStyle headerStyle = workbook.createCellStyle();
					Font font = workbook.createFont();
					font.setBold(true);
					headerStyle.setFont(font);

					String[] headers = { "GENERATE_DATE", "ACCT_NO", "PARTICULARS", "CURRENCY", "CR_DR_IND",
							"TRAN_AMT" };
					for (int i = 0; i < headers.length; i++) {
						Cell headerCell = headerRow.createCell(i);
						headerCell.setCellValue(headers[i]);
						headerCell.setCellStyle(headerStyle);
					}

					CellStyle dateCellStyle = workbook.createCellStyle();
					DataFormat dataFormat = workbook.createDataFormat();
					dateCellStyle.setDataFormat(dataFormat.getFormat("dd-MM-yyyy"));

					// Assuming report_date is of type java.util.Date
					LocalDate reportDate = report_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

					DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					String formattedReportDate = reportDate.format(formatter1);

					int rowIndex = 1;
					// Create lists to separate debit and credit transactions
					List<BRECON_TTUM_TRANSACTION_ENTITY> debitRecords = new ArrayList<>();
					List<BRECON_TTUM_TRANSACTION_ENTITY> creditRecords = new ArrayList<>();

					// Separate records into debit and credit lists
					for (BRECON_TTUM_TRANSACTION_ENTITY returnedValue : returnrecord) {
						BigDecimal transactionAmount = returnedValue.getNtry_transaction_amount().setScale(2,
								BigDecimal.ROUND_HALF_UP); // Format amount to 2 decimal places
						returnedValue.setNtry_transaction_amount(transactionAmount); // Set the formatted amount

						if ("D".equals(returnedValue.getNtry_credit_debit_indicator())) { // Assuming "D" indicates
																							// debit
							debitRecords.add(returnedValue);
						} else if ("C".equals(returnedValue.getNtry_credit_debit_indicator())) { // Assuming "C"
																									// indicates credit
							creditRecords.add(returnedValue);
						}
					}

					// Sort debit records by transaction amount in ascending order
					debitRecords.sort(Comparator.comparing(BRECON_TTUM_TRANSACTION_ENTITY::getNtry_transaction_amount));

					// Sort credit records by transaction amount in ascending order
					creditRecords
							.sort(Comparator.comparing(BRECON_TTUM_TRANSACTION_ENTITY::getNtry_transaction_amount));

					// Populate the sheet with debit records first
					for (BRECON_TTUM_TRANSACTION_ENTITY debitRecord : debitRecords) {
						Row row = sheet.createRow(rowIndex++);
						Cell dateCell = row.createCell(0);
						dateCell.setCellValue(reportDate.format(formatter1));
						dateCell.setCellStyle(dateCellStyle); // Apply date format

						row.createCell(1).setCellValue(debitRecord.getAccount_no());
						row.createCell(2).setCellValue(debitRecord.getNtry_entry_reference());
						row.createCell(3).setCellValue(debitRecord.getTransaction_currency()); // Currency
						row.createCell(4).setCellValue(debitRecord.getNtry_credit_debit_indicator());
						row.createCell(5).setCellValue(debitRecord.getNtry_transaction_amount().doubleValue());
					}

					// Populate the sheet with credit records next
					for (BRECON_TTUM_TRANSACTION_ENTITY creditRecord : creditRecords) {
						Row row = sheet.createRow(rowIndex++);
						Cell dateCell = row.createCell(0);
						dateCell.setCellValue(reportDate.format(formatter1));
						dateCell.setCellStyle(dateCellStyle); // Apply date format

						row.createCell(1).setCellValue(creditRecord.getAccount_no());
						row.createCell(2).setCellValue(creditRecord.getNtry_entry_reference());
						row.createCell(3).setCellValue(creditRecord.getTransaction_currency()); // Currency
						row.createCell(4).setCellValue(creditRecord.getNtry_credit_debit_indicator());
						row.createCell(5).setCellValue(creditRecord.getNtry_transaction_amount().doubleValue());
					}

					for (int i = 0; i < 6; i++) {
						sheet.autoSizeColumn(i);
					}

					ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
					workbook.write(outputStream);

					// Set up headers for file download
					HttpHeaders headers1 = new HttpHeaders();
					headers1.add(HttpHeaders.CONTENT_DISPOSITION,
							"attachment; filename=LAC_TTUM_" + formattedYesterdayDate.replace(".", "-") + ".xlsx");
					ByteArrayResource resource = new ByteArrayResource(outputStream.toByteArray());

					return ResponseEntity.ok().headers(headers1).contentLength(outputStream.size())
							.contentType(MediaType.parseMediaType(
									"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
							.body(resource);
				} catch (IOException e) {
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.body(Collections.singletonMap("message", "Error generating the file."));
				}
			}
		}
		// Return a bad request if there is no data to generate the report
		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(Collections.singletonMap("message", "No data available to generate the report."));
	}

	@PostMapping("/commoantablemerge")
	public ResponseEntity<?> handleReportDateSubmission(
			@RequestParam("report_date") @DateTimeFormat(pattern = "dd-MM-yyyy") Date report_date) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		String formattedDate = dateFormat.format(report_date);

		java.sql.Date sqlDate = new java.sql.Date(report_date.getTime());

		String datassvalue = coresystemlistrep.getcoresystemlistdatavalues1(formattedDate.toUpperCase());
		String datavalues1 = bRECON_Common_Table_Rep.getcoresystemlistdatavalues1(formattedDate.toUpperCase());

		if (datassvalue == null || datassvalue.isEmpty()) {
			return ResponseEntity
					.ok("No matching transaction date found for the provided report date: " + formattedDate);
		} else if (datavalues1 != null && !datavalues1.isEmpty()) {
			return ResponseEntity.ok("Records Already Updated common table for date: " + formattedDate);
		} else {
			callStoredProcedure.callBreconMappingProcedure(sqlDate);
			return ResponseEntity.ok("File Updated Successfully for date: " + formattedDate);
		}
	}

	@GetMapping("businesstrailvaluesdatas")
	public AuditTablePojo businesstrailvaluesdatas(
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") Date fromDateToUse) {

		if (fromDateToUse == null) {
			System.out.println("No date provided. Please specify a date.");
			return null; // Or return a new MANUAL_Service_Entity with default values if needed
		}

		System.out.println("Received Date: " + fromDateToUse);

		// Format the date to Oracle's expected timestamp format with milliseconds
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy hh.mm.ss.SSS a", Locale.ENGLISH);
		String formattedDate = formatter.format(fromDateToUse);

		// Print the formatted date for verification
		System.out.println("Formatted Date for Query: " + formattedDate);

		// Query with the formatted date
		AuditTablePojo accountvalue = getauditListLocalvaluesbusiness(formattedDate);

		return accountvalue != null ? accountvalue : new AuditTablePojo(); // Return empty entity if null
	}

	public AuditTablePojo getauditListLocalvaluesbusiness(String fromDateToUse) {
		MANUAL_Service_Entity ipsAudit = mANUAL_Service_Rep.getauditListLocalvaluesbusiness1(fromDateToUse);

		if (ipsAudit == null) {
			return null; // Return null if no data is found
		}

		AuditTablePojo auditTablePojo = new AuditTablePojo();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		// Populate AuditTablePojo fields
		auditTablePojo.setAudit_table(ipsAudit.getAudit_table());
		auditTablePojo.setFunc_code(ipsAudit.getFunc_code());
		auditTablePojo.setEntry_user(ipsAudit.getEntry_user());
		auditTablePojo.setEntry_time(ipsAudit.getEntry_time());
		auditTablePojo.setAuth_user(ipsAudit.getAuth_user());
		auditTablePojo.setAuth_time(ipsAudit.getAuth_time());
		auditTablePojo.setRemarks(ipsAudit.getRemarks());

		// Ensure field_name, old_value, and new_value are processed even if null
		List<String> fieldName = new ArrayList<>();
		List<String> oldvalue = new ArrayList<>();
		List<String> newvalue = new ArrayList<>();

		List<String> oldValues = ipsAudit.getOld_value() != null ? rowSeparator(ipsAudit.getOld_value())
				: new ArrayList<>();
		List<String> newValues = ipsAudit.getNew_value() != null ? rowSeparator(ipsAudit.getNew_value())
				: new ArrayList<>();
		List<String> fields = ipsAudit.getField_name() != null ? rowSeparator(ipsAudit.getField_name())
				: new ArrayList<>();

		// Determine the maximum size among the lists
		int maxSize = Math.max(fields.size(), Math.max(oldValues.size(), newValues.size()));

		// Populate values while ensuring safe handling of nulls and size mismatches
		for (int i = 0; i < maxSize; i++) {
			fieldName.add(i < fields.size() ? fields.get(i) : "-");
			String oldFormatted = i < oldValues.size() ? formatDate(oldValues.get(i), dateFormat) : "-";
			String newFormatted = i < newValues.size() ? formatDate(newValues.get(i), dateFormat) : "-";

			oldvalue.add(oldFormatted);
			newvalue.add(newFormatted);
		}

		auditTablePojo.setField_name(fieldName);
		auditTablePojo.setOld_value(oldvalue);
		auditTablePojo.setNew_value(newvalue);

		return auditTablePojo;
	}

	private List<String> rowSeparator(String value) {
		// Split the string by "||" and return the resulting parts as a list
		List<String> separatedValues = new ArrayList<>();

		if (value != null && !value.isEmpty()) {
			String[] parts = value.split("\\|\\|");

			for (String part : parts) {
				separatedValues.add(part.trim()); // Add each part to the list after trimming any extra spaces
			}
		}

		return separatedValues;
	}

	private String formatDate(String value, SimpleDateFormat dateFormat) {
		try {
			// Adjust input format to parse "yyyy-MM-dd HH:mm:ss.S" format
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			Date date = inputFormat.parse(value); // Parse to Date object
			return dateFormat.format(date); // Format it into dd-MM-yyyy
		} catch (ParseException e) {
			// If parsing fails, return the original value
			return value;
		}
	}

	@RequestMapping("/personalval")
	public List<Object[]> personalval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.getper(cifId, acctNo);
		return result;
	}

	@RequestMapping("/addressval")
	public List<Object[]> addressval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.getadres(cifId, acctNo);
		return result;
	}

	@RequestMapping("/tranval")
	public List<Object[]> tranval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.gettran(cifId, acctNo);
		System.out.println("Result size: " + result.size());
		return result;
	}

	@RequestMapping("/acctval")
	public List<Object[]> acctval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.getacct(cifId, acctNo);
		return result;
	}

	@RequestMapping("/tradeval")
	public List<Object[]> tradeval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.gettrade(cifId, acctNo);
		return result;
	}

	@RequestMapping("/empval")
	public List<Object[]> empval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.getemp(cifId, acctNo);
		return result;
	}

	@RequestMapping("/docval")
	public List<Object[]> docval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.getdoc(cifId, acctNo);
		return result;
	}

	@RequestMapping("/signval")
	public List<Object[]> signval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.getsign(cifId, acctNo);
		return result;
	}

	@RequestMapping("/associatedval")
	public List<Object[]> associatedval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getassociated(cifId, acctNo);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/jointsval")
	public List<Object[]> jointsval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.getjoints(cifId, acctNo);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/photosval")
	public List<Object[]> photosval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.getpics(cifId, acctNo);
		return result;
	}

	/*
	 * @RequestMapping("/documentval") public List<Object[]>
	 * documentval(@RequestParam("cifId") String cifId) {
	 * System.out.println("cifId: " + cifId); List<Object[]> result =
	 * charge_Back_Rep.getdoc(cifId); return result; }
	 */

	/* cust profile */
	/*
	 * =============================================================================
	 * ===
	 */

	@RequestMapping("/personval")
	public List<Object[]> personval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getpersonal(cifId);
		return result;
	}

	@RequestMapping("/adrsval")
	public List<Object[]> adrsval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getadress(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/tradval")
	public List<Object[]> tradval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.gettrad(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/employeval")
	public List<Object[]> employeeval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getemploye(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/documentval")
	public List<Object[]> documentval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getdocument(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/acctsval")
	public List<Object[]> acctsval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getaccts(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/transval")
	public List<Object[]> transval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.gettrans(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/photoval")
	public List<Object[]> photoval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);

		List<Object[]> result = charge_Back_Rep.getpic(cifId);
		return result;
	}

	@RequestMapping("/signatureval")
	public List<Object[]> signatureval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getsignature(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/jointval")
	public List<Object[]> jointval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getjoint(cifId);

		return result; // Make sure result contains the expected data
	}

	/*------------------Cust Profile -Trade finance flag--------------------*/

	@RequestMapping("/bankflgval")
	public List<Object[]> bankflgval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getbankflg(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/tradflgval")
	public List<Object[]> tradflgval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.gettradflg(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/letterofcreditval")
	public List<Object[]> letterofcreditval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getLetofcredit(cifId);

		return result; // Make sure result contains the expected data
	}

	/*---------------------Acct profile -Trade finance flag---------------------*/
	/*
	 * @RequestMapping("/bankflgsval") public List<Object[]>
	 * bankflgsval(@RequestParam("cifId") String cifId) {
	 * System.out.println("cifId: " + cifId); List<Object[]> result =
	 * charge_Back_Rep.getbankflag(cifId); return result; // Make sure result
	 * contains the expected data }
	 */

	@RequestMapping("/bankflgsval")
	public List<Object[]> bankflgsval(@RequestParam("cifId") String cifId, @RequestParam("acctNo") String acctNo) {
		System.out.println("cifId: " + cifId);
		System.out.println("acctNo: " + acctNo);
		List<Object[]> result = charge_Back_Rep.getbankflag(cifId, acctNo);
		return result;
	}

	@RequestMapping("/tradeflgval")
	public List<Object[]> tradeflgval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.gettradeflg(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/lettercreditval")
	public List<Object[]> lettercreditval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getLetofcreditS(cifId);

		return result; // Make sure result contains the expected data
	}

	@RequestMapping("/associateval")
	public List<Object[]> associateval(@RequestParam("cifId") String cifId) {
		System.out.println("cifId: " + cifId);
		List<Object[]> result = charge_Back_Rep.getassociate(cifId);

		return result; // Make sure result contains the expected data
	}

	@GetMapping("getcif")
	public List<Object[]> getcif(@RequestParam(required = false) String natIdNum) {
		List<Object[]> cifdetail = charge_Back_Rep.getcif(natIdNum);
		return cifdetail;
	}

	@GetMapping("getcifall")
	public List<Object[]> getcifall(@RequestParam(required = false) String natIdNum) {
		List<Object[]> cifdetail = charge_Back_Rep.getcifall(natIdNum);
		return cifdetail;
	}

	@GetMapping("getcifRetail")
	public List<Object[]> getcifRetail(@RequestParam(required = false) String natIdNum) {
		List<Object[]> cifdetail = charge_Back_Rep.getcifRetail(natIdNum);
		return cifdetail;
	}

	@GetMapping("getcif1")
	public List<Object[]> getcif1(@RequestParam(required = false) String natIdNum) {
		List<Object[]> cifdetail = charge_Back_Rep.getcif1(natIdNum);
		return cifdetail;
	}

	@GetMapping("getcifall1")
	public List<Object[]> getcifall1(@RequestParam(required = false) String natIdNum) {
		List<Object[]> cifdetail = charge_Back_Rep.getcifall1(natIdNum);
		return cifdetail;
	}

	@GetMapping("getcifRetail1")
	public List<Object[]> getcifRetail1(@RequestParam(required = false) String natIdNum) {
		List<Object[]> cifdetail = charge_Back_Rep.getcifRetail1(natIdNum);
		return cifdetail;
	}

	@GetMapping("dashboarddatavalues")
	public List<Object> dashboarddatavalues(
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date fromDateToUse) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

		// Convert the Date object to String
		String formattedDate = sdf.format(fromDateToUse);
		List<Object> accountvalue = bRECON_DESTINATION_REPO.getlistvalues(formattedDate.toUpperCase(),
				formattedDate.toUpperCase());
		System.out.println("The entered account date is: " + fromDateToUse);
		return accountvalue;
	}

	@RequestMapping(value = "processingdatavalues", method = RequestMethod.POST)
	@ResponseBody
	public String processingdatavalues(@RequestBody List<List<String>> formdatas) {

		List<BRECON_Common_Table_Entity> finalcommonDatas = new ArrayList<>();

		for (List<String> rowData : formdatas) {

			// Ensure there are enough elements in the row
			if (rowData.size() > 13) {
				try {
					String specificValueCore = rowData.get(5); // For core data
					String specificValueDest = rowData.get(12); // For destination data
					String tranamt = rowData.get(11);

					// Fetch core and destination data for the same row
					List<Brecon_core_entity> coreDatas = coresystemlistrep
							.getcoresystemlistdatavalues11(specificValueCore, tranamt);
					List<BRECON_DESTINATION_ENTITY> destinationDatas = bRECON_DESTINATION_REPO
							.getReportNamesvaluesdata(specificValueDest);

					// Combine core and destination data for the same row
					for (int i = 0; i < Math.max(coreDatas.size(), destinationDatas.size()); i++) {
						BRECON_Common_Table_Entity commonData = new BRECON_Common_Table_Entity();

						if (i < coreDatas.size()) {
							Brecon_core_entity coreData = coreDatas.get(i);
							commonData.setAcid(coreData.getAcid());
							commonData.setAmt_reservation_ind(coreData.getAmt_reservation_ind());
							commonData.setBank_code(coreData.getBank_code());
							commonData.setBank_id(coreData.getBank_id());
							commonData.setBkdt_tran_flg(coreData.getBkdt_tran_flg());
							commonData.setBr_code(coreData.getBr_code());
							commonData.setCreate_time(coreData.getCreate_time());
							commonData.setCreate_user(coreData.getCreate_user());
							commonData.setCrncy_code(coreData.getCrncy_code());
							commonData.setCrncy_hol_chk_done_flg(coreData.getCrncy_hol_chk_done_flg());
							commonData.setCust_id(coreData.getCust_id());
							commonData.setDel_flg(coreData.getDel_flg());
							commonData.setDel_memo_pad(coreData.getDel_memo_pad());
							commonData.setDth_init_sol_id(coreData.getDth_init_sol_id());
							commonData.setEabfab_upd_flg(coreData.getEabfab_upd_flg());
							commonData.setEntity_flg(coreData.getEntity_flg());
							commonData.setEntry_date(coreData.getEntry_date());
							commonData.setEntry_user_id(coreData.getEntry_user_id());
							commonData.setFx_tran_amt(coreData.getFx_tran_amt());
							commonData.setGl_date(coreData.getGl_date());
							commonData.setGl_segment_string(coreData.getGl_segment_string());
							commonData.setGl_sub_head_code(coreData.getGl_sub_head_code());
							commonData.setGst_upd_flg(coreData.getGst_upd_flg());
							commonData.setImpl_cash_part_tran_flg(coreData.getImpl_cash_part_tran_flg());
							commonData.setInstrmnt_alpha(coreData.getInstrmnt_alpha());
							commonData.setInstrmnt_date(coreData.getInstrmnt_date());
							commonData.setInstrmnt_num(coreData.getInstrmnt_num());
							commonData.setInstrmnt_type(coreData.getInstrmnt_type());
							commonData.setIso_flg(coreData.getIso_flg());
							commonData.setLchg_time(coreData.getLchg_time());
							commonData.setLchg_user_id(coreData.getLchg_user_id());
							commonData.setLift_lien_flg(coreData.getLift_lien_flg());
							commonData.setModify_flg(coreData.getModify_flg());
							commonData.setModify_time(coreData.getModify_time());
							commonData.setModify_user(coreData.getModify_user());
							commonData.setModule_id(coreData.getModule_id());
							commonData.setMud_pool_bal_build_flg(coreData.getMud_pool_bal_build_flg());
							commonData.setNavigation_flg(coreData.getNavigation_flg());
							commonData.setParty_code(coreData.getParty_code());
							commonData.setPart_tran_srl_num(coreData.getPart_tran_srl_num());
							commonData.setPart_tran_type(coreData.getPart_tran_type());
							commonData.setPrincipal_portion_amt(coreData.getPrincipal_portion_amt());
							commonData.setPrnt_advc_ind(coreData.getPrnt_advc_ind());
							commonData.setProxy_acid(coreData.getProxy_acid());
							commonData.setProxy_post_ind(coreData.getProxy_post_ind());
							commonData.setPr_srl_num(coreData.getPr_srl_num());
							commonData.setPstd_date(coreData.getPstd_date());
							commonData.setPstd_flg(coreData.getPstd_flg());
							commonData.setPstd_user_id(coreData.getPstd_user_id());
							commonData.setPtran_chrg_exists_flg(coreData.getPtran_chrg_exists_flg());
							commonData.setPttm_event_type(coreData.getPttm_event_type());
							commonData.setRate(coreData.getRate());
							commonData.setRate_code(coreData.getRate_code());
							commonData.setRcre_time(coreData.getRcre_time());
							commonData.setRcre_user_id(coreData.getRcre_user_id());
							commonData.setRecon_date(coreData.getRecon_date());
							commonData.setRecon_flag(coreData.getRecon_flag());
							commonData.setReferral_id(coreData.getReferral_id());
							commonData.setRef_amt(coreData.getRef_amt());
							commonData.setRef_crncy_code(coreData.getRef_crncy_code());
							commonData.setRef_num(coreData.getRef_num());
							commonData.setRegularization_amt(coreData.getRegularization_amt());
							commonData.setReport_date(coreData.getReport_date());
							commonData.setReport_from_date(coreData.getReport_from_date());
							commonData.setReport_to_date(coreData.getReport_to_date());
							commonData.setReservation_amt(coreData.getReservation_amt());
							commonData.setRestrict_modify_ind(coreData.getRestrict_modify_ind());
							commonData.setReversal_date(coreData.getReversal_date());
							commonData.setReversal_value_date(coreData.getReversal_value_date());
							commonData.setRpt_code(coreData.getRpt_code());
							commonData.setSerial_num(coreData.getSerial_num());
							commonData.setSi_org_exec_date(coreData.getSi_org_exec_date());
							commonData.setSi_srl_num(coreData.getSi_srl_num());
							commonData.setSol_id(coreData.getSol_id());
							commonData.setSvs_tran_id(coreData.getSvs_tran_id());
							commonData.setSys_part_tran_code(coreData.getSys_part_tran_code());
							commonData.setTf_entity_sol_id(coreData.getTf_entity_sol_id());
							commonData.setTod_entity_id(coreData.getTod_entity_id());
							commonData.setTod_entity_type(coreData.getTod_entity_type());
							commonData.setTran_amt(coreData.getTran_amt());
							commonData.setTran_crncy_code(coreData.getTran_crncy_code());
							commonData.setTran_date(coreData.getTran_date());
							commonData.setTran_free_code1(coreData.getTran_free_code1());
							commonData.setTran_free_code2(coreData.getTran_free_code2());
							commonData.setTran_id(coreData.getTran_id());
							commonData.setTran_particular(coreData.getTran_particular());
							commonData.setTran_particular_2(coreData.getTran_particular_2());
							commonData.setTran_particular_code(coreData.getTran_particular_code());
							commonData.setTran_rmks(coreData.getTran_rmks());
							commonData.setTran_sub_type(coreData.getTran_sub_type());
							commonData.setTran_type(coreData.getTran_type());
							commonData.setTrea_rate(coreData.getTrea_rate());
							commonData.setTrea_ref_num(coreData.getTrea_ref_num());
							commonData.setTr_status(coreData.getTr_status());
							commonData.setTs_cnt(coreData.getTs_cnt());
							commonData.setUad_module_id(coreData.getUad_module_id());
							commonData.setUad_module_key(coreData.getUad_module_key());
							commonData.setUser_part_tran_code(coreData.getUser_part_tran_code());
							commonData.setValue_date(coreData.getValue_date());
							commonData.setVerify_time(coreData.getVerify_time());
							commonData.setVerify_user(coreData.getVerify_user());
							commonData.setVfd_date(coreData.getVfd_date());
							commonData.setVfd_user_id(coreData.getVfd_user_id());
							commonData.setVoucher_print_flg(coreData.getVoucher_print_flg());
						}

						if (i < destinationDatas.size()) {
							BRECON_DESTINATION_ENTITY destinationData = destinationDatas.get(i);
							commonData.setAccount_no(destinationData.getAccount_no());
							commonData.setCanonicalizationmethod_algorithm(
									destinationData.getCanonicalizationmethod_algorithm());
							commonData.setDigestmethod_algorithm(destinationData.getDigestmethod_algorithm());
							commonData.setGrphdr_bank_identifier_code(destinationData.getGrphdr_bank_identifier_code());
							commonData.setGrphdr_creation_date_time(destinationData.getGrphdr_creation_date_time());
							commonData.setGrphdr_last_page_indicator(destinationData.getGrphdr_last_page_indicator());
							commonData.setGrphdr_message_identifier(destinationData.getGrphdr_message_identifier());
							commonData.setGrphdr_name(destinationData.getGrphdr_name());
							commonData.setGrphdr_page_number(destinationData.getGrphdr_page_number());
							commonData.setNtry_account_servicer_reference(
									destinationData.getNtry_account_servicer_reference());
							commonData.setNtry_amount_currency(destinationData.getNtry_amount_currency());
							commonData.setNtry_booking_date(destinationData.getNtry_booking_date());
							commonData.setNtry_booking_date_time(destinationData.getNtry_booking_date_time());
							commonData.setNtry_brch_cdtdbtint(destinationData.getNtry_brch_cdtdbtint());
							commonData.setNtry_btch_currency(destinationData.getNtry_btch_currency());
							commonData.setNtry_btch_msg_id(destinationData.getNtry_btch_msg_id());
							commonData.setNtry_btch_numoftxs(destinationData.getNtry_btch_numoftxs());
							commonData.setNtry_btch_ttlamt(destinationData.getNtry_btch_ttlamt());
							commonData.setNtry_cdtragt_bicfi_credit(destinationData.getNtry_cdtragt_bicfi_credit());
							commonData.setNtry_code(destinationData.getNtry_code());
							commonData.setNtry_credit_debit_indicator(destinationData.getNtry_credit_debit_indicator());
							commonData.setNtry_dbtragt_bicfi_debit(destinationData.getNtry_dbtragt_bicfi_debit());
							commonData.setNtry_entry_reference(destinationData.getNtry_entry_reference());
							commonData.setNtry_fininstnid_bicfi(destinationData.getNtry_fininstnid_bicfi());
							commonData.setNtry_instructed_amount(destinationData.getNtry_instructed_amount());
							commonData.setNtry_proprietary_code(destinationData.getNtry_proprietary_code());
							commonData.setNtry_refs_account_servicer_reference(
									destinationData.getNtry_refs_account_servicer_reference());
							commonData.setNtry_refs_clearing_system_reference(
									destinationData.getNtry_refs_clearing_system_reference());
							commonData.setNtry_refs_end_to_end_identification(
									destinationData.getNtry_refs_end_to_end_identification());
							commonData.setNtry_refs_instruction_id(destinationData.getNtry_refs_instruction_id());
							commonData
									.setNtry_refs_message_identifier(destinationData.getNtry_refs_message_identifier());
							commonData.setNtry_refs_pmtinfid(destinationData.getNtry_refs_pmtinfid());
							commonData.setNtry_refs_transaction_id(destinationData.getNtry_refs_transaction_id());
							commonData.setNtry_refs_uetr(destinationData.getNtry_refs_uetr());
							commonData.setNtry_transaction_amount(destinationData.getNtry_transaction_amount());
							commonData.setNtry_txdtls_amount_currency(destinationData.getNtry_txdtls_amount_currency());
							commonData.setNtry_txdtls_credit_debit_indicator(
									destinationData.getNtry_txdtls_credit_debit_indicator());
							commonData.setNtry_value_date(destinationData.getNtry_value_date());
							commonData.setNtry_value_date_time(destinationData.getNtry_value_date_time());
							commonData.setReport_name(destinationData.getReport_name());
							commonData.setSignaturemethod_algorithm(destinationData.getSignaturemethod_algorithm());
							commonData.setSignature_keyinfo_x509_certificate(
									destinationData.getSignature_keyinfo_x509_certificate());
							commonData.setSignature_keyinfo_x509_subject_name(
									destinationData.getSignature_keyinfo_x509_subject_name());
							commonData.setSignature_signedinfo_digest_value(
									destinationData.getSignature_signedinfo_digest_value());
							commonData.setSignature_signedinfo_signature_value(
									destinationData.getSignature_signedinfo_signature_value());
							commonData.setStmt_account_identifier(destinationData.getStmt_account_identifier());
							commonData.setStmt_bal1_amount(destinationData.getStmt_bal1_amount());
							commonData.setStmt_bal1_code_or_proprietary(
									destinationData.getStmt_bal1_code_or_proprietary());
							commonData.setStmt_bal1_credit_debit_indicator(
									destinationData.getStmt_bal1_credit_debit_indicator());
							commonData.setStmt_bal1_date(destinationData.getStmt_bal1_date());
							commonData.setStmt_bal1_date_time(destinationData.getStmt_bal1_date_time());
							commonData.setStmt_bal_amount(destinationData.getStmt_bal_amount());
							commonData
									.setStmt_bal_code_or_proprietary(destinationData.getStmt_bal_code_or_proprietary());
							commonData.setStmt_bal_credit_debit_indicator(
									destinationData.getStmt_bal_credit_debit_indicator());
							commonData.setStmt_bal_date(destinationData.getStmt_bal_date());
							commonData.setStmt_bal_date_time(destinationData.getStmt_bal_date_time());
							commonData.setStmt_creation_date_time(destinationData.getStmt_creation_date_time());
							commonData.setStmt_electronic_sequence_number(
									destinationData.getStmt_electronic_sequence_number());
							commonData.setStmt_from_date_time(destinationData.getStmt_from_date_time());
							commonData.setStmt_related_account_identifier(
									destinationData.getStmt_related_account_identifier());
							commonData.setStmt_statement_identifier(destinationData.getStmt_statement_identifier());
							commonData.setStmt_to_date_time(destinationData.getStmt_to_date_time());
							commonData.setTransaction_currency(destinationData.getTransaction_currency());
							commonData.setTransform_algorithm(destinationData.getTransform_algorithm());
							commonData.setTxssummry_amount(destinationData.getTxssummry_amount());
							commonData.setTxssummry_credit_debit_indicator(
									destinationData.getTxssummry_credit_debit_indicator());
							commonData.setTxssummry_credit_number_of_entries(
									destinationData.getTxssummry_credit_number_of_entries());
							commonData.setTxssummry_credit_sum(destinationData.getTxssummry_credit_sum());
							commonData.setTxssummry_debit_number_of_entries(
									destinationData.getTxssummry_debit_number_of_entries());
							commonData.setTxssummry_debit_sum(destinationData.getTxssummry_debit_sum());
							commonData.setTxssummry_number_of_entries(destinationData.getTxssummry_number_of_entries());
							commonData.setTxssummry_sum(destinationData.getTxssummry_sum());
						}
						commonData.setSrlno(bRECON_Common_Table_Rep.srlno());
						finalcommonDatas.add(commonData);
					}
					bRECON_Common_Table_Rep.saveAll(finalcommonDatas);

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Warning: Row data does not contain enough elements (less than 14). Skipping row.");
			}
		}

		return "Updated Successfully";
	}

}
