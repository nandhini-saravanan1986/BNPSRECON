package com.bornfire.xbrl.entities.BRBS;


 

import java.math.BigDecimal;

import java.util.Date;

 

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

 

import org.springframework.format.annotation.DateTimeFormat;

 

@Entity
@IdClass(AUD_SERVICES_SL_NO.class)
public class AUD_SERVICES_ENTITY {
    @Id
    private BigDecimal    sl_no;
    private String    entryid_add;
    private String    entry_name_add;
    private String    create_cust_name;
    private String    create_cust_id;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date    date_add;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date    date_edit;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date    date_delete;
    private Date    date_download;
    private BigDecimal    contact_add;
    private String    designation_add;
    private String    remarks_add;
    private String    entryid_edit;
    private String    entry_name_edit;
    private String    edit_cust_name;
    private String    edit_cust_id;

 

    private BigDecimal    contact_edit;
    private String    designation_edit;
    private String    remarks_edit;
    private String    entryid_delete;
    private String    entry_name_delete;
    private String    delete_cust_name;
    private String    delete_cust_id;

 

    
    private BigDecimal    contact_delete;
    private String    designation_delete;
    private String    remarks_delete;
    private String    download_report;
    private String    download_format;
    private String    entryid_download;
    private String    entry_name_download;

    private BigDecimal    contact_download;
    private String    designation_download;
    private String    remarks_download;
    private String    download_cust_name;
    private String    download_cust_id;
    private String    entity_flg;
    private String    modify_flg;
    private String    del_flg;
    private String    VALUE_ADD;
    private String    OLD_VALUE_EDIT;
    private String    NEW_VALUE_EDIT;
    private String    FIELD_NAME_ADD;
    private String    OLD_VALUE_DELETE;
    private String    NEW_VALUE_DELETE;
    private String    FIELD_NAME_EDIT;
    private String    FIELD_NAME_delete;
    private String    Function;
  //  @Temporal(TemporalType.DATE)
   // @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date    audit_date;
    private String    feild_name;
    private String    entry_id;
    private String    entry_name;
    private String    authorizer;
    private String    old_value;
    private String    new_value;
    private String    remarks;
    
    
    

	private String	cust_id_new;
	private String	 cust_id_old    ;
	private String	 cust_name_new    ;
	private String	 cust_name_old    ;
	private String	 cust_type_new  ;
	private String	 cust_type_old  ;
	private String	 cust_rating_new;
	private String	 cust_rating_old  ;
	private String	 acct_no_new  ;
	private String	 acct_no_old ;
	private String	 acct_name_new ;
	private String	 acct_name_old ;
	private String	 tran_type_new ;
	private String	 tran_type_old ;
	private String	 tran_sub_type_new ;
	private String	 tran_sub_type_old ;
	private Date	 tran_date_new ;
	private Date	 tran_date_old ;
	private String	 tran_id_new ;
	private String	 tran_id_old ;
	private BigDecimal	 part_tran_id_new ;
	private BigDecimal	 part_tran_id_old ;
	private String	 part_tran_type_new ;
	private String	 part_tran_type_old ;
	private String	 tran_crncy_new ;
	private String	 tran_crncy_old ;
	private BigDecimal	 tran_amt_new ;
	private BigDecimal	 tran_amt_old ;
	private BigDecimal	 tran_amt_orgin_new ;
	private BigDecimal	 tran_amt_orgin_old ;
	private String	 tran_category_new ;
	private String	 tran_category_old ;


    
    
    
	
    
    
	public String getCust_id_new() {
		return cust_id_new;
	}
	public void setCust_id_new(String cust_id_new) {
		this.cust_id_new = cust_id_new;
	}
	public String getCust_id_old() {
		return cust_id_old;
	}
	public void setCust_id_old(String cust_id_old) {
		this.cust_id_old = cust_id_old;
	}
	public String getCust_name_new() {
		return cust_name_new;
	}
	public void setCust_name_new(String cust_name_new) {
		this.cust_name_new = cust_name_new;
	}
	public String getCust_name_old() {
		return cust_name_old;
	}
	public void setCust_name_old(String cust_name_old) {
		this.cust_name_old = cust_name_old;
	}
	public String getCust_type_new() {
		return cust_type_new;
	}
	public void setCust_type_new(String cust_type_new) {
		this.cust_type_new = cust_type_new;
	}
	public String getCust_type_old() {
		return cust_type_old;
	}
	public void setCust_type_old(String cust_type_old) {
		this.cust_type_old = cust_type_old;
	}
	public String getCust_rating_new() {
		return cust_rating_new;
	}
	public void setCust_rating_new(String cust_rating_new) {
		this.cust_rating_new = cust_rating_new;
	}
	public String getCust_rating_old() {
		return cust_rating_old;
	}
	public void setCust_rating_old(String cust_rating_old) {
		this.cust_rating_old = cust_rating_old;
	}
	public String getAcct_no_new() {
		return acct_no_new;
	}
	public void setAcct_no_new(String acct_no_new) {
		this.acct_no_new = acct_no_new;
	}
	public String getAcct_no_old() {
		return acct_no_old;
	}
	public void setAcct_no_old(String acct_no_old) {
		this.acct_no_old = acct_no_old;
	}
	public String getAcct_name_new() {
		return acct_name_new;
	}
	public void setAcct_name_new(String acct_name_new) {
		this.acct_name_new = acct_name_new;
	}
	public String getAcct_name_old() {
		return acct_name_old;
	}
	public void setAcct_name_old(String acct_name_old) {
		this.acct_name_old = acct_name_old;
	}
	public String getTran_type_new() {
		return tran_type_new;
	}
	public void setTran_type_new(String tran_type_new) {
		this.tran_type_new = tran_type_new;
	}
	public String getTran_type_old() {
		return tran_type_old;
	}
	public void setTran_type_old(String tran_type_old) {
		this.tran_type_old = tran_type_old;
	}
	public String getTran_sub_type_new() {
		return tran_sub_type_new;
	}
	public void setTran_sub_type_new(String tran_sub_type_new) {
		this.tran_sub_type_new = tran_sub_type_new;
	}
	public String getTran_sub_type_old() {
		return tran_sub_type_old;
	}
	public void setTran_sub_type_old(String tran_sub_type_old) {
		this.tran_sub_type_old = tran_sub_type_old;
	}
	public Date getTran_date_new() {
		return tran_date_new;
	}
	public void setTran_date_new(Date tran_date_new) {
		this.tran_date_new = tran_date_new;
	}
	public Date getTran_date_old() {
		return tran_date_old;
	}
	public void setTran_date_old(Date tran_date_old) {
		this.tran_date_old = tran_date_old;
	}
	public String getTran_id_new() {
		return tran_id_new;
	}
	public void setTran_id_new(String tran_id_new) {
		this.tran_id_new = tran_id_new;
	}
	public String getTran_id_old() {
		return tran_id_old;
	}
	public void setTran_id_old(String tran_id_old) {
		this.tran_id_old = tran_id_old;
	}
	public BigDecimal getPart_tran_id_new() {
		return part_tran_id_new;
	}
	public void setPart_tran_id_new(BigDecimal part_tran_id_new) {
		this.part_tran_id_new = part_tran_id_new;
	}
	public BigDecimal getPart_tran_id_old() {
		return part_tran_id_old;
	}
	public void setPart_tran_id_old(BigDecimal part_tran_id_old) {
		this.part_tran_id_old = part_tran_id_old;
	}
	public String getPart_tran_type_new() {
		return part_tran_type_new;
	}
	public void setPart_tran_type_new(String part_tran_type_new) {
		this.part_tran_type_new = part_tran_type_new;
	}
	public String getPart_tran_type_old() {
		return part_tran_type_old;
	}
	public void setPart_tran_type_old(String part_tran_type_old) {
		this.part_tran_type_old = part_tran_type_old;
	}
	public String getTran_crncy_new() {
		return tran_crncy_new;
	}
	public void setTran_crncy_new(String tran_crncy_new) {
		this.tran_crncy_new = tran_crncy_new;
	}
	public String getTran_crncy_old() {
		return tran_crncy_old;
	}
	public void setTran_crncy_old(String tran_crncy_old) {
		this.tran_crncy_old = tran_crncy_old;
	}
	public BigDecimal getTran_amt_new() {
		return tran_amt_new;
	}
	public void setTran_amt_new(BigDecimal tran_amt_new) {
		this.tran_amt_new = tran_amt_new;
	}
	public BigDecimal getTran_amt_old() {
		return tran_amt_old;
	}
	public void setTran_amt_old(BigDecimal tran_amt_old) {
		this.tran_amt_old = tran_amt_old;
	}
	public BigDecimal getTran_amt_orgin_new() {
		return tran_amt_orgin_new;
	}
	public void setTran_amt_orgin_new(BigDecimal tran_amt_orgin_new) {
		this.tran_amt_orgin_new = tran_amt_orgin_new;
	}
	public BigDecimal getTran_amt_orgin_old() {
		return tran_amt_orgin_old;
	}
	public void setTran_amt_orgin_old(BigDecimal tran_amt_orgin_old) {
		this.tran_amt_orgin_old = tran_amt_orgin_old;
	}
	public String getTran_category_new() {
		return tran_category_new;
	}
	public void setTran_category_new(String tran_category_new) {
		this.tran_category_new = tran_category_new;
	}
	public String getTran_category_old() {
		return tran_category_old;
	}
	public void setTran_category_old(String tran_category_old) {
		this.tran_category_old = tran_category_old;
	}
	public String getFunction() {
		return Function;
	}
	public void setFunction(String function) {
		Function = function;
	}
	public Date getAudit_date() {
		return audit_date;
	}
	public void setAudit_date(Date date) {
		this.audit_date = date;
	}
	public String getFeild_name() {
		return feild_name;
	}
	public void setFeild_name(String feild_name) {
		this.feild_name = feild_name;
	}
	public String getEntry_id() {
		return entry_id;
	}
	public void setEntry_id(String entry_id) {
		this.entry_id = entry_id;
	}
	public String getEntry_name() {
		return entry_name;
	}
	public void setEntry_name(String entry_name) {
		this.entry_name = entry_name;
	}
	public String getAuthorizer() {
		return authorizer;
	}
	public void setAuthorizer(String authorizer) {
		this.authorizer = authorizer;
	}
	public String getOld_value() {
		return old_value;
	}
	public void setOld_value(String old_value) {
		this.old_value = old_value;
	}
	public String getNew_value() {
		return new_value;
	}
	public void setNew_value(String new_value) {
		this.new_value = new_value;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public BigDecimal getSl_no() {
        return sl_no;
    }
    public void setSl_no(BigDecimal sl_no) {
        this.sl_no = sl_no;
    }
    public String getEntryid_add() {
        return entryid_add;
    }
    public void setEntryid_add(String entryid_add) {
        this.entryid_add = entryid_add;
    }
    public String getEntry_name_add() {
        return entry_name_add;
    }
    public void setEntry_name_add(String entry_name_add) {
        this.entry_name_add = entry_name_add;
    }
    public String getCreate_cust_name() {
        return create_cust_name;
    }
    public void setCreate_cust_name(String create_cust_name) {
        this.create_cust_name = create_cust_name;
    }
    public String getCreate_cust_id() {
        return create_cust_id;
    }
    public void setCreate_cust_id(String create_cust_id) {
        this.create_cust_id = create_cust_id;
    }
    public Date getDate_add() {
        return date_add;
    }
    public void setDate_add(Date date_add) {
        this.date_add = date_add;
    }
    public Date getDate_edit() {
        return date_edit;
    }
    public void setDate_edit(Date date_edit) {
        this.date_edit = date_edit;
    }
    public Date getDate_delete() {
        return date_delete;
    }
    public void setDate_delete(Date date_delete) {
        this.date_delete = date_delete;
    }
    public Date getDate_download() {
        return date_download;
    }
    public void setDate_download(Date date_download) {
        this.date_download = date_download;
    }
    public BigDecimal getContact_add() {
        return contact_add;
    }
    public void setContact_add(BigDecimal contact_add) {
        this.contact_add = contact_add;
    }
    public String getDesignation_add() {
        return designation_add;
    }
    public void setDesignation_add(String designation_add) {
        this.designation_add = designation_add;
    }
    public String getRemarks_add() {
        return remarks_add;
    }
    public void setRemarks_add(String remarks_add) {
        this.remarks_add = remarks_add;
    }
    public String getEntryid_edit() {
        return entryid_edit;
    }
    public void setEntryid_edit(String entryid_edit) {
        this.entryid_edit = entryid_edit;
    }
    public String getEntry_name_edit() {
        return entry_name_edit;
    }
    public void setEntry_name_edit(String entry_name_edit) {
        this.entry_name_edit = entry_name_edit;
    }
    public String getEdit_cust_name() {
        return edit_cust_name;
    }
    public void setEdit_cust_name(String edit_cust_name) {
        this.edit_cust_name = edit_cust_name;
    }
    public String getEdit_cust_id() {
        return edit_cust_id;
    }
    public void setEdit_cust_id(String edit_cust_id) {
        this.edit_cust_id = edit_cust_id;
    }
    public BigDecimal getContact_edit() {
        return contact_edit;
    }
    public void setContact_edit(BigDecimal contact_edit) {
        this.contact_edit = contact_edit;
    }
    public String getDesignation_edit() {
        return designation_edit;
    }
    public void setDesignation_edit(String designation_edit) {
        this.designation_edit = designation_edit;
    }
    public String getRemarks_edit() {
        return remarks_edit;
    }
    public void setRemarks_edit(String remarks_edit) {
        this.remarks_edit = remarks_edit;
    }
    public String getEntryid_delete() {
        return entryid_delete;
    }
    public void setEntryid_delete(String entryid_delete) {
        this.entryid_delete = entryid_delete;
    }
    public String getEntry_name_delete() {
        return entry_name_delete;
    }
    public void setEntry_name_delete(String entry_name_delete) {
        this.entry_name_delete = entry_name_delete;
    }
    public String getDelete_cust_name() {
        return delete_cust_name;
    }
    public void setDelete_cust_name(String delete_cust_name) {
        this.delete_cust_name = delete_cust_name;
    }
    public String getDelete_cust_id() {
        return delete_cust_id;
    }
    public void setDelete_cust_id(String delete_cust_id) {
        this.delete_cust_id = delete_cust_id;
    }
    public BigDecimal getContact_delete() {
        return contact_delete;
    }
    public void setContact_delete(BigDecimal contact_delete) {
        this.contact_delete = contact_delete;
    }
    public String getDesignation_delete() {
        return designation_delete;
    }
    public void setDesignation_delete(String designation_delete) {
        this.designation_delete = designation_delete;
    }
    public String getRemarks_delete() {
        return remarks_delete;
    }
    public void setRemarks_delete(String remarks_delete) {
        this.remarks_delete = remarks_delete;
    }
    public String getDownload_report() {
        return download_report;
    }
    public void setDownload_report(String download_report) {
        this.download_report = download_report;
    }
    public String getDownload_format() {
        return download_format;
    }
    public void setDownload_format(String download_format) {
        this.download_format = download_format;
    }
    public String getEntryid_download() {
        return entryid_download;
    }
    public void setEntryid_download(String entryid_download) {
        this.entryid_download = entryid_download;
    }
    public String getEntry_name_download() {
        return entry_name_download;
    }
    public void setEntry_name_download(String entry_name_download) {
        this.entry_name_download = entry_name_download;
    }
    public BigDecimal getContact_download() {
        return contact_download;
    }
    public void setContact_download(BigDecimal contact_download) {
        this.contact_download = contact_download;
    }
    public String getDesignation_download() {
        return designation_download;
    }
    public void setDesignation_download(String designation_download) {
        this.designation_download = designation_download;
    }
    public String getRemarks_download() {
        return remarks_download;
    }
    public void setRemarks_download(String remarks_download) {
        this.remarks_download = remarks_download;
    }
    public String getDownload_cust_name() {
        return download_cust_name;
    }
    public void setDownload_cust_name(String download_cust_name) {
        this.download_cust_name = download_cust_name;
    }
    public String getDownload_cust_id() {
        return download_cust_id;
    }
    public void setDownload_cust_id(String download_cust_id) {
        this.download_cust_id = download_cust_id;
    }
    public String getEntity_flg() {
        return entity_flg;
    }
    public void setEntity_flg(String entity_flg) {
        this.entity_flg = entity_flg;
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
    public String getVALUE_ADD() {
        return VALUE_ADD;
    }
    public void setVALUE_ADD(String vALUE_ADD) {
        VALUE_ADD = vALUE_ADD;
    }
    public String getOLD_VALUE_EDIT() {
        return OLD_VALUE_EDIT;
    }
    public void setOLD_VALUE_EDIT(String oLD_VALUE_EDIT) {
        OLD_VALUE_EDIT = oLD_VALUE_EDIT;
    }
    public String getNEW_VALUE_EDIT() {
        return NEW_VALUE_EDIT;
    }
    public void setNEW_VALUE_EDIT(String nEW_VALUE_EDIT) {
        NEW_VALUE_EDIT = nEW_VALUE_EDIT;
    }
    public String getFIELD_NAME_ADD() {
        return FIELD_NAME_ADD;
    }
    public void setFIELD_NAME_ADD(String fIELD_NAME_ADD) {
        FIELD_NAME_ADD = fIELD_NAME_ADD;
    }
    public String getOLD_VALUE_DELETE() {
        return OLD_VALUE_DELETE;
    }
    public void setOLD_VALUE_DELETE(String oLD_VALUE_DELETE) {
        OLD_VALUE_DELETE = oLD_VALUE_DELETE;
    }
    public String getNEW_VALUE_DELETE() {
        return NEW_VALUE_DELETE;
    }
    public void setNEW_VALUE_DELETE(String nEW_VALUE_DELETE) {
        NEW_VALUE_DELETE = nEW_VALUE_DELETE;
    }
    public String getFIELD_NAME_EDIT() {
        return FIELD_NAME_EDIT;
    }
    public void setFIELD_NAME_EDIT(String fIELD_NAME_EDIT) {
        FIELD_NAME_EDIT = fIELD_NAME_EDIT;
    }
    public String getFIELD_NAME_delete() {
        return FIELD_NAME_delete;
    }
    public void setFIELD_NAME_delete(String fIELD_NAME_delete) {
        FIELD_NAME_delete = fIELD_NAME_delete;
    }
    public AUD_SERVICES_ENTITY() {
        super();
        // TODO Auto-generated constructor stub
    }

 

    

}

 




