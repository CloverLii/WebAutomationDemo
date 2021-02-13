package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// ============== items on the left side of the screen =======================
	private WebElement dashboard = super.locateElement(By.linkText("Dashboard"));
	private WebElement visitors = super.locateElement(By.linkText("Visitors"));
	private WebElement employees= super.locateElement(By.linkText("Employees"));
	private WebElement deliveries = super.locateElement(By.linkText("Deliveries"));
	
	
	public VisitorsPage enterVisitors() {
		super.clickElement(visitors);
		return new VisitorsPage(driver);
	}
	
	public EmployeesPage enterEmployees() {
		super.clickElement(employees);
		return new EmployeesPage(driver);
	}
	
	public boolean isDashboard() {
		if(dashboard.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}
	
}
