package com.bornfire.xbrl.services;

import com.bornfire.xbrl.entities.EcddCustomerDocumentsEntity;
import com.bornfire.xbrl.entities.EcddCustomerDocumentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class EcddUploadDocumentService {

	@Autowired
	private EcddCustomerDocumentsRepository documentRepository;

	public void saveDocuments(MultipartFile[] files, String srlNo, String customerId, String customerType,
			String uploadedBy) throws IOException {

		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				continue; // Skip empty file slots if any
			}

			String fileName = StringUtils.cleanPath(file.getOriginalFilename());

			// Security check for malicious file paths
			if (fileName.contains("..")) {
				throw new IOException("Invalid file path sequence in filename: " + fileName);
			}

			EcddCustomerDocumentsEntity doc = new EcddCustomerDocumentsEntity();
			doc.setSrlNo(srlNo);
			doc.setCustomerId(customerId);
			doc.setCustomerType(customerType);
			doc.setDocumentType("General Upload"); // Default value as the user no longer provides it
			doc.setDocumentName(fileName);
			doc.setMimeType(file.getContentType());
			doc.setDocumentContent(file.getBytes());
			doc.setUploadedDate(new Date()); // Set the current date as the upload date
			doc.setUploadedBy(uploadedBy);

			documentRepository.save(doc);
		}
	}

	public List<EcddCustomerDocumentsEntity> getDocumentList(String customerId) {
		return documentRepository.findByCustomerIdOrderByUploadedDateDesc(customerId);
	}

	public EcddCustomerDocumentsEntity getDocumentForDownload(Long docId) {
		return documentRepository.findById(docId)
				.orElseThrow(() -> new RuntimeException("Document not found with id: " + docId));
	}
}