package FYItransactions;
import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import oracle.sql.DATE;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ntry", propOrder = {
    "ntryEntryReference",
    "ntryAmountCurrency",
    "ntryCreditDebitIndicator",
    "sts",
    "bookgDt",
    "valDt",
    "ntry_account_servicer_reference",
    "bkTxCd",
    "amtDtls",
    "ntryDtls"
})
public class Entry {
	@XmlElement(name = "NtryRef", required = true)
    protected String ntryEntryReference;
	
	@XmlElement(name = "Amt", required = true)
    protected BigDecimal ntryAmountCurrency;
	
	@XmlElement(name = "CdtDbtInd", required = true)
    protected String ntryCreditDebitIndicator;
	
	@XmlElement(name = "Sts", required = true)
	protected Entry_Status sts;

	@XmlElement(name = "BookgDt", required = true)
	protected BookingDate bookgDt;
	
	@XmlElement(name = "ValDt", required = true)
	protected ValueDate valDt;
	
	@XmlElement(name = "AcctSvcrRef", required = true)
    protected String ntry_account_servicer_reference;
	
	@XmlElement(name = "BkTxCd", required = true)
	  protected BankTransactionCode bkTxCd;

	@XmlElement(name = "AmtDtls", required = true)
	  protected AmountDetails amtDtls;
	
	@XmlElement(name = "NtryDtls", required = true)
	  protected EntryDetails ntryDtls;

	public String getNtryEntryReference() {
		return ntryEntryReference;
	}

	public void setNtryEntryReference(String ntryEntryReference) {
		this.ntryEntryReference = ntryEntryReference;
	}

	public BigDecimal getNtryAmountCurrency() {
		return ntryAmountCurrency;
	}

	public void setNtryAmountCurrency(BigDecimal ntryAmountCurrency) {
		this.ntryAmountCurrency = ntryAmountCurrency;
	}

	public String getNtryCreditDebitIndicator() {
		return ntryCreditDebitIndicator;
	}

	public void setNtryCreditDebitIndicator(String ntryCreditDebitIndicator) {
		this.ntryCreditDebitIndicator = ntryCreditDebitIndicator;
	}

	public Entry_Status getSts() {
		return sts;
	}

	public void setSts(Entry_Status sts) {
		this.sts = sts;
	}

	public BookingDate getBookgDt() {
		return bookgDt;
	}

	public void setBookgDt(BookingDate bookgDt) {
		this.bookgDt = bookgDt;
	}

	public ValueDate getValDt() {
		return valDt;
	}

	public void setValDt(ValueDate valDt) {
		this.valDt = valDt;
	}

	public String getNtry_account_servicer_reference() {
		return ntry_account_servicer_reference;
	}

	public void setNtry_account_servicer_reference(String ntry_account_servicer_reference) {
		this.ntry_account_servicer_reference = ntry_account_servicer_reference;
	}

	public BankTransactionCode getBkTxCd() {
		return bkTxCd;
	}

	public void setBkTxCd(BankTransactionCode bkTxCd) {
		this.bkTxCd = bkTxCd;
	}

	public AmountDetails getAmtDtls() {
		return amtDtls;
	}

	public void setAmtDtls(AmountDetails amtDtls) {
		this.amtDtls = amtDtls;
	}

	public EntryDetails getNtryDtls() {
		return ntryDtls;
	}

	public void setNtryDtls(EntryDetails ntryDtls) {
		this.ntryDtls = ntryDtls;
	}

	public Entry(String ntryEntryReference, BigDecimal ntryAmountCurrency, String ntryCreditDebitIndicator) {
		super();
		this.ntryEntryReference = ntryEntryReference;
		this.ntryAmountCurrency = ntryAmountCurrency;
		this.ntryCreditDebitIndicator = ntryCreditDebitIndicator;
		
	}

	public Entry(String ntryEntryReference, BigDecimal ntryAmountCurrency, String ntryCreditDebitIndicator,
			Entry_Status sts, BookingDate bookgDt, ValueDate valDt, String ntry_account_servicer_reference,
			BankTransactionCode bkTxCd, AmountDetails amtDtls, EntryDetails ntryDtls) {
		super();
		this.ntryEntryReference = ntryEntryReference;
		this.ntryAmountCurrency = ntryAmountCurrency;
		this.ntryCreditDebitIndicator = ntryCreditDebitIndicator;
		this.sts = sts;
		this.bookgDt = bookgDt;
		this.valDt = valDt;
		this.ntry_account_servicer_reference = ntry_account_servicer_reference;
		this.bkTxCd = bkTxCd;
		this.amtDtls = amtDtls;
		this.ntryDtls = ntryDtls;
	}

	public Entry() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
