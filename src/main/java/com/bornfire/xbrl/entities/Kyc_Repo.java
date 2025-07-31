package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Kyc_Repo extends JpaRepository<KYC_I, String> {
	@Query(value = "select * from ECDD_INDIVIDUAL where CUSTOMER_ID = ?1 ", nativeQuery = true)
	List<KYC_I> GetUser(String custid);

	@Query(value = "select * from ECDD_INDIVIDUAL where SRL_NO = ?1 ", nativeQuery = true)
	KYC_I GetUsersrl_no(String srl_no);

//	@Query(value = "SELECT customer_id, name, account_number, ACCOUNT_TYPE, ACCOUNT_OPENING_DATE, MODIFY_FLG, "
//            + "COUNTRY_OF_CITIZENSHIP, COUNTRY_OF_CURRENT_RESIDENCY, "
//            + "FLOOR( REPORT_DATE - CURRENT_DATE) AS days, CUSTOMER_RISK "
//            + "FROM kyc_ind "
//            + "WHERE del_flg = 'N'", nativeQuery = true)
//
//	List<Object[]> Getlist();
//
//	@Query(value = "SELECT customer_id, name, account_number, ACCOUNT_TYPE, ACCOUNT_OPENING_DATE, MODIFY_FLG, "
//			+ "COUNTRY_OF_CITIZENSHIP, COUNTRY_OF_CURRENT_RESIDENCY, "
//			+ "FLOOR(MONTHS_BETWEEN(CURRENT_DATE, DATE_OF_BIRTH) / 12) AS age, CUSTOMER_RISK " + "FROM kyc_ind "
//			+ "WHERE CUSTOMER_RISK = ?1 AND FLOOR( REPORT_DATE - CURRENT_DATE) = ?2 "
//			+ "AND del_flg = 'N'", nativeQuery = true)
//	List<Object[]> GetDynamicValue(String customerRisk, Integer age);

	@Query(value = "select DISTINCT nvl(branch,0) as branch ,COUNT(CUSTOMER_ID) from ECDD_INDIVIDUAL where nvl(ENTITY_FLG,'N')='N' group by branch", nativeQuery = true)
	List<Object[]> GetbranchPendingcount();

	@Query(value = "select NVL(count(*),0) from ECDD_INDIVIDUAL where nvl(ENTITY_FLG,'N')='Y'", nativeQuery = true)
	Integer Getcompletedcount();

	@Query(value = "select NVL(count(*),0) from ECDD_INDIVIDUAL where nvl(ENTITY_FLG,'N')='N'  and NVL(MODIFY_FLG,'N')= 'N'", nativeQuery = true)
	Integer GetIncompletedcount();

	@Query(value = "select NVL(count(*),0) from ECDD_INDIVIDUAL where nvl(ENTITY_FLG,'N')='N' and NVL(MODIFY_FLG,'N')= 'Y'", nativeQuery = true)
	Integer GetPendingcount();

	//// Retrive branchwise count
	@Query(value = "select NVL(count(*),0) from ECDD_INDIVIDUAL where nvl(ENTITY_FLG,'N')='Y' and branch=?1", nativeQuery = true)
	Integer Getbranchwisecompletedcount(String branch);

	@Query(value = "select NVL(count(*),0) from ECDD_INDIVIDUAL where nvl(ENTITY_FLG,'N')='N'  and NVL(MODIFY_FLG,'N')= 'N' and branch=?1", nativeQuery = true)
	Integer GetbranchwiseIncompletedcount(String branch);

	@Query(value = "select NVL(count(*),0) from ECDD_INDIVIDUAL where nvl(ENTITY_FLG,'N')='N' and NVL(MODIFY_FLG,'N')= 'Y' and branch=?1", nativeQuery = true)
	Integer GetbranchwisePendingcount(String branch);

	@Query(value = " SELECT customer_id, name, account_number, ACCOUNT_TYPE, ACCOUNT_OPENING_DATE,customer_risk,last_ecdd_date,\r\n" + 
			"            CASE WHEN customer_risk = 'High' THEN ABS(ABS(FLOOR(NVL(last_ecdd_date, SYSDATE) - SYSDATE))-365)\r\n" + 
			"                 WHEN customer_risk = 'Medium' THEN ABS(ABS(FLOOR(NVL(last_ecdd_date, SYSDATE) - SYSDATE))-1095)\r\n" + 
			"                 WHEN customer_risk = 'Low' THEN ABS(ABS(FLOOR(NVL(last_ecdd_date, SYSDATE) - SYSDATE))-1825) END AS Age,\r\n" + 
			"                 CASE WHEN customer_risk = 'High' THEN last_ecdd_date+365\r\n" + 
			"                 WHEN customer_risk = 'Medium' THEN last_ecdd_date+1095\r\n" + 
			"                 WHEN customer_risk = 'Low' THEN last_ecdd_date+1825 END AS DUE_DATE,SRL_NO,MODIFY_FLG,ENTITY_FLG FROM ECDD_INDIVIDUAL WHERE del_flg = 'N' ", nativeQuery = true)
	List<Object[]> Getlist();

	@Query(value = " SELECT customer_id, name, account_number, ACCOUNT_TYPE, ACCOUNT_OPENING_DATE,customer_risk,last_ecdd_date,\r\n" + 
			"            CASE WHEN customer_risk = 'High' THEN ABS(ABS(FLOOR(NVL(last_ecdd_date, SYSDATE) - SYSDATE))-365)\r\n" + 
			"                 WHEN customer_risk = 'Medium' THEN ABS(ABS(FLOOR(NVL(last_ecdd_date, SYSDATE) - SYSDATE))-1095)\r\n" + 
			"                 WHEN customer_risk = 'Low' THEN ABS(ABS(FLOOR(NVL(last_ecdd_date, SYSDATE) - SYSDATE))-1825) END AS Age,\r\n" + 
			"                 CASE WHEN customer_risk = 'High' THEN last_ecdd_date+365\r\n" + 
			"                 WHEN customer_risk = 'Medium' THEN last_ecdd_date+1095\r\n" + 
			"                 WHEN customer_risk = 'Low' THEN last_ecdd_date+1825 END AS DUE_DATE,SRL_NO,MODIFY_FLG,ENTITY_FLG FROM ECDD_INDIVIDUAL WHERE del_flg = 'N' and branch=?1", nativeQuery = true)
	List<Object[]> GetBranchlist(String Branch);

	@Query(value = "SELECT customer_id, name, account_number, ACCOUNT_TYPE, ACCOUNT_OPENING_DATE,customer_risk,\r\n"
			+ "			last_ecdd_date,FLOOR(nvl(last_ecdd_date,CURRENT_DATE) - current_date) AS age,SRL_NO,MODIFY_FLG,ENTITY_FLG FROM ECDD_INDIVIDUAL \r\n"
			+ "	        WHERE CUSTOMER_RISK = 'LOW' AND FLOOR(nvl(last_ecdd_date,CURRENT_DATE) - current_date) <= 0 AND del_flg = 'N'", nativeQuery = true)
	List<Object[]> GetDynamicValue(String customerRisk, Integer days);

	@Query(value = "SELECT customer_id, name, account_number, ACCOUNT_TYPE, ACCOUNT_OPENING_DATE,customer_risk,\r\n"
			+ "			last_ecdd_date,FLOOR(nvl(last_ecdd_date,CURRENT_DATE) - current_date) AS age ,SRL_NO,MODIFY_FLG,ENTITY_FLG FROM ECDD_INDIVIDUAL \r\n"
			+ "	        WHERE CUSTOMER_RISK = 'LOW' AND FLOOR(nvl(last_ecdd_date,CURRENT_DATE) - current_date) <= 0 AND del_flg = 'N' and branch=?3", nativeQuery = true)
	List<Object[]> GetBranchDynamicValue(String customerRisk, Integer days, String Branch);
	
	
	@Query(value = "SELECT customer_id, account_opening_date FROM ECDD_INDIV_PROFILE WHERE CUSTOMER_ID = ?1", nativeQuery = true)
	List<KYC_I> Getkycrevised(String custid);

}
