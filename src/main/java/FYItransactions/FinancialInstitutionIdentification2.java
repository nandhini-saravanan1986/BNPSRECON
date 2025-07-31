package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditorAgent", propOrder = {
    "ntry_cdtragt_bicfi_credit"
})
public class FinancialInstitutionIdentification2 {
	@XmlElement(name = "BICFI", required = true)
    protected String ntry_cdtragt_bicfi_credit;

	public String getNtry_cdtragt_bicfi_credit() {
		return ntry_cdtragt_bicfi_credit;
	}

	public void setNtry_cdtragt_bicfi_credit(String ntry_cdtragt_bicfi_credit) {
		this.ntry_cdtragt_bicfi_credit = ntry_cdtragt_bicfi_credit;
	}
}
