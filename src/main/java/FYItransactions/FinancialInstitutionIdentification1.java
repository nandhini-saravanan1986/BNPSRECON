package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DebtorAgent", propOrder = {
    "ntry_dbtragt_bicfi_debit"
})
public class FinancialInstitutionIdentification1 {
	@XmlElement(name = "BICFI", required = true)
    protected String ntry_dbtragt_bicfi_debit;

	public String getNtry_dbtragt_bicfi_debit() {
		return ntry_dbtragt_bicfi_debit;
	}

	public void setNtry_dbtragt_bicfi_debit(String ntry_dbtragt_bicfi_debit) {
		this.ntry_dbtragt_bicfi_debit = ntry_dbtragt_bicfi_debit;
	}
}
