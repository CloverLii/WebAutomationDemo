package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class DashBoardPage extends BasePage{

	public DashBoardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private WebElement bashboardHome = super.locateElement(By.linkText("Dashboard"));
	private WebElement visitors = super.locateElement(By.linkText("Visitors"));
	private WebElement employees= super.locateElement(By.linkText("Employees"));
	
	public VisitorsPage enterVisitors() {
		super.clickElement(visitors);
		return new VisitorsPage(driver);
	}
	
	public EmployeesPage enterEmployees() {
		super.clickElement(employees);
		return null;
	}
	
}
