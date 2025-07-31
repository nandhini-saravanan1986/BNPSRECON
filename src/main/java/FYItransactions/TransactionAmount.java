package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TxAmt", propOrder = {
    "currency_values"
})
public class TransactionAmount {
	@XmlElement(name = "Amt", required = true)
    protected Currency_values currency_values;

	public Currency_values getCurrency_values() {
		return currency_values;
	}

	public void setCurrency_values(Currency_values currency_values) {
		this.currency_values = currency_values;
	}
}
