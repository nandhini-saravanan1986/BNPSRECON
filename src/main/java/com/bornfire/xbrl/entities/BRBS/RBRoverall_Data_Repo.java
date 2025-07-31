package com.bornfire.xbrl.entities.BRBS;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RBRoverall_Data_Repo extends JpaRepository<RBROverall_Data_Entity, String> {
	@Query(value = "select * from overall_data ", nativeQuery = true)
	List<RBROverall_Data_Entity> getList();

	@Query(value = "select * from overall_data where cin=? ", nativeQuery = true)
	RBROverall_Data_Entity getview(String cin);

	@Query(value = "select * from overall_data where cin=? ", nativeQuery = true)
	Optional<RBROverall_Data_Entity> getbycin(String cin);

	@Query(value = "select * from overall_data where srl_no=? ", nativeQuery = true)
	RBROverall_Data_Entity getupdate(String cin);

	@Query(value = "select * from overall_data where cin=?1 ", nativeQuery = true)
	List<RBROverall_Data_Entity> verify(String cin);

	@Query(value = "select * from overall_data where cin=?1 ", nativeQuery = true)
	List<RBROverall_Data_Entity> getbyview(String cin);

	RBROverall_Data_Entity findByCin(String cin);

	@Query(value = "select * from overall_data where cust_id=?1 ", nativeQuery = true)
	List<RBROverall_Data_Entity> getbycustid(String cust_id);

	@Query(value = "select * from overall_data where cin is not null and auth_flg ='Y' ", nativeQuery = true)
	List<RBROverall_Data_Entity> getFinalRBR();

	@Query(value = "select * from overall_data where cin is not null and auth_flg ='Y' and branch_code=?1", nativeQuery = true)
	List<RBROverall_Data_Entity> getFinalbranchRBR(String Branchcode);

	@Query(value = "select cin,count(cin) from overall_data Group By cin", nativeQuery = true)
	List<Object[]> getcount();

	//// VERIFIED ACCOUNTS
	@Query(value = "select * from overall_data where NVL(auth_flg,'N') = 'Y'", nativeQuery = true)
	List<RBROverall_Data_Entity> getoverallverifi();

	@Query(value = "select * from overall_data where NVL(auth_flg,'N') = 'Y' and branch_code=?1", nativeQuery = true)
	List<RBROverall_Data_Entity> getoverallbrachverifi(String branch_code);

	//// UNVERIFIED ACCOUNTS
	@Query(value = "select * from overall_data where NVL(auth_flg,'N') <> 'Y'", nativeQuery = true)
	List<RBROverall_Data_Entity> getoverallunverifi();

	@Query(value = "select * from overall_data where NVL(auth_flg,'N') <> 'Y' and branch_code=?1", nativeQuery = true)
	List<RBROverall_Data_Entity> getoverallbranchunverifi(String branch_code);

	///// Get data by srl no
	@Query(value = "select * from overall_data where srl_no=? ", nativeQuery = true)
	RBROverall_Data_Entity getsrl_no(String Srl_no);

	@Query(value = "SELECT RBR_OVERALL_SRL_NO.NEXTVAL FROM dual", nativeQuery = true)
	Long getAuditRefUUID();

	@Query(value = "SELECT * FROM overall_data WHERE cin IS NOT NULL AND operation = 'DEL' AND auth_flg = 'Y'", nativeQuery = true)
	List<RBROverall_Data_Entity> getlistofDEL();

	@Query(value = "SELECT * FROM overall_data WHERE cin IS NOT NULL  AND operation = 'DEL' AND auth_flg = 'Y'   AND BRANCH_CODE = ?1", nativeQuery = true)
	List<RBROverall_Data_Entity> getlistofDELbranch(String Branchcode);

}
