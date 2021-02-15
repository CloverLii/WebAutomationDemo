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
	
	private WebElement emailInput = super.locateElement(By.cssSelector(".email .el-input__inner"));
	
	private WebElement passwordInput = super.locateElement(By.cssSelector(".password .el-input__inner"));
	
	private WebElement loginBtn = super.locateElement(By.cssSelector(".login-btn"));
	
	private WebElement resetPwdLink = super.locateElement(By.partialLinkText("Reset your password"));
	
	
	public void login(String email, String pwd) {
		super.sendInput(emailInput, email);
		super.sendInput(passwordInput, pwd);
		super.clickElement(loginBtn);
	}
	
	public boolean isLoginPage(){
		if(emailInput.isDisplayed()) {
			return true;
		}else {
			return false;
		}
	}	
	
}
