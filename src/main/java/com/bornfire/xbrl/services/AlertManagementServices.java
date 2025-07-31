package com.bornfire.xbrl.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.entities.AlertManagementEntity;
import com.bornfire.xbrl.entities.AlertManagementRepository;

@Service
@ConfigurationProperties("output")
@Transactional

public class AlertManagementServices {

	private static final Logger logger = LoggerFactory.getLogger(LoginServices.class);
	@Autowired
	AlertManagementRepository alertrepository;

	@Autowired
	SessionFactory sessionFactory;

	public String addAlert(AlertManagementEntity alertparam, String formmode, String userid) {
		// TODO Auto-generated method stub
		String msg = "";
		Session hs1 = sessionFactory.getCurrentSession();

		BigDecimal Number1 = (BigDecimal) hs1.createNativeQuery("SELECT aml_audit_seq.NEXTVAL AS SRL_NO FROM DUAL")
				.getSingleResult();

		/* try { */

		if (formmode.equals("add")) {

			AlertManagementEntity up = alertparam;
			up.setEntry_user(userid);
			up.setEntry_time(new Date());
			up.setDel_flg("N");
			alertrepository.save(up);

			msg = "User Created Successfully";

		}
		// When the user data modifed and submitted.

		else if (formmode.equals("edit")) {
			AlertManagementEntity up = alertparam;

			up.setModify_user(userid);
			up.setModify_time(new Date());
			up.setMod_flg("Y");
			up.setDel_flg("N");
			alertrepository.save(up);/* } */

			msg = "User Edited Successfully";

		}

		else if (formmode.equals("delete")) {
			AlertManagementEntity up = alertparam;

			up.setDel_flg("Y");
			alertrepository.save(up);

			msg = "User Deleted Successfully";

		}

		return msg;
	}

	public String getSrlNoValue() {
		Session hs = sessionFactory.getCurrentSession();

		DecimalFormat numformate = new DecimalFormat("000");
		BigDecimal billNumber = (BigDecimal) hs.createNativeQuery("SELECT ALERTSEQUENCE_1.NEXTVAL AS SRL_NO FROM DUAL")
				.getSingleResult();
		String serialno = "ALT" + numformate.format(billNumber);
		System.out.println("billno" + serialno);
		return serialno;
	}

	public AlertManagementEntity getSrlNo(String id) {
		/* logger.info(id); */
		if (alertrepository.existsById(id)) {
			System.out.println("getsrlno");
			AlertManagementEntity up = alertrepository.findById(id).get();

			return up;
		} else {
			return new AlertManagementEntity();
		}

	};

	public String deletealert(String inputSrlNo) {
		String msg = "";
		Optional<AlertManagementEntity> user = alertrepository.findById(inputSrlNo);
		AlertManagementEntity reg = user.get();
		reg.setDel_flg("Y");
		alertrepository.save(reg);
		msg = "User Deleted Successfully";
		Session hs1 = sessionFactory.getCurrentSession();

		BigDecimal Number1 = (BigDecimal) hs1.createNativeQuery("SELECT RULESEQUENCE_1.NEXTVAL AS SRL_NO FROM DUAL")
				.getSingleResult();

		return msg;
	}

}