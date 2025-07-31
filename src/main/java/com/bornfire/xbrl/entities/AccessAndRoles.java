package com.bornfire.xbrl.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCES_ROLES_TABLE")
public class AccessAndRoles {

	@Id
	private String	role_id;
	private String	role_desc;
	private String	permissions;
	private String	work_class;
	private String	domain_id;
	private String	admin;
	private String	entity_flg;
	private String	auth_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	menulist;
	private String	entry_user;
	private String	modify_user;
	private String	auth_user;
	private Date	entry_time;
	private Date	modify_time;
	private Date	auth_time;
	private String audit_operations;
	private String ips_operations;
	private String monitoring;
	private String myt_registration;
	@Column(name = "BRF_Reports")
	private String brfReports;

	@Column(name = "Basel_Reports")
	private String baselReports;

	@Column(name = "Archivals")
	private String archivals;

	@Column(name = "Audit_Inquiries")
	private String auditInquiries;

	@Column(name = "RBR_Reports")
	private String rbrReports;

	@Column(name = "VAT_Ledger")
	private String vatLedger;

	@Column(name = "Invoice_Data")
	private String invoiceData;

	@Column(name = "Reconciliation")
	private String reconciliation;

	
	public String getRole_id() {
		return role_id;
	}
	public String getRole_desc() {
		return role_desc;
	}
	public String getPermissions() {
		return permissions;
	}
	public String getWork_class() {
		return work_class;
	}
	public String getDomain_id() {
		return domain_id;
	}
	public String getAdmin() {
		return admin;
	}
	public String getEntity_flg() {
		return entity_flg;
	}
	public String getAuth_flg() {
		return auth_flg;
	}
	public String getModify_flg() {
		return modify_flg;
	}
	public String getDel_flg() {
		return del_flg;
	}
	public String getMenulist() {
		return menulist;
	}
	public String getEntry_user() {
		return entry_user;
	}
	public String getModify_user() {
		return modify_user;
	}
	public String getAuth_user() {
		return auth_user;
	}
	public Date getEntry_time() {
		return entry_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public Date getAuth_time() {
		return auth_time;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public void setWork_class(String work_class) {
		this.work_class = work_class;
	}
	public void setDomain_id(String domain_id) {
		this.domain_id = domain_id;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public void setEntity_flg(String entity_flg) {
		this.entity_flg = entity_flg;
	}
	public void setAuth_flg(String auth_flg) {
		this.auth_flg = auth_flg;
	}
	public void setModify_flg(String modify_flg) {
		this.modify_flg = modify_flg;
	}
	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}
	public void setMenulist(String menulist) {
		this.menulist = menulist;
	}
	public void setEntry_user(String entry_user) {
		this.entry_user = entry_user;
	}
	public void setModify_user(String modify_user) {
		this.modify_user = modify_user;
	}
	public void setAuth_user(String auth_user) {
		this.auth_user = auth_user;
	}
	public void setEntry_time(Date entry_time) {
		this.entry_time = entry_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	public void setAuth_time(Date auth_time) {
		this.auth_time = auth_time;
	}
	
	public String getAudit_operations() {
		return audit_operations;
	}
	public String getIps_operations() {
		return ips_operations;
	}
	public String getMonitoring() {
		return monitoring;
	}
	public String getMyt_registration() {
		return myt_registration;
	}
	public void setAudit_operations(String audit_operations) {
		this.audit_operations = audit_operations;
	}
	public void setIps_operations(String ips_operations) {
		this.ips_operations = ips_operations;
	}
	public void setMonitoring(String monitoring) {
		this.monitoring = monitoring;
	}
	public void setMyt_registration(String myt_registration) {
		this.myt_registration = myt_registration;
	}
	
	
	
	public String getBrfReports() {
		return brfReports;
	}
	public void setBrfReports(String brfReports) {
		this.brfReports = brfReports;
	}
	public String getBaselReports() {
		return baselReports;
	}
	public void setBaselReports(String baselReports) {
		this.baselReports = baselReports;
	}
	public String getArchivals() {
		return archivals;
	}
	public void setArchivals(String archivals) {
		this.archivals = archivals;
	}
	public String getAuditInquiries() {
		return auditInquiries;
	}
	public void setAuditInquiries(String auditInquiries) {
		this.auditInquiries = auditInquiries;
	}
	public String getRbrReports() {
		return rbrReports;
	}
	public void setRbrReports(String rbrReports) {
		this.rbrReports = rbrReports;
	}
	public String getVatLedger() {
		return vatLedger;
	}
	public void setVatLedger(String vatLedger) {
		this.vatLedger = vatLedger;
	}
	public String getInvoiceData() {
		return invoiceData;
	}
	public void setInvoiceData(String invoiceData) {
		this.invoiceData = invoiceData;
	}
	
	
	
	
	
	public String getReconciliation() {
		return reconciliation;
	}
	public void setReconciliation(String reconciliation) {
		this.reconciliation = reconciliation;
	}
	public AccessAndRoles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public AccessAndRoles(String role_id, String role_desc, String permissions, String work_class, String domain_id,
			String admin, String entity_flg, String auth_flg, String modify_flg, String del_flg, String menulist,
			String entry_user, String modify_user, String auth_user, Date entry_time, Date modify_time, Date auth_time,
			String audit_operations, String ips_operations, String monitoring, String myt_registration,
			String brfReports, String baselReports, String archivals, String auditInquiries, String rbrReports,
			String vatLedger, String invoiceData, String reconciliation) {
		super();
		this.role_id = role_id;
		this.role_desc = role_desc;
		this.permissions = permissions;
		this.work_class = work_class;
		this.domain_id = domain_id;
		this.admin = admin;
		this.entity_flg = entity_flg;
		this.auth_flg = auth_flg;
		this.modify_flg = modify_flg;
		this.del_flg = del_flg;
		this.menulist = menulist;
		this.entry_user = entry_user;
		this.modify_user = modify_user;
		this.auth_user = auth_user;
		this.entry_time = entry_time;
		this.modify_time = modify_time;
		this.auth_time = auth_time;
		this.audit_operations = audit_operations;
		this.ips_operations = ips_operations;
		this.monitoring = monitoring;
		this.myt_registration = myt_registration;
		this.brfReports = brfReports;
		this.baselReports = baselReports;
		this.archivals = archivals;
		this.auditInquiries = auditInquiries;
		this.rbrReports = rbrReports;
		this.vatLedger = vatLedger;
		this.invoiceData = invoiceData;
		this.reconciliation = reconciliation;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((audit_operations == null) ? 0 : audit_operations.hashCode());
		result = prime * result + ((auth_flg == null) ? 0 : auth_flg.hashCode());
		result = prime * result + ((auth_time == null) ? 0 : auth_time.hashCode());
		result = prime * result + ((auth_user == null) ? 0 : auth_user.hashCode());
		result = prime * result + ((del_flg == null) ? 0 : del_flg.hashCode());
		result = prime * result + ((domain_id == null) ? 0 : domain_id.hashCode());
		result = prime * result + ((entity_flg == null) ? 0 : entity_flg.hashCode());
		result = prime * result + ((entry_time == null) ? 0 : entry_time.hashCode());
		result = prime * result + ((entry_user == null) ? 0 : entry_user.hashCode());
		result = prime * result + ((ips_operations == null) ? 0 : ips_operations.hashCode());
		result = prime * result + ((menulist == null) ? 0 : menulist.hashCode());
		result = prime * result + ((modify_flg == null) ? 0 : modify_flg.hashCode());
		result = prime * result + ((modify_time == null) ? 0 : modify_time.hashCode());
		result = prime * result + ((modify_user == null) ? 0 : modify_user.hashCode());
		result = prime * result + ((monitoring == null) ? 0 : monitoring.hashCode());
		result = prime * result + ((myt_registration == null) ? 0 : myt_registration.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((role_desc == null) ? 0 : role_desc.hashCode());
		result = prime * result + ((role_id == null) ? 0 : role_id.hashCode());
		result = prime * result + ((work_class == null) ? 0 : work_class.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccessAndRoles other = (AccessAndRoles) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (audit_operations == null) {
			if (other.audit_operations != null)
				return false;
		} else if (!audit_operations.equals(other.audit_operations))
			return false;
		if (auth_flg == null) {
			if (other.auth_flg != null)
				return false;
		} else if (!auth_flg.equals(other.auth_flg))
			return false;
		if (auth_time == null) {
			if (other.auth_time != null)
				return false;
		} else if (!auth_time.equals(other.auth_time))
			return false;
		if (auth_user == null) {
			if (other.auth_user != null)
				return false;
		} else if (!auth_user.equals(other.auth_user))
			return false;
		if (del_flg == null) {
			if (other.del_flg != null)
				return false;
		} else if (!del_flg.equals(other.del_flg))
			return false;
		if (domain_id == null) {
			if (other.domain_id != null)
				return false;
		} else if (!domain_id.equals(other.domain_id))
			return false;
		if (entity_flg == null) {
			if (other.entity_flg != null)
				return false;
		} else if (!entity_flg.equals(other.entity_flg))
			return false;
		if (entry_time == null) {
			if (other.entry_time != null)
				return false;
		} else if (!entry_time.equals(other.entry_time))
			return false;
		if (entry_user == null) {
			if (other.entry_user != null)
				return false;
		} else if (!entry_user.equals(other.entry_user))
			return false;
		if (ips_operations == null) {
			if (other.ips_operations != null)
				return false;
		} else if (!ips_operations.equals(other.ips_operations))
			return false;
		if (menulist == null) {
			if (other.menulist != null)
				return false;
		} else if (!menulist.equals(other.menulist))
			return false;
		if (modify_flg == null) {
			if (other.modify_flg != null)
				return false;
		} else if (!modify_flg.equals(other.modify_flg))
			return false;
		if (modify_time == null) {
			if (other.modify_time != null)
				return false;
		} else if (!modify_time.equals(other.modify_time))
			return false;
		if (modify_user == null) {
			if (other.modify_user != null)
				return false;
		} else if (!modify_user.equals(other.modify_user))
			return false;
		if (monitoring == null) {
			if (other.monitoring != null)
				return false;
		} else if (!monitoring.equals(other.monitoring))
			return false;
		if (myt_registration == null) {
			if (other.myt_registration != null)
				return false;
		} else if (!myt_registration.equals(other.myt_registration))
			return false;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		if (role_desc == null) {
			if (other.role_desc != null)
				return false;
		} else if (!role_desc.equals(other.role_desc))
			return false;
		if (role_id == null) {
			if (other.role_id != null)
				return false;
		} else if (!role_id.equals(other.role_id))
			return false;
		if (work_class == null) {
			if (other.work_class != null)
				return false;
		} else if (!work_class.equals(other.work_class))
			return false;
		return true;
	}
	
	
	
	
	
}

