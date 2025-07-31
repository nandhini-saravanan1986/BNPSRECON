package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RBR_Inverstments_Repo extends JpaRepository<RBR_Inverstments_Entity, String> {
	@Query(value = "select *from investments",nativeQuery = true)
	List<RBR_Inverstments_Entity>getList();
	
	@Query(value = "select * from investments where cin=? ", nativeQuery = true)
	RBR_Inverstments_Entity getview(String cin );
	
	@Query(value = "select * from investments where cin=? ", nativeQuery = true)
	List<RBR_Inverstments_Entity> getbyview(String cin );

	RBR_Inverstments_Entity findByCin(String cin);
	
	
	@Query(value = "select * from investments where cin is not null and auth_flg ='Y' ",nativeQuery = true)
	List<RBR_Inverstments_Entity> getFinalRBR();
	
	@Query(value = "select * from investments where cin is not null and auth_flg ='Y' and branch_code=?1", nativeQuery = true)
	List<RBR_Inverstments_Entity> getFinalbranchRBR(String Branchcode);
	
	
}
