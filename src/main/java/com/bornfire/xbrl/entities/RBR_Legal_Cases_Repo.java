package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bornfire.xbrl.entities.BRBS.Provision_Entity;
@Repository
public interface RBR_Legal_Cases_Repo extends JpaRepository<RBR_Legal_Cases_Entity, String>{
	@Query(value = "select * from legal_cases",nativeQuery = true)
	List<RBR_Legal_Cases_Entity> getList();
	
	@Query(value = "select * from legal_cases where cin=? ", nativeQuery = true)
	RBR_Legal_Cases_Entity getview(String cin );
	
	
	@Query(value = "select * from legal_cases where cin=? ", nativeQuery = true)
	List<RBR_Legal_Cases_Entity> getbyview(String cin );

	RBR_Legal_Cases_Entity findByCin(String cin);
	
	@Query(value = "select * from legal_cases where cin is not null and auth_flg ='Y' ", nativeQuery = true)
	List<RBR_Legal_Cases_Entity> getFinalRBR();

	@Query(value = "select * from legal_cases where cin is not null and auth_flg ='Y' and branch_code=?1", nativeQuery = true)
	List<RBR_Legal_Cases_Entity> getFinalbranchRBR(String Branchcode);
}
