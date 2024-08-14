package Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;
import utils.util;

public class HomePage extends TestBase{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[normalize-space()='Sign in']")
	WebElement Signin;
	
	@FindBy(xpath="//*[@id=\"container\"]/div/div[1]")
	WebElement loginwithsocialmediabtn;
	
	//div[@class='nsm7Bb-HzV7m-LgbsSe-MJoBVe']
	
	@FindBy(xpath="(//div//span[text()='Continue with Google'])[2]")
	WebElement googleicon;
	
	@FindBy(xpath="//input[@id='identifierId']")
	WebElement childusertxt;
	
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement nextbtn;
	
	@FindBy(xpath="//input[@name='Passwd']")
	WebElement childinputpwd;
	
	
	@FindBy(xpath="//button//span[contains(text(),'Next')]")
	WebElement pwdnext;
	
	public String Verify_HomePage_Title() {
		
		return driver.getTitle();
	}
	
	public LoginPage Validate_Signin_link() {
		
		Signin.click();
		
		return new LoginPage();
	}
	
public void Validate_Login_with_Social_Media() throws InterruptedException {
		
	
		try {
			googleicon.click();
		}catch(Exception e) {
			loginwithsocialmediabtn.click();
			e.printStackTrace();
		}
		
		
		googleicon.click();
		
		Set<String> cwindow = driver.getWindowHandles();
		
		Iterator it = cwindow.iterator();
		
		String childwindowid = (String) it.next();
		
		driver.switchTo().window(childwindowid);
		
		util.WaitforElement(childusertxt);
		
		childusertxt.sendKeys("bhaumik.gohel@gmail.com");
		
		nextbtn.click();
		
		childinputpwd.sendKeys("Admin@123");
		
		pwdnext.click();
		
		Thread.sleep(2000);
		
		driver.close();
	}
	

}
