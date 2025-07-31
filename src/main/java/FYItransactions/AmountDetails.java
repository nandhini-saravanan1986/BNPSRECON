package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmtDtls", propOrder = {
    "instdAmt",
    "txAmt"
})
public class AmountDetails {
	@XmlElement(name = "InstdAmt", required = true)
	protected InstructedAmount instdAmt;

	@XmlElement(name = "TxAmt", required = true)
	protected TransactionAmount txAmt;
	
	public InstructedAmount getInstdAmt() {
		return instdAmt;
	}

	public void setInstdAmt(InstructedAmount instdAmt) {
		this.instdAmt = instdAmt;
	}

	public TransactionAmount getTxAmt() {
		return txAmt;
	}

	public void setTxAmt(TransactionAmount txAmt) {
		this.txAmt = txAmt;
	}
}
