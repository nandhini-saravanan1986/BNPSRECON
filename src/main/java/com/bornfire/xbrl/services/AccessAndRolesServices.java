package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bornfire.xbrl.entities.AccessAndRoles;
import com.bornfire.xbrl.entities.AccessandRolesRepository;


@Service
@ConfigurationProperties("output")
@Transactional
public class AccessAndRolesServices {

	@Autowired
	AccessandRolesRepository accessandrolesrepository;

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<AccessAndRoles> gettingaccessDetails(String roleid) {

		List<AccessAndRoles> list = (List<AccessAndRoles>) sessionFactory.getCurrentSession()
				.createQuery("from AccessAndRoles where role_id ='" + roleid + "'").getResultList();
		System.out.print("df" + list);
		return list;

	}

	public String addPARAMETER(AccessAndRoles alertparam, String formmode,
			String adminValue, String BRF_ReportsValue,
			String Basel_ReportsValue, String ArchivalValue, String Audit_InquiriesValue, String RBR_ReportsValue,String VAT_LedgerValue,
			String Invoice_DataValue,String ReconciliationValue,String finalString,
			String USERID) {

		String msg = "";

		if (formmode.equals("add")) {
			AccessAndRoles up = alertparam;
			up.setDel_flg("N");
			up.setModify_flg("N");
			up.setEntity_flg("N");
			up.setAdmin(adminValue);
			up.setEntry_user(USERID);
			up.setEntry_time(new Date());
			up.setAuditInquiries(Audit_InquiriesValue);
			up.setBrfReports(BRF_ReportsValue);
			up.setBaselReports(Basel_ReportsValue);
			up.setArchivals(ArchivalValue);
			up.setRbrReports(RBR_ReportsValue);
			up.setVatLedger(VAT_LedgerValue);
			up.setInvoiceData(Invoice_DataValue);
			up.setReconciliation(ReconciliationValue);
			up.setMenulist(finalString);
			
			accessandrolesrepository.save(up);
			msg = "Role Created Successfully";
			
		} else if (formmode.equals("edit")) {
			AccessAndRoles up = alertparam;
			Optional<AccessAndRoles> user = accessandrolesrepository.findById(alertparam.getRole_id());
			AccessAndRoles user1 = user.get();
			up.setAdmin(adminValue);
			if (!finalString.equals("")) {
				up.setMenulist(finalString);
			} else {
				up.setMenulist(user.get().getMenulist());
			}
			up.setDel_flg("N");
			up.setModify_flg("Y");
			up.setEntity_flg("N");
			up.setEntry_user(user1.getEntry_user());
			up.setEntry_time(user1.getEntry_time());
			up.setModify_user(USERID);
			up.setModify_time(new Date());
			up.setReconciliation(ReconciliationValue);
			accessandrolesrepository.save(up);
			msg = "Role Edited Successfully";
		} else if (formmode.equals("delete")) {
			Optional<AccessAndRoles> user = accessandrolesrepository.findById(alertparam.getRole_id());
			AccessAndRoles accessRole = user.get();
			accessRole.setDel_flg("Y");
			accessRole.setEntity_flg("N");
			accessandrolesrepository.save(accessRole);
			msg = "Role Deleted Successfully";
		} else if (formmode.equals("verify")) {
			Optional<AccessAndRoles> user = accessandrolesrepository.findById(alertparam.getRole_id());
			AccessAndRoles user1 = user.get();
			user1.setDel_flg("N");
			user1.setModify_flg("N");
			user1.setEntity_flg("Y");
			user1.setAuth_user(USERID);
			user1.setAuth_time(new Date());
			accessandrolesrepository.save(user1);
			msg = "Role Verified Successfully";
		}
		return msg;
	}

	public AccessAndRoles getRoleId(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query<AccessAndRoles> query = session
				.createQuery(" from AccessAndRoles where role_id=?1 and NVL(DEL_FLG,1) <> 'Y'", AccessAndRoles.class);
		query.setParameter(1, id);
		List<AccessAndRoles> result = query.getResultList();
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return new AccessAndRoles();
		}

	}

	public AccessAndRoles getRoleMenu(String id) {
		Session session = sessionFactory.getCurrentSession();
		Query<AccessAndRoles> query = session.createQuery(" from AccessAndRoles where role_id=?1", AccessAndRoles.class);
		query.setParameter(1, id);
		List<AccessAndRoles> result = query.getResultList();
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return new AccessAndRoles();
		}

	}

	public String deleteRole(String userid) {
		Session hs = sessionFactory.getCurrentSession();
		Query qr;
		qr = hs.createQuery("select count(*) from UserProfile where role_id= ?1");
		qr.setParameter(1, userid);
		long count = (long) qr.getSingleResult();
		String msg = "";
		if (count == 0) {
			Optional<AccessAndRoles> user = accessandrolesrepository.findById(userid);
			AccessAndRoles reg = user.get();
			reg.setDel_flg("Y");
			accessandrolesrepository.save(reg);
			msg = "Role Deleted Successfully";
		} else {
			msg = "This role has been assigned to an User.Cannot Delete ";
		}
		return msg;
	}
}