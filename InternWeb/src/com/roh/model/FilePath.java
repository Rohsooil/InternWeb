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
		this.regisNumCardPath = regisNumCardPath;
	}

	public String getBaseDocPath() {
		return baseDocPath;
	}

	public void setBaseDocPath(String baseDocPath) {
		this.baseDocPath = baseDocPath;
	}

	public String getManagerCertifyPath() {
		return managerCertifyPath;
	}

	public void setManagerCertifyPath(String managerCertifyPath) {
		this.managerCertifyPath = managerCertifyPath;
	}

	public String getPersAgreementPath() {
		return persAgreementPath;
	}

	public void setPersAgreementPath(String persAgreementPath) {
		this.persAgreementPath = persAgreementPath;
	}

	public String getUsageAgreementPath() {
		return usageAgreementPath;
	}

	public void setUsageAgreementPath(String usageAgreementPath) {
		this.usageAgreementPath = usageAgreementPath;
	}

	public void setInstance(int index, String data) {
		switch (index) {
		case 1:
			setRegisNumCardPath(data);
			break;
		case 2:
			setBaseDocPath(data);
			break;
		case 3:
			setManagerCertifyPath(data);
			break;
		case 4:
			setPersAgreementPath(data);
			break;
		case 5:
			setUsageAgreementPath(data);
			break;
		default:
			break;
		}
	}

}
