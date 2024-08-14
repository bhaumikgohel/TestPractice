package Testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	HomePage homepageobj;
	LoginPage loginpageobj;
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initilization();
		homepageobj = new HomePage();
		loginpageobj = homepageobj.Validate_Signin_link();
	}
	
	@Test(priority=1)
	public void Verify_HomepageTitle() {
		
		String title = loginpageobj.Verify_LoginPageTitle();
		
		Assert.assertEquals(title, "LinkedIn Login, Sign in | LinkedIn");
	}
	
	@Test(priority=2)
	public void Verify_Blank_Validation() {
		
		String msg = loginpageobj.Validate_BlankUser_validation();
		
		Assert.assertEquals(msg, "Please enter an email address or phone number.");
	}
	
	@Test(priority=3)
	public void Verify_Invalid_Validation() {
		
		String msg = loginpageobj.Validate_password_validation();
		
		Assert.assertEquals(msg, "Wrong email or password. Try again or create an account .");
	}

	@Test(priority=4)
	public void Verify_Valid_Credentials() {
		
		loginpageobj.Validate_with_ValidCredentials();
		
	}
	
	@Test(priority=5)
	public void Verify_forgotpasswordlink() {
		
		loginpageobj.Validate_forgot_Password_link();
		
	}
	
	
	
	@AfterMethod
	public void Terminate() {
		driver.quit();
	}
}
