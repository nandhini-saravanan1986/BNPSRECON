package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Ecdd_customer_transaction_repo extends JpaRepository<Ecdd_customer_transaction, BigDecimal> {
	
	
	@Query(value = "select * from ECDD_CUSTOMER_TRANSACTIONS_PAST_YEAR where customer_id=?1", nativeQuery = true)
	List<Ecdd_customer_transaction> gettrandetails(String cid);

}
