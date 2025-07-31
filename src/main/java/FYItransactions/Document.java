package FYItransactions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.crypto.dsig.CanonicalizationMethod;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Document", propOrder = {
    "bkToCstmrStmt",
    "signature"
})
public class Document {
    @XmlElement(name = "BkToCstmrStmt", required = true)
    protected BankCustomerStatement bkToCstmrStmt;
    
    @XmlElement(name = "Signature", required = true)
    protected signaturevalues signature;

	public BankCustomerStatement getBkToCstmrStmt() {
		return bkToCstmrStmt;
	}

	public void setBkToCstmrStmt(BankCustomerStatement bkToCstmrStmt) {
		this.bkToCstmrStmt = bkToCstmrStmt;
	}

	public signaturevalues getSignature() {
		return signature;
	}

	public void setSignature(signaturevalues signature) {
		this.signature = signature;
	}

	public CanonicalizationMethod getCanonicalizationMethod() {
		// TODO Auto-generated method stub
		return null;
	}
}
