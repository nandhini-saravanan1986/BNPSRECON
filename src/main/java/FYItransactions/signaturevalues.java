package FYItransactions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Signature", propOrder = {
    "signedInfo",
    "signature_signedinfo_signature_value",
    "keyInfo"
})
public class signaturevalues {
	    @XmlElement(name = "SignedInfo")
	    protected signatureinformation signedInfo;
	    
	    @XmlElement(name = "SignatureValue", required = true)
	    protected String signature_signedinfo_signature_value;
	    
	    @XmlElement(name = "KeyInfo", required = true)
	    protected keyinformations keyInfo;

		public signatureinformation getSignedInfo() {
			return signedInfo;
		}

		public void setSignedInfo(signatureinformation signedInfo) {
			this.signedInfo = signedInfo;
		}

		public String getSignature_signedinfo_signature_value() {
			return signature_signedinfo_signature_value;
		}

		public void setSignature_signedinfo_signature_value(String signature_signedinfo_signature_value) {
			this.signature_signedinfo_signature_value = signature_signedinfo_signature_value;
		}

		public keyinformations getKeyInfo() {
			return keyInfo;
		}

		public void setKeyInfo(keyinformations keyInfo) {
			this.keyInfo = keyInfo;
		}
}
