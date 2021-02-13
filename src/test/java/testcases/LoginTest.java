package testcases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import base.BaseTest;
import pom.pages.LoginPage;
import util.PropertiesReader;

public class LoginTest extends BaseTest{
	
	private static Logger log = LoggerFactory.getLogger(LoginTest.class);
	
	LoginPage loginPage;
	
	@Test(description = " Login with valid account", priority = 1)
	public void testLogin() {
		
		loginPage = new LoginPage(driver);
		super.getPageInfo();
		
		String email = PropertiesReader.getKey("login.email");
		String pwd = PropertiesReader.getKey("login.password");
		log.info(String.format("==== login with valid account: email= %s, password= %s ====", email, pwd));
				
		loginPage.login(email, pwd);
		super.getPageInfo();
	}
	
	public void testLoginwithoutEmail() {
		
	}
	
	public void testLoginWithoutPwd() {
		
	}
	
	public void testLoginWithInvalidEmail() {
		
	}
	
	public void testLoginWithInvalidPwd() {
		
	}
}
