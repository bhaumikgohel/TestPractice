package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import utils.util;

public class LoginPage extends TestBase{
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[normalize-space()='Sign in']")
	WebElement Signinbtn;

	@FindBy(xpath="//div[@id='error-for-username']")
	WebElement emailvalidation;
	
	@FindBy(xpath="//div[@id='error-for-password']")
	WebElement passswordvalidation;
	
	@FindBy(xpath="//a[normalize-space()='Forgot password?']")
	WebElement forgotpasswordlink;
	
	
	public String Verify_LoginPageTitle() {
		return driver.getTitle();
	}
	
	public String Validate_BlankUser_validation() {
		
		util.WaitforElement(Signinbtn);
		
		//Please enter an email address or phone number.
		
		Signinbtn.click();
		
		return emailvalidation.getText();
		
	}
	
	public String Validate_password_validation() {
		
		//Wrong email or password. Try again or create an account .
		
		util.WaitforElement(Signinbtn);
		
		username.sendKeys(System.getProperty("username"));
		
		password.sendKeys("BhaumiK@412");
		
		Signinbtn.click();
		
		return passswordvalidation.getText();
		
	}
	
	
	public DashabordPage Validate_with_ValidCredentials() {
		
		util.WaitforElement(Signinbtn);
		
		username.sendKeys(System.getProperty("username"));
		
		password.sendKeys(System.getProperty("password"));
		
		Signinbtn.click();
		
		return new DashabordPage();
		
	}
	
	
	public ForgotPassword Validate_forgot_Password_link() {
		
		util.WaitforElement(Signinbtn);
		
		forgotpasswordlink.click();
		
		return new ForgotPassword();
		
	}
	
	
	
}
