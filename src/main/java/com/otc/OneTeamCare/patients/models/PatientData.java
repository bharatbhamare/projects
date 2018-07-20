package com.otc.OneTeamCare.patients.models;

public class PatientData {
	private String id;
	private String fname;
	private String mname;
	private String lastname;
	private String mobile;
	private String street;
	private String city;
	private String state;
	private String postalcode;
	
	
	public PatientData() {
		
	}
	public PatientData(String id, String fname, String mname, String lastname, String mobile, String street, String city,
			String state, String postalcode) {
		super();
		this.id=id;
		this.fname = fname;
		this.mname = mname;
		this.lastname = lastname;
		this.mobile = mobile;
		this.street = street;
		this.city = city;
		this.state = state;
		this.postalcode = postalcode;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	
	
	
	
}
