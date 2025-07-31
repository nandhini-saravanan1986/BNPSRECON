package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CdtrAgt", propOrder = {
    "finInstnId"
})
public class CreditorAgent {
	@XmlElement(name = "FinInstnId", required = true)
	protected FinancialInstitutionIdentification2 finInstnId;

	public FinancialInstitutionIdentification2 getFinInstnId() {
		return finInstnId;
	}

	public void setFinInstnId(FinancialInstitutionIdentification2 finInstnId) {
		this.finInstnId = finInstnId;
	}
}
