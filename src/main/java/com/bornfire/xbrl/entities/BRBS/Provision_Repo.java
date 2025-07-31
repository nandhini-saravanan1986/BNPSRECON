package com.bornfire.xbrl.entities.BRBS;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface Provision_Repo extends JpaRepository<Provision_Entity, String> {
	@Query(value = "select * from PROVISION_DATA ", nativeQuery = true)
	List<Provision_Entity> getList();
	
	@Query(value = "select * from PROVISION_DATA where cin=? ", nativeQuery = true)
	Provision_Entity getview(String cin );
	
	@Query(value = "select * from PROVISION_DATA where srl_no=? ", nativeQuery = true)
	Provision_Entity getupdate(String cin );
	
	@Query(value = "select * from PROVISION_DATA where cin=? ", nativeQuery = true)
	List<Provision_Entity> verify(String cin );
	
	@Query(value = "select * from PROVISION_DATA where fac_id=?1 ", nativeQuery = true)
	Optional<Provision_Entity> getbyfacid(String cin );
	
	
	@Query(value = "select * from PROVISION_DATA where cin=?1 ", nativeQuery = true)
	List<Provision_Entity> getbyview(String cin );

	Provision_Entity findByCin(String cin);
	

	@Query(value = "select cin,count(cin) from PROVISION_DATA Group By cin", nativeQuery = true)
	List<Object[]> getcount();
	
	@Query(value = "select * from PROVISION_DATA where cin is not null and auth_flg ='Y' ", nativeQuery = true)
	List<Provision_Entity> getFinalRBR();
	
	@Query(value = "select * from PROVISION_DATA where cin is not null and auth_flg ='Y' and branch_code=?1", nativeQuery = true)
	List<Provision_Entity> getFinalbranchRBR(String Branchcode);
	
	@Query(value = "select * from PROVISION_DATA where cust_id=?1 ", nativeQuery = true)
	List<Provision_Entity> getbycustid(String cust_id );
	
	@Query(value = "select * from PROVISION_DATA where NVL(auth_flg,'N') ='Y'", nativeQuery = true)
	List<Provision_Entity> getproveri();
	
	@Query(value = "select * from PROVISION_DATA where NVL(auth_flg,'N') ='Y' and branch_code=?1", nativeQuery = true)
	List<Provision_Entity> getprobranch_codeveri(String branch_code);
	
	@Query(value = "select * from PROVISION_DATA where NVL(auth_flg,'N') <>'Y'", nativeQuery = true)
	List<Provision_Entity> getprovunveri();
	
	@Query(value = "select * from PROVISION_DATA where NVL(auth_flg,'N') <>'Y' and branch_code=?1", nativeQuery = true)
	List<Provision_Entity> getprovbranch_codeunveri(String branch_code);
	
	@Query(value = "select * from PROVISION_DATA where srl_no=?1 ", nativeQuery = true)
	Provision_Entity getprovsrl(String cin );
	
	@Query(value = "SELECT RBR_PROVISION_SRL_NO.NEXTVAL FROM dual", nativeQuery = true)
	Long getAuditRefUUID();
	
	@Query(value = "SELECT * FROM PROVISION_DATA WHERE cin IS NOT NULL  AND auth_flg = 'Y' AND operation = 'DEL'", nativeQuery = true)
	List<Provision_Entity> getlistofDEL();
	
	@Query(value = "SELECT * FROM PROVISION_DATA WHERE cin IS NOT NULL AND auth_flg = 'Y' AND operation = 'DEL'  AND BRANCH_CODE = ?1", nativeQuery = true)
	List<Provision_Entity> getlistofDELbranch(String Branchcode );
	
}
