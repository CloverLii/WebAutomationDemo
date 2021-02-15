package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
import data.PageURL;

/**
 * 
 * Dashboard Page
 * @author cloverli
 * @date 16/02/2021
 *
 */
public class DashboardPage extends BasePage{

	public DashboardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	/* ============== entries to different pages (left side items) ======================= */
	private WebElement dashboard = super.locateElement(By.linkText("Dashboard"));
	private WebElement visitors = super.locateElement(By.linkText("Visitors"));
	private WebElement employees= super.locateElement(By.linkText("Employees"));
	//private WebElement deliveries = super.locateElement(By.linkText("Deliveries"));
	//private WebElement evacuation = super.locateElement(By.linkText("Evacuation"));
	
	/* ============== number of visitors-in, pre-registered and deliveries ============= */
	private WebElement visitorsInLink = super.locateElement(By.cssSelector("a[href='/visitors#signedIn'] > h2 > strong"));
	//private WebElement preregisteredLink = super.locateElement(By.cssSelector("a[href='/preRegistration'] > h2 > strong"));
	//private WebElement deliveriesLink = super.locateElement(By.cssSelector("a[href='/deliveries'] > strong"));
	
	
	/* =========== navigate to different pages ================== */
	// enter visitors-timeline page
	public VisitorsPage enterTimeline() {
		super.clickElement(visitors);
		return new VisitorsPage(driver);
	}
	
	// enter visitors-visitors page
	public VisitorsPage enterVisitors() {
		super.clickElement(visitorsInLink);
		return new VisitorsPage(driver);
	}
	
	public EmployeesPage enterEmployees() {
		super.clickElement(employees);
		return new EmployeesPage(driver);
	}
	
	public DashboardPage enterDashboardHome() {
		super.clickElement(dashboard);
		return new DashboardPage(driver);
	}
	
	public void enterDeliveries() {}	
	
	public void enterPreRegistration() {}	
	
	public void enterEvacuation() {}	
	
	public void enterDevices() {}	
	
	public void enterAdminRoles() {}	
	
	public void enterIntegration() {}	
	
	public void enterAccount() {}

	
	public boolean isDashboard() {
		if(driver.getCurrentUrl().equals(PageURL.DASHBOARD_PAGE)) {
			return true;
		}else {
			return false;
		}
	}
	
}
