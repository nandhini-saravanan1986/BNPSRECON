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
@Table(name = "T1_CUR_PROD_SERVICES")
public class T1CurProdServices {
	
	
	private String	A1_PROD_NAME;
	private String	A2_DESC;
	private String	A3_RISK_ASS;
	private String	A4_FACE_TO_FACE;
	private String	A5_NON_FACE_TO_FACE;
	private String	A6_NON;
	private BigDecimal	A7_HIGH_DEBIT_NUM;
	private BigDecimal	A8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	A9_HIGH_CREDIT_NUM;
	private BigDecimal	A10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	A11_MEDIUM_DEBIT_NUM;
	private BigDecimal	A12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	A13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	A14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	A15_LOW_DEBIT_NUM;
	private BigDecimal	A16_LOW_DEBIT_AMOUNT;
	private BigDecimal	A17_LOW_CREDIT_NUM;
	private BigDecimal	A18_LOW_CREDIT_AMOUNT;
	private BigDecimal	A19_WALK_DEBIT_NUM;
	private BigDecimal	A20_WALK_DEBIT_AMOUNT;
	private BigDecimal	A21_WALK_CREDIT_NUM;
	private BigDecimal	A22_WALK_CREDIT_AMOUNT;
	private String	B1_PROD_NAME;
	private String	B2_DESC;
	private String	B3_RISK_ASS;
	private String	B4_FACE_TO_FACE;
	private String	B5_NON_FACE_TO_FACE;
	private String	B6_NON;
	private BigDecimal	B7_HIGH_DEBIT_NUM;
	private BigDecimal	B8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	B9_HIGH_CREDIT_NUM;
	private BigDecimal	B10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	B11_MEDIUM_DEBIT_NUM;
	private BigDecimal	B12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	B13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	B14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	B15_LOW_DEBIT_NUM;
	private BigDecimal	B16_LOW_DEBIT_AMOUNT;
	private BigDecimal	B17_LOW_CREDIT_NUM;
	private BigDecimal	B18_LOW_CREDIT_AMOUNT;
	private BigDecimal	B19_WALK_DEBIT_NUM;
	private BigDecimal	B20_WALK_DEBIT_AMOUNT;
	private BigDecimal	B21_WALK_CREDIT_NUM;
	private BigDecimal	B22_WALK_CREDIT_AMOUNT;
	private String	C1_PROD_NAME;
	private String	C2_DESC;
	private String	C3_RISK_ASS;
	private String	C4_FACE_TO_FACE;
	private String	C5_NON_FACE_TO_FACE;
	private String	C6_NON;
	private BigDecimal	C7_HIGH_DEBIT_NUM;
	private BigDecimal	C8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	C9_HIGH_CREDIT_NUM;
	private BigDecimal	C10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	C11_MEDIUM_DEBIT_NUM;
	private BigDecimal	C12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	C13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	C14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	C15_LOW_DEBIT_NUM;
	private BigDecimal	C16_LOW_DEBIT_AMOUNT;
	private BigDecimal	C17_LOW_CREDIT_NUM;
	private BigDecimal	C18_LOW_CREDIT_AMOUNT;
	private BigDecimal	C19_WALK_DEBIT_NUM;
	private BigDecimal	C20_WALK_DEBIT_AMOUNT;
	private BigDecimal	C21_WALK_CREDIT_NUM;
	private BigDecimal	C22_WALK_CREDIT_AMOUNT;
	private String	D1_PROD_NAME;
	private String	D2_DESC;
	private String	D3_RISK_ASS;
	private String	D4_FACE_TO_FACE;
	private String	D5_NON_FACE_TO_FACE;
	private String	D6_NON;
	private BigDecimal	D7_HIGH_DEBIT_NUM;
	private BigDecimal	D8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	D9_HIGH_CREDIT_NUM;
	private BigDecimal	D10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	D11_MEDIUM_DEBIT_NUM;
	private BigDecimal	D12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	D13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	D14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	D15_LOW_DEBIT_NUM;
	private BigDecimal	D16_LOW_DEBIT_AMOUNT;
	private BigDecimal	D17_LOW_CREDIT_NUM;
	private BigDecimal	D18_LOW_CREDIT_AMOUNT;
	private BigDecimal	D19_WALK_DEBIT_NUM;
	private BigDecimal	D20_WALK_DEBIT_AMOUNT;
	private BigDecimal	D21_WALK_CREDIT_NUM;
	private BigDecimal	D22_WALK_CREDIT_AMOUNT;
	private String	E1_PROD_NAME;
	private String	E2_DESC;
	private String	E3_RISK_ASS;
	private String	E4_FACE_TO_FACE;
	private String	E5_NON_FACE_TO_FACE;
	private String	E6_NON;
	private BigDecimal	E7_HIGH_DEBIT_NUM;
	private BigDecimal	E8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	E9_HIGH_CREDIT_NUM;
	private BigDecimal	E10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	E11_MEDIUM_DEBIT_NUM;
	private BigDecimal	E12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	E13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	E14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	E15_LOW_DEBIT_NUM;
	private BigDecimal	E16_LOW_DEBIT_AMOUNT;
	private BigDecimal	E17_LOW_CREDIT_NUM;
	private BigDecimal	E18_LOW_CREDIT_AMOUNT;
	private BigDecimal	E19_WALK_DEBIT_NUM;
	private BigDecimal	E20_WALK_DEBIT_AMOUNT;
	private BigDecimal	E21_WALK_CREDIT_NUM;
	private BigDecimal	E22_WALK_CREDIT_AMOUNT;
	private String	F1_PROD_NAME;
	private String	F2_DESC;
	private String	F3_RISK_ASS;
	private String	F4_FACE_TO_FACE;
	private String	F5_NON_FACE_TO_FACE;
	private String	F6_NON;
	private BigDecimal	F7_HIGH_DEBIT_NUM;
	private BigDecimal	F8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	F9_HIGH_CREDIT_NUM;
	private BigDecimal	F10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	F11_MEDIUM_DEBIT_NUM;
	private BigDecimal	F12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	F13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	F14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	F15_LOW_DEBIT_NUM;
	private BigDecimal	F16_LOW_DEBIT_AMOUNT;
	private BigDecimal	F17_LOW_CREDIT_NUM;
	private BigDecimal	F18_LOW_CREDIT_AMOUNT;
	private BigDecimal	F19_WALK_DEBIT_NUM;
	private BigDecimal	F20_WALK_DEBIT_AMOUNT;
	private BigDecimal	F21_WALK_CREDIT_NUM;
	private BigDecimal	F22_WALK_CREDIT_AMOUNT;
	private String	G1_PROD_NAME;
	private String	G2_DESC;
	private String	G3_RISK_ASS;
	private String	G4_FACE_TO_FACE;
	private String	G5_NON_FACE_TO_FACE;
	private String	G6_NON;
	private BigDecimal	G7_HIGH_DEBIT_NUM;
	private BigDecimal	G8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	G9_HIGH_CREDIT_NUM;
	private BigDecimal	G10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	G11_MEDIUM_DEBIT_NUM;
	private BigDecimal	G12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	G13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	G14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	G15_LOW_DEBIT_NUM;
	private BigDecimal	G16_LOW_DEBIT_AMOUNT;
	private BigDecimal	G17_LOW_CREDIT_NUM;
	private BigDecimal	G18_LOW_CREDIT_AMOUNT;
	private BigDecimal	G19_WALK_DEBIT_NUM;
	private BigDecimal	G20_WALK_DEBIT_AMOUNT;
	private BigDecimal	G21_WALK_CREDIT_NUM;
	private BigDecimal	G22_WALK_CREDIT_AMOUNT;
	private String	H1_PROD_NAME;
	private String	H2_DESC;
	private String	H3_RISK_ASS;
	private String	H4_FACE_TO_FACE;
	private String	H5_NON_FACE_TO_FACE;
	private String	H6_NON;
	private BigDecimal	H7_HIGH_DEBIT_NUM;
	private BigDecimal	H8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	H9_HIGH_CREDIT_NUM;
	private BigDecimal	H10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	H11_MEDIUM_DEBIT_NUM;
	private BigDecimal	H12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	H13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	H14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	H15_LOW_DEBIT_NUM;
	private BigDecimal	H16_LOW_DEBIT_AMOUNT;
	private BigDecimal	H17_LOW_CREDIT_NUM;
	private BigDecimal	H18_LOW_CREDIT_AMOUNT;
	private BigDecimal	H19_WALK_DEBIT_NUM;
	private BigDecimal	H20_WALK_DEBIT_AMOUNT;
	private BigDecimal	H21_WALK_CREDIT_NUM;
	private BigDecimal	H22_WALK_CREDIT_AMOUNT;
	private String	I1_PROD_NAME;
	private String	I2_DESC;
	private String	I3_RISK_ASS;
	private String	I4_FACE_TO_FACE;
	private String	I5_NON_FACE_TO_FACE;
	private String	I6_NON;
	private BigDecimal	I7_HIGH_DEBIT_NUM;
	private BigDecimal	I8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	I9_HIGH_CREDIT_NUM;
	private BigDecimal	I10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	I11_MEDIUM_DEBIT_NUM;
	private BigDecimal	I12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	I13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	I14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	I15_LOW_DEBIT_NUM;
	private BigDecimal	I16_LOW_DEBIT_AMOUNT;
	private BigDecimal	I17_LOW_CREDIT_NUM;
	private BigDecimal	I18_LOW_CREDIT_AMOUNT;
	private BigDecimal	I19_WALK_DEBIT_NUM;
	private BigDecimal	I20_WALK_DEBIT_AMOUNT;
	private BigDecimal	I21_WALK_CREDIT_NUM;
	private BigDecimal	I22_WALK_CREDIT_AMOUNT;
	private String	J1_PROD_NAME;
	private String	J2_DESC;
	private String	J3_RISK_ASS;
	private String	J4_FACE_TO_FACE;
	private String	J5_NON_FACE_TO_FACE;
	private String	J6_NON;
	private BigDecimal	J7_HIGH_DEBIT_NUM;
	private BigDecimal	J8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	J9_HIGH_CREDIT_NUM;
	private BigDecimal	J10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	J11_MEDIUM_DEBIT_NUM;
	private BigDecimal	J12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	J13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	J14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	J15_LOW_DEBIT_NUM;
	private BigDecimal	J16_LOW_DEBIT_AMOUNT;
	private BigDecimal	J17_LOW_CREDIT_NUM;
	private BigDecimal	J18_LOW_CREDIT_AMOUNT;
	private BigDecimal	J19_WALK_DEBIT_NUM;
	private BigDecimal	J20_WALK_DEBIT_AMOUNT;
	private BigDecimal	J21_WALK_CREDIT_NUM;
	private BigDecimal	J22_WALK_CREDIT_AMOUNT;
	private String	K1_PROD_NAME;
	private String	K2_DESC;
	private String	K3_RISK_ASS;
	private String	K4_FACE_TO_FACE;
	private String	K5_NON_FACE_TO_FACE;
	private String	K6_NON;
	private BigDecimal	K7_HIGH_DEBIT_NUM;
	private BigDecimal	K8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	K9_HIGH_CREDIT_NUM;
	private BigDecimal	K10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	K11_MEDIUM_DEBIT_NUM;
	private BigDecimal	K12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	K13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	K14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	K15_LOW_DEBIT_NUM;
	private BigDecimal	K16_LOW_DEBIT_AMOUNT;
	private BigDecimal	K17_LOW_CREDIT_NUM;
	private BigDecimal	K18_LOW_CREDIT_AMOUNT;
	private BigDecimal	K19_WALK_DEBIT_NUM;
	private BigDecimal	K20_WALK_DEBIT_AMOUNT;
	private BigDecimal	K21_WALK_CREDIT_NUM;
	private BigDecimal	K22_WALK_CREDIT_AMOUNT;
	private String	L1_PROD_NAME;
	private String	L2_DESC;
	private String	L3_RISK_ASS;
	private String	L4_FACE_TO_FACE;
	private String	L5_NON_FACE_TO_FACE;
	private String	L6_NON;
	private BigDecimal	L7_HIGH_DEBIT_NUM;
	private BigDecimal	L8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	L9_HIGH_CREDIT_NUM;
	private BigDecimal	L10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	L11_MEDIUM_DEBIT_NUM;
	private BigDecimal	L12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	L13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	L14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	L15_LOW_DEBIT_NUM;
	private BigDecimal	L16_LOW_DEBIT_AMOUNT;
	private BigDecimal	L17_LOW_CREDIT_NUM;
	private BigDecimal	L18_LOW_CREDIT_AMOUNT;
	private BigDecimal	L19_WALK_DEBIT_NUM;
	private BigDecimal	L20_WALK_DEBIT_AMOUNT;
	private BigDecimal	L21_WALK_CREDIT_NUM;
	private BigDecimal	L22_WALK_CREDIT_AMOUNT;
	private String	M1_PROD_NAME;
	private String	M2_DESC;
	private String	M3_RISK_ASS;
	private String	M4_FACE_TO_FACE;
	private String	M5_NON_FACE_TO_FACE;
	private String	M6_NON;
	private BigDecimal	M7_HIGH_DEBIT_NUM;
	private BigDecimal	M8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	M9_HIGH_CREDIT_NUM;
	private BigDecimal	M10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	M11_MEDIUM_DEBIT_NUM;
	private BigDecimal	M12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	M13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	M14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	M15_LOW_DEBIT_NUM;
	private BigDecimal	M16_LOW_DEBIT_AMOUNT;
	private BigDecimal	M17_LOW_CREDIT_NUM;
	private BigDecimal	M18_LOW_CREDIT_AMOUNT;
	private BigDecimal	M19_WALK_DEBIT_NUM;
	private BigDecimal	M20_WALK_DEBIT_AMOUNT;
	private BigDecimal	M21_WALK_CREDIT_NUM;
	private BigDecimal	M22_WALK_CREDIT_AMOUNT;
	private String	N1_PROD_NAME;
	private String	N2_DESC;
	private String	N3_RISK_ASS;
	private String	N4_FACE_TO_FACE;
	private String	N5_NON_FACE_TO_FACE;
	private String	N6_NON;
	private BigDecimal	N7_HIGH_DEBIT_NUM;
	private BigDecimal	N8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	N9_HIGH_CREDIT_NUM;
	private BigDecimal	N10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	N11_MEDIUM_DEBIT_NUM;
	private BigDecimal	N12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	N13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	N14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	N15_LOW_DEBIT_NUM;
	private BigDecimal	N16_LOW_DEBIT_AMOUNT;
	private BigDecimal	N17_LOW_CREDIT_NUM;
	private BigDecimal	N18_LOW_CREDIT_AMOUNT;
	private BigDecimal	N19_WALK_DEBIT_NUM;
	private BigDecimal	N20_WALK_DEBIT_AMOUNT;
	private BigDecimal	N21_WALK_CREDIT_NUM;
	private BigDecimal	N22_WALK_CREDIT_AMOUNT;
	private String	O1_PROD_NAME;
	private String	O2_DESC;
	private String	O3_RISK_ASS;
	private String	O4_FACE_TO_FACE;
	private String	O5_NON_FACE_TO_FACE;
	private String	O6_NON;
	private BigDecimal	O7_HIGH_DEBIT_NUM;
	private BigDecimal	O8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	O9_HIGH_CREDIT_NUM;
	private BigDecimal	O10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	O11_MEDIUM_DEBIT_NUM;
	private BigDecimal	O12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	O13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	O14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	O15_LOW_DEBIT_NUM;
	private BigDecimal	O16_LOW_DEBIT_AMOUNT;
	private BigDecimal	O17_LOW_CREDIT_NUM;
	private BigDecimal	O18_LOW_CREDIT_AMOUNT;
	private BigDecimal	O19_WALK_DEBIT_NUM;
	private BigDecimal	O20_WALK_DEBIT_AMOUNT;
	private BigDecimal	O21_WALK_CREDIT_NUM;
	private BigDecimal	O22_WALK_CREDIT_AMOUNT;
	private String	P1_PROD_NAME;
	private String	P2_DESC;
	private String	P3_RISK_ASS;
	private String	P4_FACE_TO_FACE;
	private String	P5_NON_FACE_TO_FACE;
	private String	P6_NON;
	private BigDecimal	P7_HIGH_DEBIT_NUM;
	private BigDecimal	P8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	P9_HIGH_CREDIT_NUM;
	private BigDecimal	P10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	P11_MEDIUM_DEBIT_NUM;
	private BigDecimal	P12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	P13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	P14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	P15_LOW_DEBIT_NUM;
	private BigDecimal	P16_LOW_DEBIT_AMOUNT;
	private BigDecimal	P17_LOW_CREDIT_NUM;
	private BigDecimal	P18_LOW_CREDIT_AMOUNT;
	private BigDecimal	P19_WALK_DEBIT_NUM;
	private BigDecimal	P20_WALK_DEBIT_AMOUNT;
	private BigDecimal	P21_WALK_CREDIT_NUM;
	private BigDecimal	P22_WALK_CREDIT_AMOUNT;
	private String	Q1_PROD_NAME;
	private String	Q2_DESC;
	private String	Q3_RISK_ASS;
	private String	Q4_FACE_TO_FACE;
	private String	Q5_NON_FACE_TO_FACE;
	private String	Q6_NON;
	private BigDecimal	Q7_HIGH_DEBIT_NUM;
	private BigDecimal	Q8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	Q9_HIGH_CREDIT_NUM;
	private BigDecimal	Q10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	Q11_MEDIUM_DEBIT_NUM;
	private BigDecimal	Q12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	Q13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	Q14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	Q15_LOW_DEBIT_NUM;
	private BigDecimal	Q16_LOW_DEBIT_AMOUNT;
	private BigDecimal	Q17_LOW_CREDIT_NUM;
	private BigDecimal	Q18_LOW_CREDIT_AMOUNT;
	private BigDecimal	Q19_WALK_DEBIT_NUM;
	private BigDecimal	Q20_WALK_DEBIT_AMOUNT;
	private BigDecimal	Q21_WALK_CREDIT_NUM;
	private BigDecimal	Q22_WALK_CREDIT_AMOUNT;
	private String	R1_PROD_NAME;
	private String	R2_DESC;
	private String	R3_RISK_ASS;
	private String	R4_FACE_TO_FACE;
	private String	R5_NON_FACE_TO_FACE;
	private String	R6_NON;
	private BigDecimal	R7_HIGH_DEBIT_NUM;
	private BigDecimal	R8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	R9_HIGH_CREDIT_NUM;
	private BigDecimal	R10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	R11_MEDIUM_DEBIT_NUM;
	private BigDecimal	R12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	R13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	R14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	R15_LOW_DEBIT_NUM;
	private BigDecimal	R16_LOW_DEBIT_AMOUNT;
	private BigDecimal	R17_LOW_CREDIT_NUM;
	private BigDecimal	R18_LOW_CREDIT_AMOUNT;
	private BigDecimal	R19_WALK_DEBIT_NUM;
	private BigDecimal	R20_WALK_DEBIT_AMOUNT;
	private BigDecimal	R21_WALK_CREDIT_NUM;
	private BigDecimal	R22_WALK_CREDIT_AMOUNT;
	private String	S1_PROD_NAME;
	private String	S2_DESC;
	private String	S3_RISK_ASS;
	private String	S4_FACE_TO_FACE;
	private String	S5_NON_FACE_TO_FACE;
	private String	S6_NON;
	private BigDecimal	S7_HIGH_DEBIT_NUM;
	private BigDecimal	S8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	S9_HIGH_CREDIT_NUM;
	private BigDecimal	S10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	S11_MEDIUM_DEBIT_NUM;
	private BigDecimal	S12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	S13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	S14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	S15_LOW_DEBIT_NUM;
	private BigDecimal	S16_LOW_DEBIT_AMOUNT;
	private BigDecimal	S17_LOW_CREDIT_NUM;
	private BigDecimal	S18_LOW_CREDIT_AMOUNT;
	private BigDecimal	S19_WALK_DEBIT_NUM;
	private BigDecimal	S20_WALK_DEBIT_AMOUNT;
	private BigDecimal	S21_WALK_CREDIT_NUM;
	private BigDecimal	S22_WALK_CREDIT_AMOUNT;
	private String	T1_PROD_NAME;
	private String	T2_DESC;
	private String	T3_RISK_ASS;
	private String	T4_FACE_TO_FACE;
	private String	T5_NON_FACE_TO_FACE;
	private String	T6_NON;
	private BigDecimal	T7_HIGH_DEBIT_NUM;
	private BigDecimal	T8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	T9_HIGH_CREDIT_NUM;
	private BigDecimal	T10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	T11_MEDIUM_DEBIT_NUM;
	private BigDecimal	T12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	T13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	T14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	T15_LOW_DEBIT_NUM;
	private BigDecimal	T16_LOW_DEBIT_AMOUNT;
	private BigDecimal	T17_LOW_CREDIT_NUM;
	private BigDecimal	T18_LOW_CREDIT_AMOUNT;
	private BigDecimal	T19_WALK_DEBIT_NUM;
	private BigDecimal	T20_WALK_DEBIT_AMOUNT;
	private BigDecimal	T21_WALK_CREDIT_NUM;
	private BigDecimal	T22_WALK_CREDIT_AMOUNT;
	private String	U1_PROD_NAME;
	private String	U2_DESC;
	private String	U3_RISK_ASS;
	private String	U4_FACE_TO_FACE;
	private String	U5_NON_FACE_TO_FACE;
	private String	U6_NON;
	private BigDecimal	U7_HIGH_DEBIT_NUM;
	private BigDecimal	U8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	U9_HIGH_CREDIT_NUM;
	private BigDecimal	U10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	U11_MEDIUM_DEBIT_NUM;
	private BigDecimal	U12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	U13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	U14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	U15_LOW_DEBIT_NUM;
	private BigDecimal	U16_LOW_DEBIT_AMOUNT;
	private BigDecimal	U17_LOW_CREDIT_NUM;
	private BigDecimal	U18_LOW_CREDIT_AMOUNT;
	private BigDecimal	U19_WALK_DEBIT_NUM;
	private BigDecimal	U20_WALK_DEBIT_AMOUNT;
	private BigDecimal	U21_WALK_CREDIT_NUM;
	private BigDecimal	U22_WALK_CREDIT_AMOUNT;
	private String	V1_PROD_NAME;
	private String	V2_DESC;
	private String	V3_RISK_ASS;
	private String	V4_FACE_TO_FACE;
	private String	V5_NON_FACE_TO_FACE;
	private String	V6_NON;
	private BigDecimal	V7_HIGH_DEBIT_NUM;
	private BigDecimal	V8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	V9_HIGH_CREDIT_NUM;
	private BigDecimal	V10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	V11_MEDIUM_DEBIT_NUM;
	private BigDecimal	V12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	V13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	V14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	V15_LOW_DEBIT_NUM;
	private BigDecimal	V16_LOW_DEBIT_AMOUNT;
	private BigDecimal	V17_LOW_CREDIT_NUM;
	private BigDecimal	V18_LOW_CREDIT_AMOUNT;
	private BigDecimal	V19_WALK_DEBIT_NUM;
	private BigDecimal	V20_WALK_DEBIT_AMOUNT;
	private BigDecimal	V21_WALK_CREDIT_NUM;
	private BigDecimal	V22_WALK_CREDIT_AMOUNT;
	private String	W1_PROD_NAME;
	private String	W2_DESC;
	private String	W3_RISK_ASS;
	private String	W4_FACE_TO_FACE;
	private String	W5_NON_FACE_TO_FACE;
	private String	W6_NON;
	private BigDecimal	W7_HIGH_DEBIT_NUM;
	private BigDecimal	W8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	W9_HIGH_CREDIT_NUM;
	private BigDecimal	W10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	W11_MEDIUM_DEBIT_NUM;
	private BigDecimal	W12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	W13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	W14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	W15_LOW_DEBIT_NUM;
	private BigDecimal	W16_LOW_DEBIT_AMOUNT;
	private BigDecimal	W17_LOW_CREDIT_NUM;
	private BigDecimal	W18_LOW_CREDIT_AMOUNT;
	private BigDecimal	W19_WALK_DEBIT_NUM;
	private BigDecimal	W20_WALK_DEBIT_AMOUNT;
	private BigDecimal	W21_WALK_CREDIT_NUM;
	private BigDecimal	W22_WALK_CREDIT_AMOUNT;
	private String	X1_PROD_NAME;
	private String	X2_DESC;
	private String	X3_RISK_ASS;
	private String	X4_FACE_TO_FACE;
	private String	X5_NON_FACE_TO_FACE;
	private String	X6_NON;
	private BigDecimal	X7_HIGH_DEBIT_NUM;
	private BigDecimal	X8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	X9_HIGH_CREDIT_NUM;
	private BigDecimal	X10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	X11_MEDIUM_DEBIT_NUM;
	private BigDecimal	X12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	X13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	X14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	X15_LOW_DEBIT_NUM;
	private BigDecimal	X16_LOW_DEBIT_AMOUNT;
	private BigDecimal	X17_LOW_CREDIT_NUM;
	private BigDecimal	X18_LOW_CREDIT_AMOUNT;
	private BigDecimal	X19_WALK_DEBIT_NUM;
	private BigDecimal	X20_WALK_DEBIT_AMOUNT;
	private BigDecimal	X21_WALK_CREDIT_NUM;
	private BigDecimal	X22_WALK_CREDIT_AMOUNT;
	private String	Y1_PROD_NAME;
	private String	Y2_DESC;
	private String	Y3_RISK_ASS;
	private String	Y4_FACE_TO_FACE;
	private String	Y5_NON_FACE_TO_FACE;
	private String	Y6_NON;
	private BigDecimal	Y7_HIGH_DEBIT_NUM;
	private BigDecimal	Y8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	Y9_HIGH_CREDIT_NUM;
	private BigDecimal	Y10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	Y11_MEDIUM_DEBIT_NUM;
	private BigDecimal	Y12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	Y13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	Y14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	Y15_LOW_DEBIT_NUM;
	private BigDecimal	Y16_LOW_DEBIT_AMOUNT;
	private BigDecimal	Y17_LOW_CREDIT_NUM;
	private BigDecimal	Y18_LOW_CREDIT_AMOUNT;
	private BigDecimal	Y19_WALK_DEBIT_NUM;
	private BigDecimal	Y20_WALK_DEBIT_AMOUNT;
	private BigDecimal	Y21_WALK_CREDIT_NUM;
	private BigDecimal	Y22_WALK_CREDIT_AMOUNT;
	private String	Z1_PROD_NAME;
	private String	Z2_DESC;
	private String	Z3_RISK_ASS;
	private String	Z4_FACE_TO_FACE;
	private String	Z5_NON_FACE_TO_FACE;
	private String	Z6_NON;
	private BigDecimal	Z7_HIGH_DEBIT_NUM;
	private BigDecimal	Z8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	Z9_HIGH_CREDIT_NUM;
	private BigDecimal	Z10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	Z11_MEDIUM_DEBIT_NUM;
	private BigDecimal	Z12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	Z13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	Z14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	Z15_LOW_DEBIT_NUM;
	private BigDecimal	Z16_LOW_DEBIT_AMOUNT;
	private BigDecimal	Z17_LOW_CREDIT_NUM;
	private BigDecimal	Z18_LOW_CREDIT_AMOUNT;
	private BigDecimal	Z19_WALK_DEBIT_NUM;
	private BigDecimal	Z20_WALK_DEBIT_AMOUNT;
	private BigDecimal	Z21_WALK_CREDIT_NUM;
	private BigDecimal	Z22_WALK_CREDIT_AMOUNT;
	private String	AA1_PROD_NAME;
	private String	AA2_DESC;
	private String	AA3_RISK_ASS;
	private String	AA4_FACE_TO_FACE;
	private String	AA5_NON_FACE_TO_FACE;
	private String	AA6_NON;
	private BigDecimal	AA7_HIGH_DEBIT_NUM;
	private BigDecimal	AA8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AA9_HIGH_CREDIT_NUM;
	private BigDecimal	AA10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AA11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AA12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AA13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AA14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AA15_LOW_DEBIT_NUM;
	private BigDecimal	AA16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AA17_LOW_CREDIT_NUM;
	private BigDecimal	AA18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AA19_WALK_DEBIT_NUM;
	private BigDecimal	AA20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AA21_WALK_CREDIT_NUM;
	private BigDecimal	AA22_WALK_CREDIT_AMOUNT;
	private String	AB1_PROD_NAME;
	private String	AB2_DESC;
	private String	AB3_RISK_ASS;
	private String	AB4_FACE_TO_FACE;
	private String	AB5_NON_FACE_TO_FACE;
	private String	AB6_NON;
	private BigDecimal	AB7_HIGH_DEBIT_NUM;
	private BigDecimal	AB8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AB9_HIGH_CREDIT_NUM;
	private BigDecimal	AB10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AB11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AB12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AB13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AB14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AB15_LOW_DEBIT_NUM;
	private BigDecimal	AB16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AB17_LOW_CREDIT_NUM;
	private BigDecimal	AB18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AB19_WALK_DEBIT_NUM;
	private BigDecimal	AB20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AB21_WALK_CREDIT_NUM;
	private BigDecimal	AB22_WALK_CREDIT_AMOUNT;
	private String	AC1_PROD_NAME;
	private String	AC2_DESC;
	private String	AC3_RISK_ASS;
	private String	AC4_FACE_TO_FACE;
	private String	AC5_NON_FACE_TO_FACE;
	private String	AC6_NON;
	private BigDecimal	AC7_HIGH_DEBIT_NUM;
	private BigDecimal	AC8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AC9_HIGH_CREDIT_NUM;
	private BigDecimal	AC10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AC11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AC12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AC13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AC14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AC15_LOW_DEBIT_NUM;
	private BigDecimal	AC16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AC17_LOW_CREDIT_NUM;
	private BigDecimal	AC18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AC19_WALK_DEBIT_NUM;
	private BigDecimal	AC20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AC21_WALK_CREDIT_NUM;
	private BigDecimal	AC22_WALK_CREDIT_AMOUNT;
	private String	AD1_PROD_NAME;
	private String	AD2_DESC;
	private String	AD3_RISK_ASS;
	private String	AD4_FACE_TO_FACE;
	private String	AD5_NON_FACE_TO_FACE;
	private String	AD6_NON;
	private BigDecimal	AD7_HIGH_DEBIT_NUM;
	private BigDecimal	AD8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AD9_HIGH_CREDIT_NUM;
	private BigDecimal	AD10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AD11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AD12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AD13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AD14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AD15_LOW_DEBIT_NUM;
	private BigDecimal	AD16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AD17_LOW_CREDIT_NUM;
	private BigDecimal	AD18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AD19_WALK_DEBIT_NUM;
	private BigDecimal	AD20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AD21_WALK_CREDIT_NUM;
	private BigDecimal	AD22_WALK_CREDIT_AMOUNT;
	private String	AE1_PROD_NAME;
	private String	AE2_DESC;
	private String	AE3_RISK_ASS;
	private String	AE4_FACE_TO_FACE;
	private String	AE5_NON_FACE_TO_FACE;
	private String	AE6_NON;
	private BigDecimal	AE7_HIGH_DEBIT_NUM;
	private BigDecimal	AE8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AE9_HIGH_CREDIT_NUM;
	private BigDecimal	AE10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AE11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AE12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AE13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AE14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AE15_LOW_DEBIT_NUM;
	private BigDecimal	AE16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AE17_LOW_CREDIT_NUM;
	private BigDecimal	AE18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AE19_WALK_DEBIT_NUM;
	private BigDecimal	AE20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AE21_WALK_CREDIT_NUM;
	private BigDecimal	AE22_WALK_CREDIT_AMOUNT;
	private String	AF1_PROD_NAME;
	private String	AF2_DESC;
	private String	AF3_RISK_ASS;
	private String	AF4_FACE_TO_FACE;
	private String	AF5_NON_FACE_TO_FACE;
	private String	AF6_NON;
	private BigDecimal	AF7_HIGH_DEBIT_NUM;
	private BigDecimal	AF8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AF9_HIGH_CREDIT_NUM;
	private BigDecimal	AF10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AF11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AF12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AF13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AF14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AF15_LOW_DEBIT_NUM;
	private BigDecimal	AF16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AF17_LOW_CREDIT_NUM;
	private BigDecimal	AF18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AF19_WALK_DEBIT_NUM;
	private BigDecimal	AF20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AF21_WALK_CREDIT_NUM;
	private BigDecimal	AF22_WALK_CREDIT_AMOUNT;
	private String	AG1_PROD_NAME;
	private String	AG2_DESC;
	private String	AG3_RISK_ASS;
	private String	AG4_FACE_TO_FACE;
	private String	AG5_NON_FACE_TO_FACE;
	private String	AG6_NON;
	private BigDecimal	AG7_HIGH_DEBIT_NUM;
	private BigDecimal	AG8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AG9_HIGH_CREDIT_NUM;
	private BigDecimal	AG10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AG11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AG12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AG13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AG14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AG15_LOW_DEBIT_NUM;
	private BigDecimal	AG16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AG17_LOW_CREDIT_NUM;
	private BigDecimal	AG18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AG19_WALK_DEBIT_NUM;
	private BigDecimal	AG20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AG21_WALK_CREDIT_NUM;
	private BigDecimal	AG22_WALK_CREDIT_AMOUNT;
	private String	AH1_PROD_NAME;
	private String	AH2_DESC;
	private String	AH3_RISK_ASS;
	private String	AH4_FACE_TO_FACE;
	private String	AH5_NON_FACE_TO_FACE;
	private String	AH6_NON;
	private BigDecimal	AH7_HIGH_DEBIT_NUM;
	private BigDecimal	AH8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AH9_HIGH_CREDIT_NUM;
	private BigDecimal	AH10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AH11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AH12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AH13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AH14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AH15_LOW_DEBIT_NUM;
	private BigDecimal	AH16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AH17_LOW_CREDIT_NUM;
	private BigDecimal	AH18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AH19_WALK_DEBIT_NUM;
	private BigDecimal	AH20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AH21_WALK_CREDIT_NUM;
	private BigDecimal	AH22_WALK_CREDIT_AMOUNT;
	private String	AI1_PROD_NAME;
	private String	AI2_DESC;
	private String	AI3_RISK_ASS;
	private String	AI4_FACE_TO_FACE;
	private String	AI5_NON_FACE_TO_FACE;
	private String	AI6_NON;
	private BigDecimal	AI7_HIGH_DEBIT_NUM;
	private BigDecimal	AI8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AI9_HIGH_CREDIT_NUM;
	private BigDecimal	AI10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AI11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AI12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AI13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AI14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AI15_LOW_DEBIT_NUM;
	private BigDecimal	AI16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AI17_LOW_CREDIT_NUM;
	private BigDecimal	AI18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AI19_WALK_DEBIT_NUM;
	private BigDecimal	AI20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AI21_WALK_CREDIT_NUM;
	private BigDecimal	AI22_WALK_CREDIT_AMOUNT;
	private String	AJ1_PROD_NAME;
	private String	AJ2_DESC;
	private String	AJ3_RISK_ASS;
	private String	AJ4_FACE_TO_FACE;
	private String	AJ5_NON_FACE_TO_FACE;
	private String	AJ6_NON;
	private BigDecimal	AJ7_HIGH_DEBIT_NUM;
	private BigDecimal	AJ8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AJ9_HIGH_CREDIT_NUM;
	private BigDecimal	AJ10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AJ11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AJ12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AJ13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AJ14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AJ15_LOW_DEBIT_NUM;
	private BigDecimal	AJ16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AJ17_LOW_CREDIT_NUM;
	private BigDecimal	AJ18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AJ19_WALK_DEBIT_NUM;
	private BigDecimal	AJ20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AJ21_WALK_CREDIT_NUM;
	private BigDecimal	AJ22_WALK_CREDIT_AMOUNT;
	private String	AK1_PROD_NAME;
	private String	AK2_DESC;
	private String	AK3_RISK_ASS;
	private String	AK4_FACE_TO_FACE;
	private String	AK5_NON_FACE_TO_FACE;
	private String	AK6_NON;
	private BigDecimal	AK7_HIGH_DEBIT_NUM;
	private BigDecimal	AK8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AK9_HIGH_CREDIT_NUM;
	private BigDecimal	AK10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AK11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AK12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AK13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AK14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AK15_LOW_DEBIT_NUM;
	private BigDecimal	AK16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AK17_LOW_CREDIT_NUM;
	private BigDecimal	AK18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AK19_WALK_DEBIT_NUM;
	private BigDecimal	AK20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AK21_WALK_CREDIT_NUM;
	private BigDecimal	AK22_WALK_CREDIT_AMOUNT;
	private String	AL1_PROD_NAME;
	private String	AL2_DESC;
	private String	AL3_RISK_ASS;
	private String	AL4_FACE_TO_FACE;
	private String	AL5_NON_FACE_TO_FACE;
	private String	AL6_NON;
	private BigDecimal	AL7_HIGH_DEBIT_NUM;
	private BigDecimal	AL8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AL9_HIGH_CREDIT_NUM;
	private BigDecimal	AL10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AL11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AL12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AL13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AL14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AL15_LOW_DEBIT_NUM;
	private BigDecimal	AL16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AL17_LOW_CREDIT_NUM;
	private BigDecimal	AL18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AL19_WALK_DEBIT_NUM;
	private BigDecimal	AL20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AL21_WALK_CREDIT_NUM;
	private BigDecimal	AL22_WALK_CREDIT_AMOUNT;
	private String	AM1_PROD_NAME;
	private String	AM2_DESC;
	private String	AM3_RISK_ASS;
	private String	AM4_FACE_TO_FACE;
	private String	AM5_NON_FACE_TO_FACE;
	private String	AM6_NON;
	private BigDecimal	AM7_HIGH_DEBIT_NUM;
	private BigDecimal	AM8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AM9_HIGH_CREDIT_NUM;
	private BigDecimal	AM10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AM11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AM12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AM13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AM14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AM15_LOW_DEBIT_NUM;
	private BigDecimal	AM16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AM17_LOW_CREDIT_NUM;
	private BigDecimal	AM18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AM19_WALK_DEBIT_NUM;
	private BigDecimal	AM20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AM21_WALK_CREDIT_NUM;
	private BigDecimal	AM22_WALK_CREDIT_AMOUNT;
	private String	AN1_PROD_NAME;
	private String	AN2_DESC;
	private String	AN3_RISK_ASS;
	private String	AN4_FACE_TO_FACE;
	private String	AN5_NON_FACE_TO_FACE;
	private String	AN6_NON;
	private BigDecimal	AN7_HIGH_DEBIT_NUM;
	private BigDecimal	AN8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AN9_HIGH_CREDIT_NUM;
	private BigDecimal	AN10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AN11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AN12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AN13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AN14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AN15_LOW_DEBIT_NUM;
	private BigDecimal	AN16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AN17_LOW_CREDIT_NUM;
	private BigDecimal	AN18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AN19_WALK_DEBIT_NUM;
	private BigDecimal	AN20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AN21_WALK_CREDIT_NUM;
	private BigDecimal	AN22_WALK_CREDIT_AMOUNT;
	private String	AO1_PROD_NAME;
	private String	AO2_DESC;
	private String	AO3_RISK_ASS;
	private String	AO4_FACE_TO_FACE;
	private String	AO5_NON_FACE_TO_FACE;
	private String	AO6_NON;
	private BigDecimal	AO7_HIGH_DEBIT_NUM;
	private BigDecimal	AO8_HIGH_DEBIT_AMOUNT;
	private BigDecimal	AO9_HIGH_CREDIT_NUM;
	private BigDecimal	AO10_HIGH_CREDIT_AMOUNT;
	private BigDecimal	AO11_MEDIUM_DEBIT_NUM;
	private BigDecimal	AO12_MEDIUM_DEBIT_AMOUNT;
	private BigDecimal	AO13_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AO14_MEDIUM_CREDIT_AMOUNT;
	private BigDecimal	AO15_LOW_DEBIT_NUM;
	private BigDecimal	AO16_LOW_DEBIT_AMOUNT;
	private BigDecimal	AO17_LOW_CREDIT_NUM;
	private BigDecimal	AO18_LOW_CREDIT_AMOUNT;
	private BigDecimal	AO19_WALK_DEBIT_NUM;
	private BigDecimal	AO20_WALK_DEBIT_AMOUNT;
	private BigDecimal	AO21_WALK_CREDIT_NUM;
	private BigDecimal	AO22_WALK_CREDIT_AMOUNT;

	private String	REPORT_CODE;
	private String	REPORT_NAME;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	REPORT_DATE;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	REPORT_DUE_DATE;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	REP_SUBMIT_DATE;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	REP_PERIOD_FROM;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	REP_PERIOD_TO;
	private String	REP_FREQ;
	private String	NIL_REPORT_FLG;
	private String	ARCH_FLG;

	
	public String getA1_PROD_NAME() {
		return A1_PROD_NAME;
	}
	public void setA1_PROD_NAME(String a1_PROD_NAME) {
		A1_PROD_NAME = a1_PROD_NAME;
	}
	public String getA2_DESC() {
		return A2_DESC;
	}
	public void setA2_DESC(String a2_DESC) {
		A2_DESC = a2_DESC;
	}
	public String getA3_RISK_ASS() {
		return A3_RISK_ASS;
	}
	public void setA3_RISK_ASS(String a3_RISK_ASS) {
		A3_RISK_ASS = a3_RISK_ASS;
	}
	public String getA4_FACE_TO_FACE() {
		return A4_FACE_TO_FACE;
	}
	public void setA4_FACE_TO_FACE(String a4_FACE_TO_FACE) {
		A4_FACE_TO_FACE = a4_FACE_TO_FACE;
	}
	public String getA5_NON_FACE_TO_FACE() {
		return A5_NON_FACE_TO_FACE;
	}
	public void setA5_NON_FACE_TO_FACE(String a5_NON_FACE_TO_FACE) {
		A5_NON_FACE_TO_FACE = a5_NON_FACE_TO_FACE;
	}
	public String getA6_NON() {
		return A6_NON;
	}
	public void setA6_NON(String a6_NON) {
		A6_NON = a6_NON;
	}
	public BigDecimal getA7_HIGH_DEBIT_NUM() {
		return A7_HIGH_DEBIT_NUM;
	}
	public void setA7_HIGH_DEBIT_NUM(BigDecimal a7_HIGH_DEBIT_NUM) {
		A7_HIGH_DEBIT_NUM = a7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getA8_HIGH_DEBIT_AMOUNT() {
		return A8_HIGH_DEBIT_AMOUNT;
	}
	public void setA8_HIGH_DEBIT_AMOUNT(BigDecimal a8_HIGH_DEBIT_AMOUNT) {
		A8_HIGH_DEBIT_AMOUNT = a8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getA9_HIGH_CREDIT_NUM() {
		return A9_HIGH_CREDIT_NUM;
	}
	public void setA9_HIGH_CREDIT_NUM(BigDecimal a9_HIGH_CREDIT_NUM) {
		A9_HIGH_CREDIT_NUM = a9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getA10_HIGH_CREDIT_AMOUNT() {
		return A10_HIGH_CREDIT_AMOUNT;
	}
	public void setA10_HIGH_CREDIT_AMOUNT(BigDecimal a10_HIGH_CREDIT_AMOUNT) {
		A10_HIGH_CREDIT_AMOUNT = a10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getA11_MEDIUM_DEBIT_NUM() {
		return A11_MEDIUM_DEBIT_NUM;
	}
	public void setA11_MEDIUM_DEBIT_NUM(BigDecimal a11_MEDIUM_DEBIT_NUM) {
		A11_MEDIUM_DEBIT_NUM = a11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getA12_MEDIUM_DEBIT_AMOUNT() {
		return A12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setA12_MEDIUM_DEBIT_AMOUNT(BigDecimal a12_MEDIUM_DEBIT_AMOUNT) {
		A12_MEDIUM_DEBIT_AMOUNT = a12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getA13_MEDIUM_CREDIT_AMOUNT() {
		return A13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setA13_MEDIUM_CREDIT_AMOUNT(BigDecimal a13_MEDIUM_CREDIT_AMOUNT) {
		A13_MEDIUM_CREDIT_AMOUNT = a13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getA14_MEDIUM_CREDIT_AMOUNT() {
		return A14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setA14_MEDIUM_CREDIT_AMOUNT(BigDecimal a14_MEDIUM_CREDIT_AMOUNT) {
		A14_MEDIUM_CREDIT_AMOUNT = a14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getA15_LOW_DEBIT_NUM() {
		return A15_LOW_DEBIT_NUM;
	}
	public void setA15_LOW_DEBIT_NUM(BigDecimal a15_LOW_DEBIT_NUM) {
		A15_LOW_DEBIT_NUM = a15_LOW_DEBIT_NUM;
	}
	public BigDecimal getA16_LOW_DEBIT_AMOUNT() {
		return A16_LOW_DEBIT_AMOUNT;
	}
	public void setA16_LOW_DEBIT_AMOUNT(BigDecimal a16_LOW_DEBIT_AMOUNT) {
		A16_LOW_DEBIT_AMOUNT = a16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getA17_LOW_CREDIT_NUM() {
		return A17_LOW_CREDIT_NUM;
	}
	public void setA17_LOW_CREDIT_NUM(BigDecimal a17_LOW_CREDIT_NUM) {
		A17_LOW_CREDIT_NUM = a17_LOW_CREDIT_NUM;
	}
	public BigDecimal getA18_LOW_CREDIT_AMOUNT() {
		return A18_LOW_CREDIT_AMOUNT;
	}
	public void setA18_LOW_CREDIT_AMOUNT(BigDecimal a18_LOW_CREDIT_AMOUNT) {
		A18_LOW_CREDIT_AMOUNT = a18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getA19_WALK_DEBIT_NUM() {
		return A19_WALK_DEBIT_NUM;
	}
	public void setA19_WALK_DEBIT_NUM(BigDecimal a19_WALK_DEBIT_NUM) {
		A19_WALK_DEBIT_NUM = a19_WALK_DEBIT_NUM;
	}
	public BigDecimal getA20_WALK_DEBIT_AMOUNT() {
		return A20_WALK_DEBIT_AMOUNT;
	}
	public void setA20_WALK_DEBIT_AMOUNT(BigDecimal a20_WALK_DEBIT_AMOUNT) {
		A20_WALK_DEBIT_AMOUNT = a20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getA21_WALK_CREDIT_NUM() {
		return A21_WALK_CREDIT_NUM;
	}
	public void setA21_WALK_CREDIT_NUM(BigDecimal a21_WALK_CREDIT_NUM) {
		A21_WALK_CREDIT_NUM = a21_WALK_CREDIT_NUM;
	}
	public BigDecimal getA22_WALK_CREDIT_AMOUNT() {
		return A22_WALK_CREDIT_AMOUNT;
	}
	public void setA22_WALK_CREDIT_AMOUNT(BigDecimal a22_WALK_CREDIT_AMOUNT) {
		A22_WALK_CREDIT_AMOUNT = a22_WALK_CREDIT_AMOUNT;
	}
	public String getB1_PROD_NAME() {
		return B1_PROD_NAME;
	}
	public void setB1_PROD_NAME(String b1_PROD_NAME) {
		B1_PROD_NAME = b1_PROD_NAME;
	}
	public String getB2_DESC() {
		return B2_DESC;
	}
	public void setB2_DESC(String b2_DESC) {
		B2_DESC = b2_DESC;
	}
	public String getB3_RISK_ASS() {
		return B3_RISK_ASS;
	}
	public void setB3_RISK_ASS(String b3_RISK_ASS) {
		B3_RISK_ASS = b3_RISK_ASS;
	}
	public String getB4_FACE_TO_FACE() {
		return B4_FACE_TO_FACE;
	}
	public void setB4_FACE_TO_FACE(String b4_FACE_TO_FACE) {
		B4_FACE_TO_FACE = b4_FACE_TO_FACE;
	}
	public String getB5_NON_FACE_TO_FACE() {
		return B5_NON_FACE_TO_FACE;
	}
	public void setB5_NON_FACE_TO_FACE(String b5_NON_FACE_TO_FACE) {
		B5_NON_FACE_TO_FACE = b5_NON_FACE_TO_FACE;
	}
	public String getB6_NON() {
		return B6_NON;
	}
	public void setB6_NON(String b6_NON) {
		B6_NON = b6_NON;
	}
	public BigDecimal getB7_HIGH_DEBIT_NUM() {
		return B7_HIGH_DEBIT_NUM;
	}
	public void setB7_HIGH_DEBIT_NUM(BigDecimal b7_HIGH_DEBIT_NUM) {
		B7_HIGH_DEBIT_NUM = b7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getB8_HIGH_DEBIT_AMOUNT() {
		return B8_HIGH_DEBIT_AMOUNT;
	}
	public void setB8_HIGH_DEBIT_AMOUNT(BigDecimal b8_HIGH_DEBIT_AMOUNT) {
		B8_HIGH_DEBIT_AMOUNT = b8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getB9_HIGH_CREDIT_NUM() {
		return B9_HIGH_CREDIT_NUM;
	}
	public void setB9_HIGH_CREDIT_NUM(BigDecimal b9_HIGH_CREDIT_NUM) {
		B9_HIGH_CREDIT_NUM = b9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getB10_HIGH_CREDIT_AMOUNT() {
		return B10_HIGH_CREDIT_AMOUNT;
	}
	public void setB10_HIGH_CREDIT_AMOUNT(BigDecimal b10_HIGH_CREDIT_AMOUNT) {
		B10_HIGH_CREDIT_AMOUNT = b10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getB11_MEDIUM_DEBIT_NUM() {
		return B11_MEDIUM_DEBIT_NUM;
	}
	public void setB11_MEDIUM_DEBIT_NUM(BigDecimal b11_MEDIUM_DEBIT_NUM) {
		B11_MEDIUM_DEBIT_NUM = b11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getB12_MEDIUM_DEBIT_AMOUNT() {
		return B12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setB12_MEDIUM_DEBIT_AMOUNT(BigDecimal b12_MEDIUM_DEBIT_AMOUNT) {
		B12_MEDIUM_DEBIT_AMOUNT = b12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getB13_MEDIUM_CREDIT_AMOUNT() {
		return B13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setB13_MEDIUM_CREDIT_AMOUNT(BigDecimal b13_MEDIUM_CREDIT_AMOUNT) {
		B13_MEDIUM_CREDIT_AMOUNT = b13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getB14_MEDIUM_CREDIT_AMOUNT() {
		return B14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setB14_MEDIUM_CREDIT_AMOUNT(BigDecimal b14_MEDIUM_CREDIT_AMOUNT) {
		B14_MEDIUM_CREDIT_AMOUNT = b14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getB15_LOW_DEBIT_NUM() {
		return B15_LOW_DEBIT_NUM;
	}
	public void setB15_LOW_DEBIT_NUM(BigDecimal b15_LOW_DEBIT_NUM) {
		B15_LOW_DEBIT_NUM = b15_LOW_DEBIT_NUM;
	}
	public BigDecimal getB16_LOW_DEBIT_AMOUNT() {
		return B16_LOW_DEBIT_AMOUNT;
	}
	public void setB16_LOW_DEBIT_AMOUNT(BigDecimal b16_LOW_DEBIT_AMOUNT) {
		B16_LOW_DEBIT_AMOUNT = b16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getB17_LOW_CREDIT_NUM() {
		return B17_LOW_CREDIT_NUM;
	}
	public void setB17_LOW_CREDIT_NUM(BigDecimal b17_LOW_CREDIT_NUM) {
		B17_LOW_CREDIT_NUM = b17_LOW_CREDIT_NUM;
	}
	public BigDecimal getB18_LOW_CREDIT_AMOUNT() {
		return B18_LOW_CREDIT_AMOUNT;
	}
	public void setB18_LOW_CREDIT_AMOUNT(BigDecimal b18_LOW_CREDIT_AMOUNT) {
		B18_LOW_CREDIT_AMOUNT = b18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getB19_WALK_DEBIT_NUM() {
		return B19_WALK_DEBIT_NUM;
	}
	public void setB19_WALK_DEBIT_NUM(BigDecimal b19_WALK_DEBIT_NUM) {
		B19_WALK_DEBIT_NUM = b19_WALK_DEBIT_NUM;
	}
	public BigDecimal getB20_WALK_DEBIT_AMOUNT() {
		return B20_WALK_DEBIT_AMOUNT;
	}
	public void setB20_WALK_DEBIT_AMOUNT(BigDecimal b20_WALK_DEBIT_AMOUNT) {
		B20_WALK_DEBIT_AMOUNT = b20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getB21_WALK_CREDIT_NUM() {
		return B21_WALK_CREDIT_NUM;
	}
	public void setB21_WALK_CREDIT_NUM(BigDecimal b21_WALK_CREDIT_NUM) {
		B21_WALK_CREDIT_NUM = b21_WALK_CREDIT_NUM;
	}
	public BigDecimal getB22_WALK_CREDIT_AMOUNT() {
		return B22_WALK_CREDIT_AMOUNT;
	}
	public void setB22_WALK_CREDIT_AMOUNT(BigDecimal b22_WALK_CREDIT_AMOUNT) {
		B22_WALK_CREDIT_AMOUNT = b22_WALK_CREDIT_AMOUNT;
	}
	public String getC1_PROD_NAME() {
		return C1_PROD_NAME;
	}
	public void setC1_PROD_NAME(String c1_PROD_NAME) {
		C1_PROD_NAME = c1_PROD_NAME;
	}
	public String getC2_DESC() {
		return C2_DESC;
	}
	public void setC2_DESC(String c2_DESC) {
		C2_DESC = c2_DESC;
	}
	public String getC3_RISK_ASS() {
		return C3_RISK_ASS;
	}
	public void setC3_RISK_ASS(String c3_RISK_ASS) {
		C3_RISK_ASS = c3_RISK_ASS;
	}
	public String getC4_FACE_TO_FACE() {
		return C4_FACE_TO_FACE;
	}
	public void setC4_FACE_TO_FACE(String c4_FACE_TO_FACE) {
		C4_FACE_TO_FACE = c4_FACE_TO_FACE;
	}
	public String getC5_NON_FACE_TO_FACE() {
		return C5_NON_FACE_TO_FACE;
	}
	public void setC5_NON_FACE_TO_FACE(String c5_NON_FACE_TO_FACE) {
		C5_NON_FACE_TO_FACE = c5_NON_FACE_TO_FACE;
	}
	public String getC6_NON() {
		return C6_NON;
	}
	public void setC6_NON(String c6_NON) {
		C6_NON = c6_NON;
	}
	public BigDecimal getC7_HIGH_DEBIT_NUM() {
		return C7_HIGH_DEBIT_NUM;
	}
	public void setC7_HIGH_DEBIT_NUM(BigDecimal c7_HIGH_DEBIT_NUM) {
		C7_HIGH_DEBIT_NUM = c7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getC8_HIGH_DEBIT_AMOUNT() {
		return C8_HIGH_DEBIT_AMOUNT;
	}
	public void setC8_HIGH_DEBIT_AMOUNT(BigDecimal c8_HIGH_DEBIT_AMOUNT) {
		C8_HIGH_DEBIT_AMOUNT = c8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getC9_HIGH_CREDIT_NUM() {
		return C9_HIGH_CREDIT_NUM;
	}
	public void setC9_HIGH_CREDIT_NUM(BigDecimal c9_HIGH_CREDIT_NUM) {
		C9_HIGH_CREDIT_NUM = c9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getC10_HIGH_CREDIT_AMOUNT() {
		return C10_HIGH_CREDIT_AMOUNT;
	}
	public void setC10_HIGH_CREDIT_AMOUNT(BigDecimal c10_HIGH_CREDIT_AMOUNT) {
		C10_HIGH_CREDIT_AMOUNT = c10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getC11_MEDIUM_DEBIT_NUM() {
		return C11_MEDIUM_DEBIT_NUM;
	}
	public void setC11_MEDIUM_DEBIT_NUM(BigDecimal c11_MEDIUM_DEBIT_NUM) {
		C11_MEDIUM_DEBIT_NUM = c11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getC12_MEDIUM_DEBIT_AMOUNT() {
		return C12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setC12_MEDIUM_DEBIT_AMOUNT(BigDecimal c12_MEDIUM_DEBIT_AMOUNT) {
		C12_MEDIUM_DEBIT_AMOUNT = c12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getC13_MEDIUM_CREDIT_AMOUNT() {
		return C13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setC13_MEDIUM_CREDIT_AMOUNT(BigDecimal c13_MEDIUM_CREDIT_AMOUNT) {
		C13_MEDIUM_CREDIT_AMOUNT = c13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getC14_MEDIUM_CREDIT_AMOUNT() {
		return C14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setC14_MEDIUM_CREDIT_AMOUNT(BigDecimal c14_MEDIUM_CREDIT_AMOUNT) {
		C14_MEDIUM_CREDIT_AMOUNT = c14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getC15_LOW_DEBIT_NUM() {
		return C15_LOW_DEBIT_NUM;
	}
	public void setC15_LOW_DEBIT_NUM(BigDecimal c15_LOW_DEBIT_NUM) {
		C15_LOW_DEBIT_NUM = c15_LOW_DEBIT_NUM;
	}
	public BigDecimal getC16_LOW_DEBIT_AMOUNT() {
		return C16_LOW_DEBIT_AMOUNT;
	}
	public void setC16_LOW_DEBIT_AMOUNT(BigDecimal c16_LOW_DEBIT_AMOUNT) {
		C16_LOW_DEBIT_AMOUNT = c16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getC17_LOW_CREDIT_NUM() {
		return C17_LOW_CREDIT_NUM;
	}
	public void setC17_LOW_CREDIT_NUM(BigDecimal c17_LOW_CREDIT_NUM) {
		C17_LOW_CREDIT_NUM = c17_LOW_CREDIT_NUM;
	}
	public BigDecimal getC18_LOW_CREDIT_AMOUNT() {
		return C18_LOW_CREDIT_AMOUNT;
	}
	public void setC18_LOW_CREDIT_AMOUNT(BigDecimal c18_LOW_CREDIT_AMOUNT) {
		C18_LOW_CREDIT_AMOUNT = c18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getC19_WALK_DEBIT_NUM() {
		return C19_WALK_DEBIT_NUM;
	}
	public void setC19_WALK_DEBIT_NUM(BigDecimal c19_WALK_DEBIT_NUM) {
		C19_WALK_DEBIT_NUM = c19_WALK_DEBIT_NUM;
	}
	public BigDecimal getC20_WALK_DEBIT_AMOUNT() {
		return C20_WALK_DEBIT_AMOUNT;
	}
	public void setC20_WALK_DEBIT_AMOUNT(BigDecimal c20_WALK_DEBIT_AMOUNT) {
		C20_WALK_DEBIT_AMOUNT = c20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getC21_WALK_CREDIT_NUM() {
		return C21_WALK_CREDIT_NUM;
	}
	public void setC21_WALK_CREDIT_NUM(BigDecimal c21_WALK_CREDIT_NUM) {
		C21_WALK_CREDIT_NUM = c21_WALK_CREDIT_NUM;
	}
	public BigDecimal getC22_WALK_CREDIT_AMOUNT() {
		return C22_WALK_CREDIT_AMOUNT;
	}
	public void setC22_WALK_CREDIT_AMOUNT(BigDecimal c22_WALK_CREDIT_AMOUNT) {
		C22_WALK_CREDIT_AMOUNT = c22_WALK_CREDIT_AMOUNT;
	}
	public String getD1_PROD_NAME() {
		return D1_PROD_NAME;
	}
	public void setD1_PROD_NAME(String d1_PROD_NAME) {
		D1_PROD_NAME = d1_PROD_NAME;
	}
	public String getD2_DESC() {
		return D2_DESC;
	}
	public void setD2_DESC(String d2_DESC) {
		D2_DESC = d2_DESC;
	}
	public String getD3_RISK_ASS() {
		return D3_RISK_ASS;
	}
	public void setD3_RISK_ASS(String d3_RISK_ASS) {
		D3_RISK_ASS = d3_RISK_ASS;
	}
	public String getD4_FACE_TO_FACE() {
		return D4_FACE_TO_FACE;
	}
	public void setD4_FACE_TO_FACE(String d4_FACE_TO_FACE) {
		D4_FACE_TO_FACE = d4_FACE_TO_FACE;
	}
	public String getD5_NON_FACE_TO_FACE() {
		return D5_NON_FACE_TO_FACE;
	}
	public void setD5_NON_FACE_TO_FACE(String d5_NON_FACE_TO_FACE) {
		D5_NON_FACE_TO_FACE = d5_NON_FACE_TO_FACE;
	}
	public String getD6_NON() {
		return D6_NON;
	}
	public void setD6_NON(String d6_NON) {
		D6_NON = d6_NON;
	}
	public BigDecimal getD7_HIGH_DEBIT_NUM() {
		return D7_HIGH_DEBIT_NUM;
	}
	public void setD7_HIGH_DEBIT_NUM(BigDecimal d7_HIGH_DEBIT_NUM) {
		D7_HIGH_DEBIT_NUM = d7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getD8_HIGH_DEBIT_AMOUNT() {
		return D8_HIGH_DEBIT_AMOUNT;
	}
	public void setD8_HIGH_DEBIT_AMOUNT(BigDecimal d8_HIGH_DEBIT_AMOUNT) {
		D8_HIGH_DEBIT_AMOUNT = d8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getD9_HIGH_CREDIT_NUM() {
		return D9_HIGH_CREDIT_NUM;
	}
	public void setD9_HIGH_CREDIT_NUM(BigDecimal d9_HIGH_CREDIT_NUM) {
		D9_HIGH_CREDIT_NUM = d9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getD10_HIGH_CREDIT_AMOUNT() {
		return D10_HIGH_CREDIT_AMOUNT;
	}
	public void setD10_HIGH_CREDIT_AMOUNT(BigDecimal d10_HIGH_CREDIT_AMOUNT) {
		D10_HIGH_CREDIT_AMOUNT = d10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getD11_MEDIUM_DEBIT_NUM() {
		return D11_MEDIUM_DEBIT_NUM;
	}
	public void setD11_MEDIUM_DEBIT_NUM(BigDecimal d11_MEDIUM_DEBIT_NUM) {
		D11_MEDIUM_DEBIT_NUM = d11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getD12_MEDIUM_DEBIT_AMOUNT() {
		return D12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setD12_MEDIUM_DEBIT_AMOUNT(BigDecimal d12_MEDIUM_DEBIT_AMOUNT) {
		D12_MEDIUM_DEBIT_AMOUNT = d12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getD13_MEDIUM_CREDIT_AMOUNT() {
		return D13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setD13_MEDIUM_CREDIT_AMOUNT(BigDecimal d13_MEDIUM_CREDIT_AMOUNT) {
		D13_MEDIUM_CREDIT_AMOUNT = d13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getD14_MEDIUM_CREDIT_AMOUNT() {
		return D14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setD14_MEDIUM_CREDIT_AMOUNT(BigDecimal d14_MEDIUM_CREDIT_AMOUNT) {
		D14_MEDIUM_CREDIT_AMOUNT = d14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getD15_LOW_DEBIT_NUM() {
		return D15_LOW_DEBIT_NUM;
	}
	public void setD15_LOW_DEBIT_NUM(BigDecimal d15_LOW_DEBIT_NUM) {
		D15_LOW_DEBIT_NUM = d15_LOW_DEBIT_NUM;
	}
	public BigDecimal getD16_LOW_DEBIT_AMOUNT() {
		return D16_LOW_DEBIT_AMOUNT;
	}
	public void setD16_LOW_DEBIT_AMOUNT(BigDecimal d16_LOW_DEBIT_AMOUNT) {
		D16_LOW_DEBIT_AMOUNT = d16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getD17_LOW_CREDIT_NUM() {
		return D17_LOW_CREDIT_NUM;
	}
	public void setD17_LOW_CREDIT_NUM(BigDecimal d17_LOW_CREDIT_NUM) {
		D17_LOW_CREDIT_NUM = d17_LOW_CREDIT_NUM;
	}
	public BigDecimal getD18_LOW_CREDIT_AMOUNT() {
		return D18_LOW_CREDIT_AMOUNT;
	}
	public void setD18_LOW_CREDIT_AMOUNT(BigDecimal d18_LOW_CREDIT_AMOUNT) {
		D18_LOW_CREDIT_AMOUNT = d18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getD19_WALK_DEBIT_NUM() {
		return D19_WALK_DEBIT_NUM;
	}
	public void setD19_WALK_DEBIT_NUM(BigDecimal d19_WALK_DEBIT_NUM) {
		D19_WALK_DEBIT_NUM = d19_WALK_DEBIT_NUM;
	}
	public BigDecimal getD20_WALK_DEBIT_AMOUNT() {
		return D20_WALK_DEBIT_AMOUNT;
	}
	public void setD20_WALK_DEBIT_AMOUNT(BigDecimal d20_WALK_DEBIT_AMOUNT) {
		D20_WALK_DEBIT_AMOUNT = d20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getD21_WALK_CREDIT_NUM() {
		return D21_WALK_CREDIT_NUM;
	}
	public void setD21_WALK_CREDIT_NUM(BigDecimal d21_WALK_CREDIT_NUM) {
		D21_WALK_CREDIT_NUM = d21_WALK_CREDIT_NUM;
	}
	public BigDecimal getD22_WALK_CREDIT_AMOUNT() {
		return D22_WALK_CREDIT_AMOUNT;
	}
	public void setD22_WALK_CREDIT_AMOUNT(BigDecimal d22_WALK_CREDIT_AMOUNT) {
		D22_WALK_CREDIT_AMOUNT = d22_WALK_CREDIT_AMOUNT;
	}
	public String getE1_PROD_NAME() {
		return E1_PROD_NAME;
	}
	public void setE1_PROD_NAME(String e1_PROD_NAME) {
		E1_PROD_NAME = e1_PROD_NAME;
	}
	public String getE2_DESC() {
		return E2_DESC;
	}
	public void setE2_DESC(String e2_DESC) {
		E2_DESC = e2_DESC;
	}
	public String getE3_RISK_ASS() {
		return E3_RISK_ASS;
	}
	public void setE3_RISK_ASS(String e3_RISK_ASS) {
		E3_RISK_ASS = e3_RISK_ASS;
	}
	public String getE4_FACE_TO_FACE() {
		return E4_FACE_TO_FACE;
	}
	public void setE4_FACE_TO_FACE(String e4_FACE_TO_FACE) {
		E4_FACE_TO_FACE = e4_FACE_TO_FACE;
	}
	public String getE5_NON_FACE_TO_FACE() {
		return E5_NON_FACE_TO_FACE;
	}
	public void setE5_NON_FACE_TO_FACE(String e5_NON_FACE_TO_FACE) {
		E5_NON_FACE_TO_FACE = e5_NON_FACE_TO_FACE;
	}
	public String getE6_NON() {
		return E6_NON;
	}
	public void setE6_NON(String e6_NON) {
		E6_NON = e6_NON;
	}
	public BigDecimal getE7_HIGH_DEBIT_NUM() {
		return E7_HIGH_DEBIT_NUM;
	}
	public void setE7_HIGH_DEBIT_NUM(BigDecimal e7_HIGH_DEBIT_NUM) {
		E7_HIGH_DEBIT_NUM = e7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getE8_HIGH_DEBIT_AMOUNT() {
		return E8_HIGH_DEBIT_AMOUNT;
	}
	public void setE8_HIGH_DEBIT_AMOUNT(BigDecimal e8_HIGH_DEBIT_AMOUNT) {
		E8_HIGH_DEBIT_AMOUNT = e8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getE9_HIGH_CREDIT_NUM() {
		return E9_HIGH_CREDIT_NUM;
	}
	public void setE9_HIGH_CREDIT_NUM(BigDecimal e9_HIGH_CREDIT_NUM) {
		E9_HIGH_CREDIT_NUM = e9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getE10_HIGH_CREDIT_AMOUNT() {
		return E10_HIGH_CREDIT_AMOUNT;
	}
	public void setE10_HIGH_CREDIT_AMOUNT(BigDecimal e10_HIGH_CREDIT_AMOUNT) {
		E10_HIGH_CREDIT_AMOUNT = e10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getE11_MEDIUM_DEBIT_NUM() {
		return E11_MEDIUM_DEBIT_NUM;
	}
	public void setE11_MEDIUM_DEBIT_NUM(BigDecimal e11_MEDIUM_DEBIT_NUM) {
		E11_MEDIUM_DEBIT_NUM = e11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getE12_MEDIUM_DEBIT_AMOUNT() {
		return E12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setE12_MEDIUM_DEBIT_AMOUNT(BigDecimal e12_MEDIUM_DEBIT_AMOUNT) {
		E12_MEDIUM_DEBIT_AMOUNT = e12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getE13_MEDIUM_CREDIT_AMOUNT() {
		return E13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setE13_MEDIUM_CREDIT_AMOUNT(BigDecimal e13_MEDIUM_CREDIT_AMOUNT) {
		E13_MEDIUM_CREDIT_AMOUNT = e13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getE14_MEDIUM_CREDIT_AMOUNT() {
		return E14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setE14_MEDIUM_CREDIT_AMOUNT(BigDecimal e14_MEDIUM_CREDIT_AMOUNT) {
		E14_MEDIUM_CREDIT_AMOUNT = e14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getE15_LOW_DEBIT_NUM() {
		return E15_LOW_DEBIT_NUM;
	}
	public void setE15_LOW_DEBIT_NUM(BigDecimal e15_LOW_DEBIT_NUM) {
		E15_LOW_DEBIT_NUM = e15_LOW_DEBIT_NUM;
	}
	public BigDecimal getE16_LOW_DEBIT_AMOUNT() {
		return E16_LOW_DEBIT_AMOUNT;
	}
	public void setE16_LOW_DEBIT_AMOUNT(BigDecimal e16_LOW_DEBIT_AMOUNT) {
		E16_LOW_DEBIT_AMOUNT = e16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getE17_LOW_CREDIT_NUM() {
		return E17_LOW_CREDIT_NUM;
	}
	public void setE17_LOW_CREDIT_NUM(BigDecimal e17_LOW_CREDIT_NUM) {
		E17_LOW_CREDIT_NUM = e17_LOW_CREDIT_NUM;
	}
	public BigDecimal getE18_LOW_CREDIT_AMOUNT() {
		return E18_LOW_CREDIT_AMOUNT;
	}
	public void setE18_LOW_CREDIT_AMOUNT(BigDecimal e18_LOW_CREDIT_AMOUNT) {
		E18_LOW_CREDIT_AMOUNT = e18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getE19_WALK_DEBIT_NUM() {
		return E19_WALK_DEBIT_NUM;
	}
	public void setE19_WALK_DEBIT_NUM(BigDecimal e19_WALK_DEBIT_NUM) {
		E19_WALK_DEBIT_NUM = e19_WALK_DEBIT_NUM;
	}
	public BigDecimal getE20_WALK_DEBIT_AMOUNT() {
		return E20_WALK_DEBIT_AMOUNT;
	}
	public void setE20_WALK_DEBIT_AMOUNT(BigDecimal e20_WALK_DEBIT_AMOUNT) {
		E20_WALK_DEBIT_AMOUNT = e20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getE21_WALK_CREDIT_NUM() {
		return E21_WALK_CREDIT_NUM;
	}
	public void setE21_WALK_CREDIT_NUM(BigDecimal e21_WALK_CREDIT_NUM) {
		E21_WALK_CREDIT_NUM = e21_WALK_CREDIT_NUM;
	}
	public BigDecimal getE22_WALK_CREDIT_AMOUNT() {
		return E22_WALK_CREDIT_AMOUNT;
	}
	public void setE22_WALK_CREDIT_AMOUNT(BigDecimal e22_WALK_CREDIT_AMOUNT) {
		E22_WALK_CREDIT_AMOUNT = e22_WALK_CREDIT_AMOUNT;
	}
	public String getF1_PROD_NAME() {
		return F1_PROD_NAME;
	}
	public void setF1_PROD_NAME(String f1_PROD_NAME) {
		F1_PROD_NAME = f1_PROD_NAME;
	}
	public String getF2_DESC() {
		return F2_DESC;
	}
	public void setF2_DESC(String f2_DESC) {
		F2_DESC = f2_DESC;
	}
	public String getF3_RISK_ASS() {
		return F3_RISK_ASS;
	}
	public void setF3_RISK_ASS(String f3_RISK_ASS) {
		F3_RISK_ASS = f3_RISK_ASS;
	}
	public String getF4_FACE_TO_FACE() {
		return F4_FACE_TO_FACE;
	}
	public void setF4_FACE_TO_FACE(String f4_FACE_TO_FACE) {
		F4_FACE_TO_FACE = f4_FACE_TO_FACE;
	}
	public String getF5_NON_FACE_TO_FACE() {
		return F5_NON_FACE_TO_FACE;
	}
	public void setF5_NON_FACE_TO_FACE(String f5_NON_FACE_TO_FACE) {
		F5_NON_FACE_TO_FACE = f5_NON_FACE_TO_FACE;
	}
	public String getF6_NON() {
		return F6_NON;
	}
	public void setF6_NON(String f6_NON) {
		F6_NON = f6_NON;
	}
	public BigDecimal getF7_HIGH_DEBIT_NUM() {
		return F7_HIGH_DEBIT_NUM;
	}
	public void setF7_HIGH_DEBIT_NUM(BigDecimal f7_HIGH_DEBIT_NUM) {
		F7_HIGH_DEBIT_NUM = f7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getF8_HIGH_DEBIT_AMOUNT() {
		return F8_HIGH_DEBIT_AMOUNT;
	}
	public void setF8_HIGH_DEBIT_AMOUNT(BigDecimal f8_HIGH_DEBIT_AMOUNT) {
		F8_HIGH_DEBIT_AMOUNT = f8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getF9_HIGH_CREDIT_NUM() {
		return F9_HIGH_CREDIT_NUM;
	}
	public void setF9_HIGH_CREDIT_NUM(BigDecimal f9_HIGH_CREDIT_NUM) {
		F9_HIGH_CREDIT_NUM = f9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getF10_HIGH_CREDIT_AMOUNT() {
		return F10_HIGH_CREDIT_AMOUNT;
	}
	public void setF10_HIGH_CREDIT_AMOUNT(BigDecimal f10_HIGH_CREDIT_AMOUNT) {
		F10_HIGH_CREDIT_AMOUNT = f10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getF11_MEDIUM_DEBIT_NUM() {
		return F11_MEDIUM_DEBIT_NUM;
	}
	public void setF11_MEDIUM_DEBIT_NUM(BigDecimal f11_MEDIUM_DEBIT_NUM) {
		F11_MEDIUM_DEBIT_NUM = f11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getF12_MEDIUM_DEBIT_AMOUNT() {
		return F12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setF12_MEDIUM_DEBIT_AMOUNT(BigDecimal f12_MEDIUM_DEBIT_AMOUNT) {
		F12_MEDIUM_DEBIT_AMOUNT = f12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getF13_MEDIUM_CREDIT_AMOUNT() {
		return F13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setF13_MEDIUM_CREDIT_AMOUNT(BigDecimal f13_MEDIUM_CREDIT_AMOUNT) {
		F13_MEDIUM_CREDIT_AMOUNT = f13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getF14_MEDIUM_CREDIT_AMOUNT() {
		return F14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setF14_MEDIUM_CREDIT_AMOUNT(BigDecimal f14_MEDIUM_CREDIT_AMOUNT) {
		F14_MEDIUM_CREDIT_AMOUNT = f14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getF15_LOW_DEBIT_NUM() {
		return F15_LOW_DEBIT_NUM;
	}
	public void setF15_LOW_DEBIT_NUM(BigDecimal f15_LOW_DEBIT_NUM) {
		F15_LOW_DEBIT_NUM = f15_LOW_DEBIT_NUM;
	}
	public BigDecimal getF16_LOW_DEBIT_AMOUNT() {
		return F16_LOW_DEBIT_AMOUNT;
	}
	public void setF16_LOW_DEBIT_AMOUNT(BigDecimal f16_LOW_DEBIT_AMOUNT) {
		F16_LOW_DEBIT_AMOUNT = f16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getF17_LOW_CREDIT_NUM() {
		return F17_LOW_CREDIT_NUM;
	}
	public void setF17_LOW_CREDIT_NUM(BigDecimal f17_LOW_CREDIT_NUM) {
		F17_LOW_CREDIT_NUM = f17_LOW_CREDIT_NUM;
	}
	public BigDecimal getF18_LOW_CREDIT_AMOUNT() {
		return F18_LOW_CREDIT_AMOUNT;
	}
	public void setF18_LOW_CREDIT_AMOUNT(BigDecimal f18_LOW_CREDIT_AMOUNT) {
		F18_LOW_CREDIT_AMOUNT = f18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getF19_WALK_DEBIT_NUM() {
		return F19_WALK_DEBIT_NUM;
	}
	public void setF19_WALK_DEBIT_NUM(BigDecimal f19_WALK_DEBIT_NUM) {
		F19_WALK_DEBIT_NUM = f19_WALK_DEBIT_NUM;
	}
	public BigDecimal getF20_WALK_DEBIT_AMOUNT() {
		return F20_WALK_DEBIT_AMOUNT;
	}
	public void setF20_WALK_DEBIT_AMOUNT(BigDecimal f20_WALK_DEBIT_AMOUNT) {
		F20_WALK_DEBIT_AMOUNT = f20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getF21_WALK_CREDIT_NUM() {
		return F21_WALK_CREDIT_NUM;
	}
	public void setF21_WALK_CREDIT_NUM(BigDecimal f21_WALK_CREDIT_NUM) {
		F21_WALK_CREDIT_NUM = f21_WALK_CREDIT_NUM;
	}
	public BigDecimal getF22_WALK_CREDIT_AMOUNT() {
		return F22_WALK_CREDIT_AMOUNT;
	}
	public void setF22_WALK_CREDIT_AMOUNT(BigDecimal f22_WALK_CREDIT_AMOUNT) {
		F22_WALK_CREDIT_AMOUNT = f22_WALK_CREDIT_AMOUNT;
	}
	public String getG1_PROD_NAME() {
		return G1_PROD_NAME;
	}
	public void setG1_PROD_NAME(String g1_PROD_NAME) {
		G1_PROD_NAME = g1_PROD_NAME;
	}
	public String getG2_DESC() {
		return G2_DESC;
	}
	public void setG2_DESC(String g2_DESC) {
		G2_DESC = g2_DESC;
	}
	public String getG3_RISK_ASS() {
		return G3_RISK_ASS;
	}
	public void setG3_RISK_ASS(String g3_RISK_ASS) {
		G3_RISK_ASS = g3_RISK_ASS;
	}
	public String getG4_FACE_TO_FACE() {
		return G4_FACE_TO_FACE;
	}
	public void setG4_FACE_TO_FACE(String g4_FACE_TO_FACE) {
		G4_FACE_TO_FACE = g4_FACE_TO_FACE;
	}
	public String getG5_NON_FACE_TO_FACE() {
		return G5_NON_FACE_TO_FACE;
	}
	public void setG5_NON_FACE_TO_FACE(String g5_NON_FACE_TO_FACE) {
		G5_NON_FACE_TO_FACE = g5_NON_FACE_TO_FACE;
	}
	public String getG6_NON() {
		return G6_NON;
	}
	public void setG6_NON(String g6_NON) {
		G6_NON = g6_NON;
	}
	public BigDecimal getG7_HIGH_DEBIT_NUM() {
		return G7_HIGH_DEBIT_NUM;
	}
	public void setG7_HIGH_DEBIT_NUM(BigDecimal g7_HIGH_DEBIT_NUM) {
		G7_HIGH_DEBIT_NUM = g7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getG8_HIGH_DEBIT_AMOUNT() {
		return G8_HIGH_DEBIT_AMOUNT;
	}
	public void setG8_HIGH_DEBIT_AMOUNT(BigDecimal g8_HIGH_DEBIT_AMOUNT) {
		G8_HIGH_DEBIT_AMOUNT = g8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getG9_HIGH_CREDIT_NUM() {
		return G9_HIGH_CREDIT_NUM;
	}
	public void setG9_HIGH_CREDIT_NUM(BigDecimal g9_HIGH_CREDIT_NUM) {
		G9_HIGH_CREDIT_NUM = g9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getG10_HIGH_CREDIT_AMOUNT() {
		return G10_HIGH_CREDIT_AMOUNT;
	}
	public void setG10_HIGH_CREDIT_AMOUNT(BigDecimal g10_HIGH_CREDIT_AMOUNT) {
		G10_HIGH_CREDIT_AMOUNT = g10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getG11_MEDIUM_DEBIT_NUM() {
		return G11_MEDIUM_DEBIT_NUM;
	}
	public void setG11_MEDIUM_DEBIT_NUM(BigDecimal g11_MEDIUM_DEBIT_NUM) {
		G11_MEDIUM_DEBIT_NUM = g11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getG12_MEDIUM_DEBIT_AMOUNT() {
		return G12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setG12_MEDIUM_DEBIT_AMOUNT(BigDecimal g12_MEDIUM_DEBIT_AMOUNT) {
		G12_MEDIUM_DEBIT_AMOUNT = g12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getG13_MEDIUM_CREDIT_AMOUNT() {
		return G13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setG13_MEDIUM_CREDIT_AMOUNT(BigDecimal g13_MEDIUM_CREDIT_AMOUNT) {
		G13_MEDIUM_CREDIT_AMOUNT = g13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getG14_MEDIUM_CREDIT_AMOUNT() {
		return G14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setG14_MEDIUM_CREDIT_AMOUNT(BigDecimal g14_MEDIUM_CREDIT_AMOUNT) {
		G14_MEDIUM_CREDIT_AMOUNT = g14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getG15_LOW_DEBIT_NUM() {
		return G15_LOW_DEBIT_NUM;
	}
	public void setG15_LOW_DEBIT_NUM(BigDecimal g15_LOW_DEBIT_NUM) {
		G15_LOW_DEBIT_NUM = g15_LOW_DEBIT_NUM;
	}
	public BigDecimal getG16_LOW_DEBIT_AMOUNT() {
		return G16_LOW_DEBIT_AMOUNT;
	}
	public void setG16_LOW_DEBIT_AMOUNT(BigDecimal g16_LOW_DEBIT_AMOUNT) {
		G16_LOW_DEBIT_AMOUNT = g16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getG17_LOW_CREDIT_NUM() {
		return G17_LOW_CREDIT_NUM;
	}
	public void setG17_LOW_CREDIT_NUM(BigDecimal g17_LOW_CREDIT_NUM) {
		G17_LOW_CREDIT_NUM = g17_LOW_CREDIT_NUM;
	}
	public BigDecimal getG18_LOW_CREDIT_AMOUNT() {
		return G18_LOW_CREDIT_AMOUNT;
	}
	public void setG18_LOW_CREDIT_AMOUNT(BigDecimal g18_LOW_CREDIT_AMOUNT) {
		G18_LOW_CREDIT_AMOUNT = g18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getG19_WALK_DEBIT_NUM() {
		return G19_WALK_DEBIT_NUM;
	}
	public void setG19_WALK_DEBIT_NUM(BigDecimal g19_WALK_DEBIT_NUM) {
		G19_WALK_DEBIT_NUM = g19_WALK_DEBIT_NUM;
	}
	public BigDecimal getG20_WALK_DEBIT_AMOUNT() {
		return G20_WALK_DEBIT_AMOUNT;
	}
	public void setG20_WALK_DEBIT_AMOUNT(BigDecimal g20_WALK_DEBIT_AMOUNT) {
		G20_WALK_DEBIT_AMOUNT = g20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getG21_WALK_CREDIT_NUM() {
		return G21_WALK_CREDIT_NUM;
	}
	public void setG21_WALK_CREDIT_NUM(BigDecimal g21_WALK_CREDIT_NUM) {
		G21_WALK_CREDIT_NUM = g21_WALK_CREDIT_NUM;
	}
	public BigDecimal getG22_WALK_CREDIT_AMOUNT() {
		return G22_WALK_CREDIT_AMOUNT;
	}
	public void setG22_WALK_CREDIT_AMOUNT(BigDecimal g22_WALK_CREDIT_AMOUNT) {
		G22_WALK_CREDIT_AMOUNT = g22_WALK_CREDIT_AMOUNT;
	}
	public String getH1_PROD_NAME() {
		return H1_PROD_NAME;
	}
	public void setH1_PROD_NAME(String h1_PROD_NAME) {
		H1_PROD_NAME = h1_PROD_NAME;
	}
	public String getH2_DESC() {
		return H2_DESC;
	}
	public void setH2_DESC(String h2_DESC) {
		H2_DESC = h2_DESC;
	}
	public String getH3_RISK_ASS() {
		return H3_RISK_ASS;
	}
	public void setH3_RISK_ASS(String h3_RISK_ASS) {
		H3_RISK_ASS = h3_RISK_ASS;
	}
	public String getH4_FACE_TO_FACE() {
		return H4_FACE_TO_FACE;
	}
	public void setH4_FACE_TO_FACE(String h4_FACE_TO_FACE) {
		H4_FACE_TO_FACE = h4_FACE_TO_FACE;
	}
	public String getH5_NON_FACE_TO_FACE() {
		return H5_NON_FACE_TO_FACE;
	}
	public void setH5_NON_FACE_TO_FACE(String h5_NON_FACE_TO_FACE) {
		H5_NON_FACE_TO_FACE = h5_NON_FACE_TO_FACE;
	}
	public String getH6_NON() {
		return H6_NON;
	}
	public void setH6_NON(String h6_NON) {
		H6_NON = h6_NON;
	}
	public BigDecimal getH7_HIGH_DEBIT_NUM() {
		return H7_HIGH_DEBIT_NUM;
	}
	public void setH7_HIGH_DEBIT_NUM(BigDecimal h7_HIGH_DEBIT_NUM) {
		H7_HIGH_DEBIT_NUM = h7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getH8_HIGH_DEBIT_AMOUNT() {
		return H8_HIGH_DEBIT_AMOUNT;
	}
	public void setH8_HIGH_DEBIT_AMOUNT(BigDecimal h8_HIGH_DEBIT_AMOUNT) {
		H8_HIGH_DEBIT_AMOUNT = h8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getH9_HIGH_CREDIT_NUM() {
		return H9_HIGH_CREDIT_NUM;
	}
	public void setH9_HIGH_CREDIT_NUM(BigDecimal h9_HIGH_CREDIT_NUM) {
		H9_HIGH_CREDIT_NUM = h9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getH10_HIGH_CREDIT_AMOUNT() {
		return H10_HIGH_CREDIT_AMOUNT;
	}
	public void setH10_HIGH_CREDIT_AMOUNT(BigDecimal h10_HIGH_CREDIT_AMOUNT) {
		H10_HIGH_CREDIT_AMOUNT = h10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getH11_MEDIUM_DEBIT_NUM() {
		return H11_MEDIUM_DEBIT_NUM;
	}
	public void setH11_MEDIUM_DEBIT_NUM(BigDecimal h11_MEDIUM_DEBIT_NUM) {
		H11_MEDIUM_DEBIT_NUM = h11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getH12_MEDIUM_DEBIT_AMOUNT() {
		return H12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setH12_MEDIUM_DEBIT_AMOUNT(BigDecimal h12_MEDIUM_DEBIT_AMOUNT) {
		H12_MEDIUM_DEBIT_AMOUNT = h12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getH13_MEDIUM_CREDIT_AMOUNT() {
		return H13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setH13_MEDIUM_CREDIT_AMOUNT(BigDecimal h13_MEDIUM_CREDIT_AMOUNT) {
		H13_MEDIUM_CREDIT_AMOUNT = h13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getH14_MEDIUM_CREDIT_AMOUNT() {
		return H14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setH14_MEDIUM_CREDIT_AMOUNT(BigDecimal h14_MEDIUM_CREDIT_AMOUNT) {
		H14_MEDIUM_CREDIT_AMOUNT = h14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getH15_LOW_DEBIT_NUM() {
		return H15_LOW_DEBIT_NUM;
	}
	public void setH15_LOW_DEBIT_NUM(BigDecimal h15_LOW_DEBIT_NUM) {
		H15_LOW_DEBIT_NUM = h15_LOW_DEBIT_NUM;
	}
	public BigDecimal getH16_LOW_DEBIT_AMOUNT() {
		return H16_LOW_DEBIT_AMOUNT;
	}
	public void setH16_LOW_DEBIT_AMOUNT(BigDecimal h16_LOW_DEBIT_AMOUNT) {
		H16_LOW_DEBIT_AMOUNT = h16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getH17_LOW_CREDIT_NUM() {
		return H17_LOW_CREDIT_NUM;
	}
	public void setH17_LOW_CREDIT_NUM(BigDecimal h17_LOW_CREDIT_NUM) {
		H17_LOW_CREDIT_NUM = h17_LOW_CREDIT_NUM;
	}
	public BigDecimal getH18_LOW_CREDIT_AMOUNT() {
		return H18_LOW_CREDIT_AMOUNT;
	}
	public void setH18_LOW_CREDIT_AMOUNT(BigDecimal h18_LOW_CREDIT_AMOUNT) {
		H18_LOW_CREDIT_AMOUNT = h18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getH19_WALK_DEBIT_NUM() {
		return H19_WALK_DEBIT_NUM;
	}
	public void setH19_WALK_DEBIT_NUM(BigDecimal h19_WALK_DEBIT_NUM) {
		H19_WALK_DEBIT_NUM = h19_WALK_DEBIT_NUM;
	}
	public BigDecimal getH20_WALK_DEBIT_AMOUNT() {
		return H20_WALK_DEBIT_AMOUNT;
	}
	public void setH20_WALK_DEBIT_AMOUNT(BigDecimal h20_WALK_DEBIT_AMOUNT) {
		H20_WALK_DEBIT_AMOUNT = h20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getH21_WALK_CREDIT_NUM() {
		return H21_WALK_CREDIT_NUM;
	}
	public void setH21_WALK_CREDIT_NUM(BigDecimal h21_WALK_CREDIT_NUM) {
		H21_WALK_CREDIT_NUM = h21_WALK_CREDIT_NUM;
	}
	public BigDecimal getH22_WALK_CREDIT_AMOUNT() {
		return H22_WALK_CREDIT_AMOUNT;
	}
	public void setH22_WALK_CREDIT_AMOUNT(BigDecimal h22_WALK_CREDIT_AMOUNT) {
		H22_WALK_CREDIT_AMOUNT = h22_WALK_CREDIT_AMOUNT;
	}
	public String getI1_PROD_NAME() {
		return I1_PROD_NAME;
	}
	public void setI1_PROD_NAME(String i1_PROD_NAME) {
		I1_PROD_NAME = i1_PROD_NAME;
	}
	public String getI2_DESC() {
		return I2_DESC;
	}
	public void setI2_DESC(String i2_DESC) {
		I2_DESC = i2_DESC;
	}
	public String getI3_RISK_ASS() {
		return I3_RISK_ASS;
	}
	public void setI3_RISK_ASS(String i3_RISK_ASS) {
		I3_RISK_ASS = i3_RISK_ASS;
	}
	public String getI4_FACE_TO_FACE() {
		return I4_FACE_TO_FACE;
	}
	public void setI4_FACE_TO_FACE(String i4_FACE_TO_FACE) {
		I4_FACE_TO_FACE = i4_FACE_TO_FACE;
	}
	public String getI5_NON_FACE_TO_FACE() {
		return I5_NON_FACE_TO_FACE;
	}
	public void setI5_NON_FACE_TO_FACE(String i5_NON_FACE_TO_FACE) {
		I5_NON_FACE_TO_FACE = i5_NON_FACE_TO_FACE;
	}
	public String getI6_NON() {
		return I6_NON;
	}
	public void setI6_NON(String i6_NON) {
		I6_NON = i6_NON;
	}
	public BigDecimal getI7_HIGH_DEBIT_NUM() {
		return I7_HIGH_DEBIT_NUM;
	}
	public void setI7_HIGH_DEBIT_NUM(BigDecimal i7_HIGH_DEBIT_NUM) {
		I7_HIGH_DEBIT_NUM = i7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getI8_HIGH_DEBIT_AMOUNT() {
		return I8_HIGH_DEBIT_AMOUNT;
	}
	public void setI8_HIGH_DEBIT_AMOUNT(BigDecimal i8_HIGH_DEBIT_AMOUNT) {
		I8_HIGH_DEBIT_AMOUNT = i8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getI9_HIGH_CREDIT_NUM() {
		return I9_HIGH_CREDIT_NUM;
	}
	public void setI9_HIGH_CREDIT_NUM(BigDecimal i9_HIGH_CREDIT_NUM) {
		I9_HIGH_CREDIT_NUM = i9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getI10_HIGH_CREDIT_AMOUNT() {
		return I10_HIGH_CREDIT_AMOUNT;
	}
	public void setI10_HIGH_CREDIT_AMOUNT(BigDecimal i10_HIGH_CREDIT_AMOUNT) {
		I10_HIGH_CREDIT_AMOUNT = i10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getI11_MEDIUM_DEBIT_NUM() {
		return I11_MEDIUM_DEBIT_NUM;
	}
	public void setI11_MEDIUM_DEBIT_NUM(BigDecimal i11_MEDIUM_DEBIT_NUM) {
		I11_MEDIUM_DEBIT_NUM = i11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getI12_MEDIUM_DEBIT_AMOUNT() {
		return I12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setI12_MEDIUM_DEBIT_AMOUNT(BigDecimal i12_MEDIUM_DEBIT_AMOUNT) {
		I12_MEDIUM_DEBIT_AMOUNT = i12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getI13_MEDIUM_CREDIT_AMOUNT() {
		return I13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setI13_MEDIUM_CREDIT_AMOUNT(BigDecimal i13_MEDIUM_CREDIT_AMOUNT) {
		I13_MEDIUM_CREDIT_AMOUNT = i13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getI14_MEDIUM_CREDIT_AMOUNT() {
		return I14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setI14_MEDIUM_CREDIT_AMOUNT(BigDecimal i14_MEDIUM_CREDIT_AMOUNT) {
		I14_MEDIUM_CREDIT_AMOUNT = i14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getI15_LOW_DEBIT_NUM() {
		return I15_LOW_DEBIT_NUM;
	}
	public void setI15_LOW_DEBIT_NUM(BigDecimal i15_LOW_DEBIT_NUM) {
		I15_LOW_DEBIT_NUM = i15_LOW_DEBIT_NUM;
	}
	public BigDecimal getI16_LOW_DEBIT_AMOUNT() {
		return I16_LOW_DEBIT_AMOUNT;
	}
	public void setI16_LOW_DEBIT_AMOUNT(BigDecimal i16_LOW_DEBIT_AMOUNT) {
		I16_LOW_DEBIT_AMOUNT = i16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getI17_LOW_CREDIT_NUM() {
		return I17_LOW_CREDIT_NUM;
	}
	public void setI17_LOW_CREDIT_NUM(BigDecimal i17_LOW_CREDIT_NUM) {
		I17_LOW_CREDIT_NUM = i17_LOW_CREDIT_NUM;
	}
	public BigDecimal getI18_LOW_CREDIT_AMOUNT() {
		return I18_LOW_CREDIT_AMOUNT;
	}
	public void setI18_LOW_CREDIT_AMOUNT(BigDecimal i18_LOW_CREDIT_AMOUNT) {
		I18_LOW_CREDIT_AMOUNT = i18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getI19_WALK_DEBIT_NUM() {
		return I19_WALK_DEBIT_NUM;
	}
	public void setI19_WALK_DEBIT_NUM(BigDecimal i19_WALK_DEBIT_NUM) {
		I19_WALK_DEBIT_NUM = i19_WALK_DEBIT_NUM;
	}
	public BigDecimal getI20_WALK_DEBIT_AMOUNT() {
		return I20_WALK_DEBIT_AMOUNT;
	}
	public void setI20_WALK_DEBIT_AMOUNT(BigDecimal i20_WALK_DEBIT_AMOUNT) {
		I20_WALK_DEBIT_AMOUNT = i20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getI21_WALK_CREDIT_NUM() {
		return I21_WALK_CREDIT_NUM;
	}
	public void setI21_WALK_CREDIT_NUM(BigDecimal i21_WALK_CREDIT_NUM) {
		I21_WALK_CREDIT_NUM = i21_WALK_CREDIT_NUM;
	}
	public BigDecimal getI22_WALK_CREDIT_AMOUNT() {
		return I22_WALK_CREDIT_AMOUNT;
	}
	public void setI22_WALK_CREDIT_AMOUNT(BigDecimal i22_WALK_CREDIT_AMOUNT) {
		I22_WALK_CREDIT_AMOUNT = i22_WALK_CREDIT_AMOUNT;
	}
	public String getJ1_PROD_NAME() {
		return J1_PROD_NAME;
	}
	public void setJ1_PROD_NAME(String j1_PROD_NAME) {
		J1_PROD_NAME = j1_PROD_NAME;
	}
	public String getJ2_DESC() {
		return J2_DESC;
	}
	public void setJ2_DESC(String j2_DESC) {
		J2_DESC = j2_DESC;
	}
	public String getJ3_RISK_ASS() {
		return J3_RISK_ASS;
	}
	public void setJ3_RISK_ASS(String j3_RISK_ASS) {
		J3_RISK_ASS = j3_RISK_ASS;
	}
	public String getJ4_FACE_TO_FACE() {
		return J4_FACE_TO_FACE;
	}
	public void setJ4_FACE_TO_FACE(String j4_FACE_TO_FACE) {
		J4_FACE_TO_FACE = j4_FACE_TO_FACE;
	}
	public String getJ5_NON_FACE_TO_FACE() {
		return J5_NON_FACE_TO_FACE;
	}
	public void setJ5_NON_FACE_TO_FACE(String j5_NON_FACE_TO_FACE) {
		J5_NON_FACE_TO_FACE = j5_NON_FACE_TO_FACE;
	}
	public String getJ6_NON() {
		return J6_NON;
	}
	public void setJ6_NON(String j6_NON) {
		J6_NON = j6_NON;
	}
	public BigDecimal getJ7_HIGH_DEBIT_NUM() {
		return J7_HIGH_DEBIT_NUM;
	}
	public void setJ7_HIGH_DEBIT_NUM(BigDecimal j7_HIGH_DEBIT_NUM) {
		J7_HIGH_DEBIT_NUM = j7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getJ8_HIGH_DEBIT_AMOUNT() {
		return J8_HIGH_DEBIT_AMOUNT;
	}
	public void setJ8_HIGH_DEBIT_AMOUNT(BigDecimal j8_HIGH_DEBIT_AMOUNT) {
		J8_HIGH_DEBIT_AMOUNT = j8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getJ9_HIGH_CREDIT_NUM() {
		return J9_HIGH_CREDIT_NUM;
	}
	public void setJ9_HIGH_CREDIT_NUM(BigDecimal j9_HIGH_CREDIT_NUM) {
		J9_HIGH_CREDIT_NUM = j9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getJ10_HIGH_CREDIT_AMOUNT() {
		return J10_HIGH_CREDIT_AMOUNT;
	}
	public void setJ10_HIGH_CREDIT_AMOUNT(BigDecimal j10_HIGH_CREDIT_AMOUNT) {
		J10_HIGH_CREDIT_AMOUNT = j10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getJ11_MEDIUM_DEBIT_NUM() {
		return J11_MEDIUM_DEBIT_NUM;
	}
	public void setJ11_MEDIUM_DEBIT_NUM(BigDecimal j11_MEDIUM_DEBIT_NUM) {
		J11_MEDIUM_DEBIT_NUM = j11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getJ12_MEDIUM_DEBIT_AMOUNT() {
		return J12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setJ12_MEDIUM_DEBIT_AMOUNT(BigDecimal j12_MEDIUM_DEBIT_AMOUNT) {
		J12_MEDIUM_DEBIT_AMOUNT = j12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getJ13_MEDIUM_CREDIT_AMOUNT() {
		return J13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setJ13_MEDIUM_CREDIT_AMOUNT(BigDecimal j13_MEDIUM_CREDIT_AMOUNT) {
		J13_MEDIUM_CREDIT_AMOUNT = j13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getJ14_MEDIUM_CREDIT_AMOUNT() {
		return J14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setJ14_MEDIUM_CREDIT_AMOUNT(BigDecimal j14_MEDIUM_CREDIT_AMOUNT) {
		J14_MEDIUM_CREDIT_AMOUNT = j14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getJ15_LOW_DEBIT_NUM() {
		return J15_LOW_DEBIT_NUM;
	}
	public void setJ15_LOW_DEBIT_NUM(BigDecimal j15_LOW_DEBIT_NUM) {
		J15_LOW_DEBIT_NUM = j15_LOW_DEBIT_NUM;
	}
	public BigDecimal getJ16_LOW_DEBIT_AMOUNT() {
		return J16_LOW_DEBIT_AMOUNT;
	}
	public void setJ16_LOW_DEBIT_AMOUNT(BigDecimal j16_LOW_DEBIT_AMOUNT) {
		J16_LOW_DEBIT_AMOUNT = j16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getJ17_LOW_CREDIT_NUM() {
		return J17_LOW_CREDIT_NUM;
	}
	public void setJ17_LOW_CREDIT_NUM(BigDecimal j17_LOW_CREDIT_NUM) {
		J17_LOW_CREDIT_NUM = j17_LOW_CREDIT_NUM;
	}
	public BigDecimal getJ18_LOW_CREDIT_AMOUNT() {
		return J18_LOW_CREDIT_AMOUNT;
	}
	public void setJ18_LOW_CREDIT_AMOUNT(BigDecimal j18_LOW_CREDIT_AMOUNT) {
		J18_LOW_CREDIT_AMOUNT = j18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getJ19_WALK_DEBIT_NUM() {
		return J19_WALK_DEBIT_NUM;
	}
	public void setJ19_WALK_DEBIT_NUM(BigDecimal j19_WALK_DEBIT_NUM) {
		J19_WALK_DEBIT_NUM = j19_WALK_DEBIT_NUM;
	}
	public BigDecimal getJ20_WALK_DEBIT_AMOUNT() {
		return J20_WALK_DEBIT_AMOUNT;
	}
	public void setJ20_WALK_DEBIT_AMOUNT(BigDecimal j20_WALK_DEBIT_AMOUNT) {
		J20_WALK_DEBIT_AMOUNT = j20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getJ21_WALK_CREDIT_NUM() {
		return J21_WALK_CREDIT_NUM;
	}
	public void setJ21_WALK_CREDIT_NUM(BigDecimal j21_WALK_CREDIT_NUM) {
		J21_WALK_CREDIT_NUM = j21_WALK_CREDIT_NUM;
	}
	public BigDecimal getJ22_WALK_CREDIT_AMOUNT() {
		return J22_WALK_CREDIT_AMOUNT;
	}
	public void setJ22_WALK_CREDIT_AMOUNT(BigDecimal j22_WALK_CREDIT_AMOUNT) {
		J22_WALK_CREDIT_AMOUNT = j22_WALK_CREDIT_AMOUNT;
	}
	public String getK1_PROD_NAME() {
		return K1_PROD_NAME;
	}
	public void setK1_PROD_NAME(String k1_PROD_NAME) {
		K1_PROD_NAME = k1_PROD_NAME;
	}
	public String getK2_DESC() {
		return K2_DESC;
	}
	public void setK2_DESC(String k2_DESC) {
		K2_DESC = k2_DESC;
	}
	public String getK3_RISK_ASS() {
		return K3_RISK_ASS;
	}
	public void setK3_RISK_ASS(String k3_RISK_ASS) {
		K3_RISK_ASS = k3_RISK_ASS;
	}
	public String getK4_FACE_TO_FACE() {
		return K4_FACE_TO_FACE;
	}
	public void setK4_FACE_TO_FACE(String k4_FACE_TO_FACE) {
		K4_FACE_TO_FACE = k4_FACE_TO_FACE;
	}
	public String getK5_NON_FACE_TO_FACE() {
		return K5_NON_FACE_TO_FACE;
	}
	public void setK5_NON_FACE_TO_FACE(String k5_NON_FACE_TO_FACE) {
		K5_NON_FACE_TO_FACE = k5_NON_FACE_TO_FACE;
	}
	public String getK6_NON() {
		return K6_NON;
	}
	public void setK6_NON(String k6_NON) {
		K6_NON = k6_NON;
	}
	public BigDecimal getK7_HIGH_DEBIT_NUM() {
		return K7_HIGH_DEBIT_NUM;
	}
	public void setK7_HIGH_DEBIT_NUM(BigDecimal k7_HIGH_DEBIT_NUM) {
		K7_HIGH_DEBIT_NUM = k7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getK8_HIGH_DEBIT_AMOUNT() {
		return K8_HIGH_DEBIT_AMOUNT;
	}
	public void setK8_HIGH_DEBIT_AMOUNT(BigDecimal k8_HIGH_DEBIT_AMOUNT) {
		K8_HIGH_DEBIT_AMOUNT = k8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getK9_HIGH_CREDIT_NUM() {
		return K9_HIGH_CREDIT_NUM;
	}
	public void setK9_HIGH_CREDIT_NUM(BigDecimal k9_HIGH_CREDIT_NUM) {
		K9_HIGH_CREDIT_NUM = k9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getK10_HIGH_CREDIT_AMOUNT() {
		return K10_HIGH_CREDIT_AMOUNT;
	}
	public void setK10_HIGH_CREDIT_AMOUNT(BigDecimal k10_HIGH_CREDIT_AMOUNT) {
		K10_HIGH_CREDIT_AMOUNT = k10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getK11_MEDIUM_DEBIT_NUM() {
		return K11_MEDIUM_DEBIT_NUM;
	}
	public void setK11_MEDIUM_DEBIT_NUM(BigDecimal k11_MEDIUM_DEBIT_NUM) {
		K11_MEDIUM_DEBIT_NUM = k11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getK12_MEDIUM_DEBIT_AMOUNT() {
		return K12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setK12_MEDIUM_DEBIT_AMOUNT(BigDecimal k12_MEDIUM_DEBIT_AMOUNT) {
		K12_MEDIUM_DEBIT_AMOUNT = k12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getK13_MEDIUM_CREDIT_AMOUNT() {
		return K13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setK13_MEDIUM_CREDIT_AMOUNT(BigDecimal k13_MEDIUM_CREDIT_AMOUNT) {
		K13_MEDIUM_CREDIT_AMOUNT = k13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getK14_MEDIUM_CREDIT_AMOUNT() {
		return K14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setK14_MEDIUM_CREDIT_AMOUNT(BigDecimal k14_MEDIUM_CREDIT_AMOUNT) {
		K14_MEDIUM_CREDIT_AMOUNT = k14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getK15_LOW_DEBIT_NUM() {
		return K15_LOW_DEBIT_NUM;
	}
	public void setK15_LOW_DEBIT_NUM(BigDecimal k15_LOW_DEBIT_NUM) {
		K15_LOW_DEBIT_NUM = k15_LOW_DEBIT_NUM;
	}
	public BigDecimal getK16_LOW_DEBIT_AMOUNT() {
		return K16_LOW_DEBIT_AMOUNT;
	}
	public void setK16_LOW_DEBIT_AMOUNT(BigDecimal k16_LOW_DEBIT_AMOUNT) {
		K16_LOW_DEBIT_AMOUNT = k16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getK17_LOW_CREDIT_NUM() {
		return K17_LOW_CREDIT_NUM;
	}
	public void setK17_LOW_CREDIT_NUM(BigDecimal k17_LOW_CREDIT_NUM) {
		K17_LOW_CREDIT_NUM = k17_LOW_CREDIT_NUM;
	}
	public BigDecimal getK18_LOW_CREDIT_AMOUNT() {
		return K18_LOW_CREDIT_AMOUNT;
	}
	public void setK18_LOW_CREDIT_AMOUNT(BigDecimal k18_LOW_CREDIT_AMOUNT) {
		K18_LOW_CREDIT_AMOUNT = k18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getK19_WALK_DEBIT_NUM() {
		return K19_WALK_DEBIT_NUM;
	}
	public void setK19_WALK_DEBIT_NUM(BigDecimal k19_WALK_DEBIT_NUM) {
		K19_WALK_DEBIT_NUM = k19_WALK_DEBIT_NUM;
	}
	public BigDecimal getK20_WALK_DEBIT_AMOUNT() {
		return K20_WALK_DEBIT_AMOUNT;
	}
	public void setK20_WALK_DEBIT_AMOUNT(BigDecimal k20_WALK_DEBIT_AMOUNT) {
		K20_WALK_DEBIT_AMOUNT = k20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getK21_WALK_CREDIT_NUM() {
		return K21_WALK_CREDIT_NUM;
	}
	public void setK21_WALK_CREDIT_NUM(BigDecimal k21_WALK_CREDIT_NUM) {
		K21_WALK_CREDIT_NUM = k21_WALK_CREDIT_NUM;
	}
	public BigDecimal getK22_WALK_CREDIT_AMOUNT() {
		return K22_WALK_CREDIT_AMOUNT;
	}
	public void setK22_WALK_CREDIT_AMOUNT(BigDecimal k22_WALK_CREDIT_AMOUNT) {
		K22_WALK_CREDIT_AMOUNT = k22_WALK_CREDIT_AMOUNT;
	}
	public String getL1_PROD_NAME() {
		return L1_PROD_NAME;
	}
	public void setL1_PROD_NAME(String l1_PROD_NAME) {
		L1_PROD_NAME = l1_PROD_NAME;
	}
	public String getL2_DESC() {
		return L2_DESC;
	}
	public void setL2_DESC(String l2_DESC) {
		L2_DESC = l2_DESC;
	}
	public String getL3_RISK_ASS() {
		return L3_RISK_ASS;
	}
	public void setL3_RISK_ASS(String l3_RISK_ASS) {
		L3_RISK_ASS = l3_RISK_ASS;
	}
	public String getL4_FACE_TO_FACE() {
		return L4_FACE_TO_FACE;
	}
	public void setL4_FACE_TO_FACE(String l4_FACE_TO_FACE) {
		L4_FACE_TO_FACE = l4_FACE_TO_FACE;
	}
	public String getL5_NON_FACE_TO_FACE() {
		return L5_NON_FACE_TO_FACE;
	}
	public void setL5_NON_FACE_TO_FACE(String l5_NON_FACE_TO_FACE) {
		L5_NON_FACE_TO_FACE = l5_NON_FACE_TO_FACE;
	}
	public String getL6_NON() {
		return L6_NON;
	}
	public void setL6_NON(String l6_NON) {
		L6_NON = l6_NON;
	}
	public BigDecimal getL7_HIGH_DEBIT_NUM() {
		return L7_HIGH_DEBIT_NUM;
	}
	public void setL7_HIGH_DEBIT_NUM(BigDecimal l7_HIGH_DEBIT_NUM) {
		L7_HIGH_DEBIT_NUM = l7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getL8_HIGH_DEBIT_AMOUNT() {
		return L8_HIGH_DEBIT_AMOUNT;
	}
	public void setL8_HIGH_DEBIT_AMOUNT(BigDecimal l8_HIGH_DEBIT_AMOUNT) {
		L8_HIGH_DEBIT_AMOUNT = l8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getL9_HIGH_CREDIT_NUM() {
		return L9_HIGH_CREDIT_NUM;
	}
	public void setL9_HIGH_CREDIT_NUM(BigDecimal l9_HIGH_CREDIT_NUM) {
		L9_HIGH_CREDIT_NUM = l9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getL10_HIGH_CREDIT_AMOUNT() {
		return L10_HIGH_CREDIT_AMOUNT;
	}
	public void setL10_HIGH_CREDIT_AMOUNT(BigDecimal l10_HIGH_CREDIT_AMOUNT) {
		L10_HIGH_CREDIT_AMOUNT = l10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getL11_MEDIUM_DEBIT_NUM() {
		return L11_MEDIUM_DEBIT_NUM;
	}
	public void setL11_MEDIUM_DEBIT_NUM(BigDecimal l11_MEDIUM_DEBIT_NUM) {
		L11_MEDIUM_DEBIT_NUM = l11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getL12_MEDIUM_DEBIT_AMOUNT() {
		return L12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setL12_MEDIUM_DEBIT_AMOUNT(BigDecimal l12_MEDIUM_DEBIT_AMOUNT) {
		L12_MEDIUM_DEBIT_AMOUNT = l12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getL13_MEDIUM_CREDIT_AMOUNT() {
		return L13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setL13_MEDIUM_CREDIT_AMOUNT(BigDecimal l13_MEDIUM_CREDIT_AMOUNT) {
		L13_MEDIUM_CREDIT_AMOUNT = l13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getL14_MEDIUM_CREDIT_AMOUNT() {
		return L14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setL14_MEDIUM_CREDIT_AMOUNT(BigDecimal l14_MEDIUM_CREDIT_AMOUNT) {
		L14_MEDIUM_CREDIT_AMOUNT = l14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getL15_LOW_DEBIT_NUM() {
		return L15_LOW_DEBIT_NUM;
	}
	public void setL15_LOW_DEBIT_NUM(BigDecimal l15_LOW_DEBIT_NUM) {
		L15_LOW_DEBIT_NUM = l15_LOW_DEBIT_NUM;
	}
	public BigDecimal getL16_LOW_DEBIT_AMOUNT() {
		return L16_LOW_DEBIT_AMOUNT;
	}
	public void setL16_LOW_DEBIT_AMOUNT(BigDecimal l16_LOW_DEBIT_AMOUNT) {
		L16_LOW_DEBIT_AMOUNT = l16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getL17_LOW_CREDIT_NUM() {
		return L17_LOW_CREDIT_NUM;
	}
	public void setL17_LOW_CREDIT_NUM(BigDecimal l17_LOW_CREDIT_NUM) {
		L17_LOW_CREDIT_NUM = l17_LOW_CREDIT_NUM;
	}
	public BigDecimal getL18_LOW_CREDIT_AMOUNT() {
		return L18_LOW_CREDIT_AMOUNT;
	}
	public void setL18_LOW_CREDIT_AMOUNT(BigDecimal l18_LOW_CREDIT_AMOUNT) {
		L18_LOW_CREDIT_AMOUNT = l18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getL19_WALK_DEBIT_NUM() {
		return L19_WALK_DEBIT_NUM;
	}
	public void setL19_WALK_DEBIT_NUM(BigDecimal l19_WALK_DEBIT_NUM) {
		L19_WALK_DEBIT_NUM = l19_WALK_DEBIT_NUM;
	}
	public BigDecimal getL20_WALK_DEBIT_AMOUNT() {
		return L20_WALK_DEBIT_AMOUNT;
	}
	public void setL20_WALK_DEBIT_AMOUNT(BigDecimal l20_WALK_DEBIT_AMOUNT) {
		L20_WALK_DEBIT_AMOUNT = l20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getL21_WALK_CREDIT_NUM() {
		return L21_WALK_CREDIT_NUM;
	}
	public void setL21_WALK_CREDIT_NUM(BigDecimal l21_WALK_CREDIT_NUM) {
		L21_WALK_CREDIT_NUM = l21_WALK_CREDIT_NUM;
	}
	public BigDecimal getL22_WALK_CREDIT_AMOUNT() {
		return L22_WALK_CREDIT_AMOUNT;
	}
	public void setL22_WALK_CREDIT_AMOUNT(BigDecimal l22_WALK_CREDIT_AMOUNT) {
		L22_WALK_CREDIT_AMOUNT = l22_WALK_CREDIT_AMOUNT;
	}
	public String getM1_PROD_NAME() {
		return M1_PROD_NAME;
	}
	public void setM1_PROD_NAME(String m1_PROD_NAME) {
		M1_PROD_NAME = m1_PROD_NAME;
	}
	public String getM2_DESC() {
		return M2_DESC;
	}
	public void setM2_DESC(String m2_DESC) {
		M2_DESC = m2_DESC;
	}
	public String getM3_RISK_ASS() {
		return M3_RISK_ASS;
	}
	public void setM3_RISK_ASS(String m3_RISK_ASS) {
		M3_RISK_ASS = m3_RISK_ASS;
	}
	public String getM4_FACE_TO_FACE() {
		return M4_FACE_TO_FACE;
	}
	public void setM4_FACE_TO_FACE(String m4_FACE_TO_FACE) {
		M4_FACE_TO_FACE = m4_FACE_TO_FACE;
	}
	public String getM5_NON_FACE_TO_FACE() {
		return M5_NON_FACE_TO_FACE;
	}
	public void setM5_NON_FACE_TO_FACE(String m5_NON_FACE_TO_FACE) {
		M5_NON_FACE_TO_FACE = m5_NON_FACE_TO_FACE;
	}
	public String getM6_NON() {
		return M6_NON;
	}
	public void setM6_NON(String m6_NON) {
		M6_NON = m6_NON;
	}
	public BigDecimal getM7_HIGH_DEBIT_NUM() {
		return M7_HIGH_DEBIT_NUM;
	}
	public void setM7_HIGH_DEBIT_NUM(BigDecimal m7_HIGH_DEBIT_NUM) {
		M7_HIGH_DEBIT_NUM = m7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getM8_HIGH_DEBIT_AMOUNT() {
		return M8_HIGH_DEBIT_AMOUNT;
	}
	public void setM8_HIGH_DEBIT_AMOUNT(BigDecimal m8_HIGH_DEBIT_AMOUNT) {
		M8_HIGH_DEBIT_AMOUNT = m8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getM9_HIGH_CREDIT_NUM() {
		return M9_HIGH_CREDIT_NUM;
	}
	public void setM9_HIGH_CREDIT_NUM(BigDecimal m9_HIGH_CREDIT_NUM) {
		M9_HIGH_CREDIT_NUM = m9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getM10_HIGH_CREDIT_AMOUNT() {
		return M10_HIGH_CREDIT_AMOUNT;
	}
	public void setM10_HIGH_CREDIT_AMOUNT(BigDecimal m10_HIGH_CREDIT_AMOUNT) {
		M10_HIGH_CREDIT_AMOUNT = m10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getM11_MEDIUM_DEBIT_NUM() {
		return M11_MEDIUM_DEBIT_NUM;
	}
	public void setM11_MEDIUM_DEBIT_NUM(BigDecimal m11_MEDIUM_DEBIT_NUM) {
		M11_MEDIUM_DEBIT_NUM = m11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getM12_MEDIUM_DEBIT_AMOUNT() {
		return M12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setM12_MEDIUM_DEBIT_AMOUNT(BigDecimal m12_MEDIUM_DEBIT_AMOUNT) {
		M12_MEDIUM_DEBIT_AMOUNT = m12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getM13_MEDIUM_CREDIT_AMOUNT() {
		return M13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setM13_MEDIUM_CREDIT_AMOUNT(BigDecimal m13_MEDIUM_CREDIT_AMOUNT) {
		M13_MEDIUM_CREDIT_AMOUNT = m13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getM14_MEDIUM_CREDIT_AMOUNT() {
		return M14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setM14_MEDIUM_CREDIT_AMOUNT(BigDecimal m14_MEDIUM_CREDIT_AMOUNT) {
		M14_MEDIUM_CREDIT_AMOUNT = m14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getM15_LOW_DEBIT_NUM() {
		return M15_LOW_DEBIT_NUM;
	}
	public void setM15_LOW_DEBIT_NUM(BigDecimal m15_LOW_DEBIT_NUM) {
		M15_LOW_DEBIT_NUM = m15_LOW_DEBIT_NUM;
	}
	public BigDecimal getM16_LOW_DEBIT_AMOUNT() {
		return M16_LOW_DEBIT_AMOUNT;
	}
	public void setM16_LOW_DEBIT_AMOUNT(BigDecimal m16_LOW_DEBIT_AMOUNT) {
		M16_LOW_DEBIT_AMOUNT = m16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getM17_LOW_CREDIT_NUM() {
		return M17_LOW_CREDIT_NUM;
	}
	public void setM17_LOW_CREDIT_NUM(BigDecimal m17_LOW_CREDIT_NUM) {
		M17_LOW_CREDIT_NUM = m17_LOW_CREDIT_NUM;
	}
	public BigDecimal getM18_LOW_CREDIT_AMOUNT() {
		return M18_LOW_CREDIT_AMOUNT;
	}
	public void setM18_LOW_CREDIT_AMOUNT(BigDecimal m18_LOW_CREDIT_AMOUNT) {
		M18_LOW_CREDIT_AMOUNT = m18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getM19_WALK_DEBIT_NUM() {
		return M19_WALK_DEBIT_NUM;
	}
	public void setM19_WALK_DEBIT_NUM(BigDecimal m19_WALK_DEBIT_NUM) {
		M19_WALK_DEBIT_NUM = m19_WALK_DEBIT_NUM;
	}
	public BigDecimal getM20_WALK_DEBIT_AMOUNT() {
		return M20_WALK_DEBIT_AMOUNT;
	}
	public void setM20_WALK_DEBIT_AMOUNT(BigDecimal m20_WALK_DEBIT_AMOUNT) {
		M20_WALK_DEBIT_AMOUNT = m20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getM21_WALK_CREDIT_NUM() {
		return M21_WALK_CREDIT_NUM;
	}
	public void setM21_WALK_CREDIT_NUM(BigDecimal m21_WALK_CREDIT_NUM) {
		M21_WALK_CREDIT_NUM = m21_WALK_CREDIT_NUM;
	}
	public BigDecimal getM22_WALK_CREDIT_AMOUNT() {
		return M22_WALK_CREDIT_AMOUNT;
	}
	public void setM22_WALK_CREDIT_AMOUNT(BigDecimal m22_WALK_CREDIT_AMOUNT) {
		M22_WALK_CREDIT_AMOUNT = m22_WALK_CREDIT_AMOUNT;
	}
	public String getN1_PROD_NAME() {
		return N1_PROD_NAME;
	}
	public void setN1_PROD_NAME(String n1_PROD_NAME) {
		N1_PROD_NAME = n1_PROD_NAME;
	}
	public String getN2_DESC() {
		return N2_DESC;
	}
	public void setN2_DESC(String n2_DESC) {
		N2_DESC = n2_DESC;
	}
	public String getN3_RISK_ASS() {
		return N3_RISK_ASS;
	}
	public void setN3_RISK_ASS(String n3_RISK_ASS) {
		N3_RISK_ASS = n3_RISK_ASS;
	}
	public String getN4_FACE_TO_FACE() {
		return N4_FACE_TO_FACE;
	}
	public void setN4_FACE_TO_FACE(String n4_FACE_TO_FACE) {
		N4_FACE_TO_FACE = n4_FACE_TO_FACE;
	}
	public String getN5_NON_FACE_TO_FACE() {
		return N5_NON_FACE_TO_FACE;
	}
	public void setN5_NON_FACE_TO_FACE(String n5_NON_FACE_TO_FACE) {
		N5_NON_FACE_TO_FACE = n5_NON_FACE_TO_FACE;
	}
	public String getN6_NON() {
		return N6_NON;
	}
	public void setN6_NON(String n6_NON) {
		N6_NON = n6_NON;
	}
	public BigDecimal getN7_HIGH_DEBIT_NUM() {
		return N7_HIGH_DEBIT_NUM;
	}
	public void setN7_HIGH_DEBIT_NUM(BigDecimal n7_HIGH_DEBIT_NUM) {
		N7_HIGH_DEBIT_NUM = n7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getN8_HIGH_DEBIT_AMOUNT() {
		return N8_HIGH_DEBIT_AMOUNT;
	}
	public void setN8_HIGH_DEBIT_AMOUNT(BigDecimal n8_HIGH_DEBIT_AMOUNT) {
		N8_HIGH_DEBIT_AMOUNT = n8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getN9_HIGH_CREDIT_NUM() {
		return N9_HIGH_CREDIT_NUM;
	}
	public void setN9_HIGH_CREDIT_NUM(BigDecimal n9_HIGH_CREDIT_NUM) {
		N9_HIGH_CREDIT_NUM = n9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getN10_HIGH_CREDIT_AMOUNT() {
		return N10_HIGH_CREDIT_AMOUNT;
	}
	public void setN10_HIGH_CREDIT_AMOUNT(BigDecimal n10_HIGH_CREDIT_AMOUNT) {
		N10_HIGH_CREDIT_AMOUNT = n10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getN11_MEDIUM_DEBIT_NUM() {
		return N11_MEDIUM_DEBIT_NUM;
	}
	public void setN11_MEDIUM_DEBIT_NUM(BigDecimal n11_MEDIUM_DEBIT_NUM) {
		N11_MEDIUM_DEBIT_NUM = n11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getN12_MEDIUM_DEBIT_AMOUNT() {
		return N12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setN12_MEDIUM_DEBIT_AMOUNT(BigDecimal n12_MEDIUM_DEBIT_AMOUNT) {
		N12_MEDIUM_DEBIT_AMOUNT = n12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getN13_MEDIUM_CREDIT_AMOUNT() {
		return N13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setN13_MEDIUM_CREDIT_AMOUNT(BigDecimal n13_MEDIUM_CREDIT_AMOUNT) {
		N13_MEDIUM_CREDIT_AMOUNT = n13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getN14_MEDIUM_CREDIT_AMOUNT() {
		return N14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setN14_MEDIUM_CREDIT_AMOUNT(BigDecimal n14_MEDIUM_CREDIT_AMOUNT) {
		N14_MEDIUM_CREDIT_AMOUNT = n14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getN15_LOW_DEBIT_NUM() {
		return N15_LOW_DEBIT_NUM;
	}
	public void setN15_LOW_DEBIT_NUM(BigDecimal n15_LOW_DEBIT_NUM) {
		N15_LOW_DEBIT_NUM = n15_LOW_DEBIT_NUM;
	}
	public BigDecimal getN16_LOW_DEBIT_AMOUNT() {
		return N16_LOW_DEBIT_AMOUNT;
	}
	public void setN16_LOW_DEBIT_AMOUNT(BigDecimal n16_LOW_DEBIT_AMOUNT) {
		N16_LOW_DEBIT_AMOUNT = n16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getN17_LOW_CREDIT_NUM() {
		return N17_LOW_CREDIT_NUM;
	}
	public void setN17_LOW_CREDIT_NUM(BigDecimal n17_LOW_CREDIT_NUM) {
		N17_LOW_CREDIT_NUM = n17_LOW_CREDIT_NUM;
	}
	public BigDecimal getN18_LOW_CREDIT_AMOUNT() {
		return N18_LOW_CREDIT_AMOUNT;
	}
	public void setN18_LOW_CREDIT_AMOUNT(BigDecimal n18_LOW_CREDIT_AMOUNT) {
		N18_LOW_CREDIT_AMOUNT = n18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getN19_WALK_DEBIT_NUM() {
		return N19_WALK_DEBIT_NUM;
	}
	public void setN19_WALK_DEBIT_NUM(BigDecimal n19_WALK_DEBIT_NUM) {
		N19_WALK_DEBIT_NUM = n19_WALK_DEBIT_NUM;
	}
	public BigDecimal getN20_WALK_DEBIT_AMOUNT() {
		return N20_WALK_DEBIT_AMOUNT;
	}
	public void setN20_WALK_DEBIT_AMOUNT(BigDecimal n20_WALK_DEBIT_AMOUNT) {
		N20_WALK_DEBIT_AMOUNT = n20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getN21_WALK_CREDIT_NUM() {
		return N21_WALK_CREDIT_NUM;
	}
	public void setN21_WALK_CREDIT_NUM(BigDecimal n21_WALK_CREDIT_NUM) {
		N21_WALK_CREDIT_NUM = n21_WALK_CREDIT_NUM;
	}
	public BigDecimal getN22_WALK_CREDIT_AMOUNT() {
		return N22_WALK_CREDIT_AMOUNT;
	}
	public void setN22_WALK_CREDIT_AMOUNT(BigDecimal n22_WALK_CREDIT_AMOUNT) {
		N22_WALK_CREDIT_AMOUNT = n22_WALK_CREDIT_AMOUNT;
	}
	public String getO1_PROD_NAME() {
		return O1_PROD_NAME;
	}
	public void setO1_PROD_NAME(String o1_PROD_NAME) {
		O1_PROD_NAME = o1_PROD_NAME;
	}
	public String getO2_DESC() {
		return O2_DESC;
	}
	public void setO2_DESC(String o2_DESC) {
		O2_DESC = o2_DESC;
	}
	public String getO3_RISK_ASS() {
		return O3_RISK_ASS;
	}
	public void setO3_RISK_ASS(String o3_RISK_ASS) {
		O3_RISK_ASS = o3_RISK_ASS;
	}
	public String getO4_FACE_TO_FACE() {
		return O4_FACE_TO_FACE;
	}
	public void setO4_FACE_TO_FACE(String o4_FACE_TO_FACE) {
		O4_FACE_TO_FACE = o4_FACE_TO_FACE;
	}
	public String getO5_NON_FACE_TO_FACE() {
		return O5_NON_FACE_TO_FACE;
	}
	public void setO5_NON_FACE_TO_FACE(String o5_NON_FACE_TO_FACE) {
		O5_NON_FACE_TO_FACE = o5_NON_FACE_TO_FACE;
	}
	public String getO6_NON() {
		return O6_NON;
	}
	public void setO6_NON(String o6_NON) {
		O6_NON = o6_NON;
	}
	public BigDecimal getO7_HIGH_DEBIT_NUM() {
		return O7_HIGH_DEBIT_NUM;
	}
	public void setO7_HIGH_DEBIT_NUM(BigDecimal o7_HIGH_DEBIT_NUM) {
		O7_HIGH_DEBIT_NUM = o7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getO8_HIGH_DEBIT_AMOUNT() {
		return O8_HIGH_DEBIT_AMOUNT;
	}
	public void setO8_HIGH_DEBIT_AMOUNT(BigDecimal o8_HIGH_DEBIT_AMOUNT) {
		O8_HIGH_DEBIT_AMOUNT = o8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getO9_HIGH_CREDIT_NUM() {
		return O9_HIGH_CREDIT_NUM;
	}
	public void setO9_HIGH_CREDIT_NUM(BigDecimal o9_HIGH_CREDIT_NUM) {
		O9_HIGH_CREDIT_NUM = o9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getO10_HIGH_CREDIT_AMOUNT() {
		return O10_HIGH_CREDIT_AMOUNT;
	}
	public void setO10_HIGH_CREDIT_AMOUNT(BigDecimal o10_HIGH_CREDIT_AMOUNT) {
		O10_HIGH_CREDIT_AMOUNT = o10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getO11_MEDIUM_DEBIT_NUM() {
		return O11_MEDIUM_DEBIT_NUM;
	}
	public void setO11_MEDIUM_DEBIT_NUM(BigDecimal o11_MEDIUM_DEBIT_NUM) {
		O11_MEDIUM_DEBIT_NUM = o11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getO12_MEDIUM_DEBIT_AMOUNT() {
		return O12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setO12_MEDIUM_DEBIT_AMOUNT(BigDecimal o12_MEDIUM_DEBIT_AMOUNT) {
		O12_MEDIUM_DEBIT_AMOUNT = o12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getO13_MEDIUM_CREDIT_AMOUNT() {
		return O13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setO13_MEDIUM_CREDIT_AMOUNT(BigDecimal o13_MEDIUM_CREDIT_AMOUNT) {
		O13_MEDIUM_CREDIT_AMOUNT = o13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getO14_MEDIUM_CREDIT_AMOUNT() {
		return O14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setO14_MEDIUM_CREDIT_AMOUNT(BigDecimal o14_MEDIUM_CREDIT_AMOUNT) {
		O14_MEDIUM_CREDIT_AMOUNT = o14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getO15_LOW_DEBIT_NUM() {
		return O15_LOW_DEBIT_NUM;
	}
	public void setO15_LOW_DEBIT_NUM(BigDecimal o15_LOW_DEBIT_NUM) {
		O15_LOW_DEBIT_NUM = o15_LOW_DEBIT_NUM;
	}
	public BigDecimal getO16_LOW_DEBIT_AMOUNT() {
		return O16_LOW_DEBIT_AMOUNT;
	}
	public void setO16_LOW_DEBIT_AMOUNT(BigDecimal o16_LOW_DEBIT_AMOUNT) {
		O16_LOW_DEBIT_AMOUNT = o16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getO17_LOW_CREDIT_NUM() {
		return O17_LOW_CREDIT_NUM;
	}
	public void setO17_LOW_CREDIT_NUM(BigDecimal o17_LOW_CREDIT_NUM) {
		O17_LOW_CREDIT_NUM = o17_LOW_CREDIT_NUM;
	}
	public BigDecimal getO18_LOW_CREDIT_AMOUNT() {
		return O18_LOW_CREDIT_AMOUNT;
	}
	public void setO18_LOW_CREDIT_AMOUNT(BigDecimal o18_LOW_CREDIT_AMOUNT) {
		O18_LOW_CREDIT_AMOUNT = o18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getO19_WALK_DEBIT_NUM() {
		return O19_WALK_DEBIT_NUM;
	}
	public void setO19_WALK_DEBIT_NUM(BigDecimal o19_WALK_DEBIT_NUM) {
		O19_WALK_DEBIT_NUM = o19_WALK_DEBIT_NUM;
	}
	public BigDecimal getO20_WALK_DEBIT_AMOUNT() {
		return O20_WALK_DEBIT_AMOUNT;
	}
	public void setO20_WALK_DEBIT_AMOUNT(BigDecimal o20_WALK_DEBIT_AMOUNT) {
		O20_WALK_DEBIT_AMOUNT = o20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getO21_WALK_CREDIT_NUM() {
		return O21_WALK_CREDIT_NUM;
	}
	public void setO21_WALK_CREDIT_NUM(BigDecimal o21_WALK_CREDIT_NUM) {
		O21_WALK_CREDIT_NUM = o21_WALK_CREDIT_NUM;
	}
	public BigDecimal getO22_WALK_CREDIT_AMOUNT() {
		return O22_WALK_CREDIT_AMOUNT;
	}
	public void setO22_WALK_CREDIT_AMOUNT(BigDecimal o22_WALK_CREDIT_AMOUNT) {
		O22_WALK_CREDIT_AMOUNT = o22_WALK_CREDIT_AMOUNT;
	}
	public String getP1_PROD_NAME() {
		return P1_PROD_NAME;
	}
	public void setP1_PROD_NAME(String p1_PROD_NAME) {
		P1_PROD_NAME = p1_PROD_NAME;
	}
	public String getP2_DESC() {
		return P2_DESC;
	}
	public void setP2_DESC(String p2_DESC) {
		P2_DESC = p2_DESC;
	}
	public String getP3_RISK_ASS() {
		return P3_RISK_ASS;
	}
	public void setP3_RISK_ASS(String p3_RISK_ASS) {
		P3_RISK_ASS = p3_RISK_ASS;
	}
	public String getP4_FACE_TO_FACE() {
		return P4_FACE_TO_FACE;
	}
	public void setP4_FACE_TO_FACE(String p4_FACE_TO_FACE) {
		P4_FACE_TO_FACE = p4_FACE_TO_FACE;
	}
	public String getP5_NON_FACE_TO_FACE() {
		return P5_NON_FACE_TO_FACE;
	}
	public void setP5_NON_FACE_TO_FACE(String p5_NON_FACE_TO_FACE) {
		P5_NON_FACE_TO_FACE = p5_NON_FACE_TO_FACE;
	}
	public String getP6_NON() {
		return P6_NON;
	}
	public void setP6_NON(String p6_NON) {
		P6_NON = p6_NON;
	}
	public BigDecimal getP7_HIGH_DEBIT_NUM() {
		return P7_HIGH_DEBIT_NUM;
	}
	public void setP7_HIGH_DEBIT_NUM(BigDecimal p7_HIGH_DEBIT_NUM) {
		P7_HIGH_DEBIT_NUM = p7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getP8_HIGH_DEBIT_AMOUNT() {
		return P8_HIGH_DEBIT_AMOUNT;
	}
	public void setP8_HIGH_DEBIT_AMOUNT(BigDecimal p8_HIGH_DEBIT_AMOUNT) {
		P8_HIGH_DEBIT_AMOUNT = p8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getP9_HIGH_CREDIT_NUM() {
		return P9_HIGH_CREDIT_NUM;
	}
	public void setP9_HIGH_CREDIT_NUM(BigDecimal p9_HIGH_CREDIT_NUM) {
		P9_HIGH_CREDIT_NUM = p9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getP10_HIGH_CREDIT_AMOUNT() {
		return P10_HIGH_CREDIT_AMOUNT;
	}
	public void setP10_HIGH_CREDIT_AMOUNT(BigDecimal p10_HIGH_CREDIT_AMOUNT) {
		P10_HIGH_CREDIT_AMOUNT = p10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getP11_MEDIUM_DEBIT_NUM() {
		return P11_MEDIUM_DEBIT_NUM;
	}
	public void setP11_MEDIUM_DEBIT_NUM(BigDecimal p11_MEDIUM_DEBIT_NUM) {
		P11_MEDIUM_DEBIT_NUM = p11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getP12_MEDIUM_DEBIT_AMOUNT() {
		return P12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setP12_MEDIUM_DEBIT_AMOUNT(BigDecimal p12_MEDIUM_DEBIT_AMOUNT) {
		P12_MEDIUM_DEBIT_AMOUNT = p12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getP13_MEDIUM_CREDIT_AMOUNT() {
		return P13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setP13_MEDIUM_CREDIT_AMOUNT(BigDecimal p13_MEDIUM_CREDIT_AMOUNT) {
		P13_MEDIUM_CREDIT_AMOUNT = p13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getP14_MEDIUM_CREDIT_AMOUNT() {
		return P14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setP14_MEDIUM_CREDIT_AMOUNT(BigDecimal p14_MEDIUM_CREDIT_AMOUNT) {
		P14_MEDIUM_CREDIT_AMOUNT = p14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getP15_LOW_DEBIT_NUM() {
		return P15_LOW_DEBIT_NUM;
	}
	public void setP15_LOW_DEBIT_NUM(BigDecimal p15_LOW_DEBIT_NUM) {
		P15_LOW_DEBIT_NUM = p15_LOW_DEBIT_NUM;
	}
	public BigDecimal getP16_LOW_DEBIT_AMOUNT() {
		return P16_LOW_DEBIT_AMOUNT;
	}
	public void setP16_LOW_DEBIT_AMOUNT(BigDecimal p16_LOW_DEBIT_AMOUNT) {
		P16_LOW_DEBIT_AMOUNT = p16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getP17_LOW_CREDIT_NUM() {
		return P17_LOW_CREDIT_NUM;
	}
	public void setP17_LOW_CREDIT_NUM(BigDecimal p17_LOW_CREDIT_NUM) {
		P17_LOW_CREDIT_NUM = p17_LOW_CREDIT_NUM;
	}
	public BigDecimal getP18_LOW_CREDIT_AMOUNT() {
		return P18_LOW_CREDIT_AMOUNT;
	}
	public void setP18_LOW_CREDIT_AMOUNT(BigDecimal p18_LOW_CREDIT_AMOUNT) {
		P18_LOW_CREDIT_AMOUNT = p18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getP19_WALK_DEBIT_NUM() {
		return P19_WALK_DEBIT_NUM;
	}
	public void setP19_WALK_DEBIT_NUM(BigDecimal p19_WALK_DEBIT_NUM) {
		P19_WALK_DEBIT_NUM = p19_WALK_DEBIT_NUM;
	}
	public BigDecimal getP20_WALK_DEBIT_AMOUNT() {
		return P20_WALK_DEBIT_AMOUNT;
	}
	public void setP20_WALK_DEBIT_AMOUNT(BigDecimal p20_WALK_DEBIT_AMOUNT) {
		P20_WALK_DEBIT_AMOUNT = p20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getP21_WALK_CREDIT_NUM() {
		return P21_WALK_CREDIT_NUM;
	}
	public void setP21_WALK_CREDIT_NUM(BigDecimal p21_WALK_CREDIT_NUM) {
		P21_WALK_CREDIT_NUM = p21_WALK_CREDIT_NUM;
	}
	public BigDecimal getP22_WALK_CREDIT_AMOUNT() {
		return P22_WALK_CREDIT_AMOUNT;
	}
	public void setP22_WALK_CREDIT_AMOUNT(BigDecimal p22_WALK_CREDIT_AMOUNT) {
		P22_WALK_CREDIT_AMOUNT = p22_WALK_CREDIT_AMOUNT;
	}
	public String getQ1_PROD_NAME() {
		return Q1_PROD_NAME;
	}
	public void setQ1_PROD_NAME(String q1_PROD_NAME) {
		Q1_PROD_NAME = q1_PROD_NAME;
	}
	public String getQ2_DESC() {
		return Q2_DESC;
	}
	public void setQ2_DESC(String q2_DESC) {
		Q2_DESC = q2_DESC;
	}
	public String getQ3_RISK_ASS() {
		return Q3_RISK_ASS;
	}
	public void setQ3_RISK_ASS(String q3_RISK_ASS) {
		Q3_RISK_ASS = q3_RISK_ASS;
	}
	public String getQ4_FACE_TO_FACE() {
		return Q4_FACE_TO_FACE;
	}
	public void setQ4_FACE_TO_FACE(String q4_FACE_TO_FACE) {
		Q4_FACE_TO_FACE = q4_FACE_TO_FACE;
	}
	public String getQ5_NON_FACE_TO_FACE() {
		return Q5_NON_FACE_TO_FACE;
	}
	public void setQ5_NON_FACE_TO_FACE(String q5_NON_FACE_TO_FACE) {
		Q5_NON_FACE_TO_FACE = q5_NON_FACE_TO_FACE;
	}
	public String getQ6_NON() {
		return Q6_NON;
	}
	public void setQ6_NON(String q6_NON) {
		Q6_NON = q6_NON;
	}
	public BigDecimal getQ7_HIGH_DEBIT_NUM() {
		return Q7_HIGH_DEBIT_NUM;
	}
	public void setQ7_HIGH_DEBIT_NUM(BigDecimal q7_HIGH_DEBIT_NUM) {
		Q7_HIGH_DEBIT_NUM = q7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getQ8_HIGH_DEBIT_AMOUNT() {
		return Q8_HIGH_DEBIT_AMOUNT;
	}
	public void setQ8_HIGH_DEBIT_AMOUNT(BigDecimal q8_HIGH_DEBIT_AMOUNT) {
		Q8_HIGH_DEBIT_AMOUNT = q8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getQ9_HIGH_CREDIT_NUM() {
		return Q9_HIGH_CREDIT_NUM;
	}
	public void setQ9_HIGH_CREDIT_NUM(BigDecimal q9_HIGH_CREDIT_NUM) {
		Q9_HIGH_CREDIT_NUM = q9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getQ10_HIGH_CREDIT_AMOUNT() {
		return Q10_HIGH_CREDIT_AMOUNT;
	}
	public void setQ10_HIGH_CREDIT_AMOUNT(BigDecimal q10_HIGH_CREDIT_AMOUNT) {
		Q10_HIGH_CREDIT_AMOUNT = q10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getQ11_MEDIUM_DEBIT_NUM() {
		return Q11_MEDIUM_DEBIT_NUM;
	}
	public void setQ11_MEDIUM_DEBIT_NUM(BigDecimal q11_MEDIUM_DEBIT_NUM) {
		Q11_MEDIUM_DEBIT_NUM = q11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getQ12_MEDIUM_DEBIT_AMOUNT() {
		return Q12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setQ12_MEDIUM_DEBIT_AMOUNT(BigDecimal q12_MEDIUM_DEBIT_AMOUNT) {
		Q12_MEDIUM_DEBIT_AMOUNT = q12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getQ13_MEDIUM_CREDIT_AMOUNT() {
		return Q13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setQ13_MEDIUM_CREDIT_AMOUNT(BigDecimal q13_MEDIUM_CREDIT_AMOUNT) {
		Q13_MEDIUM_CREDIT_AMOUNT = q13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getQ14_MEDIUM_CREDIT_AMOUNT() {
		return Q14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setQ14_MEDIUM_CREDIT_AMOUNT(BigDecimal q14_MEDIUM_CREDIT_AMOUNT) {
		Q14_MEDIUM_CREDIT_AMOUNT = q14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getQ15_LOW_DEBIT_NUM() {
		return Q15_LOW_DEBIT_NUM;
	}
	public void setQ15_LOW_DEBIT_NUM(BigDecimal q15_LOW_DEBIT_NUM) {
		Q15_LOW_DEBIT_NUM = q15_LOW_DEBIT_NUM;
	}
	public BigDecimal getQ16_LOW_DEBIT_AMOUNT() {
		return Q16_LOW_DEBIT_AMOUNT;
	}
	public void setQ16_LOW_DEBIT_AMOUNT(BigDecimal q16_LOW_DEBIT_AMOUNT) {
		Q16_LOW_DEBIT_AMOUNT = q16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getQ17_LOW_CREDIT_NUM() {
		return Q17_LOW_CREDIT_NUM;
	}
	public void setQ17_LOW_CREDIT_NUM(BigDecimal q17_LOW_CREDIT_NUM) {
		Q17_LOW_CREDIT_NUM = q17_LOW_CREDIT_NUM;
	}
	public BigDecimal getQ18_LOW_CREDIT_AMOUNT() {
		return Q18_LOW_CREDIT_AMOUNT;
	}
	public void setQ18_LOW_CREDIT_AMOUNT(BigDecimal q18_LOW_CREDIT_AMOUNT) {
		Q18_LOW_CREDIT_AMOUNT = q18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getQ19_WALK_DEBIT_NUM() {
		return Q19_WALK_DEBIT_NUM;
	}
	public void setQ19_WALK_DEBIT_NUM(BigDecimal q19_WALK_DEBIT_NUM) {
		Q19_WALK_DEBIT_NUM = q19_WALK_DEBIT_NUM;
	}
	public BigDecimal getQ20_WALK_DEBIT_AMOUNT() {
		return Q20_WALK_DEBIT_AMOUNT;
	}
	public void setQ20_WALK_DEBIT_AMOUNT(BigDecimal q20_WALK_DEBIT_AMOUNT) {
		Q20_WALK_DEBIT_AMOUNT = q20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getQ21_WALK_CREDIT_NUM() {
		return Q21_WALK_CREDIT_NUM;
	}
	public void setQ21_WALK_CREDIT_NUM(BigDecimal q21_WALK_CREDIT_NUM) {
		Q21_WALK_CREDIT_NUM = q21_WALK_CREDIT_NUM;
	}
	public BigDecimal getQ22_WALK_CREDIT_AMOUNT() {
		return Q22_WALK_CREDIT_AMOUNT;
	}
	public void setQ22_WALK_CREDIT_AMOUNT(BigDecimal q22_WALK_CREDIT_AMOUNT) {
		Q22_WALK_CREDIT_AMOUNT = q22_WALK_CREDIT_AMOUNT;
	}
	public String getR1_PROD_NAME() {
		return R1_PROD_NAME;
	}
	public void setR1_PROD_NAME(String r1_PROD_NAME) {
		R1_PROD_NAME = r1_PROD_NAME;
	}
	public String getR2_DESC() {
		return R2_DESC;
	}
	public void setR2_DESC(String r2_DESC) {
		R2_DESC = r2_DESC;
	}
	public String getR3_RISK_ASS() {
		return R3_RISK_ASS;
	}
	public void setR3_RISK_ASS(String r3_RISK_ASS) {
		R3_RISK_ASS = r3_RISK_ASS;
	}
	public String getR4_FACE_TO_FACE() {
		return R4_FACE_TO_FACE;
	}
	public void setR4_FACE_TO_FACE(String r4_FACE_TO_FACE) {
		R4_FACE_TO_FACE = r4_FACE_TO_FACE;
	}
	public String getR5_NON_FACE_TO_FACE() {
		return R5_NON_FACE_TO_FACE;
	}
	public void setR5_NON_FACE_TO_FACE(String r5_NON_FACE_TO_FACE) {
		R5_NON_FACE_TO_FACE = r5_NON_FACE_TO_FACE;
	}
	public String getR6_NON() {
		return R6_NON;
	}
	public void setR6_NON(String r6_NON) {
		R6_NON = r6_NON;
	}
	public BigDecimal getR7_HIGH_DEBIT_NUM() {
		return R7_HIGH_DEBIT_NUM;
	}
	public void setR7_HIGH_DEBIT_NUM(BigDecimal r7_HIGH_DEBIT_NUM) {
		R7_HIGH_DEBIT_NUM = r7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getR8_HIGH_DEBIT_AMOUNT() {
		return R8_HIGH_DEBIT_AMOUNT;
	}
	public void setR8_HIGH_DEBIT_AMOUNT(BigDecimal r8_HIGH_DEBIT_AMOUNT) {
		R8_HIGH_DEBIT_AMOUNT = r8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getR9_HIGH_CREDIT_NUM() {
		return R9_HIGH_CREDIT_NUM;
	}
	public void setR9_HIGH_CREDIT_NUM(BigDecimal r9_HIGH_CREDIT_NUM) {
		R9_HIGH_CREDIT_NUM = r9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getR10_HIGH_CREDIT_AMOUNT() {
		return R10_HIGH_CREDIT_AMOUNT;
	}
	public void setR10_HIGH_CREDIT_AMOUNT(BigDecimal r10_HIGH_CREDIT_AMOUNT) {
		R10_HIGH_CREDIT_AMOUNT = r10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getR11_MEDIUM_DEBIT_NUM() {
		return R11_MEDIUM_DEBIT_NUM;
	}
	public void setR11_MEDIUM_DEBIT_NUM(BigDecimal r11_MEDIUM_DEBIT_NUM) {
		R11_MEDIUM_DEBIT_NUM = r11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getR12_MEDIUM_DEBIT_AMOUNT() {
		return R12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setR12_MEDIUM_DEBIT_AMOUNT(BigDecimal r12_MEDIUM_DEBIT_AMOUNT) {
		R12_MEDIUM_DEBIT_AMOUNT = r12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getR13_MEDIUM_CREDIT_AMOUNT() {
		return R13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setR13_MEDIUM_CREDIT_AMOUNT(BigDecimal r13_MEDIUM_CREDIT_AMOUNT) {
		R13_MEDIUM_CREDIT_AMOUNT = r13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getR14_MEDIUM_CREDIT_AMOUNT() {
		return R14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setR14_MEDIUM_CREDIT_AMOUNT(BigDecimal r14_MEDIUM_CREDIT_AMOUNT) {
		R14_MEDIUM_CREDIT_AMOUNT = r14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getR15_LOW_DEBIT_NUM() {
		return R15_LOW_DEBIT_NUM;
	}
	public void setR15_LOW_DEBIT_NUM(BigDecimal r15_LOW_DEBIT_NUM) {
		R15_LOW_DEBIT_NUM = r15_LOW_DEBIT_NUM;
	}
	public BigDecimal getR16_LOW_DEBIT_AMOUNT() {
		return R16_LOW_DEBIT_AMOUNT;
	}
	public void setR16_LOW_DEBIT_AMOUNT(BigDecimal r16_LOW_DEBIT_AMOUNT) {
		R16_LOW_DEBIT_AMOUNT = r16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getR17_LOW_CREDIT_NUM() {
		return R17_LOW_CREDIT_NUM;
	}
	public void setR17_LOW_CREDIT_NUM(BigDecimal r17_LOW_CREDIT_NUM) {
		R17_LOW_CREDIT_NUM = r17_LOW_CREDIT_NUM;
	}
	public BigDecimal getR18_LOW_CREDIT_AMOUNT() {
		return R18_LOW_CREDIT_AMOUNT;
	}
	public void setR18_LOW_CREDIT_AMOUNT(BigDecimal r18_LOW_CREDIT_AMOUNT) {
		R18_LOW_CREDIT_AMOUNT = r18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getR19_WALK_DEBIT_NUM() {
		return R19_WALK_DEBIT_NUM;
	}
	public void setR19_WALK_DEBIT_NUM(BigDecimal r19_WALK_DEBIT_NUM) {
		R19_WALK_DEBIT_NUM = r19_WALK_DEBIT_NUM;
	}
	public BigDecimal getR20_WALK_DEBIT_AMOUNT() {
		return R20_WALK_DEBIT_AMOUNT;
	}
	public void setR20_WALK_DEBIT_AMOUNT(BigDecimal r20_WALK_DEBIT_AMOUNT) {
		R20_WALK_DEBIT_AMOUNT = r20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getR21_WALK_CREDIT_NUM() {
		return R21_WALK_CREDIT_NUM;
	}
	public void setR21_WALK_CREDIT_NUM(BigDecimal r21_WALK_CREDIT_NUM) {
		R21_WALK_CREDIT_NUM = r21_WALK_CREDIT_NUM;
	}
	public BigDecimal getR22_WALK_CREDIT_AMOUNT() {
		return R22_WALK_CREDIT_AMOUNT;
	}
	public void setR22_WALK_CREDIT_AMOUNT(BigDecimal r22_WALK_CREDIT_AMOUNT) {
		R22_WALK_CREDIT_AMOUNT = r22_WALK_CREDIT_AMOUNT;
	}
	public String getS1_PROD_NAME() {
		return S1_PROD_NAME;
	}
	public void setS1_PROD_NAME(String s1_PROD_NAME) {
		S1_PROD_NAME = s1_PROD_NAME;
	}
	public String getS2_DESC() {
		return S2_DESC;
	}
	public void setS2_DESC(String s2_DESC) {
		S2_DESC = s2_DESC;
	}
	public String getS3_RISK_ASS() {
		return S3_RISK_ASS;
	}
	public void setS3_RISK_ASS(String s3_RISK_ASS) {
		S3_RISK_ASS = s3_RISK_ASS;
	}
	public String getS4_FACE_TO_FACE() {
		return S4_FACE_TO_FACE;
	}
	public void setS4_FACE_TO_FACE(String s4_FACE_TO_FACE) {
		S4_FACE_TO_FACE = s4_FACE_TO_FACE;
	}
	public String getS5_NON_FACE_TO_FACE() {
		return S5_NON_FACE_TO_FACE;
	}
	public void setS5_NON_FACE_TO_FACE(String s5_NON_FACE_TO_FACE) {
		S5_NON_FACE_TO_FACE = s5_NON_FACE_TO_FACE;
	}
	public String getS6_NON() {
		return S6_NON;
	}
	public void setS6_NON(String s6_NON) {
		S6_NON = s6_NON;
	}
	public BigDecimal getS7_HIGH_DEBIT_NUM() {
		return S7_HIGH_DEBIT_NUM;
	}
	public void setS7_HIGH_DEBIT_NUM(BigDecimal s7_HIGH_DEBIT_NUM) {
		S7_HIGH_DEBIT_NUM = s7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getS8_HIGH_DEBIT_AMOUNT() {
		return S8_HIGH_DEBIT_AMOUNT;
	}
	public void setS8_HIGH_DEBIT_AMOUNT(BigDecimal s8_HIGH_DEBIT_AMOUNT) {
		S8_HIGH_DEBIT_AMOUNT = s8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getS9_HIGH_CREDIT_NUM() {
		return S9_HIGH_CREDIT_NUM;
	}
	public void setS9_HIGH_CREDIT_NUM(BigDecimal s9_HIGH_CREDIT_NUM) {
		S9_HIGH_CREDIT_NUM = s9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getS10_HIGH_CREDIT_AMOUNT() {
		return S10_HIGH_CREDIT_AMOUNT;
	}
	public void setS10_HIGH_CREDIT_AMOUNT(BigDecimal s10_HIGH_CREDIT_AMOUNT) {
		S10_HIGH_CREDIT_AMOUNT = s10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getS11_MEDIUM_DEBIT_NUM() {
		return S11_MEDIUM_DEBIT_NUM;
	}
	public void setS11_MEDIUM_DEBIT_NUM(BigDecimal s11_MEDIUM_DEBIT_NUM) {
		S11_MEDIUM_DEBIT_NUM = s11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getS12_MEDIUM_DEBIT_AMOUNT() {
		return S12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setS12_MEDIUM_DEBIT_AMOUNT(BigDecimal s12_MEDIUM_DEBIT_AMOUNT) {
		S12_MEDIUM_DEBIT_AMOUNT = s12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getS13_MEDIUM_CREDIT_AMOUNT() {
		return S13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setS13_MEDIUM_CREDIT_AMOUNT(BigDecimal s13_MEDIUM_CREDIT_AMOUNT) {
		S13_MEDIUM_CREDIT_AMOUNT = s13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getS14_MEDIUM_CREDIT_AMOUNT() {
		return S14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setS14_MEDIUM_CREDIT_AMOUNT(BigDecimal s14_MEDIUM_CREDIT_AMOUNT) {
		S14_MEDIUM_CREDIT_AMOUNT = s14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getS15_LOW_DEBIT_NUM() {
		return S15_LOW_DEBIT_NUM;
	}
	public void setS15_LOW_DEBIT_NUM(BigDecimal s15_LOW_DEBIT_NUM) {
		S15_LOW_DEBIT_NUM = s15_LOW_DEBIT_NUM;
	}
	public BigDecimal getS16_LOW_DEBIT_AMOUNT() {
		return S16_LOW_DEBIT_AMOUNT;
	}
	public void setS16_LOW_DEBIT_AMOUNT(BigDecimal s16_LOW_DEBIT_AMOUNT) {
		S16_LOW_DEBIT_AMOUNT = s16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getS17_LOW_CREDIT_NUM() {
		return S17_LOW_CREDIT_NUM;
	}
	public void setS17_LOW_CREDIT_NUM(BigDecimal s17_LOW_CREDIT_NUM) {
		S17_LOW_CREDIT_NUM = s17_LOW_CREDIT_NUM;
	}
	public BigDecimal getS18_LOW_CREDIT_AMOUNT() {
		return S18_LOW_CREDIT_AMOUNT;
	}
	public void setS18_LOW_CREDIT_AMOUNT(BigDecimal s18_LOW_CREDIT_AMOUNT) {
		S18_LOW_CREDIT_AMOUNT = s18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getS19_WALK_DEBIT_NUM() {
		return S19_WALK_DEBIT_NUM;
	}
	public void setS19_WALK_DEBIT_NUM(BigDecimal s19_WALK_DEBIT_NUM) {
		S19_WALK_DEBIT_NUM = s19_WALK_DEBIT_NUM;
	}
	public BigDecimal getS20_WALK_DEBIT_AMOUNT() {
		return S20_WALK_DEBIT_AMOUNT;
	}
	public void setS20_WALK_DEBIT_AMOUNT(BigDecimal s20_WALK_DEBIT_AMOUNT) {
		S20_WALK_DEBIT_AMOUNT = s20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getS21_WALK_CREDIT_NUM() {
		return S21_WALK_CREDIT_NUM;
	}
	public void setS21_WALK_CREDIT_NUM(BigDecimal s21_WALK_CREDIT_NUM) {
		S21_WALK_CREDIT_NUM = s21_WALK_CREDIT_NUM;
	}
	public BigDecimal getS22_WALK_CREDIT_AMOUNT() {
		return S22_WALK_CREDIT_AMOUNT;
	}
	public void setS22_WALK_CREDIT_AMOUNT(BigDecimal s22_WALK_CREDIT_AMOUNT) {
		S22_WALK_CREDIT_AMOUNT = s22_WALK_CREDIT_AMOUNT;
	}
	public String getT1_PROD_NAME() {
		return T1_PROD_NAME;
	}
	public void setT1_PROD_NAME(String t1_PROD_NAME) {
		T1_PROD_NAME = t1_PROD_NAME;
	}
	public String getT2_DESC() {
		return T2_DESC;
	}
	public void setT2_DESC(String t2_DESC) {
		T2_DESC = t2_DESC;
	}
	public String getT3_RISK_ASS() {
		return T3_RISK_ASS;
	}
	public void setT3_RISK_ASS(String t3_RISK_ASS) {
		T3_RISK_ASS = t3_RISK_ASS;
	}
	public String getT4_FACE_TO_FACE() {
		return T4_FACE_TO_FACE;
	}
	public void setT4_FACE_TO_FACE(String t4_FACE_TO_FACE) {
		T4_FACE_TO_FACE = t4_FACE_TO_FACE;
	}
	public String getT5_NON_FACE_TO_FACE() {
		return T5_NON_FACE_TO_FACE;
	}
	public void setT5_NON_FACE_TO_FACE(String t5_NON_FACE_TO_FACE) {
		T5_NON_FACE_TO_FACE = t5_NON_FACE_TO_FACE;
	}
	public String getT6_NON() {
		return T6_NON;
	}
	public void setT6_NON(String t6_NON) {
		T6_NON = t6_NON;
	}
	public BigDecimal getT7_HIGH_DEBIT_NUM() {
		return T7_HIGH_DEBIT_NUM;
	}
	public void setT7_HIGH_DEBIT_NUM(BigDecimal t7_HIGH_DEBIT_NUM) {
		T7_HIGH_DEBIT_NUM = t7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getT8_HIGH_DEBIT_AMOUNT() {
		return T8_HIGH_DEBIT_AMOUNT;
	}
	public void setT8_HIGH_DEBIT_AMOUNT(BigDecimal t8_HIGH_DEBIT_AMOUNT) {
		T8_HIGH_DEBIT_AMOUNT = t8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getT9_HIGH_CREDIT_NUM() {
		return T9_HIGH_CREDIT_NUM;
	}
	public void setT9_HIGH_CREDIT_NUM(BigDecimal t9_HIGH_CREDIT_NUM) {
		T9_HIGH_CREDIT_NUM = t9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getT10_HIGH_CREDIT_AMOUNT() {
		return T10_HIGH_CREDIT_AMOUNT;
	}
	public void setT10_HIGH_CREDIT_AMOUNT(BigDecimal t10_HIGH_CREDIT_AMOUNT) {
		T10_HIGH_CREDIT_AMOUNT = t10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getT11_MEDIUM_DEBIT_NUM() {
		return T11_MEDIUM_DEBIT_NUM;
	}
	public void setT11_MEDIUM_DEBIT_NUM(BigDecimal t11_MEDIUM_DEBIT_NUM) {
		T11_MEDIUM_DEBIT_NUM = t11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getT12_MEDIUM_DEBIT_AMOUNT() {
		return T12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setT12_MEDIUM_DEBIT_AMOUNT(BigDecimal t12_MEDIUM_DEBIT_AMOUNT) {
		T12_MEDIUM_DEBIT_AMOUNT = t12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getT13_MEDIUM_CREDIT_AMOUNT() {
		return T13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setT13_MEDIUM_CREDIT_AMOUNT(BigDecimal t13_MEDIUM_CREDIT_AMOUNT) {
		T13_MEDIUM_CREDIT_AMOUNT = t13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getT14_MEDIUM_CREDIT_AMOUNT() {
		return T14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setT14_MEDIUM_CREDIT_AMOUNT(BigDecimal t14_MEDIUM_CREDIT_AMOUNT) {
		T14_MEDIUM_CREDIT_AMOUNT = t14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getT15_LOW_DEBIT_NUM() {
		return T15_LOW_DEBIT_NUM;
	}
	public void setT15_LOW_DEBIT_NUM(BigDecimal t15_LOW_DEBIT_NUM) {
		T15_LOW_DEBIT_NUM = t15_LOW_DEBIT_NUM;
	}
	public BigDecimal getT16_LOW_DEBIT_AMOUNT() {
		return T16_LOW_DEBIT_AMOUNT;
	}
	public void setT16_LOW_DEBIT_AMOUNT(BigDecimal t16_LOW_DEBIT_AMOUNT) {
		T16_LOW_DEBIT_AMOUNT = t16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getT17_LOW_CREDIT_NUM() {
		return T17_LOW_CREDIT_NUM;
	}
	public void setT17_LOW_CREDIT_NUM(BigDecimal t17_LOW_CREDIT_NUM) {
		T17_LOW_CREDIT_NUM = t17_LOW_CREDIT_NUM;
	}
	public BigDecimal getT18_LOW_CREDIT_AMOUNT() {
		return T18_LOW_CREDIT_AMOUNT;
	}
	public void setT18_LOW_CREDIT_AMOUNT(BigDecimal t18_LOW_CREDIT_AMOUNT) {
		T18_LOW_CREDIT_AMOUNT = t18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getT19_WALK_DEBIT_NUM() {
		return T19_WALK_DEBIT_NUM;
	}
	public void setT19_WALK_DEBIT_NUM(BigDecimal t19_WALK_DEBIT_NUM) {
		T19_WALK_DEBIT_NUM = t19_WALK_DEBIT_NUM;
	}
	public BigDecimal getT20_WALK_DEBIT_AMOUNT() {
		return T20_WALK_DEBIT_AMOUNT;
	}
	public void setT20_WALK_DEBIT_AMOUNT(BigDecimal t20_WALK_DEBIT_AMOUNT) {
		T20_WALK_DEBIT_AMOUNT = t20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getT21_WALK_CREDIT_NUM() {
		return T21_WALK_CREDIT_NUM;
	}
	public void setT21_WALK_CREDIT_NUM(BigDecimal t21_WALK_CREDIT_NUM) {
		T21_WALK_CREDIT_NUM = t21_WALK_CREDIT_NUM;
	}
	public BigDecimal getT22_WALK_CREDIT_AMOUNT() {
		return T22_WALK_CREDIT_AMOUNT;
	}
	public void setT22_WALK_CREDIT_AMOUNT(BigDecimal t22_WALK_CREDIT_AMOUNT) {
		T22_WALK_CREDIT_AMOUNT = t22_WALK_CREDIT_AMOUNT;
	}
	public String getU1_PROD_NAME() {
		return U1_PROD_NAME;
	}
	public void setU1_PROD_NAME(String u1_PROD_NAME) {
		U1_PROD_NAME = u1_PROD_NAME;
	}
	public String getU2_DESC() {
		return U2_DESC;
	}
	public void setU2_DESC(String u2_DESC) {
		U2_DESC = u2_DESC;
	}
	public String getU3_RISK_ASS() {
		return U3_RISK_ASS;
	}
	public void setU3_RISK_ASS(String u3_RISK_ASS) {
		U3_RISK_ASS = u3_RISK_ASS;
	}
	public String getU4_FACE_TO_FACE() {
		return U4_FACE_TO_FACE;
	}
	public void setU4_FACE_TO_FACE(String u4_FACE_TO_FACE) {
		U4_FACE_TO_FACE = u4_FACE_TO_FACE;
	}
	public String getU5_NON_FACE_TO_FACE() {
		return U5_NON_FACE_TO_FACE;
	}
	public void setU5_NON_FACE_TO_FACE(String u5_NON_FACE_TO_FACE) {
		U5_NON_FACE_TO_FACE = u5_NON_FACE_TO_FACE;
	}
	public String getU6_NON() {
		return U6_NON;
	}
	public void setU6_NON(String u6_NON) {
		U6_NON = u6_NON;
	}
	public BigDecimal getU7_HIGH_DEBIT_NUM() {
		return U7_HIGH_DEBIT_NUM;
	}
	public void setU7_HIGH_DEBIT_NUM(BigDecimal u7_HIGH_DEBIT_NUM) {
		U7_HIGH_DEBIT_NUM = u7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getU8_HIGH_DEBIT_AMOUNT() {
		return U8_HIGH_DEBIT_AMOUNT;
	}
	public void setU8_HIGH_DEBIT_AMOUNT(BigDecimal u8_HIGH_DEBIT_AMOUNT) {
		U8_HIGH_DEBIT_AMOUNT = u8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getU9_HIGH_CREDIT_NUM() {
		return U9_HIGH_CREDIT_NUM;
	}
	public void setU9_HIGH_CREDIT_NUM(BigDecimal u9_HIGH_CREDIT_NUM) {
		U9_HIGH_CREDIT_NUM = u9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getU10_HIGH_CREDIT_AMOUNT() {
		return U10_HIGH_CREDIT_AMOUNT;
	}
	public void setU10_HIGH_CREDIT_AMOUNT(BigDecimal u10_HIGH_CREDIT_AMOUNT) {
		U10_HIGH_CREDIT_AMOUNT = u10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getU11_MEDIUM_DEBIT_NUM() {
		return U11_MEDIUM_DEBIT_NUM;
	}
	public void setU11_MEDIUM_DEBIT_NUM(BigDecimal u11_MEDIUM_DEBIT_NUM) {
		U11_MEDIUM_DEBIT_NUM = u11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getU12_MEDIUM_DEBIT_AMOUNT() {
		return U12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setU12_MEDIUM_DEBIT_AMOUNT(BigDecimal u12_MEDIUM_DEBIT_AMOUNT) {
		U12_MEDIUM_DEBIT_AMOUNT = u12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getU13_MEDIUM_CREDIT_AMOUNT() {
		return U13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setU13_MEDIUM_CREDIT_AMOUNT(BigDecimal u13_MEDIUM_CREDIT_AMOUNT) {
		U13_MEDIUM_CREDIT_AMOUNT = u13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getU14_MEDIUM_CREDIT_AMOUNT() {
		return U14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setU14_MEDIUM_CREDIT_AMOUNT(BigDecimal u14_MEDIUM_CREDIT_AMOUNT) {
		U14_MEDIUM_CREDIT_AMOUNT = u14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getU15_LOW_DEBIT_NUM() {
		return U15_LOW_DEBIT_NUM;
	}
	public void setU15_LOW_DEBIT_NUM(BigDecimal u15_LOW_DEBIT_NUM) {
		U15_LOW_DEBIT_NUM = u15_LOW_DEBIT_NUM;
	}
	public BigDecimal getU16_LOW_DEBIT_AMOUNT() {
		return U16_LOW_DEBIT_AMOUNT;
	}
	public void setU16_LOW_DEBIT_AMOUNT(BigDecimal u16_LOW_DEBIT_AMOUNT) {
		U16_LOW_DEBIT_AMOUNT = u16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getU17_LOW_CREDIT_NUM() {
		return U17_LOW_CREDIT_NUM;
	}
	public void setU17_LOW_CREDIT_NUM(BigDecimal u17_LOW_CREDIT_NUM) {
		U17_LOW_CREDIT_NUM = u17_LOW_CREDIT_NUM;
	}
	public BigDecimal getU18_LOW_CREDIT_AMOUNT() {
		return U18_LOW_CREDIT_AMOUNT;
	}
	public void setU18_LOW_CREDIT_AMOUNT(BigDecimal u18_LOW_CREDIT_AMOUNT) {
		U18_LOW_CREDIT_AMOUNT = u18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getU19_WALK_DEBIT_NUM() {
		return U19_WALK_DEBIT_NUM;
	}
	public void setU19_WALK_DEBIT_NUM(BigDecimal u19_WALK_DEBIT_NUM) {
		U19_WALK_DEBIT_NUM = u19_WALK_DEBIT_NUM;
	}
	public BigDecimal getU20_WALK_DEBIT_AMOUNT() {
		return U20_WALK_DEBIT_AMOUNT;
	}
	public void setU20_WALK_DEBIT_AMOUNT(BigDecimal u20_WALK_DEBIT_AMOUNT) {
		U20_WALK_DEBIT_AMOUNT = u20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getU21_WALK_CREDIT_NUM() {
		return U21_WALK_CREDIT_NUM;
	}
	public void setU21_WALK_CREDIT_NUM(BigDecimal u21_WALK_CREDIT_NUM) {
		U21_WALK_CREDIT_NUM = u21_WALK_CREDIT_NUM;
	}
	public BigDecimal getU22_WALK_CREDIT_AMOUNT() {
		return U22_WALK_CREDIT_AMOUNT;
	}
	public void setU22_WALK_CREDIT_AMOUNT(BigDecimal u22_WALK_CREDIT_AMOUNT) {
		U22_WALK_CREDIT_AMOUNT = u22_WALK_CREDIT_AMOUNT;
	}
	public String getV1_PROD_NAME() {
		return V1_PROD_NAME;
	}
	public void setV1_PROD_NAME(String v1_PROD_NAME) {
		V1_PROD_NAME = v1_PROD_NAME;
	}
	public String getV2_DESC() {
		return V2_DESC;
	}
	public void setV2_DESC(String v2_DESC) {
		V2_DESC = v2_DESC;
	}
	public String getV3_RISK_ASS() {
		return V3_RISK_ASS;
	}
	public void setV3_RISK_ASS(String v3_RISK_ASS) {
		V3_RISK_ASS = v3_RISK_ASS;
	}
	public String getV4_FACE_TO_FACE() {
		return V4_FACE_TO_FACE;
	}
	public void setV4_FACE_TO_FACE(String v4_FACE_TO_FACE) {
		V4_FACE_TO_FACE = v4_FACE_TO_FACE;
	}
	public String getV5_NON_FACE_TO_FACE() {
		return V5_NON_FACE_TO_FACE;
	}
	public void setV5_NON_FACE_TO_FACE(String v5_NON_FACE_TO_FACE) {
		V5_NON_FACE_TO_FACE = v5_NON_FACE_TO_FACE;
	}
	public String getV6_NON() {
		return V6_NON;
	}
	public void setV6_NON(String v6_NON) {
		V6_NON = v6_NON;
	}
	public BigDecimal getV7_HIGH_DEBIT_NUM() {
		return V7_HIGH_DEBIT_NUM;
	}
	public void setV7_HIGH_DEBIT_NUM(BigDecimal v7_HIGH_DEBIT_NUM) {
		V7_HIGH_DEBIT_NUM = v7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getV8_HIGH_DEBIT_AMOUNT() {
		return V8_HIGH_DEBIT_AMOUNT;
	}
	public void setV8_HIGH_DEBIT_AMOUNT(BigDecimal v8_HIGH_DEBIT_AMOUNT) {
		V8_HIGH_DEBIT_AMOUNT = v8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getV9_HIGH_CREDIT_NUM() {
		return V9_HIGH_CREDIT_NUM;
	}
	public void setV9_HIGH_CREDIT_NUM(BigDecimal v9_HIGH_CREDIT_NUM) {
		V9_HIGH_CREDIT_NUM = v9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getV10_HIGH_CREDIT_AMOUNT() {
		return V10_HIGH_CREDIT_AMOUNT;
	}
	public void setV10_HIGH_CREDIT_AMOUNT(BigDecimal v10_HIGH_CREDIT_AMOUNT) {
		V10_HIGH_CREDIT_AMOUNT = v10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getV11_MEDIUM_DEBIT_NUM() {
		return V11_MEDIUM_DEBIT_NUM;
	}
	public void setV11_MEDIUM_DEBIT_NUM(BigDecimal v11_MEDIUM_DEBIT_NUM) {
		V11_MEDIUM_DEBIT_NUM = v11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getV12_MEDIUM_DEBIT_AMOUNT() {
		return V12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setV12_MEDIUM_DEBIT_AMOUNT(BigDecimal v12_MEDIUM_DEBIT_AMOUNT) {
		V12_MEDIUM_DEBIT_AMOUNT = v12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getV13_MEDIUM_CREDIT_AMOUNT() {
		return V13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setV13_MEDIUM_CREDIT_AMOUNT(BigDecimal v13_MEDIUM_CREDIT_AMOUNT) {
		V13_MEDIUM_CREDIT_AMOUNT = v13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getV14_MEDIUM_CREDIT_AMOUNT() {
		return V14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setV14_MEDIUM_CREDIT_AMOUNT(BigDecimal v14_MEDIUM_CREDIT_AMOUNT) {
		V14_MEDIUM_CREDIT_AMOUNT = v14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getV15_LOW_DEBIT_NUM() {
		return V15_LOW_DEBIT_NUM;
	}
	public void setV15_LOW_DEBIT_NUM(BigDecimal v15_LOW_DEBIT_NUM) {
		V15_LOW_DEBIT_NUM = v15_LOW_DEBIT_NUM;
	}
	public BigDecimal getV16_LOW_DEBIT_AMOUNT() {
		return V16_LOW_DEBIT_AMOUNT;
	}
	public void setV16_LOW_DEBIT_AMOUNT(BigDecimal v16_LOW_DEBIT_AMOUNT) {
		V16_LOW_DEBIT_AMOUNT = v16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getV17_LOW_CREDIT_NUM() {
		return V17_LOW_CREDIT_NUM;
	}
	public void setV17_LOW_CREDIT_NUM(BigDecimal v17_LOW_CREDIT_NUM) {
		V17_LOW_CREDIT_NUM = v17_LOW_CREDIT_NUM;
	}
	public BigDecimal getV18_LOW_CREDIT_AMOUNT() {
		return V18_LOW_CREDIT_AMOUNT;
	}
	public void setV18_LOW_CREDIT_AMOUNT(BigDecimal v18_LOW_CREDIT_AMOUNT) {
		V18_LOW_CREDIT_AMOUNT = v18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getV19_WALK_DEBIT_NUM() {
		return V19_WALK_DEBIT_NUM;
	}
	public void setV19_WALK_DEBIT_NUM(BigDecimal v19_WALK_DEBIT_NUM) {
		V19_WALK_DEBIT_NUM = v19_WALK_DEBIT_NUM;
	}
	public BigDecimal getV20_WALK_DEBIT_AMOUNT() {
		return V20_WALK_DEBIT_AMOUNT;
	}
	public void setV20_WALK_DEBIT_AMOUNT(BigDecimal v20_WALK_DEBIT_AMOUNT) {
		V20_WALK_DEBIT_AMOUNT = v20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getV21_WALK_CREDIT_NUM() {
		return V21_WALK_CREDIT_NUM;
	}
	public void setV21_WALK_CREDIT_NUM(BigDecimal v21_WALK_CREDIT_NUM) {
		V21_WALK_CREDIT_NUM = v21_WALK_CREDIT_NUM;
	}
	public BigDecimal getV22_WALK_CREDIT_AMOUNT() {
		return V22_WALK_CREDIT_AMOUNT;
	}
	public void setV22_WALK_CREDIT_AMOUNT(BigDecimal v22_WALK_CREDIT_AMOUNT) {
		V22_WALK_CREDIT_AMOUNT = v22_WALK_CREDIT_AMOUNT;
	}
	public String getW1_PROD_NAME() {
		return W1_PROD_NAME;
	}
	public void setW1_PROD_NAME(String w1_PROD_NAME) {
		W1_PROD_NAME = w1_PROD_NAME;
	}
	public String getW2_DESC() {
		return W2_DESC;
	}
	public void setW2_DESC(String w2_DESC) {
		W2_DESC = w2_DESC;
	}
	public String getW3_RISK_ASS() {
		return W3_RISK_ASS;
	}
	public void setW3_RISK_ASS(String w3_RISK_ASS) {
		W3_RISK_ASS = w3_RISK_ASS;
	}
	public String getW4_FACE_TO_FACE() {
		return W4_FACE_TO_FACE;
	}
	public void setW4_FACE_TO_FACE(String w4_FACE_TO_FACE) {
		W4_FACE_TO_FACE = w4_FACE_TO_FACE;
	}
	public String getW5_NON_FACE_TO_FACE() {
		return W5_NON_FACE_TO_FACE;
	}
	public void setW5_NON_FACE_TO_FACE(String w5_NON_FACE_TO_FACE) {
		W5_NON_FACE_TO_FACE = w5_NON_FACE_TO_FACE;
	}
	public String getW6_NON() {
		return W6_NON;
	}
	public void setW6_NON(String w6_NON) {
		W6_NON = w6_NON;
	}
	public BigDecimal getW7_HIGH_DEBIT_NUM() {
		return W7_HIGH_DEBIT_NUM;
	}
	public void setW7_HIGH_DEBIT_NUM(BigDecimal w7_HIGH_DEBIT_NUM) {
		W7_HIGH_DEBIT_NUM = w7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getW8_HIGH_DEBIT_AMOUNT() {
		return W8_HIGH_DEBIT_AMOUNT;
	}
	public void setW8_HIGH_DEBIT_AMOUNT(BigDecimal w8_HIGH_DEBIT_AMOUNT) {
		W8_HIGH_DEBIT_AMOUNT = w8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getW9_HIGH_CREDIT_NUM() {
		return W9_HIGH_CREDIT_NUM;
	}
	public void setW9_HIGH_CREDIT_NUM(BigDecimal w9_HIGH_CREDIT_NUM) {
		W9_HIGH_CREDIT_NUM = w9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getW10_HIGH_CREDIT_AMOUNT() {
		return W10_HIGH_CREDIT_AMOUNT;
	}
	public void setW10_HIGH_CREDIT_AMOUNT(BigDecimal w10_HIGH_CREDIT_AMOUNT) {
		W10_HIGH_CREDIT_AMOUNT = w10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getW11_MEDIUM_DEBIT_NUM() {
		return W11_MEDIUM_DEBIT_NUM;
	}
	public void setW11_MEDIUM_DEBIT_NUM(BigDecimal w11_MEDIUM_DEBIT_NUM) {
		W11_MEDIUM_DEBIT_NUM = w11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getW12_MEDIUM_DEBIT_AMOUNT() {
		return W12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setW12_MEDIUM_DEBIT_AMOUNT(BigDecimal w12_MEDIUM_DEBIT_AMOUNT) {
		W12_MEDIUM_DEBIT_AMOUNT = w12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getW13_MEDIUM_CREDIT_AMOUNT() {
		return W13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setW13_MEDIUM_CREDIT_AMOUNT(BigDecimal w13_MEDIUM_CREDIT_AMOUNT) {
		W13_MEDIUM_CREDIT_AMOUNT = w13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getW14_MEDIUM_CREDIT_AMOUNT() {
		return W14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setW14_MEDIUM_CREDIT_AMOUNT(BigDecimal w14_MEDIUM_CREDIT_AMOUNT) {
		W14_MEDIUM_CREDIT_AMOUNT = w14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getW15_LOW_DEBIT_NUM() {
		return W15_LOW_DEBIT_NUM;
	}
	public void setW15_LOW_DEBIT_NUM(BigDecimal w15_LOW_DEBIT_NUM) {
		W15_LOW_DEBIT_NUM = w15_LOW_DEBIT_NUM;
	}
	public BigDecimal getW16_LOW_DEBIT_AMOUNT() {
		return W16_LOW_DEBIT_AMOUNT;
	}
	public void setW16_LOW_DEBIT_AMOUNT(BigDecimal w16_LOW_DEBIT_AMOUNT) {
		W16_LOW_DEBIT_AMOUNT = w16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getW17_LOW_CREDIT_NUM() {
		return W17_LOW_CREDIT_NUM;
	}
	public void setW17_LOW_CREDIT_NUM(BigDecimal w17_LOW_CREDIT_NUM) {
		W17_LOW_CREDIT_NUM = w17_LOW_CREDIT_NUM;
	}
	public BigDecimal getW18_LOW_CREDIT_AMOUNT() {
		return W18_LOW_CREDIT_AMOUNT;
	}
	public void setW18_LOW_CREDIT_AMOUNT(BigDecimal w18_LOW_CREDIT_AMOUNT) {
		W18_LOW_CREDIT_AMOUNT = w18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getW19_WALK_DEBIT_NUM() {
		return W19_WALK_DEBIT_NUM;
	}
	public void setW19_WALK_DEBIT_NUM(BigDecimal w19_WALK_DEBIT_NUM) {
		W19_WALK_DEBIT_NUM = w19_WALK_DEBIT_NUM;
	}
	public BigDecimal getW20_WALK_DEBIT_AMOUNT() {
		return W20_WALK_DEBIT_AMOUNT;
	}
	public void setW20_WALK_DEBIT_AMOUNT(BigDecimal w20_WALK_DEBIT_AMOUNT) {
		W20_WALK_DEBIT_AMOUNT = w20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getW21_WALK_CREDIT_NUM() {
		return W21_WALK_CREDIT_NUM;
	}
	public void setW21_WALK_CREDIT_NUM(BigDecimal w21_WALK_CREDIT_NUM) {
		W21_WALK_CREDIT_NUM = w21_WALK_CREDIT_NUM;
	}
	public BigDecimal getW22_WALK_CREDIT_AMOUNT() {
		return W22_WALK_CREDIT_AMOUNT;
	}
	public void setW22_WALK_CREDIT_AMOUNT(BigDecimal w22_WALK_CREDIT_AMOUNT) {
		W22_WALK_CREDIT_AMOUNT = w22_WALK_CREDIT_AMOUNT;
	}
	public String getX1_PROD_NAME() {
		return X1_PROD_NAME;
	}
	public void setX1_PROD_NAME(String x1_PROD_NAME) {
		X1_PROD_NAME = x1_PROD_NAME;
	}
	public String getX2_DESC() {
		return X2_DESC;
	}
	public void setX2_DESC(String x2_DESC) {
		X2_DESC = x2_DESC;
	}
	public String getX3_RISK_ASS() {
		return X3_RISK_ASS;
	}
	public void setX3_RISK_ASS(String x3_RISK_ASS) {
		X3_RISK_ASS = x3_RISK_ASS;
	}
	public String getX4_FACE_TO_FACE() {
		return X4_FACE_TO_FACE;
	}
	public void setX4_FACE_TO_FACE(String x4_FACE_TO_FACE) {
		X4_FACE_TO_FACE = x4_FACE_TO_FACE;
	}
	public String getX5_NON_FACE_TO_FACE() {
		return X5_NON_FACE_TO_FACE;
	}
	public void setX5_NON_FACE_TO_FACE(String x5_NON_FACE_TO_FACE) {
		X5_NON_FACE_TO_FACE = x5_NON_FACE_TO_FACE;
	}
	public String getX6_NON() {
		return X6_NON;
	}
	public void setX6_NON(String x6_NON) {
		X6_NON = x6_NON;
	}
	public BigDecimal getX7_HIGH_DEBIT_NUM() {
		return X7_HIGH_DEBIT_NUM;
	}
	public void setX7_HIGH_DEBIT_NUM(BigDecimal x7_HIGH_DEBIT_NUM) {
		X7_HIGH_DEBIT_NUM = x7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getX8_HIGH_DEBIT_AMOUNT() {
		return X8_HIGH_DEBIT_AMOUNT;
	}
	public void setX8_HIGH_DEBIT_AMOUNT(BigDecimal x8_HIGH_DEBIT_AMOUNT) {
		X8_HIGH_DEBIT_AMOUNT = x8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getX9_HIGH_CREDIT_NUM() {
		return X9_HIGH_CREDIT_NUM;
	}
	public void setX9_HIGH_CREDIT_NUM(BigDecimal x9_HIGH_CREDIT_NUM) {
		X9_HIGH_CREDIT_NUM = x9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getX10_HIGH_CREDIT_AMOUNT() {
		return X10_HIGH_CREDIT_AMOUNT;
	}
	public void setX10_HIGH_CREDIT_AMOUNT(BigDecimal x10_HIGH_CREDIT_AMOUNT) {
		X10_HIGH_CREDIT_AMOUNT = x10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getX11_MEDIUM_DEBIT_NUM() {
		return X11_MEDIUM_DEBIT_NUM;
	}
	public void setX11_MEDIUM_DEBIT_NUM(BigDecimal x11_MEDIUM_DEBIT_NUM) {
		X11_MEDIUM_DEBIT_NUM = x11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getX12_MEDIUM_DEBIT_AMOUNT() {
		return X12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setX12_MEDIUM_DEBIT_AMOUNT(BigDecimal x12_MEDIUM_DEBIT_AMOUNT) {
		X12_MEDIUM_DEBIT_AMOUNT = x12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getX13_MEDIUM_CREDIT_AMOUNT() {
		return X13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setX13_MEDIUM_CREDIT_AMOUNT(BigDecimal x13_MEDIUM_CREDIT_AMOUNT) {
		X13_MEDIUM_CREDIT_AMOUNT = x13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getX14_MEDIUM_CREDIT_AMOUNT() {
		return X14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setX14_MEDIUM_CREDIT_AMOUNT(BigDecimal x14_MEDIUM_CREDIT_AMOUNT) {
		X14_MEDIUM_CREDIT_AMOUNT = x14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getX15_LOW_DEBIT_NUM() {
		return X15_LOW_DEBIT_NUM;
	}
	public void setX15_LOW_DEBIT_NUM(BigDecimal x15_LOW_DEBIT_NUM) {
		X15_LOW_DEBIT_NUM = x15_LOW_DEBIT_NUM;
	}
	public BigDecimal getX16_LOW_DEBIT_AMOUNT() {
		return X16_LOW_DEBIT_AMOUNT;
	}
	public void setX16_LOW_DEBIT_AMOUNT(BigDecimal x16_LOW_DEBIT_AMOUNT) {
		X16_LOW_DEBIT_AMOUNT = x16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getX17_LOW_CREDIT_NUM() {
		return X17_LOW_CREDIT_NUM;
	}
	public void setX17_LOW_CREDIT_NUM(BigDecimal x17_LOW_CREDIT_NUM) {
		X17_LOW_CREDIT_NUM = x17_LOW_CREDIT_NUM;
	}
	public BigDecimal getX18_LOW_CREDIT_AMOUNT() {
		return X18_LOW_CREDIT_AMOUNT;
	}
	public void setX18_LOW_CREDIT_AMOUNT(BigDecimal x18_LOW_CREDIT_AMOUNT) {
		X18_LOW_CREDIT_AMOUNT = x18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getX19_WALK_DEBIT_NUM() {
		return X19_WALK_DEBIT_NUM;
	}
	public void setX19_WALK_DEBIT_NUM(BigDecimal x19_WALK_DEBIT_NUM) {
		X19_WALK_DEBIT_NUM = x19_WALK_DEBIT_NUM;
	}
	public BigDecimal getX20_WALK_DEBIT_AMOUNT() {
		return X20_WALK_DEBIT_AMOUNT;
	}
	public void setX20_WALK_DEBIT_AMOUNT(BigDecimal x20_WALK_DEBIT_AMOUNT) {
		X20_WALK_DEBIT_AMOUNT = x20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getX21_WALK_CREDIT_NUM() {
		return X21_WALK_CREDIT_NUM;
	}
	public void setX21_WALK_CREDIT_NUM(BigDecimal x21_WALK_CREDIT_NUM) {
		X21_WALK_CREDIT_NUM = x21_WALK_CREDIT_NUM;
	}
	public BigDecimal getX22_WALK_CREDIT_AMOUNT() {
		return X22_WALK_CREDIT_AMOUNT;
	}
	public void setX22_WALK_CREDIT_AMOUNT(BigDecimal x22_WALK_CREDIT_AMOUNT) {
		X22_WALK_CREDIT_AMOUNT = x22_WALK_CREDIT_AMOUNT;
	}
	public String getY1_PROD_NAME() {
		return Y1_PROD_NAME;
	}
	public void setY1_PROD_NAME(String y1_PROD_NAME) {
		Y1_PROD_NAME = y1_PROD_NAME;
	}
	public String getY2_DESC() {
		return Y2_DESC;
	}
	public void setY2_DESC(String y2_DESC) {
		Y2_DESC = y2_DESC;
	}
	public String getY3_RISK_ASS() {
		return Y3_RISK_ASS;
	}
	public void setY3_RISK_ASS(String y3_RISK_ASS) {
		Y3_RISK_ASS = y3_RISK_ASS;
	}
	public String getY4_FACE_TO_FACE() {
		return Y4_FACE_TO_FACE;
	}
	public void setY4_FACE_TO_FACE(String y4_FACE_TO_FACE) {
		Y4_FACE_TO_FACE = y4_FACE_TO_FACE;
	}
	public String getY5_NON_FACE_TO_FACE() {
		return Y5_NON_FACE_TO_FACE;
	}
	public void setY5_NON_FACE_TO_FACE(String y5_NON_FACE_TO_FACE) {
		Y5_NON_FACE_TO_FACE = y5_NON_FACE_TO_FACE;
	}
	public String getY6_NON() {
		return Y6_NON;
	}
	public void setY6_NON(String y6_NON) {
		Y6_NON = y6_NON;
	}
	public BigDecimal getY7_HIGH_DEBIT_NUM() {
		return Y7_HIGH_DEBIT_NUM;
	}
	public void setY7_HIGH_DEBIT_NUM(BigDecimal y7_HIGH_DEBIT_NUM) {
		Y7_HIGH_DEBIT_NUM = y7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getY8_HIGH_DEBIT_AMOUNT() {
		return Y8_HIGH_DEBIT_AMOUNT;
	}
	public void setY8_HIGH_DEBIT_AMOUNT(BigDecimal y8_HIGH_DEBIT_AMOUNT) {
		Y8_HIGH_DEBIT_AMOUNT = y8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getY9_HIGH_CREDIT_NUM() {
		return Y9_HIGH_CREDIT_NUM;
	}
	public void setY9_HIGH_CREDIT_NUM(BigDecimal y9_HIGH_CREDIT_NUM) {
		Y9_HIGH_CREDIT_NUM = y9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getY10_HIGH_CREDIT_AMOUNT() {
		return Y10_HIGH_CREDIT_AMOUNT;
	}
	public void setY10_HIGH_CREDIT_AMOUNT(BigDecimal y10_HIGH_CREDIT_AMOUNT) {
		Y10_HIGH_CREDIT_AMOUNT = y10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getY11_MEDIUM_DEBIT_NUM() {
		return Y11_MEDIUM_DEBIT_NUM;
	}
	public void setY11_MEDIUM_DEBIT_NUM(BigDecimal y11_MEDIUM_DEBIT_NUM) {
		Y11_MEDIUM_DEBIT_NUM = y11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getY12_MEDIUM_DEBIT_AMOUNT() {
		return Y12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setY12_MEDIUM_DEBIT_AMOUNT(BigDecimal y12_MEDIUM_DEBIT_AMOUNT) {
		Y12_MEDIUM_DEBIT_AMOUNT = y12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getY13_MEDIUM_CREDIT_AMOUNT() {
		return Y13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setY13_MEDIUM_CREDIT_AMOUNT(BigDecimal y13_MEDIUM_CREDIT_AMOUNT) {
		Y13_MEDIUM_CREDIT_AMOUNT = y13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getY14_MEDIUM_CREDIT_AMOUNT() {
		return Y14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setY14_MEDIUM_CREDIT_AMOUNT(BigDecimal y14_MEDIUM_CREDIT_AMOUNT) {
		Y14_MEDIUM_CREDIT_AMOUNT = y14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getY15_LOW_DEBIT_NUM() {
		return Y15_LOW_DEBIT_NUM;
	}
	public void setY15_LOW_DEBIT_NUM(BigDecimal y15_LOW_DEBIT_NUM) {
		Y15_LOW_DEBIT_NUM = y15_LOW_DEBIT_NUM;
	}
	public BigDecimal getY16_LOW_DEBIT_AMOUNT() {
		return Y16_LOW_DEBIT_AMOUNT;
	}
	public void setY16_LOW_DEBIT_AMOUNT(BigDecimal y16_LOW_DEBIT_AMOUNT) {
		Y16_LOW_DEBIT_AMOUNT = y16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getY17_LOW_CREDIT_NUM() {
		return Y17_LOW_CREDIT_NUM;
	}
	public void setY17_LOW_CREDIT_NUM(BigDecimal y17_LOW_CREDIT_NUM) {
		Y17_LOW_CREDIT_NUM = y17_LOW_CREDIT_NUM;
	}
	public BigDecimal getY18_LOW_CREDIT_AMOUNT() {
		return Y18_LOW_CREDIT_AMOUNT;
	}
	public void setY18_LOW_CREDIT_AMOUNT(BigDecimal y18_LOW_CREDIT_AMOUNT) {
		Y18_LOW_CREDIT_AMOUNT = y18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getY19_WALK_DEBIT_NUM() {
		return Y19_WALK_DEBIT_NUM;
	}
	public void setY19_WALK_DEBIT_NUM(BigDecimal y19_WALK_DEBIT_NUM) {
		Y19_WALK_DEBIT_NUM = y19_WALK_DEBIT_NUM;
	}
	public BigDecimal getY20_WALK_DEBIT_AMOUNT() {
		return Y20_WALK_DEBIT_AMOUNT;
	}
	public void setY20_WALK_DEBIT_AMOUNT(BigDecimal y20_WALK_DEBIT_AMOUNT) {
		Y20_WALK_DEBIT_AMOUNT = y20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getY21_WALK_CREDIT_NUM() {
		return Y21_WALK_CREDIT_NUM;
	}
	public void setY21_WALK_CREDIT_NUM(BigDecimal y21_WALK_CREDIT_NUM) {
		Y21_WALK_CREDIT_NUM = y21_WALK_CREDIT_NUM;
	}
	public BigDecimal getY22_WALK_CREDIT_AMOUNT() {
		return Y22_WALK_CREDIT_AMOUNT;
	}
	public void setY22_WALK_CREDIT_AMOUNT(BigDecimal y22_WALK_CREDIT_AMOUNT) {
		Y22_WALK_CREDIT_AMOUNT = y22_WALK_CREDIT_AMOUNT;
	}
	public String getZ1_PROD_NAME() {
		return Z1_PROD_NAME;
	}
	public void setZ1_PROD_NAME(String z1_PROD_NAME) {
		Z1_PROD_NAME = z1_PROD_NAME;
	}
	public String getZ2_DESC() {
		return Z2_DESC;
	}
	public void setZ2_DESC(String z2_DESC) {
		Z2_DESC = z2_DESC;
	}
	public String getZ3_RISK_ASS() {
		return Z3_RISK_ASS;
	}
	public void setZ3_RISK_ASS(String z3_RISK_ASS) {
		Z3_RISK_ASS = z3_RISK_ASS;
	}
	public String getZ4_FACE_TO_FACE() {
		return Z4_FACE_TO_FACE;
	}
	public void setZ4_FACE_TO_FACE(String z4_FACE_TO_FACE) {
		Z4_FACE_TO_FACE = z4_FACE_TO_FACE;
	}
	public String getZ5_NON_FACE_TO_FACE() {
		return Z5_NON_FACE_TO_FACE;
	}
	public void setZ5_NON_FACE_TO_FACE(String z5_NON_FACE_TO_FACE) {
		Z5_NON_FACE_TO_FACE = z5_NON_FACE_TO_FACE;
	}
	public String getZ6_NON() {
		return Z6_NON;
	}
	public void setZ6_NON(String z6_NON) {
		Z6_NON = z6_NON;
	}
	public BigDecimal getZ7_HIGH_DEBIT_NUM() {
		return Z7_HIGH_DEBIT_NUM;
	}
	public void setZ7_HIGH_DEBIT_NUM(BigDecimal z7_HIGH_DEBIT_NUM) {
		Z7_HIGH_DEBIT_NUM = z7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getZ8_HIGH_DEBIT_AMOUNT() {
		return Z8_HIGH_DEBIT_AMOUNT;
	}
	public void setZ8_HIGH_DEBIT_AMOUNT(BigDecimal z8_HIGH_DEBIT_AMOUNT) {
		Z8_HIGH_DEBIT_AMOUNT = z8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getZ9_HIGH_CREDIT_NUM() {
		return Z9_HIGH_CREDIT_NUM;
	}
	public void setZ9_HIGH_CREDIT_NUM(BigDecimal z9_HIGH_CREDIT_NUM) {
		Z9_HIGH_CREDIT_NUM = z9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getZ10_HIGH_CREDIT_AMOUNT() {
		return Z10_HIGH_CREDIT_AMOUNT;
	}
	public void setZ10_HIGH_CREDIT_AMOUNT(BigDecimal z10_HIGH_CREDIT_AMOUNT) {
		Z10_HIGH_CREDIT_AMOUNT = z10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getZ11_MEDIUM_DEBIT_NUM() {
		return Z11_MEDIUM_DEBIT_NUM;
	}
	public void setZ11_MEDIUM_DEBIT_NUM(BigDecimal z11_MEDIUM_DEBIT_NUM) {
		Z11_MEDIUM_DEBIT_NUM = z11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getZ12_MEDIUM_DEBIT_AMOUNT() {
		return Z12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setZ12_MEDIUM_DEBIT_AMOUNT(BigDecimal z12_MEDIUM_DEBIT_AMOUNT) {
		Z12_MEDIUM_DEBIT_AMOUNT = z12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getZ13_MEDIUM_CREDIT_AMOUNT() {
		return Z13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setZ13_MEDIUM_CREDIT_AMOUNT(BigDecimal z13_MEDIUM_CREDIT_AMOUNT) {
		Z13_MEDIUM_CREDIT_AMOUNT = z13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getZ14_MEDIUM_CREDIT_AMOUNT() {
		return Z14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setZ14_MEDIUM_CREDIT_AMOUNT(BigDecimal z14_MEDIUM_CREDIT_AMOUNT) {
		Z14_MEDIUM_CREDIT_AMOUNT = z14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getZ15_LOW_DEBIT_NUM() {
		return Z15_LOW_DEBIT_NUM;
	}
	public void setZ15_LOW_DEBIT_NUM(BigDecimal z15_LOW_DEBIT_NUM) {
		Z15_LOW_DEBIT_NUM = z15_LOW_DEBIT_NUM;
	}
	public BigDecimal getZ16_LOW_DEBIT_AMOUNT() {
		return Z16_LOW_DEBIT_AMOUNT;
	}
	public void setZ16_LOW_DEBIT_AMOUNT(BigDecimal z16_LOW_DEBIT_AMOUNT) {
		Z16_LOW_DEBIT_AMOUNT = z16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getZ17_LOW_CREDIT_NUM() {
		return Z17_LOW_CREDIT_NUM;
	}
	public void setZ17_LOW_CREDIT_NUM(BigDecimal z17_LOW_CREDIT_NUM) {
		Z17_LOW_CREDIT_NUM = z17_LOW_CREDIT_NUM;
	}
	public BigDecimal getZ18_LOW_CREDIT_AMOUNT() {
		return Z18_LOW_CREDIT_AMOUNT;
	}
	public void setZ18_LOW_CREDIT_AMOUNT(BigDecimal z18_LOW_CREDIT_AMOUNT) {
		Z18_LOW_CREDIT_AMOUNT = z18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getZ19_WALK_DEBIT_NUM() {
		return Z19_WALK_DEBIT_NUM;
	}
	public void setZ19_WALK_DEBIT_NUM(BigDecimal z19_WALK_DEBIT_NUM) {
		Z19_WALK_DEBIT_NUM = z19_WALK_DEBIT_NUM;
	}
	public BigDecimal getZ20_WALK_DEBIT_AMOUNT() {
		return Z20_WALK_DEBIT_AMOUNT;
	}
	public void setZ20_WALK_DEBIT_AMOUNT(BigDecimal z20_WALK_DEBIT_AMOUNT) {
		Z20_WALK_DEBIT_AMOUNT = z20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getZ21_WALK_CREDIT_NUM() {
		return Z21_WALK_CREDIT_NUM;
	}
	public void setZ21_WALK_CREDIT_NUM(BigDecimal z21_WALK_CREDIT_NUM) {
		Z21_WALK_CREDIT_NUM = z21_WALK_CREDIT_NUM;
	}
	public BigDecimal getZ22_WALK_CREDIT_AMOUNT() {
		return Z22_WALK_CREDIT_AMOUNT;
	}
	public void setZ22_WALK_CREDIT_AMOUNT(BigDecimal z22_WALK_CREDIT_AMOUNT) {
		Z22_WALK_CREDIT_AMOUNT = z22_WALK_CREDIT_AMOUNT;
	}
	public String getAA1_PROD_NAME() {
		return AA1_PROD_NAME;
	}
	public void setAA1_PROD_NAME(String aA1_PROD_NAME) {
		AA1_PROD_NAME = aA1_PROD_NAME;
	}
	public String getAA2_DESC() {
		return AA2_DESC;
	}
	public void setAA2_DESC(String aA2_DESC) {
		AA2_DESC = aA2_DESC;
	}
	public String getAA3_RISK_ASS() {
		return AA3_RISK_ASS;
	}
	public void setAA3_RISK_ASS(String aA3_RISK_ASS) {
		AA3_RISK_ASS = aA3_RISK_ASS;
	}
	public String getAA4_FACE_TO_FACE() {
		return AA4_FACE_TO_FACE;
	}
	public void setAA4_FACE_TO_FACE(String aA4_FACE_TO_FACE) {
		AA4_FACE_TO_FACE = aA4_FACE_TO_FACE;
	}
	public String getAA5_NON_FACE_TO_FACE() {
		return AA5_NON_FACE_TO_FACE;
	}
	public void setAA5_NON_FACE_TO_FACE(String aA5_NON_FACE_TO_FACE) {
		AA5_NON_FACE_TO_FACE = aA5_NON_FACE_TO_FACE;
	}
	public String getAA6_NON() {
		return AA6_NON;
	}
	public void setAA6_NON(String aA6_NON) {
		AA6_NON = aA6_NON;
	}
	public BigDecimal getAA7_HIGH_DEBIT_NUM() {
		return AA7_HIGH_DEBIT_NUM;
	}
	public void setAA7_HIGH_DEBIT_NUM(BigDecimal aA7_HIGH_DEBIT_NUM) {
		AA7_HIGH_DEBIT_NUM = aA7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAA8_HIGH_DEBIT_AMOUNT() {
		return AA8_HIGH_DEBIT_AMOUNT;
	}
	public void setAA8_HIGH_DEBIT_AMOUNT(BigDecimal aA8_HIGH_DEBIT_AMOUNT) {
		AA8_HIGH_DEBIT_AMOUNT = aA8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAA9_HIGH_CREDIT_NUM() {
		return AA9_HIGH_CREDIT_NUM;
	}
	public void setAA9_HIGH_CREDIT_NUM(BigDecimal aA9_HIGH_CREDIT_NUM) {
		AA9_HIGH_CREDIT_NUM = aA9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAA10_HIGH_CREDIT_AMOUNT() {
		return AA10_HIGH_CREDIT_AMOUNT;
	}
	public void setAA10_HIGH_CREDIT_AMOUNT(BigDecimal aA10_HIGH_CREDIT_AMOUNT) {
		AA10_HIGH_CREDIT_AMOUNT = aA10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAA11_MEDIUM_DEBIT_NUM() {
		return AA11_MEDIUM_DEBIT_NUM;
	}
	public void setAA11_MEDIUM_DEBIT_NUM(BigDecimal aA11_MEDIUM_DEBIT_NUM) {
		AA11_MEDIUM_DEBIT_NUM = aA11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAA12_MEDIUM_DEBIT_AMOUNT() {
		return AA12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAA12_MEDIUM_DEBIT_AMOUNT(BigDecimal aA12_MEDIUM_DEBIT_AMOUNT) {
		AA12_MEDIUM_DEBIT_AMOUNT = aA12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAA13_MEDIUM_CREDIT_AMOUNT() {
		return AA13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAA13_MEDIUM_CREDIT_AMOUNT(BigDecimal aA13_MEDIUM_CREDIT_AMOUNT) {
		AA13_MEDIUM_CREDIT_AMOUNT = aA13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAA14_MEDIUM_CREDIT_AMOUNT() {
		return AA14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAA14_MEDIUM_CREDIT_AMOUNT(BigDecimal aA14_MEDIUM_CREDIT_AMOUNT) {
		AA14_MEDIUM_CREDIT_AMOUNT = aA14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAA15_LOW_DEBIT_NUM() {
		return AA15_LOW_DEBIT_NUM;
	}
	public void setAA15_LOW_DEBIT_NUM(BigDecimal aA15_LOW_DEBIT_NUM) {
		AA15_LOW_DEBIT_NUM = aA15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAA16_LOW_DEBIT_AMOUNT() {
		return AA16_LOW_DEBIT_AMOUNT;
	}
	public void setAA16_LOW_DEBIT_AMOUNT(BigDecimal aA16_LOW_DEBIT_AMOUNT) {
		AA16_LOW_DEBIT_AMOUNT = aA16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAA17_LOW_CREDIT_NUM() {
		return AA17_LOW_CREDIT_NUM;
	}
	public void setAA17_LOW_CREDIT_NUM(BigDecimal aA17_LOW_CREDIT_NUM) {
		AA17_LOW_CREDIT_NUM = aA17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAA18_LOW_CREDIT_AMOUNT() {
		return AA18_LOW_CREDIT_AMOUNT;
	}
	public void setAA18_LOW_CREDIT_AMOUNT(BigDecimal aA18_LOW_CREDIT_AMOUNT) {
		AA18_LOW_CREDIT_AMOUNT = aA18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAA19_WALK_DEBIT_NUM() {
		return AA19_WALK_DEBIT_NUM;
	}
	public void setAA19_WALK_DEBIT_NUM(BigDecimal aA19_WALK_DEBIT_NUM) {
		AA19_WALK_DEBIT_NUM = aA19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAA20_WALK_DEBIT_AMOUNT() {
		return AA20_WALK_DEBIT_AMOUNT;
	}
	public void setAA20_WALK_DEBIT_AMOUNT(BigDecimal aA20_WALK_DEBIT_AMOUNT) {
		AA20_WALK_DEBIT_AMOUNT = aA20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAA21_WALK_CREDIT_NUM() {
		return AA21_WALK_CREDIT_NUM;
	}
	public void setAA21_WALK_CREDIT_NUM(BigDecimal aA21_WALK_CREDIT_NUM) {
		AA21_WALK_CREDIT_NUM = aA21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAA22_WALK_CREDIT_AMOUNT() {
		return AA22_WALK_CREDIT_AMOUNT;
	}
	public void setAA22_WALK_CREDIT_AMOUNT(BigDecimal aA22_WALK_CREDIT_AMOUNT) {
		AA22_WALK_CREDIT_AMOUNT = aA22_WALK_CREDIT_AMOUNT;
	}
	public String getAB1_PROD_NAME() {
		return AB1_PROD_NAME;
	}
	public void setAB1_PROD_NAME(String aB1_PROD_NAME) {
		AB1_PROD_NAME = aB1_PROD_NAME;
	}
	public String getAB2_DESC() {
		return AB2_DESC;
	}
	public void setAB2_DESC(String aB2_DESC) {
		AB2_DESC = aB2_DESC;
	}
	public String getAB3_RISK_ASS() {
		return AB3_RISK_ASS;
	}
	public void setAB3_RISK_ASS(String aB3_RISK_ASS) {
		AB3_RISK_ASS = aB3_RISK_ASS;
	}
	public String getAB4_FACE_TO_FACE() {
		return AB4_FACE_TO_FACE;
	}
	public void setAB4_FACE_TO_FACE(String aB4_FACE_TO_FACE) {
		AB4_FACE_TO_FACE = aB4_FACE_TO_FACE;
	}
	public String getAB5_NON_FACE_TO_FACE() {
		return AB5_NON_FACE_TO_FACE;
	}
	public void setAB5_NON_FACE_TO_FACE(String aB5_NON_FACE_TO_FACE) {
		AB5_NON_FACE_TO_FACE = aB5_NON_FACE_TO_FACE;
	}
	public String getAB6_NON() {
		return AB6_NON;
	}
	public void setAB6_NON(String aB6_NON) {
		AB6_NON = aB6_NON;
	}
	public BigDecimal getAB7_HIGH_DEBIT_NUM() {
		return AB7_HIGH_DEBIT_NUM;
	}
	public void setAB7_HIGH_DEBIT_NUM(BigDecimal aB7_HIGH_DEBIT_NUM) {
		AB7_HIGH_DEBIT_NUM = aB7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAB8_HIGH_DEBIT_AMOUNT() {
		return AB8_HIGH_DEBIT_AMOUNT;
	}
	public void setAB8_HIGH_DEBIT_AMOUNT(BigDecimal aB8_HIGH_DEBIT_AMOUNT) {
		AB8_HIGH_DEBIT_AMOUNT = aB8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAB9_HIGH_CREDIT_NUM() {
		return AB9_HIGH_CREDIT_NUM;
	}
	public void setAB9_HIGH_CREDIT_NUM(BigDecimal aB9_HIGH_CREDIT_NUM) {
		AB9_HIGH_CREDIT_NUM = aB9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAB10_HIGH_CREDIT_AMOUNT() {
		return AB10_HIGH_CREDIT_AMOUNT;
	}
	public void setAB10_HIGH_CREDIT_AMOUNT(BigDecimal aB10_HIGH_CREDIT_AMOUNT) {
		AB10_HIGH_CREDIT_AMOUNT = aB10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAB11_MEDIUM_DEBIT_NUM() {
		return AB11_MEDIUM_DEBIT_NUM;
	}
	public void setAB11_MEDIUM_DEBIT_NUM(BigDecimal aB11_MEDIUM_DEBIT_NUM) {
		AB11_MEDIUM_DEBIT_NUM = aB11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAB12_MEDIUM_DEBIT_AMOUNT() {
		return AB12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAB12_MEDIUM_DEBIT_AMOUNT(BigDecimal aB12_MEDIUM_DEBIT_AMOUNT) {
		AB12_MEDIUM_DEBIT_AMOUNT = aB12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAB13_MEDIUM_CREDIT_AMOUNT() {
		return AB13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAB13_MEDIUM_CREDIT_AMOUNT(BigDecimal aB13_MEDIUM_CREDIT_AMOUNT) {
		AB13_MEDIUM_CREDIT_AMOUNT = aB13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAB14_MEDIUM_CREDIT_AMOUNT() {
		return AB14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAB14_MEDIUM_CREDIT_AMOUNT(BigDecimal aB14_MEDIUM_CREDIT_AMOUNT) {
		AB14_MEDIUM_CREDIT_AMOUNT = aB14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAB15_LOW_DEBIT_NUM() {
		return AB15_LOW_DEBIT_NUM;
	}
	public void setAB15_LOW_DEBIT_NUM(BigDecimal aB15_LOW_DEBIT_NUM) {
		AB15_LOW_DEBIT_NUM = aB15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAB16_LOW_DEBIT_AMOUNT() {
		return AB16_LOW_DEBIT_AMOUNT;
	}
	public void setAB16_LOW_DEBIT_AMOUNT(BigDecimal aB16_LOW_DEBIT_AMOUNT) {
		AB16_LOW_DEBIT_AMOUNT = aB16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAB17_LOW_CREDIT_NUM() {
		return AB17_LOW_CREDIT_NUM;
	}
	public void setAB17_LOW_CREDIT_NUM(BigDecimal aB17_LOW_CREDIT_NUM) {
		AB17_LOW_CREDIT_NUM = aB17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAB18_LOW_CREDIT_AMOUNT() {
		return AB18_LOW_CREDIT_AMOUNT;
	}
	public void setAB18_LOW_CREDIT_AMOUNT(BigDecimal aB18_LOW_CREDIT_AMOUNT) {
		AB18_LOW_CREDIT_AMOUNT = aB18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAB19_WALK_DEBIT_NUM() {
		return AB19_WALK_DEBIT_NUM;
	}
	public void setAB19_WALK_DEBIT_NUM(BigDecimal aB19_WALK_DEBIT_NUM) {
		AB19_WALK_DEBIT_NUM = aB19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAB20_WALK_DEBIT_AMOUNT() {
		return AB20_WALK_DEBIT_AMOUNT;
	}
	public void setAB20_WALK_DEBIT_AMOUNT(BigDecimal aB20_WALK_DEBIT_AMOUNT) {
		AB20_WALK_DEBIT_AMOUNT = aB20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAB21_WALK_CREDIT_NUM() {
		return AB21_WALK_CREDIT_NUM;
	}
	public void setAB21_WALK_CREDIT_NUM(BigDecimal aB21_WALK_CREDIT_NUM) {
		AB21_WALK_CREDIT_NUM = aB21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAB22_WALK_CREDIT_AMOUNT() {
		return AB22_WALK_CREDIT_AMOUNT;
	}
	public void setAB22_WALK_CREDIT_AMOUNT(BigDecimal aB22_WALK_CREDIT_AMOUNT) {
		AB22_WALK_CREDIT_AMOUNT = aB22_WALK_CREDIT_AMOUNT;
	}
	public String getAC1_PROD_NAME() {
		return AC1_PROD_NAME;
	}
	public void setAC1_PROD_NAME(String aC1_PROD_NAME) {
		AC1_PROD_NAME = aC1_PROD_NAME;
	}
	public String getAC2_DESC() {
		return AC2_DESC;
	}
	public void setAC2_DESC(String aC2_DESC) {
		AC2_DESC = aC2_DESC;
	}
	public String getAC3_RISK_ASS() {
		return AC3_RISK_ASS;
	}
	public void setAC3_RISK_ASS(String aC3_RISK_ASS) {
		AC3_RISK_ASS = aC3_RISK_ASS;
	}
	public String getAC4_FACE_TO_FACE() {
		return AC4_FACE_TO_FACE;
	}
	public void setAC4_FACE_TO_FACE(String aC4_FACE_TO_FACE) {
		AC4_FACE_TO_FACE = aC4_FACE_TO_FACE;
	}
	public String getAC5_NON_FACE_TO_FACE() {
		return AC5_NON_FACE_TO_FACE;
	}
	public void setAC5_NON_FACE_TO_FACE(String aC5_NON_FACE_TO_FACE) {
		AC5_NON_FACE_TO_FACE = aC5_NON_FACE_TO_FACE;
	}
	public String getAC6_NON() {
		return AC6_NON;
	}
	public void setAC6_NON(String aC6_NON) {
		AC6_NON = aC6_NON;
	}
	public BigDecimal getAC7_HIGH_DEBIT_NUM() {
		return AC7_HIGH_DEBIT_NUM;
	}
	public void setAC7_HIGH_DEBIT_NUM(BigDecimal aC7_HIGH_DEBIT_NUM) {
		AC7_HIGH_DEBIT_NUM = aC7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAC8_HIGH_DEBIT_AMOUNT() {
		return AC8_HIGH_DEBIT_AMOUNT;
	}
	public void setAC8_HIGH_DEBIT_AMOUNT(BigDecimal aC8_HIGH_DEBIT_AMOUNT) {
		AC8_HIGH_DEBIT_AMOUNT = aC8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAC9_HIGH_CREDIT_NUM() {
		return AC9_HIGH_CREDIT_NUM;
	}
	public void setAC9_HIGH_CREDIT_NUM(BigDecimal aC9_HIGH_CREDIT_NUM) {
		AC9_HIGH_CREDIT_NUM = aC9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAC10_HIGH_CREDIT_AMOUNT() {
		return AC10_HIGH_CREDIT_AMOUNT;
	}
	public void setAC10_HIGH_CREDIT_AMOUNT(BigDecimal aC10_HIGH_CREDIT_AMOUNT) {
		AC10_HIGH_CREDIT_AMOUNT = aC10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAC11_MEDIUM_DEBIT_NUM() {
		return AC11_MEDIUM_DEBIT_NUM;
	}
	public void setAC11_MEDIUM_DEBIT_NUM(BigDecimal aC11_MEDIUM_DEBIT_NUM) {
		AC11_MEDIUM_DEBIT_NUM = aC11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAC12_MEDIUM_DEBIT_AMOUNT() {
		return AC12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAC12_MEDIUM_DEBIT_AMOUNT(BigDecimal aC12_MEDIUM_DEBIT_AMOUNT) {
		AC12_MEDIUM_DEBIT_AMOUNT = aC12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAC13_MEDIUM_CREDIT_AMOUNT() {
		return AC13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAC13_MEDIUM_CREDIT_AMOUNT(BigDecimal aC13_MEDIUM_CREDIT_AMOUNT) {
		AC13_MEDIUM_CREDIT_AMOUNT = aC13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAC14_MEDIUM_CREDIT_AMOUNT() {
		return AC14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAC14_MEDIUM_CREDIT_AMOUNT(BigDecimal aC14_MEDIUM_CREDIT_AMOUNT) {
		AC14_MEDIUM_CREDIT_AMOUNT = aC14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAC15_LOW_DEBIT_NUM() {
		return AC15_LOW_DEBIT_NUM;
	}
	public void setAC15_LOW_DEBIT_NUM(BigDecimal aC15_LOW_DEBIT_NUM) {
		AC15_LOW_DEBIT_NUM = aC15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAC16_LOW_DEBIT_AMOUNT() {
		return AC16_LOW_DEBIT_AMOUNT;
	}
	public void setAC16_LOW_DEBIT_AMOUNT(BigDecimal aC16_LOW_DEBIT_AMOUNT) {
		AC16_LOW_DEBIT_AMOUNT = aC16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAC17_LOW_CREDIT_NUM() {
		return AC17_LOW_CREDIT_NUM;
	}
	public void setAC17_LOW_CREDIT_NUM(BigDecimal aC17_LOW_CREDIT_NUM) {
		AC17_LOW_CREDIT_NUM = aC17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAC18_LOW_CREDIT_AMOUNT() {
		return AC18_LOW_CREDIT_AMOUNT;
	}
	public void setAC18_LOW_CREDIT_AMOUNT(BigDecimal aC18_LOW_CREDIT_AMOUNT) {
		AC18_LOW_CREDIT_AMOUNT = aC18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAC19_WALK_DEBIT_NUM() {
		return AC19_WALK_DEBIT_NUM;
	}
	public void setAC19_WALK_DEBIT_NUM(BigDecimal aC19_WALK_DEBIT_NUM) {
		AC19_WALK_DEBIT_NUM = aC19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAC20_WALK_DEBIT_AMOUNT() {
		return AC20_WALK_DEBIT_AMOUNT;
	}
	public void setAC20_WALK_DEBIT_AMOUNT(BigDecimal aC20_WALK_DEBIT_AMOUNT) {
		AC20_WALK_DEBIT_AMOUNT = aC20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAC21_WALK_CREDIT_NUM() {
		return AC21_WALK_CREDIT_NUM;
	}
	public void setAC21_WALK_CREDIT_NUM(BigDecimal aC21_WALK_CREDIT_NUM) {
		AC21_WALK_CREDIT_NUM = aC21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAC22_WALK_CREDIT_AMOUNT() {
		return AC22_WALK_CREDIT_AMOUNT;
	}
	public void setAC22_WALK_CREDIT_AMOUNT(BigDecimal aC22_WALK_CREDIT_AMOUNT) {
		AC22_WALK_CREDIT_AMOUNT = aC22_WALK_CREDIT_AMOUNT;
	}
	public String getAD1_PROD_NAME() {
		return AD1_PROD_NAME;
	}
	public void setAD1_PROD_NAME(String aD1_PROD_NAME) {
		AD1_PROD_NAME = aD1_PROD_NAME;
	}
	public String getAD2_DESC() {
		return AD2_DESC;
	}
	public void setAD2_DESC(String aD2_DESC) {
		AD2_DESC = aD2_DESC;
	}
	public String getAD3_RISK_ASS() {
		return AD3_RISK_ASS;
	}
	public void setAD3_RISK_ASS(String aD3_RISK_ASS) {
		AD3_RISK_ASS = aD3_RISK_ASS;
	}
	public String getAD4_FACE_TO_FACE() {
		return AD4_FACE_TO_FACE;
	}
	public void setAD4_FACE_TO_FACE(String aD4_FACE_TO_FACE) {
		AD4_FACE_TO_FACE = aD4_FACE_TO_FACE;
	}
	public String getAD5_NON_FACE_TO_FACE() {
		return AD5_NON_FACE_TO_FACE;
	}
	public void setAD5_NON_FACE_TO_FACE(String aD5_NON_FACE_TO_FACE) {
		AD5_NON_FACE_TO_FACE = aD5_NON_FACE_TO_FACE;
	}
	public String getAD6_NON() {
		return AD6_NON;
	}
	public void setAD6_NON(String aD6_NON) {
		AD6_NON = aD6_NON;
	}
	public BigDecimal getAD7_HIGH_DEBIT_NUM() {
		return AD7_HIGH_DEBIT_NUM;
	}
	public void setAD7_HIGH_DEBIT_NUM(BigDecimal aD7_HIGH_DEBIT_NUM) {
		AD7_HIGH_DEBIT_NUM = aD7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAD8_HIGH_DEBIT_AMOUNT() {
		return AD8_HIGH_DEBIT_AMOUNT;
	}
	public void setAD8_HIGH_DEBIT_AMOUNT(BigDecimal aD8_HIGH_DEBIT_AMOUNT) {
		AD8_HIGH_DEBIT_AMOUNT = aD8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAD9_HIGH_CREDIT_NUM() {
		return AD9_HIGH_CREDIT_NUM;
	}
	public void setAD9_HIGH_CREDIT_NUM(BigDecimal aD9_HIGH_CREDIT_NUM) {
		AD9_HIGH_CREDIT_NUM = aD9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAD10_HIGH_CREDIT_AMOUNT() {
		return AD10_HIGH_CREDIT_AMOUNT;
	}
	public void setAD10_HIGH_CREDIT_AMOUNT(BigDecimal aD10_HIGH_CREDIT_AMOUNT) {
		AD10_HIGH_CREDIT_AMOUNT = aD10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAD11_MEDIUM_DEBIT_NUM() {
		return AD11_MEDIUM_DEBIT_NUM;
	}
	public void setAD11_MEDIUM_DEBIT_NUM(BigDecimal aD11_MEDIUM_DEBIT_NUM) {
		AD11_MEDIUM_DEBIT_NUM = aD11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAD12_MEDIUM_DEBIT_AMOUNT() {
		return AD12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAD12_MEDIUM_DEBIT_AMOUNT(BigDecimal aD12_MEDIUM_DEBIT_AMOUNT) {
		AD12_MEDIUM_DEBIT_AMOUNT = aD12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAD13_MEDIUM_CREDIT_AMOUNT() {
		return AD13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAD13_MEDIUM_CREDIT_AMOUNT(BigDecimal aD13_MEDIUM_CREDIT_AMOUNT) {
		AD13_MEDIUM_CREDIT_AMOUNT = aD13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAD14_MEDIUM_CREDIT_AMOUNT() {
		return AD14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAD14_MEDIUM_CREDIT_AMOUNT(BigDecimal aD14_MEDIUM_CREDIT_AMOUNT) {
		AD14_MEDIUM_CREDIT_AMOUNT = aD14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAD15_LOW_DEBIT_NUM() {
		return AD15_LOW_DEBIT_NUM;
	}
	public void setAD15_LOW_DEBIT_NUM(BigDecimal aD15_LOW_DEBIT_NUM) {
		AD15_LOW_DEBIT_NUM = aD15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAD16_LOW_DEBIT_AMOUNT() {
		return AD16_LOW_DEBIT_AMOUNT;
	}
	public void setAD16_LOW_DEBIT_AMOUNT(BigDecimal aD16_LOW_DEBIT_AMOUNT) {
		AD16_LOW_DEBIT_AMOUNT = aD16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAD17_LOW_CREDIT_NUM() {
		return AD17_LOW_CREDIT_NUM;
	}
	public void setAD17_LOW_CREDIT_NUM(BigDecimal aD17_LOW_CREDIT_NUM) {
		AD17_LOW_CREDIT_NUM = aD17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAD18_LOW_CREDIT_AMOUNT() {
		return AD18_LOW_CREDIT_AMOUNT;
	}
	public void setAD18_LOW_CREDIT_AMOUNT(BigDecimal aD18_LOW_CREDIT_AMOUNT) {
		AD18_LOW_CREDIT_AMOUNT = aD18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAD19_WALK_DEBIT_NUM() {
		return AD19_WALK_DEBIT_NUM;
	}
	public void setAD19_WALK_DEBIT_NUM(BigDecimal aD19_WALK_DEBIT_NUM) {
		AD19_WALK_DEBIT_NUM = aD19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAD20_WALK_DEBIT_AMOUNT() {
		return AD20_WALK_DEBIT_AMOUNT;
	}
	public void setAD20_WALK_DEBIT_AMOUNT(BigDecimal aD20_WALK_DEBIT_AMOUNT) {
		AD20_WALK_DEBIT_AMOUNT = aD20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAD21_WALK_CREDIT_NUM() {
		return AD21_WALK_CREDIT_NUM;
	}
	public void setAD21_WALK_CREDIT_NUM(BigDecimal aD21_WALK_CREDIT_NUM) {
		AD21_WALK_CREDIT_NUM = aD21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAD22_WALK_CREDIT_AMOUNT() {
		return AD22_WALK_CREDIT_AMOUNT;
	}
	public void setAD22_WALK_CREDIT_AMOUNT(BigDecimal aD22_WALK_CREDIT_AMOUNT) {
		AD22_WALK_CREDIT_AMOUNT = aD22_WALK_CREDIT_AMOUNT;
	}
	public String getAE1_PROD_NAME() {
		return AE1_PROD_NAME;
	}
	public void setAE1_PROD_NAME(String aE1_PROD_NAME) {
		AE1_PROD_NAME = aE1_PROD_NAME;
	}
	public String getAE2_DESC() {
		return AE2_DESC;
	}
	public void setAE2_DESC(String aE2_DESC) {
		AE2_DESC = aE2_DESC;
	}
	public String getAE3_RISK_ASS() {
		return AE3_RISK_ASS;
	}
	public void setAE3_RISK_ASS(String aE3_RISK_ASS) {
		AE3_RISK_ASS = aE3_RISK_ASS;
	}
	public String getAE4_FACE_TO_FACE() {
		return AE4_FACE_TO_FACE;
	}
	public void setAE4_FACE_TO_FACE(String aE4_FACE_TO_FACE) {
		AE4_FACE_TO_FACE = aE4_FACE_TO_FACE;
	}
	public String getAE5_NON_FACE_TO_FACE() {
		return AE5_NON_FACE_TO_FACE;
	}
	public void setAE5_NON_FACE_TO_FACE(String aE5_NON_FACE_TO_FACE) {
		AE5_NON_FACE_TO_FACE = aE5_NON_FACE_TO_FACE;
	}
	public String getAE6_NON() {
		return AE6_NON;
	}
	public void setAE6_NON(String aE6_NON) {
		AE6_NON = aE6_NON;
	}
	public BigDecimal getAE7_HIGH_DEBIT_NUM() {
		return AE7_HIGH_DEBIT_NUM;
	}
	public void setAE7_HIGH_DEBIT_NUM(BigDecimal aE7_HIGH_DEBIT_NUM) {
		AE7_HIGH_DEBIT_NUM = aE7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAE8_HIGH_DEBIT_AMOUNT() {
		return AE8_HIGH_DEBIT_AMOUNT;
	}
	public void setAE8_HIGH_DEBIT_AMOUNT(BigDecimal aE8_HIGH_DEBIT_AMOUNT) {
		AE8_HIGH_DEBIT_AMOUNT = aE8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAE9_HIGH_CREDIT_NUM() {
		return AE9_HIGH_CREDIT_NUM;
	}
	public void setAE9_HIGH_CREDIT_NUM(BigDecimal aE9_HIGH_CREDIT_NUM) {
		AE9_HIGH_CREDIT_NUM = aE9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAE10_HIGH_CREDIT_AMOUNT() {
		return AE10_HIGH_CREDIT_AMOUNT;
	}
	public void setAE10_HIGH_CREDIT_AMOUNT(BigDecimal aE10_HIGH_CREDIT_AMOUNT) {
		AE10_HIGH_CREDIT_AMOUNT = aE10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAE11_MEDIUM_DEBIT_NUM() {
		return AE11_MEDIUM_DEBIT_NUM;
	}
	public void setAE11_MEDIUM_DEBIT_NUM(BigDecimal aE11_MEDIUM_DEBIT_NUM) {
		AE11_MEDIUM_DEBIT_NUM = aE11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAE12_MEDIUM_DEBIT_AMOUNT() {
		return AE12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAE12_MEDIUM_DEBIT_AMOUNT(BigDecimal aE12_MEDIUM_DEBIT_AMOUNT) {
		AE12_MEDIUM_DEBIT_AMOUNT = aE12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAE13_MEDIUM_CREDIT_AMOUNT() {
		return AE13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAE13_MEDIUM_CREDIT_AMOUNT(BigDecimal aE13_MEDIUM_CREDIT_AMOUNT) {
		AE13_MEDIUM_CREDIT_AMOUNT = aE13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAE14_MEDIUM_CREDIT_AMOUNT() {
		return AE14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAE14_MEDIUM_CREDIT_AMOUNT(BigDecimal aE14_MEDIUM_CREDIT_AMOUNT) {
		AE14_MEDIUM_CREDIT_AMOUNT = aE14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAE15_LOW_DEBIT_NUM() {
		return AE15_LOW_DEBIT_NUM;
	}
	public void setAE15_LOW_DEBIT_NUM(BigDecimal aE15_LOW_DEBIT_NUM) {
		AE15_LOW_DEBIT_NUM = aE15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAE16_LOW_DEBIT_AMOUNT() {
		return AE16_LOW_DEBIT_AMOUNT;
	}
	public void setAE16_LOW_DEBIT_AMOUNT(BigDecimal aE16_LOW_DEBIT_AMOUNT) {
		AE16_LOW_DEBIT_AMOUNT = aE16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAE17_LOW_CREDIT_NUM() {
		return AE17_LOW_CREDIT_NUM;
	}
	public void setAE17_LOW_CREDIT_NUM(BigDecimal aE17_LOW_CREDIT_NUM) {
		AE17_LOW_CREDIT_NUM = aE17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAE18_LOW_CREDIT_AMOUNT() {
		return AE18_LOW_CREDIT_AMOUNT;
	}
	public void setAE18_LOW_CREDIT_AMOUNT(BigDecimal aE18_LOW_CREDIT_AMOUNT) {
		AE18_LOW_CREDIT_AMOUNT = aE18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAE19_WALK_DEBIT_NUM() {
		return AE19_WALK_DEBIT_NUM;
	}
	public void setAE19_WALK_DEBIT_NUM(BigDecimal aE19_WALK_DEBIT_NUM) {
		AE19_WALK_DEBIT_NUM = aE19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAE20_WALK_DEBIT_AMOUNT() {
		return AE20_WALK_DEBIT_AMOUNT;
	}
	public void setAE20_WALK_DEBIT_AMOUNT(BigDecimal aE20_WALK_DEBIT_AMOUNT) {
		AE20_WALK_DEBIT_AMOUNT = aE20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAE21_WALK_CREDIT_NUM() {
		return AE21_WALK_CREDIT_NUM;
	}
	public void setAE21_WALK_CREDIT_NUM(BigDecimal aE21_WALK_CREDIT_NUM) {
		AE21_WALK_CREDIT_NUM = aE21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAE22_WALK_CREDIT_AMOUNT() {
		return AE22_WALK_CREDIT_AMOUNT;
	}
	public void setAE22_WALK_CREDIT_AMOUNT(BigDecimal aE22_WALK_CREDIT_AMOUNT) {
		AE22_WALK_CREDIT_AMOUNT = aE22_WALK_CREDIT_AMOUNT;
	}
	public String getAF1_PROD_NAME() {
		return AF1_PROD_NAME;
	}
	public void setAF1_PROD_NAME(String aF1_PROD_NAME) {
		AF1_PROD_NAME = aF1_PROD_NAME;
	}
	public String getAF2_DESC() {
		return AF2_DESC;
	}
	public void setAF2_DESC(String aF2_DESC) {
		AF2_DESC = aF2_DESC;
	}
	public String getAF3_RISK_ASS() {
		return AF3_RISK_ASS;
	}
	public void setAF3_RISK_ASS(String aF3_RISK_ASS) {
		AF3_RISK_ASS = aF3_RISK_ASS;
	}
	public String getAF4_FACE_TO_FACE() {
		return AF4_FACE_TO_FACE;
	}
	public void setAF4_FACE_TO_FACE(String aF4_FACE_TO_FACE) {
		AF4_FACE_TO_FACE = aF4_FACE_TO_FACE;
	}
	public String getAF5_NON_FACE_TO_FACE() {
		return AF5_NON_FACE_TO_FACE;
	}
	public void setAF5_NON_FACE_TO_FACE(String aF5_NON_FACE_TO_FACE) {
		AF5_NON_FACE_TO_FACE = aF5_NON_FACE_TO_FACE;
	}
	public String getAF6_NON() {
		return AF6_NON;
	}
	public void setAF6_NON(String aF6_NON) {
		AF6_NON = aF6_NON;
	}
	public BigDecimal getAF7_HIGH_DEBIT_NUM() {
		return AF7_HIGH_DEBIT_NUM;
	}
	public void setAF7_HIGH_DEBIT_NUM(BigDecimal aF7_HIGH_DEBIT_NUM) {
		AF7_HIGH_DEBIT_NUM = aF7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAF8_HIGH_DEBIT_AMOUNT() {
		return AF8_HIGH_DEBIT_AMOUNT;
	}
	public void setAF8_HIGH_DEBIT_AMOUNT(BigDecimal aF8_HIGH_DEBIT_AMOUNT) {
		AF8_HIGH_DEBIT_AMOUNT = aF8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAF9_HIGH_CREDIT_NUM() {
		return AF9_HIGH_CREDIT_NUM;
	}
	public void setAF9_HIGH_CREDIT_NUM(BigDecimal aF9_HIGH_CREDIT_NUM) {
		AF9_HIGH_CREDIT_NUM = aF9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAF10_HIGH_CREDIT_AMOUNT() {
		return AF10_HIGH_CREDIT_AMOUNT;
	}
	public void setAF10_HIGH_CREDIT_AMOUNT(BigDecimal aF10_HIGH_CREDIT_AMOUNT) {
		AF10_HIGH_CREDIT_AMOUNT = aF10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAF11_MEDIUM_DEBIT_NUM() {
		return AF11_MEDIUM_DEBIT_NUM;
	}
	public void setAF11_MEDIUM_DEBIT_NUM(BigDecimal aF11_MEDIUM_DEBIT_NUM) {
		AF11_MEDIUM_DEBIT_NUM = aF11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAF12_MEDIUM_DEBIT_AMOUNT() {
		return AF12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAF12_MEDIUM_DEBIT_AMOUNT(BigDecimal aF12_MEDIUM_DEBIT_AMOUNT) {
		AF12_MEDIUM_DEBIT_AMOUNT = aF12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAF13_MEDIUM_CREDIT_AMOUNT() {
		return AF13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAF13_MEDIUM_CREDIT_AMOUNT(BigDecimal aF13_MEDIUM_CREDIT_AMOUNT) {
		AF13_MEDIUM_CREDIT_AMOUNT = aF13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAF14_MEDIUM_CREDIT_AMOUNT() {
		return AF14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAF14_MEDIUM_CREDIT_AMOUNT(BigDecimal aF14_MEDIUM_CREDIT_AMOUNT) {
		AF14_MEDIUM_CREDIT_AMOUNT = aF14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAF15_LOW_DEBIT_NUM() {
		return AF15_LOW_DEBIT_NUM;
	}
	public void setAF15_LOW_DEBIT_NUM(BigDecimal aF15_LOW_DEBIT_NUM) {
		AF15_LOW_DEBIT_NUM = aF15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAF16_LOW_DEBIT_AMOUNT() {
		return AF16_LOW_DEBIT_AMOUNT;
	}
	public void setAF16_LOW_DEBIT_AMOUNT(BigDecimal aF16_LOW_DEBIT_AMOUNT) {
		AF16_LOW_DEBIT_AMOUNT = aF16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAF17_LOW_CREDIT_NUM() {
		return AF17_LOW_CREDIT_NUM;
	}
	public void setAF17_LOW_CREDIT_NUM(BigDecimal aF17_LOW_CREDIT_NUM) {
		AF17_LOW_CREDIT_NUM = aF17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAF18_LOW_CREDIT_AMOUNT() {
		return AF18_LOW_CREDIT_AMOUNT;
	}
	public void setAF18_LOW_CREDIT_AMOUNT(BigDecimal aF18_LOW_CREDIT_AMOUNT) {
		AF18_LOW_CREDIT_AMOUNT = aF18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAF19_WALK_DEBIT_NUM() {
		return AF19_WALK_DEBIT_NUM;
	}
	public void setAF19_WALK_DEBIT_NUM(BigDecimal aF19_WALK_DEBIT_NUM) {
		AF19_WALK_DEBIT_NUM = aF19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAF20_WALK_DEBIT_AMOUNT() {
		return AF20_WALK_DEBIT_AMOUNT;
	}
	public void setAF20_WALK_DEBIT_AMOUNT(BigDecimal aF20_WALK_DEBIT_AMOUNT) {
		AF20_WALK_DEBIT_AMOUNT = aF20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAF21_WALK_CREDIT_NUM() {
		return AF21_WALK_CREDIT_NUM;
	}
	public void setAF21_WALK_CREDIT_NUM(BigDecimal aF21_WALK_CREDIT_NUM) {
		AF21_WALK_CREDIT_NUM = aF21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAF22_WALK_CREDIT_AMOUNT() {
		return AF22_WALK_CREDIT_AMOUNT;
	}
	public void setAF22_WALK_CREDIT_AMOUNT(BigDecimal aF22_WALK_CREDIT_AMOUNT) {
		AF22_WALK_CREDIT_AMOUNT = aF22_WALK_CREDIT_AMOUNT;
	}
	public String getAG1_PROD_NAME() {
		return AG1_PROD_NAME;
	}
	public void setAG1_PROD_NAME(String aG1_PROD_NAME) {
		AG1_PROD_NAME = aG1_PROD_NAME;
	}
	public String getAG2_DESC() {
		return AG2_DESC;
	}
	public void setAG2_DESC(String aG2_DESC) {
		AG2_DESC = aG2_DESC;
	}
	public String getAG3_RISK_ASS() {
		return AG3_RISK_ASS;
	}
	public void setAG3_RISK_ASS(String aG3_RISK_ASS) {
		AG3_RISK_ASS = aG3_RISK_ASS;
	}
	public String getAG4_FACE_TO_FACE() {
		return AG4_FACE_TO_FACE;
	}
	public void setAG4_FACE_TO_FACE(String aG4_FACE_TO_FACE) {
		AG4_FACE_TO_FACE = aG4_FACE_TO_FACE;
	}
	public String getAG5_NON_FACE_TO_FACE() {
		return AG5_NON_FACE_TO_FACE;
	}
	public void setAG5_NON_FACE_TO_FACE(String aG5_NON_FACE_TO_FACE) {
		AG5_NON_FACE_TO_FACE = aG5_NON_FACE_TO_FACE;
	}
	public String getAG6_NON() {
		return AG6_NON;
	}
	public void setAG6_NON(String aG6_NON) {
		AG6_NON = aG6_NON;
	}
	public BigDecimal getAG7_HIGH_DEBIT_NUM() {
		return AG7_HIGH_DEBIT_NUM;
	}
	public void setAG7_HIGH_DEBIT_NUM(BigDecimal aG7_HIGH_DEBIT_NUM) {
		AG7_HIGH_DEBIT_NUM = aG7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAG8_HIGH_DEBIT_AMOUNT() {
		return AG8_HIGH_DEBIT_AMOUNT;
	}
	public void setAG8_HIGH_DEBIT_AMOUNT(BigDecimal aG8_HIGH_DEBIT_AMOUNT) {
		AG8_HIGH_DEBIT_AMOUNT = aG8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAG9_HIGH_CREDIT_NUM() {
		return AG9_HIGH_CREDIT_NUM;
	}
	public void setAG9_HIGH_CREDIT_NUM(BigDecimal aG9_HIGH_CREDIT_NUM) {
		AG9_HIGH_CREDIT_NUM = aG9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAG10_HIGH_CREDIT_AMOUNT() {
		return AG10_HIGH_CREDIT_AMOUNT;
	}
	public void setAG10_HIGH_CREDIT_AMOUNT(BigDecimal aG10_HIGH_CREDIT_AMOUNT) {
		AG10_HIGH_CREDIT_AMOUNT = aG10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAG11_MEDIUM_DEBIT_NUM() {
		return AG11_MEDIUM_DEBIT_NUM;
	}
	public void setAG11_MEDIUM_DEBIT_NUM(BigDecimal aG11_MEDIUM_DEBIT_NUM) {
		AG11_MEDIUM_DEBIT_NUM = aG11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAG12_MEDIUM_DEBIT_AMOUNT() {
		return AG12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAG12_MEDIUM_DEBIT_AMOUNT(BigDecimal aG12_MEDIUM_DEBIT_AMOUNT) {
		AG12_MEDIUM_DEBIT_AMOUNT = aG12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAG13_MEDIUM_CREDIT_AMOUNT() {
		return AG13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAG13_MEDIUM_CREDIT_AMOUNT(BigDecimal aG13_MEDIUM_CREDIT_AMOUNT) {
		AG13_MEDIUM_CREDIT_AMOUNT = aG13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAG14_MEDIUM_CREDIT_AMOUNT() {
		return AG14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAG14_MEDIUM_CREDIT_AMOUNT(BigDecimal aG14_MEDIUM_CREDIT_AMOUNT) {
		AG14_MEDIUM_CREDIT_AMOUNT = aG14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAG15_LOW_DEBIT_NUM() {
		return AG15_LOW_DEBIT_NUM;
	}
	public void setAG15_LOW_DEBIT_NUM(BigDecimal aG15_LOW_DEBIT_NUM) {
		AG15_LOW_DEBIT_NUM = aG15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAG16_LOW_DEBIT_AMOUNT() {
		return AG16_LOW_DEBIT_AMOUNT;
	}
	public void setAG16_LOW_DEBIT_AMOUNT(BigDecimal aG16_LOW_DEBIT_AMOUNT) {
		AG16_LOW_DEBIT_AMOUNT = aG16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAG17_LOW_CREDIT_NUM() {
		return AG17_LOW_CREDIT_NUM;
	}
	public void setAG17_LOW_CREDIT_NUM(BigDecimal aG17_LOW_CREDIT_NUM) {
		AG17_LOW_CREDIT_NUM = aG17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAG18_LOW_CREDIT_AMOUNT() {
		return AG18_LOW_CREDIT_AMOUNT;
	}
	public void setAG18_LOW_CREDIT_AMOUNT(BigDecimal aG18_LOW_CREDIT_AMOUNT) {
		AG18_LOW_CREDIT_AMOUNT = aG18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAG19_WALK_DEBIT_NUM() {
		return AG19_WALK_DEBIT_NUM;
	}
	public void setAG19_WALK_DEBIT_NUM(BigDecimal aG19_WALK_DEBIT_NUM) {
		AG19_WALK_DEBIT_NUM = aG19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAG20_WALK_DEBIT_AMOUNT() {
		return AG20_WALK_DEBIT_AMOUNT;
	}
	public void setAG20_WALK_DEBIT_AMOUNT(BigDecimal aG20_WALK_DEBIT_AMOUNT) {
		AG20_WALK_DEBIT_AMOUNT = aG20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAG21_WALK_CREDIT_NUM() {
		return AG21_WALK_CREDIT_NUM;
	}
	public void setAG21_WALK_CREDIT_NUM(BigDecimal aG21_WALK_CREDIT_NUM) {
		AG21_WALK_CREDIT_NUM = aG21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAG22_WALK_CREDIT_AMOUNT() {
		return AG22_WALK_CREDIT_AMOUNT;
	}
	public void setAG22_WALK_CREDIT_AMOUNT(BigDecimal aG22_WALK_CREDIT_AMOUNT) {
		AG22_WALK_CREDIT_AMOUNT = aG22_WALK_CREDIT_AMOUNT;
	}
	public String getAH1_PROD_NAME() {
		return AH1_PROD_NAME;
	}
	public void setAH1_PROD_NAME(String aH1_PROD_NAME) {
		AH1_PROD_NAME = aH1_PROD_NAME;
	}
	public String getAH2_DESC() {
		return AH2_DESC;
	}
	public void setAH2_DESC(String aH2_DESC) {
		AH2_DESC = aH2_DESC;
	}
	public String getAH3_RISK_ASS() {
		return AH3_RISK_ASS;
	}
	public void setAH3_RISK_ASS(String aH3_RISK_ASS) {
		AH3_RISK_ASS = aH3_RISK_ASS;
	}
	public String getAH4_FACE_TO_FACE() {
		return AH4_FACE_TO_FACE;
	}
	public void setAH4_FACE_TO_FACE(String aH4_FACE_TO_FACE) {
		AH4_FACE_TO_FACE = aH4_FACE_TO_FACE;
	}
	public String getAH5_NON_FACE_TO_FACE() {
		return AH5_NON_FACE_TO_FACE;
	}
	public void setAH5_NON_FACE_TO_FACE(String aH5_NON_FACE_TO_FACE) {
		AH5_NON_FACE_TO_FACE = aH5_NON_FACE_TO_FACE;
	}
	public String getAH6_NON() {
		return AH6_NON;
	}
	public void setAH6_NON(String aH6_NON) {
		AH6_NON = aH6_NON;
	}
	public BigDecimal getAH7_HIGH_DEBIT_NUM() {
		return AH7_HIGH_DEBIT_NUM;
	}
	public void setAH7_HIGH_DEBIT_NUM(BigDecimal aH7_HIGH_DEBIT_NUM) {
		AH7_HIGH_DEBIT_NUM = aH7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAH8_HIGH_DEBIT_AMOUNT() {
		return AH8_HIGH_DEBIT_AMOUNT;
	}
	public void setAH8_HIGH_DEBIT_AMOUNT(BigDecimal aH8_HIGH_DEBIT_AMOUNT) {
		AH8_HIGH_DEBIT_AMOUNT = aH8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAH9_HIGH_CREDIT_NUM() {
		return AH9_HIGH_CREDIT_NUM;
	}
	public void setAH9_HIGH_CREDIT_NUM(BigDecimal aH9_HIGH_CREDIT_NUM) {
		AH9_HIGH_CREDIT_NUM = aH9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAH10_HIGH_CREDIT_AMOUNT() {
		return AH10_HIGH_CREDIT_AMOUNT;
	}
	public void setAH10_HIGH_CREDIT_AMOUNT(BigDecimal aH10_HIGH_CREDIT_AMOUNT) {
		AH10_HIGH_CREDIT_AMOUNT = aH10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAH11_MEDIUM_DEBIT_NUM() {
		return AH11_MEDIUM_DEBIT_NUM;
	}
	public void setAH11_MEDIUM_DEBIT_NUM(BigDecimal aH11_MEDIUM_DEBIT_NUM) {
		AH11_MEDIUM_DEBIT_NUM = aH11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAH12_MEDIUM_DEBIT_AMOUNT() {
		return AH12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAH12_MEDIUM_DEBIT_AMOUNT(BigDecimal aH12_MEDIUM_DEBIT_AMOUNT) {
		AH12_MEDIUM_DEBIT_AMOUNT = aH12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAH13_MEDIUM_CREDIT_AMOUNT() {
		return AH13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAH13_MEDIUM_CREDIT_AMOUNT(BigDecimal aH13_MEDIUM_CREDIT_AMOUNT) {
		AH13_MEDIUM_CREDIT_AMOUNT = aH13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAH14_MEDIUM_CREDIT_AMOUNT() {
		return AH14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAH14_MEDIUM_CREDIT_AMOUNT(BigDecimal aH14_MEDIUM_CREDIT_AMOUNT) {
		AH14_MEDIUM_CREDIT_AMOUNT = aH14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAH15_LOW_DEBIT_NUM() {
		return AH15_LOW_DEBIT_NUM;
	}
	public void setAH15_LOW_DEBIT_NUM(BigDecimal aH15_LOW_DEBIT_NUM) {
		AH15_LOW_DEBIT_NUM = aH15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAH16_LOW_DEBIT_AMOUNT() {
		return AH16_LOW_DEBIT_AMOUNT;
	}
	public void setAH16_LOW_DEBIT_AMOUNT(BigDecimal aH16_LOW_DEBIT_AMOUNT) {
		AH16_LOW_DEBIT_AMOUNT = aH16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAH17_LOW_CREDIT_NUM() {
		return AH17_LOW_CREDIT_NUM;
	}
	public void setAH17_LOW_CREDIT_NUM(BigDecimal aH17_LOW_CREDIT_NUM) {
		AH17_LOW_CREDIT_NUM = aH17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAH18_LOW_CREDIT_AMOUNT() {
		return AH18_LOW_CREDIT_AMOUNT;
	}
	public void setAH18_LOW_CREDIT_AMOUNT(BigDecimal aH18_LOW_CREDIT_AMOUNT) {
		AH18_LOW_CREDIT_AMOUNT = aH18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAH19_WALK_DEBIT_NUM() {
		return AH19_WALK_DEBIT_NUM;
	}
	public void setAH19_WALK_DEBIT_NUM(BigDecimal aH19_WALK_DEBIT_NUM) {
		AH19_WALK_DEBIT_NUM = aH19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAH20_WALK_DEBIT_AMOUNT() {
		return AH20_WALK_DEBIT_AMOUNT;
	}
	public void setAH20_WALK_DEBIT_AMOUNT(BigDecimal aH20_WALK_DEBIT_AMOUNT) {
		AH20_WALK_DEBIT_AMOUNT = aH20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAH21_WALK_CREDIT_NUM() {
		return AH21_WALK_CREDIT_NUM;
	}
	public void setAH21_WALK_CREDIT_NUM(BigDecimal aH21_WALK_CREDIT_NUM) {
		AH21_WALK_CREDIT_NUM = aH21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAH22_WALK_CREDIT_AMOUNT() {
		return AH22_WALK_CREDIT_AMOUNT;
	}
	public void setAH22_WALK_CREDIT_AMOUNT(BigDecimal aH22_WALK_CREDIT_AMOUNT) {
		AH22_WALK_CREDIT_AMOUNT = aH22_WALK_CREDIT_AMOUNT;
	}
	public String getAI1_PROD_NAME() {
		return AI1_PROD_NAME;
	}
	public void setAI1_PROD_NAME(String aI1_PROD_NAME) {
		AI1_PROD_NAME = aI1_PROD_NAME;
	}
	public String getAI2_DESC() {
		return AI2_DESC;
	}
	public void setAI2_DESC(String aI2_DESC) {
		AI2_DESC = aI2_DESC;
	}
	public String getAI3_RISK_ASS() {
		return AI3_RISK_ASS;
	}
	public void setAI3_RISK_ASS(String aI3_RISK_ASS) {
		AI3_RISK_ASS = aI3_RISK_ASS;
	}
	public String getAI4_FACE_TO_FACE() {
		return AI4_FACE_TO_FACE;
	}
	public void setAI4_FACE_TO_FACE(String aI4_FACE_TO_FACE) {
		AI4_FACE_TO_FACE = aI4_FACE_TO_FACE;
	}
	public String getAI5_NON_FACE_TO_FACE() {
		return AI5_NON_FACE_TO_FACE;
	}
	public void setAI5_NON_FACE_TO_FACE(String aI5_NON_FACE_TO_FACE) {
		AI5_NON_FACE_TO_FACE = aI5_NON_FACE_TO_FACE;
	}
	public String getAI6_NON() {
		return AI6_NON;
	}
	public void setAI6_NON(String aI6_NON) {
		AI6_NON = aI6_NON;
	}
	public BigDecimal getAI7_HIGH_DEBIT_NUM() {
		return AI7_HIGH_DEBIT_NUM;
	}
	public void setAI7_HIGH_DEBIT_NUM(BigDecimal aI7_HIGH_DEBIT_NUM) {
		AI7_HIGH_DEBIT_NUM = aI7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAI8_HIGH_DEBIT_AMOUNT() {
		return AI8_HIGH_DEBIT_AMOUNT;
	}
	public void setAI8_HIGH_DEBIT_AMOUNT(BigDecimal aI8_HIGH_DEBIT_AMOUNT) {
		AI8_HIGH_DEBIT_AMOUNT = aI8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAI9_HIGH_CREDIT_NUM() {
		return AI9_HIGH_CREDIT_NUM;
	}
	public void setAI9_HIGH_CREDIT_NUM(BigDecimal aI9_HIGH_CREDIT_NUM) {
		AI9_HIGH_CREDIT_NUM = aI9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAI10_HIGH_CREDIT_AMOUNT() {
		return AI10_HIGH_CREDIT_AMOUNT;
	}
	public void setAI10_HIGH_CREDIT_AMOUNT(BigDecimal aI10_HIGH_CREDIT_AMOUNT) {
		AI10_HIGH_CREDIT_AMOUNT = aI10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAI11_MEDIUM_DEBIT_NUM() {
		return AI11_MEDIUM_DEBIT_NUM;
	}
	public void setAI11_MEDIUM_DEBIT_NUM(BigDecimal aI11_MEDIUM_DEBIT_NUM) {
		AI11_MEDIUM_DEBIT_NUM = aI11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAI12_MEDIUM_DEBIT_AMOUNT() {
		return AI12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAI12_MEDIUM_DEBIT_AMOUNT(BigDecimal aI12_MEDIUM_DEBIT_AMOUNT) {
		AI12_MEDIUM_DEBIT_AMOUNT = aI12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAI13_MEDIUM_CREDIT_AMOUNT() {
		return AI13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAI13_MEDIUM_CREDIT_AMOUNT(BigDecimal aI13_MEDIUM_CREDIT_AMOUNT) {
		AI13_MEDIUM_CREDIT_AMOUNT = aI13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAI14_MEDIUM_CREDIT_AMOUNT() {
		return AI14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAI14_MEDIUM_CREDIT_AMOUNT(BigDecimal aI14_MEDIUM_CREDIT_AMOUNT) {
		AI14_MEDIUM_CREDIT_AMOUNT = aI14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAI15_LOW_DEBIT_NUM() {
		return AI15_LOW_DEBIT_NUM;
	}
	public void setAI15_LOW_DEBIT_NUM(BigDecimal aI15_LOW_DEBIT_NUM) {
		AI15_LOW_DEBIT_NUM = aI15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAI16_LOW_DEBIT_AMOUNT() {
		return AI16_LOW_DEBIT_AMOUNT;
	}
	public void setAI16_LOW_DEBIT_AMOUNT(BigDecimal aI16_LOW_DEBIT_AMOUNT) {
		AI16_LOW_DEBIT_AMOUNT = aI16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAI17_LOW_CREDIT_NUM() {
		return AI17_LOW_CREDIT_NUM;
	}
	public void setAI17_LOW_CREDIT_NUM(BigDecimal aI17_LOW_CREDIT_NUM) {
		AI17_LOW_CREDIT_NUM = aI17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAI18_LOW_CREDIT_AMOUNT() {
		return AI18_LOW_CREDIT_AMOUNT;
	}
	public void setAI18_LOW_CREDIT_AMOUNT(BigDecimal aI18_LOW_CREDIT_AMOUNT) {
		AI18_LOW_CREDIT_AMOUNT = aI18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAI19_WALK_DEBIT_NUM() {
		return AI19_WALK_DEBIT_NUM;
	}
	public void setAI19_WALK_DEBIT_NUM(BigDecimal aI19_WALK_DEBIT_NUM) {
		AI19_WALK_DEBIT_NUM = aI19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAI20_WALK_DEBIT_AMOUNT() {
		return AI20_WALK_DEBIT_AMOUNT;
	}
	public void setAI20_WALK_DEBIT_AMOUNT(BigDecimal aI20_WALK_DEBIT_AMOUNT) {
		AI20_WALK_DEBIT_AMOUNT = aI20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAI21_WALK_CREDIT_NUM() {
		return AI21_WALK_CREDIT_NUM;
	}
	public void setAI21_WALK_CREDIT_NUM(BigDecimal aI21_WALK_CREDIT_NUM) {
		AI21_WALK_CREDIT_NUM = aI21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAI22_WALK_CREDIT_AMOUNT() {
		return AI22_WALK_CREDIT_AMOUNT;
	}
	public void setAI22_WALK_CREDIT_AMOUNT(BigDecimal aI22_WALK_CREDIT_AMOUNT) {
		AI22_WALK_CREDIT_AMOUNT = aI22_WALK_CREDIT_AMOUNT;
	}
	public String getAJ1_PROD_NAME() {
		return AJ1_PROD_NAME;
	}
	public void setAJ1_PROD_NAME(String aJ1_PROD_NAME) {
		AJ1_PROD_NAME = aJ1_PROD_NAME;
	}
	public String getAJ2_DESC() {
		return AJ2_DESC;
	}
	public void setAJ2_DESC(String aJ2_DESC) {
		AJ2_DESC = aJ2_DESC;
	}
	public String getAJ3_RISK_ASS() {
		return AJ3_RISK_ASS;
	}
	public void setAJ3_RISK_ASS(String aJ3_RISK_ASS) {
		AJ3_RISK_ASS = aJ3_RISK_ASS;
	}
	public String getAJ4_FACE_TO_FACE() {
		return AJ4_FACE_TO_FACE;
	}
	public void setAJ4_FACE_TO_FACE(String aJ4_FACE_TO_FACE) {
		AJ4_FACE_TO_FACE = aJ4_FACE_TO_FACE;
	}
	public String getAJ5_NON_FACE_TO_FACE() {
		return AJ5_NON_FACE_TO_FACE;
	}
	public void setAJ5_NON_FACE_TO_FACE(String aJ5_NON_FACE_TO_FACE) {
		AJ5_NON_FACE_TO_FACE = aJ5_NON_FACE_TO_FACE;
	}
	public String getAJ6_NON() {
		return AJ6_NON;
	}
	public void setAJ6_NON(String aJ6_NON) {
		AJ6_NON = aJ6_NON;
	}
	public BigDecimal getAJ7_HIGH_DEBIT_NUM() {
		return AJ7_HIGH_DEBIT_NUM;
	}
	public void setAJ7_HIGH_DEBIT_NUM(BigDecimal aJ7_HIGH_DEBIT_NUM) {
		AJ7_HIGH_DEBIT_NUM = aJ7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAJ8_HIGH_DEBIT_AMOUNT() {
		return AJ8_HIGH_DEBIT_AMOUNT;
	}
	public void setAJ8_HIGH_DEBIT_AMOUNT(BigDecimal aJ8_HIGH_DEBIT_AMOUNT) {
		AJ8_HIGH_DEBIT_AMOUNT = aJ8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAJ9_HIGH_CREDIT_NUM() {
		return AJ9_HIGH_CREDIT_NUM;
	}
	public void setAJ9_HIGH_CREDIT_NUM(BigDecimal aJ9_HIGH_CREDIT_NUM) {
		AJ9_HIGH_CREDIT_NUM = aJ9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAJ10_HIGH_CREDIT_AMOUNT() {
		return AJ10_HIGH_CREDIT_AMOUNT;
	}
	public void setAJ10_HIGH_CREDIT_AMOUNT(BigDecimal aJ10_HIGH_CREDIT_AMOUNT) {
		AJ10_HIGH_CREDIT_AMOUNT = aJ10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAJ11_MEDIUM_DEBIT_NUM() {
		return AJ11_MEDIUM_DEBIT_NUM;
	}
	public void setAJ11_MEDIUM_DEBIT_NUM(BigDecimal aJ11_MEDIUM_DEBIT_NUM) {
		AJ11_MEDIUM_DEBIT_NUM = aJ11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAJ12_MEDIUM_DEBIT_AMOUNT() {
		return AJ12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAJ12_MEDIUM_DEBIT_AMOUNT(BigDecimal aJ12_MEDIUM_DEBIT_AMOUNT) {
		AJ12_MEDIUM_DEBIT_AMOUNT = aJ12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAJ13_MEDIUM_CREDIT_AMOUNT() {
		return AJ13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAJ13_MEDIUM_CREDIT_AMOUNT(BigDecimal aJ13_MEDIUM_CREDIT_AMOUNT) {
		AJ13_MEDIUM_CREDIT_AMOUNT = aJ13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAJ14_MEDIUM_CREDIT_AMOUNT() {
		return AJ14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAJ14_MEDIUM_CREDIT_AMOUNT(BigDecimal aJ14_MEDIUM_CREDIT_AMOUNT) {
		AJ14_MEDIUM_CREDIT_AMOUNT = aJ14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAJ15_LOW_DEBIT_NUM() {
		return AJ15_LOW_DEBIT_NUM;
	}
	public void setAJ15_LOW_DEBIT_NUM(BigDecimal aJ15_LOW_DEBIT_NUM) {
		AJ15_LOW_DEBIT_NUM = aJ15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAJ16_LOW_DEBIT_AMOUNT() {
		return AJ16_LOW_DEBIT_AMOUNT;
	}
	public void setAJ16_LOW_DEBIT_AMOUNT(BigDecimal aJ16_LOW_DEBIT_AMOUNT) {
		AJ16_LOW_DEBIT_AMOUNT = aJ16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAJ17_LOW_CREDIT_NUM() {
		return AJ17_LOW_CREDIT_NUM;
	}
	public void setAJ17_LOW_CREDIT_NUM(BigDecimal aJ17_LOW_CREDIT_NUM) {
		AJ17_LOW_CREDIT_NUM = aJ17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAJ18_LOW_CREDIT_AMOUNT() {
		return AJ18_LOW_CREDIT_AMOUNT;
	}
	public void setAJ18_LOW_CREDIT_AMOUNT(BigDecimal aJ18_LOW_CREDIT_AMOUNT) {
		AJ18_LOW_CREDIT_AMOUNT = aJ18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAJ19_WALK_DEBIT_NUM() {
		return AJ19_WALK_DEBIT_NUM;
	}
	public void setAJ19_WALK_DEBIT_NUM(BigDecimal aJ19_WALK_DEBIT_NUM) {
		AJ19_WALK_DEBIT_NUM = aJ19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAJ20_WALK_DEBIT_AMOUNT() {
		return AJ20_WALK_DEBIT_AMOUNT;
	}
	public void setAJ20_WALK_DEBIT_AMOUNT(BigDecimal aJ20_WALK_DEBIT_AMOUNT) {
		AJ20_WALK_DEBIT_AMOUNT = aJ20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAJ21_WALK_CREDIT_NUM() {
		return AJ21_WALK_CREDIT_NUM;
	}
	public void setAJ21_WALK_CREDIT_NUM(BigDecimal aJ21_WALK_CREDIT_NUM) {
		AJ21_WALK_CREDIT_NUM = aJ21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAJ22_WALK_CREDIT_AMOUNT() {
		return AJ22_WALK_CREDIT_AMOUNT;
	}
	public void setAJ22_WALK_CREDIT_AMOUNT(BigDecimal aJ22_WALK_CREDIT_AMOUNT) {
		AJ22_WALK_CREDIT_AMOUNT = aJ22_WALK_CREDIT_AMOUNT;
	}
	public String getAK1_PROD_NAME() {
		return AK1_PROD_NAME;
	}
	public void setAK1_PROD_NAME(String aK1_PROD_NAME) {
		AK1_PROD_NAME = aK1_PROD_NAME;
	}
	public String getAK2_DESC() {
		return AK2_DESC;
	}
	public void setAK2_DESC(String aK2_DESC) {
		AK2_DESC = aK2_DESC;
	}
	public String getAK3_RISK_ASS() {
		return AK3_RISK_ASS;
	}
	public void setAK3_RISK_ASS(String aK3_RISK_ASS) {
		AK3_RISK_ASS = aK3_RISK_ASS;
	}
	public String getAK4_FACE_TO_FACE() {
		return AK4_FACE_TO_FACE;
	}
	public void setAK4_FACE_TO_FACE(String aK4_FACE_TO_FACE) {
		AK4_FACE_TO_FACE = aK4_FACE_TO_FACE;
	}
	public String getAK5_NON_FACE_TO_FACE() {
		return AK5_NON_FACE_TO_FACE;
	}
	public void setAK5_NON_FACE_TO_FACE(String aK5_NON_FACE_TO_FACE) {
		AK5_NON_FACE_TO_FACE = aK5_NON_FACE_TO_FACE;
	}
	public String getAK6_NON() {
		return AK6_NON;
	}
	public void setAK6_NON(String aK6_NON) {
		AK6_NON = aK6_NON;
	}
	public BigDecimal getAK7_HIGH_DEBIT_NUM() {
		return AK7_HIGH_DEBIT_NUM;
	}
	public void setAK7_HIGH_DEBIT_NUM(BigDecimal aK7_HIGH_DEBIT_NUM) {
		AK7_HIGH_DEBIT_NUM = aK7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAK8_HIGH_DEBIT_AMOUNT() {
		return AK8_HIGH_DEBIT_AMOUNT;
	}
	public void setAK8_HIGH_DEBIT_AMOUNT(BigDecimal aK8_HIGH_DEBIT_AMOUNT) {
		AK8_HIGH_DEBIT_AMOUNT = aK8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAK9_HIGH_CREDIT_NUM() {
		return AK9_HIGH_CREDIT_NUM;
	}
	public void setAK9_HIGH_CREDIT_NUM(BigDecimal aK9_HIGH_CREDIT_NUM) {
		AK9_HIGH_CREDIT_NUM = aK9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAK10_HIGH_CREDIT_AMOUNT() {
		return AK10_HIGH_CREDIT_AMOUNT;
	}
	public void setAK10_HIGH_CREDIT_AMOUNT(BigDecimal aK10_HIGH_CREDIT_AMOUNT) {
		AK10_HIGH_CREDIT_AMOUNT = aK10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAK11_MEDIUM_DEBIT_NUM() {
		return AK11_MEDIUM_DEBIT_NUM;
	}
	public void setAK11_MEDIUM_DEBIT_NUM(BigDecimal aK11_MEDIUM_DEBIT_NUM) {
		AK11_MEDIUM_DEBIT_NUM = aK11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAK12_MEDIUM_DEBIT_AMOUNT() {
		return AK12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAK12_MEDIUM_DEBIT_AMOUNT(BigDecimal aK12_MEDIUM_DEBIT_AMOUNT) {
		AK12_MEDIUM_DEBIT_AMOUNT = aK12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAK13_MEDIUM_CREDIT_AMOUNT() {
		return AK13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAK13_MEDIUM_CREDIT_AMOUNT(BigDecimal aK13_MEDIUM_CREDIT_AMOUNT) {
		AK13_MEDIUM_CREDIT_AMOUNT = aK13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAK14_MEDIUM_CREDIT_AMOUNT() {
		return AK14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAK14_MEDIUM_CREDIT_AMOUNT(BigDecimal aK14_MEDIUM_CREDIT_AMOUNT) {
		AK14_MEDIUM_CREDIT_AMOUNT = aK14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAK15_LOW_DEBIT_NUM() {
		return AK15_LOW_DEBIT_NUM;
	}
	public void setAK15_LOW_DEBIT_NUM(BigDecimal aK15_LOW_DEBIT_NUM) {
		AK15_LOW_DEBIT_NUM = aK15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAK16_LOW_DEBIT_AMOUNT() {
		return AK16_LOW_DEBIT_AMOUNT;
	}
	public void setAK16_LOW_DEBIT_AMOUNT(BigDecimal aK16_LOW_DEBIT_AMOUNT) {
		AK16_LOW_DEBIT_AMOUNT = aK16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAK17_LOW_CREDIT_NUM() {
		return AK17_LOW_CREDIT_NUM;
	}
	public void setAK17_LOW_CREDIT_NUM(BigDecimal aK17_LOW_CREDIT_NUM) {
		AK17_LOW_CREDIT_NUM = aK17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAK18_LOW_CREDIT_AMOUNT() {
		return AK18_LOW_CREDIT_AMOUNT;
	}
	public void setAK18_LOW_CREDIT_AMOUNT(BigDecimal aK18_LOW_CREDIT_AMOUNT) {
		AK18_LOW_CREDIT_AMOUNT = aK18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAK19_WALK_DEBIT_NUM() {
		return AK19_WALK_DEBIT_NUM;
	}
	public void setAK19_WALK_DEBIT_NUM(BigDecimal aK19_WALK_DEBIT_NUM) {
		AK19_WALK_DEBIT_NUM = aK19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAK20_WALK_DEBIT_AMOUNT() {
		return AK20_WALK_DEBIT_AMOUNT;
	}
	public void setAK20_WALK_DEBIT_AMOUNT(BigDecimal aK20_WALK_DEBIT_AMOUNT) {
		AK20_WALK_DEBIT_AMOUNT = aK20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAK21_WALK_CREDIT_NUM() {
		return AK21_WALK_CREDIT_NUM;
	}
	public void setAK21_WALK_CREDIT_NUM(BigDecimal aK21_WALK_CREDIT_NUM) {
		AK21_WALK_CREDIT_NUM = aK21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAK22_WALK_CREDIT_AMOUNT() {
		return AK22_WALK_CREDIT_AMOUNT;
	}
	public void setAK22_WALK_CREDIT_AMOUNT(BigDecimal aK22_WALK_CREDIT_AMOUNT) {
		AK22_WALK_CREDIT_AMOUNT = aK22_WALK_CREDIT_AMOUNT;
	}
	public String getAL1_PROD_NAME() {
		return AL1_PROD_NAME;
	}
	public void setAL1_PROD_NAME(String aL1_PROD_NAME) {
		AL1_PROD_NAME = aL1_PROD_NAME;
	}
	public String getAL2_DESC() {
		return AL2_DESC;
	}
	public void setAL2_DESC(String aL2_DESC) {
		AL2_DESC = aL2_DESC;
	}
	public String getAL3_RISK_ASS() {
		return AL3_RISK_ASS;
	}
	public void setAL3_RISK_ASS(String aL3_RISK_ASS) {
		AL3_RISK_ASS = aL3_RISK_ASS;
	}
	public String getAL4_FACE_TO_FACE() {
		return AL4_FACE_TO_FACE;
	}
	public void setAL4_FACE_TO_FACE(String aL4_FACE_TO_FACE) {
		AL4_FACE_TO_FACE = aL4_FACE_TO_FACE;
	}
	public String getAL5_NON_FACE_TO_FACE() {
		return AL5_NON_FACE_TO_FACE;
	}
	public void setAL5_NON_FACE_TO_FACE(String aL5_NON_FACE_TO_FACE) {
		AL5_NON_FACE_TO_FACE = aL5_NON_FACE_TO_FACE;
	}
	public String getAL6_NON() {
		return AL6_NON;
	}
	public void setAL6_NON(String aL6_NON) {
		AL6_NON = aL6_NON;
	}
	public BigDecimal getAL7_HIGH_DEBIT_NUM() {
		return AL7_HIGH_DEBIT_NUM;
	}
	public void setAL7_HIGH_DEBIT_NUM(BigDecimal aL7_HIGH_DEBIT_NUM) {
		AL7_HIGH_DEBIT_NUM = aL7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAL8_HIGH_DEBIT_AMOUNT() {
		return AL8_HIGH_DEBIT_AMOUNT;
	}
	public void setAL8_HIGH_DEBIT_AMOUNT(BigDecimal aL8_HIGH_DEBIT_AMOUNT) {
		AL8_HIGH_DEBIT_AMOUNT = aL8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAL9_HIGH_CREDIT_NUM() {
		return AL9_HIGH_CREDIT_NUM;
	}
	public void setAL9_HIGH_CREDIT_NUM(BigDecimal aL9_HIGH_CREDIT_NUM) {
		AL9_HIGH_CREDIT_NUM = aL9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAL10_HIGH_CREDIT_AMOUNT() {
		return AL10_HIGH_CREDIT_AMOUNT;
	}
	public void setAL10_HIGH_CREDIT_AMOUNT(BigDecimal aL10_HIGH_CREDIT_AMOUNT) {
		AL10_HIGH_CREDIT_AMOUNT = aL10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAL11_MEDIUM_DEBIT_NUM() {
		return AL11_MEDIUM_DEBIT_NUM;
	}
	public void setAL11_MEDIUM_DEBIT_NUM(BigDecimal aL11_MEDIUM_DEBIT_NUM) {
		AL11_MEDIUM_DEBIT_NUM = aL11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAL12_MEDIUM_DEBIT_AMOUNT() {
		return AL12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAL12_MEDIUM_DEBIT_AMOUNT(BigDecimal aL12_MEDIUM_DEBIT_AMOUNT) {
		AL12_MEDIUM_DEBIT_AMOUNT = aL12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAL13_MEDIUM_CREDIT_AMOUNT() {
		return AL13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAL13_MEDIUM_CREDIT_AMOUNT(BigDecimal aL13_MEDIUM_CREDIT_AMOUNT) {
		AL13_MEDIUM_CREDIT_AMOUNT = aL13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAL14_MEDIUM_CREDIT_AMOUNT() {
		return AL14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAL14_MEDIUM_CREDIT_AMOUNT(BigDecimal aL14_MEDIUM_CREDIT_AMOUNT) {
		AL14_MEDIUM_CREDIT_AMOUNT = aL14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAL15_LOW_DEBIT_NUM() {
		return AL15_LOW_DEBIT_NUM;
	}
	public void setAL15_LOW_DEBIT_NUM(BigDecimal aL15_LOW_DEBIT_NUM) {
		AL15_LOW_DEBIT_NUM = aL15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAL16_LOW_DEBIT_AMOUNT() {
		return AL16_LOW_DEBIT_AMOUNT;
	}
	public void setAL16_LOW_DEBIT_AMOUNT(BigDecimal aL16_LOW_DEBIT_AMOUNT) {
		AL16_LOW_DEBIT_AMOUNT = aL16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAL17_LOW_CREDIT_NUM() {
		return AL17_LOW_CREDIT_NUM;
	}
	public void setAL17_LOW_CREDIT_NUM(BigDecimal aL17_LOW_CREDIT_NUM) {
		AL17_LOW_CREDIT_NUM = aL17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAL18_LOW_CREDIT_AMOUNT() {
		return AL18_LOW_CREDIT_AMOUNT;
	}
	public void setAL18_LOW_CREDIT_AMOUNT(BigDecimal aL18_LOW_CREDIT_AMOUNT) {
		AL18_LOW_CREDIT_AMOUNT = aL18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAL19_WALK_DEBIT_NUM() {
		return AL19_WALK_DEBIT_NUM;
	}
	public void setAL19_WALK_DEBIT_NUM(BigDecimal aL19_WALK_DEBIT_NUM) {
		AL19_WALK_DEBIT_NUM = aL19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAL20_WALK_DEBIT_AMOUNT() {
		return AL20_WALK_DEBIT_AMOUNT;
	}
	public void setAL20_WALK_DEBIT_AMOUNT(BigDecimal aL20_WALK_DEBIT_AMOUNT) {
		AL20_WALK_DEBIT_AMOUNT = aL20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAL21_WALK_CREDIT_NUM() {
		return AL21_WALK_CREDIT_NUM;
	}
	public void setAL21_WALK_CREDIT_NUM(BigDecimal aL21_WALK_CREDIT_NUM) {
		AL21_WALK_CREDIT_NUM = aL21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAL22_WALK_CREDIT_AMOUNT() {
		return AL22_WALK_CREDIT_AMOUNT;
	}
	public void setAL22_WALK_CREDIT_AMOUNT(BigDecimal aL22_WALK_CREDIT_AMOUNT) {
		AL22_WALK_CREDIT_AMOUNT = aL22_WALK_CREDIT_AMOUNT;
	}
	public String getAM1_PROD_NAME() {
		return AM1_PROD_NAME;
	}
	public void setAM1_PROD_NAME(String aM1_PROD_NAME) {
		AM1_PROD_NAME = aM1_PROD_NAME;
	}
	public String getAM2_DESC() {
		return AM2_DESC;
	}
	public void setAM2_DESC(String aM2_DESC) {
		AM2_DESC = aM2_DESC;
	}
	public String getAM3_RISK_ASS() {
		return AM3_RISK_ASS;
	}
	public void setAM3_RISK_ASS(String aM3_RISK_ASS) {
		AM3_RISK_ASS = aM3_RISK_ASS;
	}
	public String getAM4_FACE_TO_FACE() {
		return AM4_FACE_TO_FACE;
	}
	public void setAM4_FACE_TO_FACE(String aM4_FACE_TO_FACE) {
		AM4_FACE_TO_FACE = aM4_FACE_TO_FACE;
	}
	public String getAM5_NON_FACE_TO_FACE() {
		return AM5_NON_FACE_TO_FACE;
	}
	public void setAM5_NON_FACE_TO_FACE(String aM5_NON_FACE_TO_FACE) {
		AM5_NON_FACE_TO_FACE = aM5_NON_FACE_TO_FACE;
	}
	public String getAM6_NON() {
		return AM6_NON;
	}
	public void setAM6_NON(String aM6_NON) {
		AM6_NON = aM6_NON;
	}
	public BigDecimal getAM7_HIGH_DEBIT_NUM() {
		return AM7_HIGH_DEBIT_NUM;
	}
	public void setAM7_HIGH_DEBIT_NUM(BigDecimal aM7_HIGH_DEBIT_NUM) {
		AM7_HIGH_DEBIT_NUM = aM7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAM8_HIGH_DEBIT_AMOUNT() {
		return AM8_HIGH_DEBIT_AMOUNT;
	}
	public void setAM8_HIGH_DEBIT_AMOUNT(BigDecimal aM8_HIGH_DEBIT_AMOUNT) {
		AM8_HIGH_DEBIT_AMOUNT = aM8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAM9_HIGH_CREDIT_NUM() {
		return AM9_HIGH_CREDIT_NUM;
	}
	public void setAM9_HIGH_CREDIT_NUM(BigDecimal aM9_HIGH_CREDIT_NUM) {
		AM9_HIGH_CREDIT_NUM = aM9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAM10_HIGH_CREDIT_AMOUNT() {
		return AM10_HIGH_CREDIT_AMOUNT;
	}
	public void setAM10_HIGH_CREDIT_AMOUNT(BigDecimal aM10_HIGH_CREDIT_AMOUNT) {
		AM10_HIGH_CREDIT_AMOUNT = aM10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAM11_MEDIUM_DEBIT_NUM() {
		return AM11_MEDIUM_DEBIT_NUM;
	}
	public void setAM11_MEDIUM_DEBIT_NUM(BigDecimal aM11_MEDIUM_DEBIT_NUM) {
		AM11_MEDIUM_DEBIT_NUM = aM11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAM12_MEDIUM_DEBIT_AMOUNT() {
		return AM12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAM12_MEDIUM_DEBIT_AMOUNT(BigDecimal aM12_MEDIUM_DEBIT_AMOUNT) {
		AM12_MEDIUM_DEBIT_AMOUNT = aM12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAM13_MEDIUM_CREDIT_AMOUNT() {
		return AM13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAM13_MEDIUM_CREDIT_AMOUNT(BigDecimal aM13_MEDIUM_CREDIT_AMOUNT) {
		AM13_MEDIUM_CREDIT_AMOUNT = aM13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAM14_MEDIUM_CREDIT_AMOUNT() {
		return AM14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAM14_MEDIUM_CREDIT_AMOUNT(BigDecimal aM14_MEDIUM_CREDIT_AMOUNT) {
		AM14_MEDIUM_CREDIT_AMOUNT = aM14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAM15_LOW_DEBIT_NUM() {
		return AM15_LOW_DEBIT_NUM;
	}
	public void setAM15_LOW_DEBIT_NUM(BigDecimal aM15_LOW_DEBIT_NUM) {
		AM15_LOW_DEBIT_NUM = aM15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAM16_LOW_DEBIT_AMOUNT() {
		return AM16_LOW_DEBIT_AMOUNT;
	}
	public void setAM16_LOW_DEBIT_AMOUNT(BigDecimal aM16_LOW_DEBIT_AMOUNT) {
		AM16_LOW_DEBIT_AMOUNT = aM16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAM17_LOW_CREDIT_NUM() {
		return AM17_LOW_CREDIT_NUM;
	}
	public void setAM17_LOW_CREDIT_NUM(BigDecimal aM17_LOW_CREDIT_NUM) {
		AM17_LOW_CREDIT_NUM = aM17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAM18_LOW_CREDIT_AMOUNT() {
		return AM18_LOW_CREDIT_AMOUNT;
	}
	public void setAM18_LOW_CREDIT_AMOUNT(BigDecimal aM18_LOW_CREDIT_AMOUNT) {
		AM18_LOW_CREDIT_AMOUNT = aM18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAM19_WALK_DEBIT_NUM() {
		return AM19_WALK_DEBIT_NUM;
	}
	public void setAM19_WALK_DEBIT_NUM(BigDecimal aM19_WALK_DEBIT_NUM) {
		AM19_WALK_DEBIT_NUM = aM19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAM20_WALK_DEBIT_AMOUNT() {
		return AM20_WALK_DEBIT_AMOUNT;
	}
	public void setAM20_WALK_DEBIT_AMOUNT(BigDecimal aM20_WALK_DEBIT_AMOUNT) {
		AM20_WALK_DEBIT_AMOUNT = aM20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAM21_WALK_CREDIT_NUM() {
		return AM21_WALK_CREDIT_NUM;
	}
	public void setAM21_WALK_CREDIT_NUM(BigDecimal aM21_WALK_CREDIT_NUM) {
		AM21_WALK_CREDIT_NUM = aM21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAM22_WALK_CREDIT_AMOUNT() {
		return AM22_WALK_CREDIT_AMOUNT;
	}
	public void setAM22_WALK_CREDIT_AMOUNT(BigDecimal aM22_WALK_CREDIT_AMOUNT) {
		AM22_WALK_CREDIT_AMOUNT = aM22_WALK_CREDIT_AMOUNT;
	}
	public String getAN1_PROD_NAME() {
		return AN1_PROD_NAME;
	}
	public void setAN1_PROD_NAME(String aN1_PROD_NAME) {
		AN1_PROD_NAME = aN1_PROD_NAME;
	}
	public String getAN2_DESC() {
		return AN2_DESC;
	}
	public void setAN2_DESC(String aN2_DESC) {
		AN2_DESC = aN2_DESC;
	}
	public String getAN3_RISK_ASS() {
		return AN3_RISK_ASS;
	}
	public void setAN3_RISK_ASS(String aN3_RISK_ASS) {
		AN3_RISK_ASS = aN3_RISK_ASS;
	}
	public String getAN4_FACE_TO_FACE() {
		return AN4_FACE_TO_FACE;
	}
	public void setAN4_FACE_TO_FACE(String aN4_FACE_TO_FACE) {
		AN4_FACE_TO_FACE = aN4_FACE_TO_FACE;
	}
	public String getAN5_NON_FACE_TO_FACE() {
		return AN5_NON_FACE_TO_FACE;
	}
	public void setAN5_NON_FACE_TO_FACE(String aN5_NON_FACE_TO_FACE) {
		AN5_NON_FACE_TO_FACE = aN5_NON_FACE_TO_FACE;
	}
	public String getAN6_NON() {
		return AN6_NON;
	}
	public void setAN6_NON(String aN6_NON) {
		AN6_NON = aN6_NON;
	}
	public BigDecimal getAN7_HIGH_DEBIT_NUM() {
		return AN7_HIGH_DEBIT_NUM;
	}
	public void setAN7_HIGH_DEBIT_NUM(BigDecimal aN7_HIGH_DEBIT_NUM) {
		AN7_HIGH_DEBIT_NUM = aN7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAN8_HIGH_DEBIT_AMOUNT() {
		return AN8_HIGH_DEBIT_AMOUNT;
	}
	public void setAN8_HIGH_DEBIT_AMOUNT(BigDecimal aN8_HIGH_DEBIT_AMOUNT) {
		AN8_HIGH_DEBIT_AMOUNT = aN8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAN9_HIGH_CREDIT_NUM() {
		return AN9_HIGH_CREDIT_NUM;
	}
	public void setAN9_HIGH_CREDIT_NUM(BigDecimal aN9_HIGH_CREDIT_NUM) {
		AN9_HIGH_CREDIT_NUM = aN9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAN10_HIGH_CREDIT_AMOUNT() {
		return AN10_HIGH_CREDIT_AMOUNT;
	}
	public void setAN10_HIGH_CREDIT_AMOUNT(BigDecimal aN10_HIGH_CREDIT_AMOUNT) {
		AN10_HIGH_CREDIT_AMOUNT = aN10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAN11_MEDIUM_DEBIT_NUM() {
		return AN11_MEDIUM_DEBIT_NUM;
	}
	public void setAN11_MEDIUM_DEBIT_NUM(BigDecimal aN11_MEDIUM_DEBIT_NUM) {
		AN11_MEDIUM_DEBIT_NUM = aN11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAN12_MEDIUM_DEBIT_AMOUNT() {
		return AN12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAN12_MEDIUM_DEBIT_AMOUNT(BigDecimal aN12_MEDIUM_DEBIT_AMOUNT) {
		AN12_MEDIUM_DEBIT_AMOUNT = aN12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAN13_MEDIUM_CREDIT_AMOUNT() {
		return AN13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAN13_MEDIUM_CREDIT_AMOUNT(BigDecimal aN13_MEDIUM_CREDIT_AMOUNT) {
		AN13_MEDIUM_CREDIT_AMOUNT = aN13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAN14_MEDIUM_CREDIT_AMOUNT() {
		return AN14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAN14_MEDIUM_CREDIT_AMOUNT(BigDecimal aN14_MEDIUM_CREDIT_AMOUNT) {
		AN14_MEDIUM_CREDIT_AMOUNT = aN14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAN15_LOW_DEBIT_NUM() {
		return AN15_LOW_DEBIT_NUM;
	}
	public void setAN15_LOW_DEBIT_NUM(BigDecimal aN15_LOW_DEBIT_NUM) {
		AN15_LOW_DEBIT_NUM = aN15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAN16_LOW_DEBIT_AMOUNT() {
		return AN16_LOW_DEBIT_AMOUNT;
	}
	public void setAN16_LOW_DEBIT_AMOUNT(BigDecimal aN16_LOW_DEBIT_AMOUNT) {
		AN16_LOW_DEBIT_AMOUNT = aN16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAN17_LOW_CREDIT_NUM() {
		return AN17_LOW_CREDIT_NUM;
	}
	public void setAN17_LOW_CREDIT_NUM(BigDecimal aN17_LOW_CREDIT_NUM) {
		AN17_LOW_CREDIT_NUM = aN17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAN18_LOW_CREDIT_AMOUNT() {
		return AN18_LOW_CREDIT_AMOUNT;
	}
	public void setAN18_LOW_CREDIT_AMOUNT(BigDecimal aN18_LOW_CREDIT_AMOUNT) {
		AN18_LOW_CREDIT_AMOUNT = aN18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAN19_WALK_DEBIT_NUM() {
		return AN19_WALK_DEBIT_NUM;
	}
	public void setAN19_WALK_DEBIT_NUM(BigDecimal aN19_WALK_DEBIT_NUM) {
		AN19_WALK_DEBIT_NUM = aN19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAN20_WALK_DEBIT_AMOUNT() {
		return AN20_WALK_DEBIT_AMOUNT;
	}
	public void setAN20_WALK_DEBIT_AMOUNT(BigDecimal aN20_WALK_DEBIT_AMOUNT) {
		AN20_WALK_DEBIT_AMOUNT = aN20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAN21_WALK_CREDIT_NUM() {
		return AN21_WALK_CREDIT_NUM;
	}
	public void setAN21_WALK_CREDIT_NUM(BigDecimal aN21_WALK_CREDIT_NUM) {
		AN21_WALK_CREDIT_NUM = aN21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAN22_WALK_CREDIT_AMOUNT() {
		return AN22_WALK_CREDIT_AMOUNT;
	}
	public void setAN22_WALK_CREDIT_AMOUNT(BigDecimal aN22_WALK_CREDIT_AMOUNT) {
		AN22_WALK_CREDIT_AMOUNT = aN22_WALK_CREDIT_AMOUNT;
	}
	public String getAO1_PROD_NAME() {
		return AO1_PROD_NAME;
	}
	public void setAO1_PROD_NAME(String aO1_PROD_NAME) {
		AO1_PROD_NAME = aO1_PROD_NAME;
	}
	public String getAO2_DESC() {
		return AO2_DESC;
	}
	public void setAO2_DESC(String aO2_DESC) {
		AO2_DESC = aO2_DESC;
	}
	public String getAO3_RISK_ASS() {
		return AO3_RISK_ASS;
	}
	public void setAO3_RISK_ASS(String aO3_RISK_ASS) {
		AO3_RISK_ASS = aO3_RISK_ASS;
	}
	public String getAO4_FACE_TO_FACE() {
		return AO4_FACE_TO_FACE;
	}
	public void setAO4_FACE_TO_FACE(String aO4_FACE_TO_FACE) {
		AO4_FACE_TO_FACE = aO4_FACE_TO_FACE;
	}
	public String getAO5_NON_FACE_TO_FACE() {
		return AO5_NON_FACE_TO_FACE;
	}
	public void setAO5_NON_FACE_TO_FACE(String aO5_NON_FACE_TO_FACE) {
		AO5_NON_FACE_TO_FACE = aO5_NON_FACE_TO_FACE;
	}
	public String getAO6_NON() {
		return AO6_NON;
	}
	public void setAO6_NON(String aO6_NON) {
		AO6_NON = aO6_NON;
	}
	public BigDecimal getAO7_HIGH_DEBIT_NUM() {
		return AO7_HIGH_DEBIT_NUM;
	}
	public void setAO7_HIGH_DEBIT_NUM(BigDecimal aO7_HIGH_DEBIT_NUM) {
		AO7_HIGH_DEBIT_NUM = aO7_HIGH_DEBIT_NUM;
	}
	public BigDecimal getAO8_HIGH_DEBIT_AMOUNT() {
		return AO8_HIGH_DEBIT_AMOUNT;
	}
	public void setAO8_HIGH_DEBIT_AMOUNT(BigDecimal aO8_HIGH_DEBIT_AMOUNT) {
		AO8_HIGH_DEBIT_AMOUNT = aO8_HIGH_DEBIT_AMOUNT;
	}
	public BigDecimal getAO9_HIGH_CREDIT_NUM() {
		return AO9_HIGH_CREDIT_NUM;
	}
	public void setAO9_HIGH_CREDIT_NUM(BigDecimal aO9_HIGH_CREDIT_NUM) {
		AO9_HIGH_CREDIT_NUM = aO9_HIGH_CREDIT_NUM;
	}
	public BigDecimal getAO10_HIGH_CREDIT_AMOUNT() {
		return AO10_HIGH_CREDIT_AMOUNT;
	}
	public void setAO10_HIGH_CREDIT_AMOUNT(BigDecimal aO10_HIGH_CREDIT_AMOUNT) {
		AO10_HIGH_CREDIT_AMOUNT = aO10_HIGH_CREDIT_AMOUNT;
	}
	public BigDecimal getAO11_MEDIUM_DEBIT_NUM() {
		return AO11_MEDIUM_DEBIT_NUM;
	}
	public void setAO11_MEDIUM_DEBIT_NUM(BigDecimal aO11_MEDIUM_DEBIT_NUM) {
		AO11_MEDIUM_DEBIT_NUM = aO11_MEDIUM_DEBIT_NUM;
	}
	public BigDecimal getAO12_MEDIUM_DEBIT_AMOUNT() {
		return AO12_MEDIUM_DEBIT_AMOUNT;
	}
	public void setAO12_MEDIUM_DEBIT_AMOUNT(BigDecimal aO12_MEDIUM_DEBIT_AMOUNT) {
		AO12_MEDIUM_DEBIT_AMOUNT = aO12_MEDIUM_DEBIT_AMOUNT;
	}
	public BigDecimal getAO13_MEDIUM_CREDIT_AMOUNT() {
		return AO13_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAO13_MEDIUM_CREDIT_AMOUNT(BigDecimal aO13_MEDIUM_CREDIT_AMOUNT) {
		AO13_MEDIUM_CREDIT_AMOUNT = aO13_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAO14_MEDIUM_CREDIT_AMOUNT() {
		return AO14_MEDIUM_CREDIT_AMOUNT;
	}
	public void setAO14_MEDIUM_CREDIT_AMOUNT(BigDecimal aO14_MEDIUM_CREDIT_AMOUNT) {
		AO14_MEDIUM_CREDIT_AMOUNT = aO14_MEDIUM_CREDIT_AMOUNT;
	}
	public BigDecimal getAO15_LOW_DEBIT_NUM() {
		return AO15_LOW_DEBIT_NUM;
	}
	public void setAO15_LOW_DEBIT_NUM(BigDecimal aO15_LOW_DEBIT_NUM) {
		AO15_LOW_DEBIT_NUM = aO15_LOW_DEBIT_NUM;
	}
	public BigDecimal getAO16_LOW_DEBIT_AMOUNT() {
		return AO16_LOW_DEBIT_AMOUNT;
	}
	public void setAO16_LOW_DEBIT_AMOUNT(BigDecimal aO16_LOW_DEBIT_AMOUNT) {
		AO16_LOW_DEBIT_AMOUNT = aO16_LOW_DEBIT_AMOUNT;
	}
	public BigDecimal getAO17_LOW_CREDIT_NUM() {
		return AO17_LOW_CREDIT_NUM;
	}
	public void setAO17_LOW_CREDIT_NUM(BigDecimal aO17_LOW_CREDIT_NUM) {
		AO17_LOW_CREDIT_NUM = aO17_LOW_CREDIT_NUM;
	}
	public BigDecimal getAO18_LOW_CREDIT_AMOUNT() {
		return AO18_LOW_CREDIT_AMOUNT;
	}
	public void setAO18_LOW_CREDIT_AMOUNT(BigDecimal aO18_LOW_CREDIT_AMOUNT) {
		AO18_LOW_CREDIT_AMOUNT = aO18_LOW_CREDIT_AMOUNT;
	}
	public BigDecimal getAO19_WALK_DEBIT_NUM() {
		return AO19_WALK_DEBIT_NUM;
	}
	public void setAO19_WALK_DEBIT_NUM(BigDecimal aO19_WALK_DEBIT_NUM) {
		AO19_WALK_DEBIT_NUM = aO19_WALK_DEBIT_NUM;
	}
	public BigDecimal getAO20_WALK_DEBIT_AMOUNT() {
		return AO20_WALK_DEBIT_AMOUNT;
	}
	public void setAO20_WALK_DEBIT_AMOUNT(BigDecimal aO20_WALK_DEBIT_AMOUNT) {
		AO20_WALK_DEBIT_AMOUNT = aO20_WALK_DEBIT_AMOUNT;
	}
	public BigDecimal getAO21_WALK_CREDIT_NUM() {
		return AO21_WALK_CREDIT_NUM;
	}
	public void setAO21_WALK_CREDIT_NUM(BigDecimal aO21_WALK_CREDIT_NUM) {
		AO21_WALK_CREDIT_NUM = aO21_WALK_CREDIT_NUM;
	}
	public BigDecimal getAO22_WALK_CREDIT_AMOUNT() {
		return AO22_WALK_CREDIT_AMOUNT;
	}
	public void setAO22_WALK_CREDIT_AMOUNT(BigDecimal aO22_WALK_CREDIT_AMOUNT) {
		AO22_WALK_CREDIT_AMOUNT = aO22_WALK_CREDIT_AMOUNT;
	}
	public String getREPORT_CODE() {
		return REPORT_CODE;
	}
	public void setREPORT_CODE(String rEPORT_CODE) {
		REPORT_CODE = rEPORT_CODE;
	}
	public String getREPORT_NAME() {
		return REPORT_NAME;
	}
	public void setREPORT_NAME(String rEPORT_NAME) {
		REPORT_NAME = rEPORT_NAME;
	}
	public Date getREPORT_DATE() {
		return REPORT_DATE;
	}
	public void setREPORT_DATE(Date rEPORT_DATE) {
		REPORT_DATE = rEPORT_DATE;
	}
	public Date getREPORT_DUE_DATE() {
		return REPORT_DUE_DATE;
	}
	public void setREPORT_DUE_DATE(Date rEPORT_DUE_DATE) {
		REPORT_DUE_DATE = rEPORT_DUE_DATE;
	}
	public Date getREP_SUBMIT_DATE() {
		return REP_SUBMIT_DATE;
	}
	public void setREP_SUBMIT_DATE(Date rEP_SUBMIT_DATE) {
		REP_SUBMIT_DATE = rEP_SUBMIT_DATE;
	}
	public Date getREP_PERIOD_FROM() {
		return REP_PERIOD_FROM;
	}
	public void setREP_PERIOD_FROM(Date rEP_PERIOD_FROM) {
		REP_PERIOD_FROM = rEP_PERIOD_FROM;
	}
	public Date getREP_PERIOD_TO() {
		return REP_PERIOD_TO;
	}
	public void setREP_PERIOD_TO(Date rEP_PERIOD_TO) {
		REP_PERIOD_TO = rEP_PERIOD_TO;
	}
	public String getREP_FREQ() {
		return REP_FREQ;
	}
	public void setREP_FREQ(String rEP_FREQ) {
		REP_FREQ = rEP_FREQ;
	}
	public String getNIL_REPORT_FLG() {
		return NIL_REPORT_FLG;
	}
	public void setNIL_REPORT_FLG(String nIL_REPORT_FLG) {
		NIL_REPORT_FLG = nIL_REPORT_FLG;
	}
	public String getARCH_FLG() {
		return ARCH_FLG;
	}
	public void setARCH_FLG(String aRCH_FLG) {
		ARCH_FLG = aRCH_FLG;
	}
	public T1CurProdServices() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
