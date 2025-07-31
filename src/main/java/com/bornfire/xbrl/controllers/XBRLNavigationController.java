package com.bornfire.xbrl.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.bornfire.xbrl.config.PasswordEncryption;
import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.AccessAndRoles;
import com.bornfire.xbrl.entities.AccessandRolesRepository;
import com.bornfire.xbrl.entities.AlertEntity;
import com.bornfire.xbrl.entities.AlertManagementEntity;
import com.bornfire.xbrl.entities.AlertManagementRepository;
import com.bornfire.xbrl.entities.AlertRep;
import com.bornfire.xbrl.entities.BRECON_TTUM_TRANSACTION_ENTITY;
import com.bornfire.xbrl.entities.BRECON_TTUM_TRANSACTION_REP;
import com.bornfire.xbrl.entities.Brecon_Aani_payment_dup_rep;
import com.bornfire.xbrl.entities.EcddCorporateEntity;
import com.bornfire.xbrl.entities.EcddCustomerDocumentsEntity;
import com.bornfire.xbrl.entities.Facility_Repo;
import com.bornfire.xbrl.entities.Facitlity_Entity;
import com.bornfire.xbrl.entities.KYC_Audit_Rep;
import com.bornfire.xbrl.entities.Kyc_Corprate_Repo;
import com.bornfire.xbrl.entities.Kyc_Repo;
import com.bornfire.xbrl.entities.RBRShareHolder_Entity;
import com.bornfire.xbrl.entities.RBRShareHolder_Repo;
import com.bornfire.xbrl.entities.RBR_CUSTOMER_DATA_V1_REP;
import com.bornfire.xbrl.entities.RBR_Inverstments_Entity;
import com.bornfire.xbrl.entities.RBR_Inverstments_Repo;
import com.bornfire.xbrl.entities.RBR_Legal_Cases_Entity;
import com.bornfire.xbrl.entities.RBR_Legal_Cases_Repo;
import com.bornfire.xbrl.entities.RBRcustomerRepo;
import com.bornfire.xbrl.entities.RBRcustomer_entity;
import com.bornfire.xbrl.entities.Security_Entity;
import com.bornfire.xbrl.entities.Security_Repo;
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.XBRLReportsMasterRep;
import com.bornfire.xbrl.entities.BRBS.AuditTablePojo;
import com.bornfire.xbrl.entities.BRBS.BRECON_Audit_Entity;
import com.bornfire.xbrl.entities.BRBS.BRECON_Audit_Rep;
import com.bornfire.xbrl.entities.BRBS.BRECON_Common_Table_Entity;
import com.bornfire.xbrl.entities.BRBS.BRECON_Common_Table_Rep;
import com.bornfire.xbrl.entities.BRBS.BRECON_DESTINATION_ENTITY;
import com.bornfire.xbrl.entities.BRBS.BRECON_DESTINATION_REPO;
import com.bornfire.xbrl.entities.BRBS.BRF095AServiceRepo;
import com.bornfire.xbrl.entities.BRBS.BRFValidationsRepo;
import com.bornfire.xbrl.entities.BRBS.BRF_095_A_REPORT_ENTITY;
import com.bornfire.xbrl.entities.BRBS.Brecon_core_entity;
import com.bornfire.xbrl.entities.BRBS.Brecon_core_rep;
import com.bornfire.xbrl.entities.BRBS.Charge_Back_Rep;
import com.bornfire.xbrl.entities.BRBS.EcddIndividualProfileRepository;
import com.bornfire.xbrl.entities.BRBS.Ecdd_Individual_Profile_Entity;
import com.bornfire.xbrl.entities.BRBS.Ecdd_customer_transaction;
import com.bornfire.xbrl.entities.BRBS.Ecdd_customer_transaction_repo;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Audit_Rep;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Service_Rep;
import com.bornfire.xbrl.entities.BRBS.Provision_Entity;
import com.bornfire.xbrl.entities.BRBS.Provision_Repo;
import com.bornfire.xbrl.entities.BRBS.RBROverall_Data_Entity;
import com.bornfire.xbrl.entities.BRBS.RBRoverall_Data_Repo;
import com.bornfire.xbrl.entities.BRBS.T1CurProdServicesRepo;
import com.bornfire.xbrl.services.AccessAndRolesServices;
import com.bornfire.xbrl.services.AlertManagementServices;
import com.bornfire.xbrl.services.BRF004ReportService;
import com.bornfire.xbrl.services.EcddUploadDocumentService;
import com.bornfire.xbrl.services.IndividualPdfService;
import com.bornfire.xbrl.services.Kyc_individual_service;
import com.bornfire.xbrl.services.LoginServices;
import com.bornfire.xbrl.services.RBRReportservice;
import com.bornfire.xbrl.services.ReportServices;
import com.bornfire.xbrl.services.ReportServices.ReportTitle;

import net.sf.jasperreports.engine.JRException;

@Controller
@ConfigurationProperties("default")
public class XBRLNavigationController {

	private static final Logger logger = LoggerFactory.getLogger(XBRLNavigationController.class);
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	LoginServices loginServices;

	@Autowired
	Kyc_individual_service kyc_individual_service;

	@Autowired
	EcddIndividualProfileRepository ecddIndividualProfileRepository;

	@Autowired
	BRF004ReportService BRF004ReportServices;

	@Autowired
	XBRLReportsMasterRep XBRLReportsMasterReps;

	@Autowired
	Brecon_core_rep coresystemlistrep;

	@Autowired
	BRECON_Common_Table_Rep bRECON_Common_Table_Rep;

	@Autowired
	AlertRep alertRep;

	@Autowired
	ReportServices reportServices;

	@Autowired
	SequenceGenerator sequence;

	@Autowired
	BRFValidationsRepo brfValidationsRepo;
	
	@Autowired
	T1CurProdServicesRepo t1CurProdServicesRepo;

	@Autowired
	RBRcustomerRepo rBRcustomerRepo;

	@Autowired
	RBRShareHolder_Repo rbrShareHolder_Repo;

	@Autowired
	Facility_Repo facility_Repo;

	@Autowired
	Security_Repo security_Repo;

	@Autowired
	Provision_Repo Provision_Repo;

	@Autowired
	RBR_Inverstments_Repo RBR_Inverstments_Repo;

	@Autowired
	RBR_Legal_Cases_Repo RBR_Legal_Cases_Repo;

	@Autowired
	RBRoverall_Data_Repo RBRoverall_Data_Repo;

	@Autowired
	RBRReportservice RBRReportservice;

	@Autowired
	private AlertManagementRepository alertmanagementrepository;

	@Autowired
	AlertManagementServices alertservices;

	@Autowired
	com.bornfire.xbrl.entities.BRBS.AUD_SERVICE_REPO AUD_SERVICE_REPO;

	@Autowired
	UserProfileRep userProfileRep;

	@Autowired
	RBR_CUSTOMER_DATA_V1_REP RBR_CUSTOMER_DATA_V1_REP;

	@Autowired
	BRECON_DESTINATION_REPO bRECON_DESTINATION_REPO;

	@Autowired
	BRECON_Audit_Rep bRECON_Audit_Rep;

	@Autowired
	MANUAL_Audit_Rep mANUAL_Audit_Rep;

	@Autowired
	MANUAL_Service_Rep mANUAL_Service_Rep;

	@Autowired
	Charge_Back_Rep charge_Back_Rep;

	@Autowired
	Ecdd_customer_transaction_repo Ecdd_customer_transaction_repo;

	@Autowired
	BRECON_TTUM_TRANSACTION_REP BRECON_TTUM_TRANSACTION_REP;

	@Autowired
	AccessAndRolesServices AccessRoleService;

	@Autowired
	AccessandRolesRepository accessandrolesrepository;

	@Autowired
	Brecon_Aani_payment_dup_rep Brecon_Aani_payment_dup_rep;

	private String auditRefNo;

	private String pagesize;

	public String getPagesize() {
		return pagesize;
	}

	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	@RequestMapping("/custom-error")
	public String handleError(HttpServletRequest request, Model model) {
		Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		Object errorMessage = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
		Exception exception = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

		// Ignore Thymeleaf exceptions by returning a simple message or redirecting
		// elsewhere
		if (exception != null) {
			if (exception instanceof org.thymeleaf.exceptions.TemplateInputException
					|| exception instanceof org.thymeleaf.exceptions.TemplateProcessingException) {
				// For example: return a simple page or ignore it silently
				model.addAttribute("status", statusCode);
				model.addAttribute("message", "A template processing error occurred.");
				return "simple-error"; // Or any other simple error page without details
			}
		}

		model.addAttribute("status", statusCode);
		model.addAttribute("message", errorMessage);

		return "error"; // Your normal error.html template
	}

	@GetMapping("/systemotp")
	public String showOtpForm() {
		return "XBRLOtpvalidation.html"; // Thymeleaf or HTML page
	}

	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam("otp") String userOtp, HttpSession session) {
		String actualOtp = (String) session.getAttribute("otp");
		if (actualOtp != null && actualOtp.equals(userOtp)) {
			session.removeAttribute("otp"); // Clear OTP after success
			return "redirect:/Dashboard";
		}
		return "redirect:login?invalidotp";
	}

	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String getdashboard(Model md, HttpServletRequest req) {

		String domainid = (String) req.getSession().getAttribute("DOMAINID");
		String userid = (String) req.getSession().getAttribute("USERID");
		String Dashboardpage = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");

		md.addAttribute("menu", "Dashboard");
		md.addAttribute("checkpassExpiry", loginServices.checkpassexpirty(userid));
		md.addAttribute("checkAcctExpiry", loginServices.checkAcctexpirty(userid));
		md.addAttribute("changepassword", loginServices.checkPasswordChangeReq(userid));

		if (Dashboardpage.equals("DCD_ADMIN") || Dashboardpage.equals("DCD_BRANCH")) {
			int Completed = 0;
			int Pending = 0;
			int Under_review = 0;

			int CorpCompleted = 0;
			int CorpPending = 0;
			int CorpUnder_review = 0;

			int corpbarcompleted = 0;
			int corpbarPending = 0;
			int corpbarincomplete = 0;

			/// Counts fetched for Dashborad page Pending kyc INDIVIDUAL details branch wise
			BigDecimal DubaiPendIndividuals = new BigDecimal("0");
			BigDecimal AbudhabiPendIndividuals = new BigDecimal("0");
			BigDecimal DeiraPendIndividuals = new BigDecimal("0");
			BigDecimal SharjhaPendIndividuals = new BigDecimal("0");
			BigDecimal RasalkhaimaPendIndividuals = new BigDecimal("0");
			BigDecimal SyndPendIndividuals = new BigDecimal("0");

			BigDecimal DubaiPendCorporate = new BigDecimal("0");
			BigDecimal AbudhabiPendCorporate = new BigDecimal("0");
			BigDecimal DeiraPendCorporate = new BigDecimal("0");
			BigDecimal SharjhaPendCorporate = new BigDecimal("0");
			BigDecimal RasalkhaimaPendCorporate = new BigDecimal("0");
			BigDecimal SyndPendCorporate = new BigDecimal("0");
			if (Dashboardpage.equals("DCD_ADMIN")) {
				Completed = ecddIndividualProfileRepository.Getcompletedcount();
				Under_review = ecddIndividualProfileRepository.GetIncompletedcount();
				Pending = ecddIndividualProfileRepository.GetPendingcount();

				CorpCompleted = kyc_corporate_repo.Getcompletedcount();
				CorpUnder_review = kyc_corporate_repo.GetIncompletedcount();
				CorpPending = kyc_corporate_repo.GetPendingcount();
			} else {
				Completed = ecddIndividualProfileRepository.Getbranchwisecompletedcount(BRANCHCODE);
				Under_review = ecddIndividualProfileRepository.GetbranchwiseIncompletedcount(BRANCHCODE);
				Pending = ecddIndividualProfileRepository.GetbranchwisePendingcount(BRANCHCODE);

				CorpCompleted = kyc_corporate_repo.Getbranchwisecompletedcount(BRANCHCODE);
				CorpUnder_review = kyc_corporate_repo.GetbranchwiseIncompletedcount(BRANCHCODE);
				CorpPending = kyc_corporate_repo.GetbranchwisePendingcount(BRANCHCODE);
			}

			corpbarcompleted = CorpCompleted;
			corpbarPending = CorpPending;
			corpbarincomplete = CorpUnder_review;

			List<Object[]> branchwiseIndividual = ecddIndividualProfileRepository.GetbranchPendingcount();

			for (int i = 0; i < branchwiseIndividual.size(); i++) {

				if (branchwiseIndividual.get(i)[0].toString() != null) {
					if (branchwiseIndividual.get(i)[0].toString().equals("9001")) {
						DubaiPendIndividuals = branchwiseIndividual.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseIndividual.get(i)[1].toString());
					}

					if (branchwiseIndividual.get(i)[0].toString().equals("9002")) {
						AbudhabiPendIndividuals = branchwiseIndividual.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseIndividual.get(i)[1].toString());
					}
					if (branchwiseIndividual.get(i)[0].toString().equals("9003")) {
						DeiraPendIndividuals = branchwiseIndividual.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseIndividual.get(i)[1].toString());
					}
					if (branchwiseIndividual.get(i)[0].toString().equals("9004")) {
						SharjhaPendIndividuals = branchwiseIndividual.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseIndividual.get(i)[1].toString());
					}

					if (branchwiseIndividual.get(i)[0].toString().equals("9008")) {
						SyndPendIndividuals = branchwiseIndividual.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseIndividual.get(i)[1].toString());
					}
				}

			}

			List<Object[]> branchwiseCorporate = kyc_corporate_repo.GetbranchPendingcount();
			for (int i = 0; i < branchwiseCorporate.size(); i++) {

				if (branchwiseCorporate.get(i)[0].toString() != null) {
					if (branchwiseCorporate.get(i)[0].toString().equals("9001")) {
						DubaiPendCorporate = branchwiseCorporate.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseCorporate.get(i)[1].toString());
					}

					if (branchwiseCorporate.get(i)[0].toString().equals("9002")) {
						AbudhabiPendCorporate = branchwiseCorporate.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseCorporate.get(i)[1].toString());
					}
					if (branchwiseCorporate.get(i)[0].toString().equals("9003")) {
						DeiraPendCorporate = branchwiseCorporate.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseCorporate.get(i)[1].toString());
					}
					if (branchwiseCorporate.get(i)[0].toString().equals("9004")) {
						SharjhaPendCorporate = branchwiseCorporate.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseCorporate.get(i)[1].toString());
					}

					if (branchwiseCorporate.get(i)[0].toString().equals("9008")) {
						SyndPendCorporate = branchwiseCorporate.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseCorporate.get(i)[1].toString());
					}
				}

			}
			// Individuals Attribue
			md.addAttribute("DubaiPendIndividuals", DubaiPendIndividuals);
			md.addAttribute("AbudhabiPendIndividuals", AbudhabiPendIndividuals);
			md.addAttribute("DeiraPendIndividuals", DeiraPendIndividuals);
			md.addAttribute("SharjhaPendIndividuals", SharjhaPendIndividuals);
			md.addAttribute("RasalkhaimaPendIndividuals", RasalkhaimaPendIndividuals);
			md.addAttribute("SyndPendIndividuals", SyndPendIndividuals);

			// Corporate Attribute
			md.addAttribute("DubaiPendCorporate", DubaiPendCorporate);
			md.addAttribute("AbudhabiPendCorporate", AbudhabiPendCorporate);
			md.addAttribute("DeiraPendCorporate", DeiraPendCorporate);
			md.addAttribute("SharjhaPendCorporate", SharjhaPendCorporate);
			md.addAttribute("RasalkhaimaPendCorporate", RasalkhaimaPendCorporate);
			md.addAttribute("SyndPendCorporate", SyndPendCorporate);

			md.addAttribute("completed", Completed);
			md.addAttribute("Pending", Pending);
			md.addAttribute("Under_review", Under_review);
			md.addAttribute("Dashboardpage", Dashboardpage);
			md.addAttribute("corpbarcompleted", corpbarcompleted);
			md.addAttribute("corpbarPending", corpbarPending);
			md.addAttribute("corpbarincomplete", corpbarincomplete);

			md.addAttribute("Branch_code", BRANCHCODE);

			System.out.println(Dashboardpage);
		} else if (Dashboardpage.equals("BRC")) {
			LocalDate today = LocalDate.now(); // Get today's date
			Date fromDateToUse = java.sql.Date.valueOf(today.minusDays(1));

			int matchedCount = 0;
			int unmatchedSourceCount = 0;
			int unmatchedDestinationCount = 0;
			int totalTransactionCount = 0;

			List<BRECON_Common_Table_Entity> matchedList = bRECON_Common_Table_Rep.getcommondatavalues(fromDateToUse);
			matchedCount = (matchedList != null) ? matchedList.size() : 0;

			List<Brecon_core_entity> sourceList = coresystemlistrep.getcoresystemlistvalue(fromDateToUse);
			unmatchedSourceCount = (sourceList != null) ? sourceList.size() : 0;

			List<BRECON_DESTINATION_ENTITY> destList = bRECON_DESTINATION_REPO.getDestinationdatavalues(fromDateToUse);
			unmatchedDestinationCount = (destList != null) ? destList.size() : 0;

			List<Brecon_core_entity> TotalList = coresystemlistrep.getcoresystemlisttotvalue(fromDateToUse);
			totalTransactionCount = (TotalList != null) ? TotalList.size() : 0;

			// Add to model
			md.addAttribute("matchedCount", matchedCount);
			md.addAttribute("unmatchedSourceCount", unmatchedSourceCount);
			md.addAttribute("unmatchedDestinationCount", unmatchedDestinationCount);
			md.addAttribute("totalTransactionCount", totalTransactionCount);
			//// duplicates cbs records
			List<Object[]> cbsduplicaterecord = coresystemlistrep.getcbsduplicaterecord();
			md.addAttribute("cbsduplicaterecord", cbsduplicaterecord);
			//// duplicate AANI Payment Records
			List<Object[]> aaniduplicaterecord = bRECON_DESTINATION_REPO.getaaniduplicaterecord();
			md.addAttribute("aaniduplicaterecord", aaniduplicaterecord);

		} else {

			int completed = 0;
			int uncompleted = 0;

			List<ReportTitle> ls = reportServices.getDashBoardRepList(domainid);

			for (ReportTitle var : ls) {
				if (var.getCompletedFlg().equals('Y')) {
					completed++;
				} else {
					uncompleted++;
				}
			}

			md.addAttribute("reportList", ls);
			md.addAttribute("completed", completed);
			md.addAttribute("uncompleted", uncompleted);
		}

		md.addAttribute("menu", "Dashboard");
		return "XBRLDashboard";
	}

	@RequestMapping(value = "Dashboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String dashboard(@RequestParam(name = "frequency", required = false) String frequency, Model md,
			HttpServletRequest req) {

		String domainid = (String) req.getSession().getAttribute("DOMAINID");
		String userid = (String) req.getSession().getAttribute("USERID");
		String Dashboardpage = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");

		System.out.println("Dashboard page is:" + Dashboardpage);
		System.out.println("Branchcode is : " + BRANCHCODE);
		md.addAttribute("menu", "Dashboard");
		md.addAttribute("checkpassExpiry", loginServices.checkpassexpirty(userid));
		md.addAttribute("checkAcctExpiry", loginServices.checkAcctexpirty(userid));
		md.addAttribute("changepassword", loginServices.checkPasswordChangeReq(userid));

		if (Dashboardpage.equals("DCD_ADMIN") || Dashboardpage.equals("DCD_BRANCH")) {
			int Completed = 0;
			int Pending = 0;
			int Under_review = 0;

			int CorpCompleted = 0;
			int CorpPending = 0;
			int CorpUnder_review = 0;

			int corpbarcompleted = 0;
			int corpbarPending = 0;
			int corpbarincomplete = 0;

			/// Counts fetched for Dashborad page Pending kyc INDIVIDUAL details branch wise
			BigDecimal DubaiPendIndividuals = new BigDecimal("0");
			BigDecimal AbudhabiPendIndividuals = new BigDecimal("0");
			BigDecimal DeiraPendIndividuals = new BigDecimal("0");
			BigDecimal SharjhaPendIndividuals = new BigDecimal("0");
			BigDecimal RasalkhaimaPendIndividuals = new BigDecimal("0");
			BigDecimal SyndPendIndividuals = new BigDecimal("0");

			BigDecimal DubaiPendCorporate = new BigDecimal("0");
			BigDecimal AbudhabiPendCorporate = new BigDecimal("0");
			BigDecimal DeiraPendCorporate = new BigDecimal("0");
			BigDecimal SharjhaPendCorporate = new BigDecimal("0");
			BigDecimal RasalkhaimaPendCorporate = new BigDecimal("0");
			BigDecimal SyndPendCorporate = new BigDecimal("0");
			if (Dashboardpage.equals("DCD_ADMIN")) {
				Completed = ecddIndividualProfileRepository.Getcompletedcount();
				Under_review = ecddIndividualProfileRepository.GetIncompletedcount();
				Pending = ecddIndividualProfileRepository.GetPendingcount();

				CorpCompleted = kyc_corporate_repo.Getcompletedcount();
				CorpUnder_review = kyc_corporate_repo.GetIncompletedcount();
				CorpPending = kyc_corporate_repo.GetPendingcount();
			} else {
				Completed = ecddIndividualProfileRepository.Getbranchwisecompletedcount(BRANCHCODE);
				Under_review = ecddIndividualProfileRepository.GetbranchwiseIncompletedcount(BRANCHCODE);
				Pending = ecddIndividualProfileRepository.GetbranchwisePendingcount(BRANCHCODE);

				CorpCompleted = kyc_corporate_repo.Getbranchwisecompletedcount(BRANCHCODE);
				CorpUnder_review = kyc_corporate_repo.GetbranchwiseIncompletedcount(BRANCHCODE);
				CorpPending = kyc_corporate_repo.GetbranchwisePendingcount(BRANCHCODE);
			}

			corpbarcompleted = CorpCompleted;
			corpbarPending = CorpPending;
			corpbarincomplete = CorpUnder_review;

			List<Object[]> branchwiseIndividual = ecddIndividualProfileRepository.GetbranchPendingcount();

			for (int i = 0; i < branchwiseIndividual.size(); i++) {

				if (branchwiseIndividual.get(i)[0].toString() != null) {
					if (branchwiseIndividual.get(i)[0].toString().equals("9001")) {
						DubaiPendIndividuals = branchwiseIndividual.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseIndividual.get(i)[1].toString());
					}

					if (branchwiseIndividual.get(i)[0].toString().equals("9002")) {
						AbudhabiPendIndividuals = branchwiseIndividual.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseIndividual.get(i)[1].toString());
					}
					if (branchwiseIndividual.get(i)[0].toString().equals("9003")) {
						DeiraPendIndividuals = branchwiseIndividual.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseIndividual.get(i)[1].toString());
					}
					if (branchwiseIndividual.get(i)[0].toString().equals("9004")) {
						SharjhaPendIndividuals = branchwiseIndividual.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseIndividual.get(i)[1].toString());
					}

					if (branchwiseIndividual.get(i)[0].toString().equals("9008")) {
						SyndPendIndividuals = branchwiseIndividual.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseIndividual.get(i)[1].toString());
					}
				}

			}

			List<Object[]> branchwiseCorporate = kyc_corporate_repo.GetbranchPendingcount();
			for (int i = 0; i < branchwiseCorporate.size(); i++) {

				if (branchwiseCorporate.get(i)[0].toString() != null) {
					if (branchwiseCorporate.get(i)[0].toString().equals("9001")) {
						DubaiPendCorporate = branchwiseCorporate.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseCorporate.get(i)[1].toString());
					}

					if (branchwiseCorporate.get(i)[0].toString().equals("9002")) {
						AbudhabiPendCorporate = branchwiseCorporate.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseCorporate.get(i)[1].toString());
					}
					if (branchwiseCorporate.get(i)[0].toString().equals("9003")) {
						DeiraPendCorporate = branchwiseCorporate.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseCorporate.get(i)[1].toString());
					}
					if (branchwiseCorporate.get(i)[0].toString().equals("9004")) {
						SharjhaPendCorporate = branchwiseCorporate.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseCorporate.get(i)[1].toString());
					}

					if (branchwiseCorporate.get(i)[0].toString().equals("9008")) {
						SyndPendCorporate = branchwiseCorporate.get(i)[1] == null ? new BigDecimal("0")
								: new BigDecimal(branchwiseCorporate.get(i)[1].toString());
					}
				}

			}
			// Individuals Attribue
			md.addAttribute("DubaiPendIndividuals", DubaiPendIndividuals);
			md.addAttribute("AbudhabiPendIndividuals", AbudhabiPendIndividuals);
			md.addAttribute("DeiraPendIndividuals", DeiraPendIndividuals);
			md.addAttribute("SharjhaPendIndividuals", SharjhaPendIndividuals);
			md.addAttribute("RasalkhaimaPendIndividuals", RasalkhaimaPendIndividuals);
			md.addAttribute("SyndPendIndividuals", SyndPendIndividuals);

			// Corporate Attribute
			md.addAttribute("DubaiPendCorporate", DubaiPendCorporate);
			md.addAttribute("AbudhabiPendCorporate", AbudhabiPendCorporate);
			md.addAttribute("DeiraPendCorporate", DeiraPendCorporate);
			md.addAttribute("SharjhaPendCorporate", SharjhaPendCorporate);
			md.addAttribute("RasalkhaimaPendCorporate", RasalkhaimaPendCorporate);
			md.addAttribute("SyndPendCorporate", SyndPendCorporate);

			md.addAttribute("completed", Completed);
			md.addAttribute("Pending", Pending);
			md.addAttribute("Under_review", Under_review);
			md.addAttribute("Dashboardpage", Dashboardpage);
			md.addAttribute("corpbarcompleted", corpbarcompleted);
			md.addAttribute("corpbarPending", corpbarPending);
			md.addAttribute("corpbarincomplete", corpbarincomplete);

			md.addAttribute("Branch_code", BRANCHCODE);

			System.out.println(Dashboardpage);
		} else if (Dashboardpage.equals("BRC")) {
			LocalDate today = LocalDate.now(); // Get today's date
			Date fromDateToUse = java.sql.Date.valueOf(today.minusDays(1));

			int matchedCount = 0;
			int unmatchedSourceCount = 0;
			int unmatchedDestinationCount = 0;
			int totalTransactionCount = 0;

			List<BRECON_Common_Table_Entity> matchedList = bRECON_Common_Table_Rep.getcommondatavalues(fromDateToUse);
			matchedCount = (matchedList != null) ? matchedList.size() : 0;

			List<Brecon_core_entity> sourceList = coresystemlistrep.getcoresystemlistvalue(fromDateToUse);
			unmatchedSourceCount = (sourceList != null) ? sourceList.size() : 0;

			List<BRECON_DESTINATION_ENTITY> destList = bRECON_DESTINATION_REPO.getDestinationdatavalues(fromDateToUse);
			unmatchedDestinationCount = (destList != null) ? destList.size() : 0;

			List<Brecon_core_entity> TotalList = coresystemlistrep.getcoresystemlisttotvalue(fromDateToUse);
			totalTransactionCount = (TotalList != null) ? TotalList.size() : 0;

			// Add to model
			md.addAttribute("matchedCount", matchedCount);
			md.addAttribute("unmatchedSourceCount", unmatchedSourceCount);
			md.addAttribute("unmatchedDestinationCount", unmatchedDestinationCount);
			md.addAttribute("totalTransactionCount", totalTransactionCount);
			md.addAttribute("Dashboardpage", Dashboardpage);

			//// duplicates cbs records
			List<Object[]> cbsduplicaterecord = coresystemlistrep.getcbsduplicaterecord();
			md.addAttribute("cbsduplicaterecord", cbsduplicaterecord);
			//// duplicate AANI Payment Records
			List<Object[]> aaniduplicaterecord = bRECON_DESTINATION_REPO.getaaniduplicaterecord();
			md.addAttribute("aaniduplicaterecord", aaniduplicaterecord);

		} else if (Dashboardpage.equalsIgnoreCase("Superadmin")) {

			int completed = 0;
			int uncompleted = 0;

			List<ReportTitle> ls = reportServices.getDashBoardRepList(domainid);

			for (ReportTitle var : ls) {
				if (var.getCompletedFlg().equals('Y')) {
					completed++;
				} else {
					uncompleted++;
				}
			}

			List<Object[]> rawList = XBRLReportsMasterReps.getsinstatus();
			List<Map<String, Object>> brfStatusList = new ArrayList<>();
			for (Object[] row : rawList) {
				Map<String, Object> map = new HashMap<>();
				map.put("reportName", row[0]);
				map.put("description", row[1]);
				map.put("frequency", row[2]);
				map.put("reportingDate", row[3]);
				map.put("status", row[4]);
				brfStatusList.add(map);
			}
			md.addAttribute("brfStatusList", brfStatusList);
			md.addAttribute("menu", "Dashboard");
			md.addAttribute("netprofit", BRF004ReportServices.getBRF004View_one());

			md.addAttribute("reportList", ls);
			md.addAttribute("completed", completed);
			md.addAttribute("uncompleted", uncompleted);
			md.addAttribute("menu", "Dashboard");
			md.addAttribute("Dashboardpage", Dashboardpage);
			md.addAttribute("selectedFrequency", frequency);

		}

		md.addAttribute("menu", "Dashboard");
		return "XBRLDashboard";
	}

	@GetMapping("/profit-data")
	@ResponseBody
	public Map<String, Double> getProfitDataByYear(@RequestParam String year) {
		Map<String, BigDecimal> rawMap = BRF004ReportServices.getMonthlyProfitByYear(year);
		System.out.println("The Profit size is:" + rawMap.size());
		Map<String, Double> profitMap = new LinkedHashMap<>();
		for (Map.Entry<String, BigDecimal> entry : rawMap.entrySet()) {
			profitMap.put(entry.getKey(), entry.getValue().doubleValue());
		}
		return profitMap;
	}

	@GetMapping("/fetch-report-data")
	@ResponseBody
	public List<Map<String, Object>> getReportData(@RequestParam String reportDate) {
		List<Object[]> rawList = XBRLReportsMasterReps.getReportStatus(reportDate);
		List<Map<String, Object>> result = new ArrayList<>();

		for (Object[] row : rawList) {
			Map<String, Object> map = new HashMap<>();
			map.put("reportName", row[0]);
			map.put("description", row[1]);
			map.put("frequency", row[2]);
			map.put("reportingDate", row[3]);
			map.put("status", row[4]);
			result.add(map);
		}

		return result;
	}

	@Autowired
	BRF095AServiceRepo BRF095AServiceRepos;

	@RequestMapping(value = "/getvalues", method = RequestMethod.POST)
	@ResponseBody
	public List<BRF_095_A_REPORT_ENTITY> getvalues(@RequestParam(required = false) String year) {
		return BRF095AServiceRepos.getvalues(year);
	}

	@RequestMapping(value = "AccessandRoles", method = { RequestMethod.GET, RequestMethod.POST })
	public String IPSAccessandRoles(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String userid, @RequestParam(required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {

		String roleId = (String) req.getSession().getAttribute("ROLEID");
		md.addAttribute("IPSRoleMenu", AccessRoleService.getRoleMenu(roleId));

		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("menu", "ACCESS AND ROLES");
			md.addAttribute("menuname", "ACCESS AND ROLES");
			md.addAttribute("formmode", "list");
			md.addAttribute("AccessandRoles", accessandrolesrepository.rulelist());
		} else if (formmode.equals("add")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - ADD");
			md.addAttribute("formmode", "add");
		} else if (formmode.equals("edit")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - EDIT");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));
		} else if (formmode.equals("view")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - INQUIRY");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));

		} else if (formmode.equals("verify")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - VERIFY");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));

		} else if (formmode.equals("delete")) {
			md.addAttribute("menuname", "ACCESS AND ROLES - DELETE");
			md.addAttribute("formmode", formmode);
			md.addAttribute("IPSAccessRole", AccessRoleService.getRoleId(userid));
		}

		md.addAttribute("adminflag", "adminflag");
		md.addAttribute("userprofileflag", "userprofileflag");

		return "AccessandRoles";
	}

	@RequestMapping(value = "createAccessRole", method = RequestMethod.POST)
	@ResponseBody
	public String createAccessRoleEn(@RequestParam("formmode") String formmode,
			@RequestParam(value = "adminValue", required = false) String adminValue,
			@RequestParam(value = "BRF_ReportsValue", required = false) String BRF_ReportsValue,
			@RequestParam(value = "Basel_ReportsValue", required = false) String Basel_ReportsValue,
			@RequestParam(value = "ArchivalValue", required = false) String ArchivalValue,
			@RequestParam(value = "Audit_InquiriesValue", required = false) String Audit_InquiriesValue,
			@RequestParam(value = "RBR_ReportsValue", required = false) String RBR_ReportsValue,
			@RequestParam(value = "VAT_LedgerValue", required = false) String VAT_LedgerValue,
			@RequestParam(value = "Invoice_DataValue", required = false) String Invoice_DataValue,
			@RequestParam(value = "ReconciliationValue", required = false) String ReconciliationValue,
			@RequestParam(value = "finalString", required = false) String finalString,

			@ModelAttribute AccessAndRoles alertparam, Model md, HttpServletRequest rq) {

		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		md.addAttribute("IPSRoleMenu", AccessRoleService.getRoleMenu(roleId));

		String msg = AccessRoleService.addPARAMETER(alertparam, formmode, adminValue, BRF_ReportsValue,
				Basel_ReportsValue, ArchivalValue, Audit_InquiriesValue, RBR_ReportsValue, ReconciliationValue,
				VAT_LedgerValue, Invoice_DataValue, finalString, userid);

		return msg;

	}

	@RequestMapping(value = "resetPassword1", method = { RequestMethod.GET, RequestMethod.POST })
	public String showResetPasswordPage(Model md, HttpServletRequest req) {
		String Passworduser = (String) req.getSession().getAttribute("USERID");
		String Passwordresest = (String) req.getSession().getAttribute("PASSWORDERROR");

		md.addAttribute("Resetuserid", Passworduser);
		md.addAttribute("Resetreason", Passwordresest);
		return "XBRLresetPassword"; // Name of the HTML file (resetPassword.html)
	}

	@PostMapping("/resetPassword")
	public String resetPassword(@RequestParam String userid, @RequestParam String newPassword)
			throws ParseException, NoSuchAlgorithmException, InvalidKeySpecException {
		Optional<UserProfile> userOptional = userProfileRep.findById(userid);
		String encryptedPassword = PasswordEncryption.getEncryptedPassword(newPassword);
		if (userOptional.isPresent()) {
			UserProfile user = userOptional.get();
			user.setPassword(encryptedPassword); // Encrypt the new password
			String localdateval = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			LocalDate date = LocalDate.parse(localdateval);
			BigDecimal passexpdays = new BigDecimal(user.getPass_exp_days());
			LocalDate date2 = date.plusDays(passexpdays.intValue());
			user.setLog_in_count("1");
			user.setNo_of_attmp(0);
			user.setUser_status("Active");
			user.setUser_status("Active");
			user.setDisable_flg("N");
			user.setUser_locked_flg("N");
			user.setPass_exp_date(new SimpleDateFormat("yyyy-MM-dd").parse(date2.toString()));// Reset the flag
			userProfileRep.save(user);
			return "redirect:login?resetSuccess";
		}

		return "redirect:resetPassword1?error=User not found";
	}

	@GetMapping("/getRoleDetails")
	@ResponseBody
	public AccessAndRoles getRoleDetails(@RequestParam String roleId) {
		System.out.println("role id for fetching is : " + roleId);
		return accessandrolesrepository.findById(roleId).orElse(null);
	}

	@RequestMapping(value = "UserProfile", method = { RequestMethod.GET, RequestMethod.POST })
	public String userprofile(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String userid,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {

		int currentPage = page.orElse(0);
		int pageSize = size.orElse(Integer.parseInt(pagesize));

		String loginuserid = (String) req.getSession().getAttribute("USERID");
		String WORKCLASSAC = (String) req.getSession().getAttribute("WORKCLASS");
		String ROLEIDAC = (String) req.getSession().getAttribute("ROLEID");
		md.addAttribute("RuleIDType", accessandrolesrepository.roleidtype());

		System.out.println("work class is : " + WORKCLASSAC);
		// Logging Navigation
		loginServices.SessionLogging("USERPROFILE", "M2", req.getSession().getId(), loginuserid, req.getRemoteAddr(),
				"ACTIVE");
		Session hs1 = sessionFactory.getCurrentSession();
		md.addAttribute("menu", "USER PROFILE"); // To highlight the menu

		if (formmode == null || formmode.equals("list")) {

			md.addAttribute("formmode", "list");// to set which form - valid values are "edit" , "add" & "list"
			md.addAttribute("WORKCLASSAC", WORKCLASSAC);
			md.addAttribute("ROLEIDAC", ROLEIDAC);
			md.addAttribute("loginuserid", loginuserid);

			Iterable<UserProfile> user = loginServices.getUsersList(ROLEIDAC);

			md.addAttribute("userProfiles", user);

		} else if (formmode.equals("edit")) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("domains", reportServices.getDomainList());
			md.addAttribute("userProfile", loginServices.getUser(userid));

		} else if (formmode.equals("verify")) {

			md.addAttribute("formmode", formmode);
			md.addAttribute("domains", reportServices.getDomainList());
			md.addAttribute("userProfile", loginServices.getUser(userid));

		} else {

			md.addAttribute("formmode", formmode);
			md.addAttribute("domains", reportServices.getDomainList());
			md.addAttribute("FinUserProfiles", loginServices.getFinUsersList());
			md.addAttribute("userProfile", loginServices.getUser(""));

		}

		return "XBRLUserprofile";
	}

	@RequestMapping(value = "Audit", method = RequestMethod.GET)
	public String audit(Model md, HttpServletRequest req) {

		String userid = (String) req.getSession().getAttribute("USERID");
		// Logging Navigation
		loginServices.SessionLogging("AUDIT", "M11", req.getSession().getId(), userid, req.getRemoteAddr(), "ACTIVE");

		LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		md.addAttribute("menu", "Audit");
		md.addAttribute("auditlogs", reportServices.getAuditLog(
				Date.from(localDateTime.plusDays(-5).atZone(ZoneId.systemDefault()).toInstant()), new Date()));
		return "XBRLAudit";
	}

	@RequestMapping(value = "Userlog", method = RequestMethod.GET)
	public String userlog(Model md, HttpServletRequest req) {

		String userid = (String) req.getSession().getAttribute("USERID");
		// Logging Navigation
		loginServices.SessionLogging("USERLOG", "M4", req.getSession().getId(), userid, req.getRemoteAddr(), "ACTIVE");

		LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

		md.addAttribute("menu", "Userlog");
		md.addAttribute("userlog", loginServices.getUserLog(
				Date.from(localDateTime.plusDays(-5).atZone(ZoneId.systemDefault()).toInstant()), new Date()));

		return "XBRLUserLogs";
	}

	@RequestMapping(value = "XBRLReports", method = RequestMethod.GET)
	public String xbrlrep(Model md, HttpServletRequest req) {

		md.addAttribute("menu", "XBRLReports");

		String domainid = (String) req.getSession().getAttribute("DOMAINID");

		md.addAttribute("reportlist", reportServices.getReportsList(domainid));
		return "XBRLReports";
	}

	@RequestMapping(value = "MISReports", method = RequestMethod.GET)
	public String xbrlMISReports(Model md, HttpServletRequest req) {

		String userid = (String) req.getSession().getAttribute("USERID");

		// Logging Navigation
		loginServices.SessionLogging("MISREPORTS", "M12", req.getSession().getId(), userid, req.getRemoteAddr(),
				"ACTIVE");

		md.addAttribute("menu", "MISReports");

		String domainid = (String) req.getSession().getAttribute("DOMAINID");

		md.addAttribute("reportlist", reportServices.getMISReportsList(domainid));

		return "XBRLMISReports";
	}

	@RequestMapping(value = "Finuserdata", method = RequestMethod.GET)
	public ModelAndView Finuserdata(@RequestParam String userid) {
		ModelAndView mv = new ModelAndView("XBRLUserprofile::finuserapply");
		mv.addObject("formmode", "add");

		mv.addObject("userProfile", loginServices.getFinUser(userid));
		return mv;

	}

	@RequestMapping(value = "createUser", method = RequestMethod.POST)
	@ResponseBody
	public String createUser(@RequestParam("formmode") String formmode, @ModelAttribute UserProfile userprofile,
			Model md, HttpServletRequest rq) {
		String MOB = (String) rq.getSession().getAttribute("MOBILENUMBER");
		String ROLE = (String) rq.getSession().getAttribute("ROLEDESC");
		String userid = (String) rq.getSession().getAttribute("USERID");
		String username = (String) rq.getSession().getAttribute("USERNAME");
		String msg = loginServices.addUser(userprofile, formmode, userid, username, MOB, ROLE);

		return msg;

	}

	@RequestMapping(value = "deleteuser", method = RequestMethod.POST)
	@ResponseBody
	public String deleteuser(@RequestParam("formmode") String userid, Model md, HttpServletRequest rq) {

		String msg = loginServices.deleteuser(userid);

		return msg;

	}

	@RequestMapping(value = "createAlter", method = RequestMethod.POST)
	@ResponseBody
	public String createAlter(@RequestParam("formmode") String formmode, @RequestParam("report_srl") String report_srl,
			@ModelAttribute AlertEntity alertEntity, Model md, HttpServletRequest rq) {
		String MOB = (String) rq.getSession().getAttribute("MOBILENUMBER");
		String ROLE = (String) rq.getSession().getAttribute("ROLEDESC");
		String userid = (String) rq.getSession().getAttribute("USERID");
		String username = (String) rq.getSession().getAttribute("USERNAME");
		System.out.println(formmode);
		System.out.println(report_srl);
		String[] a = report_srl.split(",");
		System.out.println(a[0]);
		String report_srl1 = a[0];
		String msg = loginServices.addalerter(alertEntity, formmode, userid, username, MOB, ROLE, report_srl1);

		return msg;

	}

	@RequestMapping(value = "verifyUser", method = RequestMethod.POST)
	@ResponseBody
	public String verifyUser(@ModelAttribute UserProfile userprofile, Model md, HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		String msg = loginServices.verifyUser(userprofile, userid);

		return msg;

	}

	@RequestMapping(value = "passwordReset", method = RequestMethod.POST)
	@ResponseBody
	public String passwordReset(@ModelAttribute UserProfile userprofile, Model md, HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		String msg = loginServices.passwordReset(userprofile, userid);

		return msg;

	}

	@RequestMapping(value = "defaultpasswordReset", method = RequestMethod.POST)
	@ResponseBody
	public String DefaultpasswordReset(@ModelAttribute UserProfile userprofile, Model md, HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		String msg = loginServices.DefaultpasswordReset(userprofile, userid);

		return msg;

	}

	@RequestMapping(value = "changePassword", method = RequestMethod.POST)
	@ResponseBody
	public String changePassword(@RequestParam("oldpass") String oldpass, @RequestParam("newpass") String newpass,
			Model md, HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		String msg = loginServices.changePassword(oldpass, newpass, userid);

		return msg;

	}

	@RequestMapping(value = "updateValidity", method = RequestMethod.POST)
	@ResponseBody
	public String updateValidity(@RequestParam("reportid") String reportid, String valid, HttpServletRequest rq) {

		String userid = (String) rq.getSession().getAttribute("USERID");

		return reportServices.updateValidity(reportid, valid, userid);

	}

	@RequestMapping(value = "userLogs/Download", method = RequestMethod.GET)
	@ResponseBody
	public InputStreamResource UserDownload(HttpServletResponse response, @RequestParam String fromdate,
			@RequestParam String todate) throws IOException, SQLException {
		response.setContentType("application/octet-stream");

		InputStreamResource resource = null;

		try {
			Date fromdate2 = new SimpleDateFormat("dd-MM-yyyy").parse(fromdate);
			Date todate2 = new SimpleDateFormat("dd-MM-yyyy").parse(todate);
			File repfile = loginServices.getUserLogFile(fromdate2, todate2);
			response.setHeader("Content-Disposition", "attachment; filename=" + repfile.getName());
			resource = new InputStreamResource(new FileInputStream(repfile));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resource;
	}

	@RequestMapping(value = "auditLogs/Download", method = RequestMethod.GET)
	@ResponseBody
	public InputStreamResource auditDownload(HttpServletResponse response, @RequestParam String fromdate,
			@RequestParam String todate) throws IOException, SQLException {
		response.setContentType("application/octet-stream");

		InputStreamResource resource = null;

		try {
			Date fromdate2 = new SimpleDateFormat("dd-MM-yyyy").parse(fromdate);
			Date todate2 = new SimpleDateFormat("dd-MM-yyyy").parse(todate);
			File repfile = reportServices.getAuditLogFile(fromdate2, todate2);
			response.setHeader("Content-Disposition", "attachment; filename=" + repfile.getName());
			resource = new InputStreamResource(new FileInputStream(repfile));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resource;
	}

	@RequestMapping(value = "logoutUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String logoutUpdate(HttpServletRequest req) {

		String msg;

		String userid = (String) req.getSession().getAttribute("USERID");

		try {
			logger.info("Updating Logout");
			loginServices.SessionLogging("LOGOUT", "M0", req.getSession().getId(), userid, req.getRemoteAddr(),
					"IN-ACTIVE");
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
			msg = "failed";
		}
		return msg;
	}

	@RequestMapping(value = "ReconFileUpload", method = { RequestMethod.GET, RequestMethod.POST })
	public String Debit_Card_Fileupload(Model md, HttpServletRequest req) {
		String roleId = (String) req.getSession().getAttribute("ROLEID");

		// md.addAttribute("reportvalue", "RBS Reports");
		// md.addAttribute("reportid", "RBSReports");
		md.addAttribute("menu", "ReconFileUpload");
		String domainid = (String) req.getSession().getAttribute("DOMAINID");

		return "BRECON/ReconFileupload";
	}

	@RequestMapping(value = "createAlert", method = RequestMethod.POST)
	@ResponseBody
	public String createRule(@RequestParam("formmode") String formmode,
			@ModelAttribute AlertManagementEntity alertparam, Model md, HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");

		String msg = alertservices.addAlert(alertparam, formmode, userid);

		return msg;

	}

	@RequestMapping(value = "User_Audit", method = RequestMethod.GET)
	public String Service_Audit(Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		System.out.println("The login userid is : " + userid);

		LocalDateTime localDateTime = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		System.out.println("The time is " + localDateTime);

		md.addAttribute("menu", "Audit");

		// Add both lists to the model
		md.addAttribute("auditlogss", reportServices.getAuditservices());
		md.addAttribute("userAuditLevels", reportServices.getUserAuditLevelList());

		return "User_Audit";
	}

	@RequestMapping(value = "Audits", method = { RequestMethod.GET, RequestMethod.POST })
	public String Audits(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String delete_cust_id,
			@RequestParam(value = "page", required = false) Optional<Integer> page,
			@RequestParam(value = "size", required = false) Optional<Integer> size, Model md, HttpServletRequest req) {
		List<MANUAL_Service_Entity> changes = mANUAL_Service_Rep.getServiceAuditList(auditRefNo); // or use
																									// findByAuditRefNo()

		if (changes == null || changes.isEmpty()) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		for (MANUAL_Service_Entity entity : changes) {
			sb.append(entity.getField_name()).append(": OldValue: ").append(entity.getOld_value())
					.append(", NewValue: ").append(entity.getNew_value()).append("|||");
		}
		String loginuserid = (String) req.getSession().getAttribute("USERID");
		List<UserProfile> list = loginServices.getUsersListone(loginuserid);
		md.addAttribute("domainid", list);
		if (formmode == null || formmode.equals("list")) {
			System.out.println("hi");
			md.addAttribute("formmode", "list");
			List<MANUAL_Service_Entity> serviceAudits = mANUAL_Service_Rep.getServiceAuditList(auditRefNo);
			md.addAttribute("audits", serviceAudits);
		}
		// md.addAttribute("inlist", AUD_SERVICE_REPO.findbyId(delete_cust_id));

		// to set which form - valid values are "edit" , "add" & "list"
		// md.addAttribute("CustomerKYC",
		// CMGrepository.findAll(PageRequest.of(currentPage, pageSize)));

		else if (formmode.equals("edit")) {
			System.out.println("hlo");
			md.addAttribute("formmode", "edit");
			/* md.addAttribute("inlist", AUD_SERVICE_REPO.getInquirelist()); */
			md.addAttribute("audit", reportServices.getUserAuditLevelList());

		} else if (formmode.equals("add")) {
			md.addAttribute("formmode", "add");
			/* md.addAttribute("inlist", AUD_SERVICE_REPO.getInquirelist()); */
			md.addAttribute("inlist", AUD_SERVICE_REPO.getInquirelist());

		} else if (formmode.equals("delete")) {
			md.addAttribute("formmode", "delete");
			md.addAttribute("inlist", AUD_SERVICE_REPO.getInquirelist());

		} else if (formmode.equals("download")) {
			md.addAttribute("formmode", "download");
			md.addAttribute("inlist", AUD_SERVICE_REPO.getInquirelist());

		}

		else {

			md.addAttribute("formmode", formmode);
		}

		return "Audits";
	}

	@RequestMapping(value = "getchanges2", method = RequestMethod.GET)
	@ResponseBody
	public String getchanges2(@RequestParam("audit_ref_no") String auditRefNo) {
		System.out.println("Received audit_ref_no: " + auditRefNo);

		try {
			List<MANUAL_Service_Entity> changes = mANUAL_Service_Rep.getServiceAudiT(auditRefNo);

			if (changes == null || changes.isEmpty()) {
				return ""; // No data found
			}

			StringBuilder sb = new StringBuilder();
			for (MANUAL_Service_Entity entity : changes) {
				sb.append(entity.getField_name()).append(": OldValue: ").append(entity.getOld_value())
						.append(", NewValue: ").append(entity.getNew_value()).append("|||");
			}

			return sb.toString();

		} catch (Exception e) {
			e.printStackTrace();
			return "Error: " + e.getMessage();
		}
	}

	@RequestMapping(value = "customervarson", method = RequestMethod.POST)
	@ResponseBody
	public String barathvarson(Model md, HttpServletRequest rq, @ModelAttribute RBRcustomer_entity rBRcustomer_entity,
			String cif_no) {
		System.out.println(rBRcustomer_entity.getCif_no());
		System.out.println("The solid Id >>>>>>>>>>>>>>>>>>>>>>>>> " + rBRcustomer_entity.getCename());
		System.out.println("The solid Id >>>>>>>>>>>>>>>>>>>>>>>>> " + rBRcustomer_entity.getGender());
		RBRcustomer_entity up = rBRcustomer_entity;

		rBRcustomerRepo.save(up);
		return "success";
	}

	@RequestMapping(value = "RBRReportDownload", method = RequestMethod.GET)

	@ResponseBody
	public InputStreamResource RBRReportDownload(HttpServletResponse response,
			@RequestParam(value = "filetype", required = false) String filetype,
			@RequestParam(value = "tabName", required = false) String tabName, HttpServletRequest req,
			@RequestParam(value = "operationData", required = false) String operationData)
			throws IOException, SQLException, JRException {

		response.setContentType("application/octet-stream");
		System.out.println(operationData);

		InputStreamResource resource = null;
		try {
			File repfile = reportServices.getRBRFile(filetype, tabName, operationData, req);

			response.setHeader("Content-Disposition", "attachment; filename=" + repfile.getName());
			response.setContentType(
					"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=windows-1256");
			response.setCharacterEncoding("windows-1256");

			try (InputStream inputStream = new FileInputStream(repfile);
					OutputStream outputStream = response.getOutputStream()) {

				byte[] buffer = new byte[1024];
				int bytesRead;

				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				outputStream.flush();
			}
		} catch (FileNotFoundException e) {
			// Handle file not found exception
			e.printStackTrace(); // Consider logging or handling the exception appropriately
		} catch (IOException e) {
			// Handle IO exception
			e.printStackTrace(); // Consider logging or handling the exception appropriately
		} catch (Exception e) {
			// Handle other exceptions
			e.printStackTrace(); // Consider logging or handling the exception appropriately
		}

		return resource;
	}

	// CREATED BY GOWTHAM
	@RequestMapping(value = "RBRMasterReportDownload", method = RequestMethod.GET)
	@ResponseBody
	public void RBRMasterReportDownload(HttpServletResponse response,
			@RequestParam(value = "filetype", required = false, defaultValue = "xlsx") String filetype,
			@RequestParam(value = "formmode", required = true) String formmode, HttpServletRequest req)
			throws IOException, JRException, SQLException {

		System.out.println("Generating Excel report for formmode: " + formmode);

		// Generate the Excel file
		File reportFile = reportServices.getMasterRBRFile(formmode, req);

		if (reportFile == null || !reportFile.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "File not found");
			return;
		}

		// Set response headers for file download
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + reportFile.getName() + "\"");
		response.setCharacterEncoding("UTF-8");

		// Write file data to response output stream
		try (InputStream inputStream = new FileInputStream(reportFile);
				OutputStream outputStream = response.getOutputStream()) {

			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			outputStream.flush(); // Ensure all data is written
		} catch (IOException e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing file");
		}
	}

	@RequestMapping(value = "RBR_Master", method = { RequestMethod.GET, RequestMethod.POST })
	public String RBRcustomer_data(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String cif_no, @RequestParam(required = false) String tab, Model md,
			HttpServletRequest req, String cin, @ModelAttribute RBRShareHolder_Entity details1,
			@ModelAttribute RBRcustomer_entity details2, @ModelAttribute Facitlity_Entity details3,
			@ModelAttribute Security_Entity details4, @ModelAttribute Provision_Entity details5,
			@ModelAttribute RBROverall_Data_Entity details6, @ModelAttribute RBR_Legal_Cases_Entity details7,
			@ModelAttribute RBR_Inverstments_Entity details8) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String Roleid = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String WORK_CLASS = (String) req.getSession().getAttribute("WORKCLASS");
		String USER_PERMISSIONS = (String) req.getSession().getAttribute("PERMISSIONS");
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("userid", "userid");

			if (Roleid.equals("RBR")) {
				md.addAttribute("listcustomer", RBRReportservice.getcustdata());
			} else {
				md.addAttribute("listcustomer", RBRReportservice.getBranchcustdata(BRANCHCODE));
			}

			md.addAttribute("USER_ID", userid);

		} else if (formmode.equals("getbycin")) {
			md.addAttribute("tab", tab);
			md.addAttribute("formmode", "add");
			md.addAttribute("listcustomer", rBRcustomerRepo.getbycif_no(cif_no));
			md.addAttribute("listShare", rbrShareHolder_Repo.getbyview(cin));
			md.addAttribute("listFacility", facility_Repo.getbyview(cin));
			md.addAttribute("listSecurity", security_Repo.getbyview(cin));
			md.addAttribute("listProvision", Provision_Repo.getbyview(cin));
			md.addAttribute("listoverall", RBRoverall_Data_Repo.getbyview(cin));
			md.addAttribute("listlegalcases", RBR_Legal_Cases_Repo.getbyview(cin));
			md.addAttribute("listInverstmentscases", RBR_Inverstments_Repo.getbyview(cin));

		} else if (formmode.equals("verify")) {
			md.addAttribute("formmode", "verify");
			md.addAttribute("listcustomer", rBRcustomerRepo.getcin(cin));
			md.addAttribute("listShare", rbrShareHolder_Repo.getview(cin));
			md.addAttribute("listFacility", facility_Repo.getview(cin));
			md.addAttribute("listSecurity", security_Repo.getview(cin));
			md.addAttribute("listProvision", Provision_Repo.getview(cin));
			md.addAttribute("listoverall", RBRoverall_Data_Repo.getview(cin));
			md.addAttribute("listlegalcases", RBR_Legal_Cases_Repo.getview(cin));
			md.addAttribute("listInverstmentscases", RBR_Inverstments_Repo.getview(cin));

		} else if (formmode.equals("updatecin")) {
			md.addAttribute("formmode", "updatecin");
			md.addAttribute("listcustomer", rBRcustomerRepo.getbycif_no(cif_no));

		} else {
			System.out.println("EMPTY");
		}

		return "RBRMaster";

	}

	@RequestMapping(value = "Customerdata", method = { RequestMethod.GET, RequestMethod.POST })
	public String RBRcustomer_data(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String Srl_no, @RequestParam(required = false) String cif_no,
			@RequestParam(required = false) String tab, Model md, HttpServletRequest req, String cin,
			@ModelAttribute RBRcustomer_entity details2) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String Roleid = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String WORK_CLASS = (String) req.getSession().getAttribute("WORKCLASS");
		String USER_PERMISSIONS = (String) req.getSession().getAttribute("PERMISSIONS");
		if (formmode == null || formmode.equals("Customerdata")) {
			md.addAttribute("formmode", "Customerdata");
			md.addAttribute("userid", "userid");
			md.addAttribute("RBRMenuname", "Customer Data");

			if (Roleid.equals("RBR")) {
				md.addAttribute("listcustomerveri", rBRcustomerRepo.getcustomerdata());
				md.addAttribute("listcustomerunveri", rBRcustomerRepo.getcustomerdataunveri());
			} else {
				md.addAttribute("listcustomerveri", rBRcustomerRepo.getcustomerbranchdata(BRANCHCODE));
				md.addAttribute("listcustomerunveri", rBRcustomerRepo.getcustomerbranchdataunveri(BRANCHCODE));
			}
		} else if (formmode.equals("Customeredit")) {
			md.addAttribute("formmode", "Customeredit");
			md.addAttribute("Custedit", rBRcustomerRepo.getcustomeredit(Srl_no));
			md.addAttribute("RBRMenuname", "Customer Edit");
		} else if (formmode.equals("Customeradd")) {
			md.addAttribute("formmode", "Customeradd");
			Long Cust_Srl_no = rBRcustomerRepo.GetCustsrl_no();
			md.addAttribute("Cust_Srl_no", Cust_Srl_no.toString());
			md.addAttribute("RBRMenuname", "Customer Add");
		} else {

		}

		return "RBRMasterdata";

	}

	@RequestMapping(value = "Custdataoperation", method = RequestMethod.POST)
	@ResponseBody
	public String createcustdata(@RequestParam("formmode") String formmode,
			@ModelAttribute RBRcustomer_entity RBRcustomer_entity, Model md, HttpServletRequest rq)
			throws NoSuchAlgorithmException, InvalidKeySpecException, ParseException, IOException {
		System.out.println();
		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) rq.getSession().getAttribute("BRANCHCODE");

		String msg = RBRReportservice.Custdataoperation(RBRcustomer_entity, formmode, userid, BRANCHCODE);

		return msg;

	}

	@RequestMapping(value = "Partnerdata", method = { RequestMethod.GET, RequestMethod.POST })
	public String RBRPartnerdata(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String Srl_no, @RequestParam(required = false) String cif_no,
			@RequestParam(required = false) String tab, Model md, HttpServletRequest req, String cin,
			@ModelAttribute RBRShareHolder_Entity details2) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String Roleid = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String WORK_CLASS = (String) req.getSession().getAttribute("WORKCLASS");
		String USER_PERMISSIONS = (String) req.getSession().getAttribute("PERMISSIONS");
		if (formmode == null || formmode.equals("Partnerdata")) {
			md.addAttribute("formmode", "Partnerdata");
			md.addAttribute("userid", "userid");
			md.addAttribute("RBRMenuname", "Partner Data");

			if (Roleid.equals("RBR")) {
				md.addAttribute("listpartnerveri", rbrShareHolder_Repo.getverifiedpartner());
				md.addAttribute("listpartnerunveri", rbrShareHolder_Repo.getunverifiedpartner());
			} else {
				md.addAttribute("listpartnerveri", rbrShareHolder_Repo.getverifiedbranchpartner(BRANCHCODE));
				md.addAttribute("listpartnerunveri", rbrShareHolder_Repo.getunverifiedpartner());
			}

		} else if (formmode.equals("Partnerdataedit")) {
			md.addAttribute("formmode", "Partnerdataedit");
			RBRcustomer_entity RBRcustomer_entity = rBRcustomerRepo.getcustomeredit(Srl_no);
			md.addAttribute("RBRMenuname", "Partner Edit");
			/*
			 * String SUBBORR = RBRcustomer_entity.getSub_bor_type();
			 * md.addAttribute("SUBBORR", SUBBORR);
			 */
			md.addAttribute("Partneredit", rbrShareHolder_Repo.getpartnersrlno(Srl_no));
		} else if (formmode.equals("Partneradd")) {

			md.addAttribute("formmode", "Partneradd");
			Long Partner_Srl_no = rbrShareHolder_Repo.getAuditRefUUID();
			md.addAttribute("Partner_Srl_no", Partner_Srl_no.toString());
			md.addAttribute("RBRMenuname", "Partner Add");
		} else {

		}

		return "RBRMasterdata";

	}

	@RequestMapping(value = "Partnerdataoperation", method = RequestMethod.POST)
	@ResponseBody
	public String Partnerdataoperation(@RequestParam("formmode") String formmode,
			@ModelAttribute RBRShareHolder_Entity RBRShareHolder_Entity, Model md, HttpServletRequest rq)
			throws Exception {

		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) rq.getSession().getAttribute("BRANCHCODE");

		String msg = RBRReportservice.Partnerdataoperation(RBRShareHolder_Entity, formmode, userid, BRANCHCODE);

		return msg;

	}

	@RequestMapping(value = "Securitydata", method = { RequestMethod.GET, RequestMethod.POST })
	public String RBRSecuritydata(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String Srl_no, @RequestParam(required = false) String cif_no,
			@RequestParam(required = false) String tab, Model md, HttpServletRequest req, String cin,
			@ModelAttribute Security_Entity details2) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String Roleid = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String WORK_CLASS = (String) req.getSession().getAttribute("WORKCLASS");
		String USER_PERMISSIONS = (String) req.getSession().getAttribute("PERMISSIONS");
		if (formmode == null || formmode.equals("Securitydata")) {
			md.addAttribute("formmode", "Securitydata");
			md.addAttribute("userid", "userid");
			md.addAttribute("RBRMenuname", "Security Data");

			if (Roleid.equals("RBR")) {
				md.addAttribute("listsecuveri", security_Repo.getsecurityveri());
				md.addAttribute("listsecuunveri", security_Repo.getsecurityunveri());
			} else {
				md.addAttribute("listsecuveri", security_Repo.getsecuritybranch_codeveri(BRANCHCODE));
				md.addAttribute("listsecuunveri", security_Repo.getsecuritybranch_codeunveri(BRANCHCODE));
			}

		} else if (formmode.equals("Securitydataedit")) {

			md.addAttribute("formmode", "Securitydataedit");
			md.addAttribute("Securityedit", security_Repo.Getsecuritysrlno(Srl_no));
			md.addAttribute("RBRMenuname", "Security Edit");
		} else if (formmode.equals("Securityadd")) {
			md.addAttribute("formmode", "Securityadd");
			Long Security_Srl_no = security_Repo.getAuditRefUUID();
			md.addAttribute("Security_Srl_no", Security_Srl_no.toString());
			md.addAttribute("RBRMenuname", "Security Add");
		} else {

		}

		return "RBRMasterdata";

	}

	@RequestMapping(value = "Securitydataoperation", method = RequestMethod.POST)
	@ResponseBody
	public String Securitydataoperation(@RequestParam("formmode") String formmode,
			@ModelAttribute Security_Entity Security_Entity, Model md, HttpServletRequest rq)
			throws NoSuchAlgorithmException, InvalidKeySpecException, ParseException, IOException {

		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) rq.getSession().getAttribute("BRANCHCODE");

		String msg = RBRReportservice.Securitydataopr(Security_Entity, formmode, userid, BRANCHCODE, null);

		return msg;

	}

	@PostMapping("/Securitydataoperation/upload")
	@ResponseBody
	public ResponseEntity<String> Securitydataoperation(@RequestParam("formmode") String formmode,
			@RequestParam("file") MultipartFile file, HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		try {

			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body("File is empty.");
			}

			String msg = RBRReportservice.Securitydataupload(file, userid);
			return ResponseEntity.ok("success");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed: " + ex.getMessage());
		}
	}

	@PostMapping("/Securitydataoperation/verifyall")
	@ResponseBody
	public ResponseEntity<?> verifySecurity(@RequestParam("formmode") String formmode, @RequestBody List<Long> ids,
			HttpServletRequest rq) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) rq.getSession().getAttribute("BRANCHCODE");

		String msg = RBRReportservice.Securitydataopr(null, formmode, userid, BRANCHCODE, ids);

		return ResponseEntity.ok(msg);
	}

	@RequestMapping(value = "Facilitydata", method = { RequestMethod.GET, RequestMethod.POST })
	public String RBRFacilitydata(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String Srl_no, @RequestParam(required = false) String cif_no,
			@RequestParam(required = false) String tab, Model md, HttpServletRequest req, String cin,
			@ModelAttribute Facitlity_Entity details2) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String Roleid = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String WORK_CLASS = (String) req.getSession().getAttribute("WORKCLASS");
		String USER_PERMISSIONS = (String) req.getSession().getAttribute("PERMISSIONS");
		if (formmode == null || formmode.equals("Facilitydata")) {
			md.addAttribute("formmode", "Facilitydata");
			md.addAttribute("userid", "userid");
			md.addAttribute("RBRMenuname", "Facility Data");

			if (Roleid.equals("RBR")) {
				md.addAttribute("listFaciveri", facility_Repo.getfacveri());
				md.addAttribute("listFaciunveri", facility_Repo.getfacunveri());
			} else {
				md.addAttribute("listFaciveri", facility_Repo.getfacbranch_codeveri(BRANCHCODE));
				md.addAttribute("listFaciunveri", facility_Repo.getfacbranch_codeunveri(BRANCHCODE));
			}
		} else if (formmode.equals("Facilitydataedit")) {

			md.addAttribute("formmode", "Facilitydataedit");
			md.addAttribute("Facdataedit", facility_Repo.getfacsrlno(Srl_no));
			md.addAttribute("RBRMenuname", "Facility Edit");
		} else if (formmode.equals("Facilityadd")) {
			md.addAttribute("formmode", "Facilityadd");
			Long FAC_Srl_no = facility_Repo.getAuditRefUUID();
			md.addAttribute("FAC_Srl_no", FAC_Srl_no.toString());
			md.addAttribute("RBRMenuname", "Facility Add");
		} else {

		}

		return "RBRSecusheets";

	}

	@RequestMapping(value = "Facilitydataoperation", method = RequestMethod.POST)
	@ResponseBody
	public String Facilitydataoperation(@RequestParam("formmode") String formmode,
			@ModelAttribute Facitlity_Entity Facitlity_Entity, Model md, HttpServletRequest rq)
			throws NoSuchAlgorithmException, InvalidKeySpecException, ParseException, IOException {

		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) rq.getSession().getAttribute("BRANCHCODE");

		String msg = RBRReportservice.Facilitydataopr(Facitlity_Entity, formmode, userid, BRANCHCODE);

		return msg;

	}

	@RequestMapping(value = "Provisiondata", method = { RequestMethod.GET, RequestMethod.POST })
	public String RBRProvisiondata(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String Srl_no, @RequestParam(required = false) String cif_no,
			@RequestParam(required = false) String tab, Model md, HttpServletRequest req, String cin,
			@ModelAttribute Provision_Entity details2) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String Roleid = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String WORK_CLASS = (String) req.getSession().getAttribute("WORKCLASS");
		String USER_PERMISSIONS = (String) req.getSession().getAttribute("PERMISSIONS");
		if (formmode == null || formmode.equals("Provisiondata")) {
			md.addAttribute("formmode", "Provisiondata");
			md.addAttribute("userid", "userid");
			md.addAttribute("RBRMenuname", "Provision Data");

			if (Roleid.equals("RBR")) {
				md.addAttribute("listprovveri", Provision_Repo.getproveri());
				md.addAttribute("listprovunveri", Provision_Repo.getprovunveri());
			} else {
				md.addAttribute("listprovveri", Provision_Repo.getprobranch_codeveri(BRANCHCODE));
				md.addAttribute("listprovunveri", Provision_Repo.getprovbranch_codeunveri(BRANCHCODE));
			}
		} else if (formmode.equals("Provisiondataedit")) {

			md.addAttribute("formmode", "Provisiondataedit");
			md.addAttribute("Provdataedit", Provision_Repo.getprovsrl(Srl_no));
			md.addAttribute("RBRMenuname", "Provision Edit");
		} else if (formmode.equals("Provisionadd")) {
			md.addAttribute("formmode", "Provisionadd");
			Long Pro_Srl_no = Provision_Repo.getAuditRefUUID();
			md.addAttribute("Pro_Srl_no", Pro_Srl_no.toString());
			md.addAttribute("RBRMenuname", "Provision Add");
		} else {

		}

		return "RBRSecusheets";

	}

	@RequestMapping(value = "Provisiondataoperation", method = RequestMethod.POST)
	@ResponseBody
	public String Provisiondataoperation(@RequestParam("formmode") String formmode,
			@ModelAttribute Provision_Entity Provision_Entity, Model md, HttpServletRequest rq)
			throws NoSuchAlgorithmException, InvalidKeySpecException, ParseException, IOException {

		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) rq.getSession().getAttribute("BRANCHCODE");

		String msg = RBRReportservice.Provisiondataopr(Provision_Entity, formmode, userid, BRANCHCODE);

		return msg;

	}

	@RequestMapping(value = "Overalldata", method = { RequestMethod.GET, RequestMethod.POST })
	public String RBROveralldata(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String Srl_no, @RequestParam(required = false) String cif_no,
			@RequestParam(required = false) String tab, Model md, HttpServletRequest req, String cin,
			@ModelAttribute RBROverall_Data_Entity details2) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String Roleid = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		String WORK_CLASS = (String) req.getSession().getAttribute("WORKCLASS");
		String USER_PERMISSIONS = (String) req.getSession().getAttribute("PERMISSIONS");
		if (formmode == null || formmode.equals("Overalldata")) {
			md.addAttribute("formmode", "Overalldata");
			md.addAttribute("userid", "userid");
			md.addAttribute("RBRMenuname", "Overall Data");

			if (Roleid.equals("RBR")) {
				md.addAttribute("listprovveri", RBRoverall_Data_Repo.getoverallverifi());
				md.addAttribute("listprovunveri", RBRoverall_Data_Repo.getoverallunverifi());
			} else {
				md.addAttribute("listprovveri", RBRoverall_Data_Repo.getoverallbrachverifi(BRANCHCODE));
				md.addAttribute("listprovunveri", RBRoverall_Data_Repo.getoverallbranchunverifi(BRANCHCODE));
			}
		} else if (formmode.equals("Overalldataedit")) {

			md.addAttribute("formmode", "Overalldataedit");
			md.addAttribute("Overalldataedit", RBRoverall_Data_Repo.getsrl_no(Srl_no));
			md.addAttribute("RBRMenuname", "Overall Edit");
		} else if (formmode.equals("Overalladd")) {
			md.addAttribute("formmode", "Overalladd");
			Long Over_Srl_no = RBRoverall_Data_Repo.getAuditRefUUID();
			md.addAttribute("Over_Srl_no", Over_Srl_no.toString());
			md.addAttribute("RBRMenuname", "Overall Add");
		} else {

		}

		return "RBRSecusheets";

	}

	@RequestMapping(value = "Overalldataoperation", method = RequestMethod.POST)
	@ResponseBody
	public String Overalldataoperation(@RequestParam("formmode") String formmode,
			@ModelAttribute RBROverall_Data_Entity RBROverall_Data_Entity, Model md, HttpServletRequest rq)
			throws NoSuchAlgorithmException, InvalidKeySpecException, ParseException, IOException {

		String userid = (String) rq.getSession().getAttribute("USERID");
		String roleId = (String) rq.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) rq.getSession().getAttribute("BRANCHCODE");

		String msg = RBRReportservice.Overalldataoper(RBROverall_Data_Entity, formmode, userid, BRANCHCODE);

		return msg;

	}

	@RequestMapping(value = "RBR_1", method = { RequestMethod.GET, RequestMethod.POST })
	public String RBR_1(@RequestParam(required = false) String formmode, @RequestParam(required = false) String cif_no,
			@RequestParam(required = false) String tab, Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String Roleid = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("userid", "userid");
			// md.addAttribute("listcustomer", rBRcustomerRepo.getList());

			if (Roleid.equals("RBR")) {
				md.addAttribute("listcustomer", RBR_CUSTOMER_DATA_V1_REP.findAll());
				md.addAttribute("listcustomerRBR1", RBR_CUSTOMER_DATA_V1_REP.Getverified());

			} else {
				md.addAttribute("listcustomer", RBR_CUSTOMER_DATA_V1_REP.getCUSTList(BRANCHCODE));
				md.addAttribute("listcustomerRBR1", RBR_CUSTOMER_DATA_V1_REP.Getverifiedbranch(BRANCHCODE));
			}

			md.addAttribute("USER_ID", userid);

		}

		return "RBRVersion1";

	}

	public Map<String, Boolean> verifyCinStatus() {
		List<RBRcustomer_entity> customerList = rBRcustomerRepo.findAll();
		List<RBR_Inverstments_Entity> investmentList = RBR_Inverstments_Repo.findAll();
		List<RBRShareHolder_Entity> shareholderList = rbrShareHolder_Repo.findAll();
		List<Facitlity_Entity> facilityList = facility_Repo.findAll();
		List<Security_Entity> securityList = security_Repo.findAll();
		List<Provision_Entity> provisionList = Provision_Repo.findAll();
		List<RBROverall_Data_Entity> overallDataList = RBRoverall_Data_Repo.findAll();
		List<RBR_Legal_Cases_Entity> legalCasesList = RBR_Legal_Cases_Repo.findAll();

		Map<String, Boolean> verificationStatus = new HashMap<>();

		Set<String> allCins = new HashSet<>();
		allCins.addAll(customerList.stream().map(RBRcustomer_entity::getCin).collect(Collectors.toSet()));
		allCins.addAll(investmentList.stream().map(RBR_Inverstments_Entity::getCin).collect(Collectors.toSet()));
		allCins.addAll(shareholderList.stream().map(RBRShareHolder_Entity::getCin).collect(Collectors.toSet()));
		allCins.addAll(facilityList.stream().map(Facitlity_Entity::getCin).collect(Collectors.toSet()));
		allCins.addAll(securityList.stream().map(Security_Entity::getCin).collect(Collectors.toSet()));
		allCins.addAll(provisionList.stream().map(Provision_Entity::getCin).collect(Collectors.toSet()));
		allCins.addAll(overallDataList.stream().map(RBROverall_Data_Entity::getCin).collect(Collectors.toSet()));
		allCins.addAll(legalCasesList.stream().map(RBR_Legal_Cases_Entity::getCin).collect(Collectors.toSet()));

		for (String cin : allCins) {
			boolean isVerified = true;
			isVerified &= customerList.stream().anyMatch(c -> c.getCin().equals(cin) && "Y".equals(c.getAuth_flg()));
			isVerified &= investmentList.stream().anyMatch(i -> i.getCin().equals(cin) && "Y".equals(i.getAuth_flg()));
			isVerified &= shareholderList.stream().anyMatch(s -> s.getCin().equals(cin) && "Y".equals(s.getAuth_flg()));
			isVerified &= facilityList.stream().anyMatch(f -> f.getCin().equals(cin) && "Y".equals(f.getAuth_flg()));
			isVerified &= securityList.stream().anyMatch(se -> se.getCin().equals(cin) && "Y".equals(se.getAuth_flg()));
			isVerified &= provisionList.stream().anyMatch(p -> p.getCin().equals(cin) && "Y".equals(p.getAuth_flg()));
			isVerified &= overallDataList.stream().anyMatch(o -> o.getCin().equals(cin) && "Y".equals(o.getAuth_flg()));
			isVerified &= legalCasesList.stream().anyMatch(l -> l.getCin().equals(cin) && "Y".equals(l.getAuth_flg()));

			verificationStatus.put(cin, isVerified);
		}

		return verificationStatus;
	}

	@RequestMapping(value = "RBR_Final", method = { RequestMethod.GET, RequestMethod.POST })
	public String RBRFINAL(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String cif_no, @RequestParam(required = false) String tab, Model md,
			HttpServletRequest req, String cin) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String Roleid = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");
		if (Roleid.equals("RBR")) {
			if (formmode == null || formmode.equals("list")) {
				md.addAttribute("formmode", "list");
				md.addAttribute("listcustomer", rBRcustomerRepo.getFinalRBR());
				md.addAttribute("listShare", rbrShareHolder_Repo.getFinalRBR());
				md.addAttribute("listFacility", facility_Repo.getFinalRBR());
				md.addAttribute("listSecurity", security_Repo.getFinalRBR());
				md.addAttribute("listProvision", Provision_Repo.getFinalRBR());
				md.addAttribute("listoverall", RBRoverall_Data_Repo.getFinalRBR());
				md.addAttribute("listlegalcases", RBR_Legal_Cases_Repo.getFinalRBR());
				md.addAttribute("listInverstmentscases", RBR_Inverstments_Repo.getFinalRBR());

			} else {
				System.out.println("EMPTY");
			}
		} else {
			if (formmode == null || formmode.equals("list")) {
				md.addAttribute("formmode", "list");
				md.addAttribute("listcustomer", rBRcustomerRepo.getFinalbranchRBR(BRANCHCODE));
				md.addAttribute("listShare", rbrShareHolder_Repo.getFinalbranchRBR(BRANCHCODE));
				md.addAttribute("listFacility", facility_Repo.getFinalbranchRBR(BRANCHCODE));
				md.addAttribute("listSecurity", security_Repo.getFinalbranchRBR(BRANCHCODE));
				md.addAttribute("listProvision", Provision_Repo.getFinalbranchRBR(BRANCHCODE));
				md.addAttribute("listoverall", RBRoverall_Data_Repo.getFinalbranchRBR(BRANCHCODE));
				md.addAttribute("listlegalcases", RBR_Legal_Cases_Repo.getFinalbranchRBR(BRANCHCODE));
				md.addAttribute("listInverstmentscases", RBR_Inverstments_Repo.getFinalbranchRBR(BRANCHCODE));
			}
		}
		return "RBRFinal";

	}

	@RequestMapping(value = "RBRCustTab", method = RequestMethod.POST)
	@ResponseBody
	public String RBRCustTab(@RequestParam String cif_no, @RequestBody RBRcustomer_entity details,
			HttpServletRequest rq) {
		System.out.println("RBRCustTab " + cif_no);
		String userid = (String) rq.getSession().getAttribute("USERID");
		String username = (String) rq.getSession().getAttribute("USERNAME");
		RBRcustomer_entity up = rBRcustomerRepo.getview(cif_no);
		String msg = "";
		if (up != null) {
			msg = RBRReportservice.RBREditValidation(details);
			if (msg.equals("Verification Ok")) {
				details.setBranch_code(up.getBranch_code());
				details.setCaname("");
				// details.setOperation("UPD");
				details.setModify_flg("Y");
				details.setModify_user(username);
				details.setModify_time(new Date());
				details.setAuth_flg(up.getAuth_flg() != null ? up.getAuth_flg() : "N");
				details.setModify_user(userid);
				details.setReport_date(up.getReport_date());
				details.setBranch(up.getBranch());
				rBRcustomerRepo.save(details);
				return "Edited Successfully";
			} else {
				return msg;
			}
		} else {
			return "Customer not found";
		}
	}

	@RequestMapping(value = "RBRInvestTab", method = RequestMethod.POST)
	@ResponseBody
	public String RBRInvestTab(@RequestParam String cin, @RequestBody RBR_Inverstments_Entity details,
			HttpServletRequest rq) {
		System.out.println("RBRInvestTab " + cin);
		String userid = (String) rq.getSession().getAttribute("USERID");
		String username = (String) rq.getSession().getAttribute("USERNAME");
		RBR_Inverstments_Entity up = RBR_Inverstments_Repo.getview(cin);
		if (up != null) {
			details.setOperation("UPD");
			details.setModify_flg("Y");
			details.setModify_user(username);
			details.setModify_time(new Date());
			details.setAuth_flg(up.getAuth_flg() != null ? up.getAuth_flg() : "N");
			details.setModify_user(userid);
			details.setReport_date(up.getReport_date());
			RBR_Inverstments_Repo.save(details);
			return "Edited Successfully";
		} else {
			return "Investment not found";
		}
	}

	@RequestMapping(value = "RBRLegalTab", method = RequestMethod.POST)
	@ResponseBody
	public String RBRLegalTab(@RequestParam String cin, @RequestBody RBR_Legal_Cases_Entity details,
			HttpServletRequest rq) {
		System.out.println("RBRLegalTab " + cin);
		String userid = (String) rq.getSession().getAttribute("USERID");
		String username = (String) rq.getSession().getAttribute("USERNAME");
		RBR_Legal_Cases_Entity up = RBR_Legal_Cases_Repo.getview(cin);
		if (up != null) {
			details.setOperation("UPD");
			details.setModify_flg("Y");
			details.setModify_user(username);
			details.setModify_time(new Date());
			details.setAuth_flg(up.getAuth_flg() != null ? up.getAuth_flg() : "N");
			details.setModify_user(userid);
			details.setReport_date(up.getReport_date());
			RBR_Legal_Cases_Repo.save(details);
			return "Edited Successfully";
		} else {
			return "Legal not found";
		}
	}

	@RequestMapping(value = "RBROverallTab", method = RequestMethod.POST)
	@ResponseBody
	public String RBROverallTab(@RequestParam String cin, @RequestBody RBROverall_Data_Entity details,
			HttpServletRequest rq) {
		System.out.println("RBROverallTab " + cin);
		String userid = (String) rq.getSession().getAttribute("USERID");
		String username = (String) rq.getSession().getAttribute("USERNAME");
		RBROverall_Data_Entity up = RBRoverall_Data_Repo.getupdate(details.getSrl_no());
		if (up != null) {
			details.setOperation("UPD");
			details.setModify_flg("Y");
			details.setModify_user(username);
			details.setModify_time(new Date());
			details.setAuth_flg(up.getAuth_flg() != null ? up.getAuth_flg() : "N");
			details.setModify_user(userid);
			details.setReport_date(up.getReport_date());
			RBRoverall_Data_Repo.save(details);
			return "Edited Successfully";
		} else {
			return "Overalldata not found";
		}
	}

	@RequestMapping(value = "RBRProvisionTab", method = RequestMethod.POST)
	@ResponseBody
	public String RBRProvisionTab(@RequestParam String cin, @RequestBody Provision_Entity details,
			HttpServletRequest rq) {
		System.out.println("RBRProvisonTab " + cin);
		String userid = (String) rq.getSession().getAttribute("USERID");
		String username = (String) rq.getSession().getAttribute("USERNAME");
		Provision_Entity up = Provision_Repo.getupdate(details.getSrl_no());
		if (up != null) {
			details.setOperation("UPD");
			details.setModify_flg("Y");
			details.setModify_user(username);
			details.setModify_time(new Date());
			details.setAuth_flg(up.getAuth_flg() != null ? up.getAuth_flg() : "N");
			details.setModify_user(userid);
			details.setReport_date(up.getReport_date());
			Provision_Repo.save(details);

			return "Edited Successfully";
		} else {
			return "Provision not found";
		}
	}

	@RequestMapping(value = "RBRFacilityTab", method = RequestMethod.POST)
	@ResponseBody
	public String RBRFacilityTab(@RequestParam String cin, @RequestBody Facitlity_Entity details,
			HttpServletRequest rq) {
		System.out.println("RBRFacilityTab " + cin);
		String userid = (String) rq.getSession().getAttribute("USERID");
		String username = (String) rq.getSession().getAttribute("USERNAME");
		Facitlity_Entity up = facility_Repo.getupdate(details.getSrl_no());
		if (up != null) {
			details.setOperation("UPD");
			details.setModify_flg("Y");
			details.setModify_user(username);
			details.setModify_time(new Date());
			details.setAuth_flg(up.getAuth_flg() != null ? up.getAuth_flg() : "N");
			details.setModify_user(userid);

			facility_Repo.save(details);
			details.setReport_date(up.getReport_date());
			return "Edited Successfully";
		} else {
			return "Facility not found";
		}
	}

	@RequestMapping(value = "RBRSecurityTab", method = RequestMethod.POST)
	@ResponseBody
	public String RBRSecurityTab(@RequestParam String cin, @RequestBody Security_Entity details,
			HttpServletRequest rq) {
		System.out.println("RBRFacilityTab " + cin);
		String userid = (String) rq.getSession().getAttribute("USERID");
		String username = (String) rq.getSession().getAttribute("USERNAME");
		Security_Entity up = security_Repo.getupdate(details.getSrl_no());

		if (up != null) {

			details.setOperation("UPD");
			details.setModify_flg("Y");
			details.setModify_user(username);
			details.setModify_time(new Date());
			details.setAuth_flg(up.getAuth_flg() != null ? up.getAuth_flg() : "N");
			details.setModify_user(userid);
			details.setReport_date(up.getReport_date());
			security_Repo.save(details);
			return "Edited Successfully";

		} else {
			return "Security not found";
		}
	}

	@RequestMapping(value = "RBRPartnerTab", method = RequestMethod.POST)
	@ResponseBody
	public String RBRPartnerTab(@RequestParam String cin, @RequestBody RBRShareHolder_Entity details,
			HttpServletRequest rq) {
		System.out.println("Partner Cin " + cin);
		String userid = (String) rq.getSession().getAttribute("USERID");
		String username = (String) rq.getSession().getAttribute("USERNAME");
		RBRShareHolder_Entity up = rbrShareHolder_Repo.getupdate(details.getSrl_no());
		System.out.println(details.getP_s_cin() + " " + details.getBankcode());
		String Msg = RBRReportservice.RBRPartnervalidation(details);

		if (!cin.equals("ADD")) {

			if (up != null) {
				if (Msg.equals("Validation_done")) {
					details.setOperation("UPD");
					details.setModify_flg("Y");
					details.setModify_user(username);
					details.setModify_time(new Date());
					details.setAuth_flg(up.getAuth_flg() != null ? up.getAuth_flg() : "N");
					details.setModify_user(userid);
					details.setReport_date(up.getReport_date());
					rbrShareHolder_Repo.save(details);
					return "Edited Successfully";
				} else {
					return Msg;
				}
			} else {
				return "Partner and shareholder not found";
			}
		} else {
			RBRShareHolder_Entity rbrshare = rbrShareHolder_Repo.findByCin(details.getCin());
			if (rbrshare.getCin().isEmpty()) {
				return "No data Present for Mentioned Cin";
			} else {

				Long Srl_no = rbrShareHolder_Repo.getAuditRefUUID();
				details.setSrl_no(Srl_no.toString());

				rbrShareHolder_Repo.save(details);

				return "New Partner data Added";

			}
		}
	}

	@RequestMapping(value = "RBRUpdatecin", method = { RequestMethod.GET, RequestMethod.POST })
	public ResponseEntity<String> RBRUpdatecin(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String cin_Cust1, @RequestParam(required = false) String cif_no_Cust1,
			@RequestParam(required = false) String csno_Cust1, Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		String Msg;
		RBRcustomer_entity UP = rBRcustomerRepo.getview(cif_no_Cust1);

		UP.setCin(cin_Cust1);
		UP.setCsno(csno_Cust1);

		rBRcustomerRepo.save(UP);

		List<RBRShareHolder_Entity> up11 = rbrShareHolder_Repo.getbycustid(cif_no_Cust1);

		for (RBRShareHolder_Entity up1 : up11) {
			if (up1 != null) {
				String authFlag = up1.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up1.setCin(cin_Cust1);
					up1.setCsno(csno_Cust1);
					rbrShareHolder_Repo.save(up1);
				}
			}
		}

		List<Facitlity_Entity> up31 = facility_Repo.getbycustid(cif_no_Cust1);
		for (Facitlity_Entity up3 : up31) {
			if (up3 != null) {
				String authFlag = up3.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up3.setCin(cin_Cust1);
					up3.setCsno(csno_Cust1);

					facility_Repo.save(up3);
				}
			}
		}

		List<Security_Entity> up41 = security_Repo.getbycustid(cif_no_Cust1);
		for (Security_Entity up4 : up41) {
			if (up4 != null) {
				String authFlag = up4.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up4.setCin(cin_Cust1);
					up4.setCsno(csno_Cust1);
					security_Repo.save(up4);
				}
			}
		}
		List<Provision_Entity> up51 = Provision_Repo.getbycustid(cif_no_Cust1);
		for (Provision_Entity up5 : up51) {
			if (up5 != null) {
				String authFlag = up5.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up5.setCin(cin_Cust1);
					up5.setCsno(csno_Cust1);

					Provision_Repo.save(up5);
				}
			}
		}
		List<RBROverall_Data_Entity> up61 = RBRoverall_Data_Repo.getbycustid(cif_no_Cust1);
		for (RBROverall_Data_Entity up6 : up61) {
			if (up6 != null) {
				String authFlag = up6.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up6.setCin(cin_Cust1);
					up6.setCsno(csno_Cust1);

					RBRoverall_Data_Repo.save(up6);
				}
			}
		}

		RBRReportservice.Rbrauditservice(userid, "All CCSYS TABLES", "CIN and CSNO",
				cin_Cust1 + " - CIN AND " + csno_Cust1 + " - CSNO UPDATE");

		Msg = "Cin Updated successfully";
		return ResponseEntity.ok(Msg);

	}

	@RequestMapping(value = "RBRVerify", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> RBRVerify(@RequestParam String cin, @RequestParam String Datatype,
			@RequestParam String Srl_no, @ModelAttribute RBRShareHolder_Entity details1,
			@ModelAttribute RBRcustomer_entity details2, @ModelAttribute Facitlity_Entity details3,
			@ModelAttribute Security_Entity details4, @ModelAttribute Provision_Entity details5,
			@ModelAttribute RBROverall_Data_Entity details6, @ModelAttribute RBR_Legal_Cases_Entity details7,
			@ModelAttribute RBR_Inverstments_Entity details8, HttpServletRequest rq, Model md) {

		Map<String, Object> response = new HashMap<>();
		String msg = "";
		String userid = (String) rq.getSession().getAttribute("USERID");
		// Boolean a = verifyAndUpdateAuthFlg(cin);
		// md.addAttribute("allVerified", a);

		if (Datatype.equals("CUSTOMERDATA")) {

			msg = RBRReportservice.RBRValidation(cin);

			RBRcustomer_entity up2 = rBRcustomerRepo.findById(Srl_no).get();
			if (up2 != null && up2.getCin() != null) {
				String authFlag = up2.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up2.setAuth_flg("Y");
					up2.setAuth_user(userid);
					up2.setAuth_time(new Date());
					rBRcustomerRepo.save(up2);

					RBRReportservice.Rbrauditservice(userid, "Customer data", "Customer verification",
							up2.getCif_no() + " is verified and Srl no is " + up2.getSrl_no());

					msg = "Customer data successfully verified!";
				}
			} else {
				msg = "Verification failed: CIN is missing. " + "Please provide a valid CIN to proceed.";
			}

		}

		if (Datatype.equals("SHAREHOLDERDATA")) {

			RBRShareHolder_Entity up1 = rbrShareHolder_Repo.findById(Srl_no).get();

			if (up1 != null && up1.getCin() != null) {
				String authFlag = up1.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up1.setAuth_flg("Y");
					up1.setAuth_user(userid);
					up1.setAuth_time(new Date());
					rbrShareHolder_Repo.save(up1);

					RBRReportservice.Rbrauditservice(userid, "partner data", "Partner verification",
							up1.getP_s_cin() + " is verified and Srl no is " + up1.getSrl_no());

					msg = "Partner data successfully verified!";

				}
			} else {
				msg = "Verification failed: CIN is missing. " + "Please provide a valid CIN to proceed.";
			}

		}
		if (Datatype.equals("FACILITYDATA")) {
			Facitlity_Entity up3 = facility_Repo.findById(Srl_no).get();

			if (up3 != null && up3.getCin() != null) {
				String authFlag = up3.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up3.setAuth_flg("Y");
					up3.setAuth_user(userid);
					up3.setAuth_time(new Date());
					facility_Repo.save(up3);

					RBRReportservice.Rbrauditservice(userid, "Facility data", "Facility verification",
							up3.getFac_id() + " is verified and Srl no is " + up3.getSrl_no());

					msg = "Facility data successfully verified!";

				}
			} else {
				msg = "Verification failed: CIN is missing. " + "Please provide a valid CIN to proceed.";
			}
		}
		if (Datatype.equals("SECURITYDATA")) {
			Security_Entity up4 = security_Repo.findById(Srl_no).get();

			if (up4 != null && up4.getCin() != null) {
				String authFlag = up4.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up4.setAuth_flg("Y");
					up4.setAuth_user(userid);
					up4.setAuth_time(new Date());
					security_Repo.save(up4);

					RBRReportservice.Rbrauditservice(userid, "Security data", "Security verification",
							up4.getFac_id() + " is verified and Srl no is " + up4.getSrl_no());

					msg = "Security data successfully verified!";
				}
			} else {
				msg = "Verification failed: CIN is missing. " + "Please provide a valid CIN to proceed.";
			}
		}
		if (Datatype.equals("PROVISIONDATA")) {
			Provision_Entity up5 = Provision_Repo.findById(Srl_no).get();

			if (up5 != null && up5.getCin() != null) {
				String authFlag = up5.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up5.setAuth_flg("Y");
					up5.setAuth_user(userid);
					up5.setAuth_time(new Date());
					Provision_Repo.save(up5);

					RBRReportservice.Rbrauditservice(userid, "Provision data", "Provision verification",
							up5.getFac_id() + " is verified and Srl no is " + up5.getSrl_no());

					msg = "Provision data successfully verified!";
				}
			} else {
				msg = "Verification failed: CIN is missing. " + "Please provide a valid CIN to proceed.";
			}
		}
		if (Datatype.equals("OVERALLDATA")) {
			RBROverall_Data_Entity up6 = RBRoverall_Data_Repo.findById(Srl_no).get();

			if (up6 != null && up6.getCin() != null) {
				String authFlag = up6.getAuth_flg();
				if (authFlag != null && authFlag.equals("N")) {
					up6.setAuth_flg("Y");
					up6.setAuth_user(userid);
					up6.setAuth_time(new Date());
					RBRoverall_Data_Repo.save(up6);

					RBRReportservice.Rbrauditservice(userid, "Overall data", "Overall verification",
							up6.getCin() + " is verified and Srl no is " + up6.getSrl_no());

					msg = "Overall data successfully verified!";
				}
			} else {
				msg = "Verification failed: CIN is missing. " + "Please provide a valid CIN to proceed.";
			}

		}
		response.put("message", msg);

		response.put("cin", cin);
		return response;
	}

	public boolean verifyAndUpdateAuthFlg(String cin) {
		List<RBRcustomer_entity> customerList = rBRcustomerRepo.findAll();
		List<RBR_Inverstments_Entity> investmentList = RBR_Inverstments_Repo.findAll();
		List<RBRShareHolder_Entity> shareholderList = rbrShareHolder_Repo.findAll();
		List<Facitlity_Entity> facilityList = facility_Repo.findAll();
		List<Security_Entity> securityList = security_Repo.findAll();
		List<Provision_Entity> provisionList = Provision_Repo.findAll();
		List<RBROverall_Data_Entity> overallDataList = RBRoverall_Data_Repo.findAll();
		List<RBR_Legal_Cases_Entity> legalCasesList = RBR_Legal_Cases_Repo.findAll();

		RBRcustomer_entity customer = customerList.stream().filter(entity -> cin.equals(entity.getCin())).findFirst()
				.orElse(null);
		System.out.println("Customer: " + customer);

		RBR_Inverstments_Entity investment = investmentList.stream().filter(entity -> cin.equals(entity.getCin()))
				.findFirst().orElse(null);
		System.out.println("Investment: " + investment);

		RBRShareHolder_Entity shareholder = shareholderList.stream().filter(entity -> cin.equals(entity.getCin()))
				.findFirst().orElse(null);
		System.out.println("Shareholder: " + shareholder);

		Facitlity_Entity facility = facilityList.stream().filter(entity -> cin.equals(entity.getCin())).findFirst()
				.orElse(null);
		System.out.println("Facility: " + facility);

		Security_Entity security = securityList.stream().filter(entity -> cin.equals(entity.getCin())).findFirst()
				.orElse(null);
		System.out.println("Security: " + security);

		Provision_Entity provision = provisionList.stream().filter(entity -> cin.equals(entity.getCin())).findFirst()
				.orElse(null);
		System.out.println("Provision: " + provision);

		RBROverall_Data_Entity overallData = overallDataList.stream().filter(entity -> cin.equals(entity.getCin()))
				.findFirst().orElse(null);
		System.out.println("Overall Data: " + overallData);

		RBR_Legal_Cases_Entity legalCases = legalCasesList.stream().filter(entity -> cin.equals(entity.getCin()))
				.findFirst().orElse(null);
		System.out.println("Legal Cases: " + legalCases);

		boolean allVerified = (customer != null && "Y".equals(customer.getAuth_flg()))
				&& (investment != null && "Y".equals(investment.getAuth_flg()))
				&& (shareholder != null && "Y".equals(shareholder.getAuth_flg()))
				&& (facility != null && "Y".equals(facility.getAuth_flg()))
				&& (security != null && "Y".equals(security.getAuth_flg()))
				&& (provision != null && "Y".equals(provision.getAuth_flg()))
				&& (overallData != null && "Y".equals(overallData.getAuth_flg()))
				&& (legalCases != null && "Y".equals(legalCases.getAuth_flg()));
		System.out.println(allVerified + "allVerifiedallVerifiedallVerifiedallVerified");
		return allVerified;
	}

	// -----downloadforMSExcel by NISHANTHINI
	// coresystem download

	@RequestMapping(value = "downloadExcel", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadExcel() throws IOException {

		System.out.println("the enter the controller--1");

		List<Brecon_core_entity> coresystemEntity = brecon_core_rep.getcoresystemlistdata();

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Coresystem Data");

		// Create bold and centered header style with borders
		CellStyle headerStyle = workbook.createCellStyle();
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerStyle.setFont(headerFont);
		headerStyle.setAlignment(HorizontalAlignment.CENTER); // Center alignment for header
		headerStyle.setBorderTop(BorderStyle.THIN);
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);

		// Create a regular cell style with borders
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);

		// Create Header Row
		Row headerRow = sheet.createRow(0);
		String[] headers = { "Srl No", "Tran Date", "Tran Id", "Part Tran Id", "Tran Amount", "Tran Type",
				"Tran Account Number", "Tran Account Name", "Tran Particular" };
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(headerStyle); // Apply centered bold style to header
		}

		int rowIndex = 1;

		for (Brecon_core_entity coresystem : coresystemEntity) {
			Date tranDate = coresystem.getTran_date();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String formattedDate = formatter.format(tranDate);

			Row row = sheet.createRow(rowIndex++);
			row.createCell(0).setCellValue(rowIndex - 1);
			row.createCell(1).setCellValue(formattedDate);
			row.createCell(2).setCellValue(coresystem.getTran_id());
			row.createCell(3).setCellValue(coresystem.getPart_tran_srl_num());
			row.createCell(4).setCellValue(coresystem.getTran_amt().doubleValue());
			row.createCell(5).setCellValue(coresystem.getTran_type());
			row.createCell(6).setCellValue(coresystem.getAcid());
			row.createCell(7).setCellValue(coresystem.getBank_code());
			row.createCell(8).setCellValue(coresystem.getTran_particular());

			// Apply cell style with borders to each cell in the row
			for (int i = 0; i < headers.length; i++) {
				row.getCell(i).setCellStyle(cellStyle);
			}
		}

		// Adjust column widths to fit the content
		for (int i = 0; i < headers.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write data to a ByteArrayOutputStream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		workbook.write(outputStream);
		workbook.close();

		// Set response headers and return the file
		HttpHeaders headersResponse = new HttpHeaders();
		headersResponse.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headersResponse.setContentDispositionFormData("attachment", "CoresystemData.xlsx");

		return ResponseEntity.ok().headers(headersResponse).body(outputStream.toByteArray());
	}

	/// clearing system ms_excel download

	@RequestMapping(value = "downloadExcel1", method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadExcel1() throws IOException {

		System.out.println("the enter the controller--1");

		List<BRECON_DESTINATION_ENTITY> clearingsystemEntity = brecon_destination_repo.getDestination();

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Clearingsystem Data");

		// Create bold and centered header style with borders
		CellStyle headerStyle = workbook.createCellStyle();
		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerStyle.setFont(headerFont);
		headerStyle.setAlignment(HorizontalAlignment.CENTER); // Center alignment for header
		headerStyle.setBorderTop(BorderStyle.THIN);
		headerStyle.setBorderBottom(BorderStyle.THIN);
		headerStyle.setBorderLeft(BorderStyle.THIN);
		headerStyle.setBorderRight(BorderStyle.THIN);

		// Create a regular cell style with borders
		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);

		// Create Header Row
		Row headerRow = sheet.createRow(0);
		String[] headers = { "Srl No", "Tran Date", "Tran Id", "Part Tran Id", "Tran Amount", "Tran Type",
				"Tran Account Number", "Tran Account Name", "Tran Particular" };
		for (int i = 0; i < headers.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(headers[i]);
			cell.setCellStyle(headerStyle); // Apply centered bold style to header
		}

		int rowIndex = 1;

		for (BRECON_DESTINATION_ENTITY clearingsystem : clearingsystemEntity) {
			Date tranDate = clearingsystem.getStmt_from_date_time();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String formattedDate = formatter.format(tranDate);

			Row row = sheet.createRow(rowIndex++);
			row.createCell(0).setCellValue(rowIndex - 1);
			row.createCell(1).setCellValue(formattedDate);
			row.createCell(2).setCellValue(clearingsystem.getNtry_btch_currency());
			row.createCell(3).setCellValue(clearingsystem.getNtry_proprietary_code());
			row.createCell(4).setCellValue(clearingsystem.getNtry_transaction_amount().doubleValue());
			row.createCell(5).setCellValue(clearingsystem.getNtry_txdtls_credit_debit_indicator());
			row.createCell(6).setCellValue(clearingsystem.getAccount_no());
			row.createCell(7).setCellValue(clearingsystem.getStmt_account_identifier());
			row.createCell(8).setCellValue(clearingsystem.getNtry_entry_reference());

			// Apply cell style with borders to each cell in the row
			for (int i = 0; i < headers.length; i++) {
				row.getCell(i).setCellStyle(cellStyle);
			}
		}

		// Adjust column widths to fit the content
		for (int i = 0; i < headers.length; i++) {
			sheet.autoSizeColumn(i);
		}

		// Write data to a ByteArrayOutputStream
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		workbook.write(outputStream);
		workbook.close();

		// Set response headers and return the file
		HttpHeaders headersResponse = new HttpHeaders();
		headersResponse.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headersResponse.setContentDispositionFormData("attachment", "ClearingsystemData.xlsx");

		return ResponseEntity.ok().headers(headersResponse).body(outputStream.toByteArray());
	}

	@RequestMapping(value = "Dataupload", method = RequestMethod.GET)
	public String Dataupload(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");

		}

		return "Dataupload";
	}

	@Autowired
	Brecon_core_rep brecon_core_rep;

	@RequestMapping(value = "coresystem", method = RequestMethod.GET)
	public String coresystem(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("list", brecon_core_rep.getcoresystemlistdata());
		}

		return "Brecon_core";
	}

	@RequestMapping(value = "coresystemlist", method = RequestMethod.GET)
	public String coresystemlist(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		System.out.println(userid + "userid");
		if (formmode.equals("srlno")) {
			md.addAttribute("formmode", "srlno");
			System.out.println(srlno);
			md.addAttribute("srlno", brecon_core_rep.getSrlno(srlno));

		} else if (formmode.equals("modify")) {
			md.addAttribute("formmode", "modify");
			System.out.println(srlno);
			md.addAttribute("srlno", brecon_core_rep.getSrlno(srlno));
		} else if (formmode.equals("verify")) {
			md.addAttribute("formmode", "verify");
			System.out.println(srlno);
			md.addAttribute("srlno", brecon_core_rep.getSrlno(srlno));
		} else if (formmode.equals("add")) {
			md.addAttribute("formmode", "add");

		}

		return "Brecon_core_list";
	}

	@RequestMapping(value = "breconmodifysubmit", method = RequestMethod.POST)
	@ResponseBody
	public String breconmodifysubmit(@RequestParam(required = false) String srlno, Model md, HttpServletRequest rq,
			@ModelAttribute Brecon_core_entity brecon_core_entity, HttpServletRequest request, HttpServletRequest req) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		System.out.println(userid + "userid");

		String msg;

		// Get role ID from the session
		String roleId = (String) req.getSession().getAttribute("ROLEID");

		// Ensure modification logic is executed only if role is "BRC"
		if ("BRC".equals(roleId)) { // Safe comparison to avoid NullPointerException
			System.out.println(brecon_core_entity.getSrlno());

			// Assuming brecon_core_entity is populated with the form data
			// Update flags and user directly
			brecon_core_entity.setDel_flg("N"); // Set delete flag
			brecon_core_entity.setModify_flg("Y"); // Set modify flag
			brecon_core_entity.setEntity_flg("Y");
			brecon_core_entity.setModify_user(userid);

			// Save the entity without checking for an existing one
			brecon_core_rep.save(brecon_core_entity);

			// Generate audit entry
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Create and populate audit entity
			BRECON_Audit_Entity audit = new BRECON_Audit_Entity();
			Date currentDate = new Date();
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(user1);
			audit.setFunc_code("MODIFIED");
			audit.setAudit_table("BRECONSOURCETABLE");
			audit.setAudit_screen("MODIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setModi_details("Modified Successfully");

			// Fetch user profile and add authorization details to the audit entity if
			// available
			UserProfile values1 = userProfileRep.getRole(user1);
			if (values1 != null) {
				audit.setAuth_user(values1.getAuth_user());
				audit.setAuth_time(values1.getAuth_time());
			}

			audit.setAudit_ref_no(auditID);

			// Save audit entity
			bRECON_Audit_Rep.save(audit);

			// Success message
			msg = "Record modified successfully";
		} else {
			// If role is not "BRC", modification is not allowed
			msg = "Modification not allowed for this user";
		}

		return msg;
	}

	@RequestMapping(value = "breconverifysubmit", method = RequestMethod.POST)
	@ResponseBody
	public String breconverifysubmit(@RequestParam(required = false) String srlno, Model md, HttpServletRequest rq,
			@ModelAttribute Brecon_core_entity brecon_core_entity, HttpServletRequest req) {
		// Retrieve user information from both 'rq' and 'req'
		String userid = (String) rq.getSession().getAttribute("USERID");
		System.out.println(userid + " userid");

		String msg;

		// Retrieve role ID from the session
		String roleId = (String) req.getSession().getAttribute("ROLEID");

		// Ensure modification logic is executed only if the role is "BRC"
		if ("BRC".equals(roleId)) { // Safe comparison to avoid NullPointerException
			System.out.println(brecon_core_entity.getSrlno());

			// Set the modify flag and verified user
			brecon_core_entity.setModify_flg("N"); // Set modify flag to "N"
			brecon_core_entity.setVerify_user(userid); // Set verified user

			// Generate audit ID and retrieve user details from session
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Create and populate audit entity
			BRECON_Audit_Entity audit = new BRECON_Audit_Entity();
			Date currentDate = new Date();
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(user1);
			audit.setFunc_code("VERIFIED");
			audit.setAudit_table("BRECONSOURCETABLE");
			audit.setAudit_screen("VERIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setModi_details("Verified Successfully");

			// Fetch user profile and add authorization details to the audit entity if
			// available
			UserProfile values1 = userProfileRep.getRole(user1);
			if (values1 != null) {
				audit.setAuth_user(values1.getAuth_user());
				audit.setAuth_time(values1.getAuth_time());
			}

			// Set audit reference number and save audit entity
			audit.setAudit_ref_no(auditID);
			bRECON_Audit_Rep.save(audit);

			// Save the brecon core entity
			brecon_core_rep.save(brecon_core_entity);

			// Success message
			msg = "Verified successfully";
		} else {
			// If the role is not "BRC", return an error message
			msg = "Verification not allowed for this user";
		}

		return msg;
	}

	@RequestMapping(value = "breconaddsubmit", method = RequestMethod.POST)
	@ResponseBody
	public String breconaddsubmit(@RequestParam(required = false) Model md, HttpServletRequest rq,
			@ModelAttribute Brecon_core_entity brecon_core_entity, HttpServletRequest req) {
		// Retrieve user information from both 'rq' and 'req'
		String userid = (String) rq.getSession().getAttribute("USERID");
		System.out.println(userid + " userid");

		String msg;

		// Retrieve role ID from the session
		String roleId = (String) req.getSession().getAttribute("ROLEID");

		// Ensure modification logic is executed only if the role is "BRC"
		if ("BRC".equals(roleId)) { // Safe comparison to avoid NullPointerException

			// Set the modify flag and verified user
			brecon_core_entity.setModify_flg("N");
			brecon_core_entity.setEntity_flg("N");

			// Generate the next srlno automatically
			String maxSrlNoStr = brecon_core_rep.getMaxSrlNo(); // Fetch the current max srlno as a string

			// Convert to integer and generate the next srlno
			int nextSrlNo;
			try {
				nextSrlNo = Integer.parseInt(maxSrlNoStr) + 1; // Safely parse to int and increment
			} catch (NumberFormatException e) {
				nextSrlNo = 1; // Fallback if parsing fails (e.g., if no valid numbers are found)
			}

			brecon_core_entity.setSrlno(String.valueOf(nextSrlNo)); // Set the new srlno as a string

			// Generate audit ID and retrieve user details from session
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Create and populate audit entity
			BRECON_Audit_Entity audit = new BRECON_Audit_Entity();
			Date currentDate = new Date();
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(user1);
			audit.setFunc_code("ADDED");
			audit.setAudit_table("BRECONSOURCETABLE");
			audit.setAudit_screen("ADD");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setModi_details("Added Successfully");

			// Fetch user profile and add authorization details to the audit entity if
			// available
			UserProfile values1 = userProfileRep.getRole(user1);
			if (values1 != null) {
				audit.setAuth_user(values1.getAuth_user());
				audit.setAuth_time(values1.getAuth_time());
			}

			// Set audit reference number and save audit entity
			audit.setAudit_ref_no(auditID);
			bRECON_Audit_Rep.save(audit);

			// Save the brecon core entity
			brecon_core_rep.save(brecon_core_entity);

			// Success message
			msg = "Added successfully";
		} else {
			// If the role is not "BRC", return an error message
			msg = "Added not allowed for this user";
		}

		return msg;
	}

	@Autowired
	BRECON_DESTINATION_REPO brecon_destination_repo;

	@RequestMapping(value = "clearingsystem", method = RequestMethod.GET)
	public String clearingsystem(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("list", brecon_destination_repo.getDestination());

		} else if (formmode.equals("upload")) {
			md.addAttribute("formmode", "upload");

		}

		return "Brecon_clearing";
	}

	@RequestMapping(value = "clearingsystemlist", method = RequestMethod.GET)
	public String clearingsystemlist(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		String userid = (String) req.getSession().getAttribute("USERID");
		System.out.println(userid + "userid");
		if (formmode.equals("srlno")) {
			md.addAttribute("formmode", "srlno");
			System.out.println(srlno);
			md.addAttribute("srlno", brecon_destination_repo.getSrlno(srlno));

		} else if (formmode.equals("modify")) {
			md.addAttribute("formmode", "modify");
			System.out.println(srlno);
			md.addAttribute("srlno", brecon_destination_repo.getSrlno(srlno));
		} else if (formmode.equals("verify")) {
			md.addAttribute("formmode", "verify");
			System.out.println(srlno);
			md.addAttribute("srlno", brecon_destination_repo.getSrlno(srlno));
		}

		return "Brecon_clearing_list";
	}

	@RequestMapping(value = "brecondestinationmodifysubmit", method = RequestMethod.POST)
	@ResponseBody
	public String brecondestinationmodifysubmit(@RequestParam(required = false) String srlno, Model md,
			HttpServletRequest rq, @ModelAttribute BRECON_DESTINATION_ENTITY brecon_destination_entity,
			HttpServletRequest request, HttpServletRequest req) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		System.out.println(userid + "userid");

		String msg;

		String roleId = (String) req.getSession().getAttribute("ROLEID");

		// Ensure modification logic is executed only if the role is "BRC"
		if ("BRC".equals(roleId)) { // Safe comparison to avoid NullPointerException

			System.out.println(brecon_destination_entity.getSrlno());
			brecon_destination_entity.setDel_flg("N"); // Set delete flag
			brecon_destination_entity.setModify_flg("Y"); // Set modify flag
			brecon_destination_entity.setEntity_flg("Y");

			brecon_destination_entity.setModify_user(userid);

			// Save the entity without checking for an existing one
			brecon_destination_repo.save(brecon_destination_entity);
			// Generate audit entry
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Create and populate audit entity
			BRECON_Audit_Entity audit = new BRECON_Audit_Entity();
			Date currentDate = new Date();
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(user1);
			audit.setFunc_code("MODIFIED");
			audit.setAudit_table("BRECONDESTINATIONTABLE");
			audit.setAudit_screen("MODIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setModi_details("Modified Successfully");

			// Fetch user profile and add authorization details to the audit entity if
			// available
			UserProfile values1 = userProfileRep.getRole(user1);
			if (values1 != null) {
				audit.setAuth_user(values1.getAuth_user());
				audit.setAuth_time(values1.getAuth_time());
			}

			audit.setAudit_ref_no(auditID);

			// Save audit entity
			bRECON_Audit_Rep.save(audit);

			// Success message
			msg = "Record modified successfully";
		} else {
			// If role is not "BRC", modification is not allowed
			msg = "Modification not allowed for this user";
		}

		return msg;
	}

	@RequestMapping(value = "brecondestinationverifysubmit", method = RequestMethod.POST)
	@ResponseBody
	public String brecondestinationverifysubmit(@RequestParam(required = false) String srlno, Model md,
			HttpServletRequest rq, @ModelAttribute BRECON_DESTINATION_ENTITY brecon_destination_entity,
			HttpServletRequest req) {
		String userid = (String) rq.getSession().getAttribute("USERID");
		System.out.println(userid + "userid");

		String msg;

		String roleId = (String) req.getSession().getAttribute("ROLEID");

		// Ensure modification logic is executed only if the role is "BRC"
		if ("BRC".equals(roleId)) { // Safe comparison to avoid NullPointerException
			System.out.println(brecon_destination_entity.getSrlno());

			// Set the modify flag and verified user
			brecon_destination_entity.setModify_flg("N"); // Set modify flag to "N"
			brecon_destination_entity.setVerify_user(userid); // Set verified user

			// Generate audit ID and retrieve user details from session
			String auditID = sequence.generateRequestUUId();
			String user1 = (String) req.getSession().getAttribute("USERID");
			String username = (String) req.getSession().getAttribute("USERNAME");

			// Create and populate audit entity
			BRECON_Audit_Entity audit = new BRECON_Audit_Entity();
			Date currentDate = new Date();
			audit.setAudit_date(currentDate);
			audit.setEntry_time(currentDate);
			audit.setEntry_user(user1);
			audit.setFunc_code("VERIFIED");
			audit.setAudit_table("BRECONDESTINATIONTABLE");
			audit.setAudit_screen("VERIFY");
			audit.setEvent_id(user1);
			audit.setEvent_name(username);
			audit.setModi_details("Verified Successfully");

			// Fetch user profile and add authorization details to the audit entity if
			// available
			UserProfile values1 = userProfileRep.getRole(user1);
			if (values1 != null) {
				audit.setAuth_user(values1.getAuth_user());
				audit.setAuth_time(values1.getAuth_time());
			}

			// Set audit reference number and save audit entity
			audit.setAudit_ref_no(auditID);
			bRECON_Audit_Rep.save(audit);

			// Save the brecon core entity
			brecon_destination_repo.save(brecon_destination_entity);

			// Success message
			msg = "Verified successfully";
		} else {
			// If the role is not "BRC", return an error message
			msg = "Verification not allowed for this user";
		}

		return msg;
	}

	@RequestMapping(value = "MAPPING_RECONSCILLATION", method = RequestMethod.GET)
	public String MAPPING_RECONSCILLATION(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");

			md.addAttribute("listvalues", bRECON_DESTINATION_REPO.getlistvalues());
			/*
			 * md.addAttribute("list", coresystemlistrep.getcoresystemlistdata());
			 * md.addAttribute("list1", bRECON_DESTINATION_REPO.getDestination());
			 */
			// md.addAttribute("chargeback", fYITABLE_REP.getlist());
		} else if (formmode.equals("list2")) {
			md.addAttribute("formmode", "list2");
		} else if (formmode.equals("upload")) {
			md.addAttribute("formmode", "upload");
		}

		return "MAPPING";
	}

	@RequestMapping(value = "UNMAPPED_RECORDS", method = RequestMethod.GET)
	public String UNMAPPED_RECORDS(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("list", coresystemlistrep.getcoresystemlistdata());
			md.addAttribute("list1", bRECON_DESTINATION_REPO.getDestination());
			// md.addAttribute("chargeback", fYITABLE_REP.getlist());
		}

		return "UNMAPPED_RECORDS";
	}

	@RequestMapping(value = "Automatictransaction", method = RequestMethod.GET)
	public String Automatictransaction(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("listvaluesdatas", bRECON_Common_Table_Rep.getDestinationvalues());
			md.addAttribute("listcoredatas", bRECON_Common_Table_Rep.getDestinationvalues());
		} else if (formmode.equals("upload")) {
			md.addAttribute("formmode", "upload");
		}
		return "Brecon_Automatictransaction";
	}

	@RequestMapping(value = "Partialtransaction", method = RequestMethod.GET)
	public String Partialtransaction(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");

			md.addAttribute("listvaluesdatas", bRECON_DESTINATION_REPO.getDestination());
			md.addAttribute("listcoredatas", coresystemlistrep.getcoresystemlistdata());
		}

		return "Brecon_Partialtransaction";
	}

	@RequestMapping(value = "Manualtransaction", method = RequestMethod.GET)
	public String Manualtransaction(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("listvaluesdatas", bRECON_DESTINATION_REPO.getDestination());
			md.addAttribute("listcoredatas", coresystemlistrep.getcoresystemlistdata());
		}

		return "Brecon_Manualtransaction";
	}

	@RequestMapping(value = "Tmtfiletransaction", method = RequestMethod.GET)
	public String Tmtfiletransaction(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("chargeback", bRECON_DESTINATION_REPO.getlist());
		} else if (formmode.equals("upload")) {
			md.addAttribute("formmode", "upload");
		} else if (formmode.equals("list1")) {
			md.addAttribute("formmode", "list1");
		} else if (formmode.equals("upload1")) {
			md.addAttribute("formmode", "upload1");
		} else if (formmode.equals("upload2")) {
			md.addAttribute("formmode", "upload2");
		} else if (formmode.equals("upload3")) {
			md.addAttribute("formmode", "upload3");
		} else if (formmode.equals("upload4")) {
			md.addAttribute("formmode", "upload4");
		}

		return "Brecon_Tmt_File";
	}

	@RequestMapping(value = "Audittrailvalue", method = RequestMethod.GET)
	public String Audittrailvalue(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
		} else if (formmode.equals("upload")) {
			md.addAttribute("formmode", "upload");
		} else if (formmode.equals("list1")) {
			md.addAttribute("formmode", "list1");
		} else if (formmode.equals("upload1")) {
			md.addAttribute("formmode", "upload1");
		} else if (formmode.equals("upload2")) {
			md.addAttribute("formmode", "upload2");
		} else if (formmode.equals("upload3")) {
			md.addAttribute("formmode", "upload3");
		}

		return "Audittrails";
	}

	@RequestMapping(value = "useractivities", method = { RequestMethod.GET, RequestMethod.POST })
	public String useractivities(@RequestParam(required = false) String formmode, Model model, String cust_id,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date Fromdate,
			HttpServletRequest request) {
		LocalDate today = LocalDate.now(); // Get today's date
		Date fromDateToUse; // Declare a variable for the date to use

		if (Fromdate != null) {
			// If Fromdate has a value, use it
			fromDateToUse = Fromdate;
		} else {
			// If Fromdate has no value, use today's date
			fromDateToUse = java.sql.Date.valueOf(today);
		}

		if (formmode == null || formmode.equals("list")) {
			model.addAttribute("formmode", "list");

			// Fetch the audit list based on the determined date

			model.addAttribute("AuditList", bRECON_Audit_Rep.getauditListLocalvaluesbusiness(fromDateToUse));

		}

		return "AuditTrailValues";
	}

	@RequestMapping(value = "OperationLogsval", method = { RequestMethod.GET, RequestMethod.POST })
	public String OperationLogsval(@RequestParam(required = false) String formmode, Model model, String cust_id,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date Fromdate,
			HttpServletRequest request) {

		LocalDate today = LocalDate.now(); // Get today's date
		Date fromDateToUse; // Declare a variable for the date to use
		if (Fromdate != null) {
			// If Fromdate has a value, use it
			fromDateToUse = Fromdate;
		} else {
			// If Fromdate has no value, use today's date
			fromDateToUse = java.sql.Date.valueOf(today);
		}

		if (formmode == null || formmode.equals("list")) {
			model.addAttribute("formmode", "list");
			model.addAttribute("AuditList", bRECON_Audit_Rep.getauditListLocalvaluesbusiness1(fromDateToUse));
		}

		return "BusinessTrail";
	}

	@RequestMapping(value = "ManualAudittrailvalue", method = RequestMethod.GET)
	public String ManualAudittrailvalue(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
		} else if (formmode.equals("upload")) {
			md.addAttribute("formmode", "upload");
		} else if (formmode.equals("list1")) {
			md.addAttribute("formmode", "list1");
		} else if (formmode.equals("upload1")) {
			md.addAttribute("formmode", "upload1");
		} else if (formmode.equals("upload2")) {
			md.addAttribute("formmode", "upload2");
		} else if (formmode.equals("upload3")) {
			md.addAttribute("formmode", "upload3");
		}

		return "Manual_Audit_service";
	}

	@RequestMapping(value = "Manualuseractivities", method = { RequestMethod.GET, RequestMethod.POST })
	public String Manualuseractivities(@RequestParam(required = false) String formmode, Model model, String cust_id,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date Fromdate,
			HttpServletRequest request) {
		LocalDate today = LocalDate.now(); // Get today's date
		Date fromDateToUse; // Declare a variable for the date to use

		if (Fromdate != null) {
			// If Fromdate has a value, use it
			fromDateToUse = Fromdate;
		} else {
			// If Fromdate has no value, use today's date
			fromDateToUse = java.sql.Date.valueOf(today);
		}

		if (formmode == null || formmode.equals("list")) {
			model.addAttribute("formmode", "list");

			// Fetch the audit list based on the determined date

			model.addAttribute("AuditList", mANUAL_Audit_Rep.getauditListLocalvaluesbusiness(fromDateToUse));

		}

		return "Manual_User_Activity";
	}

	@RequestMapping(value = "ManualOperationLogsval", method = { RequestMethod.GET, RequestMethod.POST })
	public String ManualOperationLogsval(@RequestParam(required = false) String formmode, Model model, String cust_id,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date Fromdate,
			HttpServletRequest request) {

		LocalDate today = LocalDate.now(); // Get today's date
		Date fromDateToUse; // Declare a variable for the date to use
		if (Fromdate != null) {
			// If Fromdate has a value, use it
			fromDateToUse = Fromdate;
		} else {
			// If Fromdate has no value, use today's date
			fromDateToUse = java.sql.Date.valueOf(today);
		}

		if (formmode == null || formmode.equals("list")) {
			model.addAttribute("formmode", "list");
			model.addAttribute("AuditList", mANUAL_Service_Rep.getauditListLocalvaluesbusiness(fromDateToUse));
		}

		return "Manual_Business_Activity";
	}

	@RequestMapping(value = "Reconsilationdatas", method = RequestMethod.GET)
	public String Reconsilationdatas(@RequestParam(required = false) String formmode, String Offsetval, String Limitval,
			@RequestParam(required = false) String srlno, String keyword, Model md,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date Fromdate,
			HttpServletRequest req) {

		LocalDate today = LocalDate.now(); // Get today's date
		Date fromDateToUse; // Declare a variable for the date to use

		if (Fromdate != null) {
			// If Fromdate has a value, use it
			fromDateToUse = Fromdate;
		} else {
			// If Fromdate has no value, use today's date
			fromDateToUse = java.sql.Date.valueOf(today.minusDays(1));
		}

		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			// common table
			md.addAttribute("listvaluesdatas", bRECON_Common_Table_Rep.getcommondatavalues(fromDateToUse));
			md.addAttribute("datavalue", fromDateToUse);
			// source table
			md.addAttribute("listcoredatas1", coresystemlistrep.getcoresystemlistvalue(fromDateToUse));
			// destination table
			md.addAttribute("listvaluesdatas1", bRECON_DESTINATION_REPO.getDestinationdatavalues(fromDateToUse));
			// ttum transaction
			List<BRECON_TTUM_TRANSACTION_ENTITY> ttumtransacdatas = BRECON_TTUM_TRANSACTION_REP
					.getttumtransaction(fromDateToUse);
			md.addAttribute("ttumtransacdatas", ttumtransacdatas);

			String totalDebitentries = "0";
			String totalDebitamount = "0";
			String totalCreditentries = "0";
			String totalCreditamount = "0";

			totalDebitentries = bRECON_Common_Table_Rep.getdebitentries(fromDateToUse);
			totalDebitamount = bRECON_Common_Table_Rep.getdebitamount(fromDateToUse);

			totalCreditentries = bRECON_Common_Table_Rep.getcreditentries(fromDateToUse);
			totalCreditamount = bRECON_Common_Table_Rep.getcreditamount(fromDateToUse);

			/// Entries and amount
			md.addAttribute("totalDebitentries", totalDebitentries);
			md.addAttribute("totalDebitamount", totalDebitamount);
			md.addAttribute("totalCreditentries", totalCreditentries);
			md.addAttribute("totalCreditamount", totalCreditamount);

			// popup
			md.addAttribute("listcoredatas21", bRECON_Common_Table_Rep.getDestinationvaluesdatavalue());

		} else if (formmode.equals("upload")) {
			md.addAttribute("formmode", "upload");
		} else if (formmode.equals("view1")) {
			md.addAttribute("formmode", "view1");
			md.addAttribute("srlno", brecon_core_rep.getSrlno(srlno));
		}
		return "Reconsilationprocess";
	}

	@RequestMapping(value = "Reconsilationdupli", method = RequestMethod.GET)
	public String Reconsilationdupli(@RequestParam(required = false) String formmode, String Offsetval, String Limitval,
			@RequestParam(required = false) String srlno, String keyword, Model md,
			@RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date Fromdate,
			HttpServletRequest req) {

		LocalDate today = LocalDate.now(); // Get today's date
		Date fromDateToUse; // Declare a variable for the date to use

		if (Fromdate != null) {
			// If Fromdate has a value, use it
			fromDateToUse = Fromdate;
		} else {
			// If Fromdate has no value, use today's date
			fromDateToUse = java.sql.Date.valueOf(today.minusDays(1));
		}

		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("datavalue", fromDateToUse);
			// common table
			md.addAttribute("listvaluesdatas", Brecon_Aani_payment_dup_rep.getDestinationdatavalues(fromDateToUse));

		}
		return "Reconsilationdupli";
	}

	@Autowired
	Kyc_Repo kyc_repo;
	@Autowired
	Kyc_Corprate_Repo kyc_corporate_repo;
	@Autowired
	com.bornfire.xbrl.services.Kyc_Corprate_service Kyc_Corprate_service;
	@Autowired
	IndividualPdfService IndividualPdfService;
	@Autowired
	KYC_Audit_Rep KYC_Audit_Rep;

	@RequestMapping(value = "kyc", method = { RequestMethod.GET, RequestMethod.POST })
	public String KYCHome(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String customerRisk, @RequestParam(required = false) Integer age, // 'age'
																												// here
																												// means
																												// pending
																												// days
			Model md, HttpServletRequest req) {

		String ROLEID = (String) req.getSession().getAttribute("ROLEID");
		String BRANCHCODE = (String) req.getSession().getAttribute("BRANCHCODE");

		formmode = (formmode == null) ? "individual" : formmode;

		boolean isBranchRole = "DCD_BRANCH".equals(ROLEID);
		// Check if both filter parameters are present and not empty
		boolean hasFilters = (customerRisk != null && !customerRisk.isEmpty() && age != null);

		if ("corporate".equals(formmode)) {
			List<Object[]> results = isBranchRole
					? (hasFilters ? kyc_corporate_repo.getBranchDynamicValue(customerRisk, age, BRANCHCODE)
							: kyc_corporate_repo.getBranchList(BRANCHCODE))
					: (hasFilters ? kyc_corporate_repo.getDynamicValue(customerRisk, age)
							: kyc_corporate_repo.getList());
			md.addAttribute("kycData", results);
		} else { // Individual case
			List<Object[]> results = isBranchRole
					? (hasFilters
							? ecddIndividualProfileRepository.findFilteredIndividualsByBranch(customerRisk, age,
									BRANCHCODE)
							: ecddIndividualProfileRepository.findAllIndividualsByBranch(BRANCHCODE))
					: (hasFilters ? ecddIndividualProfileRepository.findFilteredIndividuals(customerRisk, age)
							: ecddIndividualProfileRepository.findAllIndividuals());
			md.addAttribute("reportlist", results);
		}

		md.addAttribute("formmode", formmode);
		return "KYC_Home";
	}

	@RequestMapping(value = "/kyc/individual", method = { RequestMethod.GET, RequestMethod.POST })
	public Object kycIndividual(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String custid, @RequestParam(required = false) String srlno,
			@RequestParam(defaultValue = "false") boolean ajax, @ModelAttribute Ecdd_Individual_Profile_Entity data,
			Model model, HttpServletRequest req) throws Exception {

		if (ajax) {
			try {
				boolean success = kyc_individual_service.updateKycData(srlno, data, req);
				if (success) {
					return new ResponseEntity<>("Section saved successfully.", HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Record not found for SRL No: " + srlno, HttpStatus.NOT_FOUND);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<>("Error saving data: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		if ("submit".equals(formmode)) {
			kyc_individual_service.updateKycData(srlno, data, req);
			return "redirect:/kyc/individual?formmode=view&srlno=" + srlno;
		}

		if ("verified".equals(formmode)) {
			kyc_individual_service.verified(custid, req);
		} else if ("download".equals(formmode)) {
			kyc_individual_service.GrtPdf(custid);
		} else if ("view".equals(formmode)) {
			model.addAttribute("formmode", "view");
			Ecdd_Individual_Profile_Entity user_data = ecddIndividualProfileRepository.GetUserBySrlNo(srlno);
			model.addAttribute("user_data", user_data);
		} else if ("modify".equals(formmode)) {
			model.addAttribute("formmode", "modify");
			Ecdd_Individual_Profile_Entity user_data = ecddIndividualProfileRepository.GetUserBySrlNo(srlno);
			model.addAttribute("user_data", user_data);
		} else if ("verify".equals(formmode)) {
			model.addAttribute("formmode", "verify");
			Ecdd_Individual_Profile_Entity user_data = ecddIndividualProfileRepository.GetUserBySrlNo(srlno);
			model.addAttribute("user_data", user_data);
		}

		return "Kyc_individual_ecdd";
	}

	@RequestMapping(value = "/kyc/corporate", method = { RequestMethod.GET, RequestMethod.POST })
	public String kyccorporate(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String uae, @RequestParam(required = false) String custid,
			@RequestParam(required = false) String srl_no, @ModelAttribute EcddCorporateEntity data, Model model,
			HttpServletRequest req, HttpServletResponse response)
			throws FileNotFoundException, JRException, SQLException, Exception {

		System.out.println("KYC Corporate form called");

		String userId = (String) req.getSession().getAttribute("USERID");
		String userName = (String) req.getSession().getAttribute("USERNAME");
		String workClass = (String) req.getSession().getAttribute("WORKCLASS");

		String ajaxParam = req.getParameter("ajax");
		if ("true".equals(ajaxParam)) {
			try {
				Kyc_Corprate_service.updateKycData(srl_no, data, req);

				response.setContentType("application/json");
				response.getWriter().write("{\"status\":\"success\", \"message\":\"Section saved!\"}");
				return null;
			} catch (Exception e) {
				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				response.getWriter()
						.write("{\"status\":\"error\", \"message\":\"Save failed: " + e.getMessage() + "\"}");
				return null;
			}
		}

		if ("submit".equalsIgnoreCase(formmode)) {
			Kyc_Corprate_service.updateKycData(srl_no, data, req);
			formmode = "view";
		} else if ("verified".equalsIgnoreCase(formmode)) {
			Kyc_Corprate_service.verified(custid, req);
		} else if ("download".equalsIgnoreCase(formmode)) {
			Kyc_Corprate_service.GrtPdf(srl_no, req);
		}

		List<EcddCorporateEntity> user_data = kyc_corporate_repo.GetUser(srl_no);
		model.addAttribute("userId", userId);
		model.addAttribute("user_data", user_data);
		model.addAttribute("formmode", formmode);

		return "kyc_corporate";
	}

	@PostMapping("/kyc/corporate/verify")
	@ResponseBody
	public String verifyRecord(@RequestParam String custid, HttpServletRequest req) {
		try {
			Kyc_Corprate_service.verified(custid, req);
			return "Verification successful";
		} catch (Exception e) {
			e.printStackTrace();
			return "Verification failed";
		}
	}

	@GetMapping("/kyc/Oneyeartran/Download")
	@ResponseBody
	public ResponseEntity<InputStreamResource> downloadCustomer(@RequestParam String custid, HttpServletRequest req) {

		List<Ecdd_customer_transaction> transactions = Ecdd_customer_transaction_repo.gettrandetails(custid);
		System.out.println("Enter Ecddv Transaction Download");

		if (transactions.isEmpty()) {
			System.out.println("No Transaction available for this customer");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}

		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
			Sheet sheet = workbook.createSheet("Transactions");

			// Style for header
			CellStyle headerStyle = workbook.createCellStyle();
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerStyle.setFont(headerFont);
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderTop(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);

			// Style for normal cells
			CellStyle borderStyle = workbook.createCellStyle();
			borderStyle.setBorderBottom(BorderStyle.THIN);
			borderStyle.setBorderTop(BorderStyle.THIN);
			borderStyle.setBorderLeft(BorderStyle.THIN);
			borderStyle.setBorderRight(BorderStyle.THIN);

			// Header row
			String[] headers = { "CUSTOMER ID", "TRAN DATE", "TRAN ID", "TRAN TYPE", "SUB TRAN TYPE",
					"TRANSACTION INDICATOR", "TRANSACTION AMOUNT", "TRAN PARTICULAR" };

			Row header = sheet.createRow(0);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = header.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(headerStyle);
			}

			// Data rows
			int rowNum = 1;
			for (Ecdd_customer_transaction tx : transactions) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(tx.getCustomer_id());
				row.createCell(1).setCellValue(tx.getTran_date().toString());
				row.createCell(2).setCellValue(tx.getTran_id());
				row.createCell(3).setCellValue(tx.getTran_type());
				row.createCell(4).setCellValue(tx.getSub_tran_type());
				row.createCell(5).setCellValue(tx.getTranaction_indicator());
				row.createCell(6).setCellValue(tx.getTransaction_amount().doubleValue());
				row.createCell(7).setCellValue(tx.getTran_particular());

				// Apply border style to all cells in row
				for (int i = 0; i < 8; i++) {
					row.getCell(i).setCellStyle(borderStyle);
				}
			}

			// Auto-size all columns
			for (int i = 0; i < headers.length; i++) {
				sheet.autoSizeColumn(i);
			}

			// Protect the sheet with password (read-only protection)
			sheet.protectSheet("Banktrandetailsbornfire@12345"); // Set your own password here

			// Write to stream
			workbook.write(out);
			ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

			HttpHeaders headersHttp = new HttpHeaders();
			headersHttp.add("Content-Disposition", "attachment; filename=" + custid + "_transactions.xlsx");

			return ResponseEntity.ok().headers(headersHttp).contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(new InputStreamResource(in));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("kyc/Reportstatus/Download")
	@ResponseBody
	public ResponseEntity<InputStreamResource> Downlaodkycstatus(HttpServletRequest req) {

		logger.info("Receiving Kyc status download request");

		List<Object[]> completedstatus = ecddIndividualProfileRepository.getstatuscount();
		List<Object[]> pendingstatus = ecddIndividualProfileRepository.getpendingstatuscount();
		List<Object[]> corpcompletedstatus = kyc_corporate_repo.getstatuscount();
		List<Object[]> corppendingstatus = kyc_corporate_repo.getpendingstatuscount();
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {

			Sheet sheet = workbook.createSheet("ECDD Report Status");

			// Create title style
			CellStyle titleStyle = workbook.createCellStyle();
			Font titleFont = workbook.createFont();
			titleFont.setBold(true);
			titleFont.setFontHeightInPoints((short) 14);
			titleStyle.setFont(titleFont);
			titleStyle.setAlignment(HorizontalAlignment.CENTER);
			titleStyle.setVerticalAlignment(VerticalAlignment.CENTER);

			// Create header style
			CellStyle headerStyle = workbook.createCellStyle();
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerStyle.setFont(headerFont);
			headerStyle.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setBorderBottom(BorderStyle.THIN);
			headerStyle.setBorderTop(BorderStyle.THIN);
			headerStyle.setBorderLeft(BorderStyle.THIN);
			headerStyle.setBorderRight(BorderStyle.THIN);
			headerStyle.setAlignment(HorizontalAlignment.CENTER);

			// Border style for data cells
			CellStyle borderStyle = workbook.createCellStyle();
			borderStyle.setBorderBottom(BorderStyle.THIN);
			borderStyle.setBorderTop(BorderStyle.THIN);
			borderStyle.setBorderLeft(BorderStyle.THIN);
			borderStyle.setBorderRight(BorderStyle.THIN);

			// INDIVIDUAL Completed: Rows 0–10, Columns A–D
			Row indivTitleRow = sheet.createRow(0);
			indivTitleRow.setHeightInPoints(20);
			Cell indivBankCell = indivTitleRow.createCell(0);
			indivBankCell.setCellValue("Bank of Baroda");
			indivBankCell.setCellStyle(titleStyle);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

			Row indivSubTitleRow = sheet.createRow(1);
			indivSubTitleRow.setHeightInPoints(18);
			Cell indivSubTitleCell = indivSubTitleRow.createCell(0);
			indivSubTitleCell.setCellValue("Ecdd Individual Completed Status");
			indivSubTitleCell.setCellStyle(titleStyle);
			sheet.addMergedRegion(new CellRangeAddress(1, 1, 0, 3));

			Row indivHeaderRow = sheet.createRow(2);
			String[] headers = { "Branch Name", "Low Risk", "Medium Risk", "High Risk" };
			for (int i = 0; i < headers.length; i++) {
				Cell cell = indivHeaderRow.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(headerStyle);
			}

			int indivRowNum = 3;
			for (Object[] rowData : completedstatus) {
				Row row = sheet.createRow(indivRowNum++);
				for (int col = 0; col < rowData.length; col++) {
					Cell cell = row.createCell(col);
					if (rowData[col] instanceof String) {
						cell.setCellValue((String) rowData[col]);
					} else if (rowData[col] instanceof Number) {
						cell.setCellValue(((Number) rowData[col]).doubleValue());
					}
					cell.setCellStyle(borderStyle);
				}
			}

			Row indivPendingTitle = sheet.createRow(11);
			indivPendingTitle.setHeightInPoints(18);
			Cell pendingTitleCell = indivPendingTitle.createCell(0);
			pendingTitleCell.setCellValue("Ecdd Individual Pending Status");
			pendingTitleCell.setCellStyle(titleStyle);
			sheet.addMergedRegion(new CellRangeAddress(11, 11, 0, 3));

			Row indivPendingHeader = sheet.createRow(12);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = indivPendingHeader.createCell(i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(headerStyle);
			}

			int indivPendingRowNum = 13;
			for (Object[] rowData : pendingstatus) {
				Row row = sheet.createRow(indivPendingRowNum++);
				for (int col = 0; col < rowData.length; col++) {
					Cell cell = row.createCell(col);
					if (rowData[col] instanceof String) {
						cell.setCellValue((String) rowData[col]);
					} else if (rowData[col] instanceof Number) {
						cell.setCellValue(((Number) rowData[col]).doubleValue());
					}
					cell.setCellStyle(borderStyle);
				}
			}

			Row corpTitleRow = sheet.getRow(0);
			Cell corpBankCell = corpTitleRow.createCell(6); // G
			corpBankCell.setCellValue("Bank of Baroda");
			corpBankCell.setCellStyle(titleStyle);
			sheet.addMergedRegion(new CellRangeAddress(0, 0, 6, 9));

			Row corpSubTitleRow = sheet.getRow(1);
			Cell corpSubTitleCell = corpSubTitleRow.createCell(6);
			corpSubTitleCell.setCellValue("Ecdd Corporate Completed Status");
			corpSubTitleCell.setCellStyle(titleStyle);
			sheet.addMergedRegion(new CellRangeAddress(1, 1, 6, 9));

			Row corpHeaderRow = sheet.getRow(2);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = corpHeaderRow.createCell(6 + i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(headerStyle);
			}

			int corpRowNum = 3;
			for (Object[] rowData : corpcompletedstatus) {
				Row row = sheet.getRow(corpRowNum);
				if (row == null)
					row = sheet.createRow(corpRowNum);
				for (int col = 0; col < rowData.length; col++) {
					Cell cell = row.createCell(6 + col);
					if (rowData[col] instanceof String) {
						cell.setCellValue((String) rowData[col]);
					} else if (rowData[col] instanceof Number) {
						cell.setCellValue(((Number) rowData[col]).doubleValue());
					}
					cell.setCellStyle(borderStyle);
				}
				corpRowNum++;
			}

			Row corpPendTitle = sheet.getRow(11);
			Cell corpPendingTitleCell = corpPendTitle.createCell(6);
			corpPendingTitleCell.setCellValue("Ecdd Corporate Pending Status");
			corpPendingTitleCell.setCellStyle(titleStyle);
			sheet.addMergedRegion(new CellRangeAddress(11, 11, 6, 9));

			Row corpPendHeader = sheet.getRow(12);
			for (int i = 0; i < headers.length; i++) {
				Cell cell = corpPendHeader.createCell(6 + i);
				cell.setCellValue(headers[i]);
				cell.setCellStyle(headerStyle);
			}

			int corpPendRowNum = 13;
			for (Object[] rowData : corppendingstatus) {
				Row row = sheet.getRow(corpPendRowNum);
				if (row == null)
					row = sheet.createRow(corpPendRowNum);
				for (int col = 0; col < rowData.length; col++) {
					Cell cell = row.createCell(6 + col);
					if (rowData[col] instanceof String) {
						cell.setCellValue((String) rowData[col]);
					} else if (rowData[col] instanceof Number) {
						cell.setCellValue(((Number) rowData[col]).doubleValue());
					}
					cell.setCellStyle(borderStyle);
				}
				corpPendRowNum++;
			}

			// Write to output stream
			workbook.write(out);
			ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());

			// If you want to return as ResponseEntity (Spring Boot)
			HttpHeaders headersHttp = new HttpHeaders();
			headersHttp.add("Content-Disposition", "attachment; filename=ecdd_completed_report.xlsx");

			return ResponseEntity.ok().headers(headersHttp).contentType(MediaType.APPLICATION_OCTET_STREAM)
					.body(new InputStreamResource(in));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping("/kyc/individual/verify")
	@ResponseBody
	public String verifyindRecord(@RequestParam String custid, HttpServletRequest req) {
		try {
			kyc_individual_service.verified(custid, req);
			return "Verification successful";
		} catch (Exception e) {
			e.printStackTrace();
			return "Verification failed";
		}
	}

	@RequestMapping(value = "kyc/corporate/download", method = RequestMethod.GET)

	@ResponseBody
	public ResponseEntity<InputStreamResource> corporateDownload(HttpServletResponse response, HttpServletRequest req,
			@RequestParam(required = false) String srl_no) throws IOException, SQLException {

		try {

			File repfile = Kyc_Corprate_service.GrtPdf(srl_no, req);

			System.out.println("Generated file: " + repfile.getName());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment", repfile.getName());

			InputStreamResource resource = new InputStreamResource(new FileInputStream(repfile));

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
					.contentLength(repfile.length()).body(resource);
		} catch (IOException | SQLException | JRException e) {
			logger.error("Error occurred while processing the file download: " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@RequestMapping(value = "kyc/individual/downloadfn", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<InputStreamResource> individualDownload(HttpServletResponse response, HttpServletRequest req,
			@RequestParam(required = false) String srlno) throws Exception {

		try {

			File repfile = IndividualPdfService.generateIndividualPdf(srlno, req);

			System.out.println("Generated file: " + repfile.getName());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment", repfile.getName());

			InputStreamResource resource = new InputStreamResource(new FileInputStream(repfile));

			return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_OCTET_STREAM)
					.contentLength(repfile.length()).body(resource);
		} catch (IOException | SQLException | JRException e) {
			logger.error("Error occurred while processing the file download: " + e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@RequestMapping(value = "auditlogs", method = RequestMethod.GET)
	public String Auditvalue(@RequestParam(required = false) String formmode,
			@RequestParam(required = false) String srlno, String keyword, Model md, HttpServletRequest req) {
		if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
		} else if (formmode.equals("upload")) {
			md.addAttribute("formmode", "upload");
		} else if (formmode.equals("list1")) {
			md.addAttribute("formmode", "list1");
		} else if (formmode.equals("upload1")) {
			md.addAttribute("formmode", "upload1");
		} else if (formmode.equals("upload2")) {
			md.addAttribute("formmode", "upload2");
		} else if (formmode.equals("upload3")) {
			md.addAttribute("formmode", "upload3");
		}

		return "Audittrailskyc";
	}

	@RequestMapping(value = "useractivity", method = { RequestMethod.GET, RequestMethod.POST })
	public String useractivity(@RequestParam(required = false) String formmode, Model model, String cust_id,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date Fromdate,
			HttpServletRequest request) {
		LocalDate today = LocalDate.now(); // Get today's date
		Date fromDateToUse; // Declare a variable for the date to use

		if (Fromdate != null) {
			// If Fromdate has a value, use it
			fromDateToUse = Fromdate;
		} else {
			// If Fromdate has no value, use today's date
			fromDateToUse = java.sql.Date.valueOf(today);
		}

		if (formmode == null || formmode.equals("list")) {
			model.addAttribute("formmode", "list");

			// Fetch the audit list based on the determined date

			model.addAttribute("AuditList", KYC_Audit_Rep.getauditListLocalvaluesbusiness(fromDateToUse));

		}

		return "AuditTrailValueskyc";
	}

	@RequestMapping(value = "OperationLogs", method = { RequestMethod.GET, RequestMethod.POST })
	public String OperationLogs(@RequestParam(required = false) String formmode, Model model, String cust_id,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date Fromdate,
			HttpServletRequest request) {

		LocalDate today = LocalDate.now(); // Get today's date
		Date fromDateToUse; // Declare a variable for the date to use
		if (Fromdate != null) {
			// If Fromdate has a value, use it
			fromDateToUse = Fromdate;
		} else {
			// If Fromdate has no value, use today's date
			fromDateToUse = java.sql.Date.valueOf(today);
		}

		if (formmode == null || formmode.equals("list")) {
			model.addAttribute("formmode", "list");
			model.addAttribute("AuditList", KYC_Audit_Rep.getauditListLocalvaluesbusiness1(fromDateToUse));
		}

		return "BusinessTrailkyc";
	}

	@RequestMapping(value = "getchanges", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String fetchChanges(@RequestParam(required = false) String audit_ref_no) {

		// Fetch data from the database using the repository
		String changeDetails = KYC_Audit_Rep.getchanges(audit_ref_no); // Example of getting data

		// Process the change details to format as required

		return changeDetails; // Return the formatted changes
	}

	@RequestMapping(value = "custprofile", method = RequestMethod.GET)
	public String custprofile(@RequestParam(required = false) String cif_id,
			@RequestParam(required = false) String acct_no, @RequestParam(required = false) String formmode,
			@RequestParam(required = false) String customerType, @RequestParam(required = false) String tranId, // New
			@RequestParam(required = false) String billId, @RequestParam(required = false) String BG_SRL_NUM, // parameter
			@RequestParam(required = false) String DC_ID, Model md, HttpServletRequest req) {

		formmode = (formmode == null) ? "list" : formmode;
		md.addAttribute("formmode", formmode);
		/*
		 * System.out.println("Received cif_id: " + cif_id);
		 * System.out.println("Received natIdCardNum: " + natIdCardNum);
		 */
		/*
		 * if (tranId != null && !tranId.isEmpty()) { md.addAttribute("gettransaction",
		 * charge_Back_Rep.gettransaction(tranId)); } else { // Handle case when tranId
		 * is null or empty md.addAttribute("gettransaction", new ArrayList<>()); //
		 * Send an empty list to avoid errors }
		 */
		if (formmode == "transdetails") {
			System.out.println("hihihihihihi" + charge_Back_Rep.gettransaction(tranId));
			md.addAttribute("gettransaction", charge_Back_Rep.gettransaction(tranId));

		}
		switch (formmode) {
		case "list":
			md.addAttribute("getlistcust", charge_Back_Rep.getAllcust());
			break;
		case "Dataquality":
			md.addAttribute("getper", charge_Back_Rep.getper(cif_id, acct_no));
			break;
		/*
		 * case "persdetail": md.addAttribute("getpersonal",
		 * charge_Back_Rep.getpersonal(cif_id)); break; case "adrsdetail":
		 * md.addAttribute("getadress", charge_Back_Rep.getadress(cif_id)); break; case
		 * "tradinfinance": md.addAttribute("gettrad", charge_Back_Rep.gettrad(cif_id));
		 * break; case "empdetail": md.addAttribute("getemploye",
		 * charge_Back_Rep.getemploye(cif_id)); break; case "documentdetail":
		 * md.addAttribute("getdocument", charge_Back_Rep.getdocument(cif_id)); break;
		 * case "acctsdetail": md.addAttribute("getaccts2",
		 * charge_Back_Rep.getaccts2(acct_no)); break; case "transdetails":
		 * md.addAttribute("gettransaction", charge_Back_Rep.gettransaction(tranId));
		 * break; case "photodetail": md.addAttribute("getpic",
		 * charge_Back_Rep.getpic(cif_id, acct_no)); break; case "JointHolderdetails":
		 * md.addAttribute("getjoint", charge_Back_Rep.getjoint(cif_id)); break; case
		 * "signdetail": md.addAttribute("getsignature",
		 * charge_Back_Rep.getsignature(cif_id)); break; case "associatedetail":
		 * md.addAttribute("getassociate", charge_Back_Rep.getassociate(cif_id)); break;
		 * case "tradflgdetail": //System.out.println("Received BILL_ID: " + billId);
		 * System.out.println( "CIF_ID: " + cif_id + ", BILL_ID: " + billId);
		 * 
		 * md.addAttribute("gettradEflg", charge_Back_Rep.gettradEflg(cif_id, billId));
		 * break;
		 * 
		 * case "tradflgBankGuarantee": //System.out.println("Received BILL_ID: " +
		 * billId); System.out.println( "CIF_ID: " + cif_id + ", BG_SRL_NUM: " +
		 * BG_SRL_NUM);
		 * 
		 * md.addAttribute("getbankflag", charge_Back_Rep.getbankflag(cif_id,
		 * BG_SRL_NUM)); break; case "tradflgLetterOfCredit":
		 * //System.out.println("Received BILL_ID: " + billId); System.out.println(
		 * "CIF_ID: " + cif_id + ", DC_ID: " + DC_ID);
		 * 
		 * md.addAttribute("getLetofcreditS", charge_Back_Rep.getLetofcreditS(cif_id,
		 * DC_ID)); break;
		 */

		default:
			break;
		}

		return "QA_Customer_profile.html";
	}

	@RequestMapping(value = "acctprofile", method = RequestMethod.GET)
	public String acctprofile(@RequestParam(required = false) String cif_id, String acct_no, String formmode,
			@RequestParam(required = false) String customerType1, @RequestParam(required = false) String tranId,
			@RequestParam(required = false) String billId, Model md, HttpServletRequest req) {

		// Default formmode to "list" if null
		formmode = (formmode == null) ? "list" : formmode;
		md.addAttribute("formmode", formmode);

		// If formmode is "trandetail" and tranId is not null
		if ("trandetail".equals(formmode) && tranId != null) {
			System.out.println("Fetching transactions for tranId: " + tranId);
			md.addAttribute("gettransactions", charge_Back_Rep.gettransactions(tranId));
		}

		else if (formmode == null || formmode.equals("list")) {
			md.addAttribute("formmode", "list");
			md.addAttribute("getlistacct", charge_Back_Rep.getAllacct());
		} else if (formmode.equals("Dataquality")) {
			md.addAttribute("formmode", "Dataquality");
			md.addAttribute("getper", charge_Back_Rep.getper(cif_id, acct_no));
		} else if (formmode.equals("persdetail")) {
			md.addAttribute("formmode", "persdetail");
			md.addAttribute("getper", charge_Back_Rep.getper(cif_id, acct_no));
		} else if (formmode.equals("adrdetail")) {
			md.addAttribute("formmode", "adrdetail");
			md.addAttribute("getadres", charge_Back_Rep.getadres(cif_id, acct_no));
		} else if (formmode.equals("acctdetail")) {
			md.addAttribute("formmode", "acctdetail");
			/* md.addAttribute("getacct", charge_Back_Rep.getacct(cif_id, acct_no)); */
			md.addAttribute("getaccts1", charge_Back_Rep.getaccts1(acct_no));
		} else if (formmode.equals("trandetail")) {
			md.addAttribute("formmode", "trandetail");
			md.addAttribute("gettransactions", charge_Back_Rep.gettransactions(tranId));
		} else if (formmode.equals("docdetail")) {
			md.addAttribute("formmode", "docdetail");
			md.addAttribute("getdoc", charge_Back_Rep.getdoc(cif_id, acct_no));
		} else if (formmode.equals("tradefinance")) {
			md.addAttribute("formmode", "tradefinance");
			md.addAttribute("gettrade", charge_Back_Rep.gettrade(cif_id, acct_no));
		} else if (formmode.equals("empprofile")) {
			md.addAttribute("formmode", "empprofile");
			md.addAttribute("getemp", charge_Back_Rep.getemp(cif_id, acct_no));
		} else if (formmode.equals("signdetail")) {
			md.addAttribute("formmode", "signdetail");
			md.addAttribute("getsign", charge_Back_Rep.getsign(cif_id, acct_no));
		} else if (formmode.equals("associatedetail")) {
			md.addAttribute("formmode", "associatedetail");
			md.addAttribute("getassociated", charge_Back_Rep.getassociated(cif_id, acct_no));
		} else if (formmode.equals("JointHolderdetails")) {
			md.addAttribute("formmode", "JointHolderdetails");
			md.addAttribute("getjoints", charge_Back_Rep.getjoints(cif_id, acct_no));
		} else if (formmode.equals("photodetails")) {
			md.addAttribute("formmode", "photodetails");
			md.addAttribute("getpics", charge_Back_Rep.getpics(cif_id, acct_no));
		} else if (formmode.equals("tradeflgdetail")) {
			md.addAttribute("formmode", "tradeflgdetail");
			System.out.println("CIF_ID: " + cif_id + ", BILL_ID: " + billId);
			md.addAttribute("gettradEflag", charge_Back_Rep.gettradEflag(cif_id, billId));
		} else if ("corporate".equals(customerType1)) {
			md.addAttribute("formmode", "cifnumber1");
			md.addAttribute("getAll1", charge_Back_Rep.getCorporateCustomers1());
		}

		return "QA_Account_profile.html";
	}

	@RequestMapping(value = "dataQuality", method = RequestMethod.GET)
	public String dataprofile(@RequestParam(required = false) String cif_id,
			@RequestParam(required = false) String acct_no, @RequestParam(required = false) String formmode,
			@RequestParam(required = false) String customerType, @RequestParam(required = false) String tranId, // New
																												// parameter
			Model md, HttpServletRequest req) {

		formmode = (formmode == null) ? "list" : formmode;
		md.addAttribute("formmode", formmode);
		/*
		 * System.out.println("Received cif_id: " + cif_id);
		 * System.out.println("Received natIdCardNum: " + natIdCardNum);
		 */
		if (tranId != null && !tranId.isEmpty()) {
			md.addAttribute("gettransaction", charge_Back_Rep.gettransaction(tranId));
		} else {
			// Handle case when tranId is null or empty
			md.addAttribute("gettransaction", new ArrayList<>()); // Send an empty list to avoid errors
		}

		if (formmode == "transdetails") {
			System.out.println("hihihihihihi" + charge_Back_Rep.gettransaction(tranId));
			md.addAttribute("gettransaction", charge_Back_Rep.gettransaction(tranId));

		}
		switch (formmode) {
		/*
		 * case "list": md.addAttribute("getlistcust", charge_Back_Rep.getAllcust());
		 * break; case "list": md.addAttribute("getlistcust",
		 * charge_Back_Rep.getAllcust()); break;
		 */
		case "Dataquality":
			md.addAttribute("getper", charge_Back_Rep.getper(cif_id, acct_no));
			break;

		case "cifnumber":
			// Fetch and add corporate customers
			List<Object[]> corporateCustomers = charge_Back_Rep.getCorporateCustomers();
			md.addAttribute("getCorporateCustomers", corporateCustomers);
			System.out.println("Corporate Customers: " + corporateCustomers);

			// Fetch and add retail customers
			List<Object[]> retailCustomers = charge_Back_Rep.getRetailCustomers();
			md.addAttribute("getRetailCustomers", retailCustomers);
			System.out.println("Retail Customers: " + retailCustomers);

			// Fetch and add all customers (both corporate and retail)
			List<Object[]> allCustomers = charge_Back_Rep.getAll();
			md.addAttribute("getAll", allCustomers);
			System.out.println("All Customers: " + allCustomers);
			break;

		case "customername":
			md.addAttribute("getName", charge_Back_Rep.getName());
			break;
		case "Dateofbirth":
			md.addAttribute("getcustdob", charge_Back_Rep.getcustdob());
			break;
		case "placeofbirth":
			md.addAttribute("getpob", charge_Back_Rep.getpob());
			break;
		case "PassportExpiry":
			md.addAttribute("getPass", charge_Back_Rep.getPass());
			break;

		case "PassportNo":
			md.addAttribute("getPassno", charge_Back_Rep.getPassno());
			break;
		case "customname":
			md.addAttribute("getName1", charge_Back_Rep.getName1());
			break;

		case "CountryofResidency":
			md.addAttribute("getCountRes", charge_Back_Rep.getCountRes());
			break;
		case "MarkerofEmployed":
			md.addAttribute("getMrkEmp", charge_Back_Rep.getMrkEmp());
			break;
		case "EmployerName":
			md.addAttribute("getEmpname", charge_Back_Rep.getEmpname());
			break;

		case "Residencyaddress":
			md.addAttribute("getResadd", charge_Back_Rep.getResadd());
			break;
		case "Poboxpostalcode":
			md.addAttribute("getpostal", charge_Back_Rep.getpostal());
			break;
		case "Customerriskrating":
			md.addAttribute("getriskrate", charge_Back_Rep.getriskrate());
			break;
		case "Monthlysalary":
			md.addAttribute("getmonth", charge_Back_Rep.getmonth());
			break;
		case "Addmonthsalary":
			md.addAttribute("getAddmonth", charge_Back_Rep.getAddmonth());
			break;
		case "Natinality1":
			md.addAttribute("getnation", charge_Back_Rep.getnation());
			break;
		case "Natinality2":
			md.addAttribute("getnation2", charge_Back_Rep.getnation2());
			break;

		case "DualNatinality":
			md.addAttribute("getDualnation", charge_Back_Rep.getDualnation());
			break;
		case "KYCReviewdate":
			md.addAttribute("getkyc", charge_Back_Rep.getkyc());
			break;
		case "TotalAnnualIncome":
			md.addAttribute("getTotalincome", charge_Back_Rep.getTotalincome());
			break;
		case "SalaryTransferredBank":
			md.addAttribute("getkyc", charge_Back_Rep.getkyc());
			break;
		case "EmiratesID":
			md.addAttribute("getEmid", charge_Back_Rep.getEmid());
			break;
		case "RelatedPartiesFlag":
			md.addAttribute("getEmid", charge_Back_Rep.getEmid());
			break;
		case "EmiratesExpDate":
			md.addAttribute("getEmiExpDate", charge_Back_Rep.getEmiExpDate());
			break;
		case "ResidenceMarker":
			md.addAttribute("getResidmark", charge_Back_Rep.getResidmark());
			break;
		case "CustNameMismatch":
			md.addAttribute("getcustName", charge_Back_Rep.getcustName());
			break;
		case "GENDER":
			md.addAttribute("getGEN", charge_Back_Rep.getGEN());
			break;
		case "Email":
			md.addAttribute("getEmail", charge_Back_Rep.getEmail());
			break;
		case "Birthday":
			md.addAttribute("getBirth", charge_Back_Rep.getBirth());
			break;
		case "CountryTaxResidence":
			md.addAttribute("getCountrytax", charge_Back_Rep.getCountrytax());
			break;
		case "Shortname":
			md.addAttribute("getShortname", charge_Back_Rep.getShortname());
			break;
		case "LoanDetails":
			md.addAttribute("getLoan", charge_Back_Rep.getLoan());
			break;
		case "CreditRating":
			md.addAttribute("getLoan", charge_Back_Rep.getLoan());
			break;
		case "Phone":
			md.addAttribute("getphone", charge_Back_Rep.getphone());
			break;
		case "TaxCompliance":
			md.addAttribute("getLoan", charge_Back_Rep.getLoan());
			break;
		case "RealEstate":
			md.addAttribute("getLoan", charge_Back_Rep.getLoan());
			break;
		case "pep":
			md.addAttribute("getnation2", charge_Back_Rep.getnation2());
			break;
		/*
		 * case "TotalAnnualIncome": md.addAttribute("getkyc",
		 * charge_Back_Rep.getkyc()); break;
		 */
		/*
		 * case "customername": List<Object[]> names = charge_Back_Rep.getname();
		 * md.addAttribute("getname", names); names.forEach(name ->
		 * System.out.println(Arrays.toString(name))); // Log each row break;
		 */

		default:
			break;
		}

		return "DataQuality.html";
	}

	@PostMapping("/kyc/indivdual/verify")
	@ResponseBody
	public String verifyRecord1(@RequestParam String custid, HttpServletRequest req) {
		try {
			kyc_individual_service.verified(custid, req);
			return "Verification successful";
		} catch (Exception e) {
			e.printStackTrace();
			return "Verification failed";
		}
	}

	@Autowired
	private EcddUploadDocumentService documentService;

	@PostMapping("/kyc/individual/upload-document")
	public ResponseEntity<String> uploadDocuments(@RequestParam("files") MultipartFile[] files,
			@RequestParam("srl_no") String srlNo, @RequestParam("customer_id") String customerId,
			@RequestParam("customer_type") String customerType, HttpSession session) {
		if (files.length == 0 || (files.length == 1 && files[0].isEmpty())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select at least one file to upload.");
		}

		try {
			String uploadedBy = (String) session.getAttribute("USERNAME");
			if (uploadedBy == null || uploadedBy.isEmpty()) {
				uploadedBy = "SYSTEM"; // Fallback
			}
			documentService.saveDocuments(files, srlNo, customerId, customerType, uploadedBy);

			return ResponseEntity.ok("Documents uploaded successfully.");

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Could not upload files: " + e.getMessage());
		}
	}

	@GetMapping("/kyc/individual/list-documents")
	@ResponseBody // Sends data as JSON
	public List<EcddCustomerDocumentsEntity> listDocuments(@RequestParam("customerId") String customerId) {
		return documentService.getDocumentList(customerId);
	}

	@GetMapping("/kyc/individual/download-doc/{docId}")
	public ResponseEntity<byte[]> downloadDocument(@PathVariable Long docId) {
		try {
			EcddCustomerDocumentsEntity doc = documentService.getDocumentForDownload(docId);
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(doc.getMimeType()))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + doc.getDocumentName() + "\"")
					.body(doc.getDocumentContent());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@PostMapping("/kyc/corporate/upload-document")
	public ResponseEntity<String> uploadcorpDocuments(@RequestParam("files") MultipartFile[] files,
			@RequestParam("srl_no") String srlNo, @RequestParam("customer_id") String customerId,
			@RequestParam("customer_type") String customerType, HttpSession session) {
		if (files.length == 0 || (files.length == 1 && files[0].isEmpty())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select at least one file to upload.");
		}
		try {
			String uploadedBy = (String) session.getAttribute("USERNAME");
			if (uploadedBy == null || uploadedBy.isEmpty())
				uploadedBy = "SYSTEM";

			documentService.saveDocuments(files, srlNo, customerId, customerType, uploadedBy);
			return ResponseEntity.ok("Documents uploaded successfully.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Could not upload files: " + e.getMessage());
		}
	}

	@GetMapping("/kyc/corporate/list-documents")
	@ResponseBody
	public List<EcddCustomerDocumentsEntity> listcorpDocuments(@RequestParam("customerId") String customerId) {
		return documentService.getDocumentList(customerId);
	}

	@GetMapping("/kyc/corporate/download-doc/{docId}")
	public ResponseEntity<byte[]> downloadcorpDocument(@PathVariable Long docId) {
		try {
			EcddCustomerDocumentsEntity doc = documentService.getDocumentForDownload(docId);
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(doc.getMimeType()))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + doc.getDocumentName() + "\"")
					.body(doc.getDocumentContent());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	public List<AuditTablePojo> getauditListLocalvaluesbusiness(Date fromDateToUse) {
		List<MANUAL_Service_Entity> auditList = mANUAL_Service_Rep.getauditListLocalvaluesbusiness(fromDateToUse);
		List<AuditTablePojo> auditPojoList = new ArrayList<>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		for (MANUAL_Service_Entity ipsAudit : auditList) {
			boolean isUpdated = false;

			// Check if an entry with the same ID and stage3 remarks already exists
			for (AuditTablePojo existingPojo : auditPojoList) {
				String auditRefNo = existingPojo.getAudit_ref_no();
				String remarks = existingPojo.getRemarks();
				String ipsAuditno = ipsAudit.getAudit_ref_no();

				if (auditRefNo != null && ipsAuditno != null && auditRefNo.equals(ipsAuditno) && remarks != null
						&& ("Login Successfully".equals(remarks) || "Logout Successfully".equals(remarks))) {

					// Update existing entry's data
					existingPojo.setAudit_table(ipsAudit.getAudit_table());
					existingPojo.setFunc_code(ipsAudit.getFunc_code());
					existingPojo.setEntry_user(ipsAudit.getEntry_user());
					existingPojo.setEntry_time(ipsAudit.getEntry_time());
					existingPojo.setAuth_user(ipsAudit.getAuth_user());
					existingPojo.setAuth_time(ipsAudit.getAuth_time());
					existingPojo.setRemarks(ipsAudit.getRemarks());

					List<String> fieldName = new ArrayList<>();
					List<String> oldvalue = new ArrayList<>();
					List<String> newvalue = new ArrayList<>();

					// Populate lists excluding "FIELD 4"
					String[] oldValues = ipsAudit.getOld_value().split("\\|\\|");
					String[] newValues = ipsAudit.getNew_value().split("\\|\\|");
					String[] fields = ipsAudit.getField_name().split("\\|\\|");

					for (int i = 0; i < fields.length; i++) {
						if (!"FIELD 4".equals(fields[i])) {
							fieldName.add(fields[i]);

							// Format the old and new values if they are date strings
							String oldFormatted = formatDate(oldValues[i], dateFormat);
							String newFormatted = formatDate(newValues[i], dateFormat);

							oldvalue.add(oldFormatted);
							newvalue.add(newFormatted);
						}
					}

					existingPojo.setField_name(fieldName);
					existingPojo.setOld_value(oldvalue);
					existingPojo.setNew_value(newvalue);

					isUpdated = true;
					break;
				}
			}

			// Create a new entry if no existing entry was updated
			if (!isUpdated) {
				AuditTablePojo auditTablePojo = new AuditTablePojo();
				auditTablePojo.setAudit_table(ipsAudit.getAudit_table());
				auditTablePojo.setFunc_code(ipsAudit.getFunc_code());
				auditTablePojo.setEntry_user(ipsAudit.getEntry_user());
				auditTablePojo.setEntry_time(ipsAudit.getEntry_time());
				auditTablePojo.setAuth_user(ipsAudit.getAuth_user());
				auditTablePojo.setAuth_time(ipsAudit.getAuth_time());
				auditTablePojo.setRemarks(ipsAudit.getRemarks());

				List<String> fieldName = new ArrayList<>();
				List<String> oldvalue = new ArrayList<>();
				List<String> newvalue = new ArrayList<>();

				if (ipsAudit != null && ipsAudit.getModi_details() != null) {
					String[] oldValues = ipsAudit.getOld_value().split("\\|\\|");
					String[] newValues = ipsAudit.getNew_value().split("\\|\\|");
					String[] fields = ipsAudit.getField_name().split("\\|\\|");

					for (int i = 0; i < fields.length; i++) {
						if (!"FIELD 4".equals(fields[i])) {
							fieldName.add(fields[i]);

							// Format the old and new values if they are date strings
							String oldFormatted = formatDate(oldValues[i], dateFormat);
							String newFormatted = formatDate(newValues[i], dateFormat);

							oldvalue.add(oldFormatted);
							newvalue.add(newFormatted);
						}
					}
				} else {
					System.out.println("No modification details available");
				}

				auditTablePojo.setField_name(fieldName);
				auditTablePojo.setOld_value(oldvalue);
				auditTablePojo.setNew_value(newvalue);
				auditPojoList.add(auditTablePojo);
			}
		}

		return auditPojoList;
	}

	// Helper method to format date values as 'DD-MM-YYYY'
	private String formatDate(String value, SimpleDateFormat dateFormat) {
		try {
			// Assuming the value is in a valid date format that SimpleDateFormat can parse
			Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(value); // Adjust this pattern based on
																						// your date format
			return dateFormat.format(date); // Return formatted date as 'DD-MM-YYYY'
		} catch (Exception e) {
			// If parsing fails, return the original value
			return value;
		}
	}

	@RequestMapping(value = "Generateloginotp", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String Generateloginotp(@RequestParam("Userid") String Userid) {
		String msg = "success";
		System.out.println(msg);
		return msg;
	}
}
