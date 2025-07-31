package FYItransactions;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DigestMethod")
@XmlAccessorType(XmlAccessType.FIELD)  // Use fields only
public class DigestInformation {
	@XmlAttribute(name = "Algorithm", required = true)
    private String algorithm;

    // Getter and setter
    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }
}
