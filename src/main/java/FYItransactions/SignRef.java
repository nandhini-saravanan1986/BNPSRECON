package FYItransactions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Reference", propOrder = {
    "transforms",
    "digestMethod",
    "signature_signedinfo_digest_value"
})
public class SignRef {
	@XmlElement(name = "Transforms", required = true)
    protected transforms_references transforms;
	
	@XmlElement(name = "DigestMethod", required = true)
    protected DigestInformation  digestMethod;
	
	@XmlElement(name = "DigestValue", required = true)
    protected String signature_signedinfo_digest_value;

	public transforms_references getTransforms() {
		return transforms;
	}

	public void setTransforms(transforms_references transforms) {
		this.transforms = transforms;
	}

	public DigestInformation getDigestMethod() {
		return digestMethod;
	}

	public void setDigestMethod(DigestInformation digestMethod) {
		this.digestMethod = digestMethod;
	}

	public String getSignature_signedinfo_digest_value() {
		return signature_signedinfo_digest_value;
	}

	public void setSignature_signedinfo_digest_value(String signature_signedinfo_digest_value) {
		this.signature_signedinfo_digest_value = signature_signedinfo_digest_value;
	}
}
