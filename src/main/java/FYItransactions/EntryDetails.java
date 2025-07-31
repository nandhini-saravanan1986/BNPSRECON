package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NtryDtls", propOrder = {
    "txDtls",
    "btch"
})
public class EntryDetails {
	@XmlElement(name = "TxDtls", required = true)
	protected TransactionDetails txDtls;

	@XmlElement(name = "Btch", required = true)
	protected Batchdetails btch;
	
	public TransactionDetails getTxDtls() {
		return txDtls;
	}

	public void setTxDtls(TransactionDetails txDtls) {
		this.txDtls = txDtls;
	}

	public Batchdetails getBtch() {
		return btch;
	}

	public void setBtch(Batchdetails btch) {
		this.btch = btch;
	}
}
