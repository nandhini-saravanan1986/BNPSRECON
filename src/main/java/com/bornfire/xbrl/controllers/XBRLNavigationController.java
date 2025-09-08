package com.bornfire.xbrl.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
import com.bornfire.xbrl.entities.UserProfile;
import com.bornfire.xbrl.entities.UserProfileRep;
import com.bornfire.xbrl.entities.XBRLReportsMasterRep;
import com.bornfire.xbrl.entities.BNPSRECON.BRECON_Audit_Entity;
import com.bornfire.xbrl.entities.BNPSRECON.BRECON_Audit_Rep;
import com.bornfire.xbrl.entities.BNPSRECON.BRECON_Common_Table_Entity;
import com.bornfire.xbrl.entities.BNPSRECON.BRECON_Common_Table_Rep;
import com.bornfire.xbrl.entities.BNPSRECON.BRECON_DESTINATION_ENTITY;
import com.bornfire.xbrl.entities.BNPSRECON.BRECON_DESTINATION_REPO;
import com.bornfire.xbrl.entities.BNPSRECON.BRFValidationsRepo;
import com.bornfire.xbrl.entities.BNPSRECON.Brecon_core_entity;
import com.bornfire.xbrl.entities.BNPSRECON.Brecon_core_rep;
import com.bornfire.xbrl.entities.BNPSRECON.Charge_Back_Rep;
import com.bornfire.xbrl.entities.BNPSRECON.MANUAL_Audit_Rep;
import com.bornfire.xbrl.entities.BNPSRECON.MANUAL_Service_Entity;
import com.bornfire.xbrl.entities.BNPSRECON.MANUAL_Service_Rep;
import com.bornfire.xbrl.services.AccessAndRolesServices;
import com.bornfire.xbrl.services.AlertManagementServices;
import com.bornfire.xbrl.services.LoginServices;
import com.bornfire.xbrl.services.ReportServices;
import com.bornfire.xbrl.services.ReportServices.ReportTitle;

@Controller
@ConfigurationProperties("default")
public class XBRLNavigationController {

	private static final Logger logger = LoggerFactory.getLogger(XBRLNavigationController.class);
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	LoginServices loginServices;

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
	private AlertManagementRepository alertmanagementrepository;

	@Autowired
	AlertManagementServices alertservices;

	@Autowired
	com.bornfire.xbrl.entities.BNPSRECON.AUD_SERVICE_REPO AUD_SERVICE_REPO;

	@Autowired
	UserProfileRep userProfileRep;

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

		if (Dashboardpage.equals("BRC")) {
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

		if (Dashboardpage.equals("BRC")) {
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

		}
		md.addAttribute("menu", "Dashboard");
		return "XBRLDashboard";
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

		String msg = loginServices.deleteUser(userid);

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
