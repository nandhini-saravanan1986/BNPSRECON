

package com.bornfire.xbrl.entities.BRBS;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BRF4_DetaiRep extends JpaRepository<BRF4_DETAIL_ENTITY, String> {
@Query(value = "SELECT * FROM  brf4_detail_table WHERE acct_no =?1", nativeQuery = true)
		BRF4_DETAIL_ENTITY getallDetails(String acct_no);
}
