package Testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.HomePage;

public class LoginwithSocialMedia extends TestBase{

	HomePage homepageobj;
	
	public LoginwithSocialMedia() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initilization();
		homepageobj = new HomePage();
	}
	
	@Test(priority=1)
	public void Validate_Login_Using_socialMedia() throws InterruptedException {
		
		homepageobj.Validate_Login_with_Social_Media();
		
	}
	
	@AfterMethod
	public void Terminate() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
