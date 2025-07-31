package com.bornfire.xbrl.entities;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertManagementRepository extends JpaRepository<AlertManagementEntity, String> {

	Optional<AlertManagementEntity> findById(String directorId);

	@Query(value = "select * from BRBS_ALERT_MGMT_TABLE  where del_flg='N'", nativeQuery = true)
	Page<AlertManagementEntity> alertlist(Pageable page);

	@Modifying
	@Query(value = "UPDATE BRBS_ALERT_MGMT_TABLE u set u.DEL_FLG ='Y' where u.SRL_NO =?1", nativeQuery = true)
	int findByfgdg1(String srl_no);

	@Query(value = "select * from BRBS_ALERT_MGMT_TABLE  where alert_code = ?1", nativeQuery = true)
	AlertManagementEntity getalertdetail(String alertcode);
	
	
	@Query(value = "select param_1 from BRBS_ALERT_MGMT_TABLE  where srl_no = ?1", nativeQuery = true)
	String getParamdetail1(String srl_no);
	
	@Query(value = "select param_2 from BRBS_ALERT_MGMT_TABLE  where srl_no = ?1", nativeQuery = true)
	String getParamdetail2(String srl_no);
	
	@Query(value = "select param_3 from BRBS_ALERT_MGMT_TABLE  where srl_no = ?1", nativeQuery = true)
	String getParamdetail3(String srl_no);
	
/*	@Query(value = "select * from BAML_USER_ALERT_NOTIFICATION_TABLE  ", nativeQuery = true)
	List<AMLUserAlertNotification> getUserList();
*/
}
