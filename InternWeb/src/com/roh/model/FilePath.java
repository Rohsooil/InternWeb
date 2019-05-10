package com.roh.model;

public class FilePath implements DBModel {
	public static final String filePath = "C:\\Users\\kev\\Documents\\files\\";

	private String regisNumCardPath;
	private String baseDocPath;
	private String managerCertifyPath;
	private String persAgreementPath;
	private String usageAgreementPath;

	public FilePath() {

	}

	public FilePath(String regisNumCardPath, String baseDocPath, String managerCertifyPath, String persAgreementPath, String usageAgreementPath) {
		this.regisNumCardPath = regisNumCardPath;
		this.baseDocPath = baseDocPath;
		this.managerCertifyPath = managerCertifyPath;
		this.persAgreementPath = persAgreementPath;
		this.usageAgreementPath = usageAgreementPath;
	}

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

	@Override
	public void setMember(int index, String data) {
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

	@Override
	public String getMember(int index) {
		String member = null;

		switch (index) {
		case 1:
			member = getRegisNumCardPath();
			break;
		case 2:
			member = getBaseDocPath();
			break;
		case 3:
			member = getManagerCertifyPath();
			break;
		case 4:
			member = getPersAgreementPath();
			break;
		case 5:
			member = getUsageAgreementPath();
			break;
		default:
			break;
		}

		return member;
	}

}
