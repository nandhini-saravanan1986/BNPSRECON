package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Id", propOrder = {
    "orgId"
})
public class Identification {
	@XmlElement(name = "OrgId", required = true)
	protected OrganizationIdentifier orgId;

	public OrganizationIdentifier getOrgId() {
		return orgId;
	}

	public void setOrgId(OrganizationIdentifier orgId) {
		this.orgId = orgId;
	}
}
