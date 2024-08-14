package Testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.ForgotPassword;
import Pages.HomePage;
import Pages.LoginPage;

public class ForgotPasswordTest extends TestBase{
	
	HomePage homepageobj;
	LoginPage loginpageobj;
	ForgotPassword forgorpasswordobj;
	
	public ForgotPasswordTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initilization();
		homepageobj = new HomePage();
		loginpageobj = homepageobj.Validate_Signin_link();
		forgorpasswordobj = loginpageobj.Validate_forgot_Password_link();
	}
	
	@Test(priority=1)
	public void Verify_HomepageTitle_Test() {
		
		String title = forgorpasswordobj.Validate_ForgotPasswordPage_Title();
		
		Assert.assertEquals(title, "Reset Password | LinkedIn");
	}
	
	@Test(priority=2)
	public void Verify_Blank_Validation_Test() {
		
		String title = forgorpasswordobj.Validate_blankvalidation();
		
		Assert.assertEquals(title, "Please enter your email or phone");
	}
	
	@Test(priority=3)
	public void Verify_Invalid_Emailid_Test() {
		
		String title = forgorpasswordobj.Validate_invalidemailid();
		
		Assert.assertEquals(title, "Please enter your email or phone");
	}
	
	@Test(priority=4)
	public void Verify_Valid_Emailid_Test() {
		
		forgorpasswordobj.Validate_validemailid();
		
	}
	
	@Test(priority=5)
	public void Verify_code_Test() {
		
		forgorpasswordobj.Validate_blankcodevalidation();
		
	}
	
	@Test(priority=6)
	public void Verify_ResendCode_Test() {
		
		forgorpasswordobj.Validate_ResendCode();
		
	}
	
	@AfterMethod
	public void Terminate() {
		driver.quit();
	}

}
