package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Btch", propOrder = {
    "ntry_btch_msg_id",
    "ntry_btch_numoftxs",
    "ntry_btch_ttlamt",
    "ntry_btch_currency",
    "ntry_brch_cdtdbtint"
})
public class Batchdetails {
	@XmlElement(name = "MsgId", required = true)
    protected String ntry_btch_msg_id;
	
	@XmlElement(name = "NbOfTxs", required = true)
    protected BigDecimal ntry_btch_numoftxs;
	
	@XmlElement(name = "TtlAmt", required = true)
    protected BigDecimal ntry_btch_ttlamt;
	
	@XmlElement(name = "Ccy", required = true)
    protected String ntry_btch_currency;
	
	@XmlElement(name = "CdtDbtInd", required = true)
    protected String ntry_brch_cdtdbtint;

	public String getNtry_btch_msg_id() {
		return ntry_btch_msg_id;
	}

	public void setNtry_btch_msg_id(String ntry_btch_msg_id) {
		this.ntry_btch_msg_id = ntry_btch_msg_id;
	}

	public BigDecimal getNtry_btch_numoftxs() {
		return ntry_btch_numoftxs;
	}

	public void setNtry_btch_numoftxs(BigDecimal ntry_btch_numoftxs) {
		this.ntry_btch_numoftxs = ntry_btch_numoftxs;
	}

	public BigDecimal getNtry_btch_ttlamt() {
		return ntry_btch_ttlamt;
	}

	public void setNtry_btch_ttlamt(BigDecimal ntry_btch_ttlamt) {
		this.ntry_btch_ttlamt = ntry_btch_ttlamt;
	}

	public String getNtry_btch_currency() {
		return ntry_btch_currency;
	}

	public void setNtry_btch_currency(String ntry_btch_currency) {
		this.ntry_btch_currency = ntry_btch_currency;
	}

	public String getNtry_brch_cdtdbtint() {
		return ntry_brch_cdtdbtint;
	}

	public void setNtry_brch_cdtdbtint(String ntry_brch_cdtdbtint) {
		this.ntry_brch_cdtdbtint = ntry_brch_cdtdbtint;
	}
}
