package FYItransactions;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Stmt", propOrder = {
    "stmtStatementIdentifier",
    "stmtElectronicSequenceNumber",
    "stmtCreationDateTime",
    "frToDt",
    "acct",
    "rltdAcct",
    "bal",
    "txsSummry",
    "ntry"
})
public class Statement {
	@XmlElement(name = "Id", required = true)
    protected String stmtStatementIdentifier;

    @XmlElement(name = "ElctrncSeqNb", required = true)
    protected BigDecimal stmtElectronicSequenceNumber;
	
	@XmlElement(name = "CreDtTm", required = true)
    protected Date stmtCreationDateTime;
	
	@XmlElement(name = "FrToDt", required = true)
	protected FromToDate frToDt;

	@XmlElement(name = "Acct", required = true)
	protected Account acct;
	
	@XmlElement(name = "RltdAcct", required = true)
	protected RelatedAccount rltdAcct;
	
	@XmlElement(name = "Bal", required = true)
	protected List<Balance> bal;
	
	@XmlElement(name = "TxsSummry", required = true)
	protected TransactionsSummary txsSummry;
	
	@XmlElement(name = "Ntry", required = true)
	protected List<Entry> ntry;

	public String getStmtStatementIdentifier() {
		return stmtStatementIdentifier;
	}

	public void setStmtStatementIdentifier(String stmtStatementIdentifier) {
		this.stmtStatementIdentifier = stmtStatementIdentifier;
	}

	public BigDecimal getStmtElectronicSequenceNumber() {
		return stmtElectronicSequenceNumber;
	}

	public void setStmtElectronicSequenceNumber(BigDecimal stmtElectronicSequenceNumber) {
		this.stmtElectronicSequenceNumber = stmtElectronicSequenceNumber;
	}

	public Date getStmtCreationDateTime() {
		return stmtCreationDateTime;
	}

	public void setStmtCreationDateTime(Date stmtCreationDateTime) {
		this.stmtCreationDateTime = stmtCreationDateTime;
	}

	public FromToDate getFrToDt() {
		return frToDt;
	}

	public void setFrToDt(FromToDate frToDt) {
		this.frToDt = frToDt;
	}

	public Account getAcct() {
		return acct;
	}

	public void setAcct(Account acct) {
		this.acct = acct;
	}

	public RelatedAccount getRltdAcct() {
		return rltdAcct;
	}

	public void setRltdAcct(RelatedAccount rltdAcct) {
		this.rltdAcct = rltdAcct;
	}

	public List<Balance> getBal() {
		return bal;
	}

	public void setBal(List<Balance> bal) {
		this.bal = bal;
	}

	public TransactionsSummary getTxsSummry() {
		return txsSummry;
	}

	public void setTxsSummry(TransactionsSummary txsSummry) {
		this.txsSummry = txsSummry;
	}

	public List<Entry> getNtry() {
		return ntry;
	}

	public void setNtry(List<Entry> ntry) {
		this.ntry = ntry;
	}
}
