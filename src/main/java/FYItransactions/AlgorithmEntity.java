package FYItransactions;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FYITABLE")
public class AlgorithmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String canonicalizationmethod_algorithm;
    private String signaturemethod_algorithm;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCanonicalizationmethod_algorithm() {
		return canonicalizationmethod_algorithm;
	}
	public void setCanonicalizationmethod_algorithm(String canonicalizationmethod_algorithm) {
		this.canonicalizationmethod_algorithm = canonicalizationmethod_algorithm;
	}
	public String getSignaturemethod_algorithm() {
		return signaturemethod_algorithm;
	}
	public void setSignaturemethod_algorithm(String signaturemethod_algorithm) {
		this.signaturemethod_algorithm = signaturemethod_algorithm;
	}
}