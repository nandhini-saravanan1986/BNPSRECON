package com.bornfire.xbrl.entities.BNPSRECON;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BRFValidationsRepo extends JpaRepository<BRFValidations, String> {

	Optional<BRFValidations> findById(String directorId);

	@Query(value = "select * from BBRF_REPORT_VALIDATION_TABLE where rpt_code=?1 ORDER BY srl_no ", nativeQuery = true)
	List<BRFValidations> getValidationList(String rpt_code);
	
	@Query(value = "uprpt_code BBRF_REPORT_VALIDATION_TABLE set cur_status=?2 where srl_no=?1", nativeQuery = true)
	void uprpt_codeValirpt_codeChkFlg(String srl_no, String cur_status);
	
	@Query(value = "select * from RR_RPT_MAST ORDER  BY SRL_NO", nativeQuery = true)
	List<BRFValidations> getReport_details();
	
	

	@Query(value = "select DISTINCT to_char(CUR_QTR_END_rpt_code,'dd/MM/yyyy')as CUR_QTR_END_rpt_code from BRBS_RPT_MAST where ROWNUM = 1 order by CUR_QTR_END_rpt_code desc", nativeQuery = true)
	String getCurrentQtr(SimpleDateFormat simpledateFormat);
	///BRF-1
	////Srl_no1
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo1(String report_date);

	////Srl_no2
	@Query(value = "SELECT count(*) from BRF1_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo2(String report_date);
	
	 ////Srl_no3
	@Query(value = "SELECT count(*) from BRF1_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo3(String report_date);
	
	
	///BRF-2
    ////Srl_no4
	@Query(value = "SELECT count(*) from BRF2_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo4(String report_date);
	
	////Srl_no5
	@Query(value = "SELECT count(*) from BRF2_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo5(String report_date);
	
	////Srl_no6
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo6(String report_date);
	
	///BRF-1
	////Srl_no7 (Total ASSETS and LIABILITIES)
	@Query(value = "SELECT b.R81_TOTAL_AMOUNT, c.R86_TOTAL_AMOUNT " +
            "FROM BRF1_SUMMARYTABLE b, BRF2_SUMMARYTABLE c " +
            "WHERE b.REPORT_DATE = ?1 AND c.REPORT_DATE = ?1 " +
            "AND b.R81_TOTAL_AMOUNT = c.R86_TOTAL_AMOUNT", nativeQuery = true)
   List<Object[]> getCheckSrlNo7(String report_date);
   
   ///BRF-2
   ////Srl_no8 (Total ASSETS and LIABILITIES)
	@Query(value = "SELECT b.R81_TOTAL_AMOUNT, c.R86_TOTAL_AMOUNT " +
	        "FROM BRF1_SUMMARYTABLE b, BRF2_SUMMARYTABLE c " +
	        "WHERE b.REPORT_DATE = ?1 AND c.REPORT_DATE = ?1 " +
	        "AND b.R81_TOTAL_AMOUNT = c.R86_TOTAL_AMOUNT", nativeQuery = true)
	List<Object[]> getCheckSrlNo8(String report_date);
	
	////Srl_no9 (PROFIT and LOSS)
	@Query(value = "SELECT b.R84_TOTAL_AMOUNT, c.R66_YEAR_TO_DATE " +
	        "FROM BRF2_SUMMARYTABLE b, BRF4_SUMMARYTABLE c " +
	        "WHERE b.REPORT_DATE = ?1 AND c.REPORT_DATE = ?1 " +
	        "AND b.R84_TOTAL_AMOUNT = c.R66_YEAR_TO_DATE", nativeQuery = true)
	List<Object[]> getCheckSrlNo9(String report_date);
	
	///BRF-3
	////Srl_no10
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo10(String report_date);

	////Srl_no11
	@Query(value = "SELECT count(*) from BRF3_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo11(String report_date);
	
	 ////Srl_no12
	@Query(value = "SELECT count(*) from BRF3_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo12(String report_date);
	
	///BRF-4
	////Srl_no10
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo13(String report_date);

	////Srl_no11
	@Query(value = "SELECT count(*) from BRF4_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo14(String report_date);
	
	 ////Srl_no12
	@Query(value = "SELECT count(*) from BRF4_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo15(String report_date);
	
	////Srl_no9 (PROFIT and LOSS)
	@Query(value = "SELECT b.R84_TOTAL_AMOUNT, c.R66_YEAR_TO_DATE " +
	        "FROM BRF2_SUMMARYTABLE b, BRF4_SUMMARYTABLE c " +
	        "WHERE b.REPORT_DATE = ?1 AND c.REPORT_DATE = ?1 " +
	        "AND b.R84_TOTAL_AMOUNT = c.R66_YEAR_TO_DATE", nativeQuery = true)
	List<Object[]> getCheckSrlNo16(String report_date);
	
	///BRF-5
	////Srl_no17
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo17(String report_date);

	////Srl_no18
	@Query(value = "SELECT count(*) from BRF5_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo18(String report_date);
	
	 ////Srl_no19
	@Query(value = "SELECT count(*) from BRF5_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo19(String report_date);
	
	///BRF-7
	////Srl_no20
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo20(String report_date);

	////Srl_no21
	@Query(value = "SELECT count(*) from BRF7_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo21(String report_date);
	
	 ////Srl_no22
	@Query(value = "SELECT count(*) from BRF7_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo22(String report_date);
	
	///Srl_no23(NET LENDING)
	@Query(value = "SELECT a.R1_AMOUNT, b.R37_TOTAL_AMOUNT, b.R44_TOTAL_AMOUNT, c.R47_TOTAL_AMOUNT, c.R49_TOTAL_AMOUNT, c.R50_TOTAL_AMOUNT, c.R52_TOTAL_AMOUNT " +
            "FROM BRF7_SUMMARYTABLE a, BRF1_SUMMARYTABLE b, BRF2_SUMMARYTABLE c " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 AND c.REPORT_DATE = ?1 " +
            "AND a.R1_AMOUNT = (b.R37_TOTAL_AMOUNT + b.R44_TOTAL_AMOUNT - (c.R47_TOTAL_AMOUNT + c.R49_TOTAL_AMOUNT + c.R50_TOTAL_AMOUNT + c.R52_TOTAL_AMOUNT))", nativeQuery = true)
	List<Object[]> getCheckSrlNo23(String report_date);
	
	///Srl_no24(LENDING TO NBFI)
	@Query(value = "SELECT a.R20_TOTAL_AMOUNT, b.R2_AMOUNT " +
            "FROM BRF1_SUMMARYTABLE a, BRF7_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND b.R2_AMOUNT = a.R20_TOTAL_AMOUNT", nativeQuery = true)
	List<Object[]> getCheckSrlNo24(String report_date);
	
	///Srl_no25(INTERBANK PLACEMENTS WITH A REMAINING LIFE OF MORE THAN 3 MONTHS)
	@Query(value = "SELECT a.R5_AMOUNT, b.R4_3_6_MONTHS, b.R4_6_12_MONTHS, b.R4_1_3_YEARS, b.R4_3_YEARS, " +
            "b.R5_3_6_MONTHS, b.R5_6_12_MONTHS, b.R5_1_3_YEARS, b.R5_3_YEARS, " +
            "b.R6_3_6_MONTHS, b.R6_6_12_MONTHS, b.R6_1_3_YEARS, b.R6_3_YEARS " +
            "FROM BRF7_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R5_AMOUNT = (b.R4_3_6_MONTHS + b.R4_6_12_MONTHS + b.R4_1_3_YEARS + b.R4_3_YEARS + " +
                               "b.R5_3_6_MONTHS + b.R5_6_12_MONTHS + b.R5_1_3_YEARS + b.R5_3_YEARS + " +
                               "b.R6_3_6_MONTHS + b.R6_6_12_MONTHS + b.R6_1_3_YEARS + b.R6_3_YEARS )", nativeQuery = true)
	List<Object[]> getCheckSrlNo25(String report_date);

	///Srl_no26(TOTAL OWN FUNDS)
	@Query(value = "SELECT a.R7_AMOUNT, b.R74_TOTAL_AMOUNT, b.R63_TOTAL_AMOUNT, b.R51_TOTAL_AMOUNT " +
               "FROM BRF7_SUMMARYTABLE a, BRF2_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R7_AMOUNT = (b.R74_TOTAL_AMOUNT + b.R63_TOTAL_AMOUNT + b.R51_TOTAL_AMOUNT)", nativeQuery = true)
	List<Object[]> getCheckSrlNo26(String report_date);
	
	///Srl_no27(GOODWILL AND OTHER INTANGIBLE ASSETS)
	@Query(value = "SELECT a.R8_AMOUNT, b.R67_TOTAL_AMOUNT, b.R68_TOTAL_AMOUNT " +
               "FROM BRF7_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R8_AMOUNT = (b.R67_TOTAL_AMOUNT + b.R68_TOTAL_AMOUNT)", nativeQuery = true)
	List<Object[]> getCheckSrlNo27(String report_date);
	
	///Srl_no28(NET FIXED ASSETS)
	@Query(value = "SELECT a.R9_AMOUNT, b.R58_TOTAL_AMOUNT, b.R59_TOTAL_AMOUNT, b.R60_TOTAL_AMOUNT, b.R62_TOTAL_AMOUNT " +
               "FROM BRF7_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R9_AMOUNT = (b.R58_TOTAL_AMOUNT + b.R59_TOTAL_AMOUNT + b.R60_TOTAL_AMOUNT + b.R62_TOTAL_AMOUNT)", nativeQuery = true)
	List<Object[]> getCheckSrlNo28(String report_date);

	///Srl_no29(FUNDS ALLOCATED TO BRANCHES ABROAD)
	@Query(value = "SELECT a.R10_AMOUNT, b.R61_TOTAL_AMOUNT " +
               "FROM BRF7_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R10_AMOUNT = b.R61_TOTAL_AMOUNT", nativeQuery = true)
	List<Object[]> getCheckSrlNo29(String report_date);
	
	///Srl_no30(NON REPAYABLE HEAD OFFICE FUNDS)
	@Query(value = "SELECT a.R16_AMOUNT, b.R61_TOTAL_AMOUNT " +
               "FROM BRF7_SUMMARYTABLE a, BRF2_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R16_AMOUNT = b.R61_TOTAL_AMOUNT", nativeQuery = true)
	List<Object[]> getCheckSrlNo30(String report_date);
	
	///Srl_no31(INTERBANK DEPOSITS WITH REMAINING LIFE OF MORE THAN 6 MONTHS (BRF 9)-6 -12 months)
	@Query(value = "SELECT a.R17_AMOUNT, b.R32_6_12_MONTHS, b.R33_6_12_MONTHS, b.R34_6_12_MONTHS, b.R35_6_12_MONTHS, b.R36_6_12_MONTHS, " +
               "b.R32_1_3_YEARS, b.R33_1_3_YEARS, b.R34_1_3_YEARS, b.R35_1_3_YEARS, b.R36_1_3_YEARS, " +
               "b.R32_3_YEARS, b.R33_3_YEARS, b.R34_3_YEARS, b.R35_3_YEARS, b.R36_3_YEARS " +
               "FROM BRF7_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R17_AMOUNT = (b.R32_6_12_MONTHS + b.R33_6_12_MONTHS + b.R34_6_12_MONTHS + b.R35_6_12_MONTHS + b.R36_6_12_MONTHS + " +
                                  "b.R32_1_3_YEARS + b.R33_1_3_YEARS + b.R34_1_3_YEARS + b.R35_1_3_YEARS + b.R36_1_3_YEARS + " +
                                  "b.R32_3_YEARS + b.R33_3_YEARS + b.R34_3_YEARS + b.R35_3_YEARS + b.R36_3_YEARS)", nativeQuery = true)
	List<Object[]> getCheckSrlNo31(String report_date);
	
	///Srl_no32(NON BANKING FINANCIAL INSTITUTIONS (BRF 9))
	@Query(value = "SELECT a.R19_AMOUNT, b.R40_6_12_MONTHS, b.R40_1_3_YEARS, b.R40_3_YEARS " +
               "FROM BRF7_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R19_AMOUNT = (b.R40_6_12_MONTHS + b.R40_1_3_YEARS + b.R40_3_YEARS)", nativeQuery = true)
	List<Object[]> getCheckSrlNo32(String report_date);
	
	///Srl_no33(85% OF THE REST OF NBFI DEPOSITS (BRF 9))
	@Query(value = "SELECT a.R20_AMOUNT, b.R40_0_7_DAYS, b.R40_8_14_DAYS, b.R40_15_DAYS_1_MONTH, b.R40_1_3_MONTHS, b.R40_3_6_MONTHS " +
               "FROM BRF7_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R20_AMOUNT = ROUND((b.R40_0_7_DAYS + b.R40_8_14_DAYS + b.R40_15_DAYS_1_MONTH + b.R40_1_3_MONTHS + b.R40_3_6_MONTHS) * 0.85, 0)", nativeQuery = true)
	List<Object[]> getCheckSrlNo33(String report_date);
	
	///Srl_no34(CUSTOMER DEPOSITS WITH REMAINING LIFE OF MORE THAN 6 MONTHS (BRF 9))
	@Query(value = "SELECT a.R21_AMOUNT, b.R37_6_12_MONTHS, b.R37_1_3_YEARS, b.R37_3_YEARS, " +
               "b.R38_6_12_MONTHS, b.R38_1_3_YEARS, b.R38_3_YEARS, " +
               "b.R39_6_12_MONTHS, b.R39_1_3_YEARS, b.R39_3_YEARS, " +
               "b.R41_6_12_MONTHS, b.R41_1_3_YEARS, b.R41_3_YEARS, " +
               "b.R42_6_12_MONTHS, b.R42_1_3_YEARS, b.R42_3_YEARS " +
               "FROM BRF7_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R21_AMOUNT = (b.R37_6_12_MONTHS + b.R37_1_3_YEARS + b.R37_3_YEARS + " +
                                  "b.R38_6_12_MONTHS + b.R38_1_3_YEARS + b.R38_3_YEARS + " +
                                  "b.R39_6_12_MONTHS + b.R39_1_3_YEARS + b.R39_3_YEARS + " +
                                  "b.R41_6_12_MONTHS + b.R41_1_3_YEARS + b.R41_3_YEARS + " +
                                  "b.R42_6_12_MONTHS + b.R42_1_3_YEARS + b.R42_3_YEARS)", nativeQuery = true)
	List<Object[]> getCheckSrlNo34(String report_date);

	///Srl_no35(85% OF THE REST OF CUSTOMER DEPOSITS (BRF 9))
	@Query(value = "SELECT a.R22_AMOUNT, b.R37_0_7_DAYS, b.R37_8_14_DAYS, b.R37_15_DAYS_1_MONTH, b.R37_1_3_MONTHS, b.R37_3_6_MONTHS, " +
            "b.R38_0_7_DAYS, b.R38_8_14_DAYS, b.R38_15_DAYS_1_MONTH, b.R38_1_3_MONTHS, b.R38_3_6_MONTHS, " +
            "b.R39_0_7_DAYS, b.R39_8_14_DAYS, b.R39_15_DAYS_1_MONTH, b.R39_1_3_MONTHS, b.R39_3_6_MONTHS, " +
            "b.R41_0_7_DAYS, b.R41_8_14_DAYS, b.R41_15_DAYS_1_MONTH, b.R41_1_3_MONTHS, b.R41_3_6_MONTHS, " +
            "b.R42_0_7_DAYS, b.R42_8_14_DAYS, b.R42_15_DAYS_1_MONTH, b.R42_1_3_MONTHS, b.R42_3_6_MONTHS " +
            "FROM BRF7_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R22_AMOUNT = ROUND((b.R37_0_7_DAYS + b.R37_8_14_DAYS + b.R37_15_DAYS_1_MONTH + b.R37_1_3_MONTHS + b.R37_3_6_MONTHS + " +
                                    "b.R38_0_7_DAYS + b.R38_8_14_DAYS + b.R38_15_DAYS_1_MONTH + b.R38_1_3_MONTHS + b.R38_3_6_MONTHS + " +
                                    "b.R39_0_7_DAYS + b.R39_8_14_DAYS + b.R39_15_DAYS_1_MONTH + b.R39_1_3_MONTHS + b.R39_3_6_MONTHS + " +
                                    "b.R41_0_7_DAYS + b.R41_8_14_DAYS + b.R41_15_DAYS_1_MONTH + b.R41_1_3_MONTHS + b.R41_3_6_MONTHS + " +
                                    "b.R42_0_7_DAYS + b.R42_8_14_DAYS + b.R42_15_DAYS_1_MONTH + b.R42_1_3_MONTHS + b.R42_3_6_MONTHS) * 0.85, 0)", nativeQuery = true)
	List<Object[]> getCheckSrlNo35(String report_date);
	
	///Srl_no36(CAPITAL MARKET FUNDING/TERM BORROWINGS MATURING AFTER 6 MONTHS FROM REPORTING DATE (BRF 9))
	@Query(value = "SELECT a.R23_AMOUNT, b.R43_6_12_MONTHS, b.R43_1_3_YEARS, b.R43_3_YEARS " +
               "FROM BRF7_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R23_AMOUNT = (b.R43_6_12_MONTHS + b.R43_1_3_YEARS + b.R43_3_YEARS)", nativeQuery = true)
	List<Object[]> getCheckSrlNo36(String report_date);

	///Srl_no37(HEAD OFFICE LOANS TOWARDS MEETING LARGE EXPOSURE FUNDING (BRF 2 LIAB - ITEM 26.6))
	@Query(value = "SELECT a.R24_AMOUNT, b.R62_TOTAL_AMOUNT " +
               "FROM BRF7_SUMMARYTABLE a, BRF2_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R24_AMOUNT = b.R62_TOTAL_AMOUNT", nativeQuery = true)
	List<Object[]> getCheckSrlNo37(String report_date);
	
	///BRF-8
	////Srl_no38
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo38(String report_date);

	////Srl_no39
	@Query(value = "SELECT count(*) from BRF8_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo39(String report_date);
	
	 ////Srl_no40
	@Query(value = "SELECT count(*) from BRF8_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo40(String report_date);

	///Srl_no41(TOTAL LIABILITIES (BRF-8)
	@Query(value = "SELECT a.R14_ELIGI_LIQ_ASSETS, b.R86_TOTAL_AMOUNT, b.R28_TOTAL_AMOUNT, b.R46_TOTAL_AMOUNT, b.R54_TOTAL_AMOUNT, b.R63_TOTAL_AMOUNT, b.R74_TOTAL_AMOUNT " +
               "FROM BRF8_SUMMARYTABLE a, BRF2_SUMMARYTABLE b " +
               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
               "AND a.R14_ELIGI_LIQ_ASSETS = (b.R86_TOTAL_AMOUNT - b.R28_TOTAL_AMOUNT - (b.R46_TOTAL_AMOUNT - b.R54_TOTAL_AMOUNT) - b.R63_TOTAL_AMOUNT - b.R74_TOTAL_AMOUNT)", nativeQuery = true)
	List<Object[]> getCheckSrlNo41(String report_date);
	
	///Srl_no45(Physical cash in hand at the bank(BRF 1 - Item-1.1))
		@Query(value = "SELECT a.R1_NOMINAL_AMOUNT, b.R2_TOTAL_AMOUNT " +
	               "FROM BRF8_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R1_NOMINAL_AMOUNT = b.R2_TOTAL_AMOUNT", nativeQuery = true)
		List<Object[]> getCheckSrlNo45(String report_date);
		
	///Srl_no46(Statutory reserves with Central Bank(BRF 1 - Item-1.2))
		@Query(value = "SELECT a.R2_NOMINAL_AMOUNT, b.R3_TOTAL_AMOUNT " +
	               "FROM BRF8_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R2_NOMINAL_AMOUNT = b.R3_TOTAL_AMOUNT", nativeQuery = true)
		List<Object[]> getCheckSrlNo46(String report_date);
		
	///Srl_no47(Free and other account balances at the Central Bank(BRF 1 - Item-1.4))
		@Query(value = "SELECT a.R3_NOMINAL_AMOUNT, b.R5_AMOUNT_AED_RESIDENT " +
	               "FROM BRF8_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R3_NOMINAL_AMOUNT = b.R5_AMOUNT_AED_RESIDENT", nativeQuery = true)
		List<Object[]> getCheckSrlNo47(String report_date);
		
	///Srl_no48(Central Bank CDs (BRF 1 - Item-1.5.2))
		@Query(value = "SELECT a.R4_NOMINAL_AMOUNT, b.R8_AMOUNT_AED_RESIDENT " +
	               "FROM BRF8_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R4_NOMINAL_AMOUNT = b.R8_AMOUNT_AED_RESIDENT", nativeQuery = true)
		List<Object[]> getCheckSrlNo48(String report_date);

	///Srl_no49(UAE Federal Government Bonds and Sukuks (BRF 1 - Item-5.2.1.1))
		@Query(value = "SELECT a.R5_NOMINAL_AMOUNT, b.R31_AMOUNT_AED_RESIDENT " +
	               "FROM BRF8_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R5_NOMINAL_AMOUNT = b.R31_AMOUNT_AED_RESIDENT", nativeQuery = true)
		List<Object[]> getCheckSrlNo49(String report_date);

	///BRF-9
	////Srl_no42
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo42(String report_date);

	////Srl_no43
	@Query(value = "SELECT count(*) from BRF9_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo43(String report_date);
	
	 ////Srl_no44
	@Query(value = "SELECT count(*) from BRF9_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo44(String report_date);
	
	///Srl_no50(CASH, RESERVES AND BALANCES WITH CENTRAL BANK - 0 - 7 days (BRF 1))
		@Query(value = "SELECT a.R1_0_7_DAYS, b.R2_AMOUNT_AED_RESIDENT, b.R2_AMOUNT_FCY_RESIDENT, b.R5_AMOUNT_AED_RESIDENT " +
	               "FROM BRF9_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R1_0_7_DAYS = (b.R2_AMOUNT_AED_RESIDENT + b.R2_AMOUNT_FCY_RESIDENT + b.R5_AMOUNT_AED_RESIDENT)", nativeQuery = true)
		List<Object[]> getCheckSrlNo50(String report_date);

		
	///Srl_no51(CASH, RESERVES AND BALANCES WITH CENTRAL BANK - 8-14 days (BRF 1))
		@Query(value = "SELECT a.R1_8_14_DAYS, b.R3_AMOUNT_AED_RESIDENT, b.R3_AMOUNT_FCY_RESIDENT " +
	               "FROM BRF9_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R1_8_14_DAYS = (b.R3_AMOUNT_AED_RESIDENT + b.R3_AMOUNT_FCY_RESIDENT)", nativeQuery = true)
		List<Object[]> getCheckSrlNo51(String report_date);
		

	///Srl_no52(Net Fixed Assets (BRF 1 - 9.3))
			@Query(value = "SELECT a.R21_3_YEARS, b.R60_AMOUNT_AED_RESIDENT " +
		               "FROM BRF9_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R21_3_YEARS = b.R60_AMOUNT_AED_RESIDENT", nativeQuery = true)
			List<Object[]> getCheckSrlNo52(String report_date);
			
	///Srl_no53(Government and Public Sector (BRF 1 - 7.1.1))
			@Query(value = "SELECT a.R22_3_YEARS, b.R39_AMOUNT_FCY_NON_RESIDENT " +
		               "FROM BRF9_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R22_3_YEARS = b.R39_AMOUNT_FCY_NON_RESIDENT", nativeQuery = true)
			List<Object[]> getCheckSrlNo53(String report_date);
			
	///Srl_no54(Other Assets1 - 0 - 7 days (BRF 1 - 10))
			@Query(value = "SELECT a.R31_0_7_DAYS, b.R63_AMOUNT_AED_RESIDENT " +
	               "FROM BRF9_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R31_0_7_DAYS = b.R63_AMOUNT_AED_RESIDENT", nativeQuery = true)
			List<Object[]> getCheckSrlNo54(String report_date);
			
	///Srl_no55(Other Assets1 - 15 days - 1 month (BRF 1 - 10))
			@Query(value = "SELECT a.R31_15_DAYS_1_MONTH, b.R65_TOTAL_AMOUNT " +
	               "FROM BRF9_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R31_15_DAYS_1_MONTH = b.R65_TOTAL_AMOUNT", nativeQuery = true)
			List<Object[]> getCheckSrlNo55(String report_date);
			
	///Srl_no56(Other Assets1 - 3 -  6 months (BRF 1 - 10))
			@Query(value = "SELECT a.R31_3_6_MONTHS, b.R71_TOTAL_AMOUNT " +
	               "FROM BRF9_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R31_3_6_MONTHS = b.R71_TOTAL_AMOUNT", nativeQuery = true)
			List<Object[]> getCheckSrlNo56(String report_date);
			
	///Srl_no57(Other Assets1 - 6 -12 months (BRF 1 - 10))
			@Query(value = "SELECT a.R31_6_12_MONTHS, b.R66_AMOUNT_AED_RESIDENT " +
	               "FROM BRF9_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R31_6_12_MONTHS = b.R66_AMOUNT_AED_RESIDENT", nativeQuery = true)
			List<Object[]> getCheckSrlNo57(String report_date);

	///Srl_no58(Other liabilities (refer note: 1) - 1 - 3 months (BRF 2))
		@Query(value = "SELECT a.R44_1_3_MONTHS, b.R64_AMOUNT_AED_RESIDENT, b.R64_AMOUNT_FCY_RESIDENT, b.R45_AMOUNT_AED_RESIDENT " +
	               "FROM BRF9_SUMMARYTABLE a, BRF2_SUMMARYTABLE b " +
	               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
	               "AND a.R44_1_3_MONTHS = (b.R64_AMOUNT_AED_RESIDENT + b.R64_AMOUNT_FCY_RESIDENT + b.R45_AMOUNT_AED_RESIDENT)", nativeQuery = true)
		List<Object[]> getCheckSrlNo58(String report_date);
		
		
	///Srl_no59(Other liabilities (refer note: 1) - 3 -  6 months (BRF 2))
			@Query(value = "SELECT a.R44_3_6_MONTHS, b.R59_TOTAL_AMOUNT, b.R58_TOTAL_AMOUNT, b.R57_TOTAL_AMOUNT, b.R55_TOTAL_AMOUNT, b.R54_TOTAL_AMOUNT, b.R53_TOTAL_AMOUNT, b.R29_TOTAL_AMOUNT " +
						   "FROM BRF9_SUMMARYTABLE a, BRF2_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R44_3_6_MONTHS = (b.R59_TOTAL_AMOUNT + b.R58_TOTAL_AMOUNT + b.R57_TOTAL_AMOUNT + b.R55_TOTAL_AMOUNT + b.R54_TOTAL_AMOUNT + b.R53_TOTAL_AMOUNT + b.R29_TOTAL_AMOUNT)", nativeQuery = true)
			List<Object[]> getCheckSrlNo59(String report_date);
			
	///Srl_no60(Provisions (Specific, interest in suspense, collective impairment provisions)(BRF 2))
			@Query(value = "SELECT a.R45_0_7_DAYS, b.R47_TOTAL_AMOUNT, b.R52_TOTAL_AMOUNT, b.R51_TOTAL_AMOUNT " +
					   "FROM BRF9_SUMMARYTABLE a, BRF2_SUMMARYTABLE b " +
					   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
					   "AND a.R45_0_7_DAYS = (b.R47_TOTAL_AMOUNT + b.R52_TOTAL_AMOUNT + b.R51_TOTAL_AMOUNT)", nativeQuery = true)
			List<Object[]> getCheckSrlNo60(String report_date);
			
	///Srl_no61(Capital and Reserves (BRF 2))
			@Query(value = "SELECT a.R46_3_YEARS, b.R74_AMOUNT_AED_RESIDENT " +
				   "FROM BRF9_SUMMARYTABLE a, BRF2_SUMMARYTABLE b " +
				   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
				   "AND a.R46_3_YEARS = b.R74_AMOUNT_AED_RESIDENT", nativeQuery = true)
			List<Object[]> getCheckSrlNo61(String report_date);
			
	///BRF11
	///Srl_no62(Cash, reserves and balances with Central Bank(BRF 1))
	@Query(value = "SELECT a.R1_NON_INTEREST, b.R2_AMOUNT_AED_RESIDENT, b.R2_AMOUNT_FCY_RESIDENT, b.R5_AMOUNT_AED_RESIDENT, b.R3_AMOUNT_AED_RESIDENT, b.R3_AMOUNT_FCY_RESIDENT " +
				   "FROM BRF11_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
				   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
				   "AND a.R1_NON_INTEREST = (b.R2_AMOUNT_AED_RESIDENT + b.R2_AMOUNT_FCY_RESIDENT + b.R5_AMOUNT_AED_RESIDENT + b.R3_AMOUNT_AED_RESIDENT + b.R3_AMOUNT_FCY_RESIDENT)", nativeQuery = true)
	List<Object[]> getCheckSrlNo62(String report_date);
	
	///Srl_no63(Central Bank CDs - 0 - 7 days (BRF 9))
	@Query(value = "SELECT a.R2_0_7_DAYS AS R2_0_7_DAYS_A, b.R2_0_7_DAYS AS R2_0_7_DAYS_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R2_0_7_DAYS = b.R2_0_7_DAYS", nativeQuery = true)
	List<Object[]> getCheckSrlNo63(String report_date);
			
	///Srl_no64(Central Bank CDs - 8-14 days(BRF 9))
	@Query(value = "SELECT a.R2_8_14_DAYS AS R2_8_14_DAYS_A, b.R2_8_14_DAYS AS R2_8_14_DAYS_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R2_8_14_DAYS = b.R2_8_14_DAYS", nativeQuery = true)
	List<Object[]> getCheckSrlNo64(String report_date);
		
	///Srl_no65(Central Bank CDs - 15 days - 1 month(BRF 9))
	@Query(value = "SELECT a.R2_15_DAYS_1_MONTH AS R2_15_DAYS_1_MONTH_A, " +
            "b.R2_15_DAYS_1_MONTH AS R2_15_DAYS_1_MONTH_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R2_15_DAYS_1_MONTH = b.R2_15_DAYS_1_MONTH", nativeQuery = true)
	List<Object[]> getCheckSrlNo65(String report_date);
			
	///Srl_no66(Central Bank CDs - 1 - 3 months(BRF 9))
	@Query(value = "SELECT a.R2_1_3_MONTHS AS R2_1_3_MONTHS_A, " +
            "b.R2_1_3_MONTHS AS R2_1_3_MONTHS_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R2_1_3_MONTHS = b.R2_1_3_MONTHS", nativeQuery = true)
	List<Object[]> getCheckSrlNo66(String report_date);
		
	///Srl_no67(Central Bank CDs - 3 -  6 months(BRF 9))
	@Query(value = "SELECT a.R2_3_6_MONTHS AS R2_3_6_MONTHS_A, " +
            "b.R2_3_6_MONTHS AS R2_3_6_MONTHS_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R2_3_6_MONTHS = b.R2_3_6_MONTHS", nativeQuery = true)
	List<Object[]> getCheckSrlNo67(String report_date);
	
	///Srl_no68(Central Bank CDs - 6 -12 months(BRF 9))
	@Query(value = "SELECT a.R2_6_12_MONTHS AS R2_6_12_MONTHS_A, " +
            "b.R2_6_12_MONTHS AS R2_6_12_MONTHS_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R2_6_12_MONTHS = b.R2_6_12_MONTHS", nativeQuery = true)
	List<Object[]> getCheckSrlNo68(String report_date);
			
	///Srl_no69(UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 0 - 7 days(BRF 9))
	@Query(value = "SELECT a.R3_0_7_DAYS AS R3_0_7_DAYS_A, " +
            "b.R3_0_7_DAYS AS R3_0_7_DAYS_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R3_0_7_DAYS = b.R3_0_7_DAYS", nativeQuery = true)
	List<Object[]> getCheckSrlNo69(String report_date);
		
	///Srl_no70(UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 8-14 days(BRF 9))
	@Query(value = "SELECT a.R3_8_14_DAYS AS R3_8_14_DAYS_A, " +
            "b.R3_8_14_DAYS AS R3_8_14_DAYS_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R3_8_14_DAYS = b.R3_8_14_DAYS", nativeQuery = true)
	List<Object[]> getCheckSrlNo70(String report_date);
			
	///Srl_no71(UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 15 days - 1 month(BRF 9))
	@Query(value = "SELECT a.R3_15_DAYS_1_MONTH AS R3_15_DAYS_1_MONTH_A, " +
            "b.R3_15_DAYS_1_MONTH AS R3_15_DAYS_1_MONTH_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R3_15_DAYS_1_MONTH = b.R3_15_DAYS_1_MONTH", nativeQuery = true)
	List<Object[]> getCheckSrlNo71(String report_date);
		
	///Srl_no72(UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 1 - 3 months(BRF 9))
	@Query(value = "SELECT a.R3_1_3_MONTHS AS R3_1_3_MONTHS_A, " +
            "b.R3_1_3_MONTHS AS R3_1_3_MONTHS_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R3_1_3_MONTHS = b.R3_1_3_MONTHS", nativeQuery = true)
	List<Object[]> getCheckSrlNo72(String report_date);
		
	///Srl_no73(UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 3 -  6 months(BRF 9))
	@Query(value = "SELECT a.R3_3_6_MONTHS AS R3_3_6_MONTHS_A, " +
            "b.R3_3_6_MONTHS AS R3_3_6_MONTHS_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R3_3_6_MONTHS = b.R3_3_6_MONTHS", nativeQuery = true)
	List<Object[]> getCheckSrlNo73(String report_date);
		
	///Srl_no74(UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 6 -12 months(BRF 9))
	@Query(value = "SELECT a.R3_6_12_MONTHS AS R3_6_12_MONTHS_A, " +
            "b.R3_6_12_MONTHS AS R3_6_12_MONTHS_B " +
            "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
            "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
            "AND a.R3_6_12_MONTHS = b.R3_6_12_MONTHS", nativeQuery = true)
	List<Object[]> getCheckSrlNo74(String report_date);
		
	///Srl_no75(UAE FEDERAL AND EMIRATE GOVERNMENTS DEBT SECURITIES - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R3_1_2_YEARS, b.R3_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R3_1_2_YEARS = b.R3_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo75(String report_date);
			
	///Srl_no76(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R4_0_7_DAYS AS R4_0_7_DAYS_A, " +
		               "b.R4_0_7_DAYS AS R4_0_7_DAYS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R4_0_7_DAYS = b.R4_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo76(String report_date);
			
	///Srl_no77(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R4_8_14_DAYS AS R4_8_14_DAYS_A, " +
		               "b.R4_8_14_DAYS AS R4_8_14_DAYS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R4_8_14_DAYS = b.R4_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo77(String report_date);
			
	///Srl_no78(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R4_15_DAYS_1_MONTH AS R4_15_DAYS_1_MONTH_A, " +
		               "b.R4_15_DAYS_1_MONTH AS R4_15_DAYS_1_MONTH_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R4_15_DAYS_1_MONTH = b.R4_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo78(String report_date);
			
	///Srl_no79(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R4_1_3_MONTHS AS R4_1_3_MONTHS_A, " +
		               "b.R4_1_3_MONTHS AS R4_1_3_MONTHS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R4_1_3_MONTHS = b.R4_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo79(String report_date);
			
	///Srl_no80(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R4_3_6_MONTHS AS R4_3_6_MONTHS_A, " +
		               "b.R4_3_6_MONTHS AS R4_3_6_MONTHS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R4_3_6_MONTHS = b.R4_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo80(String report_date);
			
	///Srl_no81(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM RESIDENT BANKS - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R4_6_12_MONTHS AS R4_6_12_MONTHS_A, " +
		               "b.R4_6_12_MONTHS AS R4_6_12_MONTHS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R4_6_12_MONTHS = b.R4_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo81(String report_date);
		
	///Srl_no82(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R6_0_7_DAYS AS R6_0_7_DAYS_A, " +
		               "b.R6_0_7_DAYS AS R6_0_7_DAYS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R6_0_7_DAYS = b.R6_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo82(String report_date);
		
	///Srl_no83(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R6_8_14_DAYS AS R6_8_14_DAYS_A, " +
		               "b.R6_8_14_DAYS AS R6_8_14_DAYS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R6_8_14_DAYS = b.R6_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo83(String report_date);
			
	///Srl_no84(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R6_15_DAYS_1_MONTH AS R6_15_DAYS_1_MONTH_A, " +
		               "b.R6_15_DAYS_1_MONTH AS R6_15_DAYS_1_MONTH_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R6_15_DAYS_1_MONTH = b.R6_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo84(String report_date);
			
	///Srl_no85(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R6_1_3_MONTHS AS R6_1_3_MONTHS_A, " +
		               "b.R6_1_3_MONTHS AS R6_1_3_MONTHS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R6_1_3_MONTHS = b.R6_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo85(String report_date);
			
	///Srl_no86(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R6_3_6_MONTHS AS R6_3_6_MONTHS_A, " +
		               "b.R6_3_6_MONTHS AS R6_3_6_MONTHS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R6_3_6_MONTHS = b.R6_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo86(String report_date);
		
	///Srl_no87(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R6_6_12_MONTHS AS R6_6_12_MONTHS_A, " +
		               "b.R6_6_12_MONTHS AS R6_6_12_MONTHS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R6_6_12_MONTHS = b.R6_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo87(String report_date);
			
	///Srl_no88(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R6_1_2_YEARS, b.R6_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R6_1_2_YEARS = b.R6_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo88(String report_date);
			
	///Srl_no89(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R6_2_3_YEARS, b.R6_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R6_2_3_YEARS = b.R6_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo89(String report_date);
			
	///Srl_no90(FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R7_0_7_DAYS AS R7_0_7_DAYS_A, " +
		               "b.R7_0_7_DAYS AS R7_0_7_DAYS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R7_0_7_DAYS = b.R7_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo90(String report_date);
			
	///Srl_no91(FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R7_8_14_DAYS AS R7_8_14_DAYS_A, " +
		               "b.R7_8_14_DAYS AS R7_8_14_DAYS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R7_8_14_DAYS = b.R7_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo91(String report_date);
			
	///Srl_no92(FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R7_15_DAYS_1_MONTH AS R7_15_DAYS_1_MONTH_A, " +
		               "b.R7_15_DAYS_1_MONTH AS R7_15_DAYS_1_MONTH_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R7_15_DAYS_1_MONTH = b.R7_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo92(String report_date);
			
	///Srl_no93(FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R7_1_3_MONTHS AS R7_1_3_MONTHS_A, " +
		               "b.R7_1_3_MONTHS AS R7_1_3_MONTHS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R7_1_3_MONTHS = b.R7_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo93(String report_date);
			
	///Srl_no94(FOREIGN SOVEREIGN DEBT (RATED AA- OR HIGHER) - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R7_3_6_MONTHS AS R7_3_6_MONTHS_A, " +
		               "b.R7_3_6_MONTHS AS R7_3_6_MONTHS_B " +
		               "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
		               "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
		               "AND a.R7_3_6_MONTHS = b.R7_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo94(String report_date);
			
	///Srl_no95(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - OVERDRAFT(BRF 9))
			@Query(value = "SELECT a.R12_OVERDRAFT, b.R12_OVERDUE " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R12_OVERDRAFT = b.R12_OVERDUE", nativeQuery = true)
			List<Object[]> getCheckSrlNo95(String report_date);
			
	///Srl_no96(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - NON-INTEREST RATE SENSITIVE(BRF 9))
			@Query(value = "SELECT a.R12_NON_INTEREST, b.R12_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R12_NON_INTEREST = b.R12_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo96(String report_date);
			
	///Srl_no97(INVESTMENT IN EQUITIES - UNQUOTED - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R20_0_7_DAYS, b.R_18_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R20_0_7_DAYS = b.R_18_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo97(String report_date);
			
	///Srl_no98(INVESTMENT IN EQUITIES - UNQUOTED - NON-INTEREST RATE SENSITIVE(BRF 9))
			@Query(value = "SELECT a.R20_NON_INTEREST, b.R_18_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R20_NON_INTEREST = b.R_18_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo98(String report_date);
			
	///Srl_no99(NET FIXED ASSETS(BRF 9))
			@Query(value = "SELECT a.R22_NON_INTEREST, b.R21_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R22_NON_INTEREST = b.R21_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo99(String report_date);
		
	///Srl_no100(GOVERNMENT AND PUBLIC SECTOR(BRF 1))
			@Query(value = "SELECT a.R23_NON_INTEREST, b.R42_AMOUNT_FCY_NON_RESIDENT " +
						   "FROM BRF11_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R23_NON_INTEREST = b.R42_AMOUNT_FCY_NON_RESIDENT", nativeQuery = true)
			List<Object[]> getCheckSrlNo100(String report_date);
			
	///Srl_no101(OTHER ASSETS1 - Overdraft(BRF 9))
			@Query(value = "SELECT a.R32_OVERDRAFT, b.R31_OVERDRAFT " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_OVERDRAFT = b.R31_OVERDRAFT", nativeQuery = true)
			List<Object[]> getCheckSrlNo101(String report_date);
			
	///Srl_no102(OTHER ASSETS1 - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R32_0_7_DAYS, b.R31_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_0_7_DAYS = b.R31_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo102(String report_date);
			
	///Srl_no103(OTHER ASSETS1 - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R32_8_14_DAYS, b.R31_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_8_14_DAYS = b.R31_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo103(String report_date);
			
	///Srl_no104(OTHER ASSETS1 - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R32_15_DAYS_1_MONTH, b.R31_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_15_DAYS_1_MONTH = b.R31_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo104(String report_date);
			
	///Srl_no105(OTHER ASSETS1 - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R32_1_3_MONTHS, b.R31_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_1_3_MONTHS = b.R31_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo105(String report_date);
			
	///Srl_no106(OTHER ASSETS1 - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R32_3_6_MONTHS, b.R31_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_3_6_MONTHS = b.R31_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo106(String report_date);
			
	///Srl_no107(OTHER ASSETS1 - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R32_6_12_MONTHS, b.R31_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_6_12_MONTHS = b.R31_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo107(String report_date);
			
	///Srl_no108(OTHER ASSETS1 - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R32_1_2_YEARS, b.R31_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_1_2_YEARS = b.R31_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo108(String report_date);
			
	///Srl_no109(OTHER ASSETS1 - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R32_2_3_YEARS, b.R31_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_2_3_YEARS = b.R31_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo109(String report_date);
			
	///Srl_no110(DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R33_0_7_DAYS, b.R32_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R33_0_7_DAYS = b.R32_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo110(String report_date);
			
	///Srl_no111(DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R33_8_14_DAYS, b.R32_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R33_8_14_DAYS = b.R32_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo111(String report_date);
			
	///Srl_no112(DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R33_15_DAYS_1_MONTH, b.R32_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R33_15_DAYS_1_MONTH = b.R32_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo112(String report_date);
			
	///Srl_no113(DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R33_1_3_MONTHS, b.R32_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R33_1_3_MONTHS = b.R32_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo113(String report_date);
			
	///Srl_no114(DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R33_3_6_MONTHS, b.R32_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R33_3_6_MONTHS = b.R32_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo114(String report_date);

	///Srl_no115(DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R33_6_12_MONTHS, b.R32_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R33_6_12_MONTHS = b.R32_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo115(String report_date);
			
	///Srl_no116(DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R33_1_2_YEARS, b.R32_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R33_1_2_YEARS = b.R32_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo116(String report_date);
			
	///Srl_no117(DEPOSITS FROM AND BALANCES DUE TO RESIDENT BANKS - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R33_2_3_YEARS, b.R32_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R33_2_3_YEARS = b.R32_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo117(String report_date);
			
	///Srl_no118(INTERBANK CDS ISSUED - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R34_0_7_DAYS, b.R33_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R34_0_7_DAYS = b.R33_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo118(String report_date);
			
	///Srl_no119(INTERBANK CDS ISSUED - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R34_8_14_DAYS, b.R33_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R34_8_14_DAYS = b.R33_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo119(String report_date);
			
	///Srl_no120(INTERBANK CDS ISSUED - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R34_15_DAYS_1_MONTH, b.R33_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R34_15_DAYS_1_MONTH = b.R33_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo120(String report_date);
			
	///Srl_no121(INTERBANK CDS ISSUED - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R34_1_3_MONTHS, b.R33_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R34_1_3_MONTHS = b.R33_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo121(String report_date);
			
	///Srl_no122(INTERBANK CDS ISSUED - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R34_3_6_MONTHS, b.R33_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R34_3_6_MONTHS = b.R33_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo122(String report_date);

	///Srl_no123(INTERBANK CDS ISSUED - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R34_6_12_MONTHS, b.R33_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R34_6_12_MONTHS = b.R33_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo123(String report_date);
			
	///Srl_no124(INTERBANK CDS ISSUED - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R34_1_2_YEARS, b.R33_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R34_1_2_YEARS = b.R33_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo124(String report_date);
			
	///Srl_no125(INTERBANK CDS ISSUED - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R34_2_3_YEARS, b.R33_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R34_2_3_YEARS = b.R33_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo125(String report_date);
			
	///Srl_no126(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R35_0_7_DAYS, b.R34_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R35_0_7_DAYS = b.R34_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo126(String report_date);
			
	///Srl_no127(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R35_8_14_DAYS, b.R34_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R35_8_14_DAYS = b.R34_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo127(String report_date);
			
	///Srl_no128(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R35_15_DAYS_1_MONTH, b.R34_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R35_15_DAYS_1_MONTH = b.R34_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo128(String report_date);
			
	///Srl_no129(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R35_1_3_MONTHS, b.R34_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R35_1_3_MONTHS = b.R34_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo129(String report_date);
			
	///Srl_no130(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R35_3_6_MONTHS, b.R34_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R35_3_6_MONTHS = b.R34_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo130(String report_date);

	///Srl_no131(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R35_6_12_MONTHS, b.R34_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R35_6_12_MONTHS = b.R34_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo131(String report_date);
			
	///Srl_no132(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R35_1_2_YEARS, b.R34_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R35_1_2_YEARS = b.R34_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo132(String report_date);
			
	///Srl_no133(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R35_2_3_YEARS, b.R34_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R35_2_3_YEARS = b.R34_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo133(String report_date);
			
	///Srl_no134(REFINANCING UNDER GOVT. HOUSING SCHEME - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R36_0_7_DAYS, b.R35_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R36_0_7_DAYS = b.R35_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo134(String report_date);
			
	///Srl_no135(REFINANCING UNDER GOVT. HOUSING SCHEME - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R36_8_14_DAYS, b.R35_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R36_8_14_DAYS = b.R35_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo135(String report_date);
			
	///Srl_no136(REFINANCING UNDER GOVT. HOUSING SCHEME - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R36_15_DAYS_1_MONTH, b.R35_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R36_15_DAYS_1_MONTH = b.R35_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo136(String report_date);
			
	///Srl_no137(REFINANCING UNDER GOVT. HOUSING SCHEME - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R36_1_3_MONTHS, b.R35_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R36_1_3_MONTHS = b.R35_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo137(String report_date);
			
	///Srl_no138(REFINANCING UNDER GOVT. HOUSING SCHEME - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R36_3_6_MONTHS, b.R35_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R36_3_6_MONTHS = b.R35_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo138(String report_date);

	///Srl_no139(REFINANCING UNDER GOVT. HOUSING SCHEME - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R36_6_12_MONTHS, b.R35_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R36_6_12_MONTHS = b.R35_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo139(String report_date);
			
	///Srl_no140(REFINANCING UNDER GOVT. HOUSING SCHEME - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R36_1_2_YEARS, b.R35_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R36_1_2_YEARS = b.R35_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo140(String report_date);
			
	///Srl_no141(REFINANCING UNDER GOVT. HOUSING SCHEME - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R36_2_3_YEARS, b.R35_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R36_2_3_YEARS = b.R35_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo141(String report_date);
			
	///Srl_no142(DUE TO CENTRAL BANK - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R37_0_7_DAYS, b.R36_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R37_0_7_DAYS = b.R36_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo142(String report_date);
			
	///Srl_no143(DUE TO CENTRAL BANK - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R37_8_14_DAYS, b.R36_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R37_8_14_DAYS = b.R36_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo143(String report_date);
			
	///Srl_no144(DUE TO CENTRAL BANK - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R37_15_DAYS_1_MONTH, b.R36_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R37_15_DAYS_1_MONTH = b.R36_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo144(String report_date);
			
	///Srl_no145(DUE TO CENTRAL BANK - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R37_1_3_MONTHS, b.R36_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R37_1_3_MONTHS = b.R36_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo145(String report_date);
			
	///Srl_no146(DUE TO CENTRAL BANK - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R37_3_6_MONTHS, b.R36_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R37_3_6_MONTHS = b.R36_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo146(String report_date);

	///Srl_no147(DUE TO CENTRAL BANK - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R37_6_12_MONTHS, b.R36_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R37_6_12_MONTHS = b.R36_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo147(String report_date);
			
	///Srl_no148(DUE TO CENTRAL BANK - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R37_1_2_YEARS, b.R36_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R37_1_2_YEARS = b.R36_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo148(String report_date);
			
	///Srl_no149(DUE TO CENTRAL BANK - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R37_2_3_YEARS, b.R36_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R37_2_3_YEARS = b.R36_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo149(String report_date);
			
		///Srl_no150(GOVERNMENT AND PUBLIC SECTOR - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R38_8_14_DAYS, b.R37_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R38_8_14_DAYS = b.R37_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo150(String report_date);
			
	///Srl_no151(GOVERNMENT AND PUBLIC SECTOR - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R38_15_DAYS_1_MONTH, b.R37_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R38_15_DAYS_1_MONTH = b.R37_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo151(String report_date);
			
	///Srl_no152(GOVERNMENT AND PUBLIC SECTOR - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R38_1_3_MONTHS, b.R37_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R38_1_3_MONTHS = b.R37_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo152(String report_date);
			
	///Srl_no153(GOVERNMENT AND PUBLIC SECTOR - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R38_3_6_MONTHS, b.R37_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R38_3_6_MONTHS = b.R37_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo153(String report_date);

	///Srl_no154(GOVERNMENT AND PUBLIC SECTOR - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R38_6_12_MONTHS, b.R37_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R38_6_12_MONTHS = b.R37_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo154(String report_date);
			
	///Srl_no155(GOVERNMENT AND PUBLIC SECTOR - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R38_1_2_YEARS, b.R37_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R38_1_2_YEARS = b.R37_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo155(String report_date);
			
	///Srl_no156(GOVERNMENT AND PUBLIC SECTOR - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R38_2_3_YEARS, b.R37_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R38_2_3_YEARS = b.R37_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo156(String report_date);
			
	///Srl_no157(GRES (GOVT OWNERSHIP OF MORE THAN 50%) - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R39_0_7_DAYS, b.R38_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R39_0_7_DAYS = b.R38_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo157(String report_date);

	///Srl_no158(GRES (GOVT OWNERSHIP OF MORE THAN 50%) - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R39_8_14_DAYS, b.R38_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R39_8_14_DAYS = b.R38_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo158(String report_date);
			
	///Srl_no159(GRES (GOVT OWNERSHIP OF MORE THAN 50%) - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R39_15_DAYS_1_MONTH, b.R38_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R39_15_DAYS_1_MONTH = b.R38_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo159(String report_date);
			
	///Srl_no160(GRES (GOVT OWNERSHIP OF MORE THAN 50%) - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R39_1_3_MONTHS, b.R38_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R39_1_3_MONTHS = b.R38_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo160(String report_date);
			
	///Srl_no161(GRES (GOVT OWNERSHIP OF MORE THAN 50%) - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R39_3_6_MONTHS, b.R38_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R39_3_6_MONTHS = b.R38_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo161(String report_date);

	///Srl_no162(GRES (GOVT OWNERSHIP OF MORE THAN 50%) - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R39_6_12_MONTHS, b.R38_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R39_6_12_MONTHS = b.R38_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo162(String report_date);
			
	///Srl_no163(GRES (GOVT OWNERSHIP OF MORE THAN 50%) - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R39_1_2_YEARS, b.R38_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R39_1_2_YEARS = b.R38_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo163(String report_date);
			
	///Srl_no164(GRES (GOVT OWNERSHIP OF MORE THAN 50%) - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R39_2_3_YEARS, b.R38_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R39_2_3_YEARS = b.R38_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo164(String report_date);
			
	///Srl_no165(CAPITAL MARKET INSTRUMENTS - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R44_0_7_DAYS, b.R43_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R44_0_7_DAYS = b.R43_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo165(String report_date);

	///Srl_no166(CAPITAL MARKET INSTRUMENTS - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R44_8_14_DAYS, b.R43_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R44_8_14_DAYS = b.R43_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo166(String report_date);
			
	///Srl_no167(CAPITAL MARKET INSTRUMENTS - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R44_15_DAYS_1_MONTH, b.R43_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R44_15_DAYS_1_MONTH = b.R43_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo167(String report_date);
			
	///Srl_no168(CAPITAL MARKET INSTRUMENTS - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R44_1_3_MONTHS, b.R43_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R44_1_3_MONTHS = b.R43_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo168(String report_date);
			
	///Srl_no169(CAPITAL MARKET INSTRUMENTS - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R44_3_6_MONTHS, b.R43_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R44_3_6_MONTHS = b.R43_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo169(String report_date);

	///Srl_no170(CAPITAL MARKET INSTRUMENTS - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R44_6_12_MONTHS, b.R43_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R44_6_12_MONTHS = b.R43_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo170(String report_date);
			
	///Srl_no171(CAPITAL MARKET INSTRUMENTS - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R44_2_3_YEARS, b.R43_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R44_2_3_YEARS = b.R43_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo171(String report_date);
			
	///Srl_no172(OTHER LIABILITIES - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R45_0_7_DAYS, b.R44_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R45_0_7_DAYS = b.R44_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo172(String report_date);
			
	///Srl_no173(OTHER LIABILITIES - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R45_8_14_DAYS, b.R44_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R45_8_14_DAYS = b.R44_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo173(String report_date);
			
	///Srl_no174(OTHER LIABILITIES - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R45_15_DAYS_1_MONTH, b.R44_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R45_15_DAYS_1_MONTH = b.R44_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo174(String report_date);
			
	///Srl_no175(OTHER LIABILITIES - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R45_1_3_MONTHS, b.R44_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R45_1_3_MONTHS = b.R44_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo175(String report_date);
			
	///Srl_no176(OTHER LIABILITIES - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R45_3_6_MONTHS, b.R44_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R45_3_6_MONTHS = b.R44_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo176(String report_date);

	///Srl_no177(OTHER LIABILITIES - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R45_6_12_MONTHS, b.R44_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R45_6_12_MONTHS = b.R44_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo177(String report_date);
			
	///Srl_no178(OTHER LIABILITIES - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R45_1_2_YEARS, b.R44_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R45_1_2_YEARS = b.R44_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo178(String report_date);
			
	///Srl_no179(OTHER LIABILITIES - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R45_2_3_YEARS, b.R44_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R45_2_3_YEARS = b.R44_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo179(String report_date);
			
	///Srl_no180(PROVISIONS - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R46_0_7_DAYS, b.R45_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R46_0_7_DAYS = b.R45_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo180(String report_date);
			
	///Srl_no181(PROVISIONS - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R46_8_14_DAYS, b.R45_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R46_8_14_DAYS = b.R45_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo181(String report_date);
			
	///Srl_no182(PROVISIONS - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R46_15_DAYS_1_MONTH, b.R45_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R46_15_DAYS_1_MONTH = b.R45_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo182(String report_date);
			
	///Srl_no183(PROVISIONS - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R46_3_6_MONTHS, b.R45_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R46_3_6_MONTHS = b.R45_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo183(String report_date);

	///Srl_no184(PROVISIONS - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R46_6_12_MONTHS, b.R45_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R46_6_12_MONTHS = b.R45_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo184(String report_date);
			
	///Srl_no185(PROVISIONS - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R46_1_2_YEARS, b.R45_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R46_1_2_YEARS = b.R45_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo185(String report_date);
			
	///Srl_no186(PROVISIONS - 2 - 3 years(BRF 9))
			@Query(value = "SELECT a.R46_2_3_YEARS, b.R45_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R46_2_3_YEARS = b.R45_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo186(String report_date);
			
	///Srl_no187(PROVISIONS - NON-INTEREST RATE SENSITIVE(BRF 9))
			@Query(value = "SELECT a.R46_NON_INTEREST, b.R45_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R46_NON_INTEREST = b.R45_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo187(String report_date);
			
	///Srl_no188(CAPITAL AND RESERVES - 0 - 7 days(BRF 9))
			@Query(value = "SELECT a.R47_0_7_DAYS, b.R46_0_7_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R47_0_7_DAYS = b.R46_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo188(String report_date);

	///Srl_no189(CAPITAL AND RESERVES - 8-14 days(BRF 9))
			@Query(value = "SELECT a.R47_8_14_DAYS, b.R46_8_14_DAYS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R47_8_14_DAYS = b.R46_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo189(String report_date);
			
	///Srl_no190(CAPITAL AND RESERVES - 15 days - 1 month(BRF 9))
			@Query(value = "SELECT a.R47_15_DAYS_1_MONTH, b.R46_15_DAYS_1_MONTH " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R47_15_DAYS_1_MONTH = b.R46_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo190(String report_date);
			
	///Srl_no191(CAPITAL AND RESERVES - 1 - 3 months(BRF 9))
			@Query(value = "SELECT a.R47_1_3_MONTHS, b.R46_1_3_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R47_1_3_MONTHS = b.R46_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo191(String report_date);
			
	///Srl_no192(CAPITAL AND RESERVES - 3 -  6 months(BRF 9))
			@Query(value = "SELECT a.R47_3_6_MONTHS, b.R46_3_6_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R47_3_6_MONTHS = b.R46_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo192(String report_date);

	///Srl_no193(CAPITAL AND RESERVES - 6 -12 months(BRF 9))
			@Query(value = "SELECT a.R47_6_12_MONTHS, b.R46_6_12_MONTHS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R47_6_12_MONTHS = b.R46_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo193(String report_date);
			
	///Srl_no194(CAPITAL AND RESERVES - 1 - 2 years(BRF 9))
			@Query(value = "SELECT a.R47_1_2_YEARS, b.R46_1_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R47_1_2_YEARS = b.R46_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo194(String report_date);
			
	///Srl_no195(CAPITAL AND RESERVES - NON-INTEREST RATE SENSITIVE(BRF 9))
			@Query(value = "SELECT a.R47_NON_INTEREST, b.R46_3_YEARS " +
						   "FROM BRF11_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R47_NON_INTEREST = b.R46_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo195(String report_date);
			
	////Srl_no196
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo196(String report_date);

	////Srl_no197
	@Query(value = "SELECT count(*) from BRF11_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo197(String report_date);
	
	 ////Srl_no198
	@Query(value = "SELECT count(*) from BRF11_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo198(String report_date);
	
	///BRF-10
	////Srl_no199
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo199(String report_date);

	////Srl_no200
	@Query(value = "SELECT count(*) from BRF10_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo200(String report_date);
	
	 ////Srl_no201
	@Query(value = "SELECT count(*) from BRF10_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo201(String report_date);
	///BRF-12
	////Srl_no202
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo202(String report_date);

	////Srl_no203
	@Query(value = "SELECT count(*) from BRF12_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo203(String report_date);
	
	 ////Srl_no204
	@Query(value = "SELECT count(*) from BRF12_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo204(String report_date);
	
	///BRF-13
	////Srl_no205
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo205(String report_date);

	////Srl_no206
	@Query(value = "SELECT count(*) from BRF13_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo206(String report_date);
	
	 ////Srl_no207
	@Query(value = "SELECT count(*) from BRF13_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo207(String report_date);
	
	///Srl_no208(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - OVERDUE (BRF 9))
			@Query(value ="SELECT a.R5_OVERDUE, b.R6_OVERDUE " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R5_OVERDUE = b.R6_OVERDUE", nativeQuery = true)
			List<Object[]> getCheckSrlNo208(String report_date);
			
	///Srl_no209(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 0 - 7 DAYS (BRF 9))
			@Query(value ="SELECT a.R5_0_7_DAYS, b.R6_0_7_DAYS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R5_0_7_DAYS = b.R6_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo209(String report_date);
			
	///Srl_no210(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 8 - 14 DAYS (BRF 9))
			@Query(value ="SELECT a.R5_8_14_DAYS, b.R6_8_14_DAYS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R5_8_14_DAYS = b.R6_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo210(String report_date);
			
	///Srl_no211(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 15 DAYS - 1 MONTH (BRF 9))
			@Query(value ="SELECT a.R5_15_DAYS_1_MONTH, b.R6_15_DAYS_1_MONTH " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R5_15_DAYS_1_MONTH = b.R6_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo211(String report_date);
			
	///Srl_no212(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 3 MONTHS (BRF 9))
			@Query(value ="SELECT a.R5_1_3_MONTHS, b.R6_1_3_MONTHS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R5_1_3_MONTHS = b.R6_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo212(String report_date);
			
	///Srl_no213(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 3 - 6 MONTHS (BRF 9))
			@Query(value ="SELECT a.R5_3_6_MONTHS, b.R6_3_6_MONTHS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R5_3_6_MONTHS = b.R6_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo213(String report_date);
			
	///Srl_no214(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 6 - 12 MONTHS (BRF 9))
			@Query(value ="SELECT a.R5_6_12_MONTHS, b.R6_6_12_MONTHS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R5_6_12_MONTHS = b.R6_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo214(String report_date);
			
	///Srl_no215(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - 1 - 3 YEARS (BRF 9))
			@Query(value ="SELECT a.R5_1_3_YEARS, b.R6_1_3_YEARS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R5_1_3_YEARS = b.R6_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo215(String report_date);
			
	///Srl_no216(PLACEMENTS/ LOANS WITH AND BALANCES DUE FROM OVERSEAS BANKS - > 3 YEARS (BRF 9))
			@Query(value ="SELECT a.R5_3_YEARS, b.R6_3_YEARS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R5_3_YEARS = b.R6_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo216(String report_date);
			
	///Srl_no217(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - OVERDUE (BRF 9))
			@Query(value ="SELECT a.R11_OVERDUE, b.R12_OVERDUE " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R11_OVERDUE = b.R12_OVERDUE", nativeQuery = true)
			List<Object[]> getCheckSrlNo217(String report_date);
			
	///Srl_no218(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - OVERDRAFT (BRF 9))
			@Query(value ="SELECT a.R11_OVERDRAFT, b.R12_OVERDRAFT " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R11_OVERDRAFT = b.R12_OVERDRAFT", nativeQuery = true)
			List<Object[]> getCheckSrlNo218(String report_date);
			
	///Srl_no219(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 0 - 7 DAYS (BRF 9))
			@Query(value ="SELECT a.R11_0_7_DAYS, b.R12_0_7_DAYS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R11_0_7_DAYS = b.R12_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo219(String report_date);
			
	///Srl_no220(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 8 - 14 DAYS (BRF 9))
			@Query(value ="SELECT a.R11_8_14_DAYS, b.R12_8_14_DAYS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R11_8_14_DAYS = b.R12_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo220(String report_date);
			
	///Srl_no221(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 15 DAYS - 1 MONTH (BRF 9))
			@Query(value ="SELECT a.R11_15_DAYS_1_MONTH, b.R12_15_DAYS_1_MONTH " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R11_15_DAYS_1_MONTH = b.R12_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo221(String report_date);
			
	///Srl_no222(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 1 - 3 MONTHS (BRF 9))
			@Query(value ="SELECT a.R11_1_3_MONTHS, b.R12_1_3_MONTHS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R11_1_3_MONTHS = b.R12_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo222(String report_date);
			
	///Srl_no223(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 3 - 6 MONTHS (BRF 9))
			@Query(value ="SELECT a.R11_3_6_MONTHS, b.R12_3_6_MONTHS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R11_3_6_MONTHS = b.R12_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo223(String report_date);
			
	///Srl_no224(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 6 - 12 MONTHS (BRF 9))
			@Query(value ="SELECT a.R11_6_12_MONTHS, b.R12_6_12_MONTHS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R11_6_12_MONTHS = b.R12_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo224(String report_date);
			
	///Srl_no225(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - 1 - 3 YEARS (BRF 9))
			@Query(value ="SELECT a.R11_1_3_YEARS, b.R12_1_3_YEARS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R11_1_3_YEARS = b.R12_1_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo225(String report_date);
			
	///Srl_no226(NON-UAE PUBLIC SECTOR ENTERPRISES DEBT/ SUKUKS - > 3 YEARS (BRF 9))
			@Query(value ="SELECT a.R11_3_YEARS, b.R12_3_YEARS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R11_3_YEARS = b.R12_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo226(String report_date);
			
	///Srl_no227(CORPORATE BONDS/ SUKUKS  - > 3 YEARS (BRF 9))
			@Query(value ="SELECT a.R15_3_YEARS, b.R16_3_YEARS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R15_3_YEARS = b.R16_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo227(String report_date);

	///Srl_no228(INVESTMENT IN EQUITIES - UNQUOTED  - > 3 YEARS (BRF 9))
			@Query(value ="SELECT a.R18_3_YEARS, b.R19_3_YEARS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R18_3_YEARS = b.R19_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo228(String report_date);
			
	///Srl_no229(GOVERNMENT AND PUBLIC SECTOR  - > 3 YEARS (BRF 9))
			@Query(value ="SELECT a.R21_3_YEARS, b.R22_3_YEARS " +
						  "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R21_3_YEARS = b.R22_3_YEARS", nativeQuery = true)
			List<Object[]> getCheckSrlNo229(String report_date);
			
	///Srl_no230(OTHER ASSETS1 - 15 DAYS - 1 MONTH (BRF 1))
			@Query(value = "SELECT a.R30_15_DAYS_1_MONTH, b.R65_AMOUNT_AED_NON_RESIDENT, b.R65_AMOUNT_FCY_NON_RESIDENT " +
						   "FROM BRF13_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R30_15_DAYS_1_MONTH = (b.R65_AMOUNT_AED_NON_RESIDENT + b.R65_AMOUNT_FCY_NON_RESIDENT)", nativeQuery = true)
			List<Object[]> getCheckSrlNo230(String report_date);
			
	///Srl_no231(OTHER ASSETS1 - 1 - 3 MONTHS (BRF 1))
			@Query(value = "SELECT a.R30_1_3_MONTHS, b.R70_AMOUNT_AED_NON_RESIDENT, b.R70_AMOUNT_FCY_NON_RESIDENT " +
						   "FROM BRF13_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R30_1_3_MONTHS = (b.R70_AMOUNT_AED_NON_RESIDENT + b.R70_AMOUNT_FCY_NON_RESIDENT)", nativeQuery = true)
			List<Object[]> getCheckSrlNo231(String report_date);
			
	///Srl_no232(OTHER ASSETS1 - 3 - 6 MONTHS (BRF 1))
			@Query(value = "SELECT a.R30_3_6_MONTHS, b.R71_AMOUNT_AED_NON_RESIDENT, b.R71_AMOUNT_FCY_NON_RESIDENT " +
						   "FROM BRF13_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R30_3_6_MONTHS = (b.R71_AMOUNT_AED_NON_RESIDENT + b.R71_AMOUNT_FCY_NON_RESIDENT)", nativeQuery = true)
			List<Object[]> getCheckSrlNo232(String report_date);
			
	///Srl_no233(OTHER ASSETS1  - 6 - 12 MONTHS (BRF 1))
			@Query(value ="SELECT a.R30_6_12_MONTHS, b.R66_AMOUNT_AED_NON_RESIDENT " +
						  "FROM BRF13_SUMMARYTABLE a, BRF1_SUMMARYTABLE b " +
						  "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						  "AND a.R30_6_12_MONTHS = b.R66_AMOUNT_AED_NON_RESIDENT", nativeQuery = true)
			List<Object[]> getCheckSrlNo233(String report_date);
			
	///Srl_no234(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 0 - 7 DAYS (BRF 9))
			@Query(value = "SELECT a.R32_0_7_DAYS, b.R34_0_7_DAYS " +
						   "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_0_7_DAYS = b.R34_0_7_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo234(String report_date);
			
	///Srl_no235(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 8 - 14 DAYS (BRF 9))
			@Query(value = "SELECT a.R32_8_14_DAYS, b.R34_8_14_DAYS " +
						   "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_8_14_DAYS = b.R34_8_14_DAYS", nativeQuery = true)
			List<Object[]> getCheckSrlNo235(String report_date);
			
	///Srl_no236(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 15 DAYS - 1 MONTH (BRF 9))
			@Query(value = "SELECT a.R32_15_DAYS_1_MONTH, b.R34_15_DAYS_1_MONTH " +
						   "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_15_DAYS_1_MONTH = b.R34_15_DAYS_1_MONTH", nativeQuery = true)
			List<Object[]> getCheckSrlNo236(String report_date);
			
	///Srl_no237(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 1 - 3 MONTHS (BRF 9))
			@Query(value = "SELECT a.R32_1_3_MONTHS, b.R34_1_3_MONTHS " +
						   "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_1_3_MONTHS = b.R34_1_3_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo237(String report_date);
			
	///Srl_no238(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 3 - 6 MONTHS (BRF 9))
			@Query(value = "SELECT a.R32_3_6_MONTHS, b.R34_3_6_MONTHS " +
						   "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_3_6_MONTHS = b.R34_3_6_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo238(String report_date);
			
	///Srl_no239(DEPOSITS FROM AND BALANCES DUE TO OVERSEAS BANKS - 6 - 12 MONTHS (BRF 9))
			@Query(value = "SELECT a.R32_6_12_MONTHS, b.R34_6_12_MONTHS " +
						   "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R32_6_12_MONTHS = b.R34_6_12_MONTHS", nativeQuery = true)
			List<Object[]> getCheckSrlNo239(String report_date);
			
	///Srl_no240(CAPITAL MARKET INSTRUMENTS - 0 - 7 DAYS (BRF 9))
			@Query(value = "SELECT a.R41_0_7_DAYS, b.R43_0_7_DAYS, b.R43_8_14_DAYS, b.R43_1_3_MONTHS, b.R43_3_6_MONTHS, b.R43_6_12_MONTHS, b.R43_1_3_YEARS, b.R43_3_YEARS " +
						   "FROM BRF13_SUMMARYTABLE a, BRF9_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R41_0_7_DAYS = (b.R43_0_7_DAYS + b.R43_8_14_DAYS + b.R43_1_3_MONTHS + b.R43_3_6_MONTHS + b.R43_6_12_MONTHS + b.R43_1_3_YEARS + b.R43_3_YEARS)", nativeQuery = true)
			List<Object[]> getCheckSrlNo240(String report_date);

	///Srl_no241(OTHER LIABILITIES - 3 - 6 MONTHS (BRF 2))
			@Query(value = "SELECT a.R42_3_6_MONTHS, b.R59_AMOUNT_AED_NON_RESIDENT, b.R58_AMOUNT_AED_NON_RESIDENT, b.R57_AMOUNT_AED_NON_RESIDENT, b.R55_AMOUNT_AED_NON_RESIDENT, b.R54_AMOUNT_AED_NON_RESIDENT, b.R53_AMOUNT_AED_NON_RESIDENT, b.R29_AMOUNT_AED_NON_RESIDENT, " +
						   "b.R59_AMOUNT_FCY_NON_RESIDENT, b.R58_AMOUNT_FCY_NON_RESIDENT, b.R57_AMOUNT_FCY_NON_RESIDENT, b.R55_AMOUNT_FCY_NON_RESIDENT, b.R54_AMOUNT_FCY_NON_RESIDENT, b.R53_AMOUNT_FCY_NON_RESIDENT, b.R29_AMOUNT_FCY_NON_RESIDENT " +
						   "FROM BRF13_SUMMARYTABLE a, BRF2_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R42_3_6_MONTHS = (b.R59_AMOUNT_AED_NON_RESIDENT + b.R58_AMOUNT_AED_NON_RESIDENT + b.R57_AMOUNT_AED_NON_RESIDENT + b.R55_AMOUNT_AED_NON_RESIDENT + b.R54_AMOUNT_AED_NON_RESIDENT + b.R53_AMOUNT_AED_NON_RESIDENT + b.R29_AMOUNT_AED_NON_RESIDENT + " +
													 "b.R59_AMOUNT_FCY_NON_RESIDENT + b.R58_AMOUNT_FCY_NON_RESIDENT + b.R57_AMOUNT_FCY_NON_RESIDENT + b.R55_AMOUNT_FCY_NON_RESIDENT + b.R54_AMOUNT_FCY_NON_RESIDENT + b.R53_AMOUNT_FCY_NON_RESIDENT + b.R29_AMOUNT_FCY_NON_RESIDENT)", nativeQuery = true)
			List<Object[]> getCheckSrlNo241(String report_date);
			
	///Srl_no242(PROVISIONS - 0 - 7 DAYS (BRF 2))
			@Query(value = "SELECT a.R43_0_7_DAYS, b.R47_AMOUNT_AED_NON_RESIDENT, b.R52_AMOUNT_AED_NON_RESIDENT, b.R51_AMOUNT_AED_NON_RESIDENT, b.R47_AMOUNT_FCY_NON_RESIDENT, b.R52_AMOUNT_FCY_NON_RESIDENT, b.R51_AMOUNT_FCY_NON_RESIDENT " +
						   "FROM BRF13_SUMMARYTABLE a, BRF2_SUMMARYTABLE b " +
						   "WHERE a.REPORT_DATE = ?1 AND b.REPORT_DATE = ?1 " +
						   "AND a.R43_0_7_DAYS = (b.R47_AMOUNT_AED_NON_RESIDENT + b.R52_AMOUNT_AED_NON_RESIDENT + b.R51_AMOUNT_AED_NON_RESIDENT + b.R47_AMOUNT_FCY_NON_RESIDENT + b.R52_AMOUNT_FCY_NON_RESIDENT + b.R51_AMOUNT_FCY_NON_RESIDENT)", nativeQuery = true)
			List<Object[]> getCheckSrlNo242(String report_date);
			
	///BRF-14
	////Srl_no243
	@Query(value = "Select count(*) from BRF_TREASURY_MASTER_TB where report_date=?1", nativeQuery = true)
	 Integer getCheckSrlNo243(String report_date);

	////Srl_no244
	@Query(value = "SELECT count(*) from BRF14_DETAILTABLE where REPORT_DATE=?1 AND REPORT_LABEL_1 IS NULL", nativeQuery = true)
	Integer getCheckSrlNo244(String report_date);
	
	 ////Srl_no255
	@Query(value = "SELECT count(*) from BRF14_SUMMARYTABLE where REPORT_DATE=?1", nativeQuery = true)
	Integer getCheckSrlNo245(String report_date);
	
	
	
	/*////Srl_no5
	@Query(value = "SELECT (NVL(a.TOT_BY_PRODUCT4_LOW_DEBIT_TRAN_AMOUNT,0)+NVL(a.TOT_BY_PRODUCT6_LOW_CREDIT_TRAN_AMOUNT,0)+NVL(b.TOT_BY_PRODUCT4_LOW_DEBIT_TRAN_AMOUNT,0)+NVL(b.TOT_BY_PRODUCT6_LOW_CREDIT_TRAN_AMOUNT,0))as LOW_COUNT,"
			+ "(NVL(a.TOT_BY_PRODUCT9_MEDIUM_DEBIT_TRAN_AMOUNT,0)+NVL(a.TOT_BY_PRODUCT11_MEDIUM_CREDIT_TRAN_COUNT,0)+NVL(b.TOT_BY_PRODUCT9_MEDIUM_DEBIT_TRAN_AMOUNT,0)+NVL(b.TOT_BY_PRODUCT11_MEDIUM_CREDIT_TRAN_COUNT,0))as MEDIUM_COUNT,"
			+ "(NVL(a.TOT_BY_PRODUCT14_HIGH_DEBIT_TRAN_AMOUNT,0)+NVL(a.TOT_BY_PRODUCT16_HIGH_CREDIT_TRAN_AMOUNT,0)+NVL(b.TOT_BY_PRODUCT14_HIGH_DEBIT_TRAN_AMOUNT,0)+NVL(b.TOT_BY_PRODUCT16_HIGH_CREDIT_TRAN_AMOUNT,0))as HIGH_COUNT,"
			+ "c.TOTAL_SUM_LOW_TRAN_AMT,c.TOTAL_SUMMED_TRAN_AMT,c.TOTAL_SUMHIGH_TRAN_AMT FROM T5A_PROFILE_FACE_TO_FACE a,T5B_PROFILE_NON_FACE_TO_FACE b,T12A_TRAN_CUST_TYPE_TABLE c WHERE a.REPORT_rpt_code=b.REPORT_rpt_code and b.REPORT_rpt_code=c.REPORT_rpt_code and a.REPORT_rpt_code=?1", nativeQuery = true)
	List<Object[]> getCheckSrlNo5(String rpt_code);
	
	////Srl_no6
	@Query(value = "SELECT NVL(a.CASH_DEP_LOW_TRAN_COUNT,0),NVL(a.CASH_DEP_LOW_TRAN_AMT,0),NVL(a.CASH_DEPMED_TRAN_COUNT,0),NVL(a.CASH_DEPMED_TRAN_AMT,0),NVL(a.CASH_DEPHIGH_TRAN_COUNT,0),NVL(a.CASH_DEPHIGH_TRAN_AMT,0),"
			+ "NVL(b.c8f_cur_total_nof_dep_tran_low,0),NVL(b.c8g_cur_total_to_val_tran_low,0),NVL(b.c8d_cur_total_nof_dep_tran_med,0),NVL(b.c8e_cur_total_to_val_tran_med,0),NVL(b.c8b_cur_total_nof_dep_tran_hig,0),"
			+ "NVL(b.c8c_cur_total_to_val_tran_hig,0) FROM T12A_TRAN_CUST_TYPE_TABLE a,T16A_IND_CASH_DEP_TABLE b WHERE a.report_rpt_code=b.report_rpt_code and a.REPORT_rpt_code=?1", nativeQuery = true)
	List<Object[]> getCheckSrlNo6(String rpt_code);
	
    ////Srl_no7
	@Query(value = "SELECT NVL(a.CASH_WITHD_LOW_TRAN_COUNT,0),NVL(a.CASH_WITHD_LOW_TRAN_AMT,0),NVL(a.CASH_WITHDMED_TRAN_COUNT,0),NVL(a.CASH_WITHDMED_TRAN_AMT,0),NVL(a.CASH_WITHDHIGH_TRAN_COUNT,0),"
			+ "NVL(a.CASH_WITHDHIGH_TRAN_AMT,0),NVL(b.c8f_cur_total_nof_dep_tran_low,0),NVL(b.c8g_cur_total_to_val_tran_low,0),NVL(b.c8d_cur_total_nof_dep_tran_med,0),NVL(b.c8e_cur_total_to_val_tran_med,0),"
			+ "NVL(b.c8b_cur_total_nof_dep_tran_hig,0),NVL(b.c8c_cur_total_to_val_tran_hig,0) FROM T12A_TRAN_CUST_TYPE_TABLE a,T16B_IND_CASH_WITHDRAW_TABLE b WHERE a.report_rpt_code=b.report_rpt_code and a.REPORT_rpt_code=?1", nativeQuery = true)
	List<Object[]> getCheckSrlNo7(String rpt_code);
	
    ////Srl_no8
	@Query(value = "SELECT NVL(a.DOM_INW_LOW_TRAN_COUNT,0),NVL(a.DOM_INW_LOW_TRAN_AMT,0),NVL(a.DOM_INWMED_TRAN_COUNT,0),NVL(a.DOM_INWMED_TRAN_AMT,0),NVL(a.DOM_INWHIGH_TRAN_COUNT,0),NVL(a.DOM_INWHIGH_TRAN_AMT,0),"
			+ "NVL(b.C10_TOTAL_LOW_TRAN_COUNT,0),NVL(b.C10_TOTAL_LOW_TRAN_AMT,0),NVL(b.C10_TOTAL_MEDIUM_TRAN_COUNT,0),NVL(b.C10_TOTAL_MEDUM_TRAN_AMT,0),NVL(b.C10_TOTAL_HIGH_TRAN_COUNT,0),NVL(b.C10_TOTAL_HIGH_TRAN_AMT,0) "
			+ "FROM T12A_TRAN_CUST_TYPE_TABLE a ,T12G_DOMESTIC_INWARD_REMITTANCE b WHERE a.report_rpt_code=b.report_rpt_code and a.REPORT_rpt_code=?1", nativeQuery = true)
	List<Object[]> getCheckSrlNo8(String rpt_code);
	
	 ////Srl_no9
	@Query(value = "SELECT a.DOM_OUT_LOW_TRAN_COUNT,a.DOM_OUT_LOW_TRAN_AMT,a.DOM_OUTMED_TRAN_COUNT,a.DOM_OUTMED_TRAN_AMT,a.DOM_OUTHIGH_TRAN_COUNT,a.DOM_OUTHIGH_TRAN_AMT,b.C10_TOTAL_LOW_TRAN_COUNT,"
			+ "b.C10_TOTAL_LOW_TRAN_AMT,b.C10_TOTAL_MEDIUM_TRAN_COUNT,b.C10_TOTAL_MEDUM_TRAN_AMT,b.C10_TOTAL_HIGH_TRAN_COUNT,b.C10_TOTAL_HIGH_TRAN_AMT FROM T12A_TRAN_CUST_TYPE_TABLE a,"
			+ "T12F_DOMESTIC_OUTWARD_REMITTANCE b WHERE a.report_rpt_code=b.report_rpt_code and  a.REPORT_rpt_code=?1", nativeQuery = true)
	List<Object[]> getCheckSrlNo9(String rpt_code);
	
	 ////Srl_no10
	@Query(value = "SELECT a.INT_TRADE_INW_LOW_TRAN_COUNT,a.INT_TRADE_INW_LOW_TRAN_AMT,a.INT_TRADE_INWMED_TRAN_COUNT,a.INT_TRADE_INWMED_TRAN_AMT,a.INT_TRADE_INWHIGH_TRAN_COUNT,a.INT_TRADE_INWHIGH_TRAN_AMT,"
			+ "(NVL(b.C10_TOTAL_LOW_CN_LOW_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_LOW_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_LOW_TRAN_COUNT,0))as LOW_COUNT,(NVL(b.C10_TOTAL_LOW_CN_LOW_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_LOW_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_LOW_TRAN_AMT,0))as LOW_AMT,"
			+ "(NVL(b.C10_TOTAL_LOW_CN_MEDIUM_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_MEDIUM_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_MEDIUM_TRAN_COUNT,0))as MED_COUNT,(NVL(b.C10_TOTAL_LOW_CN_MEDUM_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_MEDUM_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_MEDUM_TRAN_AMT,0))as MED_AMT,"
			+ "(NVL(b.C10_TOTAL_LOW_CN_HIGH_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_HIGH_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_HIGH_TRAN_COUNT,0))as HIGH_COUNT,(NVL(b.C10_TOTAL_LOW_CN_HIGH_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_HIGH_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_HIGH_TRAN_AMT,0))as HIGH_AMT FROM T12A_TRAN_CUST_TYPE_TABLE a,T12B_INTERNATIONAL_TRADE_RELATED_INWARD_REMITTANCE b WHERE a.report_rpt_code=b.report_rpt_code and a.REPORT_rpt_code=?1", nativeQuery = true)
	List<Object[]> getCheckSrlNo10(String rpt_code);
	
    ////Srl_no11
	@Query(value = "SELECT a.INT_TRADE_OUT_LOW_TRAN_COUNT,a.INT_TRADE_OUT_LOW_TRAN_AMT,a.INT_TRADE_OUTMED_TRAN_COUNT,a.INT_TRADE_OUTMED_TRAN_AMT,a.INT_TRADE_OUTHIGH_TRAN_COUNT,a.INT_TRADE_OUTHIGH_TRAN_AMT,"
			+ "(NVL(b.C10_TOTAL_LOW_CN_LOW_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_LOW_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_LOW_TRAN_COUNT,0))as LOW_COUNT,(NVL(b.C10_TOTAL_LOW_CN_LOW_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_LOW_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_LOW_TRAN_AMT,0))as LOW_AMT,"
			+ "(NVL(b.C10_TOTAL_LOW_CN_MEDIUM_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_MEDIUM_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_MEDIUM_TRAN_COUNT,0))as MED_COUNT,(NVL(b.C10_TOTAL_LOW_CN_MEDUM_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_MEDUM_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_MEDUM_TRAN_AMT,0))as MED_AMT,"
			+ "(NVL(b.C10_TOTAL_LOW_CN_HIGH_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_HIGH_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_HIGH_TRAN_COUNT,0))as HIGH_COUNT,(NVL(b.C10_TOTAL_LOW_CN_HIGH_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_HIGH_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_HIGH_TRAN_AMT,0))as HIGH_AMT FROM T12A_TRAN_CUST_TYPE_TABLE a,"
			+ "T12C_INTERNATIONAL_TRADE_RELATED_OUTWARD_REMITTANCE b WHERE a.report_rpt_code=b.report_rpt_code and a.REPORT_rpt_code=?1", nativeQuery = true)
	List<Object[]> getCheckSrlNo11(String rpt_code);
	
    ////Srl_no12
	@Query(value = "SELECT a.INT_NON_TRADE_INW_LOW_TRAN_COUNT,a.INT_NON_TRADE_INW_LOW_TRAN_AMT,a.INT_NON_TRADE_INWMED_TRAN_COUNT,a.INT_NON_TRADE_INWMED_TRAN_AMT,"
			+ "a.INT_NON_TRADE_INWHIGH_TRAN_COUNT,a.INT_NON_TRADE_INWHIGH_TRAN_AMT,(NVL(b.C10_TOTAL_LOW_CN_LOW_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_LOW_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_LOW_TRAN_COUNT,0))as LOW_COUNT,(NVL(b.C10_TOTAL_LOW_CN_LOW_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_LOW_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_LOW_TRAN_AMT,0))as LOW_AMT,"
			+ "(NVL(b.C10_TOTAL_LOW_CN_MEDIUM_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_MEDIUM_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_MEDIUM_TRAN_COUNT,0))as MED_COUNT,(NVL(b.C10_TOTAL_LOW_CN_MEDUM_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_MEDUM_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_MEDUM_TRAN_AMT,0))as MED_AMT,"
			+ "(NVL(b.C10_TOTAL_LOW_CN_HIGH_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_HIGH_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_HIGH_TRAN_COUNT,0))as HIGH_COUNT,(NVL(b.C10_TOTAL_LOW_CN_HIGH_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_HIGH_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_HIGH_TRAN_AMT,0))as HIGH_AMT FROM T12A_TRAN_CUST_TYPE_TABLE a,T12E_INTERNATIONAL_NON_TRADE_RELATED_OUTWARD_REMITTANCE b WHERE a.report_rpt_code=b.report_rpt_code and a.REPORT_rpt_code=?1", nativeQuery = true)
	List<Object[]> getCheckSrlNo12(String rpt_code);
	
    ////Srl_no13
	@Query(value = "SELECT a.INT_NON_TRADE_OUT_LOW_TRAN_COUNT,a.INT_NON_TRADE_OUT_LOW_TRAN_AMT,a.INT_NON_TRADE_OUTMED_TRAN_COUNT,a.INT_NON_TRADE_OUTMED_TRAN_AMT,"
			+ "a.INT_NON_TRADE_OUTHIGH_TRAN_COUNT,a.INT_NON_TRADE_OUTHIGH_TRAN_AMT,(NVL(b.C10_TOTAL_LOW_CN_LOW_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_LOW_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_LOW_TRAN_COUNT,0))as LOW_COUNT,"
			+ "(NVL(b.C10_TOTAL_LOW_CN_LOW_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_LOW_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_LOW_TRAN_AMT,0))as LOW_AMT,(NVL(b.C10_TOTAL_LOW_CN_MEDIUM_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_MEDIUM_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_MEDIUM_TRAN_COUNT,0))as MED_COUNT,"
			+ "(NVL(b.C10_TOTAL_LOW_CN_MEDUM_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_MEDUM_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_MEDUM_TRAN_AMT,0))as MED_AMT,(NVL(b.C10_TOTAL_LOW_CN_HIGH_TRAN_COUNT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_HIGH_TRAN_COUNT,0)+NVL(b.C10_TOTAL_HIGH_CN_HIGH_TRAN_COUNT,0))as HIGH_COUNT,(NVL(b.C10_TOTAL_LOW_CN_HIGH_TRAN_AMT,0)+NVL(b.C10_TOTAL_MEDIUM_CN_HIGH_TRAN_AMT,0)+NVL(b.C10_TOTAL_HIGH_CN_HIGH_TRAN_AMT,0))as HIGH_AMT FROM T12A_TRAN_CUST_TYPE_TABLE a,T12D_INTERNATIONAL_NON_TRADE_RELATED_INWARD_REMITTANCE b WHERE a.report_rpt_code=b.report_rpt_code and a.REPORT_rpt_code=?1", nativeQuery = true)
	List<Object[]> getCheckSrlNo13(String rpt_code);
	
    ////Srl_no14
	@Query(value = "SELECT (NVL(a.TOTAL_SUM_LOW_TRAN_COUNT,0)+NVL(a.TOTAL_SUMMED_TRAN_COUNT,0)+NVL(a.TOTAL_SUMHIGH_TRAN_COUNT,0))as COUNT,(NVL(a.TOTAL_SUM_LOW_TRAN_AMT,0)+NVL(a.TOTAL_SUMMED_TRAN_AMT,0)+NVL(a.TOTAL_SUMHIGH_TRAN_AMT,0))as AMT,"
			+ "b.C12_TRAN_COUNT,b.D12_TRAN_AMOUNT FROM T12A_TRAN_CUST_TYPE_TABLE a,T23_DISTRIBUTION_CHANNEL_TABLE b WHERE a.REPORT_rpt_code=b.REPORT_rpt_code and a.REPORT_rpt_code=?1", nativeQuery = true)
	List<Object[]> getCheckSrlNo14(String rpt_code);
*/
	
	
	//@Query(value = "select (select count(*) from T2_CFT_CUSTOMER_RATING_RPT_TB)as T2_COUNT ,(select count(*) from T5A_PROFILE_FACE_TO_FACE)as T5A_COUNT from dual", nativeQuery = true)
	//List<Object[]> getCheckSrlNo2();


	
}
