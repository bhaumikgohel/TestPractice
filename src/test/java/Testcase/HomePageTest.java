package Testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTest extends TestBase{

	HomePage homepageobj;
	LoginPage loginpageobj;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initilization();
		homepageobj = new HomePage();
	}
	
	@Test(priority=1)
	public void Verify_HomepageTitle() {
		
		String title = homepageobj.Verify_HomePage_Title();
		
		Assert.assertEquals(title, "LinkedIn: Log In or Sign Up");
	}
	
	@Test(priority=2)
	public void Verify_SigninLink() {
		
		homepageobj.Validate_Signin_link();
		
	}
	
	@AfterMethod
	public void Terminate() {
		driver.quit();
	}
}
