package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Prtry", propOrder = {
    "ntryProprietaryCode"
})
public class Proprietary {
	@XmlElement(name = "Cd", required = true)
    protected String ntryProprietaryCode;

	public String getNtryProprietaryCode() {
		return ntryProprietaryCode;
	}

	public void setNtryProprietaryCode(String ntryProprietaryCode) {
		this.ntryProprietaryCode = ntryProprietaryCode;
	}
}
