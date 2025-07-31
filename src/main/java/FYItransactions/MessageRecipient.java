package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MsgRcpt", propOrder = {
    "grpHdrName",
    "id"
})
public class MessageRecipient {
	@XmlElement(name = "Nm", required = true)
    protected String grpHdrName;
	@XmlElement(name = "Id", required = true)
	protected Identification id;
	public String getGrpHdrName() {
		return grpHdrName;
	}
	public void setGrpHdrName(String grpHdrName) {
		this.grpHdrName = grpHdrName;
	}
	public Identification getId() {
		return id;
	}
	public void setId(Identification id) {
		this.id = id;
	}
}
