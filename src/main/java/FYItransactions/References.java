package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Refs", propOrder = {
    "ntryRefsMessageIdentifier",
    "ntry_refs_pmtinfid",
    "ntryRefsAccountServicerReference",
    "ntryRefsInstructionId",
    "ntryRefsEndToEndIdentification",
    "ntry_refs_uetr",
    "ntryRefsTransactionId",
    "ntryRefsClearingSystemReference"
})
public class References {
	@XmlElement(name = "MsgId", required = true)
    protected String ntryRefsMessageIdentifier;
	
	@XmlElement(name = "PmtInfId", required = true)
    protected String ntry_refs_pmtinfid;
	
	@XmlElement(name = "AcctSvcrRef", required = true)
    protected String ntryRefsAccountServicerReference;
	
	@XmlElement(name = "InstrId", required = true)
    protected String ntryRefsInstructionId;
	
	@XmlElement(name = "EndToEndId", required = true)
    protected String ntryRefsEndToEndIdentification;
	
	@XmlElement(name = "UETR", required = true)
    protected String ntry_refs_uetr;
	
	@XmlElement(name = "TxId", required = true)
    protected String ntryRefsTransactionId;
	
	@XmlElement(name = "ClrSysRef", required = true)
    protected String ntryRefsClearingSystemReference;

	public String getNtryRefsMessageIdentifier() {
		return ntryRefsMessageIdentifier;
	}

	public void setNtryRefsMessageIdentifier(String ntryRefsMessageIdentifier) {
		this.ntryRefsMessageIdentifier = ntryRefsMessageIdentifier;
	}

	public String getNtry_refs_pmtinfid() {
		return ntry_refs_pmtinfid;
	}

	public void setNtry_refs_pmtinfid(String ntry_refs_pmtinfid) {
		this.ntry_refs_pmtinfid = ntry_refs_pmtinfid;
	}

	public String getNtryRefsAccountServicerReference() {
		return ntryRefsAccountServicerReference;
	}

	public void setNtryRefsAccountServicerReference(String ntryRefsAccountServicerReference) {
		this.ntryRefsAccountServicerReference = ntryRefsAccountServicerReference;
	}

	public String getNtryRefsInstructionId() {
		return ntryRefsInstructionId;
	}

	public void setNtryRefsInstructionId(String ntryRefsInstructionId) {
		this.ntryRefsInstructionId = ntryRefsInstructionId;
	}

	public String getNtryRefsEndToEndIdentification() {
		return ntryRefsEndToEndIdentification;
	}

	public void setNtryRefsEndToEndIdentification(String ntryRefsEndToEndIdentification) {
		this.ntryRefsEndToEndIdentification = ntryRefsEndToEndIdentification;
	}

	public String getNtry_refs_uetr() {
		return ntry_refs_uetr;
	}

	public void setNtry_refs_uetr(String ntry_refs_uetr) {
		this.ntry_refs_uetr = ntry_refs_uetr;
	}

	public String getNtryRefsTransactionId() {
		return ntryRefsTransactionId;
	}

	public void setNtryRefsTransactionId(String ntryRefsTransactionId) {
		this.ntryRefsTransactionId = ntryRefsTransactionId;
	}

	public String getNtryRefsClearingSystemReference() {
		return ntryRefsClearingSystemReference;
	}

	public void setNtryRefsClearingSystemReference(String ntryRefsClearingSystemReference) {
		this.ntryRefsClearingSystemReference = ntryRefsClearingSystemReference;
	}
}
