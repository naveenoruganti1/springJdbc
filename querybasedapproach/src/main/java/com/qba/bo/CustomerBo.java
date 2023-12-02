package com.qba.bo;

public class CustomerBo {
	private int customerNo;
	private String customerName;
	private String dob;
	private String gender;

	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "CustomerBo [customerNo=" + customerNo + ", customerName=" + customerName + ", dob=" + dob + ", gender="
				+ gender + "]";
	}
}
