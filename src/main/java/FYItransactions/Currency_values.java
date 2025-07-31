package FYItransactions;
import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Currency_values", propOrder = {
    "ntry_transaction_amount",
    "transaction_currency"
})
public class Currency_values {
	@XmlValue
    protected BigDecimal ntry_transaction_amount;
    @XmlAttribute(name = "Ccy", required = true)
    protected String transaction_currency;
    
	public BigDecimal getNtry_transaction_amount() {
		return ntry_transaction_amount;
	}
	public void setNtry_transaction_amount(BigDecimal ntry_transaction_amount) {
		this.ntry_transaction_amount = ntry_transaction_amount;
	}
	public String getTransaction_currency() {
		return transaction_currency;
	}
	public void setTransaction_currency(String transaction_currency) {
		this.transaction_currency = transaction_currency;
	}

}
