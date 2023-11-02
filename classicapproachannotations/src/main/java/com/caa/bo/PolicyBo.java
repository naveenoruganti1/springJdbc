package com.caa.bo;

public class PolicyBo {
	private int policyNo;
	private String policyHolder;
	private String policyName;
	private String tenure;
	private String primiumAmount;
	private String insuredAmount;

	public int getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}
	public String getPolicyHolder() {
		return policyHolder;
	}
	public void setPolicyHolder(String policyHolder) {
		this.policyHolder = policyHolder;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getTenure() {
		return tenure;
	}
	public void setTenure(String tenure) {
		this.tenure = tenure;
	}
	public String getPrimiumAmount() {
		return primiumAmount;
	}
	public void setPrimiumAmount(String primiumAmount) {
		this.primiumAmount = primiumAmount;
	}
	public String getInsuredAmount() {
		return insuredAmount;
	}
	public void setInsuredAmount(String insuredAmount) {
		this.insuredAmount = insuredAmount;
	}
	@Override
	public String toString() {
		return "PolicyBo [policyNo=" + policyNo + ", policyHolder=" + policyHolder + ", policyName=" + policyName
				+ ", tenure=" + tenure + ", primiumAmount=" + primiumAmount + ", insuredAmount=" + insuredAmount + "]";
	}
}
