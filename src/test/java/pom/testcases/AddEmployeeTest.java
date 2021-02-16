package pom.testcases;

import static org.testng.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import data.DataBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import pom.pages.DashboardPage;
import pom.pages.EmployeesPage;

/**
 * 
 * Add employee test
 * @author cloverli
 * @date 16/02/2021
 *
 */

@Epic("Add Employee")
public class AddEmployeeTest  extends BaseTest {
	
	private static Logger log = LoggerFactory.getLogger(LoginTest.class);
	
	DashboardPage dashboardPage;
	EmployeesPage employeePage;
	
	String firstName;
	String email;
	
	@Test(description = "Add new employee with required values")
	@Feature("Add new Employee with required values")
	@Description("Add new Employee with valid first name and email")
	public void addEmployeeTest(){
		
		dashboardPage = new DashboardPage(driver);
		
		log.info("===== enter Employees Page ====");
		employeePage = dashboardPage.enterEmployees();
		super.getPageInfo();
		int employeeCount = employeePage.getEmployeeCount();
		log.info(String.format("==== employees count before adding: %d ====", employeeCount));
		
		firstName = DataBuilder.newEmloyeeFirstName();
		email = DataBuilder.newEmail();
		log.info(String.format("==== add new employee: fName=%s, email=%s ====", firstName, email));
		employeePage.addEmployee(firstName, email);
		
		int newCount = employeePage.getEmployeeCount();
		log.info(String.format("==== employees count after adding: %d ====", newCount));
		assertEquals(newCount, employeeCount + 1);
		
	}
	
	@Test
	@Feature("Sign in employee")
	@Description("Sign in the newly added employee")
	public void signInNewAddedEmployee() {
		employeePage.searchAndSignIn(firstName);
	}
	
}
