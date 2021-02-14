package testcases;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import base.BasePage;
import base.BaseTest;
import data.DataBuilder;
import pom.pages.DashboardPage;
import pom.pages.EmployeesPage;

/**
 * 
 * @author cloverdolphin
 *
 */
public class AddEmployeeTest  extends BaseTest {
	
	private static Logger log = LoggerFactory.getLogger(LoginTest.class);
	
	DashboardPage dashboardPage;
	EmployeesPage employeePage;
	String firstName;
	String email;
	
	private void prepareData() {
		firstName = DataBuilder.newEmloyeeName();
		email = DataBuilder.newEmail();
	}
	
	@Test(description = "Add new employee with first name and email")
	public void addEmployeeTest(){
		
		dashboardPage = new DashboardPage(driver);
		
		log.info("===== enter Employees Page");
		employeePage = dashboardPage.enterEmployees();
		super.getPageInfo();
		
		prepareData();
		log.info(String.format("==== add new employee: fName=%s, email=%s", firstName, email));
		employeePage.addEmployee(firstName, email);
	}
	
}
