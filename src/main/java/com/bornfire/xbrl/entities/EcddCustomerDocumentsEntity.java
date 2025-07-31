package com.bornfire.xbrl.entities;

import javax.persistence.*;

import java.util.Arrays;
import java.util.Date;

@Entity
@Table(name = "ECDD_CUSTOMER_DOCUMENTS_TABLE")
public class EcddCustomerDocumentsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ecdd_doc_generator")
	@SequenceGenerator(name = "ecdd_doc_generator", 
	                   sequenceName = "ECDD_DOCUMENTS_SEQ",
	                   allocationSize = 1) 
	@Column(name = "DOC_ID", nullable = false, updatable = false)
	private Long docId;

	@Column(name = "SRL_NO", nullable = false, length = 200)
	private String srlNo;

	@Column(name = "CUSTOMER_ID", nullable = false, length = 50)
	private String customerId;

	@Column(name = "CUSTOMER_TYPE", nullable = false, length = 20)
	private String customerType;

	@Column(name = "DOCUMENT_TYPE", nullable = false, length = 100)
	private String documentType;

	@Column(name = "DOCUMENT_NAME", nullable = false, length = 255)
	private String documentName;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "DOCUMENT_CONTENT", nullable = false)
	private byte[] documentContent;

	@Column(name = "MIME_TYPE", length = 100)
	private String mimeType;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPLOADED_DATE", nullable = false)
	private Date uploadedDate;

	@Column(name = "UPLOADED_BY", nullable = false, length = 100)
	private String uploadedBy;

	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATE")
	private Date reportDate;

	@Column(name = "ENTRY_USER", length = 50)
	private String entryUser;

	@Temporal(TemporalType.DATE)
	@Column(name = "ENTRY_TIME")
	private Date entryTime;

	@Column(name = "AUTH_USER", length = 50)
	private String authUser;

	@Temporal(TemporalType.DATE)
	@Column(name = "AUTH_TIME")
	private Date authTime;

	@Column(name = "MODIFY_USER", length = 50)
	private String modifyUser;

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFY_TIME")
	private Date modifyTime;

	@Column(name = "VERIFY_USER", length = 50)
	private String verifyUser;

	@Temporal(TemporalType.DATE)
	@Column(name = "VERIFY_TIME")
	private Date verifyTime;

	@Column(name = "ENTITY_FLG", length = 50)
	private String entityFlg;

	@Column(name = "AUTH_FLG", length = 50)
	private String authFlg;

	@Column(name = "MODIFY_FLG", length = 50)
	private String modifyFlg;

	@Column(name = "DEL_FLG", length = 50)
	private String delFlg;

	public Long getDocId() {
		return docId;
	}

	public void setDocId(Long docId) {
		this.docId = docId;
	}

	public String getSrlNo() {
		return srlNo;
	}

	public void setSrlNo(String srlNo) {
		this.srlNo = srlNo;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public byte[] getDocumentContent() {
		return documentContent;
	}

	public void setDocumentContent(byte[] documentContent) {
		this.documentContent = documentContent;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Date getUploadedDate() {
		return uploadedDate;
	}

	public void setUploadedDate(Date uploadedDate) {
		this.uploadedDate = uploadedDate;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public String getEntryUser() {
		return entryUser;
	}

	public void setEntryUser(String entryUser) {
		this.entryUser = entryUser;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getAuthUser() {
		return authUser;
	}

	public void setAuthUser(String authUser) {
		this.authUser = authUser;
	}

	public Date getAuthTime() {
		return authTime;
	}

	public void setAuthTime(Date authTime) {
		this.authTime = authTime;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getVerifyUser() {
		return verifyUser;
	}

	public void setVerifyUser(String verifyUser) {
		this.verifyUser = verifyUser;
	}

	public Date getVerifyTime() {
		return verifyTime;
	}

	public void setVerifyTime(Date verifyTime) {
		this.verifyTime = verifyTime;
	}

	public String getEntityFlg() {
		return entityFlg;
	}

	public void setEntityFlg(String entityFlg) {
		this.entityFlg = entityFlg;
	}

	public String getAuthFlg() {
		return authFlg;
	}

	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}

	public String getModifyFlg() {
		return modifyFlg;
	}

	public void setModifyFlg(String modifyFlg) {
		this.modifyFlg = modifyFlg;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public EcddCustomerDocumentsEntity(Long docId, String srlNo, String customerId, String customerType,
			String documentType, String documentName, byte[] documentContent, String mimeType, Date uploadedDate,
			String uploadedBy, Date reportDate, String entryUser, Date entryTime, String authUser, Date authTime,
			String modifyUser, Date modifyTime, String verifyUser, Date verifyTime, String entityFlg, String authFlg,
			String modifyFlg, String delFlg) {
		super();
		this.docId = docId;
		this.srlNo = srlNo;
		this.customerId = customerId;
		this.customerType = customerType;
		this.documentType = documentType;
		this.documentName = documentName;
		this.documentContent = documentContent;
		this.mimeType = mimeType;
		this.uploadedDate = uploadedDate;
		this.uploadedBy = uploadedBy;
		this.reportDate = reportDate;
		this.entryUser = entryUser;
		this.entryTime = entryTime;
		this.authUser = authUser;
		this.authTime = authTime;
		this.modifyUser = modifyUser;
		this.modifyTime = modifyTime;
		this.verifyUser = verifyUser;
		this.verifyTime = verifyTime;
		this.entityFlg = entityFlg;
		this.authFlg = authFlg;
		this.modifyFlg = modifyFlg;
		this.delFlg = delFlg;
	}

	@Override
	public String toString() {
		return "EcdCustomerDocumentsEntity [docId=" + docId + ", srlNo=" + srlNo + ", customerId=" + customerId
				+ ", customerType=" + customerType + ", documentType=" + documentType + ", documentName=" + documentName
				+ ", documentContent=" + Arrays.toString(documentContent) + ", mimeType=" + mimeType + ", uploadedDate="
				+ uploadedDate + ", uploadedBy=" + uploadedBy + ", reportDate=" + reportDate + ", entryUser="
				+ entryUser + ", entryTime=" + entryTime + ", authUser=" + authUser + ", authTime=" + authTime
				+ ", modifyUser=" + modifyUser + ", modifyTime=" + modifyTime + ", verifyUser=" + verifyUser
				+ ", verifyTime=" + verifyTime + ", entityFlg=" + entityFlg + ", authFlg=" + authFlg + ", modifyFlg="
				+ modifyFlg + ", delFlg=" + delFlg + "]";
	}

	public EcddCustomerDocumentsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}