package com.bornfire.xbrl.entities;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Facility_Repo extends JpaRepository<Facitlity_Entity, String> {
	@Query(value = "select * from FACILITY_DATA ", nativeQuery = true)
	List<Facitlity_Entity> getList();

	@Query(value = "select * from FACILITY_DATA where cin=? ", nativeQuery = true)
	Facitlity_Entity getview(String cin);

	@Query(value = "select * from FACILITY_DATA where srl_no=? ", nativeQuery = true)
	Facitlity_Entity getupdate(String cin);

	@Query(value = "select * from FACILITY_DATA where cin=?1 ", nativeQuery = true)
	List<Facitlity_Entity> verify(String cin);

	@Query(value = "select * from FACILITY_DATA where fac_id=?1 ", nativeQuery = true)
	Optional<Facitlity_Entity> getbyfacilityid(String cin);

	Facitlity_Entity findByCin(String cin);

	@Query(value = "select * from FACILITY_DATA where cust_id=?1 ", nativeQuery = true)
	List<Facitlity_Entity> getbycustid(String cust_id);

	@Query(value = "select * from FACILITY_DATA where cin=?1 ", nativeQuery = true)
	List<Facitlity_Entity> getbyview(String cin);

	@Query(value = "select * from FACILITY_DATA where cin is not null and auth_flg ='Y' ", nativeQuery = true)
	List<Facitlity_Entity> getFinalRBR();

	@Query(value = "select * from FACILITY_DATA where cin is not null and auth_flg ='Y' and branch_code=?1", nativeQuery = true)
	List<Facitlity_Entity> getFinalbranchRBR(String Branchcode);

	@Query(value = "select cin,count(cin) from FACILITY_DATA Group By cin", nativeQuery = true)
	List<Object[]> getcount();

	@Query(value = "select * from FACILITY_DATA where NVL(auth_flg,'N') ='Y' ", nativeQuery = true)
	List<Facitlity_Entity> getfacveri();

	@Query(value = "select * from FACILITY_DATA where NVL(auth_flg,'N') <>'Y' ", nativeQuery = true)
	List<Facitlity_Entity> getfacunveri();

	@Query(value = "select * from FACILITY_DATA where NVL(auth_flg,'N') ='Y' and branch_code=?1", nativeQuery = true)
	List<Facitlity_Entity> getfacbranch_codeveri(String branch_code);

	@Query(value = "select * from FACILITY_DATA where NVL(auth_flg,'N') <>'Y' and branch_code=?1", nativeQuery = true)
	List<Facitlity_Entity> getfacbranch_codeunveri(String branch_code);

	@Query(value = "select * from FACILITY_DATA where srl_no=?1 ", nativeQuery = true)
	Facitlity_Entity getfacsrlno(String Srl_no);

	@Query(value = "SELECT RBR_FACILITY_SRL_NO.NEXTVAL FROM dual", nativeQuery = true)
	Long getAuditRefUUID();

	@Query(value = "SELECT * FROM FACILITY_DATA WHERE cin IS NOT NULL AND operation = 'DEL' AND auth_flg = 'Y'", nativeQuery = true)
	List<Facitlity_Entity> getlistofDEL();

	@Query(value = "SELECT * FROM FACILITY_DATA WHERE cin IS NOT NULL  AND operation = 'DEL' AND auth_flg = 'Y'   AND BRANCH_CODE = ?1", nativeQuery = true)
	List<Facitlity_Entity> getlistofDELbranch(String Branchcode);

}
