package com.ca.bo;

public class VechicleBo {
	private int vechicleNo;
	private String modelName;
	private String manufacturer;
	private String registrationNo;
	private String color;
	private String fuelType;
	private float amount;

	public int getVechicleNo() {
		return vechicleNo;
	}
	public void setVechicleNo(int vechicleNo) {
		this.vechicleNo = vechicleNo;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "VechicleBo [vechicleNo=" + vechicleNo + ", modelName=" + modelName + ", manufacturer=" + manufacturer
				+ ", registrationNo=" + registrationNo + ", color=" + color + ", fuelType=" + fuelType + ", amount="
				+ amount + "]";
	}
}
