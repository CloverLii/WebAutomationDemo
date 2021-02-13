package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;


public class MainPage extends BasePage{
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	private WebElement login = driver.findElement(By.tagName("a"));
	
	@FindBy(linkText="Features")
	private WebElement product_features;
	private WebElement pricing_pricing;
	private WebElement customers_industries;
	private WebElement about_aboutUs;
	private WebElement resources_articles;
	
		
	public LoginPage enterLoginPage() throws InterruptedException {				
		login.click();
		return new LoginPage(driver);
	}
	
	
}
