package base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.PropertiesReader;

/**
 * 
 * @author cloverdolphin
 *
 */
public class BasePage {
	
	public static WebDriver driver;
	
	private Actions action;
	
	private WebDriverWait wait;
	
	public BasePage(WebDriver driver) {
	        this.driver = driver;
	        this.action = new Actions(driver);
	        long timeout = Long.parseLong(PropertiesReader.getKey("driver.timeouts.webDriverWait"));
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	}
	
    public WebElement locateElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public List<WebElement> locateElements(By locator){
    	return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    
    public WebElement clickElement(By locator) {
        WebElement clickableEle = locateElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        clickableEle.click();
        return clickableEle;
    }
    
    public WebElement clickElement(WebElement ele) {
    	 wait.until(ExpectedConditions.elementToBeClickable(ele));
         ele.click();
         return ele;
    }
    
    public WebElement sendInput(By locator, String content) {
        WebElement inputElement = locateElement(locator);
        inputElement.clear();
        inputElement.sendKeys(content);
        return inputElement;
    }
    
    public void sendInput(WebElement ele, CharSequence... content) {
        ele.clear();
        ele.sendKeys(content);
    }

}
