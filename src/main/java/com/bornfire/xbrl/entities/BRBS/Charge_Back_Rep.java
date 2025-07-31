
package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Charge_Back_Rep extends JpaRepository<Charge_Back_Entity, String> {

	@Query(value = "select * from CHARGE_BACK where del_flg='N' order by srlno", nativeQuery = true)
	List<Charge_Back_Entity> getlist();

	@Query(value = "select * from CHARGE_BACK where srlno=?1", nativeQuery = true)
	Charge_Back_Entity getlistone(String srlno);

	@Query(value = "SELECT CHARGEBACK1.NEXTVAL FROM DUAL", nativeQuery = true)
	String srlno();

	@Query(value = "select report_name from CHARGE_BACK", nativeQuery = true)
	List<Charge_Back_Entity> getlists1();

	@Query(value = "select MAX(srlno) from CHARGE_BACK", nativeQuery = true)
	Integer getMaxsrlno();

	@Query(value = "select * from CHARGE_BACK", nativeQuery = true)
	List<Charge_Back_Entity> findByRecordNumber(String srlno);

	@Query(value = "SELECT * FROM CHARGE_BACK WHERE TRUNC(REPORT_DATE) = TO_DATE(?1, 'DD-MM-RR')", nativeQuery = true)
	List<Charge_Back_Entity> getAbsenteesFrom(String srlno);

	@Query(value = "select distinct report_name from CHARGE_BACK", nativeQuery = true)
	List<String> getReportNames();

	@Query(value = "select distinct srlno from CHARGE_BACK", nativeQuery = true)
	List<String> getsrlno();

	@Query(value = "select distinct message_reason_code,member_message_text,document_indicator,full_partial_indicator,case_number,currency_code_billing,processing_status from CHARGE_BACK", nativeQuery = true)
	List<String> getvalues();

	/* query to get customer profile values - Aishu */
	@Query(value = "SELECT A.PRIMARY_SOL_ID, B.SOL_DESC, A.ORGKEY, A.CUST_FIRST_NAME, A.CUST_LAST_NAME, A.CUST_DOB, A.GENDER, A.CUST_STAFF_STATUS "
			+ "FROM accounts A " + "JOIN sol B ON A.PRIMARY_SOL_ID = B.SOL_ID", nativeQuery = true)
	List<Object[]> getAllcust();

	/* query to get Account profile values - Aishu */
	@Query(value = "SELECT  \r\n" + "    A.SOL_ID,  \r\n" + "    C.SOL_DESC,  \r\n"
			+ "    LTRIM(A.CIF_ID) AS CIF_ID, \r\n" + "    A.GL_SUB_HEAD_CODE,  \r\n" + "    A.SCHM_CODE,  \r\n"
			+ "    A.FORACID,  \r\n" + "    A.ACCT_NAME,  \r\n" + "    A.ACCT_OPN_DATE,  \r\n"
			+ "    A.CLR_BAL_AMT  \r\n" + "FROM gam A  \r\n" + "JOIN accounts B  \r\n"
			+ "    ON LTRIM(A.CIF_ID) = B.ORGKEY \r\n" + "    AND A.SOL_ID = B.PRIMARY_SOL_ID  \r\n"
			+ "INNER JOIN sol C  \r\n" + "    ON A.SOL_ID = C.SOL_ID  ", nativeQuery = true)
	List<Object[]> getAllacct();

	/* query to get personal details for acct - Aishu */
	@Query(value = "select distinct a.primary_sol_id, a.orgkey,b.CUST_ID,b.foracid, a.name, a.CUST_FIRST_NAME, a.gender, \r\n"
			+ "a.CUST_DOB, a.OCCUPATION, a.PAN, a.PASSPORTNO, a.PHONE, a.EMAIL from accounts a \r\n"
			+ "join gam b on a.orgkey = b.cif_id \r\n" + "where a.orgkey =?1 and b.foracid =?2", nativeQuery = true)
	List<Object[]> getper(String cif_id, String acct_no);

	/* query to get Address details for acct - Aishu */
	@Query(value = "SELECT DISTINCT a.orgkey,b.cust_id,b.foracid, c.ACCOUNTID,c.name, c.CUST_FIRST_NAME, c.CUST_LAST_NAME, "
			+ "a.ADDRESS_LINE1, a.ADDRESS_LINE2, a.ADDRESS_LINE3, a.CITY, a.STATE, a.COUNTRY, c.PHONE, c.EMAIL "
			+ "FROM address a JOIN gam b ON a.orgkey = b.cif_id " + "JOIN accounts c ON a.orgkey = c.orgkey "
			+ "WHERE a.orgkey = ?1 AND b.foracid = ?2", nativeQuery = true)
	List<Object[]> getadres(String cif_id, String acct_no);

	/* query to get transaction details for acct - raji */
	@Query(value = "SELECT DISTINCT A.Tran_Id, A.Tran_Date, "
			+ "A.Tran_Type, A.PART_TRAN_TYPE, A.PART_TRAN_SRL_NUM, A.Tran_sub_Type, A.TRAN_AMT, "
			+ "A.TRAN_RMKS, A.TRAN_PARTICULAR, A.Tr_Status FROM htdt A "
			+ "JOIN dtd B ON A.Tran_Id = B.Tran_Id INNER JOIN gam C ON A.ACID = C.ACID "
			+ "WHERE (C.CIF_ID = ?1 OR C.FORACID = ?2) AND C.CIF_ID IS NOT NULL", nativeQuery = true)
	List<Object[]> gettran(String cif_id, String acct_no);

	/* query to get Transaction details for acct - raji */
	@Query(value = "SELECT DISTINCT  \r\n" + "    C.Cif_id,  \r\n" + "    TRIM(A.Tran_Id) AS Tran_Id,     \r\n"
			+ "    A.Tran_Date, \r\n" + "    A.Tran_Type,     \r\n" + "    A.PART_TRAN_TYPE,    \r\n"
			+ "    A.PART_TRAN_SRL_NUM,\r\n" + "    A.Tran_sub_Type,    \r\n" + "    A.TRAN_AMT,     \r\n"
			+ "    A.TRAN_RMKS, \r\n" + "    A.TRAN_PARTICULAR,    \r\n" + "    A.Tr_Status \r\n" + "FROM     \r\n"
			+ "    htdt A \r\n" + "JOIN     \r\n" + "    dtd B    \r\n" + "    ON TRIM(A.Tran_Id) = TRIM(B.Tran_Id)\r\n"
			+ "INNER JOIN     \r\n" + "    gam C   \r\n" + "    ON A.ACID = C.ACID\r\n" + "WHERE  \r\n"
			+ "    C.cif_id IS NOT NULL\r\n" + "    AND (TRIM(A.TRAN_ID) =?1)", nativeQuery = true)
	List<Object[]> gettransactions(@Param("tranId") String tranId);

	/* query to get Account details for acct - raji */
	@Query(value = "SELECT DISTINCT " + "    E.ORGKEY, " + "    A.Cust_Id, " + " A.FORACID, " + " A.ACCT_NAME, "
			+ "    A.Sol_id, " + " B.Sol_Desc, " + " A.GL_Sub_Head_CODE, " + " C.GL_Sub_Head_desc, "
			+ "    A.Acct_crncy_code, " + " A.Schm_code, " + " D.Schm_Desc, " + " A.Schm_Type, "
			+ "    A.ACCT_OPN_DATE, " + " A.CLR_BAL_AMT " + "FROM gam A " + "JOIN sol B ON A.SOL_ID = B.SOL_ID "
			+ "INNER JOIN gsh C ON A.GL_Sub_Head_CODE = C.GL_Sub_Head_CODE "
			+ "INNER JOIN gsp D ON A.Schm_code = D.Schm_code " + "INNER JOIN accounts E ON A.CIF_ID = E.ORGKEY "
			+ "WHERE (A.CIF_ID = ?1 OR A.FORACID = ?2) " + "AND A.CIF_ID IS NOT NULL", nativeQuery = true)
	List<Object[]> getacct(String cif_id, String acct_no);

	/* query to get Trade finance for acct - raji */
	@Query(value = "SELECT DISTINCT A.ORGKEY,A.NAME,A.TRADE_FINANCE_ID, A.CORP_ID,A.CRNCY_CODE,B.PRIMARY_SOL_ID, "
			+ "C.SOL_DESC, A.CORPORATE_NAME FROM tradefinance A "
			+ "JOIN accounts B ON A.ORGKEY = B.ORGKEY AND A.CORP_ID = B.CORP_ID "
			+ "INNER JOIN sol C ON B.PRIMARY_SOL_ID = C.SOL_ID " + "INNER JOIN gam D ON B.ORGKEY = D.CIF_ID "
			+ "WHERE (D.cif_id = ?1 OR D.foracid = ?2) AND D.CIF_ID IS NOT NULL", nativeQuery = true)
	List<Object[]> gettrade(String cif_id, String acct_no);

	/* query to get Doc Details for acct - raji */
	@Query(value = "SELECT DISTINCT A.ORGKEY,B.NAME,C.foracid, A.ENTITYDOCUMENTID, A.DOCCODE, "
			+ "A.DOCDESCR, A.REFERENCENUMBER, A.DOCTYPECODE, A.DOCTYPEDESCR, A.COUNTRYOFISSUE, "
			+ "A.DOCISSUEDATE, A.DOCRECEIVEDDATE FROM entitydocument A " + "JOIN accounts B ON A.ORGKEY = B.ORGKEY "
			+ "JOIN gam C ON A.ORGKEY = C.cif_id " + "WHERE (C.cif_id =?1 OR C.foracid =?2) "
			+ "AND C.cif_id IS NOT NULL ", nativeQuery = true)
	List<Object[]> getdoc(String cif_id, String acct_no);

	/* query to get Employee Details for acct - raji */
	@Query(value = "SELECT DISTINCT c.cif_id, c.foracid, a.sol_id, b.sol_desc, a.emp_id, c.acct_name AS name, a.emp_desig, a.emp_email_id "
			+ "FROM get a " + "JOIN sol b ON a.sol_id = b.sol_id " + "INNER JOIN gam c ON c.emp_id = a.emp_id "
			+ "WHERE (c.cif_id =?1 OR c.foracid =?2) " + "AND c.cif_id IS NOT NULL", nativeQuery = true)
	List<Object[]> getemp(String cif_id, String acct_no);

	/* query to get Account details for Acct - raji */
	@Query(value = "SELECT DISTINCT    E.ORGKEY,    A.Cust_Id,  A.FORACID, "
			+ "    A.ACCT_NAME,   A.Sol_id,     B.Sol_Desc,  "
			+ "    A.GL_Sub_Head_CODE,    C.GL_Sub_Head_desc,  A.Acct_crncy_code, "
			+ "    A.Schm_code,     D.Schm_Desc,    A.Schm_Type," + "    A.ACCT_OPN_DATE,   A.CLR_BAL_AMT  FROM  gam A "
			+ "INNER JOIN   sol B ON A.SOL_ID = B.SOL_ID INNER JOIN "
			+ "    gsh C ON A.GL_Sub_Head_CODE = C.GL_Sub_Head_CODE " + "INNER JOIN "
			+ "    gsp D ON A.Schm_code = D.Schm_code " + "INNER JOIN " + "    accounts E ON A.CIF_ID = E.ORGKEY "
			+ "WHERE " + "    A.FORACID = ?1 \r\n", nativeQuery = true)
	List<Object[]> getaccts1(String acct_no);

	/* query to get Sign details for acct - raji */
	@Query(value = "SELECT  a.foracid,  b.SOL_ID, c.sol_desc,"
			+ "			  a.acct_name AS name, b.cust_id, b.SIGN_POWER_NUM,"
			+ "			 b.SIGN_LENGTH,b.SIGN_AREA, b.CAPTURE_DATE, b.EXPIRY_DATE FROM imt b "
			+ "             INNER JOIN  sol c ON b.SOL_ID = c.SOL_ID"
			+ "			INNER JOIN    gam a ON a.acid = b.acid"
			+ "			WHERE a.cif_id =?1 and a.foracid =?2", nativeQuery = true)
	List<Object[]> getsign(String cif_id, String acct_no);

	/* query to get Associate details for acct - raji */
	@Query(value = " SELECT  distinct  B.ORGKEY,  B.NAME,    A.ASSOCIATIONID \r\n"
			+ "FROM   associations A  JOIN    accounts B \r\n"
			+ "  ON A.ASSOCIATIONID = B.ACCOUNTID JOIN    gam C \r\n" + "  ON B.ORGKEY = C.CIF_ID \r\n"
			+ "  WHERE  B.ORGKEY =?1 or A.FORACID =?2", nativeQuery = true)
	List<Object[]> getassociated(String cif_id, String acct_no);

	/* List<Object[]> getassociated(String cifId); */

	/* query to get photo details for ACCT - raji */
	@Query(value = "SELECT  \r\n"
			+ "    a.foracid, b.SOL_ID,  c.sol_desc,  a.acct_name AS name, b.cust_id, b.KEY_WORD,  b.IMAGE_SRL_NUM,  b.IMAGE_ACCESS_CODE,  b.CAPTURE_DATE,  b.EXPIRY_DATE  \r\n"
			+ "FROM imt b  \r\n" + "INNER JOIN sol c ON b.SOL_ID = c.SOL_ID  \r\n"
			+ "INNER JOIN gam a ON a.acid = b.acid  \r\n" + "WHERE LTRIM(a.cif_id) = ?1  \r\n"
			+ "or LTRIM(a.foracid) = ?2\r\n" + "  ", nativeQuery = true)
	List<Object[]> getpics(String cif_id, String acct_no);

	/* query to get JOINT HOLDER details for acct - raji */
	@Query(value = "SELECT DISTINCT   C.ORGKEY,  C.NAME, D.FORACID,  B.JOINT_NAME1,\r\n"
			+ "B.JOINT_NAME2,   B.JOINT_PAN_1,    B.JOINT_PAN_2,\r\n"
			+ "A.JOINT_HOLDER_CUST_ID FROM    ccgt A JOIN \r\n" + "mhrt B     ON A.SCHM_CODE = B.SCHEME_CODE JOIN \r\n"
			+ "accounts C     ON B.JOINT_NAME1 = C.NAME JOIN \r\n" + "gam D     ON C.ORGKEY = D.CIF_ID\r\n"
			+ "WHERE C.ORGKEY=?1 and D.FORACID=?2", nativeQuery = true)
	List<Object[]> getjoints(String cif_id, String acct_no);

	@Query(value = "SELECT DISTINCT\r\n" + "B.ORGKEY,\r\n" + "B.CUST_TYPE,\r\n" + "B.NAME,\r\n" + "A.BILL_ID,\r\n"
			+ "A.REG_TYPE,\r\n" + "A.BILL_DATE,\r\n" + "A.BILL_CRNCY_CODE,\r\n" + "A.BILL_AMT,\r\n"
			+ "A.DUE_DATE FROM\r\n" + "fbm A\r\n" + "JOIN accounts B ON A.SOL_ID = B.PRIMARY_SOL_ID\r\n"
			+ "JOIN    gam C\r\n" + " ON B.ORGKEY = C.CIF_ID\r\n" + "WHERE  B.ORGKEY =?1", nativeQuery = true)
	List<Object[]> gettradeflg(String cif_id);

	@Query(value = "SELECT DISTINCT C.FORACID,B.CUST_TYPE,B.NAME,A.BILL_ID,\r\n"
			+ "A.REG_TYPE,A.BILL_DATE,A.BILL_CRNCY_CODE,A.BILL_AMT,\r\n" + "A.DUE_DATE FROM fbm A\r\n"
			+ "JOIN accounts B ON A.SOL_ID = B.PRIMARY_SOL_ID JOIN    gam C\r\n" + "ON B.ORGKEY = C.CIF_ID\r\n"
			+ "WHERE C.FORACID =?1 AND A.BILL_ID =?2", nativeQuery = true)
	List<Object[]> gettradEflag(String FORACID, String billId);

	/*------------------ACCT PROFILE-------------*/

	/*-------------corporateretail all customer-------------*/

	@Query(value = "SELECT \r\n" + "    NAT_ID_CARD_NUM," + "    COUNT(DISTINCT orgkey) AS orgkey_count\r\n"
			+ "FROM \r\n" + "    accounts\r\n" + "WHERE \r\n" + "    NAT_ID_CARD_NUM IS NOT NULL\r\n"
			+ "    AND NAT_ID_CARD_NUM IN (\r\n" + "        SELECT NAT_ID_CARD_NUM\r\n" + "        FROM accounts\r\n"
			+ "        WHERE NAT_ID_CARD_NUM IS NOT NULL\r\n" + "        GROUP BY NAT_ID_CARD_NUM\r\n"
			+ "        HAVING COUNT(DISTINCT orgkey) > 1\r\n" + "    )\r\n" + "GROUP BY \r\n"
			+ "    NAT_ID_CARD_NUM", nativeQuery = true)
	List<Object[]> getAll1();

	@Query(value = "SELECT \r\n" + "  NAT_ID_CARD_NUM, TRIM(CUST_FIRST_NAME || ' ' || CUST_LAST_NAME) AS NAME,\r\n"
			+ "    orgkey\r\n" + "FROM \r\n" + "    accounts\r\n" + "WHERE \r\n"
			+ "    NAT_ID_CARD_NUM =?1", nativeQuery = true)
	List<Object[]> getcif1(String natIdCardNum);

	/*----------------------retail customer------------*/

	@Query(value = "SELECT \r\n" + "    NAT_ID_CARD_NUM," + "    COUNT(DISTINCT orgkey) AS orgkey_count\r\n"
			+ "FROM \r\n" + "    accounts\r\n" + "WHERE \r\n" + "    NAT_ID_CARD_NUM IS NOT NULL\r\n"
			+ "    AND NAT_ID_CARD_NUM IN (\r\n" + "        SELECT NAT_ID_CARD_NUM\r\n" + "        FROM accounts\r\n"
			+ "        WHERE NAT_ID_CARD_NUM IS NOT NULL\r\n"
			+ "        AND (orgkey LIKE 'R0%' OR orgkey LIKE 'C0%')\r\n" + "        GROUP BY NAT_ID_CARD_NUM\r\n"
			+ "        HAVING COUNT(DISTINCT orgkey) > 1\r\n" + "    )\r\n" + "GROUP BY \r\n"
			+ "    NAT_ID_CARD_NUM", nativeQuery = true)
	List<Object[]> getRetailCustomers1();

	@Query(value = "SELECT   NAT_ID_CARD_NUM, TRIM(CUST_FIRST_NAME || ' ' || CUST_LAST_NAME) AS NAME,\r\n"
			+ "    		 orgkey FROM    accounts WHERE \r\n"
			+ "	              (orgkey LIKE 'R0%' OR orgkey LIKE 'C0%')\r\n"
			+ "	  		 And NAT_ID_CARD_NUM =?1", nativeQuery = true)
	List<Object[]> getcifRetail1(String natIdCardNum);

	/*----------------------corporate customer------------*/
	@Query(value = "SELECT DISTINCT NAT_ID_CARD_NUM,\r\n"
			+ "       COUNT(DISTINCT orgkey) OVER (PARTITION BY NAT_ID_CARD_NUM) AS orgkey_count\r\n"
			+ "FROM accounts\r\n" + "WHERE NAT_ID_CARD_NUM IS NOT NULL  \r\n" + "  AND NAT_ID_CARD_NUM IN (\r\n"
			+ "      SELECT NAT_ID_CARD_NUM\r\n" + "      FROM accounts \r\n"
			+ "      WHERE NAT_ID_CARD_NUM IS NOT NULL\r\n" + "      GROUP BY NAT_ID_CARD_NUM\r\n"
			+ "      HAVING COUNT(DISTINCT orgkey) > 1\r\n" + "  ) \r\n"
			+ "  AND REGEXP_LIKE(orgkey, '^[0-9]')", nativeQuery = true)
	List<Object[]> getCorporateCustomers1();

	@Query(value = "SELECT \r\n" + "  NAT_ID_CARD_NUM, TRIM(CUST_FIRST_NAME || ' ' || CUST_LAST_NAME) AS NAME,\r\n"
			+ "    orgkey\r\n" + "FROM \r\n" + "    accounts\r\n" + "WHERE \r\n"
			+ "    NAT_ID_CARD_NUM =?1", nativeQuery = true)
	List<Object[]> getcifall1(String natIdCardNum);

	/* CUST PROFILE QUERY */
	/* ===================================== */

	/* query to get personal details for cust - Aishu */
	@Query(value = "select distinct a.primary_sol_id, a.orgkey,b.CUST_ID, a.name, a.CUST_FIRST_NAME, a.gender, "
			+ "a.CUST_DOB, a.OCCUPATION, a.PAN, a.PASSPORTNO, a.PHONE, a.EMAIL from accounts a "
			+ "join gam b on a.orgkey = b.cif_id " + "where a.orgkey = ?1", nativeQuery = true)
	List<Object[]> getpersonal(String cif_id);

	/* query to get Address details for cust - raji */
	@Query(value = "SELECT DISTINCT a.orgkey, b.cust_id,c.ACCOUNTID, "
			+ "     c.name,c.CUST_FIRST_NAME,c.CUST_LAST_NAME," + "     a.ADDRESS_LINE1,a.ADDRESS_LINE2, "
			+ "     a.ADDRESS_LINE3,a.CITY,a.STATE, " + "     a.COUNTRY,c.PHONE,c.EMAIL " + "FROM address a "
			+ "JOIN gam b ON a.orgkey = b.cif_id " + "JOIN accounts c ON a.orgkey = c.orgkey "
			+ "WHERE a.orgkey =?1", nativeQuery = true)
	List<Object[]> getadress(String cifId);

	/* query to get Account details for cust - raji */
	@Query(value = "SELECT DISTINCT    E.ORGKEY,    A.Cust_Id,  A.FORACID, "
			+ "    A.ACCT_NAME,   A.Sol_id,     B.Sol_Desc,  "
			+ "    A.GL_Sub_Head_CODE,    C.GL_Sub_Head_desc,  A.Acct_crncy_code, "
			+ "    A.Schm_code,     D.Schm_Desc,    A.Schm_Type," + "    A.ACCT_OPN_DATE,   A.CLR_BAL_AMT  FROM  gam A "
			+ "INNER JOIN   sol B ON A.SOL_ID = B.SOL_ID INNER JOIN "
			+ "    gsh C ON A.GL_Sub_Head_CODE = C.GL_Sub_Head_CODE " + "INNER JOIN "
			+ "    gsp D ON A.Schm_code = D.Schm_code " + "INNER JOIN " + "    accounts E ON A.CIF_ID = E.ORGKEY "
			+ "WHERE " + "    A.FORACID = ?1", nativeQuery = true)
	List<Object[]> getaccts2(String acct_no);

	/* query to get Trade finance for cust - raji */
	@Query(value = "SELECT DISTINCT A.ORGKEY,A.NAME, A.TRADE_FINANCE_ID, A.CORP_ID, A.CRNCY_CODE, \r\n"
			+ "B.PRIMARY_SOL_ID, C.SOL_DESC, A.CORPORATE_NAME FROM tradefinance A \r\n"
			+ "JOIN accounts B ON A.ORGKEY = B.ORGKEY AND A.CORP_ID = B.CORP_ID \r\n"
			+ "JOIN sol C ON B.PRIMARY_SOL_ID = C.SOL_ID JOIN gam D ON B.ORGKEY = D.CIF_ID \r\n"
			+ "WHERE D.CIF_ID = ?1", nativeQuery = true)
	List<Object[]> gettrad(String cifId);

	/* query to get Employee Details for cust - raji */

	@Query(value = "SELECT DISTINCT c.cif_id, c.foracid,a.sol_id, b.sol_desc, a.emp_id, "
			+ "c.acct_name AS name, a.emp_desig, a.emp_email_id " + "FROM get a " + "JOIN sol b ON a.sol_id = b.sol_id "
			+ "INNER JOIN gam c ON c.emp_id = a.emp_id " + "WHERE c.cif_id = ?1 "
			+ "AND c.cif_id IS NOT NULL", nativeQuery = true)
	List<Object[]> getemploye(String cif_id);

	/* query to get Document Details for cust - raji */
	@Query(value = "SELECT DISTINCT A.ORGKEY, B.NAME, A.ENTITYDOCUMENTID, A.DOCCODE, "
			+ "A.DOCDESCR, A.REFERENCENUMBER, A.DOCTYPECODE, A.DOCTYPEDESCR, "
			+ "A.COUNTRYOFISSUE, A.DOCISSUEDATE, A.DOCRECEIVEDDATE FROM entitydocument A "
			+ "JOIN accounts B ON A.ORGKEY = B.ORGKEY " + "JOIN gam C ON A.ORGKEY = C.CIF_ID " + "WHERE C.CIF_ID = ?1 "
			+ "AND C.CIF_ID IS NOT NULL", nativeQuery = true)
	List<Object[]> getdocument(String cif_id);

	/* query to get Account details for cust profile - raji */
	@Query(value = "SELECT DISTINCT E.ORGKEY, A.Cust_Id, A.FORACID,  A.ACCT_NAME,A.Sol_id, "
			+ "    B.Sol_Desc, A.GL_Sub_Head_CODE, C.GL_Sub_Head_desc, A.Acct_crncy_code, "
			+ "    A.Schm_code, D.Schm_Desc, A.Schm_Type, A.ACCT_OPN_DATE, " + "    A.CLR_BAL_AMT FROM gam A "
			+ "JOIN sol B ON A.SOL_ID = B.SOL_ID " + "INNER JOIN gsh C ON A.GL_Sub_Head_CODE = C.GL_Sub_Head_CODE "
			+ "INNER JOIN gsp D ON A.Schm_code = D.Schm_code " + "INNER JOIN accounts E ON A.CIF_ID = E.ORGKEY "
			+ "WHERE A.CIF_ID = ?1 " + "AND A.CIF_ID IS NOT NULL", nativeQuery = true)
	List<Object[]> getaccts(String cif_id);

	/* query to get Transaction details for cust - raji */
	@Query(value = "SELECT DISTINCT C.CIF_ID, TRIM(A.Tran_Id) AS Tran_Id , A.Tran_Date, A.Tran_Type, \r\n"
			+ "				  A.PART_TRAN_TYPE, A.PART_TRAN_SRL_NUM, A.Tran_sub_Type, A.TRAN_AMT, \r\n"
			+ "			   A.TRAN_RMKS, A.TRAN_PARTICULAR, A.Tr_Status FROM  htdt A JOIN \r\n"
			+ "			   dtd B ON A.Tran_Id = B.Tran_Id INNER JOIN     gam C ON A.ACID = C.ACID\r\n"
			+ "			WHERE CIF_ID IS NOT NULL  AND C.CIF_ID =?1", nativeQuery = true)
	List<Object[]> gettrans(@Param("cifId") String cifId);

	/* query to get Transaction details for cust - raji */
	/*
	 * @Query(value = "SELECT DISTINCT \r\n" +
	 * "    TRIM(A.Tran_Id) AS Tran_Id, \r\n" + "    A.Tran_Date, \r\n" +
	 * "    A.Tran_Type, \r\n" + "    A.PART_TRAN_TYPE, \r\n" +
	 * "    A.PART_TRAN_SRL_NUM, \r\n" + "    A.Tran_sub_Type, \r\n" +
	 * "    A.TRAN_AMT, \r\n" + "    A.TRAN_RMKS, \r\n" +
	 * "    A.TRAN_PARTICULAR, \r\n" + "    A.Tr_Status \r\n" + "FROM \r\n" +
	 * "    htdt A \r\n" + "JOIN \r\n" + "    dtd B \r\n" +
	 * "    ON TRIM(A.Tran_Id) = TRIM(B.Tran_Id) \r\n" + "INNER JOIN \r\n" +
	 * "    gam C \r\n" + "    ON A.ACID = C.ACID \r\n" + "WHERE \r\n" +
	 * "    TRIM(A.Tran_Id) =?1", nativeQuery = true) List<Object[]>
	 * gettransaction(@Param("tranId") String tranId);
	 */

	/* query to get Transaction details for cust - raji */
	@Query(value = "SELECT DISTINCT  \r\n" + "    C.Cif_id,  \r\n" + "    TRIM(A.Tran_Id) AS Tran_Id,     \r\n"
			+ "    A.Tran_Date, \r\n" + "    A.Tran_Type,     \r\n" + "    A.PART_TRAN_TYPE,    \r\n"
			+ "    A.PART_TRAN_SRL_NUM,\r\n" + "    A.Tran_sub_Type,    \r\n" + "    A.TRAN_AMT,     \r\n"
			+ "    A.TRAN_RMKS, \r\n" + "    A.TRAN_PARTICULAR,    \r\n" + "    A.Tr_Status \r\n" + "FROM     \r\n"
			+ "    htdt A \r\n" + "JOIN     \r\n" + "    dtd B    \r\n" + "    ON TRIM(A.Tran_Id) = TRIM(B.Tran_Id)\r\n"
			+ "INNER JOIN     \r\n" + "    gam C   \r\n" + "    ON A.ACID = C.ACID\r\n" + "WHERE  \r\n"
			+ "    C.cif_id IS NOT NULL\r\n" + "    AND (TRIM(A.TRAN_ID) =?1)", nativeQuery = true)
	List<Object[]> gettransaction(@Param("tranId") String tranId);

	/* query to get Sign details for cust - raji */
	@Query(value = "SELECT  a.cif_id,  b.SOL_ID, c.sol_desc,"
			+ "			  a.acct_name AS name, b.cust_id, b.SIGN_POWER_NUM,"
			+ "			 b.SIGN_LENGTH,b.SIGN_AREA, b.CAPTURE_DATE, b.EXPIRY_DATE FROM imt b "
			+ "             INNER JOIN  sol c ON b.SOL_ID = c.SOL_ID"
			+ "			INNER JOIN    gam a ON a.acid = b.acid" + "			WHERE a.cif_id =?1", nativeQuery = true)
	List<Object[]> getsignature(String cif_id);

	/* query to get photo details for cust - raji */
	@Query(value = "SELECT \r\n" + "    a.foracid,\r\n" + "    b.SOL_ID,\r\n" + "    c.sol_desc,\r\n"
			+ "    a.acct_name AS name,\r\n" + "    b.cust_id,\r\n" + "    b.KEY_WORD,\r\n" + "    b.IMAGE_SRL_NUM,\r\n"
			+ "    b.IMAGE_ACCESS_CODE,\r\n" + "    b.CAPTURE_DATE,\r\n" + "    b.EXPIRY_DATE\r\n" + "FROM \r\n"
			+ "    imt b\r\n" + "INNER JOIN \r\n" + "    sol c ON b.SOL_ID = c.SOL_ID\r\n" + "INNER JOIN \r\n"
			+ "    gam a ON a.acid = b.acid\r\n" + "where a.cif_id =?1", nativeQuery = true)
	List<Object[]> getpic(String cif_id);

	/* query to get JointHolder details for cust - raji */
	@Query(value = "SELECT DISTINCT\r\n" + "    C.ORGKEY,\r\n" + "    C.NAME,\r\n" + "    B.JOINT_NAME1,\r\n"
			+ "    B.JOINT_NAME2,\r\n" + "    B.JOINT_PAN_1,\r\n" + "    B.JOINT_PAN_2,\r\n"
			+ "    A.JOINT_HOLDER_CUST_ID\r\n" + "FROM \r\n" + "    ccgt A\r\n" + "JOIN \r\n" + "    mhrt B \r\n"
			+ "    ON A.SCHM_CODE = B.SCHEME_CODE\r\n" + "JOIN \r\n" + "    accounts C  \r\n"
			+ "    ON B.JOINT_NAME1 = C.NAME\r\n" + "JOIN  \r\n" + "    gam D \r\n" + "    ON C.ORGKEY = D.CIF_ID\r\n"
			+ "WHERE C.ORGKEY=?1", nativeQuery = true)
	List<Object[]> getjoint(String cif_id);

	/* query to get Associate details for cust - raji */
	@Query(value = "SELECT  distinct\r\n" + "    B.ORGKEY, \r\n" + "    B.NAME, \r\n" + "    A.ASSOCIATIONID \r\n"
			+ "FROM \r\n" + "    associations A  \r\n" + "JOIN \r\n" + "    accounts B \r\n"
			+ "    ON A.ASSOCIATIONID = B.ACCOUNTID\r\n" + "JOIN \r\n" + "    gam C\r\n"
			+ "    ON B.ORGKEY = C.CIF_ID\r\n" + "WHERE \r\n" + "    B.ORGKEY =?1", nativeQuery = true)
	List<Object[]> getassociate(String cif_id);

	/* query to get Associate details for cust - raji */
	/*
	 * @Query(value = "SELECT  distinct\r\n" + "    B.ORGKEY, \r\n" +
	 * "    B.NAME, \r\n" + "    A.ASSOCIATIONID \r\n" + "FROM \r\n" +
	 * "    associations A  \r\n" + "JOIN \r\n" + "    accounts B \r\n" +
	 * "    ON A.ASSOCIATIONID = B.ACCOUNTID\r\n" + "JOIN \r\n" + "    gam C\r\n" +
	 * "    ON B.ORGKEY = C.CIF_ID\r\n" + "WHERE \r\n" + "    B.ORGKEY =?1",
	 * nativeQuery = true) List<Object[]> getassociate(String cif_id);
	 */
	/* query to get TRADEFLAG details for cust - raji */
	@Query(value = "SELECT DISTINCT\r\n" + "B.ORGKEY,\r\n" + "B.CUST_TYPE,\r\n" + "B.NAME,\r\n" + "A.BILL_ID,\r\n"
			+ "A.REG_TYPE,\r\n" + "A.BILL_DATE,\r\n" + "A.BILL_CRNCY_CODE,\r\n" + "A.BILL_AMT,\r\n"
			+ "A.DUE_DATE FROM\r\n" + "fbm A\r\n" + "JOIN accounts B ON A.SOL_ID = B.PRIMARY_SOL_ID\r\n"
			+ "JOIN    gam C\r\n" + " ON B.ORGKEY = C.CIF_ID\r\n" + "WHERE  B.ORGKEY =?1", nativeQuery = true)
	List<Object[]> gettradflg(String cif_id);

	@Query(value = "\r\n" + "SELECT DISTINCT B.ORGKEY,B.CUST_TYPE,B.NAME,A.BILL_ID,\r\n"
			+ "A.REG_TYPE,A.BILL_DATE,A.BILL_CRNCY_CODE,A.BILL_AMT,\r\n" + "A.DUE_DATE FROM fbm A\r\n"
			+ "JOIN accounts B ON A.SOL_ID = B.PRIMARY_SOL_ID JOIN    gam C\r\n" + "ON B.ORGKEY = C.CIF_ID \r\n"
			+ "WHERE B.ORGKEY =?1 AND A.BILL_ID =?2", nativeQuery = true)
	List<Object[]> gettradEflg(String cif_id, String billId);

	/* query to get bank guarantee for cust - raji */
	@Query(value = "select DISTINCT B.ORGKEY,B.NAME,A.BG_SRL_NUM,A.cust_id,A.bg_type,A.issue_date,A.bg_expiry_date,A.bg_perd_mths,\r\n"
			+ "A.bg_perd_days,A.bg_amt from bgm A JOIN accounts B ON A.SOL_ID = B.PRIMARY_SOL_ID JOIN    gam C\r\n"
			+ "ON B.ORGKEY = C.CIF_ID WHERE B.ORGKEY =?1", nativeQuery = true)
	List<Object[]> getbankflg(String cif_id);

	/* query to get bank guarantee for acct - raji */
	@Query(value = "select B.ORGKEY,C.FORACID,A.BG_SRL_NUM,A.cust_id,A.bg_type,A.issue_date,A.bg_expiry_date,A.bg_perd_mths,\r\n"
			+ "A.bg_perd_days,A.bg_amt from bgm A JOIN accounts B ON A.SOL_ID = B.PRIMARY_SOL_ID JOIN    gam C\r\n"
			+ "ON B.ORGKEY = C.CIF_ID WHERE B.ORGKEY =?1 AND C.FORACID=?2", nativeQuery = true)
	List<Object[]> getbankflag(String cifId, String acctNo);

	/* query to get letter of credit for cust - raji */
	@Query(value = "select DISTINCT C.ORGKEY,C.NAME,B.DC_ID,A.dc_ref_num,open_value,current_value,dc_tol_avail_amt from dcmm A\r\n"
			+ "JOIN dit B ON A.dc_ref_num = B.dc_ref_num JOIN accounts C ON A.SOL_ID = C.PRIMARY_SOL_ID \r\n"
			+ "JOIN gam D ON C.ORGKEY = D.CIF_ID WHERE C.ORGKEY =?1", nativeQuery = true)
	List<Object[]> getLetofcredit(String cif_id);

	/* query to get letter of credit for cust - raji */
	@Query(value = "select DISTINCT C.ORGKEY,C.NAME,B.DC_ID,A.dc_ref_num,open_value,current_value,dc_tol_avail_amt from dcmm A\r\n"
			+ "JOIN dit B ON A.dc_ref_num = B.dc_ref_num JOIN accounts C ON A.SOL_ID = C.PRIMARY_SOL_ID \r\n"
			+ "JOIN gam D ON C.ORGKEY = D.CIF_ID WHERE C.ORGKEY =?1", nativeQuery = true)
	List<Object[]> getLetofcreditS(String cif_id);
	/*
	 * @Query(value =
	 * "select orgkey,NAME,NAT_ID_CARD_NUM,PHONE from accounts where orgkey ='10000017' or NAT_ID_CARD_NUM= ''"
	 * , nativeQuery = true) List<Object[]> getcrm(@Param("cifId") String cifId);
	 */

	/*--------------DATA QUALITY-------------*/

	/*-------------corporateretail all customer-------------*/

	@Query(value = "SELECT \r\n" + "    NAT_ID_CARD_NUM," + "    COUNT(DISTINCT orgkey) AS orgkey_count\r\n"
			+ "FROM \r\n" + "    accounts\r\n" + "WHERE \r\n" + "    NAT_ID_CARD_NUM IS NOT NULL\r\n"
			+ "    AND NAT_ID_CARD_NUM IN (\r\n" + "        SELECT NAT_ID_CARD_NUM\r\n" + "        FROM accounts\r\n"
			+ "        WHERE NAT_ID_CARD_NUM IS NOT NULL\r\n" + "        GROUP BY NAT_ID_CARD_NUM\r\n"
			+ "        HAVING COUNT(DISTINCT orgkey) > 1\r\n" + "    )\r\n" + "GROUP BY \r\n"
			+ "    NAT_ID_CARD_NUM", nativeQuery = true)
	List<Object[]> getAll();

	@Query(value = "SELECT \r\n" + "  NAT_ID_CARD_NUM, TRIM(CUST_FIRST_NAME || ' ' || CUST_LAST_NAME) AS NAME,\r\n"
			+ "    orgkey\r\n" + "FROM \r\n" + "    accounts\r\n" + "WHERE \r\n"
			+ "    NAT_ID_CARD_NUM =?1", nativeQuery = true)
	List<Object[]> getcif(String natIdCardNum);

	/*----------------------retail customer------------*/

	@Query(value = "SELECT NAT_ID_CARD_NUM, COUNT(DISTINCT ORGKEY) \r\n"
			+ "    FROM accounts WHERE NAT_ID_CARD_NUM IS NOT NULL \r\n"
			+ "        AND TABVALIDATOR = 'Retail_Customer_GE=Y|Retail_Customer_DE=Y' \r\n"
			+ "        GROUP BY NAT_ID_CARD_NUM \r\n"
			+ "    HAVING COUNT(DISTINCT ORGKEY) > 1", nativeQuery = true)
	List<Object[]> getRetailCustomers();

	/*
	 * @Query(value =
	 * "SELECT   NAT_ID_CARD_NUM, TRIM(CUST_FIRST_NAME || ' ' || CUST_LAST_NAME) AS NAME,\r\n"
	 * + "    		 orgkey FROM    CRMUSER.ACCOUNTS WHERE \r\n" +
	 * "	              (orgkey LIKE 'R%' OR orgkey LIKE 'C%')\r\n" +
	 * "	  		 And NAT_ID_CARD_NUM =?1", nativeQuery = true) List<Object[]>
	 * getcifRetail(String natIdCardNum);
	 */

	@Query(value = "SELECT NAT_ID_CARD_NUM,    TRIM(CUST_FIRST_NAME || ' ' || CUST_LAST_NAME) AS NAME,\r\n"
			+ "  orgkey FROM accounts WHERE NAT_ID_CARD_NUM =?", nativeQuery = true)
	List<Object[]> getcifRetail(String natIdCardNum);

	/*----------------------corporate customer------------*/
	@Query(value = "SELECT DISTINCT NAT_ID_CARD_NUM,\r\n"
			+ "       COUNT(DISTINCT orgkey) OVER (PARTITION BY NAT_ID_CARD_NUM) AS orgkey_count\r\n"
			+ "FROM accounts\r\n" + "WHERE NAT_ID_CARD_NUM IS NOT NULL  \r\n" + "  AND NAT_ID_CARD_NUM IN (\r\n"
			+ "      SELECT NAT_ID_CARD_NUM\r\n" + "      FROM accounts \r\n"
			+ "      WHERE NAT_ID_CARD_NUM IS NOT NULL\r\n" + "      GROUP BY NAT_ID_CARD_NUM\r\n"
			+ "      HAVING COUNT(DISTINCT orgkey) > 1\r\n" + "  ) \r\n"
			+ "  AND REGEXP_LIKE(orgkey, '^[0-9]')", nativeQuery = true)
	List<Object[]> getCorporateCustomers();

	@Query(value = "SELECT  \r\n" + "    NAT_ID_CARD_NUM, \r\n"
			+ "    TRIM(CUST_FIRST_NAME || ' ' || CUST_LAST_NAME) AS NAME,\r\n" + "    orgkey \r\n" + "FROM    \r\n"
			+ "    accounts \r\n" + "WHERE\r\n" + "    NAT_ID_CARD_NUM =?1 \r\n"
			+ "    AND REGEXP_LIKE(orgkey, '^[0-9]')", nativeQuery = true)
	List<Object[]> getcifall(String natIdCardNum);

	/*-------------customer name Back record-----------*/
	@Query(value = "SELECT \r\n" + "    ORGKEY, \r\n" + "    SALUTATION, \r\n" + "    cust_first_name, \r\n"
			+ "    cust_middle_name, \r\n" + "    cust_last_name, \r\n" + "    name, \r\n" + "    TRIM(\r\n"
			+ "        CASE \r\n"
			+ "            WHEN cust_first_name IS NULL THEN 'First Name is Empty, ' ELSE '' END ||\r\n"
			+ "        CASE \r\n"
			+ "            WHEN cust_middle_name IS NULL THEN 'Middle Name is Empty, ' ELSE '' END ||\r\n"
			+ "        CASE \r\n"
			+ "            WHEN cust_last_name IS NULL THEN 'Last Name is Empty, ' ELSE '' END ||\r\n"
			+ "        CASE \r\n"
			+ "            WHEN LENGTH(cust_first_name) = 1 OR LENGTH(cust_middle_name) = 1 OR LENGTH(cust_last_name) = 1 THEN 'Single character in name, ' ELSE '' END ||\r\n"
			+ "        CASE \r\n"
			+ "            WHEN TRIM(cust_first_name || ' ' || cust_middle_name || ' ' || cust_last_name) != TRIM(NAME) THEN 'Name discrepancy found ' ELSE '' END ||\r\n"
			+ "        CASE \r\n"
			+ "            WHEN SALUTATION IS NOT NULL AND LENGTH(SALUTATION) = 1 THEN 'Salutation has a single character, ' ELSE '' END ||\r\n"
			+ "        CASE \r\n" + "            WHEN \r\n"
			+ "                (cust_first_name IS NOT NULL OR cust_middle_name IS NOT NULL OR cust_last_name IS NOT NULL)\r\n"
			+ "                AND TRIM(cust_first_name || ' ' || cust_middle_name || ' ' || cust_last_name) = TRIM(NAME)\r\n"
			+ "            THEN 'Name matches' ELSE '' \r\n" + "        END\r\n" + "    ) AS Remarks\r\n"
			+ "FROM accounts \r\n" + "WHERE \r\n"
			+ "    NOT (cust_first_name = name AND cust_middle_name = name AND cust_last_name = name) \r\n"
			+ "    AND (\r\n" + "        LENGTH(cust_first_name) = 1 \r\n"
			+ "        OR LENGTH(cust_middle_name) = 1 \r\n" + "        OR LENGTH(cust_last_name) = 1 \r\n"
			+ "        OR LENGTH(SALUTATION) = 1 \r\n" + "        OR SALUTATION IS NOT NULL\r\n"
			+ "    )", nativeQuery = true)
	List<Object[]> getName();

	/*-------------customer name1 As passport-----------*/
	@Query(value = "SELECT     ORGKEY,   SALUTATION,\r\n"
			+ "			   SUBSTR(PSPRT_DET, 1, 6) AS first_name,   SUBSTR(PSPRT_DET, 7, 6) AS middle_name,\r\n"
			+ "			   SUBSTR(PSPRT_DET, 13, 6) AS last_name,    PSPRT_DET ,\r\n" + "            CASE \r\n"
			+ "			    WHEN LENGTH(SUBSTR(PSPRT_DET, 1, 6)) = 1 \r\n"
			+ "			    OR LENGTH(SUBSTR(PSPRT_DET, 7, 6)) = 1 \r\n"
			+ "			    OR LENGTH(SUBSTR(PSPRT_DET, 13, 10)) = 1 THEN 'Single character'\r\n"
			+ "			   WHEN LENGTH(SUBSTR(PSPRT_DET, 1, 6)) <=5  \r\n"
			+ "			  OR LENGTH(SUBSTR(PSPRT_DET, 7, 6)) <=5 \r\n"
			+ "			      OR LENGTH(SUBSTR(PSPRT_DET, 13, 10)) <=5  THEN 'Less than 6 characters'\r\n"
			+ "			      ELSE 'Invalid'     END AS Remarks   FROM \r\n"
			+ "			  accounts WHERE     PSPRT_DET = NAME\r\n"
			+ "			  AND PSPRT_DET IS NOT NULL    AND LENGTH(PSPRT_DET) > 6\r\n"
			+ "			 AND (LENGTH(SALUTATION) > 1\r\n"
			+ "			 OR REGEXP_LIKE(SALUTATION, '^[^0-9]+$'))", nativeQuery = true)
	List<Object[]> getName1();

	/*-------------customer nameMISMATCH-----------*/
	@Query(value = "SELECT DISTINCT \r\n"
			+ "    A.ORGKEY, A.SALUTATION, A.name AS bankrecord, \r\n"
			+ "    SUBSTR(A.name, 1, 6) AS first_name, \r\n"
			+ "    SUBSTR(A.name, 7, 6) AS middle_name, \r\n"
			+ "    SUBSTR(A.name, 13, 10) AS last_name, \r\n"
			+ "    A.PSPRT_DET AS PASSPORTNAME, \r\n"
			+ "    SUBSTR(A.PSPRT_DET, 1, 6) AS Psfirst_name, \r\n"
			+ "    SUBSTR(A.PSPRT_DET, 7, 6) AS Psmid_name, \r\n"
			+ "    SUBSTR(A.PSPRT_DET, 13, 10) AS Pslast_name, \r\n"
			+ "    'Name Mismatch' AS Remarks\r\n"
			+ "FROM accounts A \r\n"
			+ "WHERE A.SALUTATION IS NOT NULL \r\n"
			+ "  AND A.NAME IS NOT NULL \r\n"
			+ "  AND LENGTH(A.name) > 6 \r\n"
			+ "  AND (LENGTH(A.SALUTATION) = 1 OR REGEXP_LIKE(A.SALUTATION, '^[^0-9]+$')) \r\n"
			+ "  AND (A.NAME != A.PSPRT_DET OR A.PSPRT_DET IS NULL)\r\n"
			+ "\r\n"
			+ "UNION ALL\r\n"
			+ "\r\n"
			+ "SELECT DISTINCT \r\n"
			+ "    B.ORGKEY, B.SALUTATION, B.name AS bankrecord, \r\n"
			+ "    SUBSTR(B.name, 1, 6) AS first_name, \r\n"
			+ "    SUBSTR(B.name, 7, 6) AS middle_name, \r\n"
			+ "    SUBSTR(B.name, 13, 10) AS last_name, \r\n"
			+ "    B.PSPRT_DET AS PASSPORTNAME, \r\n"
			+ "    SUBSTR(B.PSPRT_DET, 1, 6) AS Psfirst_name, \r\n"
			+ "    SUBSTR(B.PSPRT_DET, 7, 6) AS Psmid_name, \r\n"
			+ "    SUBSTR(B.PSPRT_DET, 13, 10) AS Pslast_name, \r\n"
			+ "    'Name Mismatch' AS Remarks\r\n"
			+ "FROM accounts B \r\n"
			+ "WHERE B.SALUTATION IS NOT NULL \r\n"
			+ "  AND LENGTH(B.PSPRT_DET) > 6 \r\n"
			+ "  AND (LENGTH(B.SALUTATION) = 1 OR REGEXP_LIKE(B.SALUTATION, '^[^0-9]+$')) \r\n"
			+ "  AND NOT EXISTS (\r\n"
			+ "    SELECT 1 \r\n"
			+ "    FROM accounts C \r\n"
			+ "    WHERE C.ORGKEY = B.ORGKEY \r\n"
			+ "      AND C.SALUTATION != B.SALUTATION \r\n"
			+ "      AND C.name != B.PSPRT_DET \r\n"
			+ "      AND LENGTH(C.name) > 6 \r\n"
			+ "      AND (LENGTH(C.SALUTATION) = 1 OR REGEXP_LIKE(C.SALUTATION, '^[^0-9]+$'))\r\n"
			+ "  )\r\n"
			+ "  AND (B.NAME != B.PSPRT_DET OR B.PSPRT_DET IS NULL)", nativeQuery = true)
	List<Object[]> getcustName();

	/*-------------------placeofbirth-------------*/
	@Query(value = "SELECT   ORGKEY,  NAME,   PLACEOFBIRTH FROM accounts\r\n"
			+ "        WHERE    name is not null    AND PLACEOFBIRTH IS NULL \r\n"
			+ "  OR REGEXP_LIKE(PLACEOFBIRTH, '[0-9]')   OR PLACEOFBIRTH = COUNTRYOFBIRTH", nativeQuery = true)
	List<Object[]> getpob();

	/*--------passport expiry date----------------------*/
	@Query(value = "SELECT \r\n" + "     ORGKEY, \r\n" + "    NAME,   \r\n" + "    PASSPORTNO, \r\n"
			+ "    PSPRT_ISSUE_DATE,   \r\n" + "    PSPRT_EXP_DATE,   \r\n" + "    CASE \r\n"
			+ "        WHEN PSPRT_EXP_DATE IS NULL THEN 'Passport Expiry Date is Empty'\r\n"
			+ "        WHEN PSPRT_ISSUE_DATE IS NULL THEN 'Passport Issue Date is Empty'\r\n"
			+ "        WHEN PSPRT_ISSUE_DATE > CURRENT_DATE THEN 'Passport Issue Date is in the Future'\r\n"
			+ "        WHEN EXTRACT(YEAR FROM PSPRT_EXP_DATE) < EXTRACT(YEAR FROM PSPRT_ISSUE_DATE) + 10 THEN 'Passport Expiry Date is less than 10 years from Issue Date'\r\n"
			+ "        WHEN PSPRT_EXP_DATE > PSPRT_ISSUE_DATE + INTERVAL '10' YEAR THEN 'Passport Expiry Date exceeds 10 years validity'\r\n"
			+ "        WHEN PSPRT_EXP_DATE < CURRENT_DATE THEN 'Passport Expired'\r\n"
			+ "        ELSE 'Valid Passport '\r\n" + "    END AS Remarks  \r\n" + "FROM accounts\r\n"
			+ "WHERE PASSPORTNO  IS NOT NULL and (\r\n"
			+ "  EXTRACT(YEAR FROM PSPRT_EXP_DATE) < EXTRACT(YEAR FROM PSPRT_ISSUE_DATE) + 10  or\r\n"
			+ " PSPRT_EXP_DATE <= PSPRT_ISSUE_DATE + INTERVAL '10' YEAR or PSPRT_EXP_DATE  IS  NULL\r\n"
			+ "or PSPRT_ISSUE_DATE > CURRENT_DATE or PSPRT_ISSUE_DATE  IS  NULL\r\n"
			+ "or PSPRT_EXP_DATE < CURRENT_DATE)", nativeQuery = true)
	List<Object[]> getPass();

	/*------------Passno-----------*/

	@Query(value = "SELECT \r\n" + "    ORGKEY, \r\n" + "    NAME, \r\n" + "    PASSPORTNO,\r\n" + "    CASE\r\n"
			+ "        WHEN REGEXP_LIKE(PASSPORTNO, '(.)\\1{1,}') THEN 'Repetition of characters/digits'\r\n"
			+ "        WHEN REGEXP_LIKE(PASSPORTNO, '(012|123|234|345|456|567|678|789|890|ABC|BCD|CDE|DEF|EFG|FGH|GHI|HIJ|IJK|JKL|KLM|LMN|MNO|NOP|OPQ|PQR|QRS|RST|STU|TUV|UVW|VWX|WXY|XYZ)', 'i') THEN 'Consecutive characters/digits'\r\n"
			+ "    END AS REMARKS\r\n" + "FROM accounts  \r\n" + "WHERE PASSPORTNO IS NOT NULL \r\n"
			+ "    AND (REGEXP_LIKE(PASSPORTNO, '(.)\\1{1,}')\r\n"
			+ "         OR REGEXP_LIKE(PASSPORTNO, '(012|123|234|345|456|567|678|789|890|ABC|BCD|CDE|DEF|EFG|FGH|GHI|HIJ|IJK|JKL|KLM|LMN|MNO|NOP|OPQ|PQR|QRS|RST|STU|TUV|UVW|VWX|WXY|XYZ)', 'i'))", nativeQuery = true)
	List<Object[]> getPassno();

	/*------------Country of Residency-----------*/
	@Query(value = "SELECT  B.ORGKEY,  B.NAME, A.RESIDENCE_COUNTRY,  B.CUSTOMERNREFLG FROM demographic A\r\n"
			+ "			JOIN accounts B ON A.ORGKEY = B.ORGKEY WHERE A.RESIDENCE_COUNTRY IS NULL \r\n"
			+ "			OR A.RESIDENCE_COUNTRY IN ('N/A', 'Others')", nativeQuery = true)
	List<Object[]> getCountRes();

	/*------------MarkerofEmployed-----------*/
	@Query(value = "SELECT  \r\n" + "    A.ORGKEY,   \r\n" + "    D.EMPLOYERID,   \r\n" + "    D.EMPLOYERSNAME,\r\n"
			+ "    D.SOURCEOFINCOME,\r\n" + "    D.EMPLOYMENT_STATUS,\r\n" + "    CASE\r\n"
			+ "        WHEN D.EMPLOYMENT_STATUS = 'Unemployed' \r\n" + "             AND D.EMPLOYERID IS NULL \r\n"
			+ "             AND D.EMPLOYERSNAME IS NULL\r\n" + "         THEN 'Customer is UnEmployed'\r\n" + "\r\n"
			+ " WHEN D.EMPLOYMENT_STATUS = 'Unemployed' \r\n" + "             and (D.EMPLOYERID IS not  NULL \r\n"
			+ "             or D.EMPLOYERSNAME IS not NULL)\r\n"
			+ "            THEN 'Customer is UnEmployed but Emloyement Details is available'\r\n"
			+ " WHEN D.EMPLOYMENT_STATUS IN ('Employed', 'Self employed') \r\n"
			+ "             and (D.EMPLOYERID IS NULL \r\n" + "             or D.EMPLOYERSNAME IS NULL )\r\n"
			+ "            THEN 'Employed but Employer ID or Employer Name is Missing'\r\n"
			+ "        ELSE 'No Employment Status'\r\n" + "    END AS REMARKS\r\n" + "FROM accounts A  \r\n"
			+ "JOIN demographic D  \r\n" + "ON A.ORGKEY = D.ORGKEY  \r\n" + "WHERE \r\n"
			+ " D.EMPLOYMENT_STATUS IS NOT NULL   \r\n" + " OR (\r\n"
			+ "  (D.EMPLOYMENT_STATUS = 'Employed' AND D.EMPLOYERID IS NULL)  \r\n" + "  OR\r\n"
			+ "  (D.EMPLOYMENT_STATUS = 'Unemployed' AND D.EMPLOYERID IS NOT NULL)\r\n" + " )", nativeQuery = true)
	List<Object[]> getMrkEmp();

	/*------------Employers name-----------*/
	@Query(value = "SELECT A.ORGKEY,D.EMPLOYERID,D.EMPLOYERSNAME\r\n"
			+ "FROM accounts A,demographic D WHERE A.ORGKEY = D.ORGKEY\r\n"
			+ "AND D.EMPLOYERSNAME IS NULL", nativeQuery = true)
	List<Object[]> getEmpname();

	/*------------Residencyaddress-----------*/
	@Query(value = "SELECT  distinct ORGKEY,Name, STREET_NAME FROM address\r\n"
			+ "			WHERE STREET_NAME IS NULL  And ACCOUNTID IS NOT NULL\r\n"
			+ "			   OR TRIM(STREET_NAME) = ''   OR STREET_NAME IN ('N/A', 'Others')", nativeQuery = true)
	List<Object[]> getResadd();

	/*------------poboxpostal code-----------*/
	@Query(value = "SELECT ORGKEY,NAME,ZIP FROM accounts WHERE name is not null\r\n" + "  and ZIP IS NULL\r\n"
			+ "  OR TRIM(ZIP) ='' OR ZIP IN ('N/A', 'Others')", nativeQuery = true)
	List<Object[]> getpostal();

	/*------------Customerrisk rating-----------*/
	@Query(value = " SELECT  orgkey,name,RISKRATING,CUSTOMERNREFLG  FROM accounts  WHERE name IS not NULL\r\n"
			+ "    OR TRIM(RISKRATING) =''  and RISKRATING IN ('SEVERE','HIGH','MODERATE','LOW')", nativeQuery = true)
	List<Object[]> getriskrate();

	/*------------PHONE-----------*/
	@Query(value = "SELECT DISTINCT  A.ORGKEY,  A.NAME,   A.PHONE,PREFERRED_MOBILE_ALERT_TYPE,\r\n"
			+ "A.COUNTRY,  TRIM(BOTH '|' FROM   (CASE  WHEN \r\n"
			+ " (A.COUNTRY NOT IN ('AE', 'IN', 'US', 'GB', 'NP', 'NEPAL', 'AU', 'DE', 'FR', 'CA', 'JP', 'ZA', 'BR'))\r\n"
			+ " OR (A.COUNTRY = 'AE' AND NOT ((A.PHONE LIKE '+971%' AND LENGTH(A.PHONE) = 13) OR LENGTH(REPLACE(A.PHONE, '+971', '')) = 9))\r\n"
			+ " OR (A.COUNTRY = 'IN' AND NOT ((A.PHONE LIKE '+91%' AND LENGTH(A.PHONE) = 13) OR LENGTH(REPLACE(A.PHONE, '+91', '')) = 10))\r\n"
			+ " OR (A.COUNTRY = 'US' AND NOT ((A.PHONE LIKE '+1%' AND LENGTH(A.PHONE) = 12) OR LENGTH(REPLACE(A.PHONE, '+1', '')) = 10)) \r\n"
			+ " OR (A.COUNTRY = 'GB' AND NOT ((A.PHONE LIKE '+44%' AND LENGTH(A.PHONE) = 13) OR LENGTH(REPLACE(A.PHONE, '+44', '')) = 10))\r\n"
			+ "  OR (A.COUNTRY IN ('NP', 'NEPAL') AND NOT ((A.PHONE LIKE '+977%' AND LENGTH(A.PHONE) = 13) OR LENGTH(REPLACE(A.PHONE, '+977', '')) = 9))\r\n"
			+ " OR (A.COUNTRY = 'AU' AND NOT ((A.PHONE LIKE '+61%' AND LENGTH(A.PHONE) = 12) OR LENGTH(REPLACE(A.PHONE, '+61', '')) = 9))\r\n"
			+ "  OR (A.COUNTRY = 'DE' AND NOT ((A.PHONE LIKE '+49%' AND LENGTH(A.PHONE) = 13) OR LENGTH(REPLACE(A.PHONE, '+49', '')) = 9))\r\n"
			+ "  OR (A.COUNTRY = 'FR' AND NOT ((A.PHONE LIKE '+33%' AND LENGTH(A.PHONE) = 12) OR LENGTH(REPLACE(A.PHONE, '+33', '')) = 9))\r\n"
			+ "  OR (A.COUNTRY = 'CA' AND NOT ((A.PHONE LIKE '+1%' AND LENGTH(A.PHONE) = 12) OR LENGTH(REPLACE(A.PHONE, '+1', '')) = 10))\r\n"
			+ "  OR (A.COUNTRY = 'JP' AND NOT ((A.PHONE LIKE '+81%' AND LENGTH(A.PHONE) = 12) OR LENGTH(REPLACE(A.PHONE, '+81', '')) = 9)) \r\n"
			+ "  OR (A.COUNTRY = 'ZA' AND NOT ((A.PHONE LIKE '+27%' AND LENGTH(A.PHONE) = 12) OR LENGTH(REPLACE(A.PHONE, '+27', '')) = 9)) \r\n"
			+ " OR (A.COUNTRY = 'BR' AND NOT ((A.PHONE LIKE '+55%' AND LENGTH(A.PHONE) = 13) OR LENGTH(REPLACE(A.PHONE, '+55', '')) = 9))\r\n"
			+ "THEN 'Invalid phone number format or length based on the country.' ELSE '' END ||\r\n"
			+ "  CASE WHEN REGEXP_LIKE(A.PHONE, '[A-Za-z]') THEN 'Presence of alphabetic characters in the phone number.' ELSE '' END ||\r\n"
			+ " CASE WHEN REGEXP_LIKE(A.PHONE, '[\\\\(\\\\)@\\\\$#]') THEN 'Contains Special Characters.' ELSE '' END ||\r\n"
			+ " CASE WHEN LENGTH(A.PHONE) < 6 THEN 'Phone number too short.' ELSE '' END ||\r\n"
			+ "  CASE WHEN LENGTH(A.PHONE) > 15 THEN 'Phone number too long' ELSE '' END)\r\n"
			+ " ) AS REMARKS  FROM accounts A \r\n" + "JOIN corporate B ON A.PHONE = B.PHONE", nativeQuery = true)
	List<Object[]> getphone();

	/*------------monthsalary-----------*/
	/*
	 * @Query(value =
	 * "SELECT DISTINCT A.ORGKEY, A.NAME, D.EMPLOYMENT_STATUS, A.CRNCY_CODE, D.ANNUAL_SALARY_INCOME / 12 AS MONTHLY_SALARY\r\n"
	 * + "FROM accounts A, demographic D\r\n" +
	 * "WHERE  D.ANNUAL_SALARY_INCOME IS NULL\r\n" +
	 * "  AND (D.EMPLOYMENT_STATUS IS NOT NULL OR D.EMPLOYMENT_STATUS = 'Employed')\r\n"
	 * + "  AND A.CRNCY_CODE = 'AED'", nativeQuery = true) List<Object[]>
	 * getmonth();
	 */

	@Query(value = "SELECT ORGKEY, NAME, EMPLOYMENT_STATUS, CRNCY_CODE,SOURCEOFINCOME, MONTHLY_SALARY\r\n"
			+ "FROM(SELECT A.ORGKEY,A.NAME,D.EMPLOYMENT_STATUS,A.CRNCY_CODE,D.SOURCEOFINCOME,\r\n"
			+ "     D.ANNUAL_SALARY_INCOME / 12 AS MONTHLY_SALARY,\r\n"
			+ "     ROW_NUMBER() OVER (PARTITION BY D.DEMOGRAPHICID ORDER BY D.DEMOGRAPHICID) AS RN\r\n"
			+ "  FROM accounts A INNER JOIN  demographic D\r\n" + " ON A.ORGKEY = D.ORGKEY\r\n"
			+ "  WHERE (D.EMPLOYMENT_STATUS = 'Employed' or D.EMPLOYMENT_STATUS = 'Self employed')\r\n"
			+ "and A.CRNCY_CODE = 'AED'  and ANNUAL_SALARY_INCOME is null)", nativeQuery = true)
	List<Object[]> getmonth();

	/*------------EmiratesID-----------*/
	@Query(value = "SELECT \r\n" + "    A.orgkey,\r\n" + "    A.NAME,\r\n" + "    A.NAT_ID_CARD_NUM,\r\n"
			+ "    B.RESIDENCE_COUNTRY,\r\n" + "    B.NATIONALITY,\r\n" + "    CASE\r\n"
			+ "        WHEN LENGTH(A.NAT_ID_CARD_NUM) != 15 THEN ' Does not have standard length' \r\n"
			+ "        ELSE NULL\r\n" + "    END\r\n" + "    || \r\n" + "    CASE\r\n"
			+ "        WHEN REGEXP_LIKE(A.NAT_ID_CARD_NUM, '(.)\\\\1{1,}') THEN ' Repetition of characters/ digits' \r\n"
			+ "        ELSE NULL\r\n" + "    END\r\n" + "    ||\r\n" + "    CASE\r\n"
			+ "        WHEN REGEXP_LIKE(A.NAT_ID_CARD_NUM, '(012|123|234|345|456|567|678|789|890|ABC|BCD|CDE|DEF|EFG|FGH|GHI|HIJ|IJK|JKL|KLM|LMN|MNO|NOP|OPQ|PQR|QRS|RST|STU|TUV|UVW|VWX|WXY|XYZ)', 'i') THEN ' Consecutive characters/ digits'\r\n"
			+ "        ELSE NULL\r\n" + "    END AS REMARKS\r\n" + "FROM \r\n" + "    accounts A\r\n" + "JOIN \r\n"
			+ "    demographic B ON A.ORGKEY = B.ORGKEY\r\n" + "WHERE \r\n" + "    A.NAT_ID_CARD_NUM IS NOT NULL\r\n"
			+ "    AND B.NATIONALITY = B.RESIDENCE_COUNTRY\r\n" + "    and (\r\n"
			+ "        LENGTH(A.NAT_ID_CARD_NUM) != 15 \r\n"
			+ "        OR REGEXP_LIKE(A.NAT_ID_CARD_NUM, '(.)\\\\1{1,}')\r\n"
			+ "        OR REGEXP_LIKE(A.NAT_ID_CARD_NUM, '(012|123|234|345|456|567|678|789|890|ABC|BCD|CDE|DEF|EFG|FGH|GHI|HIJ|IJK|JKL|KLM|LMN|MNO|NOP|OPQ|PQR|QRS|RST|STU|TUV|UVW|VWX|WXY|XYZ)', 'i')\r\n"
			+ "    )", nativeQuery = true)
	List<Object[]> getEmid();

	/*------------EmiratesIDEXPdate-----------*/
	@Query(value = "select b.NAT_ID_CARD_NUM,DOCCODE,  a.DOCEXPIRYDATE,   a.IDENTIFICATIONTYPE from \r\n"
			+ "entitydocument a,accounts b where DOCCODE='INATR'\r\n"
			+ "AND IDENTIFICATIONTYPE ='National Card Number' and a.orgkey=b.orgkey", nativeQuery = true)
	List<Object[]> getEmiExpDate();

	/*------------1 NATIONALITY-----------*/
	@Query(value = " SELECT A.ORGKEY, B.NAME, A.NATIONALITY ,\r\n" + "    CASE \r\n"
			+ "        WHEN A.NATIONALITY IS NULL OR TRIM(A.NATIONALITY) = '' THEN 'Nationality is Empty'\r\n"
			+ "        WHEN REGEXP_LIKE(A.NATIONALITY, '[^A-Za-z ]') THEN 'Contains numerical/special characters'\r\n"
			+ "        ELSE ''\r\n" + "    END AS REMARKS\r\n" + "    FROM demographic A\r\n"
			+ "        JOIN accounts B ON A.ORGKEY = B.ORGKEY WHERE A.NATIONALITY IS NULL\r\n"
			+ "			OR REGEXP_LIKE(A.NATIONALITY, '[^A-Za-z ]')  \r\n"
			+ "			AND A.NATIONALITY NOT IN ('N/A', 'OTHERS')", nativeQuery = true)
	List<Object[]> getnation();

	
	/*------------2 NATIONALITY-----------*/
	@Query(value = "SELECT \r\n" + "    a.orgkey,\r\n" + "    a.NAME,\r\n" + "    a.CUST_DOB,\r\n"
			+ "    b.nationality,\r\n" + "    a.MINOR_GUARD_NAME\r\n" + "FROM \r\n" + "    accounts a\r\n"
			+ "JOIN \r\n" + "    demographic b ON a.ORGKEY = b.ORGKEY\r\n" + "WHERE \r\n"
			+ "      a.CUST_DOB IS NOT NULL\r\n" + "    and TRUNC(MONTHS_BETWEEN(SYSDATE, a.CUST_DOB) / 12) < 18 \r\n"
			+ "    or b.nationality IS NULL\r\n" + "    or a.MINOR_GUARD_NAME IS NOT NULL", nativeQuery = true)
	List<Object[]> getnation2();

	/*------------CUST_DOB-----------*/
	@Query(value = "SELECT \r\n" + "    orgkey,\r\n" + "    name,\r\n" + "    CUST_DOB,\r\n" + "    \r\n"
			+ "        CASE \r\n" + "            WHEN CUST_DOB IS NULL THEN 'Customer DOB is empty '\r\n"
			+ "            WHEN CUST_DOB > SYSDATE THEN 'Customer DOB is in the future '\r\n" + "    \r\n"
			+ "            WHEN CUST_DOB < ADD_MONTHS(SYSDATE, -80 * 12) THEN 'Customer is a Senior Citizen '\r\n"
			+ "  \r\n" + "            WHEN CUST_DOB > ADD_MONTHS(SYSDATE, -18 * 12) THEN 'Customer is a Minor '\r\n"
			+ "            ELSE ''\r\n" + "        END\r\n" + "     AS Remarks\r\n" + "FROM accounts\r\n"
			+ "WHERE \r\n" + "    name IS NOT NULL\r\n" + "    AND (\r\n" + "        CUST_DOB IS NULL\r\n"
			+ "        OR CUST_DOB > SYSDATE\r\n" + "        OR CUST_DOB < ADD_MONTHS(SYSDATE, -80 * 12)\r\n"
			+ "        OR CUST_DOB > ADD_MONTHS(SYSDATE, -18 * 12)\r\n" + "    )", nativeQuery = true)
	List<Object[]> getcustdob();

	/*------------DUAL NATIONALITY-----------*/
	@Query(value = "SELECT \r\n" + "    A.ORGKEY, \r\n" + "    A.Name, \r\n" + "    B.Nationality,\r\n"
			+ "    B.RESIDENCE_COUNTRY,\r\n" + "    CASE \r\n"
			+ "        WHEN B.Nationality <> B.RESIDENCE_COUNTRY THEN 'YES'\r\n" + "        ELSE 'NO'\r\n"
			+ "    END AS DUAL_NATIONALITY_FLAG\r\n" + "FROM \r\n" + "    accounts A\r\n" + "LEFT JOIN \r\n"
			+ "    demographic B \r\n" + "ON \r\n" + "    A.ORGKEY = B.ORGKEY\r\n" + "WHERE \r\n"
			+ "    B.Nationality IS NOT NULL \r\n" + "    AND B.RESIDENCE_COUNTRY IS NOT NULL\r\n"
			+ "    AND B.Nationality <> B.RESIDENCE_COUNTRY", nativeQuery = true)
	List<Object[]> getDualnation();

	/*------------Residence marker-----------*/
	@Query(value = "SELECT DISTINCT \r\n" + "    B.ORGKEY, \r\n" + "    B.NAME,\r\n" + "    D.RESIDENCE_COUNTRY,\r\n"
			+ "    B.NAT_ID_CARD_NUM,\r\n" + "    A.RESIDENTIALSTATUS FROM address A\r\n"
			+ "JOIN demographic D ON A.ORGKEY = D.ORGKEY\r\n" + "JOIN accounts B ON D.ORGKEY = B.ORGKEY\r\n"
			+ "WHERE  (D.RESIDENCE_COUNTRY LIKE 'AE%' AND B.NAT_ID_CARD_NUM IS NULL) OR  D.RESIDENCE_COUNTRY IS NULL \r\n"
			+ "   OR (REGEXP_LIKE(D.RESIDENCE_COUNTRY, '.*[^A-Za-z ].*'))  AND D.RESIDENCE_COUNTRY NOT IN ('N/A', 'OTHERS')", nativeQuery = true)
	List<Object[]> getResidmark();

	/*------------Addmonthsalary-----------*/
	/*
	 * @Query(value =
	 * "SELECT A.ORGKEY,A.NAME,D.EMPLOYMENT_STATUS,D.ANNUAL_OTHERS_INCOME / 12 AS MONTHLY_SALARY\r\n"
	 * + "FROM accounts A,demographic D\r\n" + "WHERE NAME IS NOT NULL\r\n" +
	 * "AND  D.ANNUAL_OTHERS_INCOME IS  NULL\r\n" +
	 * "AND D.EMPLOYMENT_STATUS ='Employed'", nativeQuery = true) List<Object[]>
	 * getAddmonth();
	 */

	@Query(value = "SELECT ORGKEY, NAME, EMPLOYMENT_STATUS, CRNCY_CODE, MONTHLY_SALARY\r\n"
			+ "FROM(SELECT distinct A.ORGKEY,A.NAME,D.EMPLOYMENT_STATUS,A.CRNCY_CODE,\r\n"
			+ "        D.ANNUAL_OTHERS_INCOME / 12 AS MONTHLY_SALARY,\r\n"
			+ "        ROW_NUMBER() OVER (PARTITION BY D.DEMOGRAPHICID ORDER BY D.DEMOGRAPHICID) AS RN\r\n"
			+ "    FROM accounts A\r\n" + "    INNER JOIN  demographic D \r\n" + "    ON A.ORGKEY = D.ORGKEY\r\n"
			+ "    WHERE (D.EMPLOYMENT_STATUS = 'Employed' or D.EMPLOYMENT_STATUS = 'Self employed')\r\n"
			+ "and A.CRNCY_CODE = 'AED'  and ANNUAL_OTHERS_INCOME is null)", nativeQuery = true)
	List<Object[]> getAddmonth();

	/*------------KYCReviewdate-----------*/
	@Query(value = "SELECT orgkey,name, KYC_DATE,KYC_REVIEWDATE, RISKRATING  FROM accounts\r\n"
			+ "WHERE name is not null and KYC_REVIEWDATE IS NULL  OR TRIM(KYC_REVIEWDATE) = ''\r\n"
			+ "OR (RISKRATING IN ('S', 'H') AND KYC_REVIEWDATE < CURRENT_DATE - INTERVAL '1' YEAR)\r\n"
			+ " OR (RISKRATING NOT IN ('S', 'H') AND KYC_REVIEWDATE < CURRENT_DATE - INTERVAL '5' YEAR)", nativeQuery = true)
	List<Object[]> getkyc();

	/*------------Estimated total income-----------*/
	@Query(value = "SELECT \r\n" + "    X.ORGKEY, \r\n" + "    X.NAME, \r\n" + "    X.EMPLOYMENT_STATUS, \r\n"
			+ "    X.CRNCY_CODE, \r\n"
			+ "    (NVL(X.MONTHLY_SALARY, 0) + NVL(Y.MONTHLY_SALARY, 0)) * 12 AS ESTIMATED_TOTAL_ANNUAL_INCOME,\r\n"
			+ "    CASE \r\n"
			+ "        WHEN (NVL(X.MONTHLY_SALARY, 0) + NVL(Y.MONTHLY_SALARY, 0)) * 12 > 500000 THEN 'Potential Outlier (High)'\r\n"
			+ "        WHEN (NVL(X.MONTHLY_SALARY, 0) + NVL(Y.MONTHLY_SALARY, 0)) * 12 < 10000 THEN 'Potential Outlier (Low)'\r\n"
			+ "        ELSE 'Normal'\r\n" + "    END AS OUTLIER_FLAG\r\n" + "FROM \r\n"
			+ "    -- X (Monthly salary from ANNUAL_SALARY_INCOME)\r\n" + "    (\r\n"
			+ "        SELECT ORGKEY, NAME, EMPLOYMENT_STATUS, CRNCY_CODE, MONTHLY_SALARY\r\n" + "        FROM (\r\n"
			+ "            SELECT  \r\n" + "                A.ORGKEY, \r\n" + "                A.NAME, \r\n"
			+ "                D.EMPLOYMENT_STATUS, \r\n" + "                A.CRNCY_CODE, \r\n"
			+ "                D.ANNUAL_SALARY_INCOME / 12 AS MONTHLY_SALARY,\r\n"
			+ "                ROW_NUMBER() OVER (PARTITION BY D.DEMOGRAPHICID ORDER BY D.DEMOGRAPHICID) AS RN\r\n"
			+ "            FROM accounts A  \r\n" + "            INNER JOIN demographic D ON A.ORGKEY = D.ORGKEY\r\n"
			+ "            WHERE \r\n" + "                D.EMPLOYMENT_STATUS IN ('Employed', 'Self employed')\r\n"
			+ "                AND A.CRNCY_CODE = 'AED'  \r\n"
			+ "                AND D.ANNUAL_SALARY_INCOME IS NOT NULL\r\n" + "        ) \r\n"
			+ "        WHERE RN = 1\r\n" + "    ) X\r\n" + "LEFT JOIN \r\n"
			+ "    -- Y (Monthly salary from ANNUAL_OTHERS_INCOME)\r\n" + "    (\r\n"
			+ "        SELECT ORGKEY, NAME, EMPLOYMENT_STATUS, CRNCY_CODE, MONTHLY_SALARY\r\n" + "        FROM (\r\n"
			+ "            SELECT DISTINCT \r\n" + "                A.ORGKEY, \r\n" + "                A.NAME, \r\n"
			+ "                D.EMPLOYMENT_STATUS, \r\n" + "                A.CRNCY_CODE, \r\n"
			+ "                D.ANNUAL_OTHERS_INCOME / 12 AS MONTHLY_SALARY,\r\n"
			+ "                ROW_NUMBER() OVER (PARTITION BY D.DEMOGRAPHICID ORDER BY D.DEMOGRAPHICID) AS RN\r\n"
			+ "            FROM accounts A    \r\n" + "            INNER JOIN demographic D ON A.ORGKEY = D.ORGKEY\r\n"
			+ "            WHERE \r\n" + "                D.EMPLOYMENT_STATUS IN ('Employed', 'Self employed')\r\n"
			+ "                AND A.CRNCY_CODE = 'AED'  \r\n"
			+ "                AND D.ANNUAL_OTHERS_INCOME IS NOT NULL\r\n" + "        ) \r\n"
			+ "        WHERE RN = 1\r\n" + "    ) Y\r\n" + "ON X.ORGKEY = Y.ORGKEY", nativeQuery = true)
	List<Object[]> getTotalincome();

	/*------------GENDER-----------*/
	@Query(value = " SELECT ORGKEY, NAME, SALUTATION, GENDER \r\n" + "FROM accounts\r\n" + "WHERE \r\n"
			+ "    (GENDER = 'NA' AND SALUTATION NOT IN ('M/S'))\r\n" + "    OR \r\n"
			+ "    (GENDER = 'M' AND SALUTATION  IN ('MRS.', 'M/S','MRS.'))\r\n" + "    OR \r\n"
			+ "    (GENDER = 'F' AND SALUTATION IN ('MR.','MR','M/S'))", nativeQuery = true)
	List<Object[]> getGEN();

	/*------------Email-----------*/
	@Query(value = "SELECT orgkey,name,email\r\n" + "FROM accounts\r\n" + "WHERE email NOT LIKE '%@%' \r\n"
			+ "  or email NOT LIKE '%gmail.com%' or email is null and name is not null", nativeQuery = true)
	List<Object[]> getEmail();

	/*------------Birthday-----------*/
	@Query(value = "SELECT orgkey,name,BIRTH_DAY, BIRTH_MONTH, BIRTH_YEAR, CUST_DOB\r\n" + "FROM accounts\r\n"
			+ "WHERE BIRTH_DAY != TO_CHAR(CUST_DOB, 'DD')\r\n" + "   and BIRTH_MONTH != TO_CHAR(CUST_DOB, 'MON')\r\n"
			+ "   and BIRTH_YEAR != TO_CHAR(CUST_DOB, 'YY')", nativeQuery = true)
	List<Object[]> getBirth();

	/*------------CountryTaxResidence-----------*/
	@Query(value = "SELECT name,\r\n" + "LASTFOREIGNTAXREVIEWDATE,\r\n" + "FOREIGNACCTAXREPORTINGREQ,\r\n"
			+ "FOREIGNTAXREPORTINGCOUNTRY,\r\n" + "FOREIGNTAXREPORTINGSTATUS,\r\n" + "NEXTFOREIGNTAXREVIEWDATE \r\n"
			+ "FROM accounts  where name is not null", nativeQuery = true)
	List<Object[]> getCountrytax();

	/*------------Shortname-----------*/
	@Query(value = "SELECT orgkey,\r\n" + "       name, \r\n" + "       cust_first_name, \r\n"
			+ "       cust_last_name, \r\n" + "       short_name \r\n" + "FROM accounts\r\n" + "WHERE \r\n"
			+ "    name IS NOT NULL\r\n" + "    AND NOT EXISTS (\r\n" + "        SELECT 1\r\n"
			+ "        FROM   (SELECT REGEXP_SUBSTR(short_name, '[^[:space:]]', LEVEL, 1) AS letter\r\n"
			+ "                FROM dual\r\n" + "                CONNECT BY LEVEL <= LENGTH(short_name))\r\n"
			+ "        WHERE  REGEXP_LIKE(letter, '[' || cust_first_name || cust_last_name || ']', 'i')\r\n"
			+ "    )", nativeQuery = true)
	List<Object[]> getShortname();

	/*------------LoanDetails-----------*/
	@Query(value = "SELECT A.ACID,\r\n" + "A.LOAN_TYPE,\r\n" + "A.ACCT_TYPE,\r\n" + "A.APPLY_INT_ON_PYMT,\r\n"
			+ "A.PAYOFF_DATE,\r\n" + "A.LINKED_ACCT_ID,\r\n" + "B.DMD_AMT,B.DMD_DATE \r\n"
			+ "FROM lam A JOIN ldt B ON A.ACID=B.ACID", nativeQuery = true)
	List<Object[]> getLoan();

}
