package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TtlNtries", propOrder = {
    "txsSummryNumberOfEntries",
    "txsSummrySum",
    "ttlNetNtry"
})
public class TotalEntries {
	@XmlElement(name = "NbOfNtries", required = true)
    protected BigDecimal txsSummryNumberOfEntries;
	
	@XmlElement(name = "Sum", required = true)
    protected BigDecimal txsSummrySum;
	
	@XmlElement(name = "TtlNetNtry", required = true)
	protected TotalNetEntry ttlNetNtry;

	public BigDecimal getTxsSummryNumberOfEntries() {
		return txsSummryNumberOfEntries;
	}

	public void setTxsSummryNumberOfEntries(BigDecimal txsSummryNumberOfEntries) {
		this.txsSummryNumberOfEntries = txsSummryNumberOfEntries;
	}

	public BigDecimal getTxsSummrySum() {
		return txsSummrySum;
	}

	public void setTxsSummrySum(BigDecimal txsSummrySum) {
		this.txsSummrySum = txsSummrySum;
	}

	public TotalNetEntry getTtlNetNtry() {
		return ttlNetNtry;
	}

	public void setTtlNetNtry(TotalNetEntry ttlNetNtry) {
		this.ttlNetNtry = ttlNetNtry;
	}
}
