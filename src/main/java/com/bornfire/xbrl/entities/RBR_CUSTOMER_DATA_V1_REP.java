package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RBR_CUSTOMER_DATA_V1_REP extends JpaRepository<RBR_CUSTOMER_DATA_V1, String> {
	
	@Query(value = "select * from CUSTOMER_DATA_RBR_V1 where branch_code=?1 ", nativeQuery = true)
	List<RBR_CUSTOMER_DATA_V1> getCUSTList(String Branchcode);
	
	@Query(value = "SELECT * FROM customer_data_rbr_v1  WHERE CIF_NO IN (SELECT CIF_NO "
			+ "FROM customer_data1 WHERE CIF_NO IS NOT NULL\r\n" + 
			"and auth_flg = 'N')", nativeQuery = true)
	List<RBR_CUSTOMER_DATA_V1> Getverified();
	
	@Query(value = "SELECT * FROM customer_data_rbr_v1  WHERE CIF_NO IN (SELECT CIF_NO "
			+ "FROM customer_data1 WHERE CIF_NO IS NOT NULL\r\n" + 
			"and auth_flg = 'N' and branch_code=?1)", nativeQuery = true)
	List<RBR_CUSTOMER_DATA_V1> Getverifiedbranch(String Branchcode);

}
