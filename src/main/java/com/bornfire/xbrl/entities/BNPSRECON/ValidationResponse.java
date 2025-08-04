package com.bornfire.xbrl.entities.BNPSRECON;

public class ValidationResponse {
	private String GenID;
	private String Status;

	public String getGenID() {
		return GenID;
	}

	public String getStatus() {
		return Status;
	}

	public void setGenID(String genID) {
		GenID = genID;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public ValidationResponse(String genID, String status) {
		super();
		GenID = genID;
		Status = status;
	}

	public ValidationResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}