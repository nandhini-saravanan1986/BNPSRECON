package com.bornfire.xbrl.entities;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bornfire.xbrl.entities.BNPSRECON.BRECON_DESTINATION_ENTITY;

@Repository
@Transactional
public interface Brecon_Aani_payment_dup_rep extends JpaRepository<Brecon_aani_payment_duplicate_entity, String> {
	
	@Query(value = "select * from BRECON_AANI_PAYMENT_DUPLICATE_RECORDS_UPLOAD where NTRY_VALUE_DATE = ?1", nativeQuery = true)
	List<Brecon_aani_payment_duplicate_entity> getDestinationdatavalues(Date yesterdayDate);

}
