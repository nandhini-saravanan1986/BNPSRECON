package com.bornfire.xbrl.entities.BRBS;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * FINAL VERSION: This repository uses the correct query logic and column order for the view,
 * but uses the method names from Kyc_Corprate_Repo (getList, getBranchList, etc.)
 * so it works as a drop-in replacement in the existing controller.
 */
@Repository
public interface EcddIndividualProfileRepository extends JpaRepository<Ecdd_Individual_Profile_Entity, String> {

    /**
     * Reusable base query for Individual KYC, ordered perfectly for the Thymeleaf view.
     * Uses the day-based calculation (+365, etc.) as requested.
     */
    String INDIVIDUAL_KYC_QUERY_FOR_VIEW = "SELECT " +
            "p.CUSTOMER_ID, " +                // 0 -> Customer ID
            "p.SYSTEM_RISK, " +                 // 1 -> Risk Category
            "p.ECDD_DATE, " +                   // 2 -> Last ECDD Review Date
            "CASE " +
            "  WHEN p.SYSTEM_RISK = 'High' THEN p.ECDD_DATE + 365 " +
            "  WHEN p.SYSTEM_RISK = 'Medium' THEN p.ECDD_DATE + 1095 " +
            "  WHEN p.SYSTEM_RISK = 'Low' THEN p.ECDD_DATE + 1825 " +
            "  ELSE NULL " +
            "END AS NEXT_REVIEW_DATE, " +       // 3 -> Next Review Date
            "TRUNC(CASE " +
            "  WHEN p.SYSTEM_RISK = 'High' THEN p.ECDD_DATE + 365 " +
            "  WHEN p.SYSTEM_RISK = 'Medium' THEN p.ECDD_DATE + 1095 " +
            "  WHEN p.SYSTEM_RISK = 'Low' THEN p.ECDD_DATE + 1825 " +
            "  ELSE NULL " +
            "END) - TRUNC(SYSDATE) AS PENDING_DAYS, " + // 4 -> Pending Due Days
            "p.SRLNO, " +                       // 5 -> Serial Number (for link)
            "p.ENTITY_FLG, " +                    // 6 -> Auth Flag (for status)
            "p.MODIFY_FLG, " +                  // 7 -> Modify Flag (for status)
            "p.ACCOUNT_TITLE, " +               // 8 -> Account Title
            "p.ACCOUNT_OPEN_DATE, " +           // 9 -> Account Opening Date
            "p.ASSOCIATED_ACCOUNTS " +          // 10 -> Account Number (for commented-out column)
            "FROM ECDD_INDIV_PROFILE p WHERE p.DEL_FLG = 'N'";

    // --- Methods renamed to match your controller's expectations ---

    /**
     * Replaces findAllIndividuals(). Corresponds to getList() in the corporate repo.
     */
    @Query(value = INDIVIDUAL_KYC_QUERY_FOR_VIEW, nativeQuery = true)
    List<Object[]> findAllIndividuals();

    /**
     * Replaces findAllIndividualsByBranch(). Corresponds to getBranchList() in the corporate repo.
     */
    @Query(value = INDIVIDUAL_KYC_QUERY_FOR_VIEW + " AND p.BRANCH = ?1", nativeQuery = true)
    List<Object[]> findAllIndividualsByBranch(String Branchcode);

    /**
     * Replaces findFilteredIndividuals(). Corresponds to getDynamicValue() in the corporate repo.
     * NOTE: The parameter is named 'days' to match the old repo, even though your controller passes a variable named 'age'.
     */
    @Query(value = INDIVIDUAL_KYC_QUERY_FOR_VIEW + " AND p.SYSTEM_RISK = ?1 HAVING " +
            "TRUNC(CASE " +
            "  WHEN p.SYSTEM_RISK = 'High' THEN p.ECDD_DATE + 365 " +
            "  WHEN p.SYSTEM_RISK = 'Medium' THEN p.ECDD_DATE + 1095 " +
            "  WHEN p.SYSTEM_RISK = 'Low' THEN p.ECDD_DATE + 1825 " +
            "  ELSE NULL " +
            "END) - TRUNC(SYSDATE) <= ?2", nativeQuery = true)
    List<Object[]> findFilteredIndividuals(String customerRisk, Integer days);
    
    /**
     * Replaces findFilteredIndividualsByBranch(). Corresponds to getBranchDynamicValue() in the corporate repo.
     */
    @Query(value = INDIVIDUAL_KYC_QUERY_FOR_VIEW + " AND p.SYSTEM_RISK = 'High' AND p.BRANCH = ?3 HAVING " +
            "TRUNC(CASE " +
            "  WHEN p.SYSTEM_RISK = 'High' THEN p.ECDD_DATE + 365 " +
            "  WHEN p.SYSTEM_RISK = 'Medium' THEN p.ECDD_DATE + 1095 " +
            "  WHEN p.SYSTEM_RISK = 'Low' THEN p.ECDD_DATE + 1825 " +
            "  ELSE NULL " +
            "END) - TRUNC(SYSDATE) <= ?2", nativeQuery = true)
    List<Object[]> findFilteredIndividualsByBranch(String customerRisk, Integer days, String Branchcode);

    /**
     * Finds a single individual entity by its Serial Number.
     */
    @Query(value = "SELECT * FROM ECDD_INDIV_PROFILE WHERE SRLNO = ?1", nativeQuery = true)
    Ecdd_Individual_Profile_Entity GetUserBySrlNo(String srlno);
    
    
    @Query(value = "select NVL(count(*),0) from ECDD_INDIV_PROFILE where nvl(ENTITY_FLG,'N')='Y'", nativeQuery = true)
	Integer Getcompletedcount();

	@Query(value = "select NVL(count(*),0) from ECDD_INDIV_PROFILE where nvl(ENTITY_FLG,'N')='N'  and NVL(MODIFY_FLG,'N')= 'N'", nativeQuery = true)
	Integer GetIncompletedcount();

	@Query(value = "select NVL(count(*),0) from ECDD_INDIV_PROFILE where nvl(ENTITY_FLG,'N')='N' and NVL(MODIFY_FLG,'N')= 'Y'", nativeQuery = true)
	Integer GetPendingcount();

	//// Retrive branchwise count
	@Query(value = "select NVL(count(*),0) from ECDD_INDIV_PROFILE where nvl(ENTITY_FLG,'N')='Y' and branch=?1", nativeQuery = true)
	Integer Getbranchwisecompletedcount(String branch);

	@Query(value = "select NVL(count(*),0) from ECDD_INDIV_PROFILE where nvl(ENTITY_FLG,'N')='N'  and NVL(MODIFY_FLG,'N')= 'N' and branch=?1", nativeQuery = true)
	Integer GetbranchwiseIncompletedcount(String branch);

	@Query(value = "select NVL(count(*),0) from ECDD_INDIV_PROFILE where nvl(ENTITY_FLG,'N')='N' and NVL(MODIFY_FLG,'N')= 'Y' and branch=?1", nativeQuery = true)
	Integer GetbranchwisePendingcount(String branch);
	
	@Query(value = "select DISTINCT nvl(branch,0) as branch ,COUNT(CUSTOMER_ID) from ECDD_INDIV_PROFILE where nvl(ENTITY_FLG,'N')='N' group by branch", nativeQuery = true)
	List<Object[]> GetbranchPendingcount();
	
	@Query(value = "SELECT *\r\n"
			+ "FROM (\r\n"
			+ "    SELECT branch, system_risk\r\n"
			+ "    FROM ecdd_indiv_profile\r\n"
			+ "    WHERE entity_flg = 'Y' AND modify_flg = 'N'\r\n"
			+ ")\r\n"
			+ "PIVOT (\r\n"
			+ "    COUNT(system_risk)\r\n"
			+ "    FOR system_risk IN ('Low' AS LOW_RISK, 'Medium' AS MEDIUM_RISK, 'High' AS HIGH_RISK)\r\n"
			+ ")\r\n"
			+ "ORDER BY branch\r\n"
			+ "", nativeQuery = true)
	List<Object[]> getstatuscount();
	
	@Query(value = "SELECT *\r\n"
			+ "FROM (\r\n"
			+ "    SELECT branch, system_risk\r\n"
			+ "    FROM ecdd_indiv_profile\r\n"
			+ "    WHERE entity_flg = 'N' AND modify_flg = 'Y'\r\n"
			+ ")\r\n"
			+ "PIVOT (\r\n"
			+ "    COUNT(system_risk)\r\n"
			+ "    FOR system_risk IN ('Low' AS LOW_RISK, 'Medium' AS MEDIUM_RISK, 'High' AS HIGH_RISK)\r\n"
			+ ")\r\n"
			+ "ORDER BY branch\r\n"
			+ "", nativeQuery = true)
	List<Object[]> getpendingstatuscount();
    
}