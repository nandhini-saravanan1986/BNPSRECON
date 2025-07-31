package FYItransactions;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transforms", propOrder = {
    "transform"
})
public class transforms_references {
	@XmlElement(name = "Transform", required = true)
    protected TransformInformation  transform;

	public TransformInformation getTransform() {
		return transform;
	}

	public void setTransform(TransformInformation transform) {
		this.transform = transform;
	}

	
}
