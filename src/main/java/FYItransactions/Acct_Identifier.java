package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Account", propOrder = {
    "othr"
})
public class Acct_Identifier {
	@XmlElement(name = "Othr", required = true)
	protected Others othr;

	public Others getOthr() {
		return othr;
	}

	public void setOthr(Others othr) {
		this.othr = othr;
	}
}
