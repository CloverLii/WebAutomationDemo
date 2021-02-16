package pom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import data.PageURL;

/**
 * 
 * Employees Page
 * @author cloverli
 * @date 16/02/2021
 *
 */
public class EmployeesPage extends BasePage {
	
	private WebElement tab_employees = super.locateElement(By.xpath("//a[@href='/employees']/h4"));
	private WebElement tab_timeline = super.locateElement(By.xpath("//a[@href='/employees/timeline']/h4"));
	private WebElement tab_archive = super.locateElement(By.xpath("//a[@href='/employees/archive']/h4"));
	
	/* =========================add items and sub-itemes ============================ */
	private WebElement addEmployeeMenu = super.locateElement(By.cssSelector(".ghost-btn > .dropdown-toggle > strong"));	
	private WebElement addEmployee = super.locateElement(By.cssSelector("li > .popup-form-add-employee"));
	//private WebElement addInBulk = super.locateElement(By.linkText("Add in Bulk"));;
	//private WebElement addViaIntegration = super.locateElement(By.linkText("Add via Integration"));
	
	/* ========================== add new employee =================================== */
	private WebElement newEmployeeFirstName = super.locateElement(By.id("User_first_name"));	
	private WebElement newEmployeeLastName = super.locateElement(By.id("User_last_name"));		
	private WebElement newEmployeeEmail = super.locateElement(By.id("User_email")); 		
	private WebElement newEmployeePhone = super.locateElement(By.id("User_phone"));
	//private WebElement newWmployeePhoneFlag = (WebElement) super.locateElements(By.cssSelector(".form-group:nth-child(5) .iti__selected-flag")); // select
	//private Select newEmployeeLocation = (Select) super.locateElement(By.id("User_location_id")); // select	
	
	private WebElement newEmployeeCCEmail = super.locateElement(By.id("User_email_cc"));
	private WebElement newEmployeeCCSMS = super.locateElement(By.id("User_phone_cc"));
	//private WebElement newEmployeeCCSMSFlag = (WebElement) super.locateElements(By.cssSelector(".form-group:nth-child(8) .iti__selected-flag")); // select
	
	private WebElement addBtn = super.locateElement(By.id("addNewEmployee"));
	//private WebElement cancalBtn = super.locateElement(By.linkText("Cancal"));
	
	private WebElement searchEmployee = super.locateElement(By.id("search"));
	private WebElement signInBtn = super.locateElement(By.linkText("Sign In"));
	private WebElement signInConfirm = super.locateElement(By.id("changeStatusSubmit"));
	private WebElement employeeCount =  super.locateElement(By.cssSelector(".selection-total-count"));

	public EmployeesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/* ============================ employees ============================== */
	
	//add new employee with required values
	public void addEmployee(String fName, String email) {
	
		super.clickElement(addEmployeeMenu);
		super.clickElement(addEmployee);
		
		super.sendInput(newEmployeeFirstName, fName);
		super.sendInput(newEmployeeEmail, email);
		super.clickElement(addBtn);
	}
	
	public void addEmployee2(String fName, String lName, String email, String phone, String ccEmail, String ccSMS) {
		super.clickElement(addEmployeeMenu);
		super.clickElement(addEmployee);
		
		super.sendInput(newEmployeeFirstName, fName);
		super.sendInput(newEmployeeLastName, lName);
		super.sendInput(newEmployeeEmail, email);
		super.sendInput(newEmployeePhone, phone);
		//super.selectRandomValue(newEmployeeLocation);
		super.sendInput(newEmployeeCCEmail, ccEmail);
		super.sendInput(newEmployeeCCSMS, ccSMS);
		
		super.clickElement(addBtn);
	}
	
	// sign in by name
	public void signInByName(String employeeName) {
		String cssLocator = String.format(".even.user-change-status[data-cred=%s]", employeeName);
		WebElement signInBtn = super.locateElement(By.cssSelector(cssLocator));
		super.clickElement(signInBtn);
		super.clickElement(signInConfirm);
	}
	
	public void cancalAddEmployee() {}
	
	public boolean isEmployeesPage() {
		return driver.getCurrentUrl().equals(PageURL.EMPLOYEES_PAGE);
	}	

	public int getEmployeeCount() {
		String countStr = employeeCount.getText();
		int employeeCount = 0;
		if(countStr != "") {
			employeeCount = Integer.parseInt(countStr);
		}
		return employeeCount;
	}
	
	// search employee by name then sign in
	public void searchAndSignIn(String name) {
		super.sendInput(searchEmployee, name);
		WebElement signInBtn = super.locateElement(By.linkText("Sign In"));
		super.clickElement(signInBtn);
		super.clickElement(signInConfirm);
	}
	
	public void filterEmployees(int statusIndex) {}
	
	public void signOutAll() {}
	
	public void archiveAll(){}
	
	/* ============================== timeline =========================== */
	public void searchTimeline(String keyword) {}
	
	public void filterTimeline(int statusIndex, int durationIndex) {}
	
	public void signOutFiltered() {}
	
	/* =========================== archive =================================*/
	public void searchArchive(String keyword) {}
	
	public void filterArchieve(int durationIndex) {}
	
	
	/* ========================== deselet/select and re-order ============================= */
	public void selectAll() {}
	
	public void deSelectAll(){}
	
	public void reorderByName() {}
	
	public void reorderByLastActivity() {}
	
	public void reorderByLocation()	{}
	
	public void reorderByTime()	{}
	
	public void reorderByArchiveDate()	{}
	
}
