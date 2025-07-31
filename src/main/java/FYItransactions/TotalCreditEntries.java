package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TtlCdtNtries", propOrder = {
    "txsSummryCreditNumberOfEntries",
    "txsSummryCreditSum"
})
public class TotalCreditEntries {
	@XmlElement(name = "NbOfNtries", required = true)
    protected BigDecimal txsSummryCreditNumberOfEntries;
	
	@XmlElement(name = "Sum", required = true)
    protected BigDecimal txsSummryCreditSum;

	public BigDecimal getTxsSummryCreditNumberOfEntries() {
		return txsSummryCreditNumberOfEntries;
	}

	public void setTxsSummryCreditNumberOfEntries(BigDecimal txsSummryCreditNumberOfEntries) {
		this.txsSummryCreditNumberOfEntries = txsSummryCreditNumberOfEntries;
	}

	public BigDecimal getTxsSummryCreditSum() {
		return txsSummryCreditSum;
	}

	public void setTxsSummryCreditSum(BigDecimal txsSummryCreditSum) {
		this.txsSummryCreditSum = txsSummryCreditSum;
	}
}
