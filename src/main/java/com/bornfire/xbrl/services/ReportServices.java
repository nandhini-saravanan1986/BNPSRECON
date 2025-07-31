
package com.bornfire.xbrl.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.validation.constraints.NotNull;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.entities.Facility_Repo;
import com.bornfire.xbrl.entities.Facitlity_Entity;
import com.bornfire.xbrl.entities.MISReportMasterList;
import com.bornfire.xbrl.entities.RBRShareHolder_Entity;
import com.bornfire.xbrl.entities.RBRShareHolder_Repo;
import com.bornfire.xbrl.entities.RBRcustomerArchivalRepo;
import com.bornfire.xbrl.entities.RBRcustomerRepo;
import com.bornfire.xbrl.entities.RBRcustomer_Archival_entity;
import com.bornfire.xbrl.entities.RBRcustomer_entity;
import com.bornfire.xbrl.entities.RBRfacilityArchivalRepo;
import com.bornfire.xbrl.entities.RBRfacility_Archival_entity;
import com.bornfire.xbrl.entities.RBRoverallArchivalRepo;
import com.bornfire.xbrl.entities.RBRoverall_Archival_entity;
import com.bornfire.xbrl.entities.RBRpartnerArchivalRepo;
import com.bornfire.xbrl.entities.RBRpartner_Archival_entity;
import com.bornfire.xbrl.entities.RBRprovisionArchivalRepo;
import com.bornfire.xbrl.entities.RBRprovision_Archival_entity;
import com.bornfire.xbrl.entities.RBRsecurityArchivalRepo;
import com.bornfire.xbrl.entities.RBRsecurity_Archival_entity;
import com.bornfire.xbrl.entities.Security_Entity;
import com.bornfire.xbrl.entities.Security_Repo;
import com.bornfire.xbrl.entities.UserAuditRepo;
import com.bornfire.xbrl.entities.XBRLAudit;
import com.bornfire.xbrl.entities.XBRLProceduresRep;

import com.bornfire.xbrl.entities.XBRLReportsMaster;
import com.bornfire.xbrl.entities.XBRLReportsMasterRep;
//import com.bornfire.xbrl.entities.BRBS.BRF2_MAPPING_REPO;
import com.bornfire.xbrl.entities.BRBS.AuditServicesEntity;
import com.bornfire.xbrl.entities.BRBS.AuditServicesRep;
import com.bornfire.xbrl.entities.BRBS.Provision_Entity;
import com.bornfire.xbrl.entities.BRBS.Provision_Repo;
import com.bornfire.xbrl.entities.BRBS.RBROverall_Data_Entity;
import com.bornfire.xbrl.entities.BRBS.RBRoverall_Data_Repo;
import com.bornfire.xbrl.entities.BRBS.UserAuditLevel_Entity;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

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
	RBRcustomerRepo RBRcustomerRepo;

	@Autowired
	RBRcustomerArchivalRepo RBRcustomerArchivalRepo;

	@Autowired
	AuditServicesRep AuditServicesRep;

	@Autowired
	XBRLReportsMasterRep xbrlReportsMasterRep;

	@Autowired
	XBRLProceduresRep xbrlProceduresRep;

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

	public Iterable<MISReportMasterList> getMISReportsList(String domainid) {
		logger.info("Getting MIS Report list");

		/*
		 * List<String> domains = new ArrayList<String>(); domains =
		 * Arrays.asList(domainid.split(","));
		 */

		return xbrlReportsMasterRep.getMISReportList();
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

	public String saveReport(String reportId, String asondate, String fromdate, String todate, String currency) {

		String msg = null;

		logger.info("Saving the Report : " + reportId);

		try {

			xbrlProceduresRep.ReportSaveSp(reportId, "0", asondate, fromdate, todate, currency);

			logger.info("ReportServices->saveReport()->inside try{}");
			msg = "success";

		} catch (Exception e) {
			logger.info("ReportServices->saveReport()->inside catch{}");
			msg = "failed";
		}

		return msg;
	}

	public String saveFIM0500Report(String reportId, String asondate, String fromdate, String todate, String currency,
			String reportingTime) {

		String msg = null;

		logger.info("Saving the Report : " + reportId);

		try {
			xbrlProceduresRep.ReportSaveSp(reportId, reportingTime, asondate, fromdate, todate, currency);

			logger.info("ReportServices->saveFIM0500Report()->inside try{}");
			msg = "success";

		} catch (Exception e) {
			logger.info("ReportServices->saveFIM0500Report()->inside catch{}");
			msg = "failed";
		}

		return msg;
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

	public File getconsolidateFileECL(String fileType) throws JRException, SQLException, IOException {

		logger.info("Entering getConsolidatedFile method");

		String path = env.getProperty("output.exportpath");
		String fileName = "ECL_CONSOLIDATED" + ".xlsx";
		File outputFile = new File(path + fileName);

		try {
			// List of Jasper files and their corresponding sheet names
			InputStream[] jasperFiles = {
					this.getClass().getResourceAsStream("/static/jasper/ECL_RWA_FB_NFB_MAST_TABLE.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/ECL_RWA_FB_NFB.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/ECL_TREASURY_DATA.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/ECL_RATING_DATA.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/ECL_SMA_DATA.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/ECL_WATCHLIST.jrxml"),
					/*
					 * this.getClass().getResourceAsStream("/static/jasper/CoolOff table1.jrxml"),
					 */
					this.getClass().getResourceAsStream("/static/jasper/ECL_COOLOFF.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/ECL_ACC_MASTER_WORKING.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/ECL_CUST_MASTER.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/ECL_ACC_MASTER.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/ECL_COLLATERAL.jrxml"),

			};

			String[] sheetNames = { "RWA FB+NFB", "FB+NFB for ECL", "TreasuryData", "RATING DATA", "SMADATA",
					"WatchList", "COOLOFF", "Acc Master Working", "CUST MASTER", "ACC MASTER", "Collateral"

			};
			List<JasperPrint> jasperPrintList = new ArrayList<>();

			HashMap<String, Object> map = new HashMap<>();
			map.put("PAGE_BREAK_CONDITION", true);
			map.put("REPORT_DATE", ""); // Setting parameters for the Jasper report

			for (int i = 0; i < jasperFiles.length; i++) {
				JasperReport jasperReport = JasperCompileManager.compileReport(jasperFiles[i]);
				JasperPrint jp = JasperFillManager.fillReport(jasperReport, map, srcdataSource.getConnection());
				jp.setName(sheetNames[i]);
				jasperPrintList.add(jp);
			}

			// Exporting the JasperPrintList to Excel
			logger.info("Exporting to Excel");
			SimpleXlsxReportConfiguration reportConfig = new SimpleXlsxReportConfiguration();
			reportConfig.setSheetNames(new String[] { fileName });
			reportConfig.setDetectCellType(true);
			reportConfig.setOnePagePerSheet(false);
			reportConfig.setRemoveEmptySpaceBetweenRows(false);
			reportConfig.setWhitePageBackground(false);
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new FileOutputStream(outputFile)));
			exporter.exportReport();
			logger.info("Excel File exported successfully");

		} catch (IOException e) {
			logger.error("Error occurred while exporting to Excel: " + e.getMessage());
			throw new IOException("Error occurred while exporting to Excel", e);
		}

		return outputFile;
	}

	public File getFile1(String filetype) throws FileNotFoundException, JRException, SQLException {

		System.out.println("0000");
		// logger.info(pdfgenerator);
		String path = env.getProperty("output.exportpath");
		// D:\JasperDownload

		System.out.println(path);

		String fileName = "";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file : Third_PARTY");

		fileName = "ECL_STATUS_LIST" + filetype;

		zipFileName = fileName + ".zip";

		try {
			InputStream jasperFile;

			// logger.info("Getting Jasper file :" + "Third_PARTY");

			if (filetype.equals("pdf")) {
				System.out.println("inner pdf");
				jasperFile = this.getClass().getResourceAsStream("/static/jasper/Ecl_Status.jrxml");
			} else {

				jasperFile = this.getClass().getResourceAsStream("/static/jasper/Ecl_Status.jrxml");

			}

			System.out.println("#####");
			JasperReport jr = JasperCompileManager.compileReport(jasperFile);
			System.out.println("@@@@@@@@");
			System.out.println(jr);
			System.out.println("@@@@@@@@");

			HashMap<String, Object> map = new HashMap<String, Object>();
			// logger.info("Assigning Parameters for Jasper");

			// map.put("INV_NO", inv_no);

			if (filetype.equals("pdf")) {
				fileName = fileName + ".pdf";
				path = path + fileName;
				JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
				JasperExportManager.exportReportToPdfFile(jp, path);

			} else {

				fileName = fileName + ".xlsx";
				path += fileName;
				JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
				JRXlsxExporter exporter = new JRXlsxExporter();
				exporter.setExporterInput(new SimpleExporterInput(jp));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
				exporter.exportReport();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		outputFile = new File(path);
		return outputFile;
	}

	public File getFile(String filetype) throws FileNotFoundException, JRException, SQLException {

		System.out.println("0000");
		// logger.info(pdfgenerator);
		String path = env.getProperty("output.exportpath");
		// D:\JasperDownload

		System.out.println(path);

		String fileName = "ECL_MDT_AED";
		String zipFileName = "";
		File outputFile;

		logger.info("Getting Output file : Third_PARTY");
		zipFileName = fileName + ".zip";

		try {
			InputStream jasperFile;
			if (filetype.equals("pdf")) {
				System.out.println("inner pdf");
				jasperFile = this.getClass().getResourceAsStream("/static/jasper/ECL_MASTER_DATA_AED.jrxml");
			} else {

				jasperFile = this.getClass().getResourceAsStream("/static/jasper/ECL_MASTER_DATA_AED.jrxml");

			}

			System.out.println("#####");
			JasperReport jr = JasperCompileManager.compileReport(jasperFile);
			System.out.println("@@@@@@@@");
			System.out.println(jr);
			System.out.println("@@@@@@@@");

			HashMap<String, Object> map = new HashMap<String, Object>();
			if (filetype.equals("pdf")) {
				fileName = fileName + ".pdf";
				path = path + fileName;
				JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
				JasperExportManager.exportReportToPdfFile(jp, path);

			} else {

				fileName = fileName + ".xlsx";
				path += fileName;
				JasperPrint jp = JasperFillManager.fillReport(jr, map, srcdataSource.getConnection());
				JRXlsxExporter exporter = new JRXlsxExporter();
				exporter.setExporterInput(new SimpleExporterInput(jp));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
				exporter.exportReport();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		outputFile = new File(path);
		return outputFile;
	}

	public File getRBRFile1(String filetype) throws FileNotFoundException, JRException, SQLException, ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		logger.info("GET GENERATION");
		// String path = this.env.getProperty("output.exportpath");
		String path = "D:/RBR_Download/";
		String fileName = "";
		String zipFileName = "";
		File outputFile;

		SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MMM-yyyy");

		fileName = "RBR_Report";

		logger.info("GET GENERATION" + fileName);

		zipFileName = fileName + ".zip";

		// String filetype="detailexcel";

		// dtltype="report";

		try {

			InputStream jasperFile;

			HashMap<String, Object> map = new HashMap<String, Object>();

			jasperFile = this.getClass().getResourceAsStream("/static/jasper/Report_main.jasper");

			InputStream subrep1 = this.getClass().getResourceAsStream("/static/jasper/Subreportrbrt.jrxml");
			InputStream subrep2 = this.getClass().getResourceAsStream("/static/jasper/cxbrlcustomer.jrxml");

			JasperReport sr1 = JasperCompileManager.compileReport(subrep1);
			JasperReport sr2 = JasperCompileManager.compileReport(subrep2);

			map.put("INST", sr1);

			map.put("INDEX", sr2);

			logger.info("GET GENERATION ASSIGNING PARAMETER");

			JasperReport jr = (JasperReport) JRLoader.loadObject(jasperFile);

			fileName = fileName + ".xlsx";

			path = path + fileName;

			JasperPrint jp = JasperFillManager.fillReport(sr1, map, srcdataSource.getConnection());
			logger.info("GET GENERATION ASSIGNING PARAMETER2");

			JRXlsxExporter exporter = new JRXlsxExporter();

			exporter.setExporterInput(new SimpleExporterInput(jp));

			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));

			exporter.exportReport();

		} catch (Exception e) {

			e.printStackTrace();

		}

		outputFile = new File(path);

		return outputFile;

	}

	public File getRBRFile(String filetype, String tabName, String operationData, HttpServletRequest req)
			throws JRException, SQLException, IOException {

		logger.info("Attempting to generate RBR report. Filetype: {}, TabName: {}, OperationData: {}", filetype,
				tabName, operationData);

		String baseOutputPath = env.getProperty("output.exportpath");
		if (baseOutputPath == null || baseOutputPath.trim().isEmpty()) {
			logger.error("Configuration error: 'output.exportpath' is not set or is empty.");
			throw new IOException("Output path configuration is missing.");
		}
		logger.debug("Base output path: {}", baseOutputPath);

		String determinedFileName = null;
		InputStream jasperFileInputStream = null; // Renamed for clarity

		String roleId = (String) req.getSession().getAttribute("ROLEID");
		String branchCode = (String) req.getSession().getAttribute("BRANCHCODE");

		logger.debug("User RoleID: {}, BranchCode: {}", roleId, branchCode);

		// --- Determine Jasper template and output filename ---
		String jasperTemplatePath = null;
		boolean isRBRRole = "RBR".equals(roleId);

		switch (tabName) {
		case "1": // CUSTOMER
			logger.debug("Processing Tab 1: CUSTOMER");
			if (isRBRRole) {
				logger.debug("Role is RBR. Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/CUSTOMER_DATA_ADD.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Customer_Data_Del.jrxml";

				}

				else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Customer_Data_UPD.jrxml";
				else
					jasperTemplatePath = "/static/jasper/CUSTOMER_DATA.jrxml";
			} else {
				logger.debug("Role is NOT RBR (or null). Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/CUSTOMER_DATA_ADD1.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Customer_Data_Del1.jrxml";
				}

				else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Customer_Data_UPD1.jrxml";
				else
					jasperTemplatePath = "/static/jasper/CUSTOMER_DATA1.jrxml";
			}
			determinedFileName = "Customer Data." + filetype;
			break;

		case "2": // PARTNER
			logger.debug("Processing Tab 2: PARTNER");
			if (isRBRRole) {
				logger.debug("Role is RBR. Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Partner and Shareholder Data Add.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Partner and Shareholder Data Del.jrxml";
				} else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Partner and Shareholder Data Upd.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Partner_and_Shareholder_Data.jrxml";
			} else {
				logger.debug("Role is NOT RBR (or null). Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Partner and Shareholder Data Add1.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Partner and Shareholder Data Del1.jrxml";
				} else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Partner and Shareholder Data Upd1.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Partner_and_Shareholder_Data1.jrxml";
			}
			determinedFileName = "Partner Data." + filetype; // Corrected typo from Patrner to Partner
			break;

		case "3": // FACILITY
			logger.debug("Processing Tab 3: FACILITY");
			if (isRBRRole) {
				logger.debug("Role is RBR. Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Facility Data Add.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Facility Data Del.jrxml";
				} else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Facility Data Upd.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Facility_Data.jrxml";
			} else {
				logger.debug("Role is NOT RBR (or null). Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Facility Data Add1.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Facility Data Del1.jrxml";
				} else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Facility Data Upd1.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Facility Data1.jrxml"; // Corrected typo from .jrxmll
			}
			determinedFileName = "Facility Data." + filetype;
			break;

		case "4": // SECURITY
			logger.debug("Processing Tab 4: SECURITY");
			if (isRBRRole) {
				logger.debug("Role is RBR. Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Security Data Add.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Security Data Del.jrxml";
				} else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Security Data Upd.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Security_Data.jrxml";
			} else {
				logger.debug("Role is NOT RBR (or null). Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Security Data Add1.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Security Data Del1.jrxml";
				} else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Security Data Upd1.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Security Data1.jrxml";
			}
			determinedFileName = "Security Data." + filetype;
			break;

		case "5": // PROVISION
			logger.debug("Processing Tab 5: PROVISION");
			if (isRBRRole) {
				logger.debug("Role is RBR. Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Provision Data Add.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Provision Data Del.jrxml";
				} else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Provision Data Upd.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Provision_Data.jrxml";
			} else {
				logger.debug("Role is NOT RBR (or null). Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Provision Data Add1.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Provision Data Del1.jrxml";
				} else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Provision Data Upd1.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Provision Data1.jrxml";
			}
			determinedFileName = "Provision Data." + filetype;
			break;

		case "6": // OVERALL
			logger.debug("Processing Tab 6: OVERALL");
			if (isRBRRole) {
				logger.debug("Role is RBR. Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Overall Data Add.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Overall Data Del.jrxml";
				} else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Overall Data Upd.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Overall_Data.jrxml";
			} else {
				logger.debug("Role is NOT RBR (or null). Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Overall Data Add1.jrxml";
				else if ("DEL".equals(operationData)) {
					jasperTemplatePath = "/static/jasper/Overall Data Del1.jrxml";
				} else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Overall Data Upd1.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Overall Data1.jrxml";
			}
			determinedFileName = "Overall Data." + filetype;
			break;

		case "7": // LEGAL CASES
			logger.debug("Processing Tab 7: LEGAL CASES");
			if (isRBRRole) {
				logger.debug("Role is RBR. Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Legal Cases Add.jrxml";
				else if ("DEL".equals(operationData))
					jasperTemplatePath = "/static/jasper/Legal Cases Del.jrxml";
				else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Legal Cases Upd.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Legal_Cases.jrxml";
			} else {
				logger.debug("Role is NOT RBR (or null). Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Legal Cases Add1.jrxml";
				else if ("DEL".equals(operationData))
					jasperTemplatePath = "/static/jasper/Legal Cases Del1.jrxml";
				else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Legal Cases Upd1.jrxml";
				else
					jasperTemplatePath = "/static/jasper/Legal Cases1.jrxml";
			}
			determinedFileName = "Legal Cases." + filetype;
			break;

		case "8": // INVESTMENTS
			logger.debug("Processing Tab 8: INVESTMENTS");
			if (isRBRRole) {
				logger.debug("Role is RBR. Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Investments Add.jrxml";
				else if ("DEL".equals(operationData))
					jasperTemplatePath = "/static/jasper/Investments Del.jrxml";
				else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Investments Upd.jrxml";
				else
					jasperTemplatePath = "/static/jasper/RBR_LIST_INVESTMENTS.jrxml";
			} else {
				logger.debug("Role is NOT RBR (or null). Operation: {}", operationData);
				if ("ADD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Investments Add1.jrxml";
				else if ("DEL".equals(operationData))
					jasperTemplatePath = "/static/jasper/Investments Del1.jrxml";
				else if ("UPD".equals(operationData))
					jasperTemplatePath = "/static/jasper/Investments Upd1.jrxml";
				else
					jasperTemplatePath = "/static/jasper/RBR_LIST_INVESTMENTS1.jrxml";
			}
			determinedFileName = "Investments." + filetype;
			break;

		case "Rbrv1": // CUSTOMERDATA V1 (no role check)
			logger.debug("Processing Tab Rbrv1: CUSTOMERDATA V1");
			jasperTemplatePath = "/static/jasper/CUSTOMER_DATA1_RBR_V1.jrxml";
			determinedFileName = "Customerdata." + filetype;
			break;

		default:
			logger.warn("Invalid tabName received: {}", tabName);
			throw new IllegalArgumentException("Invalid tab: " + tabName);
		}

		if (jasperTemplatePath == null) { // Should not happen if logic is correct, but as a safeguard
			logger.error("Jasper template path was not determined for tabName: {}", tabName);
			throw new JRException("Internal error: Jasper template path could not be determined.");
		}
		logger.info("Selected Jasper template: {}", jasperTemplatePath);
		jasperFileInputStream = this.getClass().getResourceAsStream(jasperTemplatePath);

		if (jasperFileInputStream == null) {
			logger.error("Jasper file not found at path: {} for tab: {}", jasperTemplatePath, tabName);
			throw new JRException("Jasper file not found: " + jasperTemplatePath);
		}

		// --- Compile, Fill, and Export Report ---
		File outputFile = Paths.get(baseOutputPath, determinedFileName).toFile();
		Connection dbConnection = null; // Declare connection here to be accessible in finally

		try {
			logger.debug("Compiling Jasper report from stream...");
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperFileInputStream);
			logger.debug("Jasper report compiled successfully.");

			HashMap<String, Object> reportParameters = new HashMap<>();
			reportParameters.put("BRANCH_CODE", branchCode);
			// Add any other common parameters here

			logger.debug("Getting database connection...");
			dbConnection = srcdataSource.getConnection(); // Get connection
			if (dbConnection == null) {
				logger.error("Failed to obtain database connection from datasource.");
				throw new SQLException("Could not obtain database connection.");
			}
			logger.debug("Database connection obtained. Filling report...");

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, reportParameters, dbConnection);
			logger.debug("Report filled successfully.");

			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFile.getAbsolutePath())); // Use
																											// absolute
																											// path

			// Set auto-width for columns
			SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
			configuration.setDetectCellType(true); // Auto-detect data types
			configuration.setAutoFitPageHeight(true); // Optional: auto-fit page height
			configuration.setOnePagePerSheet(false); // Optional: multiple pages in one sheet
			configuration.setWrapText(true); // Optional: wrap text
			configuration.setCollapseRowSpan(false); // Optional: keep rowspan intact // ✅ THIS enables auto column
														// width
			exporter.setConfiguration(configuration);

			logger.info("Exporting report to: {}", outputFile.getAbsolutePath());
			exporter.exportReport();
			autoSizeColumns(outputFile);

			logger.info("Excel file exported successfully: {}", outputFile.getName());

			if (tabName.equals("1")) {
				CUSTOMERdeltoARCHIVAL(isRBRRole, branchCode);
			} else if (tabName.equals("2")) {
				PARTNERdeltoARCHIVAL(isRBRRole, branchCode);
			} else if (tabName.equals("3")) {
				FACILITYdeltoARCHIVAL(isRBRRole, branchCode);
			} else if (tabName.equals("4")) {
				SECURITYdeltoARCHIVAL(isRBRRole, branchCode);
			} else if (tabName.equals("5")) {
				PROVISIONdeltoARCHIVAL(isRBRRole, branchCode);
			} else if (tabName.equals("6")) {
				OVERALLdeltoARCHIVAL(isRBRRole, branchCode);
			}

			return outputFile;

		} catch (JRException | SQLException e) { // Catch specific exceptions related to Jasper and SQL
			logger.error("Error during Jasper report generation for {}: {}", determinedFileName, e.getMessage(), e);
			// Delete partially created file if it exists and an error occurred
			if (outputFile.exists() && !outputFile.delete()) {
				logger.warn("Could not delete partially created report file: {}", outputFile.getAbsolutePath());
			}
			throw e; // Re-throw the original exception to be handled by the caller
		} catch (Exception e) { // Catch any other unexpected exceptions
			logger.error("Unexpected error during report generation for {}: {}", determinedFileName, e.getMessage(), e);
			if (outputFile.exists() && !outputFile.delete()) {
				logger.warn("Could not delete partially created report file: {}", outputFile.getAbsolutePath());
			}
			throw new JRException("Unexpected error generating report: " + e.getMessage(), e); // Wrap in JRException or
																								// a custom one
		} finally {
			// Close jasperFileInputStream
			if (jasperFileInputStream != null) {
				try {
					jasperFileInputStream.close();
				} catch (IOException e) {
					logger.warn("Could not close jasperFileInputStream: {}", e.getMessage());
				}
			}
			// Close database connection
			if (dbConnection != null) {
				try {
					if (!dbConnection.isClosed()) {
						dbConnection.close();
						logger.debug("Database connection closed.");
					}
				} catch (SQLException e) {
					logger.error("Error closing database connection: {}", e.getMessage(), e);
				}
			}
		}
	}

	public void CUSTOMERdeltoARCHIVAL(boolean isRBRRole, String branchCode) {
		logger.debug("CUSTOMERdeltoARCHIVAL started. isRBRRole={}, branchCode={}", isRBRRole, branchCode);

		List<RBRcustomer_entity> deldata;
		if (isRBRRole) {
			deldata = RBRcustomerRepo.getlistofDEL();
		} else {
			deldata = RBRcustomerRepo.getlistofDELbranch(branchCode);
		}

		logger.debug("Found {} records to archive", deldata.size());

		for (RBRcustomer_entity cud : deldata) {
			try {
				// archive
				RBRcustomer_Archival_entity temdata = new RBRcustomer_Archival_entity(cud);
				RBRcustomerArchivalRepo.save(temdata);

				// delete
				RBRcustomerRepo.deleteById(cud.getSrl_no());

				logger.debug("Archived and deleted record with srl_no={}", cud.getSrl_no());
			} catch (Exception e) {
				logger.error("Error archiving/deleting record with srl_no={}", cud.getSrl_no(), e);
			}
		}
	}

	@Autowired
	RBRShareHolder_Repo rbrShareHolder_Repo;

	@Autowired
	RBRpartnerArchivalRepo RBRpartnerArchivalRepo;

	public void PARTNERdeltoARCHIVAL(boolean isRBRRole, String branchCode) {
		logger.debug("PARTNERdeltoARCHIVAL started. isRBRRole={}, branchCode={}", isRBRRole, branchCode);

		List<RBRShareHolder_Entity> deldata;
		if (isRBRRole) {
			deldata = rbrShareHolder_Repo.getlistofDEL();
		} else {
			deldata = rbrShareHolder_Repo.getlistofDELbranch(branchCode);
		}

		logger.debug("Found {} records to archive", deldata.size());

		for (RBRShareHolder_Entity cud : deldata) {
			try {
				// archive
				RBRpartner_Archival_entity temdata = new RBRpartner_Archival_entity(cud);
				RBRpartnerArchivalRepo.save(temdata);

				// delete
				rbrShareHolder_Repo.deleteById(cud.getSrl_no());

				logger.debug("Archived and deleted record with srl_no={}", cud.getSrl_no());
			} catch (Exception e) {
				logger.error("Error archiving/deleting record with srl_no={}", cud.getSrl_no(), e);
			}
		}
	}

	@Autowired
	Facility_Repo facility_Repo;

	@Autowired
	RBRfacilityArchivalRepo RBRfacilityArchivalRepo;

	public void FACILITYdeltoARCHIVAL(boolean isRBRRole, String branchCode) {
		logger.debug("FACILITYdeltoARCHIVAL started. isRBRRole={}, branchCode={}", isRBRRole, branchCode);

		List<Facitlity_Entity> deldata;
		if (isRBRRole) {
			deldata = facility_Repo.getlistofDEL();
		} else {
			deldata = facility_Repo.getlistofDELbranch(branchCode);
		}

		logger.debug("Found {} records to archive", deldata.size());

		for (Facitlity_Entity cud : deldata) {
			try {
				// archive
				RBRfacility_Archival_entity temdata = new RBRfacility_Archival_entity(cud);
				RBRfacilityArchivalRepo.save(temdata);

				// delete
				facility_Repo.deleteById(cud.getSrl_no());

				logger.debug("Archived and deleted record with srl_no={}", cud.getSrl_no());
			} catch (Exception e) {
				logger.error("Error archiving/deleting record with srl_no={}", cud.getSrl_no(), e);
			}
		}
	}

	@Autowired
	Security_Repo security_Repo;
	@Autowired
	RBRsecurityArchivalRepo RBRsecurityArchivalRepo;

	public void SECURITYdeltoARCHIVAL(boolean isRBRRole, String branchCode) {
		logger.debug("SECURIYdeltoARCHIVAL started. isRBRRole={}, branchCode={}", isRBRRole, branchCode);

		List<Security_Entity> deldata;
		if (isRBRRole) {
			deldata = security_Repo.getlistofDEL();
		} else {
			deldata = security_Repo.getlistofDELbranch(branchCode);
		}

		logger.debug("Found {} records to archive", deldata.size());

		for (Security_Entity cud : deldata) {
			try {
				// archive
				RBRsecurity_Archival_entity temdata = new RBRsecurity_Archival_entity(cud);
				RBRsecurityArchivalRepo.save(temdata);

				// delete
				security_Repo.deleteById(cud.getSrl_no());

				logger.debug("Archived and deleted record with srl_no={}", cud.getSrl_no());
			} catch (Exception e) {
				logger.error("Error archiving/deleting record with srl_no={}", cud.getSrl_no(), e);
			}
		}
	}

	@Autowired
	Provision_Repo Provision_Repo;

	@Autowired
	RBRprovisionArchivalRepo RBRprovisionArchivalRepo;

	public void PROVISIONdeltoARCHIVAL(boolean isRBRRole, String branchCode) {
		logger.debug("PROVISIONdeltoARCHIVAL started. isRBRRole={}, branchCode={}", isRBRRole, branchCode);

		List<Provision_Entity> deldata;
		if (isRBRRole) {
			deldata = Provision_Repo.getlistofDEL();
		} else {
			deldata = Provision_Repo.getlistofDELbranch(branchCode);
		}

		logger.debug("Found {} records to archive", deldata.size());

		for (Provision_Entity cud : deldata) {
			try {
				// archive
				RBRprovision_Archival_entity temdata = new RBRprovision_Archival_entity(cud);
				RBRprovisionArchivalRepo.save(temdata);

				// delete
				Provision_Repo.deleteById(cud.getSrl_no());

				logger.debug("Archived and deleted record with srl_no={}", cud.getSrl_no());
			} catch (Exception e) {
				logger.error("Error archiving/deleting record with srl_no={}", cud.getSrl_no(), e);
			}
		}
	}

	@Autowired
	RBRoverall_Data_Repo RBRoverall_Data_Repo;

	@Autowired
	RBRoverallArchivalRepo RBRoverallArchivalRepo;

	public void OVERALLdeltoARCHIVAL(boolean isRBRRole, String branchCode) {
		logger.debug("OVERALLdeltoARCHIVAL started. isRBRRole={}, branchCode={}", isRBRRole, branchCode);

		List<RBROverall_Data_Entity> deldata;
		if (isRBRRole) {
			deldata = RBRoverall_Data_Repo.getlistofDEL();
		} else {
			deldata = RBRoverall_Data_Repo.getlistofDELbranch(branchCode);
		}

		logger.debug("Found {} records to archive", deldata.size());

		for (RBROverall_Data_Entity cud : deldata) {
			try {
				// archive
				RBRoverall_Archival_entity temdata = new RBRoverall_Archival_entity(cud);
				RBRoverallArchivalRepo.save(temdata);

				// delete
				RBRoverall_Data_Repo.deleteById(cud.getSrl_no());

				logger.debug("Archived and deleted record with srl_no={}", cud.getSrl_no());
			} catch (Exception e) {
				logger.error("Error archiving/deleting record with srl_no={}", cud.getSrl_no(), e);
			}
		}
	}

	public void autoSizeColumns(File excelFile) throws IOException {
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		XSSFRow row = sheet.getRow(0);
		if (row != null) {
			for (int i = 0; i < row.getLastCellNum(); i++) {
				sheet.autoSizeColumn(i);
			}
		}

		fis.close();

		FileOutputStream fos = new FileOutputStream(excelFile);
		workbook.write(fos);
		workbook.close();
		fos.close();
	}

	// CREATED BY GOWTHAM
	public File getMasterRBRFile(String formmode, HttpServletRequest req)
			throws JRException, SQLException, IOException {

		// Retrieve session attributes
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");

		// File storage path
		String path = env.getProperty("output.exportpath");
		if (path == null || path.isEmpty()) {
			throw new IOException("❌ Invalid export path. Check application properties.");
		}
		if (!path.endsWith(File.separator)) {
			path += File.separator;
		}

		String fileName;
		InputStream jasperFile = null;

		try {
			// Determine the report file based on formmode
			switch (formmode) {
			case "1":
				jasperFile = this.getClass().getResourceAsStream("/static/jasper/Customer Data Unverified.jrxml");
				fileName = "Customer Data Unverified.xlsx";
				break;
			case "2":
				jasperFile = this.getClass().getResourceAsStream("/static/jasper/Partner Data Unverified.jrxml");
				fileName = "Partner Data Unverified.xlsx";
				break;
			case "3":
				jasperFile = this.getClass().getResourceAsStream("/static/jasper/Security Data Unverified.jrxml");
				fileName = "security.xlsx";
				break;
			case "4":
				jasperFile = this.getClass().getResourceAsStream("/static/jasper/Facility Data Unverified.jrxml");
				fileName = "facility.xlsx";
				break;
			case "5":
				jasperFile = this.getClass().getResourceAsStream("/static/jasper/Provision Data Unverified.jrxml");
				fileName = "provision.xlsx";
				break;
			case "6":
				jasperFile = this.getClass().getResourceAsStream("/static/jasper/Overall Data Unverified.jrxml");
				fileName = "overall.xlsx";
				break;
			default:
				throw new IllegalArgumentException("❌ Invalid formmode: " + formmode);
			}

			if (jasperFile == null) {
				throw new JRException("❌ Jasper file not found for formmode: " + formmode);
			}

			try (Connection connection = srcdataSource.getConnection()) {
				// Compile the report
				JasperReport jr = JasperCompileManager.compileReport(jasperFile);

				// Pass BRANCH_CODE as a parameter
				HashMap<String, Object> parameters = new HashMap<>();
				parameters.put("BRANCH_CODE", BRANCHCODE);

				// Generate the final report file
				String outputPath = path + fileName;
				File outputFile = new File(outputPath);
				JasperPrint jp = JasperFillManager.fillReport(jr, parameters, connection);

				// Export to Excel
				JRXlsxExporter exporter = new JRXlsxExporter();
				exporter.setExporterInput(new SimpleExporterInput(jp));
				exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputPath));

				SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
				configuration.setDetectCellType(true); // Very important for data types
				configuration.setOnePagePerSheet(false);
				exporter.setConfiguration(configuration);

				// Export the report to the file
				exporter.exportReport();

				// Call your auto-size method AFTER the file has been created
				autoSizeColumns(outputFile);

				return new File(outputPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null; // Return null if an error occurs
		} finally {
			if (jasperFile != null) {
				jasperFile.close();
			}
		}
	}

	public File getECLFile(String filetype) {
		String path = env.getProperty("output.exportpath");
		String fileName = "ECL_DATA" + filetype;
		String zipFileName = fileName + ".zip";
		File outputFile = null;

		try {
			// Load JasperReport files
			InputStream jasperFile = this.getClass().getResourceAsStream("/static/jasper/Report_main.jrxml");
			InputStream[] jasperFiles = { this.getClass().getResourceAsStream("/static/jasper/Ecl_Dcr.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Ecl_Disb_Rec.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Ecl_Inr.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Ecl_Lgd.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Ecl_Lrw.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/ECL_MASTER_DATA_AED.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Ecl_Recovery.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Ecl_Status.jrxml"),
					this.getClass().getResourceAsStream("/static/jasper/Ecl_Wo_Adj.jrxml") };

			// Compile JasperReports
			JasperReport[] jasperReports = new JasperReport[jasperFiles.length];
			for (int i = 0; i < jasperFiles.length; i++) {
				jasperReports[i] = JasperCompileManager.compileReport(jasperFiles[i]);
			}

			// Fill JasperPrint for each report
			JasperPrint[] jasperPrints = new JasperPrint[jasperReports.length];
			for (int i = 0; i < jasperReports.length; i++) {
				jasperPrints[i] = JasperFillManager.fillReport(jasperReports[i], new HashMap<>(),
						srcdataSource.getConnection());
			}

			// Combine JasperPrints
			JasperPrint combinedJasperPrint = new JasperPrint();
			for (JasperPrint jasperPrint : jasperPrints) {
				List<JRPrintPage> pages = jasperPrint.getPages();
				for (JRPrintPage page : pages) {
					combinedJasperPrint.addPage(page);
				}
			}

			// Export to XLSX
			fileName = fileName + ".xlsx";
			path += fileName;
			JRXlsxExporter exporter = new JRXlsxExporter();
			exporter.setExporterInput(new SimpleExporterInput(combinedJasperPrint));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(path));
			exporter.exportReport();

		} catch (Exception e) {
			logger.error("Error generating ECL file", e);
		}

		if (path != null) {
			outputFile = new File(path);
		}
		return outputFile;
	}

}
