package FYItransactions;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BkToCstmrStmt", propOrder = {
    "grpHdr",
    "stmt"
})
public class BankCustomerStatement {
	@XmlElement(name = "GrpHdr", required = true)
	protected GroupHeader grpHdr;

	@XmlElement(name = "Stmt", required = true)
	protected Statement stmt;

	public GroupHeader getGrpHdr() {
		return grpHdr;
	}

	public void setGrpHdr(GroupHeader grpHdr) {
		this.grpHdr = grpHdr;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}
}
