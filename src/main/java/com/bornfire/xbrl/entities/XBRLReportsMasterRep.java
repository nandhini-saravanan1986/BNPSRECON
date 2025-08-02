package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface XBRLReportsMasterRep extends CrudRepository<XBRLReportsMaster,String>{
	

	@Query("select a.report_name from XBRLReportsMaster a where a.reportid=?1")
	public String getReportName(String repordId);
	
	@Query("select a.xbrl_taxonomy_version from XBRLReportsMaster a where a.reportid=?1")
	public String getTaxonomyVersion(String reportid);
	
	@Query("select a.report_frequency from XBRLReportsMaster a where a.reportid=?1")
	public String getReportFrq(String reportid);
	
	@Query("select a.institution_code from XBRLReportsMaster a where a.reportid=?1")
	public String getBankCode(String reportid);
	
	@Query("from XBRLReportsMaster a where a.report_validity='Y' and a.domain_id in ?1")
	public Iterable<XBRLReportsMaster> getReportList(List<String> domainid);
	
	@Query("from XBRLReportsMaster a where a.report_validity='Y' and a.archive_enable_flg='Y' and a.domain_id in ?1")
	public Iterable<XBRLReportsMaster> getArchReportList(List<String> domainid);
	
	@Query("select distinct a.domain_id from XBRLReportsMaster a where domain_id is not null")
	public List<String> getDomainList();
	
	@Modifying
	@Query("update XBRLReportsMaster a set report_validity=?2, lchg_user_id=?3, lchg_time=sysdate where reportid=?1 ")
	public int updateValidity(String reportId, String valid, String userid);
	

	@Query(value = "SELECT Report_name, Description, Frequency, Reporting_date, Status " + "FROM BRF_REPORTWISE_STATUS ", nativeQuery = true)
	List<Object[]> getsinstatus();
	
	@Query(value = "SELECT Report_name, Description, Frequency, Reporting_date, Status " + "FROM BRF_REPORTWISE_STATUS "
			+ "WHERE Reporting_date = TO_DATE(?1, 'YYYY-MM-DD')", nativeQuery = true)
	List<Object[]> getReportStatus(String reportDate);
	
}
