package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * 
 * @author cloverdolphin
 *
 */
public class BaseDriver {
	
	public static WebDriver driver;
	private static String DRIVER_PATH = "src/test/resources/driver/";
	
	public WebDriver initDriver(String browserName) throws IOException {
		
		if (browserName.toLowerCase().contains("chrome")){
			System.setProperty("webdriver.chrome.driver", DRIVER_PATH + "chromedriver");
			driver = new ChromeDriver();
			
		}else if(browserName.toLowerCase().contains("firefox")) {
			System.setProperty("webdriver.firefox.driver", DRIVER_PATH + "geckodriver");
			driver = new FirefoxDriver();
			
		}else if(browserName.toLowerCase().contains("safari")) {
			System.setProperty("webdriver.safari.driver", DRIVER_PATH + "safari.exe"); // add safari webdriver later
			driver = new SafariDriver();
			
		}else {
			//TODO: add more common used webdriver later
		}
		
		return driver;
	}
	
	public void closeDriver() {
		if(driver != null) {
			driver.close();
			driver.quit();
		}

	}

}
