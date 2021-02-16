package pom.pages;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import data.PageURL;

/**
 * 
 * Vistors Page
 * @author cloverli
 * @date 16/02/2021
 *
 */
public class VisitorsPage extends BasePage{

	public VisitorsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private WebElement tab_visitors = super.locateElement(By.cssSelector(".selected_section > a"));
	private WebElement tab_timeline = super.locateElement(By.cssSelector("a[href='/visitors/timeline']"));
	private WebElement tab_archive = super.locateElement(By.cssSelector("a[href='/visitors/archive']"));
	private WebElement searchInput = super.locateElement(By.id("search"));
	//private WebElement signoutBtn = super.locateElement(By.id("btn-sing-out"));
	
	/* ====================== add visitor ==========================*/
	private WebElement addVisitorBtn = super.locateElement(By.id("btn-add-visitor"));	
	private WebElement newVisitorName = super.locateElement(By.id("Visitor_full_name"));	
	private WebElement newVisitorCompany = super.locateElement(By.id("Visitor_company_name"));	// select
	private Select newVisitorLocation = new Select(super.locateElement(By.id("Visitor_location_id"))); // select
	private Select newVisitorHost = new Select(super.locateElement(By.id("Visitor_user_id")));	
	private WebElement addBtn = super.locateElement(By.id("addNewVisitor"));
	
	//private WebElement cancelBtn = super.locateElement(By.linkText("Cancel"));
	//private WebElement visitorsCount = super.locateElement(By.cssSelector(".selection-total-count"));
	private WebElement visitorCount = super.locateElement(By.cssSelector("strong:nth-child(3)"));
	
	// add visitor with required values
	public void addVisitor(String name, String company) {
		super.clickElement(addVisitorBtn);		
		super.sendInput(newVisitorName, name);
		super.sendInput(newVisitorCompany, company);		
		super.clickElement(addBtn);
	}
	
	// addd visitor with all values
	public void addVisitor2(String name, String company) {
		super.clickElement(addVisitorBtn);		
		super.sendInput(newVisitorName, name);
		super.sendInput(newVisitorCompany, company);
		super.selectRandomValue(newVisitorLocation);
		super.selectRandomValue(newVisitorHost);
		super.clickElement(addBtn);
	}

	/* ======================== visitors =========================*/
		
	public int getVisitorsCount() {
		String countStr = visitorCount.getText();
		int visitorsCount = 0;
		
		if(countStr != null) {
			visitorsCount = Integer.parseInt(countStr);
		}
		return visitorsCount;
	}
	
	public void searchVisitor(String name) {
		super.sendInput(searchInput, name);
	}
	
	public void filterVisitors(int statusIndex) {}	
	
	public void signOutFiltered() {}
	
	public void cancelAddvisitor() {}
		
	/* ===================== timeline ================================*/	

	public void searchTimeline(String keywords)	{}	
	
	public void filterTimeline(int statusIndex, int durationIndex) {}
	
	public void signOutAll() {}	
	
	public void anonymizeAll() {}
		
	/* ===================== archive ===========================*/	

	public void filterArchive(int statusIndex) {}	
		
	public void searchArchive(String keywords) {}
	
}
