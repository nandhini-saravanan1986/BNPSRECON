package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TxsSummry", propOrder = {
    "ttlNtries",
    "ttlCdtNtries",
    "ttlDbtNtries"
})
public class TransactionsSummary {
	@XmlElement(name = "TtlNtries", required = true)
	  protected TotalEntries ttlNtries;
	
	@XmlElement(name = "TtlCdtNtries", required = true)
	  protected TotalCreditEntries ttlCdtNtries;
	
	@XmlElement(name = "TtlDbtNtries", required = true)
	  protected TotalDebitEntries ttlDbtNtries;

	public TotalEntries getTtlNtries() {
		return ttlNtries;
	}

	public void setTtlNtries(TotalEntries ttlNtries) {
		this.ttlNtries = ttlNtries;
	}

	public TotalCreditEntries getTtlCdtNtries() {
		return ttlCdtNtries;
	}

	public void setTtlCdtNtries(TotalCreditEntries ttlCdtNtries) {
		this.ttlCdtNtries = ttlCdtNtries;
	}

	public TotalDebitEntries getTtlDbtNtries() {
		return ttlDbtNtries;
	}

	public void setTtlDbtNtries(TotalDebitEntries ttlDbtNtries) {
		this.ttlDbtNtries = ttlDbtNtries;
	}
}
