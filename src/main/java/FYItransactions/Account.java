package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Acct", propOrder = {
    "id"
})
public class Account {
	@XmlElement(name = "Id", required = true)
	protected Acct_Identifier id;

	public Acct_Identifier getId() {
		return id;
	}

	public void setId(Acct_Identifier id) {
		this.id = id;
	}
}
