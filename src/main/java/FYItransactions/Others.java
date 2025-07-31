package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Acct_Identifier", propOrder = {
    "stmtAccountIdentifier"
})
public class Others {
	@XmlElement(name = "Id", required = true)
    protected String stmtAccountIdentifier;

	public String getStmtAccountIdentifier() {
		return stmtAccountIdentifier;
	}

	public void setStmtAccountIdentifier(String stmtAccountIdentifier) {
		this.stmtAccountIdentifier = stmtAccountIdentifier;
	}
}
