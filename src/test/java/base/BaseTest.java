package base;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import util.PropertiesReader;

/**
 * 
 * @author cloverdolphin
 *s
 */
public class BaseTest {
	
	private static Logger log = LoggerFactory.getLogger(BaseTest.class);
	
	BaseDriver baseDriver;
	WebDriver driver;
	WebDriverWait wait;
	
	
	public BaseTest() {
		baseDriver = new BaseDriver();
	}

	@BeforeTest
	@Parameters({"propertiesPath", "log4jConPath"})
	private void getProperties(@Optional("src/test/resources/config/config.properties") String propertiesPath,
							  @Optional("src/test/resources/log4j.properties") String log4jConPath) throws IOException {
		
		//log.info("====BeforeTest: read properties files====");
		PropertiesReader.readProperties(propertiesPath);
		//PropertiesReader.readProperties(log4jConPath);
		PropertyConfigurator.configure(log4jConPath);
	}
	
	@Test
	//@BeforeClass(alwaysRun = true)
	@Parameters({"browserName"})
	public void initBrowser(@Optional("chrome") String browserName) throws IOException {		
		
		String host = PropertiesReader.getKey("driver.host");

		driver = baseDriver.initDriver(browserName);
	
		int wait1 = Integer.parseInt(PropertiesReader.getKey("driver.timeouts.webDriverWait"));
		long implicitWait = Long.parseLong(PropertiesReader.getKey("driver.timeouts.implicitWait"));
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(wait1));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.get(host);				
	}
	
	
	@AfterTest(alwaysRun = true)
	public void closeDriver() {
		baseDriver.closeDriver();
	}
}
