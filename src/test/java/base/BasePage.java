package base;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertiesReader;

/**
 * 
 * Parent Class: Commonly used methods on browser page
 * @author cloverli
 * @date 15/02/2021
 *
 */
public class BasePage {
	
	public WebDriver driver;	
	private Actions action;	
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	// constructor
	public BasePage(WebDriver driver) {
	        this.driver = driver;
	        this.action = new Actions(driver);
	        long timeout = Long.parseLong(PropertiesReader.getKey("driver.timeouts.webDriverWait"));
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	}
	
	// select random value for Select element
	public void selectRandomValue(Select select) {
		Random random = new Random();
		int size = select.getOptions().size();
		int index = random.nextInt(size);
		select.selectByIndex(index);
		System.out.println(String.format("**** select element size=%d, selectedIndex=%d: ", size, index));
	}
	
	// locate single element by locator
    public WebElement locateElement(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    // locate multiple elements by locator
    public List<WebElement> locateElements(By locator){
    	return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }
    
    // click element by locator
    public WebElement clickElement(By locator) {
        WebElement clickableEle = locateElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        clickableEle.click();
        return clickableEle;
    }
    
    // click element
    public WebElement clickElement(WebElement ele) {
    	 wait.until(ExpectedConditions.elementToBeClickable(ele));
         ele.click();
         return ele;
    }
    
    // send content by locator 
    // TODO: CharSequence...
    public WebElement sendInput(By locator, String content) {
        WebElement inputElement = locateElement(locator);
        inputElement.clear();
        inputElement.sendKeys(content);
        return inputElement;
    }
    
    // send content
    public WebElement sendInput(WebElement ele, CharSequence... content) {
        ele.clear();
        ele.sendKeys(content);
        return ele;
    }
    
    // move to element
    public void moveToElement(By locator) {
        action.moveToElement(locateElement(locator)).perform();
    }
    
    public void moveToElement(WebElement ele) {
        action.moveToElement(ele).perform();
    }
    
    public void clickElementByAction(WebElement ele) {
        action.click(ele).perform();
    }
    
    // drag element
    public void dragAndDropElement(By fromLocator, By toLocator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(fromLocator));
        action.dragAndDrop(locateElement(fromLocator), locateElement(toLocator)).perform();
    }
    
    // double click
    public void doubleClickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        action.doubleClick(locateElement(locator)).perform();
    }
    
    // hold element
    public void holdElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        action.clickAndHold(locateElement(locator)).perform();
    }
    
    // enter page by url
    public void enterPage(String url) {
    	driver.get(url);
    }
    
    // switch to next window handle
    // TODO: switch window handle according to title, index
    public WebDriver switch2NextHandle() {
    	// current window handle
        String currentHandle = driver.getWindowHandle(); 
        // get all window handles
        Set<String> allHandles = driver.getWindowHandles();
        for (String handle : allHandles) {
            if (!handle.equals(currentHandle)) {
                return driver.switchTo().window(handle);
            }
        }
        return driver;
    }
    
    // scroll to top of the window
    public void scroll2Top() {
    	js.executeScript("window.scrollTo(0, 0)");
    }
    
    // scroll to bottom of the window
    //TODO: add more options
    public void scroll2Bottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
