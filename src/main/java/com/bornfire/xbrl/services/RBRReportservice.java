package com.bornfire.xbrl.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bornfire.xbrl.config.SequenceGenerator;
import com.bornfire.xbrl.entities.Facility_Repo;
import com.bornfire.xbrl.entities.Facitlity_Entity;
import com.bornfire.xbrl.entities.RBRCustomerentityPojo;
import com.bornfire.xbrl.entities.RBRShareHolder_Entity;
import com.bornfire.xbrl.entities.RBRShareHolder_Repo;
import com.bornfire.xbrl.entities.RBR_Inverstments_Repo;
import com.bornfire.xbrl.entities.RBR_Legal_Cases_Repo;
import com.bornfire.xbrl.entities.RBRcustomerRepo;
import com.bornfire.xbrl.entities.RBRcustomer_entity;
import com.bornfire.xbrl.entities.Security_Entity;
import com.bornfire.xbrl.entities.Security_Repo;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Audit_Entity;
import com.bornfire.xbrl.entities.BRBS.MANUAL_Audit_Rep;
import com.bornfire.xbrl.entities.BRBS.Provision_Entity;
import com.bornfire.xbrl.entities.BRBS.Provision_Repo;
import com.bornfire.xbrl.entities.BRBS.RBROverall_Data_Entity;
import com.bornfire.xbrl.entities.BRBS.RBRoverall_Data_Repo;
import com.monitorjbl.xlsx.StreamingReader;

@Service
@Transactional
@ConfigurationProperties("output")
public class RBRReportservice {

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
	SequenceGenerator sequence;

	@Autowired
	MANUAL_Audit_Rep mANUAL_Audit_Rep;

	public List<RBRCustomerentityPojo> getcustdata() {

		List<RBRCustomerentityPojo> RBRcustomer_entitylist = new ArrayList<RBRCustomerentityPojo>();

		List<Object[]> RBRcustomer_entity = rBRcustomerRepo.getList();

		for (int i = 0; i < RBRcustomer_entity.size(); i++) {

			RBRCustomerentityPojo RBRcustomer = new RBRCustomerentityPojo();

			String Operation = (RBRcustomer_entity.get(i)[2] != null) ? RBRcustomer_entity.get(i)[2].toString() : "";
			RBRcustomer.setOperation(Operation);

			String Bankcode = (RBRcustomer_entity.get(i)[3] != null) ? RBRcustomer_entity.get(i)[3].toString() : "";
			RBRcustomer.setBank_code(Bankcode);

			String Branch = (RBRcustomer_entity.get(i)[4] != null) ? RBRcustomer_entity.get(i)[4].toString() : "";
			RBRcustomer.setBranch(Branch);

			String Cin = (RBRcustomer_entity.get(i)[0] != null) ? RBRcustomer_entity.get(i)[0].toString() : "";
			RBRcustomer.setCin(Cin);

			String csno = (RBRcustomer_entity.get(i)[5] != null) ? RBRcustomer_entity.get(i)[5].toString() : "";
			RBRcustomer.setCsno(csno);

			String Auth_flg = (RBRcustomer_entity.get(i)[6] != null) ? RBRcustomer_entity.get(i)[6].toString() : "";
			RBRcustomer.setAuth_flg(Auth_flg);
			String Cif_no = (RBRcustomer_entity.get(i)[7] != null) ? RBRcustomer_entity.get(i)[7].toString() : "";
			RBRcustomer.setCif_no(Cif_no);

			RBRcustomer.setPartner_data(Optional.ofNullable(RBRcustomer_entity.get(i)[8].toString()).orElse(""));
			RBRcustomer.setSecurity_date(Optional.ofNullable(RBRcustomer_entity.get(i)[10].toString()).orElse(""));
			RBRcustomer.setFacility_data(Optional.ofNullable(RBRcustomer_entity.get(i)[9].toString()).orElse(""));
			RBRcustomer.setProvision_data(Optional.ofNullable(RBRcustomer_entity.get(i)[12].toString()).orElse(""));
			RBRcustomer.setOverall_data(Optional.ofNullable(RBRcustomer_entity.get(i)[11].toString()).orElse(""));

			RBRcustomer_entitylist.add(RBRcustomer);

		}

		return RBRcustomer_entitylist;

	}

	public List<RBRCustomerentityPojo> getBranchcustdata(String Branchcode) {

		List<RBRCustomerentityPojo> RBRcustomer_entitylist = new ArrayList<RBRCustomerentityPojo>();

		List<Object[]> RBRcustomer_entity = rBRcustomerRepo.getCUSTList(Branchcode);

		for (int i = 0; i < RBRcustomer_entity.size(); i++) {

			RBRCustomerentityPojo RBRcustomer = new RBRCustomerentityPojo();

			String Operation = (RBRcustomer_entity.get(i)[2] != null) ? RBRcustomer_entity.get(i)[2].toString() : "";
			RBRcustomer.setOperation(Operation);

			String Bankcode = (RBRcustomer_entity.get(i)[3] != null) ? RBRcustomer_entity.get(i)[3].toString() : "";
			RBRcustomer.setBank_code(Bankcode);

			String Branch = (RBRcustomer_entity.get(i)[4] != null) ? RBRcustomer_entity.get(i)[4].toString() : "";
			RBRcustomer.setBranch(Branch);

			String Cin = (RBRcustomer_entity.get(i)[0] != null) ? RBRcustomer_entity.get(i)[0].toString() : "";
			RBRcustomer.setCin(Cin);

			String csno = (RBRcustomer_entity.get(i)[5] != null) ? RBRcustomer_entity.get(i)[5].toString() : "";
			RBRcustomer.setCsno(csno);

			String Auth_flg = (RBRcustomer_entity.get(i)[6] != null) ? RBRcustomer_entity.get(i)[6].toString() : "";
			RBRcustomer.setAuth_flg(Auth_flg);
			String Cif_no = (RBRcustomer_entity.get(i)[7] != null) ? RBRcustomer_entity.get(i)[7].toString() : "";
			RBRcustomer.setCif_no(Cif_no);

			RBRcustomer.setPartner_data(Optional.ofNullable(RBRcustomer_entity.get(i)[8].toString()).orElse(""));
			RBRcustomer.setSecurity_date(Optional.ofNullable(RBRcustomer_entity.get(i)[10].toString()).orElse(""));
			RBRcustomer.setFacility_data(Optional.ofNullable(RBRcustomer_entity.get(i)[9].toString()).orElse(""));
			RBRcustomer.setProvision_data(Optional.ofNullable(RBRcustomer_entity.get(i)[12].toString()).orElse(""));
			RBRcustomer.setOverall_data(Optional.ofNullable(RBRcustomer_entity.get(i)[11].toString()).orElse(""));

			RBRcustomer_entitylist.add(RBRcustomer);

		}

		return RBRcustomer_entitylist;

	}

	public String RBRValidation(String cin) {

		String msg = "";

		RBRcustomer_entity up2 = rBRcustomerRepo.getcin(cin);
		if (!up2.getCin().isEmpty()) {
			if (up2.getType_code() != null && !up2.getType_code().equals("null")) {
				if (up2.getType_code().equals("CTC2")) {
					List<RBRShareHolder_Entity> RBRShareHolder_Entity = rbrShareHolder_Repo.Verify(cin);
					if (RBRShareHolder_Entity.size() > 0) {
						if (up2.getSub_bor_type().equals("SCC1") || up2.getSub_bor_type().equals("SCC2")
								|| up2.getSub_bor_type().equals("SCC3") || up2.getSub_bor_type().equals("SCC4")) {
							msg = customervalidation(up2, cin, "VAL1");
						} else {
							msg = "The Sub borrower code is invalid for this CIN : " + cin + " Present type is CTC2";
						}
					} else {
						msg = "CIN cannot be verified .CTC2 code is not allowed in the PartnerShareholder sheet :"
								+ cin;
					}

				} else if ((up2.getType_code().equals("CTC5")) || (up2.getType_code().equals("CTC3"))
						|| (up2.getType_code().equals("CTC1"))) {
					if (up2.getSub_bor_type().equals("SCC6") || up2.getSub_bor_type().equals("SCC7")
							|| up2.getSub_bor_type().equals("SCC10") || up2.getSub_bor_type().equals("SCC12")
							|| up2.getSub_bor_type().equals("SCC8") || up2.getSub_bor_type().equals("SCC9")) {
						msg = customervalidation(up2, cin, "VAL2");
					} else {
						msg = "The Sub borrower code is invalid for this CIN : " + cin + " Present type is "
								+ up2.getType_code();
					}
				} else if (up2.getType_code().equals("CTC4")) {
					if (up2.getSub_bor_type().equals("SCC11") || up2.getSub_bor_type().equals("SCC13")
							|| up2.getSub_bor_type().equals("SCC14")) {
						msg = customervalidation(up2, cin, "VAL3");
					} else {
						msg = "The Sub borrower code is invalid for this CIN : " + cin + " Present type is "
								+ up2.getType_code();
					}
				} else if (up2.getType_code().equals("CTC6")) {
					if (up2.getSub_bor_type().equals("SCC11") || up2.getSub_bor_type().equals("SCC12")) {
						msg = customervalidation(up2, cin, "VAL4");
					} else {
						msg = "The Sub borrower code is invalid for this CIN : " + cin + " Present type is "
								+ up2.getType_code();
					}
				}
			} else {
				msg = "The type code is missing for this CIN : " + cin;
			}
		} else {
			msg = "Cin not available in CCSYS2.0 data";
		}

		System.out.println("Verification message :" + msg);
		return msg;
	}

	public String RBREditValidation(RBRcustomer_entity details) {

		String msg = "";

		RBRcustomer_entity up2 = details;

		if (up2.getType_code() != null && !up2.getType_code().equals("null")) {
			if (up2.getType_code().equals("CTC2")) {
				List<RBRShareHolder_Entity> RBRShareHolder_Entity = rbrShareHolder_Repo.Verify(up2.getCin());
				if (RBRShareHolder_Entity.size() > 0) {
					if (up2.getSub_bor_type() != null && !up2.getSub_bor_type().equals("null")) {
						if (up2.getSub_bor_type().equals("SCC1") || up2.getSub_bor_type().equals("SCC2")
								|| up2.getSub_bor_type().equals("SCC3") || up2.getSub_bor_type().equals("SCC4")) {
							msg = customervalidation(up2, up2.getCin(), "VAL1");
						} else {
							msg = "The Sub borrower code is invalid for this CIN : " + up2.getCin()
									+ " Present type is CTC2";
						}
					} else {
						msg = "The Sub borrower code is not updated for this CIN : " + up2.getCin();
					}
				} else {
					msg = "CIN cannot be verified .CTC2 code is not allowed in the PartnerShareholder sheet :"
							+ up2.getCin();
				}

			} else if ((up2.getType_code().equals("CTC5")) || (up2.getType_code().equals("CTC3"))
					|| (up2.getType_code().equals("CTC1"))) {
				if (up2.getSub_bor_type() != null && !up2.getSub_bor_type().equals("null")) {
					if (up2.getSub_bor_type().equals("SCC6") || up2.getSub_bor_type().equals("SCC7")
							|| up2.getSub_bor_type().equals("SCC10") || up2.getSub_bor_type().equals("SCC12")
							|| up2.getSub_bor_type().equals("SCC8") || up2.getSub_bor_type().equals("SCC9")) {
						msg = customervalidation(up2, up2.getCin(), "VAL2");
					} else {
						msg = "The Sub borrower code is invalid for this CIN : " + up2.getCin() + " Present type is "
								+ up2.getType_code();
					}
				} else {
					msg = "The Sub borrower code is not updated for this CIN : " + up2.getCin();
				}
			} else if (up2.getType_code().equals("CTC4")) {
				if (up2.getSub_bor_type() != null && !up2.getSub_bor_type().equals("null")) {
					if (up2.getSub_bor_type().equals("SCC11") || up2.getSub_bor_type().equals("SCC13")
							|| up2.getSub_bor_type().equals("SCC14")) {
						msg = customervalidation(up2, up2.getCin(), "VAL3");
					} else {
						msg = "The Sub borrower code is invalid for this CIN : " + up2.getCin() + " Present type is "
								+ up2.getType_code();
					}
				} else {
					msg = "The Sub borrower code is not updated for this CIN : " + up2.getCin();
				}
			} else if (up2.getType_code().equals("CTC6")) {
				if (up2.getSub_bor_type() != null && !up2.getSub_bor_type().equals("null")) {
					if (up2.getSub_bor_type().equals("SCC11") || up2.getSub_bor_type().equals("SCC12")) {
						msg = customervalidation(up2, up2.getCin(), "VAL4");
					} else {
						msg = "The Sub borrower code is invalid for this CIN : " + up2.getCin() + " Present type is "
								+ up2.getType_code();
					}
				} else {
					msg = "The Sub borrower code is not updated for this CIN : " + up2.getCin();
				}
			}
		} else {
			msg = "The type code is missing for this CIN : " + up2.getCin();
		}

		System.out.println("Verification message :" + msg);
		return msg;
	}

	@SuppressWarnings("unlikely-arg-type")
	public String customervalidation(RBRcustomer_entity RBRcustomer_entity, String cin, String Validationtype) {
		String msg = "";

		if (Validationtype.equals("VAL1")) {
			if (RBRcustomer_entity.getOperation() != null && !RBRcustomer_entity.getOperation().equals("null")) {
				if (RBRcustomer_entity.getBank_code() != null && !RBRcustomer_entity.getBank_code().equals("null")) {
					if ((!RBRcustomer_entity.getCin().equals("null")) && (!RBRcustomer_entity.getCsno().equals("null"))
							&& (!RBRcustomer_entity.getCif_no().equals("null"))) {
						if ((RBRcustomer_entity.getCename() != null
								&& !RBRcustomer_entity.getCename().equals("null"))) {
							if ((RBRcustomer_entity.getCus_res() != null
									&& !RBRcustomer_entity.getCus_res().equals("null"))) {
								if (borrowerandleivali(RBRcustomer_entity, cin, "Borrower")) {
									if (borrowerandleivali(RBRcustomer_entity, cin, "LEI")) {
										if (RBRcustomer_entity.getCus_dom() != null
												&& !RBRcustomer_entity.getCus_dom().equals("null")) {
											if (RBRcustomer_entity.getEco_sec() != null
													&& !RBRcustomer_entity.getEco_sec().equals("null")) {
												if (RBRcustomer_entity.getEst_date() != null
														&& !RBRcustomer_entity.getEst_date().equals("null")) {
													if (RBRcustomer_entity.getEmi_est() != null
															&& !RBRcustomer_entity.getEmi_est().equals("null")) {
														if (RBRcustomer_entity.getTelephone() != null
																&& !RBRcustomer_entity.getTelephone().equals("null")) {
															if ((String.valueOf(RBRcustomer_entity.getGender())
																	.equals("null"))
																	&& (String.valueOf(RBRcustomer_entity.getEmployer())
																			.equals("null"))
																	&& (String.valueOf(
																			RBRcustomer_entity.getExp_passport())
																			.equals("null"))
																	&& (String.valueOf(RBRcustomer_entity.getPassport())
																			.equals("null"))
																	&& (String
																			.valueOf(RBRcustomer_entity.getExp_emi_id())
																			.equals("null"))
																	&& (String.valueOf(RBRcustomer_entity.getEid())
																			.equals("null"))
																	&& (String.valueOf(RBRcustomer_entity.getDob())
																			.equals("null"))) {
																msg = "Verification Ok";
															} else {
																msg = "CTC2 NA field having values for this CIN : "
																		+ cin;
															}
														} else {
															msg = "Telephone number missing for this CIN : " + cin;
														}

													} else {
														msg = "The Emirate where the Juridical person"
																+ " (entity) is established missing for this CIN : "
																+ cin;
													}

												} else {
													msg = "The Date of establishment of the Juridical person (entities)"
															+ " is missing for this CIN : " + cin;
												}

											} else {
												msg = "The Economic Sector is missing for this CIN : " + cin;
											}

										} else {
											msg = "The Customer domicile is missing for this CIN : " + cin;
										}
									} else {
										msg = "Invalid data in LEI / LEI NUMBER: " + cin;
									}
								} else {
									msg = "Invalid data in Borrower Subsidary/Group Up/Group Ip: " + cin;
								}

							} else {
								msg = "The Customer Residency is missing for this CIN : " + cin;
							}

						} else {
							msg = "The Customer name is missing for this CIN : " + cin;
						}
					} else {
						msg = "The Cin/Csno/Cifno is missing for this CIN : " + cin;
					}

				} else {
					msg = "The Bank code is missing for this CIN : " + cin;
				}

			} else {
				msg = "The Operation is missing for this CIN : " + cin;
			}

		} else if (Validationtype.equals("VAL2")) {
			if (RBRcustomer_entity.getOperation() != null && !RBRcustomer_entity.getOperation().equals("null")) {
				if (RBRcustomer_entity.getBank_code() != null && !RBRcustomer_entity.getBank_code().equals("null")) {
					if ((!RBRcustomer_entity.getCin().equals("null")) && (!RBRcustomer_entity.getCsno().equals("null"))
							&& (!RBRcustomer_entity.getCif_no().equals("null"))) {
						if ((RBRcustomer_entity.getCename() != null
								&& !RBRcustomer_entity.getCename().equals("null"))) {
							if ((RBRcustomer_entity.getCus_res() != null
									&& !RBRcustomer_entity.getCus_res().equals("null"))) {
								/*
								 * if ((RBRcustomer_entity.getBorrower_subsidiary() != null &&
								 * !RBRcustomer_entity.getBorrower_subsidiary().equals("null")) &&
								 * (RBRcustomer_entity.getGroup_up() != null &&
								 * !RBRcustomer_entity.getGroup_up().equals("null")) &&
								 * (RBRcustomer_entity.getGroup_ip() != null &&
								 * !RBRcustomer_entity.getGroup_ip().equals("null"))) { if
								 * (RBRcustomer_entity.getBorrower_subsidiary().equals("Y")) { if
								 * ((RBRcustomer_entity.getLei() != null &&
								 * !RBRcustomer_entity.getLei().equals("null")) &&
								 * (RBRcustomer_entity.getLei_number() != null &&
								 * !RBRcustomer_entity.getLei_number().equals("null"))) {
								 */
								if (RBRcustomer_entity.getCus_dom() != null
										&& !RBRcustomer_entity.getCus_dom().equals("null")) {
									if (RBRcustomer_entity.getEco_sec() != null
											&& !RBRcustomer_entity.getEco_sec().equals("null")) {
										if (RBRcustomer_entity.getEst_date() != null
												&& !RBRcustomer_entity.getEst_date().equals("null")) {
											if (RBRcustomer_entity.getEmi_est() != null
													&& !RBRcustomer_entity.getEmi_est().equals("null")) {
												if (RBRcustomer_entity.getTelephone() != null
														&& !RBRcustomer_entity.getTelephone().equals("null")) {
													if ((RBRcustomer_entity.getLic_id() != null
															&& !RBRcustomer_entity.getLic_id().equals("null"))
															&& (RBRcustomer_entity.getExp_lic() != null
																	&& !RBRcustomer_entity.getExp_lic().equals("null"))
															&& (RBRcustomer_entity.getEmi_lic() != null
																	&& !RBRcustomer_entity.getEmi_lic().equals("null"))
															&& (RBRcustomer_entity.getLic_id() != null
																	&& !RBRcustomer_entity.getLic_id()
																			.equals("null"))) {
														if (RBRcustomer_entity.getCapital_annual_income() != null
																&& !RBRcustomer_entity.getCapital_annual_income()
																		.equals("null")) {
															if (RBRcustomer_entity
																	.getTurnover_operating_income() != null
																	&& !RBRcustomer_entity
																			.getTurnover_operating_income()
																			.equals("null")) {
																if (RBRcustomer_entity.getAuditor() != null
																		&& !RBRcustomer_entity.getAuditor()
																				.equals("null")) {
																	if (RBRcustomer_entity
																			.getDate_of_audited_fs() != null
																			&& !RBRcustomer_entity
																					.getDate_of_audited_fs()
																					.equals("null")) {
																		if (RBRcustomer_entity
																				.getNo_of_employees() != null
																				&& !RBRcustomer_entity
																						.getNo_of_employees()
																						.equals("null")) {

																			if ((!RBRcustomer_entity.getType_code()
																					.equals("CTC3"))
																					&& (!RBRcustomer_entity
																							.getSub_bor_type()
																							.equals("SCC10"))) {

																				if ((String
																						.valueOf(RBRcustomer_entity
																								.getGender())
																						.equals("null"))
																						&& (String.valueOf(
																								RBRcustomer_entity
																										.getEmployer())
																								.equals("null"))
																						&& (String.valueOf(
																								RBRcustomer_entity
																										.getExp_passport())
																								.equals("null"))
																						&& (String.valueOf(
																								RBRcustomer_entity
																										.getPassport())
																								.equals("null"))
																						&& (String.valueOf(
																								RBRcustomer_entity
																										.getExp_emi_id())
																								.equals("null"))
																						&& (String.valueOf(
																								RBRcustomer_entity
																										.getEid())
																								.equals("null"))
																						&& (String.valueOf(
																								RBRcustomer_entity
																										.getDob())
																								.equals("null"))) {
																					msg = "Verification Ok";
																				} else {
																					msg = "CTC2 NA field having values for this CIN : "
																							+ cin;
																				}
																			} else {
																				msg = "Verification Ok";
																			}

																			msg = "Verification Ok";
																		} else {
																			msg = "No_of_employees is missing for this CIN : "
																					+ cin;
																		}

																	} else {
																		msg = "Date_of_audit is missing for this CIN : "
																				+ cin;
																	}

																} else {
																	msg = "Auditor is missing for this CIN : " + cin;
																}

															} else {
																msg = "Turnover is missing for this CIN : " + cin;
															}

														} else {
															msg = "Captial annual income is missing for this CIN : "
																	+ cin;
														}

													} else {
														msg = "Trade license details is missing for this CIN : " + cin;
													}

												} else {
													msg = "Telephone number missing for this CIN : " + cin;
												}

											} else {
												msg = "The Emirate where the Juridical person"
														+ " (entity) is established missing for this CIN : " + cin;
											}

										} else {
											msg = "The Date of establishment of the Juridical person (entities)"
													+ " is missing for this CIN : " + cin;
										}

									} else {
										msg = "The Economic Sector is missing for this CIN : " + cin;
									}

								} else {
									msg = "The Customer domicile is missing for this CIN : " + cin;
								}

								/*
								 * } else { msg = "Lei/Lei Number is missing"; } } else { msg =
								 * "The Borrower Subsidary invalid for this CIN : " + cin +
								 * " for type code CTC5/CTC3"; }
								 * 
								 * } else { msg =
								 * "The Borrower Subsidary/Group Up/Group Ip is missing for this CIN : " + cin;
								 * }
								 */
							} else {
								msg = "The Customer Residency is missing for this CIN : " + cin;
							}

						} else {
							msg = "The Customer name is missing for this CIN : " + cin;
						}
					} else {
						msg = "The Cin/Csno/Cifno is missing for this CIN : " + cin;
					}

				} else {
					msg = "The Bank code is missing for this CIN : " + cin;
				}

			} else {
				msg = "The Operation is missing for this CIN : " + cin;
			}
		} else if (Validationtype.equals("VAL3")) {
			if (RBRcustomer_entity.getOperation() != null && !RBRcustomer_entity.getOperation().equals("null")) {
				if (RBRcustomer_entity.getBank_code() != null && !RBRcustomer_entity.getBank_code().equals("null")) {
					if ((!RBRcustomer_entity.getCin().equals("null")) && (!RBRcustomer_entity.getCsno().equals("null"))
							&& (!RBRcustomer_entity.getCif_no().equals("null"))) {
						if ((RBRcustomer_entity.getCename() != null
								&& !RBRcustomer_entity.getCename().equals("null"))) {
							if ((RBRcustomer_entity.getCus_res() != null
									&& !RBRcustomer_entity.getCus_res().equals("null"))) {
								if (String.valueOf(RBRcustomer_entity.getBorrower_subsidiary()).equals("null")
										&& String.valueOf(RBRcustomer_entity.getGroup_ip()).equals("null")
										&& String.valueOf(RBRcustomer_entity.getGroup_up()).equals("null")
										&& String.valueOf(RBRcustomer_entity.getLei()).equals("null")
										&& String.valueOf(RBRcustomer_entity.getLei_number()).equals("null")) {
									if (RBRcustomer_entity.getCus_dom() != null
											&& !RBRcustomer_entity.getCus_dom().equals("null")) {
										if (RBRcustomer_entity.getEco_sec() != null
												&& !RBRcustomer_entity.getEco_sec().equals("null")) {
											if (RBRcustomer_entity.getTelephone() != null
													&& !RBRcustomer_entity.getTelephone().equals("null")) {
												if (RBRcustomer_entity.getDob() != null
														&& !RBRcustomer_entity.getDob().equals("null")) {
													if (borrowerandleivali(RBRcustomer_entity, cin, "EIDANDPASS")) {
														if (RBRcustomer_entity.getCapital_annual_income() != null
																&& !RBRcustomer_entity.getCapital_annual_income()
																		.equals("null")) {
															if (RBRcustomer_entity.getGender() != null
																	&& !RBRcustomer_entity.getGender().equals("null")) {

																if (RBRcustomer_entity.getSub_bor_type()
																		.equals("SCC11")) {
																	if (String.valueOf(RBRcustomer_entity.getEst_date())
																			.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getEmi_est())
																					.equals("null")
																			&& String.valueOf(
																					RBRcustomer_entity.getLic_id())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getExp_lic())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getEmi_lic())
																					.equals("null")
																			&& String.valueOf(RBRcustomer_entity
																					.getTurnover_operating_income())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getEmployer())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getNo_of_employees())
																					.equals("null")) {
																		msg = "Verification Ok";
																	} else {
																		msg = "CTC4-SCC11 'NOT APPLICABLE'field have the value for this CIN : "
																				+ cin;
																	}
																} else if (RBRcustomer_entity.getSub_bor_type()
																		.equals("SCC13")) {
																	if (String.valueOf(RBRcustomer_entity.getEst_date())
																			.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getEmi_est())
																					.equals("null")
																			&& String.valueOf(
																					RBRcustomer_entity.getLic_id())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getExp_lic())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getEmi_lic())
																					.equals("null")
																			&& String.valueOf(RBRcustomer_entity
																					.getTurnover_operating_income())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getEmployer())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getNo_of_employees())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getAuditor())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getDate_of_audited_fs())
																					.equals("null")) {
																		msg = "Verification Ok";
																	} else {
																		msg = "CTC4-SCC13 'NOT APPLICABLE'field have the value for this CIN : "
																				+ cin;
																	}
																} else if (RBRcustomer_entity.getSub_bor_type()
																		.equals("SCC14")) {
																	if (String.valueOf(RBRcustomer_entity.getEst_date())
																			.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getEmi_est())
																					.equals("null")
																			&& String.valueOf(
																					RBRcustomer_entity.getLic_id())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getExp_lic())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getEmi_lic())
																					.equals("null")
																			&& String.valueOf(RBRcustomer_entity
																					.getTurnover_operating_income())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getEmployer())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getNo_of_employees())
																					.equals("null")
																			&& String
																					.valueOf(RBRcustomer_entity
																							.getDate_of_audited_fs())
																					.equals("null")) {
																		msg = "Verification Ok";
																	} else {
																		msg = "CTC4-SCC13 'NOT APPLICABLE'field have the value for this CIN : "
																				+ cin;
																	}
																}

															} else {
																msg = "Gender is missing for this CIN : " + cin;
															}
														} else {
															msg = "Captial annual income is missing for this CIN : "
																	+ cin;
														}
													} else {
														msg = "EID/PASSPORT Related filed is invalid for this CIN : "
																+ cin;
													}

												} else {
													msg = "DOB is missing for this CIN : " + cin;
												}
											} else {
												msg = "Telephone is missing for this CIN : " + cin;
											}
										} else {
											msg = "The Economic Sector is missing for this CIN : " + cin;
										}

									} else {
										msg = "The Customer domicile is missing for this CIN : " + cin;
									}

								} else {
									msg = "Borrower subsidiary / LEI related fileds"
											+ " has the value 'Not Applicable' for this CIN: " + cin + " Type code.";

								}

							} else {
								msg = "The Customer Residency is missing for this CIN : " + cin;
							}

						} else {
							msg = "The Customer name is missing for this CIN : " + cin;
						}
					} else {
						msg = "The Cin/Csno/Cifno is missing for this CIN : " + cin;
					}

				} else {
					msg = "The Bank code is missing for this CIN : " + cin;
				}

			} else {
				msg = "The Operation is missing for this CIN : " + cin;
			}
		} else if (Validationtype.equals("CTC4")) {
			if (RBRcustomer_entity.getOperation() != null && !RBRcustomer_entity.getOperation().equals("null")) {
				if (RBRcustomer_entity.getBank_code() != null && !RBRcustomer_entity.getBank_code().equals("null")) {
					if ((!RBRcustomer_entity.getCin().equals("null")) && (!RBRcustomer_entity.getCsno().equals("null"))
							&& (!RBRcustomer_entity.getCif_no().equals("null"))) {
						if ((RBRcustomer_entity.getOperation() != null
								&& !RBRcustomer_entity.getCename().equals("null"))) {
							if ((RBRcustomer_entity.getOperation() != null
									&& !RBRcustomer_entity.getCus_res().equals("null"))) {
								if (String.valueOf(RBRcustomer_entity.getBorrower_subsidiary()).equals("null")
										&& String.valueOf(RBRcustomer_entity.getGroup_ip()).equals("null")
										&& String.valueOf(RBRcustomer_entity.getGroup_up()).equals("null")
										&& String.valueOf(RBRcustomer_entity.getLei()).equals("null")
										&& String.valueOf(RBRcustomer_entity.getLei_number()).equals("null")) {
									if (RBRcustomer_entity.getCus_dom() != null
											&& !RBRcustomer_entity.getCus_dom().equals("null")) {
										if (RBRcustomer_entity.getEco_sec() != null
												&& !RBRcustomer_entity.getEco_sec().equals("null")) {
											if (RBRcustomer_entity.getTelephone() != null
													&& !RBRcustomer_entity.getTelephone().equals("null")) {

												if (RBRcustomer_entity.getSub_bor_type().equals("SCC11")) {
													if (String.valueOf(RBRcustomer_entity.getBorrower_subsidiary())
															.equals("null")
															&& String.valueOf(RBRcustomer_entity.getGroup_ip())
																	.equals("null")
															&& String.valueOf(RBRcustomer_entity.getGroup_up())
																	.equals("null")
															&& String.valueOf(RBRcustomer_entity.getLei())
																	.equals("null")
															&& String.valueOf(RBRcustomer_entity.getLei_number())
																	.equals("null")) {
														if (String.valueOf(RBRcustomer_entity.getEst_date())
																.equals("null")
																&& String.valueOf(RBRcustomer_entity.getEmi_est())
																		.equals("null")
																&& String.valueOf(RBRcustomer_entity.getLic_id())
																		.equals("null")
																&& String.valueOf(RBRcustomer_entity.getExp_lic())
																		.equals("null")
																&& String.valueOf(RBRcustomer_entity.getEmi_lic())
																		.equals("null")
																&& String
																		.valueOf(RBRcustomer_entity
																				.getTurnover_operating_income())
																		.equals("null")
																&& String.valueOf(RBRcustomer_entity.getEmployer())
																		.equals("null")
																&& String
																		.valueOf(
																				RBRcustomer_entity.getNo_of_employees())
																		.equals("null")) {
															if (RBRcustomer_entity.getGender() != null
																	&& !RBRcustomer_entity.getGender().equals("null")) {
																msg = "Verification Ok";
															} else {
																msg = "Gender Value is not updated";
															}
														} else {
															msg = "CTC6-SCC11 'NOT APPLICABLE'field have the value for this CIN : "
																	+ cin;
														}

													} else {
														msg = "Borrower subsidiary / LEI related fileds"
																+ " has the value 'Not Applicable' for this CIN: " + cin
																+ " Type code.";

													}
												} else if (RBRcustomer_entity.getSub_bor_type().equals("SCC12")) {
													if (borrowerandleivali(RBRcustomer_entity, cin, "Borrower")) {
														if (borrowerandleivali(RBRcustomer_entity, cin, "LEI")) {
															if ((RBRcustomer_entity.getLic_id() != null
																	&& !RBRcustomer_entity.getLic_id().equals("null"))
																	&& (RBRcustomer_entity.getExp_lic() != null
																			&& !RBRcustomer_entity.getExp_lic()
																					.equals("null"))
																	&& (RBRcustomer_entity.getEmi_lic() != null
																			&& !RBRcustomer_entity.getEmi_lic()
																					.equals("null"))
																	&& (RBRcustomer_entity.getLic_id() != null
																			&& !RBRcustomer_entity.getLic_id()
																					.equals("null"))) {
																if (RBRcustomer_entity
																		.getCapital_annual_income() != null
																		&& !RBRcustomer_entity
																				.getCapital_annual_income()
																				.equals("null")) {
																	if (RBRcustomer_entity
																			.getTurnover_operating_income() != null
																			&& !RBRcustomer_entity
																					.getTurnover_operating_income()
																					.equals("null")) {
																		if (RBRcustomer_entity.getAuditor() != null
																				&& !RBRcustomer_entity.getAuditor()
																						.equals("null")) {
																			if (RBRcustomer_entity
																					.getNo_of_employees() != null
																					&& !RBRcustomer_entity
																							.getNo_of_employees()
																							.equals("null")) {
																				msg = "Verification Ok";
																			} else {
																				msg = "No_of_employees is missing for this CIN : "
																						+ cin;
																			}
																		} else {
																			msg = "Auditor is missing for this CIN : "
																					+ cin;
																		}

																	} else {
																		msg = "Turnover is missing for this CIN : "
																				+ cin;
																	}

																} else {
																	msg = "Captial annual income is missing for this CIN : "
																			+ cin;
																}
															} else {
																msg = "Trade License details is missing for this cim :"
																		+ cin;
															}
														} else {
															msg = "Borrower subsidiary / LEI related fileds"
																	+ " is missing for this CIN: " + cin
																	+ " Type code.";

														}
													} else {
														msg = "Borrower subsidiary / LEI related fileds"
																+ " is missing for this CIN: " + cin + " Type code.";

													}
												}

											} else {
												msg = "Telephone is missing for this CIN : " + cin;
											}
										} else {
											msg = "The Economic Sector is missing for this CIN : " + cin;
										}

									} else {
										msg = "The Customer domicile is missing for this CIN : " + cin;
									}

								} else {
									msg = "Borrower subsidiary / LEI related fileds"
											+ " has the value 'Not Applicable' for this CIN: " + cin + " Type code.";

								}

							} else {
								msg = "The Customer Residency is missing for this CIN : " + cin;
							}

						} else {
							msg = "The Customer name is missing for this CIN : " + cin;
						}
					} else {
						msg = "The Cin/Csno/Cifno is missing for this CIN : " + cin;
					}

				} else {
					msg = "The Bank code is missing for this CIN : " + cin;
				}

			} else {
				msg = "The Operation is missing for this CIN : " + cin;
			}
		}

		return msg;
	}

	public boolean borrowerandleivali(RBRcustomer_entity RBRcustomer_entity, String cin, String type) {

		if (type.equals("Borrower")) {
			if (RBRcustomer_entity.getBorrower_subsidiary() != null
					&& !RBRcustomer_entity.getBorrower_subsidiary().equals("null")
					&& !RBRcustomer_entity.getBorrower_subsidiary().equals("")) {
				if (String.valueOf(RBRcustomer_entity.getBorrower_subsidiary()).equals("Y")) {
					if ((RBRcustomer_entity.getGroup_up() != null && !RBRcustomer_entity.getGroup_up().equals("null"))
							&& (RBRcustomer_entity.getGroup_ip() != null
									&& !RBRcustomer_entity.getGroup_ip().equals("null"))) {
						return true;
					} else {
						return false;
					}

				} else if (RBRcustomer_entity.getBorrower_subsidiary().equals("N")) {
					if ((String.valueOf(RBRcustomer_entity.getGroup_up()).equals("null"))
							&& (String.valueOf(RBRcustomer_entity.getGroup_ip()).equals("null"))) {
						return true;
					} else {
						return false;
					}
				}

			} else {
				if ((String.valueOf(RBRcustomer_entity.getGroup_up()).equals("null"))
						&& (String.valueOf(RBRcustomer_entity.getGroup_ip()).equals("null"))) {
					return true;
				} else {
					return false;
				}
			}
		} else if (type.equals("LEI")) {
			if (RBRcustomer_entity.getLei() != null && !RBRcustomer_entity.getLei().equals("null")
					&& !RBRcustomer_entity.getLei().equals("")) {
				if (RBRcustomer_entity.getLei().equals("Y")) {
					if (RBRcustomer_entity.getLei_number() != null
							&& !RBRcustomer_entity.getLei_number().equals("null")) {
						return true;
					} else {
						return false;
					}
				} else if (RBRcustomer_entity.getLei().equals("N")) {
					if (String.valueOf(RBRcustomer_entity.getLei_number()).equals("null")) {
						return true;
					} else {
						return false;
					}
				}
			} else {
				if (String.valueOf(RBRcustomer_entity.getLei_number()).equals("null")) {
					return true;
				} else {
					return false;
				}
			}
		} else if (type.equals("EIDANDPASS")) {
			if (RBRcustomer_entity.getCus_res().equals("RE")) {
				if ((String.valueOf(RBRcustomer_entity.getEid()).equals("null"))
						&& (String.valueOf(RBRcustomer_entity.getExp_emi_id()).equals("null"))) {
					return false;
				} else {
					return true;
				}
			} else if (RBRcustomer_entity.getCus_res().equals("NR")) {
				if ((String.valueOf(RBRcustomer_entity.getPassport()).equals("null"))
						&& (String.valueOf(RBRcustomer_entity.getExp_passport()).equals("null"))) {
					return false;
				} else {
					return true;
				}
			}
		}
		return false;

	}

	public String RBRPartnervalidation(RBRShareHolder_Entity details) {
		String Msg = "";
		RBRcustomer_entity up2 = rBRcustomerRepo.getcin(details.getCin());
		if (up2.getType_code() != null && !up2.getType_code().equals("null")) {
			if (!up2.getType_code().equals("CTC2")) {
				if (up2.getSub_bor_type().equals("SCC6") || up2.getSub_bor_type().equals("SCC7")
						|| up2.getSub_bor_type().equals("SCC8") || up2.getSub_bor_type().equals("SCC9")
						|| up2.getSub_bor_type().equals("SCC10") || up2.getSub_bor_type().equals("SCC12")) {
					if (details.getBankcode() != null && !details.getBankcode().equals("null")) {
						if (details.getCin() != null && !details.getCin().equals("null")) {
							if (details.getCsno() != null && !details.getCsno().equals("null")) {
								if (details.getPart_shar_type() != null
										&& !details.getPart_shar_type().equals("null")) {
									if (details.getPart_shar_rec_id() != null
											&& !details.getPart_shar_rec_id().equals("null")) {
										if (details.getP_s_ename() != null && !details.getP_s_ename().equals("null")) {
											if (details.getP_s_cin() != null && !details.getP_s_cin().equals("null")) {
												if (details.getP_s_share_percentage() != null
														&& !details.getP_s_share_percentage().equals("null")) {
													if (details.getP_s_res() != null
															&& !details.getP_s_res().equals("null")) {
														if (details.getNet_worth_p_s() != null
																&& !details.getNet_worth_p_s().equals("null")) {
															if (details.getP_s_legal_status() != null
																	&& !details.getP_s_legal_status().equals("null")) {
																if (details.getP_s_emi_id() != null
																		&& !details.getP_s_emi_id().equals("null")) {
																	if (details.getP_s_exp_emi_id() != null && !details
																			.getP_s_exp_emi_id().equals("null")) {
																		if (details.getP_s_passport_no() != null
																				&& !details.getP_s_passport_no()
																						.equals("null")) {
																			if (details.getP_s_exp_passport() != null
																					&& !details.getP_s_exp_passport()
																							.equals("null")) {
																				if (details.getP_s_nat_code() != null
																						&& !details.getP_s_nat_code()
																								.equals("null")) {
																					if (details
																							.getP_s_trade_license_no() != null
																							&& !details
																									.getP_s_trade_license_no()
																									.equals("null")) {
																						if (details
																								.getP_s_place_of_issuing_tl() != null
																								&& !details
																										.getP_s_place_of_issuing_tl()
																										.equals("null")) {
																							if (details
																									.getP_s_lei() != null
																									&& !details
																											.getP_s_lei()
																											.equals("null")) {
																								if (details
																										.getP_s_lei_number() != null
																										&& !details
																												.getP_s_lei_number()
																												.equals("null")) {
																									if (details
																											.getGender() != null
																											&& !details
																													.getGender()
																													.equals("null")) {
																										Msg = "Validation_done";
																									} else {
																										Msg = "Gender not entered";
																									}
																								} else {
																									Msg = "Partner LEI not entered";
																								}
																							} else {
																								Msg = "Partner LEI not entered";
																							}
																						} else {
																							Msg = "Partner Trade license issued place not entered";
																						}
																					} else {
																						Msg = "Partner Trade license not entered";
																					}
																				} else {
																					Msg = "Partner Nationality code not entered";
																				}
																			} else {
																				Msg = "Partner Passport Expiry date not entered";
																			}
																		} else {
																			Msg = "Partner Passport no not entered";
																		}
																	} else {
																		Msg = "Partner Emirated Expiry date not entered";
																	}
																} else {
																	Msg = "Partner Emirated id not entered";
																}
															} else {
																Msg = "Partner Legal status is not entered";
															}
														} else {
															Msg = "Partner Networth is not entered";
														}
													} else {
														Msg = "Partner resident is not entered";
													}
												} else {
													Msg = "Partner Percentage is not entered";
												}
											} else {
												Msg = "Partner cin is not entered";
											}
										} else {
											Msg = "Name is not entered";
										}
									} else {
										Msg = "Rec Id is not entered";
									}
								} else {
									Msg = "Part_shar_type is not entered";
								}
							} else {
								Msg = "Csno is not entered";
							}
						} else {
							Msg = "Cin is not entered";
						}
					} else {
						Msg = "Bankcode is not entered";
					}
				} else if ((up2.getType_code().equals("CTC4") && up2.getSub_bor_type().equals("SCC11"))
						&& (up2.getType_code().equals("CTC4") && up2.getSub_bor_type().equals("SCC14"))
						&& (up2.getType_code().equals("CTC4") && up2.getSub_bor_type().equals("SCC13"))) {

					if (details.getBankcode() != null && !details.getBankcode().equals("null")) {
						if (details.getCin() != null && !details.getCin().equals("null")) {
							if (details.getCsno() != null && !details.getCsno().equals("null")) {
								if (details.getPart_shar_type() != null
										&& !details.getPart_shar_type().equals("null")) {
									if (details.getPart_shar_rec_id() != null
											&& !details.getPart_shar_rec_id().equals("null")) {
										if (details.getP_s_ename() != null && !details.getP_s_ename().equals("null")) {
											if (details.getP_s_res() != null && !details.getP_s_res().equals("null")) {
												if (details.getP_s_legal_status() != null
														&& !details.getP_s_legal_status().equals("null")) {
													if (details.getP_s_emi_id() != null
															&& !details.getP_s_emi_id().equals("null")) {
														if (details.getP_s_exp_emi_id() != null
																&& !details.getP_s_exp_emi_id().equals("null")) {
															if (details.getP_s_passport_no() != null
																	&& !details.getP_s_passport_no().equals("null")) {
																if (details.getP_s_exp_passport() != null && !details
																		.getP_s_exp_passport().equals("null")) {
																	if (details.getP_s_nat_code() != null && !details
																			.getP_s_nat_code().equals("null")) {
																		if (details.getP_s_trade_license_no() != null
																				&& !details.getP_s_trade_license_no()
																						.equals("null")) {
																			if (details
																					.getP_s_place_of_issuing_tl() != null
																					&& !details
																							.getP_s_place_of_issuing_tl()
																							.equals("null")) {
																				if (details.getP_s_lei() != null
																						&& !details.getP_s_lei()
																								.equals("null")) {
																					if (details
																							.getP_s_lei_number() != null
																							&& !details
																									.getP_s_lei_number()
																									.equals("null")) {
																						if (details.getGender() != null
																								&& !details.getGender()
																										.equals("null")) {
																							Msg = "Validation_done";
																						} else {
																							Msg = "Gender LEI not entered";
																						}
																					} else {
																						Msg = "Partner LEI not entered";
																					}
																				} else {
																					Msg = "Partner LEI not entered";
																				}
																			} else {
																				Msg = "Partner Trade license issued place not entered";
																			}
																		} else {
																			Msg = "Partner Trade license not entered";
																		}
																	} else {
																		Msg = "Partner Nationality code not entered";
																	}
																} else {
																	Msg = "Partner Passport Expiry date not entered";
																}
															} else {
																Msg = "Partner Passport no not entered";
															}
														} else {
															Msg = "Partner Emirated Expiry date not entered";
														}
													} else {
														Msg = "Partner Emirated id not entered";
													}
												} else {
													Msg = "Partner Legal status is not entered";
												}
											} else {
												Msg = "Partner resident is not entered";
											}

										} else {
											Msg = "Name is not entered";
										}
									} else {
										Msg = "Rec Id is not entered";
									}
								} else {
									Msg = "Part_shar_type is not entered";
								}
							} else {
								Msg = "Csno is not entered";
							}
						} else {
							Msg = "Cin is not entered";
						}
					} else {
						Msg = "Bankcode is not entered";
					}
				} else if ((up2.getType_code().equals("CTC6") && up2.getSub_bor_type().equals("SCC11"))) {

					if (details.getBankcode() != null && !details.getBankcode().equals("null")) {
						if (details.getCin() != null && !details.getCin().equals("null")) {
							if (details.getCsno() != null && !details.getCsno().equals("null")) {
								if (details.getPart_shar_type() != null
										&& !details.getPart_shar_type().equals("null")) {
									if (details.getPart_shar_rec_id() != null
											&& !details.getPart_shar_rec_id().equals("null")) {
										if (details.getP_s_ename() != null && !details.getP_s_ename().equals("null")) {
											if (details.getP_s_res() != null && !details.getP_s_res().equals("null")) {
												if (details.getP_s_legal_status() != null
														&& !details.getP_s_legal_status().equals("null")) {
													if (details.getP_s_nat_code() != null
															&& !details.getP_s_nat_code().equals("null")) {

														if (details.getGender() != null
																&& !details.getGender().equals("null")) {
															Msg = "Validation_done";
														} else {
															Msg = "Gender not entered";
														}

													} else {
														Msg = "Partner Nationality code not entered";
													}

												} else {
													Msg = "Partner Legal status is not entered";
												}

											} else {
												Msg = "Partner resident is not entered";
											}
										} else {
											Msg = "Name is not entered";
										}
									} else {
										Msg = "Rec Id is not entered";
									}
								} else {
									Msg = "Part_shar_type is not entered";
								}
							} else {
								Msg = "Csno is not entered";
							}
						} else {
							Msg = "Cin is not entered";
						}
					} else {
						Msg = "Bankcode is not entered";
					}

				} else {
					Msg = "Invalid Type / Sub Borrower Type Mentioned in customer data";
				}

			} else {
				Msg = "Selected cin >> Customer data type_code is mentioned >> CTC2. Not able to Update";
			}
		} else {
			Msg = "Selected cin >> Customer data type_code is not mentioned. Not able to Update";
		}

		return Msg;
	}

	public String Custdataoperation(RBRcustomer_entity RBRcustomer_entity, String formmode, String Userid,
			String Branch) {
		String Msg = "";

		if (formmode.equals("Customeradd")) {
			RBRcustomer_entity RBRcustomeradd = new RBRcustomer_entity();

			RBRcustomeradd.setOperation(RBRcustomer_entity.getOperation());
			RBRcustomeradd.setBank_code(RBRcustomer_entity.getBank_code());
			RBRcustomeradd.setCin(RBRcustomer_entity.getCin());
			RBRcustomeradd.setCsno(RBRcustomer_entity.getCsno());
			RBRcustomeradd.setCename(RBRcustomer_entity.getCename());
			RBRcustomeradd.setCif_no(RBRcustomer_entity.getCif_no());
			RBRcustomeradd.setRemarks(RBRcustomer_entity.getRemarks());
			RBRcustomeradd.setType_code(RBRcustomer_entity.getType_code());
			RBRcustomeradd.setSub_bor_type(RBRcustomer_entity.getSub_bor_type());
			RBRcustomeradd.setCus_res(RBRcustomer_entity.getCus_res());
			RBRcustomeradd.setBorrower_subsidiary(RBRcustomer_entity.getBorrower_subsidiary());
			RBRcustomeradd.setGroup_up(RBRcustomer_entity.getGroup_up());
			RBRcustomeradd.setGroup_ip(RBRcustomer_entity.getGroup_ip());
			RBRcustomeradd.setLei(RBRcustomer_entity.getLei());
			RBRcustomeradd.setLei_number(RBRcustomer_entity.getLei_number());
			RBRcustomeradd.setCus_dom(RBRcustomer_entity.getCus_dom());
			RBRcustomeradd.setEco_sec(RBRcustomer_entity.getEco_sec());
			RBRcustomeradd.setEst_date(RBRcustomer_entity.getEst_date());
			RBRcustomeradd.setEmi_est(RBRcustomer_entity.getEmi_est());
			RBRcustomeradd.setLic_id(RBRcustomer_entity.getLic_id());
			RBRcustomeradd.setExp_lic(RBRcustomer_entity.getExp_lic());
			RBRcustomeradd.setEmi_lic(RBRcustomer_entity.getEmi_lic());
			RBRcustomeradd.setTelephone(RBRcustomer_entity.getTelephone());
			RBRcustomeradd.setDob(RBRcustomer_entity.getDob());
			RBRcustomeradd.setEid(RBRcustomer_entity.getEid());
			RBRcustomeradd.setExp_emi_id(RBRcustomer_entity.getExp_emi_id());
			RBRcustomeradd.setPassport(RBRcustomer_entity.getPassport());
			RBRcustomeradd.setExp_passport(RBRcustomer_entity.getExp_passport());
			RBRcustomeradd.setCapital_annual_income(RBRcustomer_entity.getCapital_annual_income());
			RBRcustomeradd.setTurnover_operating_income(RBRcustomer_entity.getTurnover_operating_income());
			RBRcustomeradd.setAuditor(RBRcustomer_entity.getAuditor());
			RBRcustomeradd.setEmployer(RBRcustomer_entity.getEmployer());
			RBRcustomeradd.setDate_of_audited_fs(RBRcustomer_entity.getDate_of_audited_fs());
			RBRcustomeradd.setNo_of_employees(RBRcustomer_entity.getNo_of_employees());
			RBRcustomeradd.setSrl_no(RBRcustomer_entity.getSrl_no());
			RBRcustomeradd.setBranch_code(Branch);
			if (Branch.equals("9001")) {
				RBRcustomeradd.setBranch("Dubai");
			} else if (Branch.equals("9002")) {
				RBRcustomeradd.setBranch("Abu Dhabi");
			} else if (Branch.equals("9003")) {
				RBRcustomeradd.setBranch("Deira");
			} else if (Branch.equals("9004")) {
				RBRcustomeradd.setBranch("Sharjah");
			} else if (Branch.equals("9005")) {
				RBRcustomeradd.setBranch("Ras Al Khaima");
			} else if (Branch.equals("9006")) {
				RBRcustomeradd.setBranch("Al Ain");
			} else if (Branch.equals("9008")) {
				RBRcustomeradd.setBranch("Syndication");
			}
			RBRcustomeradd.setEntry_user(Userid);
			RBRcustomeradd.setEntry_time(new Date());
			RBRcustomeradd.setAuth_flg("N");
			rBRcustomerRepo.save(RBRcustomeradd);

			Rbrauditservice(Userid, "CUSTOMER DATA", "NEW CUSTOMER DATA ENTRY",
					RBRcustomer_entity.getCin() + " - IS NEWLY ADDED AND SRL NO IS " + RBRcustomer_entity.getSrl_no());

			Msg = "New Customer added Successfully! If you don't see the update, Refresh the page";

		} else if (formmode.equals("Customeredit")) {

			Optional<RBRcustomer_entity> RBRcust = rBRcustomerRepo.findById(RBRcustomer_entity.getSrl_no());

			if (RBRcust.isPresent()) {
				RBRcustomer_entity RBRcustomeradd = RBRcust.get();
				RBRcustomeradd.setOperation(RBRcustomer_entity.getOperation());
				RBRcustomeradd.setBank_code(RBRcustomer_entity.getBank_code());
				RBRcustomeradd.setCin(RBRcustomer_entity.getCin());
				RBRcustomeradd.setCsno(RBRcustomer_entity.getCsno());
				RBRcustomeradd.setCename(RBRcustomer_entity.getCename());
				RBRcustomeradd.setCif_no(RBRcustomer_entity.getCif_no());
				RBRcustomeradd.setRemarks(RBRcustomer_entity.getRemarks());
				RBRcustomeradd.setType_code(RBRcustomer_entity.getType_code());
				RBRcustomeradd.setSub_bor_type(RBRcustomer_entity.getSub_bor_type());
				RBRcustomeradd.setCus_res(RBRcustomer_entity.getCus_res());
				RBRcustomeradd.setBorrower_subsidiary(RBRcustomer_entity.getBorrower_subsidiary());
				RBRcustomeradd.setGroup_up(RBRcustomer_entity.getGroup_up());
				RBRcustomeradd.setGroup_ip(RBRcustomer_entity.getGroup_ip());
				RBRcustomeradd.setLei(RBRcustomer_entity.getLei());
				RBRcustomeradd.setLei_number(RBRcustomer_entity.getLei_number());
				RBRcustomeradd.setCus_dom(RBRcustomer_entity.getCus_dom());
				RBRcustomeradd.setEco_sec(RBRcustomer_entity.getEco_sec());
				RBRcustomeradd.setEst_date(RBRcustomer_entity.getEst_date());
				RBRcustomeradd.setEmi_est(RBRcustomer_entity.getEmi_est());
				RBRcustomeradd.setLic_id(RBRcustomer_entity.getLic_id());
				RBRcustomeradd.setExp_lic(RBRcustomer_entity.getExp_lic());
				RBRcustomeradd.setEmi_lic(RBRcustomer_entity.getEmi_lic());
				RBRcustomeradd.setTelephone(RBRcustomer_entity.getTelephone());
				RBRcustomeradd.setDob(RBRcustomer_entity.getDob());
				RBRcustomeradd.setEid(RBRcustomer_entity.getEid());
				RBRcustomeradd.setExp_emi_id(RBRcustomer_entity.getExp_emi_id());
				RBRcustomeradd.setPassport(RBRcustomer_entity.getPassport());
				RBRcustomeradd.setExp_passport(RBRcustomer_entity.getExp_passport());
				RBRcustomeradd.setCapital_annual_income(RBRcustomer_entity.getCapital_annual_income());
				RBRcustomeradd.setTurnover_operating_income(RBRcustomer_entity.getTurnover_operating_income());
				RBRcustomeradd.setAuditor(RBRcustomer_entity.getAuditor());
				RBRcustomeradd.setEmployer(RBRcustomer_entity.getEmployer());
				RBRcustomeradd.setDate_of_audited_fs(RBRcustomer_entity.getDate_of_audited_fs());
				RBRcustomeradd.setNo_of_employees(RBRcustomer_entity.getNo_of_employees());
				RBRcustomeradd.setBranch_code(Branch);
				if (Branch.equals("9001")) {
					RBRcustomeradd.setBranch("Dubai");
				} else if (Branch.equals("9002")) {
					RBRcustomeradd.setBranch("Abu Dhabi");
				} else if (Branch.equals("9003")) {
					RBRcustomeradd.setBranch("Deira");
				} else if (Branch.equals("9004")) {
					RBRcustomeradd.setBranch("Sharjah");
				} else if (Branch.equals("9005")) {
					RBRcustomeradd.setBranch("Ras Al Khaima");
				} else if (Branch.equals("9006")) {
					RBRcustomeradd.setBranch("Al Ain");
				} else if (Branch.equals("9008")) {
					RBRcustomeradd.setBranch("Syndication");
				}
				RBRcustomeradd.setEntry_user(Userid);
				RBRcustomeradd.setEntry_time(new Date());
				RBRcustomeradd.setAuth_flg("N");
				rBRcustomerRepo.save(RBRcustomeradd);

				Rbrauditservice(Userid, "CUSTOMER DATA", "CUSTOMER DATA EDIT",
						RBRcustomer_entity.getCin() + " - IS EDITED AND SRL NO IS " + RBRcustomer_entity.getSrl_no());

				Msg = "Customer edited Successfully! If you don't see the update, Refresh the page";
			} else {
				Msg = "Not able to update data/Invalid ID";
			}

		}

		return Msg;

	}

	public String Partnerdataoperation(RBRShareHolder_Entity share, String formmode, String Userid, String Branch)
			throws Exception {
		String Msg = "";

		if (formmode.equals("Partneradd")) {

			Optional<RBRcustomer_entity> RBRcustomer_entity = rBRcustomerRepo.getcinavail(share.getCin());

			if (RBRcustomer_entity.isPresent()) {
				if (!RBRcustomer_entity.get().getType_code().equals("null")) {
					if (!RBRcustomer_entity.get().getType_code().equals("CTC2")) {

						RBRShareHolder_Entity RBRShareHolder = new RBRShareHolder_Entity();
						RBRShareHolder.setOperation(share.getOperation());
						RBRShareHolder.setSrl_no(share.getSrl_no());
						RBRShareHolder.setBankcode(share.getBankcode());
						RBRShareHolder.setCin(share.getCin());
						RBRShareHolder.setCsno(share.getCsno());
						RBRShareHolder.setPart_shar_rec_id(share.getPart_shar_rec_id());
						RBRShareHolder.setPart_shar_type(share.getPart_shar_type());
						RBRShareHolder.setP_s_ename(share.getP_s_ename());
						RBRShareHolder.setP_s_cin(share.getP_s_cin());
						RBRShareHolder.setP_s_res(share.getP_s_res());
						RBRShareHolder.setP_s_share_percentage(share.getP_s_share_percentage());
						RBRShareHolder.setNet_worth_p_s(share.getNet_worth_p_s());
						RBRShareHolder.setP_s_legal_status(share.getP_s_legal_status());
						RBRShareHolder.setP_s_emi_id(share.getP_s_emi_id());
						RBRShareHolder.setP_s_exp_emi_id(share.getP_s_exp_emi_id());
						RBRShareHolder.setP_s_passport_no(share.getP_s_passport_no());
						RBRShareHolder.setP_s_exp_passport(share.getP_s_exp_passport());
						RBRShareHolder.setP_s_nat_code(share.getP_s_nat_code());
						RBRShareHolder.setP_s_trade_license_no(share.getP_s_trade_license_no());
						RBRShareHolder.setP_s_place_of_issuing_tl(share.getP_s_place_of_issuing_tl());
						RBRShareHolder.setP_s_lei(share.getP_s_lei());
						RBRShareHolder.setP_s_lei_number(share.getP_s_lei_number());
						RBRShareHolder.setGender(share.getGender());
						RBRShareHolder.setEntry_user(Userid);
						RBRShareHolder.setEntry_time(new Date());
						RBRShareHolder.setAuth_flg("N");
						RBRShareHolder.setBranch_code(Branch);
						rbrShareHolder_Repo.save(RBRShareHolder);

						Rbrauditservice(Userid, "PARTNER DATA", "NEW PARTNER DATA ENTRY", RBRShareHolder.getCin()
								+ " - IS NEWLY ADDED AND SRL NO IS " + RBRShareHolder.getSrl_no());

						Msg = "Partner Added Successfully! If you don't see the update, Refresh the page";
					} else {
						throw new Exception("Mentioned Cin type code CTC2 in customer data/ Not able to add");
					}
				} else {
					Msg = "Customer data Sub borrower not mentioned";
				}
			} else {
				Msg = "Mentioned Cin not present in Customer data ";
			}

		} else if (formmode.equals("Partnerdataedit")) {

			Optional<RBRShareHolder_Entity> RBRShare = rbrShareHolder_Repo.findById(share.getSrl_no());

			if (RBRShare.isPresent()) {
				RBRShareHolder_Entity RBRShareHolder = RBRShare.get();

				RBRShareHolder.setOperation(share.getOperation());
				RBRShareHolder.setBankcode(share.getBankcode());
				RBRShareHolder.setCin(share.getCin());
				RBRShareHolder.setCsno(share.getCsno());
				RBRShareHolder.setPart_shar_rec_id(share.getPart_shar_rec_id());
				RBRShareHolder.setPart_shar_type(share.getPart_shar_type());
				RBRShareHolder.setP_s_ename(share.getP_s_ename());
				RBRShareHolder.setP_s_cin(share.getP_s_cin());
				RBRShareHolder.setP_s_res(share.getP_s_res());
				RBRShareHolder.setP_s_share_percentage(share.getP_s_share_percentage());
				RBRShareHolder.setNet_worth_p_s(share.getNet_worth_p_s());
				RBRShareHolder.setP_s_legal_status(share.getP_s_legal_status());
				RBRShareHolder.setP_s_emi_id(share.getP_s_emi_id());
				RBRShareHolder.setP_s_exp_emi_id(share.getP_s_exp_emi_id());
				RBRShareHolder.setP_s_passport_no(share.getP_s_passport_no());
				RBRShareHolder.setP_s_exp_passport(share.getP_s_exp_passport());
				RBRShareHolder.setP_s_nat_code(share.getP_s_nat_code());
				RBRShareHolder.setP_s_trade_license_no(share.getP_s_trade_license_no());
				RBRShareHolder.setP_s_place_of_issuing_tl(share.getP_s_place_of_issuing_tl());
				RBRShareHolder.setP_s_lei(share.getP_s_lei());
				RBRShareHolder.setP_s_lei_number(share.getP_s_lei_number());
				RBRShareHolder.setGender(share.getGender());
				RBRShareHolder.setEntry_user(Userid);
				RBRShareHolder.setEntry_time(new Date());
				RBRShareHolder.setAuth_flg("N");
				RBRShareHolder.setModify_user(Userid);
				RBRShareHolder.setModify_time(new Date());
				RBRShareHolder.setBranch_code(Branch);
				rbrShareHolder_Repo.save(RBRShareHolder);

				Rbrauditservice(Userid, "PARTNER DATA", "PARTNER DATA EDIT",
						RBRShareHolder.getCin() + " - IS EDITED AND SRL NO IS " + RBRShareHolder.getSrl_no());

				Msg = "Partner Edited Successfully! If you don't see the update, Refresh the page";

			} else {
				Msg = "No Partner found";
			}

		}

		return Msg;
	}

	public String Securitydataopr(Security_Entity sec, String formmode, String Userid, String Branch, List<Long> ids) {
		String Msg = "";

		if (formmode.equals("Securityadd")) {

			Security_Entity Security_Entity = new Security_Entity();

			Security_Entity.setOperation(sec.getOperation());
			Security_Entity.setSrl_no(sec.getSrl_no());
			Security_Entity.setBank_code(sec.getBank_code());
			Security_Entity.setCin(sec.getCin());
			Security_Entity.setCsno(sec.getCsno());
			Security_Entity.setFac_id(sec.getFac_id());
			Security_Entity.setSecurity_rec_id(sec.getSecurity_rec_id());
			Security_Entity.setSecurity_type(sec.getSecurity_type());
			Security_Entity.setMv(sec.getMv());
			Security_Entity.setValdate(sec.getValdate());
			Security_Entity.setDis_val_col(sec.getDis_val_col());
			Security_Entity.setExp_date(sec.getExp_date());
			Security_Entity.setNamee_guarantor(sec.getNamee_guarantor());
			Security_Entity.setPer_exp_secured_guarantor(sec.getPer_exp_secured_guarantor());
			Security_Entity.setId_type(sec.getId_type());
			Security_Entity.setId_value(sec.getId_value());
			Security_Entity.setAuth_flg("N");
			Security_Entity.setEntry_time(new Date());
			Security_Entity.setEntry_user(Userid);
			Security_Entity.setBranch_code(Branch);

			Rbrauditservice(Userid, "SECURITY DATA", "NEW SECURITY DATA ENTRY",
					Security_Entity.getCin() + " - IS NEWLY ADDED AND SRL NO IS " + Security_Entity.getSrl_no());

			security_Repo.save(Security_Entity);

			Msg = "Security Data Added! If you don't see the update, Refresh the page";

		} else if (formmode.equals("Securitydataedit")) {

			Optional<Security_Entity> Security_En = security_Repo.findById(sec.getSrl_no());

			if (Security_En.isPresent()) {
				Security_Entity Security_Entity = Security_En.get();

				Security_Entity.setOperation(sec.getOperation());
				Security_Entity.setBank_code(sec.getBank_code());
				Security_Entity.setCin(sec.getCin());
				Security_Entity.setCsno(sec.getCsno());
				Security_Entity.setFac_id(sec.getFac_id());
				Security_Entity.setSecurity_rec_id(sec.getSecurity_rec_id());
				Security_Entity.setSecurity_type(sec.getSecurity_type());
				Security_Entity.setMv(sec.getMv());
				Security_Entity.setValdate(sec.getValdate());
				Security_Entity.setDis_val_col(sec.getDis_val_col());
				Security_Entity.setExp_date(sec.getExp_date());
				Security_Entity.setNamee_guarantor(sec.getNamee_guarantor());
				Security_Entity.setPer_exp_secured_guarantor(sec.getPer_exp_secured_guarantor());
				Security_Entity.setId_type(sec.getId_type());
				Security_Entity.setId_value(sec.getId_value());
				Security_Entity.setAuth_flg("N");
				Security_Entity.setModify_time(new Date());
				Security_Entity.setModify_user(Userid);
				Security_Entity.setBranch_code(Branch);
				security_Repo.save(Security_Entity);

				Rbrauditservice(Userid, "SECURITY DATA", "SECURITY DATA EDIT",
						Security_Entity.getCin() + " - IS EDITED AND SRL NO IS " + Security_Entity.getSrl_no());

				Msg = "Security Data Edited! If you don't see the update, Refresh the page";

			} else {
				Msg = "Security Data Not found";
			}

		} else if (formmode.equals("Securityverifyall")) {

			List<String> stringIds = ids.stream().map(String::valueOf).collect(Collectors.toList());

			List<Security_Entity> entities = security_Repo.findAllById(stringIds);

			for (Security_Entity Security_Entity : entities) {

				Security_Entity.setAuth_flg("Y");
				Security_Entity.setAuth_time(new Date());
				Security_Entity.setAuth_user(Userid);
				Security_Entity.setSrl_no(Security_Entity.getSrl_no());
				Rbrauditservice(Userid, "SECURITY DATA", "SECURITY DATA VERIFY",
						Security_Entity.getCin() + " - IS BULK VERIFIED AND SRL NO IS " + Security_Entity.getSrl_no());
				security_Repo.save(Security_Entity);
			}

			Msg = "success";

		} else if (formmode.equals("Facilityverifyall")) {

			List<String> stringIds = ids.stream().map(String::valueOf).collect(Collectors.toList());

			List<Facitlity_Entity> entities = facility_Repo.findAllById(stringIds);

			for (Facitlity_Entity Facitlity_Entity : entities) {

				Facitlity_Entity.setAuth_flg("Y");
				Facitlity_Entity.setAuth_time(new Date());
				Facitlity_Entity.setAuth_user(Userid);
				Facitlity_Entity.setSrl_no(Facitlity_Entity.getSrl_no());
				Rbrauditservice(Userid, "FACILITY DATA", "FACILITY DATA VERIFY", Facitlity_Entity.getCin()
						+ " - IS BULK VERIFIED AND SRL NO IS " + Facitlity_Entity.getSrl_no());
				facility_Repo.save(Facitlity_Entity);
			}

			Msg = "success";

		} else if (formmode.equals("Provisionverifyall")) {

			List<String> stringIds = ids.stream().map(String::valueOf).collect(Collectors.toList());

			List<Provision_Entity> entities = Provision_Repo.findAllById(stringIds);

			for (Provision_Entity Provision_Entity : entities) {

				Provision_Entity.setAuth_flg("Y");
				Provision_Entity.setAuth_time(new Date());
				Provision_Entity.setAuth_user(Userid);
				Provision_Entity.setSrl_no(Provision_Entity.getSrl_no());
				Rbrauditservice(Userid, "PROVISION DATA", "PROVISION DATA VERIFY", Provision_Entity.getCin()
						+ " - IS BULK VERIFIED AND SRL NO IS " + Provision_Entity.getSrl_no());
				Provision_Repo.save(Provision_Entity);
			}

			Msg = "success";

		} else if (formmode.equals("overallverify")) {
			List<String> stringIds = ids.stream().map(String::valueOf).collect(Collectors.toList());

			List<RBROverall_Data_Entity> entities = RBRoverall_Data_Repo.findAllById(stringIds);

			for (RBROverall_Data_Entity RBROverall_Data_Entity : entities) {

				RBROverall_Data_Entity.setAuth_flg("Y");
				RBROverall_Data_Entity.setAuth_time(new Date());
				RBROverall_Data_Entity.setAuth_user(Userid);
				RBROverall_Data_Entity.setSrl_no(RBROverall_Data_Entity.getSrl_no());
				Rbrauditservice(Userid, "OVERALL DATA", "OVERALL DATA VERIFY", RBROverall_Data_Entity.getCin()
						+ " - IS BULK VERIFIED AND SRL NO IS " + RBROverall_Data_Entity.getSrl_no());
				RBRoverall_Data_Repo.save(RBROverall_Data_Entity);
			}

			Msg = "success";

		}

		return Msg;

	}

	public String Securitydataupload(MultipartFile Securityfile, String Userid) {
		String response = "";
		String fileName = Securityfile.getOriginalFilename();

		if (fileName.contains("security")) {

			if (!Securityfile.isEmpty()) {

				try {

					Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096)
							.open(Securityfile.getInputStream());

					List<HashMap<Integer, String>> mapList = new ArrayList<>();
					for (Sheet s : workbook) {
						for (Row r : s) {
							System.out.println(r.getRowNum());
							if (r.getRowNum() == 0) {
								continue;
							}
							String val = null;

							HashMap<Integer, String> map = new HashMap<>();
							for (int j = 0; j <= 9; j++) {
								Cell cell = r.getCell(j);
								val = cell.getStringCellValue();
								System.out.println("cell is -" + cell + " and values is -" + val);
								map.put(j, val);
							}

							mapList.add(map);

						}

					}

					for (HashMap<Integer, String> item : mapList) {

						Optional<Security_Entity> Security_En = security_Repo.getsecurity_rec_id(item.get(4));

						if (Security_En.isPresent()) {

							Security_Entity Security_Entity = Security_En.get();

							Security_Entity.setMv(toBigDecimal(item.get(7)));
							Security_Entity.setDis_val_col(toBigDecimal(item.get(9)));

							Security_Entity.setModify_flg("Y");
							Security_Entity.setAuth_flg("N");
							Security_Entity.setModify_time(new Date());

							Rbrauditservice(Userid, "Security DATA", "SECURITY DATA EXCEL UPLOAD",
									Security_Entity.getCin() + " - IS BULK UPLOAD AND SRL NO IS "
											+ Security_Entity.getSrl_no());

							security_Repo.save(Security_Entity);

						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("Received file: " + Securityfile.getOriginalFilename());
				response = "success";
			} else {
				System.out.println("Received file fail: " + Securityfile.getOriginalFilename());
				response = "Failure";
			}

		} else if (fileName.contains("facility")) {

			if (!Securityfile.isEmpty()) {

				try {

					Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096)
							.open(Securityfile.getInputStream());

					List<HashMap<Integer, String>> mapList = new ArrayList<>();
					for (Sheet s : workbook) {
						for (Row r : s) {
							System.out.println(r.getRowNum());
							if (r.getRowNum() == 0) {
								continue;
							}
							String val = null;

							HashMap<Integer, String> map = new HashMap<>();
							for (int j = 0; j <= 15; j++) {
								Cell cell = r.getCell(j);
								val = cell.getStringCellValue();
								System.out.println("cell is -" + cell + " and values is -" + val);
								map.put(j, val);
							}

							mapList.add(map);

						}

					}

					for (HashMap<Integer, String> item : mapList) {

						Optional<Facitlity_Entity> Facitlity_Entity = facility_Repo.getbyfacilityid(item.get(5));

						if (Facitlity_Entity.isPresent()) {

							Facitlity_Entity Facitlity = Facitlity_Entity.get();
							Facitlity.setLimit_funded(
									item.get(7) != null ? new BigDecimal(item.get(7)) : new BigDecimal("0"));
							Facitlity.setLimit_unfunded(
									item.get(9) != null ? new BigDecimal(item.get(9)) : new BigDecimal("0"));
							Facitlity.setOs_funded(
									item.get(8) != null ? new BigDecimal(item.get(8)) : new BigDecimal("0"));
							Facitlity.setOs_unfunded_after_ccf(
									item.get(12) != null ? new BigDecimal(item.get(12)) : new BigDecimal("0"));
							Facitlity.setOs_unfunded_before_ccf(
									item.get(11) != null ? new BigDecimal(item.get(11)) : new BigDecimal("0"));
							Facitlity.setLimit_total(
									item.get(10) != null ? new BigDecimal(item.get(10)) : new BigDecimal("0"));
							Facitlity.setOs_total(
									item.get(13) != null ? new BigDecimal(item.get(13)) : new BigDecimal("0"));
							Facitlity.setSrl_no(Facitlity.getSrl_no());
							Facitlity.setAuth_flg("N");
							Facitlity.setModify_flg("Y");
							Facitlity.setModify_time(new Date());

							Rbrauditservice(Userid, "FACILITY DATA", "FACILITY DATA EXCEL UPLOAD",
									Facitlity.getCin() + " - IS BULK UPLOAD AND SRL NO IS " + Facitlity.getSrl_no());
							facility_Repo.save(Facitlity);

						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("Received file: " + Securityfile.getOriginalFilename());
				response = "success";
			} else {
				System.out.println("Received file fail: " + Securityfile.getOriginalFilename());
				response = "Failure";
			}

		} else if (fileName.contains("provision")) {

			if (!Securityfile.isEmpty()) {

				try {

					Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096)
							.open(Securityfile.getInputStream());

					List<HashMap<Integer, String>> mapList = new ArrayList<>();
					for (Sheet s : workbook) {
						for (Row r : s) {
							System.out.println(r.getRowNum());
							if (r.getRowNum() == 0) {
								continue;
							}
							String val = null;

							HashMap<Integer, String> map = new HashMap<>();
							for (int j = 0; j <= 17; j++) {
								Cell cell = r.getCell(j);
								val = cell.getStringCellValue();
								System.out.println("cell is -" + cell + " and values is -" + val);
								map.put(j, val);
							}

							mapList.add(map);

						}

					}

					for (HashMap<Integer, String> item : mapList) {

						Optional<Provision_Entity> Provision_Entity = Provision_Repo.getbyfacid(item.get(4));
						if (Provision_Entity.isPresent()) {

							Provision_Entity Provision = Provision_Entity.get();
							Provision.setSrl_no(Provision.getSrl_no());
							Provision.setSus_intr(
									item.get(5) != null ? new BigDecimal(item.get(5)) : new BigDecimal("0"));
							Provision.setProvisions(
									item.get(6) != null ? new BigDecimal(item.get(6)) : new BigDecimal("0"));
							Provision.setOne_year_ecl(
									item.get(9) != null ? new BigDecimal(item.get(9)) : new BigDecimal("0"));
							Provision.setLife_ecl(
									item.get(10) != null ? new BigDecimal(item.get(10)) : new BigDecimal("0"));
							Provision.setFinal_ecl_after_override(
									item.get(11) != null ? new BigDecimal(item.get(11)) : new BigDecimal("0"));

							Provision.setOne_year_pd(
									item.get(12) != null ? new BigDecimal(item.get(12)) : new BigDecimal("0"));
							Provision.setOne_year_pit_pd(
									item.get(13) != null ? new BigDecimal(item.get(13)) : new BigDecimal("0"));
							Provision.setLifetime_pd(
									item.get(14) != null ? new BigDecimal(item.get(14)) : new BigDecimal("0"));
							Provision.setLgd(item.get(15) != null ? new BigDecimal(item.get(15)) : new BigDecimal("0"));

							Provision.setModify_flg("Y");
							Provision.setAuth_flg("N");
							Provision.setModify_time(new Date());

							Rbrauditservice(Userid, "PROVISION DATA", "PROVISION DATA EXCEL UPLOAD",
									Provision.getCin() + " - IS BULK UPLOAD AND SRL NO IS " + Provision.getSrl_no());

							Provision_Repo.save(Provision);

						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("Received file: " + Securityfile.getOriginalFilename());
				response = "success";
			} else {
				System.out.println("Received file fail: " + Securityfile.getOriginalFilename());
				response = "Failure";
			}

		} else if (fileName.contains("overall")) {

			if (!Securityfile.isEmpty()) {

				try {

					Workbook workbook = StreamingReader.builder().rowCacheSize(100).bufferSize(4096)
							.open(Securityfile.getInputStream());

					List<HashMap<Integer, String>> mapList = new ArrayList<>();
					for (Sheet s : workbook) {
						for (Row r : s) {
							System.out.println(r.getRowNum());
							if (r.getRowNum() == 0) {
								continue;
							}
							String val = null;

							HashMap<Integer, String> map = new HashMap<>();
							for (int j = 0; j <= 12; j++) {
								Cell cell = r.getCell(j);
								val = cell.getStringCellValue();
								System.out.println("cell is -" + cell + " and values is -" + val);
								map.put(j, val);
							}

							mapList.add(map);

						}

					}

					for (HashMap<Integer, String> item : mapList) {

						Optional<RBROverall_Data_Entity> RBROverall_Data_Entity = RBRoverall_Data_Repo
								.getbycin(item.get(2));
						if (RBROverall_Data_Entity.isPresent()) {

							RBROverall_Data_Entity RBROverall = RBROverall_Data_Entity.get();
							RBROverall.setSrl_no(RBROverall.getSrl_no());
							RBROverall.setApp_limit_funded(
									item.get(4) != null ? new BigDecimal(item.get(4)) : new BigDecimal("0"));
							RBROverall.setApp_limit_unfunded(
									item.get(5) != null ? new BigDecimal(item.get(5)) : new BigDecimal("0"));
							RBROverall.setOs_funded(
									item.get(6) != null ? new BigDecimal(item.get(6)) : new BigDecimal("0"));
							RBROverall.setOs_unfunded_after_ccf(
									item.get(8) != null ? new BigDecimal(item.get(8)) : new BigDecimal("0"));
							RBROverall.setOs_unfunded_before_ccf(
									item.get(7) != null ? new BigDecimal(item.get(7)) : new BigDecimal("0"));
							RBROverall.setTotal_outstanding_fun_unfun_after_cc(
									item.get(9) != null ? new BigDecimal(item.get(9)) : new BigDecimal("0"));
							RBROverall.setVal_sec(
									item.get(10) != null ? new BigDecimal(item.get(10)) : new BigDecimal("0"));
							RBROverall.setDis_val_sec(
									item.get(11) != null ? new BigDecimal(item.get(11)) : new BigDecimal("0"));
							RBROverall
									.setRwa(item.get(12) != null ? new BigDecimal(item.get(12)) : new BigDecimal("0"));

							RBROverall.setModify_flg("Y");
							RBROverall.setAuth_flg("N");
							RBROverall.setModify_time(new Date());

							Rbrauditservice(Userid, "OVERALL DATA", "OVERALL DATA EXCEL UPLOAD",
									RBROverall.getCin() + " - IS BULK UPLOAD AND SRL NO IS " + RBROverall.getSrl_no());

							RBRoverall_Data_Repo.save(RBROverall);

						}

					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				System.out.println("Received file: " + Securityfile.getOriginalFilename());
				response = "success";
			} else {
				System.out.println("Received file fail: " + Securityfile.getOriginalFilename());
				response = "Failure";
			}

		}

		return response;

	}

	public static BigDecimal toBigDecimal(Object value) {
		if (value == null) {
			return BigDecimal.ZERO;
		}
		if (value instanceof BigDecimal) {
			return (BigDecimal) value;
		}
		try {
			return new BigDecimal(value.toString().trim());
		} catch (NumberFormatException e) {
			// Optional: Log the bad value if needed
			return BigDecimal.ZERO;
		}
	}

	public String Facilitydataopr(Facitlity_Entity fac, String formmode, String Userid, String Branch) {
		String Msg = "";

		if (formmode.equals("Facilityadd")) {
			Facitlity_Entity Facitlity_Entity = new Facitlity_Entity();
			Facitlity_Entity.setOperation(fac.getOperation());
			Facitlity_Entity.setSrl_no(fac.getSrl_no());
			Facitlity_Entity.setBank_code(fac.getBank_code());
			Facitlity_Entity.setCin(fac.getCin());
			Facitlity_Entity.setCsno(fac.getCsno());
			Facitlity_Entity.setProduct(fac.getProduct());
			Facitlity_Entity.setFac_id(fac.getFac_id());
			Facitlity_Entity.setFac_class(fac.getFac_class());
			Facitlity_Entity.setLimit_funded(fac.getLimit_funded());
			Facitlity_Entity.setOs_funded(fac.getOs_funded());
			Facitlity_Entity.setLimit_unfunded(fac.getLimit_unfunded());
			Facitlity_Entity.setLimit_total(fac.getLimit_total());
			Facitlity_Entity.setOs_unfunded_before_ccf(fac.getOs_unfunded_before_ccf());
			Facitlity_Entity.setOs_unfunded_after_ccf(fac.getOs_unfunded_after_ccf());
			Facitlity_Entity.setOs_total(fac.getOs_total());
			Facitlity_Entity.setCountry_funds_utilization(fac.getCountry_funds_utilization());
			Facitlity_Entity.setCy(fac.getCy());
			Facitlity_Entity.setDays_past_due(fac.getDays_past_due());
			Facitlity_Entity.setPast_due_amt(fac.getPast_due_amt());
			Facitlity_Entity.setPrincipal(fac.getPrincipal());
			Facitlity_Entity.setInterest_cap(fac.getInterest_cap());
			Facitlity_Entity.setAcc_int(fac.getAcc_int());
			Facitlity_Entity.setBullet_payments(fac.getBullet_payments());
			Facitlity_Entity.setNum_bullet_payment(fac.getNum_bullet_payment());
			Facitlity_Entity.setNum_bullet_payment_received(fac.getNum_bullet_payment_received());
			Facitlity_Entity.setDefault_date(fac.getDefault_date());
			Facitlity_Entity.setPrincipal_recovered_default(fac.getPrincipal_recovered_default());
			Facitlity_Entity.setInterest_recovered_default(fac.getInterest_recovered_default());
			Facitlity_Entity.setSyndicated_loan(fac.getSyndicated_loan());
			Facitlity_Entity.setBloomberg_ticker_syndicated_loan(fac.getBloomberg_ticker_syndicated_loan());
			Facitlity_Entity.setNum_inst_def(fac.getNum_inst_def());
			Facitlity_Entity.setAmount_inst_def(fac.getAmount_inst_def());
			Facitlity_Entity.setRestructured(fac.getRestructured());
			Facitlity_Entity.setInt_pro_before_restructured(fac.getInt_pro_before_restructured());
			Facitlity_Entity.setInt_pro_after_restructured(fac.getInt_pro_after_restructured());
			Facitlity_Entity.setDate_first_restructured(fac.getDate_first_restructured());
			Facitlity_Entity.setDate_last_restructured(fac.getDate_last_restructured());
			Facitlity_Entity.setNum_restructured(fac.getNum_restructured());
			Facitlity_Entity.setPrincipal_restructured(fac.getPrincipal_restructured());
			Facitlity_Entity.setInt_profit_capitalized_into_restructured_facility(
					fac.getInt_profit_capitalized_into_restructured_facility());
			Facitlity_Entity.setAdd_lending_after_restructuring(fac.getAdd_lending_after_restructuring());
			Facitlity_Entity.setOriginal_fl_in_yrs(fac.getOriginal_fl_in_yrs());
			Facitlity_Entity.setFl_after_restructured(fac.getFl_after_restructured());
			Facitlity_Entity.setRe_maturity(fac.getRe_maturity());
			Facitlity_Entity.setWritten_off(fac.getWritten_off());
			Facitlity_Entity.setWritten_off_facility(fac.getWritten_off_facility());
			Facitlity_Entity.setAmount_of_written_off_facility(fac.getAmount_of_written_off_facility());
			Facitlity_Entity.setAuth_flg("N");
			Facitlity_Entity.setEntry_time(new Date());
			Facitlity_Entity.setEntry_user(Userid);
			Facitlity_Entity.setBranch_code(Branch);
			facility_Repo.save(Facitlity_Entity);

			Rbrauditservice(Userid, "FACILITY DATA", "NEW FACILITY DATA ENTRY",
					Facitlity_Entity.getCin() + " - IS NEWLY ADDED AND SRL NO IS " + Facitlity_Entity.getSrl_no());

			Msg = "Facility Added ! If you don't see the update, Refresh the page";

		} else if (formmode.equals("Facilitydataedit")) {

			Optional<Facitlity_Entity> Facitlity = facility_Repo.findById(fac.getSrl_no());
			if (Facitlity.isPresent()) {
				Facitlity_Entity Facitlity_Entity = Facitlity.get();

				Facitlity_Entity.setOperation(fac.getOperation());
				// Facitlity_Entity.setSrl_no(fac.getSrl_no());
				Facitlity_Entity.setBank_code(fac.getBank_code());
				Facitlity_Entity.setCin(fac.getCin());
				Facitlity_Entity.setCsno(fac.getCsno());
				Facitlity_Entity.setProduct(fac.getProduct());
				Facitlity_Entity.setFac_id(fac.getFac_id());
				Facitlity_Entity.setFac_class(fac.getFac_class());
				Facitlity_Entity.setLimit_funded(fac.getLimit_funded());
				Facitlity_Entity.setOs_funded(fac.getOs_funded());
				Facitlity_Entity.setLimit_unfunded(fac.getLimit_unfunded());
				Facitlity_Entity.setLimit_total(fac.getLimit_total());
				Facitlity_Entity.setOs_unfunded_before_ccf(fac.getOs_unfunded_before_ccf());
				Facitlity_Entity.setOs_unfunded_after_ccf(fac.getOs_unfunded_after_ccf());
				Facitlity_Entity.setOs_total(fac.getOs_total());
				Facitlity_Entity.setCountry_funds_utilization(fac.getCountry_funds_utilization());
				Facitlity_Entity.setCy(fac.getCy());
				Facitlity_Entity.setDays_past_due(fac.getDays_past_due());
				Facitlity_Entity.setPast_due_amt(fac.getPast_due_amt());
				Facitlity_Entity.setPrincipal(fac.getPrincipal());
				Facitlity_Entity.setInterest_cap(fac.getInterest_cap());
				Facitlity_Entity.setAcc_int(fac.getAcc_int());
				Facitlity_Entity.setBullet_payments(fac.getBullet_payments());
				Facitlity_Entity.setNum_bullet_payment(fac.getNum_bullet_payment());
				Facitlity_Entity.setNum_bullet_payment_received(fac.getNum_bullet_payment_received());
				Facitlity_Entity.setDefault_date(fac.getDefault_date());
				Facitlity_Entity.setPrincipal_recovered_default(fac.getPrincipal_recovered_default());
				Facitlity_Entity.setInterest_recovered_default(fac.getInterest_recovered_default());
				Facitlity_Entity.setSyndicated_loan(fac.getSyndicated_loan());
				Facitlity_Entity.setBloomberg_ticker_syndicated_loan(fac.getBloomberg_ticker_syndicated_loan());
				Facitlity_Entity.setNum_inst_def(fac.getNum_inst_def());
				Facitlity_Entity.setAmount_inst_def(fac.getAmount_inst_def());
				Facitlity_Entity.setRestructured(fac.getRestructured());
				Facitlity_Entity.setInt_pro_before_restructured(fac.getInt_pro_before_restructured());
				Facitlity_Entity.setInt_pro_after_restructured(fac.getInt_pro_after_restructured());
				Facitlity_Entity.setDate_first_restructured(fac.getDate_first_restructured());
				Facitlity_Entity.setDate_last_restructured(fac.getDate_last_restructured());
				Facitlity_Entity.setNum_restructured(fac.getNum_restructured());
				Facitlity_Entity.setPrincipal_restructured(fac.getPrincipal_restructured());
				Facitlity_Entity.setInt_profit_capitalized_into_restructured_facility(
						fac.getInt_profit_capitalized_into_restructured_facility());
				Facitlity_Entity.setAdd_lending_after_restructuring(fac.getAdd_lending_after_restructuring());
				Facitlity_Entity.setOriginal_fl_in_yrs(fac.getOriginal_fl_in_yrs());
				Facitlity_Entity.setFl_after_restructured(fac.getFl_after_restructured());
				Facitlity_Entity.setRe_maturity(fac.getRe_maturity());
				Facitlity_Entity.setWritten_off(fac.getWritten_off());
				Facitlity_Entity.setWritten_off_facility(fac.getWritten_off_facility());
				Facitlity_Entity.setAmount_of_written_off_facility(fac.getAmount_of_written_off_facility());
				Facitlity_Entity.setAuth_flg("N");
				Facitlity_Entity.setModify_time(new Date());
				Facitlity_Entity.setModify_user(Userid);
				Facitlity_Entity.setBranch_code(Branch);
				facility_Repo.save(Facitlity_Entity);

				Rbrauditservice(Userid, "FACILITY DATA", "FACILITY DATA EDIT",
						Facitlity_Entity.getCin() + " - IS EDITED AND SRL NO IS " + Facitlity_Entity.getSrl_no());

				Msg = "Facility Edited ! If you don't see the update, Refresh the page";

			} else {
				Msg = "Facility Not found";
			}

		}
		return Msg;
	}

	public String Provisiondataopr(Provision_Entity prov, String formmode, String Userid, String Branch) {
		String Msg = "";

		if (formmode.equals("Provisionadd")) {
			Provision_Entity Provision_Entity = new Provision_Entity();

			Provision_Entity.setOperation(prov.getOperation());
			Provision_Entity.setBank_code(prov.getBank_code());
			Provision_Entity.setSrl_no(prov.getSrl_no());
			Provision_Entity.setCin(prov.getCin());
			Provision_Entity.setCsno(prov.getCsno());
			Provision_Entity.setFac_id(prov.getFac_id());
			Provision_Entity.setSus_intr(prov.getSus_intr());
			Provision_Entity.setProvisions(prov.getProvisions());
			Provision_Entity.setIfrs_9_stage(prov.getIfrs_9_stage());
			Provision_Entity.setIfrs_9_stage_final(prov.getIfrs_9_stage_final());
			Provision_Entity.setOne_year_ecl(prov.getOne_year_ecl());
			Provision_Entity.setLife_ecl(prov.getLife_ecl());
			Provision_Entity.setFinal_ecl_after_override(prov.getFinal_ecl_after_override());
			Provision_Entity.setOne_year_pd(prov.getOne_year_pd());
			Provision_Entity.setOne_year_pit_pd(prov.getOne_year_pit_pd());
			Provision_Entity.setLifetime_pd(prov.getLifetime_pd());
			Provision_Entity.setLgd(prov.getLgd());
			Provision_Entity.setAuth_flg("N");
			Provision_Entity.setEntry_time(new Date());
			Provision_Entity.setEntry_user(Userid);
			Provision_Entity.setBranch_code(Branch);
			Provision_Repo.save(Provision_Entity);

			Rbrauditservice(Userid, "PROVISION DATA", "PROVISION DATA ENTRY",
					Provision_Entity.getCin() + " - IS NEWLY ADDED AND SRL NO IS " + Provision_Entity.getSrl_no());

			Msg = "Provision Added ! If you don't see the update, Refresh the page";

		} else if (formmode.equals("Provisiondataedit")) {

			Optional<Provision_Entity> Provision = Provision_Repo.findById(prov.getSrl_no());

			if (Provision.isPresent()) {
				Provision_Entity Provision_Entity = Provision.get();
				Provision_Entity.setOperation(prov.getOperation());
				Provision_Entity.setBank_code(prov.getBank_code());
				Provision_Entity.setCin(prov.getCin());
				Provision_Entity.setCsno(prov.getCsno());
				Provision_Entity.setFac_id(prov.getFac_id());
				Provision_Entity.setSus_intr(prov.getSus_intr());
				Provision_Entity.setProvisions(prov.getProvisions());
				Provision_Entity.setIfrs_9_stage(prov.getIfrs_9_stage());
				Provision_Entity.setIfrs_9_stage_final(prov.getIfrs_9_stage_final());
				Provision_Entity.setOne_year_ecl(prov.getOne_year_ecl());
				Provision_Entity.setLife_ecl(prov.getLife_ecl());
				Provision_Entity.setFinal_ecl_after_override(prov.getFinal_ecl_after_override());
				Provision_Entity.setOne_year_pd(prov.getOne_year_pd());
				Provision_Entity.setOne_year_pit_pd(prov.getOne_year_pit_pd());
				Provision_Entity.setLifetime_pd(prov.getLifetime_pd());
				Provision_Entity.setLgd(prov.getLgd());
				Provision_Entity.setAuth_flg("N");
				Provision_Entity.setModify_time(new Date());
				Provision_Entity.setModify_user(Userid);
				Provision_Entity.setBranch_code(Branch);
				Provision_Repo.save(Provision_Entity);

				Rbrauditservice(Userid, "PROVISION DATA", "PROVISION DATA EDIT",
						Provision_Entity.getCin() + " - IS EDITED AND SRL NO IS " + Provision_Entity.getSrl_no());

				Msg = "Provision Edited ! If you don't see the update, Refresh the page";
			} else {
				Msg = "Provision Not found";
			}

		}

		return Msg;

	}

	public String Overalldataoper(RBROverall_Data_Entity ovrall, String formmode, String Userid, String Branch) {
		String Msg = "";
		if (formmode.equals("Overalladd")) {
			RBROverall_Data_Entity RBROverall_Data_Entity = new RBROverall_Data_Entity();

			RBROverall_Data_Entity.setOperation(ovrall.getOperation());
			RBROverall_Data_Entity.setBank_code(ovrall.getBank_code());
			RBROverall_Data_Entity.setCin(ovrall.getCin());
			RBROverall_Data_Entity.setCsno(ovrall.getCsno());
			RBROverall_Data_Entity.setSrl_no(ovrall.getSrl_no());
			RBROverall_Data_Entity.setOs_funded(ovrall.getOs_funded());
			RBROverall_Data_Entity.setApp_limit_funded(ovrall.getApp_limit_funded());
			RBROverall_Data_Entity.setApp_limit_unfunded(ovrall.getApp_limit_unfunded());
			RBROverall_Data_Entity.setOs_unfunded_before_ccf(ovrall.getOs_unfunded_before_ccf());
			RBROverall_Data_Entity.setOs_unfunded_after_ccf(ovrall.getOs_unfunded_after_ccf());
			RBROverall_Data_Entity
					.setTotal_outstanding_fun_unfun_after_cc(ovrall.getTotal_outstanding_fun_unfun_after_cc());
			RBROverall_Data_Entity.setVal_sec(ovrall.getVal_sec());
			RBROverall_Data_Entity.setDis_val_sec(ovrall.getDis_val_sec());
			RBROverall_Data_Entity.setRwa(ovrall.getRwa());
			RBROverall_Data_Entity.setRemarks(ovrall.getRemarks());
			RBROverall_Data_Entity.setAuth_flg("N");
			RBROverall_Data_Entity.setEntry_time(new Date());
			RBROverall_Data_Entity.setEntry_user(Userid);
			RBROverall_Data_Entity.setBranch_code(Branch);
			RBRoverall_Data_Repo.save(RBROverall_Data_Entity);

			Rbrauditservice(Userid, "OVERALL DATA", "OVERALL DATA ENTRY", RBROverall_Data_Entity.getCin()
					+ " - IS NEWLY ADDED AND SRL NO IS " + RBROverall_Data_Entity.getSrl_no());

			Msg = "Overall Added ! If you don't see the update, Refresh the page";

		} else if (formmode.equals("Overalldataedit")) {
			Optional<RBROverall_Data_Entity> RBROverall = RBRoverall_Data_Repo.findById(ovrall.getSrl_no());
			if (RBROverall.isPresent()) {
				RBROverall_Data_Entity RBROverall_Data_Entity = RBROverall.get();
				RBROverall_Data_Entity.setOperation(ovrall.getOperation());
				RBROverall_Data_Entity.setBank_code(ovrall.getBank_code());
				RBROverall_Data_Entity.setSrl_no(ovrall.getSrl_no());
				RBROverall_Data_Entity.setCin(ovrall.getCin());
				RBROverall_Data_Entity.setCsno(ovrall.getCsno());
				RBROverall_Data_Entity.setOs_funded(ovrall.getOs_funded());
				RBROverall_Data_Entity.setApp_limit_funded(ovrall.getApp_limit_funded());
				RBROverall_Data_Entity.setApp_limit_unfunded(ovrall.getApp_limit_unfunded());
				RBROverall_Data_Entity.setOs_unfunded_before_ccf(ovrall.getOs_unfunded_before_ccf());
				RBROverall_Data_Entity.setOs_unfunded_after_ccf(ovrall.getOs_unfunded_after_ccf());
				RBROverall_Data_Entity
						.setTotal_outstanding_fun_unfun_after_cc(ovrall.getTotal_outstanding_fun_unfun_after_cc());
				RBROverall_Data_Entity.setVal_sec(ovrall.getVal_sec());
				RBROverall_Data_Entity.setDis_val_sec(ovrall.getDis_val_sec());
				RBROverall_Data_Entity.setRwa(ovrall.getRwa());
				RBROverall_Data_Entity.setRemarks(ovrall.getRemarks());
				RBROverall_Data_Entity.setAuth_flg("N");
				RBROverall_Data_Entity.setModify_time(new Date());
				RBROverall_Data_Entity.setModify_user(Userid);
				RBROverall_Data_Entity.setBranch_code(Branch);

				Rbrauditservice(Userid, "OVERALL DATA", "OVERALL DATA EDIT", RBROverall_Data_Entity.getCin()
						+ " - IS EDITED AND SRL NO IS " + RBROverall_Data_Entity.getSrl_no());

				RBRoverall_Data_Repo.save(RBROverall_Data_Entity);

				Msg = "Overall Edited ! If you don't see the update, Refresh the page";
			} else {
				Msg = "Overall Not found";
			}

		}

		return Msg;
	}

	public String Rbrauditservice(String Userid, String Audit_table_process, String Modification_details,
			String Modifi_remarks) {

		MANUAL_Audit_Entity audit = new MANUAL_Audit_Entity();
		String Number1 = sequence.generateRequestUUId();
		audit.setAudit_ref_no(Number1.toString());
		audit.setAudit_date(new Date());
		audit.setAudit_screen("RBR CCSYS");
		audit.setAudit_table(Audit_table_process);
		audit.setEntry_time(new Date());
		audit.setEntry_user(Userid);
		audit.setModi_details(Modification_details);
		audit.setRemarks(Modifi_remarks);

		mANUAL_Audit_Rep.save(audit);

		return Number1;
	}

}
