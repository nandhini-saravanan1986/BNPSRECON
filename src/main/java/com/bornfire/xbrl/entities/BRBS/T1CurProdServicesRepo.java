package com.bornfire.xbrl.entities.BRBS;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface T1CurProdServicesRepo extends JpaRepository<T1CurProdServices, Date> {
	
	
	
	@Query(value = "select * from T1_CUR_PROD_SERVICES where REPORT_DATE=?1", nativeQuery = true)
	List<T1CurProdServices> getT1CurProdServices(Date d1);
	
	@Query(value = "select * from T1_CUR_PROD_SERVICES where REPORT_DATE=?1", nativeQuery = true)
	T1CurProdServices getT1CurProdServicesmast(Date d1);
	
	@Query(value = "select * from T1_CUR_PROD_SERVICES where report_date not in (select max(report_date) from T1_CUR_PROD_SERVICES)", nativeQuery = true)
	List<T1CurProdServices> getReportList();
	
	@Query(value = "select * from T1_CUR_PROD_SERVICES_DET_TABLE where report_date=?1", nativeQuery = true)
	Page<T1CurProdDetail> getReportList(String report_date,Pageable page );
	
	
}