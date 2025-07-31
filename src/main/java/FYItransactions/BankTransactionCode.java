package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BkTxCd", propOrder = {
    "prtry"
})
public class BankTransactionCode {
	@XmlElement(name = "Prtry", required = true)
	protected Proprietary prtry;

	public Proprietary getPrtry() {
		return prtry;
	}

	public void setPrtry(Proprietary prtry) {
		this.prtry = prtry;
	}
}
