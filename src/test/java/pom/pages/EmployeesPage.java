package pom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class EmployeesPage extends BasePage {
	
	private WebElement tab_employees = super.locateElement(By.xpath("//a[@href='/employees']/h4"));
	private WebElement tab_timeline = super.locateElement(By.xpath("//a[@href='/employees/timeline']/h4"));
	private WebElement tab_archive = super.locateElement(By.xpath("//a[@href='/employees/archive']/h4"));
	
	private WebElement addEmployeeMenu = super.locateElement(By.cssSelector(".ghost-btn > .dropdown-toggle > strong"));	
	private WebElement addEmployee = super.locateElement(By.cssSelector("li > .popup-form-add-employee"));
	//private WebElement addInBulk = super.locateElement(By.cssSelector("li > .popup-form-add-employee"));;
	//private WebElement addViaIntegration = super.locateElement(By.cssSelector("li > .popup-form-add-employee"));
	
	// ========================== elements for new employee ===================================
	private WebElement newEmployeeFirstName = super.locateElement(By.id("User_first_name"));	
	private WebElement newEmployeeLastName = super.locateElement(By.id("User_last_name"));	
	
	private WebElement newEmployeeEmail = super.locateElement(By.id("User_email")); 	
	
	private WebElement newEmployeePhone = super.locateElement(By.id("User_phone"));
	//private List<WebElement> elementsList = super.locateElements(By.cssSelector("div>.iti_selected-flag")); // select
	//private WebElement newEmployeePhoneCountry = elementsList.get(0);
	
	private WebElement newEmployeeLocation = super.locateElement(By.id("User_location_id")); // select
	
	private WebElement newEmployeeCCEmail = super.locateElement(By.id("User_email_cc"));
	private WebElement newEmployeeCCSMS = super.locateElement(By.id("User_phone_cc"));
	//private WebElement newEmployeeCCSMSCountry = newEmployeePhoneCountry = elementsList.get(1); // select
	
	private WebElement addBtn = super.locateElement(By.id("addNewEmployee"));
	//private WebElement cancalBtn = super.locateElement(By.linkText("Cancal"));
	
	// locate [Sign In] button according employee Name
	private WebElement getSignInBtnByName(String employeeName) {
		String cssLocator = String.format(".even.user-change-status[data-cred=%s]", employeeName);
		WebElement signInBtn = super.locateElement(By.cssSelector(cssLocator));
		return signInBtn;
	}

	public EmployeesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void addEmployee(String fName, String email) {
	
		super.clickElement(addEmployeeMenu);
		super.clickElement(addEmployee);
		super.sendInput(newEmployeeFirstName, fName);
		//super.sendInput(newEmployeeLastName, lName);
		super.sendInput(newEmployeeEmail, email);
		super.clickElement(addBtn);
	}
	
	public void cancalAddEmployee() {
		
	}
	
	public boolean isEmployeesPage() {
		return true;
	}
	
	public void signIn(String employeeName) {
		WebElement signinBtn = getSignInBtnByName(employeeName);
		super.clickElement(signinBtn);
	}

	public int getEmployeeCount() {
		return 0;
	}
}
