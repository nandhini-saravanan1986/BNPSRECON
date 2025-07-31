package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsgPgntn", propOrder = {
    "grpHdrPageNumber",
    "grpHdrLastPageIndicator"
})
public class MessagePagination {
	@XmlElement(name = "PgNb", required = true)
    protected BigDecimal grpHdrPageNumber;
	
	@XmlElement(name = "LastPgInd", required = true)
    protected String grpHdrLastPageIndicator;

	public BigDecimal getGrpHdrPageNumber() {
		return grpHdrPageNumber;
	}

	public void setGrpHdrPageNumber(BigDecimal grpHdrPageNumber) {
		this.grpHdrPageNumber = grpHdrPageNumber;
	}

	public String getGrpHdrLastPageIndicator() {
		return grpHdrLastPageIndicator;
	}

	public void setGrpHdrLastPageIndicator(String grpHdrLastPageIndicator) {
		this.grpHdrLastPageIndicator = grpHdrLastPageIndicator;
	}
}
