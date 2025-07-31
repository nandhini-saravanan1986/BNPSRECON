package FYItransactions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SignedInfo", propOrder = {
    "canonicalizationMethod",
    "signatureMethod",
    "reference"
})
public class signatureinformation {
	@XmlElement(name = "CanonicalizationMethod", required = true)
    protected CanonicalizationMethods canonicalizationMethod;

    @XmlElement(name = "SignatureMethod", required = true)
    protected SignatureInformations signatureMethod;

    @XmlElement(name = "Reference", required = true)
    protected SignRef reference;

	public CanonicalizationMethods getCanonicalizationMethod() {
		return canonicalizationMethod;
	}

	public void setCanonicalizationMethod(CanonicalizationMethods canonicalizationMethod) {
		this.canonicalizationMethod = canonicalizationMethod;
	}

	public SignatureInformations getSignatureMethod() {
		return signatureMethod;
	}

	public void setSignatureMethod(SignatureInformations signatureMethod) {
		this.signatureMethod = signatureMethod;
	}

	public SignRef getReference() {
		return reference;
	}

	public void setReference(SignRef reference) {
		this.reference = reference;
	}
}
