package FYItransactions;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "X509Data", propOrder = {
    "signature_keyinfo_x509_subject_name",
    "signature_keyinfo_x509_certificate"
})
public class x509Datavalues {
	@XmlElement(name = "X509SubjectName", required = true)
    protected String signature_keyinfo_x509_subject_name;
	
	@XmlElement(name = "X509Certificate", required = true)
    protected String signature_keyinfo_x509_certificate;

	public String getSignature_keyinfo_x509_subject_name() {
		return signature_keyinfo_x509_subject_name;
	}

	public void setSignature_keyinfo_x509_subject_name(String signature_keyinfo_x509_subject_name) {
		this.signature_keyinfo_x509_subject_name = signature_keyinfo_x509_subject_name;
	}

	public String getSignature_keyinfo_x509_certificate() {
		return signature_keyinfo_x509_certificate;
	}

	public void setSignature_keyinfo_x509_certificate(String signature_keyinfo_x509_certificate) {
		this.signature_keyinfo_x509_certificate = signature_keyinfo_x509_certificate;
	}
}
