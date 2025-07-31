package com.bornfire.xbrl.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ARCHIVAL_FACILITY_DATA")
public class RBRfacility_Archival_entity {
	private String operation;
	private String acid;
	private String cust_id;
	private String bank_code;
	@Id
	private String srl_no;
	private String cin;
	private String csno;
	private String product;
	private String fac_id;
	private String fac_class;
	private BigDecimal limit_funded;
	private BigDecimal os_funded;
	private BigDecimal limit_unfunded;
	private BigDecimal limit_total;
	private BigDecimal os_unfunded_before_ccf;
	private BigDecimal os_unfunded_after_ccf;
	private BigDecimal os_total;
	private String country_funds_utilization;
	private String cy;
	private BigDecimal days_past_due;
	private BigDecimal past_due_amt;
	private BigDecimal principal;
	private BigDecimal interest_cap;
	private BigDecimal acc_int;
	private String reserve_line_6;
	private String bullet_payments;
	private BigDecimal num_bullet_payment;
	private BigDecimal num_bullet_payment_received;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date default_date;
	private BigDecimal principal_recovered_default;
	private BigDecimal interest_recovered_default;
	private String syndicated_loan;
	private String bloomberg_ticker_syndicated_loan;
	private BigDecimal num_inst_def;
	private BigDecimal amount_inst_def;
	private String restructured;
	private BigDecimal int_pro_before_restructured;
	private BigDecimal int_pro_after_restructured;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_first_restructured;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date date_last_restructured;
	private BigDecimal num_restructured;
	private BigDecimal principal_restructured;
	private BigDecimal int_profit_capitalized_into_restructured_facility;
	private BigDecimal add_lending_after_restructuring;
	private BigDecimal original_fl_in_yrs;
	private BigDecimal fl_after_restructured;
	private BigDecimal re_maturity;
	private BigDecimal written_off;
	private String written_off_facility;
	private BigDecimal amount_of_written_off_facility;
	private String reserve_line_1;
	private String reserve_line_2;
	private String reserve_line_3;
	private String reserve_line_4;
	private String reserve_line_5;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date report_date;
	private String entry_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date entry_time;
	private String auth_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date auth_time;
	private String modify_user;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date modify_time;
	private String entity_flg;
	private String auth_flg;
	private String modify_flg;
	private String del_flg;
	private String branch_code;

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getAcid() {
		return acid;
	}

	public void setAcid(String acid) {
		this.acid = acid;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getBank_code() {
		return bank_code;
	}

	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}

	public String getSrl_no() {
		return srl_no;
	}

	public void setSrl_no(String srl_no) {
		this.srl_no = srl_no;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getCsno() {
		return csno;
	}

	public void setCsno(String csno) {
		this.csno = csno;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getFac_id() {
		return fac_id;
	}

	public void setFac_id(String fac_id) {
		this.fac_id = fac_id;
	}

	public String getFac_class() {
		return fac_class;
	}

	public void setFac_class(String fac_class) {
		this.fac_class = fac_class;
	}

	public BigDecimal getLimit_funded() {
		return limit_funded;
	}

	public void setLimit_funded(BigDecimal limit_funded) {
		this.limit_funded = limit_funded;
	}

	public BigDecimal getOs_funded() {
		return os_funded;
	}

	public void setOs_funded(BigDecimal os_funded) {
		this.os_funded = os_funded;
	}

	public BigDecimal getLimit_unfunded() {
		return limit_unfunded;
	}

	public void setLimit_unfunded(BigDecimal limit_unfunded) {
		this.limit_unfunded = limit_unfunded;
	}

	public BigDecimal getLimit_total() {
		return limit_total;
	}

	public void setLimit_total(BigDecimal limit_total) {
		this.limit_total = limit_total;
	}

	public BigDecimal getOs_unfunded_before_ccf() {
		return os_unfunded_before_ccf;
	}

	public void setOs_unfunded_before_ccf(BigDecimal os_unfunded_before_ccf) {
		this.os_unfunded_before_ccf = os_unfunded_before_ccf;
	}

	public BigDecimal getOs_unfunded_after_ccf() {
		return os_unfunded_after_ccf;
	}

	public void setOs_unfunded_after_ccf(BigDecimal os_unfunded_after_ccf) {
		this.os_unfunded_after_ccf = os_unfunded_after_ccf;
	}

	public BigDecimal getOs_total() {
		return os_total;
	}

	public void setOs_total(BigDecimal os_total) {
		this.os_total = os_total;
	}

	public String getCountry_funds_utilization() {
		return country_funds_utilization;
	}

	public void setCountry_funds_utilization(String country_funds_utilization) {
		this.country_funds_utilization = country_funds_utilization;
	}

	public String getCy() {
		return cy;
	}

	public void setCy(String cy) {
		this.cy = cy;
	}

	public BigDecimal getDays_past_due() {
		return days_past_due;
	}

	public void setDays_past_due(BigDecimal days_past_due) {
		this.days_past_due = days_past_due;
	}

	public BigDecimal getPast_due_amt() {
		return past_due_amt;
	}

	public void setPast_due_amt(BigDecimal past_due_amt) {
		this.past_due_amt = past_due_amt;
	}

	public BigDecimal getPrincipal() {
		return principal;
	}

	public void setPrincipal(BigDecimal principal) {
		this.principal = principal;
	}

	public BigDecimal getInterest_cap() {
		return interest_cap;
	}

	public void setInterest_cap(BigDecimal interest_cap) {
		this.interest_cap = interest_cap;
	}

	public BigDecimal getAcc_int() {
		return acc_int;
	}

	public void setAcc_int(BigDecimal acc_int) {
		this.acc_int = acc_int;
	}

	public String getReserve_line_6() {
		return reserve_line_6;
	}

	public void setReserve_line_6(String reserve_line_6) {
		this.reserve_line_6 = reserve_line_6;
	}

	public String getBullet_payments() {
		return bullet_payments;
	}

	public void setBullet_payments(String bullet_payments) {
		this.bullet_payments = bullet_payments;
	}

	public BigDecimal getNum_bullet_payment() {
		return num_bullet_payment;
	}

	public void setNum_bullet_payment(BigDecimal num_bullet_payment) {
		this.num_bullet_payment = num_bullet_payment;
	}

	public BigDecimal getNum_bullet_payment_received() {
		return num_bullet_payment_received;
	}

	public void setNum_bullet_payment_received(BigDecimal num_bullet_payment_received) {
		this.num_bullet_payment_received = num_bullet_payment_received;
	}

	public Date getDefault_date() {
		return default_date;
	}

	public void setDefault_date(Date default_date) {
		this.default_date = default_date;
	}

	public BigDecimal getPrincipal_recovered_default() {
		return principal_recovered_default;
	}

	public void setPrincipal_recovered_default(BigDecimal principal_recovered_default) {
		this.principal_recovered_default = principal_recovered_default;
	}

	public BigDecimal getInterest_recovered_default() {
		return interest_recovered_default;
	}

	public void setInterest_recovered_default(BigDecimal interest_recovered_default) {
		this.interest_recovered_default = interest_recovered_default;
	}

	public String getSyndicated_loan() {
		return syndicated_loan;
	}

	public void setSyndicated_loan(String syndicated_loan) {
		this.syndicated_loan = syndicated_loan;
	}

	public String getBloomberg_ticker_syndicated_loan() {
		return bloomberg_ticker_syndicated_loan;
	}

	public void setBloomberg_ticker_syndicated_loan(String bloomberg_ticker_syndicated_loan) {
		this.bloomberg_ticker_syndicated_loan = bloomberg_ticker_syndicated_loan;
	}

	public BigDecimal getNum_inst_def() {
		return num_inst_def;
	}

	public void setNum_inst_def(BigDecimal num_inst_def) {
		this.num_inst_def = num_inst_def;
	}

	public BigDecimal getAmount_inst_def() {
		return amount_inst_def;
	}

	public void setAmount_inst_def(BigDecimal amount_inst_def) {
		this.amount_inst_def = amount_inst_def;
	}

	public String getRestructured() {
		return restructured;
	}

	public void setRestructured(String restructured) {
		this.restructured = restructured;
	}

	public BigDecimal getInt_pro_before_restructured() {
		return int_pro_before_restructured;
	}

	public void setInt_pro_before_restructured(BigDecimal int_pro_before_restructured) {
		this.int_pro_before_restructured = int_pro_before_restructured;
	}

	public BigDecimal getInt_pro_after_restructured() {
		return int_pro_after_restructured;
	}

	public void setInt_pro_after_restructured(BigDecimal int_pro_after_restructured) {
		this.int_pro_after_restructured = int_pro_after_restructured;
	}

	public Date getDate_first_restructured() {
		return date_first_restructured;
	}

	public void setDate_first_restructured(Date date_first_restructured) {
		this.date_first_restructured = date_first_restructured;
	}

	public Date getDate_last_restructured() {
		return date_last_restructured;
	}

	public void setDate_last_restructured(Date date_last_restructured) {
		this.date_last_restructured = date_last_restructured;
	}

	public BigDecimal getNum_restructured() {
		return num_restructured;
	}

	public void setNum_restructured(BigDecimal num_restructured) {
		this.num_restructured = num_restructured;
	}

	public BigDecimal getPrincipal_restructured() {
		return principal_restructured;
	}

	public void setPrincipal_restructured(BigDecimal principal_restructured) {
		this.principal_restructured = principal_restructured;
	}

	public BigDecimal getInt_profit_capitalized_into_restructured_facility() {
		return int_profit_capitalized_into_restructured_facility;
	}

	public void setInt_profit_capitalized_into_restructured_facility(
			BigDecimal int_profit_capitalized_into_restructured_facility) {
		this.int_profit_capitalized_into_restructured_facility = int_profit_capitalized_into_restructured_facility;
	}

	public BigDecimal getAdd_lending_after_restructuring() {
		return add_lending_after_restructuring;
	}

	public void setAdd_lending_after_restructuring(BigDecimal add_lending_after_restructuring) {
		this.add_lending_after_restructuring = add_lending_after_restructuring;
	}

	public BigDecimal getOriginal_fl_in_yrs() {
		return original_fl_in_yrs;
	}

	public void setOriginal_fl_in_yrs(BigDecimal original_fl_in_yrs) {
		this.original_fl_in_yrs = original_fl_in_yrs;
	}

	public BigDecimal getFl_after_restructured() {
		return fl_after_restructured;
	}

	public void setFl_after_restructured(BigDecimal fl_after_restructured) {
		this.fl_after_restructured = fl_after_restructured;
	}

	public BigDecimal getRe_maturity() {
		return re_maturity;
	}

	public void setRe_maturity(BigDecimal re_maturity) {
		this.re_maturity = re_maturity;
	}

	public BigDecimal getWritten_off() {
		return written_off;
	}

	public void setWritten_off(BigDecimal written_off) {
		this.written_off = written_off;
	}

	public String getWritten_off_facility() {
		return written_off_facility;
	}

	public void setWritten_off_facility(String written_off_facility) {
		this.written_off_facility = written_off_facility;
	}

	public BigDecimal getAmount_of_written_off_facility() {
		return amount_of_written_off_facility;
	}

	public void setAmount_of_written_off_facility(BigDecimal amount_of_written_off_facility) {
		this.amount_of_written_off_facility = amount_of_written_off_facility;
	}

	public String getReserve_line_1() {
		return reserve_line_1;
	}

	public void setReserve_line_1(String reserve_line_1) {
		this.reserve_line_1 = reserve_line_1;
	}

	public String getReserve_line_2() {
		return reserve_line_2;
	}

	public void setReserve_line_2(String reserve_line_2) {
		this.reserve_line_2 = reserve_line_2;
	}

	public String getReserve_line_3() {
		return reserve_line_3;
	}

	public void setReserve_line_3(String reserve_line_3) {
		this.reserve_line_3 = reserve_line_3;
	}

	public String getReserve_line_4() {
		return reserve_line_4;
	}

	public void setReserve_line_4(String reserve_line_4) {
		this.reserve_line_4 = reserve_line_4;
	}

	public String getReserve_line_5() {
		return reserve_line_5;
	}

	public void setReserve_line_5(String reserve_line_5) {
		this.reserve_line_5 = reserve_line_5;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public String getEntry_user() {
		return entry_user;
	}

	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}

	public Date getEntry_time() {
		return entry_time;
	}

	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}

	public String getAuth_user() {
		return auth_user;
	}

	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}

	public Date getAuth_time() {
		return auth_time;
	}

	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}

	public String getModify_user() {
		return modify_user;
	}

	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}

	public Date getModify_time() {
		return modify_time;
	}

	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}

	public String getEntity_flg() {
		return entity_flg;
	}

	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}

	public String getAuth_flg() {
		return auth_flg;
	}

	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
	}

	public String getModify_flg() {
		return modify_flg;
	}

	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public String getBranch_code() {
		return branch_code;
	}

	public void setBranch_code(String branch_code) {
		this.branch_code = branch_code;
	}

	public RBRfacility_Archival_entity(String operation, String acid, String cust_id, String bank_code, String srl_no,
			String cin, String csno, String product, String fac_id, String fac_class, BigDecimal limit_funded,
			BigDecimal os_funded, BigDecimal limit_unfunded, BigDecimal limit_total, BigDecimal os_unfunded_before_ccf,
			BigDecimal os_unfunded_after_ccf, BigDecimal os_total, String country_funds_utilization, String cy,
			BigDecimal days_past_due, BigDecimal past_due_amt, BigDecimal principal, BigDecimal interest_cap,
			BigDecimal acc_int, String reserve_line_6, String bullet_payments, BigDecimal num_bullet_payment,
			BigDecimal num_bullet_payment_received, Date default_date, BigDecimal principal_recovered_default,
			BigDecimal interest_recovered_default, String syndicated_loan, String bloomberg_ticker_syndicated_loan,
			BigDecimal num_inst_def, BigDecimal amount_inst_def, String restructured,
			BigDecimal int_pro_before_restructured, BigDecimal int_pro_after_restructured, Date date_first_restructured,
			Date date_last_restructured, BigDecimal num_restructured, BigDecimal principal_restructured,
			BigDecimal int_profit_capitalized_into_restructured_facility, BigDecimal add_lending_after_restructuring,
			BigDecimal original_fl_in_yrs, BigDecimal fl_after_restructured, BigDecimal re_maturity,
			BigDecimal written_off, String written_off_facility, BigDecimal amount_of_written_off_facility,
			String reserve_line_1, String reserve_line_2, String reserve_line_3, String reserve_line_4,
			String reserve_line_5, Date report_date, String entry_user, Date entry_time, String auth_user,
			Date auth_time, String modify_user, Date modify_time, String entity_flg, String auth_flg, String modify_flg,
			String del_flg, String branch_code) {
		super();
		this.operation = operation;
		this.acid = acid;
		this.cust_id = cust_id;
		this.bank_code = bank_code;
		this.srl_no = srl_no;
		this.cin = cin;
		this.csno = csno;
		this.product = product;
		this.fac_id = fac_id;
		this.fac_class = fac_class;
		this.limit_funded = limit_funded;
		this.os_funded = os_funded;
		this.limit_unfunded = limit_unfunded;
		this.limit_total = limit_total;
		this.os_unfunded_before_ccf = os_unfunded_before_ccf;
		this.os_unfunded_after_ccf = os_unfunded_after_ccf;
		this.os_total = os_total;
		this.country_funds_utilization = country_funds_utilization;
		this.cy = cy;
		this.days_past_due = days_past_due;
		this.past_due_amt = past_due_amt;
		this.principal = principal;
		this.interest_cap = interest_cap;
		this.acc_int = acc_int;
		this.reserve_line_6 = reserve_line_6;
		this.bullet_payments = bullet_payments;
		this.num_bullet_payment = num_bullet_payment;
		this.num_bullet_payment_received = num_bullet_payment_received;
		this.default_date = default_date;
		this.principal_recovered_default = principal_recovered_default;
		this.interest_recovered_default = interest_recovered_default;
		this.syndicated_loan = syndicated_loan;
		this.bloomberg_ticker_syndicated_loan = bloomberg_ticker_syndicated_loan;
		this.num_inst_def = num_inst_def;
		this.amount_inst_def = amount_inst_def;
		this.restructured = restructured;
		this.int_pro_before_restructured = int_pro_before_restructured;
		this.int_pro_after_restructured = int_pro_after_restructured;
		this.date_first_restructured = date_first_restructured;
		this.date_last_restructured = date_last_restructured;
		this.num_restructured = num_restructured;
		this.principal_restructured = principal_restructured;
		this.int_profit_capitalized_into_restructured_facility = int_profit_capitalized_into_restructured_facility;
		this.add_lending_after_restructuring = add_lending_after_restructuring;
		this.original_fl_in_yrs = original_fl_in_yrs;
		this.fl_after_restructured = fl_after_restructured;
		this.re_maturity = re_maturity;
		this.written_off = written_off;
		this.written_off_facility = written_off_facility;
		this.amount_of_written_off_facility = amount_of_written_off_facility;
		this.reserve_line_1 = reserve_line_1;
		this.reserve_line_2 = reserve_line_2;
		this.reserve_line_3 = reserve_line_3;
		this.reserve_line_4 = reserve_line_4;
		this.reserve_line_5 = reserve_line_5;
		this.report_date = report_date;
		this.entry_user = entry_user;
		this.entry_time = entry_time;
		this.auth_user = auth_user;
		this.auth_time = auth_time;
		this.modify_user = modify_user;
		this.modify_time = modify_time;
		this.entity_flg = entity_flg;
		this.auth_flg = auth_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.branch_code = branch_code;
	}

	public RBRfacility_Archival_entity(Facitlity_Entity cud) {
		this.operation = cud.getOperation();
		this.acid = cud.getAcid();
		this.cust_id = cud.getCust_id();
		this.bank_code = cud.getBank_code();
		this.srl_no = cud.getSrl_no();
		this.cin = cud.getCin();
		this.csno = cud.getCsno();
		this.product = cud.getProduct();
		this.fac_id = cud.getFac_id();
		this.fac_class = cud.getFac_class();
		this.limit_funded = cud.getLimit_funded();
		this.os_funded = cud.getOs_funded();
		this.limit_unfunded = cud.getLimit_unfunded();
		this.limit_total = cud.getLimit_total();
		this.os_unfunded_before_ccf = cud.getOs_unfunded_before_ccf();
		this.os_unfunded_after_ccf = cud.getOs_unfunded_after_ccf();
		this.os_total = cud.getOs_total();
		this.country_funds_utilization = cud.getCountry_funds_utilization();
		this.cy = cud.getCy();
		this.days_past_due = cud.getDays_past_due();
		this.past_due_amt = cud.getPast_due_amt();
		this.principal = cud.getPrincipal();
		this.interest_cap = cud.getInterest_cap();
		this.acc_int = cud.getAcc_int();
		this.reserve_line_6 = cud.getReserve_line_6();
		this.bullet_payments = cud.getBullet_payments();
		this.num_bullet_payment = cud.getNum_bullet_payment();
		this.num_bullet_payment_received = cud.getNum_bullet_payment_received();
		this.default_date = cud.getDefault_date();
		this.principal_recovered_default = cud.getPrincipal_recovered_default();
		this.interest_recovered_default = cud.getInterest_recovered_default();
		this.syndicated_loan = cud.getSyndicated_loan();
		this.bloomberg_ticker_syndicated_loan = cud.getBloomberg_ticker_syndicated_loan();
		this.num_inst_def = cud.getNum_inst_def();
		this.amount_inst_def = cud.getAmount_inst_def();
		this.restructured = cud.getRestructured();
		this.int_pro_before_restructured = cud.getInt_pro_before_restructured();
		this.int_pro_after_restructured = cud.getInt_pro_after_restructured();
		this.date_first_restructured = cud.getDate_first_restructured();
		this.date_last_restructured = cud.getDate_last_restructured();
		this.num_restructured = cud.getNum_restructured();
		this.principal_restructured = cud.getPrincipal_restructured();
		this.int_profit_capitalized_into_restructured_facility = cud
				.getInt_profit_capitalized_into_restructured_facility();
		this.add_lending_after_restructuring = cud.getAdd_lending_after_restructuring();
		this.original_fl_in_yrs = cud.getOriginal_fl_in_yrs();
		this.fl_after_restructured = cud.getFl_after_restructured();
		this.re_maturity = cud.getRe_maturity();
		this.written_off = cud.getWritten_off();
		this.written_off_facility = cud.getWritten_off_facility();
		this.amount_of_written_off_facility = cud.getAmount_of_written_off_facility();
		this.reserve_line_1 = cud.getReserve_line_1();
		this.reserve_line_2 = cud.getReserve_line_2();
		this.reserve_line_3 = cud.getReserve_line_3();
		this.reserve_line_4 = cud.getReserve_line_4();
		this.reserve_line_5 = cud.getReserve_line_5();
		this.report_date = cud.getReport_date();
		this.entry_user = cud.getEntry_user();
		this.entry_time = cud.getEntry_time();
		this.auth_user = cud.getAuth_user();
		this.auth_time = cud.getAuth_time();
		this.modify_user = cud.getModify_user();
		this.modify_time = cud.getModify_time();
		this.entity_flg = cud.getEntity_flg();
		this.auth_flg = cud.getAuth_flg();
		this.modify_flg = cud.getModify_flg();
		this.del_flg = cud.getDel_flg();
		this.branch_code = cud.getBranch_code();
	}

	public RBRfacility_Archival_entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
