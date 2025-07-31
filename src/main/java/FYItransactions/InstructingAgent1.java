package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstgAgt", propOrder = {
    "finInstnId"
})
public class InstructingAgent1 {
	@XmlElement(name = "FinInstnId", required = true)
	protected FinancialInstitutionIdentifier finInstnId;

	public FinancialInstitutionIdentifier getFinInstnId() {
		return finInstnId;
	}

	public void setFinInstnId(FinancialInstitutionIdentifier finInstnId) {
		this.finInstnId = finInstnId;
	}
}
