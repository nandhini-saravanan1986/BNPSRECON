package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sts", propOrder = {
    "ntryCode"
})
public class Entry_Status {
	@XmlElement(name = "Cd", required = true)
    protected String ntryCode;

	public String getNtryCode() {
		return ntryCode;
	}

	public void setNtryCode(String ntryCode) {
		this.ntryCode = ntryCode;
	}
}
