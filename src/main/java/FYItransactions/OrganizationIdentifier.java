package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrgId", propOrder = {
    "grpHdrBankIdentifierCode"
})
public class OrganizationIdentifier {
	@XmlElement(name = "AnyBIC", required = true)
    protected String grpHdrBankIdentifierCode;

	public String getGrpHdrBankIdentifierCode() {
		return grpHdrBankIdentifierCode;
	}

	public void setGrpHdrBankIdentifierCode(String grpHdrBankIdentifierCode) {
		this.grpHdrBankIdentifierCode = grpHdrBankIdentifierCode;
	}
}
