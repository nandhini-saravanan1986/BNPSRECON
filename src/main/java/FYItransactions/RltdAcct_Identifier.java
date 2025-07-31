package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RelatedAccount", propOrder = {
    "othr"
})
public class RltdAcct_Identifier {
	@XmlElement(name = "Othr", required = true)
	protected RltdAcct_Other othr;

	public RltdAcct_Other getOthr() {
		return othr;
	}

	public void setOthr(RltdAcct_Other othr) {
		this.othr = othr;
	}
}
