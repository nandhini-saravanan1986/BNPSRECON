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
@XmlType(name = "BookgDt", propOrder = {
    "ntryBookingDate",
    "ntryBookingDateTime"
})
public class BookingDate {
	@XmlElement(name = "Dt", required = true)
    protected Date ntryBookingDate;
	
	@XmlElement(name = "DtTm", required = true)
    protected Date ntryBookingDateTime;

	public Date getNtryBookingDate() {
		return ntryBookingDate;
	}

	public void setNtryBookingDate(Date ntryBookingDate) {
		this.ntryBookingDate = ntryBookingDate;
	}

	public Date getNtryBookingDateTime() {
		return ntryBookingDateTime;
	}

	public void setNtryBookingDateTime(Date ntryBookingDateTime) {
		this.ntryBookingDateTime = ntryBookingDateTime;
	}
}
