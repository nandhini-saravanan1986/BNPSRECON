package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ECDD_INDIVIDUAL")
public class ECDDIndividualEntity {


	    @Id
	    private String srlNo;
	    private String customerId;
	    private String accountType;
	    private String name;
	    private String accountNumber;
	    private Date dateOfBirth;
	    private String placeOfBirth;
	    private String nationality;
	    private Date accountOpeningDate;
	    private String countryOfCitizenship;
	    private String countryOfCurrentResidency;
	    private String occupation;
	    private String businessActivity;
	    private Double annualIncome;
	    private String sourceOfFunds;
	    private String purposeOfAccountOpening;
	    private String taxRegistration;
	    private String taxIdNumber;
	    private String primaryAddress;
	    private String primaryAddressCountry;
	    private String primaryAddressCity;
	    private String primaryAddressPoBox;
	    private String mobileNumber;
	    private String primaryTelephone;
	    private String secondaryTelephone;
	    private String emailId;
	    private String residentialStatusChanged;
	    private String newCountryOfResidency;
	    private String newCityOfResidency;
	    private String newPoBoxOfResidency;
	    private String accountSatisfactory;
	    private String transactionCommensurate;
	    private String highValueTransactionsObserved;
	    private String highValueTransactionsDetails1;
	    private String suspicionObserved;
	    private String suspicionObservedDetails;
	    private String branchSatisfiedWithTransactions;
	    private String supportingDocumentObtained;
	    private Double currentTurnover;
	    private Double expectedTurnover;
	    private String expectedTransactionTypes;
	    private Double expectedTransactionVolume;
	    private String transactionFrequency;
	    private String uae;
	    private String un;
	    private String ofac;
	    private String hmt;
	    private String eu;
	    private String others;
	    private String cbuCheckDone;
	    private String googleMediaSearch;
	    private String internalDenyListScreening;
	    private String supportingDocumentObtained2;
	    private String isPep;
	    private String seniorManagementApproval;
	    private String foreignCurrencyRequest;
	    private String seniorManagementApprovalFc;
	    private String customerRisk;
	    private String highRiskReason;
	    private String furtherDueDiligence;
	    private String observationsOfBankOfficial;
	    private String accountOpeningOfficerSignature;
	    private String accountOpeningOfficerName;
	    private String accountOpeningOfficerDesignation;
	    private Date accountOpeningOfficerDate;
	    private String branchOfficialSignature;
	    private String branchOfficialName;
	    private String branchOfficialDesignation;
	    private Date branchOfficialDate;
	    private String debit;
	    private String credit;
	    private String suspicionObserved1;
	    private String countryOfCitizenshipOthers;
	    private String reasonForRedFlag1;
	    private String reasonForRedFlag2;
	    private String jointSupportDocumentDetails;
	    private String branch;
	    private Date lastEcddDate;
	    private String aofAvailable;
	    private String aofRemarks;
	    private String fatcaCrsAvailable;
	    private String fatcaCrsRemarks;
	    private String sourceOfFundsAvailable;
	    private String sourceOfFundsRemarks;
	    private String observations;
	    private Date currentDate;
	    private Date reportDate;
	    private String entryUser;
	    private Date entryTime;
	    private String authUser;
	    private Date authTime;
	    private String modifyUser;
	    private Date modifyTime;
	    private String verifyUser;
	    private Date verifyTime;
	    private String entityFlg;
	    private String authFlg;
	    private String modifyFlg;
	    private String delFlg;
	    
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
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(Date dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getPlaceOfBirth() {
			return placeOfBirth;
		}
		public void setPlaceOfBirth(String placeOfBirth) {
			this.placeOfBirth = placeOfBirth;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public Date getAccountOpeningDate() {
			return accountOpeningDate;
		}
		public void setAccountOpeningDate(Date accountOpeningDate) {
			this.accountOpeningDate = accountOpeningDate;
		}
		public String getCountryOfCitizenship() {
			return countryOfCitizenship;
		}
		public void setCountryOfCitizenship(String countryOfCitizenship) {
			this.countryOfCitizenship = countryOfCitizenship;
		}
		public String getCountryOfCurrentResidency() {
			return countryOfCurrentResidency;
		}
		public void setCountryOfCurrentResidency(String countryOfCurrentResidency) {
			this.countryOfCurrentResidency = countryOfCurrentResidency;
		}
		public String getOccupation() {
			return occupation;
		}
		public void setOccupation(String occupation) {
			this.occupation = occupation;
		}
		public String getBusinessActivity() {
			return businessActivity;
		}
		public void setBusinessActivity(String businessActivity) {
			this.businessActivity = businessActivity;
		}
		public Double getAnnualIncome() {
			return annualIncome;
		}
		public void setAnnualIncome(Double annualIncome) {
			this.annualIncome = annualIncome;
		}
		public String getSourceOfFunds() {
			return sourceOfFunds;
		}
		public void setSourceOfFunds(String sourceOfFunds) {
			this.sourceOfFunds = sourceOfFunds;
		}
		public String getPurposeOfAccountOpening() {
			return purposeOfAccountOpening;
		}
		public void setPurposeOfAccountOpening(String purposeOfAccountOpening) {
			this.purposeOfAccountOpening = purposeOfAccountOpening;
		}
		public String getTaxRegistration() {
			return taxRegistration;
		}
		public void setTaxRegistration(String taxRegistration) {
			this.taxRegistration = taxRegistration;
		}
		public String getTaxIdNumber() {
			return taxIdNumber;
		}
		public void setTaxIdNumber(String taxIdNumber) {
			this.taxIdNumber = taxIdNumber;
		}
		public String getPrimaryAddress() {
			return primaryAddress;
		}
		public void setPrimaryAddress(String primaryAddress) {
			this.primaryAddress = primaryAddress;
		}
		public String getPrimaryAddressCountry() {
			return primaryAddressCountry;
		}
		public void setPrimaryAddressCountry(String primaryAddressCountry) {
			this.primaryAddressCountry = primaryAddressCountry;
		}
		public String getPrimaryAddressCity() {
			return primaryAddressCity;
		}
		public void setPrimaryAddressCity(String primaryAddressCity) {
			this.primaryAddressCity = primaryAddressCity;
		}
		public String getPrimaryAddressPoBox() {
			return primaryAddressPoBox;
		}
		public void setPrimaryAddressPoBox(String primaryAddressPoBox) {
			this.primaryAddressPoBox = primaryAddressPoBox;
		}
		public String getMobileNumber() {
			return mobileNumber;
		}
		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}
		public String getPrimaryTelephone() {
			return primaryTelephone;
		}
		public void setPrimaryTelephone(String primaryTelephone) {
			this.primaryTelephone = primaryTelephone;
		}
		public String getSecondaryTelephone() {
			return secondaryTelephone;
		}
		public void setSecondaryTelephone(String secondaryTelephone) {
			this.secondaryTelephone = secondaryTelephone;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getResidentialStatusChanged() {
			return residentialStatusChanged;
		}
		public void setResidentialStatusChanged(String residentialStatusChanged) {
			this.residentialStatusChanged = residentialStatusChanged;
		}
		public String getNewCountryOfResidency() {
			return newCountryOfResidency;
		}
		public void setNewCountryOfResidency(String newCountryOfResidency) {
			this.newCountryOfResidency = newCountryOfResidency;
		}
		public String getNewCityOfResidency() {
			return newCityOfResidency;
		}
		public void setNewCityOfResidency(String newCityOfResidency) {
			this.newCityOfResidency = newCityOfResidency;
		}
		public String getNewPoBoxOfResidency() {
			return newPoBoxOfResidency;
		}
		public void setNewPoBoxOfResidency(String newPoBoxOfResidency) {
			this.newPoBoxOfResidency = newPoBoxOfResidency;
		}
		public String getAccountSatisfactory() {
			return accountSatisfactory;
		}
		public void setAccountSatisfactory(String accountSatisfactory) {
			this.accountSatisfactory = accountSatisfactory;
		}
		public String getTransactionCommensurate() {
			return transactionCommensurate;
		}
		public void setTransactionCommensurate(String transactionCommensurate) {
			this.transactionCommensurate = transactionCommensurate;
		}
		public String getHighValueTransactionsObserved() {
			return highValueTransactionsObserved;
		}
		public void setHighValueTransactionsObserved(String highValueTransactionsObserved) {
			this.highValueTransactionsObserved = highValueTransactionsObserved;
		}
		public String getHighValueTransactionsDetails1() {
			return highValueTransactionsDetails1;
		}
		public void setHighValueTransactionsDetails1(String highValueTransactionsDetails1) {
			this.highValueTransactionsDetails1 = highValueTransactionsDetails1;
		}
		public String getSuspicionObserved() {
			return suspicionObserved;
		}
		public void setSuspicionObserved(String suspicionObserved) {
			this.suspicionObserved = suspicionObserved;
		}
		public String getSuspicionObservedDetails() {
			return suspicionObservedDetails;
		}
		public void setSuspicionObservedDetails(String suspicionObservedDetails) {
			this.suspicionObservedDetails = suspicionObservedDetails;
		}
		public String getBranchSatisfiedWithTransactions() {
			return branchSatisfiedWithTransactions;
		}
		public void setBranchSatisfiedWithTransactions(String branchSatisfiedWithTransactions) {
			this.branchSatisfiedWithTransactions = branchSatisfiedWithTransactions;
		}
		public String getSupportingDocumentObtained() {
			return supportingDocumentObtained;
		}
		public void setSupportingDocumentObtained(String supportingDocumentObtained) {
			this.supportingDocumentObtained = supportingDocumentObtained;
		}
		public Double getCurrentTurnover() {
			return currentTurnover;
		}
		public void setCurrentTurnover(Double currentTurnover) {
			this.currentTurnover = currentTurnover;
		}
		public Double getExpectedTurnover() {
			return expectedTurnover;
		}
		public void setExpectedTurnover(Double expectedTurnover) {
			this.expectedTurnover = expectedTurnover;
		}
		public String getExpectedTransactionTypes() {
			return expectedTransactionTypes;
		}
		public void setExpectedTransactionTypes(String expectedTransactionTypes) {
			this.expectedTransactionTypes = expectedTransactionTypes;
		}
		public Double getExpectedTransactionVolume() {
			return expectedTransactionVolume;
		}
		public void setExpectedTransactionVolume(Double expectedTransactionVolume) {
			this.expectedTransactionVolume = expectedTransactionVolume;
		}
		public String getTransactionFrequency() {
			return transactionFrequency;
		}
		public void setTransactionFrequency(String transactionFrequency) {
			this.transactionFrequency = transactionFrequency;
		}
		public String getUae() {
			return uae;
		}
		public void setUae(String uae) {
			this.uae = uae;
		}
		public String getUn() {
			return un;
		}
		public void setUn(String un) {
			this.un = un;
		}
		public String getOfac() {
			return ofac;
		}
		public void setOfac(String ofac) {
			this.ofac = ofac;
		}
		public String getHmt() {
			return hmt;
		}
		public void setHmt(String hmt) {
			this.hmt = hmt;
		}
		public String getEu() {
			return eu;
		}
		public void setEu(String eu) {
			this.eu = eu;
		}
		public String getOthers() {
			return others;
		}
		public void setOthers(String others) {
			this.others = others;
		}
		public String getCbuCheckDone() {
			return cbuCheckDone;
		}
		public void setCbuCheckDone(String cbuCheckDone) {
			this.cbuCheckDone = cbuCheckDone;
		}
		public String getGoogleMediaSearch() {
			return googleMediaSearch;
		}
		public void setGoogleMediaSearch(String googleMediaSearch) {
			this.googleMediaSearch = googleMediaSearch;
		}
		public String getInternalDenyListScreening() {
			return internalDenyListScreening;
		}
		public void setInternalDenyListScreening(String internalDenyListScreening) {
			this.internalDenyListScreening = internalDenyListScreening;
		}
		public String getSupportingDocumentObtained2() {
			return supportingDocumentObtained2;
		}
		public void setSupportingDocumentObtained2(String supportingDocumentObtained2) {
			this.supportingDocumentObtained2 = supportingDocumentObtained2;
		}
		public String getIsPep() {
			return isPep;
		}
		public void setIsPep(String isPep) {
			this.isPep = isPep;
		}
		public String getSeniorManagementApproval() {
			return seniorManagementApproval;
		}
		public void setSeniorManagementApproval(String seniorManagementApproval) {
			this.seniorManagementApproval = seniorManagementApproval;
		}
		public String getForeignCurrencyRequest() {
			return foreignCurrencyRequest;
		}
		public void setForeignCurrencyRequest(String foreignCurrencyRequest) {
			this.foreignCurrencyRequest = foreignCurrencyRequest;
		}
		public String getSeniorManagementApprovalFc() {
			return seniorManagementApprovalFc;
		}
		public void setSeniorManagementApprovalFc(String seniorManagementApprovalFc) {
			this.seniorManagementApprovalFc = seniorManagementApprovalFc;
		}
		public String getCustomerRisk() {
			return customerRisk;
		}
		public void setCustomerRisk(String customerRisk) {
			this.customerRisk = customerRisk;
		}
		public String getHighRiskReason() {
			return highRiskReason;
		}
		public void setHighRiskReason(String highRiskReason) {
			this.highRiskReason = highRiskReason;
		}
		public String getFurtherDueDiligence() {
			return furtherDueDiligence;
		}
		public void setFurtherDueDiligence(String furtherDueDiligence) {
			this.furtherDueDiligence = furtherDueDiligence;
		}
		public String getObservationsOfBankOfficial() {
			return observationsOfBankOfficial;
		}
		public void setObservationsOfBankOfficial(String observationsOfBankOfficial) {
			this.observationsOfBankOfficial = observationsOfBankOfficial;
		}
		public String getAccountOpeningOfficerSignature() {
			return accountOpeningOfficerSignature;
		}
		public void setAccountOpeningOfficerSignature(String accountOpeningOfficerSignature) {
			this.accountOpeningOfficerSignature = accountOpeningOfficerSignature;
		}
		public String getAccountOpeningOfficerName() {
			return accountOpeningOfficerName;
		}
		public void setAccountOpeningOfficerName(String accountOpeningOfficerName) {
			this.accountOpeningOfficerName = accountOpeningOfficerName;
		}
		public String getAccountOpeningOfficerDesignation() {
			return accountOpeningOfficerDesignation;
		}
		public void setAccountOpeningOfficerDesignation(String accountOpeningOfficerDesignation) {
			this.accountOpeningOfficerDesignation = accountOpeningOfficerDesignation;
		}
		public Date getAccountOpeningOfficerDate() {
			return accountOpeningOfficerDate;
		}
		public void setAccountOpeningOfficerDate(Date accountOpeningOfficerDate) {
			this.accountOpeningOfficerDate = accountOpeningOfficerDate;
		}
		public String getBranchOfficialSignature() {
			return branchOfficialSignature;
		}
		public void setBranchOfficialSignature(String branchOfficialSignature) {
			this.branchOfficialSignature = branchOfficialSignature;
		}
		public String getBranchOfficialName() {
			return branchOfficialName;
		}
		public void setBranchOfficialName(String branchOfficialName) {
			this.branchOfficialName = branchOfficialName;
		}
		public String getBranchOfficialDesignation() {
			return branchOfficialDesignation;
		}
		public void setBranchOfficialDesignation(String branchOfficialDesignation) {
			this.branchOfficialDesignation = branchOfficialDesignation;
		}
		public Date getBranchOfficialDate() {
			return branchOfficialDate;
		}
		public void setBranchOfficialDate(Date branchOfficialDate) {
			this.branchOfficialDate = branchOfficialDate;
		}
		public String getDebit() {
			return debit;
		}
		public void setDebit(String debit) {
			this.debit = debit;
		}
		public String getCredit() {
			return credit;
		}
		public void setCredit(String credit) {
			this.credit = credit;
		}
		public String getSuspicionObserved1() {
			return suspicionObserved1;
		}
		public void setSuspicionObserved1(String suspicionObserved1) {
			this.suspicionObserved1 = suspicionObserved1;
		}
		public String getCountryOfCitizenshipOthers() {
			return countryOfCitizenshipOthers;
		}
		public void setCountryOfCitizenshipOthers(String countryOfCitizenshipOthers) {
			this.countryOfCitizenshipOthers = countryOfCitizenshipOthers;
		}
		public String getReasonForRedFlag1() {
			return reasonForRedFlag1;
		}
		public void setReasonForRedFlag1(String reasonForRedFlag1) {
			this.reasonForRedFlag1 = reasonForRedFlag1;
		}
		public String getReasonForRedFlag2() {
			return reasonForRedFlag2;
		}
		public void setReasonForRedFlag2(String reasonForRedFlag2) {
			this.reasonForRedFlag2 = reasonForRedFlag2;
		}
		public String getJointSupportDocumentDetails() {
			return jointSupportDocumentDetails;
		}
		public void setJointSupportDocumentDetails(String jointSupportDocumentDetails) {
			this.jointSupportDocumentDetails = jointSupportDocumentDetails;
		}
		public String getBranch() {
			return branch;
		}
		public void setBranch(String branch) {
			this.branch = branch;
		}
		public Date getLastEcddDate() {
			return lastEcddDate;
		}
		public void setLastEcddDate(Date lastEcddDate) {
			this.lastEcddDate = lastEcddDate;
		}
		public String getAofAvailable() {
			return aofAvailable;
		}
		public void setAofAvailable(String aofAvailable) {
			this.aofAvailable = aofAvailable;
		}
		public String getAofRemarks() {
			return aofRemarks;
		}
		public void setAofRemarks(String aofRemarks) {
			this.aofRemarks = aofRemarks;
		}
		public String getFatcaCrsAvailable() {
			return fatcaCrsAvailable;
		}
		public void setFatcaCrsAvailable(String fatcaCrsAvailable) {
			this.fatcaCrsAvailable = fatcaCrsAvailable;
		}
		public String getFatcaCrsRemarks() {
			return fatcaCrsRemarks;
		}
		public void setFatcaCrsRemarks(String fatcaCrsRemarks) {
			this.fatcaCrsRemarks = fatcaCrsRemarks;
		}
		public String getSourceOfFundsAvailable() {
			return sourceOfFundsAvailable;
		}
		public void setSourceOfFundsAvailable(String sourceOfFundsAvailable) {
			this.sourceOfFundsAvailable = sourceOfFundsAvailable;
		}
		public String getSourceOfFundsRemarks() {
			return sourceOfFundsRemarks;
		}
		public void setSourceOfFundsRemarks(String sourceOfFundsRemarks) {
			this.sourceOfFundsRemarks = sourceOfFundsRemarks;
		}
		public String getObservations() {
			return observations;
		}
		public void setObservations(String observations) {
			this.observations = observations;
		}
		public Date getCurrentDate() {
			return currentDate;
		}
		public void setCurrentDate(Date currentDate) {
			this.currentDate = currentDate;
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
		@Override
		public String toString() {
			return "ECDDIndicidualEntity [srlNo=" + srlNo + ", customerId=" + customerId + ", accountType="
					+ accountType + ", name=" + name + ", accountNumber=" + accountNumber + ", dateOfBirth="
					+ dateOfBirth + ", placeOfBirth=" + placeOfBirth + ", nationality=" + nationality
					+ ", accountOpeningDate=" + accountOpeningDate + ", countryOfCitizenship=" + countryOfCitizenship
					+ ", countryOfCurrentResidency=" + countryOfCurrentResidency + ", occupation=" + occupation
					+ ", businessActivity=" + businessActivity + ", annualIncome=" + annualIncome + ", sourceOfFunds="
					+ sourceOfFunds + ", purposeOfAccountOpening=" + purposeOfAccountOpening + ", taxRegistration="
					+ taxRegistration + ", taxIdNumber=" + taxIdNumber + ", primaryAddress=" + primaryAddress
					+ ", primaryAddressCountry=" + primaryAddressCountry + ", primaryAddressCity=" + primaryAddressCity
					+ ", primaryAddressPoBox=" + primaryAddressPoBox + ", mobileNumber=" + mobileNumber
					+ ", primaryTelephone=" + primaryTelephone + ", secondaryTelephone=" + secondaryTelephone
					+ ", emailId=" + emailId + ", residentialStatusChanged=" + residentialStatusChanged
					+ ", newCountryOfResidency=" + newCountryOfResidency + ", newCityOfResidency=" + newCityOfResidency
					+ ", newPoBoxOfResidency=" + newPoBoxOfResidency + ", accountSatisfactory=" + accountSatisfactory
					+ ", transactionCommensurate=" + transactionCommensurate + ", highValueTransactionsObserved="
					+ highValueTransactionsObserved + ", highValueTransactionsDetails1=" + highValueTransactionsDetails1
					+ ", suspicionObserved=" + suspicionObserved + ", suspicionObservedDetails="
					+ suspicionObservedDetails + ", branchSatisfiedWithTransactions=" + branchSatisfiedWithTransactions
					+ ", supportingDocumentObtained=" + supportingDocumentObtained + ", currentTurnover="
					+ currentTurnover + ", expectedTurnover=" + expectedTurnover + ", expectedTransactionTypes="
					+ expectedTransactionTypes + ", expectedTransactionVolume=" + expectedTransactionVolume
					+ ", transactionFrequency=" + transactionFrequency + ", uae=" + uae + ", un=" + un + ", ofac="
					+ ofac + ", hmt=" + hmt + ", eu=" + eu + ", others=" + others + ", cbuCheckDone=" + cbuCheckDone
					+ ", googleMediaSearch=" + googleMediaSearch + ", internalDenyListScreening="
					+ internalDenyListScreening + ", supportingDocumentObtained2=" + supportingDocumentObtained2
					+ ", isPep=" + isPep + ", seniorManagementApproval=" + seniorManagementApproval
					+ ", foreignCurrencyRequest=" + foreignCurrencyRequest + ", seniorManagementApprovalFc="
					+ seniorManagementApprovalFc + ", customerRisk=" + customerRisk + ", highRiskReason="
					+ highRiskReason + ", furtherDueDiligence=" + furtherDueDiligence + ", observationsOfBankOfficial="
					+ observationsOfBankOfficial + ", accountOpeningOfficerSignature=" + accountOpeningOfficerSignature
					+ ", accountOpeningOfficerName=" + accountOpeningOfficerName + ", accountOpeningOfficerDesignation="
					+ accountOpeningOfficerDesignation + ", accountOpeningOfficerDate=" + accountOpeningOfficerDate
					+ ", branchOfficialSignature=" + branchOfficialSignature + ", branchOfficialName="
					+ branchOfficialName + ", branchOfficialDesignation=" + branchOfficialDesignation
					+ ", branchOfficialDate=" + branchOfficialDate + ", debit=" + debit + ", credit=" + credit
					+ ", suspicionObserved1=" + suspicionObserved1 + ", countryOfCitizenshipOthers="
					+ countryOfCitizenshipOthers + ", reasonForRedFlag1=" + reasonForRedFlag1 + ", reasonForRedFlag2="
					+ reasonForRedFlag2 + ", jointSupportDocumentDetails=" + jointSupportDocumentDetails + ", branch="
					+ branch + ", lastEcddDate=" + lastEcddDate + ", aofAvailable=" + aofAvailable + ", aofRemarks="
					+ aofRemarks + ", fatcaCrsAvailable=" + fatcaCrsAvailable + ", fatcaCrsRemarks=" + fatcaCrsRemarks
					+ ", sourceOfFundsAvailable=" + sourceOfFundsAvailable + ", sourceOfFundsRemarks="
					+ sourceOfFundsRemarks + ", observations=" + observations + ", currentDate=" + currentDate
					+ ", reportDate=" + reportDate + ", entryUser=" + entryUser + ", entryTime=" + entryTime
					+ ", authUser=" + authUser + ", authTime=" + authTime + ", modifyUser=" + modifyUser
					+ ", modifyTime=" + modifyTime + ", verifyUser=" + verifyUser + ", verifyTime=" + verifyTime
					+ ", entityFlg=" + entityFlg + ", authFlg=" + authFlg + ", modifyFlg=" + modifyFlg + ", delFlg="
					+ delFlg + ", getSrlNo()=" + getSrlNo() + ", getCustomerId()=" + getCustomerId()
					+ ", getAccountType()=" + getAccountType() + ", getName()=" + getName() + ", getAccountNumber()="
					+ getAccountNumber() + ", getDateOfBirth()=" + getDateOfBirth() + ", getPlaceOfBirth()="
					+ getPlaceOfBirth() + ", getNationality()=" + getNationality() + ", getAccountOpeningDate()="
					+ getAccountOpeningDate() + ", getCountryOfCitizenship()=" + getCountryOfCitizenship()
					+ ", getCountryOfCurrentResidency()=" + getCountryOfCurrentResidency() + ", getOccupation()="
					+ getOccupation() + ", getBusinessActivity()=" + getBusinessActivity() + ", getAnnualIncome()="
					+ getAnnualIncome() + ", getSourceOfFunds()=" + getSourceOfFunds()
					+ ", getPurposeOfAccountOpening()=" + getPurposeOfAccountOpening() + ", getTaxRegistration()="
					+ getTaxRegistration() + ", getTaxIdNumber()=" + getTaxIdNumber() + ", getPrimaryAddress()="
					+ getPrimaryAddress() + ", getPrimaryAddressCountry()=" + getPrimaryAddressCountry()
					+ ", getPrimaryAddressCity()=" + getPrimaryAddressCity() + ", getPrimaryAddressPoBox()="
					+ getPrimaryAddressPoBox() + ", getMobileNumber()=" + getMobileNumber() + ", getPrimaryTelephone()="
					+ getPrimaryTelephone() + ", getSecondaryTelephone()=" + getSecondaryTelephone() + ", getEmailId()="
					+ getEmailId() + ", getResidentialStatusChanged()=" + getResidentialStatusChanged()
					+ ", getNewCountryOfResidency()=" + getNewCountryOfResidency() + ", getNewCityOfResidency()="
					+ getNewCityOfResidency() + ", getNewPoBoxOfResidency()=" + getNewPoBoxOfResidency()
					+ ", getAccountSatisfactory()=" + getAccountSatisfactory() + ", getTransactionCommensurate()="
					+ getTransactionCommensurate() + ", getHighValueTransactionsObserved()="
					+ getHighValueTransactionsObserved() + ", getHighValueTransactionsDetails1()="
					+ getHighValueTransactionsDetails1() + ", getSuspicionObserved()=" + getSuspicionObserved()
					+ ", getSuspicionObservedDetails()=" + getSuspicionObservedDetails()
					+ ", getBranchSatisfiedWithTransactions()=" + getBranchSatisfiedWithTransactions()
					+ ", getSupportingDocumentObtained()=" + getSupportingDocumentObtained() + ", getCurrentTurnover()="
					+ getCurrentTurnover() + ", getExpectedTurnover()=" + getExpectedTurnover()
					+ ", getExpectedTransactionTypes()=" + getExpectedTransactionTypes()
					+ ", getExpectedTransactionVolume()=" + getExpectedTransactionVolume()
					+ ", getTransactionFrequency()=" + getTransactionFrequency() + ", getUae()=" + getUae()
					+ ", getUn()=" + getUn() + ", getOfac()=" + getOfac() + ", getHmt()=" + getHmt() + ", getEu()="
					+ getEu() + ", getOthers()=" + getOthers() + ", getCbuCheckDone()=" + getCbuCheckDone()
					+ ", getGoogleMediaSearch()=" + getGoogleMediaSearch() + ", getInternalDenyListScreening()="
					+ getInternalDenyListScreening() + ", getSupportingDocumentObtained2()="
					+ getSupportingDocumentObtained2() + ", getIsPep()=" + getIsPep()
					+ ", getSeniorManagementApproval()=" + getSeniorManagementApproval()
					+ ", getForeignCurrencyRequest()=" + getForeignCurrencyRequest()
					+ ", getSeniorManagementApprovalFc()=" + getSeniorManagementApprovalFc() + ", getCustomerRisk()="
					+ getCustomerRisk() + ", getHighRiskReason()=" + getHighRiskReason() + ", getFurtherDueDiligence()="
					+ getFurtherDueDiligence() + ", getObservationsOfBankOfficial()=" + getObservationsOfBankOfficial()
					+ ", getAccountOpeningOfficerSignature()=" + getAccountOpeningOfficerSignature()
					+ ", getAccountOpeningOfficerName()=" + getAccountOpeningOfficerName()
					+ ", getAccountOpeningOfficerDesignation()=" + getAccountOpeningOfficerDesignation()
					+ ", getAccountOpeningOfficerDate()=" + getAccountOpeningOfficerDate()
					+ ", getBranchOfficialSignature()=" + getBranchOfficialSignature() + ", getBranchOfficialName()="
					+ getBranchOfficialName() + ", getBranchOfficialDesignation()=" + getBranchOfficialDesignation()
					+ ", getBranchOfficialDate()=" + getBranchOfficialDate() + ", getDebit()=" + getDebit()
					+ ", getCredit()=" + getCredit() + ", getSuspicionObserved1()=" + getSuspicionObserved1()
					+ ", getCountryOfCitizenshipOthers()=" + getCountryOfCitizenshipOthers()
					+ ", getReasonForRedFlag1()=" + getReasonForRedFlag1() + ", getReasonForRedFlag2()="
					+ getReasonForRedFlag2() + ", getJointSupportDocumentDetails()=" + getJointSupportDocumentDetails()
					+ ", getBranch()=" + getBranch() + ", getLastEcddDate()=" + getLastEcddDate()
					+ ", getAofAvailable()=" + getAofAvailable() + ", getAofRemarks()=" + getAofRemarks()
					+ ", getFatcaCrsAvailable()=" + getFatcaCrsAvailable() + ", getFatcaCrsRemarks()="
					+ getFatcaCrsRemarks() + ", getSourceOfFundsAvailable()=" + getSourceOfFundsAvailable()
					+ ", getSourceOfFundsRemarks()=" + getSourceOfFundsRemarks() + ", getObservations()="
					+ getObservations() + ", getCurrentDate()=" + getCurrentDate() + ", getReportDate()="
					+ getReportDate() + ", getEntryUser()=" + getEntryUser() + ", getEntryTime()=" + getEntryTime()
					+ ", getAuthUser()=" + getAuthUser() + ", getAuthTime()=" + getAuthTime() + ", getModifyUser()="
					+ getModifyUser() + ", getModifyTime()=" + getModifyTime() + ", getVerifyUser()=" + getVerifyUser()
					+ ", getVerifyTime()=" + getVerifyTime() + ", getEntityFlg()=" + getEntityFlg() + ", getAuthFlg()="
					+ getAuthFlg() + ", getModifyFlg()=" + getModifyFlg() + ", getDelFlg()=" + getDelFlg()
					+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
					+ "]";
		}
		public ECDDIndividualEntity(String srlNo, String customerId, String accountType, String name,
				String accountNumber, Date dateOfBirth, String placeOfBirth, String nationality,
				Date accountOpeningDate, String countryOfCitizenship, String countryOfCurrentResidency,
				String occupation, String businessActivity, Double annualIncome, String sourceOfFunds,
				String purposeOfAccountOpening, String taxRegistration, String taxIdNumber, String primaryAddress,
				String primaryAddressCountry, String primaryAddressCity, String primaryAddressPoBox,
				String mobileNumber, String primaryTelephone, String secondaryTelephone, String emailId,
				String residentialStatusChanged, String newCountryOfResidency, String newCityOfResidency,
				String newPoBoxOfResidency, String accountSatisfactory, String transactionCommensurate,
				String highValueTransactionsObserved, String highValueTransactionsDetails1, String suspicionObserved,
				String suspicionObservedDetails, String branchSatisfiedWithTransactions,
				String supportingDocumentObtained, Double currentTurnover, Double expectedTurnover,
				String expectedTransactionTypes, Double expectedTransactionVolume, String transactionFrequency,
				String uae, String un, String ofac, String hmt, String eu, String others, String cbuCheckDone,
				String googleMediaSearch, String internalDenyListScreening, String supportingDocumentObtained2,
				String isPep, String seniorManagementApproval, String foreignCurrencyRequest,
				String seniorManagementApprovalFc, String customerRisk, String highRiskReason,
				String furtherDueDiligence, String observationsOfBankOfficial, String accountOpeningOfficerSignature,
				String accountOpeningOfficerName, String accountOpeningOfficerDesignation,
				Date accountOpeningOfficerDate, String branchOfficialSignature, String branchOfficialName,
				String branchOfficialDesignation, Date branchOfficialDate, String debit, String credit,
				String suspicionObserved1, String countryOfCitizenshipOthers, String reasonForRedFlag1,
				String reasonForRedFlag2, String jointSupportDocumentDetails, String branch, Date lastEcddDate,
				String aofAvailable, String aofRemarks, String fatcaCrsAvailable, String fatcaCrsRemarks,
				String sourceOfFundsAvailable, String sourceOfFundsRemarks, String observations, Date currentDate,
				Date reportDate, String entryUser, Date entryTime, String authUser, Date authTime, String modifyUser,
				Date modifyTime, String verifyUser, Date verifyTime, String entityFlg, String authFlg, String modifyFlg,
				String delFlg) {
			super();
			this.srlNo = srlNo;
			this.customerId = customerId;
			this.accountType = accountType;
			this.name = name;
			this.accountNumber = accountNumber;
			this.dateOfBirth = dateOfBirth;
			this.placeOfBirth = placeOfBirth;
			this.nationality = nationality;
			this.accountOpeningDate = accountOpeningDate;
			this.countryOfCitizenship = countryOfCitizenship;
			this.countryOfCurrentResidency = countryOfCurrentResidency;
			this.occupation = occupation;
			this.businessActivity = businessActivity;
			this.annualIncome = annualIncome;
			this.sourceOfFunds = sourceOfFunds;
			this.purposeOfAccountOpening = purposeOfAccountOpening;
			this.taxRegistration = taxRegistration;
			this.taxIdNumber = taxIdNumber;
			this.primaryAddress = primaryAddress;
			this.primaryAddressCountry = primaryAddressCountry;
			this.primaryAddressCity = primaryAddressCity;
			this.primaryAddressPoBox = primaryAddressPoBox;
			this.mobileNumber = mobileNumber;
			this.primaryTelephone = primaryTelephone;
			this.secondaryTelephone = secondaryTelephone;
			this.emailId = emailId;
			this.residentialStatusChanged = residentialStatusChanged;
			this.newCountryOfResidency = newCountryOfResidency;
			this.newCityOfResidency = newCityOfResidency;
			this.newPoBoxOfResidency = newPoBoxOfResidency;
			this.accountSatisfactory = accountSatisfactory;
			this.transactionCommensurate = transactionCommensurate;
			this.highValueTransactionsObserved = highValueTransactionsObserved;
			this.highValueTransactionsDetails1 = highValueTransactionsDetails1;
			this.suspicionObserved = suspicionObserved;
			this.suspicionObservedDetails = suspicionObservedDetails;
			this.branchSatisfiedWithTransactions = branchSatisfiedWithTransactions;
			this.supportingDocumentObtained = supportingDocumentObtained;
			this.currentTurnover = currentTurnover;
			this.expectedTurnover = expectedTurnover;
			this.expectedTransactionTypes = expectedTransactionTypes;
			this.expectedTransactionVolume = expectedTransactionVolume;
			this.transactionFrequency = transactionFrequency;
			this.uae = uae;
			this.un = un;
			this.ofac = ofac;
			this.hmt = hmt;
			this.eu = eu;
			this.others = others;
			this.cbuCheckDone = cbuCheckDone;
			this.googleMediaSearch = googleMediaSearch;
			this.internalDenyListScreening = internalDenyListScreening;
			this.supportingDocumentObtained2 = supportingDocumentObtained2;
			this.isPep = isPep;
			this.seniorManagementApproval = seniorManagementApproval;
			this.foreignCurrencyRequest = foreignCurrencyRequest;
			this.seniorManagementApprovalFc = seniorManagementApprovalFc;
			this.customerRisk = customerRisk;
			this.highRiskReason = highRiskReason;
			this.furtherDueDiligence = furtherDueDiligence;
			this.observationsOfBankOfficial = observationsOfBankOfficial;
			this.accountOpeningOfficerSignature = accountOpeningOfficerSignature;
			this.accountOpeningOfficerName = accountOpeningOfficerName;
			this.accountOpeningOfficerDesignation = accountOpeningOfficerDesignation;
			this.accountOpeningOfficerDate = accountOpeningOfficerDate;
			this.branchOfficialSignature = branchOfficialSignature;
			this.branchOfficialName = branchOfficialName;
			this.branchOfficialDesignation = branchOfficialDesignation;
			this.branchOfficialDate = branchOfficialDate;
			this.debit = debit;
			this.credit = credit;
			this.suspicionObserved1 = suspicionObserved1;
			this.countryOfCitizenshipOthers = countryOfCitizenshipOthers;
			this.reasonForRedFlag1 = reasonForRedFlag1;
			this.reasonForRedFlag2 = reasonForRedFlag2;
			this.jointSupportDocumentDetails = jointSupportDocumentDetails;
			this.branch = branch;
			this.lastEcddDate = lastEcddDate;
			this.aofAvailable = aofAvailable;
			this.aofRemarks = aofRemarks;
			this.fatcaCrsAvailable = fatcaCrsAvailable;
			this.fatcaCrsRemarks = fatcaCrsRemarks;
			this.sourceOfFundsAvailable = sourceOfFundsAvailable;
			this.sourceOfFundsRemarks = sourceOfFundsRemarks;
			this.observations = observations;
			this.currentDate = currentDate;
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
		public ECDDIndividualEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
		

	    // Getters and Setters can be added or generated using Lombok
		/*
		 * }
		 * 
		 * 
		 * public KYC_I() { super(); // TODO Auto-generated constructor stub }
		 */

	
	
	
	
	
}