package base;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * Parent Class: Initialize browser driver
 * @author cloverli
 * @date 15/02/2021
 *
 */
public class BaseDriver {
	
	private static Logger log = LoggerFactory.getLogger(BaseDriver.class);
	
	public static WebDriver driver;
	private static final String DRIVER_PATH = "src/test/resources/driver/"; // DO NOT CHANGE
	
	// initialize browser driver according to name
	// TODO: get all webdrivers ready: safari, IE, opera, edge
	public WebDriver initDriver(String browserName) throws IOException {
		
		if (browserName.toLowerCase().contains("chrome")){
			System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver");
			driver = new ChromeDriver();			
		}else if(browserName.toLowerCase().contains("firefox")) {
			System.setProperty("webdriver.firefox.driver", DRIVER_PATH + "geckodriver");
			driver = new FirefoxDriver();			
		}else {
			log.error(String.format("==== [%s] does not exist, please use valid browser name ====", browserName));
			return null;
		}
		log.info(String.format("==== initialize [%s] browser driver ====", browserName));
		return driver;
	}
	
	// close driver
	public void closeDriver() {
		if(driver != null) {
			//driver.close(); // close the browser or page which is having the focus
			driver.quit(); // close all browser window and end the WebDriver session
		}

	}

}
