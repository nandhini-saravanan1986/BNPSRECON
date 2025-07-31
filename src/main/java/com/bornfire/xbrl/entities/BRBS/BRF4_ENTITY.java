package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "BRF4_SUMMARYTABLE")
public class BRF4_ENTITY {
	private String r1_product;
	private BigDecimal r1_year_to_date;
	private String r2_product;
	private BigDecimal r2_year_to_date;
	private String r3_product;
	private BigDecimal r3_year_to_date;
	private String r4_product;
	private BigDecimal r4_year_to_date;
	private String r5_product;
	private BigDecimal r5_year_to_date;
	private String r6_product;
	private BigDecimal r6_year_to_date;
	private String r7_product;
	private BigDecimal r7_year_to_date;
	private String r8_product;
	private BigDecimal r8_year_to_date;
	private String r9_product;
	private BigDecimal r9_year_to_date;
	private String r10_product;
	private BigDecimal r10_year_to_date;
	private String r11_product;
	private BigDecimal r11_year_to_date;
	private String r12_product;
	private BigDecimal r12_year_to_date;
	private String r13_product;
	private BigDecimal r13_year_to_date;
	private String r14_product;
	private BigDecimal r14_year_to_date;
	private String r15_product;
	private BigDecimal r15_year_to_date;
	private String r16_product;
	private BigDecimal r16_year_to_date;
	private String r17_product;
	private BigDecimal r17_year_to_date;
	private String r18_product;
	private BigDecimal r18_year_to_date;
	private String r19_product;
	private BigDecimal r19_year_to_date;
	private String r20_product;
	private BigDecimal r20_year_to_date;
	private String r21_product;
	private BigDecimal r21_year_to_date;
	private String r22_product;
	private BigDecimal r22_year_to_date;
	private String r23_product;
	private BigDecimal r23_year_to_date;
	private String r24_product;
	private BigDecimal r24_year_to_date;
	private String r25_product;
	private BigDecimal r25_year_to_date;
	private String r26_product;
	private BigDecimal r26_year_to_date;
	private String r27_product;
	private BigDecimal r27_year_to_date;
	private String r28_product;
	private BigDecimal r28_year_to_date;
	private String r29_product;
	private BigDecimal r29_year_to_date;
	private String r30_product;
	private BigDecimal r30_year_to_date;
	private String r31_product;
	private BigDecimal r31_year_to_date;
	private String r32_product;
	private BigDecimal r32_year_to_date;
	private String r33_product;
	private BigDecimal r33_year_to_date;
	private String r34_product;
	private BigDecimal r34_year_to_date;
	private String r35_product;
	private BigDecimal r35_year_to_date;
	private String r36_product;
	private BigDecimal r36_year_to_date;
	private String r37_product;
	private BigDecimal r37_year_to_date;
	private String r38_product;
	private BigDecimal r38_year_to_date;
	private String r39_product;
	private BigDecimal r39_year_to_date;
	private String r40_product;
	private BigDecimal r40_year_to_date;
	private String r41_product;
	private BigDecimal r41_year_to_date;
	private String r42_product;
	private BigDecimal r42_year_to_date;
	private String r43_product;
	private BigDecimal r43_year_to_date;
	private String r44_product;
	private BigDecimal r44_year_to_date;
	private String r45_product;
	private BigDecimal r45_year_to_date;
	private String r46_product;
	private BigDecimal r46_year_to_date;
	private String r47_product;
	private BigDecimal r47_year_to_date;
	private String r48_product;
	private BigDecimal r48_year_to_date;
	private String r49_product;
	private BigDecimal r49_year_to_date;
	private String r50_product;
	private BigDecimal r50_year_to_date;
	private String r51_product;
	private BigDecimal r51_year_to_date;
	private String r52_product;
	private BigDecimal r52_year_to_date;
	private String r53_product;
	private BigDecimal r53_year_to_date;
	private String r54_product;
	private BigDecimal r54_year_to_date;
	private String r55_product;
	private BigDecimal r55_year_to_date;
	private String r56_product;
	private BigDecimal r56_year_to_date;
	private String r57_product;
	private BigDecimal r57_year_to_date;
	private String r58_product;
	private BigDecimal r58_year_to_date;
	private String r59_product;
	private BigDecimal r59_year_to_date;
	private String r60_product;
	private BigDecimal r60_year_to_date;
	private String r61_product;
	private BigDecimal r61_year_to_date;
	private String r62_product;
	private BigDecimal r62_year_to_date;
	private String r63_product;
	private BigDecimal r63_year_to_date;
	private String r64_product;
	private BigDecimal r64_year_to_date;
	private String r65_product;
	private BigDecimal r65_year_to_date;
	private String r66_product;
	private BigDecimal r66_year_to_date;
	private String r67_product;
	private BigDecimal r67_year_to_date;
	private String r68_product;
	private BigDecimal r68_year_to_date;
	private String r69_product;
	private BigDecimal r69_year_to_date;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Id
	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	private String repdesc;
	private String frequency;

	public String getR1_product() {
		return r1_product;
	}

	public BigDecimal getR1_year_to_date() {
		return r1_year_to_date;
	}

	public String getR2_product() {
		return r2_product;
	}

	public BigDecimal getR2_year_to_date() {
		return r2_year_to_date;
	}

	public String getR3_product() {
		return r3_product;
	}

	public BigDecimal getR3_year_to_date() {
		return r3_year_to_date;
	}

	public String getR4_product() {
		return r4_product;
	}

	public BigDecimal getR4_year_to_date() {
		return r4_year_to_date;
	}

	public String getR5_product() {
		return r5_product;
	}

	public BigDecimal getR5_year_to_date() {
		return r5_year_to_date;
	}

	public String getR6_product() {
		return r6_product;
	}

	public BigDecimal getR6_year_to_date() {
		return r6_year_to_date;
	}

	public String getR7_product() {
		return r7_product;
	}

	public BigDecimal getR7_year_to_date() {
		return r7_year_to_date;
	}

	public String getR8_product() {
		return r8_product;
	}

	public BigDecimal getR8_year_to_date() {
		return r8_year_to_date;
	}

	public String getR9_product() {
		return r9_product;
	}

	public BigDecimal getR9_year_to_date() {
		return r9_year_to_date;
	}

	public String getR10_product() {
		return r10_product;
	}

	public BigDecimal getR10_year_to_date() {
		return r10_year_to_date;
	}

	public String getR11_product() {
		return r11_product;
	}

	public BigDecimal getR11_year_to_date() {
		return r11_year_to_date;
	}

	public String getR12_product() {
		return r12_product;
	}

	public BigDecimal getR12_year_to_date() {
		return r12_year_to_date;
	}

	public String getR13_product() {
		return r13_product;
	}

	public BigDecimal getR13_year_to_date() {
		return r13_year_to_date;
	}

	public String getR14_product() {
		return r14_product;
	}

	public BigDecimal getR14_year_to_date() {
		return r14_year_to_date;
	}

	public String getR15_product() {
		return r15_product;
	}

	public BigDecimal getR15_year_to_date() {
		return r15_year_to_date;
	}

	public String getR16_product() {
		return r16_product;
	}

	public BigDecimal getR16_year_to_date() {
		return r16_year_to_date;
	}

	public String getR17_product() {
		return r17_product;
	}

	public BigDecimal getR17_year_to_date() {
		return r17_year_to_date;
	}

	public String getR18_product() {
		return r18_product;
	}

	public BigDecimal getR18_year_to_date() {
		return r18_year_to_date;
	}

	public String getR19_product() {
		return r19_product;
	}

	public BigDecimal getR19_year_to_date() {
		return r19_year_to_date;
	}

	public String getR20_product() {
		return r20_product;
	}

	public BigDecimal getR20_year_to_date() {
		return r20_year_to_date;
	}

	public String getR21_product() {
		return r21_product;
	}

	public BigDecimal getR21_year_to_date() {
		return r21_year_to_date;
	}

	public String getR22_product() {
		return r22_product;
	}

	public BigDecimal getR22_year_to_date() {
		return r22_year_to_date;
	}

	public String getR23_product() {
		return r23_product;
	}

	public BigDecimal getR23_year_to_date() {
		return r23_year_to_date;
	}

	public String getR24_product() {
		return r24_product;
	}

	public BigDecimal getR24_year_to_date() {
		return r24_year_to_date;
	}

	public String getR25_product() {
		return r25_product;
	}

	public BigDecimal getR25_year_to_date() {
		return r25_year_to_date;
	}

	public String getR26_product() {
		return r26_product;
	}

	public BigDecimal getR26_year_to_date() {
		return r26_year_to_date;
	}

	public String getR27_product() {
		return r27_product;
	}

	public BigDecimal getR27_year_to_date() {
		return r27_year_to_date;
	}

	public String getR28_product() {
		return r28_product;
	}

	public BigDecimal getR28_year_to_date() {
		return r28_year_to_date;
	}

	public String getR29_product() {
		return r29_product;
	}

	public BigDecimal getR29_year_to_date() {
		return r29_year_to_date;
	}

	public String getR30_product() {
		return r30_product;
	}

	public BigDecimal getR30_year_to_date() {
		return r30_year_to_date;
	}

	public String getR31_product() {
		return r31_product;
	}

	public BigDecimal getR31_year_to_date() {
		return r31_year_to_date;
	}

	public String getR32_product() {
		return r32_product;
	}

	public BigDecimal getR32_year_to_date() {
		return r32_year_to_date;
	}

	public String getR33_product() {
		return r33_product;
	}

	public BigDecimal getR33_year_to_date() {
		return r33_year_to_date;
	}

	public String getR34_product() {
		return r34_product;
	}

	public BigDecimal getR34_year_to_date() {
		return r34_year_to_date;
	}

	public String getR35_product() {
		return r35_product;
	}

	public BigDecimal getR35_year_to_date() {
		return r35_year_to_date;
	}

	public String getR36_product() {
		return r36_product;
	}

	public BigDecimal getR36_year_to_date() {
		return r36_year_to_date;
	}

	public String getR37_product() {
		return r37_product;
	}

	public BigDecimal getR37_year_to_date() {
		return r37_year_to_date;
	}

	public String getR38_product() {
		return r38_product;
	}

	public BigDecimal getR38_year_to_date() {
		return r38_year_to_date;
	}

	public String getR39_product() {
		return r39_product;
	}

	public BigDecimal getR39_year_to_date() {
		return r39_year_to_date;
	}

	public String getR40_product() {
		return r40_product;
	}

	public BigDecimal getR40_year_to_date() {
		return r40_year_to_date;
	}

	public String getR41_product() {
		return r41_product;
	}

	public BigDecimal getR41_year_to_date() {
		return r41_year_to_date;
	}

	public String getR42_product() {
		return r42_product;
	}

	public BigDecimal getR42_year_to_date() {
		return r42_year_to_date;
	}

	public String getR43_product() {
		return r43_product;
	}

	public BigDecimal getR43_year_to_date() {
		return r43_year_to_date;
	}

	public String getR44_product() {
		return r44_product;
	}

	public BigDecimal getR44_year_to_date() {
		return r44_year_to_date;
	}

	public String getR45_product() {
		return r45_product;
	}

	public BigDecimal getR45_year_to_date() {
		return r45_year_to_date;
	}

	public String getR46_product() {
		return r46_product;
	}

	public BigDecimal getR46_year_to_date() {
		return r46_year_to_date;
	}

	public String getR47_product() {
		return r47_product;
	}

	public BigDecimal getR47_year_to_date() {
		return r47_year_to_date;
	}

	public String getR48_product() {
		return r48_product;
	}

	public BigDecimal getR48_year_to_date() {
		return r48_year_to_date;
	}

	public String getR49_product() {
		return r49_product;
	}

	public BigDecimal getR49_year_to_date() {
		return r49_year_to_date;
	}

	public String getR50_product() {
		return r50_product;
	}

	public BigDecimal getR50_year_to_date() {
		return r50_year_to_date;
	}

	public String getR51_product() {
		return r51_product;
	}

	public BigDecimal getR51_year_to_date() {
		return r51_year_to_date;
	}

	public String getR52_product() {
		return r52_product;
	}

	public BigDecimal getR52_year_to_date() {
		return r52_year_to_date;
	}

	public String getR53_product() {
		return r53_product;
	}

	public BigDecimal getR53_year_to_date() {
		return r53_year_to_date;
	}

	public String getR54_product() {
		return r54_product;
	}

	public BigDecimal getR54_year_to_date() {
		return r54_year_to_date;
	}

	public String getR55_product() {
		return r55_product;
	}

	public BigDecimal getR55_year_to_date() {
		return r55_year_to_date;
	}

	public String getR56_product() {
		return r56_product;
	}

	public BigDecimal getR56_year_to_date() {
		return r56_year_to_date;
	}

	public String getR57_product() {
		return r57_product;
	}

	public BigDecimal getR57_year_to_date() {
		return r57_year_to_date;
	}

	public String getR58_product() {
		return r58_product;
	}

	public BigDecimal getR58_year_to_date() {
		return r58_year_to_date;
	}

	public String getR59_product() {
		return r59_product;
	}

	public BigDecimal getR59_year_to_date() {
		return r59_year_to_date;
	}

	public String getR60_product() {
		return r60_product;
	}

	public BigDecimal getR60_year_to_date() {
		return r60_year_to_date;
	}

	public String getR61_product() {
		return r61_product;
	}

	public BigDecimal getR61_year_to_date() {
		return r61_year_to_date;
	}

	public String getR62_product() {
		return r62_product;
	}

	public BigDecimal getR62_year_to_date() {
		return r62_year_to_date;
	}

	public String getR63_product() {
		return r63_product;
	}

	public BigDecimal getR63_year_to_date() {
		return r63_year_to_date;
	}

	public String getR64_product() {
		return r64_product;
	}

	public BigDecimal getR64_year_to_date() {
		return r64_year_to_date;
	}

	public String getR65_product() {
		return r65_product;
	}

	public BigDecimal getR65_year_to_date() {
		return r65_year_to_date;
	}

	public String getR66_product() {
		return r66_product;
	}

	public BigDecimal getR66_year_to_date() {
		return r66_year_to_date;
	}

	public String getR67_product() {
		return r67_product;
	}

	public BigDecimal getR67_year_to_date() {
		return r67_year_to_date;
	}

	public String getR68_product() {
		return r68_product;
	}

	public BigDecimal getR68_year_to_date() {
		return r68_year_to_date;
	}

	public String getR69_product() {
		return r69_product;
	}

	public BigDecimal getR69_year_to_date() {
		return r69_year_to_date;
	}

	public Date getReport_date() {
		return report_date;
	}

	public Date getReport_from_date() {
		return report_from_date;
	}

	public Date getReport_to_date() {
		return report_to_date;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public String getReport_code() {
		return report_code;
	}

	public Date getReport_submit_date() {
		return report_submit_date;
	}

	public String getRepdesc() {
		return repdesc;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setR1_product(String r1_product) {
		this.r1_product = r1_product;
	}

	public void setR1_year_to_date(BigDecimal r1_year_to_date) {
		this.r1_year_to_date = r1_year_to_date;
	}

	public void setR2_product(String r2_product) {
		this.r2_product = r2_product;
	}

	public void setR2_year_to_date(BigDecimal r2_year_to_date) {
		this.r2_year_to_date = r2_year_to_date;
	}

	public void setR3_product(String r3_product) {
		this.r3_product = r3_product;
	}

	public void setR3_year_to_date(BigDecimal r3_year_to_date) {
		this.r3_year_to_date = r3_year_to_date;
	}

	public void setR4_product(String r4_product) {
		this.r4_product = r4_product;
	}

	public void setR4_year_to_date(BigDecimal r4_year_to_date) {
		this.r4_year_to_date = r4_year_to_date;
	}

	public void setR5_product(String r5_product) {
		this.r5_product = r5_product;
	}

	public void setR5_year_to_date(BigDecimal r5_year_to_date) {
		this.r5_year_to_date = r5_year_to_date;
	}

	public void setR6_product(String r6_product) {
		this.r6_product = r6_product;
	}

	public void setR6_year_to_date(BigDecimal r6_year_to_date) {
		this.r6_year_to_date = r6_year_to_date;
	}

	public void setR7_product(String r7_product) {
		this.r7_product = r7_product;
	}

	public void setR7_year_to_date(BigDecimal r7_year_to_date) {
		this.r7_year_to_date = r7_year_to_date;
	}

	public void setR8_product(String r8_product) {
		this.r8_product = r8_product;
	}

	public void setR8_year_to_date(BigDecimal r8_year_to_date) {
		this.r8_year_to_date = r8_year_to_date;
	}

	public void setR9_product(String r9_product) {
		this.r9_product = r9_product;
	}

	public void setR9_year_to_date(BigDecimal r9_year_to_date) {
		this.r9_year_to_date = r9_year_to_date;
	}

	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}

	public void setR10_year_to_date(BigDecimal r10_year_to_date) {
		this.r10_year_to_date = r10_year_to_date;
	}

	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}

	public void setR11_year_to_date(BigDecimal r11_year_to_date) {
		this.r11_year_to_date = r11_year_to_date;
	}

	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}

	public void setR12_year_to_date(BigDecimal r12_year_to_date) {
		this.r12_year_to_date = r12_year_to_date;
	}

	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}

	public void setR13_year_to_date(BigDecimal r13_year_to_date) {
		this.r13_year_to_date = r13_year_to_date;
	}

	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}

	public void setR14_year_to_date(BigDecimal r14_year_to_date) {
		this.r14_year_to_date = r14_year_to_date;
	}

	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}

	public void setR15_year_to_date(BigDecimal r15_year_to_date) {
		this.r15_year_to_date = r15_year_to_date;
	}

	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}

	public void setR16_year_to_date(BigDecimal r16_year_to_date) {
		this.r16_year_to_date = r16_year_to_date;
	}

	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}

	public void setR17_year_to_date(BigDecimal r17_year_to_date) {
		this.r17_year_to_date = r17_year_to_date;
	}

	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}

	public void setR18_year_to_date(BigDecimal r18_year_to_date) {
		this.r18_year_to_date = r18_year_to_date;
	}

	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}

	public void setR19_year_to_date(BigDecimal r19_year_to_date) {
		this.r19_year_to_date = r19_year_to_date;
	}

	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}

	public void setR20_year_to_date(BigDecimal r20_year_to_date) {
		this.r20_year_to_date = r20_year_to_date;
	}

	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}

	public void setR21_year_to_date(BigDecimal r21_year_to_date) {
		this.r21_year_to_date = r21_year_to_date;
	}

	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}

	public void setR22_year_to_date(BigDecimal r22_year_to_date) {
		this.r22_year_to_date = r22_year_to_date;
	}

	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}

	public void setR23_year_to_date(BigDecimal r23_year_to_date) {
		this.r23_year_to_date = r23_year_to_date;
	}

	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}

	public void setR24_year_to_date(BigDecimal r24_year_to_date) {
		this.r24_year_to_date = r24_year_to_date;
	}

	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}

	public void setR25_year_to_date(BigDecimal r25_year_to_date) {
		this.r25_year_to_date = r25_year_to_date;
	}

	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}

	public void setR26_year_to_date(BigDecimal r26_year_to_date) {
		this.r26_year_to_date = r26_year_to_date;
	}

	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}

	public void setR27_year_to_date(BigDecimal r27_year_to_date) {
		this.r27_year_to_date = r27_year_to_date;
	}

	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}

	public void setR28_year_to_date(BigDecimal r28_year_to_date) {
		this.r28_year_to_date = r28_year_to_date;
	}

	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}

	public void setR29_year_to_date(BigDecimal r29_year_to_date) {
		this.r29_year_to_date = r29_year_to_date;
	}

	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}

	public void setR30_year_to_date(BigDecimal r30_year_to_date) {
		this.r30_year_to_date = r30_year_to_date;
	}

	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}

	public void setR31_year_to_date(BigDecimal r31_year_to_date) {
		this.r31_year_to_date = r31_year_to_date;
	}

	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}

	public void setR32_year_to_date(BigDecimal r32_year_to_date) {
		this.r32_year_to_date = r32_year_to_date;
	}

	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}

	public void setR33_year_to_date(BigDecimal r33_year_to_date) {
		this.r33_year_to_date = r33_year_to_date;
	}

	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}

	public void setR34_year_to_date(BigDecimal r34_year_to_date) {
		this.r34_year_to_date = r34_year_to_date;
	}

	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}

	public void setR35_year_to_date(BigDecimal r35_year_to_date) {
		this.r35_year_to_date = r35_year_to_date;
	}

	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}

	public void setR36_year_to_date(BigDecimal r36_year_to_date) {
		this.r36_year_to_date = r36_year_to_date;
	}

	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}

	public void setR37_year_to_date(BigDecimal r37_year_to_date) {
		this.r37_year_to_date = r37_year_to_date;
	}

	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}

	public void setR38_year_to_date(BigDecimal r38_year_to_date) {
		this.r38_year_to_date = r38_year_to_date;
	}

	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}

	public void setR39_year_to_date(BigDecimal r39_year_to_date) {
		this.r39_year_to_date = r39_year_to_date;
	}

	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}

	public void setR40_year_to_date(BigDecimal r40_year_to_date) {
		this.r40_year_to_date = r40_year_to_date;
	}

	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}

	public void setR41_year_to_date(BigDecimal r41_year_to_date) {
		this.r41_year_to_date = r41_year_to_date;
	}

	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}

	public void setR42_year_to_date(BigDecimal r42_year_to_date) {
		this.r42_year_to_date = r42_year_to_date;
	}

	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}

	public void setR43_year_to_date(BigDecimal r43_year_to_date) {
		this.r43_year_to_date = r43_year_to_date;
	}

	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}

	public void setR44_year_to_date(BigDecimal r44_year_to_date) {
		this.r44_year_to_date = r44_year_to_date;
	}

	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}

	public void setR45_year_to_date(BigDecimal r45_year_to_date) {
		this.r45_year_to_date = r45_year_to_date;
	}

	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}

	public void setR46_year_to_date(BigDecimal r46_year_to_date) {
		this.r46_year_to_date = r46_year_to_date;
	}

	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}

	public void setR47_year_to_date(BigDecimal r47_year_to_date) {
		this.r47_year_to_date = r47_year_to_date;
	}

	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}

	public void setR48_year_to_date(BigDecimal r48_year_to_date) {
		this.r48_year_to_date = r48_year_to_date;
	}

	public void setR49_product(String r49_product) {
		this.r49_product = r49_product;
	}

	public void setR49_year_to_date(BigDecimal r49_year_to_date) {
		this.r49_year_to_date = r49_year_to_date;
	}

	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}

	public void setR50_year_to_date(BigDecimal r50_year_to_date) {
		this.r50_year_to_date = r50_year_to_date;
	}

	public void setR51_product(String r51_product) {
		this.r51_product = r51_product;
	}

	public void setR51_year_to_date(BigDecimal r51_year_to_date) {
		this.r51_year_to_date = r51_year_to_date;
	}

	public void setR52_product(String r52_product) {
		this.r52_product = r52_product;
	}

	public void setR52_year_to_date(BigDecimal r52_year_to_date) {
		this.r52_year_to_date = r52_year_to_date;
	}

	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}

	public void setR53_year_to_date(BigDecimal r53_year_to_date) {
		this.r53_year_to_date = r53_year_to_date;
	}

	public void setR54_product(String r54_product) {
		this.r54_product = r54_product;
	}

	public void setR54_year_to_date(BigDecimal r54_year_to_date) {
		this.r54_year_to_date = r54_year_to_date;
	}

	public void setR55_product(String r55_product) {
		this.r55_product = r55_product;
	}

	public void setR55_year_to_date(BigDecimal r55_year_to_date) {
		this.r55_year_to_date = r55_year_to_date;
	}

	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}

	public void setR56_year_to_date(BigDecimal r56_year_to_date) {
		this.r56_year_to_date = r56_year_to_date;
	}

	public void setR57_product(String r57_product) {
		this.r57_product = r57_product;
	}

	public void setR57_year_to_date(BigDecimal r57_year_to_date) {
		this.r57_year_to_date = r57_year_to_date;
	}

	public void setR58_product(String r58_product) {
		this.r58_product = r58_product;
	}

	public void setR58_year_to_date(BigDecimal r58_year_to_date) {
		this.r58_year_to_date = r58_year_to_date;
	}

	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}

	public void setR59_year_to_date(BigDecimal r59_year_to_date) {
		this.r59_year_to_date = r59_year_to_date;
	}

	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}

	public void setR60_year_to_date(BigDecimal r60_year_to_date) {
		this.r60_year_to_date = r60_year_to_date;
	}

	public void setR61_product(String r61_product) {
		this.r61_product = r61_product;
	}

	public void setR61_year_to_date(BigDecimal r61_year_to_date) {
		this.r61_year_to_date = r61_year_to_date;
	}

	public void setR62_product(String r62_product) {
		this.r62_product = r62_product;
	}

	public void setR62_year_to_date(BigDecimal r62_year_to_date) {
		this.r62_year_to_date = r62_year_to_date;
	}

	public void setR63_product(String r63_product) {
		this.r63_product = r63_product;
	}

	public void setR63_year_to_date(BigDecimal r63_year_to_date) {
		this.r63_year_to_date = r63_year_to_date;
	}

	public void setR64_product(String r64_product) {
		this.r64_product = r64_product;
	}

	public void setR64_year_to_date(BigDecimal r64_year_to_date) {
		this.r64_year_to_date = r64_year_to_date;
	}

	public void setR65_product(String r65_product) {
		this.r65_product = r65_product;
	}

	public void setR65_year_to_date(BigDecimal r65_year_to_date) {
		this.r65_year_to_date = r65_year_to_date;
	}

	public void setR66_product(String r66_product) {
		this.r66_product = r66_product;
	}

	public void setR66_year_to_date(BigDecimal r66_year_to_date) {
		this.r66_year_to_date = r66_year_to_date;
	}

	public void setR67_product(String r67_product) {
		this.r67_product = r67_product;
	}

	public void setR67_year_to_date(BigDecimal r67_year_to_date) {
		this.r67_year_to_date = r67_year_to_date;
	}

	public void setR68_product(String r68_product) {
		this.r68_product = r68_product;
	}

	public void setR68_year_to_date(BigDecimal r68_year_to_date) {
		this.r68_year_to_date = r68_year_to_date;
	}

	public void setR69_product(String r69_product) {
		this.r69_product = r69_product;
	}

	public void setR69_year_to_date(BigDecimal r69_year_to_date) {
		this.r69_year_to_date = r69_year_to_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public void setReport_from_date(Date report_from_date) {
		this.report_from_date = report_from_date;
	}

	public void setReport_to_date(Date report_to_date) {
		this.report_to_date = report_to_date;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public void setReport_code(String report_code) {
		this.report_code = report_code;
	}

	public void setReport_submit_date(Date report_submit_date) {
		this.report_submit_date = report_submit_date;
	}

	public void setRepdesc(String repdesc) {
		this.repdesc = repdesc;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public BRF4_ENTITY(String r1_product, BigDecimal r1_year_to_date, String r2_product, BigDecimal r2_year_to_date,
			String r3_product, BigDecimal r3_year_to_date, String r4_product, BigDecimal r4_year_to_date,
			String r5_product, BigDecimal r5_year_to_date, String r6_product, BigDecimal r6_year_to_date,
			String r7_product, BigDecimal r7_year_to_date, String r8_product, BigDecimal r8_year_to_date,
			String r9_product, BigDecimal r9_year_to_date, String r10_product, BigDecimal r10_year_to_date,
			String r11_product, BigDecimal r11_year_to_date, String r12_product, BigDecimal r12_year_to_date,
			String r13_product, BigDecimal r13_year_to_date, String r14_product, BigDecimal r14_year_to_date,
			String r15_product, BigDecimal r15_year_to_date, String r16_product, BigDecimal r16_year_to_date,
			String r17_product, BigDecimal r17_year_to_date, String r18_product, BigDecimal r18_year_to_date,
			String r19_product, BigDecimal r19_year_to_date, String r20_product, BigDecimal r20_year_to_date,
			String r21_product, BigDecimal r21_year_to_date, String r22_product, BigDecimal r22_year_to_date,
			String r23_product, BigDecimal r23_year_to_date, String r24_product, BigDecimal r24_year_to_date,
			String r25_product, BigDecimal r25_year_to_date, String r26_product, BigDecimal r26_year_to_date,
			String r27_product, BigDecimal r27_year_to_date, String r28_product, BigDecimal r28_year_to_date,
			String r29_product, BigDecimal r29_year_to_date, String r30_product, BigDecimal r30_year_to_date,
			String r31_product, BigDecimal r31_year_to_date, String r32_product, BigDecimal r32_year_to_date,
			String r33_product, BigDecimal r33_year_to_date, String r34_product, BigDecimal r34_year_to_date,
			String r35_product, BigDecimal r35_year_to_date, String r36_product, BigDecimal r36_year_to_date,
			String r37_product, BigDecimal r37_year_to_date, String r38_product, BigDecimal r38_year_to_date,
			String r39_product, BigDecimal r39_year_to_date, String r40_product, BigDecimal r40_year_to_date,
			String r41_product, BigDecimal r41_year_to_date, String r42_product, BigDecimal r42_year_to_date,
			String r43_product, BigDecimal r43_year_to_date, String r44_product, BigDecimal r44_year_to_date,
			String r45_product, BigDecimal r45_year_to_date, String r46_product, BigDecimal r46_year_to_date,
			String r47_product, BigDecimal r47_year_to_date, String r48_product, BigDecimal r48_year_to_date,
			String r49_product, BigDecimal r49_year_to_date, String r50_product, BigDecimal r50_year_to_date,
			String r51_product, BigDecimal r51_year_to_date, String r52_product, BigDecimal r52_year_to_date,
			String r53_product, BigDecimal r53_year_to_date, String r54_product, BigDecimal r54_year_to_date,
			String r55_product, BigDecimal r55_year_to_date, String r56_product, BigDecimal r56_year_to_date,
			String r57_product, BigDecimal r57_year_to_date, String r58_product, BigDecimal r58_year_to_date,
			String r59_product, BigDecimal r59_year_to_date, String r60_product, BigDecimal r60_year_to_date,
			String r61_product, BigDecimal r61_year_to_date, String r62_product, BigDecimal r62_year_to_date,
			String r63_product, BigDecimal r63_year_to_date, String r64_product, BigDecimal r64_year_to_date,
			String r65_product, BigDecimal r65_year_to_date, String r66_product, BigDecimal r66_year_to_date,
			String r67_product, BigDecimal r67_year_to_date, String r68_product, BigDecimal r68_year_to_date,
			String r69_product, BigDecimal r69_year_to_date, Date report_date, Date report_from_date,
			Date report_to_date, String entity_flg, String modify_flg, String del_flg, String report_code,
			Date report_submit_date, String repdesc, String frequency) {
		super();
		this.r1_product = r1_product;
		this.r1_year_to_date = r1_year_to_date;
		this.r2_product = r2_product;
		this.r2_year_to_date = r2_year_to_date;
		this.r3_product = r3_product;
		this.r3_year_to_date = r3_year_to_date;
		this.r4_product = r4_product;
		this.r4_year_to_date = r4_year_to_date;
		this.r5_product = r5_product;
		this.r5_year_to_date = r5_year_to_date;
		this.r6_product = r6_product;
		this.r6_year_to_date = r6_year_to_date;
		this.r7_product = r7_product;
		this.r7_year_to_date = r7_year_to_date;
		this.r8_product = r8_product;
		this.r8_year_to_date = r8_year_to_date;
		this.r9_product = r9_product;
		this.r9_year_to_date = r9_year_to_date;
		this.r10_product = r10_product;
		this.r10_year_to_date = r10_year_to_date;
		this.r11_product = r11_product;
		this.r11_year_to_date = r11_year_to_date;
		this.r12_product = r12_product;
		this.r12_year_to_date = r12_year_to_date;
		this.r13_product = r13_product;
		this.r13_year_to_date = r13_year_to_date;
		this.r14_product = r14_product;
		this.r14_year_to_date = r14_year_to_date;
		this.r15_product = r15_product;
		this.r15_year_to_date = r15_year_to_date;
		this.r16_product = r16_product;
		this.r16_year_to_date = r16_year_to_date;
		this.r17_product = r17_product;
		this.r17_year_to_date = r17_year_to_date;
		this.r18_product = r18_product;
		this.r18_year_to_date = r18_year_to_date;
		this.r19_product = r19_product;
		this.r19_year_to_date = r19_year_to_date;
		this.r20_product = r20_product;
		this.r20_year_to_date = r20_year_to_date;
		this.r21_product = r21_product;
		this.r21_year_to_date = r21_year_to_date;
		this.r22_product = r22_product;
		this.r22_year_to_date = r22_year_to_date;
		this.r23_product = r23_product;
		this.r23_year_to_date = r23_year_to_date;
		this.r24_product = r24_product;
		this.r24_year_to_date = r24_year_to_date;
		this.r25_product = r25_product;
		this.r25_year_to_date = r25_year_to_date;
		this.r26_product = r26_product;
		this.r26_year_to_date = r26_year_to_date;
		this.r27_product = r27_product;
		this.r27_year_to_date = r27_year_to_date;
		this.r28_product = r28_product;
		this.r28_year_to_date = r28_year_to_date;
		this.r29_product = r29_product;
		this.r29_year_to_date = r29_year_to_date;
		this.r30_product = r30_product;
		this.r30_year_to_date = r30_year_to_date;
		this.r31_product = r31_product;
		this.r31_year_to_date = r31_year_to_date;
		this.r32_product = r32_product;
		this.r32_year_to_date = r32_year_to_date;
		this.r33_product = r33_product;
		this.r33_year_to_date = r33_year_to_date;
		this.r34_product = r34_product;
		this.r34_year_to_date = r34_year_to_date;
		this.r35_product = r35_product;
		this.r35_year_to_date = r35_year_to_date;
		this.r36_product = r36_product;
		this.r36_year_to_date = r36_year_to_date;
		this.r37_product = r37_product;
		this.r37_year_to_date = r37_year_to_date;
		this.r38_product = r38_product;
		this.r38_year_to_date = r38_year_to_date;
		this.r39_product = r39_product;
		this.r39_year_to_date = r39_year_to_date;
		this.r40_product = r40_product;
		this.r40_year_to_date = r40_year_to_date;
		this.r41_product = r41_product;
		this.r41_year_to_date = r41_year_to_date;
		this.r42_product = r42_product;
		this.r42_year_to_date = r42_year_to_date;
		this.r43_product = r43_product;
		this.r43_year_to_date = r43_year_to_date;
		this.r44_product = r44_product;
		this.r44_year_to_date = r44_year_to_date;
		this.r45_product = r45_product;
		this.r45_year_to_date = r45_year_to_date;
		this.r46_product = r46_product;
		this.r46_year_to_date = r46_year_to_date;
		this.r47_product = r47_product;
		this.r47_year_to_date = r47_year_to_date;
		this.r48_product = r48_product;
		this.r48_year_to_date = r48_year_to_date;
		this.r49_product = r49_product;
		this.r49_year_to_date = r49_year_to_date;
		this.r50_product = r50_product;
		this.r50_year_to_date = r50_year_to_date;
		this.r51_product = r51_product;
		this.r51_year_to_date = r51_year_to_date;
		this.r52_product = r52_product;
		this.r52_year_to_date = r52_year_to_date;
		this.r53_product = r53_product;
		this.r53_year_to_date = r53_year_to_date;
		this.r54_product = r54_product;
		this.r54_year_to_date = r54_year_to_date;
		this.r55_product = r55_product;
		this.r55_year_to_date = r55_year_to_date;
		this.r56_product = r56_product;
		this.r56_year_to_date = r56_year_to_date;
		this.r57_product = r57_product;
		this.r57_year_to_date = r57_year_to_date;
		this.r58_product = r58_product;
		this.r58_year_to_date = r58_year_to_date;
		this.r59_product = r59_product;
		this.r59_year_to_date = r59_year_to_date;
		this.r60_product = r60_product;
		this.r60_year_to_date = r60_year_to_date;
		this.r61_product = r61_product;
		this.r61_year_to_date = r61_year_to_date;
		this.r62_product = r62_product;
		this.r62_year_to_date = r62_year_to_date;
		this.r63_product = r63_product;
		this.r63_year_to_date = r63_year_to_date;
		this.r64_product = r64_product;
		this.r64_year_to_date = r64_year_to_date;
		this.r65_product = r65_product;
		this.r65_year_to_date = r65_year_to_date;
		this.r66_product = r66_product;
		this.r66_year_to_date = r66_year_to_date;
		this.r67_product = r67_product;
		this.r67_year_to_date = r67_year_to_date;
		this.r68_product = r68_product;
		this.r68_year_to_date = r68_year_to_date;
		this.r69_product = r69_product;
		this.r69_year_to_date = r69_year_to_date;
		this.report_date = report_date;
		this.report_from_date = report_from_date;
		this.report_to_date = report_to_date;
		this.entity_flg = entity_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.report_code = report_code;
		this.report_submit_date = report_submit_date;
		this.repdesc = repdesc;
		this.frequency = frequency;
	}

	public BRF4_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
}