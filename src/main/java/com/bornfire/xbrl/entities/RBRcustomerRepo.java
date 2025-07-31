package com.bornfire.xbrl.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RBRcustomerRepo extends JpaRepository<RBRcustomer_entity, String> {

	@Query(value = "SELECT \r\n" + "    NVL(t1.CIN,0) AS CIN,\r\n" + "    NVL(t1.COUNT, 0) AS customer_data1,\r\n"
			+ "    t1.operation,t1.bank_code,t1.branch,t1.csno,t1.auth_flg,t1.cif_no,\r\n"
			+ "    NVL(t2.COUNT, 0) AS partner_shareholder_data,\r\n" + "    NVL(t3.COUNT, 0) AS facility_data,\r\n"
			+ "    NVL(t4.COUNT, 0) AS security_data,\r\n" + "    NVL(t5.COUNT, 0) AS overall_data,\r\n"
			+ "    NVL(t6.COUNT, 0) AS provision_data,\r\n" + "    NVL(t7.COUNT, 0) AS legal_cases,\r\n"
			+ "    NVL(t8.COUNT, 0) AS investments\r\n" + "FROM \r\n"
			+ "    (SELECT CIN,customer_data1.operation AS operation,customer_data1.bank_code AS bank_code,\r\n"
			+ "    customer_data1.branch AS branch,customer_data1.csno AS csno,customer_data1.auth_flg AS auth_flg,\r\n"
			+ "    customer_data1.cif_no AS cif_no,COUNT(CIN) AS COUNT FROM customer_data1 where auth_flg is not null  GROUP BY CIN\r\n"
			+ "    ,customer_data1.operation,customer_data1.bank_code,\r\n"
			+ "    customer_data1.branch,customer_data1.csno,customer_data1.auth_flg,customer_data1.cif_no) t1\r\n"
			+ "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM partner_shareholder_data GROUP BY CIN) t2\r\n"
			+ "ON t1.CIN = t2.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM facility_data GROUP BY CIN) t3\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN) = t3.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM security_data GROUP BY CIN) t4\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN, t3.CIN) = t4.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM overall_data GROUP BY CIN) t5\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN, t3.CIN,t4.CIN) = t5.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM provision_data GROUP BY CIN) t6\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN, t3.CIN,t4.CIN,t5.CIN) = t6.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM legal_cases GROUP BY CIN) t7\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN, t3.CIN,t4.CIN,t5.CIN,t6.CIN) = t7.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM investments GROUP BY CIN) t8\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN, t3.CIN,t4.CIN,t5.CIN,t6.CIN,t7.CIN) = t8.CIN\r\n" + "", nativeQuery = true)
	List<Object[]> getList();

	@Query(value = "SELECT \r\n" + "    NVL(t1.CIN,0) AS CIN,\r\n" + "    NVL(t1.COUNT, 0) AS customer_data1,\r\n"
			+ "    t1.operation,t1.bank_code,t1.branch,t1.csno,t1.auth_flg,t1.cif_no,\r\n"
			+ "    NVL(t2.COUNT, 0) AS partner_shareholder_data,\r\n" + "    NVL(t3.COUNT, 0) AS facility_data,\r\n"
			+ "    NVL(t4.COUNT, 0) AS security_data,\r\n" + "    NVL(t5.COUNT, 0) AS overall_data,\r\n"
			+ "    NVL(t6.COUNT, 0) AS provision_data,\r\n" + "    NVL(t7.COUNT, 0) AS legal_cases,\r\n"
			+ "    NVL(t8.COUNT, 0) AS investments\r\n" + "FROM \r\n"
			+ "    (SELECT CIN,customer_data1.operation AS operation,customer_data1.bank_code AS bank_code,\r\n"
			+ "    customer_data1.branch AS branch,customer_data1.csno AS csno,customer_data1.auth_flg AS auth_flg,\r\n"
			+ "    customer_data1.cif_no AS cif_no,COUNT(CIN) AS COUNT FROM customer_data1 where branch_code=?1  GROUP BY CIN\r\n"
			+ "    ,customer_data1.operation,customer_data1.bank_code,\r\n"
			+ "    customer_data1.branch,customer_data1.csno,customer_data1.auth_flg,customer_data1.cif_no) t1\r\n"
			+ "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM partner_shareholder_data GROUP BY CIN) t2\r\n"
			+ "ON t1.CIN = t2.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM facility_data GROUP BY CIN) t3\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN) = t3.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM security_data GROUP BY CIN) t4\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN, t3.CIN) = t4.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM overall_data GROUP BY CIN) t5\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN, t3.CIN,t4.CIN) = t5.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM provision_data GROUP BY CIN) t6\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN, t3.CIN,t4.CIN,t5.CIN) = t6.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM legal_cases GROUP BY CIN) t7\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN, t3.CIN,t4.CIN,t5.CIN,t6.CIN) = t7.CIN\r\n" + "left join \r\n"
			+ "    (SELECT CIN, COUNT(CIN) AS COUNT FROM investments GROUP BY CIN) t8\r\n"
			+ "ON COALESCE(t1.CIN, t2.CIN, t3.CIN,t4.CIN,t5.CIN,t6.CIN,t7.CIN) = t8.CIN\r\n" + "", nativeQuery = true)
	List<Object[]> getCUSTList(String Branchcode);

	@Query(value = "select * from customer_data1 where cif_no=? ", nativeQuery = true)
	RBRcustomer_entity getview(String cif_no);

	@Query(value = "select * from customer_data1 where cin=? ", nativeQuery = true)
	RBRcustomer_entity getcin(String cin);

	@Query(value = "select * from customer_data1 where cin=? ", nativeQuery = true)
	Optional<RBRcustomer_entity> getcinavail(String cin);

	@Query(value = "select * from customer_data1 ", nativeQuery = true)
	List<RBRcustomer_entity> getadd();

	@Query(value = "select * from customer_data1 where cif_no=?1 ", nativeQuery = true)
	List<RBRcustomer_entity> getbycif_no(String cin);

	@Query(value = "Update customer_data1 set cin=?1, csno=?2 where cif_no=?3", nativeQuery = true)
	String updatecif_no(String cin, String csno, String Cif_no);

	RBRcustomer_entity findByCin(String cin);

	@Query(value = "select * from customer_data1 where cin is not null and auth_flg ='Y' ", nativeQuery = true)
	List<RBRcustomer_entity> getFinalRBR();

	@Query(value = "select * from customer_data1 where cin is not null and auth_flg ='Y' and branch_code=?1", nativeQuery = true)
	List<RBRcustomer_entity> getFinalbranchRBR(String branchcode);

	// Get Customer data for list
	@Query(value = "select * from customer_data1 where NVL(auth_flg,'N') ='Y'", nativeQuery = true)
	List<RBRcustomer_entity> getcustomerdata();

	@Query(value = "select * from customer_data1 where NVL(auth_flg,'N') <>'Y'", nativeQuery = true)
	List<RBRcustomer_entity> getcustomerdataunveri();

	@Query(value = "select * from customer_data1 where NVL(auth_flg,'N') ='Y' and branch_code=?1", nativeQuery = true)
	List<RBRcustomer_entity> getcustomerbranchdata(String Branchcode);

	@Query(value = "SELECT RBR_CUSTOMER_SRL_NO.NEXTVAL FROM dual", nativeQuery = true)
	Long GetCustsrl_no();

	@Query(value = "select * from customer_data1 where NVL(auth_flg,'N') <>'Y' and branch_code=?1", nativeQuery = true)
	List<RBRcustomer_entity> getcustomerbranchdataunveri(String Branchcode);

	//// Get Customer Data for edit
	@Query(value = "select * from customer_data1 where srl_no=?1", nativeQuery = true)
	RBRcustomer_entity getcustomeredit(String Srlno);

	@Query(value = "SELECT * FROM customer_data1 WHERE cin IS NOT NULL  AND auth_flg = 'Y' AND operation = 'DEL'", nativeQuery = true)
	List<RBRcustomer_entity> getlistofDEL();

	@Query(value = "SELECT * FROM customer_data1 WHERE cin IS NOT NULL AND auth_flg = 'Y' AND operation = 'DEL'  AND BRANCH_CODE = ?1", nativeQuery = true)
	List<RBRcustomer_entity> getlistofDELbranch(String Branchcode);

}
