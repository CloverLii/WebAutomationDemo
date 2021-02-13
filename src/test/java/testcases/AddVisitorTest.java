package testcases;

import static org.testng.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import base.BaseTest;
import data.DataBuilder;
import pom.pages.DashboardPage;
import pom.pages.VisitorsPage;

public class AddVisitorTest extends BaseTest{
	
	private static Logger log = LoggerFactory.getLogger(LoginTest.class);
	
	DashboardPage dashboardPage;
	VisitorsPage visitorsPage;
	
	@Test(description = "Add new visitor with valid values")
	public void addVisitor() {
		
		dashboardPage = new DashboardPage(driver);		
		if(!dashboardPage.isDashboard()) { return; }	
		
		log.info("==== enter Visitors Page ====");
		visitorsPage = dashboardPage.enterVisitors();		
		if(!visitorsPage.isVisitorsPage()) { return; }
		
		log.info("==== get number of visitors ====");
		//int originVisitorsCount = visitorsPage.getVisitorsCount();
		String name = DataBuilder.newVisitorName();
		String company = DataBuilder.newCompany();
		log.info(String.format("==== add new visitor: name=%s, company=%s", name, company));
		
		visitorsPage.addVisitor(name, company);
		//int currentVisitorsCount = visitorsPage.getVisitorsCount();
		//slog.info(String.format("==== number of visitors: %d, after adding: %d", originVisitorsCount, currentVisitorsCount));
		
		//assertEquals(currentVisitorsCount, originVisitorsCount+1);
		
	}
}
