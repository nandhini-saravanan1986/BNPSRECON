package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TxDtls", propOrder = {
    "refs",
    "ntryTxDtlsAmountCurrency",
    "ntryTxDtlsCreditDebitIndicator",
    "msgRcpt"
})
public class TransactionDetails {
	@XmlElement(name = "Refs", required = true)
	protected References refs;
	
	@XmlElement(name = "Amt", required = true)
    protected BigDecimal ntryTxDtlsAmountCurrency;
	
	@XmlElement(name = "CdtDbtInd", required = true)
    protected String ntryTxDtlsCreditDebitIndicator;
	
	@XmlElement(name = "RltdAgts", required = true)
	protected RelatedAgents msgRcpt;

	public References getRefs() {
		return refs;
	}

	public void setRefs(References refs) {
		this.refs = refs;
	}

	public BigDecimal getNtryTxDtlsAmountCurrency() {
		return ntryTxDtlsAmountCurrency;
	}

	public void setNtryTxDtlsAmountCurrency(BigDecimal ntryTxDtlsAmountCurrency) {
		this.ntryTxDtlsAmountCurrency = ntryTxDtlsAmountCurrency;
	}

	public String getNtryTxDtlsCreditDebitIndicator() {
		return ntryTxDtlsCreditDebitIndicator;
	}

	public void setNtryTxDtlsCreditDebitIndicator(String ntryTxDtlsCreditDebitIndicator) {
		this.ntryTxDtlsCreditDebitIndicator = ntryTxDtlsCreditDebitIndicator;
	}

	public RelatedAgents getMsgRcpt() {
		return msgRcpt;
	}

	public void setMsgRcpt(RelatedAgents msgRcpt) {
		this.msgRcpt = msgRcpt;
	}
}
