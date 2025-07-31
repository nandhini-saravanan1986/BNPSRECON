package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bal", propOrder = {
    "tp",
    "stmtBalAmount",
    "stmtBalCreditDebitIndicator",
    "dt"
})
public class Balance {
	@XmlElement(name = "Tp", required = true)
	protected TradingPartner tp;

	@XmlElement(name = "Amt", required = true)
    protected BigDecimal stmtBalAmount;
	
	@XmlElement(name = "CdtDbtInd", required = true)
    protected String stmtBalCreditDebitIndicator;

	@XmlElement(name = "Dt", required = true)
	protected bal_Date dt;

	public TradingPartner getTp() {
		return tp;
	}

	public void setTp(TradingPartner tp) {
		this.tp = tp;
	}

	public BigDecimal getStmtBalAmount() {
		return stmtBalAmount;
	}

	public void setStmtBalAmount(BigDecimal stmtBalAmount) {
		this.stmtBalAmount = stmtBalAmount;
	}

	public String getStmtBalCreditDebitIndicator() {
		return stmtBalCreditDebitIndicator;
	}

	public void setStmtBalCreditDebitIndicator(String stmtBalCreditDebitIndicator) {
		this.stmtBalCreditDebitIndicator = stmtBalCreditDebitIndicator;
	}

	public bal_Date getDt() {
		return dt;
	}

	public void setDt(bal_Date dt) {
		this.dt = dt;
	}

}
