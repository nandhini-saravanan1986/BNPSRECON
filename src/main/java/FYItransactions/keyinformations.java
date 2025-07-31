package FYItransactions;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyInfo", propOrder = {
    "x509Data"
})
public class keyinformations {
	 @XmlElement(name = "X509Data", required = true)
	 protected x509Datavalues x509Data;

	public x509Datavalues getX509Data() {
		return x509Data;
	}

	public void setX509Data(x509Datavalues x509Data) {
		this.x509Data = x509Data;
	}
}
