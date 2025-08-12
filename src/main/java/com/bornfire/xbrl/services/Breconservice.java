package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bornfire.xbrl.entities.BRECON_TTUM_TRANSACTION_ENTITY;
import com.bornfire.xbrl.entities.BRECON_TTUM_TRANSACTION_REP;
import com.bornfire.xbrl.entities.Brecon_Aani_payment_dup_rep;
import com.bornfire.xbrl.entities.Brecon_aani_payment_duplicate_entity;
import com.bornfire.xbrl.entities.BNPSRECON.BRECON_Audit_Rep;
import com.bornfire.xbrl.entities.BNPSRECON.BRECON_DESTINATION_ENTITY;
import com.bornfire.xbrl.entities.BNPSRECON.BRECON_DESTINATION_REPO;

import FYItransactions.Balance;
import FYItransactions.Entry;

@Service
public class Breconservice {
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Breconservice.class);

	@Autowired
	BRECON_TTUM_TRANSACTION_REP brecon_ttum_transaction_rep;

	@Autowired
	BRECON_DESTINATION_REPO bRECON_DESTINATION_REPO;

	@Autowired
	BRECON_Audit_Rep bRECON_Audit_Rep;

	@Autowired
	Brecon_Aani_payment_dup_rep Brecon_Aani_payment_dup_rep;

	public String StoreAANIPaymentstatementdetails(String grphdr_message_identifier, Date grphdr_creation_date_time,
			String grphdr_name, String grphdr_bank_identifier_code, BigDecimal grphdr_page_number,
			String grphdr_last_page_indicator, String stmt_statement_identifier,
			BigDecimal stmt_electronic_sequence_number, Date stmt_creation_date_time, Date stmt_from_date_time,
			Date stmt_to_date_time, String stmt_account_identifier, String stmt_related_account_identifier,
			String stmt_bal_code_or_proprietary, BigDecimal stmt_bal_amount, String stmt_bal_credit_debit_indicator,
			Date stmt_bal_date, Date stmt_bal_date_time, BigDecimal txssummry_number_of_entries,
			BigDecimal txssummry_sum, BigDecimal txssummry_amount, String txssummry_credit_debit_indicator,
			BigDecimal txssummry_credit_number_of_entries, BigDecimal txssummry_credit_sum,
			BigDecimal txssummry_debit_number_of_entries, BigDecimal txssummry_debit_sum, String ntry_entry_reference,
			BigDecimal ntry_amount_currency, String ntry_credit_debit_indicator, String ntry_code,
			Date ntry_booking_date, Date ntry_booking_date_time, Date ntry_value_date, String ntry_value_date_time,
			String ntry_account_servicer_reference, String ntry_proprietary_code, BigDecimal ntry_instructed_amount,
			BigDecimal ntry_transaction_amount, String ntry_refs_message_identifier,
			String ntry_refs_account_servicer_reference, String ntry_refs_end_to_end_identification,
			String ntry_refs_transaction_id, String ntry_refs_clearing_system_reference,
			BigDecimal ntry_txdtls_amount_currency, String ntry_txdtls_credit_debit_indicator,
			String ntry_fininstnid_bicfi, String ntry_dbtragt_bicfi_debit, String ntry_cdtragt_bicfi_credit,
			String signature_signedinfo_digest_value, String signature_signedinfo_signature_value,
			String signature_keyinfo_x509_subject_name, String signature_keyinfo_x509_certificate,
			String canonicalizationmethod_algorithm, String signaturemethod_algorithm, String transform_algorithm,
			String digestmethod_algorithm, String report_name, String ntry_refs_pmtinfid, String ntry_refs_uetr,
			String stmt_bal1_code_or_proprietary, BigDecimal stmt_bal1_amount, String stmt_bal1_credit_debit_indicator,
			Date stmt_bal1_date, Date stmt_bal1_date_time, String transaction_currency) {

		BRECON_DESTINATION_ENTITY Destinationdet = new BRECON_DESTINATION_ENTITY();

		String Msg = null;

		logger.info("Data Stored start for " + ntry_refs_clearing_system_reference);

		// Destinationdet.setAccount_no();
		Destinationdet.setGrphdr_message_identifier(grphdr_message_identifier);
		Destinationdet.setGrphdr_creation_date_time(grphdr_creation_date_time);
		Destinationdet.setGrphdr_name(grphdr_name);
		Destinationdet.setGrphdr_bank_identifier_code(grphdr_bank_identifier_code);
		Destinationdet.setGrphdr_page_number(grphdr_page_number);
		Destinationdet.setGrphdr_last_page_indicator(grphdr_last_page_indicator);
		Destinationdet.setStmt_statement_identifier(stmt_statement_identifier);
		Destinationdet.setStmt_electronic_sequence_number(stmt_electronic_sequence_number);
		Destinationdet.setStmt_creation_date_time(stmt_creation_date_time);
		Destinationdet.setStmt_from_date_time(stmt_from_date_time);
		Destinationdet.setStmt_to_date_time(stmt_to_date_time);
		Destinationdet.setStmt_account_identifier(stmt_account_identifier);
		Destinationdet.setStmt_related_account_identifier(stmt_related_account_identifier);
		Destinationdet.setStmt_bal_code_or_proprietary(stmt_bal_code_or_proprietary);
		Destinationdet.setStmt_bal_amount(stmt_bal_amount);
		Destinationdet.setStmt_bal_credit_debit_indicator(stmt_bal_credit_debit_indicator);
		Destinationdet.setStmt_bal_date(stmt_bal_date);
		Destinationdet.setStmt_bal_date_time(stmt_bal_date_time);
		Destinationdet.setTxssummry_number_of_entries(txssummry_number_of_entries);
		Destinationdet.setTxssummry_sum(txssummry_sum);
		Destinationdet.setTxssummry_amount(txssummry_amount);
		Destinationdet.setTxssummry_credit_debit_indicator(txssummry_credit_debit_indicator);
		Destinationdet.setTxssummry_credit_number_of_entries(txssummry_credit_number_of_entries);
		Destinationdet.setTxssummry_credit_sum(txssummry_credit_sum);
		Destinationdet.setTxssummry_debit_number_of_entries(txssummry_debit_number_of_entries);
		Destinationdet.setTxssummry_debit_sum(txssummry_debit_sum);
		Destinationdet.setNtry_entry_reference(ntry_entry_reference);
		Destinationdet.setNtry_amount_currency(ntry_amount_currency);
		Destinationdet.setNtry_credit_debit_indicator(ntry_credit_debit_indicator);
		Destinationdet.setNtry_code(ntry_code);
		Destinationdet.setNtry_booking_date(ntry_booking_date);
		Destinationdet.setNtry_booking_date_time(ntry_booking_date_time);
		Destinationdet.setNtry_value_date(ntry_value_date);
		Destinationdet.setNtry_value_date_time(ntry_value_date_time);
		Destinationdet.setNtry_account_servicer_reference(ntry_account_servicer_reference);
		Destinationdet.setNtry_proprietary_code(ntry_proprietary_code);
		Destinationdet.setNtry_instructed_amount(ntry_instructed_amount);
		Destinationdet.setNtry_transaction_amount(ntry_transaction_amount);
		Destinationdet.setNtry_refs_account_servicer_reference(ntry_refs_account_servicer_reference);
		Destinationdet.setNtry_refs_instruction_id("");
		Destinationdet.setNtry_refs_end_to_end_identification(ntry_refs_end_to_end_identification);
		Destinationdet.setNtry_refs_transaction_id(ntry_refs_transaction_id);
		Destinationdet.setNtry_refs_clearing_system_reference(ntry_refs_clearing_system_reference);
		Destinationdet.setNtry_txdtls_amount_currency(ntry_txdtls_amount_currency);
		Destinationdet.setNtry_txdtls_credit_debit_indicator(ntry_txdtls_credit_debit_indicator);
		Destinationdet.setNtry_fininstnid_bicfi(ntry_fininstnid_bicfi);
		Destinationdet.setNtry_dbtragt_bicfi_debit(ntry_dbtragt_bicfi_debit);
		Destinationdet.setNtry_cdtragt_bicfi_credit(ntry_cdtragt_bicfi_credit);
		Destinationdet.setSignature_signedinfo_digest_value(signature_signedinfo_digest_value);
		Destinationdet.setSignature_signedinfo_signature_value(signature_signedinfo_signature_value);
		Destinationdet.setSignature_keyinfo_x509_subject_name(signature_keyinfo_x509_subject_name);
		Destinationdet.setSignature_keyinfo_x509_certificate(signature_keyinfo_x509_certificate);
		Destinationdet.setCanonicalizationmethod_algorithm(canonicalizationmethod_algorithm);
		Destinationdet.setSignaturemethod_algorithm(signaturemethod_algorithm);
		Destinationdet.setTransform_algorithm(transform_algorithm);
		Destinationdet.setDigestmethod_algorithm(digestmethod_algorithm);
		Destinationdet.setReport_name(report_name);
		// Destinationdet.setNtry_btch_msg_id("");
		// Destinationdet.setNtry_btch_numoftxs();
		// Destinationdet.setNtry_btch_ttlamt(ntry_btch_ttlamt);
		// Destinationdet.setNtry_brch_cdtdbtint(ntry_brch_cdtdbtint);
		Destinationdet.setNtry_refs_pmtinfid(ntry_refs_pmtinfid);
		Destinationdet.setNtry_refs_uetr(ntry_refs_uetr);
		Destinationdet.setEntity_flg("Y");
		Destinationdet.setDel_flg("N");
		Destinationdet.setReport_date(new Date());
		Destinationdet.setRecon_flag("N");
		Destinationdet.setSrlno(bRECON_DESTINATION_REPO.srlno());
		Destinationdet.setStmt_bal1_code_or_proprietary(stmt_bal1_code_or_proprietary);
		Destinationdet.setStmt_bal1_amount(stmt_bal1_amount);
		Destinationdet.setStmt_bal1_credit_debit_indicator(stmt_bal1_credit_debit_indicator);
		Destinationdet.setStmt_bal1_date(stmt_bal1_date);
		Destinationdet.setStmt_bal1_date_time(stmt_bal1_date_time);

		bRECON_DESTINATION_REPO.save(Destinationdet);
		return Msg;

	}

	public String StoreAanipaymentduplicates(String grphdr_message_identifier, Date grphdr_creation_date_time,
			String grphdr_name, String grphdr_bank_identifier_code, BigDecimal grphdr_page_number,
			String grphdr_last_page_indicator, String stmt_statement_identifier,
			BigDecimal stmt_electronic_sequence_number, Date stmt_creation_date_time, Date stmt_from_date_time,
			Date stmt_to_date_time, String stmt_account_identifier, String stmt_related_account_identifier,
			String stmt_bal_code_or_proprietary, BigDecimal stmt_bal_amount, String stmt_bal_credit_debit_indicator,
			Date stmt_bal_date, Date stmt_bal_date_time, BigDecimal txssummry_number_of_entries,
			BigDecimal txssummry_sum, BigDecimal txssummry_amount, String txssummry_credit_debit_indicator,
			BigDecimal txssummry_credit_number_of_entries, BigDecimal txssummry_credit_sum,
			BigDecimal txssummry_debit_number_of_entries, BigDecimal txssummry_debit_sum, String ntry_entry_reference,
			BigDecimal ntry_amount_currency, String ntry_credit_debit_indicator, String ntry_code,
			Date ntry_booking_date, Date ntry_booking_date_time, Date ntry_value_date, String ntry_value_date_time,
			String ntry_account_servicer_reference, String ntry_proprietary_code, BigDecimal ntry_instructed_amount,
			BigDecimal ntry_transaction_amount, String ntry_refs_message_identifier,
			String ntry_refs_account_servicer_reference, String ntry_refs_end_to_end_identification,
			String ntry_refs_transaction_id, String ntry_refs_clearing_system_reference,
			BigDecimal ntry_txdtls_amount_currency, String ntry_txdtls_credit_debit_indicator,
			String ntry_fininstnid_bicfi, String ntry_dbtragt_bicfi_debit, String ntry_cdtragt_bicfi_credit,
			String signature_signedinfo_digest_value, String signature_signedinfo_signature_value,
			String signature_keyinfo_x509_subject_name, String signature_keyinfo_x509_certificate,
			String canonicalizationmethod_algorithm, String signaturemethod_algorithm, String transform_algorithm,
			String digestmethod_algorithm, String report_name, String ntry_refs_pmtinfid, String ntry_refs_uetr,
			String stmt_bal1_code_or_proprietary, BigDecimal stmt_bal1_amount, String stmt_bal1_credit_debit_indicator,
			Date stmt_bal1_date, Date stmt_bal1_date_time, String transaction_currency) {

		String Msg = null;

		logger.info("Duplicate data found store in duplicate table - " + ntry_refs_clearing_system_reference);

		Brecon_aani_payment_duplicate_entity AaniPaymentdupli = new Brecon_aani_payment_duplicate_entity();

		AaniPaymentdupli.setGrphdr_message_identifier(grphdr_message_identifier);
		AaniPaymentdupli.setGrphdr_creation_date_time(grphdr_creation_date_time);
		AaniPaymentdupli.setGrphdr_name(grphdr_name);
		AaniPaymentdupli.setGrphdr_bank_identifier_code(grphdr_bank_identifier_code);
		AaniPaymentdupli.setGrphdr_page_number(grphdr_page_number);
		AaniPaymentdupli.setGrphdr_last_page_indicator(grphdr_last_page_indicator);
		AaniPaymentdupli.setStmt_statement_identifier(stmt_statement_identifier);
		AaniPaymentdupli.setStmt_electronic_sequence_number(stmt_electronic_sequence_number);
		AaniPaymentdupli.setStmt_creation_date_time(stmt_creation_date_time);
		AaniPaymentdupli.setStmt_from_date_time(stmt_from_date_time);
		AaniPaymentdupli.setStmt_to_date_time(stmt_to_date_time);
		AaniPaymentdupli.setStmt_account_identifier(stmt_account_identifier);
		AaniPaymentdupli.setStmt_related_account_identifier(stmt_related_account_identifier);
		AaniPaymentdupli.setStmt_bal_code_or_proprietary(stmt_bal_code_or_proprietary);
		AaniPaymentdupli.setStmt_bal_amount(stmt_bal_amount);
		AaniPaymentdupli.setStmt_bal_credit_debit_indicator(stmt_bal_credit_debit_indicator);
		AaniPaymentdupli.setStmt_bal_date(stmt_bal_date);
		AaniPaymentdupli.setStmt_bal_date_time(stmt_bal_date_time);
		AaniPaymentdupli.setTxssummry_number_of_entries(txssummry_number_of_entries);
		AaniPaymentdupli.setTxssummry_sum(txssummry_sum);
		AaniPaymentdupli.setTxssummry_amount(txssummry_amount);
		AaniPaymentdupli.setTxssummry_credit_debit_indicator(txssummry_credit_debit_indicator);
		AaniPaymentdupli.setTxssummry_credit_number_of_entries(txssummry_credit_number_of_entries);
		AaniPaymentdupli.setTxssummry_credit_sum(txssummry_credit_sum);
		AaniPaymentdupli.setTxssummry_debit_number_of_entries(txssummry_debit_number_of_entries);
		AaniPaymentdupli.setTxssummry_debit_sum(txssummry_debit_sum);
		AaniPaymentdupli.setNtry_entry_reference(ntry_entry_reference);
		AaniPaymentdupli.setNtry_amount_currency(ntry_amount_currency);
		AaniPaymentdupli.setNtry_credit_debit_indicator(ntry_credit_debit_indicator);
		AaniPaymentdupli.setNtry_code(ntry_code);
		AaniPaymentdupli.setNtry_booking_date(ntry_booking_date);
		AaniPaymentdupli.setNtry_booking_date_time(ntry_booking_date_time);
		AaniPaymentdupli.setNtry_value_date(ntry_value_date);
		AaniPaymentdupli.setNtry_value_date_time(ntry_value_date_time);
		AaniPaymentdupli.setNtry_account_servicer_reference(ntry_account_servicer_reference);
		AaniPaymentdupli.setNtry_proprietary_code(ntry_proprietary_code);
		AaniPaymentdupli.setNtry_instructed_amount(ntry_instructed_amount);
		AaniPaymentdupli.setNtry_transaction_amount(ntry_transaction_amount);
		AaniPaymentdupli.setNtry_refs_account_servicer_reference(ntry_refs_account_servicer_reference);
		AaniPaymentdupli.setNtry_refs_instruction_id("");
		AaniPaymentdupli.setNtry_refs_end_to_end_identification(ntry_refs_end_to_end_identification);
		AaniPaymentdupli.setNtry_refs_transaction_id(ntry_refs_transaction_id);
		AaniPaymentdupli.setNtry_refs_clearing_system_reference(ntry_refs_clearing_system_reference);
		AaniPaymentdupli.setNtry_txdtls_amount_currency(ntry_txdtls_amount_currency);
		AaniPaymentdupli.setNtry_txdtls_credit_debit_indicator(ntry_txdtls_credit_debit_indicator);
		AaniPaymentdupli.setNtry_fininstnid_bicfi(ntry_fininstnid_bicfi);
		AaniPaymentdupli.setNtry_dbtragt_bicfi_debit(ntry_dbtragt_bicfi_debit);
		AaniPaymentdupli.setNtry_cdtragt_bicfi_credit(ntry_cdtragt_bicfi_credit);
		AaniPaymentdupli.setSignature_signedinfo_digest_value(signature_signedinfo_digest_value);
		AaniPaymentdupli.setSignature_signedinfo_signature_value(signature_signedinfo_signature_value);
		AaniPaymentdupli.setSignature_keyinfo_x509_subject_name(signature_keyinfo_x509_subject_name);
		AaniPaymentdupli.setSignature_keyinfo_x509_certificate(signature_keyinfo_x509_certificate);
		AaniPaymentdupli.setCanonicalizationmethod_algorithm(canonicalizationmethod_algorithm);
		AaniPaymentdupli.setSignaturemethod_algorithm(signaturemethod_algorithm);
		AaniPaymentdupli.setTransform_algorithm(transform_algorithm);
		AaniPaymentdupli.setDigestmethod_algorithm(digestmethod_algorithm);
		AaniPaymentdupli.setReport_name(report_name);
		// AaniPaymentdupli.setNtry_btch_msg_id("");
		// AaniPaymentdupli.setNtry_btch_numoftxs();
		// AaniPaymentdupli.setNtry_btch_ttlamt(ntry_btch_ttlamt);
		// AaniPaymentdupli.setNtry_brch_cdtdbtint(ntry_brch_cdtdbtint);
		AaniPaymentdupli.setNtry_refs_pmtinfid(ntry_refs_pmtinfid);
		AaniPaymentdupli.setNtry_refs_uetr(ntry_refs_uetr);
		AaniPaymentdupli.setEntity_flg("Y");
		AaniPaymentdupli.setDel_flg("N");
		AaniPaymentdupli.setReport_date(new Date());
		AaniPaymentdupli.setRecon_flag("N");
		AaniPaymentdupli.setSrlno(bRECON_DESTINATION_REPO.srlno());
		AaniPaymentdupli.setStmt_bal1_code_or_proprietary(stmt_bal1_code_or_proprietary);
		AaniPaymentdupli.setStmt_bal1_amount(stmt_bal1_amount);
		AaniPaymentdupli.setStmt_bal1_credit_debit_indicator(stmt_bal1_credit_debit_indicator);
		AaniPaymentdupli.setStmt_bal1_date(stmt_bal1_date);
		AaniPaymentdupli.setStmt_bal1_date_time(stmt_bal1_date_time);

		Brecon_Aani_payment_dup_rep.save(AaniPaymentdupli);
		return Msg;

	}

	public String StoreTtumTransactiondetails(String grphdr_message_identifier, Date grphdr_creation_date_time,
			String grphdr_name, String grphdr_bank_identifier_code, BigDecimal grphdr_page_number,
			String grphdr_last_page_indicator, String stmt_statement_identifier,
			BigDecimal stmt_electronic_sequence_number, Date stmt_creation_date_time, Date stmt_from_date_time,
			Date stmt_to_date_time, String stmt_account_identifier, String stmt_related_account_identifier,
			String stmt_bal_code_or_proprietary, BigDecimal stmt_bal_amount, String stmt_bal_credit_debit_indicator,
			Date stmt_bal_date, Date stmt_bal_date_time, BigDecimal txssummry_number_of_entries,
			BigDecimal txssummry_sum, BigDecimal txssummry_amount, String txssummry_credit_debit_indicator,
			BigDecimal txssummry_credit_number_of_entries, BigDecimal txssummry_credit_sum,
			BigDecimal txssummry_debit_number_of_entries, BigDecimal txssummry_debit_sum, String ntry_entry_reference,
			BigDecimal ntry_amount_currency, String ntry_credit_debit_indicator, String ntry_code,
			Date ntry_booking_date, Date ntry_booking_date_time, Date ntry_value_date, String ntry_value_date_time,
			String ntry_account_servicer_reference, String ntry_proprietary_code, BigDecimal ntry_instructed_amount,
			BigDecimal ntry_transaction_amount, String ntry_refs_message_identifier,
			String ntry_refs_account_servicer_reference, String ntry_refs_end_to_end_identification,
			String ntry_refs_transaction_id, String ntry_refs_clearing_system_reference,
			BigDecimal ntry_txdtls_amount_currency, String ntry_txdtls_credit_debit_indicator,
			String ntry_fininstnid_bicfi, String ntry_dbtragt_bicfi_debit, String ntry_cdtragt_bicfi_credit,
			String signature_signedinfo_digest_value, String signature_signedinfo_signature_value,
			String signature_keyinfo_x509_subject_name, String signature_keyinfo_x509_certificate,
			String canonicalizationmethod_algorithm, String signaturemethod_algorithm, String transform_algorithm,
			String digestmethod_algorithm, String report_name, String ntry_refs_pmtinfid, String ntry_refs_uetr,
			String stmt_bal1_code_or_proprietary, BigDecimal stmt_bal1_amount, String stmt_bal1_credit_debit_indicator,
			Date stmt_bal1_date, Date stmt_bal1_date_time, String transaction_currency) {
		String Msg = null;

		BRECON_TTUM_TRANSACTION_ENTITY TtumTransaction = new BRECON_TTUM_TRANSACTION_ENTITY();

		logger.info("Start Saving TTUM Transaction Detail  -" + ntry_refs_clearing_system_reference);

		TtumTransaction.setGrphdr_message_identifier(grphdr_message_identifier);
		TtumTransaction.setGrphdr_creation_date_time(grphdr_creation_date_time);
		TtumTransaction.setGrphdr_name(grphdr_name);
		TtumTransaction.setGrphdr_bank_identifier_code(grphdr_bank_identifier_code);
		TtumTransaction.setGrphdr_page_number(grphdr_page_number);
		TtumTransaction.setGrphdr_last_page_indicator(grphdr_last_page_indicator);
		TtumTransaction.setStmt_statement_identifier(stmt_statement_identifier);
		TtumTransaction.setStmt_electronic_sequence_number(stmt_electronic_sequence_number);
		TtumTransaction.setStmt_creation_date_time(stmt_creation_date_time);
		TtumTransaction.setStmt_from_date_time(stmt_from_date_time);
		TtumTransaction.setStmt_to_date_time(stmt_to_date_time);
		TtumTransaction.setStmt_account_identifier(stmt_account_identifier);
		TtumTransaction.setStmt_related_account_identifier(stmt_related_account_identifier);
		TtumTransaction.setStmt_bal_code_or_proprietary(stmt_bal_code_or_proprietary);
		TtumTransaction.setStmt_bal_amount(stmt_bal_amount);
		TtumTransaction.setStmt_bal_credit_debit_indicator(stmt_bal_credit_debit_indicator);
		TtumTransaction.setStmt_bal_date(stmt_bal_date);
		TtumTransaction.setStmt_bal_date_time(stmt_bal_date_time);
		TtumTransaction.setTxssummry_number_of_entries(txssummry_number_of_entries);
		TtumTransaction.setTxssummry_sum(txssummry_sum);
		TtumTransaction.setTxssummry_amount(txssummry_amount);
		TtumTransaction.setTxssummry_credit_debit_indicator(txssummry_credit_debit_indicator);
		TtumTransaction.setTxssummry_credit_number_of_entries(txssummry_credit_number_of_entries);
		TtumTransaction.setTxssummry_credit_sum(txssummry_credit_sum);
		TtumTransaction.setTxssummry_debit_number_of_entries(txssummry_debit_number_of_entries);
		TtumTransaction.setTxssummry_debit_sum(txssummry_debit_sum);
		TtumTransaction.setNtry_entry_reference(ntry_entry_reference);
		TtumTransaction.setNtry_amount_currency(ntry_amount_currency);
		TtumTransaction.setNtry_credit_debit_indicator(ntry_credit_debit_indicator);
		TtumTransaction.setNtry_code(ntry_code);
		TtumTransaction.setNtry_booking_date(ntry_booking_date);
		TtumTransaction.setNtry_booking_date_time(ntry_booking_date_time);
		TtumTransaction.setNtry_value_date(ntry_value_date);
		TtumTransaction.setNtry_value_date_time(ntry_value_date_time);
		TtumTransaction.setNtry_account_servicer_reference(ntry_account_servicer_reference);
		TtumTransaction.setNtry_proprietary_code(ntry_proprietary_code);
		TtumTransaction.setNtry_instructed_amount(ntry_instructed_amount);
		TtumTransaction.setNtry_transaction_amount(ntry_transaction_amount);
		TtumTransaction.setNtry_refs_account_servicer_reference(ntry_refs_account_servicer_reference);
		TtumTransaction.setNtry_refs_instruction_id("");
		TtumTransaction.setNtry_refs_end_to_end_identification(ntry_refs_end_to_end_identification);
		TtumTransaction.setNtry_refs_transaction_id(ntry_refs_transaction_id);
		TtumTransaction.setNtry_refs_clearing_system_reference(ntry_refs_clearing_system_reference);
		TtumTransaction.setNtry_txdtls_amount_currency(ntry_txdtls_amount_currency);
		TtumTransaction.setNtry_txdtls_credit_debit_indicator(ntry_txdtls_credit_debit_indicator);
		TtumTransaction.setNtry_fininstnid_bicfi(ntry_fininstnid_bicfi);
		TtumTransaction.setNtry_dbtragt_bicfi_debit(ntry_dbtragt_bicfi_debit);
		TtumTransaction.setNtry_cdtragt_bicfi_credit(ntry_cdtragt_bicfi_credit);
		TtumTransaction.setSignature_signedinfo_digest_value(signature_signedinfo_digest_value);
		TtumTransaction.setSignature_signedinfo_signature_value(signature_signedinfo_signature_value);
		TtumTransaction.setSignature_keyinfo_x509_subject_name(signature_keyinfo_x509_subject_name);
		TtumTransaction.setSignature_keyinfo_x509_certificate(signature_keyinfo_x509_certificate);
		TtumTransaction.setCanonicalizationmethod_algorithm(canonicalizationmethod_algorithm);
		TtumTransaction.setSignaturemethod_algorithm(signaturemethod_algorithm);
		TtumTransaction.setTransform_algorithm(transform_algorithm);
		TtumTransaction.setDigestmethod_algorithm(digestmethod_algorithm);
		TtumTransaction.setReport_name(report_name);
		// TtumTransaction.setNtry_btch_msg_id("");
		// TtumTransaction.setNtry_btch_numoftxs();
		// TtumTransaction.setNtry_btch_ttlamt(ntry_btch_ttlamt);
		// TtumTransaction.setNtry_brch_cdtdbtint(ntry_brch_cdtdbtint);
		TtumTransaction.setNtry_refs_pmtinfid(ntry_refs_pmtinfid);
		TtumTransaction.setNtry_refs_uetr(ntry_refs_uetr);
		TtumTransaction.setEntity_flg("Y");
		TtumTransaction.setDel_flg("N");
		TtumTransaction.setReport_date(new Date());
		TtumTransaction.setRecon_flag("N");
		TtumTransaction.setSrlno(bRECON_DESTINATION_REPO.srlno());
		TtumTransaction.setStmt_bal1_code_or_proprietary(stmt_bal1_code_or_proprietary);
		TtumTransaction.setStmt_bal1_amount(stmt_bal1_amount);
		TtumTransaction.setStmt_bal1_credit_debit_indicator(stmt_bal1_credit_debit_indicator);
		TtumTransaction.setStmt_bal1_date(stmt_bal1_date);
		TtumTransaction.setStmt_bal1_date_time(stmt_bal1_date_time);

		brecon_ttum_transaction_rep.save(TtumTransaction);
		return Msg;

	}

	public void batchInsertAANI(FYItransactions.Document docValue, List<FYItransactions.Entry> entries,
			String reportName, String stmtIdentifier) {

		List<BRECON_DESTINATION_ENTITY> BRECON_DESTINATION_ENTITY_LIST = new ArrayList<BRECON_DESTINATION_ENTITY>();

		List<Balance> balances = docValue.getBkToCstmrStmt().getStmt().getBal();

		String StmtBalCodeOrProprietary = "";

		BigDecimal StmtBalAmount = null;

		String StmtBalCreditDebitIndicator = "";

		Date StmtBalDate = null;

		Date StmtBalDateTime = null;

		String SecStmtBalCodeOrProprietary = "";

		BigDecimal SecStmtBalAmount = null;

		String SecStmtBalCreditDebitIndicator = "";

		Date SecStmtBalDate = null;

		Date SecStmtBalDateTime = null;

		for (int j = 0; j < balances.size(); j++) {

			if (j == 0) {

				StmtBalCodeOrProprietary = balances.get(j).getTp().getCdOrPrtry().getStmtBalCodeOrProprietary();

				StmtBalAmount = balances.get(j).getStmtBalAmount();

				logger.info(StmtBalAmount + " First Bal amount");

				StmtBalCreditDebitIndicator = balances.get(j).getStmtBalCreditDebitIndicator();

				StmtBalDate = balances.get(j).getDt().getStmtBalDate();

				StmtBalDateTime = balances.get(j).getDt().getStmtBalDateTime();

			} else if (j == 1) {

				SecStmtBalCodeOrProprietary = balances.get(j).getTp().getCdOrPrtry().getStmtBalCodeOrProprietary();

				SecStmtBalAmount = balances.get(j).getStmtBalAmount();

				logger.info(SecStmtBalAmount + " Sec Bal amount");

				SecStmtBalCreditDebitIndicator = balances.get(j).getStmtBalCreditDebitIndicator();

				SecStmtBalDate = balances.get(j).getDt().getStmtBalDate();

				SecStmtBalDateTime = balances.get(j).getDt().getStmtBalDateTime();

			}

		}

		List<Entry> Transactionentries = docValue.getBkToCstmrStmt().getStmt().getNtry();

		logger.info(String.valueOf(Transactionentries.size()));

		for (int k = 0; k < Transactionentries.size(); k++) {
			BRECON_DESTINATION_ENTITY BRECON_DESTINATION_ENTITY = new BRECON_DESTINATION_ENTITY();
			logger.info("Entry refs data store : " + Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs()
					.getNtryRefsClearingSystemReference());

			BRECON_DESTINATION_ENTITY
					.setGrphdr_message_identifier(docValue.getBkToCstmrStmt().getGrpHdr().getGrpHdrMessageIdentifier());

			BRECON_DESTINATION_ENTITY
					.setGrphdr_creation_date_time(docValue.getBkToCstmrStmt().getGrpHdr().getGrpHdrCreationDateTime());

			BRECON_DESTINATION_ENTITY
					.setGrphdr_name(docValue.getBkToCstmrStmt().getGrpHdr().getMsgRcpt().getGrpHdrName());

			BRECON_DESTINATION_ENTITY.setGrphdr_bank_identifier_code(docValue.getBkToCstmrStmt().getGrpHdr()
					.getMsgRcpt().getId().getOrgId().getGrpHdrBankIdentifierCode());

			BRECON_DESTINATION_ENTITY
					.setGrphdr_page_number(docValue.getBkToCstmrStmt().getGrpHdr().getMsgPgntn().getGrpHdrPageNumber());

			BRECON_DESTINATION_ENTITY.setGrphdr_last_page_indicator(
					docValue.getBkToCstmrStmt().getGrpHdr().getMsgPgntn().getGrpHdrLastPageIndicator());
			BRECON_DESTINATION_ENTITY
					.setStmt_statement_identifier(docValue.getBkToCstmrStmt().getStmt().getStmtStatementIdentifier());
			BRECON_DESTINATION_ENTITY.setStmt_electronic_sequence_number(
					docValue.getBkToCstmrStmt().getStmt().getStmtElectronicSequenceNumber());
			BRECON_DESTINATION_ENTITY
					.setStmt_creation_date_time(docValue.getBkToCstmrStmt().getStmt().getStmtCreationDateTime());
			BRECON_DESTINATION_ENTITY
					.setStmt_from_date_time(docValue.getBkToCstmrStmt().getStmt().getFrToDt().getStmtFromDateTime());
			BRECON_DESTINATION_ENTITY
					.setStmt_to_date_time(docValue.getBkToCstmrStmt().getStmt().getFrToDt().getStmtToDateTime());
			BRECON_DESTINATION_ENTITY.setStmt_related_account_identifier(docValue.getBkToCstmrStmt().getStmt()
					.getRltdAcct().getId().getOthr().getStmtRelatedAccountIdentifier());
			BRECON_DESTINATION_ENTITY.setTxssummry_number_of_entries(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlNtries().getTxsSummryNumberOfEntries());
			BRECON_DESTINATION_ENTITY.setTxssummry_sum(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlNtries().getTxsSummrySum());
			BRECON_DESTINATION_ENTITY.setTxssummry_amount(docValue.getBkToCstmrStmt().getStmt().getTxsSummry()
					.getTtlNtries().getTtlNetNtry().getTxsSummryAmount());
			BRECON_DESTINATION_ENTITY.setTxssummry_credit_debit_indicator(docValue.getBkToCstmrStmt().getStmt()
					.getTxsSummry().getTtlNtries().getTtlNetNtry().getTxsSummryCreditDebitIndicator());
			BRECON_DESTINATION_ENTITY.setTxssummry_credit_number_of_entries(docValue.getBkToCstmrStmt().getStmt()
					.getTxsSummry().getTtlCdtNtries().getTxsSummryCreditNumberOfEntries());
			BRECON_DESTINATION_ENTITY.setTxssummry_credit_sum(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlCdtNtries().getTxsSummryCreditSum());
			BRECON_DESTINATION_ENTITY.setTxssummry_debit_number_of_entries(docValue.getBkToCstmrStmt().getStmt()
					.getTxsSummry().getTtlDbtNtries().getTxsSummryDebitNumberOfEntries());
			BRECON_DESTINATION_ENTITY.setTxssummry_debit_sum(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlDbtNtries().getTxsSummryDebitSum());
			BRECON_DESTINATION_ENTITY.setCanonicalizationmethod_algorithm(
					docValue.getSignature().getSignedInfo().getCanonicalizationMethod().getAlgorithm());
			BRECON_DESTINATION_ENTITY.setSignaturemethod_algorithm(
					docValue.getSignature().getSignedInfo().getSignatureMethod().getAlgorithm());
			BRECON_DESTINATION_ENTITY.setTransform_algorithm(docValue.getSignature().getSignedInfo().getReference()
					.getTransforms().getTransform().getAlgorithm());
			BRECON_DESTINATION_ENTITY.setDigestmethod_algorithm(
					docValue.getSignature().getSignedInfo().getReference().getDigestMethod().getAlgorithm());
			BRECON_DESTINATION_ENTITY.setSignature_signedinfo_digest_value(
					docValue.getSignature().getSignedInfo().getReference().getSignature_signedinfo_digest_value());
			BRECON_DESTINATION_ENTITY.setSignature_signedinfo_signature_value(
					docValue.getSignature().getSignature_signedinfo_signature_value());
			BRECON_DESTINATION_ENTITY.setSignature_keyinfo_x509_subject_name(
					docValue.getSignature().getKeyInfo().getX509Data().getSignature_keyinfo_x509_subject_name());
			BRECON_DESTINATION_ENTITY.setSignature_keyinfo_x509_certificate(
					docValue.getSignature().getKeyInfo().getX509Data().getSignature_keyinfo_x509_certificate());
			BRECON_DESTINATION_ENTITY.setStmt_account_identifier(stmtIdentifier);
			BRECON_DESTINATION_ENTITY.setStmt_bal_code_or_proprietary(StmtBalCodeOrProprietary);
			BRECON_DESTINATION_ENTITY.setStmt_bal_amount(StmtBalAmount);
			BRECON_DESTINATION_ENTITY.setStmt_bal_credit_debit_indicator(StmtBalCreditDebitIndicator);
			BRECON_DESTINATION_ENTITY.setStmt_bal_date(StmtBalDate);
			BRECON_DESTINATION_ENTITY.setStmt_bal_date_time(StmtBalDateTime);
			BRECON_DESTINATION_ENTITY.setStmt_bal1_code_or_proprietary(SecStmtBalCodeOrProprietary);
			BRECON_DESTINATION_ENTITY.setStmt_bal1_amount(SecStmtBalAmount);
			BRECON_DESTINATION_ENTITY.setStmt_bal1_credit_debit_indicator(SecStmtBalCreditDebitIndicator);
			BRECON_DESTINATION_ENTITY.setStmt_bal1_date(SecStmtBalDate);
			BRECON_DESTINATION_ENTITY.setStmt_bal1_date_time(SecStmtBalDateTime);
			BRECON_DESTINATION_ENTITY.setNtry_entry_reference(Transactionentries.get(k).getNtryEntryReference());
			BRECON_DESTINATION_ENTITY.setNtry_amount_currency(Transactionentries.get(k).getNtryAmountCurrency());
			BRECON_DESTINATION_ENTITY
					.setNtry_credit_debit_indicator(Transactionentries.get(k).getNtryCreditDebitIndicator());
			BRECON_DESTINATION_ENTITY.setNtry_code(Transactionentries.get(k).getSts().getNtryCode());
			BRECON_DESTINATION_ENTITY.setNtry_booking_date(Transactionentries.get(k).getBookgDt().getNtryBookingDate());
			BRECON_DESTINATION_ENTITY
					.setNtry_booking_date_time(Transactionentries.get(k).getBookgDt().getNtryBookingDateTime());
			BRECON_DESTINATION_ENTITY.setNtry_value_date(Transactionentries.get(k).getValDt().getNtryValueDate());
			BRECON_DESTINATION_ENTITY
					.setNtry_value_date_time(Transactionentries.get(k).getValDt().getNtryValueDateTime());
			BRECON_DESTINATION_ENTITY
					.setNtry_account_servicer_reference(Transactionentries.get(k).getNtry_account_servicer_reference());
			BRECON_DESTINATION_ENTITY.setNtry_proprietary_code(
					Transactionentries.get(k).getBkTxCd().getPrtry().getNtryProprietaryCode());
			BRECON_DESTINATION_ENTITY.setNtry_instructed_amount(
					Transactionentries.get(k).getAmtDtls().getInstdAmt().getNtryInstructedAmount());
			BRECON_DESTINATION_ENTITY.setNtry_transaction_amount(Transactionentries.get(k).getAmtDtls().getTxAmt()
					.getCurrency_values().getNtry_transaction_amount());
			BRECON_DESTINATION_ENTITY.setNtry_refs_message_identifier(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsMessageIdentifier());
			BRECON_DESTINATION_ENTITY.setNtry_refs_account_servicer_reference(Transactionentries.get(k).getNtryDtls()
					.getTxDtls().getRefs().getNtryRefsAccountServicerReference());
			BRECON_DESTINATION_ENTITY.setNtry_refs_pmtinfid(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtry_refs_pmtinfid());
			BRECON_DESTINATION_ENTITY.setNtry_refs_end_to_end_identification(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsEndToEndIdentification());
			BRECON_DESTINATION_ENTITY.setNtry_refs_uetr(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtry_refs_uetr());
			BRECON_DESTINATION_ENTITY.setNtry_refs_transaction_id(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsTransactionId());
			BRECON_DESTINATION_ENTITY.setNtry_refs_clearing_system_reference(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsClearingSystemReference());
			BRECON_DESTINATION_ENTITY.setNtry_txdtls_amount_currency(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getNtryTxDtlsAmountCurrency());
			BRECON_DESTINATION_ENTITY.setNtry_txdtls_credit_debit_indicator(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getNtryTxDtlsCreditDebitIndicator());
			BRECON_DESTINATION_ENTITY.setNtry_fininstnid_bicfi(Transactionentries.get(k).getNtryDtls().getTxDtls()
					.getMsgRcpt().getInstgAgt().getFinInstnId().getNtry_fininstnid_bicfi());
			BRECON_DESTINATION_ENTITY.setNtry_dbtragt_bicfi_debit(Transactionentries.get(k).getNtryDtls().getTxDtls()
					.getMsgRcpt().getDbtrAgt().getFinInstnId().getNtry_dbtragt_bicfi_debit());
			BRECON_DESTINATION_ENTITY.setNtry_cdtragt_bicfi_credit(Transactionentries.get(k).getNtryDtls().getTxDtls()
					.getMsgRcpt().getCdtrAgt().getFinInstnId().getNtry_cdtragt_bicfi_credit());
			BRECON_DESTINATION_ENTITY.setTransaction_currency(
					Transactionentries.get(k).getAmtDtls().getTxAmt().getCurrency_values().getTransaction_currency());
			BRECON_DESTINATION_ENTITY.setEntity_flg("Y");
			BRECON_DESTINATION_ENTITY.setDel_flg("N");
			BRECON_DESTINATION_ENTITY.setReport_date(new Date());
			BRECON_DESTINATION_ENTITY.setRecon_flag("N");
			BRECON_DESTINATION_ENTITY.setSrlno(bRECON_DESTINATION_REPO.srlno());
			BRECON_DESTINATION_ENTITY.setCreate_time(new Date());
			BRECON_DESTINATION_ENTITY.setReport_name(reportName);
			BRECON_DESTINATION_ENTITY_LIST.add(BRECON_DESTINATION_ENTITY);

		}

		bRECON_DESTINATION_REPO.saveAll(BRECON_DESTINATION_ENTITY_LIST);
		logger.info("Save Completed file : " + reportName);

	}

	public void batchInsertTTUM(FYItransactions.Document docValue, List<FYItransactions.Entry> entries,
			String reportName, String stmtIdentifier) {

		List<BRECON_TTUM_TRANSACTION_ENTITY> BRECON_TTUM_TRANSACTION_ENTITY_LIST = new ArrayList<BRECON_TTUM_TRANSACTION_ENTITY>();

		List<Balance> balances = docValue.getBkToCstmrStmt().getStmt().getBal();

		String StmtBalCodeOrProprietary = "";

		BigDecimal StmtBalAmount = null;

		String StmtBalCreditDebitIndicator = "";

		Date StmtBalDate = null;

		Date StmtBalDateTime = null;

		String SecStmtBalCodeOrProprietary = "";

		BigDecimal SecStmtBalAmount = null;

		String SecStmtBalCreditDebitIndicator = "";

		Date SecStmtBalDate = null;

		Date SecStmtBalDateTime = null;

		for (int j = 0; j < balances.size(); j++) {

			if (j == 0) {

				StmtBalCodeOrProprietary = balances.get(j).getTp().getCdOrPrtry().getStmtBalCodeOrProprietary();

				StmtBalAmount = balances.get(j).getStmtBalAmount();

				logger.info(StmtBalAmount + " First Bal amount");

				StmtBalCreditDebitIndicator = balances.get(j).getStmtBalCreditDebitIndicator();

				StmtBalDate = balances.get(j).getDt().getStmtBalDate();

				StmtBalDateTime = balances.get(j).getDt().getStmtBalDateTime();

			} else if (j == 1) {

				SecStmtBalCodeOrProprietary = balances.get(j).getTp().getCdOrPrtry().getStmtBalCodeOrProprietary();

				SecStmtBalAmount = balances.get(j).getStmtBalAmount();

				logger.info(SecStmtBalAmount + " Sec Bal amount");

				SecStmtBalCreditDebitIndicator = balances.get(j).getStmtBalCreditDebitIndicator();

				SecStmtBalDate = balances.get(j).getDt().getStmtBalDate();

				SecStmtBalDateTime = balances.get(j).getDt().getStmtBalDateTime();

			}

		}

		List<Entry> Transactionentries = docValue.getBkToCstmrStmt().getStmt().getNtry();

		logger.info(String.valueOf(Transactionentries.size()));

		for (int k = 0; k < Transactionentries.size(); k++) {
			BRECON_TTUM_TRANSACTION_ENTITY BRECON_TTUM_TRANSACTION_ENTITY = new BRECON_TTUM_TRANSACTION_ENTITY();
			logger.info("TTUM Entry refs data store : " + Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs()
					.getNtryRefsClearingSystemReference());

			BRECON_TTUM_TRANSACTION_ENTITY
					.setGrphdr_message_identifier(docValue.getBkToCstmrStmt().getGrpHdr().getGrpHdrMessageIdentifier());

			BRECON_TTUM_TRANSACTION_ENTITY
					.setGrphdr_creation_date_time(docValue.getBkToCstmrStmt().getGrpHdr().getGrpHdrCreationDateTime());

			BRECON_TTUM_TRANSACTION_ENTITY
					.setGrphdr_name(docValue.getBkToCstmrStmt().getGrpHdr().getMsgRcpt().getGrpHdrName());

			BRECON_TTUM_TRANSACTION_ENTITY.setGrphdr_bank_identifier_code(docValue.getBkToCstmrStmt().getGrpHdr()
					.getMsgRcpt().getId().getOrgId().getGrpHdrBankIdentifierCode());

			BRECON_TTUM_TRANSACTION_ENTITY
					.setGrphdr_page_number(docValue.getBkToCstmrStmt().getGrpHdr().getMsgPgntn().getGrpHdrPageNumber());
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_account_identifier(stmtIdentifier);
			BRECON_TTUM_TRANSACTION_ENTITY.setGrphdr_last_page_indicator(
					docValue.getBkToCstmrStmt().getGrpHdr().getMsgPgntn().getGrpHdrLastPageIndicator());
			BRECON_TTUM_TRANSACTION_ENTITY
					.setStmt_statement_identifier(docValue.getBkToCstmrStmt().getStmt().getStmtStatementIdentifier());
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_electronic_sequence_number(
					docValue.getBkToCstmrStmt().getStmt().getStmtElectronicSequenceNumber());
			BRECON_TTUM_TRANSACTION_ENTITY
					.setStmt_creation_date_time(docValue.getBkToCstmrStmt().getStmt().getStmtCreationDateTime());
			BRECON_TTUM_TRANSACTION_ENTITY
					.setStmt_from_date_time(docValue.getBkToCstmrStmt().getStmt().getFrToDt().getStmtFromDateTime());
			BRECON_TTUM_TRANSACTION_ENTITY
					.setStmt_to_date_time(docValue.getBkToCstmrStmt().getStmt().getFrToDt().getStmtToDateTime());
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_related_account_identifier(docValue.getBkToCstmrStmt().getStmt()
					.getRltdAcct().getId().getOthr().getStmtRelatedAccountIdentifier());
			BRECON_TTUM_TRANSACTION_ENTITY.setTxssummry_number_of_entries(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlNtries().getTxsSummryNumberOfEntries());
			BRECON_TTUM_TRANSACTION_ENTITY.setTxssummry_sum(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlNtries().getTxsSummrySum());
			BRECON_TTUM_TRANSACTION_ENTITY.setTxssummry_amount(docValue.getBkToCstmrStmt().getStmt().getTxsSummry()
					.getTtlNtries().getTtlNetNtry().getTxsSummryAmount());
			BRECON_TTUM_TRANSACTION_ENTITY.setTxssummry_credit_debit_indicator(docValue.getBkToCstmrStmt().getStmt()
					.getTxsSummry().getTtlNtries().getTtlNetNtry().getTxsSummryCreditDebitIndicator());
			BRECON_TTUM_TRANSACTION_ENTITY.setTxssummry_credit_number_of_entries(docValue.getBkToCstmrStmt().getStmt()
					.getTxsSummry().getTtlCdtNtries().getTxsSummryCreditNumberOfEntries());
			BRECON_TTUM_TRANSACTION_ENTITY.setTxssummry_credit_sum(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlCdtNtries().getTxsSummryCreditSum());
			BRECON_TTUM_TRANSACTION_ENTITY.setTxssummry_debit_number_of_entries(docValue.getBkToCstmrStmt().getStmt()
					.getTxsSummry().getTtlDbtNtries().getTxsSummryDebitNumberOfEntries());
			BRECON_TTUM_TRANSACTION_ENTITY.setTxssummry_debit_sum(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlDbtNtries().getTxsSummryDebitSum());
			BRECON_TTUM_TRANSACTION_ENTITY.setCanonicalizationmethod_algorithm(
					docValue.getSignature().getSignedInfo().getCanonicalizationMethod().getAlgorithm());
			BRECON_TTUM_TRANSACTION_ENTITY.setSignaturemethod_algorithm(
					docValue.getSignature().getSignedInfo().getSignatureMethod().getAlgorithm());
			BRECON_TTUM_TRANSACTION_ENTITY.setTransform_algorithm(docValue.getSignature().getSignedInfo().getReference()
					.getTransforms().getTransform().getAlgorithm());
			BRECON_TTUM_TRANSACTION_ENTITY.setDigestmethod_algorithm(
					docValue.getSignature().getSignedInfo().getReference().getDigestMethod().getAlgorithm());
			BRECON_TTUM_TRANSACTION_ENTITY.setSignature_signedinfo_digest_value(
					docValue.getSignature().getSignedInfo().getReference().getSignature_signedinfo_digest_value());
			BRECON_TTUM_TRANSACTION_ENTITY.setSignature_signedinfo_signature_value(
					docValue.getSignature().getSignature_signedinfo_signature_value());
			BRECON_TTUM_TRANSACTION_ENTITY.setSignature_keyinfo_x509_subject_name(
					docValue.getSignature().getKeyInfo().getX509Data().getSignature_keyinfo_x509_subject_name());
			BRECON_TTUM_TRANSACTION_ENTITY.setSignature_keyinfo_x509_certificate(
					docValue.getSignature().getKeyInfo().getX509Data().getSignature_keyinfo_x509_certificate());
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_bal_code_or_proprietary(StmtBalCodeOrProprietary);
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_bal_amount(StmtBalAmount);
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_bal_credit_debit_indicator(StmtBalCreditDebitIndicator);
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_bal_date(StmtBalDate);
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_bal_date_time(StmtBalDateTime);
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_bal1_code_or_proprietary(SecStmtBalCodeOrProprietary);
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_bal1_amount(SecStmtBalAmount);
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_bal1_credit_debit_indicator(SecStmtBalCreditDebitIndicator);
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_bal1_date(SecStmtBalDate);
			BRECON_TTUM_TRANSACTION_ENTITY.setStmt_bal1_date_time(SecStmtBalDateTime);
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_entry_reference(Transactionentries.get(k).getNtryEntryReference());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_amount_currency(Transactionentries.get(k).getNtryAmountCurrency());
			BRECON_TTUM_TRANSACTION_ENTITY
					.setNtry_credit_debit_indicator(Transactionentries.get(k).getNtryCreditDebitIndicator());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_code(Transactionentries.get(k).getSts().getNtryCode());
			BRECON_TTUM_TRANSACTION_ENTITY
					.setNtry_booking_date(Transactionentries.get(k).getBookgDt().getNtryBookingDate());
			BRECON_TTUM_TRANSACTION_ENTITY
					.setNtry_booking_date_time(Transactionentries.get(k).getBookgDt().getNtryBookingDateTime());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_value_date(Transactionentries.get(k).getValDt().getNtryValueDate());
			BRECON_TTUM_TRANSACTION_ENTITY
					.setNtry_value_date_time(Transactionentries.get(k).getValDt().getNtryValueDateTime());
			BRECON_TTUM_TRANSACTION_ENTITY
					.setNtry_account_servicer_reference(Transactionentries.get(k).getNtry_account_servicer_reference());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_proprietary_code(
					Transactionentries.get(k).getBkTxCd().getPrtry().getNtryProprietaryCode());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_instructed_amount(
					Transactionentries.get(k).getAmtDtls().getInstdAmt().getNtryInstructedAmount());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_transaction_amount(Transactionentries.get(k).getAmtDtls().getTxAmt()
					.getCurrency_values().getNtry_transaction_amount());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_refs_message_identifier(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsMessageIdentifier());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_refs_account_servicer_reference(Transactionentries.get(k)
					.getNtryDtls().getTxDtls().getRefs().getNtryRefsAccountServicerReference());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_refs_pmtinfid(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtry_refs_pmtinfid());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_refs_end_to_end_identification(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsEndToEndIdentification());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_refs_uetr(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtry_refs_uetr());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_refs_transaction_id(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsTransactionId());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_refs_clearing_system_reference(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsClearingSystemReference());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_txdtls_amount_currency(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getNtryTxDtlsAmountCurrency());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_txdtls_credit_debit_indicator(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getNtryTxDtlsCreditDebitIndicator());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_fininstnid_bicfi(Transactionentries.get(k).getNtryDtls().getTxDtls()
					.getMsgRcpt().getInstgAgt().getFinInstnId().getNtry_fininstnid_bicfi());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_dbtragt_bicfi_debit(Transactionentries.get(k).getNtryDtls()
					.getTxDtls().getMsgRcpt().getDbtrAgt().getFinInstnId().getNtry_dbtragt_bicfi_debit());
			BRECON_TTUM_TRANSACTION_ENTITY.setNtry_cdtragt_bicfi_credit(Transactionentries.get(k).getNtryDtls()
					.getTxDtls().getMsgRcpt().getCdtrAgt().getFinInstnId().getNtry_cdtragt_bicfi_credit());
			BRECON_TTUM_TRANSACTION_ENTITY.setTransaction_currency(
					Transactionentries.get(k).getAmtDtls().getTxAmt().getCurrency_values().getTransaction_currency());
			BRECON_TTUM_TRANSACTION_ENTITY.setEntity_flg("Y");
			BRECON_TTUM_TRANSACTION_ENTITY.setDel_flg("N");
			BRECON_TTUM_TRANSACTION_ENTITY.setReport_date(new Date());
			BRECON_TTUM_TRANSACTION_ENTITY.setRecon_flag("N");
			BRECON_TTUM_TRANSACTION_ENTITY.setSrlno(bRECON_DESTINATION_REPO.srlno());
			BRECON_TTUM_TRANSACTION_ENTITY.setCreate_time(new Date());
			BRECON_TTUM_TRANSACTION_ENTITY.setReport_name(reportName);
			BRECON_TTUM_TRANSACTION_ENTITY_LIST.add(BRECON_TTUM_TRANSACTION_ENTITY);

		}

		brecon_ttum_transaction_rep.saveAll(BRECON_TTUM_TRANSACTION_ENTITY_LIST);
		logger.info("Save Completed file : " + reportName);

	}

	public void batchInsertDuplicates(FYItransactions.Document docValue, List<FYItransactions.Entry> entries,
			String reportName, String stmtIdentifier) {

		List<Brecon_aani_payment_duplicate_entity> Brecon_aani_payment_duplicate_entity_list = new ArrayList<Brecon_aani_payment_duplicate_entity>();

		List<Balance> balances = docValue.getBkToCstmrStmt().getStmt().getBal();

		String StmtBalCodeOrProprietary = "";

		BigDecimal StmtBalAmount = null;

		String StmtBalCreditDebitIndicator = "";

		Date StmtBalDate = null;

		Date StmtBalDateTime = null;

		String SecStmtBalCodeOrProprietary = "";

		BigDecimal SecStmtBalAmount = null;

		String SecStmtBalCreditDebitIndicator = "";

		Date SecStmtBalDate = null;

		Date SecStmtBalDateTime = null;

		for (int j = 0; j < balances.size(); j++) {

			if (j == 0) {

				StmtBalCodeOrProprietary = balances.get(j).getTp().getCdOrPrtry().getStmtBalCodeOrProprietary();

				StmtBalAmount = balances.get(j).getStmtBalAmount();

				logger.info(StmtBalAmount + " First Bal amount");

				StmtBalCreditDebitIndicator = balances.get(j).getStmtBalCreditDebitIndicator();

				StmtBalDate = balances.get(j).getDt().getStmtBalDate();

				StmtBalDateTime = balances.get(j).getDt().getStmtBalDateTime();

			} else if (j == 1) {

				SecStmtBalCodeOrProprietary = balances.get(j).getTp().getCdOrPrtry().getStmtBalCodeOrProprietary();

				SecStmtBalAmount = balances.get(j).getStmtBalAmount();

				logger.info(SecStmtBalAmount + " Sec Bal amount");

				SecStmtBalCreditDebitIndicator = balances.get(j).getStmtBalCreditDebitIndicator();

				SecStmtBalDate = balances.get(j).getDt().getStmtBalDate();

				SecStmtBalDateTime = balances.get(j).getDt().getStmtBalDateTime();

			}

		}

		List<Entry> Transactionentries = docValue.getBkToCstmrStmt().getStmt().getNtry();

		logger.info(String.valueOf(Transactionentries.size()));

		for (int k = 0; k < Transactionentries.size(); k++) {
			Brecon_aani_payment_duplicate_entity Brecon_aani_payment_duplicate_entity = new Brecon_aani_payment_duplicate_entity();
			logger.info("Duplicate Entry refs data store : " + Transactionentries.get(k).getNtryDtls().getTxDtls()
					.getRefs().getNtryRefsClearingSystemReference());

			Brecon_aani_payment_duplicate_entity
					.setGrphdr_message_identifier(docValue.getBkToCstmrStmt().getGrpHdr().getGrpHdrMessageIdentifier());

			Brecon_aani_payment_duplicate_entity
					.setGrphdr_creation_date_time(docValue.getBkToCstmrStmt().getGrpHdr().getGrpHdrCreationDateTime());

			Brecon_aani_payment_duplicate_entity
					.setGrphdr_name(docValue.getBkToCstmrStmt().getGrpHdr().getMsgRcpt().getGrpHdrName());

			Brecon_aani_payment_duplicate_entity.setGrphdr_bank_identifier_code(docValue.getBkToCstmrStmt().getGrpHdr()
					.getMsgRcpt().getId().getOrgId().getGrpHdrBankIdentifierCode());

			Brecon_aani_payment_duplicate_entity
					.setGrphdr_page_number(docValue.getBkToCstmrStmt().getGrpHdr().getMsgPgntn().getGrpHdrPageNumber());

			Brecon_aani_payment_duplicate_entity.setGrphdr_last_page_indicator(
					docValue.getBkToCstmrStmt().getGrpHdr().getMsgPgntn().getGrpHdrLastPageIndicator());
			Brecon_aani_payment_duplicate_entity
					.setStmt_statement_identifier(docValue.getBkToCstmrStmt().getStmt().getStmtStatementIdentifier());
			Brecon_aani_payment_duplicate_entity.setStmt_electronic_sequence_number(
					docValue.getBkToCstmrStmt().getStmt().getStmtElectronicSequenceNumber());
			Brecon_aani_payment_duplicate_entity
					.setStmt_creation_date_time(docValue.getBkToCstmrStmt().getStmt().getStmtCreationDateTime());
			Brecon_aani_payment_duplicate_entity
					.setStmt_from_date_time(docValue.getBkToCstmrStmt().getStmt().getFrToDt().getStmtFromDateTime());
			Brecon_aani_payment_duplicate_entity
					.setStmt_to_date_time(docValue.getBkToCstmrStmt().getStmt().getFrToDt().getStmtToDateTime());
			Brecon_aani_payment_duplicate_entity.setStmt_related_account_identifier(docValue.getBkToCstmrStmt()
					.getStmt().getRltdAcct().getId().getOthr().getStmtRelatedAccountIdentifier());
			Brecon_aani_payment_duplicate_entity.setTxssummry_number_of_entries(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlNtries().getTxsSummryNumberOfEntries());
			Brecon_aani_payment_duplicate_entity.setTxssummry_sum(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlNtries().getTxsSummrySum());
			Brecon_aani_payment_duplicate_entity.setTxssummry_amount(docValue.getBkToCstmrStmt().getStmt()
					.getTxsSummry().getTtlNtries().getTtlNetNtry().getTxsSummryAmount());
			Brecon_aani_payment_duplicate_entity.setTxssummry_credit_debit_indicator(docValue.getBkToCstmrStmt()
					.getStmt().getTxsSummry().getTtlNtries().getTtlNetNtry().getTxsSummryCreditDebitIndicator());
			Brecon_aani_payment_duplicate_entity.setTxssummry_credit_number_of_entries(docValue.getBkToCstmrStmt()
					.getStmt().getTxsSummry().getTtlCdtNtries().getTxsSummryCreditNumberOfEntries());
			Brecon_aani_payment_duplicate_entity.setTxssummry_credit_sum(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlCdtNtries().getTxsSummryCreditSum());
			Brecon_aani_payment_duplicate_entity.setTxssummry_debit_number_of_entries(docValue.getBkToCstmrStmt()
					.getStmt().getTxsSummry().getTtlDbtNtries().getTxsSummryDebitNumberOfEntries());
			Brecon_aani_payment_duplicate_entity.setTxssummry_debit_sum(
					docValue.getBkToCstmrStmt().getStmt().getTxsSummry().getTtlDbtNtries().getTxsSummryDebitSum());
			Brecon_aani_payment_duplicate_entity.setCanonicalizationmethod_algorithm(
					docValue.getSignature().getSignedInfo().getCanonicalizationMethod().getAlgorithm());
			Brecon_aani_payment_duplicate_entity.setSignaturemethod_algorithm(
					docValue.getSignature().getSignedInfo().getSignatureMethod().getAlgorithm());
			Brecon_aani_payment_duplicate_entity.setTransform_algorithm(docValue.getSignature().getSignedInfo()
					.getReference().getTransforms().getTransform().getAlgorithm());
			Brecon_aani_payment_duplicate_entity.setDigestmethod_algorithm(
					docValue.getSignature().getSignedInfo().getReference().getDigestMethod().getAlgorithm());
			Brecon_aani_payment_duplicate_entity.setSignature_signedinfo_digest_value(
					docValue.getSignature().getSignedInfo().getReference().getSignature_signedinfo_digest_value());
			Brecon_aani_payment_duplicate_entity.setSignature_signedinfo_signature_value(
					docValue.getSignature().getSignature_signedinfo_signature_value());
			Brecon_aani_payment_duplicate_entity.setSignature_keyinfo_x509_subject_name(
					docValue.getSignature().getKeyInfo().getX509Data().getSignature_keyinfo_x509_subject_name());
			Brecon_aani_payment_duplicate_entity.setSignature_keyinfo_x509_certificate(
					docValue.getSignature().getKeyInfo().getX509Data().getSignature_keyinfo_x509_certificate());
			Brecon_aani_payment_duplicate_entity.setStmt_account_identifier(stmtIdentifier);
			Brecon_aani_payment_duplicate_entity.setStmt_bal_code_or_proprietary(StmtBalCodeOrProprietary);
			Brecon_aani_payment_duplicate_entity.setStmt_bal_amount(StmtBalAmount);
			Brecon_aani_payment_duplicate_entity.setStmt_bal_credit_debit_indicator(StmtBalCreditDebitIndicator);
			Brecon_aani_payment_duplicate_entity.setStmt_bal_date(StmtBalDate);
			Brecon_aani_payment_duplicate_entity.setStmt_bal_date_time(StmtBalDateTime);
			Brecon_aani_payment_duplicate_entity.setStmt_bal1_code_or_proprietary(SecStmtBalCodeOrProprietary);
			Brecon_aani_payment_duplicate_entity.setStmt_bal1_amount(SecStmtBalAmount);
			Brecon_aani_payment_duplicate_entity.setStmt_bal1_credit_debit_indicator(SecStmtBalCreditDebitIndicator);
			Brecon_aani_payment_duplicate_entity.setStmt_bal1_date(SecStmtBalDate);
			Brecon_aani_payment_duplicate_entity.setStmt_bal1_date_time(SecStmtBalDateTime);
			Brecon_aani_payment_duplicate_entity
					.setNtry_entry_reference(Transactionentries.get(k).getNtryEntryReference());
			Brecon_aani_payment_duplicate_entity
					.setNtry_amount_currency(Transactionentries.get(k).getNtryAmountCurrency());
			Brecon_aani_payment_duplicate_entity
					.setNtry_credit_debit_indicator(Transactionentries.get(k).getNtryCreditDebitIndicator());
			Brecon_aani_payment_duplicate_entity.setNtry_code(Transactionentries.get(k).getSts().getNtryCode());
			Brecon_aani_payment_duplicate_entity
					.setNtry_booking_date(Transactionentries.get(k).getBookgDt().getNtryBookingDate());
			Brecon_aani_payment_duplicate_entity
					.setNtry_booking_date_time(Transactionentries.get(k).getBookgDt().getNtryBookingDateTime());
			Brecon_aani_payment_duplicate_entity
					.setNtry_value_date(Transactionentries.get(k).getValDt().getNtryValueDate());
			Brecon_aani_payment_duplicate_entity
					.setNtry_value_date_time(Transactionentries.get(k).getValDt().getNtryValueDateTime());
			Brecon_aani_payment_duplicate_entity
					.setNtry_account_servicer_reference(Transactionentries.get(k).getNtry_account_servicer_reference());
			Brecon_aani_payment_duplicate_entity.setNtry_proprietary_code(
					Transactionentries.get(k).getBkTxCd().getPrtry().getNtryProprietaryCode());
			Brecon_aani_payment_duplicate_entity.setNtry_instructed_amount(
					Transactionentries.get(k).getAmtDtls().getInstdAmt().getNtryInstructedAmount());
			Brecon_aani_payment_duplicate_entity.setNtry_transaction_amount(Transactionentries.get(k).getAmtDtls()
					.getTxAmt().getCurrency_values().getNtry_transaction_amount());
			Brecon_aani_payment_duplicate_entity.setNtry_refs_message_identifier(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsMessageIdentifier());
			Brecon_aani_payment_duplicate_entity.setNtry_refs_account_servicer_reference(Transactionentries.get(k)
					.getNtryDtls().getTxDtls().getRefs().getNtryRefsAccountServicerReference());
			Brecon_aani_payment_duplicate_entity.setNtry_refs_pmtinfid(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtry_refs_pmtinfid());
			Brecon_aani_payment_duplicate_entity.setNtry_refs_end_to_end_identification(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsEndToEndIdentification());
			Brecon_aani_payment_duplicate_entity.setNtry_refs_uetr(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtry_refs_uetr());
			Brecon_aani_payment_duplicate_entity.setNtry_refs_transaction_id(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsTransactionId());
			Brecon_aani_payment_duplicate_entity.setNtry_refs_clearing_system_reference(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getRefs().getNtryRefsClearingSystemReference());
			Brecon_aani_payment_duplicate_entity.setNtry_txdtls_amount_currency(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getNtryTxDtlsAmountCurrency());
			Brecon_aani_payment_duplicate_entity.setNtry_txdtls_credit_debit_indicator(
					Transactionentries.get(k).getNtryDtls().getTxDtls().getNtryTxDtlsCreditDebitIndicator());
			Brecon_aani_payment_duplicate_entity.setNtry_fininstnid_bicfi(Transactionentries.get(k).getNtryDtls()
					.getTxDtls().getMsgRcpt().getInstgAgt().getFinInstnId().getNtry_fininstnid_bicfi());
			Brecon_aani_payment_duplicate_entity.setNtry_dbtragt_bicfi_debit(Transactionentries.get(k).getNtryDtls()
					.getTxDtls().getMsgRcpt().getDbtrAgt().getFinInstnId().getNtry_dbtragt_bicfi_debit());
			Brecon_aani_payment_duplicate_entity.setNtry_cdtragt_bicfi_credit(Transactionentries.get(k).getNtryDtls()
					.getTxDtls().getMsgRcpt().getCdtrAgt().getFinInstnId().getNtry_cdtragt_bicfi_credit());
			Brecon_aani_payment_duplicate_entity.setTransaction_currency(
					Transactionentries.get(k).getAmtDtls().getTxAmt().getCurrency_values().getTransaction_currency());
			Brecon_aani_payment_duplicate_entity.setEntity_flg("Y");
			Brecon_aani_payment_duplicate_entity.setDel_flg("N");
			Brecon_aani_payment_duplicate_entity.setReport_date(new Date());
			Brecon_aani_payment_duplicate_entity.setRecon_flag("N");
			Brecon_aani_payment_duplicate_entity.setSrlno(bRECON_DESTINATION_REPO.srlno());
			Brecon_aani_payment_duplicate_entity.setCreate_time(new Date());
			Brecon_aani_payment_duplicate_entity.setReport_name(reportName);
			Brecon_aani_payment_duplicate_entity_list.add(Brecon_aani_payment_duplicate_entity);

		}
		Brecon_Aani_payment_dup_rep.saveAll(Brecon_aani_payment_duplicate_entity_list);

		logger.info("Save Completed file : " + reportName);

	}

}
