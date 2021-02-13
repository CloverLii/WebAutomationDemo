package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;
import data.DataBuilder;

public class VisitorsPage extends BasePage{

	public VisitorsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private WebElement tab_visitors = super.locateElement(By.linkText("Visitors"));
	private WebElement tab_timeline = super.locateElement(By.linkText("Timeline"));
	private WebElement tab_archive = super.locateElement(By.linkText("Archive"));
	
	private WebElement addVisitorBtn = super.locateElement(By.id("btn-add-visitor"));
	
	private WebElement newVisitorName = super.locateElement(By.id("Visitor_full_name"));
	
	private WebElement newVisitorCompany = super.locateElement(By.id("Visitor_company_name"));	
	// select
	private WebElement newVisitorLocation = super.locateElement(By.id("Visitor_location_id")); 
	// select
	private WebElement newVisitorHost = super.locateElement(By.id("Visitor_user_id"));
	
	private WebElement addBtn = super.locateElement(By.id("addNewVisitor"));
	
	//private WebElement cancelBtn = super.locateElement(By.linkText("Cancel"));
	// a label showing the count of visitors
	//private WebElement visitorsCount = super.locateElement(By.cssSelector(".selection-total-count"));
	
	
	
	public void cancelAddvisitor() {
		
	}
	
	public void addVisitor(String name, String company) {
		//super.clickElement(tab_timeline);
		super.clickElement(addVisitorBtn);
		
		super.sendInput(newVisitorName, name);
		super.sendInput(newVisitorCompany, company);		
		super.clickElement(addBtn);
	}
	
//	public int getVisitorsCount() {	
//		super.clickElement(tab_visitors);
//		int visitorsNum = Integer.parseInt(visitorsCount.getText());
//		return visitorsNum;
//	}
	
	public boolean isVisitorsPage() {
		
		return true;
	}
}
