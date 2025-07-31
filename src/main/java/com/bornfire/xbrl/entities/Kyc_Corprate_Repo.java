package com.bornfire.xbrl.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Kyc_Corprate_Repo extends JpaRepository<EcddCorporateEntity, String> {

	/// Get the Branchwise pending count for Dashboard Page
	@Query(value = "select DISTINCT nvl(BRANCH_CODE,0) as BRANCH_CODE ,COUNT(CUSTOMER_ID) from ECDD_CORPORATE_TABLE where nvl(ENTITY_FLG,'N')='N' group by BRANCH_CODE", nativeQuery = true)
	List<Object[]> GetbranchPendingcount();

	@Query(value = "select * from ECDD_CORPORATE_TABLE where SRL_NO = ?1 ", nativeQuery = true)
	List<EcddCorporateEntity> GetUser(String srl_no);

	@Query(value = "SELECT CUSTOMER_ID, COMPANY_NAME, ASSOCIATED_ACCOUNT_NUMBER, TRADE_LICENSE_NUMBER, TRADE_EXPIRY_DATE, SYSTEM_RISK, LATEST_RISK, ECDD_DATE,\r\n" + 
			"			CASE WHEN SYSTEM_RISK = 'High' THEN ABS(ABS(FLOOR(NVL(ECDD_DATE, SYSDATE) - SYSDATE))-365)\r\n" + 
			"                 WHEN SYSTEM_RISK = 'Medium' THEN ABS(ABS(FLOOR(NVL(ECDD_DATE, SYSDATE) - SYSDATE))-1095)\r\n" + 
			"                 WHEN SYSTEM_RISK = 'Low' THEN ABS(ABS(FLOOR(NVL(ECDD_DATE, SYSDATE) - SYSDATE))-1825) END AS Age,\r\n" + 
			"                 CASE WHEN SYSTEM_RISK = 'High' THEN ECDD_DATE+365\r\n" + 
			"                 WHEN SYSTEM_RISK = 'Medium' THEN ECDD_DATE+1095\r\n" + 
			"                 WHEN SYSTEM_RISK = 'Low' THEN ECDD_DATE+1825 END AS DUE_DATE,SRL_NO,MODIFY_FLG,ENTITY_FLG\r\n" + 
			"            FROM ECDD_CORPORATE_TABLE WHERE del_flg = 'N' AND ECDD_DATE IS NOT NULL", nativeQuery = true)
	List<Object[]> getList();

	//// Retrive Branch wise details
	@Query(value = "SELECT CUSTOMER_ID, COMPANY_NAME, ASSOCIATED_ACCOUNT_NUMBER, TRADE_LICENSE_NUMBER, TRADE_EXPIRY_DATE, SYSTEM_RISK, LATEST_RISK, ECDD_DATE,\r\n" + 
			"			CASE WHEN SYSTEM_RISK = 'High' THEN ABS(ABS(FLOOR(NVL(ECDD_DATE, SYSDATE) - SYSDATE))-365)\r\n" + 
			"                 WHEN SYSTEM_RISK = 'Medium' THEN ABS(ABS(FLOOR(NVL(ECDD_DATE, SYSDATE) - SYSDATE))-1095)\r\n" + 
			"                 WHEN SYSTEM_RISK = 'Low' THEN ABS(ABS(FLOOR(NVL(ECDD_DATE, SYSDATE) - SYSDATE))-1825) END AS Age,\r\n" + 
			"                 CASE WHEN SYSTEM_RISK = 'High' THEN ECDD_DATE+365\r\n" + 
			"                 WHEN SYSTEM_RISK = 'Medium' THEN ECDD_DATE+1095\r\n" + 
			"                 WHEN SYSTEM_RISK = 'Low' THEN ECDD_DATE+1825 END AS DUE_DATE,SRL_NO,MODIFY_FLG,ENTITY_FLG\r\n" + 
			"            FROM ECDD_CORPORATE_TABLE WHERE del_flg = 'N' AND ECDD_DATE IS NOT NULL AND BRANCH_CODE = ?1", nativeQuery = true)
	List<Object[]> getBranchList(String Branchcode);

	@Query(value = "SELECT CUSTOMER_ID, COMPANY_NAME, ASSOCIATED_ACCOUNT_NUMBER, TRADE_LICENSE_NUMBER, TRADE_EXPIRY_DATE, SYSTEM_RISK, LATEST_RISK, ECDD_DATE, FLOOR(NVL(ECDD_DATE, SYSDATE) - SYSDATE) AS Age,SRL_NO,MODIFY_FLG,ENTITY_FLG FROM ECDD_CORPORATE_TABLE WHERE SYSTEM_RISK = ?1 AND FLOOR(NVL(ECDD_DATE, SYSDATE) - SYSDATE) <= ?2 AND del_flg = 'N'", nativeQuery = true)
	List<Object[]> getDynamicValue(String customerRisk, Integer days);

	//// Retrive Branch wise details
	@Query(value = "SELECT CUSTOMER_ID, COMPANY_NAME, ASSOCIATED_ACCOUNT_NUMBER, TRADE_LICENSE_NUMBER, TRADE_EXPIRY_DATE, SYSTEM_RISK, LATEST_RISK, ECDD_DATE, FLOOR(NVL(ECDD_DATE, SYSDATE) - SYSDATE) AS Age,SRL_NO,MODIFY_FLG,ENTITY_FLG FROM ECDD_CORPORATE_TABLE WHERE SYSTEM_RISK = ?1 AND FLOOR(NVL(ECDD_DATE, SYSDATE) - SYSDATE) <= ?2 AND del_flg = 'N' AND BRANCH_CODE = ?3", nativeQuery = true)
	List<Object[]> getBranchDynamicValue(String customerRisk, Integer days, String Branchcode);

	@Query(value = "select NVL(count(*),0) from ECDD_CORPORATE_TABLE where nvl(ENTITY_FLG,'N')='Y'", nativeQuery = true)
	Integer Getcompletedcount();

	@Query(value = "select NVL(count(*),0) from ECDD_CORPORATE_TABLE where nvl(ENTITY_FLG,'N')='N'  and NVL(MODIFY_FLG,'N')= 'N'", nativeQuery = true)
	Integer GetIncompletedcount();

	@Query(value = "select NVL(count(*),0) from ECDD_CORPORATE_TABLE where nvl(ENTITY_FLG,'N')='N' and NVL(MODIFY_FLG,'N')= 'Y'", nativeQuery = true)
	Integer GetPendingcount();

	//// Retrive branchwise count
	@Query(value = "select NVL(count(*),0) from ECDD_CORPORATE_TABLE where nvl(ENTITY_FLG,'N')='Y' and BRANCH_CODE=?1", nativeQuery = true)
	Integer Getbranchwisecompletedcount(String branch);

	@Query(value = "select NVL(count(*),0) from ECDD_CORPORATE_TABLE where nvl(ENTITY_FLG,'N')='N'  and NVL(MODIFY_FLG,'N')= 'N' and BRANCH_CODE=?1", nativeQuery = true)
	Integer GetbranchwiseIncompletedcount(String branch);

	@Query(value = "select NVL(count(*),0) from ECDD_CORPORATE_TABLE where nvl(ENTITY_FLG,'N')='N' and NVL(MODIFY_FLG,'N')= 'Y' and BRANCH_CODE=?1", nativeQuery = true)
	Integer GetbranchwisePendingcount(String branch);
	
	@Query(value = "SELECT *\r\n"
			+ "FROM (\r\n"
			+ "    SELECT branch_code, system_risk\r\n"
			+ "    FROM ECDD_CORPORATE_TABLE\r\n"
			+ "    WHERE entity_flg = 'Y' AND modify_flg = 'N'\r\n"
			+ ")\r\n"
			+ "PIVOT (\r\n"
			+ "    COUNT(system_risk)\r\n"
			+ "    FOR system_risk IN ('Low' AS LOW_RISK, 'Medium' AS MEDIUM_RISK, 'High' AS HIGH_RISK)\r\n"
			+ ")\r\n"
			+ "ORDER BY branch_code", nativeQuery = true)
	List<Object[]> getstatuscount();
	
	@Query(value = "SELECT *\r\n"
			+ "FROM (\r\n"
			+ "    SELECT branch_code, system_risk\r\n"
			+ "    FROM ECDD_CORPORATE_TABLE\r\n"
			+ "    WHERE entity_flg = 'N' AND modify_flg = 'Y'\r\n"
			+ ")\r\n"
			+ "PIVOT (\r\n"
			+ "    COUNT(system_risk)\r\n"
			+ "    FOR system_risk IN ('Low' AS LOW_RISK, 'Medium' AS MEDIUM_RISK, 'High' AS HIGH_RISK)\r\n"
			+ ")\r\n"
			+ "ORDER BY branch_code", nativeQuery = true)
	List<Object[]> getpendingstatuscount();

}