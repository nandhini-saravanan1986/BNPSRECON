package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RltdAgts", propOrder = {
    "instgAgt",
    "dbtrAgt",
    "cdtrAgt"
})
public class RelatedAgents {
	@XmlElement(name = "InstgAgt", required = true)
	protected InstructingAgent1 instgAgt;
	
	@XmlElement(name = "DbtrAgt", required = true)
	protected DebtorAgent dbtrAgt;
	
	@XmlElement(name = "CdtrAgt", required = true)
	protected CreditorAgent cdtrAgt;

	public InstructingAgent1 getInstgAgt() {
		return instgAgt;
	}

	public void setInstgAgt(InstructingAgent1 instgAgt) {
		this.instgAgt = instgAgt;
	}

	public DebtorAgent getDbtrAgt() {
		return dbtrAgt;
	}

	public void setDbtrAgt(DebtorAgent dbtrAgt) {
		this.dbtrAgt = dbtrAgt;
	}

	public CreditorAgent getCdtrAgt() {
		return cdtrAgt;
	}

	public void setCdtrAgt(CreditorAgent cdtrAgt) {
		this.cdtrAgt = cdtrAgt;
	}
}
