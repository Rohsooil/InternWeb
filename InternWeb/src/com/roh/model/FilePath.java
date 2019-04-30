package com.roh.model;

public class FilePath {
	public static final String filePath = "C:\\Users\\kev\\Documents\\files\\";
	
	private String regisNumCardPath;
	private String baseDocPath;
	private String managerCertifyPath;
	private String persAgreementPath;
	private String usageAgreementPath;

	public String getRegisNumCardPath() {
		return regisNumCardPath;
	}

	public void setRegisNumCardPath(String regisNumCardPath) {
		this.regisNumCardPath = filePath + regisNumCardPath;
	}

	public String getBaseDocPath() {
		return baseDocPath;
	}

	public void setBaseDocPath(String baseDocPath) {
		this.baseDocPath = filePath + baseDocPath;
	}

	public String getManagerCertifyPath() {
		return managerCertifyPath;
	}

	public void setManagerCertifyPath(String managerCertifyPath) {
		this.managerCertifyPath = filePath + managerCertifyPath;
	}

	public String getPersAgreementPath() {
		return persAgreementPath;
	}

	public void setPersAgreementPath(String persAgreementPath) {
		this.persAgreementPath = filePath + persAgreementPath;
	}

	public String getUsageAgreementPath() {
		return usageAgreementPath;
	}

	public void setUsageAgreementPath(String usageAgreementPath) {
		this.usageAgreementPath = filePath + usageAgreementPath;
	}

}
