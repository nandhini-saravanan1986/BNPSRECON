package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bornfire.xbrl.entities.BNPSRECON.AuditServicesEntity;
import com.bornfire.xbrl.entities.BNPSRECON.UserAuditLevel_Entity;

public interface UserAuditRepo extends JpaRepository<UserAuditLevel_Entity, String> {

    @Query(value = "SELECT * FROM USER_AUDIT_LEVEL", nativeQuery = true)
    List<UserAuditLevel_Entity> getUserAuditList();
}




