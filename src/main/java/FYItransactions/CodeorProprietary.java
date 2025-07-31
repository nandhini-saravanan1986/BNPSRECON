package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CdOrPrtry", propOrder = {
    "stmtBalCodeOrProprietary"
})
public class CodeorProprietary {
	@XmlElement(name = "Prtry", required = true)
    protected String stmtBalCodeOrProprietary;

	public String getStmtBalCodeOrProprietary() {
		return stmtBalCodeOrProprietary;
	}

	public void setStmtBalCodeOrProprietary(String stmtBalCodeOrProprietary) {
		this.stmtBalCodeOrProprietary = stmtBalCodeOrProprietary;
	}
}
