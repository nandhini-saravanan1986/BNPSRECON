package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DbtrAgt", propOrder = {
    "finInstnId"
})
public class DebtorAgent {
	@XmlElement(name = "FinInstnId", required = true)
	protected FinancialInstitutionIdentification1 finInstnId;

	public FinancialInstitutionIdentification1 getFinInstnId() {
		return finInstnId;
	}

	public void setFinInstnId(FinancialInstitutionIdentification1 finInstnId) {
		this.finInstnId = finInstnId;
	}
}
