
package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.bornfire.xbrl.entities.UserAuditRepo;
import com.bornfire.xbrl.entities.XBRLAudit;
import com.bornfire.xbrl.entities.XBRLReportsMaster;
import com.bornfire.xbrl.entities.XBRLReportsMasterRep;
import com.bornfire.xbrl.entities.BNPSRECON.AuditServicesEntity;
import com.bornfire.xbrl.entities.BNPSRECON.AuditServicesRep;
import com.bornfire.xbrl.entities.BNPSRECON.UserAuditLevel_Entity;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

@Service
@Transactional
@ConfigurationProperties("output")
public class ReportServices {

	private static final Logger logger = LoggerFactory.getLogger(ReportServices.class);

	private static final Object TRANMASTERDETAILPage = null;

//	private static final String  = null;

	/*
	 * @Autowired BRF2_MAPPING_REPO brf2_MAPPING_REPO;
	 */

	@NotNull
	private String exportpath;

	@Autowired
	AuditServicesRep AuditServicesRep;

	@Autowired
	XBRLReportsMasterRep xbrlReportsMasterRep;

	@Autowired
	DataSource srcdataSource;

	@Autowired
	Environment env;

	@Autowired

	SessionFactory sessionFactory1;

	@Autowired
	static

	SessionFactory sessionFactory;

	@Autowired
	private UserAuditRepo userAuditRepo;

	public Iterable<XBRLReportsMaster> getReportsList(String domainid) {
		logger.info("Getting Report list");

		List<String> domains = new ArrayList<String>();
		domains = Arrays.asList(domainid.split(","));

		return xbrlReportsMasterRep.getReportList(domains);

	}

	public Iterable<XBRLReportsMaster> getArchReportsList(String domainid) {
		logger.info("Getting Report list");

		List<String> domains = new ArrayList<String>();
		domains = Arrays.asList(domainid.split(","));

		return xbrlReportsMasterRep.getArchReportList(domains);

	}

	public Iterable<XBRLReportsMaster> getReportsMaster() {
		logger.info("Getting Report Master");

		return xbrlReportsMasterRep.findAll();

	}

	public String updateValidity(String reportId, String valid, String userid) {

		String msg = "";
		try {
			xbrlReportsMasterRep.updateValidity(reportId, valid, userid);
			msg = "success";
		} catch (Exception e) {
			msg = "Error Occured. Please contact Administrator";
			e.printStackTrace();
		}

		return msg;

	}

	public List<ReportTitle> getDashBoardRepList(String domainid) {

		List<String> domains = new ArrayList<String>();
		domains = Arrays.asList(domainid.split(","));

		Session hs = sessionFactory1.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Object[]> reportList = hs.createNativeQuery(/*
															 * "select distinct a.parent_report_id, b.report_name, a.report_frequency, a.next_report_date, b.DOMAIN_ID, "
															 * +
															 * "case when next_report_date>sysdate then 'Y' else 'N' end as completed_flg  from report_master_tb a, xbrl_report_master_tb b "
															 * + "where a.PARENT_REPORT_ID = b.REPORT_ID " +
															 * "and b.report_validity='Y' and b.domain_id in ?1 "
															 */
				"select rpt_code,rpt_description,remarks_1,remarks_2, remarks_5,remarks_3"
						+ " from RR_RPT_MAST where rpt_status='ACTIVE' and del_flg<>'Y' and entity_flg='Y' and remarks_5 in ?1 ")
				.setParameter(1, domains).getResultList();

		List<ReportTitle> fu = new ArrayList<ReportTitle>();

		for (Object[] a : reportList) {

			String repId = (String) a[0];
			String repName = (String) a[1];
			String reportFreq = (String) a[2];
			Date reportDate = (Date) a[3];
			String domainId = (String) a[4];
			Character completedFlg = (Character) a[5];

			fu.add(new ReportTitle(repName, repId, reportDate, domainId, completedFlg, reportFreq));

		}

		return fu;

	};

	@SuppressWarnings("unchecked")
	public List<FileUpload> getFileUploadList() {
		logger.info("Getting Report lists");

		Session hs = sessionFactory1.getCurrentSession();

		List<Object[]> uploadList = hs.createNativeQuery(
				" select dpnd_report_id, report_name, report_frequency, count(*) as file_count,file_name from file_master_tb "
						+ " group by dpnd_report_id, report_name, report_frequency,file_name "
						+ " order by dpnd_report_id")
				.getResultList();

		List<FileUpload> fu = new ArrayList<FileUpload>();

		for (Object[] a : uploadList) {

			String repId = (String) a[0];
			String repName = (String) a[1];
			String reportFreq = (String) a[2];
			String fileCount = a[3].toString();
			String file_name = a[4].toString();

			fu.add(new FileUpload(repId, repName, reportFreq, fileCount, file_name));

		}

		return fu;
	}

	@SuppressWarnings("unchecked")
	public List<FileUpload> getFileUploadListCR_RBS() {
		logger.info("Getting Report list");

		Session hs = sessionFactory1.getCurrentSession();

		List<Object[]> uploadList = hs.createNativeQuery(
				" select dpnd_report_id, report_name, report_frequency, count(*) as file_count from file_master_tb_rbs, WHERE report_name ='CR_RBS_REPORTS' "
						+ " group by dpnd_report_id, report_name, report_frequency " + " order by dpnd_report_id")
				.getResultList();

		List<FileUpload> fu = new ArrayList<FileUpload>();

		for (Object[] a : uploadList) {

			String repId = (String) a[0];
			String repName = (String) a[1];
			String reportFreq = (String) a[2];
			String fileCount = a[3].toString();

			fu.add(new FileUpload(repId, repName, reportFreq, fileCount));

		}

		return fu;
	}

	@SuppressWarnings("unchecked")
	public List<ReportTitle> getReportName(String reportid) {

		logger.info("Getting Report Name :" + reportid);

		Session hs = sessionFactory1.getCurrentSession();
		List<Object[]> reportName = hs.createNativeQuery(
				"select distinct a.report_id, a.report_name from report_master_tb a where a.parent_report_id=?1 order by a.report_id")
				.setParameter(1, reportid).getResultList();

		List<ReportTitle> title = new ArrayList<ReportTitle>();

		for (Object[] a : reportName) {

			String repId = (String) a[0];
			String repName = (String) a[1];

			title.add(new ReportTitle(repName, repId));

		}

		return title;

	}

	public String getParentName(String reportid) {

		logger.info("Getting Report Name :" + reportid);

		String title = xbrlReportsMasterRep.getReportName(reportid);

		title = reportid + "-" + title;

		return title;

	}

	public String getExportpath() {
		return exportpath;
	}

	public void setExportpath(String exportpath) {
		this.exportpath = exportpath;
	}

	

	public List<String> getDomainList() {

		return xbrlReportsMasterRep.getDomainList();
	}

	public class ReportTitle {

		String reportName;
		String reportId;
		Date report_date;
		String domain;
		Character completedFlg;
		String frequency;

		public String getReportName() {
			return reportName;
		}

		public void setReportName(String reportName) {
			this.reportName = reportName;
		}

		public String getReportId() {
			return reportId;
		}

		public void setReportId(String reportId) {
			this.reportId = reportId;
		}

		public Date getReport_date() {
			return report_date;
		}

		public void setReport_date(Date report_date) {
			this.report_date = report_date;
		}

		public String getDomain() {
			return domain;
		}

		public void setDomain(String domain) {
			this.domain = domain;
		}

		public Character getCompletedFlg() {
			return completedFlg;
		}

		public void setCompletedFlg(Character completedFlg) {
			this.completedFlg = completedFlg;
		}

		public String getFrequency() {
			return frequency;
		}

		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}

		public ReportTitle(String reportName, String reportId) {
			super();
			this.reportName = reportName;
			this.reportId = reportId;
		}

		public ReportTitle(String reportName, String reportId, Date reportDate, String domain, Character completedFlg,
				String frequency) {
			super();
			this.reportName = reportName;
			this.reportId = reportId;
			this.report_date = reportDate;
			this.domain = domain;
			this.completedFlg = completedFlg;
			this.frequency = frequency;
		}

	}

	class FileUpload {

		private String dpnd_report_id;
		private String report_name;
		private String report_frequency;
		private String file_count;
		private String file_name;

		public String getDpnd_report_id() {
			return dpnd_report_id;
		}

		public void setDpnd_report_id(String dpnd_report_id) {
			this.dpnd_report_id = dpnd_report_id;
		}

		public String getReport_name() {
			return report_name;
		}

		public void setReport_name(String report_name) {
			this.report_name = report_name;
		}

		public String getReport_frequency() {
			return report_frequency;
		}

		public void setReport_frequency(String report_frequency) {
			this.report_frequency = report_frequency;
		}

		public String getFile_count() {
			return file_count;
		}

		public void setFile_count(String file_count) {
			this.file_count = file_count;
		}

		public String getFile_name() {
			return file_name;
		}

		public void setFile_name(String file_name) {
			this.file_name = file_name;
		}

		public FileUpload(String dpnd_report_id, String report_name, String report_frequency, String file_count,
				String file_name) {
			super();
			this.dpnd_report_id = dpnd_report_id;
			this.report_name = report_name;
			this.report_frequency = report_frequency;
			this.file_count = file_count;
			this.file_name = file_name;
		}

		public FileUpload(String dpnd_report_id, String report_name, String report_frequency, String file_count) {
			super();
			this.dpnd_report_id = dpnd_report_id;
			this.report_name = report_name;
			this.report_frequency = report_frequency;
			this.file_count = file_count;

		}

	}

	public File getAuditLogFile(Date fromdate, Date todate) {

		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		String path = exportpath;
		String fileName = "AUDIT_LOGS_" + dateFormat.format(new Date()) + ".xlsx";
		File outputFile;

		File jasperFile;

		File folders = new File(path);
		if (!folders.exists()) {
			folders.mkdirs();
		}

		try {
			jasperFile = ResourceUtils.getFile("classpath:static/jasper/AUDIT_LOGS/AuditLogs.jasper");
			JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);
			HashMap<String, Object> map = new HashMap<String, Object>();

			logger.info("Inside File Generation Method");

			logger.info("Assigning Parameters for Jasper");
			map.put("FromDate", dateFormat.format(fromdate));
			map.put("ToDate", dateFormat.format(todate));

			logger.info("Inside Method");

			path = path + "/" + fileName;
			JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jp));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
			exporter.exportReport();
			logger.info("Excel File exported");

		} catch (FileNotFoundException | JRException | SQLException e) {

			logger.info(e.getMessage());
			logger.info("Inside catch");

			e.printStackTrace();
		}

		outputFile = new File(path);

		return outputFile;

	}

	public List<XBRLAudit> getAuditLog(Date fromdate, Date todate) {
		Session hs = sessionFactory1.getCurrentSession();

		List<XBRLAudit> ls = hs.createQuery("from XBRLAudit where audit_date between ?1 and ?2 ", XBRLAudit.class)
				.setParameter(1, fromdate).setParameter(2, todate).getResultList();

		return ls;
	}

	public List<AuditServicesEntity> getAuditservices() {
		System.out.println(" inside services");
		List<AuditServicesEntity> is = AuditServicesRep.getauditService();
		System.out.println(" size is : " + is.size());
		return is;
	}

	public List<UserAuditLevel_Entity> getUserAuditLevelList() {
		System.out.println("Fetching USER_AUDIT_LEVEL data...");
		List<UserAuditLevel_Entity> result = userAuditRepo.getUserAuditList();
		System.out.println("Size: " + result.size());
		return result;
	}

}
