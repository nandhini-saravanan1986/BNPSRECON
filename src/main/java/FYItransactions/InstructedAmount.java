package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InstdAmt", propOrder = {
    "ntryInstructedAmount"
})
public class InstructedAmount {
	@XmlElement(name = "Amt", required = true)
    protected BigDecimal ntryInstructedAmount;

	public BigDecimal getNtryInstructedAmount() {
		return ntryInstructedAmount;
	}

	public void setNtryInstructedAmount(BigDecimal ntryInstructedAmount) {
		this.ntryInstructedAmount = ntryInstructedAmount;
	}
}
