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
import pom.pages.VisitorsPage;

/**
 * 
 * Add visitor test
 * @author cloverli
 * @date 16/02/2021
 *
 */

@Epic("Add new visitor")
public class AddVisitorTest extends BaseTest{
	
	private static Logger log = LoggerFactory.getLogger(LoginTest.class);
	
	DashboardPage dashboardPage;
	VisitorsPage visitorsPage;
	
	@Test(description = "Add new visitor with required values", priority = 1, groups = {"positive"})
	@Feature("Add new visitor with required values")
	@Description("Add new visitor with valid name and company")
	public void addVisitor() {
		
		dashboardPage = new DashboardPage(driver);		
		if(!dashboardPage.isDashboard()) { return; }	
		
		log.info("==== enter Visitors Page ====");			
		visitorsPage = dashboardPage.enterVisitors();
		
		int originalCount = visitorsPage.getVisitorsCount();
		log.info(String.format("==== number of visitors before adding: %d ====", originalCount));
		
		String name = DataBuilder.newVisitorName();
		String company = DataBuilder.newCompany();	
		visitorsPage.addVisitor(name, company);
		log.info(String.format("==== add new visitor: name=%s, company=%s", name, company));	
		
		//int currentCount = visitorsPage.getVisitorsCount();
		//log.info(String.format("==== number of visitors after adding: %d ====", currentCount));
		
		//assertEquals(currentCount, originalCount+1);		
	}
	
	@Test(description = "Add new visitor with all values", priority = 2, groups = {"positive, regression"})
	@Feature("Add new visitor with all values")
	@Description("Add new visitor with name, company, location and host")
	public void addVisitor2() {
		
		log.info("==== add new visitor with all values ====");			
		String name = DataBuilder.newVisitorName();
		String company = DataBuilder.newCompany();
		log.info(String.format("==== add new visitor: name=%s, company=%s", name, company));
		
		visitorsPage.addVisitor2(name, company);
	}
}
