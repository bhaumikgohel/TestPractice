package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class DashabordPage extends TestBase{
	
	public DashabordPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='t-16 t-black t-bold']")
	WebElement username;
	
	public String Verify_Username() {
		return username.getText();
	}
	

}
