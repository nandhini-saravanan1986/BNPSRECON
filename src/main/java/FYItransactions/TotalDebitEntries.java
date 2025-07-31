package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TtlDbtNtries", propOrder = {
    "txsSummryDebitNumberOfEntries",
    "txsSummryDebitSum"
})
public class TotalDebitEntries {
	@XmlElement(name = "NbOfNtries", required = true)
    protected BigDecimal txsSummryDebitNumberOfEntries;
	
	@XmlElement(name = "Sum", required = true)
    protected BigDecimal txsSummryDebitSum;

	public BigDecimal getTxsSummryDebitNumberOfEntries() {
		return txsSummryDebitNumberOfEntries;
	}

	public void setTxsSummryDebitNumberOfEntries(BigDecimal txsSummryDebitNumberOfEntries) {
		this.txsSummryDebitNumberOfEntries = txsSummryDebitNumberOfEntries;
	}

	public BigDecimal getTxsSummryDebitSum() {
		return txsSummryDebitSum;
	}

	public void setTxsSummryDebitSum(BigDecimal txsSummryDebitSum) {
		this.txsSummryDebitSum = txsSummryDebitSum;
	}
}
