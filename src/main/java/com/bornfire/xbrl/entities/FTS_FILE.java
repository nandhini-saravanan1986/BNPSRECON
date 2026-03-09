package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="FTS_REPORT")
public class FTS_FILE {

	    @Id
	    @Column(name = "SRL_NO")
	    private String srlNo;

	    @Column(name = "Sl_No")
	    private BigDecimal slNo;

	    @Column(name = "REFERENCEID", length = 100)
	    private String referenceId;

	    @Column(name = "SEQ_No")
	    private BigDecimal seqNo;

	    @Column(name = "SENDING_INST_REF", length = 100)
	    private String sendingInstRef;

	    @Column(name = "FTS_FILEID", length = 100)
	    private String ftsFileId;

	    @Column(name = "PRIORITY", length = 100)
	    private String priority;

	    @Column(name = "TRANS_TYPE", length = 100)
	    private String transType;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "VALUE_DATE")
	    private Date valueDate;

	    @Column(name = "BENEFICIARY_INST", length = 100)
	    private String beneficiaryInst;

	    @Column(name = "STATUS", length = 100)
	    private String status;

	    @Column(name = "DC_STATUS", length = 100)
	    private String dcStatus;

	    @Column(name = "BRANCHID", length = 100)
	    private String branchId;

	    @Column(name = "BRANCHEMIRATECODE", length = 100)
	    private String branchEmirateCode;

	    @Column(name = "CURRENCY", length = 100)
	    private String currency;

	    @Column(name = "AMOUNT", precision = 24, scale = 4)
	    private BigDecimal amount;

	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    @Column(name = "UPLOAD_DATE")
	    private Date uploadDate;

		public String getSrlNo() {
			return srlNo;
		}

		public void setSrlNo(String srlNo) {
			this.srlNo = srlNo;
		}

		public BigDecimal getSlNo() {
			return slNo;
		}

		public void setSlNo(BigDecimal slNo) {
			this.slNo = slNo;
		}

		public String getReferenceId() {
			return referenceId;
		}

		public void setReferenceId(String referenceId) {
			this.referenceId = referenceId;
		}

		public BigDecimal getSeqNo() {
			return seqNo;
		}

		public void setSeqNo(BigDecimal seqNo) {
			this.seqNo = seqNo;
		}

		public String getSendingInstRef() {
			return sendingInstRef;
		}

		public void setSendingInstRef(String sendingInstRef) {
			this.sendingInstRef = sendingInstRef;
		}

		public String getFtsFileId() {
			return ftsFileId;
		}

		public void setFtsFileId(String ftsFileId) {
			this.ftsFileId = ftsFileId;
		}

		public String getPriority() {
			return priority;
		}

		public void setPriority(String priority) {
			this.priority = priority;
		}

		public String getTransType() {
			return transType;
		}

		public void setTransType(String transType) {
			this.transType = transType;
		}

		public Date getValueDate() {
			return valueDate;
		}

		public void setValueDate(Date valueDate) {
			this.valueDate = valueDate;
		}

		public String getBeneficiaryInst() {
			return beneficiaryInst;
		}

		public void setBeneficiaryInst(String beneficiaryInst) {
			this.beneficiaryInst = beneficiaryInst;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getDcStatus() {
			return dcStatus;
		}

		public void setDcStatus(String dcStatus) {
			this.dcStatus = dcStatus;
		}

		public String getBranchId() {
			return branchId;
		}

		public void setBranchId(String branchId) {
			this.branchId = branchId;
		}

		public String getBranchEmirateCode() {
			return branchEmirateCode;
		}

		public void setBranchEmirateCode(String branchEmirateCode) {
			this.branchEmirateCode = branchEmirateCode;
		}

		public String getCurrency() {
			return currency;
		}

		public void setCurrency(String currency) {
			this.currency = currency;
		}

		public BigDecimal getAmount() {
			return amount;
		}

		public void setAmount(BigDecimal amount) {
			this.amount = amount;
		}

		public Date getUploadDate() {
			return uploadDate;
		}

		public void setUploadDate(Date uploadDate) {
			this.uploadDate = uploadDate;
		}

		public FTS_FILE(String srlNo, BigDecimal slNo, String referenceId, BigDecimal seqNo, String sendingInstRef,
				String ftsFileId, String priority, String transType, Date valueDate, String beneficiaryInst,
				String status, String dcStatus, String branchId, String branchEmirateCode, String currency,
				BigDecimal amount, Date uploadDate) {
			super();
			this.srlNo = srlNo;
			this.slNo = slNo;
			this.referenceId = referenceId;
			this.seqNo = seqNo;
			this.sendingInstRef = sendingInstRef;
			this.ftsFileId = ftsFileId;
			this.priority = priority;
			this.transType = transType;
			this.valueDate = valueDate;
			this.beneficiaryInst = beneficiaryInst;
			this.status = status;
			this.dcStatus = dcStatus;
			this.branchId = branchId;
			this.branchEmirateCode = branchEmirateCode;
			this.currency = currency;
			this.amount = amount;
			this.uploadDate = uploadDate;
		}

		public FTS_FILE() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    

}
