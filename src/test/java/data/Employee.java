package data;

import org.testng.annotations.Optional;

public class Employee {
	
	private String employeeFirstName;
	private String employeeLastName = "";
	private String employeeEmail;
	private String employeePhone;
	private String employeeLocation;
	private String employeeAssistantEmail;
	private String employeeAssistantSMS;
	
	// constructor with all values
	public Employee(String fName, String lName, String email, String phone, @Optional("Head Office") String location, String ccEmail,  String ccPhone) {
		this.employeeFirstName = fName;
		this.employeeLastName = lName;
		this.employeeEmail = email;
		this.employeePhone = phone;
		this.employeeLocation = location;
		this.employeeAssistantEmail = ccEmail;
		this.employeeAssistantSMS = ccPhone;
	}
	
	// constructor with required values
	public Employee(String fName, String email) {
		this.employeeFirstName = fName;
		this.employeeEmail = email;
	}
	
	// get all information of the employee
	public String getEmployeeInfo(Employee em) {
		String info = String.format("Employee info: firstName=%s, lastName=%s, email=%s, phone=%s, location=%s, ccEmail=%s, ccSMS=%s ",
				em.employeeFirstName, em.employeeLastName, em.employeeEmail, em.employeePhone, em.employeeLocation, em.employeeAssistantEmail, em.employeeAssistantSMS);
		return info;
	}
	
	// ================== getter =====================
	public String getEmployeeFirstName() {
		return this.employeeFirstName;
	}
	
	public String getEmployeeLasttName() {
		return this.employeeLastName;
	}
	
	public String getEmployeeEmail() {
		return this.employeeEmail;
	}
	
	public String getEmployeePhone() {
		return this.employeePhone;
	}
	
	public String getEmployeeLocation() {
		return this.employeeLocation;
	}
	
	public String getEmployeeCCEmail() {
		return this.employeeAssistantEmail;
	}
	
	public String getEmployeeCCSMS() {
		return this.employeeAssistantSMS;
	}
	
	// ===================== setter ========================
	public void setEmployeeFirstName(String fName) {
		this.employeeFirstName = fName;
	}
	
	public void setEmployeeLastName(String lName) {
		this.employeeLastName = lName;
	}
	
	public void setEmployeeEmail(String email) {
		this.employeeEmail = email;
	}
	
	public void setEmployeePhone(String phone) {
		this.employeePhone = phone;
	}
	
	public void setEmployeeLocation(String location) {
		this.employeeLocation = location;
	}
	
	public void setEmployeeCCEmail(String ccEmail) {
		this.employeeAssistantEmail = ccEmail;
	}
	
	public void setEmployeeCCSMS(String ccSMS) {
		this.employeeAssistantSMS = ccSMS;
	}
}
