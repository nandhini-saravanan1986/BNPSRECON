package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RBRShareHolder_Repo extends JpaRepository<RBRShareHolder_Entity, String> {
	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA ", nativeQuery = true)
	List<RBRShareHolder_Entity> getList();

	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where cin=? ", nativeQuery = true)
	RBRShareHolder_Entity getview(String cin);

	@Query(value = "select cin,count(cin) from PARTNER_SHAREHOLDER_DATA Group By cin", nativeQuery = true)
	List<Object[]> getcount();

	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where srl_no=? ", nativeQuery = true)
	RBRShareHolder_Entity getupdate(String cin);

	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where cin=? ", nativeQuery = true)
	List<RBRShareHolder_Entity> Verify(String cin);

	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where cin=?1 ", nativeQuery = true)
	List<RBRShareHolder_Entity> getbyview(String cin);

	@Query(value = "SELECT RBR_PARTNER_SRL_NO.NEXTVAL FROM dual", nativeQuery = true)
	Long getAuditRefUUID();

	RBRShareHolder_Entity findByCin(String cin);

	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where cust_id=?1 ", nativeQuery = true)
	List<RBRShareHolder_Entity> getbycustid(String cust_id);

	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where cin is not null and auth_flg ='Y' and cin in (select cin"
			+ " from customer_data1 where cin is not null and auth_flg ='Y' and branch_code=?1)", nativeQuery = true)
	List<RBRShareHolder_Entity> getFinalbranchRBR(String branchcode);

	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where cin is not null and auth_flg ='Y'", nativeQuery = true)
	List<RBRShareHolder_Entity> getFinalRBR();

	///// Get Verified PARTNER_SHAREHOLDER_DATA data
	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where NVL(auth_flg,'N') ='Y' ", nativeQuery = true)
	List<RBRShareHolder_Entity> getverifiedpartner();

	///// Get unVerified PARTNER_SHAREHOLDER_DATA data
	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where NVL(auth_flg,'N') <>'Y' ", nativeQuery = true)
	List<RBRShareHolder_Entity> getunverifiedpartner();

	///// Get Verified PARTNER_SHAREHOLDER_DATA data
	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where NVL(auth_flg,'N') ='Y' and branch_code=?1", nativeQuery = true)
	List<RBRShareHolder_Entity> getverifiedbranchpartner(String branch_code);

	///// Get unVerified PARTNER_SHAREHOLDER_DATA data
	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where NVL(auth_flg,'N') <>'Y' and branch_code=?1", nativeQuery = true)
	List<RBRShareHolder_Entity> getunverifiedbranchpartner(String branch_code);

	@Query(value = "select * from PARTNER_SHAREHOLDER_DATA where srl_no=?1 ", nativeQuery = true)
	RBRShareHolder_Entity getpartnersrlno(String cin);

	@Query(value = "SELECT * FROM PARTNER_SHAREHOLDER_DATA WHERE cin IS NOT NULL AND operation = 'DEL' AND auth_flg = 'Y'", nativeQuery = true)
	List<RBRShareHolder_Entity> getlistofDEL();

	@Query(value = "SELECT * FROM PARTNER_SHAREHOLDER_DATA WHERE cin IS NOT NULL  AND operation = 'DEL' AND auth_flg = 'Y'   AND BRANCH_CODE = ?1", nativeQuery = true)
	List<RBRShareHolder_Entity> getlistofDELbranch(String Branchcode);

}
