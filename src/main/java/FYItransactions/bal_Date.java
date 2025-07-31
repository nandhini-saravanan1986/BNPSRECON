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
@XmlType(name = "Dt", propOrder = {
    "stmtBalDate",
    "stmtBalDateTime"
})
public class bal_Date {
	@XmlElement(name = "Dt", required = true)
    protected Date stmtBalDate;
	
	@XmlElement(name = "DtTm", required = true)
    protected Date stmtBalDateTime;

	public Date getStmtBalDate() {
		return stmtBalDate;
	}

	public void setStmtBalDate(Date stmtBalDate) {
		this.stmtBalDate = stmtBalDate;
	}

	public Date getStmtBalDateTime() {
		return stmtBalDateTime;
	}

	public void setStmtBalDateTime(Date stmtBalDateTime) {
		this.stmtBalDateTime = stmtBalDateTime;
	}
}
