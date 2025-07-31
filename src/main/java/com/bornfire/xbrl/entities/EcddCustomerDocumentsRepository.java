package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcddCustomerDocumentsRepository extends JpaRepository<EcddCustomerDocumentsEntity, Long> {
	List<EcddCustomerDocumentsEntity> findByCustomerIdOrderByUploadedDateDesc(String customerId);
}