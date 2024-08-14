package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import utils.util;

public class ForgotPassword extends TestBase{

	public ForgotPassword() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath="//div[@id='user-name-error']")
	WebElement validationmsg;
	
	@FindBy(xpath="//button[@id='reset-password-submit-button']")
	WebElement nextbtn;
	
	@FindBy(xpath="//a[normalize-space()='Forgot password?']")
	WebElement forgotpasswordlink;
	
	public String Validate_ForgotPasswordPage_Title() {
		return driver.getTitle();
	}
	
	@FindBy(xpath = "//input[@id='input__email_verification_pin']")
	WebElement emailcodeinput;
	
	@FindBy(xpath="//div[@id='email-pin-error']")
	WebElement balnkvaliation;
	
	@FindBy(xpath="//button[@id='pin-submit-button']")
	WebElement submitbtn;
	
	@FindBy(xpath="//span[contains(text(),'We’ve sent you another code.')]")
	WebElement resendmsg;
	
	@FindBy(xpath="//button[@id='btn-resend-pin']")
	WebElement resendcode;
	
public String Validate_blankvalidation() {
		
		//Please enter your email or phone
		util.WaitforElement(username);
		
		nextbtn.click();
		
		String msg = validationmsg.getText();
		
		return msg;
		
	}
	
	
	public String Validate_invalidemailid() {
		

		
		util.WaitforElement(username);
		
		
		username.sendKeys("bhaumik@");
		
		nextbtn.click();
		

		String msg = validationmsg.getText();
		
		return msg;
		
	}
	
	public void Validate_validemailid() {
		
		forgotpasswordlink.click();
		
		util.WaitforElement(username);
		
		
		username.sendKeys("bhaumik.gohel@gmail.com");
		
		nextbtn.click();
		

		String msg = validationmsg.getText();
		
		
		
	}
	
	// Code Validation check
	
	public String Validate_blankcodevalidation() {
		
		username.sendKeys("bhaumik.gohel@gmail.com");
		
		nextbtn.click();
		
	util.WaitforElement(submitbtn);
	
	//That’s not the right code
	
	submitbtn.click();
	
	
	String msg = balnkvaliation.getText();
	
	return msg;
		
	}

	public String Validate_ResendCode() {
		
		username.sendKeys("bhaumik.gohel@gmail.com");
		
		nextbtn.click();
	
	util.WaitforElement(submitbtn);
	
	resendcode.click();
	
	String msg = resendmsg.getText();
	
	return msg;
		
	}
}
