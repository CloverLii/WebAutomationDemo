package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']")) ;
	private WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
	private WebElement loginBtn = driver.findElement(By.xpath("//div/button[@type='button']"));
	private WebElement resetPwdLink = driver.findElement(By.partialLinkText("Reset your password"));
	
	public void login(String email, String pwd) {
		emailInput.sendKeys(email);
		passwordInput.sendKeys(pwd);
		loginBtn.click();
	}
	
	public boolean isLoginPage(){
		driver.getTitle();
		System.out.println("==== open Login Page successfully ====" + driver.getTitle());
		return true;
	}	
	
}
