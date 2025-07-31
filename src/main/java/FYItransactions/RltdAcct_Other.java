package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RltdAcct_Identifier", propOrder = {
    "stmtRelatedAccountIdentifier"
})
public class RltdAcct_Other {
	@XmlElement(name = "Id", required = true)
    protected String stmtRelatedAccountIdentifier;

	public String getStmtRelatedAccountIdentifier() {
		return stmtRelatedAccountIdentifier;
	}

	public void setStmtRelatedAccountIdentifier(String stmtRelatedAccountIdentifier) {
		this.stmtRelatedAccountIdentifier = stmtRelatedAccountIdentifier;
	}
}
