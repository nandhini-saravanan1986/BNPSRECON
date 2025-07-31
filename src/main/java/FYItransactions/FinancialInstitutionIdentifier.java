package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstructingAgent1", propOrder = {
    "ntry_fininstnid_bicfi"
})
public class FinancialInstitutionIdentifier {
	@XmlElement(name = "BICFI", required = true)
    protected String ntry_fininstnid_bicfi;

	public String getNtry_fininstnid_bicfi() {
		return ntry_fininstnid_bicfi;
	}

	public void setNtry_fininstnid_bicfi(String ntry_fininstnid_bicfi) {
		this.ntry_fininstnid_bicfi = ntry_fininstnid_bicfi;
	}
}
