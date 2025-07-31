package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TtlNetNtry", propOrder = {
    "txsSummryAmount",
    "txsSummryCreditDebitIndicator"
})
public class TotalNetEntry {
	@XmlElement(name = "Amt", required = true)
    protected BigDecimal txsSummryAmount;
	
	@XmlElement(name = "CdtDbtInd", required = true)
    protected String txsSummryCreditDebitIndicator;

	public BigDecimal getTxsSummryAmount() {
		return txsSummryAmount;
	}

	public void setTxsSummryAmount(BigDecimal txsSummryAmount) {
		this.txsSummryAmount = txsSummryAmount;
	}

	public String getTxsSummryCreditDebitIndicator() {
		return txsSummryCreditDebitIndicator;
	}

	public void setTxsSummryCreditDebitIndicator(String txsSummryCreditDebitIndicator) {
		this.txsSummryCreditDebitIndicator = txsSummryCreditDebitIndicator;
	}
}
