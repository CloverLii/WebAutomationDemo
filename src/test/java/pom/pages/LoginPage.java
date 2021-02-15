package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.BasePage;
import data.PageURL;

/**
 * Login Page
 * @author cloverli
 * @date 15/02/2021
 *
 */
public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	/* ================== login into dashboard ===================== */
	private WebElement emailInput = super.locateElement(By.cssSelector(".email .el-input__inner"));	
	private WebElement passwordInput = super.locateElement(By.cssSelector(".password .el-input__inner"));	
	private WebElement loginBtn = super.locateElement(By.cssSelector(".login-btn"));
	
	/* ================== create account and reset password ================== */
	private WebElement creatAccountBtn = super.locateElement(By.cssSelector(".create-account-btn > .el-button"));
	private WebElement resetPasswordLink = super.locateElement(By.linkText("Reset your password"));
	
	// login with email and password
	public void login(String email, String pwd) {
		super.sendInput(emailInput, email);
		super.sendInput(passwordInput, pwd);
		super.clickElement(loginBtn);
	}
	
	public RegisterPage enterRegisterPage() {
		super.clickElement(creatAccountBtn);
		return new RegisterPage(driver);
	}
	
	public ForgetPasswordPage enterForgetPasswordPage() {
		super.clickElement(resetPasswordLink);
		return new ForgetPasswordPage(driver);
	}
	
	public boolean isLoginPage(){
		if(driver.getCurrentUrl().equals(PageURL.LOGIN_PAGE)) {
			return true;
		}else {
			return false;
		}
	}	
	
}
