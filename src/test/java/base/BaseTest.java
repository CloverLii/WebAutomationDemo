package base;

import java.io.IOException;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pom.pages.LoginPage;
import util.PropertiesReader;

/**
 * 
 * Parent Class: Commonly executed tests before/after different stage
 * @author cloverli
 * @date 15/02/2021
 */
public class BaseTest {
	
	private static Logger log = LoggerFactory.getLogger(BaseTest.class);
	
	private BaseDriver baseDriver;
	public WebDriver driver;
	
	// constructor
	public BaseTest() {
		baseDriver = new BaseDriver();
	}

	@BeforeSuite(alwaysRun = true)
	@Parameters({"propertiesPath", "log4jConPath", "accountConfigPath"})
	public void getProperties(@Optional("src/test/resources/config/config.properties") String propertiesPath,
							  @Optional("src/test/resources/log4j.properties") String log4jConPath,
							  @Optional("src/test/resources/config/account.properties")String accountConfigPath) throws IOException {
		
		log.info("====BeforeSuite: read properties files====");
		PropertiesReader.readProperties(propertiesPath);
		PropertiesReader.readProperties(accountConfigPath);
		//PropertiesReader.readProperties(log4jConPath);
		PropertyConfigurator.configure(log4jConPath);
	}
	

	@BeforeTest(alwaysRun = true)
	@Parameters({"browserName"})
	public void initBrowser(@Optional("chrome") String browserName) throws IOException {		
		
		log.info("==== BeforeTest: initialize browser ====");
		String host = PropertiesReader.getKey("driver.host");
		driver = baseDriver.initDriver(browserName);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get(host);	
	}
	
	@BeforeClass(alwaysRun = true)
	public void testLogin() {
		
		log.info("==== BeforeClass: login as admin ====");
		LoginPage loginPage = new LoginPage(driver);
		getPageInfo();
		
		String email = PropertiesReader.getKey("login.email");
		String pwd = PropertiesReader.getKey("login.password");
		log.info(String.format("==== login with valid account: email= %s, password= %s ====", email, pwd));
				
		loginPage.login(email, pwd);
		getPageInfo();
	}

	// print current url and page title
	public void getPageInfo() {
		log.info(String.format("==== current url: %s, page title: %s", driver.getCurrentUrl(), driver.getTitle()));
	}
	
	// tear down after class or after Class
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		
		log.info("==== AfterClass: quit driver ====");
		if(driver != null) {
			//driver.close(); // close the browser or page which is having the focus
			driver.quit(); // close all browser window and end the WebDriver session
		}
	}
}
