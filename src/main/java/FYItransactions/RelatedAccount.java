package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RltdAcct", propOrder = {
    "id"
})
public class RelatedAccount {
	@XmlElement(name = "Id", required = true)
	protected RltdAcct_Identifier id;

	public RltdAcct_Identifier getId() {
		return id;
	}

	public void setId(RltdAcct_Identifier id) {
		this.id = id;
	}
}
