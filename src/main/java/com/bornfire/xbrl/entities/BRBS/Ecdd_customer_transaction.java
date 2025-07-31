package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ECDD_CUSTOMER_TRANSACTIONS_PAST_YEAR")
public class Ecdd_customer_transaction {

	private Date	tran_date;
	private String	tran_id;
	private String	tran_type;
	private String	part_tran_type;
	private String	tranaction_indicator;
	private BigDecimal	transaction_amount;
	private String	tran_particular;
	private String	sub_tran_type;
	private String	customer_id;

	
	@Id
	private BigDecimal	bf_srl_no;

	public Date getTran_date() {
		return tran_date;
	}

	public void setTran_date(Date tran_date) {
		this.tran_date = tran_date;
	}

	public String getTran_id() {
		return tran_id;
	}

	public void setTran_id(String tran_id) {
		this.tran_id = tran_id;
	}

	public String getTran_type() {
		return tran_type;
	}

	public void setTran_type(String tran_type) {
		this.tran_type = tran_type;
	}

	public String getPart_tran_type() {
		return part_tran_type;
	}

	public void setPart_tran_type(String part_tran_type) {
		this.part_tran_type = part_tran_type;
	}

	public String getTranaction_indicator() {
		return tranaction_indicator;
	}

	public void setTranaction_indicator(String tranaction_indicator) {
		this.tranaction_indicator = tranaction_indicator;
	}

	public BigDecimal getTransaction_amount() {
		return transaction_amount;
	}

	public void setTransaction_amount(BigDecimal transaction_amount) {
		this.transaction_amount = transaction_amount;
	}

	public String getTran_particular() {
		return tran_particular;
	}

	public void setTran_particular(String tran_particular) {
		this.tran_particular = tran_particular;
	}

	public String getSub_tran_type() {
		return sub_tran_type;
	}

	public void setSub_tran_type(String sub_tran_type) {
		this.sub_tran_type = sub_tran_type;
	}

	public BigDecimal getBf_srl_no() {
		return bf_srl_no;
	}

	public void setBf_srl_no(BigDecimal bf_srl_no) {
		this.bf_srl_no = bf_srl_no;
	}
	
	

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	@Override
	public String toString() {
		return "Ecdd_customer_transaction [tran_date=" + tran_date + ", tran_id=" + tran_id + ", tran_type=" + tran_type
				+ ", part_tran_type=" + part_tran_type + ", tranaction_indicator=" + tranaction_indicator
				+ ", transaction_amount=" + transaction_amount + ", tran_particular=" + tran_particular
				+ ", sub_tran_type=" + sub_tran_type + ", customer_id=" + customer_id + ", bf_srl_no=" + bf_srl_no
				+ "]";
	}

	public Ecdd_customer_transaction(Date tran_date, String tran_id, String tran_type, String part_tran_type,
			String tranaction_indicator, BigDecimal transaction_amount, String tran_particular, String sub_tran_type,
			String customer_id, BigDecimal bf_srl_no) {
		super();
		this.tran_date = tran_date;
		this.tran_id = tran_id;
		this.tran_type = tran_type;
		this.part_tran_type = part_tran_type;
		this.tranaction_indicator = tranaction_indicator;
		this.transaction_amount = transaction_amount;
		this.tran_particular = tran_particular;
		this.sub_tran_type = sub_tran_type;
		this.customer_id = customer_id;
		this.bf_srl_no = bf_srl_no;
	}

	public Ecdd_customer_transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
