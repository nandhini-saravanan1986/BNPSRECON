package FYItransactions;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValDt", propOrder = {
    "ntryValueDate",
    "ntryValueDateTime"
})
public class ValueDate {
	@XmlElement(name = "Dt", required = true)
    protected Date ntryValueDate;
	
	@XmlElement(name = "DtTm", required = true)
    protected String ntryValueDateTime;

	public Date getNtryValueDate() {
		return ntryValueDate;
	}

	public void setNtryValueDate(Date ntryValueDate) {
		this.ntryValueDate = ntryValueDate;
	}

	public String getNtryValueDateTime() {
		return ntryValueDateTime;
	}

	public void setNtryValueDateTime(String ntryValueDateTime) {
		this.ntryValueDateTime = ntryValueDateTime;
	}

}
