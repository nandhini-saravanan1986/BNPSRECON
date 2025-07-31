package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tp", propOrder = {
    "cdOrPrtry"
})
public class TradingPartner {
	@XmlElement(name = "CdOrPrtry", required = true)
	protected CodeorProprietary cdOrPrtry;

	public CodeorProprietary getCdOrPrtry() {
		return cdOrPrtry;
	}

	public void setCdOrPrtry(CodeorProprietary cdOrPrtry) {
		this.cdOrPrtry = cdOrPrtry;
	}
}
