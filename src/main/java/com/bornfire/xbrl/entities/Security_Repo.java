package com.bornfire.xbrl.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Security_Repo extends JpaRepository<Security_Entity, String> {
	@Query(value = "select * from SECURITY_DATA ", nativeQuery = true)
	List<Security_Entity> getList();

	@Query(value = "select * from SECURITY_DATA where cin=? ", nativeQuery = true)
	Security_Entity getview(String cin);

	@Query(value = "select * from SECURITY_DATA where srl_no=? ", nativeQuery = true)
	Security_Entity getupdate(String cin);

	@Query(value = "select * from SECURITY_DATA where fac_id=?1 ", nativeQuery = true)
	Optional<Security_Entity> getsecurity_rec_id(String security_rec_id);

	@Query(value = "select * from SECURITY_DATA where cin=?1 ", nativeQuery = true)
	List<Security_Entity> verify(String cin);

	@Query(value = "select cin,count(cin) from SECURITY_DATA Group By cin", nativeQuery = true)
	List<Object[]> getcount();

	Security_Entity findByCin(String cin);

	@Query(value = "select Distinct * from SECURITY_DATA where cin=?1 ", nativeQuery = true)
	List<Security_Entity> getbyview(String cin);

	@Query(value = "select * from SECURITY_DATA where cin is not null and auth_flg ='Y' ", nativeQuery = true)
	List<Security_Entity> getFinalRBR();

	@Query(value = "select * from SECURITY_DATA where cin is not null and auth_flg ='Y' and branch_code=?1", nativeQuery = true)
	List<Security_Entity> getFinalbranchRBR(String Branchcode);

	@Query(value = "select * from SECURITY_DATA where cust_id=?1 ", nativeQuery = true)
	List<Security_Entity> getbycustid(String cust_id);

	//// Get Facility Verified accounts
	@Query(value = "select * from SECURITY_DATA where NVL(auth_flg,'N') ='Y' ", nativeQuery = true)
	List<Security_Entity> getsecurityveri();

	@Query(value = "select * from SECURITY_DATA where NVL(auth_flg,'N') <>'Y' ", nativeQuery = true)
	List<Security_Entity> getsecurityunveri();

	//// Get Facility Verified accounts
	@Query(value = "select * from SECURITY_DATA where NVL(auth_flg,'N') ='Y' and branch_code=?1", nativeQuery = true)
	List<Security_Entity> getsecuritybranch_codeveri(String branch_code);

	@Query(value = "select * from SECURITY_DATA where NVL(auth_flg,'N') <>'Y' and branch_code=?1", nativeQuery = true)
	List<Security_Entity> getsecuritybranch_codeunveri(String branch_code);

	@Query(value = "select * from SECURITY_DATA where srl_no=?1 ", nativeQuery = true)
	Security_Entity Getsecuritysrlno(String Srl_no);

	@Query(value = "SELECT RBR_SECURITY_SRL_NO.NEXTVAL FROM dual", nativeQuery = true)
	Long getAuditRefUUID();

	@Query(value = "SELECT * FROM SECURITY_DATA WHERE cin IS NOT NULL AND operation = 'DEL' AND auth_flg = 'Y'", nativeQuery = true)
	List<Security_Entity> getlistofDEL();

	@Query(value = "SELECT * FROM SECURITY_DATA WHERE cin IS NOT NULL  AND operation = 'DEL' AND auth_flg = 'Y'   AND BRANCH_CODE = ?1", nativeQuery = true)
	List<Security_Entity> getlistofDELbranch(String Branchcode);

}
