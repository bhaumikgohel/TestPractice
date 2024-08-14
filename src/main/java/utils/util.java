package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import Base.TestBase;

public class util extends TestBase{

	public static void WaitforElement(WebElement e) {
		FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver);
		
		f.withTimeout(Duration.ofSeconds(20));
		f.pollingEvery(Duration.ofSeconds(2));
		f.withMessage("Element not found");
		f.ignoring(Exception.class);
		
		f.until(ExpectedConditions.visibilityOf(e));
		
	}
	
	public static void ScrolluptoElement(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", e);
	}
	
}
