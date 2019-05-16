package com.roh.model.application;

public class FilePath implements ApplicationModel {

	private String regisNumCard;
	private String baseDoc;
	private String managerCertify;
	private String persAgreement;
	private String usageAgreement;

	public static final String filePath = "C:\\Users\\kev\\Documents\\files\\";

	public FilePath() {

	}

	public FilePath(String regisNumCard, String baseDoc, String managerCertify, String persAgreement, String usageAgreement) {
		this.regisNumCard = regisNumCard;
		this.baseDoc = baseDoc;
		this.managerCertify = managerCertify;
		this.persAgreement = persAgreement;
		this.usageAgreement = usageAgreement;
	}

	public String getRegisNumCard() {
		return regisNumCard;
	}

	public void setRegisNumCard(String regisNumCard) {
		this.regisNumCard = regisNumCard;
	}

	public String getBaseDoc() {
		return baseDoc;
	}

	public void setBaseDoc(String baseDoc) {
		this.baseDoc = baseDoc;
	}

	public String getManagerCertify() {
		return managerCertify;
	}

	public void setManagerCertify(String managerCertify) {
		this.managerCertify = managerCertify;
	}

	public String getPersAgreement() {
		return persAgreement;
	}

	public void setPersAgreement(String persAgreement) {
		this.persAgreement = persAgreement;
	}

	public String getUsageAgreement() {
		return usageAgreement;
	}

	public void setUsageAgreement(String usageAgreement) {
		this.usageAgreement = usageAgreement;
	}

}
