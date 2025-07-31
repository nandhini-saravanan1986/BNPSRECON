package FYItransactions;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.InputStream;
import javax.xml.namespace.QName;

public class XMLProcessor {
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void processXML(InputStream stream) throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(FYItransactions.Document.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		XMLInputFactory factory = XMLInputFactory.newInstance();
		factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, false);
		XMLEventReader xmlEventReader = factory.createXMLEventReader(stream);

		String canonicalizationMethod = null;
		String signatureMethod = null;

		while (xmlEventReader.hasNext()) {
			javax.xml.stream.events.XMLEvent event = xmlEventReader.nextEvent();
			if (event.isStartElement()) {
				javax.xml.stream.events.StartElement startElement = event.asStartElement();
				String localName = startElement.getName().getLocalPart();

				if ("CanonicalizationMethod".equals(localName)) {
					canonicalizationMethod = startElement.getAttributeByName(new QName("Algorithm")).getValue();
				} else if ("SignatureMethod".equals(localName)) {
					signatureMethod = startElement.getAttributeByName(new QName("Algorithm")).getValue();
				} else if ("Document".equals(localName)) {
					// Break the loop as we are about to unmarshal the Document
					break;
				}
			}
		}

		// Save to the database
		AlgorithmEntity algorithmEntity = new AlgorithmEntity();
		algorithmEntity.setCanonicalizationmethod_algorithm(canonicalizationMethod);
		algorithmEntity.setSignaturemethod_algorithm(signatureMethod);
		entityManager.persist(algorithmEntity);

		// Unmarshal the Document
		JAXBElement<FYItransactions.Document> jaxbElement = unmarshaller.unmarshal(xmlEventReader,
				FYItransactions.Document.class);
		FYItransactions.Document document = jaxbElement.getValue();

		// Handle the document as needed
	}
}
