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
@XmlType(name = "FrToDt", propOrder = {
    "stmtFromDateTime",
    "stmtToDateTime"
})
public class FromToDate {
	@XmlElement(name = "FrDtTm", required = true)
    protected Date stmtFromDateTime;
	
	@XmlElement(name = "ToDtTm", required = true)
    protected Date stmtToDateTime;

	public Date getStmtFromDateTime() {
		return stmtFromDateTime;
	}

	public void setStmtFromDateTime(Date stmtFromDateTime) {
		this.stmtFromDateTime = stmtFromDateTime;
	}

	public Date getStmtToDateTime() {
		return stmtToDateTime;
	}

	public void setStmtToDateTime(Date stmtToDateTime) {
		this.stmtToDateTime = stmtToDateTime;
	}

	
}
